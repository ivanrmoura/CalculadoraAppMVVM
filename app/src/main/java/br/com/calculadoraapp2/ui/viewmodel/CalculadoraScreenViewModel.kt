package br.com.calculadoraapp2.ui.viewmodel

import androidx.lifecycle.ViewModel
import br.com.calculadoraapp2.ui.screen.CalculadoraScreenUiSate
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CalculadoraScreenViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CalculadoraScreenUiSate())

    val uiSate = _uiState.asStateFlow()


    fun updateNum1(numDigitado: String){
        _uiState.update { currentState ->
          currentState.copy(
              num1 = numDigitado
          )
        }
    }

    fun updateNum2(numDigitado: String){
        _uiState.update { currentState ->
            currentState.copy(
                num2 = numDigitado
            )
        }
    }


}