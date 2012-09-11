package Magecraft.Client;

import net.minecraftforge.client.MinecraftForgeClient;
import Magecraft.Common.CommonProxyMagecraft;

public class ClientProxyMagecraft extends CommonProxyMagecraft
{
	@Override
    public void registerRenderThings()
    {
     MinecraftForgeClient.preloadTexture("/MageCraft_Resources/BlockTextureSheet.png");
     MinecraftForgeClient.preloadTexture("/MageCraft_Resources/ItemTextureSheet.png");
    }
}
