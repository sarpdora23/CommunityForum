package com.sinamekidev.appsup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.sinamekidev.appsup.data.DummyDataSource
import com.sinamekidev.appsup.models.Posts
import com.sinamekidev.appsup.models.Student
import com.sinamekidev.appsup.models.User
import com.sinamekidev.appsup.onuralan.LoginScreen
import com.sinamekidev.appsup.sarpdora.HomeScreen
import com.sinamekidev.appsup.ui.theme.AppSupTheme
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var student1 = Student(User(
              "Sarp Dora",
              UUID.randomUUID(),
              "",
                bio = "Student"
            ),"Ankra Uni","2")
            var student2 = Student(User(
                "Emre Aksoy",
                UUID.randomUUID(),
                "",
                bio = "ODTU Computer Science"
            ),"ODTU","2")
            DummyDataSource.addPost(Posts(student1.User,com.sinamekidev.appsup.R.drawable.defaultpost,"Aykut kocaman'ın vasat futbolundan bıktık"))
            DummyDataSource.addPost(Posts(student2.User,com.sinamekidev.appsup.R.drawable.defaultpost2,"Herkese günaydın!!!!"))
            DummyDataSource.addPost(Posts(student1.User,com.sinamekidev.appsup.R.drawable.defaultpost,"Aykut kocaman'ın vasat futbolundan bıktık"))
            DummyDataSource.addPost(Posts(student2.User,com.sinamekidev.appsup.R.drawable.defaultpost2,"Herkese günaydın!!!!"))
            HomeScreen()
        }
    }
}

