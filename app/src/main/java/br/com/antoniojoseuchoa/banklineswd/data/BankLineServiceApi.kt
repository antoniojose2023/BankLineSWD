package br.com.antoniojoseuchoa.banklineswd.data

import br.com.antoniojoseuchoa.banklineswd.domain.Movimentacao
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface BankLineServiceApi {
    @GET("movimentacoes/{id}")
    suspend fun getMovimentacoes(@Path("id") id: Int): List<Movimentacao>
}