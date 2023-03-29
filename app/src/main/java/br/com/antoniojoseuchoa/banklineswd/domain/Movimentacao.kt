package br.com.antoniojoseuchoa.banklineswd.domain

import com.google.gson.annotations.SerializedName

data class Movimentacao(
    val id:	Int,
    val dataHora: String,
    val descricao: String,
    val valor: Double,
    val tipo: Tipo,
    @SerializedName("idConta")
    val idCorrentista: Int
)

