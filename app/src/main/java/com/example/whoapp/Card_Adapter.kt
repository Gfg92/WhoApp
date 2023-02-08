package com.example.mymail

import android.content.Intent
import android.graphics.BitmapFactory
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import androidx.recyclerview.widget.RecyclerView
import com.example.whoapp.PictureActivity
import com.example.whoapp.R

class Card_Adapter(var items: ArrayList<Card>) :
    RecyclerView.Adapter<Card_Adapter.TarjViewHolder>(){
    lateinit var onClick: (View) -> Unit

    class TarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnCreateContextMenuListener  {

        private var imagen: ImageView
        private var titulo: TextView

        init {
            imagen = itemView.findViewById(R.id.imagen_imageView)
            titulo = itemView.findViewById(R.id.textView_card)
            itemView.setOnCreateContextMenuListener(this)

        }

        fun bindTarjeta(t: Card) = with(itemView) {
            titulo.setText(t.titulo)
            // Hacer redonda la imagen
            val bm = BitmapFactory.decodeResource(itemView.resources, t.imagen)
            val drawable = RoundedBitmapDrawableFactory.create(itemView.resources, bm)
            drawable.isCircular = true
            imagen.setImageDrawable(drawable)

            // Al clicar sobre el título de la targeta, es decir el nombre, te lleva a otra actividad
            titulo.setOnClickListener {
                val intent = Intent(itemView.context, PictureActivity::class.java)
                itemView.context.startActivity(intent)
            }



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