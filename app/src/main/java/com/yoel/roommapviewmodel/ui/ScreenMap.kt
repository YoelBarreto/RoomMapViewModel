package com.yoel.roommapviewmodel.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.utsman.osmandcompose.DefaultMapProperties
import com.utsman.osmandcompose.Marker
import com.utsman.osmandcompose.OpenStreetMap
import com.utsman.osmandcompose.ZoomButtonVisibility
import com.utsman.osmandcompose.rememberCameraState
import com.utsman.osmandcompose.rememberMarkerState
import org.osmdroid.tileprovider.tilesource.XYTileSource
import org.osmdroid.util.GeoPoint
import org.osmdroid.util.MapTileIndex
import viewmodel.MarKViewModel

val GoogleSat = object : XYTileSource(
    "Google-Sat",
    0, 19, 256, ".png", arrayOf(
        "https://mt0.google.com",
        "https://mt1.google.com",
        "https://mt2.google.com",
        "https://mt3.google.com"
    )
) {
    override fun getTileURLString(pTileIndex: Long): String {
        return baseUrl + "/vt/lyrs=s&x=" + MapTileIndex.getX(pTileIndex) + "&y=" + MapTileIndex.getY(
            pTileIndex) + "&z=" + MapTileIndex.getZoom(pTileIndex)
    }
}

@Composable
fun ScreenMap(modifier: Modifier = Modifier, viewmodel : MarKViewModel) {

    val marksWithTypes by viewmodel.marksWithTypes.collectAsState(initial = emptyList())

    // Posición inicial
    val cameraState = rememberCameraState {
        geoPoint = GeoPoint(28.95739300474134, -13.554483241074891)
        zoom = 17.0 // optional, default is 5.0
    }
    // define properties with remember with default value
    var mapProperties by remember {
        mutableStateOf(DefaultMapProperties)
    }

    SideEffect {
        mapProperties = mapProperties
            //.copy(isTilesScaledToDpi = true)
            .copy(tileSources = GoogleSat)
            .copy(isEnableRotationGesture = true)
            .copy(zoomButtonVisibility = ZoomButtonVisibility.NEVER)
    }
    OpenStreetMap(
        modifier = Modifier.fillMaxSize(),
        cameraState = cameraState,
        properties = mapProperties // add properties
    ) {

        marksWithTypes.forEach { markWithType ->
            val mark = markWithType.task
            val typeMark = markWithType.typeTask[0]

            val markerState = rememberMarkerState(
                geoPoint = GeoPoint(markWithType.task.x, markWithType.task.y)
            )

            Marker(
                state = markerState, // add marker state
                title = mark.name,
                snippet = typeMark.name
            ) {
                Column(
                    modifier = Modifier
                        .size(100.dp)
                        .background(color = Color.Black, shape = RoundedCornerShape(7.dp)),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        Text(text = it.title, fontWeight = FontWeight.Bold, color = Color.White)
                        Text(
                            text = it.snippet,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}