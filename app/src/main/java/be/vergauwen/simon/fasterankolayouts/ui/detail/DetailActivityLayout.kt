package be.vergauwen.simon.fasterankolayouts.ui.detail

import android.support.design.widget.AppBarLayout
import android.view.View
import be.vergauwen.simon.fasterankolayouts.R
import be.vergauwen.simon.fasterankolayouts.ui.ViewBinder
import be.vergauwen.simon.fasterankolayouts.ui.anko.actionBarSize
import be.vergauwen.simon.fasterankolayouts.ui.anko.color
import org.jetbrains.anko.UI
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.design.appBarLayout
import org.jetbrains.anko.design.collapsingToolbarLayout
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.dip
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.support.v4.nestedScrollView


class DetailActivityLayout : ViewBinder<DetailActivity> {

    override fun bind(detailActivity: DetailActivity): View =
            detailActivity.UI {
                coordinatorLayout {
                    appBarLayout {
                        collapsingToolbarLayout {
                            setContentScrimColor(color(R.color.colorPrimary))
                            id = R.id.toolbar_layout

                            detailActivity.toolbar = toolbar {
                                setSupportActionBar(this)
                                supportActionBar?.setDisplayHomeAsUpEnabled(true)
                            }.lparams(width = matchParent, height = actionBarSize())
                        }.lparams(width = matchParent, height = matchParent)
                    }.lparams(width = matchParent, height = dip(200))

                    detailActivity.detailContainer = nestedScrollView {
                        id = R.id.item_detail_container
                    }.lparams(width = matchParent, height = matchParent) {
                        behavior = AppBarLayout.ScrollingViewBehavior()
                    }
                }
            }.view

    override fun unbind(detailActivity: DetailActivity) {
        detailActivity.toolbar = null
        detailActivity.detailContainer = null
    }
}
