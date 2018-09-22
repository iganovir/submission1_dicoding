package com.iganov.submission1_dicoding

import android.content.res.Resources
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.sdk25.coroutines.onClick


class MainActivity : AppCompatActivity() {
    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)

        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)

        items.clear()
        for (i in name.indices) {
            items.add(Item(name[i],
                    image.getResourceId(i, 0)))
        }

        val rv = findViewById<RecyclerView>(R.id.rv)
        rv.adapter = RecyclerViewAdapter(this, items) {
            startActivity<DetailActivity>(
                    "judul" to it.name,
                    "image" to it.image.toString())
        }
        image.recycle()
    }

        class MainActivityUI : AnkoComponent<MainActivity> {
            override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
                verticalLayout {
                    recyclerView {
                        id = R.id.rv
                        lparams(width = matchParent, height = wrapContent)
                        layoutManager = LinearLayoutManager(ctx)

                    }
                }
            }
        }



    }
