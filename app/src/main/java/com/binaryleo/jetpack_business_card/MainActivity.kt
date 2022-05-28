package com.binaryleo.jetpack_business_card

import android.content.ContentValues.TAG
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.binaryleo.jetpack_business_card.ui.theme.Jetpack_business_cardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_business_cardTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard(){
    val buttonClickedState = remember {
        mutableStateOf(false)
    }
Surface(modifier = Modifier
    .fillMaxWidth()
    .fillMaxHeight()){
    Card(modifier = Modifier
        .width(200.dp)
        .height(390.dp)
        .padding(12.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(corner = CornerSize(15.dp)),
        backgroundColor = Color.White) {
        Column(modifier = Modifier.height(300.dp),
         verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
            ) {
            CreateImageProfile()
            Divider()
            CreateProfileInfo()
            Button(
                onClick = {
                     buttonClickedState.value = !buttonClickedState.value
                    //Log.d( "Clicked", "CreateBizCard: Clicked") //debug
                }) {
                Text(text = "Portfolio",
                 style = MaterialTheme.typography.button)

                
            }
            if (buttonClickedState.value){
                Content()
            }else{
                Box(){

                }
            }

        }
        




    }
}
}

@Composable fun Content(){
Box(modifier = Modifier
    .fillMaxHeight()
    .fillMaxWidth()
    .padding(5.dp)){
    Surface(modifier = Modifier
        .padding(3.dp)
        .fillMaxWidth()
        .fillMaxHeight(),
        shape = RoundedCornerShape(corner = CornerSize(6.dp)),
       border = BorderStroke(width = 2.dp, color = Color.LightGray)
        ) {
        Portfolio(data = listOf(
            "Project 1",
            "Project 2",
            "Project 3",
            "Project 4"))

    }
}

}

@Composable
fun Portfolio(data: List<String>) {
LazyColumn {
   items(data){
       item->
       Text(item)
   }
}
}

@Composable
private fun CreateProfileInfo() {
    Column(
        modifier = Modifier
            .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Karen Miles",
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.primaryVariant
        )
        Text(
            text = "Android Composer Programmer",
            modifier = Modifier.padding(3.dp),
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.primaryVariant
        )
        Text(
            text = "@karenmiles.mail.com",
            modifier = Modifier.padding(3.dp),
            style = MaterialTheme.typography.subtitle1
        )
    }
}

@Composable
private fun CreateImageProfile(modifier: Modifier= Modifier) {
    Surface(
        modifier = Modifier
            .size(size = 150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(width = 0.5.dp, Color.LightGray),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.user_profile),
            contentDescription = "user profile picture",
            modifier = Modifier.size(size = 135.dp),
            contentScale = ContentScale.Crop
        )
    }
}
@Preview
//@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Jetpack_business_cardTheme {
   CreateBizCard()
    }
}