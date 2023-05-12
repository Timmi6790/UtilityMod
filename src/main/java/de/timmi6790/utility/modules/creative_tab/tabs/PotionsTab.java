package de.timmi6790.utility.modules.creative_tab.tabs;

import java.util.List;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import de.timmi6790.utility.builders.item_stack.ItemStackBuilder;

public class PotionsTab extends BaseTab
{
	public PotionsTab()
	{
		super("Potions", Items.potionitem);
	}

	@Override
	protected void getItems(List<ItemStack> items)
	{
		for (int potionId = 1; 23 >= potionId; potionId++)
		{
			items.add(
					ItemStackBuilder.ofPotion()
							.addPotionEffect(potionId, Byte.MAX_VALUE, Integer.MAX_VALUE)
							.setItemDamage(potionId)
							.build()
			);

			items.add(
					ItemStackBuilder.ofPotion()
							.addPotionEffect(potionId, Byte.MIN_VALUE, Integer.MAX_VALUE)
							.setItemDamage(potionId)
							.build()
			);
		}
	}
}
