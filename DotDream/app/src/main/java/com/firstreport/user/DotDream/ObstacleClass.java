package com.firstreport.user.DotDream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by user on 2017-06-28.
 */

public class ObstacleClass {

    protected ViewGroup mLayout;
    private ViewGroup.LayoutParams params;
    private Context mContext;

    private DrawCanvas draw;
    private Paint paint;
    private Bitmap obstacle;
    private Bitmap resized;
    private int obstacle_width, obstacle_height;
    public int resized_width, resized_height;

    private int Obstacle_ALPHA = 200;
    public int position_x, position_y;

    public ObstacleClass (Context context, ViewGroup layout, int obstacle_res_id) {
        mContext = context;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 1;
        obstacle = BitmapFactory.decodeResource(mContext.getResources(), obstacle_res_id, options);

        obstacle_width = obstacle.getWidth()/10;
        obstacle_height = obstacle.getHeight()/10;

        draw = new DrawCanvas(mContext);
        paint = new Paint();
        mLayout = layout;
        params = mLayout.getLayoutParams();
    }


    public void resized_image(int x, int y)
    {
        resized = obstacle.createScaledBitmap(obstacle, x, y, true);

        resized_width = resized.getWidth();
        resized_height = resized.getHeight();

    }

    public boolean ending_position(int x, int y, int z, int t)
    {
        if(x == position_x && y == position_x)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void position_effect()
    {
        draw.position(position_x, position_y);
        draw();
    }


    public void position(int x, int y)
    {
        position_x = x;
        position_y = y;
    }

    public void setPosition(int x, int y)
    {
        position_x += x;
        position_y += y;
        draw.position(position_x, position_y);
        draw();
    }

    public void setObstacleSize(int width, int height) {
        obstacle = Bitmap.createScaledBitmap(obstacle, width, height, false);
        obstacle_width = obstacle.getWidth();
        obstacle_height = obstacle.getHeight();
    }

    private void draw() {
        try {
            mLayout.removeView(draw);
        } catch (Exception e) { }
        mLayout.addView(draw);
    }

    public void setObstacleAlpha(int alpha) {
        Obstacle_ALPHA = alpha;
        paint.setAlpha(alpha);
    }

    public void setLayoutSize(int width, int height) {
        params.width = width;
        params.height = height;
    }

    public int getLayoutWidth() {
        return params.width;
    }

    public int getLayoutHeight() {
        return params.height;
    }

    class DrawCanvas extends View {
        float x, y;

        private DrawCanvas(Context mContext) {
            super(mContext);
        }

        public void onDraw(Canvas canvas) {
            canvas.drawBitmap(resized, x, y, paint);
        }

        private void position(float pos_x, float pos_y) {
            x = pos_x - (obstacle_width / 2);
            y = pos_y - (obstacle_height / 2);
        }
    }

    public void empty()
    {
        resized.recycle();
        resized=null;
        obstacle.recycle();
        obstacle = null;
    }

}
