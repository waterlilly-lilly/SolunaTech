package dev.waterlilly.soluna.lv.item

import dev.waterlilly.soluna.Modules
import dev.waterlilly.soluna.core.util.initializers.AbstractItemInitializer
import dev.waterlilly.soluna.lv.block.SolunaLVBlocks
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.BlockItem
import net.minecraft.item.ItemGroup
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings

object SolunaLVItems : AbstractItemInitializer(Modules.LV) {
    override val ITEM_GROUP = FabricItemGroup.builder(module.id).m_kdtuovgn { LIGHT_BULB?.defaultStack }.m_fepxguyf()

    val LIGHT_BULB = register("light_bulb", BlockItem(SolunaLVBlocks.LIGHT_BULB, QuiltItemSettings()))
}
