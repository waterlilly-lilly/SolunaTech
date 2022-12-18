package dev.waterlilly.soluna.lv.block.entity

import dev.waterlilly.soluna.core.block.entity.ElectricMachineBlockEntity
import net.minecraft.block.BlockState
import net.minecraft.state.property.Properties
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class LightBulbBlockEntity(pos: BlockPos, state: BlockState) :
    ElectricMachineBlockEntity(SolunaLVBlockEntityTypes.LIGHT_BULB, pos, state, 108.0f, 125.0f, 1) {
    override fun tick(world: World, pos: BlockPos, state: BlockState) {
        super.tick(world, pos, state)
        if (tryConsumeEnergy(1)) {
            world.setBlockState(pos, state.with(Properties.POWERED, true))
        } else {
            world.setBlockState(pos, state.with(Properties.POWERED, false))
        }
    }
}
