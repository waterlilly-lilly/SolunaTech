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


class ExamplePowerSinkMachineBlockEntity(pos: BlockPos?, state: BlockState?) : AbstractMachineBlockEntity(SolunaCoreBlockEntityTypes.EXAMPLE_POWER_SINK_MACHINE, pos, state){
    override fun tick(world: World, pos: BlockPos, state: BlockState) {
        world.setBlockState(pos.offset(Direction.UP), Blocks.STONE.defaultState)

    }
    override fun toUpdatePacket(): Packet<ClientPlayPacketListener?>? {
        return BlockEntityUpdateS2CPacket.of(this)
    }
}
