package com.sinamekidev.appsup.onuralan


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.outlined.AccountBox

import androidx.compose.material.icons.outlined.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun LoginScreen(){


    Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFF202124)) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(top = 80.dp, bottom = 30.dp, start = 15.dp, end = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            SignInCard()
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Community For Edu",
                color = Color(0xFFd92643),
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
                )
            Spacer(modifier = Modifier.height(30.dp))

            AccountInfo()

            Column(modifier = Modifier
                .fillMaxSize()
                .padding(top = 30.dp, start = 30.dp, end = 15.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Button(modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp), onClick = {
                    //your onclick code
                },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFd92643)))

                {
                    Text(text = "Sign In",color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                }
                Spacer(modifier = Modifier.height(15.dp))

                Button(modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp), onClick = {
                    //your onclick code
                },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Cyan))

                {
                    Text(text = "Sign In With Huawei Id",color = Color.Black,fontWeight = FontWeight.Bold, fontSize = 18.sp)
                }

                Spacer(modifier = Modifier.height(30.dp))

                Divider(thickness = 2.dp, color = Color.White)

                Column(modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxSize(), horizontalAlignment = Alignment.End) {
                    Text(text = "Don't Have an Account?",color = Color(0xFF64254b),fontWeight = FontWeight.Bold, fontSize = 18.sp)


                }

            }










        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun LoginScreenTest (){
    LoginScreen()
}
@Composable
fun SignInCard(){
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
}

@Composable
fun AccountInfo (){
    var password = ""
    Column(modifier = Modifier.padding(start = 30.dp), horizontalAlignment = Alignment.CenterHorizontally) {
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

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Outlined.AccountBox, contentDescription ="Email", tint = Color(0xFFAE7CD1),
                modifier = Modifier.size(25.dp) )
            Spacer(modifier = Modifier.width(5.dp))
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Enter Password", color = Color(0xFFAE7CD1)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )


        }



    }
}









