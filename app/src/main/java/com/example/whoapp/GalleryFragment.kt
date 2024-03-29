package com.example.menucontabs

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.utils.widget.ImageFilterView
import androidx.core.app.ActivityOptionsCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.*
import com.example.mymail.Card
import com.example.mymail.Card_Adapter
import com.example.whoapp.PictureActivity
import com.example.whoapp.R

class GalleryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val items = ArrayList<Card>()
        items.add(Card(R.mipmap.image1, R.string.card1))
        items.add(Card(R.mipmap.image2, R.string.card2))
        items.add(Card(R.mipmap.image3, R.string.card3))
        items.add(Card(R.mipmap.image4, R.string.card4))
        items.add(Card(R.mipmap.image5, R.string.card5))
        items.add(Card(R.mipmap.image6, R.string.card6))
        items.add(Card(R.mipmap.image7, R.string.card7))
        items.add(Card(R.mipmap.image8, R.string.card8))
        items.add(Card(R.mipmap.image9, R.string.card9))


        val recView = view.findViewById<RecyclerView>(R.id.recView)
        recView.setHasFixedSize(true)

        val adaptador = Card_Adapter(items)
        recView.adapter = adaptador
        recView.layoutManager = GridLayoutManager(context, StaggeredGridLayoutManager.VERTICAL)

        recView.itemAnimator = DefaultItemAnimator()

        adaptador.onClick = {
            // Al clicar sobre la tarjeta, transporta el texto y la imagen a otra actividad
//            val intent = Intent(activity, PictureActivity::class.java)
//            intent.putExtra("titulo", items[recView.getChildAdapterPosition(it)].titulo)
//            intent.putExtra("image", items[recView.getChildAdapterPosition(it)].imagen)
//            startActivity(intent)


            // Al clicar sobre la tarjeta, transporta el texto y la imagen a otra actividad con una ANIMACION
            val intent = Intent(activity, PictureActivity::class.java)
            val title = items[recView.getChildAdapterPosition(it)].titulo
            val imagen = items[recView.getChildAdapterPosition(it)].imagen
            val img = it.findViewById<ImageView>(R.id.imagen_imageView)
            val text = it.findViewById<TextView>(R.id.textView_card)
            val p1 = androidx.core.util.Pair<View, String>(img, img.transitionName)
            val p2 = androidx.core.util.Pair<View, String>(text, text.transitionName)
            // Transicion
            val options =
                ActivityOptionsCompat.makeSceneTransitionAnimation(context as Activity, p1,p2)
                    .toBundle()
            options?.putInt("image", imagen)
            options?.putInt("titulo", title)
            //Añadimos la información al Intent
            intent.putExtras(options!!)
            startActivity(intent, options)

        }


    }


}


