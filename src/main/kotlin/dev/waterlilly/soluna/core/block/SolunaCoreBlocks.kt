package dev.waterlilly.soluna.core.block

import dev.waterlilly.soluna.Modules
import dev.waterlilly.soluna.core.block.machine.ExamplePowerSinkMachine
import dev.waterlilly.soluna.core.block.machine.ExamplePowerSourceMachine
import dev.waterlilly.soluna.core.util.initializers.AbstractBlockInitializer
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings

object SolunaCoreBlocks : AbstractBlockInitializer(Modules.CORE) {
    val TEST_BLOCK = register("test_block", Block(QuiltBlockSettings.copyOf(Blocks.STONE)))
    val EXAMPLE_POWER_SOURCE_MACHINE = register("example_power_source_machine", ExamplePowerSourceMachine())
    val EXAMPLE_POWER_SINK_MACHINE = register("example_power_sink_machine", ExamplePowerSinkMachine())
    override fun init() {

    }
}
