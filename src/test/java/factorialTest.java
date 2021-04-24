import org.junit.Assert;
import org.junit.Test;

public class factorialTest {

    @Test
    public void shouldReturnCalculatedFactorial() {
        //GIVEN
        int factorial1 = 2;
        int calculatedFactorial1 = 1*2;
        int factorial2 = 4;
        int calculatedFactorial2 = 1*2*3*4;
        //WHEN
        int result1 = Factorial.factorial(factorial1);
        int result2 = Factorial.factorial(factorial2);

        //GIVEN
        Assert.assertEquals(calculatedFactorial1,result1);
        Assert.assertEquals(calculatedFactorial2,result2);
    }
}
