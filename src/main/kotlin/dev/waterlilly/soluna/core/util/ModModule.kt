package dev.waterlilly.soluna.core.util

import net.minecraft.util.Identifier
import org.slf4j.Logger

/**
 * Represents a module of this mod.
 */
interface ModModule {
    /**
     * The identifier of this module.
     */
    val id: Identifier

    /**
     * A logger for this module to use.
     */
    val logger: Logger

    /**
     * Whether this module is enabled. If it's disabled, it won't be loaded.
     */
    val enabled: Boolean

    /**
     * Creates an identifier for a block/item/etc contained within this module.
     */
    fun identifier(path: String) = Identifier(id.namespace, id.path + "/" + path)

    /**
     * Initializer for the module.
     */
    fun init()
}
