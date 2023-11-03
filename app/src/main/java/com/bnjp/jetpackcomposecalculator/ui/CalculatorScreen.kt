package com.bnjp.jetpackcomposecalculator.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bnjp.jetpackcomposecalculator.R
import com.bnjp.jetpackcomposecalculator.buttonsLabel
import com.bnjp.jetpackcomposecalculator.ui.theme.JetpackComposeCalculatorTheme
import com.bnjp.jetpackcomposecalculator.ui.theme.dimens


@Composable
fun CalculatorScreen(calculatorViewModel: CalculatorViewModel = viewModel()) {

    val calculatorUiState by calculatorViewModel.uiState.collectAsState()
    val context = LocalContext.current

    fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    Column(
        modifier = Modifier
            .padding(MaterialTheme.dimens.small1)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

            Box(
                modifier = Modifier
                    .weight(2F),
                contentAlignment = Alignment.BottomEnd
                ) {
                Column(

                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.End,

                ) {
                    Text(
                        text = calculatorUiState.operationView,
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Normal
                    )
                    Text(
                        text = calculatorUiState.answerView,
                        style = MaterialTheme.typography.headlineLarge,
                    )
                }
            }

        Spacer(modifier = Modifier.height(MaterialTheme.dimens.small1))

        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .weight(3F)
                .padding(MaterialTheme.dimens.extraSmall)
               // .border(width = 1.dp, color = Color.Black)
        ) {
            val buttonsContainerModifier = Modifier
                .weight(1f)
               // .border(width = 1.dp, color = Color.Black)
            val defaultButtonModifier = Modifier
                .width(MaterialTheme.dimens.buttonWidth)
                .padding(MaterialTheme.dimens.extraSmall)
                .weight(1f)

            val largesButtonsModifier = Modifier
                .width(MaterialTheme.dimens.buttonWidth)
                .padding(MaterialTheme.dimens.extraSmall)
                .weight(2F)

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = buttonsContainerModifier
            ) {
                for (label in buttonsLabel["column1"]!!) {
                    val char = stringResource(label)[0]
                    ButtonElement(
                        onButtonCliquedClick = {
                            calculatorViewModel.getCliquedButtonChar(char) },
                        colorButton = if(label == R.string.clear) {
                            MaterialTheme.colorScheme.secondary
                        } else { MaterialTheme.colorScheme.tertiary },
                        textButton = char,
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
                    val char = stringResource(label)[0]
                    ButtonElement(
                        onButtonCliquedClick = {
                            calculatorViewModel.getCliquedButtonChar(char) },
                        textButton = char,
                        modifier = defaultButtonModifier
                    )
                }
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom,
                modifier = buttonsContainerModifier
                    .fillMaxHeight()
            ) {
                for (label in buttonsLabel["column3"]!!) {
                    val char = stringResource(label)[0]
                    ButtonElement(
                        onButtonCliquedClick = {
                            calculatorViewModel.getCliquedButtonChar(char) },
                        textButton = char,
                        modifier = defaultButtonModifier
                    )
                }
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = buttonsContainerModifier
            ) {
                for (label in buttonsLabel["column4"]!!) {
                    val char = stringResource(label)[0]
                    ButtonElement(
                        onButtonCliquedClick = {
                            calculatorViewModel.getCliquedButtonChar(char)
                            if(label == R.string.equal && calculatorUiState.isError) {
                                showToast("Erreur")
                            }
                                               },
                        colorButton = if(label == R.string.equal) {
                            MaterialTheme.colorScheme.primary
                        } else { MaterialTheme.colorScheme.tertiary },
                        textButton = char,
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
    textButton: Char,
    shape: Shape = RoundedCornerShape(4.dp),
    colorButton: Color = MaterialTheme.colorScheme.tertiary,
    textButtonColor: Color = MaterialTheme.colorScheme.onTertiary,
    onButtonCliquedClick: () -> Unit
) {
    Button(
        onClick = onButtonCliquedClick,
        modifier = modifier,
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            containerColor = colorButton
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = MaterialTheme.dimens.small1,
            pressedElevation = MaterialTheme.dimens.extraSmall
        )
         ){
        Text(
            text = textButton.toString(),
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            color = textButtonColor,
        )
    }
}

@Preview(
    showBackground = true,
    device = Devices.NEXUS_5
)
@Composable
fun CalculatorScreenPreview1() {
    JetpackComposeCalculatorTheme(windowSize = WindowWidthSizeClass.Compact) {
        CalculatorScreen()
    }
}
//@Preview(
//    showBackground = true,
//    device = Devices.PIXEL_3A_XL
//)
//@Composable
//fun CalculatorScreenPreview2() {
//    JetpackComposeCalculatorTheme(windowSize = WindowWidthSizeClass.Compact) {
//        CalculatorScreen()
//    }
//}
//
//@Preview(
//    showBackground = true,
//    device = Devices.PIXEL_XL
//)
//@Composable
//fun CalculatorScreenPreview3() {
//    JetpackComposeCalculatorTheme(windowSize = WindowWidthSizeClass.Compact) {
//        CalculatorScreen()
//    }
//
//}