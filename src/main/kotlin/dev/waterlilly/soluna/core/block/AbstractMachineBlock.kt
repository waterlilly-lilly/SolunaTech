package dev.waterlilly.soluna.core.block

import net.minecraft.block.*
import net.minecraft.item.ItemPlacementContext
import net.minecraft.state.StateManager
import net.minecraft.state.property.Properties
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.util.shape.VoxelShape
import net.minecraft.util.shape.VoxelShapes
import net.minecraft.world.BlockView

abstract class AbstractMachineBlock(settings: Settings)
    : HorizontalFacingBlock(settings), BlockEntityProvider {
    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>?) {
        builder?.add(Properties.HORIZONTAL_FACING)
    }

    override fun getOutlineShape(
        state: BlockState?,
        world: BlockView?,
        pos: BlockPos?,
        context: ShapeContext?
    ) = VoxelShapes.fullCube()
    override fun getPlacementState(ctx: ItemPlacementContext?): BlockState? {
        return defaultState.with(Properties.HORIZONTAL_FACING, ctx!!.playerFacing.opposite)
    }
}
