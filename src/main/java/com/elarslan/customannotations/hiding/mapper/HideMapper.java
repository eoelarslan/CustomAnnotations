package com.elarslan.customannotations.hiding.mapper;

import com.elarslan.customannotations.dto.Perseverance;
import com.elarslan.customannotations.enums.HidingLevel;
import com.elarslan.customannotations.hiding.annotations.HideLevelOne;
import com.github.dozermapper.core.DozerBeanMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;

@Component
public class HideMapper {
    private static final Logger LOGGER = LoggerFactory.getLogger(HideMapper.class);

    private final DozerBeanMapper dozerBeanMapper;

    public HideMapper(DozerBeanMapper dozerBeanMapper) {
        this.dozerBeanMapper = dozerBeanMapper;
    }

    @Transactional
    public <T> T map(Object o, Class<T> tClass, HidingLevel hidingLevel) {
        T response = dozerBeanMapper.map(o, tClass);
        hideFields(response);
    }

    private void hideFields(Object response) {
        response = findCoreClassName(response);
        String className = findClassNameAsString(response);

        Field[] fields = response.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            maskFields(field, response);
        }
    }

    /**
     *
     * @param response -
     * @return real class name
     */
    private Object findCoreClassName(Object response) {
        if(Perseverance.class.isAssignableFrom(response.getClass())){
            Object responseBody = response.getClass();
            if(responseBody != null) {
                return findCoreClassName(responseBody);
            }
        }
        return response;
    }

    /**
     *
     * @param response -
     * @return return class name as String
     */
    private String findClassNameAsString(Object response){
        return response.getClass().getName();
    }

    private void maskFields(Field field, Object response) throws IllegalAccessException {
        String fieldContent = (String) field.get(response);
        if(fieldContent.isBlank()) {
            return;
        }
        HideLevelOne hidingAnnotation = field.getAnnotation(HideLevelOne.class);
        //String hideLevel = hidingAnnotation.hide().name(); // for logging
        field.set(response,maskFieldWithHidingLevel(hidingAnnotation.hide(), fieldContent));
    }

    private String maskFieldWithHidingLevel(HidingLevel hidingLevel, String data) {
        // TODO: 27.02.2021 masking command will be executed (OnurE)
        return "";
    }

}
