package dev.footer.general_silicon.init;

import dev.footer.general_silicon.Root;
import dev.footer.general_silicon.blockentity.RefineryBE;
import dev.footer.general_silicon.extensions.RefineryBlock;
import dev.footer.general_silicon.init.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BEInit {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Root.MODID);

    public static final RegistryObject<BlockEntityType<RefineryBE>> REFINERY = BLOCK_ENTITIES.register("refinery",
            () -> BlockEntityType.Builder.of(RefineryBE::new, Blocks.REFINERY.get()).build(null));


    public static void register(IEventBus bus) {
        BLOCK_ENTITIES.register(bus);
    }
}
