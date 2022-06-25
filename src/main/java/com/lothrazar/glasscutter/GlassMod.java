package com.lothrazar.glasscutter;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(GlassMod.MODID)
public class GlassMod {

  public static final String MODID = "glasscutter";
  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
  public static final RegistryObject<Item> GLASSCUTTER = ITEMS.register("glasscutter", () -> new GlassCutter(new Item.Properties().stacksTo(1).durability(238).tab(CreativeModeTab.TAB_TOOLS)));
  public static final RegistryObject<Item> GLASSCUTTER_STRONG = ITEMS.register("glasscutter_strong", () -> new GlassCutter(new Item.Properties().stacksTo(1).durability(1561).tab(CreativeModeTab.TAB_TOOLS)));

  public GlassMod() {
    IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    ITEMS.register(bus);
  }
  //  @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
  //  public static class RegistryEvents {
  //
  //    @SubscribeEvent
  //    public static void onItemsRegistry(RegistryEvent.Register<Item> event) {
  //      Item.Properties properties = new Item.Properties().tab(CreativeModeTab.TAB_TOOLS);// tab group
  //      IForgeRegistry<Item> r = event.getRegistry();
  //      //normal is same durability as shears
  //      r.register(new GlassCutter(properties.stacksTo(1).durability(238)).setRegistryName(MODID));
  //      properties = new Item.Properties().tab(CreativeModeTab.TAB_TOOLS);// tab group
  //      //same damage as diamond pickaxe
  //      r.register(new GlassCutter(properties.stacksTo(1).durability(1561)).setRegistryName("glasscutter_strong"));
  //    }
  //  }
}
