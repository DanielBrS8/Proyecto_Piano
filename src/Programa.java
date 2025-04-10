import bpc.daw.consola.*;

import java.awt.*;
import java.io.File;

public class Programa {
    public static void main(String [] args){
        Consola consola = new Consola();
        CapaFondo fondo = consola.getCapaFondo();
        FondoColorSolido fcs = new FondoColorSolido(Color.DARK_GRAY);
        fondo.setFondo(fcs);
        CapaCanvas cCanvas = consola.getCapaCanvas();
        Graphics graphics = cCanvas.getGraphics();
        graphics.drawString("Introduce la ruta de un archivo para reproducir",100,100);
        String direccionArchivo = consola.getTeclado().leerCadenaCaracteres();
        File archivoMidi = new File(direccionArchivo);
        if(archivoMidi.exists()){
            cCanvas.cls();
            graphics.drawString("""
                    Donde desea reproducir la cancion?
                    1) Piano Sencillo
                    2) Piano Multiple""",100,100);
            int opcion = consola.getTeclado().leerNumeroEntero();
            Piano PianoPractico = null;
            switch (opcion){
                case 1 ->{
                    PianoSencillo pianoS = new PianoSencillo(24,108);

                }
                case 2 ->{
                    PianoPractico = new MultiPiano(24,108);
                }
            }
            PianoPractico.setPosicion(500,500);
            PianoPractico.setGraphics(graphics);
            ReproductorMidi reproMidi = new ReproductorMidi();
            reproMidi.conectar(PianoPractico);
            reproMidi.reproducir(direccionArchivo);

        }else{
            graphics.drawString("OOps ha ocurrido un error, ese archivo no existe",200,200);
        }
    }
}
