package dev.waterlilly.soluna.core.block.machine

import dev.waterlilly.soluna.core.block.AbstractMachineBlock
import dev.waterlilly.soluna.core.block.entity.ExamplePowerSinkMachineBlockEntity
import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.util.math.BlockPos
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings

class ExamplePowerSinkMachine() : AbstractMachineBlock(QuiltBlockSettings.copyOf(Blocks.BLAST_FURNACE)) {
    override fun createBlockEntity(pos: BlockPos?, state: BlockState?) = ExamplePowerSinkMachineBlockEntity(pos, state)
}
