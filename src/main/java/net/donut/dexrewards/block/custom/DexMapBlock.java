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

public class DexMapBlock extends Block{
    private static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    private static final VoxelShape NORTH_WALL = VoxelShapes.cuboid(-16 / 16f, 0, 14 / 16f, 32 / 16f, 28 / 16f, 16 / 16f);
    private static final VoxelShape EAST_WALL = VoxelShapes.cuboid(0f, 0, -16 / 16f, 2 / 16f, 28 / 16f, 32 / 16f);
    private static final VoxelShape SOUTH_WALL = VoxelShapes.cuboid(-16 / 16f, 0, 0, 32 / 16f, 28 / 16f, 2 / 16f);
    private static final VoxelShape WEST_WALL =  VoxelShapes.cuboid(14 / 16f, 0, -16 / 16f, 16 / 16f, 28 / 16f, 32 / 16f);
    public static BooleanProperty KANTO = BooleanProperty.of("kanto");
    public static BooleanProperty JOHTO = BooleanProperty.of("johto");
    public static BooleanProperty HOENN = BooleanProperty.of("hoenn");
    public static BooleanProperty SINNOH = BooleanProperty.of("sinnoh");
    public static BooleanProperty UNOVA = BooleanProperty.of("unova");
    public static BooleanProperty KALOS = BooleanProperty.of("kalos");
    public static BooleanProperty ALOLA = BooleanProperty.of("alola");
    public static BooleanProperty GALAR = BooleanProperty.of("galar");
    public static BooleanProperty PALDEA = BooleanProperty.of("paldea");
    public static BooleanProperty DEX25 = BooleanProperty.of("dex25");
    public static BooleanProperty DEX50 = BooleanProperty.of("dex50");
    public static BooleanProperty DEX75 = BooleanProperty.of("dex75");
    public static BooleanProperty DEX100 = BooleanProperty.of("dex100");
    public static BooleanProperty BASE = BooleanProperty.of("base");


    protected DexMapBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(DEX25, false).with(DEX50, false)
                .with(DEX75, false).with(DEX100, false).with(KANTO, false).with(JOHTO, false)
                .with(HOENN, false).with(SINNOH, false).with(UNOVA, false).with(KALOS, false)
                .with(ALOLA, false).with(GALAR, false).with(PALDEA, false).with(BASE, true));
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
        }
        return null;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return this.getShape(state);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack stack = player.getStackInHand(hand);
        if(stack.isOf(ModItems.DEXREWARD25) && !state.get(DEX25)) {
            world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_HARP.value(), SoundCategory.BLOCKS, 1f, 1f);
            world.setBlockState(pos, state.with(DEX25, true));
        } else if (stack.isOf(ModItems.DEXREWARD50) && !state.get(DEX50)) {
            world.playSound(player, pos, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.BLOCKS);
            world.setBlockState(pos, state.with(DEX50, true));
        } else if (stack.isOf(ModItems.DEXREWARD75) && !state.get(DEX75)) {
            world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_BASEDRUM.value(), SoundCategory.BLOCKS);
            world.setBlockState(pos, state.with(DEX75, true));
        } else if (stack.isOf(ModItems.DEXREWARD100) && !state.get(DEX100)) {
            world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_BANJO.value(), SoundCategory.BLOCKS);
            world.setBlockState(pos, state.with(DEX100, true));
        } else if (stack.isOf(ModItems.DEXREWARDKANTO) && !state.get(KANTO)) {
            world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_COW_BELL.value(), SoundCategory.BLOCKS);
            world.setBlockState(pos, state.with(KANTO, true));
        } else if (stack.isOf(ModItems.DEXREWARDJOHTO) && !state.get(JOHTO)) {
            world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_DIDGERIDOO.value(), SoundCategory.BLOCKS);
            world.setBlockState(pos, state.with(JOHTO, true));
        } else if (stack.isOf(ModItems.DEXREWARDHOENN) && !state.get(HOENN)) {
            world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_FLUTE.value(), SoundCategory.BLOCKS);
            world.setBlockState(pos, state.with(HOENN, true));
        } else if (stack.isOf(ModItems.DEXREWARDSINNOH) && !state.get(SINNOH)) {
            world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_GUITAR.value(), SoundCategory.BLOCKS);
            world.setBlockState(pos, state.with(SINNOH, true));
        } else if (stack.isOf(ModItems.DEXREWARDUNOVA) && !state.get(UNOVA)) {
            world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_HAT.value(), SoundCategory.BLOCKS);
            world.setBlockState(pos, state.with(UNOVA, true));
        } else if (stack.isOf(ModItems.DEXREWARDKALOS) && !state.get(KALOS)) {
            world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_PLING.value(), SoundCategory.BLOCKS);
            world.setBlockState(pos, state.with(KALOS, true));
        } else if (stack.isOf(ModItems.DEXREWARDALOLA) && !state.get(ALOLA)) {
            world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_BIT.value(), SoundCategory.BLOCKS);
            world.setBlockState(pos, state.with(ALOLA, true));
        } else if (stack.isOf(ModItems.DEXREWARDGALAR) && !state.get(GALAR)) {
            world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_SNARE.value(), SoundCategory.BLOCKS);
            world.setBlockState(pos, state.with(GALAR, true));
        } else if (stack.isOf(ModItems.DEXREWARDPALDEA) && !state.get(PALDEA)) {
            world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_IRON_XYLOPHONE.value(), SoundCategory.BLOCKS);
            world.setBlockState(pos, state.with(PALDEA, true));
        }

        return ActionResult.SUCCESS;

    }

    public List<Boolean> getRenderState(BlockState state) {
        List<Boolean> checks = new ArrayList<>(List.of(false, false, false, false, false, false, false, false, false, false, false, false, false));
        List<Property> key= List.of(DEX25, DEX50, DEX75, DEX100, KANTO, JOHTO, HOENN, SINNOH, UNOVA, KALOS, ALOLA, GALAR, PALDEA);
        for(int i = 0; i <= 13; i++){
            if((boolean) state.get(key.get(i))) checks.set(i, true);
            else checks.set(i, false);
        }
        return checks;
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
        builder.add(DEX25);
        builder.add(DEX50);
        builder.add(DEX75);
        builder.add(DEX100);
        builder.add(KANTO);
        builder.add(JOHTO);
        builder.add(HOENN);
        builder.add(SINNOH);
        builder.add(UNOVA);
        builder.add(KALOS);
        builder.add(ALOLA);
        builder.add(GALAR);
        builder.add(PALDEA);
        builder.add(BASE);
    }


    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new DexMapBlockEntity(pos, state);
    }
}


