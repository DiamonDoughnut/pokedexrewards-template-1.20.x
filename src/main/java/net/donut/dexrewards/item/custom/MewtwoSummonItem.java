package net.donut.dexrewards.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

import java.util.Set;
//set up item in custom class so it can do more than just exist
public class MewtwoSummonItem extends Item {
    public MewtwoSummonItem(Settings settings) {
        super(settings);
    }
//use an override ActionResult to give an event when item is interacted with in choice of manner
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        //use first if statement to guarantee code is run on server to prevent breaking things
        if(!context.getWorld().isClient()) {
            //create necessary variables for intended item usage
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            Boolean foundBlock = false;

            //metal detector script runs iterations for 64 layers, breaking at the first detection if any

            for(int i = 0; i <=positionClicked.getY() + 64; i++) {
                BlockState state = context.getWorld().getBlockState(positionClicked.down(i));
                //call to function described lower in class: if text is red, hover over and click to create
                if(isValuableBlock(state)) {
                    //use function to return values to variables needed for final output
                    outputValuableCoordinates(positionClicked.down(i), player, state.getBlock());
                    //break the loop once first item found
                    foundBlock = true;
                    break;
                }
            }
            //give output if item not found in 64 iterations
            if(!foundBlock) {
                player.sendMessage(Text.literal("No Valuables Found!"));
            }
        }
        //damage item by 1 on use
        context.getStack().damage(1, context.getPlayer(), playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));
        //give player hand animation when action is properly executed - regardless of function outcome
        return ActionResult.SUCCESS;
    }
    //function to print message to player relaying the detected variables in a readable format
    private void outputValuableCoordinates(BlockPos blockPos, PlayerEntity player, Block block) {
        player.sendMessage(Text.literal("Found " + block.asItem().getName().getString() + " at " + "(" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"), false);
    }
    //Boolean returns true if either statement after 'return' is true, then feeds answer into loop above
    private boolean isValuableBlock(BlockState state) {
        return state.isOf(Blocks.IRON_ORE) || state.isOf(Blocks.DIAMOND_ORE);
    }
}
