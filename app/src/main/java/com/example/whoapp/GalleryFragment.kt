package com.example.menucontabs

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.*
import com.example.mymail.Card
import com.example.mymail.Card_Adapter
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
            val t = items[recView.getChildAdapterPosition(it)]
            val idtext: TextView = recView.findViewById(R.id.textView)
            val bundle = bundleOf("NOM" to getString(t.titulo))
            val extras = FragmentNavigatorExtras(idtext to "trantext")
            findNavController().navigate(
                R.id.action_galleryFragment_to_pictureFragment,
                bundle,
                null,
                extras
            )
        }


    }


}


