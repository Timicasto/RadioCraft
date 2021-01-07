package minexixi.radiocraft.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import javax.sound.sampled.*;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class ClientHandler extends ChannelInboundHandlerAdapter {
    public static void play(byte[] audio) {
        try {
            AudioFormat format = new AudioFormat(44100, 16, 1, true, false);
            SourceDataLine line = AudioSystem.getSourceDataLine(format);
            line.open(format);
            line.start();
            line.write(audio, 0, audio.length);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void sendAudio(BigInteger freq, byte[] audio) {
        BigInteger freq1 = new BigInteger("300000000000");
        byte[] bytes = new byte[audio.length + 1];
        //bytes[0] = freq1;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        ByteBuf buf = ctx.alloc().buffer();
        byte[] bytes = buf.array();
        play(bytes);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf)msg;
        System.out.println(buf.toString(StandardCharsets.UTF_8));
    }
}
