package com.lqr.emoji;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;

public class BitmapDecoder {
    public static Bitmap decode(InputStream is) {
        BitmapFactory.Options options = new BitmapFactory.Options();

        // RGB_565
        options.inPreferredConfig = Bitmap.Config.RGB_565;

        /**
         * 在4.4上，如果之前is标记被移动过，会导致解码失败
         */
        try {
            if (is.markSupported()) {
                is.reset();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            return BitmapFactory.decodeStream(is, null, options);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }

        return null;
    }

   
}