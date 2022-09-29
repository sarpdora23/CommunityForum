package com.sinamekidev.appsup.onuralan

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextLayoutInput
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sinamekidev.appsup.ui.theme.Purple200
import com.sinamekidev.appsup.ui.theme.Purple500

var text = ""

@Composable
fun ForumScreen(){
    Surface(modifier = Modifier.fillMaxSize(), color = Color(0XFF202124)) {
        Column(
            Modifier
                .fillMaxWidth()) {
            TopBar()
            
        }
        
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(top = 80.dp, bottom = 30.dp, start = 15.dp, end = 15.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            TxtField()
            Spacer(modifier = Modifier.height(30.dp))


        }


    }

}

@Composable
@Preview(showSystemUi = true)
fun ForumScreenTest(){
    ForumScreen()
}
@Composable
fun TopBar(){
    TopAppBar(modifier = Modifier.fillMaxWidth().height(60.dp), backgroundColor = Color.Transparent, elevation = 5.dp, ) {

    }

}
@Composable
fun TxtField(){
    TextField(
        value = text,
        onValueChange = {
            text = it
        },
        modifier = Modifier.border(
            BorderStroke(
                width = 4.dp,
                brush = Brush.horizontalGradient(listOf(Purple200, Purple500))
            ),
            shape = RoundedCornerShape(50)
        ),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        trailingIcon = {
            Icon(Icons.Default.Search, contentDescription ="Search Icon", tint = blueLike  )

        },

    )
}

