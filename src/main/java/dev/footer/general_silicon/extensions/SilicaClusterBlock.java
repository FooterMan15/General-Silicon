package dev.footer.general_silicon.extensions;

import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;


public class SilicaClusterBlock extends AmethystClusterBlock {
    public SilicaClusterBlock(int i, int j, int k, Properties properties) {
        super(i, j, Properties.of(Material.AMETHYST)
                .strength(1.5f, 1.5f)
                .sound(SoundType.AMETHYST_CLUSTER)
                .noOcclusion()
                .randomTicks()
                .lightLevel((lightEmission) -> k)
        );
    }
}
