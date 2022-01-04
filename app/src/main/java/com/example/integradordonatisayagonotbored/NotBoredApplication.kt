package com.example.integradordonatisayagonotbored

import android.app.Application

//application to instance the prefs class
class NotBoredApplication : Application() {

    companion object{
        lateinit var prefs: Prefs
    }

    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(applicationContext)
    }

}