package Magecraft.Common;

import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxyMagecraft extends CommonProxyMagecraft
{
	@Override
    public void registerRenderThings()
    {
     MinecraftForgeClient.preloadTexture("/MageCraft_Resources/BlockTextureSheet.png");
     MinecraftForgeClient.preloadTexture("/MageCraft_Resources/ItemTextureSheet.png");
    }
}
