/*
 * Created by 动脑科技-Tim on 17-6-21 下午10:31
 * Copyright (c) 2017. All rights reserved
 *
 * Last modified 17-6-21 下午10:31
 */

package com.dn.tim.timcompiler

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import com.example.Need
import com.example.OnDeined
import com.example.OnNeverAsk
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() ,AnkoLogger{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bt1.setOnClickListener {
            MainActivityPermission.showCamera(this)
        }
        bt2.setOnClickListener {
            MainActivityPermission.showLocation(this)
        }
    }

    @Need(arrayOf(Manifest.permission.CAMERA))
    fun showCamera() {
        toast(" Camera  权限申请成功")
    }

    @Need(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION))
    fun showLocation(){
        toast("Location 权限申请成功")
    }

    @OnDeined(arrayOf(Manifest.permission.CAMERA))
    fun deniedCamera() {
        toast("Camera 权限申请失败")
    }

    @OnDeined(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION))
    fun deniedLocation() {
        toast("Location 权限申请失败")
    }

    @OnNeverAsk(arrayOf(Manifest.permission.CAMERA))
    fun neverAskCamera (){
        toast("Camera 权限申请不再询问")
        val localIntent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:$packageName"))
        startActivity(localIntent)
    }

    @OnNeverAsk(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION))
    fun neverAskLocation (){
        toast("Location 权限申请不再询问")
        val localIntent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:$packageName"))
        startActivity(localIntent)
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        MainActivityPermission.onRequestPermissionsResult(this,requestCode, grantResults)
    }
}
