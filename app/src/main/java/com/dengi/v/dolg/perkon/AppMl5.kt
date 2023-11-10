package com.dengi.v.dolg.perkon

import android.app.Application
import com.my.tracker.MyTracker
import com.yandex.metrica.YandexMetrica
import com.yandex.metrica.YandexMetricaConfig
import dagger.hilt.android.HiltAndroidApp
import com.dengi.v.dolg.perkon.data.APP_METRICA
import com.dengi.v.dolg.perkon.data.MY_TRACKER
import com.dengi.v.dolg.perkon.data.USER_X
import pro.userx.UserX

@HiltAndroidApp
class AppMl5 : Application() {
    override fun onCreate() {
        super.onCreate()

        val config = YandexMetricaConfig.newConfigBuilder(APP_METRICA).build()


        MyTracker.initTracker(MY_TRACKER, this)
        YandexMetrica.activate(applicationContext, config)
        YandexMetrica.enableActivityAutoTracking(this)
        UserX.init(USER_X)
    }
}