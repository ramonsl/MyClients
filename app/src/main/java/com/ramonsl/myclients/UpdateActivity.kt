package com.ramonsl.myclients

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.google.android.material.floatingactionbutton.FloatingActionButton


class UpdateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_update)

        val edtFone = findViewById<EditText>(R.id.edtFone)
        val edtNome = findViewById<EditText>(R.id.edtNome)
        val edtIdade = findViewById<EditText>(R.id.edtIdade)
        val FABRemove = findViewById<FloatingActionButton>(R.id.FABRemove)
        val FABSave = findViewById<FloatingActionButton>(R.id.FABSave)
        val FABBack = findViewById<FloatingActionButton>(R.id.FABBack)
        val cliente = intent.getParcelableExtra<Cliente>("cliente")

        edtFone.setText(cliente?.fone.toString())
        edtNome.setText(cliente?.nome.toString())
        edtIdade.setText(cliente?.idade.toString())


        FABRemove.setOnClickListener {
            val clienteDao = ClienteDao(this)
            if (cliente != null) {
                clienteDao.remove(cliente)
            }
            onBackPressed()

        }

        FABSave.setOnClickListener {
            var clienteUP = Cliente(cliente?.id,edtNome.text.toString(),edtFone.text.toString(),(edtIdade.text.toString().toInt()))
            var clienteDao = ClienteDao(this)
            clienteDao.update(clienteUP)
            onBackPressed()
        }

        FABBack.setOnClickListener(View.OnClickListener {
            onBackPressed()
        })


    }





}
