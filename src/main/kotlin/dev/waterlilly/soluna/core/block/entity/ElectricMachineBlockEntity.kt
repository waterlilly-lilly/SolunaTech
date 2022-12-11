package dev.waterlilly.soluna.core.block.entity

import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction
import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.nbt.NbtCompound
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.world.World
import team.reborn.energy.api.EnergyStorage
import team.reborn.energy.api.EnergyStorageUtil
import team.reborn.energy.api.base.SimpleEnergyStorage

abstract class ElectricMachineBlockEntity(type: BlockEntityType<*>?, pos: BlockPos?, state: BlockState?, voltageMin: Float, voltageMax: Float, val maxmA: Long) :
    AbstractMachineBlockEntity(type, pos, state) {
    val energyStorage: SimpleEnergyStorage = object : SimpleEnergyStorage(maxmA, maxmA, maxmA) {
        override fun onFinalCommit() {
            super.onFinalCommit()
            markDirty()
        }
    }
    fun getAdjacentPowerSources(): ArrayList<ElectricMachineBlockEntity> {
        val list = arrayListOf<ElectricMachineBlockEntity>()
        for(direction in Direction.values()) {
            val adjacentBlockEntity = world?.getBlockEntity(pos.offset(direction))
            if(adjacentBlockEntity != null && adjacentBlockEntity is ElectricMachineBlockEntity) {
                list.add(adjacentBlockEntity)
            }
        }
        return list
    }
    /**
     * Tries to pull some amount of energy from the grid. Will distribute evenly between all adjacent power sources.
     */
    fun tryConsumeEnergy(milliamps: Long): Boolean {
        var milliamps = milliamps
        if(milliamps > maxmA) milliamps = maxmA
        if(energyStorage.amount < milliamps) return false
        energyStorage.amount -= milliamps
        return true
    }
    fun tryProduceEnergy(milliamps: Long): Boolean {
        var milliamps = milliamps
        if(milliamps > maxmA) milliamps = maxmA
        energyStorage.amount += milliamps
        val energyStorages = getAdjacentPowerSources().map { be -> be.energyStorage }
        for(storage in energyStorages) {
            EnergyStorageUtil.move(energyStorage, storage, milliamps / energyStorages.size, null)
        }
        return true
    }
    override fun tick(world: World, pos: BlockPos, state: BlockState) {

    }

    override fun readNbt(nbt: NbtCompound?) {
        super.readNbt(nbt)
        energyStorage.amount = nbt?.getLong("energy") ?: 0L
    }

    override fun writeNbt(nbt: NbtCompound?) {
        super.writeNbt(nbt)
        nbt?.putLong("energy", energyStorage.amount)
    }
}

