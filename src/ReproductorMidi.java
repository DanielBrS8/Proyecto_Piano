import javax.sound.midi.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ReproductorMidi implements Receiver {
    private static final Color[] COLORES = {
            Color.YELLOW, Color.ORANGE, Color.BLUE, Color.RED,
            Color.CYAN, Color.GREEN, Color.MAGENTA, Color.PINK,
            Color.GRAY, Color.DARK_GRAY, Color.WHITE, Color.LIGHT_GRAY,
            new Color(120, 190, 250),
            new Color(220, 190, 110),
            new Color(100, 19, 150),
            new Color(220, 170, 150),
            new Color(20, 20, 50)
    };
    private Piano pianoMidi;

    public ReproductorMidi() {
        this.pianoMidi = null;
    }

    public void conectar(Piano p) {
        this.pianoMidi = p;
    }

    public void reproducir(String ruta) {
        try {
            Sequence secuencia = MidiSystem.getSequence(new File(ruta));
            Sequencer secuenciador = MidiSystem.getSequencer();
            secuenciador.open();
            Transmitter transmisor = secuenciador.getTransmitter();
            transmisor.setReceiver(this);
            secuenciador.setSequence(secuencia);
            secuenciador.start();
            Thread.sleep(secuencia.getMicrosecondLength() / 1000); // Corrección aquí
            transmisor.close();
            secuenciador.close();
        } catch (MidiUnavailableException | InvalidMidiDataException | IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void send(MidiMessage message, long timeStamp) {
        if (message instanceof ShortMessage) {
            ShortMessage sM = (ShortMessage) message;
            if (sM.getChannel() != 9) { // Corrección clave aquí
                int nota = sM.getData1();
                Tecla t = pianoMidi.getTecla(sM.getChannel(), nota);
                if (t != null) { // Verificar que la tecla existe
                    int comando = sM.getCommand();
                    if (comando == ShortMessage.NOTE_ON) {
                        int volumen = sM.getData2();
                        if (volumen > 0) {
                            t.setColorPulsado(COLORES[sM.getChannel() % COLORES.length]);
                            t.pulsar();
                        } else {
                            t.soltar();
                        }
                    } else if (comando == ShortMessage.NOTE_OFF) {
                        t.soltar();
                    }
                    t.dibujar();
                }
            }
        }
    }

    @Override
    public void close() {
        // Liberar recursos si es necesario
    }
}