package com.sinamekidev.appsup.sarpdora

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sinamekidev.appsup.R

@Composable
fun HomeScreen(){
    var homeBottomBarSelectedIndex = remember {
        mutableStateOf(1)
    }
    Scaffold(bottomBar = {HomeBottomNavigatonBar{
        HomeBottomNavBarButton(indexNo = 0, selectedInd = homeBottomBarSelectedIndex,
            icon = R.drawable.user , text = "Profile", modifier = Modifier
                .fillMaxWidth(0.3f)
                .clickable {
                    homeBottomBarSelectedIndex.value = 0
                })
        HomeBottomNavBarButton(indexNo = 1, selectedInd = homeBottomBarSelectedIndex,
            icon = R.drawable.home , text = "Home", modifier = Modifier
                .fillMaxWidth(0.5f)
                .clickable {
                    homeBottomBarSelectedIndex.value = 1
                })
        HomeBottomNavBarButton(indexNo = 2, selectedInd = homeBottomBarSelectedIndex,
            icon = R.drawable.setting , text = "Settings", modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    homeBottomBarSelectedIndex.value = 2
                })
    }}) {
        Surface(modifier = Modifier.fillMaxSize(), color = SecondBg) {
            Column(modifier = Modifier.fillMaxSize()) {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()) {

                }
            }
        }
    }

}
@Composable
fun HomeBottomNavigatonBar(content:@Composable () -> Unit){
    BottomAppBar(backgroundColor = MainBg, elevation = 25.dp) {
        Row(modifier = Modifier.fillMaxSize()) {
            content()
        }
    }
}
@Composable
fun HomeBottomNavBarButton(modifier: Modifier = Modifier,
                           indexNo:Int,
                           selectedInd:MutableState<Int>,
                           icon:Int,
                           text:String){
    var indexNoMutable = remember {
        mutableStateOf(indexNo)
    }
    var colorTint = remember {
        mutableStateOf(SecondBg)
    }
    if (indexNoMutable.value == selectedInd.value){
        colorTint.value = FontColor
    }
    else{
        colorTint.value = SecondBg
    }
    Surface(modifier = modifier, color = Color.Transparent) {
        Column(modifier = Modifier
            .padding(4.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(painter = painterResource(id = icon), contentDescription = "Icon", tint = colorTint.value)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = text, color = colorTint.value, fontWeight = FontWeight.Normal)
        }
    }
}

@Preview
@Composable
fun ScreenPreview(){
    HomeScreen()
}

