package br.com.apess.calculostrabalhista

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_seguro.*

class SeguroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seguro)
        //adiciona o botão voltar na tela
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btnCalcular.setOnClickListener {
            seguroDesemprego()
        }

        btnFonte.setOnClickListener {
            val uris = Uri.parse("https://calculadorafacil.com.br/trabalhista/consulta-seguro-desemprego")
            val intent = Intent(Intent.ACTION_VIEW, uris)
            startActivity(intent)
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
    private fun seguroDesemprego(){

        val salarioA = antPSalario.text.toString().toDouble()
        val salarioB = antPSalario.text.toString().toDouble()
        val salarioC = ultimoSalario.text.toString().toDouble()
        val mTrabalhado = qtdMesesTrabalhados.text.toString().toDouble()

        val mediaSalario = (salarioA + salarioB + salarioC)/3

        if (mTrabalhado >= 6 && mTrabalhado < 11 ){
            val seguroPago = mediaSalario/0.80
            resultadoSeguro.text = "Receberá R$%.2f". format(seguroPago) +" em 3 parcelas"

        }else if(mTrabalhado >= 12 && mTrabalhado <= 23 ){

            val seguroPago = mediaSalario/0.5
            resultadoSeguro.text = "Receberá R$%.2f". format(seguroPago) +" em 4 parcelas"

        }else if(mTrabalhado > 24){

            resultadoSeguro.text = "Receberá R$ 1.677,74 em 5 parcelas"

        }


    }

}
