package dev.waterlilly.soluna.lv.block.entity

import dev.waterlilly.soluna.Modules
import dev.waterlilly.soluna.core.util.initializers.AbstractBlockEntityTypeInitializer
import dev.waterlilly.soluna.lv.block.SolunaLVBlocks
import org.quiltmc.qsl.block.entity.api.QuiltBlockEntityTypeBuilder

object SolunaLVBlockEntityTypes : AbstractBlockEntityTypeInitializer(Modules.LV) {
    val LIGHT_BULB = register("light_bulb", QuiltBlockEntityTypeBuilder.create({pos, state -> LightBulbBlockEntity(pos, state)}, SolunaLVBlocks.LIGHT_BULB))
    fun init() {}
}
