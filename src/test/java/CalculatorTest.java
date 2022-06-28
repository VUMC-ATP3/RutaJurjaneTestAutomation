import classroomSix.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

public class CalculatorTest {

    private Calculator calculator;

    @Test
    public void testSum(){
        System.out.println("Sum tests");
        int actualResult= calculator.sum(5,3);
        int expectedResult=8;
        Assert.assertEquals(actualResult,expectedResult);
        Assert.assertEquals(calculator.sum(5,3),8);
        Assert.assertEquals(calculator.sum(-5,3),-2);
        Assert.assertEquals(calculator.sum(50,30),80);
        Assert.assertEquals(calculator.sum(5,-3),2);
        System.out.println("This is my first test ever");
    }

    @Test
    public void dalisanasTests(){
        System.out.println("Dalīšanas tests");
        Assert.assertEquals(calculator.dalisana(8.2,2.0),4.1);
    }

    @BeforeClass
    public void beforeClass(){
        this.calculator=new Calculator();
    }

    @BeforeMethod
    public void izpilditPirmsKatraTesta(){
        System.out.println("Izpildās before tests");
    }

}
