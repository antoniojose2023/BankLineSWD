package br.com.antoniojoseuchoa.banklineswd.view.movimentacao

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.antoniojoseuchoa.banklineswd.States
import br.com.antoniojoseuchoa.banklineswd.databinding.ActivityMovimentacoesBinding
import br.com.antoniojoseuchoa.banklineswd.domain.Correntistas
import br.com.antoniojoseuchoa.banklineswd.domain.Movimentacao
import br.com.antoniojoseuchoa.banklineswd.viewmodel.MovimentacaoViewModel
import kotlinx.coroutines.launch

class MovimentacoesActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMovimentacoesBinding.inflate(layoutInflater) }
    private val movimentacaoViewModel by viewModels<MovimentacaoViewModel>()
    private lateinit var correntista: Correntistas

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

          correntista =  if(Build.VERSION.SDK_INT == Build.VERSION_CODES.TIRAMISU){
              intent.getParcelableExtra("correntista", Correntistas::class.java)!!
           }else{
              intent.getParcelableExtra("correntista")!!
           }

           listenerMovimentacoes()

          binding.swipeRefresh.setOnRefreshListener{
              listenerMovimentacoes()
          }
    }

    fun listenerMovimentacoes(){
        movimentacaoViewModel.getMovimentacao(correntista.id).observe(this){  states ->
            when(states){
                States.Loading -> {
                        binding.swipeRefresh.isRefreshing = true
                }
                is States.Error -> {
                      Toast.makeText(this, "${states.mensage}", Toast.LENGTH_LONG).show()
                      binding.swipeRefresh.isRefreshing = false
                }
                is States.Sucess -> {
                       val adapterm = AdapterMovimentacao(states.list)
                       binding.rvMoviementacoes.layoutManager = LinearLayoutManager(this)
                       binding.rvMoviementacoes.adapter = adapterm
                       binding.rvMoviementacoes.setHasFixedSize(true)
                       binding.swipeRefresh.isRefreshing = false
                }
            }
        }
    }
}