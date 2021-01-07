package minexixi.radiocraft;

import minexixi.radiocraft.block.BlockRadioStation;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class RegistryHandler {
    public static final Block RADIO_STATION = new BlockRadioStation();
    public static final Item RADIO_STATION_ITEM = new ItemBlock(RADIO_STATION);
    @SubscribeEvent
    public static void registerBlock(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
            RADIO_STATION
        );
    }

    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
            RADIO_STATION_ITEM.setRegistryName("radio_station")
        );
    }
}
