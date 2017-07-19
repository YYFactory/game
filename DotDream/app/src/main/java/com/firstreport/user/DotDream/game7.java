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
 * Created by user on 2017-07-08.
 */

public class game7 extends AppCompatActivity{

    private int tile_end_x1, tile_end_y1;
    private int tile_end_x2, tile_end_y2;
    private int tile_end_x3, tile_end_y3;
    private int tile_end_x4, tile_end_y4;
    private int prior_player_x, prior_player_y;
    private int timing_number = 0, total_time_number = 50, health_timing_number = 0, level_time_number=0;
    private int pattern_number=0, health_number = 0, pattern2_number;
    private int size_dm;
    private int score_total = 0;

    private int SpeedX, SpeedY;
    private int obstacle_SpeedX, obstacle_SpeedY;
    private int obstacle_2_SpeedX, obstacle_2_SpeedY;
    private int obstacle_3_SpeedX, obstacle_3_SpeedY;
    private int screenWidth;
    private int screenHeight;
    private int frameHeight;
    private int pattern[]={0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0};
    private int pattern2[]={0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                            0, 0, 0, 0};
    private int Judge_width;

    private boolean Isdamaged_player;
    private boolean stun_player = false;

    private float player_scale;

    private Handler handler = new Handler();
    private Timer timer = new Timer();
    private ImageView player;

    private RelativeLayout layout_joystick;
    private RelativeLayout gameview7;

    private ImageView tile1_1, tile1_32;
    private ImageView tile2_13, tile2_20;
    private ImageView heart1, heart2, heart3;
    private TextView score, score_number, time, time_number, life;

    JoyStickClass js;
    ObstacleClass obs, obs_1, obs_2, obs_3, obs_4, obs_5, obs_6, obs_7;
    ObstacleClass obsx2, obsx2_1, obsx2_2, obsx2_3, obsx2_4, obsx2_5, obsx2_6, obsx2_7;
    ObstacleClass obsx3, obsx3_1, obsx3_2, obsx3_3, obsx3_4, obsx3_5, obsx3_6, obsx3_7;
    ObstacleClass obs1, obs_1_1, obs_2_1, obs_3_1, obs_4_1, obs_5_1, obs_6_1, obs_7_1;
    ObstacleClass obs1x2, obsx2_1_1, obsx2_2_1, obsx2_3_1, obsx2_4_1, obsx2_5_1, obsx2_6_1, obsx2_7_1;
    ObstacleClass obs1x3, obsx3_1_1, obsx3_2_1, obsx3_3_1, obsx3_4_1, obsx3_5_1, obsx3_6_1, obsx3_7_1;
    ObstacleClass obs2, obs2_1, obs2_2;

    ObstacleClass Getsmaller[] = new ObstacleClass[64];

    private boolean action_flg = false;
    private boolean start_flg = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameview7);

        DisplayMetrics dm = getResources().getDisplayMetrics();
        size_dm = Math.round(dm.density);

        player_scale = 1;
        Judge_width=8*size_dm;

        obstacle_SpeedX = 1;
        obstacle_SpeedY = 1;

        obstacle_2_SpeedX = -1;
        obstacle_2_SpeedY = 1;

        obstacle_3_SpeedX = 0;
        obstacle_3_SpeedY = 1;

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
        gameview7 = (RelativeLayout) findViewById(R.id.gameview7);

        js = new JoyStickClass(getApplicationContext(), layout_joystick, R.drawable.center);
        js.setStickSize(30*size_dm, 30*size_dm);
        js.setLayoutSize(100*size_dm, 100*size_dm);
        js.setLayoutAlpha(50);
        js.setStickAlpha(50);
        js.setOffset(15*size_dm);
        js.setMinimumDistance(1*size_dm);

        js.initial_draw(50*size_dm, 50*size_dm);

        obs = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obs.position(120*size_dm, 125*size_dm);
        obs.resized_image(30*size_dm, 30*size_dm);
        obs.setObstacleAlpha(200);

        obs_1 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obs_1.position(107*size_dm, 138*size_dm);
        obs_1.resized_image(30*size_dm, 30*size_dm);
        obs_1.setObstacleAlpha(200);

        obs_2 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obs_2.position(94*size_dm, 151*size_dm);
        obs_2.resized_image(30*size_dm, 30*size_dm);
        obs_2.setObstacleAlpha(200);

        obs_3 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obs_3.position(81*size_dm, 164*size_dm);
        obs_3.resized_image(30*size_dm, 30*size_dm);
        obs_3.setObstacleAlpha(200);

        obs_4 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obs_4.position(68*size_dm, 177*size_dm);
        obs_4.resized_image(30*size_dm, 30*size_dm);
        obs_4.setObstacleAlpha(200);

        obs_5 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obs_5.position(55*size_dm, 190*size_dm);
        obs_5.resized_image(30*size_dm, 30*size_dm);
        obs_5.setObstacleAlpha(200);

        obs_6 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obs_6.position(42*size_dm, 203*size_dm);
        obs_6.resized_image(30*size_dm, 30*size_dm);
        obs_6.setObstacleAlpha(200);

        obs_7 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obs_7.position(29*size_dm, 216*size_dm);
        obs_7.resized_image(30*size_dm, 30*size_dm);
        obs_7.setObstacleAlpha(200);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        obsx2 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obsx2.position(120*size_dm, 125*size_dm);
        obsx2.resized_image(30*size_dm, 30*size_dm);
        obsx2.setObstacleAlpha(200);

        obsx2_1 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obsx2_1.position(107*size_dm, 138*size_dm);
        obsx2_1.resized_image(30*size_dm, 30*size_dm);
        obsx2_1.setObstacleAlpha(200);

        obsx2_2 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obsx2_2.position(94*size_dm, 151*size_dm);
        obsx2_2.resized_image(30*size_dm, 30*size_dm);
        obsx2_2.setObstacleAlpha(200);

        obsx2_3 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obsx2_3.position(81*size_dm, 164*size_dm);
        obsx2_3.resized_image(30*size_dm, 30*size_dm);
        obsx2_3.setObstacleAlpha(200);

        obsx2_4 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obsx2_4.position(68*size_dm, 177*size_dm);
        obsx2_4.resized_image(30*size_dm, 30*size_dm);
        obsx2_4.setObstacleAlpha(200);

        obsx2_5 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obsx2_5.position(55*size_dm, 190*size_dm);
        obsx2_5.resized_image(30*size_dm, 30*size_dm);
        obsx2_5.setObstacleAlpha(200);

        obsx2_6 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obsx2_6.position(42*size_dm, 203*size_dm);
        obsx2_6.resized_image(30*size_dm, 30*size_dm);
        obsx2_6.setObstacleAlpha(200);

        obsx2_7 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obsx2_7.position(29*size_dm, 216*size_dm);
        obsx2_7.resized_image(30*size_dm, 30*size_dm);
        obsx2_7.setObstacleAlpha(200);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////
        obsx3 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obsx3.position(100*size_dm, 109*size_dm);
        obsx3.resized_image(30*size_dm, 30*size_dm);
        obsx3.setObstacleAlpha(200);

        obsx3_1 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obsx3_1.position(53*size_dm, 86*size_dm);
        obsx3_1.resized_image(30*size_dm, 30*size_dm);
        obsx3_1.setObstacleAlpha(200);

        obsx3_2 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obsx3_2.position(45*size_dm, 104*size_dm);
        obsx3_2.resized_image(30*size_dm, 30*size_dm);
        obsx3_2.setObstacleAlpha(200);

        obsx3_3 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obsx3_3.position(60*size_dm, 139*size_dm);
        obsx3_3.resized_image(30*size_dm, 30*size_dm);
        obsx3_3.setObstacleAlpha(200);

        obsx3_4 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obsx3_4.position(75*size_dm, 164*size_dm);
        obsx3_4.resized_image(30*size_dm, 30*size_dm);
        obsx3_4.setObstacleAlpha(200);

        obsx3_5 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obsx3_5.position(90*size_dm, 222*size_dm);
        obsx3_5.resized_image(30*size_dm, 30*size_dm);
        obsx3_5.setObstacleAlpha(200);

        obsx3_6 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obsx3_6.position(67*size_dm, 224*size_dm);
        obsx3_6.resized_image(30*size_dm, 30*size_dm);
        obsx3_6.setObstacleAlpha(200);

        obsx3_7 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obsx3_7.position(40*size_dm, 233*size_dm);
        obsx3_7.resized_image(30*size_dm, 30*size_dm);
        obsx3_7.setObstacleAlpha(200);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        obs1 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obs1.position(189*size_dm, 125*size_dm);
        obs1.resized_image(30*size_dm, 30*size_dm);
        obs1.setObstacleAlpha(200);

        obs_1_1 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obs_1_1.position(202*size_dm, 138*size_dm);
        obs_1_1.resized_image(30*size_dm, 30*size_dm);
        obs_1_1.setObstacleAlpha(200);

        obs_2_1 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obs_2_1.position(215*size_dm, 151*size_dm);
        obs_2_1.resized_image(30*size_dm, 30*size_dm);
        obs_2_1.setObstacleAlpha(200);

        obs_3_1 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obs_3_1.position(228*size_dm, 164*size_dm);
        obs_3_1.resized_image(30*size_dm, 30*size_dm);
        obs_3_1.setObstacleAlpha(200);

        obs_4_1=  new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obs_4_1.position(241*size_dm, 177*size_dm);
        obs_4_1.resized_image(30*size_dm, 30*size_dm);
        obs_4_1.setObstacleAlpha(200);

        obs_5_1 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obs_5_1.position(254*size_dm, 190*size_dm);
        obs_5_1.resized_image(30*size_dm, 30*size_dm);
        obs_5_1.setObstacleAlpha(200);

        obs_6_1 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obs_6_1.position(267*size_dm, 203*size_dm);
        obs_6_1.resized_image(30*size_dm, 30*size_dm);
        obs_6_1.setObstacleAlpha(200);

        obs_7_1 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obs_7_1.position(280*size_dm, 216*size_dm);
        obs_7_1.resized_image(30*size_dm, 30*size_dm);
        obs_7_1.setObstacleAlpha(200);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        obs1x2 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obs1x2.position(189*size_dm, 125*size_dm);
        obs1x2.resized_image(30*size_dm, 30*size_dm);
        obs1x2.setObstacleAlpha(200);

        obsx2_1_1 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obsx2_1_1.position(202*size_dm, 138*size_dm);
        obsx2_1_1.resized_image(30*size_dm, 30*size_dm);
        obsx2_1_1.setObstacleAlpha(200);

        obsx2_2_1 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obsx2_2_1.position(215*size_dm, 151*size_dm);
        obsx2_2_1.resized_image(30*size_dm, 30*size_dm);
        obsx2_2_1.setObstacleAlpha(200);

        obsx2_3_1 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obsx2_3_1.position(228*size_dm, 164*size_dm);
        obsx2_3_1.resized_image(30*size_dm, 30*size_dm);
        obsx2_3_1.setObstacleAlpha(200);

        obsx2_4_1=  new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obsx2_4_1.position(241*size_dm, 177*size_dm);
        obsx2_4_1.resized_image(30*size_dm, 30*size_dm);
        obsx2_4_1.setObstacleAlpha(200);

        obsx2_5_1 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obsx2_5_1.position(254*size_dm, 190*size_dm);
        obsx2_5_1.resized_image(30*size_dm, 30*size_dm);
        obsx2_5_1.setObstacleAlpha(200);

        obsx2_6_1 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obsx2_6_1.position(267*size_dm, 203*size_dm);
        obsx2_6_1.resized_image(30*size_dm, 30*size_dm);
        obsx2_6_1.setObstacleAlpha(200);

        obsx2_7_1 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obsx2_7_1.position(280*size_dm, 216*size_dm);
        obsx2_7_1.resized_image(30*size_dm, 30*size_dm);
        obsx2_7_1.setObstacleAlpha(200);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        obs1x3 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obs1x3.position(189*size_dm, 125*size_dm);
        obs1x3.resized_image(30*size_dm, 30*size_dm);
        obs1x3.setObstacleAlpha(200);

        obsx3_1_1 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obsx3_1_1.position(202*size_dm, 138*size_dm);
        obsx3_1_1.resized_image(30*size_dm, 30*size_dm);
        obsx3_1_1.setObstacleAlpha(200);

        obsx3_2_1 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obsx3_2_1.position(215*size_dm, 151*size_dm);
        obsx3_2_1.resized_image(30*size_dm, 30*size_dm);
        obsx3_2_1.setObstacleAlpha(200);

        obsx3_3_1 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obsx3_3_1.position(228*size_dm, 164*size_dm);
        obsx3_3_1.resized_image(30*size_dm, 30*size_dm);
        obsx3_3_1.setObstacleAlpha(200);

        obsx3_4_1=  new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obsx3_4_1.position(241*size_dm, 177*size_dm);
        obsx3_4_1.resized_image(30*size_dm, 30*size_dm);
        obsx3_4_1.setObstacleAlpha(200);

        obsx3_5_1 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obsx3_5_1.position(254*size_dm, 190*size_dm);
        obsx3_5_1.resized_image(30*size_dm, 30*size_dm);
        obsx3_5_1.setObstacleAlpha(200);

        obsx3_6_1 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obsx3_6_1.position(267*size_dm, 203*size_dm);
        obsx3_6_1.resized_image(30*size_dm, 30*size_dm);
        obsx3_6_1.setObstacleAlpha(200);

        obsx3_7_1 = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.enemy);
        obsx3_7_1.position(280*size_dm, 216*size_dm);
        obsx3_7_1.resized_image(30*size_dm, 30*size_dm);
        obsx3_7_1.setObstacleAlpha(200);
        //////////////////////////////////////////////////////////////////////////////

        Getsmaller[0] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[0].position(68*size_dm, 251*size_dm);
        Getsmaller[0].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[0].setObstacleAlpha(255);

        Getsmaller[1] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[1].position(81*size_dm, 239*size_dm);
        Getsmaller[1].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[1].setObstacleAlpha(255);

        Getsmaller[2] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[2].position(81*size_dm, 265*size_dm);
        Getsmaller[2].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[2].setObstacleAlpha(255);

        Getsmaller[3] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[3].position(94*size_dm, 226*size_dm);
        Getsmaller[3].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[3].setObstacleAlpha(255);

        Getsmaller[4] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[4].position(94*size_dm, 252*size_dm);
        Getsmaller[4].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[4].setObstacleAlpha(255);

        Getsmaller[5] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[5].position(94*size_dm, 278*size_dm);
        Getsmaller[5].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[5].setObstacleAlpha(255);

        Getsmaller[6] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[6].position(107*size_dm, 213*size_dm);
        Getsmaller[6].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[6].setObstacleAlpha(255);

        Getsmaller[7] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[7].position(107*size_dm, 239*size_dm);
        Getsmaller[7].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[7].setObstacleAlpha(255);

        Getsmaller[8] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[8].position(107*size_dm, 265*size_dm);
        Getsmaller[8].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[8].setObstacleAlpha(255);

        Getsmaller[9] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[9].position(107*size_dm, 291*size_dm);
        Getsmaller[9].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[9].setObstacleAlpha(255);

        Getsmaller[10] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[10].position(120*size_dm, 200*size_dm);
        Getsmaller[10].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[10].setObstacleAlpha(255);

        Getsmaller[11] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[11].position(120*size_dm, 226*size_dm);
        Getsmaller[11].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[11].setObstacleAlpha(255);

        Getsmaller[12] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[12].position(120*size_dm, 252*size_dm);
        Getsmaller[12].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[12].setObstacleAlpha(255);

        Getsmaller[13] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[13].position(120*size_dm, 278*size_dm);
        Getsmaller[13].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[13].setObstacleAlpha(255);

        Getsmaller[14] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[14].position(120*size_dm, 304*size_dm);
        Getsmaller[14].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[14].setObstacleAlpha(255);

        Getsmaller[15] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[15].position(133*size_dm, 187*size_dm);
        Getsmaller[15].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[15].setObstacleAlpha(255);

        Getsmaller[16] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[16].position(133*size_dm, 213*size_dm);
        Getsmaller[16].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[16].setObstacleAlpha(255);

        Getsmaller[17] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[17].position(133*size_dm, 239*size_dm);
        Getsmaller[17].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[17].setObstacleAlpha(255);

        Getsmaller[18] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[18].position(133*size_dm, 265*size_dm);
        Getsmaller[18].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[18].setObstacleAlpha(255);

        Getsmaller[19] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[19].position(133*size_dm, 291*size_dm);
        Getsmaller[19].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[19].setObstacleAlpha(255);

        Getsmaller[20] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[20].position(133*size_dm, 317*size_dm);
        Getsmaller[20].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[20].setObstacleAlpha(255);

        Getsmaller[21] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[21].position(146*size_dm, 174*size_dm);
        Getsmaller[21].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[21].setObstacleAlpha(255);

        Getsmaller[22] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[22].position(146*size_dm, 200*size_dm);
        Getsmaller[22].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[22].setObstacleAlpha(255);

        Getsmaller[23] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[23].position(146*size_dm, 226*size_dm);
        Getsmaller[23].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[23].setObstacleAlpha(255);

        Getsmaller[24] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[24].position(146*size_dm, 252*size_dm);
        Getsmaller[24].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[24].setObstacleAlpha(255);

        Getsmaller[25] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[25].position(146*size_dm, 278*size_dm);
        Getsmaller[25].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[25].setObstacleAlpha(255);

        Getsmaller[26] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[26].position(146*size_dm, 304*size_dm);
        Getsmaller[26].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[26].setObstacleAlpha(255);

        Getsmaller[27] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[27].position(146*size_dm, 330*size_dm);
        Getsmaller[27].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[27].setObstacleAlpha(255);

        Getsmaller[28] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[28].position(159*size_dm, 161*size_dm);
        Getsmaller[28].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[28].setObstacleAlpha(255);

        Getsmaller[29] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[29].position(159*size_dm, 187*size_dm);
        Getsmaller[29].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[29].setObstacleAlpha(255);

        Getsmaller[30] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[30].position(159*size_dm, 213*size_dm);
        Getsmaller[30].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[30].setObstacleAlpha(255);

        Getsmaller[31] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[31].position(159*size_dm, 239*size_dm);
        Getsmaller[31].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[31].setObstacleAlpha(255);

        Getsmaller[32] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[32].position(159*size_dm, 265*size_dm);
        Getsmaller[32].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[32].setObstacleAlpha(255);

        Getsmaller[33] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[33].position(159*size_dm, 291*size_dm);
        Getsmaller[33].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[33].setObstacleAlpha(255);

        Getsmaller[34] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[34].position(159*size_dm, 317*size_dm);
        Getsmaller[34].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[34].setObstacleAlpha(255);

        Getsmaller[35] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[35].position(159*size_dm, 343*size_dm);
        Getsmaller[35].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[35].setObstacleAlpha(255);

        Getsmaller[36] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[36].position(172*size_dm, 174*size_dm);
        Getsmaller[36].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[36].setObstacleAlpha(255);

        Getsmaller[37] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[37].position(172*size_dm, 200*size_dm);
        Getsmaller[37].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[37].setObstacleAlpha(255);

        Getsmaller[38] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[38].position(172*size_dm, 226*size_dm);
        Getsmaller[38].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[38].setObstacleAlpha(255);

        Getsmaller[39] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[39].position(172*size_dm, 252*size_dm);
        Getsmaller[39].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[39].setObstacleAlpha(255);

        Getsmaller[40] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[40].position(172*size_dm, 278*size_dm);
        Getsmaller[40].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[40].setObstacleAlpha(255);

        Getsmaller[41] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[41].position(172*size_dm, 304*size_dm);
        Getsmaller[41].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[41].setObstacleAlpha(255);

        Getsmaller[42] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[42].position(172*size_dm, 330*size_dm);
        Getsmaller[42].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[42].setObstacleAlpha(255);

        Getsmaller[43] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[43].position(185*size_dm, 187*size_dm);
        Getsmaller[43].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[43].setObstacleAlpha(255);

        Getsmaller[44] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[44].position(185*size_dm, 213*size_dm);
        Getsmaller[44].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[44].setObstacleAlpha(255);

        Getsmaller[45] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[45].position(185*size_dm, 239*size_dm);
        Getsmaller[45].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[45].setObstacleAlpha(255);

        Getsmaller[46] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[46].position(185*size_dm, 265*size_dm);
        Getsmaller[46].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[46].setObstacleAlpha(255);

        Getsmaller[47] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[47].position(185*size_dm, 291*size_dm);
        Getsmaller[47].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[47].setObstacleAlpha(255);

        Getsmaller[48] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[48].position(185*size_dm, 317*size_dm);
        Getsmaller[48].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[48].setObstacleAlpha(255);

        Getsmaller[49] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[49].position(198*size_dm, 200*size_dm);
        Getsmaller[49].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[49].setObstacleAlpha(255);

        Getsmaller[50] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[50].position(198*size_dm, 226*size_dm);
        Getsmaller[50].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[50].setObstacleAlpha(255);

        Getsmaller[51] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[51].position(198*size_dm, 252*size_dm);
        Getsmaller[51].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[51].setObstacleAlpha(255);

        Getsmaller[52] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[52].position(198*size_dm, 278*size_dm);
        Getsmaller[52].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[52].setObstacleAlpha(255);

        Getsmaller[53] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[53].position(198*size_dm, 304*size_dm);
        Getsmaller[53].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[53].setObstacleAlpha(255);

        Getsmaller[54] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[54].position(211*size_dm, 213*size_dm);
        Getsmaller[54].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[54].setObstacleAlpha(255);

        Getsmaller[55] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[55].position(211*size_dm, 239*size_dm);
        Getsmaller[55].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[55].setObstacleAlpha(255);

        Getsmaller[56] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[56].position(211*size_dm, 265*size_dm);
        Getsmaller[56].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[56].setObstacleAlpha(255);

        Getsmaller[57] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[57].position(211*size_dm, 291*size_dm);
        Getsmaller[57].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[57].setObstacleAlpha(255);

        Getsmaller[58] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[58].position(224*size_dm, 226*size_dm);
        Getsmaller[58].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[58].setObstacleAlpha(255);

        Getsmaller[59] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[59].position(224*size_dm, 252*size_dm);
        Getsmaller[59].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[59].setObstacleAlpha(255);

        Getsmaller[60] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[60].position(224*size_dm, 278*size_dm);
        Getsmaller[60].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[60].setObstacleAlpha(255);

        Getsmaller[61] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[61].position(237*size_dm, 239*size_dm);
        Getsmaller[61].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[61].setObstacleAlpha(255);

        Getsmaller[62] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[62].position(237*size_dm, 265*size_dm);
        Getsmaller[62].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[62].setObstacleAlpha(255);

        Getsmaller[63] = new ObstacleClass(getApplicationContext(), gameview7, R.drawable.star);
        Getsmaller[63].position(250*size_dm, 252*size_dm);
        Getsmaller[63].resized_image(25*size_dm, 25*size_dm);
        Getsmaller[63].setObstacleAlpha(255);

        player = (ImageView) findViewById(R.id.player);

        //ps = new PlayerClass(getApplicationContext(), gameview, R.drawable.player);
        //ps.position(300, 300);

        tile1_1 = (ImageView) findViewById(R.id.tile1_1);

        tile1_32 = (ImageView) findViewById(R.id.tile1_32);

        tile2_13 = (ImageView) findViewById(R.id.tile2_13);

        tile2_20 = (ImageView) findViewById(R.id.tile2_20);

        heart1 = (ImageView) findViewById(R.id.heart1);
        heart2 = (ImageView) findViewById(R.id.heart2);
        heart3 = (ImageView) findViewById(R.id.heart3);

        TextView game_first = null;
        score_number = (TextView) findViewById(R.id.score_number);
        score_number.setText("0");

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
                                                Intent intent = new Intent(getApplicationContext(), Ending.class);
                                                intent.putExtra("SCORE", score_total);
                                                startActivity(intent);
                                            }catch(Exception e)
                                            {
                                                Intent intent = new Intent(getApplicationContext(), Ending.class);
                                                intent.putExtra("SCORE", score_total);
                                                startActivity(intent);
                                            }
                                        }else
                                        {
                                            try {
                                                timer.cancel();
                                                timer = null;
                                                Intent intent = new Intent(getApplicationContext(), Main8.class);
                                                intent.putExtra("SCORE", score_total);
                                                startActivity(intent);
                                            }catch(Exception e)
                                            {
                                                Intent intent = new Intent(getApplicationContext(), Main8.class);
                                                intent.putExtra("SCORE", score_total);
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

                                        if (level_time_number % 80 == 0 && level_time_number <= 800) {
                                            pattern_number = getRandomMath(47, 0);
                                            pattern[pattern_number] = 1;
                                        }

                                        if (level_time_number % 40 == 0 && level_time_number > 800 && level_time_number <= 2000) {
                                            pattern_number = getRandomMath(47, 0);
                                            pattern[pattern_number] = 1;
                                        }

                                        if (level_time_number % 10 == 0 && level_time_number > 2000) {
                                            pattern_number = getRandomMath(47, 0);
                                            pattern[pattern_number] = 1;
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

                                        if (timing_number % 5 == 0) //크기늘리기
                                        {
                                            if (player_scale <= 5) {

                                                player_scale += 0.10*size_dm;
                                                Judge_width += 0.10*size_dm;
                                                //player.setLayoutParams(new FrameLayout.LayoutParams(player_scale, player_scale));
                                                player.setScaleX(player_scale);
                                                player.setScaleY(player_scale);

                                            }
                                        }

                                        if (timing_number % 100 == 0) {

                                            for (int i = 0; i < 64; i++) {
                                                pattern2[i] = 0;
                                            }

                                            for (int i = 0; i < 14; i++) {
                                                pattern2_number = getRandomMath(63, 0);
                                                pattern2[pattern2_number] = 1;
                                            }
                                        }

                                        smaller_drug();
                                        obstacle_moving(obstacle_SpeedX, obstacle_SpeedY, pattern_number);
                                        obstacle_2_moving(obstacle_2_SpeedX, obstacle_2_SpeedY, pattern_number);
                                        //obstacle_3_moving(obstacle_3_SpeedX, obstacle_3_SpeedY, pattern_number);
                                        player_moving(SpeedX, SpeedY, action_flg);
                                        hit_check2();
                                        score_number.setText("" + score_total);

                                    }
                                }
                            });
                        }
                    }, 0, 20);

                } else {

                    if (arg1.getAction() == MotionEvent.ACTION_DOWN || arg1.getAction() == MotionEvent.ACTION_MOVE) {

                        action_flg = true;


                    } else if (arg1.getAction() == MotionEvent.ACTION_UP) {

                        js.initial_draw(50*size_dm, 50*size_dm);
                        action_flg = false;

                    } else {

                    }

                }

                return true;

            }
        });

        return true;
    }

    void hit_check2()
    {
        for(int i=0; i<64; i++)
        {
            if(pattern2[i] == 1)
            {
                if((player.getX() - Getsmaller[i].position_x - Getsmaller[i].resized_width/4)*(player.getX() - Getsmaller[i].position_x-Getsmaller[i].resized_width/4) < Judge_width*Judge_width)
                {
                    if((player.getY() - Getsmaller[i].position_y-Getsmaller[i].resized_height/4)*(player.getY() - Getsmaller[i].position_y-Getsmaller[i].resized_height/4) < Judge_width*Judge_width)
                    {

                        if(player_scale >= 1)
                        {
                            player_scale = 1;
                            Judge_width = 8*size_dm;

                            player.setScaleX(player_scale);
                            player.setScaleY(player_scale);
                        }

                        pattern2[i] = 0;
                        Getsmaller[i].setObstacleAlpha(0);
                        Getsmaller[i].position_effect();

                        score_total += 10;
                    }
                }
            }
        }
    }

    void smaller_drug()
    {
        for(int i=0; i<64; i++) {

            if (pattern2[i] == 1) {

                Getsmaller[i].setObstacleAlpha(200);
                Getsmaller[i].position_effect();

            }
            else
            {
                Getsmaller[i].setObstacleAlpha(0);
                Getsmaller[i].position_effect();
            }
        }
    }

    boolean hit_check()
    {
        if((obs.position_x+obs.resized_width/4-player.getX())*(obs.position_x+obs.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obs.position_y+obs.resized_height/4-player.getY())*(obs.position_y+obs.resized_height/4-player.getY()) < Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((obs_1.position_x+obs_1.resized_width/4-player.getX())*(obs_1.position_x+obs_1.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obs_1.position_y+obs_1.resized_height/4-player.getY())*(obs_1.position_y+obs_1.resized_height/4-player.getY()) <Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((obs_2.position_x+obs_2.resized_width/4-player.getX())*(obs_2.position_x+obs_2.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obs_2.position_y+obs_2.resized_height/4-player.getY())*(obs_2.position_y+obs_2.resized_height/4-player.getY()) < Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((obs_3.position_x+obs_3.resized_width/4-player.getX())*(obs_3.position_x+obs_3.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obs_3.position_y+obs_3.resized_height/4-player.getY())*(obs_3.position_y+obs_3.resized_height/4-player.getY()) < Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((obs_4.position_x+obs_4.resized_width/4-player.getX())*(obs_4.position_x+obs_4.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obs_4.position_y+obs_4.resized_height/4-player.getY())*(obs_4.position_y+obs_4.resized_height/4-player.getY()) < Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((obs_5.position_x+obs_5.resized_width/4-player.getX())*(obs_5.position_x+obs_5.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obs_5.position_y+obs_5.resized_height/4-player.getY())*(obs_5.position_y+obs_5.resized_height/4-player.getY()) < Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((obs_6.position_x+obs_6.resized_width/4-player.getX())*(obs_6.position_x+obs_6.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obs_6.position_y+obs_6.resized_height/4-player.getY())*(obs_6.position_y+obs_6.resized_height/4-player.getY()) < Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((obs_7.position_x+obs_7.resized_width/4-player.getX())*(obs_7.position_x+obs_7.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obs_7.position_y+obs_7.resized_height/4-player.getY())*(obs_7.position_y+obs_7.resized_height/4-player.getY()) < Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((obsx2.position_x+obsx2.resized_width/4-player.getX())*(obsx2.position_x+obsx2.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obsx2_1.position_y+obsx2.resized_height/4-player.getY())*(obsx2_1.position_y+obsx2.resized_height/4-player.getY()) <Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((obsx2_1.position_x+obsx2_1.resized_width/4-player.getX())*(obsx2_1.position_x+obsx2_1.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obsx2_1.position_y+obsx2_1.resized_height/4-player.getY())*(obsx2_1.position_y+obsx2_1.resized_height/4-player.getY()) < Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((obsx2_2.position_x+obsx2_2.resized_width/4-player.getX())*(obsx2_2.position_x+obsx2_2.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obsx2_2.position_y+obsx2_2.resized_height/4-player.getY())*(obsx2_2.position_y+obsx2_2.resized_height/4-player.getY()) < Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((obsx2_3.position_x+obsx2_3.resized_width/4-player.getX())*(obsx2_3.position_x+obsx2_3.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obsx2_3.position_y+obsx2_3.resized_height/4-player.getY())*(obsx2_3.position_y+obsx2_3.resized_height/4-player.getY()) < Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((obsx2_4.position_x+obsx2_4.resized_width/4-player.getX())*(obsx2_4.position_x+obsx2_4.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obsx2_4.position_y+obsx2_4.resized_height/4-player.getY())*(obsx2_4.position_y+obsx2_4.resized_height/4-player.getY()) < Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((obsx2_5.position_x+obsx2_5.resized_width/4-player.getX())*(obsx2_5.position_x+obsx2_5.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obsx2_5.position_y+obsx2_5.resized_height/4-player.getY())*(obsx2_5.position_y+obsx2_5.resized_height/4-player.getY()) <Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((obsx2_6.position_x+obsx2_6.resized_width/4-player.getX())*(obsx2_6.position_x+obsx2_6.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obsx2_6.position_y+obsx2_6.resized_height/4-player.getY())*(obsx2_6.position_y+obsx2_6.resized_height/4-player.getY()) < Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((obsx2_7.position_x+obsx2_7.resized_width/4-player.getX())*(obsx2_7.position_x+obsx2_7.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obsx2_7.position_y+obsx2_7.resized_height/4-player.getY())*(obsx2_7.position_y+obsx2_7.resized_height/4-player.getY()) < Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////////

        if((obsx3.position_x+obsx3.resized_width/4-player.getX())*(obsx3.position_x+obsx3.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if ((obsx3.position_y+obsx3.resized_height/4 - player.getY()) * (obsx3.position_y+obsx3.resized_height/4 - player.getY()) < Judge_width*Judge_width) {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if ((obsx3_1.position_x + obsx3_1.resized_width/4- player.getX()) * (obsx3_1.position_x +obsx3_1.resized_width/4 - player.getX()) < Judge_width*Judge_width) {
            if ((obsx3_1.position_y + obsx3_1.resized_height/4- player.getY()) * (obsx3_1.position_y + obsx3_1.resized_height/4 - player.getY()) < Judge_width*Judge_width) {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((obsx3_2.position_x+obsx3_2.resized_width/4-player.getX())*(obsx3_2.position_x+obsx3_2.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obsx3_2.position_y+obsx3_2.resized_height/4-player.getY())*(obsx3_2.position_y+obsx3_2.resized_height/4-player.getY()) < Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((obsx3_3.position_x+obsx3_3.resized_width/4-player.getX())*(obsx3_3.position_x+obsx3_3.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obsx3_3.position_y+obsx3_3.resized_height/4-player.getY())*(obsx3_3.position_y+obsx3_3.resized_height/4-player.getY()) < Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((obsx3_4.position_x+obsx3_4.resized_width/4-player.getX())*(obsx3_4.position_x+obsx3_4.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obsx3_4.position_y+obsx3_4.resized_height/4-player.getY())*(obsx3_4.position_y+obsx3_4.resized_height/4-player.getY()) < Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((obsx3_5.position_x+obsx3_5.resized_width/4-player.getX())*(obsx3_5.position_x+obsx3_5.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obsx3_5.position_y+obsx3_5.resized_height/4-player.getY())*(obsx3_5.position_y+obsx3_5.resized_height/4-player.getY()) < Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((obsx3_6.position_x+obsx3_6.resized_width/4-player.getX())*(obsx3_6.position_x+obsx3_6.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obsx3_6.position_y+obsx3_6.resized_height/4-player.getY())*(obsx3_6.position_y+obsx3_6.resized_height/4-player.getY()) <Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((obsx3_7.position_x+obsx3_7.resized_width/4-player.getX())*(obsx3_7.position_x+obsx3_7.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obsx3_7.position_y+obsx3_7.resized_height/4-player.getY())*(obsx3_7.position_y+obsx3_7.resized_height/4-player.getY()) < Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////////
        if((obs1.position_x+obs1.resized_width/4-player.getX())*(obs1.position_x+obs1.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obs1.position_y+obs1.resized_height/4-player.getY())*(obs1.position_y+obs1.resized_height/4-player.getY()) <Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((obs_1_1.position_x+obs_1_1.resized_width/4-player.getX())*(obs_1_1.position_x+obs_1_1.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obs_1_1.position_y+obs_1_1.resized_height/4-player.getY())*(obs_1_1.position_y+obs_1_1.resized_height/4-player.getY()) < Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((obs_2_1.position_x+obs_2_1.resized_width/4-player.getX())*(obs_2_1.position_x+obs_2_1.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obs_2_1.position_y+obs_2_1.resized_height/4-player.getY())*(obs_2_1.position_y+obs_2_1.resized_height/4-player.getY()) < Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((obs_3_1.position_x+obs_3_1.resized_width/4-player.getX())*(obs_3_1.position_x+obs_3_1.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obs_3_1.position_y+obs_3_1.resized_height/4-player.getY())*(obs_3_1.position_y+obs_3_1.resized_height/4-player.getY()) < Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((obs_4_1.position_x+obs_4_1.resized_width/4-player.getX())*(obs_4_1.position_x+obs_4_1.resized_width/4-player.getX()) <Judge_width*Judge_width)
        {
            if((obs_4_1.position_y+obs_4_1.resized_height/4-player.getY())*(obs_4_1.position_y+obs_4_1.resized_height/4-player.getY()) < Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((obs_5_1.position_x+obs_5_1.resized_width/4-player.getX())*(obs_5_1.position_x+obs_5_1.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obs_5_1.position_y+obs_5_1.resized_height/4-player.getY())*(obs_5_1.position_y+obs_5_1.resized_height/4-player.getY()) < Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((obs_6_1.position_x+obs_6_1.resized_width/4-player.getX())*(obs_6_1.position_x+obs_6_1.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obs_6_1.position_y+obs_6_1.resized_height/4-player.getY())*(obs_6_1.position_y+obs_6_1.resized_height/4-player.getY()) < Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((obs_7_1.position_x+obs_7_1.resized_width/4-player.getX())*(obs_7_1.position_x+obs_7_1.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obs_7_1.position_y+obs_7_1.resized_height/4-player.getY())*(obs_7_1.position_y+obs_7_1.resized_height/4-player.getY()) <Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        if((obs1x2.position_x+obs1x2.resized_width/4-player.getX())*(obs1x2.position_x+obs1x2.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obs1x2.position_y+obs1x2.resized_height/4-player.getY())*(obs1x2.position_y+obs1x2.resized_height/4-player.getY()) < Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((obsx2_1_1.position_x+obsx2_1_1.resized_width/4-player.getX())*(obsx2_1_1.position_x+obsx2_1_1.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obsx2_1_1.position_y+obsx2_1_1.resized_height/4-player.getY())*(obsx2_1_1.position_y+obsx2_1_1.resized_height/4-player.getY()) < Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((obsx2_2_1.position_x+obsx2_2_1.resized_width/4-player.getX())*(obsx2_2_1.position_x+obsx2_2_1.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obsx2_2_1.position_y+obsx2_2_1.resized_height/4-player.getY())*(obsx2_2_1.position_y+obsx2_2_1.resized_height/4-player.getY()) < Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((obsx2_3_1.position_x+obsx2_3_1.resized_width/4-player.getX())*(obsx2_3_1.position_x+obsx2_3_1.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obsx2_3_1.position_y+obsx2_3_1.resized_height/4-player.getY())*(obsx2_3_1.position_y+obsx2_3_1.resized_height/4-player.getY()) < Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((obsx2_4_1.position_x+obsx2_4_1.resized_width/4-player.getX())*(obsx2_4_1.position_x+obsx2_4_1.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obsx2_4_1.position_y+obsx2_4_1.resized_height/4-player.getY())*(obsx2_4_1.position_y+obsx2_4_1.resized_height/4-player.getY()) < Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((obsx2_5_1.position_x+obsx2_5_1.resized_width/4-player.getX())*(obsx2_5_1.position_x+obsx2_5_1.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obsx2_5_1.position_y+obsx2_5_1.resized_height/4-player.getY())*(obsx2_5_1.position_y+obsx2_5_1.resized_height/4-player.getY()) < Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((obsx2_6_1.position_x+obsx2_6_1.resized_width/4-player.getX())*(obsx2_6_1.position_x+obsx2_6_1.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obsx2_6_1.position_y+obsx2_6_1.resized_height/4-player.getY())*(obsx2_6_1.position_y+obsx2_6_1.resized_height/4-player.getY()) < Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((obsx2_7_1.position_x+obsx2_7_1.resized_width/4-player.getX())*(obsx2_7_1.position_x+obsx2_7_1.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obsx2_7_1.position_y+obsx2_7_1.resized_height/4-player.getY())*(obsx2_7_1.position_y+obsx2_7_1.resized_height/4-player.getY()) < Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if((obs1x3.position_x+obs1x3.resized_width/4-player.getX())*(obs1x3.position_x+obs1x3.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obs1x3.position_y+obs1x3.resized_height/4-player.getY())*(obs1x3.position_y+obs1x3.resized_height/4-player.getY()) < Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((obsx3_1_1.position_x+obsx3_1_1.resized_width/4-player.getX())*(obsx3_1_1.position_x+obsx3_1_1.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obsx3_1_1.position_y+obsx3_1_1.resized_height/4-player.getY())*(obsx3_1_1.position_y+obsx3_1_1.resized_height/4-player.getY()) < Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((obsx3_2_1.position_x+obsx3_2_1.resized_width/4-player.getX())*(obsx3_2_1.position_x+obsx3_2_1.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obsx3_2_1.position_y+obsx3_2_1.resized_height/4-player.getY())*(obsx3_2_1.position_y+obsx3_2_1.resized_height/4-player.getY()) <Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((obsx3_3_1.position_x+obsx3_3_1.resized_width/4-player.getX())*(obsx3_3_1.position_x+obsx3_3_1.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obsx3_3_1.position_y+obsx3_3_1.resized_height/4-player.getY())*(obsx3_3_1.position_y+obsx3_3_1.resized_height/4-player.getY()) < Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((obsx3_4_1.position_x+obsx3_4_1.resized_width/4-player.getX())*(obsx3_4_1.position_x+obsx3_4_1.resized_width/4-player.getX()) <Judge_width*Judge_width)
        {
            if((obsx3_4_1.position_y+obsx3_4_1.resized_height/4-player.getY())*(obsx3_4_1.position_y+obsx3_4_1.resized_height/4-+obsx3_4_1.resized_height/4-player.getY()) < Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((obsx3_5_1.position_x+obsx3_5_1.resized_width/4-player.getX())*(obsx3_5_1.position_x+obsx3_5_1.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obsx3_5_1.position_y+obsx3_5_1.resized_height/4-player.getY())*(obsx3_5_1.position_y+obsx3_5_1.resized_height/4-player.getY()) < Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((obsx3_6_1.position_x+obsx3_6_1.resized_width/4-player.getX())*(obsx3_6_1.position_x+obsx3_6_1.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obsx3_6_1.position_y+obsx3_6_1.resized_height/4-player.getY())*(obsx3_6_1.position_y+obsx3_6_1.resized_height/4-player.getY()) < Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }

        if((obsx3_7_1.position_x+obsx3_7_1.resized_width/4-player.getX())*(obsx3_7_1.position_x+obsx3_7_1.resized_width/4-player.getX()) < Judge_width*Judge_width)
        {
            if((obsx3_7_1.position_y+obsx3_7_1.resized_height/4-player.getY())*(obsx3_7_1.position_y+obsx3_7_1.resized_height/4-player.getY()) < Judge_width*Judge_width)
            {
                //heart1.setVisibility(heart1.INVISIBLE);
                return true;
            }
        }
        return false;
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

    public void obstacle_moving(int x, int y, int z)
    {
        if(total_time_number >= 0 && health_number < 3) {
            if(pattern[0] == 1) {
                if (obs.position_x >= 280*size_dm) {
                    obs.position(120*size_dm, 125*size_dm);
                    //    obs.resized_image(30*size_dm, 30*size_dm);
                    obs.setObstacleAlpha(200);
                } else {
                    obs.setPosition(x, y);
                }
            }

            if(pattern[1] == 1) {
                if (obs_1.position_x >= 267*size_dm) {
                    obs_1.position(107*size_dm, 138*size_dm);
                    //    obs_1.resized_image(30*size_dm, 30*size_dm);
                    obs_1.setObstacleAlpha(200);
                } else {
                    obs_1.setPosition(x, y);
                }
            }

            if(pattern[2] == 1) {
                if (obs_2.position_x >= 254*size_dm) {
                    obs_2.position(94*size_dm, 151*size_dm);
                    //    obs_2.resized_image(30*size_dm, 30*size_dm);
                    obs_2.setObstacleAlpha(200);
                } else {
                    obs_2.setPosition(x, y);
                }
            }

            if(pattern[3] == 1) {
                if (obs_3.position_x >= 241*size_dm) {
                    obs_3.position(81*size_dm, 164*size_dm);
                    //    obs_3.resized_image(30*size_dm, 30*size_dm);
                    obs_3.setObstacleAlpha(200);
                } else {
                    obs_3.setPosition(x, y);
                }
            }

            if(pattern[4] == 1) {
                if (obs_4.position_x >= 228*size_dm) {
                    obs_4.position(68*size_dm, 177*size_dm);
                    //    obs_4.resized_image(30*size_dm, 30*size_dm);
                    obs_4.setObstacleAlpha(200);
                } else {
                    obs_4.setPosition(x, y);
                }
            }

            if(pattern[5] == 1) {
                if (obs_5.position_x >= 215*size_dm) {
                    obs_5.position(55*size_dm, 190*size_dm);
                    //    obs_5.resized_image(30*size_dm, 30*size_dm);
                    obs_5.setObstacleAlpha(200);
                } else {
                    obs_5.setPosition(x, y);
                }
            }

            if(pattern[6] == 1) {
                if (obs_6.position_x >= 202*size_dm) {
                    obs_6.position(42*size_dm, 203*size_dm);
                    //    obs_6.resized_image(30*size_dm, 30*size_dm);
                    obs_6.setObstacleAlpha(200);
                } else {
                    obs_6.setPosition(x, y);
                }
            }

            if(pattern[7] == 1) {
                if (obs_7.position_x >= 189*size_dm) {
                    obs_7.position(29*size_dm, 216*size_dm);
                    //    obs_7.resized_image(30*size_dm, 30*size_dm);
                    obs_7.setObstacleAlpha(200);
                } else {
                    obs_7.setPosition(x, y);
                }
            }
/////////////////////////////////////////////////////////////////

            if(pattern[8] == 1) {
                if (obsx2.position_x >=  280*size_dm) {
                    obsx2.position(120*size_dm, 125*size_dm);
                    //   obsx2.resized_image(30*size_dm, 30*size_dm);
                    obsx2.setObstacleAlpha(200);
                } else {
                    obsx2.setPosition(x, y);
                }
            }

            if(pattern[9] == 1) {
                if (obsx2_1.position_x >=  267*size_dm) {
                    obsx2_1.position(107*size_dm, 138*size_dm);
                    //   obsx2_1.resized_image(30*size_dm, 30*size_dm);
                    obsx2_1.setObstacleAlpha(200);
                } else {
                    obsx2_1.setPosition(x, y);
                }
            }

            if(pattern[10] == 1) {
                if (obsx2_2.position_x >= 254*size_dm) {
                    obsx2_2.position(94*size_dm, 151*size_dm);
                    //    obsx2_2.resized_image(30*size_dm, 30*size_dm);
                    obsx2_2.setObstacleAlpha(200);
                } else {
                    obsx2_2.setPosition(x, y);
                }
            }

            if(pattern[11] == 1) {
                if (obsx2_3.position_x >=  241*size_dm) {
                    obsx2_3.position(81*size_dm, 164*size_dm);
                    //   obsx2_3.resized_image(30*size_dm, 30*size_dm);
                    obsx2_3.setObstacleAlpha(200);
                } else {
                    obsx2_3.setPosition(x, y);
                }
            }

            if(pattern[12] == 1) {
                if (obsx2_4.position_x >=228*size_dm) {
                    obsx2_4.position(68*size_dm, 177*size_dm);
                    //   obsx2_4.resized_image(30*size_dm, 30*size_dm);
                    obsx2_4.setObstacleAlpha(200);
                } else {
                    obsx2_4.setPosition(x, y);
                }
            }

            if(pattern[13] == 1) {
                if (obsx2_5.position_x >= 215*size_dm) {
                    obsx2_5.position(55*size_dm, 190*size_dm);
                    //    obsx2_5.resized_image(30*size_dm, 30*size_dm);
                    obsx2_5.setObstacleAlpha(200);
                } else {
                    obsx2_5.setPosition(x, y);
                }
            }

            if(pattern[14] == 1) {
                if (obsx2_6.position_x >=202*size_dm) {
                    obsx2_6.position(42*size_dm, 203*size_dm);
                    //   obsx2_6.resized_image(30*size_dm, 30*size_dm);
                    obsx2_6.setObstacleAlpha(200);
                } else {
                    obsx2_6.setPosition(x, y);
                }
            }

            if(pattern[15] == 1) {
                if (obsx2_7.position_x >=189*size_dm) {
                    obsx2_7.position(29*size_dm, 216*size_dm);
                    //    obsx2_7.resized_image(30*size_dm, 30*size_dm);
                    obsx2_7.setObstacleAlpha(200);
                } else {
                    obsx2_7.setPosition(x, y);
                }
            }

            /////////////////////////////////////////////////////////////
            if(pattern[16] == 1) {
                if (obsx3.position_x >= 280*size_dm) {
                    obsx3.position(120*size_dm, 125*size_dm);
                    //   obsx3.resized_image(30*size_dm, 30*size_dm);
                    obsx3.setObstacleAlpha(200);
                } else {
                    obsx3.setPosition(x, y);
                }
            }

            if(pattern[17] == 1) {
                if (obsx3_1.position_x >= 267*size_dm) {
                    obsx3_1.position(107*size_dm, 138*size_dm);
                    //  obsx3_1.resized_image(30*size_dm, 30*size_dm);
                    obsx3_1.setObstacleAlpha(200);
                } else {
                    obsx3_1.setPosition(x, y);
                }
            }

            if(pattern[18] == 1) {
                if (obsx3_2.position_x >= 254*size_dm) {
                    obsx3_2.position(94*size_dm, 151*size_dm);
                    //   obsx3_2.resized_image(30*size_dm, 30*size_dm);
                    obsx3_2.setObstacleAlpha(200);
                } else {
                    obsx3_2.setPosition(x, y);
                }
            }

            if(pattern[19] == 1) {
                if (obsx3_3.position_x >=241*size_dm) {
                    obsx3_3.position(81*size_dm, 164*size_dm);
                    //   obsx3_3.resized_image(30*size_dm, 30*size_dm);
                    obsx3_3.setObstacleAlpha(200);
                } else {
                    obsx3_3.setPosition(x, y);
                }
            }

            if(pattern[20] == 1) {
                if (obsx3_4.position_x >= 228*size_dm) {
                    obsx3_4.position(68*size_dm, 177*size_dm);
                    //   obsx3_4.resized_image(30*size_dm, 30*size_dm);
                    obsx3_4.setObstacleAlpha(200);
                } else {
                    obsx3_4.setPosition(x, y);
                }
            }

            if(pattern[21] == 1) {
                if (obsx3_5.position_x >= 215*size_dm) {
                    obsx3_5.position(55*size_dm, 190*size_dm);
                    //   obsx3_5.resized_image(30*size_dm, 30*size_dm);
                    obsx3_5.setObstacleAlpha(200);
                } else {
                    obsx3_5.setPosition(x, y);
                }
            }

            if(pattern[22] == 1) {
                if (obsx3_6.position_x >= 202*size_dm) {
                    obsx3_6.position(42*size_dm, 203*size_dm);
                    //     obsx3_6.resized_image(30*size_dm, 30*size_dm);
                    obsx3_6.setObstacleAlpha(200);
                } else {
                    obsx3_6.setPosition(x, y);
                }
            }

            if(pattern[23] == 1) {
                if (obsx3_7.position_x >=  189*size_dm) {
                    obsx3_7.position(29*size_dm, 216*size_dm);
                    //    obsx3_7.resized_image(30*size_dm, 30*size_dm);
                    obsx3_7.setObstacleAlpha(200);
                } else {
                    obsx3_7.setPosition(x, y);
                }
            }
            ///////////////////
        }
    }

    public void obstacle_2_moving(int x, int y, int z) {
        if (total_time_number >= 0 && health_number < 3) {
            if (pattern[24] == 1) {
                if (obs1.position_x <= 29 * size_dm) {
                    obs1.position(189*size_dm, 125*size_dm);
                    //   obs1.resized_image(30 * size_dm, 30 * size_dm);
                    obs1.setObstacleAlpha(200);
                } else {
                    obs1.setPosition(x, y);
                }
            }

            if (pattern[25] == 1) {
                if (obs_1_1.position_x <= 42 * size_dm) {
                    obs_1_1.position(202*size_dm, 138*size_dm);
                    //    obs_1_1.resized_image(30 * size_dm, 30 * size_dm);
                    obs_1_1.setObstacleAlpha(200);
                } else {
                    obs_1_1.setPosition(x, y);
                }
            }

            if (pattern[26] == 1) {
                if (obs_2_1.position_x <= 55 * size_dm) {
                    obs_2_1.position(215*size_dm, 151*size_dm);
                    //   obs_2_1.resized_image(30 * size_dm, 30 * size_dm);
                    obs_2_1.setObstacleAlpha(200);
                } else {
                    obs_2_1.setPosition(x, y);
                }
            }

            if (pattern[27] == 1) {
                if (obs_3_1.position_x <= 68 * size_dm) {
                    obs_3_1.position(228*size_dm, 164*size_dm);
                    //  obs_3_1.resized_image(30 * size_dm, 30 * size_dm);
                    obs_3_1.setObstacleAlpha(200);
                } else {
                    obs_3_1.setPosition(x, y);
                }
            }

            if (pattern[28] == 1) {
                if (obs_4_1.position_x <= 81 * size_dm) {
                    obs_4_1.position(241*size_dm, 177*size_dm);
                    //   obs_4_1.resized_image(30 * size_dm, 30 * size_dm);
                    obs_4_1.setObstacleAlpha(200);
                } else {
                    obs_4_1.setPosition(x, y);
                }
            }

            if (pattern[29] == 1) {
                if (obs_5_1.position_x <= 94 * size_dm) {
                    obs_5_1.position(254*size_dm, 190*size_dm);
                    //  obs_5_1.resized_image(30 * size_dm, 30 * size_dm);
                    obs_5_1.setObstacleAlpha(200);
                } else {
                    obs_5_1.setPosition(x, y);
                }
            }

            if (pattern[30] == 1) {
                if (obs_6_1.position_x <= 107 * size_dm) {
                    obs_6_1.position(267*size_dm, 203*size_dm);
                    obs_6_1.resized_image(30 * size_dm, 30 * size_dm);
                    obs_6_1.setObstacleAlpha(200);
                } else {
                    obs_6_1.setPosition(x, y);
                }
            }

            if (pattern[31] == 1) {
                if (obs_7_1.position_x <= 120 * size_dm) {
                    obs_7_1.position(280*size_dm, 216*size_dm);
                    //   obs_7_1.resized_image(30 * size_dm, 30 * size_dm);
                    obs_7_1.setObstacleAlpha(200);
                } else {
                    obs_7_1.setPosition(x, y);
                }
            }
            ////////////////////////////////////////////////////////////

            if (pattern[32] == 1) {
                if (obs1x2.position_x <= 29 * size_dm) {
                    obs1x2.position(189*size_dm, 125*size_dm);
                    //   obs1x2.resized_image(30 * size_dm, 30 * size_dm);
                    obs1x2.setObstacleAlpha(200);
                } else {
                    obs1x2.setPosition(x, y);
                }
            }

            if (pattern[33] == 1) {
                if (obsx2_1_1.position_x <= 42 * size_dm) {
                    obsx2_1_1.position(202*size_dm, 138*size_dm);
                    //     obsx2_1_1.resized_image(30 * size_dm, 30 * size_dm);
                    obsx2_1_1.setObstacleAlpha(200);
                } else {
                    obsx2_1_1.setPosition(x, y);
                }
            }

            if (pattern[34] == 1) {
                if (obsx2_2_1.position_x <= 55 * size_dm) {
                    obsx2_2_1.position(215*size_dm, 151*size_dm);
                    //     obsx2_2_1.resized_image(30 * size_dm, 30 * size_dm);
                    obsx2_2_1.setObstacleAlpha(200);
                } else {
                    obsx2_2_1.setPosition(x, y);
                }
            }

            if (pattern[35] == 1) {
                if (obsx2_3_1.position_x <= 68 * size_dm) {
                    obsx2_3_1.position(228*size_dm, 164*size_dm);
                    //  obsx2_3_1.resized_image(30 * size_dm, 30 * size_dm);
                    obsx2_3_1.setObstacleAlpha(200);
                } else {
                    obsx2_3_1.setPosition(x, y);
                }
            }

            if (pattern[36] == 1) {
                if (obsx2_4_1.position_x <= 81 * size_dm) {
                    obsx2_4_1.position(241*size_dm, 177*size_dm);
                    //    obsx2_4_1.resized_image(30 * size_dm, 30 * size_dm);
                    obsx2_4_1.setObstacleAlpha(200);
                } else {
                    obsx2_4_1.setPosition(x, y);
                }
            }

            if (pattern[37] == 1) {
                if (obsx2_5_1.position_x <= 94 * size_dm) {
                    obsx2_5_1.position(254*size_dm, 190*size_dm);
                    //    obsx2_5_1.resized_image(30 * size_dm, 30 * size_dm);
                    obsx2_5_1.setObstacleAlpha(200);
                } else {
                    obsx2_5_1.setPosition(x, y);
                }
            }

            if (pattern[38] == 1) {
                if (obsx2_6_1.position_x <= 107 * size_dm) {
                    obsx2_6_1.position(267*size_dm, 203*size_dm);
                    obsx2_6_1.resized_image(30 * size_dm, 30 * size_dm);
                    obsx2_6_1.setObstacleAlpha(200);
                } else {
                    obsx2_6_1.setPosition(x, y);
                }
            }

            if (pattern[39] == 1) {
                if (obsx2_7_1.position_x <= 120 * size_dm) {
                    obsx2_7_1.position(280*size_dm, 216*size_dm);
                    //  obsx2_7_1.resized_image(30 * size_dm, 30 * size_dm);
                    obsx2_7_1.setObstacleAlpha(200);
                } else {
                    obsx2_7_1.setPosition(x, y);
                }
            }
            ///////////////////////////////////////////////////////////////
            if (pattern[40] == 1) {
                if (obs1x3.position_x <= 29 * size_dm) {
                    obs1x3.position(189*size_dm, 125*size_dm);
                    //   obs1x3.resized_image(30 * size_dm, 30 * size_dm);
                    obs1x3.setObstacleAlpha(200);
                } else {
                    obs1x3.setPosition(x, y);
                }
            }

            if (pattern[41] == 1) {
                if (obsx3_1_1.position_x <= 42 * size_dm) {
                    obsx3_1_1.position(202*size_dm, 138*size_dm);
                    //   obsx3_1_1.resized_image(30 * size_dm, 30 * size_dm);
                    obsx3_1_1.setObstacleAlpha(200);
                } else {
                    obsx3_1_1.setPosition(x, y);
                }
            }

            if (pattern[42] == 1) {
                if (obsx3_2_1.position_x <= 55 * size_dm) {
                    obsx3_2_1.position(215*size_dm, 151*size_dm);
                    //  obsx3_2_1.resized_image(30 * size_dm, 30 * size_dm);
                    obsx3_2_1.setObstacleAlpha(200);
                } else {
                    obsx3_2_1.setPosition(x, y);
                }
            }

            if (pattern[43] == 1) {
                if (obsx3_3_1.position_x <= 68 * size_dm) {
                    obsx3_3_1.position(228*size_dm, 164*size_dm);
                    //   obsx3_3_1.resized_image(30 * size_dm, 30 * size_dm);
                    obsx3_3_1.setObstacleAlpha(200);
                } else {
                    obsx3_3_1.setPosition(x, y);
                }
            }

            if (pattern[44] == 1) {
                if (obsx3_4_1.position_x <= 81 * size_dm) {
                    obsx3_4_1.position(241*size_dm, 177*size_dm);
                    //   obsx3_4_1.resized_image(30 * size_dm, 30 * size_dm);
                    obsx3_4_1.setObstacleAlpha(200);
                } else {
                    obsx3_4_1.setPosition(x, y);
                }
            }

            if (pattern[45] == 1) {
                if (obsx3_5_1.position_x <= 94 * size_dm) {
                    obsx3_5_1.position(254*size_dm, 190*size_dm);
                    // obsx3_5_1.resized_image(30 * size_dm, 30 * size_dm);
                    obsx3_5_1.setObstacleAlpha(200);
                } else {
                    obsx3_5_1.setPosition(x, y);
                }
            }

            if (pattern[46] == 1) {
                if (obsx3_6_1.position_x <= 107 * size_dm) {
                    obsx3_6_1.position(267*size_dm, 203*size_dm);
                    //  obsx3_6_1.resized_image(30 * size_dm, 30 * size_dm);
                    obsx3_6_1.setObstacleAlpha(200);
                } else {
                    obsx3_6_1.setPosition(x, y);
                }
            }

            if (pattern[47] == 1) {
                if (obsx3_7_1.position_x <= 120 * size_dm) {
                    obsx3_7_1.position(280*size_dm, 216*size_dm);
                    // obsx3_7_1.resized_image(30 * size_dm, 30 * size_dm);
                    obsx3_7_1.setObstacleAlpha(200);
                } else {
                    obsx3_7_1.setPosition(x, y);
                }
            }
        }
    }

    public void obstacle_3_moving(int x, int y, int z)
    {
        /*
        if(total_time_number >= 0 && health_number < 3) {
            if (obs2.position_y >= 350) {
                obs2.position(316, 100);
            } else {
                obs2.setPosition(x, y);
            }

            if (obs2_1.position_y >= 370) {
                obs2_1.position(290, 100);
            } else {
                obs2_1.setPosition(x, y);
            }
        }
        */
    }


    public void player_moving(int x, int y, boolean button_down) {

        if (button_down == true) {

            //mapping 범위 안에 player를 움직이기 위해서 기울기의 특성을 이용해 지정해준다.
            if((player.getX() + player.getY()) > (tile_end_x1+tile_end_y1+20) && (player.getX() + player.getY()) < (tile_end_x4+tile_end_y4+30)) {

                if(player.getX() > tile_end_x2 && player.getY() < tile_end_y4 ) {

                    if(player.getY() >= tile_end_y3) {
                        if ((player.getY() - tile_end_y2) / (player.getX() - tile_end_x2) < ((tile_end_y4 - tile_end_y2) / (tile_end_x4 - tile_end_x2))) {

                            prior_player_x = Math.round(player.getX());
                            prior_player_y = Math.round(player.getY());

                            player.setX(player.getX() + x);
                            player.setY(player.getY() + y);

                        } else {

                            player.setX(prior_player_x);
                            player.setY(prior_player_y);


                        }
                    }
                    else
                    {

                        if(player.getX() > tile_end_x1)
                        {
                            if ((player.getY()-tile_end_y1) / (player.getX()-tile_end_x1) > ((tile_end_y3 - tile_end_y1) / (tile_end_x3 - tile_end_x1))) {
                                prior_player_x = Math.round(player.getX());
                                prior_player_y = Math.round(player.getY());

                                player.setX(player.getX() + x);
                                player.setY(player.getY() + y);


                            }
                            else {

                                player.setX(prior_player_x);
                                player.setY(prior_player_y);

                            }
                        }
                        else {

                            prior_player_x = Math.round(player.getX());
                            prior_player_y = Math.round(player.getY());


                            player.setX(player.getX() + x);
                            player.setY(player.getY() + y);

                        }
                    }
                }
                else
                {
                    player.setX(prior_player_x);
                    player.setY(prior_player_y);


                }

            }
            else {

                player.setX(prior_player_x);
                player.setY(prior_player_y);

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

        obs.empty(); obs_1.empty();  obs_2.empty(); obs_3.empty(); obs_4.empty(); obs_5.empty(); obs_6.empty(); obs_7.empty();
        obsx2.empty(); obsx2_1.empty();  obsx2_2.empty(); obsx2_3.empty(); obsx2_4.empty(); obsx2_5.empty(); obsx2_6.empty(); obsx2_7.empty();
        obsx3.empty(); obsx3_1.empty();  obsx3_2.empty(); obsx3_3.empty(); obsx3_4.empty(); obsx3_5.empty(); obsx3_6.empty(); obsx3_7.empty();

        obs1.empty(); obs_1_1.empty();  obs_2_1.empty(); obs_3_1.empty(); obs_4_1.empty(); obs_5_1.empty(); obs_6_1.empty(); obs_7_1.empty();
        obs1x2.empty(); obsx2_1_1.empty();  obsx2_2_1.empty(); obsx2_3_1.empty(); obsx2_4_1.empty(); obsx2_5_1.empty(); obsx2_6_1.empty(); obsx2_7_1.empty();
        obs1x3.empty(); obsx3_1_1.empty();  obsx3_2_1.empty(); obsx3_3_1.empty(); obsx3_4_1.empty(); obsx3_5_1.empty(); obsx3_6_1.empty(); obsx3_7_1.empty();
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
