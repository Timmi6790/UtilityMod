package de.timmi6790.utility.modules.creative_tab.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public abstract class BaseTab extends CreativeTabs {
    private final Item displayItem;

    protected BaseTab(String label, Item displayItem) {
        super(label);

        this.displayItem = displayItem;
    }

    @Override
    public String getTranslatedTabLabel() {
        return this.getTabLabel();
    }

    @Override
    public Item getTabIconItem() {
        return displayItem;
    }

    @Override
    public void displayAllReleventItems(final List<ItemStack> items) {
        this.getItems(items);
    }

    protected abstract void getItems(List<ItemStack> items);
}
