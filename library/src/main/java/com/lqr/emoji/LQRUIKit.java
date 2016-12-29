package com.lqr.emoji;

import android.content.Context;
import android.util.DisplayMetrics;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * UIKit能力输出类。
 */
public final class LQRUIKit {

    // context
    private static Context context;

    public static float density;
    public static float scaleDensity;

    /**
     * 初始化UIKit，须传入context以及用户信息提供者
     *
     * @param context 上下文
     */
    public static void init(Context context) {
        LQRUIKit.context = context.getApplicationContext();

        StickerManager.getInstance().init();

        //初始化ImageLoader
        ImageLoader.getInstance().init(
                ImageLoaderConfiguration.createDefault(getContext()));

        DisplayMetrics dm = context.getApplicationContext().getResources().getDisplayMetrics();
        density = dm.density;
        scaleDensity = dm.scaledDensity;
    }

    public static Context getContext() {
        return context;
    }

    public static int dip2px(float dipValue) {
        return (int) (dipValue * density + 0.5f);
    }

    public static int px2dip(float pxValue) {
        return (int) (pxValue / density + 0.5f);
    }

    public static int sp2px(float spValue) {
        return (int) (spValue * scaleDensity + 0.5f);
    }

    public static boolean hasExtentsion(String filename) {
        int dot = filename.lastIndexOf('.');
        if ((dot > -1) && (dot < (filename.length() - 1))) {
            return true;
        } else {
            return false;
        }
    }
}
