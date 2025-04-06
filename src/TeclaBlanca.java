import java.awt.*;

public abstract class TeclaBlanca extends Tecla{
    public static final int ALTURA = 100;
    public static final int ANCHURA = 25;
    TeclaBlanca(int numero){
        super(numero);
    }
    @Override
    public Color getColorNoPulsado(){
        return new Color(255,255,255);
    }
    @Override
    public int getAnchura(){
        return TeclaBlanca.ANCHURA;
    }
    @Override
    public int getAltura(){
        return TeclaBlanca.ALTURA;
    }



}
