package br.com.apess.calculostrabalhista

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnFGTS.setOnClickListener {
            val intent = Intent(this, FGTSActivity::class.java)
            startActivity(intent)
        }

        btnSeguroDesemp.setOnClickListener {
            val intent = Intent(this, SeguroActivity::class.java)
            startActivity(intent)
        }

        btnFerias.setOnClickListener {
            val intent = Intent(this, FeriasActivity::class.java)
            startActivity(intent)
        }

    }
}
