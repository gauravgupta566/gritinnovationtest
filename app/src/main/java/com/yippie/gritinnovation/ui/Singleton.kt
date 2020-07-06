package com.yippie.gritinnovation.ui

import android.content.res.Resources

object Singleton {


        fun dpToPx(value: Int): Int {
            val density = Resources.getSystem().getDisplayMetrics().density

            return Math.round(value * density)

        }

}