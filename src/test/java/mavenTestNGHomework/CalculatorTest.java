package mavenTestNGHomework;

import classroomSix.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeClass
    public void jaunsCalc(){
        this.calculator=new Calculator();
    }

    @BeforeMethod
    public void printSacies(){
        System.out.println("Tests ir sācies");
    }


    @Test
    public void testSum(){
        Assert.assertEquals(calculator.sum(40,100),140);
        Assert.assertEquals(calculator.sum(70,1),71);
        Assert.assertEquals(calculator.sum(1000,80),1080);
        Assert.assertEquals(calculator.sum(15,8),23);
    }

    @Test
    public void testAtnemsana(){
        Assert.assertEquals(calculator.atnemsana(70,50),20);
        Assert.assertEquals(calculator.atnemsana(70,1),69);
        Assert.assertEquals(calculator.atnemsana(70,-50),120);
        Assert.assertEquals(calculator.atnemsana(50,50),0);
    }

    @Test
    public void testReizinasana(){
        Assert.assertEquals(calculator.reizinasana(8,5),40);
        Assert.assertEquals(calculator.reizinasana(8,-5),-40);
        Assert.assertEquals(calculator.reizinasana(-8,-5),40);
        Assert.assertEquals(calculator.reizinasana(8,0),0);
    }

    @Test
    public void testDalisana(){
        Assert.assertEquals(calculator.dalisana(40.0,5.0),8.0);
        Assert.assertEquals(calculator.dalisana(-40.0,-5.0),8.0);
        Assert.assertEquals(calculator.dalisana(40.0,-5.0),-8.0);
        Assert.assertEquals(calculator.dalisana(42.5,5.0),8,5);
    }

    @AfterMethod
    public void printBeidzies(){
        System.out.println("Tests ir beidzies");
    }

}
