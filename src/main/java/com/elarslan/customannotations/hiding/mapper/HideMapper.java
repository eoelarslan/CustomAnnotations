package com.elarslan.customannotations.hiding.mapper;

import com.elarslan.customannotations.client.detail.EmployeeDetailService;
import com.elarslan.customannotations.designpattern.strategy.HidingStrategy;
import com.elarslan.customannotations.dto.Perseverance;
import com.elarslan.customannotations.enums.HidingData;
import com.elarslan.customannotations.enums.HidingLevel;
import com.elarslan.customannotations.exception.InvalidDataException;
import com.elarslan.customannotations.hiding.annotations.HideFromBelow;
import com.elarslan.customannotations.hiding.annotations.HideLevel;
import com.github.dozermapper.core.DozerBeanMapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;

@Slf4j
@Component
public class HideMapper {
    private static final Logger LOGGER = LoggerFactory.getLogger(HideMapper.class);

    private final DozerBeanMapper dozerBeanMapper;
    private final HidingStrategy hidingStrategy;
    private final EmployeeDetailService employeeDetailService;

    public HideMapper(DozerBeanMapper dozerBeanMapper, HidingStrategy hidingStrategy, EmployeeDetailService employeeDetailService) {
        this.dozerBeanMapper = dozerBeanMapper;
        this.hidingStrategy = hidingStrategy;
        this.employeeDetailService = employeeDetailService;
    }

    @Transactional
    public <T> T map(Object o, Class<T> tClass) throws IllegalAccessException, InvalidDataException {
        T response = dozerBeanMapper.map(o, tClass);
        hideFields(response);
        return response;
    }

    private void hideFields(Object response) throws IllegalAccessException, InvalidDataException {
        response = findCoreClassName(response);
        String className = findClassNameAsString(response);
        Field[] fields = response.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            maskFields(field, response);
        }
    }

    /**
     * @param response -
     * @return real class name
     */
    private Object findCoreClassName(Object response) {
        if (Perseverance.class.isAssignableFrom(response.getClass())) {
            Object responseBody = response.getClass();
            if (responseBody != null) {
                return findCoreClassName(responseBody);
            }
        }
        return response;
    }

    /**
     * @param response -
     * @return return class name as String
     */
    private String findClassNameAsString(Object response) {
        return response.getClass().getName();
    }

    private void maskFields(Field field, Object response) throws IllegalAccessException, InvalidDataException {
        String fieldContent = (String) field.get(response);
        if (fieldContent.isBlank()) {
            return;
        }
        HideLevel hidingClassificationAnnotation = field.getAnnotation(HideLevel.class);
        HideFromBelow hidingDataAnnotation = field.getAnnotation(HideFromBelow.class);
        //String hideLevel = hidingClassificationAnnotation.hide().name(); // for logging
        // same loggging for the second annotation
        field.set(response, maskFieldWithHidingLevel(hidingClassificationAnnotation.hide(), hidingDataAnnotation.hideData(), fieldContent));
    }

    private String maskFieldWithHidingLevel(HidingLevel hidingLevel, HidingData hidingData, String data) throws InvalidDataException {
        return hidingStrategy.executeCommand(hidingLevel, hidingData, data);
    }
}
