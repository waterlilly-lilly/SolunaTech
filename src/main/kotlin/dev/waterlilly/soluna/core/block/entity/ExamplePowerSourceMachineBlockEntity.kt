package dev.waterlilly.soluna.core.block.entity

import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import team.reborn.energy.api.base.SimpleEnergyStorage

class ExamplePowerSourceMachineBlockEntity(pos: BlockPos?, state: BlockState?) : AbstractMachineBlockEntity(SolunaCoreBlockEntityTypes.EXAMPLE_POWER_SOURCE_MACHINE, pos, state) {
    override fun tick(world: World, pos: BlockPos, state: BlockState) {
        println("also test")

    }
}
