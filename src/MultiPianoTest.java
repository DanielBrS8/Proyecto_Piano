import bpc.daw.consola.Consola;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class MultiPianoTest {

    @Test
    public void test1(){
        Consola consola = new Consola();

        Graphics graphics = consola.getCapaCanvas().getGraphics();
        MultiPiano multiPiano = new MultiPiano(0,80);

        multiPiano.setGraphics(graphics);

        multiPiano.setPosicion(100,100);

        ElementoVisualTester elementoVisualTester = new ElementoVisualTester(consola);

        elementoVisualTester.setElementoVisual(multiPiano);
        elementoVisualTester.hacerPrueba();

    }

}