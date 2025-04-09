public class TeclaBlanca2 extends TeclaBlanca{
    TeclaBlanca2(int numero){
        super(numero);
    }

    @Override
    protected int[] getVerticesX() {
        int posX = this.posicion.x;
        int N = TeclaNegra.ANCHURA;
        int B = TeclaBlanca.ANCHURA;
        int[] x = {
                posX,posX+N/2,posX+N/2,posX+B-N/2,
                posX+B-N/2,posX+B,posX+B,posX

        };
        return x;
    }

    @Override
    protected int[] getVerticesY() {
        int posY = this.posicion.y;
        int[] y = {
            posY+TeclaNegra.ALTURA,posY+TeclaNegra.ALTURA,posY,posY
            ,posY+TeclaNegra.ALTURA,posY+TeclaNegra.ALTURA,posY+TeclaBlanca.ALTURA
            ,posY+TeclaBlanca.ALTURA
        };
        return y;
    }
}
