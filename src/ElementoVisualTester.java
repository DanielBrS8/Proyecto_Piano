import bpc.daw.consola.CapaTexto;
import bpc.daw.consola.Consola;
import bpc.daw.consola.FondoColorSolido;
import bpc.daw.consola.Teclado;

import java.awt.*;
import java.util.Locale;

public class ElementoVisualTester {

    private Graphics graphics;
    private ElementoVisual elemento;

    public ElementoVisualTester(Graphics g){

        this.graphics=g;
        this.elemento=null;

    }

    public ElementoVisualTester(){
        Consola consolaTemp = new Consola();
        consolaTemp.getCapaFondo().setFondo(new FondoColorSolido(Color.GRAY));
        this.graphics=consolaTemp.getCapaCanvas().getGraphics();
        this.elemento=null;

    }

    public void setElementoVisual(ElementoVisual e){

        this.elemento=e;

    }

    public boolean hacerPrueba(){

        this.elemento.setPosicion(120,90);
        this.elemento.setGraphics(this.graphics);
        this.elemento.dibujar();

        if(this.elemento instanceof Pulsable p){

            p.setColorPulsado(Color.BLUE);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            p.pulsar();
            p.dibujar();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            p.soltar();
            p.dibujar();

        }

        Consola consola = new Consola();

        CapaTexto capaTexto = consola.getCapaTexto();
        Teclado teclado = consola.getTeclado();

        capaTexto.println("¿Ha salido bien el test? (s/n)");

        String respuestUsuario = teclado.leerCadenaCaracteres();

        boolean devolver = false;

        if(respuestUsuario.equalsIgnoreCase("s")){

            devolver=true;

        }

        return devolver;

    }

}
