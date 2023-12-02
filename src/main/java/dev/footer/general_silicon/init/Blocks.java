package dev.footer.general_silicon.init;

import dev.footer.general_silicon.Root;
import dev.footer.general_silicon.extensions.RefineryBlock;
import dev.footer.general_silicon.extensions.SilicaBuddingBlock;
import dev.footer.general_silicon.extensions.SilicaClusterBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Blocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Root.MODID);

    public static final RegistryObject<Block> SILICA_BLOCK = registerBlock("silica_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.AMETHYST)), Creative.TAB);
    public static final RegistryObject<Block> BUDDING_SILICA = registerBlock("budding_silica",
            () -> new SilicaBuddingBlock(BlockBehaviour.Properties.of(Material.AMETHYST)), Creative.TAB);

    public static final RegistryObject<Block> SILICA_CLUSTER = registerBlock("silica_cluster",
            () -> new SilicaClusterBlock(7, 3, 5, BlockBehaviour.Properties.of(Material.AMETHYST)), Creative.TAB);
    public static final RegistryObject<Block> LARGE_SILICA_BUD = registerBlock("large_silica_bud",
            () -> new SilicaClusterBlock(5, 3, 4, BlockBehaviour.Properties.of(Material.AMETHYST)), Creative.TAB);
    public static final RegistryObject<Block> MEDIUM_SILICA_BUD = registerBlock("medium_silica_bud",
            () -> new SilicaClusterBlock(4, 3, 2, BlockBehaviour.Properties.of(Material.AMETHYST)), Creative.TAB);
    public static final RegistryObject<Block> SMALL_SILICA_BUD = registerBlock("small_silica_bud",
            () -> new SilicaClusterBlock(3, 4, 1, BlockBehaviour.Properties.of(Material.AMETHYST)), Creative.TAB);

    //BE
    public static final RegistryObject<RefineryBlock> REFINERY = registerBlock("refinery",
            () -> new RefineryBlock(BlockBehaviour.Properties.of(Material.METAL)), Creative.TAB);
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return Items.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }
}
