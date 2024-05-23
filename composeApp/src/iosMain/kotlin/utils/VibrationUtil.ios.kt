package utils



import platform.UIKit.UIDevice

 class VibrationUtilIos  constructor() : VibrationUtil {
     override fun vibrate() {
        UIDevice.currentDevice.playInputClick()
    }
}

actual fun getVibrationUtil(context: Any): VibrationUtil = VibrationUtilIos()