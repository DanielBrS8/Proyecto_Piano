import java.awt.*;

public abstract class Tecla implements Pulsable{
    protected Point posicion;
    private int nota;
    private boolean pulsada;
    private Color colorPulsada;
    private Graphics graphics;
    Tecla(int n){
        this.pulsada=false;
        this.nota = n;
        this.posicion = null;
        this.colorPulsada=null;
    }
    public int getNumeroNota(){
        return this.nota;
    }
    @Override
    public void setPosicion(int x, int y){
        this.posicion = new Point(x,y);
    }
    @Override
    public void pulsar(){
        this.pulsada = true;
    }
    @Override
    public void soltar(){
        this.pulsada = false;
    }
    @Override
    public void dibujar(){
        if (this.posicion == null || this.graphics == null) {
            throw new IllegalStateException("hay que llamar a setPosicion y setGraphics antes de llamar al método dibujar");
        }else{
            this.graphics.setColor(this.getColor());
            this.graphics.fillPolygon(this.getVerticesX(),this.getVerticesY(),this.getVerticesX().length);
            this.graphics.setColor(Color.black);
            this.graphics.drawPolygon(this.getVerticesX(),this.getVerticesY(),this.getVerticesX().length);
        }
    }
    @Override
    public void setColorPulsado(Color c){
        this.colorPulsada = c;
    }
    @Override
    public boolean estaPulsado(){
        return this.pulsada;
    }
    @Override
    public Color getColorPulsado(){
        return this.colorPulsada;
    }
    protected abstract int[] getVerticesX();
    protected abstract int[] getVerticesY();

}
