package com.lothrazar.glasscutter;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;

public class GlassCutter extends Item {

  public GlassCutter(Properties properties) {
    super(properties);
  }

  @Override
  public boolean mineBlock(ItemStack stack, Level worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
    if (!worldIn.isClientSide) {
      stack.hurtAndBreak(1, entityLiving, (p) -> {
        p.broadcastBreakEvent(EquipmentSlot.MAINHAND);
      });
    }
    if (isGlass(state)) {
      worldIn.addFreshEntity(new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(state.getBlock())));
    }
    return super.mineBlock(stack, worldIn, state, pos, entityLiving);
  }

  @Override
  public boolean isCorrectToolForDrops(BlockState blockIn) {
    return isGlass(blockIn);
  }

  @Override
  public float getDestroySpeed(ItemStack stack, BlockState state) {
    return state.is(Tags.Blocks.GLASS)
        || state.is(Tags.Blocks.GLASS_PANES) ? 15.0F : super.getDestroySpeed(stack, state);
  }

  public static boolean isGlass(BlockState blockIn) {
    return blockIn.is(Tags.Blocks.GLASS)
        || blockIn.is(Tags.Blocks.GLASS_PANES);
  }
}
