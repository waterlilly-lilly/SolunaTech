package dev.waterlilly.soluna.lv.block

import dev.waterlilly.soluna.core.block.AbstractMachineBlock
import dev.waterlilly.soluna.lv.block.entity.LightBulbBlockEntity
import net.minecraft.block.*
import net.minecraft.block.enums.WallMountLocation
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.state.StateManager
import net.minecraft.state.property.Properties
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.util.shape.VoxelShape
import net.minecraft.world.BlockView
import net.minecraft.world.World
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings
import kotlin.IllegalStateException

class LightBulbBlock : AbstractMachineBlock(QuiltBlockSettings.of(Material.GLASS)) {
    protected val FLOOR_OUTLINE = createCuboidShape(5.0, 0.0, 5.0, 11.0, 6.0, 11.0)
    protected val CEILING_OUTLINE = createCuboidShape(5.0, 10.0, 5.0, 11.0, 16.0, 11.0)
    protected val EAST_OUTLINE = createCuboidShape(0.0, 5.0, 5.0, 6.0, 11.0, 11.0)
    protected val WEST_OUTLINE = createCuboidShape(10.0, 5.0, 5.0, 16.0, 11.0, 11.0)
    protected val SOUTH_OUTLINE = createCuboidShape(5.0, 5.0, 0.0, 11.0, 11.0, 6.0)
    protected val NORTH_OUTLINE = createCuboidShape(5.0, 5.0, 10.0, 11.0, 11.0, 16.0)
    init {
        defaultState = this.stateManager.defaultState
            .with(Properties.HORIZONTAL_FACING, Direction.NORTH)
            .with(Properties.POWERED, false)
            .with(WallMountedBlock.FACE, WallMountLocation.CEILING)
    }
    override fun createBlockEntity(pos: BlockPos?, state: BlockState?) = LightBulbBlockEntity(pos!!, state!!)
    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>?) {
        builder?.add(Properties.HORIZONTAL_FACING, Properties.POWERED, WallMountedBlock.FACE)
    }

    override fun getRenderType(state: BlockState?): BlockRenderType {
        return BlockRenderType.MODEL
    }

    override fun getOutlineShape(
        state: BlockState?,
        world: BlockView?,
        pos: BlockPos?,
        context: ShapeContext?
    ): VoxelShape {
        return when(state?.get(WallMountedBlock.FACE)) {
            WallMountLocation.CEILING -> CEILING_OUTLINE
            WallMountLocation.FLOOR -> FLOOR_OUTLINE
            WallMountLocation.WALL -> when(state?.get(Properties.HORIZONTAL_FACING)) {
                Direction.NORTH -> NORTH_OUTLINE
                Direction.SOUTH -> SOUTH_OUTLINE
                Direction.EAST -> EAST_OUTLINE
                Direction.WEST -> WEST_OUTLINE
                else -> throw IllegalStateException()
            }
            else -> throw IllegalStateException()
        }
    }
}
