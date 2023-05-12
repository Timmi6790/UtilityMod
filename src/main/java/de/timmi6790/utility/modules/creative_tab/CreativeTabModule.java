package de.timmi6790.utility.modules.creative_tab;

import de.timmi6790.utility.BaseModule;
import de.timmi6790.utility.modules.creative_tab.tabs.ExploitTab;
import de.timmi6790.utility.modules.creative_tab.tabs.PotionsTab;
import de.timmi6790.utility.modules.creative_tab.tabs.SpawnersTab;
import de.timmi6790.utility.modules.creative_tab.tabs.SummonEggsTab;
import de.timmi6790.utility.modules.creative_tab.tabs.UnobtainableTab;

public class CreativeTabModule extends BaseModule
{
	@Override
	public void enable()
	{
		new SpawnersTab();
		new SummonEggsTab();
		new PotionsTab();
		new UnobtainableTab();
		new ExploitTab();
	}
}
