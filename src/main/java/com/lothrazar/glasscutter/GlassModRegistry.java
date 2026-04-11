package com.lothrazar.glasscutter;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class GlassModRegistry {

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, GlassMod.MODID);
  public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GlassMod.MODID);

  public static final DeferredHolder<Item, GlassCutter> GLASSCUTTER = ITEMS.register("glasscutter", () -> new GlassCutter(new Item.Properties().stacksTo(1).durability(238)));
  public static final DeferredHolder<Item, GlassCutter> GLASSCUTTER_STRONG = ITEMS.register("glasscutter_strong", () -> new GlassCutter(new Item.Properties().stacksTo(1).durability(1561)));

  public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TAB = CREATIVE_TABS.register("tab", () -> CreativeModeTab.builder()
      .icon(() -> new ItemStack(GLASSCUTTER.get()))
      .title(Component.translatable("itemGroup." + GlassMod.MODID))
      .displayItems((enabledFlags, populator) -> {
        for (DeferredHolder<Item, ?> entry : ITEMS.getEntries()) {
          populator.accept(entry.get());
        }
      }).build());
}
