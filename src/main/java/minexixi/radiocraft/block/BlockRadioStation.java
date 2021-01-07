package minexixi.radiocraft.block;

import minexixi.radiocraft.network.ClientHandler;
import minexixi.radiocraft.network.NettyClient;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.sound.sampled.LineUnavailableException;

public class BlockRadioStation extends Block {
    public BlockRadioStation() {
        super(Material.ROCK);
        setRegistryName("radio_station");
        setUnlocalizedName("radio_station");
        setCreativeTab(CreativeTabs.REDSTONE);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        NettyClient.client();
        return true;
    }
}
