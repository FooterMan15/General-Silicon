package dev.footer.general_silicon;

import dev.footer.general_silicon.init.BEInit;
import dev.footer.general_silicon.init.Blocks;
import dev.footer.general_silicon.init.Items;
import dev.footer.general_silicon.menu.MenuInit;
import dev.footer.general_silicon.menu.RefineryScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("general_silicon")
public class Root {

    public static final String MODID = "general_silicon";

    public Root() {
        IEventBus MOD_BUS = FMLJavaModLoadingContext.get().getModEventBus();

        Items.ITEMS.register(MOD_BUS);
        Blocks.BLOCKS.register(MOD_BUS);
        BEInit.BLOCK_ENTITIES.register(MOD_BUS);
        MenuInit.MENUS.register(MOD_BUS);


        MinecraftForge.EVENT_BUS.register(this);
    }
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            MenuScreens.register(MenuInit.REFINERY_MENU.get(), RefineryScreen::new);
        }
    }
}
