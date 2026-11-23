package br.com.calculadoraapp2.dao

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CalculadoraDao {

companion object{
    private val _resultados: MutableStateFlow<List<String>> = MutableStateFlow(emptyList())
}

    val resultados = _resultados.asStateFlow()


    fun salvarResultado(resultado: String){
        _resultados.update { listaAtual ->
            listaAtual + resultado
        }
    }

}