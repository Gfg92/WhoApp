package com.example.mymail

import android.graphics.BitmapFactory
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import com.example.whoapp.R

class Card_Adapter(var items: ArrayList<Card>) :
    RecyclerView.Adapter<Card_Adapter.TarjViewHolder>(){


    init {
        this.items = items
    }

    class TarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnCreateContextMenuListener  {

        private var imagen: ImageView
        private var titulo: TextView




        init {
            imagen = itemView.findViewById(R.id.imagen_imageView)
            titulo = itemView.findViewById(R.id.textView)
            itemView.setOnCreateContextMenuListener(this)

        }

        fun bindTarjeta(t: Card) = with(itemView) {
//            imagen.setImageResource(t.imagen)
            titulo.setText(t.titulo)
//            val fotouser = itemView.findViewById<ImageView>(t.imagen)
            val bm = BitmapFactory.decodeResource(itemView.resources, t.imagen)
            val drawable = RoundedBitmapDrawableFactory.create(itemView.resources, bm)
            drawable.isCircular = true
            imagen.setImageDrawable(drawable)

        }

        override fun onCreateContextMenu(contextMenu: ContextMenu, view: View, contextMenuInfo: ContextMenu.ContextMenuInfo?) {
            contextMenu.add(0, 0, adapterPosition, "Editar")     //groupId, itemId, order, title
            contextMenu.add(0, 1, adapterPosition, "Eliminar")
            contextMenu.add(0, 2, adapterPosition, "Compartir")
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TarjViewHolder {
        val itemView =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.card_item, viewGroup, false)
        return TarjViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: TarjViewHolder, pos: Int) {
        val item = items.get(pos)
        viewHolder.bindTarjeta(item)




    }

    override fun getItemCount(): Int {
        return items.size
    }

}