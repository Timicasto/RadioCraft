package minexixi.radiocraft.network;
/*
import minexixi.radiocraft.RadioCraft;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import javax.sound.sampled.*;
import java.util.Arrays;

public class MessageHandler implements IMessageHandler<PacketAudio, IMessage> {
    @Override
    public IMessage onMessage(PacketAudio message, MessageContext ctx) {
        if (ctx.side.isServer()) {
            Minecraft.getMinecraft().addScheduledTask(() -> {
                AudioFormat format = new AudioFormat(16000.0F, 16, 1, true, false);
                SourceDataLine line = null;
                DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
                try {
                    line = (SourceDataLine) AudioSystem.getLine(info);
                    line.open(format);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                line.start();
                byte[] b = new byte[3200];
                for (int i = 0 ; i < 3200 ; i++) {
                    b = message.buffer;
                    line.write(b, 0, b.length);
                    System.out.println(1);
                }line.close();
            });
        }
        return null;
    }
}*/
