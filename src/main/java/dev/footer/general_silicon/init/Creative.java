package dev.footer.general_silicon.init;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class Creative {
    public static final CreativeModeTab TAB = new CreativeModeTab("silicon_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.SILICON.get());
        }
    };
}
