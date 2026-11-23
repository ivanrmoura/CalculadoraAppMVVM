package br.com.calculadoraapp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.calculadoraapp2.ui.screen.CalculadoraScreen
import br.com.calculadoraapp2.ui.theme.CalculadoraApp2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculadoraApp2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CalculadoraScreen(

                    )
                }
            }
        }
    }
}

