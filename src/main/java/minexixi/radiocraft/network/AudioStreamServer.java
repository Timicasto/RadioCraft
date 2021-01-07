package minexixi.radiocraft.network;

import javax.sound.sampled.*;
import java.io.ByteArrayInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class AudioStreamServer {
    AudioInputStream audioInputStream;
    static AudioInputStream stream1;
    static AudioFormat format;
    static boolean status = true;
    static int port = 15837;
    static int sampleRate = 44100;
    static DataLine.Info info;
    static SourceDataLine line;

    public static void main(String args[]) throws Exception {
        System.out.println("Server started at port: " + port);
        DatagramSocket serverSocket = new DatagramSocket(port);

        byte[] received = new byte[4096];

        format = new AudioFormat(sampleRate, 16, 1, true, false);
        info = new DataLine.Info(SourceDataLine.class, format);
        line = (SourceDataLine) AudioSystem.getLine(info);
        line.open(format);
        line.start();

        DatagramPacket receive = new DatagramPacket(received, received.length);
        ByteArrayInputStream stream = new ByteArrayInputStream(receive.getData());

        while (status == true) {
            serverSocket.receive(receive);
            stream1 = new AudioInputStream(stream, format, receive.getLength());
            toSpeaker(receive.getData());
        }

        line.drain();
        line.close();
    }

    public static void toSpeaker(byte sound[]) {
        try {
            System.out.println("At the speaker");
            line.write(sound, 0, sound.length);
        } catch (Exception e) {
            System.out.println("Not working in speakers...");
            e.printStackTrace();
        }
    }
}
