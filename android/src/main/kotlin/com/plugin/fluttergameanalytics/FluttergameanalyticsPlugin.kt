package com.plugin.fluttergameanalytics

import android.app.Activity
import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import androidx.annotation.NonNull
import com.gameanalytics.sdk.GameAnalytics
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.embedding.engine.plugins.activity.ActivityAware
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry.Registrar


/** FluttergameanalyticsPlugin */
public class FluttergameanalyticsPlugin : FlutterPlugin, MethodCallHandler, ActivityAware {

    private lateinit var channel: MethodChannel
    private lateinit var activity: Activity


    override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
        channel = MethodChannel(flutterPluginBinding.binaryMessenger, "fluttergameanalytics")
        channel.setMethodCallHandler(this)
    }

    companion object {
        @JvmStatic
        fun registerWith(registrar: Registrar) {
            val channel = MethodChannel(registrar.messenger(), "fluttergameanalytics")
            channel.setMethodCallHandler(FluttergameanalyticsPlugin().apply { activity = registrar.activity() })
        }
    }

    override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: Result) {
        when (call.method) {
            "initialize" -> {
                val gameKey = call.argument<String>("game_key")
                val secretKey = call.argument<String>("secret_key")
                if (gameKey == null || secretKey == null) {
                    result.error(
                            "KEY_ERROR",
                            "game_key or secret_key should not be null",
                            null
                    )
                    return
                }
                initializeGameAnalytics(activity, gameKey, secretKey)
                result.success(true)
            }
            else -> {
                result.notImplemented()
            }
        }
    }

    override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
        channel.setMethodCallHandler(null)
    }

    private fun initializeGameAnalytics(activity: Activity, gameKey: String, secretKey: String) {
        val pm: PackageManager = activity.packageManager
        val info: PackageInfo = pm.getPackageInfo(activity.packageName, 0)
        GameAnalytics.configureBuild(info.versionName)
        GameAnalytics.initializeWithGameKey(activity, gameKey, secretKey)
    }

    override fun onDetachedFromActivity() {
    }

    override fun onReattachedToActivityForConfigChanges(binding: ActivityPluginBinding) {
    }

    override fun onAttachedToActivity(binding: ActivityPluginBinding) {
        activity = binding.activity
    }

    override fun onDetachedFromActivityForConfigChanges() {
    }
}
