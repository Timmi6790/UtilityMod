package de.timmi6790.utility;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import lombok.Getter;

@Mod(modid = Constants.MOD_ID)
public class UtilityMod
{
	@Getter
	@Mod.Instance(value = Constants.MOD_ID)
	private static UtilityMod instance;

	@Mod.EventHandler
	public void init(final FMLInitializationEvent event)
	{
		System.out.println("Dirt: " + Blocks.dirt.getUnlocalizedName());
	}
}
