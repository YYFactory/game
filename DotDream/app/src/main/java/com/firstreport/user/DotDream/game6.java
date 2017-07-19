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
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by user on 2017-07-07.
 */

public class game6 extends AppCompatActivity{

    private int tile_end_x1, tile_end_y1;
    private int tile_end_x2, tile_end_y2;
    private int tile_end_x3, tile_end_y3;
    private int tile_end_x4, tile_end_y4;
    private int prior_player_x, prior_player_y;
    private int timing_number = 0, total_time_number = 2, health_timing_number = 0, level_time_number=0;
    private int pattern_number=0, health_number = 0;
    private int size_dm;

    private int SpeedX, SpeedY;
    private int obstacle_SpeedX, obstacle_SpeedY;
    private int obstacle_2_SpeedX, obstacle_2_SpeedY;
    private int obstacle_3_SpeedX, obstacle_3_SpeedY;
    private int enemy_SpeedX, enemy_SpeedY;
    private int enemy2_SpeedX, enemy2_SpeedY;
    private int bullet1_SpeedX, bullet1_SpeedY;
    private int bullet2_SpeedX, bullet2_SpeedY;
    private int bullet3_SpeedX, bullet3_SpeedY;
    private int bullet4_SpeedX, bullet4_SpeedY;
    private int bullet5_SpeedX, bullet5_SpeedY;
    private int bullet1_initialX, bullet1_initialY;
    private int bullet2_initialX, bullet2_initialY;
    private int bullet3_initialX, bullet3_initialY;
    private int bullet4_initialX, bullet4_initialY;
    private int bullet5_initialX, bullet5_initialY;

    private int enemy_bullet1_SpeedX, enemy_bullet1_SpeedY, enemy_bullet2_SpeedX, enemy_bullet2_SpeedY, enemy_bullet3_SpeedX, enemy_bullet3_SpeedY,
            enemy_bullet4_SpeedX, enemy_bullet4_SpeedY, enemy_bullet5_SpeedX, enemy_bullet5_SpeedY, enemy_bullet6_SpeedX, enemy_bullet6_SpeedY,
            enemy_bullet7_SpeedX, enemy_bullet7_SpeedY, enemy_bullet8_SpeedX, enemy_bullet8_SpeedY, enemy_bullet9_SpeedX, enemy_bullet9_SpeedY,
            enemy_bullet10_SpeedX, enemy_bullet10_SpeedY, enemy_bullet11_SpeedX, enemy_bullet11_SpeedY, enemy_bullet12_SpeedX, enemy_bullet12_SpeedY,
            enemy_bullet13_SpeedX, enemy_bullet13_SpeedY, enemy_bullet14_SpeedX, enemy_bullet14_SpeedY, enemy_bullet15_SpeedX, enemy_bullet15_SpeedY,
            enemy_bullet16_SpeedX, enemy_bullet16_SpeedY;


    private int screenWidth;
    private int screenHeight;
    private int frameHeight;
    private int pattern[]={0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0};
    private int bullet[] = {0, 0, 0, 0, 0};
    private int bullet_number=0, bullet_number_count=0;
    private int enemy_shot[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0};
    private int enemey_bullet_number;

    private boolean Isdamaged_player;
    private boolean stun_player = false;
    private boolean bullet_click = false;

    private Handler handler = new Handler();
    private Timer timer = new Timer();
    private ImageView player;

    private RelativeLayout layout_joystick;
    private RelativeLayout gameview6;
    private ImageView tile1_1, tile1_32;

    private ImageView tile2_13, tile2_20;

    private ImageView heart1, heart2, heart3;
    private ImageView enemy_center;

    private Button button2;

    private boolean action_flg = false;
    private boolean start_flg = false;

    private TextView score, score_number, time, time_number, life;

    ObstacleClass enemy1_1, enemy1_2, enemy1_3, enemy1_4, enemy1_5, enemy1_6, enemy1_7, enemy1_8;
    ObstacleClass enemy2_1, enemy2_2, enemy2_3, enemy2_4, enemy2_5, enemy2_6, enemy2_7, enemy2_8;
    ObstacleClass enemy1x2_1, enemy1x2_2, enemy1x2_3, enemy1x2_4, enemy1x2_5, enemy1x2_6, enemy1x2_7, enemy1x2_8;
    ObstacleClass enemy2x2_1, enemy2x2_2, enemy2x2_3, enemy2x2_4,  enemy2x2_5,  enemy2x2_6,  enemy2x2_7, enemy2x2_8;
    ObstacleClass enemy1x3_1, enemy1x3_2, enemy1x3_3, enemy1x3_4, enemy1x3_5, enemy1x3_6, enemy1x3_7, enemy1x3_8;
    ObstacleClass enemy2x3_1, enemy2x3_2, enemy2x3_3, enemy2x3_4,  enemy2x3_5,  enemy2x3_6,  enemy2x3_7, enemy2x3_8;

    ObstacleClass enemy_bullet1, enemy_bullet2, enemy_bullet3, enemy_bullet4, enemy_bullet5, enemy_bullet6, enemy_bullet7, enemy_bullet8,
            enemy_bullet9, enemy_bullet10, enemy_bullet11, enemy_bullet12, enemy_bullet13, enemy_bullet14, enemy_bullet15, enemy_bullet16;

    ObstacleClass bullet1_1, bullet1_2, bullet1_3, bullet1_4, bullet1_5;

    JoyStickClass js;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameview6);

        DisplayMetrics dm = getResources().getDisplayMetrics();
        size_dm = Math.round(dm.density);

        obstacle_SpeedX = 1;
        obstacle_SpeedY = 1;

        enemy_SpeedX = 1;
        enemy_SpeedY = 1;

        obstacle_2_SpeedX = -1;
        obstacle_2_SpeedY = 1;

        enemy2_SpeedX = -1;
        enemy2_SpeedY = 1;

        obstacle_3_SpeedX = 0;
        obstacle_3_SpeedY = 1;

        ///////////////////////////////////////////

        enemy_bullet1_SpeedX = 1;
        enemy_bullet1_SpeedY = 0;

        enemy_bullet2_SpeedX = 2;
        enemy_bullet2_SpeedY = -1;

        enemy_bullet3_SpeedX = 1;
        enemy_bullet3_SpeedY = -1;

        enemy_bullet4_SpeedX = 1;
        enemy_bullet4_SpeedY = -2;

        enemy_bullet5_SpeedX = 0;
        enemy_bullet5_SpeedY = -1;

        enemy_bullet6_SpeedX = -1;
        enemy_bullet6_SpeedY = -2;

        enemy_bullet7_SpeedX = -1;
        enemy_bullet7_SpeedY = -1;

        enemy_bullet8_SpeedX = -2;
        enemy_bullet8_SpeedY = -1;

        enemy_bullet9_SpeedX = -1;
        enemy_bullet9_SpeedY = 0;

        enemy_bullet10_SpeedX = -2;
        enemy_bullet10_SpeedY = 1;

        enemy_bullet11_SpeedX = -1;
        enemy_bullet11_SpeedY = 1;

        enemy_bullet12_SpeedX = -1;
        enemy_bullet12_SpeedY = 2;

        enemy_bullet13_SpeedX = 0;
        enemy_bullet13_SpeedY = 1;

        enemy_bullet14_SpeedX = 1;
        enemy_bullet14_SpeedY = 2;

        enemy_bullet15_SpeedX = 1;
        enemy_bullet15_SpeedY = 1;

        enemy_bullet16_SpeedX = 2;
        enemy_bullet16_SpeedY = 1;

        //textView1 = (TextView) findViewById(R.id.textView1);
        //textView2 = (TextView) findViewById(R.id.textView2);
        //textView3 = (TextView) findViewById(R.id.textView3);
        //textView4 = (TextView) findViewById(R.id.textView4);
        //textView5 = (TextView) findViewById(R.id.textView5);

        score_number = (TextView) findViewById(R.id.score_number);
        time_number = (TextView) findViewById(R.id.time_number);

        WindowManager wm = getWindowManager();
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);

        screenWidth = size.x;
        screenHeight = size.y;

        layout_joystick = (RelativeLayout) findViewById(R.id.layout_joystick);
        gameview6 = (RelativeLayout) findViewById(R.id.gameview6);

        js = new JoyStickClass(getApplicationContext(), layout_joystick, R.drawable.center);
        js.setStickSize(30*size_dm, 30*size_dm);
        js.setLayoutSize(100*size_dm, 100*size_dm);
        js.setLayoutAlpha(50);
        js.setStickAlpha(50);
        js.setOffset(15*size_dm);
        js.setMinimumDistance(1*size_dm);

        js.initial_draw(50*size_dm, 50*size_dm);
        button2 = (Button)findViewById(R.id.button2);

        enemy_center = (ImageView) findViewById(R.id.enemy_center);

        enemy_bullet1 =  new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy_bullet1.position(161*size_dm, 247*size_dm);
        enemy_bullet1.resized_image(30*size_dm, 30*size_dm);
        enemy_bullet1.setObstacleAlpha(0);

        enemy_bullet2 =  new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy_bullet2.position(161*size_dm, 247*size_dm);
        enemy_bullet2.resized_image(30*size_dm, 30*size_dm);
        enemy_bullet2.setObstacleAlpha(0);

        enemy_bullet3 =  new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy_bullet3.position(161*size_dm, 247*size_dm);
        enemy_bullet3.resized_image(30*size_dm, 30*size_dm);
        enemy_bullet3.setObstacleAlpha(0);

        enemy_bullet4 =  new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy_bullet4.position(161*size_dm, 247*size_dm);
        enemy_bullet4.resized_image(30*size_dm, 30*size_dm);
        enemy_bullet4.setObstacleAlpha(0);

        enemy_bullet5 =  new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy_bullet5.position(161*size_dm, 247*size_dm);
        enemy_bullet5.resized_image(30*size_dm, 30*size_dm);
        enemy_bullet5.setObstacleAlpha(0);

        enemy_bullet6 =  new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy_bullet6.position(161*size_dm, 247*size_dm);
        enemy_bullet6.resized_image(30*size_dm, 30*size_dm);
        enemy_bullet6.setObstacleAlpha(0);

        enemy_bullet7 =  new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy_bullet7.position(161*size_dm, 247*size_dm);
        enemy_bullet7.resized_image(30*size_dm, 30*size_dm);
        enemy_bullet7.setObstacleAlpha(0);

        enemy_bullet8 =  new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy_bullet8.position(161*size_dm, 247*size_dm);
        enemy_bullet8.resized_image(30*size_dm, 30*size_dm);
        enemy_bullet8.setObstacleAlpha(0);

        enemy_bullet9 =  new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy_bullet9.position(161*size_dm, 247*size_dm);
        enemy_bullet9.resized_image(30*size_dm, 30*size_dm);
        enemy_bullet9.setObstacleAlpha(0);

        enemy_bullet10 =  new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy_bullet10.position(161*size_dm, 247*size_dm);
        enemy_bullet10.resized_image(30*size_dm, 30*size_dm);
        enemy_bullet10.setObstacleAlpha(0);

        enemy_bullet11 =  new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy_bullet11.position(161*size_dm, 247*size_dm);
        enemy_bullet11.resized_image(30*size_dm, 30*size_dm);
        enemy_bullet11.setObstacleAlpha(0);

        enemy_bullet12 =  new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy_bullet12.position(161*size_dm, 247*size_dm);
        enemy_bullet12.resized_image(30*size_dm, 30*size_dm);
        enemy_bullet12.setObstacleAlpha(0);

        enemy_bullet13 =  new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy_bullet13.position(161*size_dm, 247*size_dm);
        enemy_bullet13.resized_image(30*size_dm, 30*size_dm);
        enemy_bullet13.setObstacleAlpha(0);

        enemy_bullet14 =  new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy_bullet14.position(161*size_dm, 247*size_dm);
        enemy_bullet14.resized_image(30*size_dm, 30*size_dm);
        enemy_bullet14.setObstacleAlpha(0);

        enemy_bullet15 =  new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy_bullet15.position(161*size_dm, 247*size_dm);
        enemy_bullet15.resized_image(30*size_dm, 30*size_dm);
        enemy_bullet15.setObstacleAlpha(0);

        enemy_bullet16 =  new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy_bullet16.position(161*size_dm, 247*size_dm);
        enemy_bullet16.resized_image(30*size_dm, 30*size_dm);
        enemy_bullet16.setObstacleAlpha(0);

        //////////////////////////////////////////////////////////////////////////////////////////////////////


        ///////////////////////////////////////////////////////////////////////////////////////////////////

        enemy1_1 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy1_1.position(120*size_dm, 125*size_dm);
        enemy1_1.resized_image(30*size_dm, 30*size_dm);
        enemy1_1.setObstacleAlpha(200);

        enemy1_2 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy1_2.position(107*size_dm, 138*size_dm);
        enemy1_2.resized_image(30*size_dm, 30*size_dm);
        enemy1_2.setObstacleAlpha(200);

        enemy1_3 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy1_3.position(94*size_dm, 151*size_dm);
        enemy1_3.resized_image(30*size_dm, 30*size_dm);
        enemy1_3.setObstacleAlpha(200);

        enemy1_4 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy1_4.position(81*size_dm, 164*size_dm);
        enemy1_4.resized_image(30*size_dm, 30*size_dm);
        enemy1_4.setObstacleAlpha(200);

        enemy1_5 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy1_5.position(68*size_dm, 177*size_dm);
        enemy1_5.resized_image(30*size_dm, 30*size_dm);
        enemy1_5.setObstacleAlpha(200);

        enemy1_6 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy1_6.position(55*size_dm, 190*size_dm);
        enemy1_6.resized_image(30*size_dm, 30*size_dm);
        enemy1_6.setObstacleAlpha(200);

        enemy1_7 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy1_7.position(42*size_dm, 203*size_dm);
        enemy1_7.resized_image(30*size_dm, 30*size_dm);
        enemy1_7.setObstacleAlpha(200);

        enemy1_8 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy1_8.position(29*size_dm, 216*size_dm);
        enemy1_8.resized_image(30*size_dm, 30*size_dm);
        enemy1_8.setObstacleAlpha(200);

        enemy1x2_1 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy1x2_1.position(120*size_dm, 125*size_dm);
        enemy1x2_1.resized_image(30*size_dm, 30*size_dm);
        enemy1x2_1.setObstacleAlpha(200);

        enemy1x2_2 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy1x2_2.position(107*size_dm, 138*size_dm);
        enemy1x2_2.resized_image(30*size_dm, 30*size_dm);
        enemy1x2_2.setObstacleAlpha(200);

        enemy1x2_3 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy1x2_3.position(94*size_dm, 151*size_dm);
        enemy1x2_3.resized_image(30*size_dm, 30*size_dm);
        enemy1x2_3.setObstacleAlpha(200);

        enemy1x2_4 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy1x2_4.position(81*size_dm, 164*size_dm);
        enemy1x2_4.resized_image(30*size_dm, 30*size_dm);
        enemy1x2_4.setObstacleAlpha(200);

        enemy1x2_5 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy1x2_5.position(68*size_dm, 177*size_dm);
        enemy1x2_5.resized_image(30*size_dm, 30*size_dm);
        enemy1x2_5.setObstacleAlpha(200);

        enemy1x2_6 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy1x2_6.position(55*size_dm, 190*size_dm);
        enemy1x2_6.resized_image(30*size_dm, 30*size_dm);
        enemy1x2_6.setObstacleAlpha(200);

        enemy1x2_7 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy1x2_7.position(42*size_dm, 203*size_dm);
        enemy1x2_7.resized_image(30*size_dm, 30*size_dm);
        enemy1x2_7.setObstacleAlpha(200);

        enemy1x2_8 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy1x2_8.position(29*size_dm, 216*size_dm);
        enemy1x2_8.resized_image(30*size_dm, 30*size_dm);
        enemy1x2_8.setObstacleAlpha(200);

        enemy1x3_1 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy1x3_1.position(120*size_dm, 125*size_dm);
        enemy1x3_1.resized_image(30*size_dm, 30*size_dm);
        enemy1x3_1.setObstacleAlpha(200);

        enemy1x3_2 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy1x3_2.position(107*size_dm, 138*size_dm);
        enemy1x3_2.resized_image(30*size_dm, 30*size_dm);
        enemy1x3_2.setObstacleAlpha(200);

        enemy1x3_3 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy1x3_3.position(94*size_dm, 151*size_dm);
        enemy1x3_3.resized_image(30*size_dm, 30*size_dm);
        enemy1x3_3.setObstacleAlpha(200);

        enemy1x3_4 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy1x3_4.position(81*size_dm, 164*size_dm);
        enemy1x3_4.resized_image(30*size_dm, 30*size_dm);
        enemy1x3_4.setObstacleAlpha(200);

        enemy1x3_5 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy1x3_5.position(68*size_dm, 177*size_dm);
        enemy1x3_5.resized_image(30*size_dm, 30*size_dm);
        enemy1x3_5.setObstacleAlpha(200);

        enemy1x3_6 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy1x3_6.position(55*size_dm, 190*size_dm);
        enemy1x3_6.resized_image(30*size_dm, 30*size_dm);
        enemy1x3_6.setObstacleAlpha(200);

        enemy1x3_7 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy1x3_7.position(42*size_dm, 203*size_dm);
        enemy1x3_7.resized_image(30*size_dm, 30*size_dm);
        enemy1x3_7.setObstacleAlpha(200);

        enemy1x3_8 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy1x3_8.position(29*size_dm, 216*size_dm);
        enemy1x3_8.resized_image(30*size_dm, 30*size_dm);
        enemy1x3_8.setObstacleAlpha(200);
///////////////////////////////////////////////////////////////////////////////////////////////////////////
        enemy2_1 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy2_1.position(189*size_dm, 125*size_dm);
        enemy2_1.resized_image(30*size_dm, 30*size_dm);
        enemy2_1.setObstacleAlpha(200);

        enemy2_2 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy2_2.position(202*size_dm, 138*size_dm);
        enemy2_2.resized_image(30*size_dm, 30*size_dm);
        enemy2_2.setObstacleAlpha(200);

        enemy2_3 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy2_3.position(215*size_dm, 151*size_dm);
        enemy2_3.resized_image(30*size_dm, 30*size_dm);
        enemy2_3.setObstacleAlpha(200);

        enemy2_4 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy2_4.position(228*size_dm, 164*size_dm);
        enemy2_4.resized_image(30*size_dm, 30*size_dm);
        enemy2_4.setObstacleAlpha(200);

        enemy2_5 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy2_5.position(241*size_dm, 177*size_dm);
        enemy2_5.resized_image(30*size_dm, 30*size_dm);
        enemy2_5.setObstacleAlpha(200);

        enemy2_6 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy2_6.position(254*size_dm, 190*size_dm);
        enemy2_6.resized_image(30*size_dm, 30*size_dm);
        enemy2_6.setObstacleAlpha(200);

        enemy2_7 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy2_7.position(267*size_dm, 203*size_dm);
        enemy2_7.resized_image(30*size_dm, 30*size_dm);
        enemy2_7.setObstacleAlpha(200);

        enemy2_8 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy2_8.position(280*size_dm, 216*size_dm);
        enemy2_8.resized_image(30*size_dm, 30*size_dm);
        enemy2_8.setObstacleAlpha(200);

        enemy2x2_1 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy2x2_1.position(189*size_dm, 125*size_dm);
        enemy2x2_1.resized_image(30*size_dm, 30*size_dm);
        enemy2x2_1.setObstacleAlpha(200);

        enemy2x2_2 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy2x2_2.position(202*size_dm, 138*size_dm);
        enemy2x2_2.resized_image(30*size_dm, 30*size_dm);
        enemy2x2_2.setObstacleAlpha(200);

        enemy2x2_3 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy2x2_3.position(215*size_dm, 151*size_dm);
        enemy2x2_3.resized_image(30*size_dm, 30*size_dm);
        enemy2x2_3.setObstacleAlpha(200);

        enemy2x2_4 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy2x2_4.position(228*size_dm, 164*size_dm);
        enemy2x2_4.resized_image(30*size_dm, 30*size_dm);
        enemy2x2_4.setObstacleAlpha(200);

        enemy2x2_5 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy2x2_5.position(241*size_dm, 177*size_dm);
        enemy2x2_5.resized_image(30*size_dm, 30*size_dm);
        enemy2x2_5.setObstacleAlpha(200);

        enemy2x2_6 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy2x2_6.position(254*size_dm, 190*size_dm);
        enemy2x2_6.resized_image(30*size_dm, 30*size_dm);
        enemy2x2_6.setObstacleAlpha(200);

        enemy2x2_7 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy2x2_7.position(267*size_dm, 203*size_dm);
        enemy2x2_7.resized_image(30*size_dm, 30*size_dm);
        enemy2x2_7.setObstacleAlpha(200);

        enemy2x2_8 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy2x2_8.position(280*size_dm, 216*size_dm);
        enemy2x2_8.resized_image(30*size_dm, 30*size_dm);
        enemy2x2_8.setObstacleAlpha(200);

        enemy2x3_1 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy2x3_1.position(189*size_dm, 125*size_dm);
        enemy2x3_1.resized_image(30*size_dm, 30*size_dm);
        enemy2x3_1.setObstacleAlpha(200);

        enemy2x3_2 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy2x3_2.position(202*size_dm, 138*size_dm);
        enemy2x3_2.resized_image(30*size_dm, 30*size_dm);
        enemy2x3_2.setObstacleAlpha(200);

        enemy2x3_3 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy2x3_3.position(215*size_dm, 151*size_dm);
        enemy2x3_3.resized_image(30*size_dm, 30*size_dm);
        enemy2x3_3.setObstacleAlpha(200);

        enemy2x3_4 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy2x3_4.position(228*size_dm, 164*size_dm);
        enemy2x3_4.resized_image(30*size_dm, 30*size_dm);
        enemy2x3_4.setObstacleAlpha(200);

        enemy2x3_5 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy2x3_5.position(241*size_dm, 177*size_dm);
        enemy2x3_5.resized_image(30*size_dm, 30*size_dm);
        enemy2x3_5.setObstacleAlpha(200);

        enemy2x3_6 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy2x3_6.position(254*size_dm, 190*size_dm);
        enemy2x3_6.resized_image(30*size_dm, 30*size_dm);
        enemy2x3_6.setObstacleAlpha(200);

        enemy2x3_7 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy2x3_7.position(267*size_dm, 203*size_dm);
        enemy2x3_7.resized_image(30*size_dm, 30*size_dm);
        enemy2x3_7.setObstacleAlpha(200);

        enemy2x3_8 = new ObstacleClass(getApplicationContext(), gameview6, R.drawable.enemy3);
        enemy2x3_8.position(280*size_dm, 216*size_dm);
        enemy2x3_8.resized_image(30*size_dm, 30*size_dm);
        enemy2x3_8.setObstacleAlpha(200);

        bullet1_1 =  new ObstacleClass(getApplicationContext(), gameview6, R.drawable.bullet);
        bullet1_1.position(1*size_dm, 1*size_dm);
        bullet1_1.resized_image(30*size_dm, 30*size_dm);
        bullet1_1.setObstacleAlpha(200);

        bullet1_2 =  new ObstacleClass(getApplicationContext(), gameview6, R.drawable.bullet);
        bullet1_2.position(1*size_dm, 1*size_dm);
        bullet1_2.resized_image(30*size_dm, 30*size_dm);
        bullet1_2.setObstacleAlpha(200);

        bullet1_3 =  new ObstacleClass(getApplicationContext(), gameview6, R.drawable.bullet);
        bullet1_3.position(1*size_dm, 1*size_dm);
        bullet1_3.resized_image(30*size_dm, 30*size_dm);
        bullet1_3.setObstacleAlpha(200);

        bullet1_4 =  new ObstacleClass(getApplicationContext(), gameview6, R.drawable.bullet);
        bullet1_4.position(1*size_dm, 1*size_dm);
        bullet1_4.resized_image(30*size_dm, 30*size_dm);
        bullet1_4.setObstacleAlpha(200);

        bullet1_5 =  new ObstacleClass(getApplicationContext(), gameview6, R.drawable.bullet);
        bullet1_5.position(1*size_dm, 1*size_dm);
        bullet1_5.resized_image(30*size_dm, 30*size_dm);
        bullet1_5.setObstacleAlpha(200);

        tile1_1 = (ImageView) findViewById(R.id.tile1_1);

        tile1_32 = (ImageView) findViewById(R.id.tile1_32);


        tile2_13 = (ImageView) findViewById(R.id.tile2_13);

        tile2_20 = (ImageView) findViewById(R.id.tile2_20);


        heart1 = (ImageView) findViewById(R.id.heart1);
        heart2 = (ImageView) findViewById(R.id.heart2);
        heart3 = (ImageView) findViewById(R.id.heart3);

        player = (ImageView) findViewById(R.id.player);

        TextView game_first = null;

        game_setFont(game_first, "fonts/korra.ttf", R.id.score);
        game_setFont(game_first, "fonts/korra.ttf", R.id.time);
        game_setFont(game_first, "fonts/korra.ttf", R.id.life);
    }

    public boolean onTouchEvent(MotionEvent me)
    {
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

                                    if(total_time_number <= 0 || health_number >= 3) {

                                        if(health_number >= 3)
                                        {
                                            try {
                                                timer.cancel();
                                                timer = null;
                                                Intent intent = new Intent(getApplicationContext(),  Main7.class);
                                                startActivity(intent);
                                            } catch (Exception e) {
                                                Intent intent = new Intent(getApplicationContext(),  Main7.class);
                                                startActivity(intent);
                                            }
                                        } else {
                                            try {
                                                timer.cancel();
                                                timer = null;
                                                Intent intent = new Intent(getApplicationContext(), Main7.class);
                                                startActivity(intent);
                                            } catch (Exception e) {
                                                Intent intent = new Intent(getApplicationContext(), Main7.class);
                                                startActivity(intent);
                                            }

                                        }

                                    }
                                    else {

                                        ++timing_number;
                                        ++level_time_number;

                                        if (timing_number % 50 == 0) {
                                            if (timing_number <= 1000) {
                                                timing_set();
                                            } else {
                                                timing_number = 0;
                                            }
                                        }

                                        if (level_time_number % 100 == 0) {
                                            shot_enemy_bullet();
                                        }


                                        if (level_time_number % 50 == 0 && level_time_number <= 800) {
                                            pattern_number = getRandomMath(47, 0);
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


                                        //obstacle_moving(obstacle_SpeedX, obstacle_SpeedY, pattern_number);
                                        //obstacle_2_moving(obstacle_2_SpeedX, obstacle_2_SpeedY, pattern_number);
                                        //obstacle_3_moving(obstacle_3_SpeedX, obstacle_3_SpeedY, pattern_number);
                                        enemy_moving(enemy_SpeedX, enemy_SpeedY, pattern_number);
                                        enemy2_moving(enemy2_SpeedX, enemy2_SpeedY, pattern_number);
                                        enemy_bullet_moving();
                                        player_moving(SpeedX, SpeedY, action_flg);
                                        bullet_moving(player.getX(), player.getY(), SpeedX, SpeedY);
                                        hit_check2();

                                    }
                                }
                            });
                        }
                    }, 0, 20);

                } else {

                    if (arg1.getAction() == MotionEvent.ACTION_DOWN || arg1.getAction() == MotionEvent.ACTION_MOVE) {

                        //textView1.setText("X : " + String.valueOf(js.getX()));
                        //textView2.setText("Y : " + String.valueOf(js.getY()));
                        //textView3.setText("Angle : " + String.valueOf(js.getAngle()));
                        //textView4.setText("Distance : " + String.valueOf(js.getDistance()));

                    /*
                    timer.schedule(new TimerTask()
                    {
                        @Override
                        public void run(){

                            handler.post(new Runnable() {

                                @Override
                                public void run(){

                                    player_moving(SpeedX, SpeedY);

                                }

                            });
                        }

                    }, 0, 5000);
                    */

                        //player_moving(SpeedX, SpeedY);

                        action_flg = true;

                        // player_moving(SpeedX, SpeedY, action_flg);
                        //mHandler.removeMessages(LONG_PRESS);
                        //mHandler.sendEmptyMessageAtTime(LONG_PRESS, arg1.getDownTime() + TAP_TIMEOUT + LONGPRESS_TIMEOUT);

                    } else if (arg1.getAction() == MotionEvent.ACTION_UP) {
                        //textView1.setText("X :");
                        //textView2.setText("Y :");
                        //textView3.setText("Angle :");
                        //textView4.setText("Distance :");
                        //textView5.setText("Direction :");
                        js.initial_draw(50*size_dm, 50*size_dm);

                        action_flg = false;

                        //player_moving(SpeedX, SpeedY, action_flg);
                        //mHandler.removeMessages(LONG_PRESS);

                    } else {

                        //player_moving(SpeedX, SpeedY, action_flg);
                        //mHandler.removeMessages(LONG_PRESS);
                    }

                }

                return true;

            }
        });

        return true;
    }

    public void enemy_bullet_moving()
    {
        /*
        if(enemy_shot[0] == 1)
        {
            if (enemy_bullet1.position_x >= 380*size_dm)
            {
                enemy_bullet1.position(161*size_dm, 247*size_dm);
                enemy_bullet1.setObstacleAlpha(0);
                enemy_bullet1.position_effect();
                enemy_shot[0] = 0;
            }
            else {
                enemy_bullet1.setObstacleAlpha(200);
                enemy_bullet1.setPosition(enemy_bullet1_SpeedX, enemy_bullet1_SpeedY);
            }
        }
        */

        if(enemy_shot[1] == 1)
        {
            if (enemy_bullet2.position_x >= 390*size_dm) {
                enemy_bullet2.position(161*size_dm, 247*size_dm);
                enemy_bullet2.setObstacleAlpha(0);
                enemy_bullet2.position_effect();
                enemy_shot[1] = 0;
            }
            else {
                enemy_bullet2.setObstacleAlpha(200);
                enemy_bullet2.setPosition(enemy_bullet16_SpeedX, enemy_bullet16_SpeedY);
            }

        }

        if(enemy_shot[2] == 1)
        {
            if (enemy_bullet3.position_x >= 390*size_dm) {
                enemy_bullet3.position(161*size_dm, 247*size_dm);
                enemy_bullet3.setObstacleAlpha(0);
                enemy_bullet3.position_effect();
                enemy_shot[2] = 0;
            }
            else {
                enemy_bullet3.setObstacleAlpha(200);
                enemy_bullet3.setPosition(enemy_bullet15_SpeedX, enemy_bullet15_SpeedY);
            }
        }

        if(enemy_shot[3] == 1)
        {
            if (enemy_bullet4.position_x >= 390*size_dm) {
                enemy_bullet4.position(161*size_dm, 247*size_dm);
                enemy_bullet4.setObstacleAlpha(0);
                enemy_bullet4.position_effect();
                enemy_shot[3] = 0;
            }
            else {
                enemy_bullet4.setObstacleAlpha(200);
                enemy_bullet4.setPosition(enemy_bullet14_SpeedX, enemy_bullet14_SpeedY);
            }
        }

        if(enemy_shot[4] == 1)
        {
            if (enemy_bullet5.position_y >= 380*size_dm) {
                enemy_bullet5.position(161*size_dm, 247*size_dm);
                enemy_bullet5.setObstacleAlpha(0);
                enemy_bullet5.position_effect();
                enemy_shot[4] = 0;
            }
            else {
                enemy_bullet5.setObstacleAlpha(200);
                enemy_bullet5.setPosition(enemy_bullet13_SpeedX, enemy_bullet13_SpeedY);
            }
        }

        if(enemy_shot[5] == 1)
        {
            if (enemy_bullet6.position_x <= 10*size_dm) {
                enemy_bullet6.position(161*size_dm, 247*size_dm);
                enemy_bullet6.setObstacleAlpha(0);
                enemy_bullet6.position_effect();
                enemy_shot[5] = 0;
            }
            else {
                enemy_bullet6.setObstacleAlpha(200);
                enemy_bullet6.setPosition(enemy_bullet12_SpeedX, enemy_bullet12_SpeedY);
            }
        }

        if(enemy_shot[6] == 1)
        {
            if (enemy_bullet7.position_x <= 10*size_dm) {
                enemy_bullet7.position(161*size_dm, 247*size_dm);
                enemy_bullet7.setObstacleAlpha(0);
                enemy_bullet7.position_effect();
                enemy_shot[6] = 0;
            }
            else {
                enemy_bullet7.setObstacleAlpha(200);
                enemy_bullet7.setPosition(enemy_bullet11_SpeedX, enemy_bullet11_SpeedY);
            }
        }

        if(enemy_shot[7] == 1)
        {
            if (enemy_bullet8.position_x <= 10*size_dm) {
                enemy_bullet8.position(161*size_dm, 247*size_dm);
                enemy_bullet8.setObstacleAlpha(0);
                enemy_bullet8.position_effect();
                enemy_shot[7] = 0;
            }
            else {
                enemy_bullet8.setObstacleAlpha(200);
                enemy_bullet8.setPosition(enemy_bullet10_SpeedX, enemy_bullet10_SpeedY);
            }
        }

        if(enemy_shot[8] == 1)
        {
            if (enemy_bullet9.position_x <= 10*size_dm) {
                enemy_bullet9.position(161*size_dm, 247*size_dm);
                enemy_bullet9.setObstacleAlpha(0);
                enemy_bullet9.position_effect();
                enemy_shot[8] = 0;
            }
            else {
                enemy_bullet9.setObstacleAlpha(200);
                enemy_bullet9.setPosition(enemy_bullet9_SpeedX, enemy_bullet9_SpeedY);
            }
        }

        if(enemy_shot[9] == 1)
        {
            if (enemy_bullet10.position_x <= 10*size_dm) {
                enemy_bullet10.position(161*size_dm, 247*size_dm);
                enemy_bullet10.setObstacleAlpha(0);
                enemy_bullet10.position_effect();
                enemy_shot[9] = 0;
            }
            else {
                enemy_bullet10.setObstacleAlpha(200);
                enemy_bullet10.setPosition(enemy_bullet8_SpeedX, enemy_bullet8_SpeedY);
            }
        }

        if(enemy_shot[10] == 1)
        {
            if (enemy_bullet11.position_x <= 10*size_dm) {
                enemy_bullet11.position(161*size_dm, 247*size_dm);
                enemy_bullet11.setObstacleAlpha(0);
                enemy_bullet11.position_effect();
                enemy_shot[10] = 0;
            }
            else {
                enemy_bullet11.setObstacleAlpha(200);
                enemy_bullet11.setPosition(enemy_bullet7_SpeedX, enemy_bullet7_SpeedY);
            }
        }

        if(enemy_shot[11] == 1)
        {
            if (enemy_bullet12.position_x <= 10*size_dm) {
                enemy_bullet12.position(161*size_dm, 247*size_dm);
                enemy_bullet12.setObstacleAlpha(0);
                enemy_bullet12.position_effect();
                enemy_shot[11] = 0;
            }
            else {
                enemy_bullet12.setObstacleAlpha(200);
                enemy_bullet12.setPosition(enemy_bullet6_SpeedX, enemy_bullet6_SpeedY);
            }
        }

        if(enemy_shot[12] == 1)
        {
            if (enemy_bullet13.position_y <= 10*size_dm) {
                enemy_bullet13.position(161*size_dm, 247*size_dm);
                enemy_bullet13.setObstacleAlpha(0);
                enemy_bullet13.position_effect();
                enemy_shot[12] = 0;
            }
            else {
                enemy_bullet13.setObstacleAlpha(200);
                enemy_bullet13.setPosition(enemy_bullet5_SpeedX, enemy_bullet5_SpeedY);
            }
        }

        if(enemy_shot[13] == 1)
        {
            if (enemy_bullet14.position_x >= 380*size_dm) {
                enemy_bullet14.position(161*size_dm, 247*size_dm);
                enemy_bullet14.setObstacleAlpha(0);
                enemy_bullet14.position_effect();
                enemy_shot[13] = 0;
            }
            enemy_bullet14.setObstacleAlpha(200);
            enemy_bullet14.setPosition(enemy_bullet4_SpeedX, enemy_bullet4_SpeedY);
        }

        if(enemy_shot[14] == 1)
        {
            if (enemy_bullet15.position_x >= 390*size_dm) {
                enemy_bullet15.position(161*size_dm, 247*size_dm);
                enemy_bullet15.setObstacleAlpha(0);
                enemy_bullet15.position_effect();
                enemy_shot[14] = 0;
            }
            else {
                enemy_bullet15.setObstacleAlpha(200);
                enemy_bullet15.setPosition(enemy_bullet3_SpeedX, enemy_bullet3_SpeedY);
            }
        }

        if(enemy_shot[15] == 1)
        {
            if (enemy_bullet16.position_x >= 390*size_dm) {
                enemy_bullet16.position(161*size_dm, 247*size_dm);
                enemy_bullet16.setObstacleAlpha(0);
                enemy_bullet16.position_effect();
                enemy_shot[15] = 0;
            }
            else {
                enemy_bullet16.setObstacleAlpha(200);
                enemy_bullet16.setPosition(enemy_bullet2_SpeedX, enemy_bullet2_SpeedY);
            }
        }
    }


    public void shot_enemy_bullet()
    {
        int position_x = (int) (player.getX() - (enemy_center.getX()));
        int position_y = (int) (player.getY() - (enemy_center.getY()));
        float angle = (float) cal_angle(position_x, position_y);

        //if(angle >= 225 && angle < 315 )

        if(angle >= 353.75 || angle < 16.25 ) {
            enemy_shot[0] = 1;

        } else if(angle >= 16.25 && angle < 38.75 ) {
            enemy_shot[1] = 1;

        } else if(angle >= 38.75 && angle < 61.25 ) {
            enemy_shot[2] = 1;

         } else if(angle >= 61.25 && angle < 83.75) {

            enemy_shot[3] = 1;
        } else if(angle >= 83.75 && angle < 106.25){

            enemy_shot[4] = 1;
        }else if(angle >= 106.25 && angle < 128.75){

            enemy_shot[5] = 1;
        }else if(angle >= 128.75 && angle < 151.25){

            enemy_shot[6] = 1;
        }else if(angle >= 151.25 && angle < 173.75){

            enemy_shot[7] = 1;
        }else if(angle >= 173.75 && angle < 196.25){

            enemy_shot[8] = 1;
        }else if(angle >= 196.25 && angle < 218.75){

            enemy_shot[9] = 1;
        }else if(angle >= 218.75 && angle < 241.25){

            enemy_shot[10] = 1;
        }else if(angle >= 241.25 && angle < 263.75){

            enemy_shot[11] = 1;
        }else if(angle >= 263.75 && angle < 286.25){

            enemy_shot[12] = 1;
        }else if(angle >= 286.25 && angle < 308.75){

            enemy_shot[13] = 1;
        }else if(angle >= 308.75 && angle < 331.25){

            enemy_shot[14] = 1;
        }else if(angle >= 331.25 && angle < 353.75){

            enemy_shot[15] = 1;
        }


    }


    private double cal_angle(float x, float y) {
        if(x >= 0 && y >= 0)
            return Math.toDegrees(Math.atan(y / x));
        else if(x < 0 && y >= 0)
            return Math.toDegrees(Math.atan(y / x)) + 180;
        else if(x < 0 && y < 0)
            return Math.toDegrees(Math.atan(y / x)) + 180;
        else if(x >= 0 && y < 0)
            return Math.toDegrees(Math.atan(y / x)) + 360;
        return 0;
    }

    public void player_moving(int x, int y, boolean button_down) {

        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if((SpeedX == 0 && SpeedY == 0) || ((SpeedX < 1 && SpeedX > -1) && (SpeedY < 1 && SpeedY > -1))) {

                    bullet_number_count=0;
                }
                else
                {
                    for (int i = 0; i < 5; i++) {
                        if (bullet_number < 1) {
                            ++bullet_number_count;
                            if (bullet[i] == 0) {
                                ++bullet_number;
                                bullet[i] = 1;
                            }
                        }
                    }

                    bullet_number = 0;

                    if(bullet_number_count == 4)
                    {
                        bullet_click = false;
                    }
                    else {
                        bullet_click = true;
                    }
                }
            }
        });

        if (button_down == true) {

            //mapping 범위 안에 player를 움직이기 위해서 기울기의 특성을 이용해 지정해준다.
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

        /*
        if (button_down == true) {

            //mapping 범위 안에 player를 움직이기 위해서 지정해준다.
            if((ps.position_x + ps.position_y) > (tile_end_x1+tile_end_y1+20) && (ps.position_x + ps.position_y) < (tile_end_x4+tile_end_y4+30)) {

                if(ps.position_x> tile_end_x2 && ps.position_y < tile_end_y4 ) {

                    if(ps.position_y >= tile_end_y3) {
                        if ((ps.position_y - tile_end_y2) / (ps.position_x - tile_end_x2) < ((tile_end_y4 - tile_end_y2) / (tile_end_x4 - tile_end_x2))) {

                            prior_player_x = Math.round(ps.position_x);
                            prior_player_y = Math.round(ps.position_y);

                            ps.setPosition(ps.position_x + x, ps.position_y + y);
                        } else {

                            ps.setPosition(ps.position_x + x, ps.position_y + y);

                        }
                    }
                    else
                    {

                        if(ps.position_x > tile_end_x1)
                        {
                            if ((ps.position_y-tile_end_y1) / (ps.position_x-tile_end_x1) > ((tile_end_y3 - tile_end_y1) / (tile_end_x3 - tile_end_x1))) {
                                prior_player_x = Math.round(ps.position_x);
                                prior_player_y = Math.round(ps.position_y);

                                ps.setPosition(ps.position_x + x, ps.position_y + y);
                            }
                            else {

                                ps.setPosition(ps.position_x + x, ps.position_y + y);

                            }
                        }
                        else {

                            prior_player_x = Math.round(ps.position_x);
                            prior_player_y = Math.round(ps.position_y);

                            ps.setPosition(ps.position_x + x, ps.position_y + y);
                        }
                    }
                }
                else
                {
                    ps.setPosition(ps.position_x + x, ps.position_y + y);
                }

            }
            else {

                ps.setPosition(ps.position_x + x, ps.position_y + y);

            }
        }
*/
    }

    public void mapping()
    {
        tile_end_x1 = Math.round(tile1_1.getX());
        tile_end_y1 = Math.round(tile1_1.getY());

        tile_end_x2 = Math.round(tile2_13.getX());
        tile_end_y2 = Math.round(tile2_13.getY());

        tile_end_x3 = Math.round(tile2_20.getX());
        tile_end_y3 = Math.round(tile2_20.getY());

        tile_end_x4 = Math.round(tile1_32.getX());
        tile_end_y4 = Math.round(tile1_32.getY());

    }

    boolean hit_check()
    {

        if(enemy_shot[0] == 1)
        {
            if((enemy_bullet1.position_x+enemy_bullet1.resized_width/4-player.getX())*(enemy_bullet1.position_x+enemy_bullet1.resized_width/4-player.getX()) < enemy_bullet1.resized_width/2*enemy_bullet1.resized_width/3)
            {
                if((enemy_bullet1.position_y+enemy_bullet1.resized_width/4-player.getY())*(enemy_bullet1.position_y+enemy_bullet1.resized_width/4-player.getY()) < enemy_bullet1.resized_width/2*enemy_bullet1.resized_width/3)
                {
                    enemy_bullet1.position(313, 486);
                    enemy_bullet1.setObstacleAlpha(0);
                    enemy_bullet1.position_effect();
                    enemy_shot[0] = 0;
                    return true;
                }
            }
        }

        if(enemy_shot[1] == 1)
        {
            if((enemy_bullet2.position_x+enemy_bullet2.resized_width/4-player.getX())*(enemy_bullet2.position_x+enemy_bullet2.resized_width/4-player.getX()) < enemy_bullet2.resized_width/2*enemy_bullet2.resized_width/3)
            {
                if((enemy_bullet2.position_y+enemy_bullet2.resized_height/4-player.getY())*(enemy_bullet2.position_y+enemy_bullet2.resized_height/4-player.getY()) < enemy_bullet2.resized_height/2*enemy_bullet2.resized_height/3)
                {
                    enemy_bullet2.position(313, 486);
                    enemy_bullet2.setObstacleAlpha(0);
                    enemy_bullet2.position_effect();
                    enemy_shot[1] = 0;
                    return true;
                }
            }
        }

        if(enemy_shot[2] == 1)
        {
            if((enemy_bullet3.position_x+enemy_bullet3.resized_width/4-player.getX())*(enemy_bullet3.position_x+enemy_bullet3.resized_width/4-player.getX()) < enemy_bullet3.resized_width/2*enemy_bullet3.resized_width/3)
            {
                if((enemy_bullet3.position_y+enemy_bullet3.resized_height/4-player.getY())*(enemy_bullet3.position_y+enemy_bullet3.resized_height/4-player.getY()) < enemy_bullet3.resized_height/2*enemy_bullet3.resized_height/3)
                {
                    enemy_bullet3.position(313, 486);
                    enemy_bullet3.setObstacleAlpha(0);
                    enemy_bullet3.position_effect();
                    enemy_shot[2] = 0;
                    return true;
                }
            }
        }

        if(enemy_shot[3] == 1)
        {
            if((enemy_bullet4.position_x+enemy_bullet4.resized_width/4-player.getX())*(enemy_bullet4.position_x+enemy_bullet4.resized_width/4-player.getX()) < enemy_bullet4.resized_width/2*enemy_bullet4.resized_width/3)
            {
                if((enemy_bullet4.position_y+enemy_bullet4.resized_height/4-player.getY())*(enemy_bullet4.position_y+enemy_bullet4.resized_height/4-player.getY()) < enemy_bullet4.resized_height/2*enemy_bullet4.resized_height/3)
                {
                    enemy_bullet4.position(313, 486);
                    enemy_bullet4.setObstacleAlpha(0);
                    enemy_bullet4.position_effect();
                    enemy_shot[3] = 0;
                    return true;
                }
            }
        }

        if(enemy_shot[4] == 1)
        {
            if((enemy_bullet5.position_x+enemy_bullet5.resized_width/4-player.getX())*(enemy_bullet5.position_x+enemy_bullet5.resized_width/4-player.getX()) < enemy_bullet5.resized_width/2*enemy_bullet5.resized_width/3)
            {
                if((enemy_bullet5.position_y+enemy_bullet5.resized_height/4-player.getY())*(enemy_bullet5.position_y+enemy_bullet5.resized_height/4-player.getY()) < enemy_bullet5.resized_height/2*enemy_bullet5.resized_height/3)
                {
                    enemy_bullet5.position(313, 486);
                    enemy_bullet5.setObstacleAlpha(0);
                    enemy_bullet5.position_effect();
                    enemy_shot[4] = 0;
                    return true;
                }
            }
        }

        if(enemy_shot[5] == 1)
        {
            if((enemy_bullet6.position_x+enemy_bullet6.resized_width/4-player.getX())*(enemy_bullet6.position_x+enemy_bullet6.resized_width/4-player.getX()) < enemy_bullet6.resized_width/2*enemy_bullet6.resized_width/3)
            {
                if((enemy_bullet6.position_y+enemy_bullet6.resized_height/4-player.getY())*(enemy_bullet6.position_y+enemy_bullet6.resized_height/4-player.getY()) < enemy_bullet6.resized_height/2*enemy_bullet6.resized_height/3)
                {
                    enemy_bullet6.position(313, 486);
                    enemy_bullet6.setObstacleAlpha(0);
                    enemy_bullet6.position_effect();
                    enemy_shot[5] = 0;
                    return true;
                }
            }
        }

        if(enemy_shot[6] == 1)
        {
            if((enemy_bullet7.position_x+enemy_bullet7.resized_width/4-player.getX())*(enemy_bullet7.position_x+enemy_bullet7.resized_width/4-player.getX()) < enemy_bullet7.resized_width/2*enemy_bullet7.resized_width/3)
            {
                if((enemy_bullet7.position_y+enemy_bullet7.resized_height/4-player.getY())*(enemy_bullet7.position_y+enemy_bullet7.resized_height/4-player.getY()) < enemy_bullet7.resized_height/2*enemy_bullet7.resized_height/3)
                {
                    enemy_bullet7.position(313, 486);
                    enemy_bullet7.setObstacleAlpha(0);
                    enemy_bullet7.position_effect();
                    enemy_shot[6] = 0;
                    return true;
                }
            }
        }

        if(enemy_shot[7] == 1)
        {
            if((enemy_bullet8.position_x+enemy_bullet8.resized_width/4-player.getX())*(enemy_bullet8.position_x+enemy_bullet8.resized_width/4-player.getX()) < enemy_bullet8.resized_width/2*enemy_bullet8.resized_width/3)
            {
                if((enemy_bullet8.position_y+enemy_bullet8.resized_height/4-player.getY())*(enemy_bullet8.position_y+enemy_bullet8.resized_height/4-player.getY()) < enemy_bullet8.resized_height/2*enemy_bullet8.resized_height/3)
                {
                    enemy_bullet8.position(313, 486);
                    enemy_bullet8.setObstacleAlpha(0);
                    enemy_bullet8.position_effect();
                    enemy_shot[7] = 0;
                    return true;
                }
            }
        }

        if(enemy_shot[8] == 1)
        {
            if((enemy_bullet9.position_x+enemy_bullet9.resized_width/4-player.getX())*(enemy_bullet9.position_x+enemy_bullet9.resized_width/4-player.getX()) < enemy_bullet9.resized_width/2*enemy_bullet9.resized_width/3)
            {
                if((enemy_bullet9.position_y+enemy_bullet9.resized_height/4-player.getY())*(enemy_bullet9.position_y+enemy_bullet9.resized_height/4-player.getY()) < enemy_bullet9.resized_height/2*enemy_bullet9.resized_height/3)
                {
                    enemy_bullet9.position(313, 486);
                    enemy_bullet9.setObstacleAlpha(0);
                    enemy_bullet9.position_effect();
                    enemy_shot[8] = 0;
                    return true;
                }
            }
        }

        if(enemy_shot[9] == 1)
        {
            if((enemy_bullet10.position_x+enemy_bullet10.resized_width/4-player.getX())*(enemy_bullet10.position_x+enemy_bullet10.resized_width/4-player.getX()) < enemy_bullet10.resized_width/2*enemy_bullet10.resized_width/3)
            {
                if((enemy_bullet10.position_y+enemy_bullet10.resized_height/4-player.getY())*(enemy_bullet10.position_y+enemy_bullet10.resized_height/4-player.getY()) < enemy_bullet10.resized_height/2*enemy_bullet10.resized_height/3)
                {
                    enemy_bullet10.position(313, 486);
                    enemy_bullet10.setObstacleAlpha(0);
                    enemy_bullet10.position_effect();
                    enemy_shot[9] = 0;
                    return true;
                }
            }
        }

        if(enemy_shot[10] == 1)
        {
            if((enemy_bullet11.position_x+enemy_bullet11.resized_width/4-player.getX())*(enemy_bullet11.position_x+enemy_bullet11.resized_width/4-player.getX()) < enemy_bullet11.resized_width/2*enemy_bullet11.resized_width/3)
            {
                if((enemy_bullet11.position_y+enemy_bullet11.resized_height/4-player.getY())*(enemy_bullet11.position_y+enemy_bullet11.resized_height/4-player.getY()) < enemy_bullet11.resized_height/2*enemy_bullet11.resized_height/3)
                {
                    enemy_bullet11.position(313, 486);
                    enemy_bullet11.setObstacleAlpha(0);
                    enemy_bullet11.position_effect();
                    enemy_shot[10] = 0;
                    return true;
                }
            }
        }

        if(enemy_shot[11] == 1)
        {
            if((enemy_bullet12.position_x+enemy_bullet12.resized_width/4-player.getX())*(enemy_bullet12.position_x+enemy_bullet12.resized_width/4-player.getX()) < enemy_bullet12.resized_width/2*enemy_bullet12.resized_width/3)
            {
                if((enemy_bullet12.position_y+enemy_bullet12.resized_height/4-player.getY())*(enemy_bullet12.position_y+enemy_bullet12.resized_height/4-player.getY()) < enemy_bullet12.resized_height/2*enemy_bullet12.resized_height/3)
                {
                    enemy_bullet12.position(313, 486);
                    enemy_bullet12.setObstacleAlpha(0);
                    enemy_bullet12.position_effect();
                    enemy_shot[11] = 0;
                    return true;
                }
            }
        }

        if(enemy_shot[12] == 1)
        {
            if((enemy_bullet13.position_x+enemy_bullet13.resized_width/4-player.getX())*(enemy_bullet13.position_x+enemy_bullet13.resized_width/4-player.getX()) <enemy_bullet13.resized_width/2*enemy_bullet13.resized_width/3)
            {
                if((enemy_bullet13.position_y+enemy_bullet13.resized_height/4-player.getY())*(enemy_bullet13.position_y+enemy_bullet13.resized_height/4-player.getY()) < enemy_bullet13.resized_height/2*enemy_bullet13.resized_height/3)
                {
                    enemy_bullet13.position(313, 486);
                    enemy_bullet13.setObstacleAlpha(0);
                    enemy_bullet13.position_effect();
                    enemy_shot[12] = 0;
                    return true;
                }
            }
        }

        if(enemy_shot[13] == 1)
        {
            if((enemy_bullet14.position_x+enemy_bullet14.resized_width/4-player.getX())*(enemy_bullet14.position_x+enemy_bullet14.resized_width/4-player.getX()) < enemy_bullet14.resized_width/2*enemy_bullet14.resized_width/3)
            {
                if((enemy_bullet14.position_y+enemy_bullet14.resized_height/4-player.getY())*(enemy_bullet14.position_y+enemy_bullet14.resized_height/4-player.getY()) < enemy_bullet14.resized_height/2*enemy_bullet14.resized_height/3)
                {
                    enemy_bullet14.position(313, 486);
                    enemy_bullet14.setObstacleAlpha(0);
                    enemy_bullet14.position_effect();
                    enemy_shot[13] = 0;
                    return true;
                }
            }
        }

        if(enemy_shot[14] == 1)
        {
            if((enemy_bullet15.position_x+enemy_bullet15.resized_width/4-player.getX())*(enemy_bullet15.position_x+enemy_bullet15.resized_width/4-player.getX()) < enemy_bullet15.resized_width/2*enemy_bullet15.resized_width/3)
            {
                if((enemy_bullet15.position_y+enemy_bullet15.resized_height/4-player.getY())*(enemy_bullet15.position_y+enemy_bullet15.resized_height/4-player.getY()) < enemy_bullet15.resized_height/2*enemy_bullet15.resized_height/3)
                {
                    enemy_bullet15.position(313, 486);
                    enemy_bullet15.setObstacleAlpha(0);
                    enemy_bullet15.position_effect();
                    enemy_shot[14] = 0;
                    return true;
                }
            }
        }

        if(enemy_shot[15] == 1)
        {
            if((enemy_bullet16.position_x+enemy_bullet16.resized_width/4-player.getX())*(enemy_bullet16.position_x+enemy_bullet16.resized_width/4-player.getX()) < enemy_bullet16.resized_width/2*enemy_bullet16.resized_width/3)
            {
                if((enemy_bullet16.position_y+enemy_bullet16.resized_height/4-player.getY())*(enemy_bullet16.position_y+enemy_bullet16.resized_height/4-player.getY()) < enemy_bullet16.resized_height/2*enemy_bullet16.resized_height/3)
                {
                    enemy_bullet16.position(313, 486);
                    enemy_bullet16.setObstacleAlpha(0);
                    enemy_bullet16.position_effect();
                    enemy_shot[15] = 0;
                    return true;
                }
            }
        }


        if((enemy1_1.position_x+enemy1_1.resized_width/4-player.getX())*(enemy1_1.position_x+enemy1_1.resized_width/4-player.getX()) < enemy1_1.resized_width/2*enemy1_1.resized_width/3)
        {
            if((enemy1_1.position_y+enemy1_1.resized_height/4-player.getY())*(enemy1_1.position_y+enemy1_1.resized_height/4-player.getY()) < enemy1_1.resized_height/2*enemy1_1.resized_height/3)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((enemy1_2.position_x+enemy1_2.resized_width/4-player.getX())*(enemy1_2.position_x+enemy1_2.resized_width/4-player.getX()) < enemy1_2.resized_width/2*enemy1_2.resized_width/2)
        {
            if((enemy1_2.position_y+enemy1_2.resized_height/4-player.getY())*(enemy1_2.position_y+enemy1_2.resized_height/4-player.getY()) <enemy1_2.resized_height/2*enemy1_2.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((enemy1_3.position_x+enemy1_3.resized_width/4-player.getX())*(enemy1_3.position_x+enemy1_3.resized_width/4-player.getX()) < enemy1_3.resized_width/2*enemy1_3.resized_width/2)
        {
            if((enemy1_3.position_y+enemy1_3.resized_height/4-player.getY())*(enemy1_3.position_y+enemy1_3.resized_height/4-player.getY()) < enemy1_3.resized_height/2*enemy1_3.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((enemy1_4.position_x+enemy1_4.resized_width/4-player.getX())*(enemy1_4.position_x+enemy1_4.resized_width/4-player.getX()) < enemy1_4.resized_width/2*enemy1_4.resized_width/2)
        {
            if((enemy1_4.position_y+enemy1_4.resized_height/4-player.getY())*(enemy1_4.position_y+enemy1_4.resized_height/4-player.getY()) < enemy1_4.resized_height/2*enemy1_4.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((enemy1_5.position_x+enemy1_5.resized_width/4-player.getX())*(enemy1_5.position_x+enemy1_5.resized_width/4-player.getX()) < enemy1_5.resized_width/2*enemy1_5.resized_width/2)
        {
            if((enemy1_5.position_y+enemy1_5.resized_height/4-player.getY())*(enemy1_5.position_y+enemy1_5.resized_height/4-player.getY()) < enemy1_5.resized_height/2*enemy1_5.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((enemy1_6.position_x+enemy1_6.resized_width/4-player.getX())*(enemy1_6.position_x+enemy1_6.resized_width/4-player.getX()) < enemy1_6.resized_width/2*enemy1_6.resized_width/2)
        {
            if((enemy1_6.position_y+enemy1_6.resized_height/4-player.getY())*(enemy1_6.position_y+enemy1_6.resized_height/4-player.getY()) < enemy1_6.resized_height/2*enemy1_6.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((enemy1_7.position_x+enemy1_7.resized_width/4-player.getX())*(enemy1_7.position_x+enemy1_7.resized_width/4-player.getX()) < enemy1_7.resized_width/2*enemy1_7.resized_width/2)
        {
            if((enemy1_7.position_y+enemy1_7.resized_height/4-player.getY())*(enemy1_7.position_y+enemy1_7.resized_height/4-player.getY()) < enemy1_7.resized_height/2*enemy1_7.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((enemy1_8.position_x+enemy1_8.resized_width/4-player.getX())*(enemy1_8.position_x+enemy1_8.resized_width/4-player.getX()) < enemy1_8.resized_width/2*enemy1_8.resized_width/2)
        {
            if((enemy1_8.position_y+enemy1_8.resized_height/4-player.getY())*(enemy1_8.position_y+enemy1_8.resized_height/4-player.getY()) < enemy1_8.resized_height/2*enemy1_8.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        //////////////////////////////////////////////////////////////////////////////////////////////////

        if((enemy1x2_1.position_x+enemy1x2_1.resized_width/4-player.getX())*(enemy1x2_1.position_x+enemy1x2_1.resized_width/4-player.getX()) < enemy1x2_1.resized_width/2*enemy1x2_1.resized_width/2)
        {
            if((enemy1x2_1.position_y+enemy1x2_1.resized_height/4-player.getY())*(enemy1x2_1.position_y+enemy1x2_1.resized_height/4-player.getY()) <enemy1x2_1.resized_height/2*enemy1x2_1.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((enemy1x2_2.position_x+enemy1x2_2.resized_width/4-player.getX())*(enemy1x2_2.position_x+enemy1x2_2.resized_width/4-player.getX()) < enemy1x2_2.resized_width/2*enemy1x2_2.resized_width/2)
        {
            if((enemy1x2_2.position_y+enemy1x2_2.resized_height/4-player.getY())*(enemy1x2_2.position_y+enemy1x2_2.resized_height/4-player.getY()) <enemy1x2_2.resized_height/2*enemy1x2_2.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((enemy1x2_3.position_x+enemy1x2_3.resized_width/4-player.getX())*(enemy1x2_3.position_x+enemy1x2_3.resized_width/4-player.getX()) < enemy1x2_3.resized_width/2*enemy1x2_3.resized_width/2)
        {
            if((enemy1x2_3.position_y+enemy1x2_3.resized_height/4-player.getY())*(enemy1x2_3.position_y+enemy1x2_3.resized_height/4-player.getY()) < enemy1x2_3.resized_height/2*enemy1x2_3.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((enemy1x2_4.position_x+enemy1x2_4.resized_width/4-player.getX())*(enemy1x2_4.position_x+enemy1x2_4.resized_width/4-player.getX()) < enemy1x2_4.resized_width/2*enemy1x2_4.resized_width/2)
        {
            if((enemy1x2_4.position_y+enemy1x2_4.resized_height/4-player.getY())*(enemy1x2_4.position_y+enemy1x2_4.resized_height/4-player.getY()) <enemy1x2_4.resized_height/2*enemy1x2_4.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((enemy1x2_5.position_x+enemy1x2_5.resized_width/4-player.getX())*(enemy1x2_5.position_x+enemy1x2_5.resized_width/4-player.getX()) < enemy1x2_5.resized_width/2*enemy1x2_5.resized_width/2)
        {
            if((enemy1x2_5.position_y+enemy1x2_5.resized_height/4-player.getY())*(enemy1x2_5.position_y+enemy1x2_5.resized_height/4-player.getY()) < enemy1x2_5.resized_height/2*enemy1x2_5.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((enemy1x2_6.position_x+enemy1x2_6.resized_width/4-player.getX())*(enemy1x2_6.position_x+enemy1x2_6.resized_width/4-player.getX()) <enemy1x2_6.resized_width/2*enemy1x2_6.resized_width/2)
        {
            if((enemy1x2_6.position_y+enemy1x2_6.resized_height/4-player.getY())*(enemy1x2_6.position_y+enemy1x2_6.resized_height/4-player.getY()) <enemy1x2_6.resized_height/2*enemy1x2_6.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((enemy1x2_7.position_x+enemy1x2_7.resized_width/4-player.getX())*(enemy1x2_7.position_x+enemy1x2_7.resized_width/4-player.getX()) < enemy1x2_7.resized_width/2*enemy1x2_7.resized_width/2)
        {
            if((enemy1x2_7.position_y+enemy1x2_7.resized_height/4-player.getY())*(enemy1x2_7.position_y+enemy1x2_7.resized_height/4-player.getY()) < enemy1x2_7.resized_height/2*enemy1x2_7.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((enemy1x2_8.position_x+enemy1x2_8.resized_width/4-player.getX())*(enemy1x2_8.position_x+enemy1x2_8.resized_width/4-player.getX()) < enemy1x2_8.resized_width/2*enemy1x2_8.resized_width/2)
        {
            if((enemy1x2_8.position_y+enemy1x2_8.resized_height/4-player.getY())*(enemy1x2_8.position_y+enemy1x2_8.resized_height/4-player.getY()) < enemy1x2_8.resized_height/2*enemy1x2_8.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////////

        if((enemy1x3_1.position_x+enemy1x3_1.resized_width/4-player.getX())*(enemy1x3_1.position_x+enemy1x3_1.resized_width/4-player.getX()) < enemy1x3_1.resized_width/2*enemy1x3_1.resized_width/3)
        {
            if ((enemy1x3_1.position_y + enemy1x3_1.resized_height/4- player.getY()) * (enemy1x3_1.position_y + enemy1x3_1.resized_height/4 - player.getY()) < enemy1x3_1.resized_height/2*enemy1x3_1.resized_height/3) {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if ((enemy1x3_2.position_x + enemy1x3_2.resized_width/4 - player.getX()) * (enemy1x3_2.position_x + enemy1x3_2.resized_width/4 - player.getX()) < enemy1x3_2.resized_width/2*enemy1x3_2.resized_width/3) {
            if ((enemy1x3_2.position_y + enemy1x3_2.resized_height/4 - player.getY()) * (enemy1x3_2.position_y + enemy1x3_2.resized_height/4 - player.getY()) < enemy1x3_2.resized_height/2*enemy1x3_2.resized_height/3) {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((enemy1x3_3.position_x+enemy1x3_3.resized_width/4-player.getX())*(enemy1x3_3.position_x+enemy1x3_3.resized_width/4-player.getX()) < enemy1x3_3.resized_width/2*enemy1x3_3.resized_width/3)
        {
            if((enemy1x3_3.position_y+enemy1x3_3.resized_height/4-player.getY())*(enemy1x3_3.position_y+enemy1x3_3.resized_height/4-player.getY()) < enemy1x3_3.resized_height/2*enemy1x3_3.resized_height/3)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((enemy1x3_4.position_x+enemy1x3_4.resized_width/4-player.getX())*(enemy1x3_4.position_x+enemy1x3_4.resized_width/4-player.getX()) < enemy1x3_4.resized_width/2*enemy1x3_4.resized_width/3)
        {
            if((enemy1x3_4.position_y+enemy1x3_4.resized_height/4-player.getY())*(enemy1x3_4.position_y+enemy1x3_4.resized_height/4-player.getY()) < enemy1x3_4.resized_height/2*enemy1x3_4.resized_height/3)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((enemy1x3_5.position_x+enemy1x3_5.resized_width/4-player.getX())*(enemy1x3_5.position_x+enemy1x3_5.resized_width/4-player.getX()) < enemy1x3_5.resized_width/2*enemy1x3_5.resized_width/3)
        {
            if((enemy1x3_5.position_y+enemy1x3_5.resized_height/4-player.getY())*(enemy1x3_5.position_y+enemy1x3_5.resized_height/4-player.getY()) < enemy1x3_5.resized_height/2*enemy1x3_5.resized_height/3)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((enemy1x3_6.position_x+enemy1x3_6.resized_width/4-player.getX())*(enemy1x3_6.position_x+enemy1x3_6.resized_width/4-player.getX()) < enemy1x3_6.resized_width/2*enemy1x3_6.resized_width/3)
        {
            if((enemy1x3_6.position_y+enemy1x3_6.resized_height/4-player.getY())*(enemy1x3_6.position_y+enemy1x3_6.resized_height/4-player.getY()) <enemy1x3_6.resized_height/2*enemy1x3_6.resized_height/3)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((enemy1x3_7.position_x+enemy1x3_7.resized_width/4-player.getX())*(enemy1x3_7.position_x+enemy1x3_7.resized_width/4-player.getX()) < enemy1x3_7.resized_width/2*enemy1x3_7.resized_width/3)
        {
            if((enemy1x3_7.position_y+enemy1x3_7.resized_height/4-player.getY())*(enemy1x3_7.position_y+enemy1x3_7.resized_height/4-player.getY()) <enemy1x3_7.resized_height/2*enemy1x3_7.resized_height/3)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((enemy1x3_8.position_x+enemy1x3_8.resized_width/4-player.getX())*(enemy1x3_8.position_x+enemy1x3_8.resized_width/4-player.getX()) < enemy1x3_8.resized_width/2*enemy1x3_8.resized_width/3)
        {
            if((enemy1x3_8.position_y+enemy1x3_8.resized_height/4-player.getY())*(enemy1x3_8.position_y+enemy1x3_8.resized_height/4-player.getY()) < enemy1x3_8.resized_height/2*enemy1x3_8.resized_height/3)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////////
        if((enemy2_1.position_x+enemy2_1.resized_width/4-player.getX())*(enemy2_1.position_x+enemy2_1.resized_width/4-player.getX()) < enemy2_1.resized_width/2*enemy2_1.resized_width/3)
        {
            if((enemy2_1.position_y+enemy2_1.resized_height/4-player.getY())*(enemy2_1.position_y+enemy2_1.resized_height/4-player.getY()) <enemy2_1.resized_height/2*enemy2_1.resized_height/3)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((enemy2_2.position_x+enemy2_2.resized_width/4-player.getX())*(enemy2_2.position_x+enemy2_2.resized_width/4-player.getX()) < enemy2_2.resized_width/2*enemy2_2.resized_width/3)
        {
            if((enemy2_2.position_y+enemy2_2.resized_height/4-player.getY())*(enemy2_2.position_y+enemy2_2.resized_height/4-player.getY()) < enemy2_2.resized_height/2*enemy2_2.resized_height/3)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((enemy2_3.position_x+enemy2_3.resized_width/4-player.getX())*(enemy2_3.position_x+enemy2_3.resized_width/4-player.getX()) < enemy2_3.resized_width/2*enemy2_3.resized_width/3)
        {
            if((enemy2_3.position_y+enemy2_3.resized_height/4-player.getY())*(enemy2_3.position_y+enemy2_3.resized_height/4-player.getY()) < enemy2_3.resized_height/2*enemy2_3.resized_height/3)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((enemy2_4.position_x+enemy2_4.resized_width/4-player.getX())*(enemy2_4.position_x+enemy2_4.resized_width/4-player.getX()) < enemy2_4.resized_width/2*enemy2_4.resized_width/3)
        {
            if((enemy2_4.position_y+enemy2_4.resized_height/4-player.getY())*(enemy2_4.position_y+enemy2_4.resized_height/4-player.getY()) < enemy2_4.resized_height/2*enemy2_4.resized_height/3)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((enemy2_5.position_x+enemy2_5.resized_width/4-player.getX())*(enemy2_5.position_x+enemy2_5.resized_width/4-player.getX()) <enemy2_5.resized_width/2*enemy2_5.resized_width/3)
        {
            if((enemy2_5.position_y+enemy2_5.resized_height/4-player.getY())*(enemy2_5.position_y+enemy2_5.resized_height/4-player.getY()) < enemy2_5.resized_height/2*enemy2_5.resized_height/3)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((enemy2_6.position_x+enemy2_6.resized_width/4-player.getX())*(enemy2_6.position_x+enemy2_6.resized_width/4-player.getX()) < enemy2_6.resized_width/2*enemy2_6.resized_width/3)
        {
            if((enemy2_6.position_y+enemy2_6.resized_height/4-player.getY())*(enemy2_6.position_y+enemy2_6.resized_height/4-player.getY()) < enemy2_6.resized_height/2*enemy2_6.resized_height/3)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((enemy2_7.position_x+enemy2_7.resized_width/4-player.getX())*(enemy2_7.position_x+enemy2_7.resized_width/4-player.getX()) < enemy2_7.resized_width/2*enemy2_7.resized_width/3)
        {
            if((enemy2_7.position_y+enemy2_7.resized_height/4-player.getY())*(enemy2_7.position_y+enemy2_7.resized_height/4-player.getY()) < enemy2_7.resized_height/2*enemy2_7.resized_height/3)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((enemy2_8.position_x+enemy2_8.resized_width/4-player.getX())*(enemy2_8.position_x+enemy2_8.resized_width/4-player.getX()) < enemy2_8.resized_width/2*enemy2_8.resized_width/3)
        {
            if((enemy2_8.position_y+enemy2_8.resized_height/4-player.getY())*(enemy2_8.position_y+enemy2_8.resized_height/4-player.getY()) <enemy2_8.resized_height/2*enemy2_8.resized_height/3)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        if((enemy2x2_1.position_x+enemy2x2_1.resized_width/4-player.getX())*(enemy2x2_1.position_x+enemy2x2_1.resized_width/4-player.getX()) < enemy2x2_1.resized_width/2*enemy2x2_1.resized_width/3)
        {
            if((enemy2x2_1.position_y+enemy2x2_1.resized_height/4-player.getY())*(enemy2x2_1.position_y+enemy2x2_1.resized_height/4-player.getY()) < enemy2x2_1.resized_height/2*enemy2x2_1.resized_height/3)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((enemy2x2_2.position_x+enemy2x2_2.resized_width/4-player.getX())*(enemy2x2_2.position_x+enemy2x2_2.resized_width/4-player.getX()) < enemy2x2_2.resized_width/2*enemy2x2_2.resized_width/3)
        {
            if((enemy2x2_2.position_y+enemy2x2_2.resized_height/4-player.getY())*(enemy2x2_2.position_y+enemy2x2_2.resized_height/4-player.getY()) < enemy2x2_2.resized_height/2*enemy2x2_2.resized_height/3)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((enemy2x2_3.position_x+enemy2x2_3.resized_width/4-player.getX())*(enemy2x2_3.position_x+enemy2x2_3.resized_width/4-player.getX()) < enemy2x2_3.resized_width/2*enemy2x2_3.resized_width/3)
        {
            if((enemy2x2_3.position_y+enemy2x2_3.resized_height/4-player.getY())*(enemy2x2_3.position_y+enemy2x2_3.resized_height/4-player.getY()) < enemy2x2_3.resized_height/2*enemy2x2_3.resized_height/3)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((enemy2x2_4.position_x+enemy2x2_4.resized_width/4-player.getX())*(enemy2x2_4.position_x+enemy2x2_4.resized_width/4-player.getX()) < enemy2x2_4.resized_width/2*enemy2x2_4.resized_width/3)
        {
            if((enemy2x2_4.position_y+enemy2x2_4.resized_height/4-player.getY())*(enemy2x2_4.position_y+enemy2x2_4.resized_height/4-player.getY()) < enemy2x2_4.resized_height/2*enemy2x2_4.resized_height/3)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((enemy2x2_5.position_x+enemy2x2_5.resized_width/4-player.getX())*(enemy2x2_5.position_x+enemy2x2_5.resized_width/4-player.getX()) < enemy2x2_5.resized_width/2*enemy2x2_5.resized_width/3)
        {
            if((enemy2x2_5.position_y+enemy2x2_5.resized_height/4-player.getY())*(enemy2x2_5.position_y+enemy2x2_5.resized_height/4-player.getY()) < enemy2x2_5.resized_height/2*enemy2x2_5.resized_height/3)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((enemy2x2_6.position_x+enemy2x2_6.resized_width/4-player.getX())*(enemy2x2_6.position_x+enemy2x2_6.resized_width/4-player.getX()) < enemy2x2_6.resized_width/2*enemy2x2_6.resized_width/3)
        {
            if((enemy2x2_6.position_y+enemy2x2_6.resized_height/4-player.getY())*(enemy2x2_6.position_y+enemy2x2_6.resized_height/4-player.getY()) < enemy2x2_6.resized_height/2*enemy2x2_6.resized_height/3)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((enemy2x2_7.position_x+enemy2x2_7.resized_width/4-player.getX())*(enemy2x2_7.position_x+enemy2x2_7.resized_width/4-player.getX()) < enemy2x2_7.resized_width/2*enemy2x2_7.resized_width/3)
        {
            if((enemy2x2_7.position_y+enemy2x2_7.resized_height/4-player.getY())*(enemy2x2_7.position_y+enemy2x2_7.resized_height/4-player.getY()) < enemy2x2_7.resized_height/2*enemy2x2_7.resized_height/3)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((enemy2x2_8.position_x+enemy2x2_8.resized_width/4-player.getX())*(enemy2x2_8.position_x+enemy2x2_8.resized_width/4-player.getX()) < enemy2x2_8.resized_width/2*enemy2x2_8.resized_width/3)
        {
            if((enemy2x2_8.position_y+enemy2x2_8.resized_height/4-player.getY())*(enemy2x2_8.position_y+enemy2x2_8.resized_height/4-player.getY()) < enemy2x2_8.resized_height/2*enemy2x2_8.resized_height/3)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if((enemy2x3_1.position_x+enemy2x3_1.resized_width/4-player.getX())*(enemy2x3_1.position_x+enemy2x3_1.resized_width/4-player.getX()) < enemy2x3_1.resized_width/2*enemy2x3_1.resized_width/3)
        {
            if((enemy2x3_1.position_y+enemy2x3_1.resized_height/4-player.getY())*(enemy2x3_1.position_y+enemy2x3_1.resized_height/4-player.getY()) < enemy2x3_1.resized_height/2*enemy2x3_1.resized_height/3)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((enemy2x3_2.position_x+enemy2x3_2.resized_width/4-player.getX())*(enemy2x3_2.position_x+enemy2x3_2.resized_width/4-player.getX()) < enemy2x3_2.resized_width/2*enemy2x3_2.resized_width/3)
        {
            if((enemy2x3_2.position_y+enemy2x3_2.resized_height/4-player.getY())*(enemy2x3_2.position_y+enemy2x3_2.resized_height/4-player.getY()) < enemy2x3_2.resized_height/2*enemy2x3_2.resized_height/3)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((enemy2x3_3.position_x+enemy2x3_3.resized_width/4-player.getX())*(enemy2x3_3.position_x+enemy2x3_3.resized_width/4-player.getX()) < enemy2x3_3.resized_width/2*enemy2x3_3.resized_width/3)
        {
            if((enemy2x3_3.position_y+enemy2x3_3.resized_height/4-player.getY())*(enemy2x3_3.position_y+enemy2x3_3.resized_height/4-player.getY()) <enemy2x3_3.resized_height/2*enemy2x3_3.resized_height/3)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((enemy2x3_4.position_x+enemy2x3_4.resized_width/4-player.getX())*(enemy2x3_4.position_x+enemy2x3_4.resized_width/4-player.getX()) < enemy2x3_4.resized_width/2*enemy2x3_4.resized_width/3)
        {
            if((enemy2x3_4.position_y+enemy2x3_4.resized_height/4-player.getY())*(enemy2x3_4.position_y+enemy2x3_4.resized_height/4-player.getY()) < enemy2x3_4.resized_height/2*enemy2x3_4.resized_height/3)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((enemy2x3_5.position_x+enemy2x3_5.resized_width/4-player.getX())*(enemy2x3_5.position_x+enemy2x3_5.resized_width/4-player.getX()) < enemy2x3_5.resized_width/2*enemy2x3_5.resized_width/3)
        {
            if((enemy2x3_5.position_y+enemy2x3_5.resized_height/4-player.getY())*(enemy2x3_5.position_y+enemy2x3_5.resized_height/4-player.getY()) < enemy2x3_5.resized_height/2*enemy2x3_5.resized_height/3)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((enemy2x3_6.position_x+enemy2x3_6.resized_width/4-player.getX())*(enemy2x3_6.position_x+enemy2x3_6.resized_width/4-player.getX()) < enemy2x3_6.resized_width/2*enemy2x3_6.resized_width/3)
        {
            if((enemy2x3_6.position_y+enemy2x3_6.resized_height/4-player.getY())*(enemy2x3_6.position_y+enemy2x3_6.resized_height/4-player.getY()) < enemy2x3_6.resized_height/2*enemy2x3_6.resized_height/3)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((enemy2x3_7.position_x+enemy2x3_7.resized_width/4-player.getX())*(enemy2x3_7.position_x+enemy2x3_7.resized_width/4-player.getX()) < enemy2x3_7.resized_width/2*enemy2x3_7.resized_width/3)
        {
            if((enemy2x3_7.position_y+enemy2x3_7.resized_height/4-player.getY())*(enemy2x3_7.position_y+enemy2x3_7.resized_height/4-player.getY()) < enemy2x3_7.resized_height/2*enemy2x3_7.resized_height/3)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((enemy2x3_8.position_x+enemy2x3_8.resized_width/4-player.getX())*(enemy2x3_8.position_x+enemy2x3_8.resized_width/4-player.getX()) < enemy2x3_8.resized_width/2*enemy2x3_8.resized_width/3)
        {
            if((enemy2x3_8.position_y+enemy2x3_8.resized_height/4-player.getY())*(enemy2x3_8.position_y+enemy2x3_8.resized_height/4-player.getY()) < enemy2x3_8.resized_height/2*enemy2x3_8.resized_height/3)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }
        return false;
    }

    public void bullet_moving(float x, float y, int z, int t)
    {
        int initial_bullet_x = (int)x;
        int initial_bullet_y = (int)y;

        int bullet_speed_x = -z;
        int bullet_speed_y = -t;

        if(bullet[0] == 1)
        {
            if((bullet_number_count == 1) && (bullet_click == true))
            {
                bullet1_SpeedX = bullet_speed_x;
                bullet1_SpeedY = bullet_speed_y;

                bullet1_initialX =  initial_bullet_x;
                bullet1_initialY = initial_bullet_y;

                bullet_click = false;
                bullet_number_count = 0;

                bullet1_1.position( bullet1_initialX , bullet1_initialY);
            }

            if (bullet1_1.position_x >= 260*size_dm || bullet1_1.position_x <= 10*size_dm || bullet1_1.position_y <=90*size_dm || bullet1_1.position_y >= 350*size_dm) {

                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
                bullet[0]=0;
                bullet_number_count = 0;
                bullet_click = false;

            } else {

                bullet1_1.setObstacleAlpha(200);
                bullet1_1.setPosition(bullet1_SpeedX, bullet1_SpeedY);
            }
        }


        if(bullet[1] == 1)
        {
            if((bullet_number_count == 2) && (bullet_click == true))
            {
                bullet2_SpeedX = bullet_speed_x;
                bullet2_SpeedY = bullet_speed_y;

                bullet2_initialX =  initial_bullet_x;
                bullet2_initialY = initial_bullet_y;

                bullet_click = false;
                bullet_number_count = 0;

                bullet1_2.position(bullet2_initialX, bullet2_initialY);
            }


            if (bullet1_2.position_x >= 260*size_dm || bullet1_2.position_x <=10*size_dm || bullet1_2.position_y <= 90*size_dm || bullet1_2.position_y >=350*size_dm ) {

                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
                bullet[1] = 0;
                bullet_number_count = 0;
                bullet_click = false;

            } else {
                bullet1_2.setObstacleAlpha(200);
                bullet1_2.setPosition(bullet2_SpeedX, bullet2_SpeedY);
            }
        }

        if(bullet[2] == 1)
        {
            if((bullet_number_count == 3) && (bullet_click == true))
            {
                bullet3_SpeedX = bullet_speed_x;
                bullet3_SpeedY = bullet_speed_y;

                bullet3_initialX =  initial_bullet_x;
                bullet3_initialY = initial_bullet_y;

                bullet_click = false;
                bullet_number_count = 0;

                bullet1_3.position(bullet3_initialX, bullet3_initialY);
            }


            if (bullet1_3.position_x >= 260*size_dm || bullet1_3.position_x <= 10*size_dm || bullet1_3.position_y <= 90*size_dm || bullet1_3.position_y >=350*size_dm ) {

                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
                bullet[2] = 0;
                bullet_number_count = 0;
                bullet_click = false;

            } else {
                bullet1_3.setObstacleAlpha(200);
                bullet1_3.setPosition(bullet3_SpeedX, bullet3_SpeedY);
            }
        }

        if(bullet[3] == 1)
        {
            if((bullet_number_count == 4) && (bullet_click == true))
            {
                bullet4_SpeedX = bullet_speed_x;
                bullet4_SpeedY = bullet_speed_y;

                bullet4_initialX =  initial_bullet_x;
                bullet4_initialY = initial_bullet_y;

                bullet_click = false;
                bullet_number_count = 0;

                bullet1_4.position(bullet4_initialX, bullet4_initialY);
            }


            if (bullet1_4.position_x >= 260*size_dm || bullet1_4.position_x <= 10*size_dm || bullet1_4.position_y <= 90*size_dm || bullet1_4.position_y >=350*size_dm ) {

                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
                bullet[3] = 0;
                bullet_number_count = 0;
                bullet_click = false;

            } else {
                bullet1_4.setObstacleAlpha(200);
                bullet1_4.setPosition(bullet4_SpeedX, bullet4_SpeedY);
            }

        }

        if(bullet[4] == 1)
        {
            if((bullet_number_count == 5) && (bullet_click == true))
            {
                bullet5_SpeedX = bullet_speed_x;
                bullet5_SpeedY = bullet_speed_y;

                bullet5_initialX =  initial_bullet_x;
                bullet5_initialY = initial_bullet_y;

                bullet_click = false;
                bullet_number_count = 0;

                bullet1_5.position(bullet5_initialX, bullet5_initialY);
            }


            if (bullet1_5.position_x >= 260*size_dm || bullet1_5.position_x <=10*size_dm || bullet1_5.position_y <=  90*size_dm || bullet1_5.position_y >=350*size_dm ) {

                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
                bullet[4] = 0;
                bullet_number_count = 0;
                bullet_click = false;

            } else {
                bullet1_5.setObstacleAlpha(200);
                bullet1_5.setPosition(bullet5_SpeedX, bullet5_SpeedY);
            }

        }

    }

    public void hit_check2() {

        if(enemy_shot[0]==1)
        {
            if((bullet1_1.position_x + bullet1_1.resized_width/4- enemy_bullet1.position_x)*(bullet1_1.position_x + bullet1_1.resized_width/4- enemy_bullet1.position_x) < bullet1_1.resized_width/2*bullet1_1.resized_width/2)
            {
                if((bullet1_1.position_y+ bullet1_1.resized_height/4- enemy_bullet1.position_y)*(bullet1_1.position_y + bullet1_1.resized_height/4- enemy_bullet1.position_y) < bullet1_1.resized_height/2*bullet1_1.resized_height/2)
                {
                    bullet[0] = 0;
                    bullet1_1.position(10, 10);
                    bullet1_1.setObstacleAlpha(0);
                    bullet1_1.position_effect();

                    enemy_bullet1.position(313, 486);
                    enemy_bullet1.setObstacleAlpha(0);
                    enemy_bullet1.position_effect();
                    enemy_shot[0]=0;

                }
            }
        }

        if(enemy_shot[0]==1)
        {
            if((bullet1_2.position_x + bullet1_2.resized_width/4- enemy_bullet1.position_x)*(bullet1_2.position_x +  bullet1_2.resized_width/4 - enemy_bullet1.position_x) <  bullet1_2.resized_width/2* bullet1_2.resized_width/2)
            {
                if((bullet1_2.position_y + bullet1_2.resized_height/4- enemy_bullet1.position_y)*(bullet1_2.position_y + bullet1_2.resized_height/4- enemy_bullet1.position_y) < bullet1_2.resized_height/2*bullet1_2.resized_height/2)
                {
                    bullet[1] = 0;
                    bullet1_2.position(10, 10);
                    bullet1_2.setObstacleAlpha(0);
                    bullet1_2.position_effect();

                    enemy_bullet1.position(313, 486);
                    enemy_bullet1.setObstacleAlpha(0);
                    enemy_bullet1.position_effect();
                    enemy_shot[0]=0;

                }
            }
        }

        if(enemy_shot[0]==1)
        {
            if((bullet1_3.position_x + bullet1_3.resized_width/4 - enemy_bullet1.position_x)*(bullet1_3.position_x + bullet1_3.resized_width/4  - enemy_bullet1.position_x) < bullet1_3.resized_width/2*bullet1_3.resized_width/2)
            {
                if((bullet1_3.position_y + bullet1_3.resized_height/4- enemy_bullet1.position_y)*(bullet1_3.position_y + bullet1_3.resized_height/4- enemy_bullet1.position_y) < bullet1_3.resized_height/2*bullet1_3.resized_height/2)
                {
                    bullet[2] = 0;
                    bullet1_3.position(10, 10);
                    bullet1_3.setObstacleAlpha(0);
                    bullet1_3.position_effect();

                    enemy_bullet1.position(313, 486);
                    enemy_bullet1.setObstacleAlpha(0);
                    enemy_bullet1.position_effect();
                    enemy_shot[0]=0;

                }
            }
        }

        if(enemy_shot[1]==1)
        {
            if((bullet1_1.position_x + bullet1_1.resized_width/4 - enemy_bullet2.position_x)*(bullet1_1.position_x + bullet1_1.resized_width/4- enemy_bullet2.position_x) < bullet1_1.resized_width/2*bullet1_1.resized_width/2)
            {
                if((bullet1_1.position_y + bullet1_1.resized_height/4 - enemy_bullet2.position_y)*(bullet1_1.position_y + bullet1_1.resized_height/4 - enemy_bullet2.position_y) <bullet1_1.resized_height/2*bullet1_1.resized_height/2)
                {
                    bullet[0] = 0;
                    bullet1_1.position(10, 10);
                    bullet1_1.setObstacleAlpha(0);
                    bullet1_1.position_effect();

                    enemy_bullet2.position(313, 486);
                    enemy_bullet2.setObstacleAlpha(0);
                    enemy_bullet2.position_effect();
                    enemy_shot[1]=0;

                }
            }
        }

        if(enemy_shot[1]==1)
        {
            if((bullet1_2.position_x + bullet1_2.resized_width/4 - enemy_bullet2.position_x)*(bullet1_2.position_x + bullet1_2.resized_width/4- enemy_bullet2.position_x) < bullet1_2.resized_width/2*bullet1_2.resized_width/2)
            {
                if((bullet1_2.position_y + bullet1_2.resized_height/4- enemy_bullet2.position_y)*(bullet1_2.position_y + bullet1_2.resized_height/4 - enemy_bullet2.position_y) < bullet1_2.resized_height/2*bullet1_2.resized_height/2)
                {
                    bullet[1] = 0;
                    bullet1_2.position(10, 10);
                    bullet1_2.setObstacleAlpha(0);
                    bullet1_2.position_effect();

                    enemy_bullet2.position(313, 486);
                    enemy_bullet2.setObstacleAlpha(0);
                    enemy_bullet2.position_effect();
                    enemy_shot[1]=0;

                }
            }
        }

        if(enemy_shot[1]==1)
        {
            if((bullet1_3.position_x + bullet1_3.resized_width/4 - enemy_bullet2.position_x)*(bullet1_3.position_x + bullet1_3.resized_width/4- enemy_bullet2.position_x) < bullet1_3.resized_width/2*bullet1_3.resized_width/2)
            {
                if((bullet1_3.position_y + bullet1_3.resized_height/4- enemy_bullet2.position_y)*(bullet1_3.position_y +  bullet1_3.resized_height/4 - enemy_bullet2.position_y) <  bullet1_3.resized_height/2* bullet1_3.resized_height/2)
                {
                    bullet[2] = 0;
                    bullet1_3.position(10, 10);
                    bullet1_3.setObstacleAlpha(0);
                    bullet1_3.position_effect();

                    enemy_bullet2.position(313, 486);
                    enemy_bullet2.setObstacleAlpha(0);
                    enemy_bullet2.position_effect();
                    enemy_shot[1]=0;

                }
            }
        }

        if(enemy_shot[2]==1)
        {
            if((bullet1_1.position_x + bullet1_1.resized_width/4- enemy_bullet3.position_x)*(bullet1_1.position_x + bullet1_1.resized_width/4- enemy_bullet3.position_x) < bullet1_1.resized_width/2*bullet1_1.resized_width/2)
            {
                if((bullet1_1.position_y + bullet1_1.resized_height/4- enemy_bullet3.position_y)*(bullet1_1.position_y + bullet1_1.resized_height/4- enemy_bullet3.position_y) < bullet1_1.resized_height/2*bullet1_1.resized_height/2)
                {
                    bullet[0] = 0;
                    bullet1_1.position(10, 10);
                    bullet1_1.setObstacleAlpha(0);
                    bullet1_1.position_effect();

                    enemy_bullet3.position(313, 486);
                    enemy_bullet3.setObstacleAlpha(0);
                    enemy_bullet3.position_effect();
                    enemy_shot[2]=0;

                }
            }
        }

        if(enemy_shot[2]==1)
        {
            if((bullet1_2.position_x + bullet1_2.resized_width/4- enemy_bullet3.position_x)*(bullet1_2.position_x + bullet1_2.resized_width/4 - enemy_bullet3.position_x) < bullet1_2.resized_width/2*bullet1_2.resized_width/2)
            {
                if((bullet1_2.position_y + bullet1_2.resized_height/4 - enemy_bullet3.position_y)*(bullet1_2.position_y + bullet1_2.resized_height/4- enemy_bullet3.position_y) < bullet1_2.resized_height/2*bullet1_2.resized_height/2)
                {
                    bullet[1] = 0;
                    bullet1_2.position(10, 10);
                    bullet1_2.setObstacleAlpha(0);
                    bullet1_2.position_effect();

                    enemy_bullet3.position(313, 486);
                    enemy_bullet3.setObstacleAlpha(0);
                    enemy_bullet3.position_effect();
                    enemy_shot[2]=0;

                }
            }
        }

        if(enemy_shot[2]==1)
        {
            if((bullet1_3.position_x + bullet1_3.resized_width/4- enemy_bullet3.position_x)*(bullet1_3.position_x + bullet1_3.resized_width/4- enemy_bullet3.position_x) < bullet1_3.resized_width/2*bullet1_3.resized_width/2)
            {
                if((bullet1_3.position_y + bullet1_3.resized_height/4 - enemy_bullet3.position_y)*(bullet1_3.position_y + bullet1_3.resized_height/4- enemy_bullet3.position_y) < bullet1_3.resized_height/2*bullet1_3.resized_height/2)
                {
                    bullet[2] = 0;
                    bullet1_3.position(10, 10);
                    bullet1_3.setObstacleAlpha(0);
                    bullet1_3.position_effect();

                    enemy_bullet3.position(313, 486);
                    enemy_bullet3.setObstacleAlpha(0);
                    enemy_bullet3.position_effect();
                    enemy_shot[2]=0;

                }
            }
        }

        if(enemy_shot[3]==1)
        {
            if((bullet1_1.position_x + bullet1_1.resized_width/4- enemy_bullet4.position_x)*(bullet1_1.position_x + bullet1_1.resized_width/4- enemy_bullet4.position_x) < bullet1_1.resized_width/2*bullet1_1.resized_width/2)
            {
                if((bullet1_1.position_y + bullet1_1.resized_height/4- enemy_bullet4.position_y)*(bullet1_1.position_y + bullet1_1.resized_height/4 - enemy_bullet4.position_y) < bullet1_1.resized_height/2*bullet1_1.resized_height/2)
                {
                    bullet[0] = 0;
                    bullet1_1.position(10, 10);
                    bullet1_1.setObstacleAlpha(0);
                    bullet1_1.position_effect();

                    enemy_bullet4.position(313, 486);
                    enemy_bullet4.setObstacleAlpha(0);
                    enemy_bullet4.position_effect();
                    enemy_shot[3]=0;

                }
            }
        }

        if(enemy_shot[3]==1)
        {
            if((bullet1_2.position_x + bullet1_2.resized_width/4- enemy_bullet4.position_x)*(bullet1_2.position_x + bullet1_2.resized_width/4- enemy_bullet4.position_x) < bullet1_2.resized_width/2*bullet1_2.resized_width/2)
            {
                if((bullet1_2.position_y + bullet1_2.resized_height/4- enemy_bullet4.position_y)*(bullet1_2.position_y + bullet1_2.resized_height/4- enemy_bullet4.position_y) < bullet1_2.resized_height/2*bullet1_2.resized_height/2)
                {
                    bullet[1] = 0;
                    bullet1_2.position(10, 10);
                    bullet1_2.setObstacleAlpha(0);
                    bullet1_2.position_effect();

                    enemy_bullet4.position(313, 486);
                    enemy_bullet4.setObstacleAlpha(0);
                    enemy_bullet4.position_effect();
                    enemy_shot[3]=0;

                }
            }
        }

        if(enemy_shot[3]==1)
        {
            if((bullet1_3.position_x + bullet1_3.resized_width/4 - enemy_bullet4.position_x)*(bullet1_3.position_x + bullet1_3.resized_width/4- enemy_bullet4.position_x) < bullet1_3.resized_width/2*bullet1_3.resized_width/2)
            {
                if((bullet1_3.position_y + bullet1_3.resized_height/4- enemy_bullet4.position_y)*(bullet1_3.position_y + bullet1_3.resized_height/4- enemy_bullet4.position_y) < bullet1_3.resized_height/2*bullet1_3.resized_height/2)
                {
                    bullet[2] = 0;
                    bullet1_3.position(10, 10);
                    bullet1_3.setObstacleAlpha(0);
                    bullet1_3.position_effect();

                    enemy_bullet4.position(313, 486);
                    enemy_bullet4.setObstacleAlpha(0);
                    enemy_bullet4.position_effect();
                    enemy_shot[3]=0;

                }
            }
        }

        if(enemy_shot[4]==1)
        {
            if((bullet1_1.position_x + bullet1_1.resized_width/4- enemy_bullet5.position_x)*(bullet1_1.position_x + bullet1_1.resized_width/4- enemy_bullet5.position_x) < bullet1_1.resized_width/2*bullet1_1.resized_width/2)
            {
                if((bullet1_1.position_y + bullet1_1.resized_height/4- enemy_bullet5.position_y)*(bullet1_1.position_y + bullet1_1.resized_height/4- enemy_bullet5.position_y) < bullet1_1.resized_height/2*bullet1_1.resized_height/2)
                {
                    bullet[0] = 0;
                    bullet1_1.position(10, 10);
                    bullet1_1.setObstacleAlpha(0);
                    bullet1_1.position_effect();

                    enemy_bullet5.position(313, 486);
                    enemy_bullet5.setObstacleAlpha(0);
                    enemy_bullet5.position_effect();
                    enemy_shot[4]=0;

                }
            }
        }

        if(enemy_shot[4]==1)
        {
            if((bullet1_2.position_x + bullet1_2.resized_width/4- enemy_bullet5.position_x)*(bullet1_2.position_x + bullet1_2.resized_width/4- enemy_bullet5.position_x) < bullet1_2.resized_width/2*bullet1_2.resized_width/2)
            {
                if((bullet1_2.position_y + bullet1_2.resized_height/4- enemy_bullet5.position_y)*(bullet1_2.position_y + bullet1_2.resized_height/4 - enemy_bullet5.position_y) < bullet1_2.resized_height/2*bullet1_2.resized_height/2)
                {
                    bullet[1] = 0;
                    bullet1_2.position(10, 10);
                    bullet1_2.setObstacleAlpha(0);
                    bullet1_2.position_effect();

                    enemy_bullet5.position(313, 486);
                    enemy_bullet5.setObstacleAlpha(0);
                    enemy_bullet5.position_effect();
                    enemy_shot[4]=0;

                }
            }
        }

        if(enemy_shot[4]==1)
        {
            if((bullet1_3.position_x + bullet1_3.resized_width/4- enemy_bullet5.position_x)*(bullet1_3.position_x + bullet1_3.resized_width/4- enemy_bullet5.position_x) < bullet1_3.resized_width/2*bullet1_3.resized_width/2)
            {
                if((bullet1_3.position_y + bullet1_3.resized_height/4- enemy_bullet5.position_y)*(bullet1_3.position_y + bullet1_3.resized_height/4 - enemy_bullet5.position_y) < bullet1_3.resized_height/2*bullet1_3.resized_height/2)
                {
                    bullet[2] = 0;
                    bullet1_3.position(10, 10);
                    bullet1_3.setObstacleAlpha(0);
                    bullet1_3.position_effect();

                    enemy_bullet5.position(313, 486);
                    enemy_bullet5.setObstacleAlpha(0);
                    enemy_bullet5.position_effect();
                    enemy_shot[4]=0;

                }
            }
        }

        if(enemy_shot[5]==1)
        {
            if((bullet1_1.position_x + bullet1_1.resized_width/4- enemy_bullet6.position_x)*(bullet1_1.position_x + bullet1_1.resized_width/4- enemy_bullet6.position_x) < bullet1_1.resized_width/2*bullet1_1.resized_width/2)
            {
                if((bullet1_1.position_y + bullet1_1.resized_height/4- enemy_bullet6.position_y)*(bullet1_1.position_y + bullet1_1.resized_height/4- enemy_bullet6.position_y) < bullet1_1.resized_height/2*bullet1_1.resized_height/2)
                {
                    bullet[0] = 0;
                    bullet1_1.position(10, 10);
                    bullet1_1.setObstacleAlpha(0);
                    bullet1_1.position_effect();

                    enemy_bullet6.position(313, 486);
                    enemy_bullet6.setObstacleAlpha(0);
                    enemy_bullet6.position_effect();
                    enemy_shot[5]=0;

                }
            }
        }

        if(enemy_shot[5]==1)
        {
            if((bullet1_2.position_x + bullet1_2.resized_width/4 - enemy_bullet6.position_x)*(bullet1_2.position_x + bullet1_2.resized_width/4- enemy_bullet6.position_x) < bullet1_2.resized_width/2*bullet1_2.resized_width/2)
            {
                if((bullet1_2.position_y + bullet1_2.resized_height/4 - enemy_bullet6.position_y)*(bullet1_2.position_y + bullet1_2.resized_height/4 - enemy_bullet6.position_y) < bullet1_2.resized_height/2*bullet1_2.resized_height/2)
                {
                    bullet[1] = 0;
                    bullet1_2.position(10, 10);
                    bullet1_2.setObstacleAlpha(0);
                    bullet1_2.position_effect();

                    enemy_bullet6.position(313, 486);
                    enemy_bullet6.setObstacleAlpha(0);
                    enemy_bullet6.position_effect();
                    enemy_shot[5]=0;

                }
            }
        }

        if(enemy_shot[5]==1)
        {
            if((bullet1_3.position_x + bullet1_3.resized_width/4- enemy_bullet6.position_x)*(bullet1_3.position_x +bullet1_3.resized_width/4- enemy_bullet6.position_x) <bullet1_3.resized_width/2*bullet1_3.resized_width/2)
            {
                if((bullet1_3.position_y + bullet1_3.resized_height/4- enemy_bullet6.position_y)*(bullet1_3.position_y + bullet1_3.resized_height/4 - enemy_bullet6.position_y) < bullet1_3.resized_height/2*bullet1_3.resized_height/2)
                {
                    bullet[2] = 0;
                    bullet1_3.position(10, 10);
                    bullet1_3.setObstacleAlpha(0);
                    bullet1_3.position_effect();

                    enemy_bullet6.position(313, 486);
                    enemy_bullet6.setObstacleAlpha(0);
                    enemy_bullet6.position_effect();
                    enemy_shot[5]=0;

                }
            }
        }

        if(enemy_shot[6]==1)
        {
            if((bullet1_1.position_x + bullet1_1.resized_width/4- enemy_bullet7.position_x)*(bullet1_1.position_x + bullet1_1.resized_width/4 - enemy_bullet7.position_x) < bullet1_1.resized_width/2*bullet1_1.resized_width/2)
            {
                if((bullet1_1.position_y + bullet1_1.resized_height/4- enemy_bullet7.position_y)*(bullet1_1.position_y + bullet1_1.resized_height/4- enemy_bullet7.position_y) < bullet1_1.resized_height/2*bullet1_1.resized_height/2)
                {
                    bullet[0] = 0;
                    bullet1_1.position(10, 10);
                    bullet1_1.setObstacleAlpha(0);
                    bullet1_1.position_effect();

                    enemy_bullet7.position(313, 486);
                    enemy_bullet7.setObstacleAlpha(0);
                    enemy_bullet7.position_effect();
                    enemy_shot[6]=0;

                }
            }
        }

        if(enemy_shot[6]==1)
        {
            if((bullet1_2.position_x + bullet1_2.resized_width/4- enemy_bullet7.position_x)*(bullet1_2.position_x +bullet1_2.resized_width/4 - enemy_bullet7.position_x) < bullet1_2.resized_width/2*bullet1_2.resized_width/2)
            {
                if((bullet1_2.position_y + bullet1_2.resized_height/4 - enemy_bullet7.position_y)*(bullet1_2.position_y  +bullet1_2.resized_height/4- enemy_bullet7.position_y) < bullet1_2.resized_height/2*bullet1_2.resized_height/2)
                {
                    bullet[1] = 0;
                    bullet1_2.position(10, 10);
                    bullet1_2.setObstacleAlpha(0);
                    bullet1_2.position_effect();

                    enemy_bullet7.position(313, 486);
                    enemy_bullet7.setObstacleAlpha(0);
                    enemy_bullet7.position_effect();
                    enemy_shot[6]=0;

                }
            }
        }

        if(enemy_shot[6]==1)
        {
            if((bullet1_3.position_x + bullet1_3.resized_width/4- enemy_bullet7.position_x)*(bullet1_3.position_x + bullet1_3.resized_width/4- enemy_bullet7.position_x) < bullet1_3.resized_width/2*bullet1_3.resized_width/2)
            {
                if((bullet1_3.position_y + bullet1_3.resized_height/4 - enemy_bullet7.position_y)*(bullet1_3.position_y  +bullet1_3.resized_height/4- enemy_bullet7.position_y) < bullet1_3.resized_height/2*bullet1_3.resized_height/2)
                {
                    bullet[2] = 0;
                    bullet1_3.position(10, 10);
                    bullet1_3.setObstacleAlpha(0);
                    bullet1_3.position_effect();

                    enemy_bullet7.position(313, 486);
                    enemy_bullet7.setObstacleAlpha(0);
                    enemy_bullet7.position_effect();
                    enemy_shot[6]=0;

                }
            }
        }

        if(enemy_shot[7]==1)
        {
            if((bullet1_1.position_x + bullet1_1.resized_width/4- enemy_bullet8.position_x)*(bullet1_1.position_x + bullet1_1.resized_width/4- enemy_bullet8.position_x) < bullet1_1.resized_width/2*bullet1_1.resized_width/2)
            {
                if((bullet1_1.position_y + bullet1_1.resized_height/4- enemy_bullet8.position_y)*(bullet1_1.position_y + bullet1_1.resized_height/4- enemy_bullet8.position_y) < bullet1_1.resized_height/2*bullet1_1.resized_height/2)
                {
                    bullet[0] = 0;
                    bullet1_1.position(10, 10);
                    bullet1_1.setObstacleAlpha(0);
                    bullet1_1.position_effect();

                    enemy_bullet8.position(313, 486);
                    enemy_bullet8.setObstacleAlpha(0);
                    enemy_bullet8.position_effect();
                    enemy_shot[7]=0;

                }
            }
        }

        if(enemy_shot[7]==1)
        {
            if((bullet1_2.position_x + bullet1_2.resized_width/4- enemy_bullet8.position_x)*(bullet1_2.position_x + bullet1_2.resized_width/4- enemy_bullet8.position_x) < bullet1_2.resized_width/2*bullet1_2.resized_width/2)
            {
                if((bullet1_2.position_y + bullet1_2.resized_height/4- enemy_bullet8.position_y)*(bullet1_2.position_y + bullet1_2.resized_height/4- enemy_bullet8.position_y) < bullet1_2.resized_height/2*bullet1_2.resized_height/2)
                {
                    bullet[1] = 0;
                    bullet1_2.position(10, 10);
                    bullet1_2.setObstacleAlpha(0);
                    bullet1_2.position_effect();

                    enemy_bullet8.position(313, 486);
                    enemy_bullet8.setObstacleAlpha(0);
                    enemy_bullet8.position_effect();
                    enemy_shot[7]=0;

                }
            }
        }

        if(enemy_shot[7]==1)
        {
            if((bullet1_3.position_x + bullet1_3.resized_width/4 - enemy_bullet8.position_x)*(bullet1_3.position_x +bullet1_3.resized_width/4- enemy_bullet8.position_x) <bullet1_3.resized_width/2*bullet1_3.resized_width/2)
            {
                if((bullet1_3.position_y + bullet1_3.resized_height/4- enemy_bullet8.position_y)*(bullet1_3.position_y + bullet1_3.resized_height/4- enemy_bullet8.position_y) < bullet1_3.resized_height/2*bullet1_3.resized_height/2)
                {
                    bullet[2] = 0;
                    bullet1_3.position(10, 10);
                    bullet1_3.setObstacleAlpha(0);
                    bullet1_3.position_effect();

                    enemy_bullet8.position(313, 486);
                    enemy_bullet8.setObstacleAlpha(0);
                    enemy_bullet8.position_effect();
                    enemy_shot[7]=0;

                }
            }
        }

        if(enemy_shot[8]==1)
        {
            if((bullet1_1.position_x + bullet1_1.resized_width/4- enemy_bullet9.position_x)*(bullet1_1.position_x + bullet1_1.resized_width/4- enemy_bullet9.position_x) < bullet1_1.resized_width/2*bullet1_1.resized_width/2)
            {
                if((bullet1_1.position_y +bullet1_1.resized_height/4- enemy_bullet9.position_y)*(bullet1_1.position_y +bullet1_1.resized_height/4- enemy_bullet9.position_y) < bullet1_1.resized_height/2*bullet1_1.resized_height/2)
                {
                    bullet[0] = 0;
                    bullet1_1.position(10, 10);
                    bullet1_1.setObstacleAlpha(0);
                    bullet1_1.position_effect();

                    enemy_bullet9.position(313, 486);
                    enemy_bullet9.setObstacleAlpha(0);
                    enemy_bullet9.position_effect();
                    enemy_shot[8]=0;

                }
            }
        }

        if(enemy_shot[8]==1)
        {
            if((bullet1_2.position_x + bullet1_2.resized_width/4- enemy_bullet9.position_x)*(bullet1_2.position_x + bullet1_2.resized_width/4- enemy_bullet9.position_x) < bullet1_2.resized_width/2*bullet1_2.resized_width/2)
            {
                if((bullet1_2.position_y + bullet1_2.resized_height/4- enemy_bullet9.position_y)*(bullet1_2.position_y +bullet1_2.resized_height/4 - enemy_bullet9.position_y) < bullet1_2.resized_height/2*bullet1_2.resized_height/2)
                {
                    bullet[1] = 0;
                    bullet1_2.position(10, 10);
                    bullet1_2.setObstacleAlpha(0);
                    bullet1_2.position_effect();

                    enemy_bullet9.position(313, 486);
                    enemy_bullet9.setObstacleAlpha(0);
                    enemy_bullet9.position_effect();
                    enemy_shot[8]=0;

                }
            }
        }

        if(enemy_shot[8]==1)
        {
            if((bullet1_3.position_x + bullet1_3.resized_width/4 - enemy_bullet9.position_x)*(bullet1_3.position_x + bullet1_3.resized_width/4- enemy_bullet9.position_x) < bullet1_3.resized_width/2*bullet1_3.resized_width/2)
            {
                if((bullet1_3.position_y + bullet1_3.resized_height/4 - enemy_bullet9.position_y)*(bullet1_3.position_y + bullet1_3.resized_height/4- enemy_bullet9.position_y) < bullet1_3.resized_height/2*bullet1_3.resized_height/2)
                {
                    bullet[2] = 0;
                    bullet1_3.position(10, 10);
                    bullet1_3.setObstacleAlpha(0);
                    bullet1_3.position_effect();

                    enemy_bullet9.position(313, 486);
                    enemy_bullet9.setObstacleAlpha(0);
                    enemy_bullet9.position_effect();
                    enemy_shot[8]=0;

                }
            }
        }


        if(enemy_shot[9]==1)
        {
            if((bullet1_1.position_x + bullet1_1.resized_width/4- enemy_bullet10.position_x)*(bullet1_1.position_x + bullet1_1.resized_width/4- enemy_bullet10.position_x) < bullet1_1.resized_width/2*bullet1_1.resized_width/2)
            {
                if((bullet1_1.position_y + bullet1_1.resized_height/4 - enemy_bullet10.position_y)*(bullet1_1.position_y + bullet1_1.resized_height/4- enemy_bullet10.position_y) < bullet1_1.resized_height/2*bullet1_1.resized_height/2)
                {
                    bullet[0] = 0;
                    bullet1_1.position(10, 10);
                    bullet1_1.setObstacleAlpha(0);
                    bullet1_1.position_effect();

                    enemy_bullet10.position(313, 486);
                    enemy_bullet10.setObstacleAlpha(0);
                    enemy_bullet10.position_effect();
                    enemy_shot[9]=0;

                }
            }
        }


        if(enemy_shot[9]==1)
        {
            if((bullet1_2.position_x + bullet1_2.resized_width/4- enemy_bullet10.position_x)*(bullet1_2.position_x + bullet1_2.resized_width/4- enemy_bullet10.position_x) < bullet1_2.resized_width/2*bullet1_2.resized_width/2)
            {
                if((bullet1_2.position_y + bullet1_2.resized_height/4- enemy_bullet10.position_y)*(bullet1_2.position_y +  bullet1_2.resized_height/4- enemy_bullet10.position_y) <  bullet1_2.resized_height/2* bullet1_2.resized_height/2)
                {
                    bullet[1] = 0;
                    bullet1_2.position(10, 10);
                    bullet1_2.setObstacleAlpha(0);
                    bullet1_2.position_effect();

                    enemy_bullet10.position(313, 486);
                    enemy_bullet10.setObstacleAlpha(0);
                    enemy_bullet10.position_effect();
                    enemy_shot[9]=0;

                }
            }
        }

        if(enemy_shot[9]==1)
        {
            if((bullet1_3.position_x + bullet1_3.resized_width/4- enemy_bullet10.position_x)*(bullet1_3.position_x + bullet1_3.resized_width/4- enemy_bullet10.position_x) < bullet1_3.resized_width/2*bullet1_3.resized_width/2)
            {
                if((bullet1_3.position_y + bullet1_3.resized_height/4 - enemy_bullet10.position_y)*(bullet1_3.position_y + bullet1_3.resized_height/4- enemy_bullet10.position_y) < bullet1_3.resized_height/2*bullet1_3.resized_height/2)
                {
                    bullet[2] = 0;
                    bullet1_3.position(10, 10);
                    bullet1_3.setObstacleAlpha(0);
                    bullet1_3.position_effect();

                    enemy_bullet10.position(313, 486);
                    enemy_bullet10.setObstacleAlpha(0);
                    enemy_bullet10.position_effect();
                    enemy_shot[9]=0;

                }
            }
        }

        if(enemy_shot[10]==1)
        {
            if((bullet1_1.position_x + bullet1_1.resized_width/4- enemy_bullet11.position_x)*(bullet1_1.position_x +bullet1_1.resized_width/4 - enemy_bullet11.position_x) < bullet1_1.resized_width/2*bullet1_1.resized_width/2)
            {
                if((bullet1_1.position_y + bullet1_1.resized_height/4- enemy_bullet11.position_y)*(bullet1_1.position_y + bullet1_1.resized_height/4 - enemy_bullet11.position_y) < bullet1_1.resized_height/2*bullet1_1.resized_height/2)
                {
                    bullet[0] = 0;
                    bullet1_1.position(10, 10);
                    bullet1_1.setObstacleAlpha(0);
                    bullet1_1.position_effect();

                    enemy_bullet11.position(313, 486);
                    enemy_bullet11.setObstacleAlpha(0);
                    enemy_bullet11.position_effect();
                    enemy_shot[10]=0;

                }
            }
        }

        if(enemy_shot[10]==1)
        {
            if((bullet1_2.position_x + bullet1_2.resized_width/4- enemy_bullet11.position_x)*(bullet1_2.position_x + bullet1_2.resized_width/4- enemy_bullet11.position_x) < bullet1_2.resized_width/2*bullet1_2.resized_width/2)
            {
                if((bullet1_2.position_y + bullet1_2.resized_height/4- enemy_bullet11.position_y)*(bullet1_2.position_y + bullet1_2.resized_height/4- enemy_bullet11.position_y) < bullet1_2.resized_height/2*bullet1_2.resized_height/2)
                {
                    bullet[1] = 0;
                    bullet1_2.position(10, 10);
                    bullet1_2.setObstacleAlpha(0);
                    bullet1_2.position_effect();

                    enemy_bullet11.position(313, 486);
                    enemy_bullet11.setObstacleAlpha(0);
                    enemy_bullet11.position_effect();
                    enemy_shot[10]=0;

                }
            }
        }

        if(enemy_shot[10]==1)
        {
            if((bullet1_3.position_x + bullet1_3.resized_width/4- enemy_bullet11.position_x)*(bullet1_3.position_x + bullet1_3.resized_width/4- enemy_bullet11.position_x) <bullet1_3.resized_width/2*bullet1_3.resized_width/2)
            {
                if((bullet1_3.position_y + bullet1_3.resized_height/4 - enemy_bullet11.position_y)*(bullet1_3.position_y +  bullet1_3.resized_height/4 - enemy_bullet11.position_y) <  bullet1_3.resized_height/2* bullet1_3.resized_height/2)
                {
                    bullet[2] = 0;
                    bullet1_3.position(10, 10);
                    bullet1_3.setObstacleAlpha(0);
                    bullet1_3.position_effect();

                    enemy_bullet11.position(313, 486);
                    enemy_bullet11.setObstacleAlpha(0);
                    enemy_bullet11.position_effect();
                    enemy_shot[10]=0;

                }
            }
        }

        if(enemy_shot[11]==1)
        {
            if((bullet1_1.position_x + bullet1_1.resized_width/4 - enemy_bullet12.position_x)*(bullet1_1.position_x + bullet1_1.resized_width/4 - enemy_bullet12.position_x) < bullet1_1.resized_width/2*bullet1_1.resized_width/2)
            {
                if((bullet1_1.position_y + bullet1_1.resized_height/4- enemy_bullet12.position_y)*(bullet1_1.position_y + bullet1_1.resized_height/4 - enemy_bullet12.position_y) < bullet1_1.resized_height/2*bullet1_1.resized_height/2)
                {
                    bullet[0] = 0;
                    bullet1_1.position(10, 10);
                    bullet1_1.setObstacleAlpha(0);
                    bullet1_1.position_effect();

                    enemy_bullet12.position(313, 486);
                    enemy_bullet12.setObstacleAlpha(0);
                    enemy_bullet12.position_effect();
                    enemy_shot[11]=0;

                }
            }
        }

        if(enemy_shot[11]==1)
        {
            if((bullet1_2.position_x + bullet1_2.resized_width/4- enemy_bullet12.position_x)*(bullet1_2.position_x + bullet1_2.resized_width/4- enemy_bullet12.position_x) < bullet1_2.resized_width/2*bullet1_2.resized_width/2)
            {
                if((bullet1_2.position_y + bullet1_2.resized_height/4- enemy_bullet12.position_y)*(bullet1_2.position_y + bullet1_2.resized_height/4- enemy_bullet12.position_y) < bullet1_2.resized_height/2*bullet1_2.resized_height/2)
                {
                    bullet[1] = 0;
                    bullet1_2.position(10, 10);
                    bullet1_2.setObstacleAlpha(0);
                    bullet1_2.position_effect();

                    enemy_bullet12.position(313, 486);
                    enemy_bullet12.setObstacleAlpha(0);
                    enemy_bullet12.position_effect();
                    enemy_shot[11]=0;

                }
            }
        }

        if(enemy_shot[11]==1)
        {
            if((bullet1_3.position_x + bullet1_3.resized_width/4- enemy_bullet12.position_x)*(bullet1_3.position_x +  bullet1_3.resized_width/4- enemy_bullet12.position_x) <  bullet1_3.resized_width/2* bullet1_3.resized_width/2)
            {
                if((bullet1_3.position_y +  bullet1_3.resized_height/4 - enemy_bullet12.position_y)*(bullet1_3.position_y + bullet1_3.resized_height/4- enemy_bullet12.position_y) < bullet1_3.resized_height/2*bullet1_3.resized_height/2)
                {
                    bullet[2] = 0;
                    bullet1_3.position(10, 10);
                    bullet1_3.setObstacleAlpha(0);
                    bullet1_3.position_effect();

                    enemy_bullet12.position(313, 486);
                    enemy_bullet12.setObstacleAlpha(0);
                    enemy_bullet12.position_effect();
                    enemy_shot[11]=0;

                }
            }
        }

        if(enemy_shot[12]==1)
        {
            if((bullet1_1.position_x+ bullet1_1.resized_width/4 - enemy_bullet13.position_x)*(bullet1_1.position_x + bullet1_1.resized_width/4- enemy_bullet13.position_x) < bullet1_1.resized_width/2*bullet1_1.resized_width/2)
            {
                if((bullet1_1.position_y + bullet1_1.resized_height/4- enemy_bullet13.position_y)*(bullet1_1.position_y + bullet1_1.resized_height/4- enemy_bullet13.position_y) < bullet1_1.resized_height/2*bullet1_1.resized_height/2)
                {
                    bullet[0] = 0;
                    bullet1_1.position(10, 10);
                    bullet1_1.setObstacleAlpha(0);
                    bullet1_1.position_effect();

                    enemy_bullet13.position(313, 486);
                    enemy_bullet13.setObstacleAlpha(0);
                    enemy_bullet13.position_effect();
                    enemy_shot[12]=0;

                }
            }
        }


        if(enemy_shot[12]==1)
        {
            if((bullet1_2.position_x + bullet1_2.resized_width/4 - enemy_bullet13.position_x)*(bullet1_2.position_x + bullet1_2.resized_width/4- enemy_bullet13.position_x) < bullet1_2.resized_width/2*bullet1_2.resized_width/2)
            {
                if((bullet1_2.position_y + bullet1_2.resized_height/4 - enemy_bullet13.position_y)*(bullet1_2.position_y + bullet1_2.resized_height/4- enemy_bullet13.position_y) < bullet1_2.resized_height/2*bullet1_2.resized_height/2)
                {
                    bullet[1] = 0;
                    bullet1_2.position(10, 10);
                    bullet1_2.setObstacleAlpha(0);
                    bullet1_2.position_effect();

                    enemy_bullet13.position(313, 486);
                    enemy_bullet13.setObstacleAlpha(0);
                    enemy_bullet13.position_effect();
                    enemy_shot[12]=0;

                }
            }
        }

        if(enemy_shot[12]==1)
        {
            if((bullet1_3.position_x + bullet1_3.resized_width/4- enemy_bullet13.position_x)*(bullet1_3.position_x +  bullet1_3.resized_width/4 - enemy_bullet13.position_x) <  bullet1_3.resized_width/2 * bullet1_3.resized_width/2)
            {
                if((bullet1_3.position_y + bullet1_3.resized_height/4 - enemy_bullet13.position_y)*(bullet1_3.position_y + bullet1_3.resized_height/4 - enemy_bullet13.position_y) < bullet1_3.resized_height/2*bullet1_3.resized_height/2)
                {
                    bullet[2] = 0;
                    bullet1_3.position(10, 10);
                    bullet1_3.setObstacleAlpha(0);
                    bullet1_3.position_effect();

                    enemy_bullet13.position(313, 486);
                    enemy_bullet13.setObstacleAlpha(0);
                    enemy_bullet13.position_effect();
                    enemy_shot[12]=0;

                }
            }
        }

        if(enemy_shot[13]==1)
        {
            if((bullet1_1.position_x + bullet1_1.resized_width/4 - enemy_bullet14.position_x)*(bullet1_1.position_x + bullet1_1.resized_width/4- enemy_bullet14.position_x) <bullet1_1.resized_width/2*bullet1_1.resized_width/2)
            {
                if((bullet1_1.position_y + bullet1_1.resized_height/4 - enemy_bullet14.position_y)*(bullet1_1.position_y + bullet1_1.resized_height/4- enemy_bullet14.position_y) < bullet1_1.resized_height/2*bullet1_1.resized_height/2)
                {
                    bullet[0] = 0;
                    bullet1_1.position(10, 10);
                    bullet1_1.setObstacleAlpha(0);
                    bullet1_1.position_effect();

                    enemy_bullet14.position(313, 486);
                    enemy_bullet14.setObstacleAlpha(0);
                    enemy_bullet14.position_effect();
                    enemy_shot[13]=0;

                }
            }
        }

        if(enemy_shot[13]==1)
        {
            if((bullet1_2.position_x + bullet1_2.resized_width/4- enemy_bullet14.position_x)*(bullet1_2.position_x + bullet1_2.resized_width/4 - enemy_bullet14.position_x) < bullet1_2.resized_width/2*bullet1_2.resized_width/2)
            {
                if((bullet1_2.position_y + bullet1_2.resized_height/4- enemy_bullet14.position_y)*(bullet1_2.position_y + bullet1_2.resized_height/4 - enemy_bullet14.position_y) <bullet1_2.resized_height/2*bullet1_2.resized_height/2)
                {
                    bullet[1] = 0;
                    bullet1_2.position(10, 10);
                    bullet1_2.setObstacleAlpha(0);
                    bullet1_2.position_effect();

                    enemy_bullet14.position(313, 486);
                    enemy_bullet14.setObstacleAlpha(0);
                    enemy_bullet14.position_effect();
                    enemy_shot[13]=0;

                }
            }
        }

        if(enemy_shot[13]==1)
        {
            if((bullet1_3.position_x +bullet1_3.resized_width/4 - enemy_bullet14.position_x)*(bullet1_3.position_x + bullet1_3.resized_width/4- enemy_bullet14.position_x) < bullet1_3.resized_width/2*bullet1_3.resized_width/2)
            {
                if((bullet1_3.position_y + bullet1_3.resized_height/4- enemy_bullet14.position_y)*(bullet1_3.position_y + bullet1_3.resized_height/4- enemy_bullet14.position_y) < bullet1_3.resized_height/2*bullet1_3.resized_height/2)
                {
                    bullet[2] = 0;
                    bullet1_3.position(10, 10);
                    bullet1_3.setObstacleAlpha(0);
                    bullet1_3.position_effect();

                    enemy_bullet14.position(313, 486);
                    enemy_bullet14.setObstacleAlpha(0);
                    enemy_bullet14.position_effect();
                    enemy_shot[13]=0;

                }
            }
        }

        if(enemy_shot[14]==1) {
            if ((bullet1_1.position_x + bullet1_1.resized_width/4- enemy_bullet15.position_x) * (bullet1_1.position_x + bullet1_1.resized_width/4 - enemy_bullet15.position_x) < bullet1_1.resized_width/2 * bullet1_1.resized_width/2) {
                if ((bullet1_1.position_y + bullet1_1.resized_height/4- enemy_bullet15.position_y) * (bullet1_1.position_y +bullet1_1.resized_height/4- enemy_bullet15.position_y) < bullet1_1.resized_height/2 * bullet1_1.resized_height/2) {
                    bullet[0] = 0;
                    bullet1_1.position(10, 10);
                    bullet1_1.setObstacleAlpha(0);
                    bullet1_1.position_effect();

                    enemy_bullet15.position(313, 486);
                    enemy_bullet15.setObstacleAlpha(0);
                    enemy_bullet15.position_effect();
                    enemy_shot[14] = 0;

                }
            }
        }

        if(enemy_shot[14]==1) {
            if ((bullet1_2.position_x +  bullet1_2.resized_width/4 - enemy_bullet15.position_x) * (bullet1_2.position_x + bullet1_2.resized_width/4 - enemy_bullet15.position_x) < bullet1_2.resized_width/2 *bullet1_2.resized_width/2) {
                if ((bullet1_2.position_y + bullet1_2.resized_height/4- enemy_bullet15.position_y) * (bullet1_2.position_y + bullet1_2.resized_height/4 - enemy_bullet15.position_y) < bullet1_2.resized_height/2 * bullet1_2.resized_height/2) {
                    bullet[1] = 0;
                    bullet1_2.position(10, 10);
                    bullet1_2.setObstacleAlpha(0);
                    bullet1_2.position_effect();

                    enemy_bullet15.position(313, 486);
                    enemy_bullet15.setObstacleAlpha(0);
                    enemy_bullet15.position_effect();
                    enemy_shot[14] = 0;

                }
            }
        }

        if(enemy_shot[14]==1) {
            if ((bullet1_3.position_x + bullet1_3.resized_width/4- enemy_bullet15.position_x) * (bullet1_3.position_x + bullet1_3.resized_width/4- enemy_bullet15.position_x) < bullet1_3.resized_width/2 * bullet1_3.resized_width/2) {
                if ((bullet1_3.position_y + bullet1_3.resized_height/4 - enemy_bullet15.position_y) * (bullet1_3.position_y + bullet1_3.resized_height/4 - enemy_bullet15.position_y) < bullet1_3.resized_height/2 * bullet1_3.resized_height/2) {
                    bullet[2] = 0;
                    bullet1_3.position(10, 10);
                    bullet1_3.setObstacleAlpha(0);
                    bullet1_3.position_effect();

                    enemy_bullet15.position(313, 486);
                    enemy_bullet15.setObstacleAlpha(0);
                    enemy_bullet15.position_effect();
                    enemy_shot[14] = 0;

                }
            }
        }

        if(enemy_shot[15]==1) {
            if ((bullet1_1.position_x + bullet1_1.resized_width/4 - enemy_bullet16.position_x) * (bullet1_1.position_x + bullet1_1.resized_width/4- enemy_bullet16.position_x) < bullet1_1.resized_width/2 * bullet1_1.resized_width/2) {
                if ((bullet1_1.position_y + bullet1_1.resized_height/4- enemy_bullet16.position_y) * (bullet1_1.position_y + bullet1_1.resized_height/4 - enemy_bullet16.position_y) < bullet1_1.resized_height/2 * bullet1_1.resized_height/2) {
                    bullet[0] = 0;
                    bullet1_1.position(10, 10);
                    bullet1_1.setObstacleAlpha(0);
                    bullet1_1.position_effect();

                    enemy_bullet16.position(313, 486);
                    enemy_bullet16.setObstacleAlpha(0);
                    enemy_bullet16.position_effect();
                    enemy_shot[15] = 0;

                }
            }
        }

        if(enemy_shot[15]==1) {
            if ((bullet1_2.position_x + bullet1_2.resized_width/4 - enemy_bullet16.position_x) * (bullet1_2.position_x + bullet1_2.resized_width/4 - enemy_bullet16.position_x) < bullet1_2.resized_width/2 * bullet1_2.resized_width/2) {
                if ((bullet1_2.position_y + bullet1_2.resized_height/4 - enemy_bullet16.position_y) * (bullet1_2.position_y +  bullet1_2.resized_height/4  - enemy_bullet16.position_y) <  bullet1_2.resized_height/2 *  bullet1_2.resized_height/2) {
                    bullet[1] = 0;
                    bullet1_2.position(10, 10);
                    bullet1_2.setObstacleAlpha(0);
                    bullet1_2.position_effect();

                    enemy_bullet16.position(313, 486);
                    enemy_bullet16.setObstacleAlpha(0);
                    enemy_bullet16.position_effect();
                    enemy_shot[15] = 0;

                }
            }
        }

        if(enemy_shot[15]==1) {
            if ((bullet1_3.position_x + bullet1_3.resized_width/4 - enemy_bullet16.position_x) * (bullet1_3.position_x + bullet1_3.resized_width/4 - enemy_bullet16.position_x) < bullet1_3.resized_width/3 * bullet1_3.resized_width/2) {
                if ((bullet1_3.position_y + bullet1_3.resized_height/4 - enemy_bullet16.position_y) * (bullet1_3.position_y  +  bullet1_3.resized_height/4- enemy_bullet16.position_y) <  bullet1_3.resized_height/2 *  bullet1_3.resized_height/2) {
                    bullet[2] = 0;
                    bullet1_3.position(10, 10);
                    bullet1_3.setObstacleAlpha(0);
                    bullet1_3.position_effect();

                    enemy_bullet16.position(313, 486);
                    enemy_bullet16.setObstacleAlpha(0);
                    enemy_bullet16.position_effect();
                    enemy_shot[15] = 0;

                }
            }
        }

        if ((enemy1_1.position_x + enemy1_1.resized_width/4 - bullet1_1.position_x) * (enemy1_1.position_x +  enemy1_1.resized_width/4 - bullet1_1.position_x) <  enemy1_1.resized_width/2 *  enemy1_1.resized_width/2) {
            if ((enemy1_1.position_y + enemy1_1.resized_height/4 - bullet1_1.position_y) * (enemy1_1.position_y + enemy1_1.resized_height/4- bullet1_1.position_y) < enemy1_1.resized_height/2 * enemy1_1.resized_height/2) {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[0]=0;
                enemy1_1.position(120*size_dm, 125*size_dm);
                enemy1_1.setObstacleAlpha(0);
                enemy1_1.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if((enemy1_1.position_x+enemy1_1.resized_width/4-bullet1_2.position_x)*(enemy1_1.position_x+enemy1_1.resized_width/4-bullet1_2.position_x) < enemy1_1.resized_width/2*enemy1_1.resized_width/2)
        {
            if((enemy1_1.position_y+enemy1_1.resized_height/4-bullet1_2.position_y)*(enemy1_1.position_y+enemy1_1.resized_height/4-bullet1_2.position_y) < enemy1_1.resized_height/2*enemy1_1.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[0]=0;
                enemy1_1.position(120*size_dm, 125*size_dm);
                enemy1_1.setObstacleAlpha(0);
                enemy1_1.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();

            }
        }

        if((enemy1_1.position_x+enemy1_1.resized_width/4-bullet1_3.position_x)*(enemy1_1.position_x+enemy1_1.resized_width/4-bullet1_3.position_x) < enemy1_1.resized_width/2*enemy1_1.resized_width/2)
        {
            if((enemy1_1.position_y+enemy1_1.resized_height/4-bullet1_3.position_y)*(enemy1_1.position_y+enemy1_1.resized_height/4-bullet1_3.position_y) < enemy1_1.resized_height/2*enemy1_1.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[0]=0;
                enemy1_1.position(120*size_dm, 125*size_dm);
                enemy1_1.setObstacleAlpha(0);
                enemy1_1.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();

            }
        }

        if((enemy1_1.position_x+enemy1_1.resized_width/4-bullet1_4.position_x)*(enemy1_1.position_x+enemy1_1.resized_width/4-bullet1_4.position_x) < enemy1_1.resized_width/2*enemy1_1.resized_width/2)
        {
            if((enemy1_1.position_y+enemy1_1.resized_height/4-bullet1_4.position_y)*(enemy1_1.position_y+enemy1_1.resized_height/4-bullet1_4.position_y) < enemy1_1.resized_height/2*enemy1_1.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[0]=0;
                enemy1_1.position(120*size_dm, 125*size_dm);
                enemy1_1.setObstacleAlpha(0);
                enemy1_1.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();

            }
        }

        if((enemy1_1.position_x+enemy1_1.resized_width/4-bullet1_5.position_x)*(enemy1_1.position_x+enemy1_1.resized_width/4-bullet1_5.position_x) < enemy1_1.resized_width/2*enemy1_1.resized_width/2)
        {
            if((enemy1_1.position_y+enemy1_1.resized_height/4-bullet1_5.position_y)*(enemy1_1.position_y+enemy1_1.resized_height/4-bullet1_5.position_y) < enemy1_1.resized_height/2*enemy1_1.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[0]=0;
                enemy1_1.position(120*size_dm, 125*size_dm);
                enemy1_1.setObstacleAlpha(0);
                enemy1_1.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();

            }
        }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        if((enemy1_2.position_x+enemy1_2.resized_width/4-bullet1_1.position_x)*(enemy1_2.position_x+enemy1_2.resized_width/4-bullet1_1.position_x) < enemy1_2.resized_width/2*enemy1_2.resized_width/2)
        {
            if((enemy1_2.position_y+enemy1_2.resized_height/4-bullet1_1.position_y)*(enemy1_2.position_y+enemy1_2.resized_height/4-bullet1_1.position_y) <enemy1_2.resized_height/2*enemy1_2.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[1]=0;
                enemy1_2.position(107*size_dm, 138*size_dm);
                enemy1_2.setObstacleAlpha(0);
                enemy1_2.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();

            }
        }

        if((enemy1_2.position_x+enemy1_2.resized_width/4-bullet1_2.position_x)*(enemy1_2.position_x+enemy1_2.resized_width/4-bullet1_2.position_x) < enemy1_2.resized_width/2*enemy1_2.resized_width/2)
        {
            if((enemy1_2.position_y+enemy1_2.resized_height/4-bullet1_2.position_y)*(enemy1_2.position_y+enemy1_2.resized_height/4-bullet1_2.position_y) <enemy1_2.resized_height/2*enemy1_2.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[1]=0;
                enemy1_2.position(107*size_dm, 138*size_dm);
                enemy1_2.setObstacleAlpha(0);
                enemy1_2.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();

            }
        }

        if((enemy1_2.position_x+enemy1_2.resized_width/4-bullet1_3.position_x)*(enemy1_2.position_x+enemy1_2.resized_width/4-bullet1_3.position_x) < enemy1_2.resized_width/2*enemy1_2.resized_width/2)
        {
            if((enemy1_2.position_y+enemy1_2.resized_height/4-bullet1_3.position_y)*(enemy1_2.position_y+enemy1_2.resized_height/4-bullet1_3.position_y) <enemy1_2.resized_height/2*enemy1_2.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[1]=0;
                enemy1_2.position(107*size_dm, 138*size_dm);
                enemy1_2.setObstacleAlpha(0);
                enemy1_2.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();

            }
        }

        if((enemy1_2.position_x+enemy1_2.resized_width/4-bullet1_4.position_x)*(enemy1_2.position_x+enemy1_2.resized_width/4-bullet1_4.position_x) < enemy1_2.resized_width/2*enemy1_2.resized_width/2)
        {
            if((enemy1_2.position_y+enemy1_2.resized_height/4-bullet1_4.position_y)*(enemy1_2.position_y+enemy1_2.resized_height/4-bullet1_4.position_y) <enemy1_2.resized_height/2*enemy1_2.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[1]=0;
                enemy1_2.position(107*size_dm, 138*size_dm);
                enemy1_2.setObstacleAlpha(0);
                enemy1_2.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();

            }
        }

        if((enemy1_2.position_x+enemy1_2.resized_width/4-bullet1_5.position_x)*(enemy1_2.position_x+enemy1_2.resized_width/4-bullet1_5.position_x) < enemy1_2.resized_width/2*enemy1_2.resized_width/2)
        {
            if((enemy1_2.position_y+enemy1_2.resized_height/4-bullet1_5.position_y)*(enemy1_2.position_y+enemy1_2.resized_height/4-bullet1_5.position_y) <enemy1_2.resized_height/2*enemy1_2.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[1]=0;
                enemy1_2.position(107*size_dm, 138*size_dm);
                enemy1_2.setObstacleAlpha(0);
                enemy1_2.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();

            }
        }

        //////////////////////////////////////////////////////////////////////////////////////////////////////////

        if((enemy1_3.position_x+enemy1_3.resized_width/4-bullet1_1.position_x)*(enemy1_3.position_x+enemy1_3.resized_width/4-bullet1_1.position_x) < enemy1_3.resized_width/2*enemy1_3.resized_width/2)
        {
            if((enemy1_3.position_y+enemy1_3.resized_height/4-bullet1_1.position_y)*(enemy1_3.position_y+enemy1_3.resized_height/4-bullet1_1.position_y) < enemy1_3.resized_height/2*enemy1_3.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[2]=0;
                enemy1_3.position(94*size_dm, 151*size_dm);
                enemy1_3.setObstacleAlpha(0);
                enemy1_3.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if((enemy1_3.position_x+enemy1_3.resized_width/4-bullet1_2.position_x)*(enemy1_3.position_x+enemy1_3.resized_width/4-bullet1_2.position_x) < enemy1_3.resized_width/2*enemy1_3.resized_width/2)
        {
            if((enemy1_3.position_y+enemy1_3.resized_height/4-bullet1_2.position_y)*(enemy1_3.position_y+enemy1_3.resized_height/4-bullet1_2.position_y) < enemy1_3.resized_height/2*enemy1_3.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[2]=0;
                enemy1_3.position(94*size_dm, 151*size_dm);
                enemy1_3.setObstacleAlpha(0);
                enemy1_3.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }

        if((enemy1_3.position_x+enemy1_3.resized_width/4-bullet1_3.position_x)*(enemy1_3.position_x+enemy1_3.resized_width/4-bullet1_3.position_x) < enemy1_3.resized_width/2*enemy1_3.resized_width/2)
        {
            if((enemy1_3.position_y+enemy1_3.resized_height/4-bullet1_3.position_y)*(enemy1_3.position_y+enemy1_3.resized_height/4-bullet1_3.position_y) < enemy1_3.resized_height/2*enemy1_3.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[2]=0;
                enemy1_3.position(94*size_dm, 151*size_dm);
                enemy1_3.setObstacleAlpha(0);
                enemy1_3.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }

        if((enemy1_3.position_x+enemy1_3.resized_width/4-bullet1_4.position_x)*(enemy1_3.position_x+enemy1_3.resized_width/4-bullet1_4.position_x) < enemy1_3.resized_width/2*enemy1_3.resized_width/2)
        {
            if((enemy1_3.position_y+enemy1_3.resized_height/4-bullet1_4.position_y)*(enemy1_3.position_y+enemy1_3.resized_height/4-bullet1_4.position_y) < enemy1_3.resized_height/2*enemy1_3.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[2]=0;
                enemy1_3.position(94*size_dm, 151*size_dm);
                enemy1_3.setObstacleAlpha(0);
                enemy1_3.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }

        if((enemy1_3.position_x+enemy1_3.resized_width/4-bullet1_5.position_x)*(enemy1_3.position_x+enemy1_3.resized_width/4-bullet1_5.position_x) < enemy1_3.resized_width/2*enemy1_3.resized_width/2)
        {
            if((enemy1_3.position_y+enemy1_3.resized_height/4-bullet1_5.position_y)*(enemy1_3.position_y+enemy1_3.resized_height/4-bullet1_5.position_y) < enemy1_3.resized_height/2*enemy1_3.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[2]=0;
                enemy1_3.position(94*size_dm, 151*size_dm);
                enemy1_3.setObstacleAlpha(0);
                enemy1_3.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////////////

        if((enemy1_4.position_x+enemy1_4.resized_width/4-bullet1_1.position_x)*(enemy1_4.position_x+enemy1_4.resized_width/4-bullet1_1.position_x) < enemy1_4.resized_width/2*enemy1_4.resized_width/2)
        {
            if((enemy1_4.position_y+enemy1_4.resized_height/4-bullet1_1.position_y)*(enemy1_4.position_y+enemy1_4.resized_height/4-bullet1_1.position_y) < enemy1_4.resized_height/2*enemy1_4.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[3]=0;
                enemy1_4.position(81*size_dm, 164*size_dm);
                enemy1_4.setObstacleAlpha(0);
                enemy1_4.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();

            }
        }

        if((enemy1_4.position_x+enemy1_4.resized_width/4-bullet1_2.position_x)*(enemy1_4.position_x+enemy1_4.resized_width/4-bullet1_2.position_x) < enemy1_4.resized_width/2*enemy1_4.resized_width/2)
        {
            if((enemy1_4.position_y+enemy1_4.resized_height/4-bullet1_2.position_y)*(enemy1_4.position_y+enemy1_4.resized_height/4-bullet1_2.position_y) < enemy1_4.resized_height/2*enemy1_4.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[3]=0;
                enemy1_4.position(81*size_dm, 164*size_dm);
                enemy1_4.setObstacleAlpha(0);
                enemy1_4.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();

            }
        }

        if((enemy1_4.position_x+enemy1_4.resized_width/4-bullet1_3.position_x)*(enemy1_4.position_x+enemy1_4.resized_width/4-bullet1_3.position_x) < enemy1_4.resized_width/2*enemy1_4.resized_width/2)
        {
            if((enemy1_4.position_y+enemy1_4.resized_height/4-bullet1_3.position_y)*(enemy1_4.position_y+enemy1_4.resized_height/4-bullet1_3.position_y) < enemy1_4.resized_height/2*enemy1_4.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[3]=0;
                enemy1_4.position(81*size_dm, 164*size_dm);
                enemy1_4.setObstacleAlpha(0);
                enemy1_4.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();

            }
        }

        if((enemy1_4.position_x+enemy1_4.resized_width/4-bullet1_4.position_x)*(enemy1_4.position_x+enemy1_4.resized_width/4-bullet1_4.position_x) < enemy1_4.resized_width/2*enemy1_4.resized_width/2)
        {
            if((enemy1_4.position_y+enemy1_4.resized_height/4-bullet1_4.position_y)*(enemy1_4.position_y+enemy1_4.resized_height/4-bullet1_4.position_y) < enemy1_4.resized_height/2*enemy1_4.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[3]=0;
                enemy1_4.position(81*size_dm, 164*size_dm);
                enemy1_4.setObstacleAlpha(0);
                enemy1_4.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();

            }
        }

        if((enemy1_4.position_x+enemy1_4.resized_width/4-bullet1_5.position_x)*(enemy1_4.position_x+enemy1_4.resized_width/4-bullet1_5.position_x) < enemy1_4.resized_width/2*enemy1_4.resized_width/2)
        {
            if((enemy1_4.position_y+enemy1_4.resized_height/4-bullet1_5.position_y)*(enemy1_4.position_y+enemy1_4.resized_height/4-bullet1_5.position_y) < enemy1_4.resized_height/2*enemy1_4.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[3]=0;
                enemy1_4.position(81*size_dm, 164*size_dm);
                enemy1_4.setObstacleAlpha(0);
                enemy1_4.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();

            }
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////

        if((enemy1_5.position_x+enemy1_5.resized_width/4-bullet1_1.position_x)*(enemy1_5.position_x+enemy1_5.resized_width/4-bullet1_1.position_x) < enemy1_5.resized_width/2*enemy1_5.resized_width/2)
        {
            if((enemy1_5.position_y+enemy1_5.resized_height/4-bullet1_1.position_y)*(enemy1_5.position_y+enemy1_5.resized_height/4-bullet1_1.position_y) < enemy1_5.resized_height/2*enemy1_5.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[4]=0;
                enemy1_5.position(68*size_dm, 177*size_dm);
                enemy1_5.setObstacleAlpha(0);
                enemy1_5.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();

            }
        }

        if((enemy1_5.position_x+enemy1_5.resized_width/4-bullet1_2.position_x)*(enemy1_5.position_x+enemy1_5.resized_width/4-bullet1_2.position_x) < enemy1_5.resized_width/2*enemy1_5.resized_width/2)
        {
            if((enemy1_5.position_y+enemy1_5.resized_height/4-bullet1_2.position_y)*(enemy1_5.position_y+enemy1_5.resized_height/4-bullet1_2.position_y) < enemy1_5.resized_height/2*enemy1_5.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[4]=0;
                enemy1_5.position(68*size_dm, 177*size_dm);
                enemy1_5.setObstacleAlpha(0);
                enemy1_5.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }

        if((enemy1_5.position_x+enemy1_5.resized_width/4-bullet1_3.position_x)*(enemy1_5.position_x+enemy1_5.resized_width/4-bullet1_3.position_x) <enemy1_5.resized_width/2*enemy1_5.resized_width/2)
        {
            if((enemy1_5.position_y+enemy1_5.resized_height/4-bullet1_3.position_y)*(enemy1_5.position_y+enemy1_5.resized_height/4-bullet1_3.position_y) < enemy1_5.resized_height/2*enemy1_5.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[4]=0;
                enemy1_5.position(68*size_dm, 177*size_dm);
                enemy1_5.setObstacleAlpha(0);
                enemy1_5.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }

        if((enemy1_5.position_x+enemy1_5.resized_width/4-bullet1_4.position_x)*(enemy1_5.position_x+enemy1_5.resized_width/4-bullet1_4.position_x) < enemy1_5.resized_width/2*enemy1_5.resized_width/2)
        {
            if((enemy1_5.position_y+enemy1_5.resized_height/4-bullet1_4.position_y)*(enemy1_5.position_y+enemy1_5.resized_height/4-bullet1_4.position_y) < enemy1_5.resized_height/2*enemy1_5.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[4]=0;
                enemy1_5.position(68*size_dm, 177*size_dm);
                enemy1_5.setObstacleAlpha(0);
                enemy1_5.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }

        if((enemy1_5.position_x+enemy1_5.resized_width/4-bullet1_5.position_x)*(enemy1_5.position_x+enemy1_5.resized_width/4-bullet1_5.position_x) < enemy1_5.resized_width/2*enemy1_5.resized_width/2)
        {
            if((enemy1_5.position_y+enemy1_5.resized_height/4-bullet1_5.position_y)*(enemy1_5.position_y+enemy1_5.resized_height/4-bullet1_5.position_y) < enemy1_5.resized_height/2*enemy1_5.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[4]=0;
                enemy1_5.position(68*size_dm, 177*size_dm);
                enemy1_5.setObstacleAlpha(0);
                enemy1_5.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////////

        if((enemy1_6.position_x+enemy1_6.resized_width/4-bullet1_1.position_x)*(enemy1_6.position_x+enemy1_6.resized_width/4-bullet1_1.position_x) < enemy1_6.resized_width/2*enemy1_6.resized_width/2)
        {
            if((enemy1_6.position_y+enemy1_6.resized_height/4-bullet1_1.position_y)*(enemy1_6.position_y+enemy1_6.resized_height/4-bullet1_1.position_y) < enemy1_6.resized_height/2*enemy1_6.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[5]=0;
                enemy1_6.position(55*size_dm, 190*size_dm);
                enemy1_6.setObstacleAlpha(0);
                enemy1_6.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if((enemy1_6.position_x+enemy1_6.resized_width/4-bullet1_2.position_x)*(enemy1_6.position_x+enemy1_6.resized_width/4-bullet1_2.position_x) < enemy1_6.resized_width/2*enemy1_6.resized_width/2)
        {
            if((enemy1_6.position_y+enemy1_6.resized_height/4-bullet1_2.position_y)*(enemy1_6.position_y+enemy1_6.resized_height/4-bullet1_2.position_y) < enemy1_6.resized_height/2*enemy1_6.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[5]=0;
                enemy1_6.position(55*size_dm, 190*size_dm);
                enemy1_6.setObstacleAlpha(0);
                enemy1_6.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }

        if((enemy1_6.position_x+enemy1_6.resized_width/4-bullet1_3.position_x)*(enemy1_6.position_x+enemy1_6.resized_width/4-bullet1_3.position_x) < enemy1_6.resized_width/2*enemy1_6.resized_width/2)
        {
            if((enemy1_6.position_y+enemy1_6.resized_height/4-bullet1_3.position_y)*(enemy1_6.position_y+enemy1_6.resized_height/4-bullet1_3.position_y) < enemy1_6.resized_height/2*enemy1_6.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[5]=0;
                enemy1_6.position(55*size_dm, 190*size_dm);
                enemy1_6.setObstacleAlpha(0);
                enemy1_6.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }

        if((enemy1_6.position_x+enemy1_6.resized_width/4-bullet1_4.position_x)*(enemy1_6.position_x+enemy1_6.resized_width/4-bullet1_4.position_x) < enemy1_6.resized_width/2*enemy1_6.resized_width/2)
        {
            if((enemy1_6.position_y+enemy1_6.resized_height/4-bullet1_4.position_y)*(enemy1_6.position_y+enemy1_6.resized_height/4-bullet1_4.position_y) < enemy1_6.resized_height/2*enemy1_6.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[5]=0;
                enemy1_6.position(55*size_dm, 190*size_dm);
                enemy1_6.setObstacleAlpha(0);
                enemy1_6.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }

        if((enemy1_6.position_x+enemy1_6.resized_width/4-bullet1_5.position_x)*(enemy1_6.position_x+enemy1_6.resized_width/4-bullet1_5.position_x) < enemy1_6.resized_width/2*enemy1_6.resized_width/2)
        {
            if((enemy1_6.position_y+enemy1_6.resized_height/4-bullet1_5.position_y)*(enemy1_6.position_y+enemy1_6.resized_height/4-bullet1_5.position_y) < enemy1_6.resized_height/2*enemy1_6.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[5]=0;
                enemy1_6.position(55*size_dm, 190*size_dm);
                enemy1_6.setObstacleAlpha(0);
                enemy1_6.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        if((enemy1_7.position_x+enemy1_7.resized_width/4-bullet1_1.position_x)*(enemy1_7.position_x+enemy1_7.resized_width/4-bullet1_1.position_x) < enemy1_7.resized_width/2*enemy1_7.resized_width/2)
        {
            if((enemy1_7.position_y+enemy1_7.resized_height/4-bullet1_1.position_y)*(enemy1_7.position_y+enemy1_7.resized_height/4-bullet1_1.position_y) < enemy1_7.resized_height/2*enemy1_7.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[6]=0;
                enemy1_7.position(42*size_dm, 203*size_dm);
                enemy1_7.setObstacleAlpha(0);
                enemy1_7.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if((enemy1_7.position_x+enemy1_7.resized_width/4-bullet1_2.position_x)*(enemy1_7.position_x+enemy1_7.resized_width/4-bullet1_2.position_x) < enemy1_7.resized_width/2*enemy1_7.resized_width/2)
        {
            if((enemy1_7.position_y+enemy1_7.resized_height/4-bullet1_2.position_y)*(enemy1_7.position_y+enemy1_7.resized_height/4-bullet1_2.position_y) < enemy1_7.resized_height/2*enemy1_7.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[6]=0;
                enemy1_7.position(42*size_dm, 203*size_dm);
                enemy1_7.setObstacleAlpha(0);
                enemy1_7.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }


        if((enemy1_7.position_x+enemy1_7.resized_width/4-bullet1_3.position_x)*(enemy1_7.position_x+enemy1_7.resized_width/4-bullet1_3.position_x) < enemy1_7.resized_width/2*enemy1_7.resized_width/2)
        {
            if((enemy1_7.position_y+enemy1_7.resized_height/4-bullet1_3.position_y)*(enemy1_7.position_y+enemy1_7.resized_height/4-bullet1_3.position_y) < enemy1_7.resized_height/2*enemy1_7.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[6]=0;
                enemy1_7.position(42*size_dm, 203*size_dm);
                enemy1_7.setObstacleAlpha(0);
                enemy1_7.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }


        if((enemy1_7.position_x+enemy1_7.resized_width/4-bullet1_4.position_x)*(enemy1_7.position_x+enemy1_7.resized_width/4-bullet1_4.position_x) < enemy1_7.resized_width/2*enemy1_7.resized_width/2)
        {
            if((enemy1_7.position_y+enemy1_7.resized_height/4-bullet1_4.position_x)*(enemy1_7.position_y+enemy1_7.resized_height/4-bullet1_4.position_x) < enemy1_7.resized_height/2*enemy1_7.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[6]=0;
                enemy1_7.position(42*size_dm, 203*size_dm);
                enemy1_7.setObstacleAlpha(0);
                enemy1_7.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }


        if((enemy1_7.position_x+enemy1_7.resized_width/4-bullet1_5.position_x)*(enemy1_7.position_x+enemy1_7.resized_width/4-bullet1_5.position_x) < enemy1_7.resized_width/2*enemy1_7.resized_width/2)
        {
            if((enemy1_7.position_y+enemy1_7.resized_height/4-bullet1_5.position_y)*(enemy1_7.position_y+enemy1_7.resized_height/4-bullet1_5.position_y) < enemy1_7.resized_height/2*enemy1_7.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[6]=0;
                enemy1_7.position(42*size_dm, 203*size_dm);
                enemy1_7.setObstacleAlpha(0);
                enemy1_7.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }


        //////////////////////////////////////////////////////////////////////////////////////////////////////////

        if((enemy1_8.position_x+enemy1_8.resized_width/4-bullet1_1.position_x)*(enemy1_8.position_x+enemy1_8.resized_width/4-bullet1_1.position_x) < enemy1_8.resized_width/2*enemy1_8.resized_width/2)
        {
            if((enemy1_8.position_y+enemy1_8.resized_height/4-bullet1_1.position_y)*(enemy1_8.position_y+enemy1_8.resized_height/4-bullet1_1.position_y) < enemy1_8.resized_height/2*enemy1_8.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[7]=0;
                enemy1_8.position(29*size_dm, 216*size_dm);
                enemy1_8.setObstacleAlpha(0);
                enemy1_8.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();

            }
        }

        if((enemy1_8.position_x+enemy1_8.resized_width/4-bullet1_2.position_x)*(enemy1_8.position_x+enemy1_8.resized_width/4-bullet1_2.position_x) < enemy1_8.resized_width/2*enemy1_8.resized_width/2)
        {
            if((enemy1_8.position_y+enemy1_8.resized_height/4-bullet1_2.position_y)*(enemy1_8.position_y+enemy1_8.resized_height/4-bullet1_2.position_y) < enemy1_8.resized_height/2*enemy1_8.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[7]=0;
                enemy1_8.position(29*size_dm, 216*size_dm);
                enemy1_8.setObstacleAlpha(0);
                enemy1_8.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();

            }
        }

        if((enemy1_8.position_x+enemy1_8.resized_width/4-bullet1_3.position_x)*(enemy1_8.position_x+enemy1_8.resized_width/4-bullet1_3.position_x) < enemy1_8.resized_width/2*enemy1_8.resized_width/2)
        {
            if((enemy1_8.position_y+enemy1_8.resized_height/4-bullet1_3.position_y)*(enemy1_8.position_y+enemy1_8.resized_height/4-bullet1_3.position_y) < enemy1_8.resized_height/2*enemy1_8.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[7]=0;
                enemy1_8.position(29*size_dm, 216*size_dm);
                enemy1_8.setObstacleAlpha(0);
                enemy1_8.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();

            }
        }

        if((enemy1_8.position_x+enemy1_8.resized_width/4-bullet1_4.position_x)*(enemy1_8.position_x+enemy1_8.resized_width/4-bullet1_4.position_x) < enemy1_8.resized_width/2*enemy1_8.resized_width/2)
        {
            if((enemy1_8.position_y+enemy1_8.resized_height/4-bullet1_4.position_y)*(enemy1_8.position_y+enemy1_8.resized_height/4-bullet1_4.position_y) < enemy1_8.resized_height/2*enemy1_8.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[7]=0;
                enemy1_8.position(29*size_dm, 216*size_dm);
                enemy1_8.setObstacleAlpha(0);
                enemy1_8.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();

            }
        }

        if((enemy1_8.position_x+enemy1_8.resized_width/4-bullet1_5.position_x)*(enemy1_8.position_x+enemy1_8.resized_width/4-bullet1_5.position_x) < enemy1_8.resized_width/2*enemy1_8.resized_width/2)
        {
            if((enemy1_8.position_y+enemy1_8.resized_height/4-bullet1_5.position_y)*(enemy1_8.position_y+enemy1_8.resized_height/4-bullet1_5.position_y) < enemy1_8.resized_height/2*enemy1_8.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[7]=0;
                enemy1_8.position(29*size_dm, 216*size_dm);
                enemy1_8.setObstacleAlpha(0);
                enemy1_8.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();

            }
        }

        //////////////////////////////////////////////////////////////////////////////////////////////////

        if((enemy1x2_1.position_x+enemy1x2_1.resized_width/4-bullet1_1.position_x)*(enemy1x2_1.position_x+enemy1x2_1.resized_width/4-bullet1_1.position_x) < enemy1x2_1.resized_width/2*enemy1x2_1.resized_width/2)
        {
            if((enemy1x2_1.position_y+enemy1x2_1.resized_height/4-bullet1_1.position_y)*(enemy1x2_1.position_y+enemy1x2_1.resized_height/4-bullet1_1.position_y) <enemy1x2_1.resized_height/2*enemy1x2_1.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[8]=0;
                enemy1x2_1.position(120*size_dm, 125*size_dm);
                enemy1x2_1.setObstacleAlpha(0);
                enemy1x2_1.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if((enemy1x2_1.position_x+enemy1x2_1.resized_width/4-bullet1_2.position_x)*(enemy1x2_1.position_x+enemy1x2_1.resized_width/4-bullet1_2.position_x) < enemy1x2_1.resized_width/2*enemy1x2_1.resized_width/2)
        {
            if((enemy1x2_1.position_y+enemy1x2_1.resized_height/4-bullet1_2.position_y)*(enemy1x2_1.position_y+enemy1x2_1.resized_height/4-bullet1_2.position_y) <enemy1x2_1.resized_height/2*enemy1x2_1.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[8]=0;
                enemy1x2_1.position(120*size_dm, 125*size_dm);
                enemy1x2_1.setObstacleAlpha(0);
                enemy1x2_1.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }

        if((enemy1x2_1.position_x+enemy1x2_1.resized_width/4-bullet1_3.position_x)*(enemy1x2_1.position_x+enemy1x2_1.resized_width/4-bullet1_3.position_x) < enemy1x2_1.resized_width/2*enemy1x2_1.resized_width/2)
        {
            if((enemy1x2_1.position_y+enemy1x2_1.resized_height/4-bullet1_3.position_y)*(enemy1x2_1.position_y+enemy1x2_1.resized_height/4-bullet1_3.position_y) <enemy1x2_1.resized_height/2*enemy1x2_1.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[8]=0;
                enemy1x2_1.position(120*size_dm, 125*size_dm);
                enemy1x2_1.setObstacleAlpha(0);
                enemy1x2_1.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }

        if((enemy1x2_1.position_x+enemy1x2_1.resized_width/4-bullet1_4.position_x)*(enemy1x2_1.position_x+enemy1x2_1.resized_width/4-bullet1_4.position_x) < enemy1x2_1.resized_width/2*enemy1x2_1.resized_width/2)
        {
            if((enemy1x2_1.position_y+enemy1x2_1.resized_height/4-bullet1_4.position_y)*(enemy1x2_1.position_y+enemy1x2_1.resized_height/4-bullet1_4.position_y) <enemy1x2_1.resized_height/2*enemy1x2_1.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[8]=0;
                enemy1x2_1.position(120*size_dm, 125*size_dm);
                enemy1x2_1.setObstacleAlpha(0);
                enemy1x2_1.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }

        if((enemy1x2_1.position_x+enemy1x2_1.resized_width/4-bullet1_5.position_x)*(enemy1x2_1.position_x+enemy1x2_1.resized_width/4-bullet1_5.position_x) < enemy1x2_1.resized_width/2*enemy1x2_1.resized_width/2)
        {
            if((enemy1x2_1.position_y+enemy1x2_1.resized_height/4-bullet1_5.position_y)*(enemy1x2_1.position_y+enemy1x2_1.resized_height/4-bullet1_5.position_y) <enemy1x2_1.resized_height/2*enemy1x2_1.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[8]=0;
                enemy1x2_1.position(120*size_dm, 125*size_dm);
                enemy1x2_1.setObstacleAlpha(0);
                enemy1x2_1.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        if((enemy1x2_2.position_x+enemy1x2_2.resized_width/4-bullet1_1.position_x)*(enemy1x2_2.position_x+enemy1x2_2.resized_width/4-bullet1_1.position_x) < enemy1x2_2.resized_width/2*enemy1x2_2.resized_width/2)
        {
            if((enemy1x2_2.position_y+enemy1x2_2.resized_height/4-bullet1_1.position_y)*(enemy1x2_2.position_y+enemy1x2_2.resized_height/4-bullet1_1.position_y) < enemy1x2_2.resized_height/2*enemy1x2_2.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[9]=0;
                enemy1x2_2.position(107*size_dm, 138*size_dm);
                enemy1x2_2.setObstacleAlpha(0);
                enemy1x2_2.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if((enemy1x2_2.position_x+enemy1x2_2.resized_width/4-bullet1_2.position_x)*(enemy1x2_2.position_x+enemy1x2_2.resized_width/4-bullet1_2.position_x) < enemy1x2_2.resized_width/2*enemy1x2_2.resized_width/2)
        {
            if((enemy1x2_2.position_y+enemy1x2_2.resized_height/4-bullet1_2.position_y)*(enemy1x2_2.position_y+enemy1x2_2.resized_height/4-bullet1_2.position_y) < enemy1x2_2.resized_height/2*enemy1x2_2.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[9]=0;
                enemy1x2_2.position(107*size_dm, 138*size_dm);
                enemy1x2_2.setObstacleAlpha(0);
                enemy1x2_2.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }

        if((enemy1x2_2.position_x+enemy1x2_2.resized_width/4-bullet1_3.position_x)*(enemy1x2_2.position_x+enemy1x2_2.resized_width/4-bullet1_3.position_x) < enemy1x2_2.resized_width/2*enemy1x2_2.resized_width/2)
        {
            if((enemy1x2_2.position_y+enemy1x2_2.resized_height/4-bullet1_3.position_y)*(enemy1x2_2.position_y+enemy1x2_2.resized_height/3-bullet1_3.position_y) < enemy1x2_2.resized_height/2*enemy1x2_2.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[9]=0;
                enemy1x2_2.position(107*size_dm, 138*size_dm);
                enemy1x2_2.setObstacleAlpha(0);
                enemy1x2_2.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }

        if((enemy1x2_2.position_x+enemy1x2_2.resized_width/4-bullet1_4.position_x)*(enemy1x2_2.position_x+enemy1x2_2.resized_width/4-bullet1_4.position_x) < enemy1x2_2.resized_width/2*enemy1x2_2.resized_width/2)
        {
            if((enemy1x2_2.position_y+enemy1x2_2.resized_height/4-bullet1_4.position_y)*(enemy1x2_2.position_y+enemy1x2_2.resized_height/4-bullet1_4.position_y) < enemy1x2_2.resized_height/2*enemy1x2_2.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[9]=0;
                enemy1x2_2.position(107*size_dm, 138*size_dm);
                enemy1x2_2.setObstacleAlpha(0);
                enemy1x2_2.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }

        if((enemy1x2_2.position_x+enemy1x2_2.resized_width/4-bullet1_5.position_x)*(enemy1x2_2.position_x+enemy1x2_2.resized_width/4-bullet1_5.position_x) < enemy1x2_2.resized_width/2*enemy1x2_2.resized_width/2)
        {
            if((enemy1x2_2.position_y+enemy1x2_2.resized_height/4-bullet1_5.position_y)*(enemy1x2_2.position_y+enemy1x2_2.resized_height/4-bullet1_5.position_y) < enemy1x2_2.resized_height/2*enemy1x2_2.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[9]=0;
                enemy1x2_2.position(107*size_dm, 138*size_dm);
                enemy1x2_2.setObstacleAlpha(0);
                enemy1x2_2.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////

        if((enemy1x2_3.position_x+enemy1x2_3.resized_width/4-bullet1_1.position_x)*(enemy1x2_3.position_x+enemy1x2_3.resized_width/4-bullet1_1.position_x) < enemy1x2_3.resized_width/2*enemy1x2_3.resized_width/2)
        {
            if((enemy1x2_3.position_y+enemy1x2_3.resized_height/4-bullet1_1.position_y)*(enemy1x2_3.position_y+enemy1x2_3.resized_height/4-bullet1_1.position_y) < enemy1x2_3.resized_height/2*enemy1x2_3.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[10]=0;
                enemy1x2_3.position(94*size_dm, 151*size_dm);
                enemy1x2_3.setObstacleAlpha(0);
                enemy1x2_3.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if((enemy1x2_3.position_x+enemy1x2_3.resized_width/4-bullet1_2.position_x)*(enemy1x2_3.position_x+enemy1x2_3.resized_width/4-bullet1_2.position_x) < enemy1x2_3.resized_width/2*enemy1x2_3.resized_width/2)
        {
            if((enemy1x2_3.position_y+enemy1x2_3.resized_height/4-bullet1_2.position_y)*(enemy1x2_3.position_y+enemy1x2_3.resized_height/4-bullet1_2.position_y) < enemy1x2_3.resized_height/2*enemy1x2_3.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[10]=0;
                enemy1x2_3.position(94*size_dm, 151*size_dm);
                enemy1x2_3.setObstacleAlpha(0);
                enemy1x2_3.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }


        if((enemy1x2_3.position_x+enemy1x2_3.resized_width/4-bullet1_3.position_x)*(enemy1x2_3.position_x+enemy1x2_3.resized_width/4-bullet1_3.position_x) < enemy1x2_3.resized_width/2*enemy1x2_3.resized_width/2)
        {
            if((enemy1x2_3.position_y+enemy1x2_3.resized_height/4-bullet1_3.position_y)*(enemy1x2_3.position_y+enemy1x2_3.resized_height/4-bullet1_3.position_y) < enemy1x2_3.resized_height/2*enemy1x2_3.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[10]=0;
                enemy1x2_3.position(94*size_dm, 151*size_dm);
                enemy1x2_3.setObstacleAlpha(0);
                enemy1x2_3.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }


        if((enemy1x2_3.position_x+enemy1x2_3.resized_width/4-bullet1_4.position_x)*(enemy1x2_3.position_x+enemy1x2_3.resized_width/4-bullet1_4.position_x) < enemy1x2_3.resized_width/2*enemy1x2_3.resized_width/2)
        {
            if((enemy1x2_3.position_y+enemy1x2_3.resized_height/4-bullet1_4.position_y)*(enemy1x2_3.position_y+enemy1x2_3.resized_height/4-bullet1_4.position_y) < enemy1x2_3.resized_height/2*enemy1x2_3.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[10]=0;
                enemy1x2_3.position(94*size_dm, 151*size_dm);
                enemy1x2_3.setObstacleAlpha(0);
                enemy1x2_3.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }


        if((enemy1x2_3.position_x+enemy1x2_3.resized_width/4-bullet1_5.position_x)*(enemy1x2_3.position_x+enemy1x2_3.resized_width/4-bullet1_5.position_x) < enemy1x2_3.resized_width/2*enemy1x2_3.resized_width/2)
        {
            if((enemy1x2_3.position_y+enemy1x2_3.resized_height/4-bullet1_5.position_y)*(enemy1x2_3.position_y+enemy1x2_3.resized_height/4-bullet1_5.position_y) < enemy1x2_3.resized_height/2*enemy1x2_3.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[10]=0;
                enemy1x2_3.position(94*size_dm, 151*size_dm);
                enemy1x2_3.setObstacleAlpha(0);
                enemy1x2_3.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }


        //////////////////////////////////////////////////////////////////////////////////////////////////////////


        if((enemy1x2_4.position_x+enemy1x2_4.resized_width/4-bullet1_1.position_x)*(enemy1x2_4.position_x+enemy1x2_4.resized_width/4-bullet1_1.position_x) < enemy1x2_4.resized_width/2*enemy1x2_4.resized_width/2)
        {
            if((enemy1x2_4.position_y+enemy1x2_4.resized_height/4-bullet1_1.position_y)*(enemy1x2_4.position_y+enemy1x2_4.resized_height/4-bullet1_1.position_y) <enemy1x2_4.resized_height/2*enemy1x2_4.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[11]=0;
                enemy1x2_4.position(81*size_dm, 164*size_dm);
                enemy1x2_4.setObstacleAlpha(0);
                enemy1x2_4.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if((enemy1x2_4.position_x+enemy1x2_4.resized_width/4-bullet1_2.position_x)*(enemy1x2_4.position_x+enemy1x2_4.resized_width/4-bullet1_2.position_x) < enemy1x2_4.resized_width/2*enemy1x2_4.resized_width/2)
        {
            if((enemy1x2_4.position_y+enemy1x2_4.resized_height/4-bullet1_2.position_y)*(enemy1x2_4.position_y+enemy1x2_4.resized_height/4-bullet1_2.position_y) <enemy1x2_4.resized_height/2*enemy1x2_4.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[11]=0;
                enemy1x2_4.position(81*size_dm, 164*size_dm);
                enemy1x2_4.setObstacleAlpha(0);
                enemy1x2_4.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }

        if((enemy1x2_4.position_x+enemy1x2_4.resized_width/4-bullet1_3.position_x)*(enemy1x2_4.position_x+enemy1x2_4.resized_width/4-bullet1_3.position_x) < enemy1x2_4.resized_width/2*enemy1x2_4.resized_width/2)
        {
            if((enemy1x2_4.position_y+enemy1x2_4.resized_width/4-bullet1_3.position_y)*(enemy1x2_4.position_y+enemy1x2_4.resized_width/4-bullet1_3.position_y) < enemy1x2_4.resized_width/2*enemy1x2_4.resized_width/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[11]=0;
                enemy1x2_4.position(81*size_dm, 164*size_dm);
                enemy1x2_4.setObstacleAlpha(0);
                enemy1x2_4.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }

        if((enemy1x2_4.position_x+enemy1x2_4.resized_width/4-bullet1_4.position_x)*(enemy1x2_4.position_x+enemy1x2_4.resized_width/4-bullet1_4.position_x) < enemy1x2_4.resized_width/2*enemy1x2_4.resized_width/2)
        {
            if((enemy1x2_4.position_y+enemy1x2_4.resized_height/4-bullet1_4.position_y)*(enemy1x2_4.position_y+enemy1x2_4.resized_height/4-bullet1_4.position_y) < enemy1x2_4.resized_height/2*enemy1x2_4.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[11]=0;
                enemy1x2_4.position(81*size_dm, 164*size_dm);
                enemy1x2_4.setObstacleAlpha(0);
                enemy1x2_4.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }

        if((enemy1x2_4.position_x+enemy1x2_4.resized_width/4-bullet1_5.position_x)*(enemy1x2_4.position_x+enemy1x2_4.resized_width/4-bullet1_5.position_x) < enemy1x2_4.resized_width/2*enemy1x2_4.resized_width/2)
        {
            if((enemy1x2_4.position_y+enemy1x2_4.resized_height/4-bullet1_5.position_y)*(enemy1x2_4.position_y+enemy1x2_4.resized_height/4-bullet1_5.position_y) < enemy1x2_4.resized_height/2*enemy1x2_4.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[11]=0;
                enemy1x2_4.position(81*size_dm, 164*size_dm);
                enemy1x2_4.setObstacleAlpha(0);
                enemy1x2_4.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        if((enemy1x2_5.position_x+enemy1x2_5.resized_width/4-bullet1_1.position_x)*(enemy1x2_5.position_x+enemy1x2_5.resized_width/4-bullet1_1.position_x) < enemy1x2_5.resized_width/2*enemy1x2_5.resized_width/2)
        {
            if((enemy1x2_5.position_y+enemy1x2_5.resized_height/4-bullet1_1.position_y)*(enemy1x2_5.position_y+enemy1x2_5.resized_height/4-bullet1_1.position_y) < enemy1x2_5.resized_height/2*enemy1x2_5.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[12]=0;
                enemy1x2_5.position(68*size_dm, 177*size_dm);
                enemy1x2_5.setObstacleAlpha(0);
                enemy1x2_5.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if((enemy1x2_5.position_x+enemy1x2_5.resized_width/4-bullet1_2.position_x)*(enemy1x2_5.position_x+enemy1x2_5.resized_width/4-bullet1_2.position_x) < enemy1x2_5.resized_width/2*enemy1x2_5.resized_width/2)
        {
            if((enemy1x2_5.position_y+enemy1x2_5.resized_height/4-bullet1_2.position_y)*(enemy1x2_5.position_y+enemy1x2_5.resized_height/4-bullet1_2.position_y) < enemy1x2_5.resized_height/2*enemy1x2_5.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[12]=0;
                enemy1x2_5.position(68*size_dm, 177*size_dm);
                enemy1x2_5.setObstacleAlpha(0);
                enemy1x2_5.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }

        if((enemy1x2_5.position_x+enemy1x2_5.resized_width/4-bullet1_3.position_x)*(enemy1x2_5.position_x+enemy1x2_5.resized_width/4-bullet1_3.position_x) < enemy1x2_5.resized_width/2*enemy1x2_5.resized_width/2)
        {
            if((enemy1x2_5.position_y+enemy1x2_5.resized_height/4-bullet1_3.position_y)*(enemy1x2_5.position_y+enemy1x2_5.resized_height/4-bullet1_3.position_y) <enemy1x2_5.resized_height/2*enemy1x2_5.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[12]=0;
                enemy1x2_5.position(68*size_dm, 177*size_dm);
                enemy1x2_5.setObstacleAlpha(0);
                enemy1x2_5.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }

        if((enemy1x2_5.position_x+enemy1x2_5.resized_width/4-bullet1_4.position_x)*(enemy1x2_5.position_x+enemy1x2_5.resized_width/4-bullet1_4.position_x) < enemy1x2_5.resized_width/2*enemy1x2_5.resized_width/2)
        {
            if((enemy1x2_5.position_y+enemy1x2_5.resized_height/4-bullet1_4.position_y)*(enemy1x2_5.position_y+enemy1x2_5.resized_height/4-bullet1_4.position_y) < enemy1x2_5.resized_height/2*enemy1x2_5.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[12]=0;
                enemy1x2_5.position(68*size_dm, 177*size_dm);
                enemy1x2_5.setObstacleAlpha(0);
                enemy1x2_5.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }

        if((enemy1x2_5.position_x+enemy1x2_5.resized_width/4-bullet1_5.position_x)*(enemy1x2_5.position_x+enemy1x2_5.resized_width/4-bullet1_5.position_x) < enemy1x2_5.resized_width/2*enemy1x2_5.resized_width/2)
        {
            if((enemy1x2_5.position_y+enemy1x2_5.resized_height/4-bullet1_5.position_y)*(enemy1x2_5.position_y+enemy1x2_5.resized_height/4-bullet1_5.position_y) < enemy1x2_5.resized_height/2*enemy1x2_5.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[12]=0;
                enemy1x2_5.position(68*size_dm, 177*size_dm);
                enemy1x2_5.setObstacleAlpha(0);
                enemy1x2_5.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }

        ///////////////////////////////////////////////////////////////////////////////////////

        if((enemy1x2_6.position_x+enemy1x2_6.resized_width/4-bullet1_1.position_x)*(enemy1x2_6.position_x+enemy1x2_6.resized_width/4-bullet1_1.position_x) < enemy1x2_6.resized_width/2*enemy1x2_6.resized_width/2)
        {
            if((enemy1x2_6.position_y+enemy1x2_6.resized_height/4-bullet1_1.position_y)*(enemy1x2_6.position_y+enemy1x2_6.resized_height/4-bullet1_1.position_y) <enemy1x2_6.resized_height/2*enemy1x2_6.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[13]=0;
                enemy1x2_6.position(55*size_dm, 190*size_dm);
                enemy1x2_6.setObstacleAlpha(0);
                enemy1x2_6.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if((enemy1x2_6.position_x+enemy1x2_6.resized_width/4-bullet1_2.position_x)*(enemy1x2_6.position_x+enemy1x2_6.resized_width/4-bullet1_2.position_x) < enemy1x2_6.resized_width/2*enemy1x2_6.resized_width/2)
        {
            if((enemy1x2_6.position_y+enemy1x2_6.resized_height/4-bullet1_2.position_y)*(enemy1x2_6.position_y+enemy1x2_6.resized_height/4-bullet1_2.position_y) <enemy1x2_6.resized_height/2*enemy1x2_6.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[13]=0;
                enemy1x2_6.position(55*size_dm, 190*size_dm);
                enemy1x2_6.setObstacleAlpha(0);
                enemy1x2_6.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }

        if((enemy1x2_6.position_x+enemy1x2_6.resized_width/4-bullet1_3.position_x)*(enemy1x2_6.position_x+enemy1x2_6.resized_width/4-bullet1_3.position_x) < enemy1x2_6.resized_width/2*enemy1x2_6.resized_width/2)
        {
            if((enemy1x2_6.position_y+enemy1x2_6.resized_height/4-bullet1_3.position_y)*(enemy1x2_6.position_y+enemy1x2_6.resized_height/4-bullet1_3.position_y) <enemy1x2_6.resized_height/2*enemy1x2_6.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[13]=0;
                enemy1x2_6.position(55*size_dm, 190*size_dm);
                enemy1x2_6.setObstacleAlpha(0);
                enemy1x2_6.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }

        if((enemy1x2_6.position_x+enemy1x2_6.resized_width/4-bullet1_4.position_x)*(enemy1x2_6.position_x+enemy1x2_6.resized_width/4-bullet1_4.position_x) < enemy1x2_6.resized_width/2*enemy1x2_6.resized_width/2)
        {
            if((enemy1x2_6.position_y+enemy1x2_6.resized_height/4-bullet1_4.position_y)*(enemy1x2_6.position_y+enemy1x2_6.resized_height/4-bullet1_4.position_y) <enemy1x2_6.resized_height/2*enemy1x2_6.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[13]=0;
                enemy1x2_6.position(55*size_dm, 190*size_dm);
                enemy1x2_6.setObstacleAlpha(0);
                enemy1x2_6.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }

        if((enemy1x2_6.position_x+enemy1x2_6.resized_width/4-bullet1_5.position_x)*(enemy1x2_6.position_x+enemy1x2_6.resized_width/4-bullet1_5.position_x) < enemy1x2_6.resized_width/2*enemy1x2_6.resized_width/2)
        {
            if((enemy1x2_6.position_y+enemy1x2_6.resized_height/4-bullet1_5.position_y)*(enemy1x2_6.position_y+enemy1x2_6.resized_height/4-bullet1_5.position_y) <enemy1x2_6.resized_height/2*enemy1x2_6.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[13]=0;
                enemy1x2_6.position(55*size_dm, 190*size_dm);
                enemy1x2_6.setObstacleAlpha(0);
                enemy1x2_6.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////

        if((enemy1x2_7.position_x+enemy1x2_7.resized_width/4-bullet1_1.position_x)*(enemy1x2_7.position_x+enemy1x2_7.resized_width/4-bullet1_1.position_x) < enemy1x2_7.resized_width/2*enemy1x2_7.resized_width/2)
        {
            if((enemy1x2_7.position_y+enemy1x2_7.resized_height/4-bullet1_1.position_y)*(enemy1x2_7.position_y+enemy1x2_7.resized_height/4-bullet1_1.position_y) < enemy1x2_7.resized_height/2*enemy1x2_7.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[14]=0;
                enemy1x2_7.position(42*size_dm, 203*size_dm);
                enemy1x2_7.setObstacleAlpha(0);
                enemy1x2_7.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if((enemy1x2_7.position_x+enemy1x2_7.resized_width/4-bullet1_2.position_x)*(enemy1x2_7.position_x+enemy1x2_7.resized_width/4-bullet1_2.position_x) < enemy1x2_7.resized_width/2*enemy1x2_7.resized_width/2)
        {
            if((enemy1x2_7.position_y+enemy1x2_7.resized_height/4-bullet1_2.position_x)*(enemy1x2_7.position_y+enemy1x2_7.resized_height/4-bullet1_2.position_x) < enemy1x2_7.resized_height/2*enemy1x2_7.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[14]=0;
                enemy1x2_7.position(42*size_dm, 203*size_dm);
                enemy1x2_7.setObstacleAlpha(0);
                enemy1x2_7.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }

        if((enemy1x2_7.position_x+enemy1x2_7.resized_width/4-bullet1_3.position_x)*(enemy1x2_7.position_x+enemy1x2_7.resized_width/4-bullet1_3.position_x) < enemy1x2_7.resized_width/2*enemy1x2_7.resized_width/2)
        {
            if((enemy1x2_7.position_y+enemy1x2_7.resized_height/4-bullet1_3.position_y)*(enemy1x2_7.position_y+enemy1x2_7.resized_height/4-bullet1_3.position_y) < enemy1x2_7.resized_height/2*enemy1x2_7.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[14]=0;
                enemy1x2_7.position(42*size_dm, 203*size_dm);
                enemy1x2_7.setObstacleAlpha(0);
                enemy1x2_7.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }

        if((enemy1x2_7.position_x+enemy1x2_7.resized_width/4-bullet1_4.position_x)*(enemy1x2_7.position_x+enemy1x2_7.resized_width/4-bullet1_4.position_x) < enemy1x2_7.resized_width/2*enemy1x2_7.resized_width/2)
        {
            if((enemy1x2_7.position_y+enemy1x2_7.resized_height/4-bullet1_4.position_y)*(enemy1x2_7.position_y+enemy1x2_7.resized_height/4-bullet1_4.position_y) < enemy1x2_7.resized_height/2*enemy1x2_7.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[14]=0;
                enemy1x2_7.position(42*size_dm, 203*size_dm);
                enemy1x2_7.setObstacleAlpha(0);
                enemy1x2_7.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }

        if((enemy1x2_7.position_x+enemy1x2_7.resized_width/4-bullet1_5.position_x)*(enemy1x2_7.position_x+enemy1x2_7.resized_width/4-bullet1_5.position_x) < enemy1x2_7.resized_width/2*enemy1x2_7.resized_width/2)
        {
            if((enemy1x2_7.position_y+enemy1x2_7.resized_height/4-bullet1_5.position_y)*(enemy1x2_7.position_y+enemy1x2_7.resized_height/4-bullet1_5.position_y) < enemy1x2_7.resized_height/2*enemy1x2_7.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[14]=0;
                enemy1x2_7.position(42*size_dm, 203*size_dm);
                enemy1x2_7.setObstacleAlpha(0);
                enemy1x2_7.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        if((enemy1x2_8.position_x+enemy1x2_8.resized_width/4-bullet1_1.position_x)*(enemy1x2_8.position_x+enemy1x2_8.resized_width/4-bullet1_1.position_x) < enemy1x2_8.resized_width/2*enemy1x2_8.resized_width/2)
        {
            if((enemy1x2_8.position_y+enemy1x2_8.resized_height/4-bullet1_1.position_y)*(enemy1x2_8.position_y+enemy1x2_8.resized_height/4-bullet1_1.position_y) < enemy1x2_8.resized_height/2*enemy1x2_8.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[15]=0;
                enemy1x2_8.position(29*size_dm, 216*size_dm);
                enemy1x2_8.setObstacleAlpha(0);
                enemy1x2_8.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if((enemy1x2_8.position_x+enemy1x2_8.resized_width/4-bullet1_2.position_x)*(enemy1x2_8.position_x+enemy1x2_8.resized_width/4-bullet1_2.position_x) < enemy1x2_8.resized_width/2*enemy1x2_8.resized_width/2)
        {
            if((enemy1x2_8.position_y+enemy1x2_8.resized_height/4-bullet1_2.position_y)*(enemy1x2_8.position_y+enemy1x2_8.resized_height/4-bullet1_2.position_y) < enemy1x2_8.resized_height/2*enemy1x2_8.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[15]=0;
                enemy1x2_8.position(29*size_dm, 216*size_dm);
                enemy1x2_8.setObstacleAlpha(0);
                enemy1x2_8.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }

        if((enemy1x2_8.position_x+enemy1x2_8.resized_width/4-bullet1_3.position_x)*(enemy1x2_8.position_x+enemy1x2_8.resized_width/4-bullet1_3.position_x) < enemy1x2_8.resized_width/2*enemy1x2_8.resized_width/2)
        {
            if((enemy1x2_8.position_y+enemy1x2_8.resized_height/4-bullet1_3.position_y)*(enemy1x2_8.position_y+enemy1x2_8.resized_height/4-bullet1_3.position_y) < enemy1x2_8.resized_height/2*enemy1x2_8.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[15]=0;
                enemy1x2_8.position(29*size_dm, 216*size_dm);
                enemy1x2_8.setObstacleAlpha(0);
                enemy1x2_8.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }

        if((enemy1x2_8.position_x+enemy1x2_8.resized_width/4-bullet1_4.position_x)*(enemy1x2_8.position_x+enemy1x2_8.resized_width/4-bullet1_4.position_x) < enemy1x2_8.resized_width/2*enemy1x2_8.resized_width/2)
        {
            if((enemy1x2_8.position_y+enemy1x2_8.resized_height/4-bullet1_4.position_y)*(enemy1x2_8.position_y+enemy1x2_8.resized_height/4-bullet1_4.position_y) < enemy1x2_8.resized_height/2*enemy1x2_8.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[15]=0;
                enemy1x2_8.position(29*size_dm, 216*size_dm);
                enemy1x2_8.setObstacleAlpha(0);
                enemy1x2_8.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }

        if((enemy1x2_8.position_x+enemy1x2_8.resized_width/4-bullet1_5.position_x)*(enemy1x2_8.position_x+enemy1x2_8.resized_width/4-bullet1_5.position_x) < enemy1x2_8.resized_width/2*enemy1x2_8.resized_width/2)
        {
            if((enemy1x2_8.position_y+enemy1x2_8.resized_height/4-bullet1_5.position_y)*(enemy1x2_8.position_y+enemy1x2_8.resized_height/4-bullet1_5.position_y) < enemy1x2_8.resized_height/2*enemy1x2_8.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[15]=0;
                enemy1x2_8.position(29*size_dm, 216*size_dm);
                enemy1x2_8.setObstacleAlpha(0);
                enemy1x2_8.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////////

        if((enemy1x3_1.position_x+enemy1x3_1.resized_width/4-bullet1_1.position_x)*(enemy1x3_1.position_x+enemy1x3_1.resized_width/4-bullet1_1.position_x) < enemy1x3_1.resized_width/2*enemy1x3_1.resized_width/2)
        {
            if ((enemy1x3_1.position_y + enemy1x3_1.resized_height/4 - bullet1_1.position_y) * (enemy1x3_1.position_y +  enemy1x3_1.resized_height/4 - bullet1_1.position_y) <  enemy1x3_1.resized_height/2* enemy1x3_1.resized_height/2) {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[16]=0;
                enemy1x3_1.position(120*size_dm, 125*size_dm);
                enemy1x3_1.setObstacleAlpha(0);
                enemy1x3_1.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if((enemy1x3_1.position_x+enemy1x3_1.resized_width/4-bullet1_2.position_x)*(enemy1x3_1.position_x+enemy1x3_1.resized_width/4-bullet1_2.position_x) < enemy1x3_1.resized_width/2*enemy1x3_1.resized_width/2)
        {
            if ((enemy1x3_1.position_y + enemy1x3_1.resized_height/4 - bullet1_2.position_y) * (enemy1x3_1.position_y + enemy1x3_1.resized_height/4 -bullet1_2.position_y) < enemy1x3_1.resized_height/2*enemy1x3_1.resized_height/2) {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[16]=0;
                enemy1x3_1.position(120*size_dm, 125*size_dm);
                enemy1x3_1.setObstacleAlpha(0);
                enemy1x3_1.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }

        if((enemy1x3_1.position_x+enemy1x3_1.resized_width/4-bullet1_3.position_x)*(enemy1x3_1.position_x+enemy1x3_1.resized_width/4-bullet1_3.position_x) < enemy1x3_1.resized_width/2*enemy1x3_1.resized_width/2)
        {
            if ((enemy1x3_1.position_y + enemy1x3_1.resized_height/4 - bullet1_3.position_y) * (enemy1x3_1.position_y +enemy1x3_1.resized_height/4 - bullet1_3.position_y) < enemy1x3_1.resized_height/2*enemy1x3_1.resized_height/2) {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[16]=0;
                enemy1x3_1.position(120*size_dm, 125*size_dm);
                enemy1x3_1.setObstacleAlpha(0);
                enemy1x3_1.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }

        if((enemy1x3_1.position_x+enemy1x3_1.resized_width/4-bullet1_4.position_x)*(enemy1x3_1.position_x+enemy1x3_1.resized_width/4-bullet1_4.position_x) < enemy1x3_1.resized_width/2*enemy1x3_1.resized_width/2)
        {
            if ((enemy1x3_1.position_y + enemy1x3_1.resized_height/4 - bullet1_4.position_y) * (enemy1x3_1.position_y + enemy1x3_1.resized_height/4 - bullet1_4.position_y) < enemy1x3_1.resized_height/2*enemy1x3_1.resized_height/2) {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[16]=0;
                enemy1x3_1.position(120*size_dm, 125*size_dm);
                enemy1x3_1.setObstacleAlpha(0);
                enemy1x3_1.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }

        if((enemy1x3_1.position_x+enemy1x3_1.resized_width/4-bullet1_5.position_x)*(enemy1x3_1.position_x+enemy1x3_1.resized_width/4-bullet1_5.position_x) < enemy1x3_1.resized_width/2*enemy1x3_1.resized_width/2)
        {
            if ((enemy1x3_1.position_y + enemy1x3_1.resized_height/4 - bullet1_5.position_y) * (enemy1x3_1.position_y + enemy1x3_1.resized_height/4 - bullet1_5.position_y) < enemy1x3_1.resized_height/2*enemy1x3_1.resized_height/2) {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[16]=0;
                enemy1x3_1.position(120*size_dm, 125*size_dm);
                enemy1x3_1.setObstacleAlpha(0);
                enemy1x3_1.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        if ((enemy1x3_2.position_x + enemy1x3_2.resized_width/4 - bullet1_1.position_x) * (enemy1x3_2.position_x + enemy1x3_2.resized_width/4 - bullet1_1.position_x) < enemy1x3_2.resized_width/2*enemy1x3_2.resized_width/2) {
            if ((enemy1x3_2.position_y + enemy1x3_2.resized_height/4 - bullet1_1.position_y) * (enemy1x3_2.position_y + enemy1x3_2.resized_height/4- bullet1_1.position_y) <  enemy1x3_2.resized_height/2* enemy1x3_2.resized_height/2) {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[17]=0;
                enemy1x3_2.position(107*size_dm, 138*size_dm);
                enemy1x3_2.setObstacleAlpha(0);
                enemy1x3_2.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if ((enemy1x3_2.position_x + enemy1x3_2.resized_width/4-  bullet1_2.position_x) * (enemy1x3_2.position_x + enemy1x3_2.resized_width/4 -  bullet1_2.position_x) <enemy1x3_2.resized_width/2*enemy1x3_2.resized_width/2) {
            if ((enemy1x3_2.position_y + enemy1x3_2.resized_height/4 -  bullet1_2.position_y) * (enemy1x3_2.position_y + enemy1x3_2.resized_height/4-  bullet1_2.position_y) < enemy1x3_2.resized_height/2*enemy1x3_2.resized_height/2) {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[17]=0;
                enemy1x3_2.position(107*size_dm, 138*size_dm);
                enemy1x3_2.setObstacleAlpha(0);
                enemy1x3_2.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }

        if ((enemy1x3_2.position_x + enemy1x3_2.resized_width/4-  bullet1_3.position_x) * (enemy1x3_2.position_x + enemy1x3_2.resized_width/4-  bullet1_3.position_x) < enemy1x3_2.resized_width/2*enemy1x3_2.resized_width/2) {
            if ((enemy1x3_2.position_y + enemy1x3_2.resized_height/4 -  bullet1_3.position_y) * (enemy1x3_2.position_y + enemy1x3_2.resized_height/4 - bullet1_3.position_y) < enemy1x3_2.resized_height/2*enemy1x3_2.resized_height/2) {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[17]=0;
                enemy1x3_2.position(107*size_dm, 138*size_dm);
                enemy1x3_2.setObstacleAlpha(0);
                enemy1x3_2.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }

        if ((enemy1x3_2.position_x + enemy1x3_2.resized_width/4 - bullet1_4.position_x) * (enemy1x3_2.position_x + enemy1x3_2.resized_width/4 - bullet1_4.position_x) < enemy1x3_2.resized_width/2*enemy1x3_2.resized_width/2) {
            if ((enemy1x3_2.position_y + enemy1x3_2.resized_height/4 - bullet1_4.position_y) * (enemy1x3_2.position_y + enemy1x3_2.resized_height/4-  bullet1_4.position_y) < enemy1x3_2.resized_height/2*enemy1x3_2.resized_height/2) {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[17]=0;
                enemy1x3_2.position(107*size_dm, 138*size_dm);
                enemy1x3_2.setObstacleAlpha(0);
                enemy1x3_2.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }

        if ((enemy1x3_2.position_x + enemy1x3_2.resized_width/4 -bullet1_5.position_x) * (enemy1x3_2.position_x + enemy1x3_2.resized_width/4- bullet1_5.position_x) <  enemy1x3_2.resized_width/2* enemy1x3_2.resized_width/2) {
            if ((enemy1x3_2.position_y + enemy1x3_2.resized_height/4 - bullet1_5.position_y) * (enemy1x3_2.position_y + enemy1x3_2.resized_height/4 - bullet1_5.position_y) < enemy1x3_2.resized_height/2*enemy1x3_2.resized_height/2) {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[17]=0;
                enemy1x3_2.position(107*size_dm, 138*size_dm);
                enemy1x3_2.setObstacleAlpha(0);
                enemy1x3_2.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////

        if((enemy1x3_3.position_x+enemy1x3_3.resized_width/4-bullet1_1.position_x)*(enemy1x3_3.position_x+enemy1x3_3.resized_width/4-bullet1_1.position_x) < enemy1x3_3.resized_width/2*enemy1x3_3.resized_width/2)
        {
            if((enemy1x3_3.position_y+enemy1x3_3.resized_height/4-bullet1_1.position_y)*(enemy1x3_3.position_y+enemy1x3_3.resized_height/4-bullet1_1.position_y) < enemy1x3_3.resized_height/2*enemy1x3_3.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[18]=0;
                enemy1x3_3.position(94*size_dm, 151*size_dm);
                enemy1x3_3.setObstacleAlpha(0);
                enemy1x3_3.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if((enemy1x3_3.position_x+enemy1x3_3.resized_width/4-bullet1_2.position_x)*(enemy1x3_3.position_x+enemy1x3_3.resized_width/4-bullet1_2.position_x) < enemy1x3_3.resized_width/2*enemy1x3_3.resized_width/2)
        {
            if((enemy1x3_3.position_y+enemy1x3_3.resized_height/4-bullet1_2.position_y)*(enemy1x3_3.position_y+enemy1x3_3.resized_height/4-bullet1_2.position_y) < enemy1x3_3.resized_height/2*enemy1x3_3.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[18]=0;
                enemy1x3_3.position(94*size_dm, 151*size_dm);
                enemy1x3_3.setObstacleAlpha(0);
                enemy1x3_3.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }


        if((enemy1x3_3.position_x+enemy1x3_3.resized_width/4-bullet1_3.position_x)*(enemy1x3_3.position_x+enemy1x3_3.resized_width/4-bullet1_3.position_x) < enemy1x3_3.resized_width/2*enemy1x3_3.resized_width/2)
        {
            if((enemy1x3_3.position_y+enemy1x3_3.resized_height/4-bullet1_3.position_y)*(enemy1x3_3.position_y+enemy1x3_3.resized_height/4-bullet1_3.position_y) < enemy1x3_3.resized_height/2*enemy1x3_3.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[18]=0;
                enemy1x3_3.position(94*size_dm, 151*size_dm);
                enemy1x3_3.setObstacleAlpha(0);
                enemy1x3_3.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }


        if((enemy1x3_3.position_x+enemy1x3_3.resized_width/4-bullet1_4.position_x)*(enemy1x3_3.position_x+enemy1x3_3.resized_width/4-bullet1_4.position_x) < enemy1x3_3.resized_width/2*enemy1x3_3.resized_width/2)
        {
            if((enemy1x3_3.position_y+enemy1x3_3.resized_height/4-bullet1_4.position_y)*(enemy1x3_3.position_y+enemy1x3_3.resized_height/4-bullet1_4.position_y) < enemy1x3_3.resized_height/2*enemy1x3_3.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[18]=0;
                enemy1x3_3.position(94*size_dm, 151*size_dm);
                enemy1x3_3.setObstacleAlpha(0);
                enemy1x3_3.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }

        if((enemy1x3_3.position_x+enemy1x3_3.resized_width/4-bullet1_5.position_x)*(enemy1x3_3.position_x+enemy1x3_3.resized_width/4-bullet1_5.position_x) < enemy1x3_3.resized_width/2*enemy1x3_3.resized_width/2)
        {
            if((enemy1x3_3.position_y+enemy1x3_3.resized_height/4-bullet1_5.position_y)*(enemy1x3_3.position_y+enemy1x3_3.resized_height/4-bullet1_5.position_y) < enemy1x3_3.resized_height/2*enemy1x3_3.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[18]=0;
                enemy1x3_3.position(94*size_dm, 151*size_dm);
                enemy1x3_3.setObstacleAlpha(0);
                enemy1x3_3.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }

        //////////////////////////////////////////////////////////////////////////////////////

        if((enemy1x3_4.position_x+enemy1x3_4.resized_width/4-bullet1_1.position_x)*(enemy1x3_4.position_x+enemy1x3_4.resized_width/4-bullet1_1.position_x) < enemy1x3_4.resized_width/2*enemy1x3_4.resized_width/2)
        {
            if((enemy1x3_4.position_y+enemy1x3_4.resized_height/4-bullet1_1.position_y)*(enemy1x3_4.position_y+enemy1x3_4.resized_height/4-bullet1_1.position_y) < enemy1x3_4.resized_height/2*enemy1x3_4.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[19]=0;
                enemy1x3_4.position(81*size_dm, 164*size_dm);
                enemy1x3_4.setObstacleAlpha(0);
                enemy1x3_4.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }
        if((enemy1x3_4.position_x+enemy1x3_4.resized_width/4-bullet1_2.position_x)*(enemy1x3_4.position_x+enemy1x3_4.resized_width/4-bullet1_2.position_x) < enemy1x3_4.resized_width/2*enemy1x3_4.resized_width/2)
        {
            if((enemy1x3_4.position_y+enemy1x3_4.resized_height/4-bullet1_2.position_y)*(enemy1x3_4.position_y+enemy1x3_4.resized_height/4-bullet1_2.position_y) < enemy1x3_4.resized_height/2*enemy1x3_4.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[19]=0;
                enemy1x3_4.position(81*size_dm, 164*size_dm);
                enemy1x3_4.setObstacleAlpha(0);
                enemy1x3_4.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }
        if((enemy1x3_4.position_x+enemy1x3_4.resized_width/4-bullet1_3.position_x)*(enemy1x3_4.position_x+enemy1x3_4.resized_width/4-bullet1_3.position_x) < enemy1x3_4.resized_width/2*enemy1x3_4.resized_width/2)
        {
            if((enemy1x3_4.position_y+enemy1x3_4.resized_height/4-bullet1_3.position_y)*(enemy1x3_4.position_y+enemy1x3_4.resized_height/4-bullet1_3.position_y) < enemy1x3_4.resized_height/2*enemy1x3_4.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[19]=0;
                enemy1x3_4.position(81*size_dm, 164*size_dm);
                enemy1x3_4.setObstacleAlpha(0);
                enemy1x3_4.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();

            }
        }
        if((enemy1x3_4.position_x+enemy1x3_4.resized_width/4-bullet1_4.position_x)*(enemy1x3_4.position_x+enemy1x3_4.resized_width/4-bullet1_4.position_x) < enemy1x3_4.resized_width/2*enemy1x3_4.resized_width/2)
        {
            if((enemy1x3_4.position_y+enemy1x3_4.resized_height/4-bullet1_4.position_y)*(enemy1x3_4.position_y+enemy1x3_4.resized_height/4-bullet1_4.position_y) <enemy1x3_4.resized_height/2*enemy1x3_4.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[19]=0;
                enemy1x3_4.position(81*size_dm, 164*size_dm);
                enemy1x3_4.setObstacleAlpha(0);
                enemy1x3_4.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }
        if((enemy1x3_4.position_x+enemy1x3_4.resized_width/4-bullet1_5.position_x)*(enemy1x3_4.position_x+enemy1x3_4.resized_width/4-bullet1_5.position_x) <enemy1x3_4.resized_width/2*enemy1x3_4.resized_width/2)
        {
            if((enemy1x3_4.position_y+enemy1x3_4.resized_height/4-bullet1_5.position_y)*(enemy1x3_4.position_y+enemy1x3_4.resized_height/4-bullet1_5.position_y) < enemy1x3_4.resized_height/2*enemy1x3_4.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[19]=0;
                enemy1x3_4.position(81*size_dm, 164*size_dm);
                enemy1x3_4.setObstacleAlpha(0);
                enemy1x3_4.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }
        /////////////////////////////////////////////////////////////////////////////////////////////////////////

        if((enemy1x3_5.position_x+enemy1x3_5.resized_width/4-bullet1_1.position_x)*(enemy1x3_5.position_x+enemy1x3_5.resized_width/4-bullet1_1.position_x) < enemy1x3_5.resized_width/2*enemy1x3_5.resized_width/2)
        {
            if((enemy1x3_5.position_y+enemy1x3_5.resized_height/4-bullet1_1.position_y)*(enemy1x3_5.position_y+enemy1x3_5.resized_height/4-bullet1_1.position_y) < enemy1x3_5.resized_height/2*enemy1x3_5.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[20]=0;
                enemy1x3_5.position(68*size_dm, 177*size_dm);
                enemy1x3_5.setObstacleAlpha(0);
                enemy1x3_5.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if((enemy1x3_5.position_x+enemy1x3_5.resized_width/4-bullet1_2.position_x)*(enemy1x3_5.position_x+enemy1x3_5.resized_width/4-bullet1_2.position_x) < enemy1x3_5.resized_width/2*enemy1x3_5.resized_width/2)
        {
            if((enemy1x3_5.position_y+enemy1x3_5.resized_height/4-bullet1_2.position_y)*(enemy1x3_5.position_y+enemy1x3_5.resized_height/4-bullet1_2.position_y) < enemy1x3_5.resized_height/2*enemy1x3_5.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[20]=0;
                enemy1x3_5.position(68*size_dm, 177*size_dm);
                enemy1x3_5.setObstacleAlpha(0);
                enemy1x3_5.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }


        if((enemy1x3_5.position_x+enemy1x3_5.resized_width/4-bullet1_3.position_x)*(enemy1x3_5.position_x+enemy1x3_5.resized_width/4-bullet1_3.position_x) < enemy1x3_5.resized_width/2*enemy1x3_5.resized_width/2)
        {
            if((enemy1x3_5.position_y+enemy1x3_5.resized_height/4-bullet1_3.position_y)*(enemy1x3_5.position_y+enemy1x3_5.resized_height/4-bullet1_3.position_y) < enemy1x3_5.resized_height/2*enemy1x3_5.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[20]=0;
                enemy1x3_5.position(68*size_dm, 177*size_dm);
                enemy1x3_5.setObstacleAlpha(0);
                enemy1x3_5.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }


        if((enemy1x3_5.position_x+enemy1x3_5.resized_width/4-bullet1_4.position_x)*(enemy1x3_5.position_x+enemy1x3_5.resized_width/4-bullet1_4.position_x) < enemy1x3_5.resized_width/2*enemy1x3_5.resized_width/2)
        {
            if((enemy1x3_5.position_y+enemy1x3_5.resized_height/4-bullet1_4.position_y)*(enemy1x3_5.position_y+enemy1x3_5.resized_height/4-bullet1_4.position_y) <enemy1x3_5.resized_height/2*enemy1x3_5.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[20]=0;
                enemy1x3_5.position(68*size_dm, 177*size_dm);
                enemy1x3_5.setObstacleAlpha(0);
                enemy1x3_5.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }


        if((enemy1x3_5.position_x+enemy1x3_5.resized_width/4-bullet1_5.position_x)*(enemy1x3_5.position_x+enemy1x3_5.resized_width/4-bullet1_5.position_x) < enemy1x3_5.resized_width/2*enemy1x3_5.resized_width/2)
        {
            if((enemy1x3_5.position_y+enemy1x3_5.resized_height/4-bullet1_5.position_y)*(enemy1x3_5.position_y+enemy1x3_5.resized_height/4-bullet1_5.position_y) < enemy1x3_5.resized_height/2*enemy1x3_5.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[20]=0;
                enemy1x3_5.position(68*size_dm, 177*size_dm);
                enemy1x3_5.setObstacleAlpha(0);
                enemy1x3_5.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }


        /////////////////////////////////////////////////////////////////////////////////////////////////////////////

        if((enemy1x3_6.position_x+enemy1x3_6.resized_width/4-bullet1_1.position_x)*(enemy1x3_6.position_x+enemy1x3_6.resized_width/4-bullet1_1.position_x) < enemy1x3_6.resized_width/2*enemy1x3_6.resized_width/2)
        {
            if((enemy1x3_6.position_y+enemy1x3_6.resized_height/4-bullet1_1.position_y)*(enemy1x3_6.position_y+enemy1x3_6.resized_height/4-bullet1_1.position_y) < enemy1x3_6.resized_height/2*enemy1x3_6.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[21]=0;
                enemy1x3_6.position(55*size_dm, 190*size_dm);
                enemy1x3_6.setObstacleAlpha(0);
                enemy1x3_6.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if((enemy1x3_6.position_x+enemy1x3_6.resized_width/4-bullet1_2.position_x)*(enemy1x3_6.position_x+enemy1x3_6.resized_width/4-bullet1_2.position_x) < enemy1x3_6.resized_width/2*enemy1x3_6.resized_width/2)
        {
            if((enemy1x3_6.position_y+enemy1x3_6.resized_height/4-bullet1_2.position_y)*(enemy1x3_6.position_y+enemy1x3_6.resized_height/4-bullet1_2.position_y) < enemy1x3_6.resized_height/2*enemy1x3_6.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[21]=0;
                enemy1x3_6.position(55*size_dm, 190*size_dm);
                enemy1x3_6.setObstacleAlpha(0);
                enemy1x3_6.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }

        if((enemy1x3_6.position_x+enemy1x3_6.resized_width/4-bullet1_3.position_x)*(enemy1x3_6.position_x+enemy1x3_6.resized_width/4-bullet1_3.position_x) < enemy1x3_6.resized_width/2*enemy1x3_6.resized_width/2)
        {
            if((enemy1x3_6.position_y+enemy1x3_6.resized_height/4-bullet1_3.position_y)*(enemy1x3_6.position_y+enemy1x3_6.resized_height/4-bullet1_3.position_y) < enemy1x3_6.resized_height/2*enemy1x3_6.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[21]=0;
                enemy1x3_6.position(55*size_dm, 190*size_dm);
                enemy1x3_6.setObstacleAlpha(0);
                enemy1x3_6.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }

        if((enemy1x3_6.position_x+enemy1x3_6.resized_width/4-bullet1_4.position_x)*(enemy1x3_6.position_x+enemy1x3_6.resized_width/4-bullet1_4.position_x) < enemy1x3_6.resized_width/2*enemy1x3_6.resized_width/2)
        {
            if((enemy1x3_6.position_y+enemy1x3_6.resized_height/4-bullet1_4.position_y)*(enemy1x3_6.position_y+enemy1x3_6.resized_height/4-bullet1_4.position_y) < enemy1x3_6.resized_height/2*enemy1x3_6.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[21]=0;
                enemy1x3_6.position(55*size_dm, 190*size_dm);
                enemy1x3_6.setObstacleAlpha(0);
                enemy1x3_6.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }

        if((enemy1x3_6.position_x+enemy1x3_6.resized_width/4-bullet1_5.position_x)*(enemy1x3_6.position_x+enemy1x3_6.resized_width/4-bullet1_5.position_x) < enemy1x3_6.resized_width/2*enemy1x3_6.resized_width/2)
        {
            if((enemy1x3_6.position_y+enemy1x3_6.resized_height/4-bullet1_5.position_y)*(enemy1x3_6.position_y+enemy1x3_6.resized_height/4-bullet1_5.position_y) < enemy1x3_6.resized_height/2*enemy1x3_6.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[21]=0;
                enemy1x3_6.position(55*size_dm, 190*size_dm);
                enemy1x3_6.setObstacleAlpha(0);
                enemy1x3_6.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        if((enemy1x3_7.position_x+enemy1x3_7.resized_width/4-bullet1_1.position_x)*(enemy1x3_7.position_x+enemy1x3_7.resized_width/4-bullet1_1.position_x) < enemy1x3_7.resized_width/2*enemy1x3_7.resized_width/2)
        {
            if((enemy1x3_7.position_y+enemy1x3_7.resized_height/4-bullet1_1.position_y)*(enemy1x3_7.position_y+enemy1x3_7.resized_height/4-bullet1_1.position_y) <enemy1x3_7.resized_height/2*enemy1x3_7.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[22]=0;
                enemy1x3_7.position(42*size_dm, 203*size_dm);
                enemy1x3_7.setObstacleAlpha(0);
                enemy1x3_7.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if((enemy1x3_7.position_x+enemy1x3_7.resized_width/4-bullet1_2.position_x)*(enemy1x3_7.position_x+enemy1x3_7.resized_width/4-bullet1_2.position_x) <enemy1x3_7.resized_width/2*enemy1x3_7.resized_width/2)
        {
            if((enemy1x3_7.position_y+enemy1x3_7.resized_height/4-bullet1_2.position_y)*(enemy1x3_7.position_y+enemy1x3_7.resized_height/4-bullet1_2.position_y) <enemy1x3_7.resized_height/2*enemy1x3_7.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[22]=0;
                enemy1x3_7.position(42*size_dm, 203*size_dm);
                enemy1x3_7.setObstacleAlpha(0);
                enemy1x3_7.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }

        if((enemy1x3_7.position_x+enemy1x3_7.resized_width/4-bullet1_3.position_x)*(enemy1x3_7.position_x+enemy1x3_7.resized_width/4-bullet1_3.position_x) < enemy1x3_7.resized_width/2*enemy1x3_7.resized_width/2)
        {
            if((enemy1x3_7.position_y+enemy1x3_7.resized_height/4-bullet1_3.position_y)*(enemy1x3_7.position_y+enemy1x3_7.resized_height/4-bullet1_3.position_y) <enemy1x3_7.resized_height/2*enemy1x3_7.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[22]=0;
                enemy1x3_7.position(42*size_dm, 203*size_dm);
                enemy1x3_7.setObstacleAlpha(0);
                enemy1x3_7.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }

        if((enemy1x3_7.position_x+enemy1x3_7.resized_width/4-bullet1_4.position_x)*(enemy1x3_7.position_x+enemy1x3_7.resized_width/4-bullet1_4.position_x) < enemy1x3_7.resized_width/2*enemy1x3_7.resized_width/2)
        {
            if((enemy1x3_7.position_y+enemy1x3_7.resized_height/4-bullet1_4.position_y)*(enemy1x3_7.position_y+enemy1x3_7.resized_height/4-bullet1_4.position_y) <enemy1x3_7.resized_height/2*enemy1x3_7.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[22]=0;
                enemy1x3_7.position(42*size_dm, 203*size_dm);
                enemy1x3_7.setObstacleAlpha(0);
                enemy1x3_7.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }

        if((enemy1x3_7.position_x+enemy1x3_7.resized_width/4-bullet1_5.position_x)*(enemy1x3_7.position_x+enemy1x3_7.resized_width/4-bullet1_5.position_x) < enemy1x3_7.resized_width/2*enemy1x3_7.resized_width/2)
        {
            if((enemy1x3_7.position_y+enemy1x3_7.resized_height/4-bullet1_5.position_y)*(enemy1x3_7.position_y+enemy1x3_7.resized_height/4-bullet1_5.position_y) <enemy1x3_7.resized_height/2*enemy1x3_7.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[22]=0;
                enemy1x3_7.position(42*size_dm, 203*size_dm);
                enemy1x3_7.setObstacleAlpha(0);
                enemy1x3_7.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////////

        if((enemy1x3_8.position_x+enemy1x3_8.resized_width/4-bullet1_1.position_x)*(enemy1x3_8.position_x+enemy1x3_8.resized_width/4-bullet1_1.position_x) < enemy1x3_8.resized_width/2*enemy1x3_8.resized_width/2)
        {
            if((enemy1x3_8.position_y+enemy1x3_8.resized_height/4-bullet1_1.position_y)*(enemy1x3_8.position_y+enemy1x3_8.resized_height/4-bullet1_1.position_y) < enemy1x3_8.resized_height/2*enemy1x3_8.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[23]=0;
                enemy1x3_8.position(29*size_dm, 216*size_dm);
                enemy1x3_8.setObstacleAlpha(0);
                enemy1x3_8.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if((enemy1x3_8.position_x+enemy1x3_8.resized_width/4-bullet1_2.position_x)*(enemy1x3_8.position_x+enemy1x3_8.resized_width/4-bullet1_2.position_x) < enemy1x3_8.resized_width/2*enemy1x3_8.resized_width/2)
        {
            if((enemy1x3_8.position_y+enemy1x3_8.resized_height/4-bullet1_2.position_y)*(enemy1x3_8.position_y+enemy1x3_8.resized_height/4-bullet1_2.position_y) < enemy1x3_8.resized_height/2*enemy1x3_8.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[23]=0;
                enemy1x3_8.position(29*size_dm, 216*size_dm);
                enemy1x3_8.setObstacleAlpha(0);
                enemy1x3_8.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }

        if((enemy1x3_8.position_x+enemy1x3_8.resized_width/4-bullet1_3.position_x)*(enemy1x3_8.position_x+enemy1x3_8.resized_width/4-bullet1_3.position_x) < enemy1x3_8.resized_width/2*enemy1x3_8.resized_width/2)
        {
            if((enemy1x3_8.position_y+enemy1x3_8.resized_height/4-bullet1_3.position_y)*(enemy1x3_8.position_y+enemy1x3_8.resized_height/4-bullet1_3.position_y) < enemy1x3_8.resized_height/2*enemy1x3_8.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[23]=0;
                enemy1x3_8.position(29*size_dm, 216*size_dm);
                enemy1x3_8.setObstacleAlpha(0);
                enemy1x3_8.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }

        if((enemy1x3_8.position_x+enemy1x3_8.resized_width/4-bullet1_4.position_x)*(enemy1x3_8.position_x+enemy1x3_8.resized_width/4-bullet1_4.position_x) < enemy1x3_8.resized_width/2*enemy1x3_8.resized_width/2)
        {
            if((enemy1x3_8.position_y+enemy1x3_8.resized_height/4-bullet1_4.position_y)*(enemy1x3_8.position_y+enemy1x3_8.resized_height/4-bullet1_4.position_y) < enemy1x3_8.resized_height/2*enemy1x3_8.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[23]=0;
                enemy1x3_8.position(29*size_dm, 216*size_dm);
                enemy1x3_8.setObstacleAlpha(0);
                enemy1x3_8.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }

        if((enemy1x3_8.position_x+enemy1x3_8.resized_width/4-bullet1_5.position_x)*(enemy1x3_8.position_x+enemy1x3_8.resized_width/4-bullet1_5.position_x) < enemy1x3_8.resized_width/2*enemy1x3_8.resized_width/2)
        {
            if((enemy1x3_8.position_y+enemy1x3_8.resized_height/4-bullet1_5.position_y)*(enemy1x3_8.position_y+enemy1x3_8.resized_height/4-bullet1_5.position_y) < enemy1x3_8.resized_height/2*enemy1x3_8.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[23]=0;
                enemy1x3_8.position(29*size_dm, 216*size_dm);
                enemy1x3_8.setObstacleAlpha(0);
                enemy1x3_8.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////////
        if((enemy2_1.position_x+enemy2_1.resized_width/4-bullet1_1.position_x)*(enemy2_1.position_x+enemy2_1.resized_width/4-bullet1_1.position_x) <enemy2_1.resized_width/2*enemy2_1.resized_width/2)
        {
            if((enemy2_1.position_y+enemy2_1.resized_height/4-bullet1_1.position_y)*(enemy2_1.position_y+enemy2_1.resized_height/4-bullet1_1.position_y) <enemy2_1.resized_height/2*enemy2_1.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[24]=0;
                enemy2_1.position(189*size_dm, 125*size_dm);
                enemy2_1.setObstacleAlpha(0);
                enemy2_1.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if((enemy2_1.position_x+enemy2_1.resized_width/4-bullet1_2.position_x)*(enemy2_1.position_x+enemy2_1.resized_width/4-bullet1_2.position_x) < enemy2_1.resized_width/2*enemy2_1.resized_width/2)
        {
            if((enemy2_1.position_y+enemy2_1.resized_height/4-bullet1_2.position_y)*(enemy2_1.position_y+enemy2_1.resized_height/4-bullet1_2.position_y) <enemy2_1.resized_height/2*enemy2_1.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[24]=0;
                enemy2_1.position(189*size_dm, 125*size_dm);
                enemy2_1.setObstacleAlpha(0);
                enemy2_1.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }

        if((enemy2_1.position_x+enemy2_1.resized_width/4-bullet1_3.position_x)*(enemy2_1.position_x+enemy2_1.resized_width/4-bullet1_3.position_x) < enemy2_1.resized_width/2*enemy2_1.resized_width/2)
        {
            if((enemy2_1.position_y+enemy2_1.resized_height/4-bullet1_3.position_y)*(enemy2_1.position_y+enemy2_1.resized_height/4-bullet1_3.position_y) <enemy2_1.resized_height/2*enemy2_1.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[24]=0;
                enemy2_1.position(189*size_dm, 125*size_dm);
                enemy2_1.setObstacleAlpha(0);
                enemy2_1.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }

        if((enemy2_1.position_x+enemy2_1.resized_width/4-bullet1_4.position_x)*(enemy2_1.position_x+enemy2_1.resized_width/4-bullet1_4.position_x) < enemy2_1.resized_width/2*enemy2_1.resized_width/2)
        {
            if((enemy2_1.position_y+enemy2_1.resized_height/4-bullet1_4.position_y)*(enemy2_1.position_y+enemy2_1.resized_height/4-bullet1_4.position_y) <enemy2_1.resized_height/2*enemy2_1.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[24]=0;
                enemy2_1.position(189*size_dm, 125*size_dm);
                enemy2_1.setObstacleAlpha(0);
                enemy2_1.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }

        if((enemy2_1.position_x+enemy2_1.resized_width/4-bullet1_5.position_x)*(enemy2_1.position_x+enemy2_1.resized_width/4-bullet1_5.position_x) < enemy2_1.resized_width/2*enemy2_1.resized_width/2)
        {
            if((enemy2_1.position_y+enemy2_1.resized_height/4-bullet1_5.position_y)*(enemy2_1.position_y+enemy2_1.resized_height/4-bullet1_5.position_y) <enemy2_1.resized_height/2*enemy2_1.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[24]=0;
                enemy2_1.position(189*size_dm, 125*size_dm);
                enemy2_1.setObstacleAlpha(0);
                enemy2_1.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////
        if ((enemy2_2.position_x + enemy2_2.resized_width/4 - bullet1_1.position_x) * (enemy2_2.position_x + enemy2_2.resized_width/4 - bullet1_1.position_x) < enemy2_2.resized_width/2 * enemy2_2.resized_width/2) {
            if ((enemy2_2.position_y + enemy2_2.resized_height/4 - bullet1_1.position_y) * (enemy2_2.position_y + enemy2_2.resized_height/4 - bullet1_1.position_y) < enemy2_2.resized_height/2 * enemy2_2.resized_height/2) {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[25] = 0;
                enemy2_2.position(202*size_dm, 138*size_dm);
                enemy2_2.setObstacleAlpha(0);
                enemy2_2.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if ((enemy2_2.position_x + enemy2_2.resized_width/4 - bullet1_2.position_x) * (enemy2_2.position_x + enemy2_2.resized_width/4- bullet1_2.position_x) < enemy2_2.resized_width/2 * enemy2_2.resized_width/2) {
            if ((enemy2_2.position_y + enemy2_2.resized_height/4 - bullet1_2.position_y) * (enemy2_2.position_y + enemy2_2.resized_height/4- bullet1_2.position_y) < enemy2_2.resized_height/2 * enemy2_2.resized_height/2) {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[25] = 0;
                enemy2_2.position(202*size_dm, 138*size_dm);
                enemy2_2.setObstacleAlpha(0);
                enemy2_2.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }

        if ((enemy2_2.position_x + enemy2_2.resized_width/4 - bullet1_3.position_x) * (enemy2_2.position_x + enemy2_2.resized_width/4 - bullet1_3.position_x) < enemy2_2.resized_width/2 * enemy2_2.resized_width/2) {
            if ((enemy2_2.position_y + enemy2_2.resized_height/4 - bullet1_3.position_y) * (enemy2_2.position_y + enemy2_2.resized_height/4- bullet1_3.position_y) < enemy2_2.resized_height/2 * enemy2_2.resized_height/2) {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[25] = 0;
                enemy2_2.position(202*size_dm, 138*size_dm);
                enemy2_2.setObstacleAlpha(0);
                enemy2_2.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }
        if ((enemy2_2.position_x + enemy2_2.resized_width/4 - bullet1_4.position_x) * (enemy2_2.position_x + enemy2_2.resized_width/4 - bullet1_4.position_x) < enemy2_2.resized_width/2 * enemy2_2.resized_width/2) {
            if ((enemy2_2.position_y + enemy2_2.resized_height/4 - bullet1_4.position_y) * (enemy2_2.position_y + enemy2_2.resized_height/4 - bullet1_4.position_y) <enemy2_2.resized_height/2 * enemy2_2.resized_height/2) {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[25] = 0;
                enemy2_2.position(202*size_dm, 138*size_dm);
                enemy2_2.setObstacleAlpha(0);
                enemy2_2.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }
        if ((enemy2_2.position_x + enemy2_2.resized_width/4 - bullet1_5.position_x) * (enemy2_2.position_x + enemy2_2.resized_width/4 - bullet1_5.position_x) <enemy2_2.resized_width/2 * enemy2_2.resized_width/2) {
            if ((enemy2_2.position_y + enemy2_2.resized_height/4 - bullet1_5.position_y) * (enemy2_2.position_y + enemy2_2.resized_height/4 - bullet1_5.position_y) < enemy2_2.resized_height/2 * enemy2_2.resized_height/2) {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[25] = 0;
                enemy2_2.position(202*size_dm, 138*size_dm);
                enemy2_2.setObstacleAlpha(0);
                enemy2_2.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }



        ///////////////////////////////////////////////////////////////////////////

        if((enemy2_3.position_x+enemy2_3.resized_width/4-bullet1_1.position_x)*(enemy2_3.position_x+enemy2_3.resized_width/4-bullet1_1.position_x) < enemy2_3.resized_width/2*enemy2_3.resized_width/2)
        {
            if((enemy2_3.position_y+enemy2_3.resized_height/4-bullet1_1.position_y)*(enemy2_3.position_y+enemy2_3.resized_height/4-bullet1_1.position_y) < enemy2_3.resized_height/2*enemy2_3.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[26] = 0;
                enemy2_3.position(215*size_dm, 151*size_dm);
                enemy2_3.setObstacleAlpha(0);
                enemy2_3.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if((enemy2_3.position_x+enemy2_3.resized_width/4-bullet1_2.position_x)*(enemy2_3.position_x+enemy2_3.resized_width/4-bullet1_2.position_x) < enemy2_3.resized_width/2*enemy2_3.resized_width/2)
        {
            if((enemy2_3.position_y+enemy2_3.resized_height/4-bullet1_2.position_y)*(enemy2_3.position_y+enemy2_3.resized_height/4-bullet1_2.position_y) < enemy2_3.resized_height/2*enemy2_3.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[26] = 0;
                enemy2_3.position(215*size_dm, 151*size_dm);
                enemy2_3.setObstacleAlpha(0);
                enemy2_3.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }

        if((enemy2_3.position_x+enemy2_3.resized_width/4-bullet1_3.position_x)*(enemy2_3.position_x+enemy2_3.resized_width/4-bullet1_3.position_x) < enemy2_3.resized_width/2*enemy2_3.resized_width/2)
        {
            if((enemy2_3.position_y+enemy2_3.resized_height/4-bullet1_3.position_y)*(enemy2_3.position_y+enemy2_3.resized_height/4-bullet1_3.position_y) < enemy2_3.resized_height/2*enemy2_3.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[26] = 0;
                enemy2_3.position(215*size_dm, 151*size_dm);
                enemy2_3.setObstacleAlpha(0);
                enemy2_3.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }

        if((enemy2_3.position_x+enemy2_3.resized_width/4-bullet1_4.position_x)*(enemy2_3.position_x+enemy2_3.resized_width/4-bullet1_4.position_x) < enemy2_3.resized_width/2*enemy2_3.resized_width/2)
        {
            if((enemy2_3.position_y+enemy2_3.resized_height/4-bullet1_4.position_y)*(enemy2_3.position_y+enemy2_3.resized_height/4-bullet1_4.position_y) < enemy2_3.resized_height/2*enemy2_3.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[26] = 0;
                enemy2_3.position(215*size_dm, 151*size_dm);
                enemy2_3.setObstacleAlpha(0);
                enemy2_3.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }

        if((enemy2_3.position_x+enemy2_3.resized_width/4-bullet1_5.position_x)*(enemy2_3.position_x+enemy2_3.resized_width/4-bullet1_5.position_x) < enemy2_3.resized_width/2*enemy2_3.resized_width/2)
        {
            if((enemy2_3.position_y+enemy2_3.resized_height/4-bullet1_5.position_y)*(enemy2_3.position_y+enemy2_3.resized_height/4-bullet1_5.position_y) < enemy2_3.resized_height/2*enemy2_3.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[26] = 0;
                enemy2_3.position(215*size_dm, 151*size_dm);
                enemy2_3.setObstacleAlpha(0);
                enemy2_3.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }


        ////////////////////////////////////////////////////////////////////////////////////////

        if((enemy2_4.position_x+enemy2_4.resized_width/4-bullet1_1.position_x)*(enemy2_4.position_x+enemy2_4.resized_width/4-bullet1_1.position_x) < enemy2_4.resized_width/2*enemy2_4.resized_width/2)
        {
            if((enemy2_4.position_y+enemy2_4.resized_height/4-bullet1_1.position_y)*(enemy2_4.position_y+enemy2_4.resized_height/4-bullet1_1.position_y) < enemy2_4.resized_height/2*enemy2_4.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[27] = 0;
                enemy2_4.position(228*size_dm, 164*size_dm);
                enemy2_4.setObstacleAlpha(0);
                enemy2_4.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if((enemy2_4.position_x+enemy2_4.resized_width/4-bullet1_2.position_x)*(enemy2_4.position_x+enemy2_4.resized_width/4-bullet1_2.position_x) < enemy2_4.resized_width/2*enemy2_4.resized_width/2)
        {
            if((enemy2_4.position_y+enemy2_4.resized_height/4-bullet1_2.position_y)*(enemy2_4.position_y+enemy2_4.resized_height/4-bullet1_2.position_y) < enemy2_4.resized_height/2*enemy2_4.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[27] = 0;
                enemy2_4.position(228*size_dm, 164*size_dm);
                enemy2_4.setObstacleAlpha(0);
                enemy2_4.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }

        if((enemy2_4.position_x+enemy2_4.resized_width/4-bullet1_3.position_x)*(enemy2_4.position_x+enemy2_4.resized_width/4-bullet1_3.position_x) < enemy2_4.resized_width/2*enemy2_4.resized_width/2)
        {
            if((enemy2_4.position_y+enemy2_4.resized_height/4-bullet1_3.position_y)*(enemy2_4.position_y+enemy2_4.resized_height/4-bullet1_3.position_y) < enemy2_4.resized_height/2*enemy2_4.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[27] = 0;
                enemy2_4.position(228*size_dm, 164*size_dm);
                enemy2_4.setObstacleAlpha(0);
                enemy2_4.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }

        if((enemy2_4.position_x+enemy2_4.resized_width/4-bullet1_4.position_x)*(enemy2_4.position_x+enemy2_4.resized_width/4-bullet1_4.position_x) < enemy2_4.resized_width/2*enemy2_4.resized_width/2)
        {
            if((enemy2_4.position_y+enemy2_4.resized_height/4-bullet1_4.position_y)*(enemy2_4.position_y+enemy2_4.resized_height/4-bullet1_4.position_y) < enemy2_4.resized_height/2*enemy2_4.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[27] = 0;
                enemy2_4.position(228*size_dm, 164*size_dm);
                enemy2_4.setObstacleAlpha(0);
                enemy2_4.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }

        if((enemy2_4.position_x+enemy2_4.resized_width/4-bullet1_5.position_x)*(enemy2_4.position_x+enemy2_4.resized_width/4-bullet1_5.position_x) < enemy2_4.resized_width/2*enemy2_4.resized_width/2)
        {
            if((enemy2_4.position_y+enemy2_4.resized_height/4-bullet1_5.position_y)*(enemy2_4.position_y+enemy2_4.resized_height/4-bullet1_5.position_y) < enemy2_4.resized_height/2*enemy2_4.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[27] = 0;
                enemy2_4.position(228*size_dm, 164*size_dm);
                enemy2_4.setObstacleAlpha(0);
                enemy2_4.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        if((enemy2_5.position_x+enemy2_5.resized_width/4-bullet1_1.position_x)*(enemy2_5.position_x+enemy2_5.resized_width/4-bullet1_1.position_x) <enemy2_5.resized_width/2*enemy2_5.resized_width/2)
        {
            if((enemy2_5.position_y+enemy2_5.resized_height/4-bullet1_1.position_y)*(enemy2_5.position_y+enemy2_5.resized_height/4-bullet1_1.position_y) < enemy2_5.resized_height/2*enemy2_5.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[28] = 0;
                enemy2_5.position(241*size_dm, 177*size_dm);
                enemy2_5.setObstacleAlpha(0);
                enemy2_5.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if((enemy2_5.position_x+enemy2_5.resized_width/4-bullet1_2.position_x)*(enemy2_5.position_x+enemy2_5.resized_width/4-bullet1_2.position_x) <enemy2_5.resized_width/2*enemy2_5.resized_width/2)
        {
            if((enemy2_5.position_y+enemy2_5.resized_height/4-bullet1_2.position_y)*(enemy2_5.position_y+enemy2_5.resized_height/4-bullet1_2.position_y) < enemy2_5.resized_height/2*enemy2_5.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[28] = 0;
                enemy2_5.position(241*size_dm, 177*size_dm);
                enemy2_5.setObstacleAlpha(0);
                enemy2_5.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }

        if((enemy2_5.position_x+enemy2_5.resized_width/4-bullet1_3.position_x)*(enemy2_5.position_x+enemy2_5.resized_width/4-bullet1_3.position_x) <enemy2_5.resized_width/2*enemy2_5.resized_width/2)
        {
            if((enemy2_5.position_y+enemy2_5.resized_height/4-bullet1_3.position_y)*(enemy2_5.position_y+enemy2_5.resized_height/4-bullet1_3.position_y) < enemy2_5.resized_height/2*enemy2_5.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[28] = 0;
                enemy2_5.position(241*size_dm, 177*size_dm);
                enemy2_5.setObstacleAlpha(0);
                enemy2_5.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }

        if((enemy2_5.position_x+enemy2_5.resized_width/4-bullet1_4.position_x)*(enemy2_5.position_x+enemy2_5.resized_width/4-bullet1_4.position_x) <enemy2_5.resized_width/2*enemy2_5.resized_width/2)
        {
            if((enemy2_5.position_y+enemy2_5.resized_height/4-bullet1_4.position_y)*(enemy2_5.position_y+enemy2_5.resized_height/4-bullet1_4.position_y) <enemy2_5.resized_height/2*enemy2_5.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[28] = 0;
                enemy2_5.position(241*size_dm, 177*size_dm);
                enemy2_5.setObstacleAlpha(0);
                enemy2_5.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }

        if((enemy2_5.position_x+enemy2_5.resized_width/4-bullet1_5.position_x)*(enemy2_5.position_x+enemy2_5.resized_width/4-bullet1_5.position_x) <enemy2_5.resized_width/2*enemy2_5.resized_width/2)
        {
            if((enemy2_5.position_y+enemy2_5.resized_height/4-bullet1_5.position_y)*(enemy2_5.position_y+enemy2_5.resized_height/4-bullet1_5.position_y) < enemy2_5.resized_height/2*enemy2_5.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[28] = 0;
                enemy2_5.position(241*size_dm, 177*size_dm);
                enemy2_5.setObstacleAlpha(0);
                enemy2_5.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }

        //////////////////////////////////////////////////////////////////////////////////////////////////////

        if((enemy2_6.position_x+enemy2_6.resized_width/4-bullet1_1.position_x)*(enemy2_6.position_x+enemy2_6.resized_width/4-bullet1_1.position_x) < enemy2_6.resized_width/2*enemy2_6.resized_width/2)
        {
            if((enemy2_6.position_y+enemy2_6.resized_height/4-bullet1_1.position_y)*(enemy2_6.position_y+enemy2_6.resized_height/4-bullet1_1.position_y) < enemy2_6.resized_height/2*enemy2_6.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[29] = 0;
                enemy2_6.position(254*size_dm, 190*size_dm);
                enemy2_6.setObstacleAlpha(0);
                enemy2_6.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if((enemy2_6.position_x+enemy2_6.resized_width/4-bullet1_2.position_x)*(enemy2_6.position_x+enemy2_6.resized_width/4-bullet1_2.position_x) < enemy2_6.resized_width/2*enemy2_6.resized_width/2)
        {
            if((enemy2_6.position_y+enemy2_6.resized_height/4-bullet1_2.position_y)*(enemy2_6.position_y+enemy2_6.resized_height/4-bullet1_2.position_y) < enemy2_6.resized_height/2*enemy2_6.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[29] = 0;
                enemy2_6.position(254*size_dm, 190*size_dm);
                enemy2_6.setObstacleAlpha(0);
                enemy2_6.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }

        if((enemy2_6.position_x+enemy2_6.resized_width/4-bullet1_3.position_x)*(enemy2_6.position_x+enemy2_6.resized_width/4-bullet1_3.position_x) < enemy2_6.resized_width/2*enemy2_6.resized_width/2)
        {
            if((enemy2_6.position_y+enemy2_6.resized_height/4-bullet1_3.position_y)*(enemy2_6.position_y+enemy2_6.resized_height/4-bullet1_3.position_y) < enemy2_6.resized_height/2*enemy2_6.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[29] = 0;
                enemy2_6.position(254*size_dm, 190*size_dm);
                enemy2_6.setObstacleAlpha(0);
                enemy2_6.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }

        if((enemy2_6.position_x+enemy2_6.resized_width/4-bullet1_4.position_x)*(enemy2_6.position_x+enemy2_6.resized_width/4-bullet1_4.position_x) < enemy2_6.resized_width/2*enemy2_6.resized_width/2)
        {
            if((enemy2_6.position_y+enemy2_6.resized_height/4-bullet1_4.position_y)*(enemy2_6.position_y+enemy2_6.resized_height/4-bullet1_4.position_y) < enemy2_6.resized_height/2*enemy2_6.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[29] = 0;
                enemy2_6.position(254*size_dm, 190*size_dm);
                enemy2_6.setObstacleAlpha(0);
                enemy2_6.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }

        if((enemy2_6.position_x+enemy2_6.resized_width/4-bullet1_5.position_x)*(enemy2_6.position_x+enemy2_6.resized_width/4-bullet1_5.position_x) < enemy2_6.resized_width/2*enemy2_6.resized_width/2)
        {
            if((enemy2_6.position_y+ enemy2_6.resized_height/4-bullet1_5.position_y)*(enemy2_6.position_y+enemy2_6.resized_height/4-bullet1_5.position_y) < enemy2_6.resized_height/2*enemy2_6.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[29] = 0;
                enemy2_6.position(254*size_dm, 190*size_dm);
                enemy2_6.setObstacleAlpha(0);
                enemy2_6.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }


        ///////////////////////////////////////////////////////////////////////////////////////////////

        if((enemy2_7.position_x+enemy2_7.resized_width/4-bullet1_1.position_x)*(enemy2_7.position_x+enemy2_7.resized_width/4-bullet1_1.position_x) < enemy2_7.resized_width/2*enemy2_7.resized_width/2)
        {
            if((enemy2_7.position_y+enemy2_7.resized_height/4-bullet1_1.position_y)*(enemy2_7.position_y+enemy2_7.resized_height/4-bullet1_1.position_y) < enemy2_7.resized_height/2*enemy2_7.resized_height/2) {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[30] = 0;
                enemy2_7.position(267*size_dm, 203*size_dm);
                enemy2_7.setObstacleAlpha(0);
                enemy2_7.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if((enemy2_7.position_x+enemy2_7.resized_width/4-bullet1_2.position_x)*(enemy2_7.position_x+enemy2_7.resized_width/4-bullet1_2.position_x) < enemy2_7.resized_width/2*enemy2_7.resized_width/2)
        {
            if((enemy2_7.position_y+enemy2_7.resized_height/4-bullet1_2.position_y)*(enemy2_7.position_y+enemy2_7.resized_height/4-bullet1_2.position_y) < enemy2_7.resized_height/2*enemy2_7.resized_height/2) {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[30] = 0;
                enemy2_7.position(267*size_dm, 203*size_dm);
                enemy2_7.setObstacleAlpha(0);
                enemy2_7.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }


        if((enemy2_7.position_x+enemy2_7.resized_width/4-bullet1_3.position_x)*(enemy2_7.position_x+enemy2_7.resized_width/4-bullet1_3.position_x) < enemy2_7.resized_width/2*enemy2_7.resized_width/2)
        {
            if((enemy2_7.position_y+enemy2_7.resized_height/4-bullet1_3.position_y)*(enemy2_7.position_y+enemy2_7.resized_height/4-bullet1_3.position_y) < enemy2_7.resized_height/2*enemy2_7.resized_height/2) {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[30] = 0;
                enemy2_7.position(267*size_dm, 203*size_dm);
                enemy2_7.setObstacleAlpha(0);
                enemy2_7.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }


        if((enemy2_7.position_x+enemy2_7.resized_width/4-bullet1_4.position_x)*(enemy2_7.position_x+enemy2_7.resized_width/4-bullet1_4.position_x) < enemy2_7.resized_width/2*enemy2_7.resized_width/2)
        {
            if((enemy2_7.position_y+enemy2_7.resized_height/4-bullet1_4.position_y)*(enemy2_7.position_y+enemy2_7.resized_height/4-bullet1_4.position_y) < enemy2_7.resized_height/2*enemy2_7.resized_height/2) {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[30] = 0;
                enemy2_7.position(267*size_dm, 203*size_dm);
                enemy2_7.setObstacleAlpha(0);
                enemy2_7.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }
        if((enemy2_7.position_x+enemy2_7.resized_width/4-bullet1_5.position_x)*(enemy2_7.position_x+enemy2_7.resized_width/4-bullet1_5.position_x) < enemy2_7.resized_width/2*enemy2_7.resized_width/2)
        {
            if((enemy2_7.position_y+enemy2_7.resized_height/4-bullet1_5.position_y)*(enemy2_7.position_y+enemy2_7.resized_height/4-bullet1_5.position_y) < enemy2_7.resized_height/2*enemy2_7.resized_height/2) {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[30] = 0;
                enemy2_7.position(267*size_dm, 203*size_dm);
                enemy2_7.setObstacleAlpha(0);
                enemy2_7.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }


        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        if((enemy2_8.position_x+enemy2_8.resized_width/4-bullet1_1.position_x)*(enemy2_8.position_x+enemy2_8.resized_width/4-bullet1_1.position_x) < enemy2_8.resized_width/2*enemy2_8.resized_width/2)
        {
            if((enemy2_8.position_y+enemy2_8.resized_height/4-bullet1_1.position_y)*(enemy2_8.position_y+enemy2_8.resized_height/4-bullet1_1.position_y) <enemy2_8.resized_height/2*enemy2_8.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[31] = 0;
                enemy2_8.position(280*size_dm, 219*size_dm);
                enemy2_8.setObstacleAlpha(0);
                enemy2_8.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if((enemy2_8.position_x+enemy2_8.resized_width/4-bullet1_2.position_x)*(enemy2_8.position_x+enemy2_8.resized_width/4-bullet1_2.position_x) < enemy2_8.resized_width/2*enemy2_8.resized_width/2)
        {
            if((enemy2_8.position_y+enemy2_8.resized_height/4-bullet1_2.position_y)*(enemy2_8.position_y+enemy2_8.resized_height/4-bullet1_2.position_y) <enemy2_8.resized_height/2*enemy2_8.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[31] = 0;
                enemy2_8.position(280*size_dm, 219*size_dm);
                enemy2_8.setObstacleAlpha(0);
                enemy2_8.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }

        if((enemy2_8.position_x+enemy2_8.resized_width/4-bullet1_3.position_x)*(enemy2_8.position_x+enemy2_8.resized_width/4-bullet1_3.position_x) < enemy2_8.resized_width/2*enemy2_8.resized_width/2)
        {
            if((enemy2_8.position_y+enemy2_8.resized_height/4-bullet1_3.position_y)*(enemy2_8.position_y+enemy2_8.resized_height/4-bullet1_3.position_y) <enemy2_8.resized_height/2*enemy2_8.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[31] = 0;
                enemy2_8.position(280*size_dm, 219*size_dm);
                enemy2_8.setObstacleAlpha(0);
                enemy2_8.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }

        if((enemy2_8.position_x+enemy2_8.resized_width/4-bullet1_4.position_x)*(enemy2_8.position_x+enemy2_8.resized_width/4-bullet1_4.position_x) < enemy2_8.resized_width/2*enemy2_8.resized_width/2)
        {
            if((enemy2_8.position_y+enemy2_8.resized_height/4-bullet1_4.position_y)*(enemy2_8.position_y+enemy2_8.resized_height/4-bullet1_4.position_y) <enemy2_8.resized_height/2*enemy2_8.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[31] = 0;
                enemy2_8.position(280*size_dm, 219*size_dm);
                enemy2_8.setObstacleAlpha(0);
                enemy2_8.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }

        if((enemy2_8.position_x+enemy2_8.resized_width/4-bullet1_5.position_x)*(enemy2_8.position_x+enemy2_8.resized_width/4-bullet1_5.position_x) < enemy2_8.resized_width/2*enemy2_8.resized_width/2)
        {
            if((enemy2_8.position_y+enemy2_8.resized_height/4-bullet1_5.position_y)*(enemy2_8.position_y+enemy2_8.resized_height/4-bullet1_5.position_y) <enemy2_8.resized_height/2*enemy2_8.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[31] = 0;
                enemy2_8.position(280*size_dm, 219*size_dm);
                enemy2_8.setObstacleAlpha(0);
                enemy2_8.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        if((enemy2x2_1.position_x+enemy2x2_1.resized_width/4-bullet1_1.position_x)*(enemy2x2_1.position_x+enemy2x2_1.resized_width/4-bullet1_1.position_x) < enemy2x2_1.resized_width/2*enemy2x2_1.resized_width/2)
        {
            if((enemy2x2_1.position_y+enemy2x2_1.resized_width/4-bullet1_1.position_y)*(enemy2x2_1.position_y+enemy2x2_1.resized_width/4-bullet1_1.position_y) < enemy2x2_1.resized_width/2*enemy2x2_1.resized_width/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[32] = 0;
                enemy2x2_1.position(189*size_dm, 125*size_dm);
                enemy2x2_1.setObstacleAlpha(0);
                enemy2x2_1.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if((enemy2x2_1.position_x+enemy2x2_1.resized_width/4-bullet1_2.position_x)*(enemy2x2_1.position_x+enemy2x2_1.resized_width/4-bullet1_2.position_x) < enemy2x2_1.resized_width/2*enemy2x2_1.resized_width/2)
        {
            if((enemy2x2_1.position_y+enemy2x2_1.resized_height/4-bullet1_2.position_y)*(enemy2x2_1.position_y+enemy2x2_1.resized_height/4-bullet1_2.position_y) < enemy2x2_1.resized_height/2*enemy2x2_1.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[32] = 0;
                enemy2x2_1.position(189*size_dm, 125*size_dm);
                enemy2x2_1.setObstacleAlpha(0);
                enemy2x2_1.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }

        if((enemy2x2_1.position_x+enemy2x2_1.resized_width/4-bullet1_3.position_x)*(enemy2x2_1.position_x+enemy2x2_1.resized_width/4-bullet1_3.position_x) < enemy2x2_1.resized_width/2*enemy2x2_1.resized_width/2)
        {
            if((enemy2x2_1.position_y+enemy2x2_1.resized_height/4-bullet1_3.position_y)*(enemy2x2_1.position_y+enemy2x2_1.resized_height/4-bullet1_3.position_y) < enemy2x2_1.resized_height/2*enemy2x2_1.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[32] = 0;
                enemy2x2_1.position(189*size_dm, 125*size_dm);
                enemy2x2_1.setObstacleAlpha(0);
                enemy2x2_1.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }

        if((enemy2x2_1.position_x+enemy2x2_1.resized_width/4-bullet1_4.position_x)*(enemy2x2_1.position_x+enemy2x2_1.resized_width/4-bullet1_4.position_x) < enemy2x2_1.resized_width/2*enemy2x2_1.resized_width/2)
        {
            if((enemy2x2_1.position_y+enemy2x2_1.resized_height/4-bullet1_4.position_y)*(enemy2x2_1.position_y+enemy2x2_1.resized_height/4-bullet1_4.position_y) < enemy2x2_1.resized_height/2*enemy2x2_1.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[32] = 0;
                enemy2x2_1.position(189*size_dm, 125*size_dm);
                enemy2x2_1.setObstacleAlpha(0);
                enemy2x2_1.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }

        if((enemy2x2_1.position_x+enemy2x2_1.resized_width/4-bullet1_5.position_x)*(enemy2x2_1.position_x+enemy2x2_1.resized_width/4-bullet1_5.position_x) < enemy2x2_1.resized_width/2*enemy2x2_1.resized_width/2)
        {
            if((enemy2x2_1.position_y+enemy2x2_1.resized_height/4-bullet1_5.position_y)*(enemy2x2_1.position_y+enemy2x2_1.resized_height/4-bullet1_5.position_y) <enemy2x2_1.resized_height/2*enemy2x2_1.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[32] = 0;
                enemy2x2_1.position(189*size_dm, 125*size_dm);
                enemy2x2_1.setObstacleAlpha(0);
                enemy2x2_1.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////

        if((enemy2x2_2.position_x+enemy2x2_2.resized_width/4-bullet1_1.position_x)*(enemy2x2_2.position_x+enemy2x2_2.resized_width/4-bullet1_1.position_x) < enemy2x2_2.resized_width/2*enemy2x2_2.resized_width/2)
        {
            if((enemy2x2_2.position_y+enemy2x2_2.resized_height/4-bullet1_1.position_y)*(enemy2x2_2.position_y+enemy2x2_2.resized_height/4-bullet1_1.position_y) < enemy2x2_2.resized_height/2*enemy2x2_2.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[33] = 0;
                enemy2x2_2.position(202*size_dm, 138*size_dm);
                enemy2x2_2.setObstacleAlpha(0);
                enemy2x2_2.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if((enemy2x2_2.position_x+enemy2x2_2.resized_width/4-bullet1_2.position_x)*(enemy2x2_2.position_x+enemy2x2_2.resized_width/4-bullet1_2.position_x) < enemy2x2_2.resized_width/2*enemy2x2_2.resized_width/2)
        {
            if((enemy2x2_2.position_y+enemy2x2_2.resized_height/4-bullet1_2.position_y)*(enemy2x2_2.position_y+enemy2x2_2.resized_height/4-bullet1_2.position_y) < enemy2x2_2.resized_height/2*enemy2x2_2.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[33] = 0;
                enemy2x2_2.position(202*size_dm, 138*size_dm);
                enemy2x2_2.setObstacleAlpha(0);
                enemy2x2_2.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }

        if((enemy2x2_2.position_x+enemy2x2_2.resized_width/4-bullet1_3.position_x)*(enemy2x2_2.position_x+enemy2x2_2.resized_width/4-bullet1_3.position_x) < enemy2x2_2.resized_width/2*enemy2x2_2.resized_width/2)
        {
            if((enemy2x2_2.position_y+enemy2x2_2.resized_height/4-bullet1_3.position_y)*(enemy2x2_2.position_y+enemy2x2_2.resized_height/4-bullet1_3.position_y) < enemy2x2_2.resized_height/2*enemy2x2_2.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[33] = 0;
                enemy2x2_2.position(202*size_dm, 138*size_dm);
                enemy2x2_2.setObstacleAlpha(0);
                enemy2x2_2.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }

        if((enemy2x2_2.position_x+enemy2x2_2.resized_width/4-bullet1_4.position_x)*(enemy2x2_2.position_x+enemy2x2_2.resized_width/4-bullet1_4.position_x) < enemy2x2_2.resized_width/2*enemy2x2_2.resized_width/2)
        {
            if((enemy2x2_2.position_y+enemy2x2_2.resized_height/4-bullet1_4.position_y)*(enemy2x2_2.position_y+enemy2x2_2.resized_height/4-bullet1_4.position_y) < enemy2x2_2.resized_height/3*enemy2x2_2.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[33] = 0;
                enemy2x2_2.position(202*size_dm, 138*size_dm);
                enemy2x2_2.setObstacleAlpha(0);
                enemy2x2_2.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }

        if((enemy2x2_2.position_x+enemy2x2_2.resized_width/4-bullet1_5.position_x)*(enemy2x2_2.position_x+enemy2x2_2.resized_width/4-bullet1_5.position_x) < enemy2x2_2.resized_width/2*enemy2x2_2.resized_width/2)
        {
            if((enemy2x2_2.position_y+enemy2x2_2.resized_height/4-bullet1_5.position_y)*(enemy2x2_2.position_y+enemy2x2_2.resized_height/4-bullet1_5.position_y) < enemy2x2_2.resized_height/2*enemy2x2_2.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[33] = 0;
                enemy2x2_2.position(202*size_dm, 138*size_dm);
                enemy2x2_2.setObstacleAlpha(0);
                enemy2x2_2.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////

        if((enemy2x2_3.position_x+enemy2x2_3.resized_width/4-bullet1_1.position_x)*(enemy2x2_3.position_x+enemy2x2_3.resized_width/4-bullet1_1.position_x) < enemy2x2_3.resized_width/2*enemy2x2_3.resized_width/2)
        {
            if((enemy2x2_3.position_y+enemy2x2_3.resized_height/4-bullet1_1.position_y)*(enemy2x2_3.position_y+enemy2x2_3.resized_height/4-bullet1_1.position_y) < enemy2x2_3.resized_height/2*enemy2x2_3.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[34] = 0;
                enemy2x2_3.position(215*size_dm, 151*size_dm);
                enemy2x2_3.setObstacleAlpha(0);
                enemy2x2_3.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if((enemy2x2_3.position_x+enemy2x2_3.resized_width/4-bullet1_2.position_x)*(enemy2x2_3.position_x+enemy2x2_3.resized_width/4-bullet1_2.position_x) < enemy2x2_3.resized_width/2*enemy2x2_3.resized_width/2)
        {
            if((enemy2x2_3.position_y+enemy2x2_3.resized_height/4-bullet1_2.position_y)*(enemy2x2_3.position_y+enemy2x2_3.resized_height/4-bullet1_2.position_y) < enemy2x2_3.resized_height/2*enemy2x2_3.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[34] = 0;
                enemy2x2_3.position(215*size_dm, 151*size_dm);
                enemy2x2_3.setObstacleAlpha(0);
                enemy2x2_3.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }
        if((enemy2x2_3.position_x+enemy2x2_3.resized_width/4-bullet1_3.position_x)*(enemy2x2_3.position_x+enemy2x2_3.resized_width/4-bullet1_3.position_x) < enemy2x2_3.resized_width/2*enemy2x2_3.resized_width/2)
        {
            if((enemy2x2_3.position_y+enemy2x2_3.resized_height/4-bullet1_3.position_y)*(enemy2x2_3.position_y+enemy2x2_3.resized_height/4-bullet1_3.position_y) < enemy2x2_3.resized_height/2*enemy2x2_3.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[34] = 0;
                enemy2x2_3.position(215*size_dm, 151*size_dm);
                enemy2x2_3.setObstacleAlpha(0);
                enemy2x2_3.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }

        if((enemy2x2_3.position_x+enemy2x2_3.resized_width/4-bullet1_4.position_x)*(enemy2x2_3.position_x+enemy2x2_3.resized_width/4-bullet1_4.position_x) < enemy2x2_3.resized_width/2*enemy2x2_3.resized_width/2)
        {
            if((enemy2x2_3.position_y+enemy2x2_3.resized_height/4-bullet1_4.position_y)*(enemy2x2_3.position_y+enemy2x2_3.resized_height/4-bullet1_4.position_y) < enemy2x2_3.resized_height/2*enemy2x2_3.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[34] = 0;
                enemy2x2_3.position(215*size_dm, 151*size_dm);
                enemy2x2_3.setObstacleAlpha(0);
                enemy2x2_3.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }

        if((enemy2x2_3.position_x+enemy2x2_3.resized_width/4-bullet1_5.position_x)*(enemy2x2_3.position_x+enemy2x2_3.resized_width/4-bullet1_5.position_x) < enemy2x2_3.resized_width/2*enemy2x2_3.resized_width/2)
        {
            if((enemy2x2_3.position_y+enemy2x2_3.resized_height/4-bullet1_5.position_y)*(enemy2x2_3.position_y+enemy2x2_3.resized_height/4-bullet1_5.position_y) < enemy2x2_3.resized_height/2*enemy2x2_3.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[34] = 0;
                enemy2x2_3.position(215*size_dm, 151*size_dm);
                enemy2x2_3.setObstacleAlpha(0);
                enemy2x2_3.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        if((enemy2x2_4.position_x+enemy2x2_4.resized_width/4-bullet1_1.position_x)*(enemy2x2_4.position_x+enemy2x2_4.resized_width/4-bullet1_1.position_x) < enemy2x2_4.resized_width/2*enemy2x2_4.resized_width/2)
        {
            if((enemy2x2_4.position_y+enemy2x2_4.resized_height/4-bullet1_1.position_y)*(enemy2x2_4.position_y+enemy2x2_4.resized_height/4-bullet1_1.position_y) < enemy2x2_4.resized_height/2*enemy2x2_4.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[35] = 0;
                enemy2x2_4.position(228*size_dm, 164*size_dm);
                enemy2x2_4.setObstacleAlpha(0);
                enemy2x2_4.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if((enemy2x2_4.position_x+enemy2x2_4.resized_width/4-bullet1_2.position_x)*(enemy2x2_4.position_x+enemy2x2_4.resized_width/4-bullet1_2.position_x) < enemy2x2_4.resized_width/2*enemy2x2_4.resized_width/2)
        {
            if((enemy2x2_4.position_y+enemy2x2_4.resized_height/4-bullet1_2.position_y)*(enemy2x2_4.position_y+enemy2x2_4.resized_height/4-bullet1_2.position_y) < enemy2x2_4.resized_height/2*enemy2x2_4.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[35] = 0;
                enemy2x2_4.position(228*size_dm, 164*size_dm);
                enemy2x2_4.setObstacleAlpha(0);
                enemy2x2_4.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }

        if((enemy2x2_4.position_x+enemy2x2_4.resized_width/4-bullet1_3.position_x)*(enemy2x2_4.position_x+enemy2x2_4.resized_width/4-bullet1_3.position_x) < enemy2x2_4.resized_width/2*enemy2x2_4.resized_width/2)
        {
            if((enemy2x2_4.position_y+enemy2x2_4.resized_height/4-bullet1_3.position_y)*(enemy2x2_4.position_y+enemy2x2_4.resized_height/4-bullet1_3.position_y) < enemy2x2_4.resized_height/2*enemy2x2_4.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[35] = 0;
                enemy2x2_4.position(228*size_dm, 164*size_dm);
                enemy2x2_4.setObstacleAlpha(0);
                enemy2x2_4.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }

        if((enemy2x2_4.position_x+enemy2x2_4.resized_width/4-bullet1_4.position_x)*(enemy2x2_4.position_x+enemy2x2_4.resized_width/4-bullet1_4.position_x) < enemy2x2_4.resized_width/2*enemy2x2_4.resized_width/2)
        {
            if((enemy2x2_4.position_y+enemy2x2_4.resized_height/4-bullet1_4.position_y)*(enemy2x2_4.position_y+enemy2x2_4.resized_height/4-bullet1_4.position_y) < enemy2x2_4.resized_height/2*enemy2x2_4.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[35] = 0;
                enemy2x2_4.position(228*size_dm, 164*size_dm);
                enemy2x2_4.setObstacleAlpha(0);
                enemy2x2_4.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }

        if((enemy2x2_4.position_x+enemy2x2_4.resized_width/4-bullet1_5.position_x)*(enemy2x2_4.position_x+enemy2x2_4.resized_width/4-bullet1_5.position_x) < enemy2x2_4.resized_width/2*enemy2x2_4.resized_width/2)
        {
            if((enemy2x2_4.position_y+enemy2x2_4.resized_height/4-bullet1_5.position_y)*(enemy2x2_4.position_y+enemy2x2_4.resized_height/4-bullet1_5.position_y) < enemy2x2_4.resized_height/2*enemy2x2_4.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[35] = 0;
                enemy2x2_4.position(228*size_dm, 164*size_dm);
                enemy2x2_4.setObstacleAlpha(0);
                enemy2x2_4.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        if((enemy2x2_5.position_x+enemy2x2_5.resized_width/4-bullet1_1.position_x)*(enemy2x2_5.position_x+enemy2x2_5.resized_width/4-bullet1_1.position_x) < enemy2x2_5.resized_width/2*enemy2x2_5.resized_width/2)
        {
            if((enemy2x2_5.position_y+enemy2x2_5.resized_height/4-bullet1_1.position_y)*(enemy2x2_5.position_y+enemy2x2_5.resized_height/4-bullet1_1.position_y) < enemy2x2_5.resized_height/2*enemy2x2_5.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[36] = 0;
                enemy2x2_5.position(241*size_dm, 177*size_dm);
                enemy2x2_5.setObstacleAlpha(0);
                enemy2x2_5.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if((enemy2x2_5.position_x+enemy2x2_5.resized_width/4-bullet1_2.position_x)*(enemy2x2_5.position_x+enemy2x2_5.resized_width/4-bullet1_2.position_x) < enemy2x2_5.resized_width/2*enemy2x2_5.resized_width/2)
        {
            if((enemy2x2_5.position_y+enemy2x2_5.resized_height/4-bullet1_2.position_y)*(enemy2x2_5.position_y+enemy2x2_5.resized_height/4-bullet1_2.position_y) < enemy2x2_5.resized_height/2*enemy2x2_5.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[36] = 0;
                enemy2x2_5.position(241*size_dm, 177*size_dm);
                enemy2x2_5.setObstacleAlpha(0);
                enemy2x2_5.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }

        if((enemy2x2_5.position_x+enemy2x2_5.resized_width/4-bullet1_3.position_x)*(enemy2x2_5.position_x+enemy2x2_5.resized_width/4-bullet1_3.position_x) < enemy2x2_5.resized_width/2*enemy2x2_5.resized_width/2)
        {
            if((enemy2x2_5.position_y+enemy2x2_5.resized_height/4-bullet1_3.position_y)*(enemy2x2_5.position_y+enemy2x2_5.resized_height/4-bullet1_3.position_y) < enemy2x2_5.resized_height/2*enemy2x2_5.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[36] = 0;
                enemy2x2_5.position(241*size_dm, 177*size_dm);
                enemy2x2_5.setObstacleAlpha(0);
                enemy2x2_5.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }

        if((enemy2x2_5.position_x+enemy2x2_5.resized_width/4-bullet1_4.position_x)*(enemy2x2_5.position_x+enemy2x2_5.resized_width/4-bullet1_4.position_x) < enemy2x2_5.resized_width/2*enemy2x2_5.resized_width/2)
        {
            if((enemy2x2_5.position_y+enemy2x2_5.resized_height/4-bullet1_4.position_y)*(enemy2x2_5.position_y+enemy2x2_5.resized_height/4-bullet1_4.position_y) < enemy2x2_5.resized_height/2*enemy2x2_5.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[36] = 0;
                enemy2x2_5.position(241*size_dm, 177*size_dm);
                enemy2x2_5.setObstacleAlpha(0);
                enemy2x2_5.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }

        if((enemy2x2_5.position_x+enemy2x2_5.resized_width/4-bullet1_5.position_x)*(enemy2x2_5.position_x+enemy2x2_5.resized_width/4-bullet1_5.position_x) < enemy2x2_5.resized_width/2*enemy2x2_5.resized_width/2)
        {
            if((enemy2x2_5.position_y+enemy2x2_5.resized_height/4-bullet1_5.position_y)*(enemy2x2_5.position_y+enemy2x2_5.resized_height/4-bullet1_5.position_y) < enemy2x2_5.resized_height/2*enemy2x2_5.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[36] = 0;
                enemy2x2_5.position(241*size_dm, 177*size_dm);
                enemy2x2_5.setObstacleAlpha(0);
                enemy2x2_5.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        if((enemy2x2_6.position_x+enemy2x2_6.resized_width/4-bullet1_1.position_x)*(enemy2x2_6.position_x+enemy2x2_6.resized_width/4-bullet1_1.position_x) < enemy2x2_6.resized_width/2*enemy2x2_6.resized_width/2)
        {
            if((enemy2x2_6.position_y+enemy2x2_6.resized_height/4-bullet1_1.position_y)*(enemy2x2_6.position_y+enemy2x2_6.resized_height/4-bullet1_1.position_y) < enemy2x2_6.resized_height/2*enemy2x2_6.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[37] = 0;
                enemy2x2_6.position(254*size_dm, 190*size_dm);
                enemy2x2_6.setObstacleAlpha(0);
                enemy2x2_6.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if((enemy2x2_6.position_x+enemy2x2_6.resized_width/4-bullet1_2.position_x)*(enemy2x2_6.position_x+enemy2x2_6.resized_width/4-bullet1_2.position_x) < enemy2x2_6.resized_width/2*enemy2x2_6.resized_width/2)
        {
            if((enemy2x2_6.position_y+enemy2x2_6.resized_height/4-bullet1_2.position_y)*(enemy2x2_6.position_y+enemy2x2_6.resized_height/4-bullet1_2.position_y) < enemy2x2_6.resized_height/2*enemy2x2_6.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[37] = 0;
                enemy2x2_6.position(254*size_dm, 190*size_dm);
                enemy2x2_6.setObstacleAlpha(0);
                enemy2x2_6.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }

        if((enemy2x2_6.position_x+enemy2x2_6.resized_width/4-bullet1_3.position_x)*(enemy2x2_6.position_x+enemy2x2_6.resized_width/4-bullet1_3.position_x) < enemy2x2_6.resized_width/2*enemy2x2_6.resized_width/2)
        {
            if((enemy2x2_6.position_y+enemy2x2_6.resized_height/4-bullet1_3.position_y)*(enemy2x2_6.position_y+enemy2x2_6.resized_height/4-bullet1_3.position_y) < enemy2x2_6.resized_height/2*enemy2x2_6.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[37] = 0;
                enemy2x2_6.position(254*size_dm, 190*size_dm);
                enemy2x2_6.setObstacleAlpha(0);
                enemy2x2_6.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }

        if((enemy2x2_6.position_x+enemy2x2_6.resized_width/4-bullet1_4.position_x)*(enemy2x2_6.position_x+enemy2x2_6.resized_width/4-bullet1_4.position_x) < enemy2x2_6.resized_width/2*enemy2x2_6.resized_width/2)
        {
            if((enemy2x2_6.position_y+enemy2x2_6.resized_height/4-bullet1_4.position_y)*(enemy2x2_6.position_y+enemy2x2_6.resized_height/4-bullet1_4.position_y) < enemy2x2_6.resized_height/2*enemy2x2_6.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[37] = 0;
                enemy2x2_6.position(254*size_dm, 190*size_dm);
                enemy2x2_6.setObstacleAlpha(0);
                enemy2x2_6.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }

        if((enemy2x2_6.position_x+enemy2x2_6.resized_width/4-bullet1_5.position_x)*(enemy2x2_6.position_x+enemy2x2_6.resized_width/4-bullet1_5.position_x) < enemy2x2_6.resized_width/2*enemy2x2_6.resized_width/2)
        {
            if((enemy2x2_6.position_y+enemy2x2_6.resized_height/4-bullet1_5.position_y)*(enemy2x2_6.position_y+enemy2x2_6.resized_height/4-bullet1_5.position_y) <enemy2x2_6.resized_height/2*enemy2x2_6.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[37] = 0;
                enemy2x2_6.position(254*size_dm, 190*size_dm);
                enemy2x2_6.setObstacleAlpha(0);
                enemy2x2_6.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        if((enemy2x2_7.position_x+enemy2x2_7.resized_width/4-bullet1_1.position_x)*(enemy2x2_7.position_x+enemy2x2_7.resized_width/4-bullet1_1.position_x) < enemy2x2_7.resized_width/2*enemy2x2_7.resized_width/2)
        {
            if((enemy2x2_7.position_y+enemy2x2_7.resized_height/4-bullet1_1.position_y)*(enemy2x2_7.position_y+enemy2x2_7.resized_height/4-bullet1_1.position_y) < enemy2x2_7.resized_height/2*enemy2x2_7.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[38] = 0;
                enemy2x2_7.position(267*size_dm, 203*size_dm);
                enemy2x2_7.setObstacleAlpha(0);
                enemy2x2_7.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if((enemy2x2_7.position_x+enemy2x2_7.resized_width/4-bullet1_2.position_x)*(enemy2x2_7.position_x+enemy2x2_7.resized_width/4-bullet1_2.position_x) < enemy2x2_7.resized_width/2*enemy2x2_7.resized_width/2)
        {
            if((enemy2x2_7.position_y+enemy2x2_7.resized_height/4-bullet1_2.position_y)*(enemy2x2_7.position_y+enemy2x2_7.resized_height/4-bullet1_2.position_y) < enemy2x2_7.resized_height/2*enemy2x2_7.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[38] = 0;
                enemy2x2_7.position(267*size_dm, 203*size_dm);
                enemy2x2_7.setObstacleAlpha(0);
                enemy2x2_7.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }

        if((enemy2x2_7.position_x+enemy2x2_7.resized_width/4-bullet1_3.position_x)*(enemy2x2_7.position_x+enemy2x2_7.resized_width/4-bullet1_3.position_x) < enemy2x2_7.resized_width/2*enemy2x2_7.resized_width/2)
        {
            if((enemy2x2_7.position_y+enemy2x2_7.resized_height/4-bullet1_3.position_y)*(enemy2x2_7.position_y+enemy2x2_7.resized_height/4-bullet1_3.position_y) < enemy2x2_7.resized_height/2*enemy2x2_7.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[38] = 0;
                enemy2x2_7.position(267*size_dm, 203*size_dm);
                enemy2x2_7.setObstacleAlpha(0);
                enemy2x2_7.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }

        if((enemy2x2_7.position_x+enemy2x2_7.resized_width/4-bullet1_4.position_x)*(enemy2x2_7.position_x+enemy2x2_7.resized_width/4-bullet1_4.position_x) < enemy2x2_7.resized_width/2*enemy2x2_7.resized_width/2)
        {
            if((enemy2x2_7.position_y+enemy2x2_7.resized_height/4-bullet1_4.position_y)*(enemy2x2_7.position_y+enemy2x2_7.resized_height/4-bullet1_4.position_y) < enemy2x2_7.resized_height/2*enemy2x2_7.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[38] = 0;
                enemy2x2_7.position(267*size_dm, 203*size_dm);
                enemy2x2_7.setObstacleAlpha(0);
                enemy2x2_7.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }

        if((enemy2x2_7.position_x+enemy2x2_7.resized_width/4-bullet1_5.position_x)*(enemy2x2_7.position_x+enemy2x2_7.resized_width/4-bullet1_5.position_x) < enemy2x2_7.resized_width/2*enemy2x2_7.resized_width/2)
        {
            if((enemy2x2_7.position_y+enemy2x2_7.resized_height/4-bullet1_5.position_y)*(enemy2x2_7.position_y+enemy2x2_7.resized_height/4-bullet1_5.position_y) < enemy2x2_7.resized_height/2*enemy2x2_7.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[38] = 0;
                enemy2x2_7.position(267*size_dm, 203*size_dm);
                enemy2x2_7.setObstacleAlpha(0);
                enemy2x2_7.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        if((enemy2x2_8.position_x+enemy2x2_8.resized_width/4-bullet1_1.position_x)*(enemy2x2_8.position_x+enemy2x2_8.resized_width/4-bullet1_1.position_x) < enemy2x2_8.resized_width/2*enemy2x2_8.resized_width/2)
        {
            if((enemy2x2_8.position_y+enemy2x2_8.resized_height/4-bullet1_1.position_y)*(enemy2x2_8.position_y+enemy2x2_8.resized_height/4-bullet1_1.position_y) < enemy2x2_8.resized_height/2*enemy2x2_8.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[39] = 0;
                enemy2x2_8.position(280*size_dm, 219*size_dm);
                enemy2x2_8.setObstacleAlpha(0);
                enemy2x2_8.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if((enemy2x2_8.position_x+enemy2x2_8.resized_width/4-bullet1_2.position_x)*(enemy2x2_8.position_x+enemy2x2_8.resized_width/4-bullet1_2.position_x) < enemy2x2_8.resized_width/2*enemy2x2_8.resized_width/2)
        {
            if((enemy2x2_8.position_y+enemy2x2_8.resized_height/4-bullet1_2.position_y)*(enemy2x2_8.position_y+enemy2x2_8.resized_height/4-bullet1_2.position_y) < enemy2x2_8.resized_height/2*enemy2x2_8.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[39] = 0;
                enemy2x2_8.position(280*size_dm, 219*size_dm);
                enemy2x2_8.setObstacleAlpha(0);
                enemy2x2_8.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }

        if((enemy2x2_8.position_x+enemy2x2_8.resized_width/4-bullet1_3.position_x)*(enemy2x2_8.position_x+enemy2x2_8.resized_width/4-bullet1_3.position_x) < enemy2x2_8.resized_width/2*enemy2x2_8.resized_width/2)
        {
            if((enemy2x2_8.position_y+enemy2x2_8.resized_height/4-bullet1_3.position_y)*(enemy2x2_8.position_y+enemy2x2_8.resized_height/4-bullet1_3.position_y) < enemy2x2_8.resized_height/2*enemy2x2_8.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[39] = 0;
                enemy2x2_8.position(280*size_dm, 219*size_dm);
                enemy2x2_8.setObstacleAlpha(0);
                enemy2x2_8.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }

        if((enemy2x2_8.position_x+enemy2x2_8.resized_width/4-bullet1_4.position_x)*(enemy2x2_8.position_x+enemy2x2_8.resized_width/4-bullet1_4.position_x) < enemy2x2_8.resized_width/2*enemy2x2_8.resized_width/2)
        {
            if((enemy2x2_8.position_y+enemy2x2_8.resized_height/4-bullet1_4.position_y)*(enemy2x2_8.position_y+enemy2x2_8.resized_height/4-bullet1_4.position_y) < enemy2x2_8.resized_height/2*enemy2x2_8.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[39] = 0;
                enemy2x2_8.position(280*size_dm, 219*size_dm);
                enemy2x2_8.setObstacleAlpha(0);
                enemy2x2_8.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }

        if((enemy2x2_8.position_x+enemy2x2_8.resized_width/4-bullet1_5.position_x)*(enemy2x2_8.position_x+enemy2x2_8.resized_width/4-bullet1_5.position_x) < enemy2x2_8.resized_width/2*enemy2x2_8.resized_width/2)
        {
            if((enemy2x2_8.position_y+enemy2x2_8.resized_height/4-bullet1_5.position_y)*(enemy2x2_8.position_y+enemy2x2_8.resized_height/4-bullet1_5.position_y) < enemy2x2_8.resized_height/2*enemy2x2_8.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[39] = 0;
                enemy2x2_8.position(280*size_dm, 219*size_dm);
                enemy2x2_8.setObstacleAlpha(0);
                enemy2x2_8.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if((enemy2x3_1.position_x+enemy2x3_1.resized_width/4-bullet1_1.position_x)*(enemy2x3_1.position_x+enemy2x3_1.resized_width/4-bullet1_1.position_x) < enemy2x3_1.resized_width/2*enemy2x3_1.resized_width/2)
        {
            if((enemy2x3_1.position_y+enemy2x3_1.resized_height/4-bullet1_1.position_y)*(enemy2x3_1.position_y+enemy2x3_1.resized_height/4-bullet1_1.position_y) < enemy2x3_1.resized_height/2*enemy2x3_1.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[40] = 0;
                enemy2x3_1.position(189*size_dm, 125*size_dm);
                enemy2x3_1.setObstacleAlpha(0);
                enemy2x3_1.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if((enemy2x3_1.position_x+enemy2x3_1.resized_width/4-bullet1_2.position_x)*(enemy2x3_1.position_x+enemy2x3_1.resized_width/4-bullet1_2.position_x) < enemy2x3_1.resized_width/2*enemy2x3_1.resized_width/2)
        {
            if((enemy2x3_1.position_y+enemy2x3_1.resized_height/4-bullet1_2.position_y)*(enemy2x3_1.position_y+enemy2x3_1.resized_height/4-bullet1_2.position_y) < enemy2x3_1.resized_height/2*enemy2x3_1.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[40] = 0;
                enemy2x3_1.position(189*size_dm, 125*size_dm);
                enemy2x3_1.setObstacleAlpha(0);
                enemy2x3_1.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }

        if((enemy2x3_1.position_x+enemy2x3_1.resized_width/4-bullet1_3.position_x)*(enemy2x3_1.position_x+enemy2x3_1.resized_width/4-bullet1_3.position_x) < enemy2x3_1.resized_width/2*enemy2x3_1.resized_width/2)
        {
            if((enemy2x3_1.position_y+enemy2x3_1.resized_height/4-bullet1_3.position_y)*(enemy2x3_1.position_y+enemy2x3_1.resized_height/4-bullet1_3.position_y) < enemy2x3_1.resized_height/2*enemy2x3_1.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[40] = 0;
                enemy2x3_1.position(189*size_dm, 125*size_dm);
                enemy2x3_1.setObstacleAlpha(0);
                enemy2x3_1.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }

        if((enemy2x3_1.position_x+enemy2x3_1.resized_width/4-bullet1_4.position_x)*(enemy2x3_1.position_x+enemy2x3_1.resized_width/4-bullet1_4.position_x) < enemy2x3_1.resized_width/2*enemy2x3_1.resized_width/2)
        {
            if((enemy2x3_1.position_y+enemy2x3_1.resized_height/4-bullet1_4.position_y)*(enemy2x3_1.position_y+enemy2x3_1.resized_height/4-bullet1_4.position_y) < enemy2x3_1.resized_height/2*enemy2x3_1.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[40] = 0;
                enemy2x3_1.position(189*size_dm, 125*size_dm);
                enemy2x3_1.setObstacleAlpha(0);
                enemy2x3_1.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }

        if((enemy2x3_1.position_x+enemy2x3_1.resized_width/4-bullet1_5.position_x)*(enemy2x3_1.position_x+enemy2x3_1.resized_width/4-bullet1_5.position_x) < enemy2x3_1.resized_width/2*enemy2x3_1.resized_width/2)
        {
            if((enemy2x3_1.position_y+enemy2x3_1.resized_height/4-bullet1_5.position_y)*(enemy2x3_1.position_y+enemy2x3_1.resized_height/4-bullet1_5.position_y) < enemy2x3_1.resized_height/2*enemy2x3_1.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[40] = 0;
                enemy2x3_1.position(189*size_dm, 125*size_dm);
                enemy2x3_1.setObstacleAlpha(0);
                enemy2x3_1.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////////////

        if((enemy2x3_2.position_x+enemy2x3_2.resized_width/4-bullet1_1.position_x)*(enemy2x3_2.position_x+enemy2x3_2.resized_width/4-bullet1_1.position_x) < enemy2x3_2.resized_width/2*enemy2x3_2.resized_width/2)
        {
            if((enemy2x3_2.position_y+enemy2x3_2.resized_height/4-bullet1_1.position_y)*(enemy2x3_2.position_y+enemy2x3_2.resized_height/4-bullet1_1.position_y) < enemy2x3_2.resized_height/2*enemy2x3_2.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[41] = 0;
                enemy2x3_2.position(202*size_dm, 138*size_dm);
                enemy2x3_2.setObstacleAlpha(0);
                enemy2x3_2.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if((enemy2x3_2.position_x+enemy2x3_2.resized_width/4-bullet1_2.position_x)*(enemy2x3_2.position_x+enemy2x3_2.resized_width/4-bullet1_2.position_x) < enemy2x3_2.resized_width/2*enemy2x3_2.resized_width/2)
        {
            if((enemy2x3_2.position_y+enemy2x3_2.resized_height/4-bullet1_2.position_y)*(enemy2x3_2.position_y+enemy2x3_2.resized_height/4-bullet1_2.position_y) < enemy2x3_2.resized_height/2*enemy2x3_2.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[41] = 0;
                enemy2x3_2.position(202*size_dm, 138*size_dm);
                enemy2x3_2.setObstacleAlpha(0);
                enemy2x3_2.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }

        if((enemy2x3_2.position_x+enemy2x3_2.resized_width/4-bullet1_3.position_x)*(enemy2x3_2.position_x+enemy2x3_2.resized_width/4-bullet1_3.position_x) < enemy2x3_2.resized_width/2*enemy2x3_2.resized_width/2)
        {
            if((enemy2x3_2.position_y+enemy2x3_2.resized_height/4-bullet1_3.position_y)*(enemy2x3_2.position_y+enemy2x3_2.resized_height/4-bullet1_3.position_y) < enemy2x3_2.resized_height/2*enemy2x3_2.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[41] = 0;
                enemy2x3_2.position(202*size_dm, 138*size_dm);
                enemy2x3_2.setObstacleAlpha(0);
                enemy2x3_2.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }

        if((enemy2x3_2.position_x+enemy2x3_2.resized_width/4-bullet1_4.position_x)*(enemy2x3_2.position_x+enemy2x3_2.resized_width/4-bullet1_4.position_x) < enemy2x3_2.resized_width/2*enemy2x3_2.resized_width/2)
        {
            if((enemy2x3_2.position_y+enemy2x3_2.resized_height/4-bullet1_4.position_y)*(enemy2x3_2.position_y+enemy2x3_2.resized_height/4-bullet1_4.position_y) < enemy2x3_2.resized_height/2*enemy2x3_2.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[41] = 0;
                enemy2x3_2.position(202*size_dm, 138*size_dm);
                enemy2x3_2.setObstacleAlpha(0);
                enemy2x3_2.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }

        if((enemy2x3_2.position_x+enemy2x3_2.resized_width/4-bullet1_5.position_x)*(enemy2x3_2.position_x+enemy2x3_2.resized_width/4-bullet1_5.position_x) < enemy2x3_2.resized_width/2*enemy2x3_2.resized_width/2)
        {
            if((enemy2x3_2.position_y+enemy2x3_3.resized_height/4-bullet1_5.position_y)*(enemy2x3_2.position_y+enemy2x3_3.resized_height/4-bullet1_5.position_y) < enemy2x3_3.resized_height/2*enemy2x3_3.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[41] = 0;
                enemy2x3_2.position(202*size_dm, 138*size_dm);
                enemy2x3_2.setObstacleAlpha(0);
                enemy2x3_2.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        if((enemy2x3_3.position_x+enemy2x3_3.resized_width/4-bullet1_1.position_x)*(enemy2x3_3.position_x+enemy2x3_3.resized_width/4-bullet1_1.position_x) < enemy2x3_3.resized_width/2*enemy2x3_3.resized_width/2)
        {
            if((enemy2x3_3.position_y+enemy2x3_3.resized_height/4-bullet1_1.position_y)*(enemy2x3_3.position_y+enemy2x3_3.resized_height/4-bullet1_1.position_y) <enemy2x3_3.resized_height/2*enemy2x3_3.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[42] = 0;
                enemy2x3_3.position(215*size_dm, 151*size_dm);
                enemy2x3_3.setObstacleAlpha(0);
                enemy2x3_3.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if((enemy2x3_3.position_x+enemy2x3_3.resized_width/4-bullet1_2.position_x)*(enemy2x3_3.position_x+enemy2x3_3.resized_width/4-bullet1_2.position_x) < enemy2x3_3.resized_width/2*enemy2x3_3.resized_width/2)
        {
            if((enemy2x3_3.position_y+enemy2x3_3.resized_height/4-bullet1_2.position_y)*(enemy2x3_3.position_y+enemy2x3_3.resized_height/4-bullet1_2.position_y) <enemy2x3_3.resized_height/2*enemy2x3_3.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[42] = 0;
                enemy2x3_3.position(215*size_dm, 151*size_dm);
                enemy2x3_3.setObstacleAlpha(0);
                enemy2x3_3.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }

        if((enemy2x3_3.position_x+enemy2x3_3.resized_width/4-bullet1_3.position_x)*(enemy2x3_3.position_x+enemy2x3_3.resized_width/4-bullet1_3.position_x) < enemy2x3_3.resized_width/2*enemy2x3_3.resized_width/2)
        {
            if((enemy2x3_3.position_y+enemy2x3_3.resized_height/4-bullet1_3.position_y)*(enemy2x3_3.position_y+enemy2x3_3.resized_height/4-bullet1_3.position_y) <enemy2x3_3.resized_height/2*enemy2x3_3.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[42] = 0;
                enemy2x3_3.position(215*size_dm, 151*size_dm);
                enemy2x3_3.setObstacleAlpha(0);
                enemy2x3_3.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }

        if((enemy2x3_3.position_x+enemy2x3_3.resized_width/4-bullet1_4.position_x)*(enemy2x3_3.position_x+enemy2x3_3.resized_width/4-bullet1_4.position_x) < enemy2x3_3.resized_width/2*enemy2x3_3.resized_width/2)
        {
            if((enemy2x3_3.position_y+enemy2x3_3.resized_height/4-bullet1_4.position_y)*(enemy2x3_3.position_y+enemy2x3_3.resized_height/4-bullet1_4.position_y) <enemy2x3_3.resized_height/2*enemy2x3_3.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[42] = 0;
                enemy2x3_3.position(215*size_dm, 151*size_dm);
                enemy2x3_3.setObstacleAlpha(0);
                enemy2x3_3.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }

        if((enemy2x3_3.position_x+enemy2x3_3.resized_width/4-bullet1_5.position_x)*(enemy2x3_3.position_x+enemy2x3_3.resized_width/4-bullet1_5.position_x) <enemy2x3_3.resized_width/2*enemy2x3_3.resized_width/2)
        {
            if((enemy2x3_3.position_y+enemy2x3_3.resized_height/4-bullet1_5.position_y)*(enemy2x3_3.position_y+enemy2x3_3.resized_height/4-bullet1_5.position_y) <enemy2x3_3.resized_height/2*enemy2x3_3.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[42] = 0;
                enemy2x3_3.position(215*size_dm, 151*size_dm);
                enemy2x3_3.setObstacleAlpha(0);
                enemy2x3_3.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////////

        if((enemy2x3_4.position_x+enemy2x3_4.resized_width/4-bullet1_1.position_x)*(enemy2x3_4.position_x+enemy2x3_4.resized_width/4-bullet1_1.position_x) < enemy2x3_4.resized_width/2*enemy2x3_4.resized_width/2)
        {
            if((enemy2x3_4.position_y+enemy2x3_4.resized_height/4-bullet1_1.position_y)*(enemy2x3_4.position_y+enemy2x3_4.resized_height/4-bullet1_1.position_y) < enemy2x3_4.resized_height/2*enemy2x3_4.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[43] = 0;
                enemy2x3_4.position(228*size_dm, 164*size_dm);
                enemy2x3_4.setObstacleAlpha(0);
                enemy2x3_4.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if((enemy2x3_4.position_x+enemy2x3_4.resized_width/4-bullet1_2.position_x)*(enemy2x3_4.position_x+enemy2x3_4.resized_width/4-bullet1_2.position_x) < enemy2x3_4.resized_width/2*enemy2x3_4.resized_width/2)
        {
            if((enemy2x3_4.position_y+enemy2x3_4.resized_height/4-bullet1_2.position_y)*(enemy2x3_4.position_y+enemy2x3_4.resized_height/4-bullet1_2.position_y) < enemy2x3_4.resized_height/2*enemy2x3_4.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[43] = 0;
                enemy2x3_4.position(228*size_dm, 164*size_dm);
                enemy2x3_4.setObstacleAlpha(0);
                enemy2x3_4.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }

        if((enemy2x3_4.position_x+enemy2x3_4.resized_width/4-bullet1_3.position_x)*(enemy2x3_4.position_x+enemy2x3_4.resized_width/4-bullet1_3.position_x) < enemy2x3_4.resized_width/2*enemy2x3_4.resized_width/2)
        {
            if((enemy2x3_4.position_y+enemy2x3_4.resized_height/4-bullet1_3.position_y)*(enemy2x3_4.position_y+enemy2x3_4.resized_height/4-bullet1_3.position_y) < enemy2x3_4.resized_height/2*enemy2x3_4.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[43] = 0;
                enemy2x3_4.position(228*size_dm, 164*size_dm);
                enemy2x3_4.setObstacleAlpha(0);
                enemy2x3_4.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }

        if((enemy2x3_4.position_x+enemy2x3_4.resized_width/4-bullet1_4.position_x)*(enemy2x3_4.position_x+enemy2x3_4.resized_width/4-bullet1_4.position_x) < enemy2x3_4.resized_width/2*enemy2x3_4.resized_width/2)
        {
            if((enemy2x3_4.position_y+enemy2x3_4.resized_height/4-bullet1_4.position_y)*(enemy2x3_4.position_y+enemy2x3_4.resized_height/4-bullet1_4.position_y) < enemy2x3_4.resized_height/2*enemy2x3_4.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[43] = 0;
                enemy2x3_4.position(228*size_dm, 164*size_dm);
                enemy2x3_4.setObstacleAlpha(0);
                enemy2x3_4.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }

        if((enemy2x3_4.position_x+enemy2x3_4.resized_width/4-bullet1_5.position_x)*(enemy2x3_4.position_x+enemy2x3_4.resized_width/4-bullet1_5.position_x) < enemy2x3_4.resized_width/2*enemy2x3_4.resized_width/2)
        {
            if((enemy2x3_4.position_y+enemy2x3_4.resized_height/4-bullet1_5.position_y)*(enemy2x3_4.position_y+enemy2x3_4.resized_height/4-bullet1_5.position_y) < enemy2x3_4.resized_height/2*enemy2x3_4.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[43] = 0;
                enemy2x3_4.position(228*size_dm, 164*size_dm);
                enemy2x3_4.setObstacleAlpha(0);
                enemy2x3_4.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////////////


        if((enemy2x3_5.position_x+enemy2x3_5.resized_width/4-bullet1_1.position_x)*(enemy2x3_5.position_x+enemy2x3_5.resized_width/4-bullet1_1.position_x) <enemy2x3_5.resized_width/2*enemy2x3_5.resized_width/2)
        {
            if((enemy2x3_5.position_y+enemy2x3_5.resized_height/4-bullet1_1.position_y)*(enemy2x3_5.position_y+enemy2x3_5.resized_height/4-bullet1_1.position_y) < enemy2x3_5.resized_height/2*enemy2x3_5.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[44] = 0;
                enemy2x3_5.position(241*size_dm, 177*size_dm);
                enemy2x3_5.setObstacleAlpha(0);
                enemy2x3_5.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if((enemy2x3_5.position_x+enemy2x3_5.resized_width/4-bullet1_2.position_x)*(enemy2x3_5.position_x+enemy2x3_5.resized_width/4-bullet1_2.position_x) <enemy2x3_5.resized_width/2*enemy2x3_5.resized_width/2)
        {
            if((enemy2x3_5.position_y+enemy2x3_5.resized_height/4-bullet1_2.position_y)*(enemy2x3_5.position_y+enemy2x3_5.resized_height/4-bullet1_2.position_y) < enemy2x3_5.resized_height/2*enemy2x3_5.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[44] = 0;
                enemy2x3_5.position(241*size_dm, 177*size_dm);
                enemy2x3_5.setObstacleAlpha(0);
                enemy2x3_5.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }

        if((enemy2x3_5.position_x+enemy2x3_5.resized_width/4-bullet1_3.position_x)*(enemy2x3_5.position_x+enemy2x3_5.resized_width/4-bullet1_3.position_x) <enemy2x3_5.resized_width/2*enemy2x3_5.resized_width/2)
        {
            if((enemy2x3_5.position_y+enemy2x3_5.resized_height/4-bullet1_3.position_y)*(enemy2x3_5.position_y+enemy2x3_5.resized_height/4-bullet1_3.position_y) < enemy2x3_5.resized_height/2*enemy2x3_5.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[44] = 0;
                enemy2x3_5.position(241*size_dm, 177*size_dm);
                enemy2x3_5.setObstacleAlpha(0);
                enemy2x3_5.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }

        if((enemy2x3_5.position_x+enemy2x3_5.resized_width/4-bullet1_4.position_x)*(enemy2x3_5.position_x+enemy2x3_5.resized_width/4-bullet1_4.position_x) <enemy2x3_5.resized_width/2*enemy2x3_5.resized_width/2)
        {
            if((enemy2x3_5.position_y+enemy2x3_5.resized_height/4-bullet1_4.position_y)*(enemy2x3_5.position_y+enemy2x3_5.resized_height/4-bullet1_4.position_y) < enemy2x3_5.resized_height/2*enemy2x3_5.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[44] = 0;
                enemy2x3_5.position(241*size_dm, 177*size_dm);
                enemy2x3_5.setObstacleAlpha(0);
                enemy2x3_5.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }

        if((enemy2x3_5.position_x+enemy2x3_5.resized_width/4-bullet1_5.position_x)*(enemy2x3_5.position_x+enemy2x3_5.resized_width/4-bullet1_5.position_x) <enemy2x3_5.resized_width/2*enemy2x3_5.resized_width/2)
        {
            if((enemy2x3_5.position_y+enemy2x3_5.resized_height/4-bullet1_5.position_y)*(enemy2x3_5.position_y+enemy2x3_5.resized_height/4-bullet1_5.position_y) < enemy2x3_5.resized_height/2*enemy2x3_5.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[44] = 0;
                enemy2x3_5.position(241*size_dm, 177*size_dm);
                enemy2x3_5.setObstacleAlpha(0);
                enemy2x3_5.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        if((enemy2x3_6.position_x+enemy2x3_6.resized_width/4-bullet1_1.position_x)*(enemy2x3_6.position_x+enemy2x3_6.resized_width/4-bullet1_1.position_x) <enemy2x3_6.resized_width/2*enemy2x3_6.resized_width/2)
        {
            if((enemy2x3_6.position_y+enemy2x3_6.resized_height/4-bullet1_1.position_y)*(enemy2x3_6.position_y+enemy2x3_6.resized_height/4-bullet1_1.position_y) < enemy2x3_6.resized_height/2*enemy2x3_6.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[45] = 0;
                enemy2x3_6.position(254*size_dm, 190*size_dm);
                enemy2x3_6.setObstacleAlpha(0);
                enemy2x3_6.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if((enemy2x3_6.position_x+enemy2x3_6.resized_width/4-bullet1_2.position_x)*(enemy2x3_6.position_x+enemy2x3_6.resized_width/4-bullet1_2.position_x) < enemy2x3_6.resized_width/2*enemy2x3_6.resized_width/2)
        {
            if((enemy2x3_6.position_y+enemy2x3_6.resized_height/4-bullet1_2.position_y)*(enemy2x3_6.position_y+enemy2x3_6.resized_height/4-bullet1_2.position_y) < enemy2x3_6.resized_height/2*enemy2x3_6.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[45] = 0;
                enemy2x3_6.position(254*size_dm, 190*size_dm);
                enemy2x3_6.setObstacleAlpha(0);
                enemy2x3_6.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }

        if((enemy2x3_6.position_x+enemy2x3_6.resized_width/4-bullet1_3.position_x)*(enemy2x3_6.position_x+enemy2x3_6.resized_width/4-bullet1_3.position_x) < enemy2x3_6.resized_width/2*enemy2x3_6.resized_width/2)
        {
            if((enemy2x3_6.position_y+enemy2x3_6.resized_height/4-bullet1_3.position_y)*(enemy2x3_6.position_y+enemy2x3_6.resized_height/4-bullet1_3.position_y) < enemy2x3_6.resized_height/2*enemy2x3_6.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[45] = 0;
                enemy2x3_6.position(254*size_dm, 190*size_dm);
                enemy2x3_6.setObstacleAlpha(0);
                enemy2x3_6.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }

        if((enemy2x3_6.position_x+enemy2x3_6.resized_width/4-bullet1_4.position_x)*(enemy2x3_6.position_x+enemy2x3_6.resized_width/4-bullet1_4.position_x) < enemy2x3_6.resized_width/2*enemy2x3_6.resized_width/2)
        {
            if((enemy2x3_6.position_y+enemy2x3_6.resized_height/4-bullet1_4.position_y)*(enemy2x3_6.position_y+enemy2x3_6.resized_height/4-bullet1_4.position_y) < enemy2x3_6.resized_height/2*enemy2x3_6.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[45] = 0;
                enemy2x3_6.position(254*size_dm, 190*size_dm);
                enemy2x3_6.setObstacleAlpha(0);
                enemy2x3_6.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }

        if((enemy2x3_6.position_x+enemy2x3_6.resized_width/4-bullet1_5.position_x)*(enemy2x3_6.position_x+enemy2x3_6.resized_width/4-bullet1_5.position_x) < enemy2x3_6.resized_width/2*enemy2x3_6.resized_width/2)
        {
            if((enemy2x3_6.position_y+enemy2x3_6.resized_height/4-bullet1_5.position_y)*(enemy2x3_6.position_y+enemy2x3_6.resized_height/4-bullet1_5.position_y) < enemy2x3_6.resized_height/2*enemy2x3_6.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[45] = 0;
                enemy2x3_6.position(254*size_dm, 190*size_dm);
                enemy2x3_6.setObstacleAlpha(0);
                enemy2x3_6.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        if((enemy2x3_7.position_x+enemy2x3_7.resized_width/4-bullet1_1.position_x)*(enemy2x3_7.position_x+enemy2x3_7.resized_width/4-bullet1_1.position_x) < enemy2x3_7.resized_width/2*enemy2x3_7.resized_width/2)
        {
            if((enemy2x3_7.position_y+enemy2x3_7.resized_height/4-bullet1_1.position_y)*(enemy2x3_7.position_y+enemy2x3_7.resized_height/4-bullet1_1.position_y) < enemy2x3_7.resized_height/2*enemy2x3_7.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[46] = 0;
                enemy2x3_7.position(267*size_dm, 203*size_dm);
                enemy2x3_7.setObstacleAlpha(0);
                enemy2x3_7.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if((enemy2x3_7.position_x+enemy2x3_7.resized_width/4-bullet1_2.position_x)*(enemy2x3_7.position_x+enemy2x3_7.resized_width/4-bullet1_2.position_x) < enemy2x3_7.resized_width/2*enemy2x3_7.resized_width/2)
        {
            if((enemy2x3_7.position_y+enemy2x3_7.resized_height/4-bullet1_2.position_y)*(enemy2x3_7.position_y+enemy2x3_7.resized_height/4-bullet1_2.position_y) < enemy2x3_7.resized_height/2*enemy2x3_7.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[46] = 0;
                enemy2x3_7.position(267*size_dm, 203*size_dm);
                enemy2x3_7.setObstacleAlpha(0);
                enemy2x3_7.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }

        if((enemy2x3_7.position_x+enemy2x3_7.resized_width/4-bullet1_3.position_x)*(enemy2x3_7.position_x+enemy2x3_7.resized_width/4-bullet1_3.position_x) < enemy2x3_7.resized_width/2*enemy2x3_7.resized_width/2)
        {
            if((enemy2x3_7.position_y+enemy2x3_7.resized_height/4-bullet1_3.position_y)*(enemy2x3_7.position_y+enemy2x3_7.resized_height/4-bullet1_3.position_y) < enemy2x3_7.resized_height/2*enemy2x3_7.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[46] = 0;
                enemy2x3_7.position(267*size_dm, 203*size_dm);
                enemy2x3_7.setObstacleAlpha(0);
                enemy2x3_7.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }

        if((enemy2x3_7.position_x+enemy2x3_7.resized_width/4-bullet1_4.position_x)*(enemy2x3_7.position_x+enemy2x3_7.resized_width/4-bullet1_4.position_x) <enemy2x3_7.resized_width/2*enemy2x3_7.resized_width/2)
        {
            if((enemy2x3_7.position_y+enemy2x3_7.resized_height/4-bullet1_4.position_y)*(enemy2x3_7.position_y+enemy2x3_7.resized_height/4-bullet1_4.position_y) < enemy2x3_7.resized_height/2*enemy2x3_7.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[46] = 0;
                enemy2x3_7.position(267*size_dm, 203*size_dm);
                enemy2x3_7.setObstacleAlpha(0);
                enemy2x3_7.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }

        if((enemy2x3_7.position_x+enemy2x3_7.resized_width/4-bullet1_5.position_x)*(enemy2x3_7.position_x+enemy2x3_7.resized_width/4-bullet1_5.position_x) < enemy2x3_7.resized_width/2*enemy2x3_7.resized_width/2)
        {
            if((enemy2x3_7.position_y+enemy2x3_7.resized_height/4-bullet1_5.position_y)*(enemy2x3_7.position_y+enemy2x3_7.resized_height/4-bullet1_5.position_y) < enemy2x3_7.resized_height/2*enemy2x3_7.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[46] = 0;
                enemy2x3_7.position(267*size_dm, 203*size_dm);
                enemy2x3_7.setObstacleAlpha(0);
                enemy2x3_7.position_effect();

                bullet[4] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        if((enemy2x3_8.position_x+enemy2x3_8.resized_width/4-bullet1_1.position_x)*(enemy2x3_8.position_x+enemy2x3_8.resized_width/4-bullet1_1.position_x) < enemy2x3_8.resized_width/2*enemy2x3_8.resized_width/2)
        {
            if((enemy2x3_8.position_y+enemy2x3_8.resized_height/4-bullet1_1.position_y)*(enemy2x3_8.position_y+enemy2x3_8.resized_height/4-bullet1_1.position_y) < enemy2x3_8.resized_height/2*enemy2x3_8.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[47] = 0;
                enemy2x3_8.position(280*size_dm, 219*size_dm);
                enemy2x3_8.setObstacleAlpha(0);
                enemy2x3_8.position_effect();

                bullet[0] = 0;
                bullet1_1.position(10, 10);
                bullet1_1.setObstacleAlpha(0);
                bullet1_1.position_effect();
            }
        }

        if((enemy2x3_8.position_x+enemy2x3_8.resized_width/4-bullet1_2.position_x)*(enemy2x3_8.position_x+enemy2x3_8.resized_width/4-bullet1_2.position_x) < enemy2x3_8.resized_width/2*enemy2x3_8.resized_width/2)
        {
            if((enemy2x3_8.position_y+enemy2x3_8.resized_height/4-bullet1_2.position_y)*(enemy2x3_8.position_y+enemy2x3_8.resized_height/4-bullet1_2.position_y) <enemy2x3_8.resized_height/2*enemy2x3_8.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[47] = 0;
                enemy2x3_8.position(280*size_dm, 219*size_dm);
                enemy2x3_8.setObstacleAlpha(0);
                enemy2x3_8.position_effect();

                bullet[1] = 0;
                bullet1_2.position(10, 10);
                bullet1_2.setObstacleAlpha(0);
                bullet1_2.position_effect();
            }
        }

        if((enemy2x3_8.position_x+enemy2x3_8.resized_width/4-bullet1_3.position_x)*(enemy2x3_8.position_x+enemy2x3_8.resized_width/4-bullet1_3.position_x) < enemy2x3_8.resized_width/2*enemy2x3_8.resized_width/2)
        {
            if((enemy2x3_8.position_y+enemy2x3_8.resized_height/4-bullet1_3.position_y)*(enemy2x3_8.position_y+enemy2x3_8.resized_height/4-bullet1_3.position_y) < enemy2x3_8.resized_height/2*enemy2x3_8.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[47] = 0;
                enemy2x3_8.position(280*size_dm, 219*size_dm);
                enemy2x3_8.setObstacleAlpha(0);
                enemy2x3_8.position_effect();

                bullet[2] = 0;
                bullet1_3.position(10, 10);
                bullet1_3.setObstacleAlpha(0);
                bullet1_3.position_effect();
            }
        }

        if((enemy2x3_8.position_x+enemy2x3_8.resized_width/4-bullet1_4.position_x)*(enemy2x3_8.position_x+enemy2x3_8.resized_width/4-bullet1_4.position_x) < enemy2x3_8.resized_width/2*enemy2x3_8.resized_width/2)
        {
            if((enemy2x3_8.position_y+enemy2x3_8.resized_height/4-bullet1_4.position_y)*(enemy2x3_8.position_y+enemy2x3_8.resized_height/4-bullet1_4.position_y) < enemy2x3_8.resized_height/2*enemy2x3_8.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[47] = 0;
                enemy2x3_8.position(280*size_dm, 219*size_dm);
                enemy2x3_8.setObstacleAlpha(0);
                enemy2x3_8.position_effect();

                bullet[3] = 0;
                bullet1_4.position(10, 10);
                bullet1_4.setObstacleAlpha(0);
                bullet1_4.position_effect();
            }
        }

        if((enemy2x3_8.position_x+enemy2x3_8.resized_width/4-bullet1_5.position_x)*(enemy2x3_8.position_x+enemy2x3_8.resized_width/4-bullet1_5.position_x) < enemy2x3_8.resized_width/2*enemy2x3_8.resized_width/2)
        {
            if((enemy2x3_8.position_y+enemy2x3_8.resized_height/4-bullet1_5.position_y)*(enemy2x3_8.position_y+enemy2x3_8.resized_height/4-bullet1_5.position_y) < enemy2x3_8.resized_height/2*enemy2x3_8.resized_height/2)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                pattern[47] = 0;
                enemy2x3_8.position(280*size_dm, 219*size_dm);
                enemy2x3_8.setObstacleAlpha(0);
                enemy2x3_8.position_effect();

                bullet[3] = 0;
                bullet1_5.position(10, 10);
                bullet1_5.setObstacleAlpha(0);
                bullet1_5.position_effect();
            }
        }


    }

    public void enemy_moving(int x, int y, int z) {

        if(total_time_number >= 0 && health_number < 3) {
            if(pattern[0] == 1) {
                if (enemy1_1.position_x >= 280*size_dm) {
                    enemy1_1.position(120*size_dm, 125*size_dm);
                    enemy1_1.setObstacleAlpha(200);
                } else {
                    enemy1_1.setObstacleAlpha(200);
                    enemy1_1.setPosition(x, y);
                }
            }

            if(pattern[1] == 1) {
                if (enemy1_2.position_x >= 267*size_dm) {
                    enemy1_2.position(107*size_dm, 138*size_dm);
                    enemy1_2.setObstacleAlpha(200);
                } else {
                    enemy1_2.setObstacleAlpha(200);
                    enemy1_2.setPosition(x, y);
                }
            }

            if(pattern[2] == 1) {
                if (enemy1_3.position_x >= 254*size_dm) {
                    enemy1_3.position(94*size_dm, 151*size_dm);
                    enemy1_3.setObstacleAlpha(200);
                } else {
                    enemy1_3.setObstacleAlpha(200);
                    enemy1_3.setPosition(x, y);
                }
            }

            if(pattern[3] == 1) {
                if (enemy1_4.position_x >= 241*size_dm) {
                    enemy1_4.position(81*size_dm, 164*size_dm);
                    enemy1_4.setObstacleAlpha(200);
                } else {
                    enemy1_4.setObstacleAlpha(200);
                    enemy1_4.setPosition(x, y);
                }
            }

            if(pattern[4] == 1) {
                if (enemy1_5.position_x >= 228*size_dm) {
                    enemy1_5.position(68*size_dm, 177*size_dm);
                    enemy1_5.setObstacleAlpha(200);
                } else {
                    enemy1_5.setObstacleAlpha(200);
                    enemy1_5.setPosition(x, y);
                }
            }

            if(pattern[5] == 1) {
                if (enemy1_6.position_x >= 215*size_dm) {
                    enemy1_6.position(55*size_dm, 190*size_dm);
                    enemy1_6.setObstacleAlpha(200);
                } else {
                    enemy1_6.setObstacleAlpha(200);
                    enemy1_6.setPosition(x, y);
                }
            }

            if(pattern[6] == 1) {
                if (enemy1_7.position_x >= 202*size_dm) {
                    enemy1_7.position(42*size_dm, 203*size_dm);
                    enemy1_7.setObstacleAlpha(200);
                } else {
                    enemy1_7.setObstacleAlpha(200);
                    enemy1_7.setPosition(x, y);
                }
            }

            if(pattern[7] == 1) {
                if (enemy1_8.position_x >= 189*size_dm) {
                    enemy1_8.position(29*size_dm, 216*size_dm);
                    enemy1_8.setObstacleAlpha(200);
                } else {
                    enemy1_8.setObstacleAlpha(200);
                    enemy1_8.setPosition(x, y);
                }
            }
/////////////////////////////////////////////////////////////////

            if(pattern[8] == 1) {
                if (enemy1x2_1.position_x >= 280*size_dm) {
                    enemy1x2_1.position(120*size_dm, 125*size_dm);
                    enemy1x2_1.setObstacleAlpha(200);
                } else {
                    enemy1x2_1.setObstacleAlpha(200);
                    enemy1x2_1.setPosition(x, y);
                }
            }

            if(pattern[9] == 1) {
                if (enemy1x2_2.position_x >= 267*size_dm) {
                    enemy1x2_2.position(107*size_dm, 138*size_dm);
                    enemy1x2_2.setObstacleAlpha(200);
                } else {
                    enemy1x2_2.setObstacleAlpha(200);
                    enemy1x2_2.setPosition(x, y);
                }
            }

            if(pattern[10] == 1) {
                if (enemy1x2_3.position_x >= 254*size_dm) {
                    enemy1x2_3.position(94*size_dm, 151*size_dm);
                    enemy1x2_3.setObstacleAlpha(200);
                } else {
                    enemy1x2_3.setObstacleAlpha(200);
                    enemy1x2_3.setPosition(x, y);
                }
            }

            if(pattern[11] == 1) {
                if (enemy1x2_4.position_x >= 241*size_dm) {
                    enemy1x2_4.position(81*size_dm, 164*size_dm);
                    enemy1x2_4.setObstacleAlpha(200);
                } else {
                    enemy1x2_4.setObstacleAlpha(200);
                    enemy1x2_4.setPosition(x, y);
                }
            }

            if(pattern[12] == 1) {
                if (enemy1x2_5.position_x >= 228*size_dm) {
                    enemy1x2_5.position(68*size_dm, 177*size_dm);
                    enemy1x2_5.setObstacleAlpha(200);
                } else {
                    enemy1x2_5.setObstacleAlpha(200);
                    enemy1x2_5.setPosition(x, y);
                }
            }

            if(pattern[13] == 1) {
                if (enemy1x2_6.position_x >= 215*size_dm) {
                    enemy1x2_6.position(55*size_dm, 190*size_dm);
                    enemy1x2_6.setObstacleAlpha(200);
                } else {
                    enemy1x2_6.setObstacleAlpha(200);
                    enemy1x2_6.setPosition(x, y);
                }
            }

            if(pattern[14] == 1) {
                if (enemy1x2_7.position_x >= 202*size_dm) {
                    enemy1x2_7.position(42*size_dm, 203*size_dm);
                    enemy1x2_7.setObstacleAlpha(200);
                } else {
                    enemy1x2_7.setObstacleAlpha(200);
                    enemy1x2_7.setPosition(x, y);
                }
            }

            if(pattern[15] == 1) {
                if (enemy1x2_8.position_x >= 189*size_dm) {
                    enemy1x2_8.position(29*size_dm, 216*size_dm);
                    enemy1x2_8.setObstacleAlpha(200);
                } else {
                    enemy1x2_8.setObstacleAlpha(200);
                    enemy1x2_8.setPosition(x, y);
                }
            }
            /////////////////////////////////////////////////////////////
            if(pattern[16] == 1) {
                if (enemy1x3_1.position_x >= 280*size_dm) {
                    enemy1x3_1.position(120*size_dm, 125*size_dm);
                    enemy1x3_1.setObstacleAlpha(200);
                } else {
                    enemy1x3_1.setObstacleAlpha(200);
                    enemy1x3_1.setPosition(x, y);
                }
            }

            if(pattern[17] == 1) {
                if (enemy1x3_2.position_x >= 267*size_dm) {
                    enemy1x3_2.position(107*size_dm, 138*size_dm);
                    enemy1x3_2.setObstacleAlpha(200);
                } else {
                    enemy1x3_2.setObstacleAlpha(200);
                    enemy1x3_2.setPosition(x, y);
                }
            }

            if(pattern[18] == 1) {
                if (enemy1x3_3.position_x >= 254*size_dm) {
                    enemy1x3_3.position(94*size_dm, 151*size_dm);
                    enemy1x3_3.setObstacleAlpha(200);
                } else {
                    enemy1x3_3.setObstacleAlpha(200);
                    enemy1x3_3.setPosition(x, y);
                }
            }

            if(pattern[19] == 1) {
                if (enemy1x3_4.position_x >= 241*size_dm) {
                    enemy1x3_4.position(81*size_dm, 164*size_dm);
                    enemy1x3_4.setObstacleAlpha(200);
                } else {
                    enemy1x3_4.setObstacleAlpha(200);
                    enemy1x3_4.setPosition(x, y);
                }
            }

            if(pattern[20] == 1) {
                if (enemy1x3_5.position_x >= 228*size_dm) {
                    enemy1x3_5.position(68*size_dm, 177*size_dm);
                    enemy1x3_5.setObstacleAlpha(200);
                } else {
                    enemy1x3_5.setObstacleAlpha(200);
                    enemy1x3_5.setPosition(x, y);
                }
            }

            if(pattern[21] == 1) {
                if (enemy1x3_6.position_x >= 215*size_dm) {
                    enemy1x3_6.position(55*size_dm, 190*size_dm);
                    enemy1x3_6.setObstacleAlpha(200);
                } else {
                    enemy1x3_6.setObstacleAlpha(200);
                    enemy1x3_6.setPosition(x, y);
                }
            }

            if(pattern[22] == 1) {
                if (enemy1x3_7.position_x >= 202*size_dm) {
                    enemy1x3_7.position(42*size_dm, 203*size_dm);
                    enemy1x3_7.setObstacleAlpha(200);
                } else {
                    enemy1x3_7.setObstacleAlpha(200);
                    enemy1x3_7.setPosition(x, y);
                }
            }

            if(pattern[23] == 1) {
                if (enemy1x3_8.position_x >= 189*size_dm) {
                    enemy1x3_8.position(29*size_dm, 216*size_dm);
                    enemy1x3_8.setObstacleAlpha(200);
                } else {
                    enemy1x3_8.setObstacleAlpha(200);
                    enemy1x3_8.setPosition(x, y);
                }
            }
            ///////////////////
        }

    }

    public void enemy2_moving(int x, int y, int z) {

        if(total_time_number >= 0 && health_number < 3) {
            if(pattern[24] == 1) {
                if (enemy2_1.position_x <= 29*size_dm) {
                    enemy2_1.position(189*size_dm, 125*size_dm);
                    enemy2_1.setObstacleAlpha(200);
                } else {
                    enemy2_1.setObstacleAlpha(200);
                    enemy2_1.setPosition(x, y);
                }
            }

            if(pattern[25] == 1) {
                if (enemy2_2.position_x <= 42*size_dm) {
                    enemy2_2.position(202*size_dm, 138*size_dm);
                    enemy2_2.setObstacleAlpha(200);
                } else {
                    enemy2_2.setObstacleAlpha(200);
                    enemy2_2.setPosition(x, y);
                }
            }

            if(pattern[26] == 1) {
                if (enemy2_3.position_x <= 55*size_dm) {
                    enemy2_3.position(215*size_dm, 151*size_dm);
                    enemy2_3.setObstacleAlpha(200);
                } else {
                    enemy2_3.setObstacleAlpha(200);
                    enemy2_3.setPosition(x, y);
                }
            }

            if(pattern[27] == 1) {
                if (enemy2_4.position_x <= 68*size_dm) {
                    enemy2_4.position(228*size_dm, 164*size_dm);
                    enemy2_4.setObstacleAlpha(200);
                } else {
                    enemy2_4.setObstacleAlpha(200);
                    enemy2_4.setPosition(x, y);
                }
            }

            if(pattern[28] == 1) {
                if (enemy2_5.position_x <= 81*size_dm) {
                    enemy2_5.position(241*size_dm, 177*size_dm);
                    enemy2_5.setObstacleAlpha(200);
                } else {
                    enemy2_5.setObstacleAlpha(200);
                    enemy2_5.setPosition(x, y);
                }
            }

            if(pattern[29] == 1) {
                if (enemy2_6.position_x <= 94*size_dm) {
                    enemy2_6.position(254*size_dm, 190*size_dm);
                    enemy2_6.setObstacleAlpha(200);
                } else {
                    enemy2_6.setObstacleAlpha(200);
                    enemy2_6.setPosition(x, y);
                }
            }

            if(pattern[30] == 1) {
                if (enemy2_7.position_x <= 107*size_dm) {
                    enemy2_7.position(267*size_dm, 203*size_dm);
                    enemy2_7.setObstacleAlpha(200);
                } else {
                    enemy2_7.setPosition(x, y);
                }
            }

            if(pattern[31] == 1){
                if (enemy2_8.position_x <= 120*size_dm) {
                    enemy2_8.position(280*size_dm, 219*size_dm);
                    enemy2_8.setObstacleAlpha(200);
                } else {
                    enemy2_8.setObstacleAlpha(200);
                    enemy2_8.setPosition(x, y);
                }
            }
            ////////////////////////////////////////////////////////////

            if(pattern[32] == 1) {
                if (enemy2x2_1.position_x <= 29*size_dm) {
                    enemy2x2_1.position(189*size_dm, 125*size_dm);
                    enemy2x2_1.setObstacleAlpha(200);
                } else {
                    enemy2x2_1.setObstacleAlpha(200);
                    enemy2x2_1.setPosition(x, y);
                }
            }

            if(pattern[33] == 1) {
                if (enemy2x2_2.position_x <= 42*size_dm) {
                    enemy2x2_2.position(202*size_dm, 138*size_dm);
                    enemy2x2_2.setObstacleAlpha(200);
                } else {
                    enemy2x2_2.setObstacleAlpha(200);
                    enemy2x2_2.setPosition(x, y);
                }
            }

            if(pattern[34] == 1) {
                if (enemy2x2_3.position_x <= 55*size_dm) {
                    enemy2x2_3.position(215*size_dm, 151*size_dm);
                    enemy2x2_3.setObstacleAlpha(200);
                } else {
                    enemy2x2_3.setObstacleAlpha(200);
                    enemy2x2_3.setPosition(x, y);
                }
            }

            if(pattern[35] == 1) {
                if (enemy2x2_4.position_x <= 68*size_dm) {
                    enemy2x2_4.position(228*size_dm, 164*size_dm);
                    enemy2x2_4.setObstacleAlpha(200);
                } else {
                    enemy2x2_4.setObstacleAlpha(200);
                    enemy2x2_4.setPosition(x, y);
                }
            }

            if(pattern[36] == 1) {
                if (enemy2x2_5.position_x <= 81*size_dm) {
                    enemy2x2_5.position(241*size_dm, 177*size_dm);
                    enemy2x2_5.setObstacleAlpha(200);
                } else {
                    enemy2x2_5.setObstacleAlpha(200);
                    enemy2x2_5.setPosition(x, y);
                }
            }

            if(pattern[37] == 1) {
                if (enemy2x2_6.position_x <= 94*size_dm) {
                    enemy2x2_6.position(254*size_dm, 190*size_dm);
                    enemy2x2_6.setObstacleAlpha(200);
                } else {
                    enemy2x2_6.setObstacleAlpha(200);
                    enemy2x2_6.setPosition(x, y);
                }
            }

            if(pattern[38] == 1) {
                if (enemy2x2_7.position_x <= 107*size_dm) {
                    enemy2x2_7.position(267*size_dm, 203*size_dm);
                    enemy2x2_7.setObstacleAlpha(200);
                } else {
                    enemy2x2_7.setObstacleAlpha(200);
                    enemy2x2_7.setPosition(x, y);
                }
            }

            if(pattern[39] == 1) {
                if (enemy2x2_8.position_x <= 120*size_dm) {
                    enemy2x2_8.position(280*size_dm, 219*size_dm);
                    enemy2x2_8.setObstacleAlpha(200);
                } else {
                    enemy2x2_8.setObstacleAlpha(200);
                    enemy2x2_8.setPosition(x, y);
                }
            }
            ///////////////////////////////////////////////////////////////
            if(pattern[40] == 1) {
                if (enemy2x3_1.position_x <= 29*size_dm) {
                    enemy2x3_1.position(189*size_dm, 125*size_dm);
                    enemy2x3_1.setObstacleAlpha(200);
                } else {
                    enemy2x3_1.setObstacleAlpha(200);
                    enemy2x3_1.setPosition(x, y);
                }
            }

            if(pattern[41] == 1) {
                if (enemy2x3_2.position_x <= 42*size_dm) {
                    enemy2x3_2.position(202*size_dm, 138*size_dm);
                    enemy2x3_2.setObstacleAlpha(200);
                } else {
                    enemy2x3_2.setObstacleAlpha(200);
                    enemy2x3_2.setPosition(x, y);
                }
            }

            if(pattern[42] == 1) {
                if (enemy2x3_3.position_x <= 55*size_dm) {
                    enemy2x3_3.position(215*size_dm, 151*size_dm);
                    enemy2x3_3.setObstacleAlpha(200);
                } else {
                    enemy2x3_3.setPosition(x, y);
                }
            }

            if(pattern[43] == 1) {
                if (enemy2x3_4.position_x <= 68*size_dm) {
                    enemy2x3_4.position(228*size_dm, 164*size_dm);
                    enemy2x3_4.setObstacleAlpha(200);
                } else {
                    enemy2x3_4.setObstacleAlpha(200);
                    enemy2x3_4.setPosition(x, y);
                }
            }

            if(pattern[44] == 1) {
                if (enemy2x3_5.position_x <= 81*size_dm) {
                    enemy2x3_5.position(241*size_dm, 177*size_dm);
                    enemy2x3_5.setObstacleAlpha(200);
                } else {
                    enemy2x3_5.setObstacleAlpha(200);
                    enemy2x3_5.setPosition(x, y);
                }
            }

            if(pattern[45] == 1) {
                if (enemy2x3_6.position_x <= 94*size_dm) {
                    enemy2x3_6.position(254*size_dm, 190*size_dm);
                    enemy2x3_6.setObstacleAlpha(200);
                } else {
                    enemy2x3_6.setObstacleAlpha(200);
                    enemy2x3_6.setPosition(x, y);
                }
            }

            if(pattern[46] == 1) {
                if (enemy2x3_7.position_x <= 107*size_dm) {
                    enemy2x3_7.position(267*size_dm, 203*size_dm);
                    enemy2x3_7.setObstacleAlpha(200);
                } else {
                    enemy2x3_7.setObstacleAlpha(200);
                    enemy2x3_7.setPosition(x, y);
                }
            }

            if(pattern[47] == 1) {
                if (enemy2x3_8.position_x <= 120*size_dm) {
                    enemy2x3_8.position(280*size_dm, 219*size_dm);
                    enemy2x3_8.setObstacleAlpha(200);
                } else {
                    enemy2x3_8.setObstacleAlpha(200);
                    enemy2x3_8.setPosition(x, y);
                }
            }
        }
    }

    void timing_set()
    {
        if(total_time_number > 0) {
            total_time_number -= 1;
            time_number.setText("" + total_time_number);
        }
    }

    void game_setFont(TextView name, String path, int res)
    {
        name = (TextView)findViewById(res);
        Typeface font = Typeface.createFromAsset(this.getAssets(), path);

        name.setTypeface(font);
    }

    private int getRandomMath(int max, int offset) {


        int nResult = (int)(Math.random() * (max-offset+1)) + offset;


        return nResult;

    }


    void health_check(boolean x)
    {
        if(x == true)
        {
            ++health_number;
            stun_player = true;
        }

        if(health_number == 1)
        {
            heart1.setVisibility(heart1.INVISIBLE);
        }
        else if(health_number == 2)
        {
            heart2.setVisibility(heart2.INVISIBLE);
        }
        else if(health_number == 3)
        {
            heart3.setVisibility(heart3.INVISIBLE);
        }

    }

    @Override
    protected void onDestroy()
    {
        Drawable t = tile1_1.getDrawable();

        Drawable t31 = tile1_32.getDrawable();


        Drawable t_13 = tile2_13.getDrawable();

        Drawable t_20 = tile2_20.getDrawable();


        Drawable h1 = heart1.getDrawable();
        Drawable h2 = heart2.getDrawable();
        Drawable h3 = heart3.getDrawable();

        if(t instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t.setCallback(null);

        if(t31 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t31).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t31.setCallback(null);


        if(t_13 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t_13).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_13.setCallback(null);


        if(t_20 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t_20).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_20.setCallback(null);


        if(h1 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)h1).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        h1.setCallback(null);

        if(h2 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)h2).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        h2.setCallback(null);

        if(h3 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)h3).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        h3.setCallback(null);

       enemy1_1.empty(); enemy1_2.empty(); enemy1_3.empty(); enemy1_4.empty(); enemy1_5.empty(); enemy1_6.empty(); enemy1_7.empty(); enemy1_8.empty();
        enemy2_1.empty(); enemy2_2.empty(); enemy2_3.empty(); enemy2_4.empty(); enemy2_5.empty(); enemy2_6.empty(); enemy2_7.empty(); enemy2_8.empty();
        enemy1x2_1.empty(); enemy1x2_2.empty(); enemy1x2_3.empty(); enemy1x2_4.empty(); enemy1x2_5.empty(); enemy1x2_6.empty(); enemy1x2_7.empty(); enemy1x2_8.empty();
        enemy2x2_1.empty(); enemy2x2_2.empty(); enemy2x2_3.empty(); enemy2x2_4.empty();  enemy2x2_5.empty();  enemy2x2_6.empty();  enemy2x2_7.empty(); enemy2x2_8.empty();
         enemy1x3_1.empty(); enemy1x3_2.empty(); enemy1x3_3.empty(); enemy1x3_4.empty(); enemy1x3_5.empty(); enemy1x3_6.empty(); enemy1x3_7.empty(); enemy1x3_8.empty();
         enemy2x3_1.empty(); enemy2x3_2.empty(); enemy2x3_3.empty(); enemy2x3_4.empty();  enemy2x3_5.empty();  enemy2x3_6.empty();  enemy2x3_7.empty(); enemy2x3_8.empty();

         enemy_bullet1.empty(); enemy_bullet2.empty(); enemy_bullet3.empty(); enemy_bullet4.empty(); enemy_bullet5.empty(); enemy_bullet6.empty(); enemy_bullet7.empty(); enemy_bullet8.empty();
                enemy_bullet9.empty(); enemy_bullet10.empty(); enemy_bullet11.empty(); enemy_bullet12.empty(); enemy_bullet13.empty(); enemy_bullet14.empty(); enemy_bullet15.empty(); enemy_bullet16.empty();

         bullet1_1.empty(); bullet1_2.empty(); bullet1_3.empty(); bullet1_4.empty(); bullet1_5.empty();
        js.empty();
        super.onDestroy();

    }


    //Disable Return Button
    @Override
    public boolean dispatchKeyEvent(KeyEvent event){

        if(event.getAction() == KeyEvent.ACTION_DOWN){

            switch (event.getKeyCode()){

                case KeyEvent.KEYCODE_BACK:
                    return true;

            }

        }

        return super.dispatchKeyEvent(event);

    }

}
