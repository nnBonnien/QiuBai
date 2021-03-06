package com.jianda.qiubai.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;

import com.squareup.picasso.Transformation;

/**
 * Created by Administrator on 15-12-29.
 */
public class CircleTransform implements Transformation{
    @Override
    public Bitmap transform(Bitmap source) {
        Bitmap result = Bitmap.createBitmap(source.getWidth(),source.getHeight(),Bitmap.Config.ARGB_8888);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(source, Shader.TileMode.CLAMP,Shader.TileMode.CLAMP));
        paint.setAntiAlias(true);
        new Canvas(result).drawCircle(source.getWidth()/2,source.getHeight()/2,Math.min(source.getWidth(),source.getHeight())/2,paint);
        source.recycle();
        return result;
    }

    @Override
    public String key() {
        return "circle";
    }
}
