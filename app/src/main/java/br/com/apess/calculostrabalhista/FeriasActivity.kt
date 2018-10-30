package br.com.apess.calculostrabalhista

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_ferias.*

class FeriasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ferias)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btnFonteF.setOnClickListener {
            val uris = Uri.parse("http://www.calculadorafacil.com.br/trabalhista/calculo-de-ferias")
            val intent = Intent(Intent.ACTION_VIEW, uris)
            startActivity(intent)
        }

        btnCalcularF.setOnClickListener {
            calcularFerias()
        }


    }

    //criação do botão voltar
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        //botão home
        return if(item?.itemId == android.R.id.home) {
            finish()
            true
        }else{
            super.onOptionsItemSelected(item)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun calcularFerias() {

        val salario = txtSalarioF.text.toString().toDouble()
        val meses = txtMeses.text.toString().toDouble()
        val faltas = txtFaltas.text.toString().toDouble()

        val ferias = (salario / 3) + salario


        if (faltas <= 5) {

            resultadoF.text = "Você tem direito a 30 dias com remuneração de: R$%.2f".format(ferias)

        } else if (faltas >= 6 && faltas <= 14) {

            resultadoF.text = "Você tem direito a 24 dias com remuneração de: R$%.2f".format(ferias)

        } else if (faltas >= 15 && faltas <= 23) {
            resultadoF.text = "Você tem direito a 18 dias com remuneração de: R$%.2f".format(ferias)

        } else if (faltas >= 24 && faltas <= 32) {
            resultadoF.text = "Você tem direito a 12 dias com remuneração de: R$%.2f".format(ferias)

        } else {
            resultadoF.text = "Você não possui direito a descanso e receberá a quantia de: R$%.2f".format(ferias)

        }


    }
}
