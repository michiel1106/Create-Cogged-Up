package com.lampboy.cogged_up;

import com.lampboy.cogged_up.content.custom_cogwheel.CustomCogwheelBEInstance;
import com.lampboy.cogged_up.content.custom_cogwheel.encased.CustomEncasedCogwheelBEInstance;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.kinetics.base.ShaftInstance;
import com.simibubi.create.content.kinetics.simpleRelays.BracketedKineticBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.BracketedKineticBlockEntityInstance;
import com.simibubi.create.content.kinetics.simpleRelays.BracketedKineticBlockEntityRenderer;
import com.simibubi.create.content.kinetics.simpleRelays.SimpleKineticBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedShaftBlock;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

public class CoggedUpBETypes {

    public static final BlockEntityEntry<BracketedKineticBlockEntity> CUSTOM_COGWHEEL_BE = CoggedUp.REGISTRATE
            .blockEntity("my_large_cogwheel", BracketedKineticBlockEntity::new)
            .instance(() -> CustomCogwheelBEInstance::new)
            .validBlocks(
                    CoggedUpBlocks.ANDESITE_COGWHEEL,
                    CoggedUpBlocks.LARGE_ANDESITE_COGWHEEL,
                    CoggedUpBlocks.BRASS_COGWHEEL,
                    CoggedUpBlocks.LARGE_BRASS_COGWHEEL,
                    CoggedUpBlocks.COPPER_COGWHEEL,
                    CoggedUpBlocks.LARGE_COPPER_COGWHEEL,
                    CoggedUpBlocks.INDUSTRIAL_IRON_COGWHEEL,
                    CoggedUpBlocks.LARGE_INDUSTRIAL_IRON_COGWHEEL
            )
            .renderer(() -> BracketedKineticBlockEntityRenderer::new)
            .register();

    public static final BlockEntityEntry<SimpleKineticBlockEntity> CUSTOM_ENCASED_COGWHEEL_BE = CoggedUp.REGISTRATE
            .blockEntity("custom_encased_cogwheel", SimpleKineticBlockEntity::new)
            .instance(() -> CustomEncasedCogwheelBEInstance::new)
            .validBlocks(
                    CoggedUpBlocks.ANDESITE_ENCASED_ANDESITE_COGWHEEL,
                    CoggedUpBlocks.ANDESITE_ENCASED_LARGE_ANDESITE_COGWHEEL,
                    CoggedUpBlocks.ANDESITE_ENCASED_BRASS_COGWHEEL,
                    CoggedUpBlocks.ANDESITE_ENCASED_LARGE_BRASS_COGWHEEL,
                    CoggedUpBlocks.ANDESITE_ENCASED_COPPER_COGWHEEL,
                    CoggedUpBlocks.ANDESITE_ENCASED_LARGE_COPPER_COGWHEEL,

                    CoggedUpBlocks.BRASS_ENCASED_ANDESITE_COGWHEEL,
                    CoggedUpBlocks.BRASS_ENCASED_LARGE_ANDESITE_COGWHEEL,
                    CoggedUpBlocks.BRASS_ENCASED_BRASS_COGWHEEL,
                    CoggedUpBlocks.BRASS_ENCASED_LARGE_BRASS_COGWHEEL,
                    CoggedUpBlocks.BRASS_ENCASED_COPPER_COGWHEEL,
                    CoggedUpBlocks.BRASS_ENCASED_LARGE_COPPER_COGWHEEL,

                    CoggedUpBlocks.COPPER_ENCASED_ANDESITE_COGWHEEL,
                    CoggedUpBlocks.COPPER_ENCASED_LARGE_ANDESITE_COGWHEEL,
                    CoggedUpBlocks.COPPER_ENCASED_BRASS_COGWHEEL,
                    CoggedUpBlocks.COPPER_ENCASED_LARGE_BRASS_COGWHEEL,
                    CoggedUpBlocks.COPPER_ENCASED_COPPER_COGWHEEL,
                    CoggedUpBlocks.COPPER_ENCASED_LARGE_COPPER_COGWHEEL,

                    CoggedUpBlocks.COPPER_ENCASED_COGWHEEL,
                    CoggedUpBlocks.COPPER_ENCASED_LARGE_COGWHEEL
            )
            .register();

    /**
     * A Block Entity that is identical to ENCASED_SHAFT in {@link com.simibubi.create.AllBlockEntityTypes}
     * This adds the copper encased shaft as a valid block and validates ticking.
     * */
    public static final BlockEntityEntry<KineticBlockEntity> CUSTOM_ENCASED_SHAFT_BE = CoggedUp.REGISTRATE
            .blockEntity("custom_encased_shaft", KineticBlockEntity::new)
            .instance(() -> ShaftInstance::new)
            .validBlocks(CoggedUpBlocks.COPPER_ENCASED_SHAFT)
            .register();

    public static void register() {}
}
