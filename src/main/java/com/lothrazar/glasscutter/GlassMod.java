package com.lothrazar.glasscutter;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod(GlassMod.MODID)
public class GlassMod {

  public static final String MODID = "glasscutter";

  public GlassMod() {}

  @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
  public static class RegistryEvents {

    @SubscribeEvent
    public static void onItemsRegistry(RegistryEvent.Register<Item> event) {
      Item.Properties properties = new Item.Properties().tab(CreativeModeTab.TAB_TOOLS);// tab group
      IForgeRegistry<Item> r = event.getRegistry();
      //normal is same durability as shears
      r.register(new GlassCutter(properties.stacksTo(1).durability(238)).setRegistryName(MODID));
      properties = new Item.Properties().tab(CreativeModeTab.TAB_TOOLS);// tab group
      //same damage as diamond pickaxe
      r.register(new GlassCutter(properties.stacksTo(1).durability(1561)).setRegistryName("glasscutter_strong"));
    }
  }
}
