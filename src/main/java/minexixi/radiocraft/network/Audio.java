package minexixi.radiocraft.network;

import io.netty.buffer.ByteBuf;
import minexixi.radiocraft.RadioCraft;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

import javax.sound.sampled.*;
import java.util.Arrays;
/*
public class Audio {
    public static final int bufSize = 3200;
    public static byte[] buffer = new byte[bufSize];
    public void makeRecord() throws LineUnavailableException {
        AudioFormat audioFormat = new AudioFormat(16000.0F, 16, 1, true, false);
        DataLine.Info info = new DataLine.Info(TargetDataLine.class, audioFormat);
        TargetDataLine targetDataLine = (TargetDataLine) AudioSystem.getLine(info);
        targetDataLine.open(audioFormat);
        targetDataLine.start();
        System.out.println("You can speak now!");
        while (targetDataLine.read(buffer, 0, bufSize) > 0) {
            RadioCraft.network.sendToServer(new PacketAudio(buffer));
        }
    }
}
*/

