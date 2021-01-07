package minexixi.radiocraft.proxy;

import minexixi.radiocraft.EventHandler;
import minexixi.radiocraft.RadioCraft;
import minexixi.radiocraft.network.NettyServer;
import minexixi.radiocraft.network.ServerHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        // EventHandler.registerMessage(MessageHandler.class, PacketAudio.class, Side.SERVER);
    }

    public void init(FMLInitializationEvent event) {
        NettyServer.startServer();
    }

    public void postInit(FMLPostInitializationEvent event) {

    }
}
