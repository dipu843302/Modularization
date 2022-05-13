package com.example.flightmode

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.widget.Toast

class AirplaneModeChangeReceiver :BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (isAirplaneModeOn(context!!.applicationContext)){
            Toast.makeText(context, "Airplane mode is on", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context, "Airplane mode is off", Toast.LENGTH_SHORT).show()
        }
    }

    private fun isAirplaneModeOn(applicationContext: Context?): Boolean {
            return Settings.System.getInt(applicationContext!!.contentResolver,Settings.Global.AIRPLANE_MODE_ON,0)!=0
    }
}