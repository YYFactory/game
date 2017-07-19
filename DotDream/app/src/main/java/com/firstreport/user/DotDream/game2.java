package com.firstreport.user.DotDream;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by user on 2017-07-02.
 */

public class game2 extends AppCompatActivity {

    private int tile_end_x1, tile_end_y1;
    private int tile_end_x2, tile_end_y2;
    private int tile_end_x3, tile_end_y3;
    private int tile_end_x4, tile_end_y4;
    private int prior_player_x, prior_player_y;
    private int timing_number = 0, total_time_number = 50, health_timing_number = 0, level_time_number = 0;
    private int pattern_number = 0, health_number = 0;

    private int size_dm;
    private int SpeedX, SpeedY;
    private int obstacle_SpeedX, obstacle_SpeedY;
    private int obstacle_2_SpeedX, obstacle_2_SpeedY;
    private int obstacle_3_SpeedX, obstacle_3_SpeedY;
    private int screenWidth;
    private int screenHeight;
    private int frameHeight;
    private int pattern[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0};

    private boolean Isdamaged_player;
    private boolean stun_player = false;

    private Handler handler = new Handler();
    private Timer timer = new Timer();
    private ImageView player;

    private RelativeLayout layout_joystick;
    private RelativeLayout gameview2;

    private ImageView tile1_1, tile1_2, tile1_3, tile1_4, tile1_5, tile1_6, tile1_7, tile1_8, tile1_9, tile1_10;
    private ImageView tile1_11, tile1_12, tile1_13, tile1_14, tile1_15, tile1_16, tile1_17, tile1_18, tile1_19, tile1_20;
    private ImageView tile1_21, tile1_22, tile1_23, tile1_24, tile1_25, tile1_26, tile1_27, tile1_28, tile1_29, tile1_30;
    private ImageView tile1_31, tile1_32;

    private ImageView tile2_1, tile2_2, tile2_3, tile2_4, tile2_5, tile2_6, tile2_7, tile2_8, tile2_9, tile2_10;
    private ImageView tile2_11, tile2_12, tile2_13, tile2_14, tile2_15, tile2_16, tile2_17, tile2_18, tile2_19, tile2_20;
    private ImageView tile2_21, tile2_22, tile2_23, tile2_24, tile2_25, tile2_26, tile2_27, tile2_28, tile2_29, tile2_30;
    private ImageView tile2_31, tile2_32;
    private ImageView heart1, heart2, heart3;

    private TextView score, score_number, time, time_number, life;

    JoyStickClass js;

    ObstacleClass obs2_1, obs2_2_1, obs2_2_2, obs2_3_1, obs2_3_2, obs2_3_3, obs2_4_1, obs2_4_2, obs2_4_3, obs2_4_4;
    ObstacleClass obs2_5_1, obs2_5_2, obs2_5_3, obs2_5_4, obs2_5_5, obs2_6_1, obs2_6_2, obs2_6_3, obs2_6_4, obs2_6_5, obs2_6_6;
    ObstacleClass obs2_7_1, obs2_7_2, obs2_7_3, obs2_7_4, obs2_7_5, obs2_7_6, obs2_7_7, obs2_8_1, obs2_8_2, obs2_8_3, obs2_8_4;
    ObstacleClass obs2_8_5, obs2_8_6, obs2_8_7, obs2_8_8, obs2_9_1, obs2_9_2, obs2_9_3, obs2_9_4, obs2_9_5, obs2_9_6, obs2_9_7;
    ObstacleClass obs2_10_1, obs2_10_2, obs2_10_3, obs2_10_4, obs2_10_5, obs2_10_6, obs2_11_1, obs2_11_2, obs2_11_3, obs2_11_4, obs2_11_5;
    ObstacleClass obs2_12_1, obs2_12_2, obs2_12_3, obs2_12_4, obs2_13_1, obs2_13_2, obs2_13_3, obs2_14_1, obs2_14_2, obs2_15_1;

    ObstacleClass effect2_1, effect2_2_1, effect2_2_2, effect2_3_1, effect2_3_2, effect2_3_3, effect2_4_1, effect2_4_2, effect2_4_3, effect2_4_4;
    ObstacleClass effect2_5_1, effect2_5_2, effect2_5_3, effect2_5_4, effect2_5_5, effect2_6_1, effect2_6_2, effect2_6_3, effect2_6_4, effect2_6_5, effect2_6_6;
    ObstacleClass effect2_7_1, effect2_7_2, effect2_7_3, effect2_7_4, effect2_7_5, effect2_7_6, effect2_7_7, effect2_8_1, effect2_8_2, effect2_8_3, effect2_8_4;
    ObstacleClass effect2_8_5, effect2_8_6, effect2_8_7, effect2_8_8, effect2_9_1, effect2_9_2, effect2_9_3, effect2_9_4, effect2_9_5, effect2_9_6, effect2_9_7;
    ObstacleClass effect2_10_1, effect2_10_2, effect2_10_3, effect2_10_4, effect2_10_5, effect2_10_6, effect2_11_1, effect2_11_2, effect2_11_3, effect2_11_4, effect2_11_5;
    ObstacleClass effect2_12_1, effect2_12_2, effect2_12_3, effect2_12_4, effect2_13_1, effect2_13_2, effect2_13_3, effect2_14_1, effect2_14_2, effect2_15_1;


    private boolean action_flg = false;
    private boolean start_flg = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameview2);

        DisplayMetrics dm = getResources().getDisplayMetrics();
        size_dm = Math.round(dm.density);

        obstacle_SpeedX = 1;
        obstacle_SpeedY = 1;

        obstacle_2_SpeedX = -1;
        obstacle_2_SpeedY = 1;

        obstacle_3_SpeedX = 0;
        obstacle_3_SpeedY = 1;

        score_number = (TextView) findViewById(R.id.score_number);
        time_number = (TextView) findViewById(R.id.time_number);

        WindowManager wm = getWindowManager();
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);

        screenWidth = size.x;
        screenHeight = size.y;

        layout_joystick = (RelativeLayout) findViewById(R.id.layout_joystick);
        gameview2 = (RelativeLayout) findViewById(R.id.gameview2);

        js = new JoyStickClass(getApplicationContext(), layout_joystick, R.drawable.center);
        js.setStickSize(30 * size_dm, 30 * size_dm);
        js.setLayoutSize(100 * size_dm, 100 * size_dm);
        js.setLayoutAlpha(50);
        js.setStickAlpha(50);
        js.setOffset(15 * size_dm);
        js.setMinimumDistance(1 * size_dm);

        js.initial_draw(50 * size_dm, 50 * size_dm);

        obs2_1 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_1.position(65 * size_dm, 80 * size_dm);
        obs2_1.resized_image(30 * size_dm, 30 * size_dm);
        obs2_1.setObstacleAlpha(220);

        effect2_1 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_1.position(65 * size_dm, 254 * size_dm);
        effect2_1.resized_image(30 * size_dm, 30 * size_dm);
        effect2_1.setObstacleAlpha(220);

        obs2_2_1 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_2_1.position(78 * size_dm, 80 * size_dm);
        obs2_2_1.resized_image(30 * size_dm, 30 * size_dm);
        obs2_2_1.setObstacleAlpha(220);

        effect2_2_1 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_2_1.position(78 * size_dm, 242 * size_dm);
        effect2_2_1.resized_image(30 * size_dm, 30 * size_dm);
        effect2_2_1.setObstacleAlpha(220);

        obs2_2_2 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_2_2.position(78 * size_dm, 80 * size_dm);
        obs2_2_2.resized_image(30 * size_dm, 30 * size_dm);
        obs2_2_2.setObstacleAlpha(220);

        effect2_2_2 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_2_2.position(78 * size_dm, 268 * size_dm);
        effect2_2_2.resized_image(30 * size_dm, 30 * size_dm);
        effect2_2_2.setObstacleAlpha(220);

        obs2_3_1 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_3_1.position(91 * size_dm, 80 * size_dm);
        obs2_3_1.resized_image(30 * size_dm, 30 * size_dm);
        obs2_3_1.setObstacleAlpha(220);

        effect2_3_1 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_3_1.position(91 * size_dm, 229 * size_dm);
        effect2_3_1.resized_image(30 * size_dm, 30 * size_dm);
        effect2_3_1.setObstacleAlpha(220);

        obs2_3_2 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_3_2.position(91 * size_dm, 80 * size_dm);
        obs2_3_2.resized_image(30 * size_dm, 30 * size_dm);
        obs2_3_2.setObstacleAlpha(220);

        effect2_3_2 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_3_2.position(91 * size_dm, 255 * size_dm);
        effect2_3_2.resized_image(30 * size_dm, 30 * size_dm);
        effect2_3_2.setObstacleAlpha(220);

        obs2_3_3 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_3_3.position(91 * size_dm, 80 * size_dm);
        obs2_3_3.resized_image(30 * size_dm, 30 * size_dm);
        obs2_3_3.setObstacleAlpha(220);

        effect2_3_3 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_3_3.position(91 * size_dm, 281 * size_dm);
        effect2_3_3.resized_image(30 * size_dm, 30 * size_dm);
        effect2_3_3.setObstacleAlpha(220);

        obs2_4_1 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_4_1.position(104 * size_dm, 80 * size_dm);
        obs2_4_1.resized_image(30 * size_dm, 30 * size_dm);
        obs2_4_1.setObstacleAlpha(220);

        effect2_4_1 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_4_1.position(104 * size_dm, 216 * size_dm);
        effect2_4_1.resized_image(30 * size_dm, 30 * size_dm);
        effect2_4_1.setObstacleAlpha(220);

        obs2_4_2 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_4_2.position(104 * size_dm, 80 * size_dm);
        obs2_4_2.resized_image(30 * size_dm, 30 * size_dm);
        obs2_4_2.setObstacleAlpha(200);

        effect2_4_2 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_4_2.position(104 * size_dm, 242 * size_dm);
        effect2_4_2.resized_image(30 * size_dm, 30 * size_dm);
        effect2_4_2.setObstacleAlpha(200);

        obs2_4_3 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_4_3.position(104 * size_dm, 80 * size_dm);
        obs2_4_3.resized_image(30 * size_dm, 30 * size_dm);
        obs2_4_3.setObstacleAlpha(220);

        effect2_4_3 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_4_3.position(104 * size_dm, 268 * size_dm);
        effect2_4_3.resized_image(30 * size_dm, 30 * size_dm);
        effect2_4_3.setObstacleAlpha(220);

        obs2_4_4 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_4_4.position(104 * size_dm, 80 * size_dm);
        obs2_4_4.resized_image(30 * size_dm, 30 * size_dm);
        obs2_4_4.setObstacleAlpha(220);

        effect2_4_4 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_4_4.position(104 * size_dm, 294 * size_dm);
        effect2_4_4.resized_image(30 * size_dm, 30 * size_dm);
        effect2_4_4.setObstacleAlpha(220);

        obs2_5_1 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_5_1.position(117 * size_dm, 80 * size_dm);
        obs2_5_1.resized_image(30 * size_dm, 30 * size_dm);
        obs2_5_1.setObstacleAlpha(220);

        effect2_5_1 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_5_1.position(117 * size_dm, 203 * size_dm);
        effect2_5_1.resized_image(30 * size_dm, 30 * size_dm);
        effect2_5_1.setObstacleAlpha(220);

        obs2_5_2 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_5_2.position(117 * size_dm, 80 * size_dm);
        obs2_5_2.resized_image(30 * size_dm, 30 * size_dm);
        obs2_5_2.setObstacleAlpha(220);

        effect2_5_2 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_5_2.position(117 * size_dm, 229 * size_dm);
        effect2_5_2.resized_image(30 * size_dm, 30 * size_dm);
        effect2_5_2.setObstacleAlpha(220);

        obs2_5_3 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_5_3.position(117 * size_dm, 80 * size_dm);
        obs2_5_3.resized_image(30 * size_dm, 30 * size_dm);
        obs2_5_3.setObstacleAlpha(200);

        effect2_5_3 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_5_3.position(117 * size_dm, 255 * size_dm);
        effect2_5_3.resized_image(30 * size_dm, 30 * size_dm);
        effect2_5_3.setObstacleAlpha(200);

        obs2_5_4 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_5_4.position(117 * size_dm, 80 * size_dm);
        obs2_5_4.resized_image(30 * size_dm, 30 * size_dm);
        obs2_5_4.setObstacleAlpha(220);

        effect2_5_4 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_5_4.position(117 * size_dm, 281 * size_dm);
        effect2_5_4.resized_image(30 * size_dm, 30 * size_dm);
        effect2_5_4.setObstacleAlpha(220);

        obs2_5_5 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_5_5.position(117 * size_dm, 80 * size_dm);
        obs2_5_5.resized_image(30 * size_dm, 30 * size_dm);
        obs2_5_5.setObstacleAlpha(220);

        effect2_5_5 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_5_5.position(117 * size_dm, 307 * size_dm);
        effect2_5_5.resized_image(30 * size_dm, 30 * size_dm);
        effect2_5_5.setObstacleAlpha(220);

        obs2_6_1 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_6_1.position(130 * size_dm, 80 * size_dm);
        obs2_6_1.resized_image(30 * size_dm, 30 * size_dm);
        obs2_6_1.setObstacleAlpha(220);

        effect2_6_1 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_6_1.position(130 * size_dm, 190 * size_dm);
        effect2_6_1.resized_image(30 * size_dm, 30 * size_dm);
        effect2_6_1.setObstacleAlpha(220);

        obs2_6_2 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_6_2.position(130 * size_dm, 80 * size_dm);
        obs2_6_2.resized_image(30 * size_dm, 30 * size_dm);
        obs2_6_2.setObstacleAlpha(220);

        effect2_6_2 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_6_2.position(130 * size_dm, 216 * size_dm);
        effect2_6_2.resized_image(30 * size_dm, 30 * size_dm);
        effect2_6_2.setObstacleAlpha(220);

        obs2_6_3 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_6_3.position(130 * size_dm, 80 * size_dm);
        obs2_6_3.resized_image(30 * size_dm, 30 * size_dm);
        obs2_6_3.setObstacleAlpha(200);

        effect2_6_3 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_6_3.position(130 * size_dm, 242 * size_dm);
        effect2_6_3.resized_image(30 * size_dm, 30 * size_dm);
        effect2_6_3.setObstacleAlpha(200);

        obs2_6_4 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_6_4.position(130 * size_dm, 80 * size_dm);
        obs2_6_4.resized_image(30 * size_dm, 30 * size_dm);
        obs2_6_4.setObstacleAlpha(220);

        effect2_6_4 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_6_4.position(130 * size_dm, 268 * size_dm);
        effect2_6_4.resized_image(30 * size_dm, 30 * size_dm);
        effect2_6_4.setObstacleAlpha(220);

        obs2_6_5 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_6_5.position(130 * size_dm, 80 * size_dm);
        obs2_6_5.resized_image(30 * size_dm, 30 * size_dm);
        obs2_6_5.setObstacleAlpha(220);

        effect2_6_5 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_6_5.position(130 * size_dm, 294 * size_dm);
        effect2_6_5.resized_image(30 * size_dm, 30 * size_dm);
        effect2_6_5.setObstacleAlpha(220);

        obs2_6_6 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_6_6.position(130 * size_dm, 80 * size_dm);
        obs2_6_6.resized_image(30 * size_dm, 30 * size_dm);
        obs2_6_6.setObstacleAlpha(220);

        effect2_6_6 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_6_6.position(130 * size_dm, 320 * size_dm);
        effect2_6_6.resized_image(30 * size_dm, 30 * size_dm);
        effect2_6_6.setObstacleAlpha(220);

        obs2_7_1 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_7_1.position(143 * size_dm, 80 * size_dm);
        obs2_7_1.resized_image(30 * size_dm, 30 * size_dm);
        obs2_7_1.setObstacleAlpha(220);

        effect2_7_1 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_7_1.position(143 * size_dm, 177 * size_dm);
        effect2_7_1.resized_image(30 * size_dm, 30 * size_dm);
        effect2_7_1.setObstacleAlpha(220);

        obs2_7_2 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_7_2.position(143 * size_dm, 80 * size_dm);
        obs2_7_2.resized_image(30 * size_dm, 30 * size_dm);
        obs2_7_2.setObstacleAlpha(220);

        effect2_7_2 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_7_2.position(143 * size_dm, 203 * size_dm);
        effect2_7_2.resized_image(30 * size_dm, 30 * size_dm);
        effect2_7_2.setObstacleAlpha(220);

        obs2_7_3 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_7_3.position(143 * size_dm, 80 * size_dm);
        obs2_7_3.resized_image(30 * size_dm, 30 * size_dm);
        obs2_7_3.setObstacleAlpha(220);

        effect2_7_3 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_7_3.position(143 * size_dm, 229 * size_dm);
        effect2_7_3.resized_image(30 * size_dm, 30 * size_dm);
        effect2_7_3.setObstacleAlpha(220);

        obs2_7_4 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_7_4.position(143 * size_dm, 80 * size_dm);
        obs2_7_4.resized_image(30 * size_dm, 30 * size_dm);
        obs2_7_4.setObstacleAlpha(220);

        effect2_7_4 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_7_4.position(143 * size_dm, 255 * size_dm);
        effect2_7_4.resized_image(30 * size_dm, 30 * size_dm);
        effect2_7_4.setObstacleAlpha(220);

        obs2_7_5 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_7_5.position(143 * size_dm, 80 * size_dm);
        obs2_7_5.resized_image(30 * size_dm, 30 * size_dm);
        obs2_7_5.setObstacleAlpha(220);

        effect2_7_5 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_7_5.position(143 * size_dm, 281 * size_dm);
        effect2_7_5.resized_image(30 * size_dm, 30 * size_dm);
        effect2_7_5.setObstacleAlpha(220);

        obs2_7_6 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_7_6.position(143 * size_dm, 80 * size_dm);
        obs2_7_6.resized_image(30 * size_dm, 30 * size_dm);
        obs2_7_6.setObstacleAlpha(220);

        effect2_7_6 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_7_6.position(143 * size_dm, 307 * size_dm);
        effect2_7_6.resized_image(30 * size_dm, 30 * size_dm);
        effect2_7_6.setObstacleAlpha(220);

        obs2_7_7 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_7_7.position(143 * size_dm, 80 * size_dm);
        obs2_7_7.resized_image(30 * size_dm, 30 * size_dm);
        obs2_7_7.setObstacleAlpha(220);

        effect2_7_7 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_7_7.position(143 * size_dm, 333 * size_dm);
        effect2_7_7.resized_image(30 * size_dm, 30 * size_dm);
        effect2_7_7.setObstacleAlpha(220);

        obs2_8_1 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_8_1.position(156 * size_dm, 80 * size_dm);
        obs2_8_1.resized_image(30 * size_dm, 30 * size_dm);
        obs2_8_1.setObstacleAlpha(220);

        effect2_8_1 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_8_1.position(156 * size_dm, 164 * size_dm);
        effect2_8_1.resized_image(30 * size_dm, 30 * size_dm);
        effect2_8_1.setObstacleAlpha(220);

        obs2_8_2 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_8_2.position(156 * size_dm, 80 * size_dm);
        obs2_8_2.resized_image(30 * size_dm, 30 * size_dm);
        obs2_8_2.setObstacleAlpha(220);

        effect2_8_2 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_8_2.position(156 * size_dm, 190 * size_dm);
        effect2_8_2.resized_image(30 * size_dm, 30 * size_dm);
        effect2_8_2.setObstacleAlpha(220);

        obs2_8_3 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_8_3.position(156 * size_dm, 80 * size_dm);
        obs2_8_3.resized_image(30 * size_dm, 30 * size_dm);
        obs2_8_3.setObstacleAlpha(220);

        effect2_8_3 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_8_3.position(156 * size_dm, 216 * size_dm);
        effect2_8_3.resized_image(30 * size_dm, 30 * size_dm);
        effect2_8_3.setObstacleAlpha(220);

        obs2_8_4 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_8_4.position(156 * size_dm, 80 * size_dm);
        obs2_8_4.resized_image(30 * size_dm, 30 * size_dm);
        obs2_8_4.setObstacleAlpha(220);

        effect2_8_4 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_8_4.position(156 * size_dm, 242 * size_dm);
        effect2_8_4.resized_image(30 * size_dm, 30 * size_dm);
        effect2_8_4.setObstacleAlpha(220);

        obs2_8_5 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_8_5.position(156 * size_dm, 80 * size_dm);
        obs2_8_5.resized_image(30 * size_dm, 30 * size_dm);
        obs2_8_5.setObstacleAlpha(220);

        effect2_8_5 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_8_5.position(156 * size_dm, 268 * size_dm);
        effect2_8_5.resized_image(30 * size_dm, 30 * size_dm);
        effect2_8_5.setObstacleAlpha(220);

        obs2_8_6 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_8_6.position(156 * size_dm, 80 * size_dm);
        obs2_8_6.resized_image(30 * size_dm, 30 * size_dm);
        obs2_8_6.setObstacleAlpha(220);

        effect2_8_6 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_8_6.position(156 * size_dm, 294 * size_dm);
        effect2_8_6.resized_image(30 * size_dm, 30 * size_dm);
        effect2_8_6.setObstacleAlpha(220);

        obs2_8_7 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_8_7.position(156 * size_dm, 80 * size_dm);
        obs2_8_7.resized_image(30 * size_dm, 30 * size_dm);
        obs2_8_7.setObstacleAlpha(220);

        effect2_8_7 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_8_7.position(156 * size_dm, 320 * size_dm);
        effect2_8_7.resized_image(30 * size_dm, 30 * size_dm);
        effect2_8_7.setObstacleAlpha(220);

        obs2_8_8 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_8_8.position(156 * size_dm, 80 * size_dm);
        obs2_8_8.resized_image(30 * size_dm, 30 * size_dm);
        obs2_8_8.setObstacleAlpha(220);

        effect2_8_8 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_8_8.position(156 * size_dm, 346 * size_dm);
        effect2_8_8.resized_image(30 * size_dm, 30 * size_dm);
        effect2_8_8.setObstacleAlpha(220);

        obs2_9_1 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_9_1.position(169 * size_dm, 80 * size_dm);
        obs2_9_1.resized_image(30 * size_dm, 30 * size_dm);
        obs2_9_1.setObstacleAlpha(220);

        effect2_9_1 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_9_1.position(169 * size_dm, 177 * size_dm);
        effect2_9_1.resized_image(30 * size_dm, 30 * size_dm);
        effect2_9_1.setObstacleAlpha(220);

        obs2_9_2 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_9_2.position(169 * size_dm, 80 * size_dm);
        obs2_9_2.resized_image(30 * size_dm, 30 * size_dm);
        obs2_9_2.setObstacleAlpha(220);

        effect2_9_2 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_9_2.position(169 * size_dm, 203 * size_dm);
        effect2_9_2.resized_image(30 * size_dm, 30 * size_dm);
        effect2_9_2.setObstacleAlpha(220);

        obs2_9_3 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_9_3.position(169 * size_dm, 80 * size_dm);
        obs2_9_3.resized_image(30 * size_dm, 30 * size_dm);
        obs2_9_3.setObstacleAlpha(220);

        effect2_9_3 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_9_3.position(169 * size_dm, 229 * size_dm);
        effect2_9_3.resized_image(30 * size_dm, 30 * size_dm);
        effect2_9_3.setObstacleAlpha(220);

        obs2_9_4 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_9_4.position(169 * size_dm, 80 * size_dm);
        obs2_9_4.resized_image(30 * size_dm, 30 * size_dm);
        obs2_9_4.setObstacleAlpha(220);

        effect2_9_4 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_9_4.position(169 * size_dm, 255 * size_dm);
        effect2_9_4.resized_image(30 * size_dm, 30 * size_dm);
        effect2_9_4.setObstacleAlpha(220);

        obs2_9_5 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_9_5.position(169 * size_dm, 80 * size_dm);
        obs2_9_5.resized_image(30 * size_dm, 30 * size_dm);
        obs2_9_5.setObstacleAlpha(220);

        effect2_9_5 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_9_5.position(169 * size_dm, 281 * size_dm);
        effect2_9_5.resized_image(30 * size_dm, 30 * size_dm);
        effect2_9_5.setObstacleAlpha(220);

        obs2_9_6 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_9_6.position(169 * size_dm, 80 * size_dm);
        obs2_9_6.resized_image(30 * size_dm, 30 * size_dm);
        obs2_9_6.setObstacleAlpha(220);

        effect2_9_6 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_9_6.position(169 * size_dm, 307 * size_dm);
        effect2_9_6.resized_image(30 * size_dm, 30 * size_dm);
        effect2_9_6.setObstacleAlpha(220);

        obs2_9_7 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_9_7.position(169 * size_dm, 80 * size_dm);
        obs2_9_7.resized_image(30 * size_dm, 30 * size_dm);
        obs2_9_7.setObstacleAlpha(220);

        effect2_9_7 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_9_7.position(169 * size_dm, 333 * size_dm);
        effect2_9_7.resized_image(30 * size_dm, 30 * size_dm);
        effect2_9_7.setObstacleAlpha(220);

        obs2_10_1 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_10_1.position(182 * size_dm, 80 * size_dm);
        obs2_10_1.resized_image(30 * size_dm, 30 * size_dm);
        obs2_10_1.setObstacleAlpha(220);

        effect2_10_1 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_10_1.position(182 * size_dm, 190 * size_dm);
        effect2_10_1.resized_image(30 * size_dm, 30 * size_dm);
        effect2_10_1.setObstacleAlpha(220);

        obs2_10_2 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_10_2.position(182 * size_dm, 80 * size_dm);
        obs2_10_2.resized_image(30 * size_dm, 30 * size_dm);
        obs2_10_2.setObstacleAlpha(220);

        effect2_10_2 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_10_2.position(182 * size_dm, 216 * size_dm);
        effect2_10_2.resized_image(30 * size_dm, 30 * size_dm);
        effect2_10_2.setObstacleAlpha(220);

        obs2_10_3 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_10_3.position(182 * size_dm, 80 * size_dm);
        obs2_10_3.resized_image(30 * size_dm, 30 * size_dm);
        obs2_10_3.setObstacleAlpha(220);

        effect2_10_3 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_10_3.position(182 * size_dm, 242 * size_dm);
        effect2_10_3.resized_image(30 * size_dm, 30 * size_dm);
        effect2_10_3.setObstacleAlpha(220);

        obs2_10_4 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_10_4.position(182 * size_dm, 80 * size_dm);
        obs2_10_4.resized_image(30 * size_dm, 30 * size_dm);
        obs2_10_4.setObstacleAlpha(220);

        effect2_10_4 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_10_4.position(182 * size_dm, 268 * size_dm);
        effect2_10_4.resized_image(30 * size_dm, 30 * size_dm);
        effect2_10_4.setObstacleAlpha(220);

        obs2_10_5 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_10_5.position(182 * size_dm, 80 * size_dm);
        obs2_10_5.resized_image(30 * size_dm, 30 * size_dm);
        obs2_10_5.setObstacleAlpha(220);

        effect2_10_5 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_10_5.position(182 * size_dm, 294 * size_dm);
        effect2_10_5.resized_image(30 * size_dm, 30 * size_dm);
        effect2_10_5.setObstacleAlpha(220);

        obs2_10_6 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_10_6.position(182 * size_dm, 80 * size_dm);
        obs2_10_6.resized_image(30 * size_dm, 30 * size_dm);
        obs2_10_6.setObstacleAlpha(220);

        effect2_10_6 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_10_6.position(182 * size_dm, 320 * size_dm);
        effect2_10_6.resized_image(30 * size_dm, 30 * size_dm);
        effect2_10_6.setObstacleAlpha(220);

        obs2_11_1 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_11_1.position(195 * size_dm, 80 * size_dm);
        obs2_11_1.resized_image(30 * size_dm, 30 * size_dm);
        obs2_11_1.setObstacleAlpha(220);

        effect2_11_1 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_11_1.position(195 * size_dm, 203 * size_dm);
        effect2_11_1.resized_image(30 * size_dm, 30 * size_dm);
        effect2_11_1.setObstacleAlpha(220);

        obs2_11_2 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_11_2.position(195 * size_dm, 80 * size_dm);
        obs2_11_2.resized_image(30 * size_dm, 30 * size_dm);
        obs2_11_2.setObstacleAlpha(220);

        effect2_11_2 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_11_2.position(195 * size_dm, 229 * size_dm);
        effect2_11_2.resized_image(30 * size_dm, 30 * size_dm);
        effect2_11_2.setObstacleAlpha(220);

        obs2_11_3 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_11_3.position(195 * size_dm, 80 * size_dm);
        obs2_11_3.resized_image(30 * size_dm, 30 * size_dm);
        obs2_11_3.setObstacleAlpha(220);

        effect2_11_3 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_11_3.position(195 * size_dm, 255 * size_dm);
        effect2_11_3.resized_image(30 * size_dm, 30 * size_dm);
        effect2_11_3.setObstacleAlpha(220);

        obs2_11_4 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_11_4.position(195 * size_dm, 80 * size_dm);
        obs2_11_4.resized_image(30 * size_dm, 30 * size_dm);
        obs2_11_4.setObstacleAlpha(220);

        effect2_11_4 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_11_4.position(195 * size_dm, 281 * size_dm);
        effect2_11_4.resized_image(30 * size_dm, 30 * size_dm);
        effect2_11_4.setObstacleAlpha(220);

        obs2_11_5 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_11_5.position(195 * size_dm, 80 * size_dm);
        obs2_11_5.resized_image(30 * size_dm, 30 * size_dm);
        obs2_11_5.setObstacleAlpha(220);

        effect2_11_5 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_11_5.position(195 * size_dm, 307 * size_dm);
        effect2_11_5.resized_image(30 * size_dm, 30 * size_dm);
        effect2_11_5.setObstacleAlpha(220);

        obs2_12_1 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_12_1.position(208 * size_dm, 80 * size_dm);
        obs2_12_1.resized_image(30 * size_dm, 30 * size_dm);
        obs2_12_1.setObstacleAlpha(220);

        effect2_12_1 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_12_1.position(208 * size_dm, 216 * size_dm);
        effect2_12_1.resized_image(30 * size_dm, 30 * size_dm);
        effect2_12_1.setObstacleAlpha(220);

        obs2_12_2 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_12_2.position(208 * size_dm, 80 * size_dm);
        obs2_12_2.resized_image(30 * size_dm, 30 * size_dm);
        obs2_12_2.setObstacleAlpha(220);

        effect2_12_2 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_12_2.position(208 * size_dm, 242 * size_dm);
        effect2_12_2.resized_image(30 * size_dm, 30 * size_dm);
        effect2_12_2.setObstacleAlpha(220);

        obs2_12_3 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_12_3.position(208 * size_dm, 80 * size_dm);
        obs2_12_3.resized_image(30 * size_dm, 30 * size_dm);
        obs2_12_3.setObstacleAlpha(220);

        effect2_12_3 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_12_3.position(208 * size_dm, 268 * size_dm);
        effect2_12_3.resized_image(30 * size_dm, 30 * size_dm);
        effect2_12_3.setObstacleAlpha(220);

        obs2_12_4 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_12_4.position(208 * size_dm, 80 * size_dm);
        obs2_12_4.resized_image(30 * size_dm, 30 * size_dm);
        obs2_12_4.setObstacleAlpha(220);

        effect2_12_4 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_12_4.position(208 * size_dm, 294 * size_dm);
        effect2_12_4.resized_image(30 * size_dm, 30 * size_dm);
        effect2_12_4.setObstacleAlpha(220);

        obs2_13_1 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_13_1.position(221 * size_dm, 80 * size_dm);
        obs2_13_1.resized_image(30 * size_dm, 30 * size_dm);
        obs2_13_1.setObstacleAlpha(220);

        effect2_13_1 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_13_1.position(221 * size_dm, 229 * size_dm);
        effect2_13_1.resized_image(30 * size_dm, 30 * size_dm);
        effect2_13_1.setObstacleAlpha(220);

        obs2_13_2 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_13_2.position(221 * size_dm, 80 * size_dm);
        obs2_13_2.resized_image(30 * size_dm, 30 * size_dm);
        obs2_13_2.setObstacleAlpha(220);

        effect2_13_2 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_13_2.position(221 * size_dm, 255 * size_dm);
        effect2_13_2.resized_image(30 * size_dm, 30 * size_dm);
        effect2_13_2.setObstacleAlpha(220);

        obs2_13_3 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_13_3.position(221 * size_dm, 80 * size_dm);
        obs2_13_3.resized_image(30 * size_dm, 30 * size_dm);
        obs2_13_3.setObstacleAlpha(220);

        effect2_13_3 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_13_3.position(221 * size_dm, 281 * size_dm);
        effect2_13_3.resized_image(30 * size_dm, 30 * size_dm);
        effect2_13_3.setObstacleAlpha(220);

        obs2_14_1 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_14_1.position(234 * size_dm, 80 * size_dm);
        obs2_14_1.resized_image(30 * size_dm, 30 * size_dm);
        obs2_14_1.setObstacleAlpha(220);

        effect2_14_1 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_14_1.position(234 * size_dm, 242 * size_dm);
        effect2_14_1.resized_image(30 * size_dm, 30 * size_dm);
        effect2_14_1.setObstacleAlpha(220);

        obs2_14_2 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_14_2.position(234 * size_dm, 80 * size_dm);
        obs2_14_2.resized_image(30 * size_dm, 30 * size_dm);
        obs2_14_2.setObstacleAlpha(220);

        effect2_14_2 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_14_2.position(234 * size_dm, 268 * size_dm);
        effect2_14_2.resized_image(30 * size_dm, 30 * size_dm);
        effect2_14_2.setObstacleAlpha(220);

        obs2_15_1 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.enemy2);
        obs2_15_1.position(247 * size_dm, 80 * size_dm);
        obs2_15_1.resized_image(30 * size_dm, 30 * size_dm);
        obs2_15_1.setObstacleAlpha(220);

        effect2_15_1 = new ObstacleClass(getApplicationContext(), gameview2, R.drawable.effect);
        effect2_15_1.position(247 * size_dm, 255 * size_dm);
        effect2_15_1.resized_image(30 * size_dm, 30 * size_dm);
        effect2_15_1.setObstacleAlpha(220);

        player = (ImageView) findViewById(R.id.player);

        tile1_1 = (ImageView) findViewById(R.id.tile1_1);
        tile1_2 = (ImageView) findViewById(R.id.tile1_2);
        tile1_3 = (ImageView) findViewById(R.id.tile1_3);
        tile1_4 = (ImageView) findViewById(R.id.tile1_4);
        tile1_5 = (ImageView) findViewById(R.id.tile1_5);
        tile1_6 = (ImageView) findViewById(R.id.tile1_6);
        tile1_7 = (ImageView) findViewById(R.id.tile1_7);
        tile1_8 = (ImageView) findViewById(R.id.tile1_8);
        tile1_9 = (ImageView) findViewById(R.id.tile1_9);
        tile1_10 = (ImageView) findViewById(R.id.tile1_10);
        tile1_11 = (ImageView) findViewById(R.id.tile1_11);
        tile1_12 = (ImageView) findViewById(R.id.tile1_12);
        tile1_13 = (ImageView) findViewById(R.id.tile1_13);
        tile1_14 = (ImageView) findViewById(R.id.tile1_14);
        tile1_15 = (ImageView) findViewById(R.id.tile1_15);
        tile1_16 = (ImageView) findViewById(R.id.tile1_16);
        tile1_17 = (ImageView) findViewById(R.id.tile1_17);
        tile1_18 = (ImageView) findViewById(R.id.tile1_18);
        tile1_19 = (ImageView) findViewById(R.id.tile1_19);
        tile1_20 = (ImageView) findViewById(R.id.tile1_20);
        tile1_21 = (ImageView) findViewById(R.id.tile1_21);
        tile1_22 = (ImageView) findViewById(R.id.tile1_22);
        tile1_23 = (ImageView) findViewById(R.id.tile1_23);
        tile1_24 = (ImageView) findViewById(R.id.tile1_24);
        tile1_25 = (ImageView) findViewById(R.id.tile1_25);
        tile1_26 = (ImageView) findViewById(R.id.tile1_26);
        tile1_27 = (ImageView) findViewById(R.id.tile1_27);
        tile1_28 = (ImageView) findViewById(R.id.tile1_28);
        tile1_29 = (ImageView) findViewById(R.id.tile1_29);
        tile1_30 = (ImageView) findViewById(R.id.tile1_30);
        tile1_31 = (ImageView) findViewById(R.id.tile1_31);
        tile1_32 = (ImageView) findViewById(R.id.tile1_32);

        tile2_1 = (ImageView) findViewById(R.id.tile2_1);
        tile2_2 = (ImageView) findViewById(R.id.tile2_2);
        tile2_3 = (ImageView) findViewById(R.id.tile2_3);
        tile2_4 = (ImageView) findViewById(R.id.tile2_4);
        tile2_5 = (ImageView) findViewById(R.id.tile2_5);
        tile2_6 = (ImageView) findViewById(R.id.tile2_6);
        tile2_7 = (ImageView) findViewById(R.id.tile2_7);
        tile2_8 = (ImageView) findViewById(R.id.tile2_8);
        tile2_9 = (ImageView) findViewById(R.id.tile2_9);
        tile2_10 = (ImageView) findViewById(R.id.tile2_10);
        tile2_11 = (ImageView) findViewById(R.id.tile2_11);
        tile2_12 = (ImageView) findViewById(R.id.tile2_12);
        tile2_13 = (ImageView) findViewById(R.id.tile2_13);
        tile2_14 = (ImageView) findViewById(R.id.tile2_14);
        tile2_15 = (ImageView) findViewById(R.id.tile2_15);
        tile2_16 = (ImageView) findViewById(R.id.tile2_16);
        tile2_17 = (ImageView) findViewById(R.id.tile2_17);
        tile2_18 = (ImageView) findViewById(R.id.tile2_18);
        tile2_19 = (ImageView) findViewById(R.id.tile2_19);
        tile2_20 = (ImageView) findViewById(R.id.tile2_20);
        tile2_21 = (ImageView) findViewById(R.id.tile2_21);
        tile2_22 = (ImageView) findViewById(R.id.tile2_22);
        tile2_23 = (ImageView) findViewById(R.id.tile2_23);
        tile2_24 = (ImageView) findViewById(R.id.tile2_24);
        tile2_25 = (ImageView) findViewById(R.id.tile2_25);
        tile2_26 = (ImageView) findViewById(R.id.tile2_26);
        tile2_27 = (ImageView) findViewById(R.id.tile2_27);
        tile2_28 = (ImageView) findViewById(R.id.tile2_28);
        tile2_29 = (ImageView) findViewById(R.id.tile2_29);
        tile2_30 = (ImageView) findViewById(R.id.tile2_30);
        tile2_31 = (ImageView) findViewById(R.id.tile2_31);
        tile2_32 = (ImageView) findViewById(R.id.tile2_32);

        heart1 = (ImageView) findViewById(R.id.heart1);
        heart2 = (ImageView) findViewById(R.id.heart2);
        heart3 = (ImageView) findViewById(R.id.heart3);

        TextView game_first = null;

        game_setFont(game_first, "fonts/korra.ttf", R.id.score);
        game_setFont(game_first, "fonts/korra.ttf", R.id.time);
        game_setFont(game_first, "fonts/korra.ttf", R.id.life);

    }

    void health_check(boolean x) {
        if (x == true) {
            ++health_number;
            stun_player = true;
        }

        if (health_number == 1) {
            heart1.setVisibility(heart1.INVISIBLE);
        } else if (health_number == 2) {
            heart2.setVisibility(heart2.INVISIBLE);
        } else if (health_number == 3) {
            heart3.setVisibility(heart3.INVISIBLE);
        }

    }

    void timing_set() {
        if (total_time_number > 0) {
            total_time_number -= 1;
            time_number.setText("" + total_time_number);
        }
    }

    void game_setFont(TextView name, String path, int res) {
        name = (TextView) findViewById(res);
        Typeface font = Typeface.createFromAsset(this.getAssets(), path);

        name.setTypeface(font);
    }

    public void mapping() {
        tile_end_x1 = Math.round(tile1_1.getX());
        tile_end_y1 = Math.round(tile1_1.getY());

        tile_end_x2 = Math.round(tile2_13.getX());
        tile_end_y2 = Math.round(tile2_13.getY());

        tile_end_x3 = Math.round(tile2_20.getX());
        tile_end_y3 = Math.round(tile2_20.getY());

        tile_end_x4 = Math.round(tile1_32.getX());
        tile_end_y4 = Math.round(tile1_32.getY());

    }

    private int getRandomMath(int max, int offset) {


        int nResult = (int) (Math.random() * (max - offset + 1)) + offset;


        return nResult;

    }

    public boolean onTouchEvent(MotionEvent me) {
        layout_joystick.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View arg0, MotionEvent arg1) {
                js.drawStick(arg1);

                SpeedX = Math.round(js.getX() / 60F);
                SpeedY = Math.round(js.getY() / 60F);

                FrameLayout frame = (FrameLayout) findViewById(R.id.frame);
                frameHeight = frame.getHeight();

                if (start_flg == false) {

                    start_flg = true;

                    mapping();

                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {

                            handler.post(new Runnable() {

                                @Override
                                public void run() {

                                    if (total_time_number <= 0 || health_number >= 3) {

                                        if (health_number >= 3) {
                                            try {
                                                timer.cancel();
                                                timer = null;
                                                Intent intent = new Intent(getApplicationContext(), Ending.class);
                                                startActivity(intent);
                                            } catch (Exception e) {
                                                Intent intent = new Intent(getApplicationContext(), Ending.class);
                                                startActivity(intent);
                                            }
                                        } else {
                                            try {
                                                timer.cancel();
                                                timer = null;
                                                Intent intent = new Intent(getApplicationContext(), Main3.class);
                                                startActivity(intent);
                                            } catch (Exception e) {
                                                Intent intent = new Intent(getApplicationContext(), Main3.class);
                                                startActivity(intent);
                                            }
                                        }

                                    } else {

                                        ++timing_number;
                                        ++level_time_number;

                                        if (timing_number % 50 == 0) {
                                            if (timing_number <= 1000) {
                                                timing_set();
                                            } else {
                                                timing_number = 0;
                                            }
                                        }

                                        if (level_time_number % 25 == 0 && level_time_number <= 800) {
                                            pattern_number = getRandomMath(63, 0);
                                            pattern[pattern_number] = 1;
                                        } else if (level_time_number > 800) {
                                            level_time_number = 0;
                                        }

                                        if (stun_player == false) {
                                            Isdamaged_player = hit_check();
                                            health_check(Isdamaged_player);
                                        } else {
                                            ++health_timing_number;
                                            if (health_timing_number % 300 == 0) {
                                                stun_player = false;
                                                health_timing_number = 0;
                                            }
                                        }

                                        obstacle_3_moving(obstacle_3_SpeedX, obstacle_3_SpeedY, pattern_number);
                                        player_moving(SpeedX, SpeedY, action_flg);

                                    }
                                }
                            });
                        }
                    }, 0, 20);

                } else {

                    if (arg1.getAction() == MotionEvent.ACTION_DOWN || arg1.getAction() == MotionEvent.ACTION_MOVE) {

                        action_flg = true;

                    } else if (arg1.getAction() == MotionEvent.ACTION_UP) {

                        js.initial_draw(50 * size_dm, 50 * size_dm);

                        action_flg = false;

                    } else {


                    }

                }

                return true;

            }
        });

        return true;
    }

    public void player_moving(int x, int y, boolean button_down) {

        if (button_down == true) {

            if ((player.getX() + player.getY()) > (tile_end_x1 + tile_end_y1 + 20) && (player.getX() + player.getY()) < (tile_end_x4 + tile_end_y4 + 30)) {

                if (player.getX() > tile_end_x2 && player.getY() < tile_end_y4) {

                    if (player.getY() >= tile_end_y3) {
                        if ((player.getY() - tile_end_y2) / (player.getX() - tile_end_x2) < ((tile_end_y4 - tile_end_y2) / (tile_end_x4 - tile_end_x2))) {

                            prior_player_x = Math.round(player.getX());
                            prior_player_y = Math.round(player.getY());

                            player.setX(player.getX() + x);
                            player.setY(player.getY() + y);
                        } else {

                            player.setX(prior_player_x);
                            player.setY(prior_player_y);

                        }
                    } else {

                        if (player.getX() > tile_end_x1) {
                            if ((player.getY() - tile_end_y1) / (player.getX() - tile_end_x1) > ((tile_end_y3 - tile_end_y1) / (tile_end_x3 - tile_end_x1))) {
                                prior_player_x = Math.round(player.getX());
                                prior_player_y = Math.round(player.getY());

                                player.setX(player.getX() + x);
                                player.setY(player.getY() + y);
                            } else {

                                player.setX(prior_player_x);
                                player.setY(prior_player_y);

                            }
                        } else {
                            prior_player_x = Math.round(player.getX());
                            prior_player_y = Math.round(player.getY());

                            player.setX(player.getX() + x);
                            player.setY(player.getY() + y);
                        }
                    }
                } else {

                    player.setX(prior_player_x);
                    player.setY(prior_player_y);

                }

            } else {

                player.setX(prior_player_x);
                player.setY(prior_player_y);

            }
        }
    }

    public void obstacle_3_moving(int x, int y, int z) {

        if (total_time_number >= 0 && health_number < 3) {

            if (pattern[0] == 1) {
                if (obs2_1.position_y >= 244 * size_dm) {
                    obs2_1.position(65 * size_dm, 80 * size_dm);
                    obs2_1.setObstacleAlpha(200);
                } else {
                    obs2_1.setPosition(x, y);
                    if (obs2_1.position_y <= 194 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_1.position(65 * size_dm, 254 * size_dm);
                            effect2_1.setObstacleAlpha(200);
                            effect2_1.position_effect();
                        } else {
                            effect2_1.setObstacleAlpha(0);
                            effect2_1.position_effect();
                        }
                    } else {
                        effect2_1.setObstacleAlpha(0);
                        effect2_1.position_effect();
                    }
                }
            }

            if (pattern[1] == 1) {
                if (obs2_2_1.position_y >= 232 * size_dm) {
                    obs2_2_1.position(78 * size_dm, 80 * size_dm);
                    obs2_2_1.setObstacleAlpha(220);
                } else {
                    obs2_2_1.setPosition(x, y);
                    if (obs2_2_1.position_y <= 182 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_2_1.position(78 * size_dm, 242 * size_dm);
                            effect2_2_1.setObstacleAlpha(200);
                            effect2_2_1.position_effect();
                        } else {
                            effect2_2_1.setObstacleAlpha(0);
                            effect2_2_1.position_effect();
                        }
                    } else {
                        effect2_2_1.setObstacleAlpha(0);
                        effect2_2_1.position_effect();
                    }
                }
            }

            if (pattern[2] == 1) {
                if (obs2_2_2.position_y >= 258 * size_dm) {
                    obs2_2_2.position(78 * size_dm, 80 * size_dm);
                    obs2_2_2.setObstacleAlpha(220);
                } else {
                    obs2_2_2.setPosition(x, y);
                    if (obs2_2_2.position_y <= 208 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_2_2.position(78 * size_dm, 268 * size_dm);
                            effect2_2_2.setObstacleAlpha(200);
                            effect2_2_2.position_effect();
                        } else {
                            effect2_2_2.setObstacleAlpha(0);
                            effect2_2_2.position_effect();
                        }
                    } else {
                        effect2_2_2.setObstacleAlpha(0);
                        effect2_2_2.position_effect();
                    }
                }
            }

            if (pattern[3] == 1) {
                if (obs2_3_1.position_y >= 219 * size_dm) {
                    obs2_3_1.position(91 * size_dm, 80 * size_dm);
                    obs2_3_1.setObstacleAlpha(220);
                } else {
                    obs2_3_1.setPosition(x, y);
                    if (obs2_3_1.position_y <= 169 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_3_1.position(91 * size_dm, 229 * size_dm);
                            effect2_3_1.setObstacleAlpha(200);
                            effect2_3_1.position_effect();
                        } else {
                            effect2_3_1.setObstacleAlpha(0);
                            effect2_3_1.position_effect();
                        }
                    } else {
                        effect2_3_1.setObstacleAlpha(0);
                        effect2_3_1.position_effect();
                    }
                }
            }

            if (pattern[4] == 1) {
                if (obs2_3_2.position_y >= 245 * size_dm) {
                    obs2_3_2.position(91 * size_dm, 80 * size_dm);
                    obs2_3_2.setObstacleAlpha(220);
                } else {
                    obs2_3_2.setPosition(x, y);
                    if (obs2_3_2.position_y <= 195 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_3_2.position(91 * size_dm, 255 * size_dm);
                            effect2_3_2.setObstacleAlpha(200);
                            effect2_3_2.position_effect();
                        } else {
                            effect2_3_2.setObstacleAlpha(0);
                            effect2_3_2.position_effect();
                        }
                    } else {
                        effect2_3_2.setObstacleAlpha(0);
                        effect2_3_2.position_effect();
                    }
                }
            }

            if (pattern[5] == 1) {
                if (obs2_3_3.position_y >= 271 * size_dm) {
                    obs2_3_3.position(91 * size_dm, 80 * size_dm);
                    obs2_3_3.setObstacleAlpha(220);
                } else {
                    obs2_3_3.setPosition(x, y);
                    if (obs2_3_3.position_y <= 221 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_3_3.position(91 * size_dm, 281 * size_dm);
                            effect2_3_3.setObstacleAlpha(200);
                            effect2_3_3.position_effect();
                        } else {
                            effect2_3_3.setObstacleAlpha(0);
                            effect2_3_3.position_effect();
                        }
                    } else {
                        effect2_3_3.setObstacleAlpha(0);
                        effect2_3_3.position_effect();
                    }
                }
            }

            if (pattern[6] == 1) {
                if (obs2_4_1.position_y >= 206 * size_dm) {
                    obs2_4_1.position(104 * size_dm, 80 * size_dm);
                    obs2_4_1.setObstacleAlpha(220);
                } else {
                    obs2_4_1.setPosition(x, y);
                    if (obs2_4_1.position_y <= 156 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_4_1.position(104 * size_dm, 216 * size_dm);
                            effect2_4_1.setObstacleAlpha(200);
                            effect2_4_1.position_effect();
                        } else {
                            effect2_4_1.setObstacleAlpha(0);
                            effect2_4_1.position_effect();
                        }
                    } else {
                        effect2_4_1.setObstacleAlpha(0);
                        effect2_4_1.position_effect();
                    }
                }
            }

            if (pattern[7] == 1) {
                if (obs2_4_2.position_y >= 232 * size_dm) {
                    obs2_4_2.position(104 * size_dm, 80 * size_dm);
                    obs2_4_2.setObstacleAlpha(220);
                } else {
                    obs2_4_2.setPosition(x, y);
                    if (obs2_4_2.position_y <= 182 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_4_2.position(104 * size_dm, 242 * size_dm);
                            effect2_4_2.setObstacleAlpha(200);
                            effect2_4_2.position_effect();
                        } else {
                            effect2_4_2.setObstacleAlpha(0);
                            effect2_4_2.position_effect();
                        }
                    } else {
                        effect2_4_2.setObstacleAlpha(0);
                        effect2_4_2.position_effect();
                    }
                }
            }

            if (pattern[8] == 1) {
                if (obs2_4_3.position_y >= 258 * size_dm) {
                    obs2_4_3.position(104 * size_dm, 80 * size_dm);
                    obs2_4_3.setObstacleAlpha(220);
                } else {
                    obs2_4_3.setPosition(x, y);
                    if (obs2_4_3.position_y <= 208 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_4_3.position(104 * size_dm, 268 * size_dm);
                            effect2_4_3.setObstacleAlpha(200);
                            effect2_4_3.position_effect();
                        } else {
                            effect2_4_3.setObstacleAlpha(0);
                            effect2_4_3.position_effect();
                        }
                    } else {
                        effect2_4_3.setObstacleAlpha(0);
                        effect2_4_3.position_effect();
                    }
                }
            }

            if (pattern[9] == 1) {
                if (obs2_4_4.position_y >= 284 * size_dm) {
                    obs2_4_4.position(104 * size_dm, 80 * size_dm);
                    obs2_4_4.setObstacleAlpha(220);
                } else {
                    obs2_4_4.setPosition(x, y);
                    if (obs2_4_4.position_y <= 234 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_4_4.position(104 * size_dm, 294 * size_dm);
                            effect2_4_4.setObstacleAlpha(200);
                            effect2_4_4.position_effect();
                        } else {
                            effect2_4_4.setObstacleAlpha(0);
                            effect2_4_4.position_effect();
                        }
                    } else {
                        effect2_4_4.setObstacleAlpha(0);
                        effect2_4_4.position_effect();
                    }
                }
            }

            if (pattern[10] == 1) {
                if (obs2_5_1.position_y >= 193 * size_dm) {
                    obs2_5_1.position(117 * size_dm, 80 * size_dm);
                    obs2_5_1.setObstacleAlpha(220);
                } else {
                    obs2_5_1.setPosition(x, y);
                    if (obs2_5_1.position_y <= 143 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_5_1.position(117 * size_dm, 203 * size_dm);
                            effect2_5_1.setObstacleAlpha(200);
                            effect2_5_1.position_effect();
                        } else {
                            effect2_5_1.setObstacleAlpha(0);
                            effect2_5_1.position_effect();
                        }
                    } else {
                        effect2_5_1.setObstacleAlpha(0);
                        effect2_5_1.position_effect();
                    }
                }
            }

            if (pattern[11] == 1) {
                if (obs2_5_2.position_y >= 219 * size_dm) {
                    obs2_5_2.position(117 * size_dm, 80 * size_dm);
                    obs2_5_2.setObstacleAlpha(220);
                } else {
                    obs2_5_2.setPosition(x, y);
                    if (obs2_5_2.position_y <= 169 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_5_2.position(117 * size_dm, 229 * size_dm);
                            effect2_5_2.setObstacleAlpha(200);
                            effect2_5_2.position_effect();
                        } else {
                            effect2_5_2.setObstacleAlpha(0);
                            effect2_5_2.position_effect();
                        }
                    } else {
                        effect2_5_2.setObstacleAlpha(0);
                        effect2_5_2.position_effect();
                    }
                }
            }

            if (pattern[12] == 1) {
                if (obs2_5_3.position_y >= 245 * size_dm) {
                    obs2_5_3.position(117 * size_dm, 80 * size_dm);
                    obs2_5_3.setObstacleAlpha(220);
                } else {
                    obs2_5_3.setPosition(x, y);
                    if (obs2_5_3.position_y <= 195 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_5_3.position(117 * size_dm, 255 * size_dm);
                            effect2_5_3.setObstacleAlpha(200);
                            effect2_5_3.position_effect();
                        } else {
                            effect2_5_3.setObstacleAlpha(0);
                            effect2_5_3.position_effect();
                        }
                    } else {
                        effect2_5_3.setObstacleAlpha(0);
                        effect2_5_3.position_effect();
                    }
                }
            }

            if (pattern[13] == 1) {
                if (obs2_5_4.position_y >= 271 * size_dm) {
                    obs2_5_4.position(117 * size_dm, 80 * size_dm);
                    obs2_5_4.setObstacleAlpha(220);
                } else {
                    obs2_5_4.setPosition(x, y);
                    if (obs2_5_4.position_y <= 221 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_5_4.position(117 * size_dm, 281 * size_dm);
                            effect2_5_4.setObstacleAlpha(200);
                            effect2_5_4.position_effect();
                        } else {
                            effect2_5_4.setObstacleAlpha(0);
                            effect2_5_4.position_effect();
                        }
                    } else {
                        effect2_5_4.setObstacleAlpha(0);
                        effect2_5_4.position_effect();
                    }
                }
            }

            if (pattern[14] == 1) {
                if (obs2_5_5.position_y >= 297 * size_dm) {
                    obs2_5_5.position(117 * size_dm, 80 * size_dm);
                    obs2_5_5.setObstacleAlpha(220);
                } else {
                    obs2_5_5.setPosition(x, y);
                    if (obs2_5_5.position_y <= 247 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_5_5.position(117 * size_dm, 307 * size_dm);
                            effect2_5_5.setObstacleAlpha(200);
                            effect2_5_5.position_effect();
                        } else {
                            effect2_5_5.setObstacleAlpha(0);
                            effect2_5_5.position_effect();
                        }
                    } else {
                        effect2_5_5.setObstacleAlpha(0);
                        effect2_5_5.position_effect();
                    }
                }
            }

            if (pattern[15] == 1) {
                if (obs2_6_1.position_y >= 180 * size_dm) {
                    obs2_6_1.position(130 * size_dm, 80 * size_dm);
                    obs2_6_1.setObstacleAlpha(220);
                } else {
                    obs2_6_1.setPosition(x, y);
                    if (obs2_6_1.position_y <= 130 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_6_1.position(130 * size_dm, 190 * size_dm);
                            effect2_6_1.setObstacleAlpha(200);
                            effect2_6_1.position_effect();
                        } else {
                            effect2_6_1.setObstacleAlpha(0);
                            effect2_6_1.position_effect();
                        }
                    } else {
                        effect2_6_1.setObstacleAlpha(0);
                        effect2_6_1.position_effect();
                    }
                }
            }

            if (pattern[16] == 1) {
                if (obs2_6_2.position_y >= 206 * size_dm) {
                    obs2_6_2.position(130 * size_dm, 80 * size_dm);
                    obs2_6_2.setObstacleAlpha(220);
                } else {
                    obs2_6_2.setPosition(x, y);
                    if (obs2_6_2.position_y <= 156 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_6_2.position(130 * size_dm, 216 * size_dm);
                            effect2_6_2.setObstacleAlpha(200);
                            effect2_6_2.position_effect();
                        } else {
                            effect2_6_2.setObstacleAlpha(0);
                            effect2_6_2.position_effect();
                        }
                    } else {
                        effect2_6_2.setObstacleAlpha(0);
                        effect2_6_2.position_effect();
                    }
                }
            }

            if (pattern[17] == 1) {
                if (obs2_6_3.position_y >= 232 * size_dm) {
                    obs2_6_3.position(130 * size_dm, 80 * size_dm);
                    obs2_6_3.setObstacleAlpha(220);
                } else {
                    obs2_6_3.setPosition(x, y);
                    if (obs2_6_3.position_y <= 182 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_6_3.position(130 * size_dm, 242 * size_dm);
                            effect2_6_3.setObstacleAlpha(200);
                            effect2_6_3.position_effect();
                        } else {
                            effect2_6_3.setObstacleAlpha(0);
                            effect2_6_3.position_effect();
                        }
                    } else {
                        effect2_6_3.setObstacleAlpha(0);
                        effect2_6_3.position_effect();
                    }
                }
            }

            if (pattern[18] == 1) {
                if (obs2_6_4.position_y >= 258 * size_dm) {
                    obs2_6_4.position(130 * size_dm, 80 * size_dm);
                    obs2_6_4.setObstacleAlpha(220);
                } else {
                    obs2_6_4.setPosition(x, y);
                    if (obs2_6_4.position_y <= 208 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_6_4.position(130 * size_dm, 268 * size_dm);
                            effect2_6_4.setObstacleAlpha(200);
                            effect2_6_4.position_effect();
                        } else {
                            effect2_6_4.setObstacleAlpha(0);
                            effect2_6_4.position_effect();
                        }
                    } else {
                        effect2_6_4.setObstacleAlpha(0);
                        effect2_6_4.position_effect();
                    }
                }
            }

            if (pattern[19] == 1) {
                if (obs2_6_5.position_y >= 284 * size_dm) {
                    obs2_6_5.position(130 * size_dm, 80 * size_dm);
                    obs2_6_5.setObstacleAlpha(220);
                } else {
                    obs2_6_5.setPosition(x, y);
                    if (obs2_6_5.position_y <= 234 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_6_5.position(130 * size_dm, 294 * size_dm);
                            effect2_6_5.setObstacleAlpha(200);
                            effect2_6_5.position_effect();
                        } else {
                            effect2_6_5.setObstacleAlpha(0);
                            effect2_6_5.position_effect();
                        }
                    } else {
                        effect2_6_5.setObstacleAlpha(0);
                        effect2_6_5.position_effect();
                    }
                }
            }

            if (pattern[20] == 1) {
                if (obs2_6_6.position_y >= 310 * size_dm) {
                    obs2_6_6.position(130 * size_dm, 80 * size_dm);
                    obs2_6_6.setObstacleAlpha(220);
                } else {
                    obs2_6_6.setPosition(x, y);
                    if (obs2_6_6.position_y <= 260 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_6_6.position(130 * size_dm, 320 * size_dm);
                            effect2_6_6.setObstacleAlpha(200);
                            effect2_6_6.position_effect();
                        } else {
                            effect2_6_6.setObstacleAlpha(0);
                            effect2_6_6.position_effect();
                        }
                    } else {
                        effect2_6_6.setObstacleAlpha(0);
                        effect2_6_6.position_effect();
                    }
                }
            }

            if (pattern[21] == 1) {
                if (obs2_7_1.position_y >= 167 * size_dm) {
                    obs2_7_1.position(143 * size_dm, 80 * size_dm);
                    obs2_7_1.setObstacleAlpha(220);
                } else {
                    obs2_7_1.setPosition(x, y);
                    if (obs2_7_1.position_y <= 117 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_7_1.position(143 * size_dm, 177 * size_dm);
                            effect2_7_1.setObstacleAlpha(200);
                            effect2_7_1.position_effect();
                        } else {
                            effect2_7_1.setObstacleAlpha(0);
                            effect2_7_1.position_effect();
                        }
                    } else {
                        effect2_7_1.setObstacleAlpha(0);
                        effect2_7_1.position_effect();
                    }
                }
            }

            if (pattern[22] == 1) {
                if (obs2_7_2.position_y >= 193 * size_dm) {
                    obs2_7_2.position(143 * size_dm, 80 * size_dm);
                    obs2_7_2.setObstacleAlpha(220);
                } else {
                    obs2_7_2.setPosition(x, y);
                    if (obs2_7_2.position_y <= 173 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_7_2.position(143 * size_dm, 203 * size_dm);
                            effect2_7_2.setObstacleAlpha(200);
                            effect2_7_2.position_effect();
                        } else {
                            effect2_7_2.setObstacleAlpha(0);
                            effect2_7_2.position_effect();
                        }
                    } else {
                        effect2_7_2.setObstacleAlpha(0);
                        effect2_7_2.position_effect();
                    }
                }
            }

            if (pattern[23] == 1) {
                if (obs2_7_3.position_y >= 219 * size_dm) {
                    obs2_7_3.position(143 * size_dm, 80 * size_dm);
                    obs2_7_3.setObstacleAlpha(220);
                } else {
                    obs2_7_3.setPosition(x, y);
                    if (obs2_7_3.position_y <= 169 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_7_3.position(143 * size_dm, 229 * size_dm);
                            effect2_7_3.setObstacleAlpha(200);
                            effect2_7_3.position_effect();
                        } else {
                            effect2_7_3.setObstacleAlpha(0);
                            effect2_7_3.position_effect();
                        }
                    } else {
                        effect2_7_3.setObstacleAlpha(0);
                        effect2_7_3.position_effect();
                    }
                }
            }

            if (pattern[24] == 1) {
                if (obs2_7_4.position_y >= 245 * size_dm) {
                    obs2_7_4.position(143 * size_dm, 80 * size_dm);
                    obs2_7_4.setObstacleAlpha(220);
                } else {
                    obs2_7_4.setPosition(x, y);
                    if (obs2_7_4.position_y <= 195 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_7_4.position(143 * size_dm, 255 * size_dm);
                            effect2_7_4.setObstacleAlpha(200);
                            effect2_7_4.position_effect();
                        } else {
                            effect2_7_4.setObstacleAlpha(0);
                            effect2_7_4.position_effect();
                        }
                    } else {
                        effect2_7_4.setObstacleAlpha(0);
                        effect2_7_4.position_effect();
                    }
                }
            }

            if (pattern[25] == 1) {
                if (obs2_7_5.position_y >= 271 * size_dm) {
                    obs2_7_5.position(143 * size_dm, 80 * size_dm);
                    obs2_7_5.setObstacleAlpha(220);
                } else {
                    obs2_7_5.setPosition(x, y);
                    if (obs2_7_5.position_y <= 221 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_7_5.position(143 * size_dm, 281 * size_dm);
                            effect2_7_5.setObstacleAlpha(200);
                            effect2_7_5.position_effect();
                        } else {
                            effect2_7_5.setObstacleAlpha(0);
                            effect2_7_5.position_effect();
                        }
                    } else {
                        effect2_7_4.setObstacleAlpha(0);
                        effect2_7_4.position_effect();
                    }
                }
            }

            if (pattern[26] == 1) {
                if (obs2_7_6.position_y >= 297 * size_dm) {
                    obs2_7_6.position(143 * size_dm, 80 * size_dm);
                    obs2_7_6.setObstacleAlpha(220);
                } else {
                    obs2_7_6.setPosition(x, y);
                    if (obs2_7_6.position_y <= 247 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_7_6.position(143 * size_dm, 307 * size_dm);
                            effect2_7_6.setObstacleAlpha(200);
                            effect2_7_6.position_effect();
                        } else {
                            effect2_7_6.setObstacleAlpha(0);
                            effect2_7_6.position_effect();
                        }
                    } else {
                        effect2_7_6.setObstacleAlpha(0);
                        effect2_7_6.position_effect();
                    }
                }
            }

            if (pattern[27] == 1) {
                if (obs2_7_7.position_y >= 323 * size_dm) {
                    obs2_7_7.position(143 * size_dm, 80 * size_dm);
                    obs2_7_7.setObstacleAlpha(220);
                } else {
                    obs2_7_7.setPosition(x, y);
                    if (obs2_7_7.position_y <= 273 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_7_7.position(143 * size_dm, 333 * size_dm);
                            effect2_7_7.setObstacleAlpha(200);
                            effect2_7_7.position_effect();
                        } else {
                            effect2_7_7.setObstacleAlpha(0);
                            effect2_7_7.position_effect();
                        }
                    } else {
                        effect2_7_7.setObstacleAlpha(0);
                        effect2_7_7.position_effect();
                    }
                }
            }

            if (pattern[28] == 1) {
                if (obs2_8_1.position_y >= 154 * size_dm) {
                    obs2_8_1.position(156 * size_dm, 80 * size_dm);
                    obs2_8_1.setObstacleAlpha(220);
                } else {
                    obs2_8_1.setPosition(x, y);
                    if (obs2_8_1.position_y <= 104 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_8_1.position(156 * size_dm, 164 * size_dm);
                            effect2_8_1.setObstacleAlpha(200);
                            effect2_8_1.position_effect();
                        } else {
                            effect2_8_1.setObstacleAlpha(0);
                            effect2_8_1.position_effect();
                        }
                    } else {
                        effect2_8_1.setObstacleAlpha(0);
                        effect2_8_1.position_effect();
                    }
                }
            }

            if (pattern[29] == 1) {
                if (obs2_8_2.position_y >= 180 * size_dm) {
                    obs2_8_2.position(156 * size_dm, 80 * size_dm);
                    obs2_8_2.setObstacleAlpha(220);
                } else {
                    obs2_8_2.setPosition(x, y);
                    if (obs2_8_2.position_y <= 130 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_8_2.position(156 * size_dm, 190 * size_dm);
                            effect2_8_2.setObstacleAlpha(200);
                            effect2_8_2.position_effect();
                        } else {
                            effect2_8_2.setObstacleAlpha(0);
                            effect2_8_2.position_effect();
                        }
                    } else {
                        effect2_8_2.setObstacleAlpha(0);
                        effect2_8_2.position_effect();
                    }
                }
            }

            if (pattern[30] == 1) {
                if (obs2_8_3.position_y >= 206 * size_dm) {
                    obs2_8_3.position(156 * size_dm, 80 * size_dm);
                    obs2_8_3.setObstacleAlpha(220);
                } else {
                    obs2_8_3.setPosition(x, y);
                    if (obs2_8_3.position_y <= 156 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_8_3.position(156 * size_dm, 216 * size_dm);
                            effect2_8_3.setObstacleAlpha(200);
                            effect2_8_3.position_effect();
                        } else {
                            effect2_8_3.setObstacleAlpha(0);
                            effect2_8_3.position_effect();
                        }
                    } else {
                        effect2_8_3.setObstacleAlpha(0);
                        effect2_8_3.position_effect();
                    }
                }
            }

            if (pattern[31] == 1) {
                if (obs2_8_4.position_y >= 232 * size_dm) {
                    obs2_8_4.position(156 * size_dm, 80 * size_dm);
                    obs2_8_4.setObstacleAlpha(220);
                } else {
                    obs2_8_4.setPosition(x, y);
                    if (obs2_8_4.position_y <= 182 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_8_4.position(156 * size_dm, 242 * size_dm);
                            effect2_8_4.setObstacleAlpha(200);
                            effect2_8_4.position_effect();
                        } else {
                            effect2_8_4.setObstacleAlpha(0);
                            effect2_8_4.position_effect();
                        }
                    } else {
                        effect2_8_4.setObstacleAlpha(0);
                        effect2_8_4.position_effect();
                    }
                }
            }

            if (pattern[32] == 1) {
                if (obs2_8_5.position_y >= 258 * size_dm) {
                    obs2_8_5.position(156 * size_dm, 80 * size_dm);
                    obs2_8_5.setObstacleAlpha(220);
                } else {
                    obs2_8_5.setPosition(x, y);
                    if (obs2_8_5.position_y <= 208 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_8_5.position(156 * size_dm, 268 * size_dm);
                            effect2_8_5.setObstacleAlpha(200);
                            effect2_8_5.position_effect();
                        } else {
                            effect2_8_5.setObstacleAlpha(0);
                            effect2_8_5.position_effect();
                        }
                    } else {
                        effect2_8_5.setObstacleAlpha(0);
                        effect2_8_5.position_effect();
                    }
                }
            }

            if (pattern[33] == 1) {
                if (obs2_8_6.position_y >= 284 * size_dm) {
                    obs2_8_6.position(156 * size_dm, 80 * size_dm);
                    obs2_8_6.setObstacleAlpha(220);
                } else {
                    obs2_8_6.setPosition(x, y);
                    if (obs2_8_6.position_y <= 234 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_8_6.position(156 * size_dm, 294 * size_dm);
                            effect2_8_6.setObstacleAlpha(200);
                            effect2_8_6.position_effect();
                        } else {
                            effect2_8_6.setObstacleAlpha(0);
                            effect2_8_6.position_effect();
                        }
                    } else {
                        effect2_8_6.setObstacleAlpha(0);
                        effect2_8_6.position_effect();
                    }
                }
            }

            if (pattern[34] == 1) {
                if (obs2_8_7.position_y >= 310 * size_dm) {
                    obs2_8_7.position(156 * size_dm, 80 * size_dm);
                    obs2_8_7.setObstacleAlpha(220);
                } else {
                    obs2_8_7.setPosition(x, y);
                    if (obs2_8_7.position_y <= 260 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_8_7.position(156 * size_dm, 320 * size_dm);
                            effect2_8_7.setObstacleAlpha(200);
                            effect2_8_7.position_effect();
                        } else {
                            effect2_8_7.setObstacleAlpha(0);
                            effect2_8_7.position_effect();
                        }
                    } else {
                        effect2_8_7.setObstacleAlpha(0);
                        effect2_8_7.position_effect();
                    }
                }
            }

            if (pattern[35] == 1) {
                if (obs2_8_8.position_y >= 336 * size_dm) {
                    obs2_8_8.position(156 * size_dm, 80 * size_dm);
                    obs2_8_8.setObstacleAlpha(220);
                } else {
                    obs2_8_8.setPosition(x, y);
                    if (obs2_8_8.position_y <= 286 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_8_8.position(156 * size_dm, 346 * size_dm);
                            effect2_8_8.setObstacleAlpha(200);
                            effect2_8_8.position_effect();
                        } else {
                            effect2_8_8.setObstacleAlpha(0);
                            effect2_8_8.position_effect();
                        }
                    } else {
                        effect2_8_8.setObstacleAlpha(0);
                        effect2_8_8.position_effect();
                    }
                }
            }

            if (pattern[36] == 1) {
                if (obs2_9_1.position_y >= 167 * size_dm) {
                    obs2_9_1.position(169 * size_dm, 80 * size_dm);
                    obs2_9_1.setObstacleAlpha(220);
                } else {
                    obs2_9_1.setPosition(x, y);
                    if (obs2_9_1.position_y <= 117 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_9_1.position(169 * size_dm, 177 * size_dm);
                            effect2_9_1.setObstacleAlpha(200);
                            effect2_9_1.position_effect();
                        } else {
                            effect2_9_1.setObstacleAlpha(0);
                            effect2_9_1.position_effect();
                        }
                    } else {
                        effect2_9_1.setObstacleAlpha(0);
                        effect2_9_1.position_effect();
                    }
                }
            }

            if (pattern[37] == 1) {
                if (obs2_9_2.position_y >= 193 * size_dm) {
                    obs2_9_2.position(169 * size_dm, 80 * size_dm);
                    obs2_9_2.setObstacleAlpha(220);
                } else {
                    obs2_9_2.setPosition(x, y);
                    if (obs2_9_2.position_y <= 143 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_9_2.position(169 * size_dm, 203 * size_dm);
                            effect2_9_2.setObstacleAlpha(200);
                            effect2_9_2.position_effect();
                        } else {
                            effect2_9_2.setObstacleAlpha(0);
                            effect2_9_2.position_effect();
                        }
                    } else {
                        effect2_9_2.setObstacleAlpha(0);
                        effect2_9_2.position_effect();
                    }
                }
            }

            if (pattern[38] == 1) {
                if (obs2_9_3.position_y >= 219 * size_dm) {
                    obs2_9_3.position(169 * size_dm, 80 * size_dm);
                    obs2_9_3.setObstacleAlpha(220);
                } else {
                    obs2_9_3.setPosition(x, y);
                    if (obs2_9_3.position_y <= 169 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_9_3.position(169 * size_dm, 229 * size_dm);
                            effect2_9_3.setObstacleAlpha(200);
                            effect2_9_3.position_effect();
                        } else {
                            effect2_9_3.setObstacleAlpha(0);
                            effect2_9_3.position_effect();
                        }
                    } else {
                        effect2_9_3.setObstacleAlpha(0);
                        effect2_9_3.position_effect();
                    }
                }
            }

            if (pattern[39] == 1) {
                if (obs2_9_4.position_y >= 245 * size_dm) {
                    obs2_9_4.position(169 * size_dm, 80 * size_dm);
                    obs2_9_4.setObstacleAlpha(220 * size_dm);
                } else {
                    obs2_9_4.setPosition(x, y);
                    if (obs2_9_4.position_y <= 195 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_9_4.position(169 * size_dm, 255 * size_dm);
                            effect2_9_4.setObstacleAlpha(200);
                            effect2_9_4.position_effect();
                        } else {
                            effect2_9_4.setObstacleAlpha(0);
                            effect2_9_4.position_effect();
                        }
                    } else {
                        effect2_9_4.setObstacleAlpha(0);
                        effect2_9_4.position_effect();
                    }
                }
            }

            if (pattern[40] == 1) {
                if (obs2_9_5.position_y >= 271 * size_dm) {
                    obs2_9_5.position(169 * size_dm, 80 * size_dm);
                    obs2_9_5.setObstacleAlpha(220);
                } else {
                    obs2_9_5.setPosition(x, y);
                    if (obs2_9_5.position_y <= 221 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_9_5.position(169 * size_dm, 281 * size_dm);
                            effect2_9_5.setObstacleAlpha(200);
                            effect2_9_5.position_effect();
                        } else {
                            effect2_9_5.setObstacleAlpha(0);
                            effect2_9_5.position_effect();
                        }
                    } else {
                        effect2_9_5.setObstacleAlpha(0);
                        effect2_9_5.position_effect();
                    }
                }
            }

            if (pattern[41] == 1) {
                if (obs2_9_6.position_y >= 297 * size_dm) {
                    obs2_9_6.position(169 * size_dm, 80 * size_dm);
                    obs2_9_6.setObstacleAlpha(220);
                } else {
                    obs2_9_6.setPosition(x, y);
                    if (obs2_9_6.position_y <= 247 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_9_6.position(169 * size_dm, 307 * size_dm);
                            effect2_9_6.setObstacleAlpha(200);
                            effect2_9_6.position_effect();
                        } else {
                            effect2_9_6.setObstacleAlpha(0);
                            effect2_9_6.position_effect();
                        }
                    } else {
                        effect2_9_6.setObstacleAlpha(0);
                        effect2_9_6.position_effect();
                    }
                }
            }

            if (pattern[42] == 1) {
                if (obs2_9_7.position_y >= 323 * size_dm) {
                    obs2_9_7.position(169 * size_dm, 80 * size_dm);
                    obs2_9_7.setObstacleAlpha(220);
                } else {
                    obs2_9_7.setPosition(x, y);
                    if (obs2_9_7.position_y <= 273 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_9_7.position(169 * size_dm, 333 * size_dm);
                            effect2_9_7.setObstacleAlpha(200);
                            effect2_9_7.position_effect();
                        } else {
                            effect2_9_7.setObstacleAlpha(0);
                            effect2_9_7.position_effect();
                        }
                    } else {
                        effect2_9_7.setObstacleAlpha(0);
                        effect2_9_7.position_effect();
                    }
                }
            }

            if (pattern[43] == 1) {
                if (obs2_10_1.position_y >= 180 * size_dm) {
                    obs2_10_1.position(182 * size_dm, 80 * size_dm);
                    obs2_10_1.setObstacleAlpha(220);
                } else {
                    obs2_10_1.setPosition(x, y);
                    if (obs2_10_1.position_y <= 130 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_10_1.position(182 * size_dm, 190 * size_dm);
                            effect2_10_1.setObstacleAlpha(200);
                            effect2_10_1.position_effect();
                        } else {
                            effect2_10_1.setObstacleAlpha(0);
                            effect2_10_1.position_effect();
                        }
                    } else {
                        effect2_10_1.setObstacleAlpha(0);
                        effect2_10_1.position_effect();
                    }
                }
            }

            if (pattern[44] == 1) {
                if (obs2_10_2.position_y >= 206 * size_dm) {
                    obs2_10_2.position(182 * size_dm, 80 * size_dm);
                    obs2_10_2.setObstacleAlpha(220);
                } else {
                    obs2_10_2.setPosition(x, y);
                    if (obs2_10_2.position_y <= 156 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_10_2.position(182 * size_dm, 216 * size_dm);
                            effect2_10_2.setObstacleAlpha(200);
                            effect2_10_2.position_effect();
                        } else {
                            effect2_10_2.setObstacleAlpha(0);
                            effect2_10_2.position_effect();
                        }
                    } else {
                        effect2_10_2.setObstacleAlpha(0);
                        effect2_10_2.position_effect();
                    }
                }
            }

            if (pattern[45] == 1) {
                if (obs2_10_3.position_y >= 232 * size_dm) {
                    obs2_10_3.position(182 * size_dm, 80 * size_dm);
                    obs2_10_3.setObstacleAlpha(220);
                } else {
                    obs2_10_3.setPosition(x, y);
                    if (obs2_10_3.position_y <= 182 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_10_3.position(182 * size_dm, 242 * size_dm);
                            effect2_10_3.setObstacleAlpha(200);
                            effect2_10_3.position_effect();
                        } else {
                            effect2_10_3.setObstacleAlpha(0);
                            effect2_10_3.position_effect();
                        }
                    } else {
                        effect2_10_3.setObstacleAlpha(0);
                        effect2_10_3.position_effect();
                    }
                }
            }

            if (pattern[46] == 1) {
                if (obs2_10_4.position_y >= 258 * size_dm) {
                    obs2_10_4.position(182 * size_dm, 80 * size_dm);
                    obs2_10_4.setObstacleAlpha(220);
                } else {
                    obs2_10_4.setPosition(x, y);
                    if (obs2_10_4.position_y <= 208 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_10_4.position(182 * size_dm, 268 * size_dm);
                            effect2_10_4.setObstacleAlpha(200);
                            effect2_10_4.position_effect();
                        } else {
                            effect2_10_4.setObstacleAlpha(0);
                            effect2_10_4.position_effect();
                        }
                    } else {
                        effect2_10_4.setObstacleAlpha(0);
                        effect2_10_4.position_effect();
                    }
                }
            }

            if (pattern[47] == 1) {
                if (obs2_10_5.position_y >= 284 * size_dm) {
                    obs2_10_5.position(182 * size_dm, 80 * size_dm);
                    obs2_10_5.setObstacleAlpha(220);
                } else {
                    obs2_10_5.setPosition(x, y);
                    if (obs2_10_5.position_y <= 234 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_10_5.position(182 * size_dm, 294 * size_dm);
                            effect2_10_5.setObstacleAlpha(200);
                            effect2_10_5.position_effect();
                        } else {
                            effect2_10_5.setObstacleAlpha(0);
                            effect2_10_5.position_effect();
                        }
                    } else {
                        effect2_10_5.setObstacleAlpha(0);
                        effect2_10_5.position_effect();
                    }
                }
            }

            if (pattern[48] == 1) {
                if (obs2_10_6.position_y >= 310 * size_dm) {
                    obs2_10_6.position(182 * size_dm, 80 * size_dm);
                    obs2_10_6.setObstacleAlpha(220);
                } else {
                    obs2_10_6.setPosition(x, y);
                    if (obs2_10_6.position_y <= 270 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_10_6.position(182 * size_dm, 320 * size_dm);
                            effect2_10_6.setObstacleAlpha(200);
                            effect2_10_6.position_effect();
                        } else {
                            effect2_10_6.setObstacleAlpha(0);
                            effect2_10_6.position_effect();
                        }
                    } else {
                        effect2_10_6.setObstacleAlpha(0);
                        effect2_10_6.position_effect();
                    }
                }
            }

            if (pattern[49] == 1) {
                if (obs2_11_1.position_y >= 193 * size_dm) {
                    obs2_11_1.position(195 * size_dm, 80 * size_dm);
                    obs2_11_1.setObstacleAlpha(220);
                } else {
                    obs2_11_1.setPosition(x, y);
                    if (obs2_11_1.position_y <= 143 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_11_1.position(195 * size_dm, 203 * size_dm);
                            effect2_11_1.setObstacleAlpha(200);
                            effect2_11_1.position_effect();
                        } else {
                            effect2_11_1.setObstacleAlpha(0);
                            effect2_11_1.position_effect();
                        }
                    } else {
                        effect2_11_1.setObstacleAlpha(0);
                        effect2_11_1.position_effect();
                    }
                }
            }

            if (pattern[50] == 1) {
                if (obs2_11_2.position_y >= 219 * size_dm) {
                    obs2_11_2.position(195 * size_dm, 80 * size_dm);
                    obs2_11_2.setObstacleAlpha(220);
                } else {
                    obs2_11_2.setPosition(x, y);
                    if (obs2_11_2.position_y <= 169 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_11_2.position(195 * size_dm, 229 * size_dm);
                            effect2_11_2.setObstacleAlpha(200);
                            effect2_11_2.position_effect();
                        } else {
                            effect2_11_2.setObstacleAlpha(0);
                            effect2_11_2.position_effect();
                        }
                    } else {
                        effect2_11_2.setObstacleAlpha(0);
                        effect2_11_2.position_effect();
                    }
                }
            }

            if (pattern[51] == 1) {
                if (obs2_11_3.position_y >= 245 * size_dm) {
                    obs2_11_3.position(195 * size_dm, 80 * size_dm);
                    obs2_11_3.setObstacleAlpha(220);
                } else {
                    obs2_11_3.setPosition(x, y);
                    if (obs2_11_3.position_y <= 195 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_11_3.position(195 * size_dm, 255 * size_dm);
                            effect2_11_3.setObstacleAlpha(200);
                            effect2_11_3.position_effect();
                        } else {
                            effect2_11_3.setObstacleAlpha(0);
                            effect2_11_3.position_effect();
                        }
                    } else {
                        effect2_11_3.setObstacleAlpha(0);
                        effect2_11_3.position_effect();
                    }
                }
            }

            if (pattern[52] == 1) {
                if (obs2_11_4.position_y >= 271 * size_dm) {
                    obs2_11_4.position(195 * size_dm, 80 * size_dm);
                    obs2_11_4.setObstacleAlpha(220);
                } else {
                    obs2_11_4.setPosition(x, y);
                    if (obs2_11_4.position_y <= 221 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_11_4.position(195 * size_dm, 281 * size_dm);
                            effect2_11_4.setObstacleAlpha(200);
                            effect2_11_4.position_effect();
                        } else {
                            effect2_11_4.setObstacleAlpha(0);
                            effect2_11_4.position_effect();
                        }
                    } else {
                        effect2_11_4.setObstacleAlpha(0);
                        effect2_11_4.position_effect();
                    }
                }
            }

            if (pattern[53] == 1) {
                if (obs2_11_5.position_y >= 297 * size_dm) {
                    obs2_11_5.position(195 * size_dm, 80 * size_dm);
                    obs2_11_5.setObstacleAlpha(220);
                } else {
                    obs2_11_5.setPosition(x, y);
                    if (obs2_11_5.position_y <= 247 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_11_5.position(195 * size_dm, 307 * size_dm);
                            effect2_11_5.setObstacleAlpha(200);
                            effect2_11_5.position_effect();
                        } else {
                            effect2_11_5.setObstacleAlpha(0);
                            effect2_11_5.position_effect();
                        }
                    } else {
                        effect2_11_5.setObstacleAlpha(0);
                        effect2_11_5.position_effect();
                    }
                }
            }

            if (pattern[54] == 1) {
                if (obs2_12_1.position_y >= 206 * size_dm) {
                    obs2_12_1.position(208 * size_dm, 80 * size_dm);
                    obs2_12_1.setObstacleAlpha(220);
                } else {
                    obs2_12_1.setPosition(x, y);
                    if (obs2_12_1.position_y <= 156 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_12_1.position(208 * size_dm, 216 * size_dm);
                            effect2_12_1.setObstacleAlpha(200);
                            effect2_12_1.position_effect();
                        } else {
                            effect2_12_1.setObstacleAlpha(0);
                            effect2_12_1.position_effect();
                        }
                    } else {
                        effect2_12_1.setObstacleAlpha(0);
                        effect2_12_1.position_effect();
                    }
                }
            }

            if (pattern[55] == 1) {
                if (obs2_12_2.position_y >= 232 * size_dm) {
                    obs2_12_2.position(208 * size_dm, 80 * size_dm);
                    obs2_12_2.setObstacleAlpha(220);
                } else {
                    obs2_12_2.setPosition(x, y);
                    if (obs2_12_2.position_y <= 182 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_12_2.position(208 * size_dm, 242 * size_dm);
                            effect2_12_2.setObstacleAlpha(200);
                            effect2_12_2.position_effect();
                        } else {
                            effect2_12_2.setObstacleAlpha(0);
                            effect2_12_2.position_effect();
                        }
                    } else {
                        effect2_12_2.setObstacleAlpha(0);
                        effect2_12_2.position_effect();
                    }
                }
            }

            if (pattern[56] == 1) {
                if (obs2_12_3.position_y >= 258 * size_dm) {
                    obs2_12_3.position(208 * size_dm, 80 * size_dm);
                    obs2_12_3.setObstacleAlpha(220);
                } else {
                    obs2_12_3.setPosition(x, y);
                    if (obs2_12_3.position_y <= 208 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_12_3.position(208 * size_dm, 268 * size_dm);
                            effect2_12_3.setObstacleAlpha(200);
                            effect2_12_3.position_effect();
                        } else {
                            effect2_12_3.setObstacleAlpha(0);
                            effect2_12_3.position_effect();
                        }
                    } else {
                        effect2_12_3.setObstacleAlpha(0);
                        effect2_12_3.position_effect();
                    }
                }
            }

            if (pattern[57] == 1) {
                if (obs2_12_4.position_y >= 284 * size_dm) {
                    obs2_12_4.position(208 * size_dm, 80 * size_dm);
                    obs2_12_4.setObstacleAlpha(220);
                } else {
                    obs2_12_4.setPosition(x, y);
                    if (obs2_12_4.position_y <= 234 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_12_4.position(208 * size_dm, 294 * size_dm);
                            effect2_12_4.setObstacleAlpha(200);
                            effect2_12_4.position_effect();
                        } else {
                            effect2_12_4.setObstacleAlpha(0);
                            effect2_12_4.position_effect();
                        }
                    } else {
                        effect2_12_4.setObstacleAlpha(0);
                        effect2_12_4.position_effect();
                    }
                }
            }

            if (pattern[58] == 1) {
                if (obs2_13_1.position_y >= 219 * size_dm) {
                    obs2_13_1.position(221 * size_dm, 80 * size_dm);
                    obs2_13_1.setObstacleAlpha(220);
                } else {
                    obs2_13_1.setPosition(x, y);
                    if (obs2_13_1.position_y <= 169 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_13_1.position(221 * size_dm, 229 * size_dm);
                            effect2_13_1.setObstacleAlpha(200);
                            effect2_13_1.position_effect();
                        } else {
                            effect2_13_1.setObstacleAlpha(0);
                            effect2_13_1.position_effect();
                        }
                    } else {
                        effect2_13_1.setObstacleAlpha(0);
                        effect2_13_1.position_effect();
                    }
                }
            }

            if (pattern[59] == 1) {
                if (obs2_13_2.position_y >= 245 * size_dm) {
                    obs2_13_2.position(221 * size_dm, 80 * size_dm);
                    obs2_13_2.setObstacleAlpha(220);
                } else {
                    obs2_13_2.setPosition(x, y);
                    if (obs2_13_2.position_y <= 195 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_13_2.position(221 * size_dm, 255 * size_dm);
                            effect2_13_2.setObstacleAlpha(200);
                            effect2_13_2.position_effect();
                        } else {
                            effect2_13_2.setObstacleAlpha(0);
                            effect2_13_2.position_effect();
                        }
                    } else {
                        effect2_13_2.setObstacleAlpha(0);
                        effect2_13_2.position_effect();
                    }
                }
            }

            if (pattern[60] == 1) {
                if (obs2_13_3.position_y >= 271 * size_dm) {
                    obs2_13_3.position(221 * size_dm, 80 * size_dm);
                    obs2_13_3.setObstacleAlpha(220);
                } else {
                    obs2_13_3.setPosition(x, y);
                    if (obs2_13_3.position_y <= 221 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_13_3.position(221 * size_dm, 281 * size_dm);
                            effect2_13_3.setObstacleAlpha(200);
                            effect2_13_3.position_effect();
                        } else {
                            effect2_13_3.setObstacleAlpha(0);
                            effect2_13_3.position_effect();
                        }
                    } else {
                        effect2_13_3.setObstacleAlpha(0);
                        effect2_13_3.position_effect();
                    }
                }
            }

            if (pattern[61] == 1) {
                if (obs2_14_1.position_y >= 232 * size_dm) {
                    obs2_14_1.position(234 * size_dm, 80 * size_dm);
                    obs2_14_1.setObstacleAlpha(220);
                } else {
                    obs2_14_1.setPosition(x, y);
                    if (obs2_14_1.position_y <= 182 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_14_1.position(234 * size_dm, 242 * size_dm);
                            effect2_14_1.setObstacleAlpha(200);
                            effect2_14_1.position_effect();
                        } else {
                            effect2_14_1.setObstacleAlpha(0);
                            effect2_14_1.position_effect();
                        }
                    } else {
                        effect2_14_1.setObstacleAlpha(0);
                        effect2_14_1.position_effect();
                    }
                }
            }

            if (pattern[62] == 1) {
                if (obs2_14_2.position_y >= 258 * size_dm) {
                    obs2_14_2.position(234 * size_dm, 80 * size_dm);
                    obs2_14_2.setObstacleAlpha(220);
                } else {
                    obs2_14_2.setPosition(x, y);
                    if (obs2_14_2.position_y <= 208 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_14_2.position(234 * size_dm, 268 * size_dm);
                            effect2_14_2.setObstacleAlpha(200);
                            effect2_14_2.position_effect();
                        } else {
                            effect2_14_2.setObstacleAlpha(0);
                            effect2_14_2.position_effect();
                        }
                    } else {
                        effect2_14_2.setObstacleAlpha(0);
                        effect2_14_2.position_effect();
                    }
                }
            }

            if (pattern[63] == 1) {
                if (obs2_15_1.position_y >= 245 * size_dm) {
                    obs2_15_1.position(247 * size_dm, 80 * size_dm);
                    obs2_15_1.setObstacleAlpha(220);
                } else {
                    obs2_15_1.setPosition(x, y);
                    if (obs2_15_1.position_y <= 195 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect2_15_1.position(247 * size_dm, 255 * size_dm);
                            effect2_15_1.setObstacleAlpha(200);
                            effect2_15_1.position_effect();
                        } else {
                            effect2_15_1.setObstacleAlpha(0);
                            effect2_15_1.position_effect();
                        }
                    } else {
                        effect2_15_1.setObstacleAlpha(0);
                        effect2_15_1.position_effect();
                    }
                }
            }

        }
    }

    boolean hit_check() {

        if (Math.abs(obs2_1.position_y - tile2_13.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile2_13.getY() - tile2_13.getHeight() / 4) * (player.getY() - tile2_13.getY() - tile2_13.getHeight() / 4) < tile2_13.getHeight() / 3 * tile2_13.getHeight() / 2) {
                if ((player.getX() - tile2_13.getX() - tile2_13.getWidth() / 4) * (player.getX() - tile2_13.getX() - tile2_13.getWidth() / 4) < tile2_13.getWidth() / 3 * tile2_13.getWidth() / 2) {
                    return true;
                }
            }
        }


        if (Math.abs(obs2_2_1.position_y - tile1_10.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile1_10.getY() - tile1_10.getHeight() / 4) * (player.getY() - tile1_10.getY() - tile1_10.getHeight() / 4) < tile1_10.getHeight() / 3 * tile1_10.getHeight() / 2) {
                if ((player.getX() - tile1_10.getX() - tile1_10.getWidth() / 4) * (player.getX() - tile1_10.getX() - tile1_10.getWidth() / 4) < tile1_10.getWidth() / 3 * tile1_10.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_2_2.position_y - tile1_17.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile1_17.getY() - tile1_17.getHeight() / 4) * (player.getY() - tile1_17.getY() - tile1_17.getHeight() / 4) < tile1_17.getHeight() / 3 * tile1_17.getHeight() / 2) {
                if ((player.getX() - tile1_17.getX() - tile1_17.getWidth() / 4) * (player.getX() - tile1_17.getX() - tile1_17.getWidth() / 4) < tile1_17.getWidth() / 3 * tile1_17.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_3_1.position_y - tile2_7.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile2_7.getY() - tile2_7.getHeight() / 4) * (player.getY() - tile2_7.getY() - tile2_7.getHeight() / 4) < tile2_7.getHeight() / 3 * tile2_7.getHeight() / 2) {
                if ((player.getX() - tile2_7.getX() - tile2_7.getWidth() / 4) * (player.getX() - tile2_7.getX() - tile2_7.getWidth() / 4) < tile2_7.getWidth() / 3 * tile2_7.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_3_2.position_y - tile2_14.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile2_14.getY() - tile2_14.getHeight() / 4) * (player.getY() - tile2_14.getY() - tile2_14.getHeight() / 4) < tile2_14.getHeight() / 3 * tile2_14.getHeight() / 2) {
                if ((player.getX() - tile2_14.getX() - tile2_14.getWidth() / 4) * (player.getX() - tile2_14.getX() - tile2_14.getWidth() / 4) < tile2_14.getWidth() / 3 * tile2_14.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_3_3.position_y - tile2_21.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile2_21.getY() - tile2_21.getHeight() / 4) * (player.getY() - tile2_21.getY() - tile2_21.getHeight() / 4) < tile2_21.getHeight() / 3 * tile2_21.getHeight() / 2) {
                if ((player.getX() - tile2_21.getX() - tile2_21.getWidth() / 4) * (player.getX() - tile2_21.getX() - tile2_21.getWidth() / 4) < tile2_21.getWidth() / 3 * tile2_21.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_4_1.position_y - tile1_5.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile1_5.getY() - tile1_5.getHeight() / 4) * (player.getY() - tile1_5.getY() - tile1_5.getHeight() / 4) < tile1_5.getHeight() / 3 * tile1_5.getHeight() / 2) {
                if ((player.getX() - tile1_5.getX() - 10 - tile1_5.getWidth() / 4) * (player.getX() - tile1_5.getX() - tile1_5.getWidth() / 4) < tile1_5.getWidth() / 3 * tile1_5.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_4_2.position_y - tile1_11.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile1_11.getY() - tile1_11.getHeight() / 4) * (player.getY() - tile1_11.getY() - tile1_11.getHeight() / 4) < tile1_11.getHeight() / 3 * tile1_11.getHeight() / 2) {
                if ((player.getX() - tile1_11.getX() - tile1_11.getWidth() / 4) * (player.getX() - tile1_11.getX() - tile1_11.getWidth() / 4) < tile1_11.getWidth() / 3 * tile1_11.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_4_3.position_y - tile1_18.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile1_18.getY() - tile1_18.getHeight() / 4) * (player.getY() - tile1_18.getY() - tile1_18.getHeight() / 4) < tile1_18.getHeight() / 3 * tile1_18.getHeight() / 2) {
                if ((player.getX() - tile1_18.getX() - tile1_18.getWidth() / 4) * (player.getX() - tile1_18.getX() - tile1_18.getWidth() / 4) < tile1_18.getWidth() / 3 * tile1_18.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_4_4.position_y - tile1_24.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile1_24.getY() - tile1_24.getHeight() / 4) * (player.getY() - tile1_24.getY() - tile1_24.getHeight() / 4) < tile1_24.getHeight() / 3 * tile1_24.getHeight() / 2) {
                if ((player.getX() - tile1_24.getX() - tile1_24.getWidth() / 4) * (player.getX() - tile1_24.getX() - tile1_24.getWidth() / 4) < tile1_24.getWidth() / 3 * tile1_24.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_5_1.position_y - tile2_3.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile2_3.getY() - tile2_3.getHeight() / 4) * (player.getY() - tile2_3.getY() - tile2_3.getHeight() / 4) < tile2_3.getHeight() / 3 * tile2_3.getHeight() / 2) {
                if ((player.getX() - tile2_3.getX() - tile2_3.getWidth() / 4) * (player.getX() - tile2_3.getX() - tile2_3.getWidth() / 4) < tile2_3.getWidth() / 3 * tile2_3.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_5_2.position_y - tile2_8.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile2_8.getY() - tile2_8.getHeight() / 4) * (player.getY() - tile2_8.getY() - tile2_8.getHeight() / 4) < tile2_8.getHeight() / 3 * tile2_8.getHeight() / 2) {
                if ((player.getX() - tile2_8.getX() - tile2_8.getWidth() / 4) * (player.getX() - tile2_8.getX() - tile2_8.getWidth() / 4) < tile2_8.getWidth() / 3 * tile2_8.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_5_3.position_y - tile2_15.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile2_15.getY() - tile2_15.getHeight() / 4) * (player.getY() - tile2_15.getY() - tile2_15.getHeight() / 4) < tile2_15.getHeight() / 3 * tile2_15.getHeight() / 2) {
                if ((player.getX() - tile2_15.getX() - tile2_15.getWidth() / 4) * (player.getX() - tile2_15.getX() - tile2_15.getWidth() / 4) < tile2_15.getWidth() / 3 * tile2_15.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_5_4.position_y - tile2_22.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile2_22.getY() - tile2_22.getHeight() / 4) * (player.getY() - tile2_22.getY() - tile2_22.getHeight() / 4) < tile2_22.getHeight() / 3 * tile2_22.getHeight() / 2) {
                if ((player.getX() - tile2_22.getX() - tile2_22.getWidth() / 4) * (player.getX() - tile2_22.getX() - tile2_22.getWidth() / 4) < tile2_22.getWidth() / 3 * tile2_22.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_5_5.position_y - tile2_27.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile2_27.getY() - tile2_27.getHeight() / 4) * (player.getY() - tile2_27.getY() - tile2_27.getHeight() / 4) < tile2_27.getHeight() / 3 * tile2_27.getHeight() / 2) {
                if ((player.getX() - tile2_27.getX() - tile2_27.getWidth() / 4) * (player.getX() - tile2_27.getX() - tile2_27.getWidth() / 4) < tile2_27.getWidth() / 3 * tile2_27.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_6_1.position_y - tile1_2.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile1_2.getY() - tile1_2.getHeight() / 4) * (player.getY() - tile1_2.getY() - tile1_2.getHeight() / 4) < tile1_2.getHeight() / 3 * tile1_2.getHeight() / 2) {
                if ((player.getX() - tile1_2.getX() - tile1_2.getWidth() / 4) * (player.getX() - tile1_2.getX() - tile1_2.getWidth() / 4) < tile1_2.getWidth() / 3 * tile1_2.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_6_2.position_y - tile1_6.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile1_6.getY() - tile1_6.getHeight() / 4) * (player.getY() - tile1_6.getY() - tile1_6.getHeight() / 4) < tile1_6.getHeight() / 3 * tile1_6.getHeight() / 2) {
                if ((player.getX() - tile1_6.getX() - tile1_6.getWidth() / 4) * (player.getX() - tile1_6.getX() - tile1_6.getWidth() / 4) < tile1_6.getWidth() / 3 * tile1_6.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_6_3.position_y - tile1_12.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile1_12.getY() - tile1_12.getHeight() / 4) * (player.getY() - tile1_12.getY() - tile1_12.getHeight() / 4) < tile1_12.getHeight() / 3 * tile1_12.getHeight() / 2) {
                if ((player.getX() - tile1_12.getX() - tile1_12.getWidth() / 4) * (player.getX() - tile1_12.getX() - tile1_12.getWidth() / 4) < tile1_12.getWidth() / 3 * tile1_12.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_6_4.position_y - tile1_19.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile1_19.getY() - tile1_19.getHeight() / 4) * (player.getY() - tile1_19.getY() - tile1_19.getHeight() / 4) < tile1_19.getHeight() / 3 * tile1_19.getHeight() / 2) {
                if ((player.getX() - tile1_19.getX() - tile1_19.getWidth() / 4) * (player.getX() - tile1_19.getX() - tile1_19.getWidth() / 4) < tile1_19.getWidth() / 3 * tile1_19.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_6_5.position_y - tile1_25.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile1_25.getY() - tile1_25.getHeight() / 4) * (player.getY() - tile1_25.getY() - tile1_25.getHeight() / 4) < tile1_25.getHeight() / 3 * tile1_25.getHeight() / 2) {
                if ((player.getX() - tile1_25.getX() - tile1_25.getWidth() / 4) * (player.getX() - tile1_25.getX() - tile1_25.getWidth() / 4) < tile1_25.getWidth() / 3 * tile1_25.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_6_6.position_y - tile1_29.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile1_29.getY() - tile1_29.getHeight() / 4) * (player.getY() - tile1_29.getY() - tile1_29.getHeight() / 4) < tile1_29.getHeight() / 3 * tile1_29.getHeight() / 2) {
                if ((player.getX() - tile1_29.getX() - tile1_29.getWidth() / 4) * (player.getX() - tile1_29.getX() - tile1_29.getWidth() / 4) < tile1_29.getWidth() / 3 * tile1_29.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_7_1.position_y - tile2_1.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile2_1.getY() - tile2_1.getHeight() / 4) * (player.getY() - tile2_1.getY() - tile2_1.getHeight() / 4) < tile2_1.getHeight() / 3 * tile2_1.getHeight() / 2) {
                if ((player.getX() - tile2_1.getX() - tile2_1.getWidth() / 4) * (player.getX() - tile2_1.getX() - tile2_1.getWidth() / 4) < tile2_1.getWidth() / 3 * tile2_1.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_7_2.position_y - tile2_4.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile2_4.getY() - tile2_4.getHeight() / 4) * (player.getY() - tile2_4.getY() - tile2_4.getHeight() / 4) < tile2_4.getHeight() / 3 * tile2_4.getHeight() / 2) {
                if ((player.getX() - tile2_4.getX() - tile2_4.getWidth() / 4) * (player.getX() - tile2_4.getX() - tile2_4.getWidth() / 4) < tile2_4.getWidth() / 3 * tile2_4.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_7_3.position_y - tile2_9.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile2_9.getY() - tile2_9.getHeight() / 4) * (player.getY() - tile2_9.getY() - tile2_9.getHeight() / 4) < tile2_9.getHeight() / 3 * tile2_9.getHeight() / 2) {
                if ((player.getX() - tile2_9.getX() - tile2_9.getWidth() / 4) * (player.getX() - tile2_9.getX() - tile2_9.getWidth() / 4) < tile2_9.getWidth() / 3 * tile2_9.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_7_4.position_y - tile2_16.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile2_16.getY() - tile2_16.getHeight() / 4) * (player.getY() - tile2_16.getY() - tile2_16.getHeight() / 4) < tile2_16.getHeight() / 3 * tile2_16.getHeight() / 2) {
                if ((player.getX() - tile2_16.getX() - tile2_16.getWidth() / 4) * (player.getX() - tile2_16.getX() - tile2_16.getWidth() / 4) < tile2_16.getWidth() / 3 * tile2_16.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_7_5.position_y - tile2_23.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile2_23.getY() - tile2_23.getHeight() / 4) * (player.getY() - tile2_23.getY() - tile2_23.getHeight() / 4) < tile2_23.getHeight() / 3 * tile2_23.getHeight() / 2) {
                if ((player.getX() - tile2_23.getX() - tile2_23.getWidth() / 4) * (player.getX() - tile2_23.getX() - tile2_23.getWidth() / 4) < tile2_23.getWidth() / 3 * tile2_23.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_7_6.position_y - tile2_28.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile2_28.getY() - tile2_28.getHeight() / 4) * (player.getY() - tile2_28.getY() - tile2_28.getHeight() / 4) < tile2_28.getHeight() / 3 * tile2_28.getHeight() / 2) {
                if ((player.getX() - tile2_28.getX() - tile2_28.getWidth() / 4) * (player.getX() - tile2_28.getX() - tile2_28.getWidth() / 4) < tile2_28.getWidth() / 3 * tile2_28.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_7_7.position_y - tile2_31.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile2_31.getY() - tile2_31.getHeight() / 4) * (player.getY() - tile2_31.getY() - tile2_31.getHeight() / 4) < tile2_31.getHeight() / 3 * tile2_31.getHeight() / 2) {
                if ((player.getX() - tile2_31.getX() - tile2_31.getWidth() / 4) * (player.getX() - tile2_31.getX() - tile2_31.getWidth() / 4) < tile2_31.getWidth() / 3 * tile2_31.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_8_1.position_y - tile1_1.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile1_1.getY() - tile1_1.getHeight() / 4) * (player.getY() - tile1_1.getY() - tile1_1.getHeight() / 4) < tile1_1.getHeight() / 3 * tile1_1.getHeight() / 2) {
                if ((player.getX() - tile1_1.getX() - tile1_1.getWidth() / 4) * (player.getX() - tile1_1.getX() - tile1_1.getWidth() / 4) < tile1_1.getWidth() / 3 * tile1_1.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_8_2.position_y - tile1_3.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile1_3.getY() - tile1_3.getHeight() / 4) * (player.getY() - tile1_3.getY() - tile1_3.getHeight() / 4) < tile1_3.getHeight() / 3 * tile1_3.getHeight() / 2) {
                if ((player.getX() - tile1_3.getX() - tile1_3.getWidth() / 4) * (player.getX() - tile1_3.getX() - tile1_3.getWidth() / 4) < tile1_3.getWidth() / 3 * tile1_3.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_8_3.position_y - tile1_7.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile1_7.getY() - tile1_7.getHeight() / 4) * (player.getY() - tile1_7.getY() - tile1_7.getHeight() / 4) < tile1_7.getHeight() / 3 * tile1_7.getHeight() / 2) {
                if ((player.getX() - tile1_7.getX() - tile1_7.getWidth() / 4) * (player.getX() - tile1_7.getX() - tile1_7.getWidth() / 4) < tile1_7.getWidth() / 3 * tile1_7.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_8_4.position_y - tile1_13.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile1_13.getY() - tile1_13.getHeight() / 4) * (player.getY() - tile1_13.getY() - tile1_13.getHeight() / 4) < tile1_13.getHeight() / 3 * tile1_13.getHeight() / 2) {
                if ((player.getX() - tile1_13.getX() - tile1_13.getWidth() / 4) * (player.getX() - tile1_13.getX() - tile1_13.getWidth() / 4) < tile1_13.getWidth() / 3 * tile1_13.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_8_5.position_y - tile1_20.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile1_20.getY() - tile1_20.getHeight() / 4) * (player.getY() - tile1_20.getY() - tile1_20.getHeight() / 4) < tile1_20.getHeight() / 3 * tile1_20.getHeight() / 2) {
                if ((player.getX() - tile1_20.getX() - tile1_20.getWidth() / 4) * (player.getX() - tile1_20.getX() - tile1_20.getWidth() / 4) < tile1_20.getWidth() / 3 * tile1_20.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_8_6.position_y - tile1_26.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile1_26.getY() - tile1_26.getHeight() / 4) * (player.getY() - tile1_26.getY() - tile1_26.getHeight() / 4) < tile1_26.getHeight() / 3 * tile1_26.getHeight() / 2) {
                if ((player.getX() - tile1_26.getX() - tile1_26.getWidth() / 4) * (player.getX() - tile1_26.getX() - tile1_26.getWidth() / 4) < tile1_26.getWidth() / 3 * tile1_26.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_8_7.position_y - tile1_30.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile1_30.getY() - tile1_30.getHeight() / 4) * (player.getY() - tile1_30.getY() - tile1_30.getHeight() / 4) < tile1_30.getHeight() / 3 * tile1_30.getHeight() / 2) {
                if ((player.getX() - tile1_30.getX() - tile1_30.getWidth() / 4) * (player.getX() - tile1_30.getX() - tile1_30.getWidth() / 4) < tile1_30.getWidth() / 3 * tile1_30.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_8_8.position_y - tile1_32.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile1_32.getY() - tile1_32.getHeight() / 4) * (player.getY() - tile1_32.getY() - tile1_32.getHeight() / 4) < tile1_32.getHeight() / 3 * tile1_32.getHeight() / 2) {
                if ((player.getX() - tile1_32.getX() - tile1_32.getWidth() / 4) * (player.getX() - tile1_32.getX() - tile1_32.getWidth() / 4) < tile1_32.getWidth() / 3 * tile1_32.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_9_1.position_y - tile2_2.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile2_2.getY() - tile2_2.getHeight() / 4) * (player.getY() - tile2_2.getY() - tile2_2.getHeight() / 4) < tile2_2.getHeight() / 3 * tile2_2.getHeight() / 2) {
                if ((player.getX() - tile2_2.getX() - tile2_2.getWidth() / 4) * (player.getX() - tile2_2.getX() - tile2_2.getWidth() / 4) < tile2_2.getWidth() / 3 * tile2_2.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_9_2.position_y - tile2_5.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile2_5.getY() - tile2_5.getHeight() / 4) * (player.getY() - tile2_5.getY() - tile2_5.getHeight() / 4) < tile2_5.getHeight() / 3 * tile2_5.getHeight() / 2) {
                if ((player.getX() - tile2_5.getX() - tile2_5.getWidth() / 4) * (player.getX() - tile2_5.getX() - tile2_5.getWidth() / 4) < tile2_5.getWidth() / 3 * tile2_5.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_9_3.position_y - tile2_10.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile2_10.getY() - tile2_10.getHeight() / 4) * (player.getY() - tile2_10.getY() - tile2_10.getHeight() / 4) < tile2_10.getHeight() / 3 * tile2_10.getHeight() / 2) {
                if ((player.getX() - tile2_10.getX() - tile2_10.getWidth() / 4) * (player.getX() - tile2_10.getX() - tile2_10.getWidth() / 4) < tile2_10.getWidth() / 3 * tile2_10.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_9_4.position_y - tile2_17.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile2_17.getY() - tile2_17.getHeight() / 4) * (player.getY() - tile2_17.getY() - tile2_17.getHeight() / 4) < tile2_17.getHeight() / 3 * tile2_17.getHeight() / 2) {
                if ((player.getX() - tile2_17.getX() - tile2_17.getWidth() / 4) * (player.getX() - tile2_17.getX() - tile2_17.getWidth() / 4) < tile2_17.getWidth() / 3 * tile2_17.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_9_5.position_y - tile2_24.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile2_24.getY() - tile2_24.getHeight() / 4) * (player.getY() - tile2_24.getY() - tile2_24.getHeight() / 4) < tile2_24.getHeight() / 3 * tile2_24.getHeight() / 2) {
                if ((player.getX() - tile2_24.getX() - tile2_24.getWidth() / 4) * (player.getX() - tile2_24.getX() - tile2_24.getWidth() / 4) < tile2_24.getWidth() / 3 * tile2_24.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_9_6.position_y - tile2_29.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile2_29.getY() - tile2_29.getHeight() / 4) * (player.getY() - tile2_29.getY() - tile2_29.getHeight() / 4) < tile2_29.getHeight() / 3 * tile2_29.getHeight() / 2) {
                if ((player.getX() - tile2_29.getX() - tile2_29.getWidth() / 4) * (player.getX() - tile2_29.getX() - tile2_29.getWidth() / 4) < tile2_29.getWidth() / 3 * tile2_29.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_9_7.position_y - tile2_32.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile2_32.getY() - tile2_32.getHeight() / 4) * (player.getY() - tile2_32.getY() - tile2_32.getHeight() / 4) < tile2_32.getHeight() / 3 * tile2_32.getHeight() / 2) {
                if ((player.getX() - tile2_32.getX() - tile2_32.getWidth() / 4) * (player.getX() - tile2_32.getX() - tile2_32.getWidth() / 4) < tile2_32.getWidth() / 3 * tile2_32.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_10_1.position_y - tile1_4.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile1_4.getY() - tile1_4.getHeight() / 4) * (player.getY() - tile1_4.getY() - tile1_4.getHeight() / 4) < tile1_4.getHeight() / 3 * tile1_4.getHeight() / 2) {
                if ((player.getX() - tile1_4.getX() - tile1_4.getWidth() / 4) * (player.getX() - tile1_4.getX() - tile1_4.getWidth() / 4) < tile1_4.getWidth() / 3 * tile1_4.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_10_2.position_y - tile1_8.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile1_8.getY() - tile1_8.getHeight() / 4) * (player.getY() - tile1_8.getY() - tile1_8.getHeight() / 4) < tile1_8.getHeight() / 3 * tile1_8.getHeight() / 2) {
                if ((player.getX() - tile1_8.getX() - tile1_8.getWidth() / 4) * (player.getX() - tile1_8.getX() - tile1_8.getWidth() / 4) < tile1_8.getWidth() / 3 * tile1_8.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_10_3.position_y - tile1_14.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile1_14.getY() - tile1_14.getHeight() / 4) * (player.getY() - tile1_14.getY() - tile1_14.getHeight() / 4) < tile1_14.getHeight() / 3 * tile1_14.getHeight() / 2) {
                if ((player.getX() - tile1_14.getX() - tile1_14.getWidth() / 4) * (player.getX() - tile1_14.getX() - tile1_14.getWidth() / 4) < tile1_14.getWidth() / 3 * tile1_14.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_10_4.position_y - tile1_21.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile1_21.getY() - tile1_21.getHeight() / 4) * (player.getY() - tile1_21.getY() - tile1_21.getHeight() / 4) < tile1_21.getHeight() / 3 * tile1_21.getHeight() / 2) {
                if ((player.getX() - tile1_21.getX() - tile1_21.getWidth() / 4) * (player.getX() - tile1_21.getX() - tile1_21.getWidth() / 4) < tile1_21.getWidth() / 3 * tile1_21.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_10_5.position_y - tile1_27.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile1_27.getY() - tile1_27.getHeight() / 4) * (player.getY() - tile1_27.getY() - tile1_27.getHeight() / 4) < tile1_27.getHeight() / 3 * tile1_27.getHeight() / 2) {
                if ((player.getX() - tile1_27.getX() - tile1_27.getWidth() / 4) * (player.getX() - tile1_27.getX() - tile1_27.getWidth() / 4) < tile1_27.getWidth() / 3 * tile1_27.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_10_6.position_y - tile1_31.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile1_31.getY() - tile1_31.getHeight() / 4) * (player.getY() - tile1_31.getY() - tile1_31.getHeight() / 4) < tile1_31.getHeight() / 3 * tile1_31.getHeight() / 2) {
                if ((player.getX() - tile1_31.getX() - tile1_31.getWidth() / 4) * (player.getX() - tile1_31.getX() - tile1_31.getWidth() / 4) < tile1_31.getWidth() / 3 * tile1_31.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_11_1.position_y - tile2_6.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile2_6.getY() - tile2_6.getHeight() / 4) * (player.getY() - tile2_6.getY() - tile2_6.getHeight() / 4) < tile2_6.getHeight() / 3 * tile2_6.getHeight() / 2) {
                if ((player.getX() - tile2_6.getX() - tile2_6.getWidth() / 4) * (player.getX() - tile2_6.getX() - tile2_6.getWidth() / 4) < tile2_6.getWidth() / 3 * tile2_6.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_11_2.position_y - tile2_11.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile2_11.getY() - tile2_11.getHeight() / 4) * (player.getY() - tile2_11.getY() - tile2_11.getHeight() / 4) < tile2_11.getHeight() / 3 * tile2_11.getHeight() / 2) {
                if ((player.getX() - tile2_11.getX() - tile2_11.getWidth() / 4) * (player.getX() - tile2_11.getX() - tile2_11.getWidth() / 4) < tile2_11.getWidth() / 3 * tile2_11.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_11_3.position_y - tile2_18.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile2_18.getY() - tile2_18.getHeight() / 4) * (player.getY() - tile2_18.getY() - tile2_18.getHeight() / 4) < tile2_18.getHeight() / 3 * tile2_18.getHeight() / 2) {
                if ((player.getX() - tile2_18.getX() - tile2_18.getWidth() / 4) * (player.getX() - tile2_18.getX() - tile2_18.getWidth() / 4) < tile2_18.getWidth() / 3 * tile2_18.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_11_4.position_y - tile2_25.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile2_25.getY() - tile2_25.getHeight() / 4) * (player.getY() - tile2_25.getY() - tile2_25.getHeight() / 4) < tile2_25.getHeight() / 3 * tile2_25.getHeight() / 2) {
                if ((player.getX() - tile2_25.getX() - tile2_25.getWidth() / 4) * (player.getX() - tile2_25.getX() - tile2_25.getWidth() / 4) < tile2_25.getWidth() / 3 * tile2_25.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_11_5.position_y - tile2_30.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile2_30.getY() - tile2_30.getHeight() / 4) * (player.getY() - tile2_30.getY() - tile2_30.getHeight() / 4) < tile2_30.getHeight() / 3 * tile2_30.getHeight() / 2) {
                if ((player.getX() - tile2_30.getX() - tile2_30.getWidth() / 4) * (player.getX() - tile2_30.getX() - tile2_30.getWidth() / 4) < tile2_30.getWidth() / 3 * tile2_30.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_12_1.position_y - tile1_9.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile1_9.getY() - tile1_9.getHeight() / 4) * (player.getY() - tile1_9.getY() - tile1_9.getHeight() / 4) < tile1_9.getHeight() / 3 * tile1_9.getHeight() / 2) {
                if ((player.getX() - tile1_9.getX() - tile1_9.getWidth() / 4) * (player.getX() - tile1_9.getX() - tile1_9.getWidth() / 4) < tile1_9.getWidth() / 3 * tile1_9.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_12_2.position_y - tile1_15.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile1_15.getY() - tile1_15.getHeight() / 4) * (player.getY() - tile1_15.getY() - tile1_15.getHeight() / 4) < tile1_15.getHeight() / 3 * tile1_15.getHeight() / 2) {
                if ((player.getX() - tile1_15.getX() - tile1_15.getWidth() / 4) * (player.getX() - tile1_15.getX() - tile1_15.getWidth() / 4) < tile1_15.getWidth() / 3 * tile1_15.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_12_3.position_y - tile1_22.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile1_22.getY() - tile1_22.getHeight() / 4) * (player.getY() - tile1_22.getY() - tile1_22.getHeight() / 4) < tile1_22.getHeight() / 3 * tile1_22.getHeight() / 2) {
                if ((player.getX() - tile1_22.getX() - tile1_22.getWidth() / 4) * (player.getX() - tile1_22.getX() - tile1_22.getWidth() / 4) < tile1_22.getWidth() / 3 * tile1_22.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_12_4.position_y - tile1_28.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile1_28.getY() - tile1_28.getHeight() / 4) * (player.getY() - tile1_28.getY() - tile1_28.getHeight() / 4) < tile1_28.getHeight() / 3 * tile1_28.getHeight() / 2) {
                if ((player.getX() - tile1_28.getX() - tile1_28.getWidth() / 4) * (player.getX() - tile1_28.getX() - tile1_28.getWidth() / 4) < tile1_28.getWidth() / 3 * tile1_28.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_13_1.position_y - tile2_12.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile2_12.getY() - tile2_12.getHeight() / 4) * (player.getY() - tile2_12.getY() - tile2_12.getHeight() / 4) < tile2_12.getHeight() / 3 * tile2_12.getHeight() / 2) {
                if ((player.getX() - tile2_12.getX() - tile2_12.getWidth() / 4) * (player.getX() - tile2_12.getX() - tile2_12.getWidth() / 4) < tile2_12.getWidth() / 3 * tile2_12.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_13_2.position_y - tile2_19.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile2_19.getY() - tile2_19.getHeight() / 4) * (player.getY() - tile2_19.getY() - tile2_19.getHeight() / 4) < tile2_19.getHeight() / 3 * tile2_19.getHeight() / 2) {
                if ((player.getX() - tile2_19.getX() - tile2_19.getWidth() / 4) * (player.getX() - tile2_19.getX() - tile2_19.getWidth() / 4) < tile2_19.getWidth() / 3 * tile2_19.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_13_3.position_y - tile2_26.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile2_26.getY() - tile2_26.getHeight() / 4) * (player.getY() - tile2_26.getY() - tile2_26.getHeight() / 4) < tile2_26.getHeight() / 3 * tile2_26.getHeight() / 2) {
                if ((player.getX() - tile2_26.getX() - tile2_26.getWidth() / 4) * (player.getX() - tile2_26.getX() - tile2_26.getWidth() / 4) < tile2_26.getWidth() / 3 * tile2_26.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_14_1.position_y - tile1_16.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile1_16.getY() - tile1_16.getHeight() / 4) * (player.getY() - tile1_16.getY() - tile1_16.getHeight() / 4) < tile1_16.getHeight() / 3 * tile1_16.getHeight() / 2) {
                if ((player.getX() - tile1_16.getX() - tile1_16.getWidth() / 4) * (player.getX() - tile1_16.getX() - tile1_16.getWidth() / 4) < tile1_16.getWidth() / 3 * tile1_16.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_14_2.position_y - tile1_23.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile1_23.getY() - tile1_23.getHeight() / 4) * (player.getY() - tile1_23.getY() - tile1_23.getHeight() / 4) < tile1_23.getHeight() / 3 * tile1_23.getHeight() / 2) {
                if ((player.getX() - tile1_23.getX() - tile1_23.getWidth() / 4) * (player.getX() - tile1_23.getX() - tile1_23.getWidth() / 4) < tile1_23.getWidth() / 3 * tile1_23.getWidth() / 2) {
                    return true;
                }
            }
        }

        if (Math.abs(obs2_15_1.position_y - tile2_20.getY()) <= 10 * size_dm) {
            if ((player.getY() - tile2_20.getY() - tile2_20.getHeight() / 4) * (player.getY() - tile2_20.getY() - tile2_20.getHeight() / 4) < tile2_20.getHeight() / 3 * tile2_20.getHeight() / 2) {
                if ((player.getX() - tile2_20.getX() - tile2_20.getWidth() / 4) * (player.getX() - tile2_20.getX() - tile2_20.getWidth() / 4) < tile2_20.getWidth() / 3 * tile2_20.getWidth() / 2) {
                    return true;
                }
            }
        }


        return false;
    }

    @Override
    protected void onDestroy() {
        Drawable t = tile1_1.getDrawable();
        Drawable t1 = tile1_2.getDrawable();
        Drawable t2 = tile1_3.getDrawable();
        Drawable t3 = tile1_4.getDrawable();
        Drawable t4 = tile1_5.getDrawable();
        Drawable t5 = tile1_6.getDrawable();
        Drawable t6 = tile1_7.getDrawable();
        Drawable t7 = tile1_8.getDrawable();
        Drawable t8 = tile1_9.getDrawable();
        Drawable t9 = tile1_10.getDrawable();
        Drawable t10 = tile1_11.getDrawable();
        Drawable t11 = tile1_12.getDrawable();
        Drawable t12 = tile1_13.getDrawable();
        Drawable t13 = tile1_14.getDrawable();
        Drawable t14 = tile1_15.getDrawable();
        Drawable t15 = tile1_16.getDrawable();
        Drawable t16 = tile1_17.getDrawable();
        Drawable t17 = tile1_18.getDrawable();
        Drawable t18 = tile1_19.getDrawable();
        Drawable t19 = tile1_20.getDrawable();
        Drawable t20 = tile1_21.getDrawable();
        Drawable t21 = tile1_22.getDrawable();
        Drawable t22 = tile1_23.getDrawable();
        Drawable t23 = tile1_24.getDrawable();
        Drawable t24 = tile1_25.getDrawable();
        Drawable t25 = tile1_26.getDrawable();
        Drawable t26 = tile1_27.getDrawable();
        Drawable t27 = tile1_28.getDrawable();
        Drawable t28 = tile1_29.getDrawable();
        Drawable t29 = tile1_30.getDrawable();
        Drawable t30 = tile1_31.getDrawable();
        Drawable t31 = tile1_32.getDrawable();

        Drawable t_1 = tile2_1.getDrawable();
        Drawable t_2 = tile2_2.getDrawable();
        Drawable t_3 = tile2_3.getDrawable();
        Drawable t_4 = tile2_4.getDrawable();
        Drawable t_5 = tile2_5.getDrawable();
        Drawable t_6 = tile2_6.getDrawable();
        Drawable t_7 = tile2_7.getDrawable();
        Drawable t_8 = tile2_8.getDrawable();
        Drawable t_9 = tile2_9.getDrawable();
        Drawable t_10 = tile2_10.getDrawable();
        Drawable t_11 = tile2_11.getDrawable();
        Drawable t_12 = tile2_12.getDrawable();
        Drawable t_13 = tile2_13.getDrawable();
        Drawable t_14 = tile2_14.getDrawable();
        Drawable t_15 = tile2_15.getDrawable();
        Drawable t_16 = tile2_16.getDrawable();
        Drawable t_17 = tile2_17.getDrawable();
        Drawable t_18 = tile2_18.getDrawable();
        Drawable t_19 = tile2_19.getDrawable();
        Drawable t_20 = tile2_20.getDrawable();
        Drawable t_21 = tile2_21.getDrawable();
        Drawable t_22 = tile2_22.getDrawable();
        Drawable t_23 = tile2_23.getDrawable();
        Drawable t_24 = tile2_24.getDrawable();
        Drawable t_25 = tile2_25.getDrawable();
        Drawable t_26 = tile2_26.getDrawable();
        Drawable t_27 = tile2_27.getDrawable();
        Drawable t_28 = tile2_28.getDrawable();
        Drawable t_29 = tile2_29.getDrawable();
        Drawable t_30 = tile2_30.getDrawable();
        Drawable t_31 = tile2_31.getDrawable();
        Drawable t_32 = tile2_32.getDrawable();

        Drawable h1 = heart1.getDrawable();
        Drawable h2 = heart2.getDrawable();
        Drawable h3 = heart3.getDrawable();

        if (t instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t.setCallback(null);

        if (t1 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t1).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t1.setCallback(null);

        if (t2 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t2).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t2.setCallback(null);

        if (t3 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t3).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t3.setCallback(null);

        if (t4 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t4).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t4.setCallback(null);

        if (t5 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t5).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t5.setCallback(null);

        if (t6 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t6).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t6.setCallback(null);

        if (t7 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t7).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t7.setCallback(null);

        if (t8 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t8).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t8.setCallback(null);

        if (t9 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t9).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t9.setCallback(null);

        if (t10 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t10).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t10.setCallback(null);

        if (t11 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t11).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t11.setCallback(null);

        if (t12 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t12).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t12.setCallback(null);

        if (t13 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t13).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t13.setCallback(null);

        if (t14 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t14).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t14.setCallback(null);

        if (t15 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t15).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t15.setCallback(null);

        if (t16 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t16).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t16.setCallback(null);

        if (t17 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t17).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t17.setCallback(null);

        if (t18 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t18).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t18.setCallback(null);

        if (t19 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t19).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t19.setCallback(null);

        if (t20 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t20).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t20.setCallback(null);

        if (t21 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t21).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t21.setCallback(null);

        if (t22 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t22).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t22.setCallback(null);

        if (t23 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t23).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t23.setCallback(null);

        if (t24 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t24).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t24.setCallback(null);

        if (t25 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t25).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t25.setCallback(null);

        if (t26 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t26).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t26.setCallback(null);

        if (t27 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t27).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t27.setCallback(null);

        if (t28 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t28).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t28.setCallback(null);

        if (t29 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t29).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t29.setCallback(null);

        if (t30 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t30).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t30.setCallback(null);

        if (t31 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t31).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t31.setCallback(null);

        if (t_1 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t_1).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_1.setCallback(null);

        if (t_2 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t_2).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_2.setCallback(null);

        if (t_3 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t_3).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_3.setCallback(null);

        if (t_4 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t_4).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_4.setCallback(null);

        if (t_5 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t_5).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_5.setCallback(null);

        if (t_6 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t_6).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_6.setCallback(null);

        if (t_7 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t_7).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_7.setCallback(null);

        if (t_8 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t_8).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_8.setCallback(null);

        if (t_9 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t_9).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_9.setCallback(null);

        if (t_10 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t_10).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_10.setCallback(null);

        if (t_11 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t_11).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_11.setCallback(null);

        if (t_12 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t_12).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_12.setCallback(null);

        if (t_13 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t_13).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_13.setCallback(null);

        if (t_13 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t_13).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_13.setCallback(null);

        if (t_14 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t_14).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_14.setCallback(null);

        if (t_15 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t_15).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_15.setCallback(null);

        if (t_16 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t_16).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_16.setCallback(null);

        if (t_17 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t_17).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t17.setCallback(null);

        if (t_18 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t_18).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_18.setCallback(null);

        if (t_19 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t_19).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_19.setCallback(null);

        if (t_20 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t_20).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_20.setCallback(null);

        if (t_21 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t_21).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_21.setCallback(null);

        if (t_22 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t_22).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_22.setCallback(null);

        if (t_23 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t_23).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_23.setCallback(null);

        if (t_24 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t_24).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_24.setCallback(null);

        if (t_25 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t_25).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_25.setCallback(null);

        if (t_26 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t_26).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_26.setCallback(null);

        if (t_27 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t_27).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_27.setCallback(null);
        if (t_28 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t_28).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_28.setCallback(null);
        if (t_29 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t_29).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_29.setCallback(null);
        if (t_30 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t_30).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_30.setCallback(null);

        if (t_31 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t_31).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_31.setCallback(null);

        if (t_32 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t_32).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_32.setCallback(null);

        if (h1 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) h1).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        h1.setCallback(null);

        if (h2 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) h2).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        h2.setCallback(null);

        if (h3 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) h3).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        h3.setCallback(null);

        obs2_1.empty();
        obs2_2_1.empty();
        obs2_2_2.empty();
        obs2_3_1.empty();
        obs2_3_2.empty();
        obs2_3_3.empty();
        obs2_4_1.empty();
        obs2_4_2.empty();
        obs2_4_3.empty();
        obs2_4_4.empty();
        obs2_5_1.empty();
        obs2_5_2.empty();
        obs2_5_3.empty();
        obs2_5_4.empty();
        obs2_5_5.empty();
        obs2_6_1.empty();
        obs2_6_2.empty();
        obs2_6_3.empty();
        obs2_6_4.empty();
        obs2_6_5.empty();
        obs2_6_6.empty();
        obs2_7_1.empty();
        obs2_7_2.empty();
        obs2_7_3.empty();
        obs2_7_4.empty();
        obs2_7_5.empty();
        obs2_7_6.empty();
        obs2_7_7.empty();
        obs2_8_1.empty();
        obs2_8_2.empty();
        obs2_8_3.empty();
        obs2_8_4.empty();
        obs2_8_5.empty();
        obs2_8_6.empty();
        obs2_8_7.empty();
        obs2_8_8.empty();
        obs2_9_1.empty();
        obs2_9_2.empty();
        obs2_9_3.empty();
        obs2_9_4.empty();
        obs2_9_5.empty();
        obs2_9_6.empty();
        obs2_9_7.empty();
        obs2_10_1.empty();
        obs2_10_2.empty();
        obs2_10_3.empty();
        obs2_10_4.empty();
        obs2_10_5.empty();
        obs2_10_6.empty();
        obs2_11_1.empty();
        obs2_11_2.empty();
        obs2_11_3.empty();
        obs2_11_4.empty();
        obs2_11_5.empty();
        obs2_12_1.empty();
        obs2_12_2.empty();
        obs2_12_3.empty();
        obs2_12_4.empty();
        obs2_13_1.empty();
        obs2_13_2.empty();
        obs2_13_3.empty();
        obs2_14_1.empty();
        obs2_14_2.empty();
        obs2_15_1.empty();

        effect2_1.empty();
        effect2_2_1.empty();
        effect2_2_2.empty();
        effect2_3_1.empty();
        effect2_3_2.empty();
        effect2_3_3.empty();
        effect2_4_1.empty();
        effect2_4_2.empty();
        effect2_4_3.empty();
        effect2_4_4.empty();
        effect2_5_1.empty();
        effect2_5_2.empty();
        effect2_5_3.empty();
        effect2_5_4.empty();
        effect2_5_5.empty();
        effect2_6_1.empty();
        effect2_6_2.empty();
        effect2_6_3.empty();
        effect2_6_4.empty();
        effect2_6_5.empty();
        effect2_6_6.empty();
        effect2_7_1.empty();
        effect2_7_2.empty();
        effect2_7_3.empty();
        effect2_7_4.empty();
        effect2_7_5.empty();
        effect2_7_6.empty();
        effect2_7_7.empty();
        effect2_8_1.empty();
        effect2_8_2.empty();
        effect2_8_3.empty();
        effect2_8_4.empty();
        effect2_8_5.empty();
        effect2_8_6.empty();
        effect2_8_7.empty();
        effect2_8_8.empty();
        effect2_9_1.empty();
        effect2_9_2.empty();
        effect2_9_3.empty();
        effect2_9_4.empty();
        effect2_9_5.empty();
        effect2_9_6.empty();
        effect2_9_7.empty();
        effect2_10_1.empty();
        effect2_10_2.empty();
        effect2_10_3.empty();
        effect2_10_4.empty();
        effect2_10_5.empty();
        effect2_10_6.empty();
        effect2_11_1.empty();
        effect2_11_2.empty();
        effect2_11_3.empty();
        effect2_11_4.empty();
        effect2_11_5.empty();
        effect2_12_1.empty();
        effect2_12_2.empty();
        effect2_12_3.empty();
        effect2_12_4.empty();
        effect2_13_1.empty();
        effect2_13_2.empty();
        effect2_13_3.empty();
        effect2_14_1.empty();
        effect2_14_2.empty();
        effect2_15_1.empty();

        js.empty();

        super.onDestroy();

    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {

        if (event.getAction() == KeyEvent.ACTION_DOWN) {

            switch (event.getKeyCode()) {

                case KeyEvent.KEYCODE_BACK:
                    return true;

            }

        }

        return super.dispatchKeyEvent(event);

    }


}
