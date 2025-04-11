import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MultiPiano extends Piano{
    private List<PianoSencillo> piano;

    public MultiPiano(int teclainicial,int teclaFinal){

        super();

        this.piano=new ArrayList<>();

        for(int i=0;i<16;i++){

            this.piano.add(new PianoSencillo(teclainicial,teclaFinal));

        }

    }

    @Override
    public Tecla getTecla(int canal, int nota) {

        return this.piano.get(canal).getTecla(canal,nota);

    }

    @Override
    public void setPosicion(int x, int y) {
        int espacio = 10;
        int anchoPiano = this.piano.get(0).getAnchura();
        int altoPiano = this.piano.get(0).getAltura();

        int xActual = x;
        int yActual = y;


        for (int i = 0; i < this.piano.size(); i++) {
            PianoSencillo p = this.piano.get(i);
            p.setPosicion(xActual, yActual);


            if ((i + 1) % 8 == 0) {
                xActual += anchoPiano + espacio;
                yActual = y;
            } else {
                yActual += altoPiano + espacio;
            }
        }
    }

    @Override
    public void setGraphics(Graphics g) {

        for (PianoSencillo p : this.piano) {
            p.setGraphics(g);
        }

    }

    @Override
    public void dibujar() {
        for (PianoSencillo p : this.piano) {
            p.dibujar();
        }

    }

    @Override
    public int getAnchura() {
        int anchoPiano = this.piano.get(0).getAnchura();
        return 2 * anchoPiano + 10;
    }

    @Override
    public int getAltura() {
        int altoPiano = this.piano.get(0).getAltura();
        return 8 * altoPiano + 70;
    }
}
