package net.donut.dexrewards.block.custom;

import net.donut.dexrewards.block.entity.DexMapBlockEntity;
import net.donut.dexrewards.block.entity.ImplementedInventory;
import net.donut.dexrewards.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class DexMapBlock extends BlockWithEntity implements BlockEntityProvider, ImplementedInventory {
    private static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    private static final VoxelShape NORTH_WALL = VoxelShapes.cuboid(-16 / 16f, 0, 14 / 16f, 32 / 16f, 28 / 16f, 16 / 16f);
    private static final VoxelShape EAST_WALL = VoxelShapes.cuboid(0f, 0, -16 / 16f, 2 / 16f, 28 / 16f, 32 / 16f);
    private static final VoxelShape SOUTH_WALL = VoxelShapes.cuboid(-16 / 16f, 0, 0, 32 / 16f, 28 / 16f, 2 / 16f);
    private static final VoxelShape WEST_WALL =  VoxelShapes.cuboid(14 / 16f, 0, -16 / 16f, 16 / 16f, 28 / 16f, 32 / 16f);
    public Boolean check;
    public NbtCompound cpd = new NbtCompound();


    public DexMapBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(FACING, Direction.NORTH));
    }



    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return super.getPlacementState(ctx);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        assert placer != null;
        world.setBlockState(pos, state.with(HorizontalFacingBlock.FACING, placer.getHorizontalFacing().getOpposite()));
        super.onPlaced(world, pos, state, placer, itemStack);
    }

    public VoxelShape getShape(BlockState state) {
        Direction direction = state.get(FACING);
        switch(direction){
            case NORTH -> {
                return NORTH_WALL;
            }

            case EAST -> {
                return EAST_WALL;
            }

            case SOUTH -> {
                return SOUTH_WALL;
            }
            case WEST -> {
                return WEST_WALL;
            }
            default -> {
                return null;
            }
        }

    }


    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return this.getShape(state);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        DexMapBlockEntity map = (DexMapBlockEntity) world.getBlockEntity(pos);
        NbtCompound nbtCompound;
        ItemStack stack = player.getStackInHand(hand);
        if (map instanceof DexMapBlockEntity) {
            if (stack.isOf(ModItems.DEXREWARD25)) {
                check = map.tokenMutable.get(1);
                if (!check) {
                    map.tokenMutable.set(1, true);
                    map.setStack(0, stack);
                    stack.damage(1, player, player1 -> player1.sendToolBreakStatus(hand));
                    world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_HARP.value(), SoundCategory.BLOCKS, 1f, 1f);
                    markDirty();
                    return ActionResult.SUCCESS;
                }
            } else if (stack.isOf(ModItems.DEXREWARD50)) {
                check = map.tokenMutable.get(2);
                if (!check) {
                    map.tokenMutable.set(2, true);
                    map.setStack(1, stack);
                    stack.damage(1, player, player1 -> player1.sendToolBreakStatus(hand));
                    world.playSound(player, pos, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.BLOCKS);
                    markDirty();
                    return ActionResult.SUCCESS;
                }
            } else if (stack.isOf(ModItems.DEXREWARD75)) {
                check = map.tokenMutable.get(3);
                if (!check) {
                    map.tokenMutable.set(3, true);
                    map.setStack(2, stack);
                    stack.damage(1, player, player1 -> player1.sendToolBreakStatus(hand));
                    world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_BASEDRUM.value(), SoundCategory.BLOCKS);
                    markDirty();
                    return ActionResult.SUCCESS;
                }
            } else if (stack.isOf(ModItems.DEXREWARD100)) {
                check = map.tokenMutable.get(4);
                if (!check) {
                    map.tokenMutable.set(4, true);
                    map.setStack(3, stack);
                    stack.damage(1, player, player1 -> player1.sendToolBreakStatus(hand));
                    world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_BANJO.value(), SoundCategory.BLOCKS);
                    map.markDirty();
                    markDirty();
                    return ActionResult.SUCCESS;
                }
            } else if (stack.isOf(ModItems.DEXREWARDKANTO)) {
                check = map.tokenMutable.get(5);
                if (!check) {
                    map.tokenMutable.set(5, true);
                    map.setStack(4, stack);
                    stack.damage(1, player, player1 -> player1.sendToolBreakStatus(hand));
                    world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_COW_BELL.value(), SoundCategory.BLOCKS);
                    markDirty();
                    return ActionResult.SUCCESS;
                }
            } else if (stack.isOf(ModItems.DEXREWARDJOHTO)) {
                check = map.tokenMutable.get(6);
                if (!check) {
                    map.tokenMutable.set(6, true);
                    map.setStack(5, stack);
                    stack.damage(1, player, player1 -> player1.sendToolBreakStatus(hand));
                    world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_DIDGERIDOO.value(), SoundCategory.BLOCKS);
                    markDirty();
                    return ActionResult.SUCCESS;
                }
            } else if (stack.isOf(ModItems.DEXREWARDHOENN)) {
                check = map.tokenMutable.get(7);
                if (!check) {
                    map.tokenMutable.set(7, true);
                    map.setStack(6, stack);
                    stack.damage(1, player, player1 -> player1.sendToolBreakStatus(hand));
                    world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_FLUTE.value(), SoundCategory.BLOCKS);
                    markDirty();
                    return ActionResult.SUCCESS;
                }
            } else if (stack.isOf(ModItems.DEXREWARDSINNOH)) {
                check = map.tokenMutable.get(8);
                if (!check) {
                    map.tokenMutable.set(8, true);
                    map.setStack(7, stack);
                    stack.damage(1, player, player1 -> player1.sendToolBreakStatus(hand));
                    world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_GUITAR.value(), SoundCategory.BLOCKS);
                    markDirty();
                    return ActionResult.SUCCESS;
                }
            } else if (stack.isOf(ModItems.DEXREWARDUNOVA)) {
                check = map.tokenMutable.get(9);
                if (!check) {
                    map.tokenMutable.set(9, true);
                    map.setStack(8, stack);
                    stack.damage(1, player, player1 -> player1.sendToolBreakStatus(hand));
                    world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_HAT.value(), SoundCategory.BLOCKS);
                    markDirty();
                    return ActionResult.SUCCESS;
                }
            } else if (stack.isOf(ModItems.DEXREWARDKALOS)) {
                check = map.tokenMutable.get(10);
                if (!check) {
                    map.tokenMutable.set(1, true);
                    map.setStack(9, stack);
                    stack.damage(10, player, player1 -> player1.sendToolBreakStatus(hand));
                    world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_PLING.value(), SoundCategory.BLOCKS);
                    markDirty();
                    return ActionResult.SUCCESS;
                }
            } else if (stack.isOf(ModItems.DEXREWARDALOLA)) {
                check = map.tokenMutable.get(11);
                if (!check) {
                    map.tokenMutable.set(11, true);
                    map.setStack(10, stack);
                    stack.damage(1, player, player1 -> player1.sendToolBreakStatus(hand));
                    world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_BIT.value(), SoundCategory.BLOCKS);
                    markDirty();
                    return ActionResult.SUCCESS;
                }
            } else if (stack.isOf(ModItems.DEXREWARDGALAR)) {
                check = map.tokenMutable.get(12);
                if (!check) {
                    map.tokenMutable.set(12, true);
                    map.setStack(11, stack);
                    stack.damage(1, player, player1 -> player1.sendToolBreakStatus(hand));
                    world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_SNARE.value(), SoundCategory.BLOCKS);
                    return ActionResult.SUCCESS;
                }
            } else if (stack.isOf(ModItems.DEXREWARDPALDEA)) {
                check = map.tokenMutable.get(13);
                if (!check) {
                    map.tokenMutable.set(13, true);
                    map.setStack(12, stack);
                    stack.damage(1, player, player1 -> player1.sendToolBreakStatus(hand));
                    world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_IRON_XYLOPHONE.value(), SoundCategory.BLOCKS);
                    markDirty();
                    return ActionResult.SUCCESS;
                }
            }
            map.markDirty();
        }
        return ActionResult.PASS;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    //the below is serviceable, but use the Custom Items class version to ensure tooltip translates with everything else
    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.literal("A beautifully hand-drawn map of the world designed for you to track Pokédex completion progress"));
        super.appendTooltip(stack, world, tooltip, options);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(HorizontalFacingBlock.FACING);

    }

    public List<ItemStack> getRenderStacks(){
        return List.of(this.getStack(0), this.getStack(1), this.getStack(2),
                this.getStack(3), this.getStack(4), this.getStack(5), this.getStack(6),
                this.getStack(7), this.getStack(8), this.getStack(9), this.getStack(10),
                this.getStack(11), this.getStack(12));
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof DexMapBlockEntity) {
                ItemScatterer.spawn(world, pos, (DexMapBlockEntity  )blockEntity);
                world.updateComparators(pos,this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }


    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new DexMapBlockEntity(pos, state);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return null;
    }

    @Override
    public ItemStack getStack(int slot) {
        return ImplementedInventory.super.getStack(slot);
    }
}


