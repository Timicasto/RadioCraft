package minexixi.radiocraft.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.StandardCharsets;
import java.util.Date;

public class ServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf buf = (ByteBuf)msg;
        System.out.println(new Date() + ": Received Data -> " + buf.toString(StandardCharsets.UTF_8));
        ByteBuf out = getByteBuf(ctx);
        ctx.channel().writeAndFlush(out);
    }

    private ByteBuf getByteBuf(ChannelHandlerContext ctx) {
        byte[] bytes = "[ServerThread]: ?? What's up? ->".getBytes(StandardCharsets.UTF_8);
        ByteBuf buf = ctx.alloc().buffer();
        buf.writeBytes(bytes);
        return buf;
    }
}
