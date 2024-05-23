public class AndroidPlatform : Platform {
//    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
override val name: String = "android"
}

actual fun getPlatform(): Platform = AndroidPlatform()
