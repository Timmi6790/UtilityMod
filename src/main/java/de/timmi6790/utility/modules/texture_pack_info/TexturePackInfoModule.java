package de.timmi6790.utility.modules.texture_pack_info;

import de.timmi6790.utility.BaseModule;

public class TexturePackInfoModule extends BaseModule
{
	public TexturePackInfoModule()
	{
		registerListenerComponents(
				new TexturePackInfoListener()
		);
	}
}
