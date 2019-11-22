package com.jqk.first

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import com.jqk.first.databinding.ActivityMainBinding
import com.tbruyelle.rxpermissions2.RxPermissions
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    lateinit var rxPermissions: RxPermissions

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.view = this

        rxPermissions = RxPermissions(this)

        rxPermissions
            .request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            .subscribe({ granted ->
                if (granted) {

                } else {

                }
            })
    }

    fun urlprotocol(view: View) {
        binding.message.text = FFmpegHelloWorld.urlprotocolinfo()
    }

    fun avformat(view: View) {
        binding.message.text = FFmpegHelloWorld.avformatinfo()
    }

    fun avcodec(view: View) {
        binding.message.text = FFmpegHelloWorld.avcodecinfo()
    }

    fun avfilter(view: View) {
        try {
            binding.message.text = FFmpegHelloWorld.avfilterinfo()
        } catch (e: Exception) {
            Log.d("ffmpegtest", "e = " + e.toString())
        }

    }

    fun configuration(view: View) {
        binding.message.text = FFmpegHelloWorld.configurationinfo()
    }
}
