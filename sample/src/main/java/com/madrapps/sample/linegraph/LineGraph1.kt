package com.madrapps.sample.linegraph

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.madrapps.plot.line.DataPoint
import com.madrapps.plot.line.LineGraph
import com.madrapps.plot.line.LinePlot
import com.madrapps.sample.ui.theme.PlotTheme

@Composable
internal fun LineGraph1(item: List<List<DataPoint>>) {
    LineGraph(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        plot = LinePlot(
            listOf(
                LinePlot.Line(
                    item[0],
                    LinePlot.Connection(Color.Blue, 3.dp),
                    LinePlot.Intersection(Color.Blue, 6.dp),
                    LinePlot.Highlight(Color.Red, 12.dp),
                    LinePlot.AreaUnderLine(Color.Blue, 0.1f)
                ),
                LinePlot.Line(
                    item[1],
                    LinePlot.Connection(Color.Gray, 2.dp),
                    LinePlot.Intersection { center, _ ->
                        val px = 4.dp.toPx()
                        val topLeft = Offset(center.x - px, center.y - px)
                        drawRect(Color.Gray, topLeft, Size(px * 2, px * 2))
                    },
                    LinePlot.Highlight { center ->
                        val px = 4.dp.toPx()
                        val topLeft = Offset(center.x - px, center.y - px)
                        drawRect(Color.Red, topLeft, Size(px * 2, px * 2))
                    },
                ),
            ), LinePlot.Grid(Color.Gray)
        )
    )
}

@Preview(showBackground = true)
@Composable
fun LineGraph1Preview() {
    PlotTheme {
        LineGraph1(listOf(DataPoints.dataPoints1, DataPoints.dataPoints2))
    }
}