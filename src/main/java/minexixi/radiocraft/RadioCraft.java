package minexixi.radiocraft;

import minexixi.radiocraft.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = RadioCraft.MODID, name = RadioCraft.NAME, version = RadioCraft.VERSION)
public class RadioCraft {
    public static final String MODID = "radiocraft";
    public static final String NAME = "Radio Craft";
    public static final String VERSION = "Demo1";
    public static Logger logger = LogManager.getLogger();

    public static SimpleNetworkWrapper network;

    @Mod.Instance(RadioCraft.MODID)
    public RadioCraft instance;

    @SidedProxy(clientSide = "minexixi.radiocraft.proxy.ClientProxy", serverSide = "minexixi.radiocraft.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        instance = this;
        network = NetworkRegistry.INSTANCE.newSimpleChannel(MODID);
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
