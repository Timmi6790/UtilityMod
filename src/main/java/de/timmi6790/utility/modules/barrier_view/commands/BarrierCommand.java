package de.timmi6790.utility.modules.barrier_view.commands;

import de.timmi6790.utility.modules.barrier_view.BarrierViewModule;
import de.timmi6790.utility.modules.command.BaseCommand;
import de.timmi6790.utility.modules.config.Config;
import de.timmi6790.utility.modules.config.ConfigModule;
import de.timmi6790.utility.utils.MessageBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.EnumChatFormatting;

import java.util.Optional;

public class BarrierCommand extends BaseCommand {
    private final BarrierViewModule module;

    public BarrierCommand(final BarrierViewModule module) {
        super("barrier");
        this.setPrefix("Barrier");

        this.module = module;
    }

    @Override
    public void onCommand(final ICommandSender sender, final String[] args) {
        final Optional<Config> configOpt = this.module.getModule(ConfigModule.class).map(ConfigModule::getConfig);
        if (!configOpt.isPresent()) {
            this.tell(MessageBuilder.of("Config not loaded!"));
            return;
        }

        final Config config = configOpt.get();
        config.setVisibleBarrierBlock(!config.isVisibleBarrierBlock());

        if (config.isVisibleBarrierBlock()) {
            this.tell(MessageBuilder.of("Barrier blocks are now visible.", EnumChatFormatting.GRAY));
        } else {
            this.tell(MessageBuilder.of("We are back to normal.", EnumChatFormatting.GRAY));
        }

        Minecraft.getMinecraft().renderGlobal.loadRenderers();
    }
}
