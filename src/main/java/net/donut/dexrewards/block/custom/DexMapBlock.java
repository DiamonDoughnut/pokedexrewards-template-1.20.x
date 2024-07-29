package net.donut.dexrewards.block.custom;

import net.donut.dexrewards.block.entities.DexMapBlockEntity;
import net.donut.dexrewards.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.resource.ResourceIndex;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
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

public abstract class DexMapBlock extends BlockWithEntity{



    protected DexMapBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction direction = state.get(HorizontalFacingBlock.FACING);
        return switch (direction) {
            case NORTH -> VoxelShapes.cuboid(-16 / 16f, 0, 14 / 16f, 32 / 16f, 28 / 16f, 16 / 16f);
            case EAST -> VoxelShapes.cuboid(0f, 0, -16 / 16f, 2 / 16f, 28 / 16f, 32 / 16f);
            case SOUTH -> VoxelShapes.cuboid(-16 / 16f, 0, 0, 32 / 16f, 28 / 16f, 2 / 16f);
            case WEST -> VoxelShapes.cuboid(14 / 16f, 0, -16 / 16f, 16 / 16f, 28 / 16f, 32 / 16f);
            default -> VoxelShapes.fullCube();
        };
    }


    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        Set<Integer> tokens = Set.of(0);
        int i = 0;
        ItemStack stack = player.getStackInHand(hand);
        if(stack.isOf(ModItems.DEXREWARD25) && !tokens.contains(1)) {
            world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_HARP.value(), SoundCategory.BLOCKS, 1f, 1f);
            tokens.add(1);
            i++;
        } else if (stack.isOf(ModItems.DEXREWARD50) && !tokens.contains(2)) {
            world.playSound(player, pos, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.BLOCKS);
            tokens.add(2);
            i++;
        } else if (stack.isOf(ModItems.DEXREWARD75) && !tokens.contains(3)) {
            world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_BASEDRUM.value(), SoundCategory.BLOCKS);
            tokens.add(3);
            i++;
        } else if (stack.isOf(ModItems.DEXREWARD100) && !tokens.contains(4)) {
            world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_IRON_XYLOPHONE.value(), SoundCategory.BLOCKS);
            tokens.add(4);
            i++;
        }
        i = tokens.size() - 1;
        //for (int l = 0; l <= i; l++){
        //
        //}
        return ActionResult.SUCCESS;

    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    private static final Map<String, ResourceIndex> LAYERED_LOCATION_CACHE = new HashMap<>();
    private final String[] DexMapOverlayArray = new String[13];

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

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new DexMapBlockEntity(pos, state);
    }
}


