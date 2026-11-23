package br.com.calculadoraapp2.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.calculadoraapp2.dao.CalculadoraDao
import br.com.calculadoraapp2.ui.screen.CalculadoraScreenUiSate
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CalculadoraScreenViewModel : ViewModel() {

    private val calculadoraDao = CalculadoraDao()

    private val _uiState = MutableStateFlow(CalculadoraScreenUiSate())

    val uiSate = _uiState.asStateFlow()


    init {
        viewModelScope.launch {
            calculadoraDao.resultados.collect { resultadosList ->
                _uiState.update { currentState ->
                    currentState.copy(
                        resultadosSalvos = resultadosList
                    )
                }
            }
        }
    }

    fun salvaResultado(){

        viewModelScope.launch {
            calculadoraDao.salvarResultado(_uiState.value.resultado)
        }

        _uiState.update { currentState ->
            currentState.copy(
                num1 = "",
                num2 = "",
                resultado = "0"
            )
        }


    }

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


    fun somar(){
        val resultado = _uiState.value.num1.toDouble() + _uiState.value.num2.toDouble()

        _uiState.update { currentState ->
            currentState.copy(
                resultado = resultado.toString()
            )
        }

    }

}