package tw.edu.pu.o10830100.myapplication

import android.graphics.Bitmap
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.module.AppGlideModule
import jp.wasabeef.glide.transformations.BlurTransformation
import jp.wasabeef.glide.transformations.ColorFilterTransformation
import jp.wasabeef.glide.transformations.GrayscaleTransformation
import jp.wasabeef.glide.transformations.RoundedCornersTransformation
import jp.wasabeef.glide.transformations.gpu.SketchFilterTransformation
import jp.wasabeef.glide.transformations.gpu.ToonFilterTransformation
import tw.edu.pu.o10830100.myapplication.GlideOptions.bitmapTransform

@GlideModule
public final class MyAppGlideModule : AppGlideModule()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val multi = MultiTransformation<Bitmap>(
            //SketchFilterTransformation(),//
            ToonFilterTransformation(),
                    RoundedCornersTransformation(128, 0, RoundedCornersTransformation.CornerType.ALL),
            //ColorFilterTransformation(Color.argb(0, 100, 100, 0))//
              GrayscaleTransformation()

        )


        val img:ImageView = findViewById(R.id.img2)
        GlideApp.with(this)
            .load(R.drawable.sea)
            .apply(bitmapTransform(multi))
            .into(img)


    }
}