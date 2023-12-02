package dev.footer.general_silicon.init;

import dev.footer.general_silicon.Root;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Items {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Root.MODID);

    public static final RegistryObject<Item> SILICON = ITEMS.register("silicon",
            () -> new Item(new Item.Properties().tab(Creative.TAB)));
    public static final RegistryObject<Item> SILICA_SHARD = ITEMS.register("silica_shard",
            () -> new Item(new Item.Properties().tab(Creative.TAB)));
    public static final RegistryObject<Item> SILICA_DUST = ITEMS.register("silica_dust",
            () -> new Item(new Item.Properties().tab(Creative.TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
