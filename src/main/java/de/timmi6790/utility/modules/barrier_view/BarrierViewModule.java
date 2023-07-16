package de.timmi6790.utility.modules.barrier_view;

import de.timmi6790.utility.BaseModule;
import de.timmi6790.utility.modules.barrier_view.commands.BarrierCommand;
import net.minecraft.client.Minecraft;

public class BarrierViewModule extends BaseModule {
    public BarrierViewModule() {
        this.registerListenerComponents(new BarrierViewListener(this));

        this.registerCommands(new BarrierCommand(this));
    }

    public void reloadRender() {
        Minecraft.getMinecraft().renderGlobal.loadRenderers();
    }
}
