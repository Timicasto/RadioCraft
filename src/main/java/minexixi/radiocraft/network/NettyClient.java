package minexixi.radiocraft.network;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;

import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class NettyClient {
    private static int maxRe = 5;
    public static void client() {
        NioEventLoopGroup worker = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(worker).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(new ClientHandler());
            }
        });
        connect(bootstrap, 5);
    }

    private static void connect(Bootstrap bootstrap, int re) {
        bootstrap.connect("127.0.0.1", 32180).addListener(future -> {
            if (future.isSuccess()) {
                    System.out.println("Connect Successful");
            } else if (re == 0) {
                System.err.println("Connect Failed, Gave up");
            } else {
                int order = (maxRe - re) + 1;
                int delay = 1 << order;
                System.err.println(new Date() + ": Connect Failed, Retry: " + order);
                bootstrap.config().group().schedule(() -> connect(bootstrap, re - 1), delay, TimeUnit.SECONDS);
            }
        });
    }
}
