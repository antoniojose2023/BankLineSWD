package br.com.antoniojoseuchoa.banklineswd.view.movimentacao

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.antoniojoseuchoa.banklineswd.databinding.ItemMovimentacaoBinding
import br.com.antoniojoseuchoa.banklineswd.domain.Movimentacao

class AdapterMovimentacao(val list: List<Movimentacao>): RecyclerView.Adapter<AdapterMovimentacao.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
          return ViewHolder(ItemMovimentacaoBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
          val item = list[position]
          holder.bind(item)
    }

    override fun getItemCount() = list.size

    class ViewHolder(private val binding: ItemMovimentacaoBinding): RecyclerView.ViewHolder(binding.root){
        @SuppressLint("SetTextI18n")
        fun bind(item: Movimentacao){
               binding.tvData.text = "Data :${item.dataHora}"
               binding.tvSaldo.text = "Saldo :R$${item.valor}"
               binding.tvTipoMovimentcao.text = "Tipo :R$${item.tipo}"
               binding.tvDescricao.text = "Descrição: ${item.descricao}"
        }
    }
}