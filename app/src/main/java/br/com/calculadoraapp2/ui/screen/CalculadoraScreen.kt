package br.com.calculadoraapp2.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.calculadoraapp2.ui.component.ResultadoCard
import br.com.calculadoraapp2.ui.theme.CalculadoraApp2Theme
import br.com.calculadoraapp2.ui.viewmodel.CalculadoraScreenViewModel

data class CalculadoraScreenUiSate(
    val resultado: String = "",
    val num1: String = "",
    val num2: String = "",
    val resultadosSalvos: List<String> = listOf()
)

@Composable
fun CalculadoraScreen(
    modifier: Modifier = Modifier,
    viewModel: CalculadoraScreenViewModel
) {
    val state by viewModel.uiSate.collectAsState()

    CalculadoraScreen(
       modifier = modifier,
        state = state,
        onNum1Change = {
            viewModel.updateNum1(it)
        },
        onNum2Change = {
            viewModel.updateNum2(it)
        },
        onSomarClick = {
            viewModel.somar()
        },
        onSalvarResultado = {
            viewModel.salvaResultado()
        }
    )

}

@Composable
fun CalculadoraScreen(
    modifier: Modifier = Modifier,
    onNum1Change: (String) -> Unit = {},
    onNum2Change: (String) -> Unit = {},
    onSomarClick: () -> Unit = {},
    onSalvarResultado: () -> Unit = {},
    state: CalculadoraScreenUiSate = CalculadoraScreenUiSate()
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = state.resultado,
            fontSize = 18.sp
        )

        OutlinedTextField(
            value = state.num1,
            onValueChange = onNum1Change,
            label = {
                Text(
                    text = "Primeiro número"
                )
            },
            modifier = Modifier
                .fillMaxWidth()
        )

        OutlinedTextField(
            value = state.num2,
            onValueChange = onNum2Change,
            label = {
                Text(
                    text = "Segundo número"
                )
            },
            modifier = Modifier
                .fillMaxWidth()
        )


        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Button(
                onClick = onSomarClick,
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .weight(0.25f)
            ){
                Text(text = "+")
            }

            Button(
                onClick = {},
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .weight(0.25f)
            ){
                Text(text = "-")
            }

            Button(
                onClick = {},
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .weight(0.25f)
            ){
                Text(text = "*")
            }

            Button(
                onClick = {},
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .weight(0.25f)
            ){
                Text(text = "/")
            }


        }

        Button(
            onClick = onSalvarResultado,
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
        ){
            Text(text = "Salvar Resultado")
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
           items(state.resultadosSalvos){
                ResultadoCard(
                    resultado = it
                )
           }
        }

    }

}


@Preview(showBackground = true)
@Composable
private fun CalculadoraScreenPreview() {
    CalculadoraApp2Theme() {
        CalculadoraScreen(
            state = CalculadoraScreenUiSate(
                num1 = "1",
                num2 = "30",
                resultado = "40"
            )
        )
    }
}
