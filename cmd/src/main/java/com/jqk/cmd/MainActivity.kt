package com.jqk.cmd

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tbruyelle.rxpermissions2.RxPermissions
import android.R.attr.duration
import android.widget.Button


class MainActivity : AppCompatActivity() {
    lateinit var rxPermissions: RxPermissions
    lateinit var exit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rxPermissions = RxPermissions(this)

        rxPermissions
            .request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            .subscribe({ granted ->
                if (granted) {
                    Log.d("ffmpegcmd", "请求权限")
                    ffmpegTest()
                } else {

                }
            })

        exit = findViewById(R.id.exit)

        exit.setOnClickListener {
            Thread(Runnable {
                FFmpegCmd.exit()
            })
        }
    }

    fun ffmpegTest() {
        val startTime = System.currentTimeMillis()
        val input = "/storage/emulated/0/570539629.mp4"
        val output = "/storage/emulated/0/output.mp4"
        //剪切视频从00：20-00：28的片段
        var cmd = "ffmpeg -d -ss 00:00:05 -t 00:00:05 -i %s -vcodec copy -acodec copy %s"
        cmd = String.format(cmd, input, output)
        cmd.split(" ")

        var cmd2 = "ffmpeg -y -i %s -b 2097k -r 30 -vcodec libx264 -preset superfast %s"
        cmd2 = String.format(cmd2, input, output)
        cmd2.split(" ")

        val cmdList = CmdList()
        cmdList.append(cmd2.split(" ").toTypedArray())

        FFmpegUtil.execCmd(cmdList, 1, object : OnVideoProcessListener {
            override fun onProcessStart() {
                Log.d("ffmpegcmd", "onProcessStart")
            }

            override fun onProcessProgress(progress: Float) {
                Log.d("ffmpegcmd", "onProcessProgress = " + progress)
            }

            override fun onProcessSuccess() {
                Log.d("ffmpegcmd", "onProcessSuccess")
            }

            override fun onProcessFailure() {
                Log.d("ffmpegcmd", "onProcessFailure")
            }
        })

    }
}
