import com.elarslan.customannotations.client.constant.EmployeeConstant;
import com.elarslan.customannotations.client.detail.EmployeeDetailService;
import com.elarslan.customannotations.client.dto.TechnicalEmployee;
import com.elarslan.customannotations.client.privilege.service.PrivilegeService;
import com.elarslan.customannotations.designpattern.strategy.HidingStrategy;
import com.elarslan.customannotations.designpattern.strategy.HidingStrategyService;
import com.elarslan.customannotations.enums.HidingData;
import com.elarslan.customannotations.enums.HidingLevel;
import com.elarslan.customannotations.exception.InvalidDataException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HidingStrategyTest {

    @InjectMocks
    private HidingStrategy hidingStrategy;

    @Mock
    private EmployeeDetailService employeeDetailService;

    @Mock
    private PrivilegeService privilegeService;

    @Mock
    private HidingStrategyService hidingStrategyService;

    String data = "Ingenuity";
    private static final String hidingDataNameForBare = "BARE";
    private static final String hidingDataNameForSimple = "SIMPLE";
    private static final String hidingDataNameForSpecific = "SPECIFIC";
    private static final String hidingDataNameForExceptional = "EXCEPTIONAL";

    private static final Integer LEVEL_1 = 1;
    private static final Integer LEVEL_2 = 2;
    private static final Integer LEVEL_3 = 3;
    private static final Integer LEVEL_4 = 4;

    @Test
    public void maskDataToNotMaskedData() throws InvalidDataException {
        when(employeeDetailService.getEmployeeDetail(1, TechnicalEmployee.class)).thenReturn(new TechnicalEmployee("Adam Steltzner", 1963, EmployeeConstant.employeeLevels.get(LEVEL_1), Arrays.asList("IntelliJ", "Python", "Terraform")));
        when(privilegeService.isDataVisible(LEVEL_1,LEVEL_1)).thenReturn(true);

        String actualData = hidingStrategy.executeCommand(HidingLevel.LEVEL_ONE, HidingData.BARE, data);
        String expected = data;
        Assert.assertEquals(expected,actualData);
    }
}
