package de.timmi6790.utility.modules.creative_tab.tabs;

import java.util.List;
import net.minecraft.init.Items;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;

public class SummonEggsTab extends BaseTab {
    public SummonEggsTab() {
        super("Summon Eggs", Items.spawn_egg);
    }

    @Override
    public void getItems(final List<ItemStack> items) {
        for (int metaData = 0; 200 >= metaData; metaData++) {
            final ItemStack itemStack = new ItemStack(Items.spawn_egg, 1, metaData);
            if (ItemMonsterPlacer.getEntityName(itemStack) != null) {
                items.add(itemStack);
            }
        }
    }
}
