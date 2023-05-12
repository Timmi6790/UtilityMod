package de.timmi6790.utility.modules.creative_tab.tabs;

import java.util.Comparator;
import java.util.List;

import net.minecraft.entity.EntityList;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import de.timmi6790.utility.builders.item_stack.ItemStackBuilder;

public class SpawnersTab extends BaseTab
{
	public SpawnersTab()
	{
		super("Spawners", new ItemStack(Blocks.mob_spawner).getItem());
	}

	@Override
	public void getItems(final List<ItemStack> items)
	{
		final List<String> entityNames = EntityList.getEntityNameList();
		entityNames.sort(Comparator.naturalOrder());
		for (final String entityName : entityNames)
		{
			// Client crash
			if ("Painting".equalsIgnoreCase(entityName)
					|| "ItemFrame".equalsIgnoreCase(entityName)
					|| "Item".equalsIgnoreCase(entityName)
			)
			{
				continue;
			}

			items.add(
					ItemStackBuilder.ofSpawner(entityName)
							.setItemName(entityName)
							.build()
			);
		}
	}
}
