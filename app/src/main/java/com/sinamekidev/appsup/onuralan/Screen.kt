package com.sinamekidev.appsup.onuralan

import android.widget.ImageView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalTextInputService
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun LoginScreen(){
    var password = ""
    Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFF202124)) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp, bottom = 30.dp, start = 15.dp, end = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Card(
                modifier = Modifier.size(200.dp),
                elevation = 2.dp
            ) {
                Image(
                    painterResource(com.sinamekidev.appsup.R.drawable.logo),
                    contentDescription = "Logo",
                    modifier = Modifier.fillMaxSize()
                )

            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Community For Edu",
                color = Color(0xFFd92643),
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
                )
            Spacer(modifier = Modifier.height(30.dp))
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Outlined.Email, contentDescription ="Email", tint = Color(0xFFAE7CD1),
                    modifier = Modifier.size(25.dp) )
                Spacer(modifier = Modifier.width(5.dp))
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Enter Email", color = Color(0xFFAE7CD1)) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )
            }

            Row(modifier = Modifier.fillMaxWidth().padding(top = 15.dp),
                verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Outlined.AccountBox, contentDescription ="Email", tint = Color(0xFFAE7CD1),
                    modifier = Modifier.size(25.dp) )
                Spacer(modifier = Modifier.width(5.dp))
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Enter Password", color = Color(0xFFAE7CD1)) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )
            }



        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun LoginScreenTest (){
    LoginScreen()
}






