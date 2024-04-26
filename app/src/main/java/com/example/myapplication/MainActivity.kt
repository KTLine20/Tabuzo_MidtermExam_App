package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
// TABUZO,KRISANGELINE E
// BSIT22A3
//MOBILE COMPUTIING
//MIDTERM EXAM

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    mainpage()

                }
            }
        }
    }
}

@Composable
fun mainpage() {

    //si result variable is nakaset na value para sa button para magkaaction
    var result by remember { mutableStateOf(0) }

    //lalagyanan ng name input
    var UserInput by remember { mutableStateOf("") }

    // si trigger variable para magnext page nakaset siya sa one
    var trigger by remember { mutableStateOf(1) }


    if (trigger == 1) {
        //PICTURE NG BLUE HEADER
        val image = painterResource(id = R.drawable.bicol_intro)
        Column {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(),
                //PARA MAG STRETCH HANGGANG DULO YUNG HEADER
                contentScale = ContentScale.FillWidth
            )
            //inputbox
            InputField(
                UserInput,
                onValueChange = { UserInput = it },
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .fillMaxWidth()
            )
            //code para sa button
            //pagkapindot ng button magchchange ng value si result from 0 to 1
            Button(onClick = { result = 1 })
            {
                Text(stringResource(R.string.OK)
                    )


            }
        }
    }//
        Column {
            //and dahil true yung magiging result ng condition dahil sa action ng button tatawagin niya yung nextpage function then izezero si trigger which will not run the mainpage again
            if (result == 1) {

                Header()
                //GREETING TEXT NG SECOND PAGE
                Text(
                    text = "WELCOME TO BICOL!" +" "+ UserInput,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        //PAGITAN NG HEADER TSAKA TEST
                        .padding(15.dp)
                        //PARA GUMITNA YUNG TITLE
                        .padding(horizontal = 50.dp)

                )

                Content()

                trigger=0
            }
        }
    }




@Composable
fun Header() {
    //  var trigger by remember { mutableStateOf(0) }
    val image = painterResource(id = R.drawable.topheader)
    var UserInput by remember { mutableStateOf("") }
    Column {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(),
            //PARA MAG STRETCH HANGGANG DULO YUNG HEADER
            contentScale = ContentScale.FillWidth
        )

    }
}
@Composable
    fun Content(){
        
        val image1 = painterResource(id = R.drawable.mayon )
        Image(
            painter = image1,
            contentDescription = null,
            modifier = Modifier
                .padding(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 20.dp)
                .fillMaxWidth(),

            //PARA MAG STRETCH HANGGANG DULO YUNG HEADER
            contentScale = ContentScale.FillWidth )

        Text(
            text = "If you're looking for an adventurous getaway, Bicol is the place to be! With many fascinating places to explore, a trip to any Bicol tourist spotpromises to be an exhilarating adventure that will leave you spellbound.\n" +
                    "\n" +
                    "Be captivated by majestic volcanoes and unspoiled beaches brimming with diverse marine life. Swim with friendly butanding or uncover the mysteries of mountains, caves, and cliffs.\n" +
                    "\n",
            fontSize = 15.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                //PAGITAN NG HEADER TSAKA TEST
                .padding(15.dp)
                //PARA GUMITNA YUNG TITLE
                .padding(horizontal = 20.dp)

        )
    }



@Composable
fun InputField(UsertInput:String,onValueChange: (String) -> Unit,modifier: Modifier = Modifier) {

    TextField(
        value = UsertInput,
        onValueChange =  onValueChange  ,
        modifier = modifier,
        singleLine = true,
        label = { Text(text = "ENTER NAME :")}


    )

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() { mainpage()
 //nextpage()
}
