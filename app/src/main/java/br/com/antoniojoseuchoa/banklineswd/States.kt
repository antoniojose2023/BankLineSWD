package br.com.antoniojoseuchoa.banklineswd

import br.com.antoniojoseuchoa.banklineswd.domain.Movimentacao

sealed class States{
    object Loading: States()
    class Sucess(val list: List<Movimentacao>): States()
    class Error(val mensage: String): States()
}