package de.timmi6790.utility;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = Constants.MOD_ID)
public class UtilityMod
{
	@Mod.EventHandler
	public void init(final FMLInitializationEvent event)
	{
		System.out.println("Dirt: " + Blocks.dirt.getUnlocalizedName());
	}
}
