package com.paulo.uicomposes.youtube_tutorial

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.paulo.uicomposes.R


@Composable
fun Profile() {

    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Card(
            elevation = 8.dp,
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier
                .border(width = 2.dp, color = Color.Red, shape = RoundedCornerShape(30.dp))
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState() )
            ) {
                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ){
                    IconButton(onClick = {  },
                        modifier = Modifier
                            .clip(CircleShape)
                            .border(1.dp, Color.Red)
                    ) {
                        Icon(Icons.Default.Home, contentDescription = "content description",tint = Color.Red)
                    }
                }


                Image(
                    painter = painterResource(id = R.drawable.cooking),
                    contentDescription = "desc",
                    modifier = Modifier
                        .size(180.dp)
                        .clip(CircleShape)
                        .border(
                            width = 2.dp, color = Color.Red,
                            shape = CircleShape
                        ),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "Hola que tal",
                    fontSize = 15.sp,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                )
                Text(
                    text = "matando o que te mata",
                    fontSize = 12.sp,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
                Divider(
                    modifier =  Modifier.padding(10.dp)
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {
                    TwoLine(number = "150", title = "Followers")
                    TwoLine(number = "100", title = "Following")
                    TwoLine(number = "30", title = "Posts")
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {
                    IconButton(onClick = {  },
                        modifier = Modifier
                            .clip(CircleShape)
                            .border(1.dp, Color.Red)
                    ) {
                        Icon(Icons.Default.Add, contentDescription = "content description",tint = Color.Red)
                    }
                    IconButton(onClick = {  },
                        modifier = Modifier
                            .clip(CircleShape)
                            .border(1.dp, Color.Black)
                    ) {
                        Icon(Icons.Default.Remove, contentDescription = "content description",tint = Color.Red)
                    }
                }
            }
        }

    }

}

@Composable
fun TwoLine(number: String, title: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = number,
            color = Color.Red,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            modifier = Modifier.padding(5.dp)
        )
        Text(
            text = title,
            fontStyle = FontStyle.Italic,
            maxLines = 1,
            modifier = Modifier.padding(5.dp)
        )
    }

}

@Composable
fun MyApp() {
    Text(
        text = "Rango Rango",
        fontSize = 35.sp,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        textDecoration = TextDecoration.LineThrough,
        maxLines = 1,
        modifier = Modifier.padding(10.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Profile()
}