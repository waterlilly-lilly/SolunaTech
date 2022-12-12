package dev.waterlilly.soluna.core.block.entity

import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.block.entity.BlockEntity
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.world.World
import team.reborn.energy.api.base.SimpleEnergyStorage

class ExamplePowerSourceMachineBlockEntity(pos: BlockPos?, state: BlockState?) : ElectricMachineBlockEntity(SolunaCoreBlockEntityTypes.EXAMPLE_POWER_SOURCE_MACHINE, pos, state, 4.5f, 5.5f, 20) {
    override fun tick(world: World, pos: BlockPos, state: BlockState) {
        super.tick(world, pos, state)
        if(world.isReceivingRedstonePower(pos)) {
            tryProduceEnergy(20)
        }
    }
}
