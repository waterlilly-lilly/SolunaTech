package dev.waterlilly.soluna.core.block.entity

import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.enchantment.EnchantmentHelper.createNbt
import net.minecraft.nbt.NbtCompound
import net.minecraft.network.Packet
import net.minecraft.network.listener.ClientPlayPacketListener
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.world.World
import team.reborn.energy.api.base.SimpleEnergyStorage


class ExamplePowerSinkMachineBlockEntity(pos: BlockPos?, state: BlockState?) : ElectricMachineBlockEntity(SolunaCoreBlockEntityTypes.EXAMPLE_POWER_SINK_MACHINE, pos, state, 4.5f, 5.5f, 5){
    override fun tick(world: World, pos: BlockPos, state: BlockState) {
        super.tick(world, pos, state)
        if(tryConsumeEnergy(5)) {
            world.setBlockState(pos.offset(Direction.UP), Blocks.GLOWSTONE.defaultState)
        } else {
            world.setBlockState(pos.offset(Direction.UP), Blocks.REDSTONE_BLOCK.defaultState)
        }
    }
}
