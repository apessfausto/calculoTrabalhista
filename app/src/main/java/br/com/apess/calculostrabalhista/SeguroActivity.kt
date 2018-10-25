package br.com.apess.calculostrabalhista

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

class SeguroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seguro)
        //adiciona o botão voltar na tela
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

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
}
