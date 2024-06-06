package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

@DisplayName("Класс для тестирования калькулятор")
public class CalcTest {
    Calc calc = new Calc();

//    @BeforeEach
//    public void before(){
//        System.out.println("калькулятор настроен");
//    }
//    @AfterEach
//    public void after(){
//        System.out.println("калькулятор сброшен");
//    }

    @Test
    @Tag("baseMethods")
    public void testPlus(){
        Assertions.assertEquals(20,calc.plus(10,10));
    }

    @Test
    @Tag("baseMethods")
    public void testMinus(){
        Assertions.assertEquals(0,calc.minus(10,10));
    }

    @Test
    public void testDelen(){
        Assertions.assertEquals(1.0,calc.delen(10.0,10.0));
        Assertions.assertEquals(2.5,calc.delen(10.0,4.0));
    }

    @Test
    public void testDelenInt(){
        Assertions.assertEquals(2, calc.delen(10,4));
    }

    @Test
    @DisplayName("Тест на исключения ArithmeticException при делении на 0")
    public void testDelenIntByZeroException(){
        Assertions.assertThrows(ArithmeticException.class,()->calc.delen(10,0));
    }

    @Test
    public void testUmnozh(){
        Assertions.assertEquals(100,calc.umnozh(10,10));
    }




    @ParameterizedTest
    @ValueSource(ints = {2,4,6,-2,4})
    public void testOddEven(int n){
        Assertions.assertEquals(true,calc.oddEven(n));
    }


    @ParameterizedTest
    @ValueSource(ints = {1,3,7,-9})
    public void testIsEven(int n){
        Assertions.assertTrue(calc.oddEven(11));
        Assertions.assertFalse(calc.oddEven(n));

    }


}
