package de.timmi6790.utility.modules.creative_tab;

import de.timmi6790.utility.BaseModule;
import de.timmi6790.utility.modules.creative_tab.tabs.*;

public class CreativeTabModule extends BaseModule {

    @Override
    public void enable() {
        new SpawnersTab();
        new SummonEggsTab();
        new PotionsTab();
        new UnobtainableTab();
        new ExploitTab();
    }
}
