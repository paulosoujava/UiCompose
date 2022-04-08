package com.paulo.uicomposes.ui.calendar

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ScrollableColumnDemo() {

    val calendar = remember {
        Mock.get().last() // ultimo ano
    }
    val grouped = calendar.history.groupBy { it.section }
    Surface(color = Color.Gray.copy(alpha = 0.1f)) {
        Column {
            Header(calendar)
            LazyColumn {
                grouped.forEach { (section, sectionTest) ->
                    var (dayOfWeek, numberFormatDayOfWeek) = section.split(" ")
                    stickyHeader {
                        HeaderLeft(dayOfWeek, numberFormatDayOfWeek)
                    }
                    items(
                        items = sectionTest,
                        itemContent = {
                            CardContentCalendar(it)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun Header(history: YearHistory) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        IconButton(onClick = { }
        ) {
            Icon(
                Icons.Default.ChevronLeft,
                contentDescription = "content description",
                tint = Color.Green
            )
        }
        Text(
            text = history.yaer,
            color = Color.Gray,
            fontSize = 16.sp
        )

        IconButton(onClick = {}
        ) {
            Icon(
                Icons.Default.ChevronRight,
                contentDescription = "content description",
                tint = Color.Green
            )
        }
    }
}

@Composable
fun HeaderLeft(dayOfWeek: String, dayInt: String) {
    Column(
        Modifier
            .width(80.dp)
            .height(50.dp)
            .padding(start = 5.dp, top = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = dayOfWeek,
            color = Color.Gray,
            style = MaterialTheme.typography.subtitle2
        )
        Text(
            text = dayInt,
            fontSize = 18.sp,
            style = MaterialTheme.typography.h3
        )
    }

}

@Composable
fun CardContentCalendar(calendar: Test) {
    Column(
        Modifier
            .padding(start = 85.dp, end = 10.dp)
            .offset(y = -(40).dp)
    ) {

        Text(
            text = calendar.hour,
            color = Color.Gray,
            style = MaterialTheme.typography.subtitle2
        )
        Card(
            Modifier
                .fillMaxWidth()
        ) {
            Row(
                Modifier.padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Column {
                    Text(
                        text = "Serviço Solicitado",
                        fontSize = 12.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(bottom = 5.dp)
                    )
                    Text(
                        text = calendar.typeService,
                        fontSize = 16.sp
                    )

                }
                Column {
                    Text(
                        text = "Código do pedido",
                        fontSize = 12.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(bottom = 5.dp)
                    )
                    Text(
                        text = calendar.codeOfType,
                        color = Color.Green
                    )

                }
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
    }
}


