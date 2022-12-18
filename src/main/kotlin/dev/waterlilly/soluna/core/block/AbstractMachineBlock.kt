package dev.waterlilly.soluna.core.block

import dev.waterlilly.soluna.core.block.entity.AbstractMachineBlockEntity
import net.minecraft.block.*
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityTicker
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.item.ItemPlacementContext
import net.minecraft.state.StateManager
import net.minecraft.state.property.Properties
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.util.shape.VoxelShapes
import net.minecraft.world.BlockView
import net.minecraft.world.World
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings

abstract class AbstractMachineBlock(settings: QuiltBlockSettings) : BlockWithEntity(settings) {
    init {
        defaultState = this.stateManager.defaultState.with(Properties.HORIZONTAL_FACING, Direction.NORTH)
    }

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

    override fun getRenderType(state: BlockState?): BlockRenderType = BlockRenderType.MODEL
    override fun <T : BlockEntity?> getTicker(
        world: World?,
        state: BlockState?,
        type: BlockEntityType<T>?
    ): BlockEntityTicker<T>? {
        return BlockEntityTicker { world, pos, state, be ->
            (be as AbstractMachineBlockEntity).tick(
                world,
                pos,
                state
            )
        }
    }
}
