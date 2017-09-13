package pers.victor.ext

import android.content.Context
import android.graphics.Point
import android.util.DisplayMetrics
import android.view.WindowManager


/**
 * Created by Victor on 2017/8/21. (ง •̀_•́)ง
 */

val screenWidth: Int
    get() = app.resources.displayMetrics.widthPixels

val screenHeight: Int
    get() = app.resources.displayMetrics.heightPixels

val screenDensity: Float
    get() = app.resources.displayMetrics.density

val scaledDensity: Float
    get() = app.resources.displayMetrics.scaledDensity

fun dp2px(dp: Number) = (dp.toFloat() * app.resources.displayMetrics.density + 0.5f).toInt()

fun sp2px(sp: Number) = (sp.toFloat() * app.resources.displayMetrics.scaledDensity + 0.5f).toInt()

fun px2dp(px: Number) = (px.toFloat() / app.resources.displayMetrics.density + 0.5f).toInt()

fun px2sp(px: Number) = (px.toFloat() / app.resources.displayMetrics.scaledDensity + 0.5f).toInt()

fun getStatusBarHeight(): Int {
    var result = 0
    val resourceId = app.resources.getIdentifier("status_bar_height", "dimen", "android")
    if (resourceId > 0) {
        result = app.resources.getDimensionPixelSize(resourceId)
    }
    return result
}

fun getVirNavBarHeight(): Int {
    val wm = (app.getSystemService(Context.WINDOW_SERVICE) as WindowManager)
    val display = wm.defaultDisplay
    val p = Point()
    display.getSize(p)
    val screenHeight = Math.max(p.y, p.x)
    val dm = DisplayMetrics()
    val c: Class<*> = Class.forName("android.view.Display")
    val method = c.getMethod("getRealMetrics", DisplayMetrics::class.java)
    method.invoke(display, dm)
    return Math.max(dm.heightPixels, dm.widthPixels) - screenHeight
}