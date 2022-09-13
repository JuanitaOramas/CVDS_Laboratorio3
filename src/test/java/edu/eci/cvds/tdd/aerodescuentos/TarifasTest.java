package edu.eci.cvds.tdd.aerodescuentos;
import edu.eci.cvds.tdd.aerodescuentos.CalculadorDescuentos;

import org.junit.Assert;
import org.junit.Test;


public class TarifasTest {
    //private CalculadorDescuentos calculador = new CalculadorDescuentos();

    @Test
    public void GivenDiasdeAntelacionMenor20YMayorA18_WhenDiasdeAntelacionMenor20_ThenDescuento(){
        double  calculate = CalculadorDescuentos.calculoTarifa(40, 25, 15);
        Assert.assertEquals(32, calculate, 0.1);
    }
    @Test
    public void GivenDiasdeAntelacionMenor20YMenorA65_WhenDiasdeAntelacionMenor20_ThenDescuento(){
        double calculate = CalculadorDescuentos.calculoTarifa(40, 25, 15);
        Assert.assertEquals(32, calculate, 0.1);
    }

    @Test
    public void Given_When_ThenNoAgeDiscount(){
        double number = 1000;
        double calculate = CalculadorDescuentos.calculoTarifa(number, 15, 30);
        Assert.assertTrue(number == calculate);
    }

    @Test
    public void GivenEdad18YMenorA65_WhenDiasdeAntelacionMenor20_ThenDescuentoValido(){
        double calculate = CalculadorDescuentos.calculoTarifa(40, 25, 20);
        Assert.assertEquals(34, calculate, 0.1);
    }

    @Test
    public void GivenMenorEdad18_WhenDiasdeAntelacionMenor20_ThenDescuentoMenorEdad(){
        double calculate = CalculadorDescuentos.calculoTarifa(40, 25, 18);
        Assert.assertEquals(34, calculate, 0.1);
    }


}
