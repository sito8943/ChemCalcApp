import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.sito.chemcalc.R

import androidx.compose.ui.unit.dp

@Composable
fun MolarWeight() {

    val error = ""
    val formula = remember {
        mutableStateOf(TextFieldValue())
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        TextField(
            placeholder = { Text(text = stringResource(id = R.string.mainInputPlaceholder)) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Blue,
                unfocusedBorderColor = Color.Gray
            ),
            modifier = Modifier
                .fillMaxWidth(),
            value = formula.value,
            onValueChange = { formula.value = it })
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            TextField(
                placeholder = { Text(text = stringResource(id = R.string.resultPlaceholder)) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Blue,
                    unfocusedBorderColor = Color.Gray
                ),
                modifier = Modifier
                    .fillMaxWidth(),
                value = formula.value,
                onValueChange = { formula.value = it })
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            Button(modifier = Modifier
                .clip(shape = RoundedCornerShape(20))
                .background(color = Color.Blue),
                onClick = { /*TODO*/ }) {
                Text(text = stringResource(id = R.string.cleanButton))
            }
            Button(modifier = Modifier
                .clip(shape = RoundedCornerShape(20))
                .background(color = Color.Blue),
                onClick = { /*TODO*/ }) {
                Text(text = stringResource(id = R.string.calculateButton))
            }
            Button(modifier = Modifier
                .clip(shape = RoundedCornerShape(20))
                .background(color = Color.Blue),
                onClick = { /*TODO*/ }) {
                Text(text = stringResource(id = R.string.mathsButton))
            }
        }
    }
}

@Preview
@Composable
fun ShowMolarWeight() {
    MolarWeight()
}