package com.ramonsl.myclients

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.google.android.material.floatingactionbutton.FloatingActionButton


class SaveActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_save)

        val FABBack = findViewById<FloatingActionButton>(R.id.FABBack)
        val FABSave = findViewById<FloatingActionButton>(R.id.FABSave)
        val edtNome= findViewById<EditText>(R.id.edtNome)
        val edtFone= findViewById<EditText>(R.id.edtFone)
        val edtIdade= findViewById<EditText>(R.id.edtIdade)

        FABBack.setOnClickListener(View.OnClickListener {
            onBackPressed()
        })


        FABSave.setOnClickListener(View.OnClickListener {
            var cliente = Cliente(null,edtNome.text.toString(),edtFone.text.toString(),(edtIdade.text.toString().toInt()))
            var clienteDao = ClienteDao(this)
            clienteDao.insert(cliente)
            onBackPressed()
        })
    }


}
