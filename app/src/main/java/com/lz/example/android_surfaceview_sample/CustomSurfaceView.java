package com.lz.example.android_surfaceview_sample;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by lz on 2017/12/6.
 */

public class CustomSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    private Paint textPaint;

    private Paint rectPaint;

    private Canvas canvas;

    private SurfaceHolder holder;

    public CustomSurfaceView(Context context) {
        this(context, null);
    }

    public CustomSurfaceView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        holder = getHolder();
        holder.addCallback(this);
        textPaint = new TextPaint();
        textPaint.setColor(getResources().getColor(R.color.colorAccent));
        textPaint.setTextSize(18);
        rectPaint = new TextPaint();
        rectPaint.setColor(getResources().getColor(R.color.colorPrimary));
    }

    private void draw() {
        canvas = holder.lockCanvas();
        BitmapDrawable drawable = (BitmapDrawable) getResources().getDrawable(R.mipmap.ic_launcher);
        drawImage(drawable.getBitmap());
        drawRect();
        drawText();
        holder.unlockCanvasAndPost(canvas);
    }

    private void drawImage(Bitmap bitmap) {
        canvas.drawBitmap(bitmap, 100, 0, new Paint());
    }

    private void drawText() {
        canvas.drawText("画一行文字", 100, 500, textPaint);
    }

    private void drawRect() {
        Rect rect = new Rect(100, 200, 500, 350);
        canvas.drawRect(rect, rectPaint);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        draw();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
