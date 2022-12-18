package dev.waterlilly.soluna.core.block.entity

import dev.waterlilly.soluna.Modules
import dev.waterlilly.soluna.core.block.SolunaCoreBlocks
import dev.waterlilly.soluna.core.util.initializers.AbstractBlockEntityTypeInitializer
import org.quiltmc.qsl.block.entity.api.QuiltBlockEntityTypeBuilder

object SolunaCoreBlockEntityTypes : AbstractBlockEntityTypeInitializer(Modules.CORE) {
    val EXAMPLE_POWER_SINK_MACHINE = register(
        "example_power_sink",
        QuiltBlockEntityTypeBuilder.create(
            { pos, state -> ExamplePowerSinkMachineBlockEntity(pos, state) },
            SolunaCoreBlocks.EXAMPLE_POWER_SINK_MACHINE
        )
    )
    val EXAMPLE_POWER_SOURCE_MACHINE = register(
        "example_power_source",
        QuiltBlockEntityTypeBuilder.create(
            { pos, state -> ExamplePowerSourceMachineBlockEntity(pos, state) },
            SolunaCoreBlocks.EXAMPLE_POWER_SOURCE_MACHINE
        )
    )

    fun init() {}
}
