package com.bnjp.jetpackcomposecalculator.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bnjp.jetpackcomposecalculator.R
import com.bnjp.jetpackcomposecalculator.buttonsLabel
import com.bnjp.jetpackcomposecalculator.ui.theme.JetpackComposeCalculatorTheme

@Composable
fun CalculatorScreen() {
    Column(
        modifier = Modifier
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f),
            contentAlignment = Alignment.BottomEnd
        )
        {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "70 + 30",
                    style = MaterialTheme.typography.displaySmall,
                    fontWeight = FontWeight.SemiBold,
                )
                Text(
                    text = "= 100",
                    style = MaterialTheme.typography.displayLarge,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .weight(3F)
               // .border(width = 1.dp, color = Color.Black)
        ) {
            val buttonsContainerModifier = Modifier
             //   .border(width = 1.dp, color = Color.Black)
            val defaultButtonModifier = Modifier
                .size(width = 88.dp, height = 80.dp)
                .padding(vertical = 1.dp) .graphicsLayer { shadowElevation = 5f; shape = RoundedCornerShape(8.dp) }

            val largesButtonsModifier = Modifier
                .size(width = 88.dp, height = 80.dp)
                .padding(vertical = 1.dp) .graphicsLayer { shadowElevation = 5f; shape = RoundedCornerShape(8.dp) }
                .weight(2F)

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = buttonsContainerModifier
            ) {
                for (label in buttonsLabel["column1"]!!) {
                    ButtonElement(
                        colorButton = if(label == R.string.clear) {
                            MaterialTheme.colorScheme.secondary
                        } else { MaterialTheme.colorScheme.tertiary },
                        textButton = stringResource(label),
                        textButtonColor = if(label == R.string.clear) {
                            MaterialTheme.colorScheme.onPrimary
                        } else { MaterialTheme.colorScheme.onTertiary },
                        modifier = if(label == R.string.clear) {
                            largesButtonsModifier
                        } else { defaultButtonModifier },

                    )
                }
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = buttonsContainerModifier
            ) {
                for (label in buttonsLabel["column2"]!!) {
                    ButtonElement(
                        textButton = stringResource(label),
                        modifier = defaultButtonModifier
                    )
                }
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = buttonsContainerModifier
            ) {
                for (label in buttonsLabel["column3"]!!) {
                    ButtonElement(
                        textButton = stringResource(label),
                        modifier = defaultButtonModifier
                    )
                }
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = buttonsContainerModifier
            ) {
                for (label in buttonsLabel["column4"]!!) {
                    ButtonElement(
                        colorButton = if(label == R.string.equal) {
                            MaterialTheme.colorScheme.primary
                        } else { MaterialTheme.colorScheme.tertiary },
                        textButton = stringResource(label),
                        textButtonColor = if(label == R.string.equal) {
                            MaterialTheme.colorScheme.onPrimary
                        } else { MaterialTheme.colorScheme.onTertiary },
                        modifier = if(label == R.string.equal) {
                            largesButtonsModifier
                        } else { defaultButtonModifier }
                    )
                }
            }
        }
    }
}

@Composable
fun ButtonElement(
    modifier: Modifier = Modifier,
    textButton: String,
    shape: Shape = RoundedCornerShape(8.dp),
    colorButton: Color = MaterialTheme.colorScheme.tertiary,
    textButtonColor: Color = MaterialTheme.colorScheme.onTertiary
) {
    Button(
        onClick = { /*TODO*/ },
        modifier = modifier,
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            containerColor = colorButton
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 10.dp,
            pressedElevation = 2.dp
        )
         ){
        Text(
            text = textButton,
            style = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            color = textButtonColor,
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
fun CalculatorScreenPreview() {
    JetpackComposeCalculatorTheme {
        CalculatorScreen()
    }

}