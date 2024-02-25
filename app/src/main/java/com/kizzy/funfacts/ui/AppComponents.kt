package com.kizzy.funfacts.ui

import android.graphics.drawable.PaintDrawable
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kizzy.funfacts.R


@Composable
fun AppTopBar(title: String) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text(text = title, fontSize = 23.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.bookmark_iv),
            contentDescription = "Top Bar Icon",
            modifier = Modifier.size(60.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AppTopBarPreview() {
    AppTopBar("Hi There")
}

@Composable
fun TextComponent(txt: String, textSize: TextUnit, textColor: Color = Color.Black) {
    Text(
        text = txt,
        fontSize = textSize,
        color = textColor

    )
}

@Preview(showBackground = true)
@Composable
fun TextComponentPreview() {
    TextComponent(txt = "Let's learn about You!", 21.sp)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInputComponent(onTextChange: (text: String) -> Unit) {
    var currentText by remember {
        mutableStateOf("")
    }
    OutlinedTextField(value = currentText, onValueChange = {
        currentText = it
        onTextChange(it)
    }, modifier = Modifier.fillMaxWidth(),
        placeholder = {Text("Enter your name", fontSize = 18.sp)},
        textStyle = TextStyle.Default.copy(fontSize = 22.sp),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
    )
}

@Preview(showBackground = true)
@Composable
fun TextInputComponentPreview() {
    TextInputComponent(onTextChange = {})
}

@Composable
fun AnimalCard(image: Int,selected : Boolean,animalSelected : (name: String) -> Unit) {
    Card (
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
        .padding(24.dp)
        .size(130.dp),
        elevation = CardDefaults.cardElevation(4.dp),) {
        Box (modifier = Modifier.fillMaxSize().border(width = 1.dp, color = if(selected) Color.Green else Color.Transparent, shape = RoundedCornerShape(8.dp))){
            Image(painter = painterResource(id = image), contentDescription = "Animal Picture", modifier = Modifier
                .padding(16.dp)
                .size(100.dp).clickable {
                    val name = if (image == R.drawable.cat_iv) "Cat" else "Dog"
                    animalSelected(name)
                } )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun AnimalCardPreview() {
    AnimalCard(R.drawable.cat_iv,true, animalSelected = {})
}