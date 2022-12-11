package dev.waterlilly.soluna.core.block.machine

import dev.waterlilly.soluna.core.block.AbstractMachineBlock
import dev.waterlilly.soluna.core.block.entity.AbstractMachineBlockEntity
import dev.waterlilly.soluna.core.block.entity.ExamplePowerSinkMachineBlockEntity
import dev.waterlilly.soluna.core.block.entity.SolunaCoreBlockEntityTypes
import net.minecraft.block.BlockRenderType
import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.block.Material
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityTicker
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings

class ExamplePowerSinkMachine() : AbstractMachineBlock(QuiltBlockSettings.of(Material.METAL)) {
    override fun createBlockEntity(pos: BlockPos?, state: BlockState?) = ExamplePowerSinkMachineBlockEntity(pos, state)


}
