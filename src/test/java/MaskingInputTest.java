import com.elarslan.customannotations.masking.MaskingInput;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MaskingInputTest {

    String dataIncludesVowels = "Adam Steltzner";

    @Test
    public void maskVowelsForNonNullValues(){
        String actualMaskedData = MaskingInput.maskVowels(dataIncludesVowels);
        String expectedMaskedData ="*d*m St*ltzn*r";
        Assert.assertEquals(expectedMaskedData,actualMaskedData);
    }

}
