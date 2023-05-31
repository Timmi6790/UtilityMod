package de.timmi6790.utility.modules.barrier_view;

import de.timmi6790.utility.BaseModule;
import de.timmi6790.utility.modules.barrier_view.commands.BarrierCommand;

public class BarrierViewModule extends BaseModule {
    public BarrierViewModule() {
        this.registerCommands(
                new BarrierCommand(this)
        );
    }
}
