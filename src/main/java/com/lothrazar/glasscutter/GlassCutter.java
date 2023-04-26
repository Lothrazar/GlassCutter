package com.lothrazar.glasscutter;

import com.lothrazar.library.item.ItemFlib;
import com.lothrazar.library.util.BlockstatesUtil;
import com.lothrazar.library.util.LevelWorldUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class GlassCutter extends ItemFlib {

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
    if (BlockstatesUtil.isGlass(state)) {
      LevelWorldUtil.dropItemStackInWorld(worldIn, pos, new ItemStack(state.getBlock()));
    }
    return super.mineBlock(stack, worldIn, state, pos, entityLiving);
  }

  @Override
  public boolean isCorrectToolForDrops(BlockState blockIn) {
    return BlockstatesUtil.isGlass(blockIn);
  }

  @Override
  public float getDestroySpeed(ItemStack stack, BlockState state) {
    return BlockstatesUtil.isGlass(state) ? 15.0F : super.getDestroySpeed(stack, state);
  }
}
