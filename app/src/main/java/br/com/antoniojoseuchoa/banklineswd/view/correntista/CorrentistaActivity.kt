package br.com.antoniojoseuchoa.banklineswd.view.correntista

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.antoniojoseuchoa.banklineswd.databinding.ActivityCorrentistaBinding
import br.com.antoniojoseuchoa.banklineswd.domain.Correntistas
import br.com.antoniojoseuchoa.banklineswd.view.movimentacao.MovimentacoesActivity

class CorrentistaActivity : AppCompatActivity() {
    private val binding by lazy { ActivityCorrentistaBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonEnviar.setOnClickListener {
            val id = binding.editInputText.text.toString()
            if(id.isEmpty()){
                  exibirMensagen("Campos vázio")
            }else{
                val correntistas = Correntistas(1)

                val intent = Intent(this, MovimentacoesActivity::class.java)
                intent.putExtra("correntista", correntistas)
                startActivity(intent)
            }
        }
    }

    fun exibirMensagen(mensagem: String){
            Toast.makeText(this, "$mensagem", Toast.LENGTH_LONG).show()
    }

}