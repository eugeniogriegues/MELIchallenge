package com.example.melichallenge.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.melichallenge.model.ApiClient
import com.example.melichallenge.model.ItemResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class MeliViewModel : ViewModel () {

    val meliModel = MutableLiveData<ItemResponse>()


    fun obtenerItems (inputTexto: String)  {

        val client = ApiClient.apiService.lanzarCall(inputTexto, 20)  // LANZA LA LLAMADA CON EL INPUT DEL SEARCHVIEW Y UN LIMITE DE RESULTADOS = 20

        CoroutineScope(Dispatchers.IO).launch {

            client.enqueue(object : retrofit2.Callback<ItemResponse> {

                override fun onResponse(
                    call: Call<ItemResponse>,
                    response: Response<ItemResponse>
                )

                {
                        if (response.isSuccessful) {

                            val resultados = response.body()?.results

                            resultados?.let {

                                meliModel.postValue(ItemResponse(resultados))   // ACTUALIZA LA LISTA CON LOS NUEVOS RESULTADOS

                            }

                        }

                }

                override fun onFailure(call: Call<ItemResponse>, t: Throwable) {

                }

            })
        }

    }

}