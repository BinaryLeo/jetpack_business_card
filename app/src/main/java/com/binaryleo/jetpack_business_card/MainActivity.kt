package com.binaryleo.jetpack_business_card

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
Surface(modifier = Modifier
    .fillMaxWidth()
    .fillMaxHeight()){
    Card(modifier = Modifier.width(200.dp)
        .height(390.dp)
        .padding(12.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(corner = CornerSize(15.dp)),
        backgroundColor = Color.White

        ) {

    }
}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Jetpack_business_cardTheme {
   CreateBizCard()
    }
}