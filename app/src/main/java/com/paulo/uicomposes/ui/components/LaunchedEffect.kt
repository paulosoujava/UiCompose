package com.paulo.uicomposes.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun LaunchedEffect() {
    val state = rememberLazyListState()
    LaunchedEffect(key1 = Unit, block = {
        delay(2000)
        state.animateScrollToItem(1000)
    })

    LazyColumn(
        state = state,
        modifier = Modifier.padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        items(2000){ index ->
            Card(backgroundColor = Color(0xFF98c9F0), elevation = 12.dp) {
                Box(modifier = Modifier.fillMaxWidth().height(150.dp), Alignment.Center){
                    Text(text = "${index + 1}", style = MaterialTheme.typography.h2)
                }
            }
        }
    }
}