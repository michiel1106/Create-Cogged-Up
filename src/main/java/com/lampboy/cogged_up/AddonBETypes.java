package com.lampboy.cogged_up;

import com.lampboy.cogged_up.content.custom_cogwheel.CustomCogwheelBE;
import com.lampboy.cogged_up.content.custom_cogwheel.CustomCogwheelBEInstance;
import com.simibubi.create.content.kinetics.simpleRelays.BracketedKineticBlockEntityRenderer;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

public class AddonBETypes {

    public static final BlockEntityEntry<CustomCogwheelBE> MY_LARGE_COGWHEEL_BE = CoggedUp.REGISTRATE
            .blockEntity("my_large_cogwheel", CustomCogwheelBE::new)
            .instance(() -> CustomCogwheelBEInstance::new)
            .validBlocks(
                    AddonBlocks.ANDESITE_COGWHEEL,
                    AddonBlocks.LARGE_ANDESITE_COGWHEEL,
                    AddonBlocks.BRASS_COGWHEEL,
                    AddonBlocks.LARGE_BRASS_COGWHEEL,
                    AddonBlocks.COPPER_COGWHEEL,
                    AddonBlocks.LARGE_COPPER_COGWHEEL,
                    AddonBlocks.INDUSTRIAL_IRON_COGWHEEL,
                    AddonBlocks.LARGE_INDUSTRIAL_IRON_COGWHEEL)
            .renderer(() -> BracketedKineticBlockEntityRenderer::new)
            .register();

    public static void register() {}
}
