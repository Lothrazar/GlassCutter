package com.lothrazar.glasscutter;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(GlassMod.MODID)
public class GlassMod {

  public static final String MODID = "glasscutter";

  public GlassMod(IEventBus bus) {
    GlassModRegistry.ITEMS.register(bus);
    GlassModRegistry.CREATIVE_TABS.register(bus);
    GlassModRegistry.GLM.register(bus);
  }
}
