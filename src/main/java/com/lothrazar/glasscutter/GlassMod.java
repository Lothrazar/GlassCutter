package com.lothrazar.glasscutter;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(GlassMod.MODID)
public class GlassMod {

  public static final String MODID = "glasscutter";

  public GlassMod() {
    IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    GlassModRegistry.ITEMS.register(bus);
  }
}
