package uca.edu.reqres.utils

import uca.edu.reqres.model.Reqres
import java.lang.Exception

sealed class DataState {
    object Idle: DataState()
    data class Success(val reqres: List<Reqres>) : DataState()
    data class Error(val exception: Exception) : DataState()
    object Loading: DataState()
}