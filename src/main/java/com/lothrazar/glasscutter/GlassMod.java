package com.lothrazar.glasscutter;

import com.lothrazar.library.registry.RegistryFactory;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(GlassMod.MODID)
public class GlassMod {

  public static final String MODID = "glasscutter";
  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

  @SubscribeEvent
  public static void buildContents(CreativeModeTabEvent.Register event) {
    RegistryFactory.buildTab(event, GlassMod.MODID, GLASSCUTTER.get().asItem(), ITEMS);
  }

  public static final RegistryObject<Item> GLASSCUTTER = ITEMS.register("glasscutter", () -> new GlassCutter(new Item.Properties().stacksTo(1).durability(238)));
  public static final RegistryObject<Item> GLASSCUTTER_STRONG = ITEMS.register("glasscutter_strong", () -> new GlassCutter(new Item.Properties().stacksTo(1).durability(1561)));

  public GlassMod() {
    IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    ITEMS.register(bus);
  }
}
