import bpc.daw.consola.Consola;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;
public class TeclaNegraTest {

    @Test
    public void test1(){
        TeclaNegra teclaNegra = new TeclaNegra(61);
        teclaNegra.setColorPulsado(Color.BLUE);
        teclaNegra.pulsar();
        assertEquals(Color.BLUE,teclaNegra.getColor());
    }

    @Test
    public void test2(){
        Consola consola= new Consola();
        TeclaNegra teclaNegra = new TeclaNegra(61);
        ElementoVisualTester elementoVisualTester= new ElementoVisualTester(consola);
        elementoVisualTester.setElementoVisual(teclaNegra);
        elementoVisualTester.hacerPrueba();
    }
}