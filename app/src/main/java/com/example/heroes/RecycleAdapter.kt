package com.example.heroes

import android.view.LayoutInflater
import androidx.appcompat.view.menu.MenuView.ItemView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecycleAdapter(private val heroList:ArrayList<Hero> )
    :RecyclerView.Adapter<RecycleAdapter.HeroViewHolder>(){
    var onItemClick:((Hero)->Unit)?=null

    class HeroViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_body)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.card_layout,parent,false)
        return HeroViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        val hero = heroList[position]
        holder.itemImage.setImageResource(hero.image)
        holder.itemTitle.text=hero.title
        holder.itemDetail.text=hero.description
        holder.itemView.setOnClickListener {
          onItemClick?.invoke(hero)
        }
    }

    override fun getItemCount(): Int {
        return heroList.size
    }
}