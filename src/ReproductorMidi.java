import javax.sound.midi.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ReproductorMidi implements Receiver {
    private static final Color[] COLORES =
            {Color.yellow,Color.ORANGE,Color.BLUE,Color.red,
            Color.cyan,Color.GREEN,Color.MAGENTA,Color.pink,
            Color.gray,Color.DARK_GRAY,Color.white,Color.LIGHT_GRAY,
            new Color(120,190,250),
            new Color(220,190,110),
            new Color(100,19,150),
            new Color(220,170,150),
            new Color(20,20,50)};
    private Piano pianoMidi;

    public ReproductorMidi(){
        this.pianoMidi=null;
    }
    public void conectar(Piano p){
        this.pianoMidi=p;

    }
    public void reproducir(String ruta) {

        try{
            Sequence Secuencia = MidiSystem.getSequence(new File(ruta));
            Sequencer S1 = MidiSystem.getSequencer();
            S1.open();
            Transmitter T1 = S1.getTransmitter();
            T1.setReceiver(this);
            S1.setSequence(Secuencia);
            S1.start();
            Thread.sleep(Secuencia.getMicrosecondLength()/10);
            T1.close();
            S1.close();

        } catch (MidiUnavailableException e) {
            System.out.println(e.getMessage());
        } catch (InvalidMidiDataException w) {
            System.out.println(w.getMessage());
        }catch (IOException i){
            System.out.println(i.getMessage());
        }catch (InterruptedException l){
            System.out.println(l.getMessage());
        }
    }


    @Override
    public void send(MidiMessage message, long timeStamp) {
        if(message instanceof ShortMessage ){
            ShortMessage sM = (ShortMessage)message;
            if(sM.getChannel() ==9){
                int numeroNota = sM.getData1();
                Tecla t = this.pianoMidi.getTecla(sM.getChannel(),numeroNota);
                if(t.posicion!=null){
                    int nComando = sM.getCommand();
                    if(nComando==ShortMessage.NOTE_ON){
                        int volumen = sM.getData2();
                        if(volumen>0){
                            t.setColorPulsado(ReproductorMidi.COLORES[sM.getChannel()]);
                            t.pulsar();

                        } else if (volumen==0) {

                            t.soltar();

                        }
                    } else if (nComando==ShortMessage.NOTE_OFF) {
                        t.soltar();

                    }
                    t.dibujar();

                }
            }
        }
    }

    @Override
    public void close() {

    }
}
