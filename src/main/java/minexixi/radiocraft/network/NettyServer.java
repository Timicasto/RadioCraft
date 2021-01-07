package minexixi.radiocraft.network;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NettyServer {
    public static Logger logger = LogManager.getLogger();
    public static void startServer() {
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        logger.info("Loaded Class");
        bootstrap.group(boss, worker).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<NioSocketChannel>() {
            protected void initChannel(NioSocketChannel channel) {
                logger.info("Starting RadioCraft Netty Server");
                channel.pipeline().addLast(new ServerHandler());
            }
        });
        bootstrap.bind(32180);
    }

    public static void heapByteBuf() {
        ByteBuf buf = Unpooled.buffer();
        if (buf.hasArray()) {
            byte[] bytes = buf.array();
            int offset = buf.arrayOffset() + buf.readerIndex();
            int length = buf.readableBytes();
            logger.info("offset:{},length:{}", offset, length);
        }
    }
}
