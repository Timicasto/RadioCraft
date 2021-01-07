package minexixi.radiocraft;

import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.relauncher.Side;

public class EventHandler {
    public static int id = 0;
    public static <REQ extends IMessage, REPLY extends IMessage> void registerMessage(Class<? extends IMessageHandler<REQ, REPLY>> messageHandler, Class<REQ> reqClass, Side side) {
        RadioCraft.network.registerMessage(messageHandler, reqClass, id++, side);
    }
}
