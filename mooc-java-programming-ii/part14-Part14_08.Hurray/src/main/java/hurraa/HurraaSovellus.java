package hurraa;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class HurraaSovellus extends JFrame {
    private static final String AUDIO_FILE_PATH = "audio/Applause-Yannick_Lemieux.wav";

    public HurraaSovellus() {
        setTitle("Hurray Button Program");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);

        JButton hurrayButton = new JButton("Hurray!");
        hurrayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playAudio();
            }
        });

        getContentPane().add(hurrayButton);
        pack();
        setLocationRelativeTo(null);
    }

    private void playAudio() {
        try {
            File audioFile = new File(AUDIO_FILE_PATH);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);

            if (!AudioSystem.isLineSupported(info)) {
                System.out.println("Audio line not supported.");
                return;
            }

            Clip audioClip = (Clip) AudioSystem.getLine(info);
            audioClip.open(audioStream);
            audioClip.start();

            // Wait for the audio to finish playing
            while (audioClip.isRunning()) {
                Thread.sleep(100);
            }

            audioClip.close();
            audioStream.close();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HurraaSovellus().setVisible(true);
            }
        });
    }
}
