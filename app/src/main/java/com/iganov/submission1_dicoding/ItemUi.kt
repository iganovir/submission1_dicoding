package com.iganov.submission1_dicoding

import android.content.Context
import android.view.View
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by IGANOV on 9/15/2018.
 */
class ItemUi : AnkoComponent<Context> {
    override fun createView(ui: AnkoContext<Context>): View = with(ui){
        relativeLayout {
            padding = 20

            imageView {
                id = R.id.imageItem
                imageResource = R.drawable.img_arsenal
            }.lparams {
                width = dip(40)
                height = dip(40)
                setMargins(0, 0, dip(16), 0)

            }

            textView {
                textSize = sp(10).toFloat()
                id = R.id.textItem
                text = "ini text"
            }.lparams{
                width = wrapContent
                height = wrapContent
                rightOf(R.id.imageItem)
            }


        }
    }

}