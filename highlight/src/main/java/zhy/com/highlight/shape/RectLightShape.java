package zhy.com.highlight.shape;

import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import zhy.com.highlight.HighLight;

/**
 * Created by caizepeng on 16/8/20.
 * Edited by isanwenyu@163.com 16/10/26.
 */
public class RectLightShape extends BaseLightShape {

    private boolean blur = true;

    public RectLightShape() {
    }


    public RectLightShape(float padding) {
        super(padding, padding);
    }

    public RectLightShape(boolean blur) {
        this.blur = blur;
    }

    public RectLightShape(float padding, boolean blur) {
        super(padding, padding);
        this.blur = blur;
    }

    public RectLightShape(float dx, float dy) {
        super(dx, dy);
    }

    @Override
    protected void drawShape(Bitmap bitmap, HighLight.ViewPosInfo viewPosInfo) {
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setDither(true);
        paint.setAntiAlias(true);
        if (blur)
            paint.setMaskFilter(new BlurMaskFilter(15, BlurMaskFilter.Blur.SOLID));
        canvas.drawRoundRect(viewPosInfo.rectF,6,6,paint);
    }

    @Override
    protected void resetRectF4Shape(RectF viewPosInfoRectF, float dx, float dy) {
        viewPosInfoRectF.inset(dx,dy);
    }
}
