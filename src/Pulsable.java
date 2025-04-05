import java.awt.*;

public interface Pulsable extends ElementoVisual{
    public abstract void pulsar();
    public abstract void soltar();
    public abstract boolean estaPulsado();
    public abstract void setColorPulsado(Color c);
    public abstract Color getColorPulsado();
    public abstract Color getColorNoPulsado();
    public default Color getColor(){
        Color c = null;
        if (this.estaPulsado()){
            c = this.getColorPulsado();
        }else{
            c = this.getColorNoPulsado();
        }
        return c;
    };


}
