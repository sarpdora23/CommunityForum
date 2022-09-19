package com.sinamekidev.appsup.sarpdora

import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
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
    var homeTopBarTitle = remember {
        mutableStateOf("Home")
    }
    var navMenuVisibity = remember {
        mutableStateOf(false)
    }
    var navMenuIndex = remember {
        mutableStateOf(0)
    }
    Box() {
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
        }}, topBar = { HomeTopNavBar(title = homeTopBarTitle.value,
            navMenuVisibility = navMenuVisibity)}) {
            Surface(modifier = Modifier.fillMaxSize(), color = SecondBg) {
                Column(modifier = Modifier.fillMaxSize()) {
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()) {

                    }
                }
            }
        }
        AnimatedVisibility(visible =navMenuVisibity.value) {
            Row(modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent)) {
                Column(modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.7f)) {
                    NavigationMenu {
                        MenuRow(icon = R.drawable.home, text = "Home", isSelected = navMenuIndex.value == 0) {
                            navMenuIndex.value = 0
                        }
                        MenuRow(icon = R.drawable.discussion, text = "Forum",isSelected = navMenuIndex.value == 1) {
                            navMenuIndex.value = 1
                        }
                        MenuRow(icon = R.drawable.mortarboard, text = "Course",isSelected = navMenuIndex.value == 2) {
                            navMenuIndex.value = 2
                        }
                        MenuRow(icon = R.drawable.ranking, text = "Ranking",isSelected = navMenuIndex.value == 3) {
                            navMenuIndex.value = 3
                        }
                        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom){
                            Surface(modifier = Modifier.fillMaxWidth(), color = SecondBg) {
                                Row(modifier = Modifier
                                    .fillMaxWidth()
                                    .height(60.dp),
                                    verticalAlignment = Alignment.CenterVertically) {
                                    Spacer(modifier = Modifier.width(60.dp))
                                    Text(text = "Sign Out", color = MainBg, fontSize = 30.sp, fontWeight = FontWeight.Bold)
                                    Spacer(modifier = Modifier.width(15.dp))
                                    Icon(painter = painterResource(id = R.drawable.logout)
                                        , contentDescription ="Log out", tint = MainBg, modifier = Modifier.size(30.dp))
                                }
                            }
                        }
                    }
                }
                Column(modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()) {
                    Surface(color = Color(0x8B070707), modifier = Modifier
                        .fillMaxSize()
                        .clickable {
                            navMenuVisibity.value = false
                        }) {

                    }
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
fun HomeTopNavBar(modifier: Modifier = Modifier,title:String,navMenuVisibility:MutableState<Boolean>){
    TopAppBar(modifier = modifier, elevation = 25.dp, backgroundColor = MenuBg) {
        Row(modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector =Icons.Default.Menu , contentDescription ="Menu", tint = FontColor,
                modifier = Modifier
                    .size(32.dp)
                    .clickable {
                        navMenuVisibility.value = true
                    })
            Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                Text(text = title, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Spacer(modifier = Modifier.width(32.dp))
            }

        }
    }
}
@Composable
fun HomeBottomNavBarButton(modifier: Modifier = Modifier,
                           indexNo:Int,
                           selectedInd:MutableState<Int>,
                           icon:Int,
                           text:String){
    var colorTint = remember {
        mutableStateOf(SecondBg)
    }
    if (indexNo == selectedInd.value){
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
@Composable
fun NavigationMenu(content: @Composable () -> Unit){
    Surface(modifier = Modifier.fillMaxSize(), color = SelectedBg) {
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.logo), contentDescription ="Logo", contentScale = ContentScale.FillWidth)
            content()
        }
    }
}
@Composable
fun MenuRow(icon:Int,text:String,isSelected:Boolean = false,onClick: () -> Unit){
    var rowColor = remember {
        mutableStateOf(SelectedBg)
    }
    if(isSelected){
        rowColor.value = Color(0xFFB1573A)
    }
    else{
        rowColor.value = SelectedBg
    }
    Row(modifier = Modifier
        .fillMaxWidth()
        ,
        verticalAlignment = Alignment.CenterVertically) {
        Card(modifier = Modifier
            .fillMaxWidth()
            .height(60.dp).clickable { onClick.invoke() }, backgroundColor = rowColor.value) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(), verticalAlignment = Alignment.CenterVertically) {
                Spacer(modifier = Modifier.width(60.dp))
                Icon(painter = painterResource(id = icon), contentDescription = "Icon", tint = FontColor, modifier = Modifier.size(30.dp))
                Spacer(modifier = Modifier.width(30.dp))
                Text(text = text, color = FontColor, fontSize = 30.sp, fontWeight = FontWeight.SemiBold)
            }
        }
    }
}
@Preview
@Composable
fun ScreenPreview(){
    HomeScreen()
}

