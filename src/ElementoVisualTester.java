import bpc.daw.consola.CapaTexto;
import bpc.daw.consola.Consola;
import bpc.daw.consola.FondoColorSolido;
import bpc.daw.consola.Teclado;

import java.awt.*;

public class ElementoVisualTester {

    private Graphics graphics;
    private ElementoVisual elemento;
    private Consola consola;

    public ElementoVisualTester(Graphics g, Consola c){
        this.graphics=g;
        this.elemento=null;
        this.consola = c;

    }

    public ElementoVisualTester(Consola c){
        this.consola = c;
        this.consola.getCapaFondo().setFondo(new FondoColorSolido(Color.GRAY));
        this.graphics=this.consola.getCapaCanvas().getGraphics();
        this.elemento=null;
    }

    public void setElementoVisual(ElementoVisual e){

        this.elemento=e;

    }

    public boolean hacerPrueba(){

        this.elemento.setPosicion(120,90);
        this.elemento.setGraphics(this.graphics);
        this.elemento.dibujar() ;

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
        boolean devolver = false;
        if(this.consola!=null){
            CapaTexto capaTexto = this.consola.getCapaTexto();
            Teclado teclado = this.consola.getTeclado();

            capaTexto.println("¿Ha salido bien el test? (s/n)");

            String respuestUsuario = teclado.leerCadenaCaracteres();


            if(respuestUsuario.equalsIgnoreCase("s")){

                devolver=true;

            }



        }

        return devolver;
    }

}
