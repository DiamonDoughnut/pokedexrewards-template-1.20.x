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

public class DexMapBlock extends BlockWithEntity implements BlockEntityProvider {
    private static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    private static final VoxelShape NORTH_WALL = VoxelShapes.cuboid(-1f, 0, 0.875f, 2f, 1.75f, 1f);
    private static final VoxelShape EAST_WALL = VoxelShapes.cuboid(0f, 0, -1f, 0.125f, 1.75f, 2f);
    private static final VoxelShape SOUTH_WALL = VoxelShapes.cuboid(-1f, 0, 0, 2f, 1.75f, 0.125f);
    private static final VoxelShape WEST_WALL =  VoxelShapes.cuboid(0.875f, 0, -1f, 1f, 1.75f, 2f);
    public Boolean check;


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
        ItemStack stack = player.getStackInHand(hand);
        if (map instanceof DexMapBlockEntity) {
            for(int i = 0; i <= 12; i++){
                if (stack.isOf(map.list[i])) {
                    check = map.getStack(i).isEmpty();
                    if (!check) {
                        map.modifyInventory(i, stack);
                        stack.damage(1, player, player1 -> player1.sendToolBreakStatus(hand));
                        world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_HARP.value(), SoundCategory.BLOCKS, 1f, 1f);
                        map.markDirty();
                        return ActionResult.SUCCESS;
                    }
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

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof DexMapBlockEntity) {
                ItemScatterer.spawn(world, pos, (DexMapBlockEntity)blockEntity);
                world.updateComparators(pos,this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }


    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new DexMapBlockEntity(pos, state);
    }

}


