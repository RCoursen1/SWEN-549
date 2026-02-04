package com.example.swen549_gitrepo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.swen549_gitrepo.ui.theme.SWEN549gitrepoTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SWEN549gitrepoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

//RSVP
                    MakeText(
                        "Graduation RSVP-RIT",
                        modifier = Modifier.padding(innerPadding),
                        Color.Magenta,
                        25f,
                        Color.Cyan,
                        20,
                        30,
                        TextAlign.Left

                    )
//Grad announcement
                    MakeText(
                        "Graduation Announcement",
                        modifier = Modifier
                            .offset(y = 100.dp)
                            .padding(innerPadding),
                        Color.Red,
                        50f,
                        Color.Transparent,
                        15,
                        10
                    )
//monday 10am
                    MakeText(
                        "Monday 10am, Golisano Hall 4000",
                        modifier = Modifier
                            .offset(y = 500.dp)
                            .padding(innerPadding),
                        Color.Blue,
                        25f,
                        Color.Transparent,
                        15,
                        15
                    )
//Pic
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.grad_cap),
                            contentDescription = "Graduation picture",
                            modifier = Modifier
                                .size(250.dp)
                                .offset(y = 300.dp),
//                            contentScale = ContentScale.Crop
                        )
                    }
                    Column(
                        modifier = Modifier.fillMaxSize().offset(y=700.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        var isOn by remember { mutableStateOf(false) }

                        Switch(
                            checked = isOn, onCheckedChange = { isOn = it })
                        if (isOn){
                            MakeText(
                                "Ill Be there!",
                                modifier = Modifier
                                    .offset(y = (-50).dp)
                                    .padding(innerPadding),
                                Color.Black,
                                25f,
                                Color.Transparent,
                                20,
                                15
                            )
                        }
                        else{
                            MakeText(
                                "I wont Be there",
                                modifier = Modifier
                                    .offset(y = (-50).dp)
                                    .padding(innerPadding),
                                Color.Black,
                                25f,
                                Color.Transparent,
                                20,
                                15
                            )
                        }
                    }
                }
            }
        }
    }
}




@Composable
fun MakeText(
    message: String,
    modifier: Modifier = Modifier,
    textColor: Color = Color.Blue,
    textSize: Float = 16f,
    backgroundColor: Color = Color.Transparent,
    paddingHorizontal: Int = 15,
    paddingVertical: Int = 15,
    align: TextAlign = TextAlign.Center,

    ) {

    Text(
        text = message,
        modifier = modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .padding(horizontal = paddingHorizontal.dp, vertical = paddingVertical.dp),
        color = textColor,
        fontSize = textSize.sp,
        lineHeight = (textSize * 1.2f).sp,
        textAlign = align,


        )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SWEN549gitrepoTheme {
        MakeText("Android")
    }
}