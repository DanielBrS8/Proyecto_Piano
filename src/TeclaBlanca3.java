public class TeclaBlanca3 extends TeclaBlanca{
    TeclaBlanca3(int numero){
        super(numero);
    }

    @Override
    protected int[] getVerticesX() {
        int posX = this.posicion.x;
        int N = TeclaNegra.ANCHURA;
        int B = TeclaBlanca.ANCHURA;
        int[] x = {
                posX
                ,posX+B-N
                ,posX+B-N
                ,posX+B
                ,posX+B
                ,posX
        };
        return x;
    }
    @Override
    protected int[] getVerticesY() {
        int posY = this.posicion.y;
        int[] y = {
                posY+TeclaNegra.ALTURA
                ,posY+TeclaNegra.ALTURA
                ,posY
                ,posY,posY+TeclaBlanca.ALTURA
                ,posY+TeclaBlanca.ALTURA
        };
        return y;
    }
}
