import bpc.daw.consola.CapaFondo;
import bpc.daw.consola.Consola;
import bpc.daw.consola.FondoColorSolido;
import org.junit.Test;

import java.awt.*;

public class TeclaFactoryTest {

    @Test

    public void test1(){

        Consola consola = new Consola();
        CapaFondo capaFondo = consola.getCapaFondo();
        FondoColorSolido fondoColorSolido = new FondoColorSolido(Color.GRAY);

        capaFondo.setFondo(fondoColorSolido);

        ElementoVisualTester elementoVisualTester = new ElementoVisualTester(consola);

    }


}