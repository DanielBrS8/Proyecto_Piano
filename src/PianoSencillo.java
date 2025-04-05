import java.util.HashMap;
import java.util.Map;

public class PianoSencillo extends Piano{
    private Map<Integer,Tecla> teclas;

    public PianoSencillo(int teclaInicial,int teclaFinal){
        this.teclas=new HashMap<>();
    }


}
