package br.com.antoniojoseuchoa.banklineswd.data.repository

import androidx.lifecycle.liveData
import br.com.antoniojoseuchoa.banklineswd.States
import br.com.antoniojoseuchoa.banklineswd.data.BankLineServiceApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BankLineRepository {
    private val base_url = "http://10.0.2.2:8080/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(base_url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(BankLineServiceApi::class.java)

    fun getMovimentacoes(id: Int) = liveData {
        emit(States.Loading)

        try{
            emit(States.Sucess(retrofit.getMovimentacoes(id)))
        }catch (ex: java.lang.Exception){
            emit(States.Error(ex.message.toString()))
        }
    }
}