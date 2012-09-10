package Magecraft.client;

import net.minecraftforge.client.MinecraftForgeClient;
import Magecraft.common.CommonProxyMagecraft;

public class ClientProxyMagecraft extends CommonProxyMagecraft
{
	@Override
    public void registerRenderThings()
    {
     MinecraftForgeClient.preloadTexture("/MageCraft_Resources/BlockTextureSheet.png");
     MinecraftForgeClient.preloadTexture("/MageCraft_Resources/ItemTextureSheet.png");
    }
}
