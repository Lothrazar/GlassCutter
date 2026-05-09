package com.lothrazar.glasscutter;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.LootTableLoadEvent;

public class GlassLootTableLoadHandler {

  // loot table normal editing
  // TAGS are not available when this event fires
  @SubscribeEvent
  public static void onLootTableLoad(LootTableLoadEvent event) {
//    String path = event.getName().getPath();
//    if (!path.startsWith("blocks/")){ return;}
//
//    Block block = BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(
//        event.getName().getNamespace(), path.substring("blocks/".length())));
//
//    // Tags are not yet bound during LootTableLoadEvent, so use class checks instead
//    if (!(block instanceof GlassBlock) && !(block instanceof PaneBlock)) {return;}
//    if (!BlockstatesUtil.isGlass(block.defaultBlockState())) {return;}
//
//    LootPool pool = LootPool.lootPool()
//        .add(LootItem.lootTableItem(block))
//        .when(AnyOfCondition.anyOf(
//            MatchTool.toolMatches(ItemPredicate.Builder.item().of(GlassModRegistry.GLASSCUTTER.get())),
//            MatchTool.toolMatches(ItemPredicate.Builder.item().of(GlassModRegistry.GLASSCUTTER_STRONG.get()))
//        ))
//        .build();
//    event.getTable().addPool(pool);
  }
}
