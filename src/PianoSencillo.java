import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class PianoSencillo extends Piano{
    private Map<Integer,Tecla> teclas;

    public PianoSencillo(int teclaInicial,int teclaFinal){
        super();
        this.teclaInicial = teclaInicial;
        this.teclaFinal = teclaFinal;
        this.teclas=new HashMap<>();
        for (int i = this.teclaInicial;i<this.teclaFinal;i++){
            Tecla t1 = TeclaFactory.CrearTecla(i);
            this.teclas.put(i,t1);
        }

    }
    @Override
    public void setPosicion(int x, int y) {
        int x1 = x;
        int y1 = y;
        for (Map.Entry<Integer,Tecla> tecla : this.teclas.entrySet()){
            Tecla t1 = tecla.getValue();
            if (t1 instanceof TeclaBlanca tb){
                t1.setPosicion(x1,y1);
                x1+=TeclaBlanca.ANCHURA;
            }
            if (t1 instanceof TeclaNegra tn){
                t1.setPosicion(x1-TeclaNegra.ANCHURA/2,y1);
            }
        }
        ;
        this.dibujar();
    }

    @Override
    public void setGraphics(Graphics g) {
        for (Map.Entry<Integer,Tecla> tecla : this.teclas.entrySet()){
            tecla.getValue().setGraphics(g);
        }
    }

    @Override
    public void dibujar() {
        for (Map.Entry<Integer,Tecla> tecla : this.teclas.entrySet()){
            tecla.getValue().dibujar();
        }
    }
    @Override
    public int getAnchura() {
        return this.teclas.size()*TeclaBlanca.ANCHURA;
    }

    @Override
    public int getAltura() {
        return TeclaBlanca.ALTURA;
    }

    @Override
    public Tecla getTecla(int canal, int nota) {
        return this.teclas.get(nota);
    }
}

