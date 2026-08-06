package com.lothrazar.glasscutter;

import com.lothrazar.library.util.BlockstatesUtil;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemInstance;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

public class GlassGlobalDropModifier extends LootModifier {

  public static final MapCodec<GlassGlobalDropModifier> CODEC = RecordCodecBuilder.mapCodec(
      inst -> codecStart(inst).apply(inst, GlassGlobalDropModifier::new));

  public GlassGlobalDropModifier(LootItemCondition[] conditions, int priority) {
    super(conditions, priority);
  }

  @Override
  public MapCodec<? extends IGlobalLootModifier> codec() {
    return CODEC;
  }

  @Override
  protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> lootItems, LootContext ctx) {
    BlockState state = ctx.getOptionalParameter(LootContextParams.BLOCK_STATE);

    //util is based on GLASS_PANES and GLASS_BLOCKS data tags
    if (state == null || !BlockstatesUtil.isGlass(state)) {return lootItems;}

    ItemInstance tool = ctx.getOptionalParameter(LootContextParams.TOOL);
    if (tool == null || tool.is(Items.AIR)) {return lootItems;}

    Item toolItem = tool.typeHolder().value();
    if (toolItem != GlassModRegistry.GLASSCUTTER.get() && toolItem != GlassModRegistry.GLASSCUTTER_STRONG.get()) {
      return lootItems;
    }
    // the block is glass, and the tool is a glass cutter

    Item blockItem = state.getBlock().asItem();
    boolean alreadyDropping = lootItems.stream().anyMatch(s -> s.is(blockItem));
    if (!alreadyDropping) { // example: Silk_touch or Tinted glass already has it
      lootItems.add(new ItemStack(blockItem));
    }
    return lootItems;
  }
}
