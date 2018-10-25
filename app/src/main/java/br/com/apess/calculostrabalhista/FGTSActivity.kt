package br.com.apess.calculostrabalhista

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_fgts.*

class FGTSActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fgts)
        //botão voltar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //botão calcular
        btnCalcular.setOnClickListener {
            val fgts =
                ((etxSalarioBruto.text.toString().toDouble() * 0.8) * etxMesesTrabalhados.text.toString().toDouble()).toString()
            txtResultado.text = fgts
        }

        //brindo outro site
        btnVerFonte.setOnClickListener {
            val uris = Uri.parse("https://calculofgts.net/")
            val intent = Intent(Intent.ACTION_VIEW, uris)
            startActivity(intent)
        }

    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        //direcionamento com o botão home (botão com comando padrão)
        return if (item?.itemId == android.R.id.home) {
            finish()
            true
        } else {
            super.onOptionsItemSelected(item)
        }

    }
}
