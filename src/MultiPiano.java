import java.awt.*;
import java.util.List;

public class MultiPiano extends Piano{
    private List<PianoSencillo> piano;

    public MultiPiano(int teclainicial,int teclaFinal){

    }

    @Override
    public Tecla getTecla(int canal, int nota) {
        return null;
    }

    @Override
    public void setPosicion(int x, int y) {

    }

    @Override
    public void setGraphics(Graphics g) {

    }

    @Override
    public void dibujar() {

    }

    @Override
    public int getAnchura() {
        return 0;
    }

    @Override
    public int getAltura() {
        return 0;
    }
}
