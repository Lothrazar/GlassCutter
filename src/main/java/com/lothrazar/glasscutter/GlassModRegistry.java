package com.lothrazar.glasscutter;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class GlassModRegistry {

  public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(GlassMod.MODID);
  public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GlassMod.MODID);
  public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> GLM = DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, GlassMod.MODID);

  public static final DeferredHolder<Item, GlassCutterItem> GLASSCUTTER = ITEMS.registerItem("glasscutter", props -> new GlassCutterItem(props.stacksTo(1).durability(238)));
  public static final DeferredHolder<Item, GlassCutterItem> GLASSCUTTER_STRONG = ITEMS.registerItem("glasscutter_strong", props -> new GlassCutterItem(props.stacksTo(1).durability(1561)));

  public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<GlassGlobalDropModifier>> GLASS_DROP = GLM.register("glass_drop", () -> GlassGlobalDropModifier.CODEC);

  public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TAB = CREATIVE_TABS.register("tab", () -> CreativeModeTab.builder()
      .icon(() -> new ItemStack(GLASSCUTTER.get()))
      .title(Component.translatable("itemGroup." + GlassMod.MODID))
      .displayItems((enabledFlags, populator) -> {
        for (DeferredHolder<Item, ?> entry : ITEMS.getEntries()) {
          populator.accept(entry.get());
        }
      }).build());
}
