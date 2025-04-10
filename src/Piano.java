import javax.swing.text.Position;
import java.awt.*;

public abstract class Piano implements ElementoVisual{
    protected int teclaInicial;
    protected int teclaFinal;
    protected Position posicion;
    private Graphics graphics;

    public Piano(){
        this.teclaFinal=0;
        this.teclaInicial=0;
        this.posicion=null;
        this.graphics=null;
    }
    public abstract Tecla getTecla(int canal, int nota);

    public int getTeclaInicial(){
        return this.teclaInicial;
    }
    public int getTeclaFinal(){
        return this.teclaFinal;
    }

}
