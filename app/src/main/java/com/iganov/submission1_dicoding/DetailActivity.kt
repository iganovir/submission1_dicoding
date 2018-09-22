package com.iganov.submission1_dicoding

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

/**
 * Created by IGANOV on 9/17/2018.
 */
class DetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DetailUi().setContentView(this)

        val intent = getIntent()
        val gambar = findViewById<ImageView>(R.id.imageDetail)
        val judul = findViewById<TextView>(R.id.titleDetail)
        val desc = findViewById<TextView>(R.id.descDetail)

        var image:Int = intent.getIntExtra("image",R.drawable.img_acm)
        Glide.with(this).load(image).into(gambar)
        judul.text = intent.getStringExtra("judul")
        desc.text = intent.getStringExtra("judul") + " is a professional football club"

    }

    class DetailUi : AnkoComponent<DetailActivity>
    {
        override fun createView(ui: AnkoContext<DetailActivity>): View = with(ui) {
            verticalLayout {
                gravity = Gravity.CENTER_HORIZONTAL

                imageView {
                    id = R.id.imageDetail
                }.lparams(
                        width = 100,
                        height = 100
                )

                textView {
                    id = R.id.titleDetail
                }.lparams(
                        width = wrapContent,
                        height = wrapContent
                )

                textView {
                id = R.id.descDetail
                 }.lparams(
                        width = wrapContent,
                        height = wrapContent
                )

            }
        }
    }
}

