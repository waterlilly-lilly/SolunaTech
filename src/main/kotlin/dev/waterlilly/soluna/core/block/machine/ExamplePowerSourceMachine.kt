package dev.waterlilly.soluna.core.block.machine

import dev.waterlilly.soluna.core.block.AbstractMachineBlock
import dev.waterlilly.soluna.core.block.entity.ExamplePowerSourceMachineBlockEntity
import net.minecraft.block.BlockState
import net.minecraft.block.Material
import net.minecraft.util.math.BlockPos
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings

class ExamplePowerSourceMachine : AbstractMachineBlock(QuiltBlockSettings.of(Material.METAL)) {
    override fun createBlockEntity(pos: BlockPos?, state: BlockState?) =
        ExamplePowerSourceMachineBlockEntity(pos, state)
}
