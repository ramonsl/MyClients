
package com.ramonsl.myclients

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ClienteAdapter (private val clientes: List<Cliente>):
    RecyclerView.Adapter<ClienteAdapter.VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        Log.v("LOG", "onCreate")
        val v= LayoutInflater.from(parent.context).inflate(R.layout.cliente_item,parent,false)
        val vh = VH(v)


        vh.itemView.setOnClickListener{
            val cliente= clientes[vh.adapterPosition]
            val it = Intent(parent.context,UpdateActivity::class.java)
            it.putExtra("cliente",cliente)
           parent.context.startActivity(it)

        }
        return vh
    }

    override fun getItemCount(): Int {
        return clientes.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        Log.v("LOG", "ViewHolder")
        var cliente = clientes[position]
        holder.txtFoneCliente.text=cliente.fone.toString()
        holder.txtNomeCliente.text=cliente.nome.toString()
        holder.txtIdadeCliente.text=cliente.idade.toString()
    }



    class VH(view: View) : RecyclerView.ViewHolder(view) {

        var txtNomeCliente = view.findViewById<TextView>(R.id.txtNameCliente)
        var txtIdadeCliente = view.findViewById<TextView>(R.id.txtIdadeCliente)
        var txtFoneCliente = view.findViewById<TextView>(R.id.txtFoneCliente)
        init {
            // Define click listener for the ViewHolder's View.
            txtFoneCliente = view.findViewById(R.id.txtFoneCliente)
            txtIdadeCliente = view.findViewById(R.id.txtIdadeCliente)
            txtNomeCliente= view.findViewById(R.id.txtNameCliente)

        }
    }
}