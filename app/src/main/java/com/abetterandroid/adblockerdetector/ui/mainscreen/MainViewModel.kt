package com.abetterandroid.adblockerdetector.ui.mainscreen

import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _hasAdBlocker = MutableLiveData<Boolean>()
    val hasAdBlocker: LiveData<Boolean> = _hasAdBlocker

    private val _adBlockerName = MutableLiveData<String>()
    val adBlockerName: LiveData<String> = _adBlockerName

    fun checkForAdBlocker(context: Context) {
        val adBlockerPackages = listOf(
            "com.savageorgiev.blockthis",
            "org.adaway",
            "org.blokada.alarm",
            "org.blokada.origin.alarm",
            "org.blokada.plus",
            "org.dschuermann.adaway",
            "com.github.adblockremover",
            "com.stevesoltys.seedvault.plugins.adblocker",
            "com.industries.tracer.apprtc",
            "com.blokada.lite",
            "com.blokada.alarm.lite"
            // Add any additional package names here
        )

        val packageManager = context.packageManager
        for (packageName in adBlockerPackages) {
            try {
                val packageInfo = packageManager.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES)

                if (packageInfo != null) {
                    _adBlockerName.postValue(  packageInfo.packageName)
                    _hasAdBlocker.postValue(true)
                    return
                }
            } catch (e: PackageManager.NameNotFoundException) {
                Log.d("DEBUG","not found")
            }
        }
        _hasAdBlocker.postValue(false)
    }
}