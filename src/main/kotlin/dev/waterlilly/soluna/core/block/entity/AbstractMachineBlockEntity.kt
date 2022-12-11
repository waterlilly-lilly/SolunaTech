package dev.waterlilly.soluna.core.block.entity

import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.nbt.NbtCompound
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import team.reborn.energy.api.base.SimpleEnergyStorage

abstract class AbstractMachineBlockEntity(type: BlockEntityType<*>?, pos: BlockPos?, state: BlockState?) : BlockEntity(type, pos, state) {
    abstract fun tick(world: World, pos: BlockPos, state: BlockState)
    override fun writeNbt(nbt: NbtCompound?) {
        super.writeNbt(nbt)
    }

    override fun readNbt(nbt: NbtCompound?) {
        super.readNbt(nbt)
    }

}
