package utils

interface VibrationUtil {
    fun vibrate()
}

expect fun getVibrationUtil(context :Any): VibrationUtil