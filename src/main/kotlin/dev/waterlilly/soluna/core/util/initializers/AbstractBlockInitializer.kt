package dev.waterlilly.soluna.core.util.initializers

import dev.waterlilly.soluna.core.util.ModModule
import net.minecraft.block.Block
import net.minecraft.client.MinecraftClient
import net.minecraft.client.render.RenderLayer
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import org.quiltmc.qsl.block.extensions.api.client.BlockRenderLayerMap

abstract class AbstractBlockInitializer(protected val module: ModModule) {
    fun register(path: String, block: Block): Block? {
        if (!module.enabled) return null
        if (MinecraftClient.getInstance() != null) {
            BlockRenderLayerMap.put(RenderLayer.getCutout(), block)
        }
        module.logger.debug("Register block " + module.identifier(path))
        return Registry.register(Registries.BLOCK, module.identifier(path), block)
    }

    abstract fun init()
}
