package com.code.desafio.android.presentation.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.code.desafio.android.presentation.Constants.Companion.EMPTY_STRING
import com.code.desafio.android.presentation.Constants.Companion.PASSWORD
import com.code.desafio.android.presentation.Constants.Companion.USER
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    private val _loginSuccess: MutableLiveData<Boolean?> = MutableLiveData(false)
    val loginSuccess: LiveData<Boolean?> = _loginSuccess

    private val _errorLocalValidation: MutableLiveData<String?> = MutableLiveData(null)
    val errorLocalValidation: LiveData<String?> = _errorLocalValidation

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    fun login(user: String, password: String) {
        viewModelScope.launch {

            _loginSuccess.value = false
            _isLoading.value = true
            _errorLocalValidation.value = EMPTY_STRING

            if (user.trim().isEmpty()) {
                _errorLocalValidation.value = "Debes ingresar un usuario"
                return@launch
            }

            if (password.trim().isEmpty()) {
                _errorLocalValidation.value = "Debes ingresar tu usuario"
                return@launch
            }

            if (user.trim().equals(USER)) {
                _errorLocalValidation.value = "Usuario incorrecto"
                return@launch
            }

            if (password.trim().equals(PASSWORD)) {
                _errorLocalValidation.value = "Password incorrecto"
                return@launch
            }

            _loginSuccess.value = true
            _isLoading.value = false

        }
    }
}