package dev.waterlilly.soluna.core.util

import net.minecraft.util.Identifier
import org.slf4j.Logger

interface ModModule {
    val id: String
    val logger: Logger
    val enabled: Boolean
    fun identifier(path: String): Identifier
    fun init()
}
