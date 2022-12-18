package dev.waterlilly.soluna.core.util.initializers

import dev.waterlilly.soluna.core.util.ModModule
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry

abstract class AbstractItemInitializer(protected val module: ModModule) {
    abstract val ITEM_GROUP: ItemGroup
    fun register(path: String, item: Item): Item? {
        if (!module.enabled) return null
        module.logger.debug("Register block " + module.identifier(path))
        ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP).register { content -> content.addItem(item) }
        return Registry.register(Registries.ITEM, module.identifier(path), item)
    }

    fun init() {}
}
