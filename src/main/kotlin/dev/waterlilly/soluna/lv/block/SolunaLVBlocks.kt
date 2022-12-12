package dev.waterlilly.soluna.lv.block

import dev.waterlilly.soluna.Modules
import dev.waterlilly.soluna.core.util.initializers.AbstractBlockInitializer
import dev.waterlilly.soluna.lv.block.entity.SolunaLVBlockEntityTypes
import net.minecraft.block.Block
import net.minecraft.block.Material
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings

object SolunaLVBlocks : AbstractBlockInitializer(Modules.LV) {
    val LIGHT_BULB = register("light_bulb", LightBulbBlock())
    override fun init() {
        SolunaLVBlockEntityTypes.init()
    }
}
