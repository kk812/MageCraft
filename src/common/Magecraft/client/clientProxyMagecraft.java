package Magecraft.client;

import net.minecraftforge.client.MinecraftForgeClient;
import Magecraft.common.commonProxyMagecraft;

public class clientProxyMagecraft extends commonProxyMagecraft
{
	@Override
    public void registerRenderThings()
    {
     MinecraftForgeClient.preloadTexture("/MageCraft_Resources/BlockTextureSheet.png");
     MinecraftForgeClient.preloadTexture("/MageCraft_Resources/ItemTextureSheet.png");
    }
}
