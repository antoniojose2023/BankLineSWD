package br.com.antoniojoseuchoa.banklineswd.viewmodel

import androidx.lifecycle.ViewModel
import br.com.antoniojoseuchoa.banklineswd.data.repository.BankLineRepository

class MovimentacaoViewModel: ViewModel() {
    fun getMovimentacao(id: Int) = BankLineRepository.getMovimentacoes(id)
}

