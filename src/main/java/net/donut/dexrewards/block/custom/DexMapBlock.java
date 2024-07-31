package net.donut.dexrewards.block.custom;

import net.donut.dexrewards.DexRewards;
import net.donut.dexrewards.block.entities.DexMapBlockEntity;
import net.donut.dexrewards.item.ModItems;
import net.fabricmc.fabric.impl.blockrenderlayer.BlockRenderLayerMapImpl;
import net.fabricmc.fabric.mixin.blockrenderlayer.RenderLayersMixin;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.resource.ResourceIndex;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Property;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.*;

import static org.apache.commons.lang3.ArrayUtils.toArray;

public class DexMapBlock extends BlockWithEntity{
    private static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    private static final VoxelShape NORTH_WALL = VoxelShapes.cuboid(-16 / 16f, 0, 14 / 16f, 32 / 16f, 28 / 16f, 16 / 16f);
    private static final VoxelShape EAST_WALL = VoxelShapes.cuboid(0f, 0, -16 / 16f, 2 / 16f, 28 / 16f, 32 / 16f);
    private static final VoxelShape SOUTH_WALL = VoxelShapes.cuboid(-16 / 16f, 0, 0, 32 / 16f, 28 / 16f, 2 / 16f);
    private static final VoxelShape WEST_WALL =  VoxelShapes.cuboid(14 / 16f, 0, -16 / 16f, 16 / 16f, 28 / 16f, 32 / 16f);
    public Boolean check;
    public boolean[] nbt= new boolean[13];


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
        if(map instanceof DexMapBlockEntity) {
            for(int i = 0; i <= 13; i++){
                map.nbt.putBoolean(map.tokenNames[i], map.tokenCheck[i]);
            }
            if (stack.isOf(ModItems.DEXREWARD25)) {
                check = map.nbt.getBoolean("dex_25");
                if (!check) {
                    map.nbt.putBoolean("dex_25", true);
                    world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_HARP.value(), SoundCategory.BLOCKS, 1f, 1f);
                    map.markDirty();
                    return ActionResult.SUCCESS;
                } else {
                    return ActionResult.PASS;
                }
            } else if (stack.isOf(ModItems.DEXREWARD50)) {
                check = map.nbt.getBoolean("dex_50");
                if (!check) {
                    map.nbt.putBoolean("dex_25", true);
                    world.playSound(player, pos, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.BLOCKS);
                    map.markDirty();
                    return ActionResult.SUCCESS;
                } else {
                    return ActionResult.PASS;
                }
            } else if (stack.isOf(ModItems.DEXREWARD75)) {
                check = map.nbt.getBoolean("dex_75");
                if (!check) {
                    map.nbt.putBoolean("dex_25", true);
                    world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_BASEDRUM.value(), SoundCategory.BLOCKS);
                    map.markDirty();
                    return ActionResult.SUCCESS;
                } else {
                    return ActionResult.PASS;
                }
            } else if (stack.isOf(ModItems.DEXREWARD100)) {
                check = map.nbt.getBoolean("dex_100");
                if (!check) {
                    map.nbt.putBoolean("dex_25", true);
                    world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_BANJO.value(), SoundCategory.BLOCKS);
                    map.markDirty();
                    return ActionResult.SUCCESS;
                } else {
                    return ActionResult.PASS;
                }
            } else if (stack.isOf(ModItems.DEXREWARDKANTO)) {
                check = map.nbt.getBoolean("kanto");
                if (!check) {
                    map.nbt.putBoolean("dex_25", true);
                    world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_COW_BELL.value(), SoundCategory.BLOCKS);
                    map.markDirty();
                    return ActionResult.SUCCESS;
                } else {
                    return ActionResult.PASS;
                }
            } else if (stack.isOf(ModItems.DEXREWARDJOHTO)) {
                check = map.nbt.getBoolean("johto");
                if (!check) {
                    map.nbt.putBoolean("dex_25", true);
                    world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_DIDGERIDOO.value(), SoundCategory.BLOCKS);
                    map.markDirty();
                    return ActionResult.SUCCESS;
                } else {
                    return ActionResult.PASS;
                }
            } else if (stack.isOf(ModItems.DEXREWARDHOENN)) {
                check = map.nbt.getBoolean("hoenn");
                if (!check) {
                    map.nbt.putBoolean("dex_25", true);
                    world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_FLUTE.value(), SoundCategory.BLOCKS);
                    map.markDirty();
                    return ActionResult.SUCCESS;
                } else {
                    return ActionResult.PASS;
                }
            } else if (stack.isOf(ModItems.DEXREWARDSINNOH)) {
                check = map.nbt.getBoolean("sinnoh");
                if (!check) {
                    map.nbt.putBoolean("dex_25", true);
                    world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_GUITAR.value(), SoundCategory.BLOCKS);
                    map.markDirty();
                    return ActionResult.SUCCESS;
                } else {
                    return ActionResult.PASS;
                }
            } else if (stack.isOf(ModItems.DEXREWARDUNOVA)) {
                check = map.nbt.getBoolean("unova");
                if (!check) {
                    map.nbt.putBoolean("dex_25", true);
                    world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_HAT.value(), SoundCategory.BLOCKS);
                    map.markDirty();
                    return ActionResult.SUCCESS;
                } else {
                    return ActionResult.PASS;
                }
            } else if (stack.isOf(ModItems.DEXREWARDKALOS)) {
                check = map.nbt.getBoolean("kalos");
                if (!check) {
                    map.nbt.putBoolean("dex_25", true);
                    world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_PLING.value(), SoundCategory.BLOCKS);
                    map.markDirty();
                    return ActionResult.SUCCESS;
                } else {
                    return ActionResult.PASS;
                }
            } else if (stack.isOf(ModItems.DEXREWARDALOLA)) {
                check = map.nbt.getBoolean("alola");
                if (!check) {
                    map.nbt.putBoolean("dex_25", true);
                    world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_BIT.value(), SoundCategory.BLOCKS);
                    map.markDirty();
                    return ActionResult.SUCCESS;
                } else {
                    return ActionResult.PASS;
                }
            } else if (stack.isOf(ModItems.DEXREWARDGALAR)) {
                check = map.nbt.getBoolean("galar");
                if (!check) {
                    map.nbt.putBoolean("dex_25", true);
                    world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_SNARE.value(), SoundCategory.BLOCKS);
                    map.markDirty();
                    return ActionResult.SUCCESS;
                } else {
                    return ActionResult.PASS;
                }
            } else if (stack.isOf(ModItems.DEXREWARDPALDEA)) {
                check = map.nbt.getBoolean("paldea");
                if (!check) {
                    map.nbt.putBoolean("dex_25", true);
                    world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_IRON_XYLOPHONE.value(), SoundCategory.BLOCKS);
                    map.markDirty();
                    return ActionResult.SUCCESS;
                } else {
                    map.markDirty();
                    return ActionResult.PASS;
                }
            }
        }
        return ActionResult.PASS;

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


    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new DexMapBlockEntity(pos, state);
    }
}


