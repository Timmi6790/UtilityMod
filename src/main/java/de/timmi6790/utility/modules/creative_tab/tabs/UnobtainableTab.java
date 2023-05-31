package de.timmi6790.utility.modules.creative_tab.tabs;

import de.timmi6790.utility.builders.item_stack.ItemStackBuilder;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import java.util.Collections;
import java.util.List;

public class UnobtainableTab extends BaseTab {
    public UnobtainableTab() {
        super("Unobtainable", Items.experience_bottle);
    }

    @Override
    protected void getItems(final List<ItemStack> items) {
        Collections.addAll(
                items,
                ItemStackBuilder.of(Blocks.barrier)
                        .build(),

                ItemStackBuilder.of(Blocks.command_block)
                        .build(),

                ItemStackBuilder.of(Blocks.dragon_egg)
                        .build(),

                // TODO: FIX CLIENT CRASH
                /*
                ItemStackBuilder.of(Blocks.end_portal)
                        .build(),

                ItemStackBuilder.of(Blocks.portal)
                        .build(),

                ItemStackBuilder.of(Blocks.air)
                        .build(),

                ItemStackBuilder.of(Blocks.fire)
                        .build(),
                 */

                ItemStackBuilder.of(Blocks.farmland)
                        .build()
        );
    }
}
