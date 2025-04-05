import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;
import java.awt.*;

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

    @Override
    public void send(MidiMessage message, long timeStamp) {

    }

    @Override
    public void close() {

    }
}
