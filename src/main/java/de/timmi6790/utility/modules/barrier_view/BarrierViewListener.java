package de.timmi6790.utility.modules.barrier_view;

import de.timmi6790.utility.ListenerComponent;
import de.timmi6790.utility.modules.config.events.ConfigChangeEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@RequiredArgsConstructor
@Log4j2
public class BarrierViewListener implements ListenerComponent {
    private final BarrierViewModule module;

    @SubscribeEvent
    public void onConfigChange(final ConfigChangeEvent event) {
        if (event.getProperty().equals(event.getConfig().getVisibleBarrierBlockProperty())) {
            log.trace("Reloading render do to config change");
            this.module.reloadRender();
        }
    }
}
