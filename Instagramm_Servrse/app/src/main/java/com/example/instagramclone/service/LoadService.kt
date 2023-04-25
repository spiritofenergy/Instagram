package com.example.instagramclone.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast
import kotlinx.coroutines.DelicateCoroutinesApi

import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class LoadService: Service() {
    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(this, "Service has been started", Toast.LENGTH_SHORT).show()
        startCount()
        return super.onStartCommand(intent, flags, startId)

    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("check", "Service: onDestroy on stopped")
        Toast.makeText(this,"Service on stopped", Toast.LENGTH_SHORT).show()

    }
    @OptIn(DelicateCoroutinesApi::class)

    private fun startCount() {
        GlobalScope.launch {
            for (i in 0 until 20){
                Log.d("check", "Service:: Count $i")
                delay(2000)
                if(i == 19)
                    stopSelf()
            }


        }
    }
}