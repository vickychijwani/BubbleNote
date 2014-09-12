package io.github.vickychijwani.bubblenote;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

public class Utils {

    private static Point sScreenSize = null;

    private Utils() {}

    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public static int getScreenWidth(Context context) {
        fetchScreenSize(context);
        return sScreenSize.x;
    }

    public static int getScreenHeight(Context context) {
        fetchScreenSize(context);
        return sScreenSize.y;
    }

    private static void fetchScreenSize(Context context) {
        if (sScreenSize != null) return;
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        sScreenSize = new Point();
        display.getSize(sScreenSize);
    }

}
