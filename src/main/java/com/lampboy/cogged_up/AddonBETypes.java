package com.lampboy.cogged_up;

import com.lampboy.cogged_up.content.custom_cogwheel.CustomCogwheelBEInstance;
import com.lampboy.cogged_up.content.custom_cogwheel.encased.CustomEncasedCogwheelBE;
import com.lampboy.cogged_up.content.custom_cogwheel.encased.CustomEncasedCogwheelBEInstance;
import com.lampboy.cogged_up.content.custom_cogwheel.encased.CustomEncasedCogwheelBlock;
import com.simibubi.create.content.kinetics.simpleRelays.BracketedKineticBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.BracketedKineticBlockEntityRenderer;
import com.simibubi.create.content.kinetics.simpleRelays.SimpleKineticBlockEntity;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

public class AddonBETypes {

    public static final BlockEntityEntry<BracketedKineticBlockEntity> MY_LARGE_COGWHEEL_BE = CoggedUp.REGISTRATE
            .blockEntity("my_large_cogwheel", BracketedKineticBlockEntity::new)
            .instance(() -> CustomCogwheelBEInstance::new)
            .validBlocks(
                    AddonBlocks.ANDESITE_COGWHEEL,
                    AddonBlocks.LARGE_ANDESITE_COGWHEEL,
                    AddonBlocks.BRASS_COGWHEEL,
                    AddonBlocks.LARGE_BRASS_COGWHEEL,
                    AddonBlocks.COPPER_COGWHEEL,
                    AddonBlocks.LARGE_COPPER_COGWHEEL,
                    AddonBlocks.INDUSTRIAL_IRON_COGWHEEL,
                    AddonBlocks.LARGE_INDUSTRIAL_IRON_COGWHEEL
            )
            .renderer(() -> BracketedKineticBlockEntityRenderer::new)
            .register();

    public static final BlockEntityEntry<SimpleKineticBlockEntity> CUSTOM_ENCASED_COGWHEEL_BE = CoggedUp.REGISTRATE
            .blockEntity("custom_encased_cogwheel", SimpleKineticBlockEntity::new)
            .instance(() -> (manager, be) -> new CustomEncasedCogwheelBEInstance(manager, be, false))
            .validBlocks(
                    AddonBlocks.ANDESITE_ENCASED_ANDESITE_COGWHEEL
            )
            .register();

    public static void register() {}
}
