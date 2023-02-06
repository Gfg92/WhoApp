package com.example.menucontabs

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
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


        val items = ArrayList<Card>()
        items.add(Card(R.mipmap.image1, "Card 1"))
        items.add(Card(R.mipmap.image2, "Card 2"))
        items.add(Card(R.mipmap.image3, "Card 3"))
        items.add(Card(R.mipmap.image4, "Card 4"))
        items.add(Card(R.mipmap.image5, "Card 5"))
        items.add(Card(R.mipmap.image6, "Card 6"))
        items.add(Card(R.mipmap.image7, "Card 7"))
        items.add(Card(R.mipmap.image8, "Card 8"))
        items.add(Card(R.mipmap.image9, "Card 9"))


        val recView = root.findViewById<RecyclerView>(R.id.recView)

        recView.setHasFixedSize(true)

        val adaptador = Card_Adapter(items)
        recView.adapter = adaptador
        recView.layoutManager = GridLayoutManager(context, StaggeredGridLayoutManager.VERTICAL)

        recView.itemAnimator = DefaultItemAnimator()

        return root
    }


}


