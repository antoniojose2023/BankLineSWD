package br.com.antoniojoseuchoa.banklineswd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import br.com.antoniojoseuchoa.banklineswd.databinding.ActivityMainBinding
import br.com.antoniojoseuchoa.banklineswd.view.correntista.CorrentistaActivity

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        carregarTelaSplash()
    }

    fun carregarTelaSplash(){
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, CorrentistaActivity::class.java))
        }, 3000)
    }
}