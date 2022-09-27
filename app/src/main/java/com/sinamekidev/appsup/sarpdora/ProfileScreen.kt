package com.sinamekidev.appsup.sarpdora

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sinamekidev.appsup.R


@Composable
fun ProfileScreen(){
    Surface(modifier = Modifier.fillMaxSize(), color = SecondBg) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)) {
            SharePost()
        }
    }
}

@Composable
fun SharePost(){
    var isWriting = remember {
        mutableStateOf(false)
    }
    var postText = remember {
        mutableStateOf("")
    }
    Surface(shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.24f)
            .padding(9.dp), color = Color(0xFF420D24)
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(9.dp)) {
            Row(modifier = Modifier.fillMaxWidth()) {
                TextField(value =postText.value , onValueChange = {
                    postText.value = it
                }, label = {
                        Row {
                            Image(painter = painterResource(id = R.drawable.profile), contentDescription = "",
                                modifier = Modifier.size(52.dp))
                            Spacer(modifier = Modifier.width(15.dp))
                            Text(text = "Share your comments...", color = Color(0xFF696969), fontSize = 20.sp)
                        }
                }, colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent), singleLine = false,
                modifier = Modifier.fillMaxSize())
            }

        }
    }
}

@Preview
@Composable
fun PreviewProfileScreen(){
    ProfileScreen()
}