import java.awt.*;

public class TeclaNegra extends Tecla{

    public static final int ANCHURA=15;
    public static final int ALTURA=50;

    TeclaNegra(int n){

        super(n);

    }


    @Override
    public Color getColorNoPulsado() {
        return Color.BLACK;
    }

    @Override
    public int getAnchura() {
        return TeclaNegra.ANCHURA;
    }

    @Override
    public int getAltura() {
        return TeclaNegra.ALTURA;
    }

    @Override
    protected int[] getVerticesX() {
        return new int[]{this.posicion.x,this.posicion.x,this.posicion.x+TeclaNegra.ANCHURA,this.posicion.x+TeclaNegra.ANCHURA};
    }

    @Override
    protected int[] getVerticesY() {
        return new int[]{this.posicion.y,this.posicion.y+TeclaNegra.ALTURA,this.posicion.y+TeclaNegra.ALTURA,this.posicion.y};
    }


 



}
