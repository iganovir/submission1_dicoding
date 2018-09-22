package com.iganov.submission1_dicoding

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.*

/**
 * Created by IGANOV on 9/15/2018.
 */
class RecyclerViewAdapter(private val context: Context, private val items: List<Item>, private val listener: (Item) -> Unit)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder{
        return ViewHolder(ItemUi().createView(AnkoContext.create(parent.context)))
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)

        holder.itemView.setOnClickListener {
            val intent = Intent(context,DetailActivity::class.java)
            intent.putExtra("image",items[position].image)
            intent.putExtra("judul",items[position].name)
            context.startActivity(intent)

        }

    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(override val containerView: View?) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        private val name = containerView?.findViewById<TextView>(R.id.textItem)
        private val image = containerView?.findViewById<ImageView>(R.id.imageItem)

        fun bindItem(items: Item, listener: (Item) -> Unit) {
            if(name != null)
            {
                name.text = items.name
            }
            Glide.with(itemView.context).load(items.image).into(image)
            itemView.setOnClickListener {
                listener(items)

            }
        }

    }
}