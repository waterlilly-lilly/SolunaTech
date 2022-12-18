package dev.waterlilly.soluna.core.util

import com.google.common.graph.ImmutableValueGraph
import com.google.common.graph.ValueGraphBuilder
import net.minecraft.util.math.BlockPos

object PathfindingUtil {
    fun genGraph(entry: BlockPos): ImmutableValueGraph<BlockPos, UInt> {
        val builder = ValueGraphBuilder.directed().immutable<BlockPos, UInt>()

        return builder.build()
    }
}
