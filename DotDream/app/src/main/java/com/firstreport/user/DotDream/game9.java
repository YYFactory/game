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
 * Created by user on 2017-07-11.
 */

public class game9 extends AppCompatActivity {

    private int tile_end_x1, tile_end_y1;
    private int tile_end_x2, tile_end_y2;
    private int tile_end_x3, tile_end_y3;
    private int tile_end_x4, tile_end_y4;
    private int prior_player_x, prior_player_y;
    private int SpeedX, SpeedY;
    private int timing_number = 0, total_time_number = 50, health_timing_number = 0, level_time_number = 0;
    private int pattern_number = 0, health_number = 0, pattern2_number = 0, enemy_health_time_number = 0;
    private int bullet_number = 0, bullet_number_count = 0;
    private int Obstacle_Part1_SpeedX = 1, Obstacle_Part1_SpeedY = 1;
    private int Obstacle_Part2_SpeedX = 1, Obstacle_Part2_SpeedY = -1;
    private int Obstacle_1_Part1_SpeedX = -1, Obstacle_1_Part1_SpeedY = 1;
    private int Obstacle_1_Part2_SpeedX = -1, Obstacle_1_Part2_SpeedY = -1;
    private int blackhall_action_time = 0;
    private int bullet[] = {0, 0, 0, 0, 0};
    private int frameHeight;
    private int score_total;
    private int size_dm;
    private int bullet_SpeedX[] = {0, 0, 0, 0, 0}, bullet_SpeedY[] = {0, 0, 0, 0, 0}, bullet_initialX[] = {0, 0, 0, 0, 0}, bullet_initialY[] = {0, 0, 0, 0, 0};
    private int pattern[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0};

    private int enemy_bullet1_SpeedX, enemy_bullet1_SpeedY, enemy_bullet2_SpeedX, enemy_bullet2_SpeedY, enemy_bullet3_SpeedX, enemy_bullet3_SpeedY,
            enemy_bullet4_SpeedX, enemy_bullet4_SpeedY, enemy_bullet5_SpeedX, enemy_bullet5_SpeedY, enemy_bullet6_SpeedX, enemy_bullet6_SpeedY,
            enemy_bullet7_SpeedX, enemy_bullet7_SpeedY, enemy_bullet8_SpeedX, enemy_bullet8_SpeedY, enemy_bullet9_SpeedX, enemy_bullet9_SpeedY,
            enemy_bullet10_SpeedX, enemy_bullet10_SpeedY, enemy_bullet11_SpeedX, enemy_bullet11_SpeedY, enemy_bullet12_SpeedX, enemy_bullet12_SpeedY,
            enemy_bullet13_SpeedX, enemy_bullet13_SpeedY, enemy_bullet14_SpeedX, enemy_bullet14_SpeedY, enemy_bullet15_SpeedX, enemy_bullet15_SpeedY,
            enemy_bullet16_SpeedX, enemy_bullet16_SpeedY;


    private int enemy1[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0};

    private int enemy_last_attack_SpeedX[] = {-2, -1, 0, 1, 2};
    private int enemy_last_attack_SpeedY[] = {2, 1, 0, -1, -2};

    private int enemy_last_attack_Speed_X[] = {-2, -1, 1, 2};
    private int enemy_last_attack_Speed_Y[] = {2, 1, -1, -2};

    private int enemy1_cal[] = {0, 0};
    private int enemy_shot[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0};

    private int enemy_move_number[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0};

    private int resource_number[] = {R.id.tile1_1, R.id.tile1_2, R.id.tile1_3, R.id.tile1_4, R.id.tile1_5, R.id.tile1_6, R.id.tile1_7, R.id.tile1_8, R.id.tile1_9, R.id.tile1_10,
            R.id.tile1_11, R.id.tile1_12, R.id.tile1_13, R.id.tile1_14, R.id.tile1_15, R.id.tile1_16, R.id.tile1_17, R.id.tile1_18, R.id.tile1_19, R.id.tile1_20,
            R.id.tile1_21, R.id.tile1_22, R.id.tile1_23, R.id.tile1_24, R.id.tile1_25, R.id.tile1_26, R.id.tile1_27, R.id.tile1_28, R.id.tile1_29, R.id.tile1_30,
            R.id.tile1_31, R.id.tile1_32, R.id.tile2_1, R.id.tile2_2, R.id.tile2_3, R.id.tile2_4, R.id.tile2_5, R.id.tile2_6, R.id.tile2_7, R.id.tile2_8, R.id.tile2_9, R.id.tile2_10,
            R.id.tile2_11, R.id.tile2_12, R.id.tile2_13, R.id.tile2_14, R.id.tile2_15, R.id.tile2_16, R.id.tile2_17, R.id.tile2_18, R.id.tile2_19, R.id.tile2_20,
            R.id.tile2_21, R.id.tile2_22, R.id.tile2_23, R.id.tile2_24, R.id.tile2_25, R.id.tile2_26, R.id.tile2_27, R.id.tile2_28, R.id.tile2_29, R.id.tile2_30,
            R.id.tile2_31, R.id.tile2_32};

    private int player_bullet_damage, enemy_maximum_energy, enemy_maximum_energy2, enemy_maximum_energy3;
    private int action_flag1_count = 1, action_flag1_count2 = 1, action_flag1_count3 = 1;

    private int last_SpeedX[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0};

    private int last_SpeedY[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0};

    private boolean Isdamaged_player;
    private boolean Isdamaged_enemy;
    private boolean stun_player = false;
    private boolean stun_enemy = false;
    private boolean action_flg = false;
    private boolean start_flg = false;
    private boolean bullet_click = false;
    private boolean enemy_action_flag1 = false;
    private boolean enemy_action_flag2 = false;
    private boolean enemy_action_flag3 = false;
    private boolean initialize_enemy_attack2 = false;
    private boolean initialize_enemy_attack3 = false;
    private boolean initialize_enemy_attack4 = false;

    private TextView score, score_number, time, time_number, life;
    private Handler handler = new Handler();
    private Timer timer = new Timer();

    private RelativeLayout layout_joystick;
    private RelativeLayout gameview9;

    private ImageView tile1_1, tile1_2, tile1_3, tile1_4, tile1_5, tile1_6, tile1_7, tile1_8, tile1_9, tile1_10;
    private ImageView tile1_11, tile1_12, tile1_13, tile1_14, tile1_15, tile1_16, tile1_17, tile1_18, tile1_19, tile1_20;
    private ImageView tile1_21, tile1_22, tile1_23, tile1_24, tile1_25, tile1_26, tile1_27, tile1_28, tile1_29, tile1_30;
    private ImageView tile1_31, tile1_32;

    private ImageView tile[] = new ImageView[64];
    private ImageView heart1, heart2, heart3;
    private ImageView player;
    private ImageView enemy_center;

    private Button button2;

    ObstacleClass obstacle[] = new ObstacleClass[4];
    ObstacleClass obstaclex2[] = new ObstacleClass[4];
    ObstacleClass obstaclex3[] = new ObstacleClass[4];
    ObstacleClass obstaclex4[] = new ObstacleClass[4];

    ObstacleClass r_obstacle[] = new ObstacleClass[4];
    ObstacleClass r_obstaclex2[] = new ObstacleClass[4];
    ObstacleClass r_obstaclex3[] = new ObstacleClass[4];
    ObstacleClass r_obstaclex4[] = new ObstacleClass[4];

    ObstacleClass obstacle_1[] = new ObstacleClass[4];
    ObstacleClass obstaclex2_1[] = new ObstacleClass[4];
    ObstacleClass obstaclex3_1[] = new ObstacleClass[4];
    ObstacleClass obstaclex4_1[] = new ObstacleClass[4];

    ObstacleClass r_obstacle_1[] = new ObstacleClass[4];
    ObstacleClass r_obstaclex2_1[] = new ObstacleClass[4];
    ObstacleClass r_obstaclex3_1[] = new ObstacleClass[4];
    ObstacleClass r_obstaclex4_1[] = new ObstacleClass[4];

    ObstacleClass obstacle_2[] = new ObstacleClass[4];
    ObstacleClass obstaclex2_2[] = new ObstacleClass[4];
    ObstacleClass obstaclex3_2[] = new ObstacleClass[4];
    ObstacleClass obstaclex4_2[] = new ObstacleClass[4];

    ObstacleClass r_obstacle_2[] = new ObstacleClass[4];
    ObstacleClass r_obstaclex2_2[] = new ObstacleClass[4];
    ObstacleClass r_obstaclex3_2[] = new ObstacleClass[4];
    ObstacleClass r_obstaclex4_2[] = new ObstacleClass[4];

    ObstacleClass obstacle_3[] = new ObstacleClass[4];
    ObstacleClass obstaclex2_3[] = new ObstacleClass[4];
    ObstacleClass obstaclex3_3[] = new ObstacleClass[4];
    ObstacleClass obstaclex4_3[] = new ObstacleClass[4];

    ObstacleClass r_obstacle_3[] = new ObstacleClass[4];
    ObstacleClass r_obstaclex2_3[] = new ObstacleClass[4];
    ObstacleClass r_obstaclex3_3[] = new ObstacleClass[4];
    ObstacleClass r_obstaclex4_3[] = new ObstacleClass[4];

    ObstacleClass obstacle_4[] = new ObstacleClass[4];
    ObstacleClass obstaclex2_4[] = new ObstacleClass[4];
    ObstacleClass obstaclex3_4[] = new ObstacleClass[4];
    ObstacleClass obstaclex4_4[] = new ObstacleClass[4];

    ObstacleClass r_obstacle_4[] = new ObstacleClass[4];
    ObstacleClass r_obstaclex2_4[] = new ObstacleClass[4];
    ObstacleClass r_obstaclex3_4[] = new ObstacleClass[4];
    ObstacleClass r_obstaclex4_4[] = new ObstacleClass[4];

    ObstacleClass obstacle_5[] = new ObstacleClass[4];
    ObstacleClass obstaclex2_5[] = new ObstacleClass[4];
    ObstacleClass obstaclex3_5[] = new ObstacleClass[4];
    ObstacleClass obstaclex4_5[] = new ObstacleClass[4];

    ObstacleClass r_obstacle_5[] = new ObstacleClass[4];
    ObstacleClass r_obstaclex2_5[] = new ObstacleClass[4];
    ObstacleClass r_obstaclex3_5[] = new ObstacleClass[4];
    ObstacleClass r_obstaclex4_5[] = new ObstacleClass[4];

    ObstacleClass obstacle_6[] = new ObstacleClass[4];
    ObstacleClass obstaclex2_6[] = new ObstacleClass[4];
    ObstacleClass obstaclex3_6[] = new ObstacleClass[4];
    ObstacleClass obstaclex4_6[] = new ObstacleClass[4];

    ObstacleClass r_obstacle_6[] = new ObstacleClass[4];
    ObstacleClass r_obstaclex2_6[] = new ObstacleClass[4];
    ObstacleClass r_obstaclex3_6[] = new ObstacleClass[4];
    ObstacleClass r_obstaclex4_6[] = new ObstacleClass[4];

    ObstacleClass obstacle_7[] = new ObstacleClass[4];
    ObstacleClass obstaclex2_7[] = new ObstacleClass[4];
    ObstacleClass obstaclex3_7[] = new ObstacleClass[4];
    ObstacleClass obstaclex4_7[] = new ObstacleClass[4];

    ObstacleClass r_obstacle_7[] = new ObstacleClass[4];
    ObstacleClass r_obstaclex2_7[] = new ObstacleClass[4];
    ObstacleClass r_obstaclex3_7[] = new ObstacleClass[4];
    ObstacleClass r_obstaclex4_7[] = new ObstacleClass[4];

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

    ObstacleClass enemy_energybar, enemy_energybar2, enemy_energybar3, player_energybar;
    ObstacleClass player_bullet[] = new ObstacleClass[5];
    ObstacleClass enemy_bullet[] = new ObstacleClass[16];

    ObstacleClass effect[] = new ObstacleClass[64];

    JoyStickClass js;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameview9);

        DisplayMetrics dm = getResources().getDisplayMetrics();
        size_dm = Math.round(dm.density);

        score_number = (TextView) findViewById(R.id.score_number);
        time_number = (TextView) findViewById(R.id.time_number);

        WindowManager wm = getWindowManager();
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);

        layout_joystick = (RelativeLayout) findViewById(R.id.layout_joystick);
        gameview9 = (RelativeLayout) findViewById(R.id.gameview9);

        js = new JoyStickClass(getApplicationContext(), layout_joystick, R.drawable.center);
        js.setStickSize(30 * size_dm, 30 * size_dm);
        js.setLayoutSize(100 * size_dm, 100 * size_dm);
        js.setLayoutAlpha(50);
        js.setStickAlpha(50);
        js.setOffset(15 * size_dm);
        js.setMinimumDistance(1 * size_dm);

        js.initial_draw(50 * size_dm, 50 * size_dm);

        button2 = (Button) findViewById(R.id.button2);

        enemy_energybar = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.bullet);
        enemy_energybar.position(10 * size_dm, 50 * size_dm);
        enemy_energybar.resized_image(300 * size_dm, 10 * size_dm);
        enemy_energybar.setObstacleAlpha(220);

        enemy_energybar.position_effect();

        enemy_energybar2 = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.bullet);
        enemy_energybar2.position(10 * size_dm, 70 * size_dm);
        enemy_energybar2.resized_image(300 * size_dm, 10 * size_dm);
        enemy_energybar2.setObstacleAlpha(220);

        enemy_energybar2.position_effect();

        enemy_energybar3 = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.bullet);
        enemy_energybar3.position(10 * size_dm, 90 * size_dm);
        enemy_energybar3.resized_image(300 * size_dm, 10 * size_dm);
        enemy_energybar3.setObstacleAlpha(220);

        enemy_energybar3.position_effect();

        heart1 = (ImageView) findViewById(R.id.heart1);
        heart2 = (ImageView) findViewById(R.id.heart2);
        heart3 = (ImageView) findViewById(R.id.heart3);
        player = (ImageView) findViewById(R.id.player);
        enemy_center = (ImageView) findViewById(R.id.enemy_center);

        player_bullet_damage = size_dm;
        enemy_maximum_energy = 300 * size_dm;
        enemy_maximum_energy2 = 300 * size_dm;
        enemy_maximum_energy3 = 300 * size_dm;

        enemy_bullet[0] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy3);
        enemy_bullet[0].position(161 * size_dm, 247 * size_dm);
        enemy_bullet[0].resized_image(30 * size_dm, 30 * size_dm);
        enemy_bullet[0].setObstacleAlpha(0);

        enemy_bullet[1] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy3);
        enemy_bullet[1].position(161 * size_dm, 247 * size_dm);
        enemy_bullet[1].resized_image(30 * size_dm, 30 * size_dm);
        enemy_bullet[1].setObstacleAlpha(0);

        enemy_bullet[2] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy3);
        enemy_bullet[2].position(161 * size_dm, 247 * size_dm);
        enemy_bullet[2].resized_image(30 * size_dm, 30 * size_dm);
        enemy_bullet[2].setObstacleAlpha(0);

        enemy_bullet[3] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy3);
        enemy_bullet[3].position(161 * size_dm, 247 * size_dm);
        enemy_bullet[3].resized_image(30 * size_dm, 30 * size_dm);
        enemy_bullet[3].setObstacleAlpha(0);

        enemy_bullet[4] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy3);
        enemy_bullet[4].position(161 * size_dm, 247 * size_dm);
        enemy_bullet[4].resized_image(30 * size_dm, 30 * size_dm);
        enemy_bullet[4].setObstacleAlpha(0);

        enemy_bullet[5] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy3);
        enemy_bullet[5].position(161 * size_dm, 247 * size_dm);
        enemy_bullet[5].resized_image(30 * size_dm, 30 * size_dm);
        enemy_bullet[5].setObstacleAlpha(0);

        enemy_bullet[6] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy3);
        enemy_bullet[6].position(161 * size_dm, 247 * size_dm);
        enemy_bullet[6].resized_image(30 * size_dm, 30 * size_dm);
        enemy_bullet[6].setObstacleAlpha(0);

        enemy_bullet[7] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy3);
        enemy_bullet[7].position(161 * size_dm, 247 * size_dm);
        enemy_bullet[7].resized_image(30 * size_dm, 30 * size_dm);
        enemy_bullet[7].setObstacleAlpha(0);

        enemy_bullet[8] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy3);
        enemy_bullet[8].position(161 * size_dm, 247 * size_dm);
        enemy_bullet[8].resized_image(30 * size_dm, 30 * size_dm);
        enemy_bullet[8].setObstacleAlpha(0);

        enemy_bullet[9] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy3);
        enemy_bullet[9].position(161 * size_dm, 247 * size_dm);
        enemy_bullet[9].resized_image(30 * size_dm, 30 * size_dm);
        enemy_bullet[9].setObstacleAlpha(0);

        enemy_bullet[10] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy3);
        enemy_bullet[10].position(161 * size_dm, 247 * size_dm);
        enemy_bullet[10].resized_image(30 * size_dm, 30 * size_dm);
        enemy_bullet[10].setObstacleAlpha(0);

        enemy_bullet[11] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy3);
        enemy_bullet[11].position(161 * size_dm, 247 * size_dm);
        enemy_bullet[11].resized_image(30 * size_dm, 30 * size_dm);
        enemy_bullet[11].setObstacleAlpha(0);

        enemy_bullet[12] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy3);
        enemy_bullet[12].position(161 * size_dm, 247 * size_dm);
        enemy_bullet[12].resized_image(30 * size_dm, 30 * size_dm);
        enemy_bullet[12].setObstacleAlpha(0);

        enemy_bullet[13] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy3);
        enemy_bullet[13].position(161 * size_dm, 247 * size_dm);
        enemy_bullet[13].resized_image(30 * size_dm, 30 * size_dm);
        enemy_bullet[13].setObstacleAlpha(0);

        enemy_bullet[14] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy3);
        enemy_bullet[14].position(161 * size_dm, 247 * size_dm);
        enemy_bullet[14].resized_image(30 * size_dm, 30 * size_dm);
        enemy_bullet[14].setObstacleAlpha(0);

        enemy_bullet[15] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy3);
        enemy_bullet[15].position(161 * size_dm, 247 * size_dm);
        enemy_bullet[15].resized_image(30 * size_dm, 30 * size_dm);
        enemy_bullet[15].setObstacleAlpha(0);

        player = (ImageView) findViewById(R.id.player);

        for (int i = 0; i < 5; i++) {
            player_bullet[i] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.bullet);
            player_bullet[i].position(1 * size_dm, 1 * size_dm);
            player_bullet[i].resized_image(30 * size_dm, 30 * size_dm);
            player_bullet[i].setObstacleAlpha(200);
        }

        for (int i = 0; i < 64; i++) {
            tile[i] = (ImageView) findViewById(resource_number[i]);
        }

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


        obstacle[0] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        obstacle[0].position(120 * size_dm, 125 * size_dm);
        obstacle[0].resized_image(30 * size_dm, 30 * size_dm);
        obstacle[0].setObstacleAlpha(220);

        effect[0] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[0].position(157 * size_dm, 168 * size_dm);
        effect[0].resized_image(30 * size_dm, 30 * size_dm);
        effect[0].setObstacleAlpha(220);

        obstacle[1] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        obstacle[1].position(120 * size_dm, 125 * size_dm);
        obstacle[1].resized_image(30 * size_dm, 30 * size_dm);
        obstacle[1].setObstacleAlpha(220);

        effect[1] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[1].position(170 * size_dm, 181 * size_dm);
        effect[1].resized_image(30 * size_dm, 30 * size_dm);
        effect[1].setObstacleAlpha(220);

        obstacle[2] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        obstacle[2].position(120 * size_dm, 125 * size_dm);
        obstacle[2].resized_image(30 * size_dm, 30 * size_dm);
        obstacle[2].setObstacleAlpha(220);

        effect[2] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[2].position(183 * size_dm, 194 * size_dm);
        effect[2].resized_image(30 * size_dm, 30 * size_dm);
        effect[2].setObstacleAlpha(220);

        obstacle[3] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        obstacle[3].position(120 * size_dm, 125 * size_dm);
        obstacle[3].resized_image(30 * size_dm, 30 * size_dm);
        obstacle[3].setObstacleAlpha(220);

        effect[3] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[3].position(195 * size_dm, 203 * size_dm);
        effect[3].resized_image(30 * size_dm, 30 * size_dm);
        effect[3].setObstacleAlpha(220);

        obstacle_1[0] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        obstacle_1[0].position(107 * size_dm, 138 * size_dm);
        obstacle_1[0].resized_image(30 * size_dm, 30 * size_dm);
        obstacle_1[0].setObstacleAlpha(220);

        effect[4] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[4].position(143 * size_dm, 177 * size_dm);
        effect[4].resized_image(30 * size_dm, 30 * size_dm);
        effect[4].setObstacleAlpha(220);

        obstacle_1[1] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        obstacle_1[1].position(107 * size_dm, 138 * size_dm);
        obstacle_1[1].resized_image(30 * size_dm, 30 * size_dm);
        obstacle_1[1].setObstacleAlpha(220);

        effect[5] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[5].position(156 * size_dm, 190 * size_dm);
        effect[5].resized_image(30 * size_dm, 30 * size_dm);
        effect[5].setObstacleAlpha(220);

        obstacle_1[2] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        obstacle_1[2].position(107 * size_dm, 138 * size_dm);
        obstacle_1[2].resized_image(30 * size_dm, 30 * size_dm);
        obstacle_1[2].setObstacleAlpha(220);

        effect[6] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[6].position(169 * size_dm, 203 * size_dm);
        effect[6].resized_image(30 * size_dm, 30 * size_dm);
        effect[6].setObstacleAlpha(220);

        obstacle_1[3] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        obstacle_1[3].position(107 * size_dm, 138 * size_dm);
        obstacle_1[3].resized_image(30 * size_dm, 30 * size_dm);
        obstacle_1[3].setObstacleAlpha(220);

        effect[7] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[7].position(182 * size_dm, 216 * size_dm);
        effect[7].resized_image(30 * size_dm, 30 * size_dm);
        effect[7].setObstacleAlpha(220);

        obstacle_2[0] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        obstacle_2[0].position(94 * size_dm, 151 * size_dm);
        obstacle_2[0].resized_image(30 * size_dm, 30 * size_dm);
        obstacle_2[0].setObstacleAlpha(220);

        effect[8] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[8].position(259, 377);
        effect[8].resized_image(30 * size_dm, 30 * size_dm);
        effect[8].setObstacleAlpha(220);

        obstacle_2[1] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        obstacle_2[1].position(94 * size_dm, 151 * size_dm);
        obstacle_2[1].resized_image(30 * size_dm, 30 * size_dm);
        obstacle_2[1].setObstacleAlpha(220);

        effect[9] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[9].position(289, 450);
        effect[9].resized_image(30 * size_dm, 30 * size_dm);
        effect[9].setObstacleAlpha(220);

        obstacle_2[2] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        obstacle_2[2].position(94 * size_dm, 151 * size_dm);
        obstacle_2[2].resized_image(30 * size_dm, 30 * size_dm);
        obstacle_2[2].setObstacleAlpha(220);

        effect[10] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[10].position(315, 430);
        effect[10].resized_image(30 * size_dm, 30 * size_dm);
        effect[10].setObstacleAlpha(220);

        obstacle_2[3] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        obstacle_2[3].position(94 * size_dm, 151 * size_dm);
        obstacle_2[3].resized_image(30 * size_dm, 30 * size_dm);
        obstacle_2[3].setObstacleAlpha(220);

        effect[11] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[11].position(341, 450);
        effect[11].resized_image(30 * size_dm, 30 * size_dm);
        effect[11].setObstacleAlpha(220);

        /////////////////////////////////////////////////////////////////////////////////////////////////

        obstacle_3[0] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        obstacle_3[0].position(81 * size_dm, 164 * size_dm);
        obstacle_3[0].resized_image(30 * size_dm, 30 * size_dm);
        obstacle_3[0].setObstacleAlpha(220);

        effect[12] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[12].position(235, 400);
        effect[12].resized_image(30 * size_dm, 30 * size_dm);
        effect[12].setObstacleAlpha(220);

        obstacle_3[1] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        obstacle_3[1].position(81 * size_dm, 164 * size_dm);
        obstacle_3[1].resized_image(30 * size_dm, 30 * size_dm);
        obstacle_3[1].setObstacleAlpha(220);

        effect[13] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[13].position(259, 430);
        effect[13].resized_image(30 * size_dm, 30 * size_dm);
        effect[13].setObstacleAlpha(220);

        obstacle_3[2] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        obstacle_3[2].position(81 * size_dm, 164 * size_dm);
        obstacle_3[2].resized_image(30 * size_dm, 30 * size_dm);
        obstacle_3[2].setObstacleAlpha(220);

        effect[14] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[14].position(289, 450);
        effect[14].resized_image(30 * size_dm, 30 * size_dm);
        effect[14].setObstacleAlpha(220);

        obstacle_3[3] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        obstacle_3[3].position(81 * size_dm, 164 * size_dm);
        obstacle_3[3].resized_image(30 * size_dm, 30 * size_dm);
        obstacle_3[3].setObstacleAlpha(220);

        effect[15] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[15].position(315, 480);
        effect[15].resized_image(30 * size_dm, 30 * size_dm);
        effect[15].setObstacleAlpha(220);

        obstacle_4[0] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        obstacle_4[0].position(68 * size_dm, 177 * size_dm);
        obstacle_4[0].resized_image(30 * size_dm, 30 * size_dm);
        obstacle_4[0].setObstacleAlpha(220);

        effect[16] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[16].position(208, 425);
        effect[16].resized_image(30 * size_dm, 30 * size_dm);
        effect[16].setObstacleAlpha(220);

        obstacle_4[1] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        obstacle_4[1].position(68 * size_dm, 177 * size_dm);
        obstacle_4[1].resized_image(30 * size_dm, 30 * size_dm);
        obstacle_4[1].setObstacleAlpha(220);

        effect[17] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[17].position(235, 454);
        effect[17].resized_image(30 * size_dm, 30 * size_dm);
        effect[17].setObstacleAlpha(220);

        obstacle_4[2] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        obstacle_4[2].position(68 * size_dm, 177 * size_dm);
        obstacle_4[2].resized_image(30 * size_dm, 30 * size_dm);
        obstacle_4[2].setObstacleAlpha(220);

        effect[18] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[18].position(259, 480);
        effect[18].resized_image(30 * size_dm, 30 * size_dm);
        effect[18].setObstacleAlpha(220);

        obstacle_4[3] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        obstacle_4[3].position(68 * size_dm, 177 * size_dm);
        obstacle_4[3].resized_image(30 * size_dm, 30 * size_dm);
        obstacle_4[3].setObstacleAlpha(220);

        effect[19] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[19].position(289, 510);
        effect[19].resized_image(30 * size_dm, 30 * size_dm);
        effect[19].setObstacleAlpha(220);

        obstacle_5[0] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        obstacle_5[0].position(55 * size_dm, 190 * size_dm);
        obstacle_5[0].resized_image(30 * size_dm, 30 * size_dm);
        obstacle_5[0].setObstacleAlpha(220);

        effect[20] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[20].position(180, 454);
        effect[20].resized_image(30 * size_dm, 30 * size_dm);
        effect[20].setObstacleAlpha(220);

        obstacle_5[1] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        obstacle_5[1].position(55 * size_dm, 190 * size_dm);
        obstacle_5[1].resized_image(30 * size_dm, 30 * size_dm);
        obstacle_5[1].setObstacleAlpha(220);

        effect[21] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[21].position(208, 477);
        effect[21].resized_image(30 * size_dm, 30 * size_dm);
        effect[21].setObstacleAlpha(220);

        obstacle_5[2] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        obstacle_5[2].position(55 * size_dm, 190 * size_dm);
        obstacle_5[2].resized_image(30 * size_dm, 30 * size_dm);
        obstacle_5[2].setObstacleAlpha(220);

        effect[22] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[22].position(235, 505);
        effect[22].resized_image(30 * size_dm, 30 * size_dm);
        effect[22].setObstacleAlpha(220);

        obstacle_5[3] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        obstacle_5[3].position(55 * size_dm, 190 * size_dm);
        obstacle_5[3].resized_image(30 * size_dm, 30 * size_dm);
        obstacle_5[3].setObstacleAlpha(220);

        effect[23] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[23].position(259, 530);
        effect[23].resized_image(30 * size_dm, 30 * size_dm);
        effect[23].setObstacleAlpha(220);

        obstacle_6[0] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        obstacle_6[0].position(42 * size_dm, 203 * size_dm);
        obstacle_6[0].resized_image(30 * size_dm, 30 * size_dm);
        obstacle_6[0].setObstacleAlpha(220);

        effect[24] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[24].position(157, 477);
        effect[24].resized_image(30 * size_dm, 30 * size_dm);
        effect[24].setObstacleAlpha(220);

        obstacle_6[1] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        obstacle_6[1].position(42 * size_dm, 203 * size_dm);
        obstacle_6[1].resized_image(30 * size_dm, 30 * size_dm);
        obstacle_6[1].setObstacleAlpha(220);

        effect[25] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[25].position(180, 505);
        effect[25].resized_image(30 * size_dm, 30 * size_dm);
        effect[25].setObstacleAlpha(220);

        obstacle_6[2] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        obstacle_6[2].position(42 * size_dm, 203 * size_dm);
        obstacle_6[2].resized_image(30 * size_dm, 30 * size_dm);
        obstacle_6[2].setObstacleAlpha(220);

        effect[26] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[26].position(208, 535);
        effect[26].resized_image(30 * size_dm, 30 * size_dm);
        effect[26].setObstacleAlpha(220);

        obstacle_6[3] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        obstacle_6[3].position(42 * size_dm, 203 * size_dm);
        obstacle_6[3].resized_image(30 * size_dm, 30 * size_dm);
        obstacle_6[3].setObstacleAlpha(220);

        effect[27] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[27].position(235, 560);
        effect[27].resized_image(30 * size_dm, 30 * size_dm);
        effect[27].setObstacleAlpha(220);

        obstacle_7[0] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        obstacle_7[0].position(29 * size_dm, 216 * size_dm);
        obstacle_7[0].resized_image(30 * size_dm, 30 * size_dm);
        obstacle_7[0].setObstacleAlpha(220);

        effect[28] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[28].position(130, 505);
        effect[28].resized_image(30 * size_dm, 30 * size_dm);
        effect[28].setObstacleAlpha(220);

        obstacle_7[1] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        obstacle_7[1].position(29 * size_dm, 216 * size_dm);
        obstacle_7[1].resized_image(30 * size_dm, 30 * size_dm);
        obstacle_7[1].setObstacleAlpha(220);

        effect[29] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[29].position(157, 535);
        effect[29].resized_image(30 * size_dm, 30 * size_dm);
        effect[29].setObstacleAlpha(220);

        obstacle_7[2] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        obstacle_7[2].position(29 * size_dm, 216 * size_dm);
        obstacle_7[2].resized_image(30 * size_dm, 30 * size_dm);
        obstacle_7[2].setObstacleAlpha(220);

        effect[30] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[30].position(180, 555);
        effect[30].resized_image(30 * size_dm, 30 * size_dm);
        effect[30].setObstacleAlpha(220);

        obstacle_7[3] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        obstacle_7[3].position(29 * size_dm, 216 * size_dm);
        obstacle_7[3].resized_image(30 * size_dm, 30 * size_dm);
        obstacle_7[3].setObstacleAlpha(220);

        effect[31] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[31].position(208, 585);
        effect[31].resized_image(30 * size_dm, 30 * size_dm);
        effect[31].setObstacleAlpha(220);

        r_obstacle[0] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        r_obstacle[0].position(189 * size_dm, 125 * size_dm);
        r_obstacle[0].resized_image(30 * size_dm, 30 * size_dm);
        r_obstacle[0].setObstacleAlpha(220);

        effect[32] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[32].position(315, 328);
        effect[32].resized_image(30 * size_dm, 30 * size_dm);
        effect[32].setObstacleAlpha(220);

        r_obstacle[1] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        r_obstacle[1].position(189 * size_dm, 125 * size_dm);
        r_obstacle[1].resized_image(30 * size_dm, 30 * size_dm);
        r_obstacle[1].setObstacleAlpha(220);

        effect[33] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[33].position(289, 350);
        effect[33].resized_image(30 * size_dm, 30 * size_dm);
        effect[33].setObstacleAlpha(220);

        r_obstacle[2] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        r_obstacle[2].position(189 * size_dm, 125 * size_dm);
        r_obstacle[2].resized_image(30 * size_dm, 30 * size_dm);
        r_obstacle[2].setObstacleAlpha(220);

        effect[34] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[34].position(259, 377);
        effect[34].resized_image(30 * size_dm, 30 * size_dm);
        effect[34].setObstacleAlpha(220);

        r_obstacle[3] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        r_obstacle[3].position(189 * size_dm, 125 * size_dm);
        r_obstacle[3].resized_image(30 * size_dm, 30 * size_dm);
        r_obstacle[3].setObstacleAlpha(220);

        effect[35] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[35].position(235, 400);
        effect[35].resized_image(30 * size_dm, 30 * size_dm);
        effect[35].setObstacleAlpha(220);

        r_obstacle_1[0] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        r_obstacle_1[0].position(202 * size_dm, 138 * size_dm);
        r_obstacle_1[0].resized_image(30 * size_dm, 30 * size_dm);
        r_obstacle_1[0].setObstacleAlpha(220);

        effect[36] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[36].position(341, 350);
        effect[36].resized_image(30 * size_dm, 30 * size_dm);
        effect[36].setObstacleAlpha(220);

        r_obstacle_1[1] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        r_obstacle_1[1].position(202 * size_dm, 138 * size_dm);
        r_obstacle_1[1].resized_image(30 * size_dm, 30 * size_dm);
        r_obstacle_1[1].setObstacleAlpha(220);

        effect[37] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[37].position(315, 375);
        effect[37].resized_image(30 * size_dm, 30 * size_dm);
        effect[37].setObstacleAlpha(220);

        r_obstacle_1[2] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        r_obstacle_1[2].position(202 * size_dm, 138 * size_dm);
        r_obstacle_1[2].resized_image(30 * size_dm, 30 * size_dm);
        r_obstacle_1[2].setObstacleAlpha(220);

        effect[38] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[38].position(289, 400);
        effect[38].resized_image(30 * size_dm, 30 * size_dm);
        effect[38].setObstacleAlpha(220);

        r_obstacle_1[3] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        r_obstacle_1[3].position(202 * size_dm, 138 * size_dm);
        r_obstacle_1[3].resized_image(30 * size_dm, 30 * size_dm);
        r_obstacle_1[3].setObstacleAlpha(220);

        effect[39] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[39].position(259, 430);
        effect[39].resized_image(30 * size_dm, 30 * size_dm);
        effect[39].setObstacleAlpha(220);

        r_obstacle_2[0] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        r_obstacle_2[0].position(215 * size_dm, 151 * size_dm);
        r_obstacle_2[0].resized_image(30 * size_dm, 30 * size_dm);
        r_obstacle_2[0].setObstacleAlpha(220);

        effect[40] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[40].position(367, 377);
        effect[40].resized_image(30 * size_dm, 30 * size_dm);
        effect[40].setObstacleAlpha(220);

        r_obstacle_2[1] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        r_obstacle_2[1].position(215 * size_dm, 151 * size_dm);
        r_obstacle_2[1].resized_image(30 * size_dm, 30 * size_dm);
        r_obstacle_2[1].setObstacleAlpha(220);

        effect[41] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[41].position(341, 400);
        effect[41].resized_image(30 * size_dm, 30 * size_dm);
        effect[41].setObstacleAlpha(220);

        r_obstacle_2[2] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        r_obstacle_2[2].position(215 * size_dm, 151 * size_dm);
        r_obstacle_2[2].resized_image(30 * size_dm, 30 * size_dm);
        r_obstacle_2[2].setObstacleAlpha(220);

        effect[42] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[42].position(315, 430);
        effect[42].resized_image(30 * size_dm, 30 * size_dm);
        effect[42].setObstacleAlpha(220);

        r_obstacle_2[3] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        r_obstacle_2[3].position(215 * size_dm, 151 * size_dm);
        r_obstacle_2[3].resized_image(30 * size_dm, 30 * size_dm);
        r_obstacle_2[3].setObstacleAlpha(220);

        effect[43] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[43].position(289, 450);
        effect[43].resized_image(30 * size_dm, 30 * size_dm);
        effect[43].setObstacleAlpha(220);

        r_obstacle_3[0] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        r_obstacle_3[0].position(228 * size_dm, 164 * size_dm);
        r_obstacle_3[0].resized_image(30 * size_dm, 30 * size_dm);
        r_obstacle_3[0].setObstacleAlpha(220);

        effect[44] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[44].position(393, 400);
        effect[44].resized_image(30 * size_dm, 30 * size_dm);
        effect[44].setObstacleAlpha(220);

        r_obstacle_3[1] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        r_obstacle_3[1].position(228 * size_dm, 164 * size_dm);
        r_obstacle_3[1].resized_image(30 * size_dm, 30 * size_dm);
        r_obstacle_3[1].setObstacleAlpha(220);

        effect[45] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[45].position(367, 430);
        effect[45].resized_image(30 * size_dm, 30 * size_dm);
        effect[45].setObstacleAlpha(220);

        r_obstacle_3[2] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        r_obstacle_3[2].position(228 * size_dm, 164 * size_dm);
        r_obstacle_3[2].resized_image(30 * size_dm, 30 * size_dm);
        r_obstacle_3[2].setObstacleAlpha(220);

        effect[46] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[46].position(341, 450);
        effect[46].resized_image(30 * size_dm, 30 * size_dm);
        effect[46].setObstacleAlpha(220);

        r_obstacle_3[3] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        r_obstacle_3[3].position(228 * size_dm, 164 * size_dm);
        r_obstacle_3[3].resized_image(30 * size_dm, 30 * size_dm);
        r_obstacle_3[3].setObstacleAlpha(220);

        effect[47] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[47].position(315, 480);
        effect[47].resized_image(30 * size_dm, 30 * size_dm);
        effect[47].setObstacleAlpha(220);

        r_obstacle_4[0] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        r_obstacle_4[0].position(241 * size_dm, 177 * size_dm);
        r_obstacle_4[0].resized_image(30 * size_dm, 30 * size_dm);
        r_obstacle_4[0].setObstacleAlpha(220);

        effect[48] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[48].position(419, 425);
        effect[48].resized_image(30 * size_dm, 30 * size_dm);
        effect[48].setObstacleAlpha(220);

        r_obstacle_4[1] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        r_obstacle_4[1].position(241 * size_dm, 177 * size_dm);
        r_obstacle_4[1].resized_image(30 * size_dm, 30 * size_dm);
        r_obstacle_4[1].setObstacleAlpha(220);

        effect[49] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[49].position(393, 454);
        effect[49].resized_image(30 * size_dm, 30 * size_dm);
        effect[49].setObstacleAlpha(220);

        r_obstacle_4[2] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        r_obstacle_4[2].position(241 * size_dm, 177 * size_dm);
        r_obstacle_4[2].resized_image(30 * size_dm, 30 * size_dm);
        r_obstacle_4[2].setObstacleAlpha(220);

        effect[50] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[50].position(367, 480);
        effect[50].resized_image(30 * size_dm, 30 * size_dm);
        effect[50].setObstacleAlpha(220);

        r_obstacle_4[3] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        r_obstacle_4[3].position(241 * size_dm, 177 * size_dm);
        r_obstacle_4[3].resized_image(30 * size_dm, 30 * size_dm);
        r_obstacle_4[3].setObstacleAlpha(220);

        effect[51] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[51].position(341, 510);
        effect[51].resized_image(30 * size_dm, 30 * size_dm);
        effect[51].setObstacleAlpha(220);

        r_obstacle_5[0] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        r_obstacle_5[0].position(254 * size_dm, 190 * size_dm);
        r_obstacle_5[0].resized_image(30 * size_dm, 30 * size_dm);
        r_obstacle_5[0].setObstacleAlpha(220);

        effect[52] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[52].position(445, 454);
        effect[52].resized_image(30 * size_dm, 30 * size_dm);
        effect[52].setObstacleAlpha(220);

        r_obstacle_5[1] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        r_obstacle_5[1].position(254 * size_dm, 190 * size_dm);
        r_obstacle_5[1].resized_image(30 * size_dm, 30 * size_dm);
        r_obstacle_5[1].setObstacleAlpha(220);

        effect[53] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[53].position(419, 477);
        effect[53].resized_image(30 * size_dm, 30 * size_dm);
        effect[53].setObstacleAlpha(220);

        r_obstacle_5[2] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        r_obstacle_5[2].position(254 * size_dm, 190 * size_dm);
        r_obstacle_5[2].resized_image(30 * size_dm, 30 * size_dm);
        r_obstacle_5[2].setObstacleAlpha(220);

        effect[54] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[54].position(393, 505);
        effect[54].resized_image(30 * size_dm, 30 * size_dm);
        effect[54].setObstacleAlpha(220);

        r_obstacle_5[3] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        r_obstacle_5[3].position(254 * size_dm, 190 * size_dm);
        r_obstacle_5[3].resized_image(30 * size_dm, 30 * size_dm);
        r_obstacle_5[3].setObstacleAlpha(220);

        effect[55] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[55].position(367, 530);
        effect[55].resized_image(30 * size_dm, 30 * size_dm);
        effect[55].setObstacleAlpha(220);

        r_obstacle_6[0] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        r_obstacle_6[0].position(267 * size_dm, 203 * size_dm);
        r_obstacle_6[0].resized_image(30 * size_dm, 30 * size_dm);
        r_obstacle_6[0].setObstacleAlpha(220);

        effect[56] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[56].position(471, 477);
        effect[56].resized_image(30 * size_dm, 30 * size_dm);
        effect[56].setObstacleAlpha(220);

        r_obstacle_6[1] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        r_obstacle_6[1].position(267 * size_dm, 203 * size_dm);
        r_obstacle_6[1].resized_image(30 * size_dm, 30 * size_dm);
        r_obstacle_6[1].setObstacleAlpha(220);

        effect[57] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[57].position(445, 505);
        effect[57].resized_image(30 * size_dm, 30 * size_dm);
        effect[57].setObstacleAlpha(220);

        r_obstacle_6[2] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        r_obstacle_6[2].position(267 * size_dm, 203 * size_dm);
        r_obstacle_6[2].resized_image(30 * size_dm, 30 * size_dm);
        r_obstacle_6[2].setObstacleAlpha(220);

        effect[58] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[58].position(419, 530);
        effect[58].resized_image(30 * size_dm, 30 * size_dm);
        effect[58].setObstacleAlpha(220);

        r_obstacle_6[3] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        r_obstacle_6[3].position(267 * size_dm, 203 * size_dm);
        r_obstacle_6[3].resized_image(30 * size_dm, 30 * size_dm);
        r_obstacle_6[3].setObstacleAlpha(220);

        effect[59] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[59].position(393, 560);
        effect[59].resized_image(30 * size_dm, 30 * size_dm);
        effect[59].setObstacleAlpha(220);

        r_obstacle_7[0] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        r_obstacle_7[0].position(280 * size_dm, 216 * size_dm);
        r_obstacle_7[0].resized_image(30 * size_dm, 30 * size_dm);
        r_obstacle_7[0].setObstacleAlpha(220);

        effect[60] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[60].position(495, 505);
        effect[60].resized_image(30 * size_dm, 30 * size_dm);
        effect[60].setObstacleAlpha(220);

        r_obstacle_7[1] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        r_obstacle_7[1].position(280 * size_dm, 216 * size_dm);
        r_obstacle_7[1].resized_image(30 * size_dm, 30 * size_dm);
        r_obstacle_7[1].setObstacleAlpha(220);

        effect[61] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[61].position(471, 535);
        effect[61].resized_image(30 * size_dm, 30 * size_dm);
        effect[61].setObstacleAlpha(220);

        r_obstacle_7[2] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        r_obstacle_7[2].position(280 * size_dm, 216 * size_dm);
        r_obstacle_7[2].resized_image(30 * size_dm, 30 * size_dm);
        r_obstacle_7[2].setObstacleAlpha(220);

        effect[62] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[62].position(445, 555);
        effect[62].resized_image(30 * size_dm, 30 * size_dm);
        effect[62].setObstacleAlpha(220);

        r_obstacle_7[3] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.enemy);
        r_obstacle_7[3].position(280 * size_dm, 216 * size_dm);
        r_obstacle_7[3].resized_image(30 * size_dm, 30 * size_dm);
        r_obstacle_7[3].setObstacleAlpha(220);

        effect[63] = new ObstacleClass(getApplicationContext(), gameview9, R.drawable.effect);
        effect[63].position(419, 585);
        effect[63].resized_image(30 * size_dm, 30 * size_dm);
        effect[63].setObstacleAlpha(220);

        score_total = getIntent().getIntExtra("SCORE", 0);
        score_number.setText(score_total + "");

        TextView game_first = null;

        game_setFont(game_first, "fonts/korra.ttf", R.id.score);
        game_setFont(game_first, "fonts/korra.ttf", R.id.time);
        game_setFont(game_first, "fonts/korra.ttf", R.id.life);

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

                                    if (total_time_number <= 0 || health_number >= 3 ||  action_flag1_count3 == 0) {

                                        if (health_number >= 3) {
                                            try {
                                                timer.cancel();
                                                timer = null;
                                                Intent intent = new Intent(getApplicationContext(),  Ending.class);
                                                intent.putExtra("SCORE", score_total);
                                                startActivity(intent);
                                            } catch (Exception e) {
                                                Intent intent = new Intent(getApplicationContext(),  Ending.class);
                                                intent.putExtra("SCORE", score_total);
                                                startActivity(intent);
                                            }
                                        } else if (action_flag1_count3 == 0) {
                                            try {
                                                timer.cancel();
                                                timer = null;
                                                Intent intent = new Intent(getApplicationContext(), Main10.class);
                                                intent.putExtra("SCORE", score_total);
                                                startActivity(intent);
                                            } catch (Exception e) {
                                                Intent intent = new Intent(getApplicationContext(), Main10.class);
                                                intent.putExtra("SCORE", score_total);
                                                startActivity(intent);
                                            }

                                        } else {
                                            try {
                                                timer.cancel();
                                                timer = null;
                                                Intent intent = new Intent(getApplicationContext(), Ending.class);
                                                intent.putExtra("SCORE", score_total);
                                                startActivity(intent);
                                            } catch (Exception e) {
                                                Intent intent = new Intent(getApplicationContext(), Ending.class);
                                                intent.putExtra("SCORE", score_total);
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

                                        if (enemy_action_flag1 == false || enemy_action_flag2 == false || enemy_action_flag3 == false) {
                                            if (stun_enemy == false) {
                                                Isdamaged_enemy = hit_check_enemy();
                                                enemy_health_check(Isdamaged_enemy);
                                            } else {
                                                ++enemy_health_time_number;
                                                if (enemy_health_time_number % 300 == 0) {
                                                    stun_enemy = false;
                                                    enemy_health_time_number = 0;
                                                }
                                            }
                                        }

                                        if (timing_number % 25 == 1) {
                                            shot_enemy6();
                                        }

                                        if (enemy_action_flag1 == false && action_flag1_count != 0) {
                                            if (level_time_number % 50 == 0) {

                                                if (enemy1_cal[0] == 1) {
                                                    pattern[getRandomMath9(31, 0)] = 1;
                                                } else if (enemy1_cal[1] == 1) {
                                                    pattern[getRandomMath9(63, 32)] = 1;
                                                }

                                                if (level_time_number > 1000) {
                                                    level_time_number = 0;
                                                }
                                            }
                                        } else if (enemy_action_flag1 == true) {

                                            ++blackhall_action_time;
                                            if (blackhall_action_time % 300 != 0) {
                                                blackhall_attack1();
                                            } else {
                                                enemy_action_flag1 = false;
                                                enemy_center.setScaleX(1);
                                                enemy_center.setScaleY(1);
                                                blackhall_action_time = 0;
                                            }
                                        }

                                        if (enemy_action_flag2 == false && action_flag1_count == 0 && action_flag1_count3 == 1) {
                                            if (level_time_number % 50 == 0) {

                                                if (enemy1_cal[0] == 1) {
                                                    pattern[getRandomMath9(31, 0)] = 1;
                                                } else if (enemy1_cal[1] == 1) {
                                                    pattern[getRandomMath9(63, 32)] = 1;
                                                }

                                                if (level_time_number > 1000) {
                                                    level_time_number = 0;
                                                }
                                            }
                                        } else if (enemy_action_flag2 == true) {
                                            ++blackhall_action_time;
                                            if (blackhall_action_time % 300 != 0) {
                                                blackhall_attack1();
                                            } else {
                                                enemy_action_flag2 = false;
                                                enemy_center.setScaleX(1);
                                                enemy_center.setScaleY(1);
                                                blackhall_action_time = 0;
                                            }
                                        }

                                        if (enemy_action_flag3 == false && action_flag1_count2 == 0) {
                                            if (level_time_number % 50 == 0) {

                                                if (enemy1_cal[0] == 1) {
                                                    pattern[getRandomMath9(31, 0)] = 1;
                                                } else if (enemy1_cal[1] == 1) {
                                                    pattern[getRandomMath9(63, 32)] = 1;
                                                }

                                                if (level_time_number > 1000) {
                                                    level_time_number = 0;
                                                }
                                            }
                                        } else if (enemy_action_flag3 == true) {
                                            ++blackhall_action_time;
                                            if (blackhall_action_time % 300 != 0) {
                                                blackhall_attack1();
                                            } else {
                                                enemy_action_flag3 = false;
                                                enemy_center.setScaleX(1);
                                                enemy_center.setScaleY(1);
                                                blackhall_action_time = 0;
                                            }
                                        }

                                        if (action_flag1_count != 0) {
                                            shot_enemy1();
                                            enemy_attack1();
                                        } else if (action_flag1_count == 0 && action_flag1_count2 != 0) {
                                            shot_enemy1();
                                            enemy_attack2();
                                            hit_check2();
                                        } else if (action_flag1_count2 == 0) {
                                            enemy_attack3();

                                            if (timing_number % 5 == 0 && action_flag1_count3 < 170) {
                                                enemy_moving();
                                            }

                                            hit_check2();
                                        }

                                        player_moving(SpeedX, SpeedY, action_flg);
                                        bullet_moving(player.getX(), player.getY(), SpeedX, SpeedY);

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

    void enemy_attack3() {

        if (initialize_enemy_attack3 == false) {
            for (int i = 0; i < 64; i++) {
                pattern[i] = 0;
            }

            for (int i = 0; i < 64; i++) {
                effect[i].setObstacleAlpha(0);
                effect[i].position_effect();
            }

            for (int i = 0; i < 4; i++) {
                obstacle[i].position(120 * size_dm, 125 * size_dm);
                obstacle[i].setObstacleAlpha(0);
                obstacle[i].position_effect();
            }

            for (int i = 0; i < 4; i++) {
                obstacle_1[i].position(107 * size_dm, 138 * size_dm);
                obstacle_1[i].setObstacleAlpha(0);
                obstacle_1[i].position_effect();
            }

            for (int i = 0; i < 4; i++) {
                obstacle_2[i].position(94 * size_dm, 151 * size_dm);
                obstacle_2[i].setObstacleAlpha(0);
                obstacle_2[i].position_effect();
            }

            for (int i = 0; i < 4; i++) {
                obstacle_3[i].position(81 * size_dm, 164 * size_dm);
                obstacle_3[i].setObstacleAlpha(0);
                obstacle_3[i].position_effect();
            }

            for (int i = 0; i < 4; i++) {
                obstacle_4[i].position(68 * size_dm, 177 * size_dm);
                obstacle_4[i].setObstacleAlpha(0);
                obstacle_4[i].position_effect();
            }

            for (int i = 0; i < 4; i++) {
                obstacle_5[i].position(55 * size_dm, 190 * size_dm);
                obstacle_5[i].setObstacleAlpha(0);
                obstacle_5[i].position_effect();
            }

            for (int i = 0; i < 4; i++) {
                obstacle_6[i].position(42 * size_dm, 203 * size_dm);
                obstacle_6[i].setObstacleAlpha(0);
                obstacle_6[i].position_effect();
            }

            for (int i = 0; i < 4; i++) {
                obstacle_7[i].position(29 * size_dm, 216 * size_dm);
                obstacle_7[i].setObstacleAlpha(0);
                obstacle_7[i].position_effect();
            }

            for (int i = 0; i < 4; i++) {
                r_obstacle[i].position(189 * size_dm, 125 * size_dm);
                r_obstacle[i].setObstacleAlpha(0);
                r_obstacle[i].position_effect();
            }

            for (int i = 0; i < 4; i++) {
                r_obstacle_1[i].position(202 * size_dm, 138 * size_dm);
                r_obstacle_1[i].setObstacleAlpha(0);
                r_obstacle_1[i].position_effect();
            }

            for (int i = 0; i < 4; i++) {
                r_obstacle_2[i].position(215 * size_dm, 151 * size_dm);
                r_obstacle_2[i].setObstacleAlpha(0);
                r_obstacle_2[i].position_effect();
            }

            for (int i = 0; i < 4; i++) {
                r_obstacle_3[i].position(228 * size_dm, 164 * size_dm);
                r_obstacle_3[i].setObstacleAlpha(0);
                r_obstacle_3[i].position_effect();
            }

            for (int i = 0; i < 4; i++) {
                r_obstacle_4[i].position(241 * size_dm, 177 * size_dm);
                r_obstacle_4[i].setObstacleAlpha(0);
                r_obstacle_4[i].position_effect();
            }

            for (int i = 0; i < 4; i++) {
                r_obstacle_5[i].position(254 * size_dm, 190 * size_dm);
                r_obstacle_5[i].setObstacleAlpha(0);
                r_obstacle_5[i].position_effect();
            }

            for (int i = 0; i < 4; i++) {
                r_obstacle_6[i].position(267 * size_dm, 203 * size_dm);
                r_obstacle_6[i].setObstacleAlpha(0);
                r_obstacle_6[i].position_effect();
            }

            for (int i = 0; i < 4; i++) {
                r_obstacle_7[i].position(280 * size_dm, 216 * size_dm);
                r_obstacle_7[i].setObstacleAlpha(0);
                r_obstacle_7[i].position_effect();
            }


            enemy_bullet[0].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[0].setObstacleAlpha(0);
            enemy_bullet[0].position_effect();
            enemy_shot[0] = 0;

            enemy_bullet[1].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[1].setObstacleAlpha(0);
            enemy_bullet[1].position_effect();
            enemy_shot[1] = 0;

            enemy_bullet[2].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[2].setObstacleAlpha(0);
            enemy_bullet[2].position_effect();
            enemy_shot[2] = 0;

            enemy_bullet[3].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[3].setObstacleAlpha(0);
            enemy_bullet[3].position_effect();
            enemy_shot[3] = 0;

            enemy_bullet[4].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[4].setObstacleAlpha(0);
            enemy_bullet[4].position_effect();
            enemy_shot[4] = 0;

            enemy_bullet[5].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[5].setObstacleAlpha(0);
            enemy_bullet[5].position_effect();
            enemy_shot[5] = 0;

            enemy_bullet[6].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[6].setObstacleAlpha(0);
            enemy_bullet[6].position_effect();
            enemy_shot[6] = 0;

            enemy_bullet[7].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[7].setObstacleAlpha(0);
            enemy_bullet[7].position_effect();
            enemy_shot[7] = 0;

            enemy_bullet[8].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[8].setObstacleAlpha(0);
            enemy_bullet[8].position_effect();
            enemy_shot[8] = 0;

            enemy_bullet[9].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[9].setObstacleAlpha(0);
            enemy_bullet[9].position_effect();
            enemy_shot[9] = 0;


            enemy_bullet[10].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[10].setObstacleAlpha(0);
            enemy_bullet[10].position_effect();
            enemy_shot[10] = 0;


            enemy_bullet[11].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[11].setObstacleAlpha(0);
            enemy_bullet[11].position_effect();
            enemy_shot[11] = 0;


            enemy_bullet[12].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[12].setObstacleAlpha(0);
            enemy_bullet[12].position_effect();
            enemy_shot[12] = 0;


            enemy_bullet[13].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[13].setObstacleAlpha(0);
            enemy_bullet[13].position_effect();
            enemy_shot[13] = 0;


            enemy_bullet[14].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[14].setObstacleAlpha(0);
            enemy_bullet[14].position_effect();
            enemy_shot[14] = 0;


            enemy_bullet[15].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[15].setObstacleAlpha(0);
            enemy_bullet[15].position_effect();
            enemy_shot[15] = 0;


            for(int i=0; i<15; i++)
            {
                last_SpeedX[i] = enemy_last_attack_SpeedX[getRandomMath9(4, 0)];
                last_SpeedY[i] = enemy_last_attack_Speed_Y[getRandomMath9(3, 0)];
            }

            for(int i=15; i<32; i++)
            {
                last_SpeedX[i] = enemy_last_attack_Speed_X[getRandomMath9(3, 0)];
                last_SpeedY[i] = enemy_last_attack_SpeedY[getRandomMath9(4, 0)];
            }

            initialize_enemy_attack3 = true;
        }

        if (action_flag1_count2 == 0 && enemy_maximum_energy > 5 * size_dm && enemy_action_flag3 == false && action_flag1_count3 != 0) {

            if (action_flag1_count3 >= 170) {
                //enemy_center.setX(170 * size_dm);
                //enemy_center.setY(233 * size_dm);

                if (initialize_enemy_attack4 == false) {
                    for (int i = 0; i < 4; i++) {
                        obstacle[i].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        obstacle[i].setObstacleAlpha(0);
                        obstacle[i].position_effect();
                    }

                    for (int i = 0; i < 4; i++) {
                        obstacle_1[i].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        obstacle_1[i].setObstacleAlpha(0);
                        obstacle_1[i].position_effect();
                    }

                    for (int i = 0; i < 4; i++) {
                        obstacle_2[i].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        obstacle_2[i].setObstacleAlpha(0);
                        obstacle_2[i].position_effect();
                    }

                    for (int i = 0; i < 4; i++) {
                        obstacle_3[i].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        obstacle_3[i].setObstacleAlpha(0);
                        obstacle_3[i].position_effect();
                    }

                    for (int i = 0; i < 16; i++) {
                        effect[i].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        effect[i].setObstacleAlpha(0);
                        effect[i].position_effect();
                    }

                    initialize_enemy_attack4 = true;

                }

                pattern[getRandomMath9(31, 0)] = 1;

                if (pattern[0] == 1) {
                    if (obstacle[0].position_x >= 300 * size_dm || obstacle[0].position_x <= 10 * size_dm || obstacle[0].position_y <= 90 * size_dm || obstacle[0].position_y >= 350 * size_dm) {
                        obstacle[0].setObstacleAlpha(0);
                        obstacle[0].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        obstacle[0].position_effect();
                    } else {
                        obstacle[0].setObstacleAlpha(200);
                        obstacle[0].setPosition(last_SpeedX[0], last_SpeedY[0]);
                    }
                }


                if (pattern[1] == 1) {
                    if (obstacle[1].position_x >= 300 * size_dm || obstacle[1].position_x <= 10 * size_dm || obstacle[1].position_y <= 90 * size_dm || obstacle[1].position_y >= 350 * size_dm) {
                        obstacle[1].setObstacleAlpha(0);
                        obstacle[1].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        obstacle[1].position_effect();
                    } else {
                        obstacle[1].setObstacleAlpha(200);
                        obstacle[1].setPosition(last_SpeedX[1], last_SpeedY[1]);
                    }
                }

                if (pattern[2] == 1) {
                    if (obstacle[2].position_x >= 300 * size_dm || obstacle[2].position_x <= 10 * size_dm || obstacle[2].position_y <= 90 * size_dm || obstacle[2].position_y >= 350 * size_dm) {
                        obstacle[2].setObstacleAlpha(0);
                        obstacle[2].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        obstacle[2].position_effect();
                    } else {
                        obstacle[2].setObstacleAlpha(200);
                        obstacle[2].setPosition(last_SpeedX[2], last_SpeedY[2]);
                    }
                }

                if (pattern[3] == 1) {
                    if (obstacle[3].position_x >= 300 * size_dm || obstacle[3].position_x <= 10 * size_dm || obstacle[3].position_y <= 90 * size_dm || obstacle[3].position_y >= 350 * size_dm) {
                        obstacle[3].setObstacleAlpha(0);
                        obstacle[3].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        obstacle[3].position_effect();
                    } else {
                        obstacle[3].setObstacleAlpha(200);
                        obstacle[3].setPosition(last_SpeedX[3], last_SpeedY[3]);
                    }
                }

                if (pattern[4] == 1) {
                    if (obstacle_3[3].position_x >= 300 * size_dm || obstacle_3[3].position_x <= 10 * size_dm || obstacle_3[3].position_y <= 90 * size_dm || obstacle_3[3].position_y >= 350 * size_dm) {
                        obstacle_3[3].setObstacleAlpha(0);
                        obstacle_3[3].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        obstacle_3[3].position_effect();
                    } else {
                        obstacle_3[3].setObstacleAlpha(200);
                        obstacle_3[3].setPosition(last_SpeedX[4], last_SpeedY[4]);
                    }
                }

                if (pattern[5] == 1) {
                    if (obstacle_1[0].position_x >= 300 * size_dm || obstacle_1[0].position_x <= 10 * size_dm || obstacle_1[0].position_y <= 90 * size_dm || obstacle_1[0].position_y >= 350 * size_dm) {
                        obstacle_1[0].setObstacleAlpha(0);
                        obstacle_1[0].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        obstacle_1[0].position_effect();
                    } else {
                        obstacle_1[0].setObstacleAlpha(200);
                        obstacle_1[0].setPosition(last_SpeedX[5], last_SpeedY[5]);
                    }
                }

                if (pattern[6] == 1) {
                    if (obstacle_1[1].position_x >= 300 * size_dm || obstacle_1[1].position_x <= 10 * size_dm || obstacle_1[1].position_y <= 90 * size_dm || obstacle_1[1].position_y >= 350 * size_dm) {
                        obstacle_1[1].setObstacleAlpha(0);
                        obstacle_1[1].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        obstacle_1[1].position_effect();
                    } else {
                        obstacle_1[1].setObstacleAlpha(200);
                        obstacle_1[1].setPosition(last_SpeedX[6], last_SpeedY[6]);
                    }
                }

                if (pattern[7] == 1) {
                    if (obstacle_1[2].position_x >= 300 * size_dm || obstacle_1[2].position_x <= 10 * size_dm || obstacle_1[2].position_y <= 90 * size_dm || obstacle_1[2].position_y >= 350 * size_dm) {
                        obstacle_1[2].setObstacleAlpha(0);
                        obstacle_1[2].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        obstacle_1[2].position_effect();
                    } else {
                        obstacle_1[2].setObstacleAlpha(200);
                        obstacle_1[2].setPosition(last_SpeedX[7], last_SpeedY[7]);
                    }
                }

                if (pattern[8] == 1) {
                    if (effect[0].position_x >= 300 * size_dm || effect[0].position_x <= 10 * size_dm || effect[0].position_y <= 90 * size_dm || effect[0].position_y >= 350 * size_dm) {
                        effect[0].setObstacleAlpha(0);
                        effect[0].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        effect[0].position_effect();
                    } else {
                        effect[0].setObstacleAlpha(200);
                        effect[0].setPosition(last_SpeedX[8], last_SpeedY[8]);
                    }
                }

                if (pattern[9] == 1) {
                    if (effect[1].position_x >= 300 * size_dm || effect[1].position_x <= 10 * size_dm || effect[1].position_y <= 90 * size_dm || effect[1].position_y >= 350 * size_dm) {
                        effect[1].setObstacleAlpha(0);
                        effect[1].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        effect[1].position_effect();
                    } else {
                        effect[1].setObstacleAlpha(200);
                        effect[1].setPosition(last_SpeedX[9], last_SpeedY[9]);
                    }
                }

                if (pattern[10] == 1) {
                    if (effect[2].position_x >= 300 * size_dm || effect[2].position_x <= 10 * size_dm || effect[2].position_y <= 90 * size_dm || effect[2].position_y >= 350 * size_dm) {
                        effect[2].setObstacleAlpha(0);
                        effect[2].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        effect[2].position_effect();
                    } else {
                        effect[2].setObstacleAlpha(200);
                        effect[2].setPosition(last_SpeedX[10], last_SpeedY[10]);
                    }
                }

                if (pattern[11] == 1) {
                    if (effect[3].position_x >= 300 * size_dm || effect[3].position_x <= 10 * size_dm || effect[3].position_y <= 90 * size_dm || effect[3].position_y >= 350 * size_dm) {
                        effect[3].setObstacleAlpha(0);
                        effect[3].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        effect[3].position_effect();
                    } else {
                        effect[3].setObstacleAlpha(200);
                        effect[3].setPosition(last_SpeedX[11], last_SpeedY[11]);
                    }
                }
                if (pattern[12] == 1) {
                    if (effect[4].position_x >= 300 * size_dm || effect[4].position_x <= 10 * size_dm || effect[4].position_y <= 90 * size_dm || effect[4].position_y >= 350 * size_dm) {
                        effect[4].setObstacleAlpha(0);
                        effect[4].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        effect[4].position_effect();
                    } else {
                        effect[4].setObstacleAlpha(200);
                        effect[4].setPosition(last_SpeedX[12], last_SpeedY[12]);
                    }
                }

                if (pattern[13] == 1) {
                    if (effect[5].position_x >= 300 * size_dm || effect[5].position_x <= 10 * size_dm || effect[5].position_y <= 90 * size_dm || effect[5].position_y >= 350 * size_dm) {
                        effect[5].setObstacleAlpha(0);
                        effect[5].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        effect[5].position_effect();
                    } else {
                        effect[5].setObstacleAlpha(200);
                        effect[5].setPosition(last_SpeedX[13], last_SpeedY[13]);
                    }
                }

                if (pattern[14] == 1) {
                    if (effect[6].position_x >= 300 * size_dm || effect[6].position_x <= 10 * size_dm || effect[6].position_y <= 90 * size_dm || effect[6].position_y >= 350 * size_dm) {
                        effect[6].setObstacleAlpha(0);
                        effect[6].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        effect[6].position_effect();
                    } else {
                        effect[6].setObstacleAlpha(200);
                        effect[6].setPosition(last_SpeedX[14], last_SpeedY[14]);
                    }
                }

                if (pattern[15] == 1) {
                    if (effect[7].position_x >= 300 * size_dm || effect[7].position_x <= 10 * size_dm || effect[7].position_y <= 90 * size_dm || effect[7].position_y >= 350 * size_dm) {
                        effect[7].setObstacleAlpha(0);
                        effect[7].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        effect[7].position_effect();
                    } else {
                        effect[7].setObstacleAlpha(200);
                        effect[7].setPosition(last_SpeedX[15], last_SpeedY[15]);
                    }
                }

                if (pattern[16] == 1) {
                    if (obstacle_1[3].position_x >= 300 * size_dm || obstacle_1[3].position_x <= 10 * size_dm || obstacle_1[3].position_y <= 90 * size_dm || obstacle_1[3].position_y >= 350 * size_dm) {
                        obstacle_1[3].setObstacleAlpha(0);
                        obstacle_1[3].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        obstacle_1[3].position_effect();
                    } else {
                        obstacle_1[3].setObstacleAlpha(200);
                        obstacle_1[3].setPosition(last_SpeedX[16], last_SpeedY[16]);
                    }
                }

                if (pattern[17] == 1) {
                    if (obstacle_2[0].position_x >= 300 * size_dm || obstacle_2[0].position_x <= 10 * size_dm || obstacle_2[0].position_y <= 90 * size_dm || obstacle_2[0].position_y >= 350 * size_dm) {
                        obstacle_2[0].setObstacleAlpha(0);
                        obstacle_2[0].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        obstacle_2[0].position_effect();
                    } else {
                        obstacle_2[0].setObstacleAlpha(200);
                        obstacle_2[0].setPosition(last_SpeedX[17], last_SpeedY[17]);
                    }
                }

                if (pattern[18] == 1) {
                    if (obstacle_2[1].position_x >= 300 * size_dm || obstacle_2[1].position_x <= 10 * size_dm || obstacle_2[1].position_y <= 90 * size_dm || obstacle_2[1].position_y >= 350 * size_dm) {
                        obstacle_2[1].setObstacleAlpha(0);
                        obstacle_2[1].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        obstacle_2[1].position_effect();
                    } else {
                        obstacle_2[1].setObstacleAlpha(200);
                        obstacle_2[1].setPosition(last_SpeedX[18], last_SpeedY[18]);
                    }
                }

                if (pattern[19] == 1) {
                    if (obstacle_2[2].position_x >= 300 * size_dm || obstacle_2[2].position_x <= 10 * size_dm || obstacle_2[2].position_y <= 90 * size_dm || obstacle_2[2].position_y >= 350 * size_dm) {
                        obstacle_2[2].setObstacleAlpha(0);
                        obstacle_2[2].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        obstacle_2[2].position_effect();
                    } else {
                        obstacle_2[2].setObstacleAlpha(200);
                        obstacle_2[2].setPosition(last_SpeedX[19], last_SpeedY[19]);
                    }
                }

                if (pattern[20] == 1) {
                    if (obstacle_2[3].position_x >= 300 * size_dm || obstacle_2[3].position_x <= 10 * size_dm || obstacle_2[3].position_y <= 90 * size_dm || obstacle_2[3].position_y >= 350 * size_dm) {
                        obstacle_2[3].setObstacleAlpha(0);
                        obstacle_2[3].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        obstacle_2[3].position_effect();
                    } else {
                        obstacle_2[3].setObstacleAlpha(200);
                        obstacle_2[3].setPosition(last_SpeedX[20], last_SpeedY[20]);
                    }
                }

                if (pattern[21] == 1) {
                    if (obstacle_3[0].position_x >= 300 * size_dm || obstacle_3[0].position_x <= 10 * size_dm || obstacle_3[0].position_y <= 90 * size_dm || obstacle_3[0].position_y >= 350 * size_dm) {
                        obstacle_3[0].setObstacleAlpha(0);
                        obstacle_3[0].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        obstacle_3[0].position_effect();
                    } else {
                        obstacle_3[0].setObstacleAlpha(200);
                        obstacle_3[0].setPosition(last_SpeedX[21], last_SpeedY[21]);
                    }
                }

                if (pattern[22] == 1) {
                    if (obstacle_3[1].position_x >= 300 * size_dm || obstacle_3[1].position_x <= 10 * size_dm || obstacle_3[1].position_y <= 90 * size_dm || obstacle_3[1].position_y >= 350 * size_dm) {
                        obstacle_3[1].setObstacleAlpha(0);
                        obstacle_3[1].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        obstacle_3[1].position_effect();
                    } else {
                        obstacle_3[1].setObstacleAlpha(200);
                        obstacle_3[1].setPosition(last_SpeedX[22], last_SpeedY[22]);
                    }
                }

                if (pattern[23] == 1) {
                    if (obstacle_3[2].position_x >= 300 * size_dm || obstacle_3[2].position_x <= 10 * size_dm || obstacle_3[2].position_y <= 90 * size_dm || obstacle_3[2].position_y >= 350 * size_dm) {
                        obstacle_3[2].setObstacleAlpha(0);
                        obstacle_3[2].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        obstacle_3[2].position_effect();
                    } else {
                        obstacle_3[2].setObstacleAlpha(200);
                        obstacle_3[2].setPosition(last_SpeedX[23], last_SpeedY[23]);
                    }
                }

                if (pattern[24] == 1) {
                    if (effect[8].position_x >= 300 * size_dm || effect[8].position_x <= 10 * size_dm || effect[8].position_y <= 90 * size_dm || effect[8].position_y >= 350 * size_dm) {
                        effect[8].setObstacleAlpha(0);
                        effect[8].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        effect[8].position_effect();
                    } else {
                        effect[8].setObstacleAlpha(200);
                        effect[8].setPosition(last_SpeedX[24], last_SpeedY[24]);
                    }
                }

                if (pattern[25] == 1) {
                    if (effect[9].position_x >= 300 * size_dm || effect[9].position_x <= 10 * size_dm || effect[9].position_y <= 90 * size_dm || effect[9].position_y >= 350 * size_dm) {
                        effect[9].setObstacleAlpha(0);
                        effect[9].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        effect[9].position_effect();
                    } else {
                        effect[9].setObstacleAlpha(200);
                        effect[9].setPosition(last_SpeedX[25], last_SpeedY[25]);
                    }
                }

                if (pattern[26] == 1) {
                    if (effect[10].position_x >= 300 * size_dm || effect[10].position_x <= 10 * size_dm || effect[10].position_y <= 90 * size_dm || effect[10].position_y >= 350 * size_dm) {
                        effect[10].setObstacleAlpha(0);
                        effect[10].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        effect[10].position_effect();
                    } else {
                        effect[10].setObstacleAlpha(200);
                        effect[10].setPosition(last_SpeedX[26], last_SpeedY[26]);
                    }
                }

                if (pattern[27] == 1) {
                    if (effect[11].position_x >= 300 * size_dm || effect[11].position_x <= 10 * size_dm || effect[11].position_y <= 90 * size_dm || effect[11].position_y >= 350 * size_dm) {
                        effect[11].setObstacleAlpha(0);
                        effect[11].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        effect[11].position_effect();
                    } else {
                        effect[11].setObstacleAlpha(200);
                        effect[11].setPosition(last_SpeedX[27], last_SpeedY[27]);
                    }
                }

                if (pattern[28] == 1) {
                    if (effect[12].position_x >= 300 * size_dm || effect[12].position_x <= 10 * size_dm || effect[12].position_y <= 90 * size_dm || effect[12].position_y >= 350 * size_dm) {
                        effect[12].setObstacleAlpha(0);
                        effect[12].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        effect[12].position_effect();
                    } else {
                        effect[12].setObstacleAlpha(200);
                        effect[12].setPosition(last_SpeedX[28], last_SpeedY[28]);
                    }
                }

                if (pattern[29] == 1) {
                    if (effect[13].position_x >= 300 * size_dm || effect[13].position_x <= 10 * size_dm || effect[13].position_y <= 90 * size_dm || effect[13].position_y >= 350 * size_dm) {
                        effect[13].setObstacleAlpha(0);
                        effect[13].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        effect[13].position_effect();
                    } else {
                        effect[13].setObstacleAlpha(200);
                        effect[13].setPosition(last_SpeedX[29], last_SpeedY[29]);
                    }
                }

                if (pattern[30] == 1) {
                    if (effect[14].position_x >= 300 * size_dm || effect[14].position_x <= 10 * size_dm || effect[14].position_y <= 90 * size_dm || effect[14].position_y >= 350 * size_dm) {
                        effect[14].setObstacleAlpha(0);
                        effect[14].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        effect[14].position_effect();
                    } else {
                        effect[14].setObstacleAlpha(200);
                        effect[14].setPosition(last_SpeedX[30], last_SpeedY[30]);
                    }
                }

                if (pattern[31] == 1) {
                    if (effect[15].position_x >= 300 * size_dm || effect[15].position_x <= 10 * size_dm || effect[15].position_y <= 90 * size_dm || effect[15].position_y >= 350 * size_dm) {
                        effect[15].setObstacleAlpha(0);
                        effect[15].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        effect[15].position_effect();
                    } else {
                        effect[15].setObstacleAlpha(200);
                        effect[15].setPosition(last_SpeedX[31], last_SpeedY[31]);
                    }
                }
            }

        } else if (enemy_action_flag3 == true) {

        } else if (action_flag1_count3 == 0) {

        } else

        {
            //enemy_bullet_moving();

        }

    }

    void enemy_moving()
    {
        for(int i=0; i<16; i++)
        {
            enemy_move_number[i] = 0;
        }

        enemy_move_angle();

        if(enemy_move_number[0] == 1)
        {
            enemy_center.setX(enemy_center.getX()+enemy_bullet1_SpeedX);
            enemy_center.setY(enemy_center.getY()+enemy_bullet1_SpeedY);
        } else if(enemy_move_number[1] == 1)
        {
            enemy_center.setX(enemy_center.getX()+enemy_bullet16_SpeedX);
            enemy_center.setY(enemy_center.getY()+enemy_bullet16_SpeedY);
        } else if(enemy_move_number[2] == 1)
        {
            enemy_center.setX(enemy_center.getX()+enemy_bullet15_SpeedX);
            enemy_center.setY(enemy_center.getY()+enemy_bullet15_SpeedY);
        } else if(enemy_move_number[3] == 1)
        {
            enemy_center.setX(enemy_center.getX()+enemy_bullet14_SpeedX);
            enemy_center.setY(enemy_center.getY()+enemy_bullet14_SpeedY);
        }else if(enemy_move_number[4] == 1)
        {
            enemy_center.setX(enemy_center.getX()+enemy_bullet13_SpeedX);
            enemy_center.setY(enemy_center.getY()+enemy_bullet13_SpeedY);
        }else if(enemy_move_number[5] == 1)
        {
            enemy_center.setX(enemy_center.getX()+enemy_bullet12_SpeedX);
            enemy_center.setY(enemy_center.getY()+enemy_bullet12_SpeedY);
        }else if(enemy_move_number[6] == 1)
        {
            enemy_center.setX(enemy_center.getX()+enemy_bullet11_SpeedX);
            enemy_center.setY(enemy_center.getY()+enemy_bullet11_SpeedY);
        }else if(enemy_move_number[7] == 1)
        {
            enemy_center.setX(enemy_center.getX()+enemy_bullet10_SpeedX);
            enemy_center.setY(enemy_center.getY()+enemy_bullet10_SpeedY);
        }else if(enemy_move_number[8] == 1)
        {
            enemy_center.setX(enemy_center.getX()+enemy_bullet9_SpeedX);
            enemy_center.setY(enemy_center.getY()+enemy_bullet9_SpeedY);
        }else if(enemy_move_number[9] == 1)
        {
            enemy_center.setX(enemy_center.getX()+enemy_bullet8_SpeedX);
            enemy_center.setY(enemy_center.getY()+enemy_bullet8_SpeedY);
        }else if(enemy_move_number[10] == 1)
        {
            enemy_center.setX(enemy_center.getX()+enemy_bullet7_SpeedX);
            enemy_center.setY(enemy_center.getY()+enemy_bullet7_SpeedY);
        }else if(enemy_move_number[11] == 1)
        {
            enemy_center.setX(enemy_center.getX()+enemy_bullet6_SpeedX);
            enemy_center.setY(enemy_center.getY()+enemy_bullet6_SpeedY);
        }else if(enemy_move_number[12] == 1)
        {
            enemy_center.setX(enemy_center.getX()+enemy_bullet5_SpeedX);
            enemy_center.setY(enemy_center.getY()+enemy_bullet5_SpeedY);
        }else if(enemy_move_number[13] == 1)
        {
            enemy_center.setX(enemy_center.getX()+enemy_bullet4_SpeedX);
            enemy_center.setY(enemy_center.getY()+enemy_bullet4_SpeedY);
        }else if(enemy_move_number[14] == 1)
        {
            enemy_center.setX(enemy_center.getX()+enemy_bullet3_SpeedX);
            enemy_center.setY(enemy_center.getY()+enemy_bullet3_SpeedY);
        }else
        {
            enemy_center.setX(enemy_center.getX()+enemy_bullet2_SpeedX);
            enemy_center.setY(enemy_center.getY()+enemy_bullet2_SpeedY);
        }
    }

    void hit_check2()
    {

        if(action_flag1_count2 != 0) {
            if (enemy_shot[0] == 1) {
                if ((player_bullet[0].position_x + player_bullet[0].resized_width / 4 - enemy_bullet[0].position_x) * (player_bullet[0].position_x + player_bullet[0].resized_width / 4 - enemy_bullet[0].position_x) < player_bullet[0].resized_width / 2 * player_bullet[0].resized_width / 3) {
                    if ((player_bullet[0].position_y + player_bullet[0].resized_height / 4 - enemy_bullet[0].position_y) * (player_bullet[0].position_y + player_bullet[0].resized_height / 4 - enemy_bullet[0].position_y) < player_bullet[0].resized_height / 2 * player_bullet[0].resized_height / 3) {
                        bullet[0] = 0;
                        player_bullet[0].position(10, 10);
                        player_bullet[0].setObstacleAlpha(0);
                        player_bullet[0].position_effect();

                        enemy_bullet[0].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[0].setObstacleAlpha(0);
                        enemy_bullet[0].position_effect();
                        enemy_shot[0] = 0;

                    }
                }
            }

            if (enemy_shot[0] == 1) {
                if ((player_bullet[1].position_x + player_bullet[1].resized_width / 4 - enemy_bullet[0].position_x) * (player_bullet[1].position_x + player_bullet[0].resized_width / 4 - enemy_bullet[1].position_x) < player_bullet[1].resized_width / 2 * player_bullet[1].resized_width / 3) {
                    if ((player_bullet[1].position_y + player_bullet[1].resized_height / 4 - enemy_bullet[0].position_y) * (player_bullet[1].position_y + player_bullet[0].resized_height / 4 - enemy_bullet[1].position_y) < player_bullet[1].resized_height / 2 * player_bullet[1].resized_height / 3) {
                        bullet[1] = 0;
                        player_bullet[1].position(10, 10);
                        player_bullet[1].setObstacleAlpha(0);
                        player_bullet[1].position_effect();

                        enemy_bullet[0].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[0].setObstacleAlpha(0);
                        enemy_bullet[0].position_effect();
                        enemy_shot[0] = 0;

                    }
                }
            }

            if (enemy_shot[0] == 1) {
                if ((player_bullet[2].position_x + player_bullet[0].resized_width / 4 - enemy_bullet[2].position_x) * (player_bullet[2].position_x + player_bullet[2].resized_width / 4 - enemy_bullet[0].position_x) < player_bullet[2].resized_width / 2 * player_bullet[2].resized_width / 3) {
                    if ((player_bullet[2].position_y + player_bullet[0].resized_height / 4 - enemy_bullet[2].position_y) * (player_bullet[2].position_y + player_bullet[2].resized_height / 4 - enemy_bullet[0].position_y) < player_bullet[2].resized_height / 2 * player_bullet[2].resized_height / 3) {
                        bullet[2] = 0;
                        player_bullet[2].position(10, 10);
                        player_bullet[2].setObstacleAlpha(0);
                        player_bullet[2].position_effect();

                        enemy_bullet[0].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[0].setObstacleAlpha(0);
                        enemy_bullet[0].position_effect();
                        enemy_shot[0] = 0;

                    }
                }
            }

            if (enemy_shot[1] == 1) {
                if ((player_bullet[0].position_x + player_bullet[0].resized_width / 4 - enemy_bullet[1].position_x) * (player_bullet[0].position_x + player_bullet[0].resized_width / 4 - enemy_bullet[1].position_x) < player_bullet[0].resized_width / 2 * player_bullet[0].resized_width / 3) {
                    if ((player_bullet[0].position_y + player_bullet[0].resized_height / 4 - enemy_bullet[1].position_y) * (player_bullet[0].position_y + player_bullet[0].resized_height / 4 - enemy_bullet[1].position_y) < player_bullet[0].resized_height / 2 * player_bullet[0].resized_height / 3) {
                        bullet[0] = 0;
                        player_bullet[0].position(10, 10);
                        player_bullet[0].setObstacleAlpha(0);
                        player_bullet[0].position_effect();

                        enemy_bullet[1].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[1].setObstacleAlpha(0);
                        enemy_bullet[1].position_effect();
                        enemy_shot[1] = 0;

                    }
                }
            }

            if (enemy_shot[1] == 1) {
                if ((player_bullet[1].position_x + player_bullet[1].resized_width / 4 - enemy_bullet[1].position_x) * (player_bullet[1].position_x + player_bullet[1].resized_width / 4 - enemy_bullet[1].position_x) < player_bullet[1].resized_width / 2 * player_bullet[1].resized_width / 3) {
                    if ((player_bullet[1].position_y + player_bullet[1].resized_height / 4 - enemy_bullet[1].position_y) * (player_bullet[1].position_y + player_bullet[1].resized_height / 4 - enemy_bullet[1].position_y) < player_bullet[1].resized_height / 2 * player_bullet[1].resized_height / 3) {
                        bullet[1] = 0;
                        player_bullet[1].position(10, 10);
                        player_bullet[1].setObstacleAlpha(0);
                        player_bullet[1].position_effect();

                        enemy_bullet[1].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[1].setObstacleAlpha(0);
                        enemy_bullet[1].position_effect();
                        enemy_shot[1] = 0;

                    }
                }
            }

            if (enemy_shot[1] == 1) {
                if ((player_bullet[2].position_x + player_bullet[2].resized_width / 4 - enemy_bullet[1].position_x) * (player_bullet[2].position_x + player_bullet[2].resized_width / 4 - enemy_bullet[1].position_x) < player_bullet[2].resized_width / 2 * player_bullet[2].resized_width / 3) {
                    if ((player_bullet[2].position_y + player_bullet[2].resized_height / 4 - enemy_bullet[1].position_y) * (player_bullet[2].position_y + player_bullet[2].resized_height / 4 - enemy_bullet[1].position_y) < player_bullet[2].resized_height / 2 * player_bullet[2].resized_height / 3) {
                        bullet[2] = 0;
                        player_bullet[2].position(10, 10);
                        player_bullet[2].setObstacleAlpha(0);
                        player_bullet[2].position_effect();

                        enemy_bullet[1].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[1].setObstacleAlpha(0);
                        enemy_bullet[1].position_effect();
                        enemy_shot[1] = 0;

                    }
                }
            }

            if (enemy_shot[2] == 1) {
                if ((player_bullet[0].position_x + player_bullet[0].resized_width / 4 - enemy_bullet[2].position_x) * (player_bullet[0].position_x + player_bullet[0].resized_width / 4 - enemy_bullet[2].position_x) < player_bullet[0].resized_width / 2 * player_bullet[0].resized_width / 3) {
                    if ((player_bullet[0].position_y + player_bullet[0].resized_height / 4 - enemy_bullet[2].position_y) * (player_bullet[0].position_y + player_bullet[0].resized_height / 4 - enemy_bullet[2].position_y) < player_bullet[0].resized_height / 2 * player_bullet[0].resized_height / 3) {
                        bullet[0] = 0;
                        player_bullet[0].position(10, 10);
                        player_bullet[0].setObstacleAlpha(0);
                        player_bullet[0].position_effect();

                        enemy_bullet[2].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[2].setObstacleAlpha(0);
                        enemy_bullet[2].position_effect();
                        enemy_shot[2] = 0;

                    }
                }
            }

            if (enemy_shot[2] == 1) {
                if ((player_bullet[1].position_x + player_bullet[1].resized_width / 4 - enemy_bullet[2].position_x) * (player_bullet[1].position_x + player_bullet[1].resized_width / 4 - enemy_bullet[2].position_x) < player_bullet[1].resized_width / 2 * player_bullet[1].resized_width / 3) {
                    if ((player_bullet[1].position_y + player_bullet[1].resized_height / 4 - enemy_bullet[2].position_y) * (player_bullet[1].position_y + player_bullet[1].resized_height / 4 - enemy_bullet[2].position_y) < player_bullet[1].resized_height / 2 * player_bullet[1].resized_height / 3) {
                        bullet[1] = 0;
                        player_bullet[1].position(10, 10);
                        player_bullet[1].setObstacleAlpha(0);
                        player_bullet[1].position_effect();

                        enemy_bullet[2].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[2].setObstacleAlpha(0);
                        enemy_bullet[2].position_effect();
                        enemy_shot[2] = 0;

                    }
                }
            }

            if (enemy_shot[2] == 1) {
                if ((player_bullet[2].position_x + player_bullet[2].resized_width / 4 - enemy_bullet[2].position_x) * (player_bullet[2].position_x + player_bullet[2].resized_width / 4 - enemy_bullet[2].position_x) < player_bullet[2].resized_width / 2 * player_bullet[2].resized_width / 3) {
                    if ((player_bullet[2].position_y + player_bullet[2].resized_height / 4 - enemy_bullet[2].position_y) * (player_bullet[2].position_y + player_bullet[2].resized_height / 4 - enemy_bullet[2].position_y) < player_bullet[2].resized_height / 2 * player_bullet[2].resized_height / 3) {
                        bullet[2] = 0;
                        player_bullet[2].position(10, 10);
                        player_bullet[2].setObstacleAlpha(0);
                        player_bullet[2].position_effect();

                        enemy_bullet[2].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[2].setObstacleAlpha(0);
                        enemy_bullet[2].position_effect();
                        enemy_shot[2] = 0;

                    }
                }
            }

            if (enemy_shot[3] == 1) {
                if ((player_bullet[0].position_x + player_bullet[0].resized_width / 4 - enemy_bullet[3].position_x) * (player_bullet[0].position_x + player_bullet[0].resized_width / 4 - enemy_bullet[3].position_x) < player_bullet[0].resized_width / 2 * player_bullet[0].resized_width / 3) {
                    if ((player_bullet[0].position_y + player_bullet[0].resized_height / 4 - enemy_bullet[3].position_y) * (player_bullet[0].position_y + player_bullet[0].resized_height / 4 - enemy_bullet[3].position_y) < player_bullet[0].resized_height / 2 * player_bullet[0].resized_height / 3) {
                        bullet[0] = 0;
                        player_bullet[0].position(10, 10);
                        player_bullet[0].setObstacleAlpha(0);
                        player_bullet[0].position_effect();

                        enemy_bullet[3].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[3].setObstacleAlpha(0);
                        enemy_bullet[3].position_effect();
                        enemy_shot[3] = 0;

                    }
                }
            }

            if (enemy_shot[3] == 1) {
                if ((player_bullet[1].position_x + player_bullet[1].resized_width / 4 - enemy_bullet[3].position_x) * (player_bullet[1].position_x + player_bullet[1].resized_width / 4 - enemy_bullet[3].position_x) < player_bullet[1].resized_width / 2 * player_bullet[1].resized_width / 3) {
                    if ((player_bullet[1].position_y + player_bullet[1].resized_height / 4 - enemy_bullet[3].position_y) * (player_bullet[1].position_y + player_bullet[1].resized_height / 4 - enemy_bullet[3].position_y) < player_bullet[1].resized_height / 2 * player_bullet[1].resized_height / 3) {
                        bullet[1] = 0;
                        player_bullet[1].position(10, 10);
                        player_bullet[1].setObstacleAlpha(0);
                        player_bullet[1].position_effect();

                        enemy_bullet[3].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[3].setObstacleAlpha(0);
                        enemy_bullet[3].position_effect();
                        enemy_shot[3] = 0;

                    }
                }
            }

            if (enemy_shot[3] == 1) {
                if ((player_bullet[2].position_x + player_bullet[2].resized_width / 4 - enemy_bullet[3].position_x) * (player_bullet[2].position_x + player_bullet[2].resized_width / 4 - enemy_bullet[3].position_x) < player_bullet[2].resized_width / 2 * player_bullet[2].resized_width / 3) {
                    if ((player_bullet[2].position_y + player_bullet[2].resized_height / 4 - enemy_bullet[3].position_y) * (player_bullet[2].position_y + player_bullet[2].resized_height / 4 - enemy_bullet[3].position_y) < player_bullet[2].resized_height / 2 * player_bullet[2].resized_height / 3) {
                        bullet[2] = 0;
                        player_bullet[2].position(10, 10);
                        player_bullet[2].setObstacleAlpha(0);
                        player_bullet[2].position_effect();

                        enemy_bullet[3].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[3].setObstacleAlpha(0);
                        enemy_bullet[3].position_effect();
                        enemy_shot[3] = 0;

                    }
                }
            }

            if (enemy_shot[4] == 1) {
                if ((player_bullet[0].position_x + player_bullet[0].resized_width / 4 - enemy_bullet[4].position_x) * (player_bullet[0].position_x + player_bullet[0].resized_width / 4 - enemy_bullet[4].position_x) < player_bullet[0].resized_width / 2 * player_bullet[0].resized_width / 3) {
                    if ((player_bullet[0].position_y + player_bullet[0].resized_height / 4 - enemy_bullet[4].position_y) * (player_bullet[0].position_y + player_bullet[0].resized_height / 4 - enemy_bullet[4].position_y) < player_bullet[0].resized_height / 2 * player_bullet[0].resized_height / 3) {
                        bullet[0] = 0;
                        player_bullet[0].position(10, 10);
                        player_bullet[0].setObstacleAlpha(0);
                        player_bullet[0].position_effect();

                        enemy_bullet[4].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[4].setObstacleAlpha(0);
                        enemy_bullet[4].position_effect();
                        enemy_shot[4] = 0;

                    }
                }
            }

            if (enemy_shot[4] == 1) {
                if ((player_bullet[1].position_x + player_bullet[1].resized_width / 4 - enemy_bullet[4].position_x) * (player_bullet[1].position_x + player_bullet[1].resized_width / 4 - enemy_bullet[4].position_x) < player_bullet[1].resized_width / 2 * player_bullet[1].resized_width / 3) {
                    if ((player_bullet[1].position_y + player_bullet[1].resized_height / 4 - enemy_bullet[4].position_y) * (player_bullet[1].position_y + player_bullet[1].resized_height / 4 - enemy_bullet[4].position_y) < player_bullet[1].resized_height / 2 * player_bullet[1].resized_height / 3) {
                        bullet[1] = 0;
                        player_bullet[1].position(10, 10);
                        player_bullet[1].setObstacleAlpha(0);
                        player_bullet[1].position_effect();

                        enemy_bullet[4].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[4].setObstacleAlpha(0);
                        enemy_bullet[4].position_effect();
                        enemy_shot[4] = 0;

                    }
                }
            }

            if (enemy_shot[4] == 1) {
                if ((player_bullet[2].position_x + player_bullet[2].resized_width / 4 - enemy_bullet[4].position_x) * (player_bullet[2].position_x + player_bullet[2].resized_width / 4 - enemy_bullet[4].position_x) < player_bullet[2].resized_width / 2 * player_bullet[2].resized_width / 3) {
                    if ((player_bullet[2].position_y + player_bullet[2].resized_height / 4 - enemy_bullet[4].position_y) * (player_bullet[2].position_y + player_bullet[2].resized_height / 4 - enemy_bullet[4].position_y) < player_bullet[2].resized_height / 2 * player_bullet[2].resized_height / 3) {
                        bullet[2] = 0;
                        player_bullet[2].position(10, 10);
                        player_bullet[2].setObstacleAlpha(0);
                        player_bullet[2].position_effect();

                        enemy_bullet[4].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[4].setObstacleAlpha(0);
                        enemy_bullet[4].position_effect();
                        enemy_shot[4] = 0;

                    }
                }
            }

            if (enemy_shot[5] == 1) {
                if ((player_bullet[0].position_x + player_bullet[0].resized_width / 4 - enemy_bullet[5].position_x) * (player_bullet[0].position_x + player_bullet[0].resized_width / 4 - enemy_bullet[5].position_x) < player_bullet[0].resized_width / 2 * player_bullet[0].resized_width / 3) {
                    if ((player_bullet[0].position_y + player_bullet[0].resized_height / 4 - enemy_bullet[5].position_y) * (player_bullet[0].position_y + player_bullet[0].resized_height / 4 - enemy_bullet[5].position_y) < player_bullet[0].resized_height / 2 * player_bullet[0].resized_height / 3) {
                        bullet[0] = 0;
                        player_bullet[0].position(10, 10);
                        player_bullet[0].setObstacleAlpha(0);
                        player_bullet[0].position_effect();

                        enemy_bullet[5].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[5].setObstacleAlpha(0);
                        enemy_bullet[5].position_effect();
                        enemy_shot[5] = 0;

                    }
                }
            }

            if (enemy_shot[5] == 1) {
                if ((player_bullet[1].position_x + player_bullet[1].resized_width / 4 - enemy_bullet[5].position_x) * (player_bullet[1].position_x + player_bullet[1].resized_width / 4 - enemy_bullet[5].position_x) < player_bullet[1].resized_width / 2 * player_bullet[1].resized_width / 3) {
                    if ((player_bullet[1].position_y + player_bullet[1].resized_height / 4 - enemy_bullet[5].position_y) * (player_bullet[1].position_y + player_bullet[1].resized_height / 4 - enemy_bullet[5].position_y) < player_bullet[1].resized_height / 2 * player_bullet[1].resized_height / 3) {
                        bullet[1] = 0;
                        player_bullet[1].position(10, 10);
                        player_bullet[1].setObstacleAlpha(0);
                        player_bullet[1].position_effect();

                        enemy_bullet[5].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[5].setObstacleAlpha(0);
                        enemy_bullet[5].position_effect();
                        enemy_shot[5] = 0;

                    }
                }
            }

            if (enemy_shot[5] == 1) {
                if ((player_bullet[2].position_x + player_bullet[2].resized_width / 4 - enemy_bullet[5].position_x) * (player_bullet[2].position_x + player_bullet[2].resized_width / 4 - enemy_bullet[5].position_x) < player_bullet[2].resized_width / 2 * player_bullet[2].resized_width / 3) {
                    if ((player_bullet[2].position_y + player_bullet[2].resized_height / 4 - enemy_bullet[5].position_y) * (player_bullet[2].position_y + player_bullet[2].resized_height / 4 - enemy_bullet[5].position_y) < player_bullet[2].resized_height / 2 * player_bullet[2].resized_height / 3) {
                        bullet[2] = 0;
                        player_bullet[2].position(10, 10);
                        player_bullet[2].setObstacleAlpha(0);
                        player_bullet[2].position_effect();

                        enemy_bullet[5].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[5].setObstacleAlpha(0);
                        enemy_bullet[5].position_effect();
                        enemy_shot[5] = 0;

                    }
                }
            }

            if (enemy_shot[6] == 1) {
                if ((player_bullet[0].position_x + player_bullet[0].resized_width / 4 - enemy_bullet[6].position_x) * (player_bullet[0].position_x + player_bullet[0].resized_width / 4 - enemy_bullet[6].position_x) < player_bullet[0].resized_width / 2 * player_bullet[0].resized_width / 3) {
                    if ((player_bullet[0].position_y + player_bullet[0].resized_height / 4 - enemy_bullet[6].position_y) * (player_bullet[0].position_y + player_bullet[0].resized_height / 4 - enemy_bullet[6].position_y) < player_bullet[0].resized_height / 2 * player_bullet[0].resized_height / 3) {
                        bullet[0] = 0;
                        player_bullet[0].position(10, 10);
                        player_bullet[0].setObstacleAlpha(0);
                        player_bullet[0].position_effect();

                        enemy_bullet[6].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[6].setObstacleAlpha(0);
                        enemy_bullet[6].position_effect();
                        enemy_shot[6] = 0;

                    }
                }
            }

            if (enemy_shot[6] == 1) {
                if ((player_bullet[1].position_x + player_bullet[1].resized_width / 4 - enemy_bullet[6].position_x) * (player_bullet[1].position_x + player_bullet[1].resized_width / 4 - enemy_bullet[6].position_x) < player_bullet[1].resized_width / 2 * player_bullet[1].resized_width / 3) {
                    if ((player_bullet[1].position_y + player_bullet[1].resized_height / 4 - enemy_bullet[6].position_y) * (player_bullet[1].position_y + player_bullet[1].resized_height / 4 - enemy_bullet[6].position_y) < player_bullet[1].resized_height / 2 * player_bullet[1].resized_height / 3) {
                        bullet[1] = 0;
                        player_bullet[1].position(10, 10);
                        player_bullet[1].setObstacleAlpha(0);
                        player_bullet[1].position_effect();

                        enemy_bullet[6].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[6].setObstacleAlpha(0);
                        enemy_bullet[6].position_effect();
                        enemy_shot[6] = 0;

                    }
                }
            }

            if (enemy_shot[6] == 1) {
                if ((player_bullet[2].position_x + player_bullet[2].resized_width / 4 - enemy_bullet[6].position_x) * (player_bullet[2].position_x + player_bullet[2].resized_width / 4 - enemy_bullet[6].position_x) < player_bullet[2].resized_width / 2 * player_bullet[2].resized_width / 3) {
                    if ((player_bullet[2].position_y + player_bullet[2].resized_height / 4 - enemy_bullet[6].position_y) * (player_bullet[2].position_y + player_bullet[2].resized_height / 4 - enemy_bullet[6].position_y) < player_bullet[2].resized_height / 2 * player_bullet[2].resized_height / 3) {
                        bullet[2] = 0;
                        player_bullet[2].position(10, 10);
                        player_bullet[2].setObstacleAlpha(0);
                        player_bullet[2].position_effect();

                        enemy_bullet[6].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[6].setObstacleAlpha(0);
                        enemy_bullet[6].position_effect();
                        enemy_shot[6] = 0;

                    }
                }
            }

            if (enemy_shot[7] == 1) {
                if ((player_bullet[0].position_x + player_bullet[0].resized_width / 4 - enemy_bullet[7].position_x) * (player_bullet[0].position_x + player_bullet[0].resized_width / 4 - enemy_bullet[7].position_x) < player_bullet[0].resized_width / 2 * player_bullet[0].resized_width / 3) {
                    if ((player_bullet[0].position_y + player_bullet[0].resized_height / 4 - enemy_bullet[7].position_y) * (player_bullet[0].position_y + player_bullet[0].resized_height / 4 - enemy_bullet[7].position_y) < player_bullet[0].resized_height / 2 * player_bullet[0].resized_height / 3) {
                        bullet[0] = 0;
                        player_bullet[0].position(10, 10);
                        player_bullet[0].setObstacleAlpha(0);
                        player_bullet[0].position_effect();

                        enemy_bullet[7].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[7].setObstacleAlpha(0);
                        enemy_bullet[7].position_effect();
                        enemy_shot[7] = 0;

                    }
                }
            }

            if (enemy_shot[7] == 1) {
                if ((player_bullet[1].position_x + player_bullet[1].resized_width / 4 - enemy_bullet[7].position_x) * (player_bullet[1].position_x + player_bullet[1].resized_width / 4 - enemy_bullet[7].position_x) < player_bullet[1].resized_width / 2 * player_bullet[1].resized_width / 3) {
                    if ((player_bullet[1].position_y + player_bullet[1].resized_height / 4 - enemy_bullet[7].position_y) * (player_bullet[1].position_y + player_bullet[1].resized_height / 4 - enemy_bullet[7].position_y) < player_bullet[1].resized_height / 2 * player_bullet[1].resized_height / 3) {
                        bullet[1] = 0;
                        player_bullet[1].position(10, 10);
                        player_bullet[1].setObstacleAlpha(0);
                        player_bullet[1].position_effect();

                        enemy_bullet[7].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[7].setObstacleAlpha(0);
                        enemy_bullet[7].position_effect();
                        enemy_shot[7] = 0;

                    }
                }
            }

            if (enemy_shot[7] == 1) {
                if ((player_bullet[2].position_x + player_bullet[2].resized_width / 4 - enemy_bullet[7].position_x) * (player_bullet[2].position_x + player_bullet[2].resized_width / 4 - enemy_bullet[7].position_x) < player_bullet[2].resized_width / 2 * player_bullet[2].resized_width / 3) {
                    if ((player_bullet[2].position_y + player_bullet[2].resized_height / 4 - enemy_bullet[7].position_y) * (player_bullet[2].position_y + player_bullet[2].resized_height / 4 - enemy_bullet[7].position_y) < player_bullet[2].resized_height / 2 * player_bullet[2].resized_height / 3) {
                        bullet[2] = 0;
                        player_bullet[2].position(10, 10);
                        player_bullet[2].setObstacleAlpha(0);
                        player_bullet[2].position_effect();

                        enemy_bullet[7].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[7].setObstacleAlpha(0);
                        enemy_bullet[7].position_effect();
                        enemy_shot[7] = 0;

                    }
                }
            }

            if (enemy_shot[8] == 1) {
                if ((player_bullet[0].position_x + player_bullet[0].resized_width / 4 - enemy_bullet[8].position_x) * (player_bullet[0].position_x + player_bullet[0].resized_width / 4 - enemy_bullet[8].position_x) < player_bullet[0].resized_width / 2 * player_bullet[0].resized_width / 3) {
                    if ((player_bullet[0].position_y + player_bullet[0].resized_height / 4 - enemy_bullet[8].position_y) * (player_bullet[0].position_y + player_bullet[0].resized_height / 4 - enemy_bullet[8].position_y) < player_bullet[0].resized_height / 2 * player_bullet[0].resized_height / 3) {
                        bullet[0] = 0;
                        player_bullet[0].position(10, 10);
                        player_bullet[0].setObstacleAlpha(0);
                        player_bullet[0].position_effect();

                        enemy_bullet[8].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[8].setObstacleAlpha(0);
                        enemy_bullet[8].position_effect();
                        enemy_shot[8] = 0;

                    }
                }
            }

            if (enemy_shot[8] == 1) {
                if ((player_bullet[1].position_x + player_bullet[1].resized_width / 4 - enemy_bullet[8].position_x) * (player_bullet[1].position_x + player_bullet[1].resized_width / 4 - enemy_bullet[8].position_x) < player_bullet[1].resized_width / 2 * player_bullet[1].resized_width / 3) {
                    if ((player_bullet[1].position_y + player_bullet[1].resized_height / 4 - enemy_bullet[8].position_y) * (player_bullet[1].position_y + player_bullet[1].resized_height / 4 - enemy_bullet[8].position_y) < player_bullet[1].resized_height / 2 * player_bullet[1].resized_height / 3) {
                        bullet[1] = 0;
                        player_bullet[1].position(10, 10);
                        player_bullet[1].setObstacleAlpha(0);
                        player_bullet[1].position_effect();

                        enemy_bullet[8].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[8].setObstacleAlpha(0);
                        enemy_bullet[8].position_effect();
                        enemy_shot[8] = 0;

                    }
                }
            }

            if (enemy_shot[8] == 1) {
                if ((player_bullet[2].position_x + player_bullet[2].resized_width / 4 - enemy_bullet[8].position_x) * (player_bullet[2].position_x + player_bullet[2].resized_width / 4 - enemy_bullet[8].position_x) < player_bullet[2].resized_width / 2 * player_bullet[2].resized_width / 3) {
                    if ((player_bullet[2].position_y + player_bullet[2].resized_height / 4 - enemy_bullet[8].position_y) * (player_bullet[2].position_y + player_bullet[2].resized_height / 4 - enemy_bullet[8].position_y) < player_bullet[2].resized_height / 2 * player_bullet[2].resized_height / 3) {
                        bullet[2] = 0;
                        player_bullet[2].position(10, 10);
                        player_bullet[2].setObstacleAlpha(0);
                        player_bullet[2].position_effect();

                        enemy_bullet[8].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[8].setObstacleAlpha(0);
                        enemy_bullet[8].position_effect();
                        enemy_shot[8] = 0;

                    }
                }
            }


            if (enemy_shot[9] == 1) {
                if ((player_bullet[0].position_x + player_bullet[0].resized_width / 4 - enemy_bullet[9].position_x) * (player_bullet[0].position_x + player_bullet[0].resized_width / 4 - enemy_bullet[9].position_x) < player_bullet[0].resized_width / 2 * player_bullet[0].resized_width / 3) {
                    if ((player_bullet[0].position_y + player_bullet[0].resized_height / 4 - enemy_bullet[9].position_y) * (player_bullet[0].position_y + player_bullet[0].resized_height / 4 - enemy_bullet[9].position_y) < player_bullet[0].resized_height / 2 * player_bullet[0].resized_height / 3) {
                        bullet[0] = 0;
                        player_bullet[0].position(10, 10);
                        player_bullet[0].setObstacleAlpha(0);
                        player_bullet[0].position_effect();

                        enemy_bullet[9].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[9].setObstacleAlpha(0);
                        enemy_bullet[9].position_effect();
                        enemy_shot[9] = 0;

                    }
                }
            }


            if (enemy_shot[9] == 1) {
                if ((player_bullet[1].position_x + player_bullet[1].resized_width / 4 - enemy_bullet[9].position_x) * (player_bullet[1].position_x + player_bullet[1].resized_width / 4 - enemy_bullet[9].position_x) < player_bullet[1].resized_width / 2 * player_bullet[1].resized_width / 3) {
                    if ((player_bullet[1].position_y + player_bullet[1].resized_height / 4 - enemy_bullet[9].position_y) * (player_bullet[1].position_y + player_bullet[1].resized_height / 4 - enemy_bullet[9].position_y) < player_bullet[1].resized_height / 2 * player_bullet[1].resized_height / 3) {
                        bullet[1] = 0;
                        player_bullet[1].position(10, 10);
                        player_bullet[1].setObstacleAlpha(0);
                        player_bullet[1].position_effect();

                        enemy_bullet[9].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[9].setObstacleAlpha(0);
                        enemy_bullet[9].position_effect();
                        enemy_shot[9] = 0;

                    }
                }
            }

            if (enemy_shot[9] == 1) {
                if ((player_bullet[2].position_x + player_bullet[2].resized_width / 4 - enemy_bullet[9].position_x) * (player_bullet[2].position_x + player_bullet[2].resized_width / 4 - enemy_bullet[9].position_x) < player_bullet[2].resized_width / 2 * player_bullet[2].resized_width / 3) {
                    if ((player_bullet[2].position_y + player_bullet[2].resized_height / 4 - enemy_bullet[9].position_y) * (player_bullet[2].position_y + player_bullet[2].resized_height / 4 - enemy_bullet[9].position_y) < player_bullet[2].resized_height / 2 * player_bullet[2].resized_height / 3) {
                        bullet[2] = 0;
                        player_bullet[2].position(10, 10);
                        player_bullet[2].setObstacleAlpha(0);
                        player_bullet[2].position_effect();

                        enemy_bullet[9].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[9].setObstacleAlpha(0);
                        enemy_bullet[9].position_effect();
                        enemy_shot[9] = 0;

                    }
                }
            }

            if (enemy_shot[10] == 1) {
                if ((player_bullet[0].position_x + player_bullet[0].resized_width / 4 - enemy_bullet[10].position_x) * (player_bullet[0].position_x + player_bullet[0].resized_width / 4 - enemy_bullet[10].position_x) < player_bullet[0].resized_width / 2 * player_bullet[0].resized_width / 3) {
                    if ((player_bullet[0].position_y + player_bullet[0].resized_height / 4 - enemy_bullet[10].position_y) * (player_bullet[0].position_y + player_bullet[0].resized_height / 4 - enemy_bullet[10].position_y) < player_bullet[0].resized_height / 2 * player_bullet[0].resized_height / 3) {
                        bullet[0] = 0;
                        player_bullet[0].position(10, 10);
                        player_bullet[0].setObstacleAlpha(0);
                        player_bullet[0].position_effect();

                        enemy_bullet[10].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[10].setObstacleAlpha(0);
                        enemy_bullet[10].position_effect();
                        enemy_shot[10] = 0;

                    }
                }
            }

            if (enemy_shot[10] == 1) {
                if ((player_bullet[1].position_x + player_bullet[1].resized_width / 4 - enemy_bullet[10].position_x) * (player_bullet[1].position_x + player_bullet[1].resized_width / 4 - enemy_bullet[10].position_x) < player_bullet[1].resized_width / 2 * player_bullet[1].resized_width / 3) {
                    if ((player_bullet[1].position_y + player_bullet[1].resized_height / 4 - enemy_bullet[10].position_y) * (player_bullet[1].position_y + player_bullet[1].resized_height / 4 - enemy_bullet[10].position_y) < player_bullet[1].resized_height / 2 * player_bullet[1].resized_height / 3) {
                        bullet[1] = 0;
                        player_bullet[1].position(10, 10);
                        player_bullet[1].setObstacleAlpha(0);
                        player_bullet[1].position_effect();

                        enemy_bullet[10].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[10].setObstacleAlpha(0);
                        enemy_bullet[10].position_effect();
                        enemy_shot[10] = 0;

                    }
                }
            }

            if (enemy_shot[10] == 1) {
                if ((player_bullet[2].position_x + player_bullet[2].resized_width / 4 - enemy_bullet[10].position_x) * (player_bullet[2].position_x + player_bullet[2].resized_width / 4 - enemy_bullet[10].position_x) < player_bullet[2].resized_width / 2 * player_bullet[2].resized_width / 3) {
                    if ((player_bullet[2].position_y + player_bullet[2].resized_height / 4 - enemy_bullet[10].position_y) * (player_bullet[2].position_y + player_bullet[2].resized_height / 4 - enemy_bullet[10].position_y) < player_bullet[2].resized_height / 2 * player_bullet[2].resized_height / 3) {
                        bullet[2] = 0;
                        player_bullet[2].position(10, 10);
                        player_bullet[2].setObstacleAlpha(0);
                        player_bullet[2].position_effect();

                        enemy_bullet[10].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[10].setObstacleAlpha(0);
                        enemy_bullet[10].position_effect();
                        enemy_shot[10] = 0;

                    }
                }
            }

            if (enemy_shot[11] == 1) {
                if ((player_bullet[0].position_x + player_bullet[0].resized_width / 4 - enemy_bullet[11].position_x) * (player_bullet[0].position_x + player_bullet[0].resized_width / 4 - enemy_bullet[11].position_x) < player_bullet[0].resized_width / 2 * player_bullet[0].resized_width / 3) {
                    if ((player_bullet[0].position_y + player_bullet[0].resized_height / 4 - enemy_bullet[11].position_y) * (player_bullet[0].position_y + player_bullet[0].resized_height / 4 - enemy_bullet[11].position_y) < player_bullet[0].resized_height / 2 * player_bullet[0].resized_height / 3) {
                        bullet[0] = 0;
                        player_bullet[0].position(10, 10);
                        player_bullet[0].setObstacleAlpha(0);
                        player_bullet[0].position_effect();

                        enemy_bullet[11].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[11].setObstacleAlpha(0);
                        enemy_bullet[11].position_effect();
                        enemy_shot[11] = 0;

                    }
                }
            }

            if (enemy_shot[11] == 1) {
                if ((player_bullet[1].position_x + player_bullet[1].resized_width / 4 - enemy_bullet[11].position_x) * (player_bullet[1].position_x + player_bullet[1].resized_width / 4 - enemy_bullet[11].position_x) < player_bullet[1].resized_width / 2 * player_bullet[1].resized_width / 3) {
                    if ((player_bullet[1].position_y + player_bullet[1].resized_height / 4 - enemy_bullet[11].position_y) * (player_bullet[1].position_y + player_bullet[1].resized_height / 4 - enemy_bullet[11].position_y) < player_bullet[1].resized_height / 2 * player_bullet[1].resized_height / 3) {
                        bullet[1] = 0;
                        player_bullet[1].position(10, 10);
                        player_bullet[1].setObstacleAlpha(0);
                        player_bullet[1].position_effect();

                        enemy_bullet[11].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[11].setObstacleAlpha(0);
                        enemy_bullet[11].position_effect();
                        enemy_shot[11] = 0;

                    }
                }
            }

            if (enemy_shot[11] == 1) {
                if ((player_bullet[2].position_x + player_bullet[2].resized_width / 4 - enemy_bullet[11].position_x) * (player_bullet[2].position_x + player_bullet[2].resized_width / 4 - enemy_bullet[11].position_x) < player_bullet[2].resized_width / 2 * player_bullet[2].resized_width / 3) {
                    if ((player_bullet[2].position_y + player_bullet[2].resized_height / 4 - enemy_bullet[11].position_y) * (player_bullet[2].position_y + player_bullet[2].resized_height / 4 - enemy_bullet[11].position_y) < player_bullet[2].resized_height / 2 * player_bullet[2].resized_height / 3) {
                        bullet[2] = 0;
                        player_bullet[2].position(10, 10);
                        player_bullet[2].setObstacleAlpha(0);
                        player_bullet[2].position_effect();

                        enemy_bullet[11].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[11].setObstacleAlpha(0);
                        enemy_bullet[11].position_effect();
                        enemy_shot[11] = 0;

                    }
                }
            }

            if (enemy_shot[12] == 1) {
                if ((player_bullet[0].position_x + player_bullet[0].resized_width / 4 - enemy_bullet[12].position_x) * (player_bullet[0].position_x + player_bullet[0].resized_width / 4 - enemy_bullet[12].position_x) < player_bullet[0].resized_width / 2 * player_bullet[0].resized_width / 3) {
                    if ((player_bullet[0].position_y + player_bullet[0].resized_height / 4 - enemy_bullet[12].position_y) * (player_bullet[0].position_y + player_bullet[0].resized_height / 4 - enemy_bullet[12].position_y) < player_bullet[0].resized_height / 2 * player_bullet[0].resized_height / 3) {
                        bullet[0] = 0;
                        player_bullet[0].position(10, 10);
                        player_bullet[0].setObstacleAlpha(0);
                        player_bullet[0].position_effect();

                        enemy_bullet[12].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[12].setObstacleAlpha(0);
                        enemy_bullet[12].position_effect();
                        enemy_shot[12] = 0;

                    }
                }
            }


            if (enemy_shot[12] == 1) {
                if ((player_bullet[1].position_x + player_bullet[1].resized_width / 4 - enemy_bullet[12].position_x) * (player_bullet[1].position_x + player_bullet[1].resized_width / 4 - enemy_bullet[12].position_x) < player_bullet[1].resized_width / 2 * player_bullet[1].resized_width / 3) {
                    if ((player_bullet[1].position_y + player_bullet[1].resized_height / 4 - enemy_bullet[12].position_y) * (player_bullet[1].position_y + player_bullet[1].resized_height / 4 - enemy_bullet[12].position_y) < player_bullet[1].resized_height / 2 * player_bullet[1].resized_height / 3) {
                        bullet[1] = 0;
                        player_bullet[1].position(10, 10);
                        player_bullet[1].setObstacleAlpha(0);
                        player_bullet[1].position_effect();

                        enemy_bullet[12].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[12].setObstacleAlpha(0);
                        enemy_bullet[12].position_effect();
                        enemy_shot[12] = 0;

                    }
                }
            }

            if (enemy_shot[12] == 1) {
                if ((player_bullet[2].position_x + player_bullet[2].resized_width / 4 - enemy_bullet[12].position_x) * (player_bullet[2].position_x + player_bullet[2].resized_width / 4 - enemy_bullet[12].position_x) < player_bullet[2].resized_width / 2 * player_bullet[2].resized_width / 3) {
                    if ((player_bullet[2].position_y + player_bullet[2].resized_height / 4 - enemy_bullet[12].position_y) * (player_bullet[2].position_y + player_bullet[2].resized_height / 4 - enemy_bullet[12].position_y) < player_bullet[2].resized_height / 2 * player_bullet[2].resized_height / 3) {
                        bullet[2] = 0;
                        player_bullet[2].position(10, 10);
                        player_bullet[2].setObstacleAlpha(0);
                        player_bullet[2].position_effect();

                        enemy_bullet[12].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[12].setObstacleAlpha(0);
                        enemy_bullet[12].position_effect();
                        enemy_shot[12] = 0;

                    }
                }
            }

            if (enemy_shot[13] == 1) {
                if ((player_bullet[0].position_x + player_bullet[0].resized_width / 4 - enemy_bullet[13].position_x) * (player_bullet[0].position_x + player_bullet[0].resized_width / 4 - enemy_bullet[13].position_x) < player_bullet[0].resized_width / 2 * player_bullet[0].resized_width / 3) {
                    if ((player_bullet[0].position_y + player_bullet[0].resized_height / 4 - enemy_bullet[13].position_y) * (player_bullet[0].position_y + player_bullet[0].resized_height / 4 - enemy_bullet[13].position_y) < player_bullet[0].resized_height / 2 * player_bullet[0].resized_height / 3) {
                        bullet[0] = 0;
                        player_bullet[0].position(10, 10);
                        player_bullet[0].setObstacleAlpha(0);
                        player_bullet[0].position_effect();

                        enemy_bullet[13].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[13].setObstacleAlpha(0);
                        enemy_bullet[13].position_effect();
                        enemy_shot[13] = 0;

                    }
                }
            }

            if (enemy_shot[13] == 1) {
                if ((player_bullet[1].position_x + player_bullet[1].resized_width / 4 - enemy_bullet[13].position_x) * (player_bullet[1].position_x + player_bullet[1].resized_width / 4 - enemy_bullet[13].position_x) < player_bullet[1].resized_width / 2 * player_bullet[1].resized_width / 3) {
                    if ((player_bullet[1].position_y + player_bullet[1].resized_height / 4 - enemy_bullet[13].position_y) * (player_bullet[1].position_y + player_bullet[1].resized_height / 4 - enemy_bullet[13].position_y) < player_bullet[1].resized_height / 2 * player_bullet[1].resized_height / 3) {
                        bullet[1] = 0;
                        player_bullet[1].position(10, 10);
                        player_bullet[1].setObstacleAlpha(0);
                        player_bullet[1].position_effect();

                        enemy_bullet[13].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[13].setObstacleAlpha(0);
                        enemy_bullet[13].position_effect();
                        enemy_shot[13] = 0;

                    }
                }
            }

            if (enemy_shot[13] == 1) {
                if ((player_bullet[2].position_x + player_bullet[2].resized_width / 4 - enemy_bullet[13].position_x) * (player_bullet[2].position_x + player_bullet[2].resized_width / 4 - enemy_bullet[13].position_x) < player_bullet[2].resized_width / 2 * player_bullet[2].resized_width / 3) {
                    if ((player_bullet[2].position_y + player_bullet[2].resized_height / 4 - enemy_bullet[13].position_y) * (player_bullet[2].position_y + player_bullet[2].resized_height / 4 - enemy_bullet[13].position_y) < player_bullet[2].resized_height / 2 * player_bullet[2].resized_height / 3) {
                        bullet[2] = 0;
                        player_bullet[2].position(10, 10);
                        player_bullet[2].setObstacleAlpha(0);
                        player_bullet[2].position_effect();

                        enemy_bullet[13].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[13].setObstacleAlpha(0);
                        enemy_bullet[13].position_effect();
                        enemy_shot[13] = 0;

                    }
                }
            }

            if (enemy_shot[14] == 1) {
                if ((player_bullet[0].position_x + player_bullet[0].resized_width / 4 - enemy_bullet[14].position_x) * (player_bullet[0].position_x + player_bullet[0].resized_width / 4 - enemy_bullet[14].position_x) < player_bullet[0].resized_width / 2 * player_bullet[0].resized_width / 3) {
                    if ((player_bullet[0].position_y + player_bullet[0].resized_height / 4 - enemy_bullet[14].position_y) * (player_bullet[0].position_y + player_bullet[0].resized_height / 4 - enemy_bullet[14].position_y) < player_bullet[0].resized_height / 2 * player_bullet[0].resized_height / 3) {
                        bullet[0] = 0;
                        player_bullet[0].position(10, 10);
                        player_bullet[0].setObstacleAlpha(0);
                        player_bullet[0].position_effect();

                        enemy_bullet[14].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[14].setObstacleAlpha(0);
                        enemy_bullet[14].position_effect();
                        enemy_shot[14] = 0;

                    }
                }
            }

            if (enemy_shot[14] == 1) {
                if ((player_bullet[1].position_x + player_bullet[1].resized_width / 4 - enemy_bullet[14].position_x) * (player_bullet[1].position_x + player_bullet[1].resized_width / 4 - enemy_bullet[14].position_x) < player_bullet[1].resized_width / 2 * player_bullet[1].resized_width / 3) {
                    if ((player_bullet[1].position_y + player_bullet[1].resized_height / 4 - enemy_bullet[14].position_y) * (player_bullet[1].position_y + player_bullet[1].resized_height / 4 - enemy_bullet[14].position_y) < player_bullet[1].resized_height / 2 * player_bullet[1].resized_height / 3) {
                        bullet[1] = 0;
                        player_bullet[1].position(10, 10);
                        player_bullet[1].setObstacleAlpha(0);
                        player_bullet[1].position_effect();

                        enemy_bullet[14].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[14].setObstacleAlpha(0);
                        enemy_bullet[14].position_effect();
                        enemy_shot[14] = 0;

                    }
                }
            }

            if (enemy_shot[14] == 1) {
                if ((player_bullet[2].position_x + player_bullet[2].resized_width / 4 - enemy_bullet[14].position_x) * (player_bullet[2].position_x + player_bullet[2].resized_width / 4 - enemy_bullet[14].position_x) < player_bullet[2].resized_width / 2 * player_bullet[2].resized_width / 3) {
                    if ((player_bullet[2].position_y + player_bullet[2].resized_height / 4 - enemy_bullet[14].position_y) * (player_bullet[2].position_y + player_bullet[2].resized_height / 4 - enemy_bullet[14].position_y) < player_bullet[2].resized_height / 2 * player_bullet[2].resized_height / 3) {
                        bullet[2] = 0;
                        player_bullet[2].position(10, 10);
                        player_bullet[2].setObstacleAlpha(0);
                        player_bullet[2].position_effect();

                        enemy_bullet[14].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[14].setObstacleAlpha(0);
                        enemy_bullet[14].position_effect();
                        enemy_shot[14] = 0;

                    }
                }
            }


            if (enemy_shot[15] == 1) {
                if ((player_bullet[0].position_x + player_bullet[0].resized_width / 4 - enemy_bullet[15].position_x) * (player_bullet[0].position_x + player_bullet[0].resized_width / 4 - enemy_bullet[15].position_x) < player_bullet[0].resized_width / 2 * player_bullet[0].resized_width / 3) {
                    if ((player_bullet[0].position_y + player_bullet[0].resized_height / 4 - enemy_bullet[15].position_y) * (player_bullet[0].position_y + player_bullet[0].resized_height / 4 - enemy_bullet[15].position_y) < player_bullet[0].resized_height / 2 * player_bullet[0].resized_height / 3) {
                        bullet[0] = 0;
                        player_bullet[0].position(10, 10);
                        player_bullet[0].setObstacleAlpha(0);
                        player_bullet[0].position_effect();

                        enemy_bullet[15].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[15].setObstacleAlpha(0);
                        enemy_bullet[15].position_effect();
                        enemy_shot[15] = 0;

                    }
                }
            }

            if (enemy_shot[15] == 1) {
                if ((player_bullet[1].position_x + player_bullet[1].resized_width / 4 - enemy_bullet[15].position_x) * (player_bullet[1].position_x + player_bullet[1].resized_width / 4 - enemy_bullet[15].position_x) < player_bullet[1].resized_width / 2 * player_bullet[1].resized_width / 3) {
                    if ((player_bullet[1].position_y + player_bullet[1].resized_height / 4 - enemy_bullet[15].position_y) * (player_bullet[1].position_y + player_bullet[1].resized_height / 4 - enemy_bullet[15].position_y) < player_bullet[1].resized_height / 2 * player_bullet[1].resized_height / 3) {
                        bullet[1] = 0;
                        player_bullet[1].position(10, 10);
                        player_bullet[1].setObstacleAlpha(0);
                        player_bullet[1].position_effect();

                        enemy_bullet[15].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[15].setObstacleAlpha(0);
                        enemy_bullet[15].position_effect();
                        enemy_shot[15] = 0;

                    }
                }
            }

            if (enemy_shot[15] == 1) {
                if ((player_bullet[2].position_x + player_bullet[2].resized_width / 4 - enemy_bullet[15].position_x) * (player_bullet[2].position_x + player_bullet[2].resized_width / 4 - enemy_bullet[15].position_x) < player_bullet[2].resized_width / 3 * player_bullet[2].resized_width / 2) {
                    if ((player_bullet[2].position_y + player_bullet[2].resized_height / 4 - enemy_bullet[15].position_y) * (player_bullet[2].position_y + player_bullet[2].resized_height / 4 - enemy_bullet[15].position_y) < player_bullet[2].resized_height / 2 * player_bullet[2].resized_height / 3) {
                        bullet[2] = 0;
                        player_bullet[2].position(10, 10);
                        player_bullet[2].setObstacleAlpha(0);
                        player_bullet[2].position_effect();

                        enemy_bullet[15].position((int) enemy_center.getX(), (int) enemy_center.getY());
                        enemy_bullet[15].setObstacleAlpha(0);
                        enemy_bullet[15].position_effect();
                        enemy_shot[15] = 0;

                    }
                }
            }
        }
    }

    public void enemy_bullet_moving() {

        /*
        if (enemy_shot[0] == 1) {
            if (enemy_bullet[0].position_x >= 400 * size_dm) {
                enemy_bullet[0].position((int) enemy_center.getX(), (int) enemy_center.getY());
                enemy_bullet[0].setObstacleAlpha(0);
                enemy_bullet[0].position_effect();
                enemy_shot[0] = 0;
            } else {
                enemy_bullet[0].setObstacleAlpha(200);
                enemy_bullet[0].setPosition(enemy_bullet1_SpeedX, enemy_bullet1_SpeedY);
            }

            enemy_bullet[0].setObstacleAlpha(200);
            enemy_bullet[0].setPosition(enemy_bullet1_SpeedX, enemy_bullet1_SpeedY);
        }
*/

        if (enemy_shot[1] == 1) {
            if (enemy_bullet[1].position_x >= 400 * size_dm) {
                enemy_bullet[1].position((int) enemy_center.getX(), (int) enemy_center.getY());
                enemy_bullet[1].setObstacleAlpha(0);
                enemy_bullet[1].position_effect();
                enemy_shot[1] = 0;
            } else {
                enemy_bullet[1].setObstacleAlpha(200);
                enemy_bullet[1].setPosition(enemy_bullet16_SpeedX, enemy_bullet16_SpeedY);
            }

        }

        if(enemy_shot[2] == 1)
        {
            if (enemy_bullet[2].position_x >= 400*size_dm) {
                enemy_bullet[2].position((int)enemy_center.getX(), (int)enemy_center.getY());
                enemy_bullet[2].setObstacleAlpha(0);
                enemy_bullet[2].position_effect();
                enemy_shot[2] = 0;
            }
            else {
                enemy_bullet[2].setObstacleAlpha(200);
                enemy_bullet[2].setPosition(enemy_bullet15_SpeedX, enemy_bullet15_SpeedY);
            }
        }

        if(enemy_shot[3] == 1)
        {
            if (enemy_bullet[3].position_x >= 400*size_dm) {
                enemy_bullet[3].position((int)enemy_center.getX(), (int)enemy_center.getY());
                enemy_bullet[3].setObstacleAlpha(0);
                enemy_bullet[3].position_effect();
                enemy_shot[3] = 0;
            }
            else {
                enemy_bullet[3].setObstacleAlpha(200);
                enemy_bullet[3].setPosition(enemy_bullet14_SpeedX, enemy_bullet14_SpeedY);
            }
        }

        if(enemy_shot[4] == 1)
        {
            if (enemy_bullet[4].position_y >= 500*size_dm) {
                enemy_bullet[4].position((int)enemy_center.getX(), (int)enemy_center.getY());
                enemy_bullet[4].setObstacleAlpha(0);
                enemy_bullet[4].position_effect();
                enemy_shot[4] = 0;
            }
            else {
                enemy_bullet[4].setObstacleAlpha(200);
                enemy_bullet[4].setPosition(enemy_bullet13_SpeedX, enemy_bullet13_SpeedY);
            }
        }

        if(enemy_shot[5] == 1)
        {
            if (enemy_bullet[5].position_x <= 5*size_dm) {
                enemy_bullet[5].position((int)enemy_center.getX(), (int)enemy_center.getY());
                enemy_bullet[5].setObstacleAlpha(0);
                enemy_bullet[5].position_effect();
                enemy_shot[5] = 0;
            }
            else {
                enemy_bullet[5].setObstacleAlpha(200);
                enemy_bullet[5].setPosition(enemy_bullet12_SpeedX, enemy_bullet12_SpeedY);
            }
        }

        if(enemy_shot[6] == 1)
        {
            if (enemy_bullet[6].position_x <= 5*size_dm) {
                enemy_bullet[6].position((int)enemy_center.getX(), (int)enemy_center.getY());
                enemy_bullet[6].setObstacleAlpha(0);
                enemy_bullet[6].position_effect();
                enemy_shot[6] = 0;
            }
            else {
                enemy_bullet[6].setObstacleAlpha(200);
                enemy_bullet[6].setPosition(enemy_bullet11_SpeedX, enemy_bullet11_SpeedY);
            }
        }

        if(enemy_shot[7] == 1)
        {
            if (enemy_bullet[7].position_x <= 5*size_dm) {
                enemy_bullet[7].position((int)enemy_center.getX(), (int)enemy_center.getY());
                enemy_bullet[7].setObstacleAlpha(0);
                enemy_bullet[7].position_effect();
                enemy_shot[7] = 0;
            }
            else {
                enemy_bullet[7].setObstacleAlpha(200);
                enemy_bullet[7].setPosition(enemy_bullet10_SpeedX, enemy_bullet10_SpeedY);
            }
        }

        if(enemy_shot[8] == 1)
        {
            if (enemy_bullet[8].position_x <= 5*size_dm) {
                enemy_bullet[8].position((int)enemy_center.getX(), (int)enemy_center.getY());
                enemy_bullet[8].setObstacleAlpha(0);
                enemy_bullet[8].position_effect();
                enemy_shot[8] = 0;
            }
            else {
                enemy_bullet[8].setObstacleAlpha(200);
                enemy_bullet[8].setPosition(enemy_bullet9_SpeedX, enemy_bullet9_SpeedY);
            }
        }

        if(enemy_shot[9] == 1)
        {
            if (enemy_bullet[9].position_x <= 5*size_dm) {
                enemy_bullet[9].position((int)enemy_center.getX(), (int)enemy_center.getY());
                enemy_bullet[9].setObstacleAlpha(0);
                enemy_bullet[9].position_effect();
                enemy_shot[9] = 0;
            }
            else {
                enemy_bullet[9].setObstacleAlpha(200);
                enemy_bullet[9].setPosition(enemy_bullet8_SpeedX, enemy_bullet8_SpeedY);
            }
        }

        if(enemy_shot[10] == 1)
        {
            if (enemy_bullet[10].position_x <= 5*size_dm) {
                enemy_bullet[10].position((int)enemy_center.getX(), (int)enemy_center.getY());
                enemy_bullet[10].setObstacleAlpha(0);
                enemy_bullet[10].position_effect();
                enemy_shot[10] = 0;
            }
            else {
                enemy_bullet[10].setObstacleAlpha(200);
                enemy_bullet[10].setPosition(enemy_bullet7_SpeedX, enemy_bullet7_SpeedY);
            }
        }

        if(enemy_shot[11] == 1)
        {
            if (enemy_bullet[11].position_x <= 5*size_dm) {
                enemy_bullet[11].position((int)enemy_center.getX(), (int)enemy_center.getY());
                enemy_bullet[11].setObstacleAlpha(0);
                enemy_bullet[11].position_effect();
                enemy_shot[11] = 0;
            }
            else {
                enemy_bullet[11].setObstacleAlpha(200);
                enemy_bullet[11].setPosition(enemy_bullet6_SpeedX, enemy_bullet6_SpeedY);
            }
        }

        if(enemy_shot[12] == 1)
        {
            if (enemy_bullet[12].position_y <= 5*size_dm) {
                enemy_bullet[12].position((int)enemy_center.getX(), (int)enemy_center.getY());
                enemy_bullet[12].setObstacleAlpha(0);
                enemy_bullet[12].position_effect();
                enemy_shot[12] = 0;
            }
            else {
                    enemy_bullet[12].setObstacleAlpha(200);
                    enemy_bullet[12].setPosition(enemy_bullet5_SpeedX, enemy_bullet5_SpeedY);
            }
        }

        if(enemy_shot[13] == 1)
        {
            if (enemy_bullet[13].position_x >= 400*size_dm) {
                enemy_bullet[13].position((int)enemy_center.getX(), (int)enemy_center.getY());
                enemy_bullet[13].setObstacleAlpha(0);
                enemy_bullet[13].position_effect();
                enemy_shot[13] = 0;
            }else {

                    enemy_bullet[13].setObstacleAlpha(200);
                    enemy_bullet[13].setPosition(enemy_bullet4_SpeedX, enemy_bullet4_SpeedY);

            }
        }

        if(enemy_shot[14] == 1)
        {
            if (enemy_bullet[14].position_x >= 400*size_dm) {
                enemy_bullet[14].position((int)enemy_center.getX(), (int)enemy_center.getY());
                enemy_bullet[14].setObstacleAlpha(0);
                enemy_bullet[14].position_effect();
                enemy_shot[14] = 0;
            }
            else {
                    enemy_bullet[14].setObstacleAlpha(200);
                    enemy_bullet[14].setPosition(enemy_bullet3_SpeedX, enemy_bullet3_SpeedY);

            }
        }

        if(enemy_shot[15] == 1)
        {
            if (enemy_bullet[15].position_x >= 400*size_dm) {
                enemy_bullet[15].position((int)enemy_center.getX(), (int)enemy_center.getY());
                enemy_bullet[15].setObstacleAlpha(0);
                enemy_bullet[15].position_effect();
                enemy_shot[15] = 0;
            }
            else {
                    enemy_bullet[15].setObstacleAlpha(200);
                    enemy_bullet[15].setPosition(enemy_bullet2_SpeedX, enemy_bullet2_SpeedY);

            }
        }
    }

    void blackhall_attack1() {

        enemy_center.setScaleX(3);
        enemy_center.setScaleY(3);

        for (int i = 0; i < 16; i++) {
            enemy_shot[i] = 0;
        }

        shot_enemy6();

        if(enemy_shot[0] == 1)
        {
            player.setX(player.getX()-enemy_bullet1_SpeedX);

        }else if(enemy_shot[1] == 1)
        {
            player.setX(player.getX()-enemy_bullet16_SpeedX);
            player.setY(player.getY()-enemy_bullet16_SpeedY);
        }else if(enemy_shot[2] == 1)
        {
            player.setX(player.getX()-enemy_bullet15_SpeedX);
            player.setY(player.getY()-enemy_bullet15_SpeedY);
        }else if(enemy_shot[3] == 1)
        {
            player.setX(player.getX()-enemy_bullet14_SpeedX);
            player.setY(player.getY()-enemy_bullet14_SpeedY);
        }else if(enemy_shot[4] == 1)
        {
            player.setX(player.getX()-enemy_bullet13_SpeedX);
            player.setY(player.getY()-enemy_bullet13_SpeedY);
        }else if(enemy_shot[5] == 1)
        {
            player.setX(player.getX()-enemy_bullet12_SpeedX);
            player.setY(player.getY()-enemy_bullet12_SpeedY);
        }else if(enemy_shot[6] == 1)
        {
            player.setX(player.getX()-enemy_bullet11_SpeedX);
            player.setY(player.getY()-enemy_bullet11_SpeedY);
        }else if(enemy_shot[7] == 1)
        {
            player.setX(player.getX()-enemy_bullet10_SpeedX);
            player.setY(player.getY()-enemy_bullet10_SpeedY);
        }else if(enemy_shot[8] == 1)
        {
            player.setX(player.getX()-enemy_bullet9_SpeedX);
            player.setY(player.getY()-enemy_bullet9_SpeedY);
        }else if(enemy_shot[9] == 1)
        {
            player.setX(player.getX()-enemy_bullet8_SpeedX);
            player.setY(player.getY()-enemy_bullet8_SpeedY);
        }else if(enemy_shot[10] == 1)
        {
            player.setX(player.getX()-enemy_bullet7_SpeedX);
            player.setY(player.getY()-enemy_bullet7_SpeedY);
        }else if(enemy_shot[11] == 1)
        {
            player.setX(player.getX()-enemy_bullet6_SpeedX);
            player.setY(player.getY()-enemy_bullet6_SpeedY);
        }else if(enemy_shot[12] == 1)
        {
            player.setX(player.getX()-enemy_bullet5_SpeedX);
            player.setY(player.getY()-enemy_bullet5_SpeedY);
        }else if(enemy_shot[13] == 1)
        {
            player.setX(player.getX()-enemy_bullet4_SpeedX);
            player.setY(player.getY()-enemy_bullet4_SpeedY);
        }else if(enemy_shot[14] == 1)
        {
            player.setX(player.getX()-enemy_bullet3_SpeedX);
            player.setY(player.getY()-enemy_bullet3_SpeedY);
        }else if(enemy_shot[15] == 1)
        {
            player.setX(player.getX()-enemy_bullet2_SpeedX);
            player.setY(player.getY()-enemy_bullet2_SpeedY);
        }

    }

    void enemy_attack2()
    {

        if(initialize_enemy_attack2 == false) {

            for (int i = 0; i < 64; i++) {
                pattern[i] = 0;
            }

            for (int i = 0; i < 64; i++) {
                effect[i].setObstacleAlpha(0);
                effect[i].position_effect();
            }

            for (int i = 0; i < 4; i++) {
                obstacle[i].position(120 * size_dm, 125 * size_dm);
                obstacle[i].setObstacleAlpha(0);
                obstacle[i].position_effect();
            }

            for (int i = 0; i < 4; i++) {
                obstacle_1[i].position(107 * size_dm, 138 * size_dm);
                obstacle_1[i].setObstacleAlpha(0);
                obstacle_1[i].position_effect();
            }

            for (int i = 0; i < 4; i++) {
                obstacle_2[i].position(94 * size_dm, 151 * size_dm);
                obstacle_2[i].setObstacleAlpha(0);
                obstacle_2[i].position_effect();
            }

            for (int i = 0; i < 4; i++) {
                obstacle_3[i].position(81 * size_dm, 164 * size_dm);
                obstacle_3[i].setObstacleAlpha(0);
                obstacle_3[i].position_effect();
            }

            for (int i = 0; i < 4; i++) {
                obstacle_4[i].position(68 * size_dm, 177 * size_dm);
                obstacle_4[i].setObstacleAlpha(0);
                obstacle_4[i].position_effect();
            }

            for (int i = 0; i < 4; i++) {
                obstacle_5[i].position(55 * size_dm, 190 * size_dm);
                obstacle_5[i].setObstacleAlpha(0);
                obstacle_5[i].position_effect();
            }

            for (int i = 0; i < 4; i++) {
                obstacle_6[i].position(42 * size_dm, 203 * size_dm);
                obstacle_6[i].setObstacleAlpha(0);
                obstacle_6[i].position_effect();
            }

            for (int i = 0; i < 4; i++) {
                obstacle_7[i].position(29 * size_dm, 216 * size_dm);
                obstacle_7[i].setObstacleAlpha(0);
                obstacle_7[i].position_effect();
            }

            for (int i = 0; i < 4; i++) {
                r_obstacle[i].position(189 * size_dm, 125 * size_dm);
                r_obstacle[i].setObstacleAlpha(0);
                r_obstacle[i].position_effect();
            }

            for (int i = 0; i < 4; i++) {
                r_obstacle_1[i].position(202 * size_dm, 138 * size_dm);
                r_obstacle_1[i].setObstacleAlpha(0);
                r_obstacle_1[i].position_effect();
            }

            for (int i = 0; i < 4; i++) {
                r_obstacle_2[i].position(215 * size_dm, 151 * size_dm);
                r_obstacle_2[i].setObstacleAlpha(0);
                r_obstacle_2[i].position_effect();
            }

            for (int i = 0; i < 4; i++) {
                r_obstacle_3[i].position(228 * size_dm, 164 * size_dm);
                r_obstacle_3[i].setObstacleAlpha(0);
                r_obstacle_3[i].position_effect();
            }

            for (int i = 0; i < 4; i++) {
                r_obstacle_4[i].position(241 * size_dm, 177 * size_dm);
                r_obstacle_4[i].setObstacleAlpha(0);
                r_obstacle_4[i].position_effect();
            }

            for (int i = 0; i < 4; i++) {
                r_obstacle_5[i].position(254 * size_dm, 190 * size_dm);
                r_obstacle_5[i].setObstacleAlpha(0);
                r_obstacle_5[i].position_effect();
            }

            for (int i = 0; i < 4; i++) {
                r_obstacle_6[i].position(267 * size_dm, 203 * size_dm);
                r_obstacle_6[i].setObstacleAlpha(0);
                r_obstacle_6[i].position_effect();
            }

            for (int i = 0; i < 4; i++) {
                r_obstacle_7[i].position(280 * size_dm, 216 * size_dm);
                r_obstacle_7[i].setObstacleAlpha(0);
                r_obstacle_7[i].position_effect();
            }


            initialize_enemy_attack2 = true;

        }


        if(action_flag1_count == 0 && enemy_maximum_energy2 > 5*size_dm && enemy_action_flag2 == false && action_flag1_count2 != 0 )
        {

            enemy_bullet_moving();

            if(action_flag1_count2 < 101)
            {

            }
            else {


                if (pattern[0] == 1) {
                    if (obstacle[0].position_x >= 250 * size_dm) {
                        obstacle[0].position(120 * size_dm, 125 * size_dm);
                        obstacle[0].setObstacleAlpha(200);
                    } else {
                        if (obstacle[0].position_x <= 136 * size_dm && obstacle[0].position_x >= 0) {
                            obstacle[0].setObstacleAlpha(200);
                            obstacle[0].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[0].position(156 * size_dm, 164 * size_dm);
                                effect[0].setObstacleAlpha(200);
                                effect[0].position_effect();
                            } else {
                                effect[0].setObstacleAlpha(0);
                                effect[0].position_effect();
                            }
                        } else if (obstacle[0].position_x >= 157 * size_dm && obstacle[0].position_x <= 208 * size_dm) {

                            if (obstacle[0].position_x >= 157 * size_dm && obstacle[0].position_x <= 185 * size_dm) {
                                obstacle[0].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            } else if (obstacle[0].position_x > 185 * size_dm && obstacle[0].position_x <= 208 * size_dm) {
                                obstacle[0].setPosition(Obstacle_Part1_SpeedX, 3);
                            }

                            if (obstacle[0].position_x <= 188 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[0].position(208 * size_dm, 216 * size_dm);
                                    effect[0].setObstacleAlpha(200);
                                    effect[0].position_effect();
                                } else {

                                    effect[0].setObstacleAlpha(0);
                                    effect[0].position_effect();

                                }
                            } else {
                                effect[0].setObstacleAlpha(0);
                                effect[0].position_effect();
                            }
                        } else if (obstacle[0].position_x > 208 * size_dm) {
                            obstacle[0].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            effect[0].setObstacleAlpha(0);
                            effect[0].position_effect();
                        } else {
                            obstacle[0].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            effect[0].setObstacleAlpha(0);
                            effect[0].position_effect();
                        }
                    }
                }
                /////////////////////////////////////////////////////////////////////////////////////////

                if (pattern[1] == 1) {
                    if (obstacle[1].position_x >= 250 * size_dm) {
                        obstacle[1].position(120 * size_dm, 125 * size_dm);
                        obstacle[1].setObstacleAlpha(200);
                    } else {
                        if (obstacle[1].position_x <= 149 * size_dm && obstacle[1].position_x >= 0) {
                            obstacle[1].setObstacleAlpha(200);
                            obstacle[1].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[1].position(169 * size_dm, 177 * size_dm);
                                effect[1].setObstacleAlpha(200);
                                effect[1].position_effect();
                            } else {
                                effect[1].setObstacleAlpha(0);
                                effect[1].position_effect();
                            }
                        } else if (obstacle[1].position_x >= 169 * size_dm && obstacle[1].position_x <= 221 * size_dm) {

                            if (obstacle[1].position_x >= 169 * size_dm && obstacle[1].position_x <= 197 * size_dm) {
                                obstacle[1].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            } else if (obstacle[1].position_x > 197 * size_dm && obstacle[1].position_x <= 221 * size_dm) {
                                obstacle[1].setPosition(Obstacle_Part1_SpeedX, 3);
                            }

                            if (obstacle[1].position_x <= 201 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[1].position(221 * size_dm, 229 * size_dm);
                                    effect[1].setObstacleAlpha(200);
                                    effect[1].position_effect();
                                } else {

                                    effect[1].setObstacleAlpha(0);
                                    effect[1].position_effect();

                                }
                            } else {
                                effect[1].setObstacleAlpha(0);
                                effect[1].position_effect();
                            }
                        } else if (obstacle[1].position_x > 221 * size_dm) {
                            obstacle[1].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            effect[1].setObstacleAlpha(0);
                            effect[1].position_effect();
                        } else {
                            obstacle[1].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            effect[1].setObstacleAlpha(0);
                            effect[1].position_effect();
                        }
                    }
                }
                ////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[2] == 1) {
                    if (obstacle[2].position_x >= 250 * size_dm) {
                        obstacle[2].position(120 * size_dm, 125 * size_dm);
                        obstacle[2].setObstacleAlpha(200);
                    } else {
                        if (obstacle[2].position_x <= 162 * size_dm && obstacle[2].position_x >= 0) {
                            obstacle[2].setObstacleAlpha(200);
                            obstacle[2].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[2].position(182 * size_dm, 190 * size_dm);
                                effect[2].setObstacleAlpha(200);
                                effect[2].position_effect();
                            } else {
                                effect[2].setObstacleAlpha(0);
                                effect[2].position_effect();
                            }
                        } else if (obstacle[2].position_x >= 182 * size_dm && obstacle[2].position_x <= 234 * size_dm) {

                            if (obstacle[2].position_x >= 182 * size_dm && obstacle[2].position_x <= 210 * size_dm) {
                                obstacle[2].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            } else if (obstacle[2].position_x > 210 * size_dm && obstacle[2].position_x <= 234 * size_dm) {
                                obstacle[2].setPosition(Obstacle_Part1_SpeedX, 3);
                            }

                            if (obstacle[2].position_x <= 214 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[2].position(234 * size_dm, 242 * size_dm);
                                    effect[2].setObstacleAlpha(200);
                                    effect[2].position_effect();
                                } else {

                                    effect[2].setObstacleAlpha(0);
                                    effect[2].position_effect();

                                }
                            } else {
                                effect[2].setObstacleAlpha(0);
                                effect[2].position_effect();
                            }
                        } else if (obstacle[2].position_x > 234 * size_dm) {
                            obstacle[2].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            effect[2].setObstacleAlpha(0);
                            effect[2].position_effect();
                        } else {
                            obstacle[2].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            effect[2].setObstacleAlpha(0);
                            effect[2].position_effect();
                        }
                    }
                }
                ///////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[3] == 1) {
                    if (obstacle[3].position_x >= 250 * size_dm) {
                        obstacle[3].position(120 * size_dm, 125 * size_dm);
                        obstacle[3].setObstacleAlpha(200);
                    } else {
                        if (obstacle[3].position_x <= 175 * size_dm && obstacle[3].position_x >= 0) {
                            obstacle[3].setObstacleAlpha(200);
                            obstacle[3].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[3].position(195 * size_dm, 203 * size_dm);
                                effect[3].setObstacleAlpha(200);
                                effect[3].position_effect();
                            } else {
                                effect[3].setObstacleAlpha(0);
                                effect[3].position_effect();
                            }
                        } else if (obstacle[3].position_x >= 195 * size_dm && obstacle[3].position_x <= 247 * size_dm) {

                            if (obstacle[3].position_x >= 195 * size_dm && obstacle[3].position_x <= 223 * size_dm) {
                                obstacle[3].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            } else if (obstacle[3].position_x > 223 * size_dm && obstacle[3].position_x <= 247 * size_dm) {
                                obstacle[3].setPosition(Obstacle_Part1_SpeedX, 3);
                            }

                            if (obstacle[3].position_x <= 227 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[3].position(247 * size_dm, 255 * size_dm);
                                    effect[3].setObstacleAlpha(200);
                                    effect[3].position_effect();
                                } else {

                                    effect[3].setObstacleAlpha(0);
                                    effect[3].position_effect();

                                }
                            } else {
                                effect[3].setObstacleAlpha(0);
                                effect[3].position_effect();
                            }
                        } else if (obstacle[3].position_x > 247 * size_dm) {
                            obstacle[3].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            effect[3].setObstacleAlpha(0);
                            effect[3].position_effect();
                        } else {
                            obstacle[3].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            effect[3].setObstacleAlpha(0);
                            effect[3].position_effect();
                        }
                    }
                }
                /////////////////////////////////////////////////////////////////////////////////////////////////////

                if (pattern[4] == 1) {
                    if (obstacle_1[0].position_x >= 250 * size_dm) {
                        obstacle_1[0].position(107 * size_dm, 138 * size_dm);
                        obstacle_1[0].setObstacleAlpha(200);
                    } else {
                        if (obstacle_1[0].position_x <= 123 * size_dm && obstacle_1[0].position_x >= 0) {
                            obstacle_1[0].setObstacleAlpha(200);
                            obstacle_1[0].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[4].position(143 * size_dm, 177 * size_dm);
                                effect[4].setObstacleAlpha(200);
                                effect[4].position_effect();
                            } else {
                                effect[4].setObstacleAlpha(0);
                                effect[4].position_effect();
                            }
                        } else if (obstacle_1[0].position_x >= 143 * size_dm && obstacle_1[0].position_x <= 195 * size_dm) {

                            if (obstacle_1[0].position_x >= 143 * size_dm && obstacle_1[0].position_x <= 171 * size_dm) {
                                obstacle_1[0].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            } else if (obstacle_1[0].position_x > 171 * size_dm && obstacle_1[0].position_x <= 195 * size_dm) {
                                obstacle_1[0].setPosition(Obstacle_Part1_SpeedX, 3);
                            }

                            if (obstacle_1[0].position_x <= 175 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[4].position(195 * size_dm, 203 * size_dm);
                                    effect[4].setObstacleAlpha(200);
                                    effect[4].position_effect();
                                } else {

                                    effect[4].setObstacleAlpha(0);
                                    effect[4].position_effect();

                                }
                            } else {
                                effect[4].setObstacleAlpha(0);
                                effect[4].position_effect();
                            }
                        } else if (obstacle_1[0].position_x > 195 * size_dm) {
                            obstacle_1[0].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            effect[4].setObstacleAlpha(0);
                            effect[4].position_effect();
                        } else {
                            obstacle_1[0].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            effect[4].setObstacleAlpha(0);
                            effect[4].position_effect();
                        }
                    }
                }
                //////////////////////////////////////////////////////////////////////////////////////////
                /*
                if (pattern[5] == 1) {
                    if (obstacle_1[1].position_x >= 250 * size_dm) {
                        obstacle_1[1].position(107 * size_dm, 138 * size_dm);
                        obstacle_1[1].setObstacleAlpha(200);
                    } else {
                        if (obstacle_1[1].position_x <= 136 * size_dm && obstacle_1[1].position_x >= 0) {
                            obstacle_1[1].setObstacleAlpha(200);
                            obstacle_1[1].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[5].position(156 * size_dm, 190 * size_dm);
                                effect[5].setObstacleAlpha(200);
                                effect[5].position_effect();
                            } else {
                                effect[5].setObstacleAlpha(0);
                                effect[5].position_effect();
                            }
                        } else if (obstacle_1[1].position_x >= 156 * size_dm && obstacle_1[1].position_x <= 208 * size_dm) {

                            if (obstacle_1[1].position_x >= 156 * size_dm && obstacle_1[1].position_x <= 184 * size_dm) {
                                obstacle_1[1].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            } else if (obstacle_1[1].position_x > 184 * size_dm && obstacle_1[1].position_x <= 208 * size_dm) {
                                obstacle_1[1].setPosition(Obstacle_Part1_SpeedX, 3);
                            }

                            if (obstacle_1[1].position_x <= 188 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[5].position(208 * size_dm, 242 * size_dm);
                                    effect[5].setObstacleAlpha(200);
                                    effect[5].position_effect();
                                } else {

                                    effect[5].setObstacleAlpha(0);
                                    effect[5].position_effect();

                                }
                            } else {
                                effect[5].setObstacleAlpha(0);
                                effect[5].position_effect();
                            }
                        } else if (obstacle_1[1].position_x > 208 * size_dm) {
                            obstacle_1[1].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            effect[5].setObstacleAlpha(0);
                            effect[5].position_effect();
                        } else {
                            obstacle_1[1].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            effect[5].setObstacleAlpha(0);
                            effect[5].position_effect();
                        }
                    }
                }
                */
                //////////////////////////////////////////////////////////////////////////////////////////////////////

                if (pattern[6] == 1) {
                    if (obstacle_1[2].position_x >= 250 * size_dm) {
                        obstacle_1[2].position(107 * size_dm, 138 * size_dm);
                        obstacle_1[2].setObstacleAlpha(200);
                    } else {
                        if (obstacle_1[2].position_x <= 149 * size_dm && obstacle_1[2].position_x >= 0) {
                            obstacle_1[2].setObstacleAlpha(200);
                            obstacle_1[2].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[6].position(169 * size_dm, 203 * size_dm);
                                effect[6].setObstacleAlpha(200);
                                effect[6].position_effect();
                            } else {
                                effect[6].setObstacleAlpha(0);
                                effect[6].position_effect();
                            }
                        } else if (obstacle_1[2].position_x >= 169 * size_dm && obstacle_1[2].position_x <= 221 * size_dm) {

                            if (obstacle_1[2].position_x >= 169 * size_dm && obstacle_1[2].position_x <= 197 * size_dm) {
                                obstacle_1[2].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            } else if (obstacle_1[2].position_x > 197 * size_dm && obstacle_1[2].position_x <= 221 * size_dm) {
                                obstacle_1[2].setPosition(Obstacle_Part1_SpeedX, 3);
                            }

                            if (obstacle_1[2].position_x <= 201 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[6].position(221 * size_dm, 255 * size_dm);
                                    effect[6].setObstacleAlpha(200);
                                    effect[6].position_effect();
                                } else {

                                    effect[6].setObstacleAlpha(0);
                                    effect[6].position_effect();

                                }
                            } else {
                                effect[6].setObstacleAlpha(0);
                                effect[6].position_effect();
                            }
                        } else if (obstacle_1[2].position_x > 221 * size_dm) {
                            obstacle_1[2].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            effect[6].setObstacleAlpha(0);
                            effect[6].position_effect();
                        } else {
                            obstacle_1[2].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            effect[6].setObstacleAlpha(0);
                            effect[6].position_effect();
                        }
                    }
                }
                ////////////////////////////////////////////////////////////////////////////////////////////////

                if (pattern[7] == 1) {
                    if (obstacle_1[3].position_x >= 250 * size_dm) {
                        obstacle_1[3].position(107 * size_dm, 138 * size_dm);
                        obstacle_1[3].setObstacleAlpha(200);
                    } else {
                        if (obstacle_1[3].position_x <= 162 * size_dm && obstacle_1[3].position_x >= 0) {
                            obstacle_1[3].setObstacleAlpha(200);
                            obstacle_1[3].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[7].position(182 * size_dm, 216 * size_dm);
                                effect[7].setObstacleAlpha(200);
                                effect[7].position_effect();
                            } else {
                                effect[7].setObstacleAlpha(0);
                                effect[7].position_effect();
                            }
                        } else if (obstacle_1[3].position_x >= 182 * size_dm && obstacle_1[3].position_x <= 234 * size_dm) {

                            if (obstacle_1[3].position_x >= 182 * size_dm && obstacle_1[3].position_x <= 210 * size_dm) {
                                obstacle_1[3].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            } else if (obstacle_1[3].position_x > 210 * size_dm && obstacle_1[3].position_x <= 234 * size_dm) {
                                obstacle_1[3].setPosition(Obstacle_Part1_SpeedX, 3);
                            }

                            if (obstacle_1[3].position_x <= 214 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[7].position(234 * size_dm, 268 * size_dm);
                                    effect[7].setObstacleAlpha(200);
                                    effect[7].position_effect();
                                } else {

                                    effect[7].setObstacleAlpha(0);
                                    effect[7].position_effect();

                                }
                            } else {
                                effect[7].setObstacleAlpha(0);
                                effect[7].position_effect();
                            }
                        } else if (obstacle_1[3].position_x > 234 * size_dm) {
                            obstacle_1[3].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            effect[7].setObstacleAlpha(0);
                            effect[7].position_effect();
                        } else {
                            obstacle_1[3].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            effect[7].setObstacleAlpha(0);
                            effect[7].position_effect();
                        }
                    }
                }
                /////////////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[8] == 1) {
                    if (obstacle_2[0].position_x >= 250 * size_dm) {
                        obstacle_2[0].position(94 * size_dm, 151 * size_dm);
                        obstacle_2[0].setObstacleAlpha(200);
                    } else {
                        if (obstacle_2[0].position_x <= 120 * size_dm && obstacle_2[0].position_x >= 0) {
                            obstacle_2[0].setObstacleAlpha(200);
                            obstacle_2[0].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[8].position(130 * size_dm, 190 * size_dm);
                                effect[8].setObstacleAlpha(200);
                                effect[8].position_effect();
                            } else {
                                effect[8].setObstacleAlpha(0);
                                effect[8].position_effect();
                            }
                        } else if (obstacle_2[0].position_x >= 130 * size_dm && obstacle_2[0].position_x <= 182 * size_dm) {

                            if (obstacle_2[0].position_x >= 130 * size_dm && obstacle_2[0].position_x <= 158 * size_dm) {
                                obstacle_2[0].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            } else if (obstacle_2[0].position_x > 158 * size_dm && obstacle_2[0].position_x <= 182 * size_dm) {
                                obstacle_2[0].setPosition(Obstacle_Part1_SpeedX, 3);
                            }

                            if (obstacle_2[0].position_x <= 162 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[8].position(182 * size_dm, 242 * size_dm);
                                    effect[8].setObstacleAlpha(200);
                                    effect[8].position_effect();
                                } else {

                                    effect[8].setObstacleAlpha(0);
                                    effect[8].position_effect();

                                }
                            } else {
                                effect[8].setObstacleAlpha(0);
                                effect[8].position_effect();
                            }
                        } else if (obstacle_2[0].position_x > 182 * size_dm) {
                            obstacle_2[0].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            effect[8].setObstacleAlpha(0);
                            effect[8].position_effect();
                        } else {
                            obstacle_2[0].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            effect[8].setObstacleAlpha(0);
                            effect[8].position_effect();
                        }
                    }
                }
                ////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[9] == 1) {
                    if (obstacle_2[1].position_x >= 250 * size_dm) {
                        obstacle_2[1].position(94 * size_dm, 151 * size_dm);
                        obstacle_2[1].setObstacleAlpha(200);
                    } else {
                        if (obstacle_2[1].position_x <= 123 * size_dm && obstacle_2[1].position_x >= 0) {
                            obstacle_2[1].setObstacleAlpha(200);
                            obstacle_2[1].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[9].position(143 * size_dm, 203 * size_dm);
                                effect[9].setObstacleAlpha(200);
                                effect[9].position_effect();
                            } else {
                                effect[9].setObstacleAlpha(0);
                                effect[9].position_effect();
                            }
                        } else if (obstacle_2[1].position_x >= 143 * size_dm && obstacle_2[1].position_x <= 195 * size_dm) {

                            if (obstacle_2[1].position_x >= 143 * size_dm && obstacle_2[1].position_x <= 171 * size_dm) {
                                obstacle_2[1].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            }
                            else if (obstacle_2[1].position_x > 330 && obstacle_2[1].position_x <= 390) {
                                    obstacle_2[1].setPosition(Obstacle_Part1_SpeedX, 3);
                                }

                                if (obstacle_2[1].position_x <= 175 * size_dm) {
                                    if (level_time_number % 2 == 0) {
                                        effect[9].position(195 * size_dm, 255 * size_dm);
                                        effect[9].setObstacleAlpha(200);
                                        effect[9].position_effect();
                                    } else {

                                        effect[9].setObstacleAlpha(0);
                                        effect[9].position_effect();

                                    }
                                } else {
                                    effect[9].setObstacleAlpha(0);
                                    effect[9].position_effect();
                                }
                            } else if (obstacle_2[1].position_x > 195 * size_dm) {
                                obstacle_2[1].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                                effect[9].setObstacleAlpha(0);
                                effect[9].position_effect();
                            } else {
                                obstacle_2[1].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                                effect[9].setObstacleAlpha(0);
                                effect[9].position_effect();
                            }
                        }
                    }

//////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[10] == 1) {
                    if (obstacle_2[2].position_x >= 250 * size_dm) {
                        obstacle_2[2].position(94 * size_dm, 151 * size_dm);
                        obstacle_2[2].setObstacleAlpha(200);
                    } else {
                        if (obstacle_2[2].position_x <= 136 * size_dm && obstacle_2[2].position_x >= 0) {
                            obstacle_2[2].setObstacleAlpha(200);
                            obstacle_2[2].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[10].position(156 * size_dm, 216 * size_dm);
                                effect[10].setObstacleAlpha(200);
                                effect[10].position_effect();
                            } else {
                                effect[10].setObstacleAlpha(0);
                                effect[10].position_effect();
                            }
                        } else if (obstacle_2[2].position_x >= 156 * size_dm && obstacle_2[2].position_x <= 208 * size_dm) {

                            if (obstacle_2[2].position_x >= 156 * size_dm && obstacle_2[2].position_x <= 184 * size_dm) {
                                obstacle_2[2].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            } else if (obstacle_2[2].position_x > 184 * size_dm && obstacle_2[2].position_x <= 208 * size_dm) {
                                obstacle_2[2].setPosition(Obstacle_Part1_SpeedX, 3);
                            }

                            if (obstacle_2[2].position_x <= 188 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[10].position(208 * size_dm, 268 * size_dm);
                                    effect[10].setObstacleAlpha(200);
                                    effect[10].position_effect();
                                } else {

                                    effect[10].setObstacleAlpha(0);
                                    effect[10].position_effect();

                                }
                            } else {
                                effect[10].setObstacleAlpha(0);
                                effect[10].position_effect();
                            }
                        } else if (obstacle_2[2].position_x > 208 * size_dm) {
                            obstacle_2[2].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            effect[10].setObstacleAlpha(0);
                            effect[10].position_effect();
                        } else {
                            obstacle_2[2].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            effect[10].setObstacleAlpha(0);
                            effect[10].position_effect();
                        }
                    }
                }
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[11] == 1) {
                    if (obstacle_2[3].position_x >= 250 * size_dm) {
                        obstacle_2[3].position(94 * size_dm, 151 * size_dm);
                        obstacle_2[3].setObstacleAlpha(200);
                    } else {
                        if (obstacle_2[3].position_x <= 149 * size_dm && obstacle_2[3].position_x >= 0) {
                            obstacle_2[3].setObstacleAlpha(200);
                            obstacle_2[3].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[11].position(169 * size_dm, 229 * size_dm);
                                effect[11].setObstacleAlpha(200);
                                effect[11].position_effect();
                            } else {
                                effect[11].setObstacleAlpha(0);
                                effect[11].position_effect();
                            }
                        } else if (obstacle_2[3].position_x >= 169 * size_dm && obstacle_2[3].position_x <= 221 * size_dm) {

                            if (obstacle_2[3].position_x >= 169 * size_dm && obstacle_2[3].position_x <= 197 * size_dm) {
                                obstacle_2[3].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            } else if (obstacle_2[3].position_x > 197 * size_dm && obstacle_2[3].position_x <= 221 * size_dm) {
                                obstacle_2[3].setPosition(Obstacle_Part1_SpeedX, 3);
                            }

                            if (obstacle_2[3].position_x <= 201 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[11].position(221 * size_dm, 281 * size_dm);
                                    effect[11].setObstacleAlpha(200);
                                    effect[11].position_effect();
                                } else {

                                    effect[11].setObstacleAlpha(0);
                                    effect[11].position_effect();

                                }
                            } else {
                                effect[11].setObstacleAlpha(0);
                                effect[11].position_effect();
                            }
                        } else if (obstacle_2[3].position_x > 221 * size_dm) {
                            obstacle_2[3].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            effect[11].setObstacleAlpha(0);
                            effect[11].position_effect();
                        } else {
                            obstacle_2[3].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            effect[11].setObstacleAlpha(0);
                            effect[11].position_effect();
                        }
                    }
                }
                /////////////////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[12] == 1) {
                    if (obstacle_3[0].position_x >= 250 * size_dm) {
                        obstacle_3[0].position(81 * size_dm, 164 * size_dm);
                        obstacle_3[0].setObstacleAlpha(200);
                    } else {
                        if (obstacle_3[0].position_x <= 97 * size_dm && obstacle_3[0].position_x >= 0) {
                            obstacle_3[0].setObstacleAlpha(200);
                            obstacle_3[0].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[12].position(117 * size_dm, 203 * size_dm);
                                effect[12].setObstacleAlpha(200);
                                effect[12].position_effect();
                            } else {
                                effect[12].setObstacleAlpha(0);
                                effect[12].position_effect();
                            }
                        } else if (obstacle_3[0].position_x >= 117 * size_dm && obstacle_3[0].position_x <= 169 * size_dm) {

                            if (obstacle_3[0].position_x >= 117 * size_dm && obstacle_3[0].position_x <= 145 * size_dm) {
                                obstacle_3[0].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            } else if (obstacle_3[0].position_x > 145 * size_dm && obstacle_3[0].position_x <= 169 * size_dm) {
                                obstacle_3[0].setPosition(Obstacle_Part1_SpeedX, 3);
                            }

                            if (obstacle_3[0].position_x <= 149 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[12].position(169 * size_dm, 255 * size_dm);
                                    effect[12].setObstacleAlpha(200);
                                    effect[12].position_effect();
                                } else {

                                    effect[12].setObstacleAlpha(0);
                                    effect[12].position_effect();

                                }
                            } else {
                                effect[12].setObstacleAlpha(0);
                                effect[12].position_effect();
                            }
                        } else if (obstacle_3[0].position_x > 169 * size_dm) {
                            obstacle_3[0].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            effect[12].setObstacleAlpha(0);
                            effect[12].position_effect();
                        } else {
                            obstacle_3[0].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            effect[12].setObstacleAlpha(0);
                            effect[12].position_effect();
                        }
                    }
                }
                ////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[13] == 1) {
                    if (obstacle_3[1].position_x >= 250 * size_dm) {
                        obstacle_3[1].position(81 * size_dm, 164 * size_dm);
                        obstacle_3[1].setObstacleAlpha(200);
                    } else {
                        if (obstacle_3[1].position_x <= 110 * size_dm && obstacle_3[1].position_x >= 0) {
                            obstacle_3[1].setObstacleAlpha(200);
                            obstacle_3[1].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[13].position(130 * size_dm, 216 * size_dm);
                                effect[13].setObstacleAlpha(200);
                                effect[13].position_effect();
                            } else {
                                effect[13].setObstacleAlpha(0);
                                effect[13].position_effect();
                            }
                        } else if (obstacle_3[1].position_x >= 130 * size_dm && obstacle_3[1].position_x <= 182 * size_dm) {

                            if (obstacle_3[1].position_x >= 130 * size_dm && obstacle_3[1].position_x <= 158 * size_dm) {
                                obstacle_3[1].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            } else if (obstacle_3[1].position_x > 158 * size_dm && obstacle_3[1].position_x <= 182 * size_dm) {
                                obstacle_3[1].setPosition(Obstacle_Part1_SpeedX, 3);
                            }

                            if (obstacle_3[1].position_x <= 162 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[13].position(182 * size_dm, 268 * size_dm);
                                    effect[13].setObstacleAlpha(200);
                                    effect[13].position_effect();
                                } else {

                                    effect[13].setObstacleAlpha(0);
                                    effect[13].position_effect();

                                }
                            } else {
                                effect[13].setObstacleAlpha(0);
                                effect[13].position_effect();
                            }
                        } else if (obstacle_3[1].position_x > 182 * size_dm) {
                            obstacle_3[1].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            effect[13].setObstacleAlpha(0);
                            effect[13].position_effect();
                        } else {
                            obstacle_3[1].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            effect[13].setObstacleAlpha(0);
                            effect[13].position_effect();
                        }
                    }
                }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[14] == 1) {
                    if (obstacle_3[2].position_x >= 250 * size_dm) {
                        obstacle_3[2].position(81 * size_dm, 164 * size_dm);
                        obstacle_3[2].setObstacleAlpha(200);
                    } else {
                        if (obstacle_3[2].position_x <= 123 * size_dm && obstacle_3[2].position_x >= 0) {
                            obstacle_3[2].setObstacleAlpha(200);
                            obstacle_3[2].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[14].position(143 * size_dm, 229 * size_dm);
                                effect[14].setObstacleAlpha(200);
                                effect[14].position_effect();
                            } else {
                                effect[14].setObstacleAlpha(0);
                                effect[14].position_effect();
                            }
                        } else if (obstacle_3[2].position_x >= 143 * size_dm && obstacle_3[2].position_x <= 195 * size_dm) {

                            if (obstacle_3[2].position_x >= 143 * size_dm && obstacle_3[2].position_x <= 171 * size_dm) {
                                obstacle_3[2].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            } else if (obstacle_3[2].position_x > 171 * size_dm && obstacle_3[2].position_x <= 195 * size_dm) {
                                obstacle_3[2].setPosition(Obstacle_Part1_SpeedX, 3);
                            }

                            if (obstacle_3[2].position_x <= 175 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[14].position(195 * size_dm, 281 * size_dm);
                                    effect[14].setObstacleAlpha(200);
                                    effect[14].position_effect();
                                } else {

                                    effect[14].setObstacleAlpha(0);
                                    effect[14].position_effect();

                                }
                            } else {
                                effect[14].setObstacleAlpha(0);
                                effect[14].position_effect();
                            }
                        } else if (obstacle_3[2].position_x > 195 * size_dm) {
                            obstacle_3[2].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            effect[14].setObstacleAlpha(0);
                            effect[14].position_effect();
                        } else {
                            obstacle_3[2].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            effect[14].setObstacleAlpha(0);
                            effect[14].position_effect();
                        }
                    }
                }
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[15] == 1) {
                    if (obstacle_3[3].position_x >= 250 * size_dm) {
                        obstacle_3[3].position(81 * size_dm, 164 * size_dm);
                        obstacle_3[3].setObstacleAlpha(200);
                    } else {
                        if (obstacle_3[3].position_x <= 136 * size_dm && obstacle_3[3].position_x >= 0) {
                            obstacle_3[3].setObstacleAlpha(200);
                            obstacle_3[3].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[15].position(156 * size_dm, 242 * size_dm);
                                effect[15].setObstacleAlpha(200);
                                effect[15].position_effect();
                            } else {
                                effect[15].setObstacleAlpha(0);
                                effect[15].position_effect();
                            }
                        } else if (obstacle_3[3].position_x >= 156 * size_dm && obstacle_3[3].position_x <= 208 * size_dm) {

                            if (obstacle_3[3].position_x >= 156 * size_dm && obstacle_3[3].position_x <= 184 * size_dm) {
                                obstacle_3[3].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            } else if (obstacle_3[3].position_x > 184 * size_dm && obstacle_3[3].position_x <= 208 * size_dm) {
                                obstacle_3[3].setPosition(Obstacle_Part1_SpeedX, 3);
                            }

                            if (obstacle_3[3].position_x <= 188 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[15].position(208 * size_dm, 294 * size_dm);
                                    effect[15].setObstacleAlpha(200);
                                    effect[15].position_effect();
                                } else {

                                    effect[15].setObstacleAlpha(0);
                                    effect[15].position_effect();

                                }
                            } else {
                                effect[15].setObstacleAlpha(0);
                                effect[15].position_effect();
                            }
                        } else if (obstacle_3[3].position_x > 208 * size_dm) {
                            obstacle_3[3].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            effect[15].setObstacleAlpha(0);
                            effect[15].position_effect();
                        } else {
                            obstacle_3[3].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            effect[15].setObstacleAlpha(0);
                            effect[15].position_effect();
                        }
                    }
                }
                //////////////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[16] == 1) {
                    if (obstacle_4[0].position_x >= 250 * size_dm) {
                        obstacle_4[0].position(68 * size_dm, 177 * size_dm);
                        obstacle_4[0].setObstacleAlpha(200);
                    } else {
                        if (obstacle_4[0].position_x <= 84 * size_dm && obstacle_4[0].position_x >= 0) {
                            obstacle_4[0].setObstacleAlpha(200);
                            obstacle_4[0].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[16].position(104 * size_dm, 216 * size_dm);
                                effect[16].setObstacleAlpha(200);
                                effect[16].position_effect();
                            } else {
                                effect[16].setObstacleAlpha(0);
                                effect[16].position_effect();
                            }
                        } else if (obstacle_4[0].position_x >= 104 * size_dm && obstacle_4[0].position_x <= 156 * size_dm) {

                            if (obstacle_4[0].position_x >= 104 * size_dm && obstacle_4[0].position_x <= 132 * size_dm) {
                                obstacle_4[0].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            } else if (obstacle_4[0].position_x > 132 * size_dm && obstacle_4[0].position_x <= 156 * size_dm) {
                                obstacle_4[0].setPosition(Obstacle_Part1_SpeedX, 3);
                            }

                            if (obstacle_4[0].position_x <= 136 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[16].position(156 * size_dm, 268 * size_dm);
                                    effect[16].setObstacleAlpha(200);
                                    effect[16].position_effect();
                                } else {

                                    effect[16].setObstacleAlpha(0);
                                    effect[16].position_effect();

                                }
                            } else {
                                effect[16].setObstacleAlpha(0);
                                effect[16].position_effect();
                            }
                        } else if (obstacle_4[0].position_x > 156 * size_dm) {
                            obstacle_4[0].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            effect[16].setObstacleAlpha(0);
                            effect[16].position_effect();
                        } else {
                            obstacle_4[0].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            effect[16].setObstacleAlpha(0);
                            effect[16].position_effect();
                        }
                    }
                }
                ///////////////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[17] == 1) {
                    if (obstacle_4[1].position_x >= 250 * size_dm) {
                        obstacle_4[1].position(68 * size_dm, 177 * size_dm);
                        obstacle_4[1].setObstacleAlpha(200);
                    } else {
                        if (obstacle_4[1].position_x <= 97 * size_dm && obstacle_4[1].position_x >= 0) {
                            obstacle_4[1].setObstacleAlpha(200);
                            obstacle_4[1].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[17].position(117 * size_dm, 229 * size_dm);
                                effect[17].setObstacleAlpha(200);
                                effect[17].position_effect();
                            } else {
                                effect[17].setObstacleAlpha(0);
                                effect[17].position_effect();
                            }
                        } else if (obstacle_4[1].position_x >= 117 * size_dm && obstacle_4[1].position_x <= 169 * size_dm) {

                            if (obstacle_4[1].position_x >= 117 * size_dm && obstacle_4[1].position_x <= 145 * size_dm) {
                                obstacle_4[1].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            } else if (obstacle_4[1].position_x > 145 * size_dm && obstacle_4[1].position_x <= 169 * size_dm) {
                                obstacle_4[1].setPosition(Obstacle_Part1_SpeedX, 3);
                            }

                            if (obstacle_4[1].position_x <= 149 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[17].position(169 * size_dm, 281 * size_dm);
                                    effect[17].setObstacleAlpha(200);
                                    effect[17].position_effect();
                                } else {

                                    effect[17].setObstacleAlpha(0);
                                    effect[17].position_effect();

                                }
                            } else {
                                effect[17].setObstacleAlpha(0);
                                effect[17].position_effect();
                            }
                        } else if (obstacle_4[1].position_x > 169 * size_dm) {
                            obstacle_4[1].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            effect[17].setObstacleAlpha(0);
                            effect[17].position_effect();
                        } else {
                            obstacle_4[1].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            effect[17].setObstacleAlpha(0);
                            effect[17].position_effect();
                        }
                    }
                }
//////////////////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[18] == 1) {
                    if (obstacle_4[2].position_x >= 250 * size_dm) {
                        obstacle_4[2].position(68 * size_dm, 177 * size_dm);
                        obstacle_4[2].setObstacleAlpha(200);
                    } else {
                        if (obstacle_4[2].position_x <= 110 * size_dm && obstacle_4[2].position_x >= 0) {
                            obstacle_4[2].setObstacleAlpha(200);
                            obstacle_4[2].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[18].position(130 * size_dm, 242 * size_dm);
                                effect[18].setObstacleAlpha(200);
                                effect[18].position_effect();
                            } else {
                                effect[18].setObstacleAlpha(0);
                                effect[18].position_effect();
                            }
                        } else if (obstacle_4[2].position_x >= 130 * size_dm && obstacle_4[2].position_x <= 182 * size_dm) {

                            if (obstacle_4[2].position_x >= 130 * size_dm && obstacle_4[2].position_x <= 158 * size_dm) {
                                obstacle_4[2].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            } else if (obstacle_4[2].position_x > 158 * size_dm && obstacle_4[2].position_x <= 182 * size_dm) {
                                obstacle_4[2].setPosition(Obstacle_Part1_SpeedX, 3);
                            }

                            if (obstacle_4[2].position_x <= 162 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[18].position(182 * size_dm, 294 * size_dm);
                                    effect[18].setObstacleAlpha(200);
                                    effect[18].position_effect();
                                } else {

                                    effect[18].setObstacleAlpha(0);
                                    effect[18].position_effect();

                                }
                            } else {
                                effect[18].setObstacleAlpha(0);
                                effect[18].position_effect();
                            }
                        } else if (obstacle_4[2].position_x > 182 * size_dm) {
                            obstacle_4[2].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            effect[18].setObstacleAlpha(0);
                            effect[18].position_effect();
                        } else {
                            obstacle_4[2].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            effect[18].setObstacleAlpha(0);
                            effect[18].position_effect();
                        }
                    }
                }
                //////////////////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[19] == 1) {
                    if (obstacle_4[3].position_x >= 250 * size_dm) {
                        obstacle_4[3].position(68 * size_dm, 177 * size_dm);
                        obstacle_4[3].setObstacleAlpha(200);
                    } else {
                        if (obstacle_4[3].position_x <= 123 && obstacle_4[3].position_x >= 0) {
                            obstacle_4[3].setObstacleAlpha(200);
                            obstacle_4[3].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[19].position(143 * size_dm, 255 * size_dm);
                                effect[19].setObstacleAlpha(200);
                                effect[19].position_effect();
                            } else {
                                effect[19].setObstacleAlpha(0);
                                effect[19].position_effect();
                            }
                        } else if (obstacle_4[3].position_x >= 143 * size_dm && obstacle_4[3].position_x <= 195 * size_dm) {

                            if (obstacle_4[3].position_x >= 143 * size_dm && obstacle_4[3].position_x <= 171 * size_dm) {
                                obstacle_4[3].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            } else if (obstacle_4[3].position_x > 171 * size_dm && obstacle_4[3].position_x <= 195 * size_dm) {
                                obstacle_4[3].setPosition(Obstacle_Part1_SpeedX, 3);
                            }

                            if (obstacle_4[3].position_x <= 175 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[19].position(195 * size_dm, 307 * size_dm);
                                    effect[19].setObstacleAlpha(200);
                                    effect[19].position_effect();
                                } else {

                                    effect[19].setObstacleAlpha(0);
                                    effect[19].position_effect();

                                }
                            } else {
                                effect[19].setObstacleAlpha(0);
                                effect[19].position_effect();
                            }
                        } else if (obstacle_4[3].position_x > 195 * size_dm) {
                            obstacle_4[3].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            effect[19].setObstacleAlpha(0);
                            effect[19].position_effect();
                        } else {
                            obstacle_4[3].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            effect[19].setObstacleAlpha(0);
                            effect[19].position_effect();
                        }
                    }
                }
                ///////////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[20] == 1) {
                    if (obstacle_5[0].position_x >= 250 * size_dm) {
                        obstacle_5[0].position(55 * size_dm, 190 * size_dm);
                        obstacle_5[0].setObstacleAlpha(200);
                    } else {
                        if (obstacle_5[0].position_x <= 71 * size_dm && obstacle_5[0].position_x >= 0) {
                            obstacle_5[0].setObstacleAlpha(200);
                            obstacle_5[0].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[20].position(91 * size_dm, 229 * size_dm);
                                effect[20].setObstacleAlpha(200);
                                effect[20].position_effect();
                            } else {
                                effect[20].setObstacleAlpha(0);
                                effect[20].position_effect();
                            }
                        } else if (obstacle_5[0].position_x >= 91 * size_dm && obstacle_5[0].position_x <= 143 * size_dm) {

                            if (obstacle_5[0].position_x >= 91 * size_dm && obstacle_5[0].position_x <= 119 * size_dm) {
                                obstacle_5[0].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            } else if (obstacle_5[0].position_x > 119 * size_dm && obstacle_5[0].position_x <= 143 * size_dm) {
                                obstacle_5[0].setPosition(Obstacle_Part1_SpeedX, 3);
                            }

                            if (obstacle_5[0].position_x <= 123 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[20].position(143 * size_dm, 281 * size_dm);
                                    effect[20].setObstacleAlpha(200);
                                    effect[20].position_effect();
                                } else {

                                    effect[20].setObstacleAlpha(0);
                                    effect[20].position_effect();

                                }
                            } else {
                                effect[20].setObstacleAlpha(0);
                                effect[20].position_effect();
                            }
                        } else if (obstacle_5[0].position_x > 143 * size_dm) {
                            obstacle_5[0].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            effect[20].setObstacleAlpha(0);
                            effect[20].position_effect();
                        } else {
                            obstacle_5[0].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            effect[20].setObstacleAlpha(0);
                            effect[20].position_effect();
                        }
                    }
                }
                //////////////////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[21] == 1) {
                    if (obstacle_5[1].position_x >= 250 * size_dm) {
                        obstacle_5[1].position(55 * size_dm, 190 * size_dm);
                        obstacle_5[1].setObstacleAlpha(200);
                    } else {
                        if (obstacle_5[1].position_x <= 84 * size_dm && obstacle_5[1].position_x >= 0) {
                            obstacle_5[1].setObstacleAlpha(200);
                            obstacle_5[1].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[21].position(104 * size_dm, 242 * size_dm);
                                effect[21].setObstacleAlpha(200);
                                effect[21].position_effect();
                            } else {
                                effect[21].setObstacleAlpha(0);
                                effect[21].position_effect();
                            }
                        } else if (obstacle_5[1].position_x >= 104 * size_dm && obstacle_5[1].position_x <= 156 * size_dm) {

                            if (obstacle_5[1].position_x >= 104 * size_dm && obstacle_5[1].position_x <= 132 * size_dm) {
                                obstacle_5[1].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            } else if (obstacle_5[1].position_x > 132 * size_dm && obstacle_5[1].position_x <= 156 * size_dm) {
                                obstacle_5[1].setPosition(Obstacle_Part1_SpeedX, 3);
                            }

                            if (obstacle_5[1].position_x <= 136 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[21].position(156 * size_dm, 294 * size_dm);
                                    effect[21].setObstacleAlpha(200);
                                    effect[21].position_effect();
                                } else {

                                    effect[21].setObstacleAlpha(0);
                                    effect[21].position_effect();

                                }
                            } else {
                                effect[21].setObstacleAlpha(0);
                                effect[21].position_effect();
                            }
                        } else if (obstacle_5[1].position_x > 156 * size_dm) {
                            obstacle_5[1].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            effect[21].setObstacleAlpha(0);
                            effect[21].position_effect();
                        } else {
                            obstacle_5[1].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            effect[21].setObstacleAlpha(0);
                            effect[21].position_effect();
                        }
                    }
                }
                ///////////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[22] == 1) {
                    if (obstacle_5[2].position_x >= 250 * size_dm) {
                        obstacle_5[2].position(55 * size_dm, 190 * size_dm);
                        obstacle_5[2].setObstacleAlpha(200);
                    } else {
                        if (obstacle_5[2].position_x <= 97 * size_dm && obstacle_5[2].position_x >= 0) {
                            obstacle_5[2].setObstacleAlpha(200);
                            obstacle_5[2].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[22].position(117 * size_dm, 255 * size_dm);
                                effect[22].setObstacleAlpha(200);
                                effect[22].position_effect();
                            } else {
                                effect[22].setObstacleAlpha(0);
                                effect[22].position_effect();
                            }
                        } else if (obstacle_5[2].position_x >= 117 * size_dm && obstacle_5[2].position_x <= 169 * size_dm) {

                            if (obstacle_5[2].position_x >= 117 * size_dm && obstacle_5[2].position_x <= 145 * size_dm) {
                                obstacle_5[2].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            } else if (obstacle_5[2].position_x > 145 * size_dm && obstacle_5[2].position_x <= 169 * size_dm) {
                                obstacle_5[2].setPosition(Obstacle_Part1_SpeedX, 3);
                            }

                            if (obstacle_5[2].position_x <= 149 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[22].position(169 * size_dm, 307 * size_dm);
                                    effect[22].setObstacleAlpha(200);
                                    effect[22].position_effect();
                                } else {

                                    effect[22].setObstacleAlpha(0);
                                    effect[22].position_effect();

                                }
                            } else {
                                effect[22].setObstacleAlpha(0);
                                effect[22].position_effect();
                            }
                        } else if (obstacle_5[2].position_x > 169 * size_dm) {
                            obstacle_5[2].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            effect[22].setObstacleAlpha(0);
                            effect[22].position_effect();
                        } else {
                            obstacle_5[2].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            effect[22].setObstacleAlpha(0);
                            effect[22].position_effect();
                        }
                    }
                }
                /////////////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[23] == 1) {
                    if (obstacle_5[3].position_x >= 250 * size_dm) {
                        obstacle_5[3].position(55 * size_dm, 190 * size_dm);
                        obstacle_5[3].setObstacleAlpha(200);
                    } else {
                        if (obstacle_5[3].position_x <= 110 * size_dm && obstacle_5[3].position_x >= 0) {
                            obstacle_5[3].setObstacleAlpha(200);
                            obstacle_5[3].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[23].position(130 * size_dm, 268 * size_dm);
                                effect[23].setObstacleAlpha(200);
                                effect[23].position_effect();
                            } else {
                                effect[23].setObstacleAlpha(0);
                                effect[23].position_effect();
                            }
                        } else if (obstacle_5[3].position_x >= 130 * size_dm && obstacle_5[3].position_x <= 182 * size_dm) {

                            if (obstacle_5[3].position_x >= 130 * size_dm && obstacle_5[3].position_x <= 158 * size_dm) {
                                obstacle_5[3].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            } else if (obstacle_5[3].position_x > 158 * size_dm && obstacle_5[3].position_x <= 182 * size_dm) {
                                obstacle_5[3].setPosition(Obstacle_Part1_SpeedX, 3);
                            }

                            if (obstacle_5[3].position_x <= 162 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[23].position(182 * size_dm, 320 * size_dm);
                                    effect[23].setObstacleAlpha(200);
                                    effect[23].position_effect();
                                } else {

                                    effect[23].setObstacleAlpha(0);
                                    effect[23].position_effect();

                                }
                            } else {
                                effect[23].setObstacleAlpha(0);
                                effect[23].position_effect();
                            }
                        } else if (obstacle_5[3].position_x > 182 * size_dm) {
                            obstacle_5[3].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            effect[23].setObstacleAlpha(0);
                            effect[23].position_effect();
                        } else {
                            obstacle_5[3].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            effect[23].setObstacleAlpha(0);
                            effect[23].position_effect();
                        }
                    }
                }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[24] == 1) {
                    if (obstacle_6[0].position_x >= 250 * size_dm) {
                        obstacle_6[0].position(42 * size_dm, 203 * size_dm);
                        obstacle_6[0].setObstacleAlpha(200);
                    } else {
                        if (obstacle_6[0].position_x <= 58 * size_dm && obstacle_6[0].position_x >= 0) {
                            obstacle_6[0].setObstacleAlpha(200);
                            obstacle_6[0].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[24].position(78 * size_dm, 242 * size_dm);
                                effect[24].setObstacleAlpha(200);
                                effect[24].position_effect();
                            } else {
                                effect[24].setObstacleAlpha(0);
                                effect[24].position_effect();
                            }
                        } else if (obstacle_6[0].position_x >= 78 * size_dm && obstacle_6[0].position_x <= 130 * size_dm) {

                            if (obstacle_6[0].position_x >= 78 * size_dm && obstacle_6[0].position_x <= 106 * size_dm) {
                                obstacle_6[0].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            } else if (obstacle_6[0].position_x > 106 * size_dm && obstacle_6[0].position_x <= 130 * size_dm) {
                                obstacle_6[0].setPosition(Obstacle_Part1_SpeedX, 3);
                            }

                            if (obstacle_6[0].position_x <= 110 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[24].position(130 * size_dm, 294 * size_dm);
                                    effect[24].setObstacleAlpha(200);
                                    effect[24].position_effect();
                                } else {

                                    effect[24].setObstacleAlpha(0);
                                    effect[24].position_effect();

                                }
                            } else {
                                effect[24].setObstacleAlpha(0);
                                effect[24].position_effect();
                            }
                        } else if (obstacle_6[0].position_x > 130 * size_dm) {
                            obstacle_6[0].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            effect[24].setObstacleAlpha(0);
                            effect[24].position_effect();
                        } else {
                            obstacle_6[0].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            effect[24].setObstacleAlpha(0);
                            effect[24].position_effect();
                        }
                    }
                }
//////////////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[25] == 1) {
                    if (obstacle_6[1].position_x >= 250 * size_dm) {
                        obstacle_6[1].position(42 * size_dm, 203 * size_dm);
                        obstacle_6[1].setObstacleAlpha(200);
                    } else {
                        if (obstacle_6[1].position_x <= 71 * size_dm && obstacle_6[1].position_x >= 0) {
                            obstacle_6[1].setObstacleAlpha(200);
                            obstacle_6[1].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[25].position(91 * size_dm, 255 * size_dm);
                                effect[25].setObstacleAlpha(200);
                                effect[25].position_effect();
                            } else {
                                effect[25].setObstacleAlpha(0);
                                effect[25].position_effect();
                            }
                        } else if (obstacle_6[1].position_x >= 91 * size_dm && obstacle_6[1].position_x <= 143 * size_dm) {

                            if (obstacle_6[1].position_x >= 91 * size_dm && obstacle_6[1].position_x <= 119 * size_dm) {
                                obstacle_6[1].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            } else if (obstacle_6[1].position_x > 119 * size_dm && obstacle_6[1].position_x <= 143 * size_dm) {
                                obstacle_6[1].setPosition(Obstacle_Part1_SpeedX, 3);
                            }

                            if (obstacle_6[1].position_x <= 123 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[25].position(143 * size_dm, 307 * size_dm);
                                    effect[25].setObstacleAlpha(200);
                                    effect[25].position_effect();
                                } else {

                                    effect[25].setObstacleAlpha(0);
                                    effect[25].position_effect();

                                }
                            } else {
                                effect[25].setObstacleAlpha(0);
                                effect[25].position_effect();
                            }
                        } else if (obstacle_6[1].position_x > 143 * size_dm) {
                            obstacle_6[1].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            effect[25].setObstacleAlpha(0);
                            effect[25].position_effect();
                        } else {
                            obstacle_6[1].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            effect[25].setObstacleAlpha(0);
                            effect[25].position_effect();
                        }
                    }
                }
                //////////////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[26] == 1) {
                    if (obstacle_6[2].position_x >= 250 * size_dm) {
                        obstacle_6[2].position(42 * size_dm, 203 * size_dm);
                        obstacle_6[2].setObstacleAlpha(200);
                    } else {
                        if (obstacle_6[2].position_x <= 84 * size_dm && obstacle_6[2].position_x >= 0) {
                            obstacle_6[2].setObstacleAlpha(200);
                            obstacle_6[2].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[26].position(104 * size_dm, 268 * size_dm);
                                effect[26].setObstacleAlpha(200);
                                effect[26].position_effect();
                            } else {
                                effect[26].setObstacleAlpha(0);
                                effect[26].position_effect();
                            }
                        } else if (obstacle_6[2].position_x >= 104 * size_dm && obstacle_6[2].position_x <= 156 * size_dm) {

                            if (obstacle_6[2].position_x >= 104 * size_dm && obstacle_6[2].position_x <= 132 * size_dm) {
                                obstacle_6[2].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            } else if (obstacle_6[2].position_x > 132 * size_dm && obstacle_6[2].position_x <= 156 * size_dm) {
                                obstacle_6[2].setPosition(Obstacle_Part1_SpeedX, 3);
                            }

                            if (obstacle_6[2].position_x <= 136 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[26].position(156 * size_dm, 320 * size_dm);
                                    effect[26].setObstacleAlpha(200);
                                    effect[26].position_effect();
                                } else {

                                    effect[26].setObstacleAlpha(0);
                                    effect[26].position_effect();

                                }
                            } else {
                                effect[26].setObstacleAlpha(0);
                                effect[26].position_effect();
                            }
                        } else if (obstacle_6[2].position_x > 156 * size_dm) {
                            obstacle_6[2].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            effect[26].setObstacleAlpha(0);
                            effect[26].position_effect();
                        } else {
                            obstacle_6[2].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            effect[26].setObstacleAlpha(0);
                            effect[26].position_effect();
                        }
                    }
                }
                //////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[27] == 1) {
                    if (obstacle_6[3].position_x >= 250 * size_dm) {
                        obstacle_6[3].position(42 * size_dm, 203 * size_dm);
                        obstacle_6[3].setObstacleAlpha(200);
                    } else {
                        if (obstacle_6[3].position_x <= 97 * size_dm && obstacle_6[3].position_x >= 0) {
                            obstacle_6[3].setObstacleAlpha(200);
                            obstacle_6[3].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[27].position(117 * size_dm, 281 * size_dm);
                                effect[27].setObstacleAlpha(200);
                                effect[27].position_effect();
                            } else {
                                effect[27].setObstacleAlpha(0);
                                effect[27].position_effect();
                            }
                        } else if (obstacle_6[3].position_x >= 117 * size_dm && obstacle_6[3].position_x <= 169 * size_dm) {

                            if (obstacle_6[3].position_x >= 117 * size_dm && obstacle_6[3].position_x <= 145 * size_dm) {
                                obstacle_6[3].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            } else if (obstacle_6[3].position_x > 145 * size_dm && obstacle_6[3].position_x <= 169 * size_dm) {
                                obstacle_6[3].setPosition(Obstacle_Part1_SpeedX, 3);
                            }

                            if (obstacle_6[3].position_x <= 149 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[27].position(169 * size_dm, 333 * size_dm);
                                    effect[27].setObstacleAlpha(200);
                                    effect[27].position_effect();
                                } else {

                                    effect[27].setObstacleAlpha(0);
                                    effect[27].position_effect();

                                }
                            } else {
                                effect[27].setObstacleAlpha(0);
                                effect[27].position_effect();
                            }
                        } else if (obstacle_6[3].position_x > 169 * size_dm) {
                            obstacle_6[3].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            effect[27].setObstacleAlpha(0);
                            effect[27].position_effect();
                        } else {
                            obstacle_6[3].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            effect[27].setObstacleAlpha(0);
                            effect[27].position_effect();
                        }
                    }
                }
                /////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[28] == 1) {
                    if (obstacle_7[0].position_x >= 250 * size_dm) {
                        obstacle_7[0].position(29 * size_dm, 216 * size_dm);
                        obstacle_7[0].setObstacleAlpha(200);
                    } else {
                        if (obstacle_7[0].position_x <= 45 * size_dm && obstacle_7[0].position_x >= 0) {
                            obstacle_7[0].setObstacleAlpha(200);
                            obstacle_7[0].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[28].position(65 * size_dm, 254 * size_dm);
                                effect[28].setObstacleAlpha(200);
                                effect[28].position_effect();
                            } else {
                                effect[28].setObstacleAlpha(0);
                                effect[28].position_effect();
                            }
                        } else if (obstacle_7[0].position_x >= 65 * size_dm && obstacle_7[0].position_x <= 117 * size_dm) {

                            if (obstacle_7[0].position_x >= 65 * size_dm && obstacle_7[0].position_x <= 93 * size_dm) {
                                obstacle_7[0].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            } else if (obstacle_7[0].position_x > 93 * size_dm && obstacle_7[0].position_x <= 117 * size_dm) {
                                obstacle_7[0].setPosition(Obstacle_Part1_SpeedX, 3);
                            }

                            if (obstacle_7[0].position_x <= 97 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[28].position(117 * size_dm, 307 * size_dm);
                                    effect[28].setObstacleAlpha(200);
                                    effect[28].position_effect();
                                } else {

                                    effect[28].setObstacleAlpha(0);
                                    effect[28].position_effect();

                                }
                            } else {
                                effect[28].setObstacleAlpha(0);
                                effect[28].position_effect();
                            }
                        } else if (obstacle_7[0].position_x > 117 * size_dm) {
                            obstacle_7[0].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            effect[28].setObstacleAlpha(0);
                            effect[28].position_effect();
                        } else {
                            obstacle_7[0].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            effect[28].setObstacleAlpha(0);
                            effect[28].position_effect();
                        }
                    }
                }
                ////////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[29] == 1) {
                    if (obstacle_7[1].position_x >= 250 * size_dm) {
                        obstacle_7[1].position(29 * size_dm, 216 * size_dm);
                        obstacle_7[1].setObstacleAlpha(200);
                    } else {
                        if (obstacle_7[1].position_x <= 58 * size_dm && obstacle_7[1].position_x >= 0) {
                            obstacle_7[1].setObstacleAlpha(200);
                            obstacle_7[1].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[29].position(78 * size_dm, 268 * size_dm);
                                effect[29].setObstacleAlpha(200);
                                effect[29].position_effect();
                            } else {
                                effect[29].setObstacleAlpha(0);
                                effect[29].position_effect();
                            }
                        } else if (obstacle_7[1].position_x >= 78 * size_dm && obstacle_7[1].position_x <= 130 * size_dm) {

                            if (obstacle_7[1].position_x >= 78 * size_dm && obstacle_7[1].position_x <= 106 * size_dm) {
                                obstacle_7[1].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            } else if (obstacle_7[1].position_x > 106 * size_dm && obstacle_7[1].position_x <= 130 * size_dm) {
                                obstacle_7[1].setPosition(Obstacle_Part1_SpeedX, 3);
                            }

                            if (obstacle_7[1].position_x <= 110 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[29].position(130 * size_dm, 320 * size_dm);
                                    effect[29].setObstacleAlpha(200);
                                    effect[29].position_effect();
                                } else {

                                    effect[29].setObstacleAlpha(0);
                                    effect[29].position_effect();

                                }
                            } else {
                                effect[29].setObstacleAlpha(0);
                                effect[29].position_effect();
                            }
                        } else if (obstacle_7[1].position_x > 130 * size_dm) {
                            obstacle_7[1].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            effect[29].setObstacleAlpha(0);
                            effect[29].position_effect();
                        } else {
                            obstacle_7[1].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            effect[29].setObstacleAlpha(0);
                            effect[29].position_effect();
                        }
                    }
                }
                ////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[30] == 1) {
                    if (obstacle_7[2].position_x >= 250 * size_dm) {
                        obstacle_7[2].position(29 * size_dm, 216 * size_dm);
                        obstacle_7[2].setObstacleAlpha(200);
                    } else {
                        if (obstacle_7[2].position_x <= 71 * size_dm && obstacle_7[2].position_x >= 0) {
                            obstacle_7[2].setObstacleAlpha(200);
                            obstacle_7[2].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[30].position(91 * size_dm, 281 * size_dm);
                                effect[30].setObstacleAlpha(200);
                                effect[30].position_effect();
                            } else {
                                effect[30].setObstacleAlpha(0);
                                effect[30].position_effect();
                            }
                        } else if (obstacle_7[2].position_x >= 91 * size_dm && obstacle_7[2].position_x <= 143 * size_dm) {

                            if (obstacle_7[2].position_x >= 91 * size_dm && obstacle_7[2].position_x <= 119 * size_dm) {
                                obstacle_7[2].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            } else if (obstacle_7[2].position_x > 119 * size_dm && obstacle_7[2].position_x <= 143 * size_dm) {
                                obstacle_7[2].setPosition(Obstacle_Part1_SpeedX, 3);
                            }

                            if (obstacle_7[2].position_x <= 123 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[30].position(143 * size_dm, 333 * size_dm);
                                    effect[30].setObstacleAlpha(200);
                                    effect[30].position_effect();
                                } else {

                                    effect[30].setObstacleAlpha(0);
                                    effect[30].position_effect();

                                }
                            } else {
                                effect[30].setObstacleAlpha(0);
                                effect[30].position_effect();
                            }
                        } else if (obstacle_7[2].position_x > 143 * size_dm) {
                            obstacle_7[2].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            effect[30].setObstacleAlpha(0);
                            effect[30].position_effect();
                        } else {
                            obstacle_7[2].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            effect[30].setObstacleAlpha(0);
                            effect[30].position_effect();
                        }
                    }
                }
                ////////////////////////////////////////////////////////////////////////////////////
                if (pattern[31] == 1) {
                    if (obstacle_7[3].position_x >= 250 * size_dm) {
                        obstacle_7[3].position(29 * size_dm, 216 * size_dm);
                        obstacle_7[3].setObstacleAlpha(200);
                    } else {
                        if (obstacle_7[3].position_x <= 84 * size_dm && obstacle_7[3].position_x >= 0) {
                            obstacle_7[3].setObstacleAlpha(200);
                            obstacle_7[3].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[31].position(104 * size_dm, 294 * size_dm);
                                effect[31].setObstacleAlpha(200);
                                effect[31].position_effect();
                            } else {
                                effect[31].setObstacleAlpha(0);
                                effect[31].position_effect();
                            }
                        } else if (obstacle_7[3].position_x >= 104 * size_dm && obstacle_7[3].position_x <= 156 * size_dm) {

                            if (obstacle_7[3].position_x >= 104 * size_dm && obstacle_7[3].position_x <= 132 * size_dm) {
                                obstacle_7[3].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            } else if (obstacle_7[3].position_x > 132 * size_dm && obstacle_7[3].position_x <= 156 * size_dm) {
                                obstacle_7[3].setPosition(Obstacle_Part1_SpeedX, 3);
                            }

                            if (obstacle_7[3].position_x <= 136 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[31].position(156 * size_dm, 346 * size_dm);
                                    effect[31].setObstacleAlpha(200);
                                    effect[31].position_effect();
                                } else {

                                    effect[31].setObstacleAlpha(0);
                                    effect[31].position_effect();

                                }
                            } else {
                                effect[31].setObstacleAlpha(0);
                                effect[31].position_effect();
                            }
                        } else if (obstacle_7[3].position_x > 156 * size_dm) {
                            obstacle_7[3].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                            effect[31].setObstacleAlpha(0);
                            effect[31].position_effect();
                        } else {
                            obstacle_7[3].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                            effect[31].setObstacleAlpha(0);
                            effect[31].position_effect();
                        }
                    }
                }
                //////////////////////////////////////////////////////////////////////////////////////////////////////
                  if (pattern[32] == 1) {
                if (r_obstacle[0].position_x <= 30 * size_dm) {
                    r_obstacle[0].position(189 * size_dm, 125 * size_dm);
                    r_obstacle[0].setObstacleAlpha(200);
                } else {
                    if (r_obstacle[0].position_x >= 176 * size_dm) {
                        r_obstacle[0].setObstacleAlpha(200);
                        r_obstacle[0].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[32].position(156 * size_dm, 164 * size_dm);
                            effect[32].setObstacleAlpha(200);
                            effect[32].position_effect();
                        } else {
                            effect[32].setObstacleAlpha(0);
                            effect[32].position_effect();
                        }
                    } else if (r_obstacle[0].position_x >= 104 * size_dm && r_obstacle[0].position_x < 160 * size_dm) {

                        if (r_obstacle[0].position_x >= 130 * size_dm && r_obstacle[0].position_x < 160 * size_dm) {
                            r_obstacle[0].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        } else if (r_obstacle[0].position_x >= 104 * size_dm && r_obstacle[0].position_x < 130 * size_dm) {
                            r_obstacle[0].setPosition(Obstacle_1_Part2_SpeedX, 3);
                        }

                        if (r_obstacle[0].position_x >= 124 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[32].position(104 * size_dm, 216 * size_dm);
                                effect[32].setObstacleAlpha(200);
                                effect[32].position_effect();
                            } else {

                                effect[32].setObstacleAlpha(0);
                                effect[32].position_effect();

                            }
                        } else {
                            effect[32].setObstacleAlpha(0);
                            effect[32].position_effect();
                        }
                    } else if (r_obstacle[0].position_x < 104 * size_dm) {
                        r_obstacle[0].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        effect[32].setObstacleAlpha(0);
                        effect[32].position_effect();
                    } else {
                        r_obstacle[0].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        effect[32].setObstacleAlpha(0);
                        effect[32].position_effect();
                    }
                }
                  }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                if (pattern[33] == 1) {
                    if (r_obstacle[1].position_x <= 30 * size_dm) {
                        r_obstacle[1].position(189 * size_dm, 125 * size_dm);
                        r_obstacle[1].setObstacleAlpha(200);
                    } else {
                        if (r_obstacle[1].position_x >= 163 * size_dm) {
                            r_obstacle[1].setObstacleAlpha(200);
                            r_obstacle[1].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[33].position(143 * size_dm, 177 * size_dm);
                                effect[33].setObstacleAlpha(200);
                                effect[33].position_effect();
                            } else {
                                effect[33].setObstacleAlpha(0);
                                effect[33].position_effect();
                            }
                        } else if (r_obstacle[1].position_x >= 91 * size_dm && r_obstacle[1].position_x <= 143 * size_dm) {

                            if (r_obstacle[1].position_x >= 115 * size_dm && r_obstacle[1].position_x <= 143 * size_dm) {
                                r_obstacle[1].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            } else if (r_obstacle[1].position_x >= 91 * size_dm && r_obstacle[1].position_x < 115 * size_dm) {
                                r_obstacle[1].setPosition(Obstacle_1_Part2_SpeedX, 3);
                            }

                            if (r_obstacle[1].position_x >= 111 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[33].position(91 * size_dm, 229 * size_dm);
                                    effect[33].setObstacleAlpha(200);
                                    effect[33].position_effect();
                                } else {

                                    effect[33].setObstacleAlpha(0);
                                    effect[33].position_effect();

                                }
                            } else {
                                effect[33].setObstacleAlpha(0);
                                effect[33].position_effect();
                            }
                        } else if (r_obstacle[1].position_x < 91 * size_dm) {
                            r_obstacle[1].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            effect[33].setObstacleAlpha(0);
                            effect[33].position_effect();
                        } else {
                            r_obstacle[1].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            effect[33].setObstacleAlpha(0);
                            effect[33].position_effect();
                        }
                    }
                }
                //////////////////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[34] == 1) {
                    if (r_obstacle[2].position_x <= 30 * size_dm) {
                        r_obstacle[2].position(189 * size_dm, 125 * size_dm);
                        r_obstacle[2].setObstacleAlpha(200);
                    } else {
                        if (r_obstacle[2].position_x >= 150 * size_dm) {
                            r_obstacle[2].setObstacleAlpha(200);
                            r_obstacle[2].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[34].position(130 * size_dm, 190 * size_dm);
                                effect[34].setObstacleAlpha(200);
                                effect[34].position_effect();
                            } else {
                                effect[34].setObstacleAlpha(0);
                                effect[34].position_effect();
                            }
                        } else if (r_obstacle[2].position_x >= 78 * size_dm && r_obstacle[2].position_x <= 130 * size_dm) {

                            if (r_obstacle[2].position_x >= 102 * size_dm && r_obstacle[2].position_x <= 130 * size_dm) {
                                r_obstacle[2].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            } else if (r_obstacle[2].position_x >= 78 * size_dm && r_obstacle[2].position_x < 102 * size_dm) {
                                r_obstacle[2].setPosition(Obstacle_1_Part2_SpeedX, 3);
                            }

                            if (r_obstacle[2].position_x >= 98 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[34].position(78 * size_dm, 242 * size_dm);
                                    effect[34].setObstacleAlpha(200);
                                    effect[34].position_effect();
                                } else {

                                    effect[34].setObstacleAlpha(0);
                                    effect[34].position_effect();

                                }
                            } else {
                                effect[34].setObstacleAlpha(0);
                                effect[34].position_effect();
                            }
                        } else if (r_obstacle[2].position_x < 78 * size_dm) {
                            r_obstacle[2].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            effect[34].setObstacleAlpha(0);
                            effect[34].position_effect();
                        } else {
                            r_obstacle[2].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            effect[34].setObstacleAlpha(0);
                            effect[34].position_effect();
                        }
                    }
                }
                ////////////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[35] == 1) {
                    if (r_obstacle[3].position_x <= 30 * size_dm) {
                        r_obstacle[3].position(189 * size_dm, 125 * size_dm);
                        r_obstacle[3].setObstacleAlpha(200);
                    } else {
                        if (r_obstacle[3].position_x >= 137 * size_dm) {
                            r_obstacle[3].setObstacleAlpha(200);
                            r_obstacle[3].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[35].position(117 * size_dm, 203 * size_dm);
                                effect[35].setObstacleAlpha(200);
                                effect[35].position_effect();
                            } else {
                                effect[35].setObstacleAlpha(0);
                                effect[35].position_effect();
                            }
                        } else if (r_obstacle[3].position_x >= 65 * size_dm && r_obstacle[3].position_x <= 117 * size_dm) {

                            if (r_obstacle[3].position_x >= 89 * size_dm && r_obstacle[3].position_x <= 117 * size_dm) {
                                r_obstacle[3].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            } else if (r_obstacle[3].position_x >= 65 * size_dm && r_obstacle[3].position_x < 89 * size_dm) {
                                r_obstacle[3].setPosition(Obstacle_1_Part2_SpeedX, 3);
                            }

                            if (r_obstacle[3].position_x >= 85 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[35].position(65 * size_dm, 254 * size_dm);
                                    effect[35].setObstacleAlpha(200);
                                    effect[35].position_effect();
                                } else {

                                    effect[35].setObstacleAlpha(0);
                                    effect[35].position_effect();

                                }
                            } else {
                                effect[35].setObstacleAlpha(0);
                                effect[35].position_effect();
                            }
                        } else if (r_obstacle[3].position_x < 65 * size_dm) {
                            r_obstacle[3].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            effect[35].setObstacleAlpha(0);
                            effect[35].position_effect();
                        } else {
                            r_obstacle[3].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            effect[35].setObstacleAlpha(0);
                            effect[35].position_effect();
                        }
                    }
                }
                ////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[36] == 1) {
                    if (r_obstacle_1[0].position_x <= 30 * size_dm) {
                        r_obstacle_1[0].position(202 * size_dm, 138 * size_dm);
                        r_obstacle_1[0].setObstacleAlpha(200);
                    } else {
                        if (r_obstacle_1[0].position_x >= 189 * size_dm) {
                            r_obstacle_1[0].setObstacleAlpha(200);
                            r_obstacle_1[0].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[36].position(169 * size_dm, 177 * size_dm);
                                effect[36].setObstacleAlpha(200);
                                effect[36].position_effect();
                            } else {
                                effect[36].setObstacleAlpha(0);
                                effect[36].position_effect();
                            }
                        } else if (r_obstacle_1[0].position_x >= 117 * size_dm && r_obstacle_1[0].position_x <= 169 * size_dm) {

                            if (r_obstacle_1[0].position_x >= 141 * size_dm && r_obstacle_1[0].position_x <= 169 * size_dm) {
                                r_obstacle_1[0].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            } else if (r_obstacle_1[0].position_x >= 117 * size_dm && r_obstacle_1[0].position_x < 141 * size_dm) {
                                r_obstacle_1[0].setPosition(Obstacle_1_Part2_SpeedX, 3);
                            }

                            if (r_obstacle_1[0].position_x >= 137 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[36].position(117 * size_dm, 229 * size_dm);
                                    effect[36].setObstacleAlpha(200);
                                    effect[36].position_effect();
                                } else {

                                    effect[36].setObstacleAlpha(0);
                                    effect[36].position_effect();

                                }
                            } else {
                                effect[36].setObstacleAlpha(0);
                                effect[36].position_effect();
                            }
                        } else if (r_obstacle_1[0].position_x < 117 * size_dm) {
                            r_obstacle_1[0].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            effect[36].setObstacleAlpha(0);
                            effect[36].position_effect();
                        } else {
                            r_obstacle_1[0].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            effect[36].setObstacleAlpha(0);
                            effect[36].position_effect();
                        }
                    }
                }
                /////////////////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[37] == 1) {
                    if (r_obstacle_1[1].position_x <= 30 * size_dm) {
                        r_obstacle_1[1].position(202 * size_dm, 138 * size_dm);
                        r_obstacle_1[1].setObstacleAlpha(200);
                    } else {
                        if (r_obstacle_1[1].position_x >= 176 * size_dm) {
                            r_obstacle_1[1].setObstacleAlpha(200);
                            r_obstacle_1[1].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[37].position(156 * size_dm, 190 * size_dm);
                                effect[37].setObstacleAlpha(200);
                                effect[37].position_effect();
                            } else {
                                effect[37].setObstacleAlpha(0);
                                effect[37].position_effect();
                            }
                        } else if (r_obstacle_1[1].position_x >= 104 * size_dm && r_obstacle_1[1].position_x <= 156 * size_dm) {

                            if (r_obstacle_1[1].position_x >= 128 * size_dm && r_obstacle_1[1].position_x <= 156 * size_dm) {
                                r_obstacle_1[1].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            } else if (r_obstacle_1[1].position_x >= 104 * size_dm && r_obstacle_1[1].position_x < 128 * size_dm) {
                                r_obstacle_1[1].setPosition(Obstacle_1_Part2_SpeedX, 3);
                            }

                            if (r_obstacle_1[1].position_x >= 124 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[37].position(104 * size_dm, 242 * size_dm);
                                    effect[37].setObstacleAlpha(200);
                                    effect[37].position_effect();
                                } else {

                                    effect[37].setObstacleAlpha(0);
                                    effect[37].position_effect();

                                }
                            } else {
                                effect[37].setObstacleAlpha(0);
                                effect[37].position_effect();
                            }
                        } else if (r_obstacle_1[1].position_x < 104 * size_dm) {
                            r_obstacle_1[1].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            effect[37].setObstacleAlpha(0);
                            effect[37].position_effect();
                        } else {
                            r_obstacle_1[1].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            effect[37].setObstacleAlpha(0);
                            effect[37].position_effect();
                        }
                    }
                }
                //////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[38] == 1) {
                    if (r_obstacle_1[2].position_x <= 30 * size_dm) {
                        r_obstacle_1[2].position(202 * size_dm, 138 * size_dm);
                        r_obstacle_1[2].setObstacleAlpha(200);
                    } else {
                        if (r_obstacle_1[2].position_x >= 163 * size_dm) {
                            r_obstacle_1[2].setObstacleAlpha(200);
                            r_obstacle_1[2].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[38].position(143 * size_dm, 203 * size_dm);
                                effect[38].setObstacleAlpha(200);
                                effect[38].position_effect();
                            } else {
                                effect[38].setObstacleAlpha(0);
                                effect[38].position_effect();
                            }
                        } else if (r_obstacle_1[2].position_x >= 91 * size_dm && r_obstacle_1[2].position_x <= 143 * size_dm) {

                            if (r_obstacle_1[2].position_x >= 115 * size_dm && r_obstacle_1[2].position_x <= 143 * size_dm) {
                                r_obstacle_1[2].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            } else if (r_obstacle_1[2].position_x >= 91 * size_dm && r_obstacle_1[2].position_x < 115 * size_dm) {
                                r_obstacle_1[2].setPosition(Obstacle_1_Part2_SpeedX, 3);
                            }

                            if (r_obstacle_1[2].position_x >= 111 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[38].position(91 * size_dm, 255 * size_dm);
                                    effect[38].setObstacleAlpha(200);
                                    effect[38].position_effect();
                                } else {

                                    effect[38].setObstacleAlpha(0);
                                    effect[38].position_effect();

                                }
                            } else {
                                effect[38].setObstacleAlpha(0);
                                effect[38].position_effect();
                            }
                        } else if (r_obstacle_1[2].position_x < 91 * size_dm) {
                            r_obstacle_1[2].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            effect[38].setObstacleAlpha(0);
                            effect[38].position_effect();
                        } else {
                            r_obstacle_1[2].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            effect[38].setObstacleAlpha(0);
                            effect[38].position_effect();
                        }
                    }
                }
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[39] == 1) {
                    if (r_obstacle_1[3].position_x <= 30 * size_dm) {
                        r_obstacle_1[3].position(202 * size_dm, 138 * size_dm);
                        r_obstacle_1[3].setObstacleAlpha(200);
                    } else {
                        if (r_obstacle_1[3].position_x >= 150 * size_dm) {
                            r_obstacle_1[3].setObstacleAlpha(200);
                            r_obstacle_1[3].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[39].position(130 * size_dm, 216 * size_dm);
                                effect[39].setObstacleAlpha(200);
                                effect[39].position_effect();
                            } else {
                                effect[39].setObstacleAlpha(0);
                                effect[39].position_effect();
                            }
                        } else if (r_obstacle_1[3].position_x >= 100 * size_dm && r_obstacle_1[3].position_x <= 130 * size_dm) {

                            if (r_obstacle_1[3].position_x >= 122 * size_dm && r_obstacle_1[3].position_x <= 130 * size_dm) {
                                r_obstacle_1[3].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            } else if (r_obstacle_1[3].position_x >= 100 * size_dm && r_obstacle_1[3].position_x < 122 * size_dm) {
                                r_obstacle_1[3].setPosition(Obstacle_1_Part2_SpeedX, 3);
                            }

                            if (r_obstacle_1[3].position_x >= 108 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[39].position(78 * size_dm, 268 * size_dm);
                                    effect[39].setObstacleAlpha(200);
                                    effect[39].position_effect();
                                } else {

                                    effect[39].setObstacleAlpha(0);
                                    effect[39].position_effect();

                                }
                            } else {
                                effect[39].setObstacleAlpha(0);
                                effect[39].position_effect();
                            }
                        } else if (r_obstacle_1[3].position_x < 100 * size_dm) {
                            r_obstacle_1[3].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            effect[39].setObstacleAlpha(0);
                            effect[39].position_effect();
                        } else {
                            r_obstacle_1[3].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            effect[39].setObstacleAlpha(0);
                            effect[39].position_effect();
                        }
                    }
                }
                /////////////////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[40] == 1) {
                    if (r_obstacle_2[0].position_x <= 30 * size_dm) {
                        r_obstacle_2[0].position(215 * size_dm, 151 * size_dm);
                        r_obstacle_2[0].setObstacleAlpha(200);
                    } else {
                        if (r_obstacle_2[0].position_x >= 202 * size_dm) {
                            r_obstacle_2[0].setObstacleAlpha(200);
                            r_obstacle_2[0].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[40].position(182 * size_dm, 190 * size_dm);
                                effect[40].setObstacleAlpha(200);
                                effect[40].position_effect();
                            } else {
                                effect[40].setObstacleAlpha(0);
                                effect[40].position_effect();
                            }
                        } else if (r_obstacle_2[0].position_x >= 130 * size_dm && r_obstacle_2[0].position_x <= 182 * size_dm) {

                            if (r_obstacle_2[0].position_x >= 154 * size_dm && r_obstacle_2[0].position_x <= 182 * size_dm) {
                                r_obstacle_2[0].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            } else if (r_obstacle_2[0].position_x >= 130 * size_dm && r_obstacle_2[0].position_x < 154 * size_dm) {
                                r_obstacle_2[0].setPosition(Obstacle_1_Part2_SpeedX, 3);
                            }

                            if (r_obstacle_2[0].position_x >= 150 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[40].position(130 * size_dm, 242 * size_dm);
                                    effect[40].setObstacleAlpha(200);
                                    effect[40].position_effect();
                                } else {

                                    effect[40].setObstacleAlpha(0);
                                    effect[40].position_effect();

                                }
                            } else {
                                effect[40].setObstacleAlpha(0);
                                effect[40].position_effect();
                            }
                        } else if (r_obstacle_2[0].position_x < 130 * size_dm) {
                            r_obstacle_2[0].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            effect[40].setObstacleAlpha(0);
                            effect[40].position_effect();
                        } else {
                            r_obstacle_2[0].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            effect[40].setObstacleAlpha(0);
                            effect[40].position_effect();
                        }
                    }
                }
                ///////////////////////////////////////////////////////////////////////////
                if (pattern[41] == 1) {
                    if (r_obstacle_2[1].position_x <= 30 * size_dm) {
                        r_obstacle_2[1].position(215 * size_dm, 151 * size_dm);
                        r_obstacle_2[1].setObstacleAlpha(200);
                    } else {
                        if (r_obstacle_2[1].position_x >= 189 * size_dm) {
                            r_obstacle_2[1].setObstacleAlpha(200);
                            r_obstacle_2[1].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[41].position(169 * size_dm, 203 * size_dm);
                                effect[41].setObstacleAlpha(200);
                                effect[41].position_effect();
                            } else {
                                effect[41].setObstacleAlpha(0);
                                effect[41].position_effect();
                            }
                        } else if (r_obstacle_2[1].position_x >= 117 * size_dm && r_obstacle_2[1].position_x <= 169 * size_dm) {

                            if (r_obstacle_2[1].position_x >= 141 * size_dm && r_obstacle_2[1].position_x <= 169 * size_dm) {
                                r_obstacle_2[1].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            } else if (r_obstacle_2[1].position_x >= 117 * size_dm && r_obstacle_2[1].position_x < 141 * size_dm) {
                                r_obstacle_2[1].setPosition(Obstacle_1_Part2_SpeedX, 3);
                            }

                            if (r_obstacle_2[1].position_x >= 137 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[41].position(117 * size_dm, 255 * size_dm);
                                    effect[41].setObstacleAlpha(200);
                                    effect[41].position_effect();
                                } else {

                                    effect[41].setObstacleAlpha(0);
                                    effect[41].position_effect();

                                }
                            } else {
                                effect[41].setObstacleAlpha(0);
                                effect[41].position_effect();
                            }
                        } else if (r_obstacle_2[1].position_x < 117 * size_dm) {
                            r_obstacle_2[1].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            effect[41].setObstacleAlpha(0);
                            effect[41].position_effect();
                        } else {
                            r_obstacle_2[1].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            effect[41].setObstacleAlpha(0);
                            effect[41].position_effect();
                        }
                    }
                }

                if (pattern[42] == 1) {
                    if (r_obstacle_2[2].position_x <= 30 * size_dm) {
                        r_obstacle_2[2].position(215 * size_dm, 151 * size_dm);
                        r_obstacle_2[2].setObstacleAlpha(200);
                    } else {
                        if (r_obstacle_2[2].position_x >= 176 * size_dm) {
                            r_obstacle_2[2].setObstacleAlpha(200);
                            r_obstacle_2[2].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[42].position(156 * size_dm, 216 * size_dm);
                                effect[42].setObstacleAlpha(200);
                                effect[42].position_effect();
                            } else {
                                effect[42].setObstacleAlpha(0);
                                effect[42].position_effect();
                            }
                        } else if (r_obstacle_2[2].position_x >= 104 * size_dm && r_obstacle_2[2].position_x <= 156 * size_dm) {

                            if (r_obstacle_2[2].position_x >= 128 * size_dm && r_obstacle_2[2].position_x <= 156 * size_dm) {
                                r_obstacle_2[2].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            } else if (r_obstacle_2[2].position_x >= 104 * size_dm && r_obstacle_2[2].position_x < 128 * size_dm) {
                                r_obstacle_2[2].setPosition(Obstacle_1_Part2_SpeedX, 3);
                            }

                            if (r_obstacle_2[2].position_x >= 124 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[42].position(104 * size_dm, 268 * size_dm);
                                    effect[42].setObstacleAlpha(200);
                                    effect[42].position_effect();
                                } else {

                                    effect[42].setObstacleAlpha(0);
                                    effect[42].position_effect();

                                }
                            } else {
                                effect[42].setObstacleAlpha(0);
                                effect[42].position_effect();
                            }
                        } else if (r_obstacle_2[2].position_x < 104 * size_dm) {
                            r_obstacle_2[2].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            effect[42].setObstacleAlpha(0);
                            effect[42].position_effect();
                        } else {
                            r_obstacle_2[2].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            effect[42].setObstacleAlpha(0);
                            effect[42].position_effect();
                        }
                    }
                }

                if (pattern[43] == 1) {
                    if (r_obstacle_2[3].position_x <= 30 * size_dm) {
                        r_obstacle_2[3].position(215 * size_dm, 151 * size_dm);
                        r_obstacle_2[3].setObstacleAlpha(200);
                    } else {
                        if (r_obstacle_2[3].position_x >= 163 * size_dm) {
                            r_obstacle_2[3].setObstacleAlpha(200);
                            r_obstacle_2[3].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[43].position(143 * size_dm, 229 * size_dm);
                                effect[43].setObstacleAlpha(200);
                                effect[43].position_effect();
                            } else {
                                effect[43].setObstacleAlpha(0);
                                effect[43].position_effect();
                            }
                        } else if (r_obstacle_2[3].position_x >= 91 * size_dm && r_obstacle_2[3].position_x <= 143 * size_dm) {

                            if (r_obstacle_2[3].position_x >= 115 * size_dm && r_obstacle_2[3].position_x <= 143 * size_dm) {
                                r_obstacle_2[3].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            } else if (r_obstacle_2[3].position_x >= 91 * size_dm && r_obstacle_2[3].position_x < 115 * size_dm) {
                                r_obstacle_2[3].setPosition(Obstacle_1_Part2_SpeedX, 3);
                            }

                            if (r_obstacle_2[3].position_x >= 111 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[43].position(91 * size_dm, 281 * size_dm);
                                    effect[43].setObstacleAlpha(200);
                                    effect[43].position_effect();
                                } else {

                                    effect[43].setObstacleAlpha(0);
                                    effect[43].position_effect();

                                }
                            } else {
                                effect[43].setObstacleAlpha(0);
                                effect[43].position_effect();
                            }
                        } else if (r_obstacle_2[3].position_x < 91 * size_dm) {
                            r_obstacle_2[3].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            effect[43].setObstacleAlpha(0);
                            effect[43].position_effect();
                        } else {
                            r_obstacle_2[3].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            effect[43].setObstacleAlpha(0);
                            effect[43].position_effect();
                        }
                    }
                }

                if (pattern[44] == 1) {
                    if (r_obstacle_3[0].position_x <= 30 * size_dm) {
                        r_obstacle_3[0].position(228 * size_dm, 164 * size_dm);
                        r_obstacle_3[0].setObstacleAlpha(200);
                    } else {
                        if (r_obstacle_3[0].position_x >= 215 * size_dm) {
                            r_obstacle_3[0].setObstacleAlpha(200);
                            r_obstacle_3[0].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[44].position(195 * size_dm, 203 * size_dm);
                                effect[44].setObstacleAlpha(200);
                                effect[44].position_effect();
                            } else {
                                effect[44].setObstacleAlpha(0);
                                effect[44].position_effect();
                            }
                        } else if (r_obstacle_3[0].position_x >= 143 * size_dm && r_obstacle_3[0].position_x <= 195 * size_dm) {

                            if (r_obstacle_3[0].position_x >= 167 * size_dm && r_obstacle_3[0].position_x <= 195 * size_dm) {
                                r_obstacle_3[0].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            } else if (r_obstacle_3[0].position_x >= 143 * size_dm && r_obstacle_3[0].position_x < 167 * size_dm) {
                                r_obstacle_3[0].setPosition(Obstacle_1_Part2_SpeedX, 3);
                            }

                            if (r_obstacle_3[0].position_x >= 163 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[44].position(143 * size_dm, 255 * size_dm);
                                    effect[44].setObstacleAlpha(200);
                                    effect[44].position_effect();
                                } else {

                                    effect[44].setObstacleAlpha(0);
                                    effect[44].position_effect();

                                }
                            } else {
                                effect[44].setObstacleAlpha(0);
                                effect[44].position_effect();
                            }
                        } else if (r_obstacle_3[0].position_x < 143 * size_dm) {
                            r_obstacle_3[0].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            effect[44].setObstacleAlpha(0);
                            effect[44].position_effect();
                        } else {
                            r_obstacle_3[0].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            effect[44].setObstacleAlpha(0);
                            effect[44].position_effect();
                        }
                    }
                }

                if (pattern[45] == 1) {
                    if (r_obstacle_3[1].position_x <= 30 * size_dm) {
                        r_obstacle_3[1].position(228 * size_dm, 164 * size_dm);
                        r_obstacle_3[1].setObstacleAlpha(200);
                    } else {
                        if (r_obstacle_3[1].position_x >= 202 * size_dm) {
                            r_obstacle_3[1].setObstacleAlpha(200);
                            r_obstacle_3[1].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[45].position(182 * size_dm, 216 * size_dm);
                                effect[45].setObstacleAlpha(200);
                                effect[45].position_effect();
                            } else {
                                effect[45].setObstacleAlpha(0);
                                effect[45].position_effect();
                            }
                        } else if (r_obstacle_3[1].position_x >= 130 * size_dm && r_obstacle_3[1].position_x <= 182 * size_dm) {

                            if (r_obstacle_3[1].position_x >= 154 * size_dm && r_obstacle_3[1].position_x <= 182 * size_dm) {
                                r_obstacle_3[1].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            } else if (r_obstacle_3[1].position_x >= 130 * size_dm && r_obstacle_3[1].position_x < 154 * size_dm) {
                                r_obstacle_3[1].setPosition(Obstacle_1_Part2_SpeedX, 3);
                            }

                            if (r_obstacle_3[1].position_x >= 150 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[45].position(130 * size_dm, 268 * size_dm);
                                    effect[45].setObstacleAlpha(200);
                                    effect[45].position_effect();
                                } else {

                                    effect[45].setObstacleAlpha(0);
                                    effect[45].position_effect();

                                }
                            } else {
                                effect[45].setObstacleAlpha(0);
                                effect[45].position_effect();
                            }
                        } else if (r_obstacle_3[1].position_x < 130 * size_dm) {
                            r_obstacle_3[1].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            effect[45].setObstacleAlpha(0);
                            effect[45].position_effect();
                        } else {
                            r_obstacle_3[1].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            effect[45].setObstacleAlpha(0);
                            effect[45].position_effect();
                        }
                    }
                }

                if (pattern[46] == 1) {
                    if (r_obstacle_3[2].position_x <= 30 * size_dm) {
                        r_obstacle_3[2].position(228 * size_dm, 164 * size_dm);
                        r_obstacle_3[2].setObstacleAlpha(200);
                    } else {
                        if (r_obstacle_3[2].position_x >= 189 * size_dm) {
                            r_obstacle_3[2].setObstacleAlpha(200);
                            r_obstacle_3[2].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[46].position(169 * size_dm, 229 * size_dm);
                                effect[46].setObstacleAlpha(200);
                                effect[46].position_effect();
                            } else {
                                effect[46].setObstacleAlpha(0);
                                effect[46].position_effect();
                            }
                        } else if (r_obstacle_3[2].position_x >= 117 * size_dm && r_obstacle_3[2].position_x <= 169 * size_dm) {

                            if (r_obstacle_3[2].position_x >= 141 * size_dm && r_obstacle_3[2].position_x <= 169 * size_dm) {
                                r_obstacle_3[2].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            } else if (r_obstacle_3[2].position_x >= 117 * size_dm && r_obstacle_3[2].position_x < 141 * size_dm) {
                                r_obstacle_3[2].setPosition(Obstacle_1_Part2_SpeedX, 3);
                            }

                            if (r_obstacle_3[2].position_x >= 137 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[46].position(117 * size_dm, 281 * size_dm);
                                    effect[46].setObstacleAlpha(200);
                                    effect[46].position_effect();
                                } else {

                                    effect[46].setObstacleAlpha(0);
                                    effect[46].position_effect();

                                }
                            } else {
                                effect[46].setObstacleAlpha(0);
                                effect[46].position_effect();
                            }
                        } else if (r_obstacle_3[2].position_x < 117 * size_dm) {
                            r_obstacle_3[2].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            effect[46].setObstacleAlpha(0);
                            effect[46].position_effect();
                        } else {
                            r_obstacle_3[2].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            effect[46].setObstacleAlpha(0);
                            effect[46].position_effect();
                        }
                    }
                }
                //////////////////////////////////////////////////////////////////////////////////
                if (pattern[47] == 1) {
                    if (r_obstacle_3[3].position_x <= 30 * size_dm) {
                        r_obstacle_3[3].position(228 * size_dm, 164 * size_dm);
                        r_obstacle_3[3].setObstacleAlpha(200);
                    } else {
                        if (r_obstacle_3[3].position_x >= 176 * size_dm) {
                            r_obstacle_3[3].setObstacleAlpha(200);
                            r_obstacle_3[3].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[47].position(156 * size_dm, 242 * size_dm);
                                effect[47].setObstacleAlpha(200);
                                effect[47].position_effect();
                            } else {
                                effect[47].setObstacleAlpha(0);
                                effect[47].position_effect();
                            }
                        } else if (r_obstacle_3[3].position_x >= 104 * size_dm && r_obstacle_3[3].position_x <= 156 * size_dm) {

                            if (r_obstacle_3[3].position_x >= 128 * size_dm && r_obstacle_3[3].position_x <= 156 * size_dm) {
                                r_obstacle_3[3].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            } else if (r_obstacle_3[3].position_x >= 104 * size_dm && r_obstacle_3[3].position_x < 128 * size_dm) {
                                r_obstacle_3[3].setPosition(Obstacle_1_Part2_SpeedX, 3);
                            }

                            if (r_obstacle_3[3].position_x >= 124 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[47].position(104 * size_dm, 294 * size_dm);
                                    effect[47].setObstacleAlpha(200);
                                    effect[47].position_effect();
                                } else {

                                    effect[47].setObstacleAlpha(0);
                                    effect[47].position_effect();

                                }
                            } else {
                                effect[47].setObstacleAlpha(0);
                                effect[47].position_effect();
                            }
                        } else if (r_obstacle_3[3].position_x < 104 * size_dm) {
                            r_obstacle_3[3].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            effect[47].setObstacleAlpha(0);
                            effect[47].position_effect();
                        } else {
                            r_obstacle_3[3].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            effect[47].setObstacleAlpha(0);
                            effect[47].position_effect();
                        }
                    }
                }
                //////////////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[48] == 1) {
                    if (r_obstacle_4[0].position_x <= 30 * size_dm) {
                        r_obstacle_4[0].position(241 * size_dm, 177 * size_dm);
                        r_obstacle_4[0].setObstacleAlpha(200);
                    } else {
                        if (r_obstacle_4[0].position_x >= 228 * size_dm) {
                            r_obstacle_4[0].setObstacleAlpha(200);
                            r_obstacle_4[0].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[48].position(208 * size_dm, 216 * size_dm);
                                effect[48].setObstacleAlpha(200);
                                effect[48].position_effect();
                            } else {
                                effect[48].setObstacleAlpha(0);
                                effect[48].position_effect();
                            }
                        } else if (r_obstacle_4[0].position_x >= 156 * size_dm && r_obstacle_4[0].position_x <= 208 * size_dm) {

                            if (r_obstacle_4[0].position_x >= 180 * size_dm && r_obstacle_4[0].position_x <= 208 * size_dm) {
                                r_obstacle_4[0].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            } else if (r_obstacle_4[0].position_x >= 156 * size_dm && r_obstacle_4[0].position_x < 180 * size_dm) {
                                r_obstacle_4[0].setPosition(Obstacle_1_Part2_SpeedX, 3);
                            }

                            if (r_obstacle_4[0].position_x >= 176 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[48].position(156 * size_dm, 268 * size_dm);
                                    effect[48].setObstacleAlpha(200);
                                    effect[48].position_effect();
                                } else {

                                    effect[48].setObstacleAlpha(0);
                                    effect[48].position_effect();

                                }
                            } else {
                                effect[48].setObstacleAlpha(0);
                                effect[48].position_effect();
                            }
                        } else if (r_obstacle_4[0].position_x < 156 * size_dm) {
                            r_obstacle_4[0].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            effect[48].setObstacleAlpha(0);
                            effect[48].position_effect();
                        } else {
                            r_obstacle_4[0].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            effect[48].setObstacleAlpha(0);
                            effect[48].position_effect();
                        }
                    }
                }
                ///////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[49] == 1) {
                    if (r_obstacle_4[1].position_x <= 30 * size_dm) {
                        r_obstacle_4[1].position(241 * size_dm, 177 * size_dm);
                        r_obstacle_4[1].setObstacleAlpha(200);
                    } else {
                        if (r_obstacle_4[1].position_x >= 215 * size_dm) {
                            r_obstacle_4[1].setObstacleAlpha(200);
                            r_obstacle_4[1].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[49].position(195 * size_dm, 229 * size_dm);
                                effect[49].setObstacleAlpha(200);
                                effect[49].position_effect();
                            } else {
                                effect[49].setObstacleAlpha(0);
                                effect[49].position_effect();
                            }
                        } else if (r_obstacle_4[1].position_x >= 143 * size_dm && r_obstacle_4[1].position_x <= 195 * size_dm) {

                            if (r_obstacle_4[1].position_x >= 167 * size_dm && r_obstacle_4[1].position_x <= 195 * size_dm) {
                                r_obstacle_4[1].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            } else if (r_obstacle_4[1].position_x >= 143 * size_dm && r_obstacle_4[1].position_x < 167 * size_dm) {
                                r_obstacle_4[1].setPosition(Obstacle_1_Part2_SpeedX, 3);
                            }

                            if (r_obstacle_4[1].position_x >= 163 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[49].position(143 * size_dm, 281 * size_dm);
                                    effect[49].setObstacleAlpha(200);
                                    effect[49].position_effect();
                                } else {

                                    effect[49].setObstacleAlpha(0);
                                    effect[49].position_effect();

                                }
                            } else {
                                effect[49].setObstacleAlpha(0);
                                effect[49].position_effect();
                            }
                        } else if (r_obstacle_4[1].position_x < 143 * size_dm) {
                            r_obstacle_4[1].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            effect[49].setObstacleAlpha(0);
                            effect[49].position_effect();
                        } else {
                            r_obstacle_4[1].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            effect[49].setObstacleAlpha(0);
                            effect[49].position_effect();
                        }
                    }
                }
                ///////////////////////////////////////////////////////////////////////////////////
                if (pattern[50] == 1) {
                    if (r_obstacle_4[2].position_x <= 30 * size_dm) {
                        r_obstacle_4[2].position(241 * size_dm, 177 * size_dm);
                        r_obstacle_4[2].setObstacleAlpha(200);
                    } else {
                        if (r_obstacle_4[2].position_x >= 202 * size_dm) {
                            r_obstacle_4[2].setObstacleAlpha(200);
                            r_obstacle_4[2].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[50].position(182 * size_dm, 242 * size_dm);
                                effect[50].setObstacleAlpha(200);
                                effect[50].position_effect();
                            } else {
                                effect[50].setObstacleAlpha(0);
                                effect[50].position_effect();
                            }
                        } else if (r_obstacle_4[2].position_x >= 130 * size_dm && r_obstacle_4[2].position_x <= 182 * size_dm) {

                            if (r_obstacle_4[2].position_x >= 154 * size_dm && r_obstacle_4[2].position_x <= 182 * size_dm) {
                                r_obstacle_4[2].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            } else if (r_obstacle_4[2].position_x >= 130 * size_dm && r_obstacle_4[2].position_x < 154 * size_dm) {
                                r_obstacle_4[2].setPosition(Obstacle_1_Part2_SpeedX, 3);
                            }

                            if (r_obstacle_4[2].position_x >= 150 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[50].position(130 * size_dm, 294 * size_dm);
                                    effect[50].setObstacleAlpha(200);
                                    effect[50].position_effect();
                                } else {

                                    effect[50].setObstacleAlpha(0);
                                    effect[50].position_effect();

                                }
                            } else {
                                effect[50].setObstacleAlpha(0);
                                effect[50].position_effect();
                            }
                        } else if (r_obstacle_4[2].position_x < 130 * size_dm) {
                            r_obstacle_4[2].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            effect[50].setObstacleAlpha(0);
                            effect[50].position_effect();
                        } else {
                            r_obstacle_4[2].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            effect[50].setObstacleAlpha(0);
                            effect[50].position_effect();
                        }
                    }
                }
                ////////////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[51] == 1) {
                    if (r_obstacle_4[3].position_x <= 30 * size_dm) {
                        r_obstacle_4[3].position(241 * size_dm, 177 * size_dm);
                        r_obstacle_4[3].setObstacleAlpha(200);
                    } else {
                        if (r_obstacle_4[3].position_x >= 189 * size_dm) {
                            r_obstacle_4[3].setObstacleAlpha(200);
                            r_obstacle_4[3].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[51].position(169 * size_dm, 255 * size_dm);
                                effect[51].setObstacleAlpha(200);
                                effect[51].position_effect();
                            } else {
                                effect[51].setObstacleAlpha(0);
                                effect[51].position_effect();
                            }
                        } else if (r_obstacle_4[3].position_x >= 117 * size_dm && r_obstacle_4[3].position_x <= 169 * size_dm) {

                            if (r_obstacle_4[3].position_x >= 141 * size_dm && r_obstacle_4[3].position_x <= 169 * size_dm) {
                                r_obstacle_4[3].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            } else if (r_obstacle_4[3].position_x >= 117 * size_dm && r_obstacle_4[3].position_x < 141 * size_dm) {
                                r_obstacle_4[3].setPosition(Obstacle_1_Part2_SpeedX, 3);
                            }

                            if (r_obstacle_4[3].position_x >= 137 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[51].position(117 * size_dm, 307 * size_dm);
                                    effect[51].setObstacleAlpha(200);
                                    effect[51].position_effect();
                                } else {

                                    effect[51].setObstacleAlpha(0);
                                    effect[51].position_effect();

                                }
                            } else {
                                effect[51].setObstacleAlpha(0);
                                effect[51].position_effect();
                            }
                        } else if (r_obstacle_4[3].position_x < 117 * size_dm) {
                            r_obstacle_4[3].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            effect[51].setObstacleAlpha(0);
                            effect[51].position_effect();
                        } else {
                            r_obstacle_4[3].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            effect[51].setObstacleAlpha(0);
                            effect[51].position_effect();
                        }
                    }
                }
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[52] == 1) {
                    if (r_obstacle_5[0].position_x <= 30 * size_dm) {
                        r_obstacle_5[0].position(254 * size_dm, 190 * size_dm);
                        r_obstacle_5[0].setObstacleAlpha(200);
                    } else {
                        if (r_obstacle_5[0].position_x >= 241 * size_dm) {
                            r_obstacle_5[0].setObstacleAlpha(200);
                            r_obstacle_5[0].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[52].position(221 * size_dm, 229 * size_dm);
                                effect[52].setObstacleAlpha(200);
                                effect[52].position_effect();
                            } else {
                                effect[52].setObstacleAlpha(0);
                                effect[52].position_effect();
                            }
                        } else if (r_obstacle_5[0].position_x >= 169 * size_dm && r_obstacle_5[0].position_x <= 221 * size_dm) {

                            if (r_obstacle_5[0].position_x >= 193 * size_dm && r_obstacle_5[0].position_x <= 221 * size_dm) {
                                r_obstacle_5[0].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            } else if (r_obstacle_5[0].position_x >= 169 * size_dm && r_obstacle_5[0].position_x < 193 * size_dm) {
                                r_obstacle_5[0].setPosition(Obstacle_1_Part2_SpeedX, 3);
                            }

                            if (r_obstacle_5[0].position_x >= 189 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[52].position(169 * size_dm, 281 * size_dm);
                                    effect[52].setObstacleAlpha(200);
                                    effect[52].position_effect();
                                } else {

                                    effect[52].setObstacleAlpha(0);
                                    effect[52].position_effect();

                                }
                            } else {
                                effect[52].setObstacleAlpha(0);
                                effect[52].position_effect();
                            }
                        } else if (r_obstacle_5[0].position_x < 169 * size_dm) {
                            r_obstacle_5[0].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            effect[52].setObstacleAlpha(0);
                            effect[52].position_effect();
                        } else {
                            r_obstacle_5[0].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            effect[52].setObstacleAlpha(0);
                            effect[52].position_effect();
                        }
                    }
                }
                /////////////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[53] == 1) {
                    if (r_obstacle_5[1].position_x <= 30 * size_dm) {
                        r_obstacle_5[1].position(254 * size_dm, 190 * size_dm);
                        r_obstacle_5[1].setObstacleAlpha(200);
                    } else {
                        if (r_obstacle_5[1].position_x >= 228 * size_dm) {
                            r_obstacle_5[1].setObstacleAlpha(200);
                            r_obstacle_5[1].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[53].position(208 * size_dm, 242 * size_dm);
                                effect[53].setObstacleAlpha(200);
                                effect[53].position_effect();
                            } else {
                                effect[53].setObstacleAlpha(0);
                                effect[53].position_effect();
                            }
                        } else if (r_obstacle_5[1].position_x >= 156 * size_dm && r_obstacle_5[1].position_x <= 208 * size_dm) {

                            if (r_obstacle_5[1].position_x >= 180 * size_dm && r_obstacle_5[1].position_x <= 208 * size_dm) {
                                r_obstacle_5[1].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            } else if (r_obstacle_5[1].position_x >= 156 * size_dm && r_obstacle_5[1].position_x < 180 * size_dm) {
                                r_obstacle_5[1].setPosition(Obstacle_1_Part2_SpeedX, 3);
                            }

                            if (r_obstacle_5[1].position_x >= 176 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[53].position(156 * size_dm, 294 * size_dm);
                                    effect[53].setObstacleAlpha(200);
                                    effect[53].position_effect();
                                } else {

                                    effect[53].setObstacleAlpha(0);
                                    effect[53].position_effect();

                                }
                            } else {
                                effect[53].setObstacleAlpha(0);
                                effect[53].position_effect();
                            }
                        } else if (r_obstacle_5[1].position_x < 156 * size_dm) {
                            r_obstacle_5[1].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            effect[53].setObstacleAlpha(0);
                            effect[53].position_effect();
                        } else {
                            r_obstacle_5[1].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            effect[53].setObstacleAlpha(0);
                            effect[53].position_effect();
                        }
                    }
                }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[54] == 1) {
                    if (r_obstacle_5[2].position_x <= 30 * size_dm) {
                        r_obstacle_5[2].position(254 * size_dm, 190 * size_dm);
                        r_obstacle_5[2].setObstacleAlpha(200);
                    } else {
                        if (r_obstacle_5[2].position_x >= 215 * size_dm) {
                            r_obstacle_5[2].setObstacleAlpha(200);
                            r_obstacle_5[2].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[54].position(195 * size_dm, 255 * size_dm);
                                effect[54].setObstacleAlpha(200);
                                effect[54].position_effect();
                            } else {
                                effect[54].setObstacleAlpha(0);
                                effect[54].position_effect();
                            }
                        } else if (r_obstacle_5[2].position_x >= 143 * size_dm && r_obstacle_5[2].position_x <= 195 * size_dm) {

                            if (r_obstacle_5[2].position_x >= 167 * size_dm && r_obstacle_5[2].position_x <= 195 * size_dm) {
                                r_obstacle_5[2].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            } else if (r_obstacle_5[2].position_x >= 143 * size_dm && r_obstacle_5[2].position_x < 167 * size_dm) {
                                r_obstacle_5[2].setPosition(Obstacle_1_Part2_SpeedX, 3);
                            }

                            if (r_obstacle_5[2].position_x >= 163 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[54].position(143 * size_dm, 307 * size_dm);
                                    effect[54].setObstacleAlpha(200);
                                    effect[54].position_effect();
                                } else {

                                    effect[54].setObstacleAlpha(0);
                                    effect[54].position_effect();

                                }
                            } else {
                                effect[54].setObstacleAlpha(0);
                                effect[54].position_effect();
                            }
                        } else if (r_obstacle_5[2].position_x < 143 * size_dm) {
                            r_obstacle_5[2].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            effect[54].setObstacleAlpha(0);
                            effect[54].position_effect();
                        } else {
                            r_obstacle_5[2].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            effect[54].setObstacleAlpha(0);
                            effect[54].position_effect();
                        }
                    }
                }
                //////////////////////////////////////////////////////////////////////////////////////
                if (pattern[55] == 1) {
                    if (r_obstacle_5[3].position_x <= 30 * size_dm) {
                        r_obstacle_5[3].position(254 * size_dm, 190 * size_dm);
                        r_obstacle_5[3].setObstacleAlpha(200);
                    } else {
                        if (r_obstacle_5[3].position_x >= 202 * size_dm) {
                            r_obstacle_5[3].setObstacleAlpha(200);
                            r_obstacle_5[3].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[55].position(182 * size_dm, 268 * size_dm);
                                effect[55].setObstacleAlpha(200);
                                effect[55].position_effect();
                            } else {
                                effect[55].setObstacleAlpha(0);
                                effect[55].position_effect();
                            }
                        } else if (r_obstacle_5[3].position_x >= 130 * size_dm && r_obstacle_5[3].position_x <= 182 * size_dm) {

                            if (r_obstacle_5[3].position_x >= 154 * size_dm && r_obstacle_5[3].position_x <= 182 * size_dm) {
                                r_obstacle_5[3].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            } else if (r_obstacle_5[3].position_x >= 130 * size_dm && r_obstacle_5[3].position_x < 154 * size_dm) {
                                r_obstacle_5[3].setPosition(Obstacle_1_Part2_SpeedX, 3);
                            }

                            if (r_obstacle_5[3].position_x >= 150 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[55].position(130 * size_dm, 320 * size_dm);
                                    effect[55].setObstacleAlpha(200);
                                    effect[55].position_effect();
                                } else {

                                    effect[55].setObstacleAlpha(0);
                                    effect[55].position_effect();

                                }
                            } else {
                                effect[55].setObstacleAlpha(0);
                                effect[55].position_effect();
                            }
                        } else if (r_obstacle_5[3].position_x < 130 * size_dm) {
                            r_obstacle_5[3].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            effect[55].setObstacleAlpha(0);
                            effect[55].position_effect();
                        } else {
                            r_obstacle_5[3].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            effect[55].setObstacleAlpha(0);
                            effect[55].position_effect();
                        }
                    }
                }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[56] == 1) {
                    if (r_obstacle_6[0].position_x <= 30 * size_dm) {
                        r_obstacle_6[0].position(267 * size_dm, 203 * size_dm);
                        r_obstacle_6[0].setObstacleAlpha(200);
                    } else {
                        if (r_obstacle_6[0].position_x >= 254 * size_dm) {
                            r_obstacle_6[0].setObstacleAlpha(200);
                            r_obstacle_6[0].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[56].position(234 * size_dm, 242 * size_dm);
                                effect[56].setObstacleAlpha(200);
                                effect[56].position_effect();
                            } else {
                                effect[56].setObstacleAlpha(0);
                                effect[56].position_effect();
                            }
                        } else if (r_obstacle_6[0].position_x >= 182 * size_dm && r_obstacle_6[0].position_x <= 234 * size_dm) {

                            if (r_obstacle_6[0].position_x >= 206 * size_dm && r_obstacle_6[0].position_x <= 234 * size_dm) {
                                r_obstacle_6[0].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            } else if (r_obstacle_6[0].position_x >= 182 * size_dm && r_obstacle_6[0].position_x < 206 * size_dm) {
                                r_obstacle_6[0].setPosition(Obstacle_1_Part2_SpeedX, 3);
                            }

                            if (r_obstacle_6[0].position_x >= 202 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[56].position(182 * size_dm, 294 * size_dm);
                                    effect[56].setObstacleAlpha(200);
                                    effect[56].position_effect();
                                } else {

                                    effect[56].setObstacleAlpha(0);
                                    effect[56].position_effect();

                                }
                            } else {
                                effect[56].setObstacleAlpha(0);
                                effect[56].position_effect();
                            }
                        } else if (r_obstacle_6[0].position_x < 182 * size_dm) {
                            r_obstacle_6[0].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            effect[56].setObstacleAlpha(0);
                            effect[56].position_effect();
                        } else {
                            r_obstacle_6[0].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            effect[56].setObstacleAlpha(0);
                            effect[56].position_effect();
                        }
                    }
                }
                /////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[57] == 1) {
                    if (r_obstacle_6[1].position_x <= 30 * size_dm) {
                        r_obstacle_6[1].position(267 * size_dm, 203 * size_dm);
                        r_obstacle_6[1].setObstacleAlpha(200);
                    } else {
                        if (r_obstacle_6[1].position_x >= 241 * size_dm) {
                            r_obstacle_6[1].setObstacleAlpha(200);
                            r_obstacle_6[1].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[57].position(221 * size_dm, 255 * size_dm);
                                effect[57].setObstacleAlpha(200);
                                effect[57].position_effect();
                            } else {
                                effect[57].setObstacleAlpha(0);
                                effect[57].position_effect();
                            }
                        } else if (r_obstacle_6[1].position_x >= 169 * size_dm && r_obstacle_6[1].position_x <= 221 * size_dm) {

                            if (r_obstacle_6[1].position_x >= 193 * size_dm && r_obstacle_6[1].position_x <= 221 * size_dm) {
                                r_obstacle_6[1].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            } else if (r_obstacle_6[1].position_x >= 169 * size_dm && r_obstacle_6[1].position_x < 193 * size_dm) {
                                r_obstacle_6[1].setPosition(Obstacle_1_Part2_SpeedX, 3);
                            }

                            if (r_obstacle_6[1].position_x >= 189 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[57].position(169 * size_dm, 307 * size_dm);
                                    effect[57].setObstacleAlpha(200);
                                    effect[57].position_effect();
                                } else {

                                    effect[57].setObstacleAlpha(0);
                                    effect[57].position_effect();

                                }
                            } else {
                                effect[57].setObstacleAlpha(0);
                                effect[57].position_effect();
                            }
                        } else if (r_obstacle_6[1].position_x < 169 * size_dm) {
                            r_obstacle_6[1].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            effect[57].setObstacleAlpha(0);
                            effect[57].position_effect();
                        } else {
                            r_obstacle_6[1].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            effect[57].setObstacleAlpha(0);
                            effect[57].position_effect();
                        }
                    }
                }
                ////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[58] == 1) {
                    if (r_obstacle_6[2].position_x <= 30 * size_dm) {
                        r_obstacle_6[2].position(267 * size_dm, 203 * size_dm);
                        r_obstacle_6[2].setObstacleAlpha(200);
                    } else {
                        if (r_obstacle_6[2].position_x >= 228 * size_dm) {
                            r_obstacle_6[2].setObstacleAlpha(200);
                            r_obstacle_6[2].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[58].position(208 * size_dm, 268 * size_dm);
                                effect[58].setObstacleAlpha(200);
                                effect[58].position_effect();
                            } else {
                                effect[58].setObstacleAlpha(0);
                                effect[58].position_effect();
                            }
                        } else if (r_obstacle_6[2].position_x >= 156 * size_dm && r_obstacle_6[2].position_x <= 208 * size_dm) {

                            if (r_obstacle_6[2].position_x >= 180 * size_dm && r_obstacle_6[2].position_x <= 208 * size_dm) {
                                r_obstacle_6[2].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            } else if (r_obstacle_6[2].position_x >= 156 * size_dm && r_obstacle_6[2].position_x < 180 * size_dm) {
                                r_obstacle_6[2].setPosition(Obstacle_1_Part2_SpeedX, 3);
                            }

                            if (r_obstacle_6[2].position_x >= 176 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[58].position(156 * size_dm, 320 * size_dm);
                                    effect[58].setObstacleAlpha(200);
                                    effect[58].position_effect();
                                } else {

                                    effect[58].setObstacleAlpha(0);
                                    effect[58].position_effect();

                                }
                            } else {
                                effect[58].setObstacleAlpha(0);
                                effect[58].position_effect();
                            }
                        } else if (r_obstacle_6[2].position_x < 156 * size_dm) {
                            r_obstacle_6[2].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            effect[58].setObstacleAlpha(0);
                            effect[58].position_effect();
                        } else {
                            r_obstacle_6[2].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            effect[58].setObstacleAlpha(0);
                            effect[58].position_effect();
                        }
                    }
                }
                //////////////////////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[59] == 1) {
                    if (r_obstacle_6[3].position_x <= 30 * size_dm) {
                        r_obstacle_6[3].position(267 * size_dm, 203 * size_dm);
                        r_obstacle_6[3].setObstacleAlpha(200);
                    } else {
                        if (r_obstacle_6[3].position_x >= 215 * size_dm) {
                            r_obstacle_6[3].setObstacleAlpha(200);
                            r_obstacle_6[3].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[59].position(195 * size_dm, 281 * size_dm);
                                effect[59].setObstacleAlpha(200);
                                effect[59].position_effect();
                            } else {
                                effect[59].setObstacleAlpha(0);
                                effect[59].position_effect();
                            }
                        } else if (r_obstacle_6[3].position_x >= 143 * size_dm && r_obstacle_6[3].position_x <= 195 * size_dm) {

                            if (r_obstacle_6[3].position_x >= 167 * size_dm && r_obstacle_6[3].position_x <= 195 * size_dm) {
                                r_obstacle_6[3].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            } else if (r_obstacle_6[3].position_x >= 143 * size_dm && r_obstacle_6[3].position_x < 167 * size_dm) {
                                r_obstacle_6[3].setPosition(Obstacle_1_Part2_SpeedX, 3);
                            }

                            if (r_obstacle_6[3].position_x >= 163 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[59].position(143 * size_dm, 333 * size_dm);
                                    effect[59].setObstacleAlpha(200);
                                    effect[59].position_effect();
                                } else {

                                    effect[59].setObstacleAlpha(0);
                                    effect[59].position_effect();

                                }
                            } else {
                                effect[59].setObstacleAlpha(0);
                                effect[59].position_effect();
                            }
                        } else if (r_obstacle_6[3].position_x < 143 * size_dm) {
                            r_obstacle_6[3].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            effect[59].setObstacleAlpha(0);
                            effect[59].position_effect();
                        } else {
                            r_obstacle_6[3].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            effect[59].setObstacleAlpha(0);
                            effect[59].position_effect();
                        }
                    }
                }
                ///////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[60] == 1) {
                    if (r_obstacle_7[0].position_x <= 30 * size_dm) {
                        r_obstacle_7[0].position(280 * size_dm, 216 * size_dm);
                        r_obstacle_7[0].setObstacleAlpha(200);
                    } else {
                        if (r_obstacle_7[0].position_x >= 267 * size_dm) {
                            r_obstacle_7[0].setObstacleAlpha(200);
                            r_obstacle_7[0].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[60].position(247 * size_dm, 255 * size_dm);
                                effect[60].setObstacleAlpha(200);
                                effect[60].position_effect();
                            } else {
                                effect[60].setObstacleAlpha(0);
                                effect[60].position_effect();
                            }
                        } else if (r_obstacle_7[0].position_x >= 195 * size_dm && r_obstacle_7[0].position_x <= 247 * size_dm) {

                            if (r_obstacle_7[0].position_x >= 219 * size_dm && r_obstacle_7[0].position_x <= 247 * size_dm) {
                                r_obstacle_7[0].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            } else if (r_obstacle_7[0].position_x >= 195 * size_dm && r_obstacle_7[0].position_x < 219 * size_dm) {
                                r_obstacle_7[0].setPosition(Obstacle_1_Part2_SpeedX, 3);
                            }

                            if (r_obstacle_7[0].position_x >= 215 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[60].position(195 * size_dm, 307 * size_dm);
                                    effect[60].setObstacleAlpha(200);
                                    effect[60].position_effect();
                                } else {

                                    effect[60].setObstacleAlpha(0);
                                    effect[60].position_effect();

                                }
                            } else {
                                effect[60].setObstacleAlpha(0);
                                effect[60].position_effect();
                            }
                        } else if (r_obstacle_7[0].position_x < 195 * size_dm) {
                            r_obstacle_7[0].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            effect[60].setObstacleAlpha(0);
                            effect[60].position_effect();
                        } else {
                            r_obstacle_7[0].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            effect[60].setObstacleAlpha(0);
                            effect[60].position_effect();
                        }
                    }
                }
                /////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[61] == 1) {
                    if (r_obstacle_7[1].position_x <= 30 * size_dm) {
                        r_obstacle_7[1].position(280 * size_dm, 216 * size_dm);
                        r_obstacle_7[1].setObstacleAlpha(200);
                    } else {
                        if (r_obstacle_7[1].position_x >= 254 * size_dm) {
                            r_obstacle_7[1].setObstacleAlpha(200);
                            r_obstacle_7[1].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[61].position(234 * size_dm, 268 * size_dm);
                                effect[61].setObstacleAlpha(200);
                                effect[61].position_effect();
                            } else {
                                effect[61].setObstacleAlpha(0);
                                effect[61].position_effect();
                            }
                        } else if (r_obstacle_7[1].position_x >= 182 * size_dm && r_obstacle_7[1].position_x <= 234 * size_dm) {

                            if (r_obstacle_7[1].position_x >= 206 * size_dm && r_obstacle_7[1].position_x <= 234 * size_dm) {
                                r_obstacle_7[1].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            } else if (r_obstacle_7[1].position_x >= 182 * size_dm && r_obstacle_7[1].position_x < 206 * size_dm) {
                                r_obstacle_7[1].setPosition(Obstacle_1_Part2_SpeedX, 3);
                            }

                            if (r_obstacle_7[1].position_x >= 202 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[61].position(182 * size_dm, 320 * size_dm);
                                    effect[61].setObstacleAlpha(200);
                                    effect[61].position_effect();
                                } else {

                                    effect[61].setObstacleAlpha(0);
                                    effect[61].position_effect();

                                }
                            } else {
                                effect[61].setObstacleAlpha(0);
                                effect[61].position_effect();
                            }
                        } else if (r_obstacle_7[1].position_x < 182 * size_dm) {
                            r_obstacle_7[1].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            effect[61].setObstacleAlpha(0);
                            effect[61].position_effect();
                        } else {
                            r_obstacle_7[1].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            effect[61].setObstacleAlpha(0);
                            effect[61].position_effect();
                        }
                    }
                }
                //////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[62] == 1) {
                    if (r_obstacle_7[2].position_x <= 30 * size_dm) {
                        r_obstacle_7[2].position(280 * size_dm, 216 * size_dm);
                        r_obstacle_7[2].setObstacleAlpha(200);
                    } else {
                        if (r_obstacle_7[2].position_x >= 241 * size_dm) {
                            r_obstacle_7[2].setObstacleAlpha(200);
                            r_obstacle_7[2].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[62].position(221 * size_dm, 281 * size_dm);
                                effect[62].setObstacleAlpha(200);
                                effect[62].position_effect();
                            } else {
                                effect[62].setObstacleAlpha(0);
                                effect[62].position_effect();
                            }
                        } else if (r_obstacle_7[2].position_x >= 169 * size_dm && r_obstacle_7[2].position_x <= 221 * size_dm) {

                            if (r_obstacle_7[2].position_x >= 193 * size_dm && r_obstacle_7[2].position_x <= 221 * size_dm) {
                                r_obstacle_7[2].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            } else if (r_obstacle_7[2].position_x >= 169 * size_dm && r_obstacle_7[2].position_x < 193 * size_dm) {
                                r_obstacle_7[2].setPosition(Obstacle_1_Part2_SpeedX, 3);
                            }

                            if (r_obstacle_7[2].position_x >= 189 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[62].position(169 * size_dm, 333 * size_dm);
                                    effect[62].setObstacleAlpha(200);
                                    effect[62].position_effect();
                                } else {

                                    effect[62].setObstacleAlpha(0);
                                    effect[62].position_effect();

                                }
                            } else {
                                effect[62].setObstacleAlpha(0);
                                effect[62].position_effect();
                            }
                        } else if (r_obstacle_7[2].position_x < 169 * size_dm) {
                            r_obstacle_7[2].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            effect[62].setObstacleAlpha(0);
                            effect[62].position_effect();
                        } else {
                            r_obstacle_7[2].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            effect[62].setObstacleAlpha(0);
                            effect[62].position_effect();
                        }
                    }
                }
                ///////////////////////////////////////////////////////////////////////////////////////////////////
                if (pattern[63] == 1) {
                    if (r_obstacle_7[3].position_x <= 30 * size_dm) {
                        r_obstacle_7[3].position(280 * size_dm, 216 * size_dm);
                        r_obstacle_7[3].setObstacleAlpha(200);
                    } else {
                        if (r_obstacle_7[3].position_x >= 228 * size_dm) {
                            r_obstacle_7[3].setObstacleAlpha(200);
                            r_obstacle_7[3].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            if (level_time_number % 2 == 0) {
                                effect[63].position(208 * size_dm, 294 * size_dm);
                                effect[63].setObstacleAlpha(200);
                                effect[63].position_effect();
                            } else {
                                effect[63].setObstacleAlpha(0);
                                effect[63].position_effect();
                            }
                        } else if (r_obstacle_7[3].position_x >= 156 * size_dm && r_obstacle_7[3].position_x <= 208 * size_dm) {

                            if (r_obstacle_7[3].position_x >= 180 * size_dm && r_obstacle_7[3].position_x <= 208 * size_dm) {
                                r_obstacle_7[3].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            } else if (r_obstacle_7[3].position_x >= 156 * size_dm && r_obstacle_7[3].position_x < 180 * size_dm) {
                                r_obstacle_7[3].setPosition(Obstacle_1_Part2_SpeedX, 3);
                            }

                            if (r_obstacle_7[3].position_x >= 176 * size_dm) {
                                if (level_time_number % 2 == 0) {
                                    effect[63].position(156 * size_dm, 346 * size_dm);
                                    effect[63].setObstacleAlpha(200);
                                    effect[63].position_effect();
                                } else {

                                    effect[63].setObstacleAlpha(0);
                                    effect[63].position_effect();

                                }
                            } else {
                                effect[63].setObstacleAlpha(0);
                                effect[63].position_effect();
                            }
                        } else if (r_obstacle_7[3].position_x < 156 * size_dm) {
                            r_obstacle_7[3].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                            effect[63].setObstacleAlpha(0);
                            effect[63].position_effect();
                        } else {
                            r_obstacle_7[3].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                            effect[63].setObstacleAlpha(0);
                            effect[63].position_effect();
                        }
                    }
                }
            }
            /*
            if (obs2_1.position_y >= 350) {
                obs2_1.position(316, 100);
            } else {
                obs2_1.setPosition(x, y);
            }

            if (obs2_2.position_y >= 370) {
                obs2_2.position(290, 100);
            } else {
                obs2_2.setPosition(x, y);
            }
            */
        }
        else if(enemy_action_flag2 == true)
        {
            enemy_bullet[0].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[0].setObstacleAlpha(0);
            enemy_bullet[0].position_effect();
            enemy_shot[0] = 0;

            enemy_bullet[1].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[1].setObstacleAlpha(0);
            enemy_bullet[1].position_effect();
            enemy_shot[1] = 0;

            enemy_bullet[2].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[2].setObstacleAlpha(0);
            enemy_bullet[2].position_effect();
            enemy_shot[2] = 0;

            enemy_bullet[3].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[3].setObstacleAlpha(0);
            enemy_bullet[3].position_effect();
            enemy_shot[3] = 0;

            enemy_bullet[4].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[4].setObstacleAlpha(0);
            enemy_bullet[4].position_effect();
            enemy_shot[4] = 0;

            enemy_bullet[5].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[5].setObstacleAlpha(0);
            enemy_bullet[5].position_effect();
            enemy_shot[5] = 0;

            enemy_bullet[6].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[6].setObstacleAlpha(0);
            enemy_bullet[6].position_effect();
            enemy_shot[6] = 0;

            enemy_bullet[7].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[7].setObstacleAlpha(0);
            enemy_bullet[7].position_effect();
            enemy_shot[7] = 0;

            enemy_bullet[8].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[8].setObstacleAlpha(0);
            enemy_bullet[8].position_effect();
            enemy_shot[8] = 0;

            enemy_bullet[9].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[9].setObstacleAlpha(0);
            enemy_bullet[9].position_effect();
            enemy_shot[9] = 0;


            enemy_bullet[10].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[10].setObstacleAlpha(0);
            enemy_bullet[10].position_effect();
            enemy_shot[10] = 0;


            enemy_bullet[11].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[11].setObstacleAlpha(0);
            enemy_bullet[11].position_effect();
            enemy_shot[11] = 0;


            enemy_bullet[12].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[12].setObstacleAlpha(0);
            enemy_bullet[12].position_effect();
            enemy_shot[12] = 0;


            enemy_bullet[13].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[13].setObstacleAlpha(0);
            enemy_bullet[13].position_effect();
            enemy_shot[13] = 0;


            enemy_bullet[14].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[14].setObstacleAlpha(0);
            enemy_bullet[14].position_effect();
            enemy_shot[14] = 0;


            enemy_bullet[15].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[15].setObstacleAlpha(0);
            enemy_bullet[15].position_effect();
            enemy_shot[15] = 0;


            for(int i=0; i<64; i++)
            {
                pattern[i] = 0;
            }

            for(int i=0; i<64; i++)
            {
                effect[i].setObstacleAlpha(0);
                effect[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                obstacle[i].position(120*size_dm, 125*size_dm);
                obstacle[i].setObstacleAlpha(0);
                obstacle[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                obstacle_1[i].position(107*size_dm, 138*size_dm);
                obstacle_1[i].setObstacleAlpha(0);
                obstacle_1[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                obstacle_2[i].position(94*size_dm, 151*size_dm);
                obstacle_2[i].setObstacleAlpha(0);
                obstacle_2[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                obstacle_3[i].position(81*size_dm, 164*size_dm);
                obstacle_3[i].setObstacleAlpha(0);
                obstacle_3[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                obstacle_4[i].position(68*size_dm, 177*size_dm);
                obstacle_4[i].setObstacleAlpha(0);
                obstacle_4[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                obstacle_5[i].position(55*size_dm, 190*size_dm);
                obstacle_5[i].setObstacleAlpha(0);
                obstacle_5[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                obstacle_6[i].position(42*size_dm, 203*size_dm);
                obstacle_6[i].setObstacleAlpha(0);
                obstacle_6[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                obstacle_7[i].position(29*size_dm, 216*size_dm);
                obstacle_7[i].setObstacleAlpha(0);
                obstacle_7[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                r_obstacle[i].position(189*size_dm, 125*size_dm);
                r_obstacle[i].setObstacleAlpha(0);
                r_obstacle[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                r_obstacle_1[i].position(202*size_dm, 138*size_dm);
                r_obstacle_1[i].setObstacleAlpha(0);
                r_obstacle_1[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                r_obstacle_2[i].position(215*size_dm, 151*size_dm);
                r_obstacle_2[i].setObstacleAlpha(0);
                r_obstacle_2[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                r_obstacle_3[i].position(228*size_dm, 164*size_dm);
                r_obstacle_3[i].setObstacleAlpha(0);
                r_obstacle_3[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                r_obstacle_4[i].position(241*size_dm, 177*size_dm);
                r_obstacle_4[i].setObstacleAlpha(0);
                r_obstacle_4[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                r_obstacle_5[i].position(254*size_dm, 190*size_dm);
                r_obstacle_5[i].setObstacleAlpha(0);
                r_obstacle_5[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                r_obstacle_6[i].position(267*size_dm, 203*size_dm);
                r_obstacle_6[i].setObstacleAlpha(0);
                r_obstacle_6[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                r_obstacle_7[i].position(280*size_dm, 216*size_dm);
                r_obstacle_7[i].setObstacleAlpha(0);
                r_obstacle_7[i].position_effect();
            }

        }
        else if(action_flag1_count2 == 0)
        {
            enemy_bullet[0].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[0].setObstacleAlpha(0);
            enemy_bullet[0].position_effect();
            enemy_shot[0] = 0;

            enemy_bullet[1].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[1].setObstacleAlpha(0);
            enemy_bullet[1].position_effect();
            enemy_shot[1] = 0;

            enemy_bullet[2].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[2].setObstacleAlpha(0);
            enemy_bullet[2].position_effect();
            enemy_shot[2] = 0;

            enemy_bullet[3].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[3].setObstacleAlpha(0);
            enemy_bullet[3].position_effect();
            enemy_shot[3] = 0;

            enemy_bullet[4].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[4].setObstacleAlpha(0);
            enemy_bullet[4].position_effect();
            enemy_shot[4] = 0;

            enemy_bullet[5].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[5].setObstacleAlpha(0);
            enemy_bullet[5].position_effect();
            enemy_shot[5] = 0;

            enemy_bullet[6].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[6].setObstacleAlpha(0);
            enemy_bullet[6].position_effect();
            enemy_shot[6] = 0;

            enemy_bullet[7].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[7].setObstacleAlpha(0);
            enemy_bullet[7].position_effect();
            enemy_shot[7] = 0;

            enemy_bullet[8].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[8].setObstacleAlpha(0);
            enemy_bullet[8].position_effect();
            enemy_shot[8] = 0;

            enemy_bullet[9].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[9].setObstacleAlpha(0);
            enemy_bullet[9].position_effect();
            enemy_shot[9] = 0;


            enemy_bullet[10].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[10].setObstacleAlpha(0);
            enemy_bullet[10].position_effect();
            enemy_shot[10] = 0;


            enemy_bullet[11].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[11].setObstacleAlpha(0);
            enemy_bullet[11].position_effect();
            enemy_shot[11] = 0;


            enemy_bullet[12].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[12].setObstacleAlpha(0);
            enemy_bullet[12].position_effect();
            enemy_shot[12] = 0;


            enemy_bullet[13].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[13].setObstacleAlpha(0);
            enemy_bullet[13].position_effect();
            enemy_shot[13] = 0;


            enemy_bullet[14].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[14].setObstacleAlpha(0);
            enemy_bullet[14].position_effect();
            enemy_shot[14] = 0;


            enemy_bullet[15].position((int) enemy_center.getX(), (int) enemy_center.getY());
            enemy_bullet[15].setObstacleAlpha(0);
            enemy_bullet[15].position_effect();
            enemy_shot[15] = 0;


            for(int i=0; i<64; i++)
            {
                pattern[i] = 0;
            }

            for(int i=0; i<64; i++)
            {
                effect[i].setObstacleAlpha(0);
                effect[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                obstacle[i].position(120*size_dm, 125*size_dm);
                obstacle[i].setObstacleAlpha(0);
                obstacle[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                obstacle_1[i].position(107*size_dm, 138*size_dm);
                obstacle_1[i].setObstacleAlpha(0);
                obstacle_1[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                obstacle_2[i].position(94*size_dm, 151*size_dm);
                obstacle_2[i].setObstacleAlpha(0);
                obstacle_2[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                obstacle_3[i].position(81*size_dm, 164*size_dm);
                obstacle_3[i].setObstacleAlpha(0);
                obstacle_3[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                obstacle_4[i].position(68*size_dm, 177*size_dm);
                obstacle_4[i].setObstacleAlpha(0);
                obstacle_4[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                obstacle_5[i].position(55*size_dm, 190*size_dm);
                obstacle_5[i].setObstacleAlpha(0);
                obstacle_5[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                obstacle_6[i].position(42*size_dm, 203*size_dm);
                obstacle_6[i].setObstacleAlpha(0);
                obstacle_6[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                obstacle_7[i].position(29*size_dm, 216*size_dm);
                obstacle_7[i].setObstacleAlpha(0);
                obstacle_7[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                r_obstacle[i].position(189*size_dm, 125*size_dm);
                r_obstacle[i].setObstacleAlpha(0);
                r_obstacle[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                r_obstacle_1[i].position(202*size_dm, 138*size_dm);
                r_obstacle_1[i].setObstacleAlpha(0);
                r_obstacle_1[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                r_obstacle_2[i].position(215*size_dm, 151*size_dm);
                r_obstacle_2[i].setObstacleAlpha(0);
                r_obstacle_2[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                r_obstacle_3[i].position(228*size_dm, 164*size_dm);
                r_obstacle_3[i].setObstacleAlpha(0);
                r_obstacle_3[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                r_obstacle_4[i].position(241*size_dm, 177*size_dm);
                r_obstacle_4[i].setObstacleAlpha(0);
                r_obstacle_4[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                r_obstacle_5[i].position(254*size_dm, 190*size_dm);
                r_obstacle_5[i].setObstacleAlpha(0);
                r_obstacle_5[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                r_obstacle_6[i].position(267*size_dm, 203*size_dm);
                r_obstacle_6[i].setObstacleAlpha(0);
                r_obstacle_6[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                r_obstacle_7[i].position(280*size_dm, 216*size_dm);
                r_obstacle_7[i].setObstacleAlpha(0);
                r_obstacle_7[i].position_effect();
            }
        }
    }

    void enemy_attack1()
    {
        if(enemy_maximum_energy3 > 5*size_dm && action_flag1_count != 0 && enemy_action_flag1 == false)
        {
            if (pattern[0] == 1) {
                if (obstacle[0].position_x >= 250 * size_dm) {
                    obstacle[0].position(120 * size_dm, 125 * size_dm);
                    obstacle[0].setObstacleAlpha(200);
                } else {
                    if (obstacle[0].position_x <= 136 * size_dm && obstacle[0].position_x >= 0) {
                        obstacle[0].setObstacleAlpha(200);
                        obstacle[0].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[0].position(156 * size_dm, 164 * size_dm);
                            effect[0].setObstacleAlpha(200);
                            effect[0].position_effect();
                        } else {
                            effect[0].setObstacleAlpha(0);
                            effect[0].position_effect();
                        }
                    } else if (obstacle[0].position_x >= 157 * size_dm && obstacle[0].position_x <= 208 * size_dm) {

                        if (obstacle[0].position_x >= 157 * size_dm && obstacle[0].position_x <= 185 * size_dm) {
                            obstacle[0].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        } else if (obstacle[0].position_x > 185 * size_dm && obstacle[0].position_x <= 208 * size_dm) {
                            obstacle[0].setPosition(Obstacle_Part1_SpeedX, 3);
                        }

                        if (obstacle[0].position_x <= 188 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[0].position(208 * size_dm, 216 * size_dm);
                                effect[0].setObstacleAlpha(200);
                                effect[0].position_effect();
                            } else {

                                effect[0].setObstacleAlpha(0);
                                effect[0].position_effect();

                            }
                        } else {
                            effect[0].setObstacleAlpha(0);
                            effect[0].position_effect();
                        }
                    } else if (obstacle[0].position_x > 208 * size_dm) {
                        obstacle[0].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        effect[0].setObstacleAlpha(0);
                        effect[0].position_effect();
                    } else {
                        obstacle[0].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        effect[0].setObstacleAlpha(0);
                        effect[0].position_effect();
                    }
                }
            }
            /////////////////////////////////////////////////////////////////////////////////////////

            if (pattern[1] == 1) {
                if (obstacle[1].position_x >= 250 * size_dm) {
                    obstacle[1].position(120 * size_dm, 125 * size_dm);
                    obstacle[1].setObstacleAlpha(200);
                } else {
                    if (obstacle[1].position_x <= 149 * size_dm && obstacle[1].position_x >= 0) {
                        obstacle[1].setObstacleAlpha(200);
                        obstacle[1].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[1].position(169 * size_dm, 177 * size_dm);
                            effect[1].setObstacleAlpha(200);
                            effect[1].position_effect();
                        } else {
                            effect[1].setObstacleAlpha(0);
                            effect[1].position_effect();
                        }
                    } else if (obstacle[1].position_x >= 169 * size_dm && obstacle[1].position_x <= 221 * size_dm) {

                        if (obstacle[1].position_x >= 169 * size_dm && obstacle[1].position_x <= 197 * size_dm) {
                            obstacle[1].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        } else if (obstacle[1].position_x > 197 * size_dm && obstacle[1].position_x <= 221 * size_dm) {
                            obstacle[1].setPosition(Obstacle_Part1_SpeedX, 3);
                        }

                        if (obstacle[1].position_x <= 201 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[1].position(221 * size_dm, 229 * size_dm);
                                effect[1].setObstacleAlpha(200);
                                effect[1].position_effect();
                            } else {

                                effect[1].setObstacleAlpha(0);
                                effect[1].position_effect();

                            }
                        } else {
                            effect[1].setObstacleAlpha(0);
                            effect[1].position_effect();
                        }
                    } else if (obstacle[1].position_x > 221 * size_dm) {
                        obstacle[1].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        effect[1].setObstacleAlpha(0);
                        effect[1].position_effect();
                    } else {
                        obstacle[1].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        effect[1].setObstacleAlpha(0);
                        effect[1].position_effect();
                    }
                }
            }
            ////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[2] == 1) {
                if (obstacle[2].position_x >= 250 * size_dm) {
                    obstacle[2].position(120 * size_dm, 125 * size_dm);
                    obstacle[2].setObstacleAlpha(200);
                } else {
                    if (obstacle[2].position_x <= 162 * size_dm && obstacle[2].position_x >= 0) {
                        obstacle[2].setObstacleAlpha(200);
                        obstacle[2].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[2].position(182 * size_dm, 190 * size_dm);
                            effect[2].setObstacleAlpha(200);
                            effect[2].position_effect();
                        } else {
                            effect[2].setObstacleAlpha(0);
                            effect[2].position_effect();
                        }
                    } else if (obstacle[2].position_x >= 182 * size_dm && obstacle[2].position_x <= 234 * size_dm) {

                        if (obstacle[2].position_x >= 182 * size_dm && obstacle[2].position_x <= 210 * size_dm) {
                            obstacle[2].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        } else if (obstacle[2].position_x > 210 * size_dm && obstacle[2].position_x <= 234 * size_dm) {
                            obstacle[2].setPosition(Obstacle_Part1_SpeedX, 3);
                        }

                        if (obstacle[2].position_x <= 214 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[2].position(234 * size_dm, 242 * size_dm);
                                effect[2].setObstacleAlpha(200);
                                effect[2].position_effect();
                            } else {

                                effect[2].setObstacleAlpha(0);
                                effect[2].position_effect();

                            }
                        } else {
                            effect[2].setObstacleAlpha(0);
                            effect[2].position_effect();
                        }
                    } else if (obstacle[2].position_x > 234 * size_dm) {
                        obstacle[2].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        effect[2].setObstacleAlpha(0);
                        effect[2].position_effect();
                    } else {
                        obstacle[2].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        effect[2].setObstacleAlpha(0);
                        effect[2].position_effect();
                    }
                }
            }
            ///////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[3] == 1) {
                if (obstacle[3].position_x >= 250 * size_dm) {
                    obstacle[3].position(120 * size_dm, 125 * size_dm);
                    obstacle[3].setObstacleAlpha(200);
                } else {
                    if (obstacle[3].position_x <= 175 * size_dm && obstacle[3].position_x >= 0) {
                        obstacle[3].setObstacleAlpha(200);
                        obstacle[3].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[3].position(195 * size_dm, 203 * size_dm);
                            effect[3].setObstacleAlpha(200);
                            effect[3].position_effect();
                        } else {
                            effect[3].setObstacleAlpha(0);
                            effect[3].position_effect();
                        }
                    } else if (obstacle[3].position_x >= 195 * size_dm && obstacle[3].position_x <= 247 * size_dm) {

                        if (obstacle[3].position_x >= 195 * size_dm && obstacle[3].position_x <= 223 * size_dm) {
                            obstacle[3].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        } else if (obstacle[3].position_x > 223 * size_dm && obstacle[3].position_x <= 247 * size_dm) {
                            obstacle[3].setPosition(Obstacle_Part1_SpeedX, 3);
                        }

                        if (obstacle[3].position_x <= 227 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[3].position(247 * size_dm, 255 * size_dm);
                                effect[3].setObstacleAlpha(200);
                                effect[3].position_effect();
                            } else {

                                effect[3].setObstacleAlpha(0);
                                effect[3].position_effect();

                            }
                        } else {
                            effect[3].setObstacleAlpha(0);
                            effect[3].position_effect();
                        }
                    } else if (obstacle[3].position_x > 247 * size_dm) {
                        obstacle[3].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        effect[3].setObstacleAlpha(0);
                        effect[3].position_effect();
                    } else {
                        obstacle[3].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        effect[3].setObstacleAlpha(0);
                        effect[3].position_effect();
                    }
                }
            }
            /////////////////////////////////////////////////////////////////////////////////////////////////////

            if (pattern[4] == 1) {
                if (obstacle_1[0].position_x >= 250 * size_dm) {
                    obstacle_1[0].position(107 * size_dm, 138 * size_dm);
                    obstacle_1[0].setObstacleAlpha(200);
                } else {
                    if (obstacle_1[0].position_x <= 123 * size_dm && obstacle_1[0].position_x >= 0) {
                        obstacle_1[0].setObstacleAlpha(200);
                        obstacle_1[0].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[4].position(143 * size_dm, 177 * size_dm);
                            effect[4].setObstacleAlpha(200);
                            effect[4].position_effect();
                        } else {
                            effect[4].setObstacleAlpha(0);
                            effect[4].position_effect();
                        }
                    } else if (obstacle_1[0].position_x >= 143 * size_dm && obstacle_1[0].position_x <= 195 * size_dm) {

                        if (obstacle_1[0].position_x >= 143 * size_dm && obstacle_1[0].position_x <= 171 * size_dm) {
                            obstacle_1[0].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        } else if (obstacle_1[0].position_x > 171 * size_dm && obstacle_1[0].position_x <= 195 * size_dm) {
                            obstacle_1[0].setPosition(Obstacle_Part1_SpeedX, 3);
                        }

                        if (obstacle_1[0].position_x <= 175 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[4].position(195 * size_dm, 203 * size_dm);
                                effect[4].setObstacleAlpha(200);
                                effect[4].position_effect();
                            } else {

                                effect[4].setObstacleAlpha(0);
                                effect[4].position_effect();

                            }
                        } else {
                            effect[4].setObstacleAlpha(0);
                            effect[4].position_effect();
                        }
                    } else if (obstacle_1[0].position_x > 195 * size_dm) {
                        obstacle_1[0].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        effect[4].setObstacleAlpha(0);
                        effect[4].position_effect();
                    } else {
                        obstacle_1[0].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        effect[4].setObstacleAlpha(0);
                        effect[4].position_effect();
                    }
                }
            }
            //////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[5] == 1) {
                if (obstacle_1[1].position_x >= 250 * size_dm) {
                    obstacle_1[1].position(107 * size_dm, 138 * size_dm);
                    obstacle_1[1].setObstacleAlpha(200);
                } else {
                    if (obstacle_1[1].position_x <= 136 * size_dm && obstacle_1[1].position_x >= 0) {
                        obstacle_1[1].setObstacleAlpha(200);
                        obstacle_1[1].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[5].position(156 * size_dm, 190 * size_dm);
                            effect[5].setObstacleAlpha(200);
                            effect[5].position_effect();
                        } else {
                            effect[5].setObstacleAlpha(0);
                            effect[5].position_effect();
                        }
                    } else if (obstacle_1[1].position_x >= 156 * size_dm && obstacle_1[1].position_x <= 208 * size_dm) {

                        if (obstacle_1[1].position_x >= 156 * size_dm && obstacle_1[1].position_x <= 184 * size_dm) {
                            obstacle_1[1].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        } else if (obstacle_1[1].position_x > 184 * size_dm && obstacle_1[1].position_x <= 208 * size_dm) {
                            obstacle_1[1].setPosition(Obstacle_Part1_SpeedX, 3);
                        }

                        if (obstacle_1[1].position_x <= 188 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[5].position(208 * size_dm, 242 * size_dm);
                                effect[5].setObstacleAlpha(200);
                                effect[5].position_effect();
                            } else {

                                effect[5].setObstacleAlpha(0);
                                effect[5].position_effect();

                            }
                        } else {
                            effect[5].setObstacleAlpha(0);
                            effect[5].position_effect();
                        }
                    } else if (obstacle_1[1].position_x > 208 * size_dm) {
                        obstacle_1[1].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        effect[5].setObstacleAlpha(0);
                        effect[5].position_effect();
                    } else {
                        obstacle_1[1].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        effect[5].setObstacleAlpha(0);
                        effect[5].position_effect();
                    }
                }
            }
            //////////////////////////////////////////////////////////////////////////////////////////////////////

            if (pattern[6] == 1) {
                if (obstacle_1[2].position_x >= 250 * size_dm) {
                    obstacle_1[2].position(107 * size_dm, 138 * size_dm);
                    obstacle_1[2].setObstacleAlpha(200);
                } else {
                    if (obstacle_1[2].position_x <= 149 * size_dm && obstacle_1[2].position_x >= 0) {
                        obstacle_1[2].setObstacleAlpha(200);
                        obstacle_1[2].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[6].position(169 * size_dm, 203 * size_dm);
                            effect[6].setObstacleAlpha(200);
                            effect[6].position_effect();
                        } else {
                            effect[6].setObstacleAlpha(0);
                            effect[6].position_effect();
                        }
                    } else if (obstacle_1[2].position_x >= 169 * size_dm && obstacle_1[2].position_x <= 221 * size_dm) {

                        if (obstacle_1[2].position_x >= 169 * size_dm && obstacle_1[2].position_x <= 197 * size_dm) {
                            obstacle_1[2].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        } else if (obstacle_1[2].position_x > 197 * size_dm && obstacle_1[2].position_x <= 221 * size_dm) {
                            obstacle_1[2].setPosition(Obstacle_Part1_SpeedX, 3);
                        }

                        if (obstacle_1[2].position_x <= 201 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[6].position(221 * size_dm, 255 * size_dm);
                                effect[6].setObstacleAlpha(200);
                                effect[6].position_effect();
                            } else {

                                effect[6].setObstacleAlpha(0);
                                effect[6].position_effect();

                            }
                        } else {
                            effect[6].setObstacleAlpha(0);
                            effect[6].position_effect();
                        }
                    } else if (obstacle_1[2].position_x > 221 * size_dm) {
                        obstacle_1[2].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        effect[6].setObstacleAlpha(0);
                        effect[6].position_effect();
                    } else {
                        obstacle_1[2].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        effect[6].setObstacleAlpha(0);
                        effect[6].position_effect();
                    }
                }
            }
            ////////////////////////////////////////////////////////////////////////////////////////////////

            if (pattern[7] == 1) {
                if (obstacle_1[3].position_x >= 250 * size_dm) {
                    obstacle_1[3].position(107 * size_dm, 138 * size_dm);
                    obstacle_1[3].setObstacleAlpha(200);
                } else {
                    if (obstacle_1[3].position_x <= 162 * size_dm && obstacle_1[3].position_x >= 0) {
                        obstacle_1[3].setObstacleAlpha(200);
                        obstacle_1[3].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[7].position(182 * size_dm, 216 * size_dm);
                            effect[7].setObstacleAlpha(200);
                            effect[7].position_effect();
                        } else {
                            effect[7].setObstacleAlpha(0);
                            effect[7].position_effect();
                        }
                    } else if (obstacle_1[3].position_x >= 182 * size_dm && obstacle_1[3].position_x <= 234 * size_dm) {

                        if (obstacle_1[3].position_x >= 182 * size_dm && obstacle_1[3].position_x <= 210 * size_dm) {
                            obstacle_1[3].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        } else if (obstacle_1[3].position_x > 210 * size_dm && obstacle_1[3].position_x <= 234 * size_dm) {
                            obstacle_1[3].setPosition(Obstacle_Part1_SpeedX, 3);
                        }

                        if (obstacle_1[3].position_x <= 214 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[7].position(234 * size_dm, 268 * size_dm);
                                effect[7].setObstacleAlpha(200);
                                effect[7].position_effect();
                            } else {

                                effect[7].setObstacleAlpha(0);
                                effect[7].position_effect();

                            }
                        } else {
                            effect[7].setObstacleAlpha(0);
                            effect[7].position_effect();
                        }
                    } else if (obstacle_1[3].position_x > 234 * size_dm) {
                        obstacle_1[3].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        effect[7].setObstacleAlpha(0);
                        effect[7].position_effect();
                    } else {
                        obstacle_1[3].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        effect[7].setObstacleAlpha(0);
                        effect[7].position_effect();
                    }
                }
            }
            /////////////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[8] == 1) {
                if (obstacle_2[0].position_x >= 250 * size_dm) {
                    obstacle_2[0].position(94 * size_dm, 151 * size_dm);
                    obstacle_2[0].setObstacleAlpha(200);
                } else {
                    if (obstacle_2[0].position_x <= 120 * size_dm && obstacle_2[0].position_x >= 0) {
                        obstacle_2[0].setObstacleAlpha(200);
                        obstacle_2[0].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[8].position(130 * size_dm, 190 * size_dm);
                            effect[8].setObstacleAlpha(200);
                            effect[8].position_effect();
                        } else {
                            effect[8].setObstacleAlpha(0);
                            effect[8].position_effect();
                        }
                    } else if (obstacle_2[0].position_x >= 130 * size_dm && obstacle_2[0].position_x <= 182 * size_dm) {

                        if (obstacle_2[0].position_x >= 130 * size_dm && obstacle_2[0].position_x <= 158 * size_dm) {
                            obstacle_2[0].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        } else if (obstacle_2[0].position_x > 158 * size_dm && obstacle_2[0].position_x <= 182 * size_dm) {
                            obstacle_2[0].setPosition(Obstacle_Part1_SpeedX, 3);
                        }

                        if (obstacle_2[0].position_x <= 162 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[8].position(182 * size_dm, 242 * size_dm);
                                effect[8].setObstacleAlpha(200);
                                effect[8].position_effect();
                            } else {

                                effect[8].setObstacleAlpha(0);
                                effect[8].position_effect();

                            }
                        } else {
                            effect[8].setObstacleAlpha(0);
                            effect[8].position_effect();
                        }
                    } else if (obstacle_2[0].position_x > 182 * size_dm) {
                        obstacle_2[0].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        effect[8].setObstacleAlpha(0);
                        effect[8].position_effect();
                    } else {
                        obstacle_2[0].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        effect[8].setObstacleAlpha(0);
                        effect[8].position_effect();
                    }
                }
            }
            ////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[9] == 1) {
                if (obstacle_2[1].position_x >= 250 * size_dm) {
                    obstacle_2[1].position(94 * size_dm, 151 * size_dm);
                    obstacle_2[1].setObstacleAlpha(200);
                } else {
                    if (obstacle_2[1].position_x <= 123 * size_dm && obstacle_2[1].position_x >= 0) {
                        obstacle_2[1].setObstacleAlpha(200);
                        obstacle_2[1].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[9].position(143 * size_dm, 203 * size_dm);
                            effect[9].setObstacleAlpha(200);
                            effect[9].position_effect();
                        } else {
                            effect[9].setObstacleAlpha(0);
                            effect[9].position_effect();
                        }
                    } else if (obstacle_2[1].position_x >= 143 * size_dm && obstacle_2[1].position_x <= 195 * size_dm) {

                        if (obstacle_2[1].position_x >= 143 * size_dm && obstacle_2[1].position_x <= 171 * size_dm) {
                            obstacle_2[1].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        } else if (obstacle_2[1].position_x > 171*size_dm && obstacle_2[1].position_x <= 195*size_dm) {
                            obstacle_2[1].setPosition(Obstacle_Part1_SpeedX, 3);
                        }

                        if (obstacle_2[1].position_x <= 175 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[9].position(195 * size_dm, 255 * size_dm);
                                effect[9].setObstacleAlpha(200);
                                effect[9].position_effect();
                            } else {

                                effect[9].setObstacleAlpha(0);
                                effect[9].position_effect();

                            }
                        } else {
                            effect[9].setObstacleAlpha(0);
                            effect[9].position_effect();
                        }
                    } else if (obstacle_2[1].position_x > 195 * size_dm) {
                        obstacle_2[1].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        effect[9].setObstacleAlpha(0);
                        effect[9].position_effect();
                    } else {
                        obstacle_2[1].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        effect[9].setObstacleAlpha(0);
                        effect[9].position_effect();
                    }
                }
            }

//////////////////////////////////////////////////////////////////////////////////////////////

            if (pattern[10] == 1) {
                if (obstacle_2[2].position_x >= 250 * size_dm) {
                    obstacle_2[2].position(94 * size_dm, 151 * size_dm);
                    obstacle_2[2].setObstacleAlpha(200);
                } else {
                    if (obstacle_2[2].position_x <= 136 * size_dm && obstacle_2[2].position_x >= 0) {
                        obstacle_2[2].setObstacleAlpha(200);
                        obstacle_2[2].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[10].position(156 * size_dm, 216 * size_dm);
                            effect[10].setObstacleAlpha(200);
                            effect[10].position_effect();
                        } else {
                            effect[10].setObstacleAlpha(0);
                            effect[10].position_effect();
                        }
                    } else if (obstacle_2[2].position_x >= 156 * size_dm && obstacle_2[2].position_x <= 208 * size_dm) {

                        if (obstacle_2[2].position_x >= 156 * size_dm && obstacle_2[2].position_x <= 184 * size_dm) {
                            obstacle_2[2].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        } else if (obstacle_2[2].position_x > 184 * size_dm && obstacle_2[2].position_x <= 208 * size_dm) {
                            obstacle_2[2].setPosition(Obstacle_Part1_SpeedX, 3);
                        }

                        if (obstacle_2[2].position_x <= 188 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[10].position(208 * size_dm, 268 * size_dm);
                                effect[10].setObstacleAlpha(200);
                                effect[10].position_effect();
                            } else {

                                effect[10].setObstacleAlpha(0);
                                effect[10].position_effect();

                            }
                        } else {
                            effect[10].setObstacleAlpha(0);
                            effect[10].position_effect();
                        }
                    } else if (obstacle_2[2].position_x > 208 * size_dm) {
                        obstacle_2[2].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        effect[10].setObstacleAlpha(0);
                        effect[10].position_effect();
                    } else {
                        obstacle_2[2].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        effect[10].setObstacleAlpha(0);
                        effect[10].position_effect();
                    }
                }
            }

            ///////////////////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[11] == 1) {
                if (obstacle_2[3].position_x >= 250 * size_dm) {
                    obstacle_2[3].position(94 * size_dm, 151 * size_dm);
                    obstacle_2[3].setObstacleAlpha(200);
                } else {
                    if (obstacle_2[3].position_x <= 149 * size_dm && obstacle_2[3].position_x >= 0) {
                        obstacle_2[3].setObstacleAlpha(200);
                        obstacle_2[3].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[11].position(169 * size_dm, 229 * size_dm);
                            effect[11].setObstacleAlpha(200);
                            effect[11].position_effect();
                        } else {
                            effect[11].setObstacleAlpha(0);
                            effect[11].position_effect();
                        }
                    } else if (obstacle_2[3].position_x >= 169 * size_dm && obstacle_2[3].position_x <= 221 * size_dm) {

                        if (obstacle_2[3].position_x >= 169 * size_dm && obstacle_2[3].position_x <= 197 * size_dm) {
                            obstacle_2[3].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        } else if (obstacle_2[3].position_x > 197 * size_dm && obstacle_2[3].position_x <= 221 * size_dm) {
                            obstacle_2[3].setPosition(Obstacle_Part1_SpeedX, 3);
                        }

                        if (obstacle_2[3].position_x <= 201 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[11].position(221 * size_dm, 281 * size_dm);
                                effect[11].setObstacleAlpha(200);
                                effect[11].position_effect();
                            } else {

                                effect[11].setObstacleAlpha(0);
                                effect[11].position_effect();

                            }
                        } else {
                            effect[11].setObstacleAlpha(0);
                            effect[11].position_effect();
                        }
                    } else if (obstacle_2[3].position_x > 221 * size_dm) {
                        obstacle_2[3].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        effect[11].setObstacleAlpha(0);
                        effect[11].position_effect();
                    } else {
                        obstacle_2[3].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        effect[11].setObstacleAlpha(0);
                        effect[11].position_effect();
                    }
                }
            }
            /////////////////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[12] == 1) {
                if (obstacle_3[0].position_x >= 250 * size_dm) {
                    obstacle_3[0].position(81 * size_dm, 164 * size_dm);
                    obstacle_3[0].setObstacleAlpha(200);
                } else {
                    if (obstacle_3[0].position_x <= 97 * size_dm && obstacle_3[0].position_x >= 0) {
                        obstacle_3[0].setObstacleAlpha(200);
                        obstacle_3[0].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[12].position(117 * size_dm, 203 * size_dm);
                            effect[12].setObstacleAlpha(200);
                            effect[12].position_effect();
                        } else {
                            effect[12].setObstacleAlpha(0);
                            effect[12].position_effect();
                        }
                    } else if (obstacle_3[0].position_x >= 117 * size_dm && obstacle_3[0].position_x <= 169 * size_dm) {

                        if (obstacle_3[0].position_x >= 117 * size_dm && obstacle_3[0].position_x <= 145 * size_dm) {
                            obstacle_3[0].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        } else if (obstacle_3[0].position_x > 145 * size_dm && obstacle_3[0].position_x <= 169 * size_dm) {
                            obstacle_3[0].setPosition(Obstacle_Part1_SpeedX, 3);
                        }

                        if (obstacle_3[0].position_x <= 149 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[12].position(169 * size_dm, 255 * size_dm);
                                effect[12].setObstacleAlpha(200);
                                effect[12].position_effect();
                            } else {

                                effect[12].setObstacleAlpha(0);
                                effect[12].position_effect();

                            }
                        } else {
                            effect[12].setObstacleAlpha(0);
                            effect[12].position_effect();
                        }
                    } else if (obstacle_3[0].position_x > 169 * size_dm) {
                        obstacle_3[0].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        effect[12].setObstacleAlpha(0);
                        effect[12].position_effect();
                    } else {
                        obstacle_3[0].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        effect[12].setObstacleAlpha(0);
                        effect[12].position_effect();
                    }
                }
            }
            ////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[13] == 1) {
                if (obstacle_3[1].position_x >= 250 * size_dm) {
                    obstacle_3[1].position(81 * size_dm, 164 * size_dm);
                    obstacle_3[1].setObstacleAlpha(200);
                } else {
                    if (obstacle_3[1].position_x <= 110 * size_dm && obstacle_3[1].position_x >= 0) {
                        obstacle_3[1].setObstacleAlpha(200);
                        obstacle_3[1].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[13].position(130 * size_dm, 216 * size_dm);
                            effect[13].setObstacleAlpha(200);
                            effect[13].position_effect();
                        } else {
                            effect[13].setObstacleAlpha(0);
                            effect[13].position_effect();
                        }
                    } else if (obstacle_3[1].position_x >= 130 * size_dm && obstacle_3[1].position_x <= 182 * size_dm) {

                        if (obstacle_3[1].position_x >= 130 * size_dm && obstacle_3[1].position_x <= 158 * size_dm) {
                            obstacle_3[1].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        } else if (obstacle_3[1].position_x > 158 * size_dm && obstacle_3[1].position_x <= 182 * size_dm) {
                            obstacle_3[1].setPosition(Obstacle_Part1_SpeedX, 3);
                        }

                        if (obstacle_3[1].position_x <= 162 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[13].position(182 * size_dm, 268 * size_dm);
                                effect[13].setObstacleAlpha(200);
                                effect[13].position_effect();
                            } else {

                                effect[13].setObstacleAlpha(0);
                                effect[13].position_effect();

                            }
                        } else {
                            effect[13].setObstacleAlpha(0);
                            effect[13].position_effect();
                        }
                    } else if (obstacle_3[1].position_x > 182 * size_dm) {
                        obstacle_3[1].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        effect[13].setObstacleAlpha(0);
                        effect[13].position_effect();
                    } else {
                        obstacle_3[1].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        effect[13].setObstacleAlpha(0);
                        effect[13].position_effect();
                    }
                }
            }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[14] == 1) {
                if (obstacle_3[2].position_x >= 250 * size_dm) {
                    obstacle_3[2].position(81 * size_dm, 164 * size_dm);
                    obstacle_3[2].setObstacleAlpha(200);
                } else {
                    if (obstacle_3[2].position_x <= 123 * size_dm && obstacle_3[2].position_x >= 0) {
                        obstacle_3[2].setObstacleAlpha(200);
                        obstacle_3[2].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[14].position(143 * size_dm, 229 * size_dm);
                            effect[14].setObstacleAlpha(200);
                            effect[14].position_effect();
                        } else {
                            effect[14].setObstacleAlpha(0);
                            effect[14].position_effect();
                        }
                    } else if (obstacle_3[2].position_x >= 143 * size_dm && obstacle_3[2].position_x <= 195 * size_dm) {

                        if (obstacle_3[2].position_x >= 143 * size_dm && obstacle_3[2].position_x <= 171 * size_dm) {
                            obstacle_3[2].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        } else if (obstacle_3[2].position_x > 171 * size_dm && obstacle_3[2].position_x <= 195 * size_dm) {
                            obstacle_3[2].setPosition(Obstacle_Part1_SpeedX, 3);
                        }

                        if (obstacle_3[2].position_x <= 175 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[14].position(195 * size_dm, 281 * size_dm);
                                effect[14].setObstacleAlpha(200);
                                effect[14].position_effect();
                            } else {

                                effect[14].setObstacleAlpha(0);
                                effect[14].position_effect();

                            }
                        } else {
                            effect[14].setObstacleAlpha(0);
                            effect[14].position_effect();
                        }
                    } else if (obstacle_3[2].position_x > 195 * size_dm) {
                        obstacle_3[2].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        effect[14].setObstacleAlpha(0);
                        effect[14].position_effect();
                    } else {
                        obstacle_3[2].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        effect[14].setObstacleAlpha(0);
                        effect[14].position_effect();
                    }
                }
            }
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[15] == 1) {
                if (obstacle_3[3].position_x >= 250 * size_dm) {
                    obstacle_3[3].position(81 * size_dm, 164 * size_dm);
                    obstacle_3[3].setObstacleAlpha(200);
                } else {
                    if (obstacle_3[3].position_x <= 136 * size_dm && obstacle_3[3].position_x >= 0) {
                        obstacle_3[3].setObstacleAlpha(200);
                        obstacle_3[3].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[15].position(156 * size_dm, 242 * size_dm);
                            effect[15].setObstacleAlpha(200);
                            effect[15].position_effect();
                        } else {
                            effect[15].setObstacleAlpha(0);
                            effect[15].position_effect();
                        }
                    } else if (obstacle_3[3].position_x >= 156 * size_dm && obstacle_3[3].position_x <= 208 * size_dm) {

                        if (obstacle_3[3].position_x >= 156 * size_dm && obstacle_3[3].position_x <= 184 * size_dm) {
                            obstacle_3[3].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        } else if (obstacle_3[3].position_x > 184 * size_dm && obstacle_3[3].position_x <= 208 * size_dm) {
                            obstacle_3[3].setPosition(Obstacle_Part1_SpeedX, 3);
                        }

                        if (obstacle_3[3].position_x <= 188 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[15].position(208 * size_dm, 294 * size_dm);
                                effect[15].setObstacleAlpha(200);
                                effect[15].position_effect();
                            } else {

                                effect[15].setObstacleAlpha(0);
                                effect[15].position_effect();

                            }
                        } else {
                            effect[15].setObstacleAlpha(0);
                            effect[15].position_effect();
                        }
                    } else if (obstacle_3[3].position_x > 208 * size_dm) {
                        obstacle_3[3].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        effect[15].setObstacleAlpha(0);
                        effect[15].position_effect();
                    } else {
                        obstacle_3[3].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        effect[15].setObstacleAlpha(0);
                        effect[15].position_effect();
                    }
                }
            }
            //////////////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[16] == 1) {
                if (obstacle_4[0].position_x >= 250 * size_dm) {
                    obstacle_4[0].position(68 * size_dm, 177 * size_dm);
                    obstacle_4[0].setObstacleAlpha(200);
                } else {
                    if (obstacle_4[0].position_x <= 84 * size_dm && obstacle_4[0].position_x >= 0) {
                        obstacle_4[0].setObstacleAlpha(200);
                        obstacle_4[0].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[16].position(104 * size_dm, 216 * size_dm);
                            effect[16].setObstacleAlpha(200);
                            effect[16].position_effect();
                        } else {
                            effect[16].setObstacleAlpha(0);
                            effect[16].position_effect();
                        }
                    } else if (obstacle_4[0].position_x >= 104 * size_dm && obstacle_4[0].position_x <= 156 * size_dm) {

                        if (obstacle_4[0].position_x >= 104 * size_dm && obstacle_4[0].position_x <= 132 * size_dm) {
                            obstacle_4[0].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        } else if (obstacle_4[0].position_x > 132 * size_dm && obstacle_4[0].position_x <= 156 * size_dm) {
                            obstacle_4[0].setPosition(Obstacle_Part1_SpeedX, 3);
                        }

                        if (obstacle_4[0].position_x <= 136 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[16].position(156 * size_dm, 268 * size_dm);
                                effect[16].setObstacleAlpha(200);
                                effect[16].position_effect();
                            } else {

                                effect[16].setObstacleAlpha(0);
                                effect[16].position_effect();

                            }
                        } else {
                            effect[16].setObstacleAlpha(0);
                            effect[16].position_effect();
                        }
                    } else if (obstacle_4[0].position_x > 156 * size_dm) {
                        obstacle_4[0].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        effect[16].setObstacleAlpha(0);
                        effect[16].position_effect();
                    } else {
                        obstacle_4[0].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        effect[16].setObstacleAlpha(0);
                        effect[16].position_effect();
                    }
                }
            }
            ///////////////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[17] == 1) {
                if (obstacle_4[1].position_x >= 250 * size_dm) {
                    obstacle_4[1].position(68 * size_dm, 177 * size_dm);
                    obstacle_4[1].setObstacleAlpha(200);
                } else {
                    if (obstacle_4[1].position_x <= 97 * size_dm && obstacle_4[1].position_x >= 0) {
                        obstacle_4[1].setObstacleAlpha(200);
                        obstacle_4[1].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[17].position(117 * size_dm, 229 * size_dm);
                            effect[17].setObstacleAlpha(200);
                            effect[17].position_effect();
                        } else {
                            effect[17].setObstacleAlpha(0);
                            effect[17].position_effect();
                        }
                    } else if (obstacle_4[1].position_x >= 117 * size_dm && obstacle_4[1].position_x <= 169 * size_dm) {

                        if (obstacle_4[1].position_x >= 117 * size_dm && obstacle_4[1].position_x <= 145 * size_dm) {
                            obstacle_4[1].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        } else if (obstacle_4[1].position_x > 145 * size_dm && obstacle_4[1].position_x <= 169 * size_dm) {
                            obstacle_4[1].setPosition(Obstacle_Part1_SpeedX, 3);
                        }

                        if (obstacle_4[1].position_x <= 149 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[17].position(169 * size_dm, 281 * size_dm);
                                effect[17].setObstacleAlpha(200);
                                effect[17].position_effect();
                            } else {

                                effect[17].setObstacleAlpha(0);
                                effect[17].position_effect();

                            }
                        } else {
                            effect[17].setObstacleAlpha(0);
                            effect[17].position_effect();
                        }
                    } else if (obstacle_4[1].position_x > 169 * size_dm) {
                        obstacle_4[1].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        effect[17].setObstacleAlpha(0);
                        effect[17].position_effect();
                    } else {
                        obstacle_4[1].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        effect[17].setObstacleAlpha(0);
                        effect[17].position_effect();
                    }
                }
            }
//////////////////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[18] == 1) {
                if (obstacle_4[2].position_x >= 250 * size_dm) {
                    obstacle_4[2].position(68 * size_dm, 177 * size_dm);
                    obstacle_4[2].setObstacleAlpha(200);
                } else {
                    if (obstacle_4[2].position_x <= 110 * size_dm && obstacle_4[2].position_x >= 0) {
                        obstacle_4[2].setObstacleAlpha(200);
                        obstacle_4[2].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[18].position(130 * size_dm, 242 * size_dm);
                            effect[18].setObstacleAlpha(200);
                            effect[18].position_effect();
                        } else {
                            effect[18].setObstacleAlpha(0);
                            effect[18].position_effect();
                        }
                    } else if (obstacle_4[2].position_x >= 130 * size_dm && obstacle_4[2].position_x <= 182 * size_dm) {

                        if (obstacle_4[2].position_x >= 130 * size_dm && obstacle_4[2].position_x <= 158 * size_dm) {
                            obstacle_4[2].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        } else if (obstacle_4[2].position_x > 158 * size_dm && obstacle_4[2].position_x <= 182 * size_dm) {
                            obstacle_4[2].setPosition(Obstacle_Part1_SpeedX, 3);
                        }

                        if (obstacle_4[2].position_x <= 162 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[18].position(182 * size_dm, 294 * size_dm);
                                effect[18].setObstacleAlpha(200);
                                effect[18].position_effect();
                            } else {

                                effect[18].setObstacleAlpha(0);
                                effect[18].position_effect();

                            }
                        } else {
                            effect[18].setObstacleAlpha(0);
                            effect[18].position_effect();
                        }
                    } else if (obstacle_4[2].position_x > 182 * size_dm) {
                        obstacle_4[2].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        effect[18].setObstacleAlpha(0);
                        effect[18].position_effect();
                    } else {
                        obstacle_4[2].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        effect[18].setObstacleAlpha(0);
                        effect[18].position_effect();
                    }
                }
            }
            //////////////////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[19] == 1) {
                if (obstacle_4[3].position_x >= 250 * size_dm) {
                    obstacle_4[3].position(68 * size_dm, 177 * size_dm);
                    obstacle_4[3].setObstacleAlpha(200);
                } else {
                    if (obstacle_4[3].position_x <= 123 && obstacle_4[3].position_x >= 0) {
                        obstacle_4[3].setObstacleAlpha(200);
                        obstacle_4[3].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[19].position(143 * size_dm, 255 * size_dm);
                            effect[19].setObstacleAlpha(200);
                            effect[19].position_effect();
                        } else {
                            effect[19].setObstacleAlpha(0);
                            effect[19].position_effect();
                        }
                    } else if (obstacle_4[3].position_x >= 143 * size_dm && obstacle_4[3].position_x <= 195 * size_dm) {

                        if (obstacle_4[3].position_x >= 143 * size_dm && obstacle_4[3].position_x <= 171 * size_dm) {
                            obstacle_4[3].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        } else if (obstacle_4[3].position_x > 171 * size_dm && obstacle_4[3].position_x <= 195 * size_dm) {
                            obstacle_4[3].setPosition(Obstacle_Part1_SpeedX, 3);
                        }

                        if (obstacle_4[3].position_x <= 175 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[19].position(195 * size_dm, 307 * size_dm);
                                effect[19].setObstacleAlpha(200);
                                effect[19].position_effect();
                            } else {

                                effect[19].setObstacleAlpha(0);
                                effect[19].position_effect();

                            }
                        } else {
                            effect[19].setObstacleAlpha(0);
                            effect[19].position_effect();
                        }
                    } else if (obstacle_4[3].position_x > 195 * size_dm) {
                        obstacle_4[3].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        effect[19].setObstacleAlpha(0);
                        effect[19].position_effect();
                    } else {
                        obstacle_4[3].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        effect[19].setObstacleAlpha(0);
                        effect[19].position_effect();
                    }
                }
            }
            ///////////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[20] == 1) {
                if (obstacle_5[0].position_x >= 250 * size_dm) {
                    obstacle_5[0].position(55 * size_dm, 190 * size_dm);
                    obstacle_5[0].setObstacleAlpha(200);
                } else {
                    if (obstacle_5[0].position_x <= 71 * size_dm && obstacle_5[0].position_x >= 0) {
                        obstacle_5[0].setObstacleAlpha(200);
                        obstacle_5[0].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[20].position(91 * size_dm, 229 * size_dm);
                            effect[20].setObstacleAlpha(200);
                            effect[20].position_effect();
                        } else {
                            effect[20].setObstacleAlpha(0);
                            effect[20].position_effect();
                        }
                    } else if (obstacle_5[0].position_x >= 91 * size_dm && obstacle_5[0].position_x <= 143 * size_dm) {

                        if (obstacle_5[0].position_x >= 91 * size_dm && obstacle_5[0].position_x <= 119 * size_dm) {
                            obstacle_5[0].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        } else if (obstacle_5[0].position_x > 119 * size_dm && obstacle_5[0].position_x <= 143 * size_dm) {
                            obstacle_5[0].setPosition(Obstacle_Part1_SpeedX, 3);
                        }

                        if (obstacle_5[0].position_x <= 123 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[20].position(143 * size_dm, 281 * size_dm);
                                effect[20].setObstacleAlpha(200);
                                effect[20].position_effect();
                            } else {

                                effect[20].setObstacleAlpha(0);
                                effect[20].position_effect();

                            }
                        } else {
                            effect[20].setObstacleAlpha(0);
                            effect[20].position_effect();
                        }
                    } else if (obstacle_5[0].position_x > 143 * size_dm) {
                        obstacle_5[0].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        effect[20].setObstacleAlpha(0);
                        effect[20].position_effect();
                    } else {
                        obstacle_5[0].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        effect[20].setObstacleAlpha(0);
                        effect[20].position_effect();
                    }
                }
            }
            //////////////////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[21] == 1) {
                if (obstacle_5[1].position_x >= 250 * size_dm) {
                    obstacle_5[1].position(55 * size_dm, 190 * size_dm);
                    obstacle_5[1].setObstacleAlpha(200);
                } else {
                    if (obstacle_5[1].position_x <= 84 * size_dm && obstacle_5[1].position_x >= 0) {
                        obstacle_5[1].setObstacleAlpha(200);
                        obstacle_5[1].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[21].position(104 * size_dm, 242 * size_dm);
                            effect[21].setObstacleAlpha(200);
                            effect[21].position_effect();
                        } else {
                            effect[21].setObstacleAlpha(0);
                            effect[21].position_effect();
                        }
                    } else if (obstacle_5[1].position_x >= 104 * size_dm && obstacle_5[1].position_x <= 156 * size_dm) {

                        if (obstacle_5[1].position_x >= 104 * size_dm && obstacle_5[1].position_x <= 132 * size_dm) {
                            obstacle_5[1].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        } else if (obstacle_5[1].position_x > 132 * size_dm && obstacle_5[1].position_x <= 156 * size_dm) {
                            obstacle_5[1].setPosition(Obstacle_Part1_SpeedX, 3);
                        }

                        if (obstacle_5[1].position_x <= 136 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[21].position(156 * size_dm, 294 * size_dm);
                                effect[21].setObstacleAlpha(200);
                                effect[21].position_effect();
                            } else {

                                effect[21].setObstacleAlpha(0);
                                effect[21].position_effect();

                            }
                        } else {
                            effect[21].setObstacleAlpha(0);
                            effect[21].position_effect();
                        }
                    } else if (obstacle_5[1].position_x > 156 * size_dm) {
                        obstacle_5[1].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        effect[21].setObstacleAlpha(0);
                        effect[21].position_effect();
                    } else {
                        obstacle_5[1].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        effect[21].setObstacleAlpha(0);
                        effect[21].position_effect();
                    }
                }
            }
            ///////////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[22] == 1) {
                if (obstacle_5[2].position_x >= 250 * size_dm) {
                    obstacle_5[2].position(55 * size_dm, 190 * size_dm);
                    obstacle_5[2].setObstacleAlpha(200);
                } else {
                    if (obstacle_5[2].position_x <= 97 * size_dm && obstacle_5[2].position_x >= 0) {
                        obstacle_5[2].setObstacleAlpha(200);
                        obstacle_5[2].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[22].position(117 * size_dm, 255 * size_dm);
                            effect[22].setObstacleAlpha(200);
                            effect[22].position_effect();
                        } else {
                            effect[22].setObstacleAlpha(0);
                            effect[22].position_effect();
                        }
                    } else if (obstacle_5[2].position_x >= 117 * size_dm && obstacle_5[2].position_x <= 169 * size_dm) {

                        if (obstacle_5[2].position_x >= 117 * size_dm && obstacle_5[2].position_x <= 145 * size_dm) {
                            obstacle_5[2].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        } else if (obstacle_5[2].position_x > 145 * size_dm && obstacle_5[2].position_x <= 169 * size_dm) {
                            obstacle_5[2].setPosition(Obstacle_Part1_SpeedX, 3);
                        }

                        if (obstacle_5[2].position_x <= 149 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[22].position(169 * size_dm, 307 * size_dm);
                                effect[22].setObstacleAlpha(200);
                                effect[22].position_effect();
                            } else {

                                effect[22].setObstacleAlpha(0);
                                effect[22].position_effect();

                            }
                        } else {
                            effect[22].setObstacleAlpha(0);
                            effect[22].position_effect();
                        }
                    } else if (obstacle_5[2].position_x > 169 * size_dm) {
                        obstacle_5[2].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        effect[22].setObstacleAlpha(0);
                        effect[22].position_effect();
                    } else {
                        obstacle_5[2].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        effect[22].setObstacleAlpha(0);
                        effect[22].position_effect();
                    }
                }
            }
            /////////////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[23] == 1) {
                if (obstacle_5[3].position_x >= 250 * size_dm) {
                    obstacle_5[3].position(55 * size_dm, 190 * size_dm);
                    obstacle_5[3].setObstacleAlpha(200);
                } else {
                    if (obstacle_5[3].position_x <= 110 * size_dm && obstacle_5[3].position_x >= 0) {
                        obstacle_5[3].setObstacleAlpha(200);
                        obstacle_5[3].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[23].position(130 * size_dm, 268 * size_dm);
                            effect[23].setObstacleAlpha(200);
                            effect[23].position_effect();
                        } else {
                            effect[23].setObstacleAlpha(0);
                            effect[23].position_effect();
                        }
                    } else if (obstacle_5[3].position_x >= 130 * size_dm && obstacle_5[3].position_x <= 182 * size_dm) {

                        if (obstacle_5[3].position_x >= 130 * size_dm && obstacle_5[3].position_x <= 158 * size_dm) {
                            obstacle_5[3].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        } else if (obstacle_5[3].position_x > 158 * size_dm && obstacle_5[3].position_x <= 182 * size_dm) {
                            obstacle_5[3].setPosition(Obstacle_Part1_SpeedX, 3);
                        }

                        if (obstacle_5[3].position_x <= 162 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[23].position(182 * size_dm, 320 * size_dm);
                                effect[23].setObstacleAlpha(200);
                                effect[23].position_effect();
                            } else {

                                effect[23].setObstacleAlpha(0);
                                effect[23].position_effect();

                            }
                        } else {
                            effect[23].setObstacleAlpha(0);
                            effect[23].position_effect();
                        }
                    } else if (obstacle_5[3].position_x > 182 * size_dm) {
                        obstacle_5[3].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        effect[23].setObstacleAlpha(0);
                        effect[23].position_effect();
                    } else {
                        obstacle_5[3].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        effect[23].setObstacleAlpha(0);
                        effect[23].position_effect();
                    }
                }
            }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[24] == 1) {
                if (obstacle_6[0].position_x >= 250 * size_dm) {
                    obstacle_6[0].position(42 * size_dm, 203 * size_dm);
                    obstacle_6[0].setObstacleAlpha(200);
                } else {
                    if (obstacle_6[0].position_x <= 58 * size_dm && obstacle_6[0].position_x >= 0) {
                        obstacle_6[0].setObstacleAlpha(200);
                        obstacle_6[0].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[24].position(78 * size_dm, 242 * size_dm);
                            effect[24].setObstacleAlpha(200);
                            effect[24].position_effect();
                        } else {
                            effect[24].setObstacleAlpha(0);
                            effect[24].position_effect();
                        }
                    } else if (obstacle_6[0].position_x >= 78 * size_dm && obstacle_6[0].position_x <= 130 * size_dm) {

                        if (obstacle_6[0].position_x >= 78 * size_dm && obstacle_6[0].position_x <= 106 * size_dm) {
                            obstacle_6[0].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        } else if (obstacle_6[0].position_x > 106 * size_dm && obstacle_6[0].position_x <= 130 * size_dm) {
                            obstacle_6[0].setPosition(Obstacle_Part1_SpeedX, 3);
                        }

                        if (obstacle_6[0].position_x <= 110 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[24].position(130 * size_dm, 294 * size_dm);
                                effect[24].setObstacleAlpha(200);
                                effect[24].position_effect();
                            } else {

                                effect[24].setObstacleAlpha(0);
                                effect[24].position_effect();

                            }
                        } else {
                            effect[24].setObstacleAlpha(0);
                            effect[24].position_effect();
                        }
                    } else if (obstacle_6[0].position_x > 130 * size_dm) {
                        obstacle_6[0].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        effect[24].setObstacleAlpha(0);
                        effect[24].position_effect();
                    } else {
                        obstacle_6[0].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        effect[24].setObstacleAlpha(0);
                        effect[24].position_effect();
                    }
                }
            }
//////////////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[25] == 1) {
                if (obstacle_6[1].position_x >= 250 * size_dm) {
                    obstacle_6[1].position(42 * size_dm, 203 * size_dm);
                    obstacle_6[1].setObstacleAlpha(200);
                } else {
                    if (obstacle_6[1].position_x <= 71 * size_dm && obstacle_6[1].position_x >= 0) {
                        obstacle_6[1].setObstacleAlpha(200);
                        obstacle_6[1].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[25].position(91 * size_dm, 255 * size_dm);
                            effect[25].setObstacleAlpha(200);
                            effect[25].position_effect();
                        } else {
                            effect[25].setObstacleAlpha(0);
                            effect[25].position_effect();
                        }
                    } else if (obstacle_6[1].position_x >= 91 * size_dm && obstacle_6[1].position_x <= 143 * size_dm) {

                        if (obstacle_6[1].position_x >= 91 * size_dm && obstacle_6[1].position_x <= 119 * size_dm) {
                            obstacle_6[1].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        } else if (obstacle_6[1].position_x > 119 * size_dm && obstacle_6[1].position_x <= 143 * size_dm) {
                            obstacle_6[1].setPosition(Obstacle_Part1_SpeedX, 3);
                        }

                        if (obstacle_6[1].position_x <= 123 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[25].position(143 * size_dm, 307 * size_dm);
                                effect[25].setObstacleAlpha(200);
                                effect[25].position_effect();
                            } else {

                                effect[25].setObstacleAlpha(0);
                                effect[25].position_effect();

                            }
                        } else {
                            effect[25].setObstacleAlpha(0);
                            effect[25].position_effect();
                        }
                    } else if (obstacle_6[1].position_x > 143 * size_dm) {
                        obstacle_6[1].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        effect[25].setObstacleAlpha(0);
                        effect[25].position_effect();
                    } else {
                        obstacle_6[1].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        effect[25].setObstacleAlpha(0);
                        effect[25].position_effect();
                    }
                }
            }
            //////////////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[26] == 1) {
                if (obstacle_6[2].position_x >= 250 * size_dm) {
                    obstacle_6[2].position(42 * size_dm, 203 * size_dm);
                    obstacle_6[2].setObstacleAlpha(200);
                } else {
                    if (obstacle_6[2].position_x <= 84 * size_dm && obstacle_6[2].position_x >= 0) {
                        obstacle_6[2].setObstacleAlpha(200);
                        obstacle_6[2].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[26].position(104 * size_dm, 268 * size_dm);
                            effect[26].setObstacleAlpha(200);
                            effect[26].position_effect();
                        } else {
                            effect[26].setObstacleAlpha(0);
                            effect[26].position_effect();
                        }
                    } else if (obstacle_6[2].position_x >= 104 * size_dm && obstacle_6[2].position_x <= 156 * size_dm) {

                        if (obstacle_6[2].position_x >= 104 * size_dm && obstacle_6[2].position_x <= 132 * size_dm) {
                            obstacle_6[2].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        } else if (obstacle_6[2].position_x > 132 * size_dm && obstacle_6[2].position_x <= 156 * size_dm) {
                            obstacle_6[2].setPosition(Obstacle_Part1_SpeedX, 3);
                        }

                        if (obstacle_6[2].position_x <= 136 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[26].position(156 * size_dm, 320 * size_dm);
                                effect[26].setObstacleAlpha(200);
                                effect[26].position_effect();
                            } else {

                                effect[26].setObstacleAlpha(0);
                                effect[26].position_effect();

                            }
                        } else {
                            effect[26].setObstacleAlpha(0);
                            effect[26].position_effect();
                        }
                    } else if (obstacle_6[2].position_x > 156 * size_dm) {
                        obstacle_6[2].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        effect[26].setObstacleAlpha(0);
                        effect[26].position_effect();
                    } else {
                        obstacle_6[2].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        effect[26].setObstacleAlpha(0);
                        effect[26].position_effect();
                    }
                }
            }
            //////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[27] == 1) {
                if (obstacle_6[3].position_x >= 250 * size_dm) {
                    obstacle_6[3].position(42 * size_dm, 203 * size_dm);
                    obstacle_6[3].setObstacleAlpha(200);
                } else {
                    if (obstacle_6[3].position_x <= 97 * size_dm && obstacle_6[3].position_x >= 0) {
                        obstacle_6[3].setObstacleAlpha(200);
                        obstacle_6[3].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[27].position(117 * size_dm, 281 * size_dm);
                            effect[27].setObstacleAlpha(200);
                            effect[27].position_effect();
                        } else {
                            effect[27].setObstacleAlpha(0);
                            effect[27].position_effect();
                        }
                    } else if (obstacle_6[3].position_x >= 117 * size_dm && obstacle_6[3].position_x <= 169 * size_dm) {

                        if (obstacle_6[3].position_x >= 117 * size_dm && obstacle_6[3].position_x <= 145 * size_dm) {
                            obstacle_6[3].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        } else if (obstacle_6[3].position_x > 145 * size_dm && obstacle_6[3].position_x <= 169 * size_dm) {
                            obstacle_6[3].setPosition(Obstacle_Part1_SpeedX, 3);
                        }

                        if (obstacle_6[3].position_x <= 149 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[27].position(169 * size_dm, 333 * size_dm);
                                effect[27].setObstacleAlpha(200);
                                effect[27].position_effect();
                            } else {

                                effect[27].setObstacleAlpha(0);
                                effect[27].position_effect();

                            }
                        } else {
                            effect[27].setObstacleAlpha(0);
                            effect[27].position_effect();
                        }
                    } else if (obstacle_6[3].position_x > 169 * size_dm) {
                        obstacle_6[3].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        effect[27].setObstacleAlpha(0);
                        effect[27].position_effect();
                    } else {
                        obstacle_6[3].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        effect[27].setObstacleAlpha(0);
                        effect[27].position_effect();
                    }
                }
            }
            /////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[28] == 1) {
                if (obstacle_7[0].position_x >= 250 * size_dm) {
                    obstacle_7[0].position(29 * size_dm, 216 * size_dm);
                    obstacle_7[0].setObstacleAlpha(200);
                } else {
                    if (obstacle_7[0].position_x <= 45 * size_dm && obstacle_7[0].position_x >= 0) {
                        obstacle_7[0].setObstacleAlpha(200);
                        obstacle_7[0].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[28].position(65 * size_dm, 254 * size_dm);
                            effect[28].setObstacleAlpha(200);
                            effect[28].position_effect();
                        } else {
                            effect[28].setObstacleAlpha(0);
                            effect[28].position_effect();
                        }
                    } else if (obstacle_7[0].position_x >= 65 * size_dm && obstacle_7[0].position_x <= 117 * size_dm) {

                        if (obstacle_7[0].position_x >= 65 * size_dm && obstacle_7[0].position_x <= 93 * size_dm) {
                            obstacle_7[0].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        } else if (obstacle_7[0].position_x > 93 * size_dm && obstacle_7[0].position_x <= 117 * size_dm) {
                            obstacle_7[0].setPosition(Obstacle_Part1_SpeedX, 3);
                        }

                        if (obstacle_7[0].position_x <= 97 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[28].position(117 * size_dm, 307 * size_dm);
                                effect[28].setObstacleAlpha(200);
                                effect[28].position_effect();
                            } else {

                                effect[28].setObstacleAlpha(0);
                                effect[28].position_effect();

                            }
                        } else {
                            effect[28].setObstacleAlpha(0);
                            effect[28].position_effect();
                        }
                    } else if (obstacle_7[0].position_x > 117 * size_dm) {
                        obstacle_7[0].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        effect[28].setObstacleAlpha(0);
                        effect[28].position_effect();
                    } else {
                        obstacle_7[0].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        effect[28].setObstacleAlpha(0);
                        effect[28].position_effect();
                    }
                }
            }
            ////////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[29] == 1) {
                if (obstacle_7[1].position_x >= 250 * size_dm) {
                    obstacle_7[1].position(29 * size_dm, 216 * size_dm);
                    obstacle_7[1].setObstacleAlpha(200);
                } else {
                    if (obstacle_7[1].position_x <= 58 * size_dm && obstacle_7[1].position_x >= 0) {
                        obstacle_7[1].setObstacleAlpha(200);
                        obstacle_7[1].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[29].position(78 * size_dm, 268 * size_dm);
                            effect[29].setObstacleAlpha(200);
                            effect[29].position_effect();
                        } else {
                            effect[29].setObstacleAlpha(0);
                            effect[29].position_effect();
                        }
                    } else if (obstacle_7[1].position_x >= 78 * size_dm && obstacle_7[1].position_x <= 130 * size_dm) {

                        if (obstacle_7[1].position_x >= 78 * size_dm && obstacle_7[1].position_x <= 106 * size_dm) {
                            obstacle_7[1].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        } else if (obstacle_7[1].position_x > 106 * size_dm && obstacle_7[1].position_x <= 130 * size_dm) {
                            obstacle_7[1].setPosition(Obstacle_Part1_SpeedX, 3);
                        }

                        if (obstacle_7[1].position_x <= 110 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[29].position(130 * size_dm, 320 * size_dm);
                                effect[29].setObstacleAlpha(200);
                                effect[29].position_effect();
                            } else {

                                effect[29].setObstacleAlpha(0);
                                effect[29].position_effect();

                            }
                        } else {
                            effect[29].setObstacleAlpha(0);
                            effect[29].position_effect();
                        }
                    } else if (obstacle_7[1].position_x > 130 * size_dm) {
                        obstacle_7[1].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        effect[29].setObstacleAlpha(0);
                        effect[29].position_effect();
                    } else {
                        obstacle_7[1].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        effect[29].setObstacleAlpha(0);
                        effect[29].position_effect();
                    }
                }
            }
            ////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[30] == 1) {
                if (obstacle_7[2].position_x >= 250 * size_dm) {
                    obstacle_7[2].position(29 * size_dm, 216 * size_dm);
                    obstacle_7[2].setObstacleAlpha(200);
                } else {
                    if (obstacle_7[2].position_x <= 71 * size_dm && obstacle_7[2].position_x >= 0) {
                        obstacle_7[2].setObstacleAlpha(200);
                        obstacle_7[2].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[30].position(91 * size_dm, 281 * size_dm);
                            effect[30].setObstacleAlpha(200);
                            effect[30].position_effect();
                        } else {
                            effect[30].setObstacleAlpha(0);
                            effect[30].position_effect();
                        }
                    } else if (obstacle_7[2].position_x >= 91 * size_dm && obstacle_7[2].position_x <= 143 * size_dm) {

                        if (obstacle_7[2].position_x >= 91 * size_dm && obstacle_7[2].position_x <= 119 * size_dm) {
                            obstacle_7[2].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        } else if (obstacle_7[2].position_x > 119 * size_dm && obstacle_7[2].position_x <= 143 * size_dm) {
                            obstacle_7[2].setPosition(Obstacle_Part1_SpeedX, 3);
                        }

                        if (obstacle_7[2].position_x <= 123 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[30].position(143 * size_dm, 333 * size_dm);
                                effect[30].setObstacleAlpha(200);
                                effect[30].position_effect();
                            } else {

                                effect[30].setObstacleAlpha(0);
                                effect[30].position_effect();

                            }
                        } else {
                            effect[30].setObstacleAlpha(0);
                            effect[30].position_effect();
                        }
                    } else if (obstacle_7[2].position_x > 143 * size_dm) {
                        obstacle_7[2].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        effect[30].setObstacleAlpha(0);
                        effect[30].position_effect();
                    } else {
                        obstacle_7[2].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        effect[30].setObstacleAlpha(0);
                        effect[30].position_effect();
                    }
                }
            }
            ////////////////////////////////////////////////////////////////////////////////////
            if (pattern[31] == 1) {
                if (obstacle_7[3].position_x >= 250 * size_dm) {
                    obstacle_7[3].position(29 * size_dm, 216 * size_dm);
                    obstacle_7[3].setObstacleAlpha(200);
                } else {
                    if (obstacle_7[3].position_x <= 84 * size_dm && obstacle_7[3].position_x >= 0) {
                        obstacle_7[3].setObstacleAlpha(200);
                        obstacle_7[3].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[31].position(104 * size_dm, 294 * size_dm);
                            effect[31].setObstacleAlpha(200);
                            effect[31].position_effect();
                        } else {
                            effect[31].setObstacleAlpha(0);
                            effect[31].position_effect();
                        }
                    } else if (obstacle_7[3].position_x >= 104 * size_dm && obstacle_7[3].position_x <= 156 * size_dm) {

                        if (obstacle_7[3].position_x >= 104 * size_dm && obstacle_7[3].position_x <= 132 * size_dm) {
                            obstacle_7[3].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        } else if (obstacle_7[3].position_x > 132 * size_dm && obstacle_7[3].position_x <= 156 * size_dm) {
                            obstacle_7[3].setPosition(Obstacle_Part1_SpeedX, 3);
                        }

                        if (obstacle_7[3].position_x <= 136 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[31].position(156 * size_dm, 346 * size_dm);
                                effect[31].setObstacleAlpha(200);
                                effect[31].position_effect();
                            } else {

                                effect[31].setObstacleAlpha(0);
                                effect[31].position_effect();

                            }
                        } else {
                            effect[31].setObstacleAlpha(0);
                            effect[31].position_effect();
                        }
                    } else if (obstacle_7[3].position_x > 156 * size_dm) {
                        obstacle_7[3].setPosition(Obstacle_Part2_SpeedX, Obstacle_Part2_SpeedY);
                        effect[31].setObstacleAlpha(0);
                        effect[31].position_effect();
                    } else {
                        obstacle_7[3].setPosition(Obstacle_Part1_SpeedX, Obstacle_Part1_SpeedY);
                        effect[31].setObstacleAlpha(0);
                        effect[31].position_effect();
                    }
                }
            }
            //////////////////////////////////////////////////////////////////////////////////////////////////////
              if (pattern[32] == 1) {
            if (r_obstacle[0].position_x <= 30 * size_dm) {
                r_obstacle[0].position(189 * size_dm, 125 * size_dm);
                r_obstacle[0].setObstacleAlpha(200);
            } else {
                if (r_obstacle[0].position_x >= 176 * size_dm) {
                    r_obstacle[0].setObstacleAlpha(200);
                    r_obstacle[0].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                    if (level_time_number % 2 == 0) {
                        effect[32].position(156 * size_dm, 164 * size_dm);
                        effect[32].setObstacleAlpha(200);
                        effect[32].position_effect();
                    } else {
                        effect[32].setObstacleAlpha(0);
                        effect[32].position_effect();
                    }
                } else if (r_obstacle[0].position_x >= 104 * size_dm && r_obstacle[0].position_x < 160 * size_dm) {

                    if (r_obstacle[0].position_x >= 130 * size_dm && r_obstacle[0].position_x < 160 * size_dm) {
                        r_obstacle[0].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                    } else if (r_obstacle[0].position_x >= 104 * size_dm && r_obstacle[0].position_x < 130 * size_dm) {
                        r_obstacle[0].setPosition(Obstacle_1_Part2_SpeedX, 3);
                    }

                    if (r_obstacle[0].position_x >= 124 * size_dm) {
                        if (level_time_number % 2 == 0) {
                            effect[32].position(104 * size_dm, 216 * size_dm);
                            effect[32].setObstacleAlpha(200);
                            effect[32].position_effect();
                        } else {

                            effect[32].setObstacleAlpha(0);
                            effect[32].position_effect();

                        }
                    } else {
                        effect[32].setObstacleAlpha(0);
                        effect[32].position_effect();
                    }
                } else if (r_obstacle[0].position_x < 104 * size_dm) {
                    r_obstacle[0].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                    effect[32].setObstacleAlpha(0);
                    effect[32].position_effect();
                } else {
                    r_obstacle[0].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                    effect[32].setObstacleAlpha(0);
                    effect[32].position_effect();
                }
            }
              }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            if (pattern[33] == 1) {
                if (r_obstacle[1].position_x <= 30 * size_dm) {
                    r_obstacle[1].position(189 * size_dm, 125 * size_dm);
                    r_obstacle[1].setObstacleAlpha(200);
                } else {
                    if (r_obstacle[1].position_x >= 163 * size_dm) {
                        r_obstacle[1].setObstacleAlpha(200);
                        r_obstacle[1].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[33].position(143 * size_dm, 177 * size_dm);
                            effect[33].setObstacleAlpha(200);
                            effect[33].position_effect();
                        } else {
                            effect[33].setObstacleAlpha(0);
                            effect[33].position_effect();
                        }
                    } else if (r_obstacle[1].position_x >= 91 * size_dm && r_obstacle[1].position_x <= 143 * size_dm) {

                        if (r_obstacle[1].position_x >= 115 * size_dm && r_obstacle[1].position_x <= 143 * size_dm) {
                            r_obstacle[1].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        } else if (r_obstacle[1].position_x >= 91 * size_dm && r_obstacle[1].position_x < 115 * size_dm) {
                            r_obstacle[1].setPosition(Obstacle_1_Part2_SpeedX, 3);
                        }

                        if (r_obstacle[1].position_x >= 111 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[33].position(91 * size_dm, 229 * size_dm);
                                effect[33].setObstacleAlpha(200);
                                effect[33].position_effect();
                            } else {

                                effect[33].setObstacleAlpha(0);
                                effect[33].position_effect();

                            }
                        } else {
                            effect[33].setObstacleAlpha(0);
                            effect[33].position_effect();
                        }
                    } else if (r_obstacle[1].position_x < 91 * size_dm) {
                        r_obstacle[1].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        effect[33].setObstacleAlpha(0);
                        effect[33].position_effect();
                    } else {
                        r_obstacle[1].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        effect[33].setObstacleAlpha(0);
                        effect[33].position_effect();
                    }
                }
            }
            //////////////////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[34] == 1) {
                if (r_obstacle[2].position_x <= 30 * size_dm) {
                    r_obstacle[2].position(189 * size_dm, 125 * size_dm);
                    r_obstacle[2].setObstacleAlpha(200);
                } else {
                    if (r_obstacle[2].position_x >= 150 * size_dm) {
                        r_obstacle[2].setObstacleAlpha(200);
                        r_obstacle[2].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[34].position(130 * size_dm, 190 * size_dm);
                            effect[34].setObstacleAlpha(200);
                            effect[34].position_effect();
                        } else {
                            effect[34].setObstacleAlpha(0);
                            effect[34].position_effect();
                        }
                    } else if (r_obstacle[2].position_x >= 78 * size_dm && r_obstacle[2].position_x <= 130 * size_dm) {

                        if (r_obstacle[2].position_x >= 102 * size_dm && r_obstacle[2].position_x <= 130 * size_dm) {
                            r_obstacle[2].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        } else if (r_obstacle[2].position_x >= 78 * size_dm && r_obstacle[2].position_x < 102 * size_dm) {
                            r_obstacle[2].setPosition(Obstacle_1_Part2_SpeedX, 3);
                        }

                        if (r_obstacle[2].position_x >= 98 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[34].position(78 * size_dm, 242 * size_dm);
                                effect[34].setObstacleAlpha(200);
                                effect[34].position_effect();
                            } else {

                                effect[34].setObstacleAlpha(0);
                                effect[34].position_effect();

                            }
                        } else {
                            effect[34].setObstacleAlpha(0);
                            effect[34].position_effect();
                        }
                    } else if (r_obstacle[2].position_x < 78 * size_dm) {
                        r_obstacle[2].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        effect[34].setObstacleAlpha(0);
                        effect[34].position_effect();
                    } else {
                        r_obstacle[2].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        effect[34].setObstacleAlpha(0);
                        effect[34].position_effect();
                    }
                }
            }
            ////////////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[35] == 1) {
                if (r_obstacle[3].position_x <= 30 * size_dm) {
                    r_obstacle[3].position(189 * size_dm, 125 * size_dm);
                    r_obstacle[3].setObstacleAlpha(200);
                } else {
                    if (r_obstacle[3].position_x >= 137 * size_dm) {
                        r_obstacle[3].setObstacleAlpha(200);
                        r_obstacle[3].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[35].position(117 * size_dm, 203 * size_dm);
                            effect[35].setObstacleAlpha(200);
                            effect[35].position_effect();
                        } else {
                            effect[35].setObstacleAlpha(0);
                            effect[35].position_effect();
                        }
                    } else if (r_obstacle[3].position_x >= 65 * size_dm && r_obstacle[3].position_x <= 117 * size_dm) {

                        if (r_obstacle[3].position_x >= 89 * size_dm && r_obstacle[3].position_x <= 117 * size_dm) {
                            r_obstacle[3].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        } else if (r_obstacle[3].position_x >= 65 * size_dm && r_obstacle[3].position_x < 89 * size_dm) {
                            r_obstacle[3].setPosition(Obstacle_1_Part2_SpeedX, 3);
                        }

                        if (r_obstacle[3].position_x >= 85 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[35].position(65 * size_dm, 254 * size_dm);
                                effect[35].setObstacleAlpha(200);
                                effect[35].position_effect();
                            } else {

                                effect[35].setObstacleAlpha(0);
                                effect[35].position_effect();

                            }
                        } else {
                            effect[35].setObstacleAlpha(0);
                            effect[35].position_effect();
                        }
                    } else if (r_obstacle[3].position_x < 65 * size_dm) {
                        r_obstacle[3].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        effect[35].setObstacleAlpha(0);
                        effect[35].position_effect();
                    } else {
                        r_obstacle[3].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        effect[35].setObstacleAlpha(0);
                        effect[35].position_effect();
                    }
                }
            }
            ////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[36] == 1) {
                if (r_obstacle_1[0].position_x <= 30 * size_dm) {
                    r_obstacle_1[0].position(202 * size_dm, 138 * size_dm);
                    r_obstacle_1[0].setObstacleAlpha(200);
                } else {
                    if (r_obstacle_1[0].position_x >= 189 * size_dm) {
                        r_obstacle_1[0].setObstacleAlpha(200);
                        r_obstacle_1[0].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[36].position(169 * size_dm, 177 * size_dm);
                            effect[36].setObstacleAlpha(200);
                            effect[36].position_effect();
                        } else {
                            effect[36].setObstacleAlpha(0);
                            effect[36].position_effect();
                        }
                    } else if (r_obstacle_1[0].position_x >= 117 * size_dm && r_obstacle_1[0].position_x <= 169 * size_dm) {

                        if (r_obstacle_1[0].position_x >= 141 * size_dm && r_obstacle_1[0].position_x <= 169 * size_dm) {
                            r_obstacle_1[0].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        } else if (r_obstacle_1[0].position_x >= 117 * size_dm && r_obstacle_1[0].position_x < 141 * size_dm) {
                            r_obstacle_1[0].setPosition(Obstacle_1_Part2_SpeedX, 3);
                        }

                        if (r_obstacle_1[0].position_x >= 137 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[36].position(117 * size_dm, 229 * size_dm);
                                effect[36].setObstacleAlpha(200);
                                effect[36].position_effect();
                            } else {

                                effect[36].setObstacleAlpha(0);
                                effect[36].position_effect();

                            }
                        } else {
                            effect[36].setObstacleAlpha(0);
                            effect[36].position_effect();
                        }
                    } else if (r_obstacle_1[0].position_x < 117 * size_dm) {
                        r_obstacle_1[0].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        effect[36].setObstacleAlpha(0);
                        effect[36].position_effect();
                    } else {
                        r_obstacle_1[0].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        effect[36].setObstacleAlpha(0);
                        effect[36].position_effect();
                    }
                }
            }
            /////////////////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[37] == 1) {
                if (r_obstacle_1[1].position_x <= 30 * size_dm) {
                    r_obstacle_1[1].position(202 * size_dm, 138 * size_dm);
                    r_obstacle_1[1].setObstacleAlpha(200);
                } else {
                    if (r_obstacle_1[1].position_x >= 176 * size_dm) {
                        r_obstacle_1[1].setObstacleAlpha(200);
                        r_obstacle_1[1].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[37].position(156 * size_dm, 190 * size_dm);
                            effect[37].setObstacleAlpha(200);
                            effect[37].position_effect();
                        } else {
                            effect[37].setObstacleAlpha(0);
                            effect[37].position_effect();
                        }
                    } else if (r_obstacle_1[1].position_x >= 104 * size_dm && r_obstacle_1[1].position_x <= 156 * size_dm) {

                        if (r_obstacle_1[1].position_x >= 128 * size_dm && r_obstacle_1[1].position_x <= 156 * size_dm) {
                            r_obstacle_1[1].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        } else if (r_obstacle_1[1].position_x >= 104 * size_dm && r_obstacle_1[1].position_x < 128 * size_dm) {
                            r_obstacle_1[1].setPosition(Obstacle_1_Part2_SpeedX, 3);
                        }

                        if (r_obstacle_1[1].position_x >= 124 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[37].position(104 * size_dm, 242 * size_dm);
                                effect[37].setObstacleAlpha(200);
                                effect[37].position_effect();
                            } else {

                                effect[37].setObstacleAlpha(0);
                                effect[37].position_effect();

                            }
                        } else {
                            effect[37].setObstacleAlpha(0);
                            effect[37].position_effect();
                        }
                    } else if (r_obstacle_1[1].position_x < 104 * size_dm) {
                        r_obstacle_1[1].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        effect[37].setObstacleAlpha(0);
                        effect[37].position_effect();
                    } else {
                        r_obstacle_1[1].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        effect[37].setObstacleAlpha(0);
                        effect[37].position_effect();
                    }
                }
            }
            //////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[38] == 1) {
                if (r_obstacle_1[2].position_x <= 30 * size_dm) {
                    r_obstacle_1[2].position(202 * size_dm, 138 * size_dm);
                    r_obstacle_1[2].setObstacleAlpha(200);
                } else {
                    if (r_obstacle_1[2].position_x >= 163 * size_dm) {
                        r_obstacle_1[2].setObstacleAlpha(200);
                        r_obstacle_1[2].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[38].position(143 * size_dm, 203 * size_dm);
                            effect[38].setObstacleAlpha(200);
                            effect[38].position_effect();
                        } else {
                            effect[38].setObstacleAlpha(0);
                            effect[38].position_effect();
                        }
                    } else if (r_obstacle_1[2].position_x >= 91 * size_dm && r_obstacle_1[2].position_x <= 143 * size_dm) {

                        if (r_obstacle_1[2].position_x >= 115 * size_dm && r_obstacle_1[2].position_x <= 143 * size_dm) {
                            r_obstacle_1[2].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        } else if (r_obstacle_1[2].position_x >= 91 * size_dm && r_obstacle_1[2].position_x < 115 * size_dm) {
                            r_obstacle_1[2].setPosition(Obstacle_1_Part2_SpeedX, 3);
                        }

                        if (r_obstacle_1[2].position_x >= 111 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[38].position(91 * size_dm, 255 * size_dm);
                                effect[38].setObstacleAlpha(200);
                                effect[38].position_effect();
                            } else {

                                effect[38].setObstacleAlpha(0);
                                effect[38].position_effect();

                            }
                        } else {
                            effect[38].setObstacleAlpha(0);
                            effect[38].position_effect();
                        }
                    } else if (r_obstacle_1[2].position_x < 91 * size_dm) {
                        r_obstacle_1[2].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        effect[38].setObstacleAlpha(0);
                        effect[38].position_effect();
                    } else {
                        r_obstacle_1[2].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        effect[38].setObstacleAlpha(0);
                        effect[38].position_effect();
                    }
                }
            }
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[39] == 1) {
                if (r_obstacle_1[3].position_x <= 30 * size_dm) {
                    r_obstacle_1[3].position(202 * size_dm, 138 * size_dm);
                    r_obstacle_1[3].setObstacleAlpha(200);
                } else {
                    if (r_obstacle_1[3].position_x >= 150 * size_dm) {
                        r_obstacle_1[3].setObstacleAlpha(200);
                        r_obstacle_1[3].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[39].position(130 * size_dm, 216 * size_dm);
                            effect[39].setObstacleAlpha(200);
                            effect[39].position_effect();
                        } else {
                            effect[39].setObstacleAlpha(0);
                            effect[39].position_effect();
                        }
                    } else if (r_obstacle_1[3].position_x >= 100 * size_dm && r_obstacle_1[3].position_x <= 130 * size_dm) {

                        if (r_obstacle_1[3].position_x >= 122 * size_dm && r_obstacle_1[3].position_x <= 130 * size_dm) {
                            r_obstacle_1[3].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        } else if (r_obstacle_1[3].position_x >= 100 * size_dm && r_obstacle_1[3].position_x < 122 * size_dm) {
                            r_obstacle_1[3].setPosition(Obstacle_1_Part2_SpeedX, 3);
                        }

                        if (r_obstacle_1[3].position_x >= 108 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[39].position(78 * size_dm, 268 * size_dm);
                                effect[39].setObstacleAlpha(200);
                                effect[39].position_effect();
                            } else {

                                effect[39].setObstacleAlpha(0);
                                effect[39].position_effect();

                            }
                        } else {
                            effect[39].setObstacleAlpha(0);
                            effect[39].position_effect();
                        }
                    } else if (r_obstacle_1[3].position_x < 100 * size_dm) {
                        r_obstacle_1[3].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        effect[39].setObstacleAlpha(0);
                        effect[39].position_effect();
                    } else {
                        r_obstacle_1[3].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        effect[39].setObstacleAlpha(0);
                        effect[39].position_effect();
                    }
                }
            }
            /////////////////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[40] == 1) {
                if (r_obstacle_2[0].position_x <= 30 * size_dm) {
                    r_obstacle_2[0].position(215 * size_dm, 151 * size_dm);
                    r_obstacle_2[0].setObstacleAlpha(200);
                } else {
                    if (r_obstacle_2[0].position_x >= 202 * size_dm) {
                        r_obstacle_2[0].setObstacleAlpha(200);
                        r_obstacle_2[0].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[40].position(182 * size_dm, 190 * size_dm);
                            effect[40].setObstacleAlpha(200);
                            effect[40].position_effect();
                        } else {
                            effect[40].setObstacleAlpha(0);
                            effect[40].position_effect();
                        }
                    } else if (r_obstacle_2[0].position_x >= 130 * size_dm && r_obstacle_2[0].position_x <= 182 * size_dm) {

                        if (r_obstacle_2[0].position_x >= 154 * size_dm && r_obstacle_2[0].position_x <= 182 * size_dm) {
                            r_obstacle_2[0].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        } else if (r_obstacle_2[0].position_x >= 130 * size_dm && r_obstacle_2[0].position_x < 154 * size_dm) {
                            r_obstacle_2[0].setPosition(Obstacle_1_Part2_SpeedX, 3);
                        }

                        if (r_obstacle_2[0].position_x >= 150 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[40].position(130 * size_dm, 242 * size_dm);
                                effect[40].setObstacleAlpha(200);
                                effect[40].position_effect();
                            } else {

                                effect[40].setObstacleAlpha(0);
                                effect[40].position_effect();

                            }
                        } else {
                            effect[40].setObstacleAlpha(0);
                            effect[40].position_effect();
                        }
                    } else if (r_obstacle_2[0].position_x < 130 * size_dm) {
                        r_obstacle_2[0].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        effect[40].setObstacleAlpha(0);
                        effect[40].position_effect();
                    } else {
                        r_obstacle_2[0].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        effect[40].setObstacleAlpha(0);
                        effect[40].position_effect();
                    }
                }
            }
            ///////////////////////////////////////////////////////////////////////////
            if (pattern[41] == 1) {
                if (r_obstacle_2[1].position_x <= 30 * size_dm) {
                    r_obstacle_2[1].position(215 * size_dm, 151 * size_dm);
                    r_obstacle_2[1].setObstacleAlpha(200);
                } else {
                    if (r_obstacle_2[1].position_x >= 189 * size_dm) {
                        r_obstacle_2[1].setObstacleAlpha(200);
                        r_obstacle_2[1].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[41].position(169 * size_dm, 203 * size_dm);
                            effect[41].setObstacleAlpha(200);
                            effect[41].position_effect();
                        } else {
                            effect[41].setObstacleAlpha(0);
                            effect[41].position_effect();
                        }
                    } else if (r_obstacle_2[1].position_x >= 117 * size_dm && r_obstacle_2[1].position_x <= 169 * size_dm) {

                        if (r_obstacle_2[1].position_x >= 141 * size_dm && r_obstacle_2[1].position_x <= 169 * size_dm) {
                            r_obstacle_2[1].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        } else if (r_obstacle_2[1].position_x >= 117 * size_dm && r_obstacle_2[1].position_x < 141 * size_dm) {
                            r_obstacle_2[1].setPosition(Obstacle_1_Part2_SpeedX, 3);
                        }

                        if (r_obstacle_2[1].position_x >= 137 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[41].position(117 * size_dm, 255 * size_dm);
                                effect[41].setObstacleAlpha(200);
                                effect[41].position_effect();
                            } else {

                                effect[41].setObstacleAlpha(0);
                                effect[41].position_effect();

                            }
                        } else {
                            effect[41].setObstacleAlpha(0);
                            effect[41].position_effect();
                        }
                    } else if (r_obstacle_2[1].position_x < 117 * size_dm) {
                        r_obstacle_2[1].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        effect[41].setObstacleAlpha(0);
                        effect[41].position_effect();
                    } else {
                        r_obstacle_2[1].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        effect[41].setObstacleAlpha(0);
                        effect[41].position_effect();
                    }
                }
            }
            ///////////////////////////////////////////////////////////////////////////////////////
            if (pattern[42] == 1) {
                if (r_obstacle_2[2].position_x <= 30 * size_dm) {
                    r_obstacle_2[2].position(215 * size_dm, 151 * size_dm);
                    r_obstacle_2[2].setObstacleAlpha(200);
                } else {
                    if (r_obstacle_2[2].position_x >= 176 * size_dm) {
                        r_obstacle_2[2].setObstacleAlpha(200);
                        r_obstacle_2[2].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[42].position(156 * size_dm, 216 * size_dm);
                            effect[42].setObstacleAlpha(200);
                            effect[42].position_effect();
                        } else {
                            effect[42].setObstacleAlpha(0);
                            effect[42].position_effect();
                        }
                    } else if (r_obstacle_2[2].position_x >= 104 * size_dm && r_obstacle_2[2].position_x <= 156 * size_dm) {

                        if (r_obstacle_2[2].position_x >= 128 * size_dm && r_obstacle_2[2].position_x <= 156 * size_dm) {
                            r_obstacle_2[2].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        } else if (r_obstacle_2[2].position_x >= 104 * size_dm && r_obstacle_2[2].position_x < 128 * size_dm) {
                            r_obstacle_2[2].setPosition(Obstacle_1_Part2_SpeedX, 3);
                        }

                        if (r_obstacle_2[2].position_x >= 124 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[42].position(104 * size_dm, 268 * size_dm);
                                effect[42].setObstacleAlpha(200);
                                effect[42].position_effect();
                            } else {

                                effect[42].setObstacleAlpha(0);
                                effect[42].position_effect();

                            }
                        } else {
                            effect[42].setObstacleAlpha(0);
                            effect[42].position_effect();
                        }
                    } else if (r_obstacle_2[2].position_x < 104 * size_dm) {
                        r_obstacle_2[2].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        effect[42].setObstacleAlpha(0);
                        effect[42].position_effect();
                    } else {
                        r_obstacle_2[2].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        effect[42].setObstacleAlpha(0);
                        effect[42].position_effect();
                    }
                }
            }
            ////////////////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[43] == 1) {
                if (r_obstacle_2[3].position_x <= 30 * size_dm) {
                    r_obstacle_2[3].position(215 * size_dm, 151 * size_dm);
                    r_obstacle_2[3].setObstacleAlpha(200);
                } else {
                    if (r_obstacle_2[3].position_x >= 163 * size_dm) {
                        r_obstacle_2[3].setObstacleAlpha(200);
                        r_obstacle_2[3].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[43].position(143 * size_dm, 229 * size_dm);
                            effect[43].setObstacleAlpha(200);
                            effect[43].position_effect();
                        } else {
                            effect[43].setObstacleAlpha(0);
                            effect[43].position_effect();
                        }
                    } else if (r_obstacle_2[3].position_x >= 91 * size_dm && r_obstacle_2[3].position_x <= 143 * size_dm) {

                        if (r_obstacle_2[3].position_x >= 115 * size_dm && r_obstacle_2[3].position_x <= 143 * size_dm) {
                            r_obstacle_2[3].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        } else if (r_obstacle_2[3].position_x >= 91 * size_dm && r_obstacle_2[3].position_x < 115 * size_dm) {
                            r_obstacle_2[3].setPosition(Obstacle_1_Part2_SpeedX, 3);
                        }

                        if (r_obstacle_2[3].position_x >= 111 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[43].position(91 * size_dm, 281 * size_dm);
                                effect[43].setObstacleAlpha(200);
                                effect[43].position_effect();
                            } else {

                                effect[43].setObstacleAlpha(0);
                                effect[43].position_effect();

                            }
                        } else {
                            effect[43].setObstacleAlpha(0);
                            effect[43].position_effect();
                        }
                    } else if (r_obstacle_2[3].position_x < 91 * size_dm) {
                        r_obstacle_2[3].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        effect[43].setObstacleAlpha(0);
                        effect[43].position_effect();
                    } else {
                        r_obstacle_2[3].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        effect[43].setObstacleAlpha(0);
                        effect[43].position_effect();
                    }
                }
            }
////////////////////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[44] == 1) {
                if (r_obstacle_3[0].position_x <= 30 * size_dm) {
                    r_obstacle_3[0].position(228 * size_dm, 164 * size_dm);
                    r_obstacle_3[0].setObstacleAlpha(200);
                } else {
                    if (r_obstacle_3[0].position_x >= 215 * size_dm) {
                        r_obstacle_3[0].setObstacleAlpha(200);
                        r_obstacle_3[0].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[44].position(195 * size_dm, 203 * size_dm);
                            effect[44].setObstacleAlpha(200);
                            effect[44].position_effect();
                        } else {
                            effect[44].setObstacleAlpha(0);
                            effect[44].position_effect();
                        }
                    } else if (r_obstacle_3[0].position_x >= 143 * size_dm && r_obstacle_3[0].position_x <= 195 * size_dm) {

                        if (r_obstacle_3[0].position_x >= 167 * size_dm && r_obstacle_3[0].position_x <= 195 * size_dm) {
                            r_obstacle_3[0].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        } else if (r_obstacle_3[0].position_x >= 143 * size_dm && r_obstacle_3[0].position_x < 167 * size_dm) {
                            r_obstacle_3[0].setPosition(Obstacle_1_Part2_SpeedX, 3);
                        }

                        if (r_obstacle_3[0].position_x >= 163 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[44].position(143 * size_dm, 255 * size_dm);
                                effect[44].setObstacleAlpha(200);
                                effect[44].position_effect();
                            } else {

                                effect[44].setObstacleAlpha(0);
                                effect[44].position_effect();

                            }
                        } else {
                            effect[44].setObstacleAlpha(0);
                            effect[44].position_effect();
                        }
                    } else if (r_obstacle_3[0].position_x < 143 * size_dm) {
                        r_obstacle_3[0].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        effect[44].setObstacleAlpha(0);
                        effect[44].position_effect();
                    } else {
                        r_obstacle_3[0].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        effect[44].setObstacleAlpha(0);
                        effect[44].position_effect();
                    }
                }
            }
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[45] == 1) {
                if (r_obstacle_3[1].position_x <= 30 * size_dm) {
                    r_obstacle_3[1].position(228 * size_dm, 164 * size_dm);
                    r_obstacle_3[1].setObstacleAlpha(200);
                } else {
                    if (r_obstacle_3[1].position_x >= 202 * size_dm) {
                        r_obstacle_3[1].setObstacleAlpha(200);
                        r_obstacle_3[1].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[45].position(182 * size_dm, 216 * size_dm);
                            effect[45].setObstacleAlpha(200);
                            effect[45].position_effect();
                        } else {
                            effect[45].setObstacleAlpha(0);
                            effect[45].position_effect();
                        }
                    } else if (r_obstacle_3[1].position_x >= 130 * size_dm && r_obstacle_3[1].position_x <= 182 * size_dm) {

                        if (r_obstacle_3[1].position_x >= 154 * size_dm && r_obstacle_3[1].position_x <= 182 * size_dm) {
                            r_obstacle_3[1].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        } else if (r_obstacle_3[1].position_x >= 130 * size_dm && r_obstacle_3[1].position_x < 154 * size_dm) {
                            r_obstacle_3[1].setPosition(Obstacle_1_Part2_SpeedX, 3);
                        }

                        if (r_obstacle_3[1].position_x >= 150 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[45].position(130 * size_dm, 268 * size_dm);
                                effect[45].setObstacleAlpha(200);
                                effect[45].position_effect();
                            } else {

                                effect[45].setObstacleAlpha(0);
                                effect[45].position_effect();

                            }
                        } else {
                            effect[45].setObstacleAlpha(0);
                            effect[45].position_effect();
                        }
                    } else if (r_obstacle_3[1].position_x < 130 * size_dm) {
                        r_obstacle_3[1].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        effect[45].setObstacleAlpha(0);
                        effect[45].position_effect();
                    } else {
                        r_obstacle_3[1].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        effect[45].setObstacleAlpha(0);
                        effect[45].position_effect();
                    }
                }
            }
            ////////////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[46] == 1) {
                if (r_obstacle_3[2].position_x <= 30 * size_dm) {
                    r_obstacle_3[2].position(228 * size_dm, 164 * size_dm);
                    r_obstacle_3[2].setObstacleAlpha(200);
                } else {
                    if (r_obstacle_3[2].position_x >= 189 * size_dm) {
                        r_obstacle_3[2].setObstacleAlpha(200);
                        r_obstacle_3[2].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[46].position(169 * size_dm, 229 * size_dm);
                            effect[46].setObstacleAlpha(200);
                            effect[46].position_effect();
                        } else {
                            effect[46].setObstacleAlpha(0);
                            effect[46].position_effect();
                        }
                    } else if (r_obstacle_3[2].position_x >= 117 * size_dm && r_obstacle_3[2].position_x <= 169 * size_dm) {

                        if (r_obstacle_3[2].position_x >= 141 * size_dm && r_obstacle_3[2].position_x <= 169 * size_dm) {
                            r_obstacle_3[2].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        } else if (r_obstacle_3[2].position_x >= 117 * size_dm && r_obstacle_3[2].position_x < 141 * size_dm) {
                            r_obstacle_3[2].setPosition(Obstacle_1_Part2_SpeedX, 3);
                        }

                        if (r_obstacle_3[2].position_x >= 137 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[46].position(117 * size_dm, 281 * size_dm);
                                effect[46].setObstacleAlpha(200);
                                effect[46].position_effect();
                            } else {

                                effect[46].setObstacleAlpha(0);
                                effect[46].position_effect();

                            }
                        } else {
                            effect[46].setObstacleAlpha(0);
                            effect[46].position_effect();
                        }
                    } else if (r_obstacle_3[2].position_x < 117 * size_dm) {
                        r_obstacle_3[2].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        effect[46].setObstacleAlpha(0);
                        effect[46].position_effect();
                    } else {
                        r_obstacle_3[2].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        effect[46].setObstacleAlpha(0);
                        effect[46].position_effect();
                    }
                }
            }
            //////////////////////////////////////////////////////////////////////////////////
            if (pattern[47] == 1) {
                if (r_obstacle_3[3].position_x <= 30 * size_dm) {
                    r_obstacle_3[3].position(228 * size_dm, 164 * size_dm);
                    r_obstacle_3[3].setObstacleAlpha(200);
                } else {
                    if (r_obstacle_3[3].position_x >= 176 * size_dm) {
                        r_obstacle_3[3].setObstacleAlpha(200);
                        r_obstacle_3[3].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[47].position(156 * size_dm, 242 * size_dm);
                            effect[47].setObstacleAlpha(200);
                            effect[47].position_effect();
                        } else {
                            effect[47].setObstacleAlpha(0);
                            effect[47].position_effect();
                        }
                    } else if (r_obstacle_3[3].position_x >= 104 * size_dm && r_obstacle_3[3].position_x <= 156 * size_dm) {

                        if (r_obstacle_3[3].position_x >= 128 * size_dm && r_obstacle_3[3].position_x <= 156 * size_dm) {
                            r_obstacle_3[3].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        } else if (r_obstacle_3[3].position_x >= 104 * size_dm && r_obstacle_3[3].position_x < 128 * size_dm) {
                            r_obstacle_3[3].setPosition(Obstacle_1_Part2_SpeedX, 3);
                        }

                        if (r_obstacle_3[3].position_x >= 124 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[47].position(104 * size_dm, 294 * size_dm);
                                effect[47].setObstacleAlpha(200);
                                effect[47].position_effect();
                            } else {

                                effect[47].setObstacleAlpha(0);
                                effect[47].position_effect();

                            }
                        } else {
                            effect[47].setObstacleAlpha(0);
                            effect[47].position_effect();
                        }
                    } else if (r_obstacle_3[3].position_x < 104 * size_dm) {
                        r_obstacle_3[3].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        effect[47].setObstacleAlpha(0);
                        effect[47].position_effect();
                    } else {
                        r_obstacle_3[3].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        effect[47].setObstacleAlpha(0);
                        effect[47].position_effect();
                    }
                }
            }
            //////////////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[48] == 1) {
                if (r_obstacle_4[0].position_x <= 30 * size_dm) {
                    r_obstacle_4[0].position(241 * size_dm, 177 * size_dm);
                    r_obstacle_4[0].setObstacleAlpha(200);
                } else {
                    if (r_obstacle_4[0].position_x >= 228 * size_dm) {
                        r_obstacle_4[0].setObstacleAlpha(200);
                        r_obstacle_4[0].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[48].position(208 * size_dm, 216 * size_dm);
                            effect[48].setObstacleAlpha(200);
                            effect[48].position_effect();
                        } else {
                            effect[48].setObstacleAlpha(0);
                            effect[48].position_effect();
                        }
                    } else if (r_obstacle_4[0].position_x >= 156 * size_dm && r_obstacle_4[0].position_x <= 208 * size_dm) {

                        if (r_obstacle_4[0].position_x >= 180 * size_dm && r_obstacle_4[0].position_x <= 208 * size_dm) {
                            r_obstacle_4[0].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        } else if (r_obstacle_4[0].position_x >= 156 * size_dm && r_obstacle_4[0].position_x < 180 * size_dm) {
                            r_obstacle_4[0].setPosition(Obstacle_1_Part2_SpeedX, 3);
                        }

                        if (r_obstacle_4[0].position_x >= 176 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[48].position(156 * size_dm, 268 * size_dm);
                                effect[48].setObstacleAlpha(200);
                                effect[48].position_effect();
                            } else {

                                effect[48].setObstacleAlpha(0);
                                effect[48].position_effect();

                            }
                        } else {
                            effect[48].setObstacleAlpha(0);
                            effect[48].position_effect();
                        }
                    } else if (r_obstacle_4[0].position_x < 156 * size_dm) {
                        r_obstacle_4[0].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        effect[48].setObstacleAlpha(0);
                        effect[48].position_effect();
                    } else {
                        r_obstacle_4[0].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        effect[48].setObstacleAlpha(0);
                        effect[48].position_effect();
                    }
                }
            }
            ///////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[49] == 1) {
                if (r_obstacle_4[1].position_x <= 30 * size_dm) {
                    r_obstacle_4[1].position(241 * size_dm, 177 * size_dm);
                    r_obstacle_4[1].setObstacleAlpha(200);
                } else {
                    if (r_obstacle_4[1].position_x >= 215 * size_dm) {
                        r_obstacle_4[1].setObstacleAlpha(200);
                        r_obstacle_4[1].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[49].position(195 * size_dm, 229 * size_dm);
                            effect[49].setObstacleAlpha(200);
                            effect[49].position_effect();
                        } else {
                            effect[49].setObstacleAlpha(0);
                            effect[49].position_effect();
                        }
                    } else if (r_obstacle_4[1].position_x >= 143 * size_dm && r_obstacle_4[1].position_x <= 195 * size_dm) {

                        if (r_obstacle_4[1].position_x >= 167 * size_dm && r_obstacle_4[1].position_x <= 195 * size_dm) {
                            r_obstacle_4[1].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        } else if (r_obstacle_4[1].position_x >= 143 * size_dm && r_obstacle_4[1].position_x < 167 * size_dm) {
                            r_obstacle_4[1].setPosition(Obstacle_1_Part2_SpeedX, 3);
                        }

                        if (r_obstacle_4[1].position_x >= 163 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[49].position(143 * size_dm, 281 * size_dm);
                                effect[49].setObstacleAlpha(200);
                                effect[49].position_effect();
                            } else {

                                effect[49].setObstacleAlpha(0);
                                effect[49].position_effect();

                            }
                        } else {
                            effect[49].setObstacleAlpha(0);
                            effect[49].position_effect();
                        }
                    } else if (r_obstacle_4[1].position_x < 143 * size_dm) {
                        r_obstacle_4[1].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        effect[49].setObstacleAlpha(0);
                        effect[49].position_effect();
                    } else {
                        r_obstacle_4[1].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        effect[49].setObstacleAlpha(0);
                        effect[49].position_effect();
                    }
                }
            }
            ///////////////////////////////////////////////////////////////////////////////////
            if (pattern[50] == 1) {
                if (r_obstacle_4[2].position_x <= 30 * size_dm) {
                    r_obstacle_4[2].position(241 * size_dm, 177 * size_dm);
                    r_obstacle_4[2].setObstacleAlpha(200);
                } else {
                    if (r_obstacle_4[2].position_x >= 202 * size_dm) {
                        r_obstacle_4[2].setObstacleAlpha(200);
                        r_obstacle_4[2].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[50].position(182 * size_dm, 242 * size_dm);
                            effect[50].setObstacleAlpha(200);
                            effect[50].position_effect();
                        } else {
                            effect[50].setObstacleAlpha(0);
                            effect[50].position_effect();
                        }
                    } else if (r_obstacle_4[2].position_x >= 130 * size_dm && r_obstacle_4[2].position_x <= 182 * size_dm) {

                        if (r_obstacle_4[2].position_x >= 154 * size_dm && r_obstacle_4[2].position_x <= 182 * size_dm) {
                            r_obstacle_4[2].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        } else if (r_obstacle_4[2].position_x >= 130 * size_dm && r_obstacle_4[2].position_x < 154 * size_dm) {
                            r_obstacle_4[2].setPosition(Obstacle_1_Part2_SpeedX, 3);
                        }

                        if (r_obstacle_4[2].position_x >= 150 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[50].position(130 * size_dm, 294 * size_dm);
                                effect[50].setObstacleAlpha(200);
                                effect[50].position_effect();
                            } else {

                                effect[50].setObstacleAlpha(0);
                                effect[50].position_effect();

                            }
                        } else {
                            effect[50].setObstacleAlpha(0);
                            effect[50].position_effect();
                        }
                    } else if (r_obstacle_4[2].position_x < 130 * size_dm) {
                        r_obstacle_4[2].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        effect[50].setObstacleAlpha(0);
                        effect[50].position_effect();
                    } else {
                        r_obstacle_4[2].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        effect[50].setObstacleAlpha(0);
                        effect[50].position_effect();
                    }
                }
            }
            ////////////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[51] == 1) {
                if (r_obstacle_4[3].position_x <= 30 * size_dm) {
                    r_obstacle_4[3].position(241 * size_dm, 177 * size_dm);
                    r_obstacle_4[3].setObstacleAlpha(200);
                } else {
                    if (r_obstacle_4[3].position_x >= 189 * size_dm) {
                        r_obstacle_4[3].setObstacleAlpha(200);
                        r_obstacle_4[3].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[51].position(169 * size_dm, 255 * size_dm);
                            effect[51].setObstacleAlpha(200);
                            effect[51].position_effect();
                        } else {
                            effect[51].setObstacleAlpha(0);
                            effect[51].position_effect();
                        }
                    } else if (r_obstacle_4[3].position_x >= 117 * size_dm && r_obstacle_4[3].position_x <= 169 * size_dm) {

                        if (r_obstacle_4[3].position_x >= 141 * size_dm && r_obstacle_4[3].position_x <= 169 * size_dm) {
                            r_obstacle_4[3].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        } else if (r_obstacle_4[3].position_x >= 117 * size_dm && r_obstacle_4[3].position_x < 141 * size_dm) {
                            r_obstacle_4[3].setPosition(Obstacle_1_Part2_SpeedX, 3);
                        }

                        if (r_obstacle_4[3].position_x >= 137 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[51].position(117 * size_dm, 307 * size_dm);
                                effect[51].setObstacleAlpha(200);
                                effect[51].position_effect();
                            } else {

                                effect[51].setObstacleAlpha(0);
                                effect[51].position_effect();

                            }
                        } else {
                            effect[51].setObstacleAlpha(0);
                            effect[51].position_effect();
                        }
                    } else if (r_obstacle_4[3].position_x < 117 * size_dm) {
                        r_obstacle_4[3].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        effect[51].setObstacleAlpha(0);
                        effect[51].position_effect();
                    } else {
                        r_obstacle_4[3].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        effect[51].setObstacleAlpha(0);
                        effect[51].position_effect();
                    }
                }
            }
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[52] == 1) {
                if (r_obstacle_5[0].position_x <= 30 * size_dm) {
                    r_obstacle_5[0].position(254 * size_dm, 190 * size_dm);
                    r_obstacle_5[0].setObstacleAlpha(200);
                } else {
                    if (r_obstacle_5[0].position_x >= 241 * size_dm) {
                        r_obstacle_5[0].setObstacleAlpha(200);
                        r_obstacle_5[0].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[52].position(221 * size_dm, 229 * size_dm);
                            effect[52].setObstacleAlpha(200);
                            effect[52].position_effect();
                        } else {
                            effect[52].setObstacleAlpha(0);
                            effect[52].position_effect();
                        }
                    } else if (r_obstacle_5[0].position_x >= 169 * size_dm && r_obstacle_5[0].position_x <= 221 * size_dm) {

                        if (r_obstacle_5[0].position_x >= 193 * size_dm && r_obstacle_5[0].position_x <= 221 * size_dm) {
                            r_obstacle_5[0].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        } else if (r_obstacle_5[0].position_x >= 169 * size_dm && r_obstacle_5[0].position_x < 193 * size_dm) {
                            r_obstacle_5[0].setPosition(Obstacle_1_Part2_SpeedX, 3);
                        }

                        if (r_obstacle_5[0].position_x >= 189 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[52].position(169 * size_dm, 281 * size_dm);
                                effect[52].setObstacleAlpha(200);
                                effect[52].position_effect();
                            } else {

                                effect[52].setObstacleAlpha(0);
                                effect[52].position_effect();

                            }
                        } else {
                            effect[52].setObstacleAlpha(0);
                            effect[52].position_effect();
                        }
                    } else if (r_obstacle_5[0].position_x < 169 * size_dm) {
                        r_obstacle_5[0].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        effect[52].setObstacleAlpha(0);
                        effect[52].position_effect();
                    } else {
                        r_obstacle_5[0].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        effect[52].setObstacleAlpha(0);
                        effect[52].position_effect();
                    }
                }
            }
            /////////////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[53] == 1) {
                if (r_obstacle_5[1].position_x <= 30 * size_dm) {
                    r_obstacle_5[1].position(254 * size_dm, 190 * size_dm);
                    r_obstacle_5[1].setObstacleAlpha(200);
                } else {
                    if (r_obstacle_5[1].position_x >= 228 * size_dm) {
                        r_obstacle_5[1].setObstacleAlpha(200);
                        r_obstacle_5[1].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[53].position(208 * size_dm, 242 * size_dm);
                            effect[53].setObstacleAlpha(200);
                            effect[53].position_effect();
                        } else {
                            effect[53].setObstacleAlpha(0);
                            effect[53].position_effect();
                        }
                    } else if (r_obstacle_5[1].position_x >= 156 * size_dm && r_obstacle_5[1].position_x <= 208 * size_dm) {

                        if (r_obstacle_5[1].position_x >= 180 * size_dm && r_obstacle_5[1].position_x <= 208 * size_dm) {
                            r_obstacle_5[1].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        } else if (r_obstacle_5[1].position_x >= 156 * size_dm && r_obstacle_5[1].position_x < 180 * size_dm) {
                            r_obstacle_5[1].setPosition(Obstacle_1_Part2_SpeedX, 3);
                        }

                        if (r_obstacle_5[1].position_x >= 176 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[53].position(156 * size_dm, 294 * size_dm);
                                effect[53].setObstacleAlpha(200);
                                effect[53].position_effect();
                            } else {

                                effect[53].setObstacleAlpha(0);
                                effect[53].position_effect();

                            }
                        } else {
                            effect[53].setObstacleAlpha(0);
                            effect[53].position_effect();
                        }
                    } else if (r_obstacle_5[1].position_x < 156 * size_dm) {
                        r_obstacle_5[1].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        effect[53].setObstacleAlpha(0);
                        effect[53].position_effect();
                    } else {
                        r_obstacle_5[1].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        effect[53].setObstacleAlpha(0);
                        effect[53].position_effect();
                    }
                }
            }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[54] == 1) {
                if (r_obstacle_5[2].position_x <= 30 * size_dm) {
                    r_obstacle_5[2].position(254 * size_dm, 190 * size_dm);
                    r_obstacle_5[2].setObstacleAlpha(200);
                } else {
                    if (r_obstacle_5[2].position_x >= 215 * size_dm) {
                        r_obstacle_5[2].setObstacleAlpha(200);
                        r_obstacle_5[2].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[54].position(195 * size_dm, 255 * size_dm);
                            effect[54].setObstacleAlpha(200);
                            effect[54].position_effect();
                        } else {
                            effect[54].setObstacleAlpha(0);
                            effect[54].position_effect();
                        }
                    } else if (r_obstacle_5[2].position_x >= 143 * size_dm && r_obstacle_5[2].position_x <= 195 * size_dm) {

                        if (r_obstacle_5[2].position_x >= 167 * size_dm && r_obstacle_5[2].position_x <= 195 * size_dm) {
                            r_obstacle_5[2].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        } else if (r_obstacle_5[2].position_x >= 143 * size_dm && r_obstacle_5[2].position_x < 167 * size_dm) {
                            r_obstacle_5[2].setPosition(Obstacle_1_Part2_SpeedX, 3);
                        }

                        if (r_obstacle_5[2].position_x >= 163 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[54].position(143 * size_dm, 307 * size_dm);
                                effect[54].setObstacleAlpha(200);
                                effect[54].position_effect();
                            } else {

                                effect[54].setObstacleAlpha(0);
                                effect[54].position_effect();

                            }
                        } else {
                            effect[54].setObstacleAlpha(0);
                            effect[54].position_effect();
                        }
                    } else if (r_obstacle_5[2].position_x < 143 * size_dm) {
                        r_obstacle_5[2].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        effect[54].setObstacleAlpha(0);
                        effect[54].position_effect();
                    } else {
                        r_obstacle_5[2].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        effect[54].setObstacleAlpha(0);
                        effect[54].position_effect();
                    }
                }
            }
            //////////////////////////////////////////////////////////////////////////////////////
            if (pattern[55] == 1) {
                if (r_obstacle_5[3].position_x <= 30 * size_dm) {
                    r_obstacle_5[3].position(254 * size_dm, 190 * size_dm);
                    r_obstacle_5[3].setObstacleAlpha(200);
                } else {
                    if (r_obstacle_5[3].position_x >= 202 * size_dm) {
                        r_obstacle_5[3].setObstacleAlpha(200);
                        r_obstacle_5[3].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[55].position(182 * size_dm, 268 * size_dm);
                            effect[55].setObstacleAlpha(200);
                            effect[55].position_effect();
                        } else {
                            effect[55].setObstacleAlpha(0);
                            effect[55].position_effect();
                        }
                    } else if (r_obstacle_5[3].position_x >= 130 * size_dm && r_obstacle_5[3].position_x <= 182 * size_dm) {

                        if (r_obstacle_5[3].position_x >= 154 * size_dm && r_obstacle_5[3].position_x <= 182 * size_dm) {
                            r_obstacle_5[3].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        } else if (r_obstacle_5[3].position_x >= 130 * size_dm && r_obstacle_5[3].position_x < 154 * size_dm) {
                            r_obstacle_5[3].setPosition(Obstacle_1_Part2_SpeedX, 3);
                        }

                        if (r_obstacle_5[3].position_x >= 150 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[55].position(130 * size_dm, 320 * size_dm);
                                effect[55].setObstacleAlpha(200);
                                effect[55].position_effect();
                            } else {

                                effect[55].setObstacleAlpha(0);
                                effect[55].position_effect();

                            }
                        } else {
                            effect[55].setObstacleAlpha(0);
                            effect[55].position_effect();
                        }
                    } else if (r_obstacle_5[3].position_x < 130 * size_dm) {
                        r_obstacle_5[3].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        effect[55].setObstacleAlpha(0);
                        effect[55].position_effect();
                    } else {
                        r_obstacle_5[3].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        effect[55].setObstacleAlpha(0);
                        effect[55].position_effect();
                    }
                }
            }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[56] == 1) {
                if (r_obstacle_6[0].position_x <= 30 * size_dm) {
                    r_obstacle_6[0].position(267 * size_dm, 203 * size_dm);
                    r_obstacle_6[0].setObstacleAlpha(200);
                } else {
                    if (r_obstacle_6[0].position_x >= 254 * size_dm) {
                        r_obstacle_6[0].setObstacleAlpha(200);
                        r_obstacle_6[0].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[56].position(234 * size_dm, 242 * size_dm);
                            effect[56].setObstacleAlpha(200);
                            effect[56].position_effect();
                        } else {
                            effect[56].setObstacleAlpha(0);
                            effect[56].position_effect();
                        }
                    } else if (r_obstacle_6[0].position_x >= 182 * size_dm && r_obstacle_6[0].position_x <= 234 * size_dm) {

                        if (r_obstacle_6[0].position_x >= 206 * size_dm && r_obstacle_6[0].position_x <= 234 * size_dm) {
                            r_obstacle_6[0].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        } else if (r_obstacle_6[0].position_x >= 182 * size_dm && r_obstacle_6[0].position_x < 206 * size_dm) {
                            r_obstacle_6[0].setPosition(Obstacle_1_Part2_SpeedX, 3);
                        }

                        if (r_obstacle_6[0].position_x >= 202 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[56].position(182 * size_dm, 294 * size_dm);
                                effect[56].setObstacleAlpha(200);
                                effect[56].position_effect();
                            } else {

                                effect[56].setObstacleAlpha(0);
                                effect[56].position_effect();

                            }
                        } else {
                            effect[56].setObstacleAlpha(0);
                            effect[56].position_effect();
                        }
                    } else if (r_obstacle_6[0].position_x < 182 * size_dm) {
                        r_obstacle_6[0].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        effect[56].setObstacleAlpha(0);
                        effect[56].position_effect();
                    } else {
                        r_obstacle_6[0].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        effect[56].setObstacleAlpha(0);
                        effect[56].position_effect();
                    }
                }
            }
            /////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[57] == 1) {
                if (r_obstacle_6[1].position_x <= 30 * size_dm) {
                    r_obstacle_6[1].position(267 * size_dm, 203 * size_dm);
                    r_obstacle_6[1].setObstacleAlpha(200);
                } else {
                    if (r_obstacle_6[1].position_x >= 241 * size_dm) {
                        r_obstacle_6[1].setObstacleAlpha(200);
                        r_obstacle_6[1].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[57].position(221 * size_dm, 255 * size_dm);
                            effect[57].setObstacleAlpha(200);
                            effect[57].position_effect();
                        } else {
                            effect[57].setObstacleAlpha(0);
                            effect[57].position_effect();
                        }
                    } else if (r_obstacle_6[1].position_x >= 169 * size_dm && r_obstacle_6[1].position_x <= 221 * size_dm) {

                        if (r_obstacle_6[1].position_x >= 193 * size_dm && r_obstacle_6[1].position_x <= 221 * size_dm) {
                            r_obstacle_6[1].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        } else if (r_obstacle_6[1].position_x >= 169 * size_dm && r_obstacle_6[1].position_x < 193 * size_dm) {
                            r_obstacle_6[1].setPosition(Obstacle_1_Part2_SpeedX, 3);
                        }

                        if (r_obstacle_6[1].position_x >= 189 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[57].position(169 * size_dm, 307 * size_dm);
                                effect[57].setObstacleAlpha(200);
                                effect[57].position_effect();
                            } else {

                                effect[57].setObstacleAlpha(0);
                                effect[57].position_effect();

                            }
                        } else {
                            effect[57].setObstacleAlpha(0);
                            effect[57].position_effect();
                        }
                    } else if (r_obstacle_6[1].position_x < 169 * size_dm) {
                        r_obstacle_6[1].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        effect[57].setObstacleAlpha(0);
                        effect[57].position_effect();
                    } else {
                        r_obstacle_6[1].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        effect[57].setObstacleAlpha(0);
                        effect[57].position_effect();
                    }
                }
            }
            ////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[58] == 1) {
                if (r_obstacle_6[2].position_x <= 30 * size_dm) {
                    r_obstacle_6[2].position(267 * size_dm, 203 * size_dm);
                    r_obstacle_6[2].setObstacleAlpha(200);
                } else {
                    if (r_obstacle_6[2].position_x >= 228 * size_dm) {
                        r_obstacle_6[2].setObstacleAlpha(200);
                        r_obstacle_6[2].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[58].position(208 * size_dm, 268 * size_dm);
                            effect[58].setObstacleAlpha(200);
                            effect[58].position_effect();
                        } else {
                            effect[58].setObstacleAlpha(0);
                            effect[58].position_effect();
                        }
                    } else if (r_obstacle_6[2].position_x >= 156 * size_dm && r_obstacle_6[2].position_x <= 208 * size_dm) {

                        if (r_obstacle_6[2].position_x >= 180 * size_dm && r_obstacle_6[2].position_x <= 208 * size_dm) {
                            r_obstacle_6[2].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        } else if (r_obstacle_6[2].position_x >= 156 * size_dm && r_obstacle_6[2].position_x < 180 * size_dm) {
                            r_obstacle_6[2].setPosition(Obstacle_1_Part2_SpeedX, 3);
                        }

                        if (r_obstacle_6[2].position_x >= 176 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[58].position(156 * size_dm, 320 * size_dm);
                                effect[58].setObstacleAlpha(200);
                                effect[58].position_effect();
                            } else {

                                effect[58].setObstacleAlpha(0);
                                effect[58].position_effect();

                            }
                        } else {
                            effect[58].setObstacleAlpha(0);
                            effect[58].position_effect();
                        }
                    } else if (r_obstacle_6[2].position_x < 156 * size_dm) {
                        r_obstacle_6[2].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        effect[58].setObstacleAlpha(0);
                        effect[58].position_effect();
                    } else {
                        r_obstacle_6[2].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        effect[58].setObstacleAlpha(0);
                        effect[58].position_effect();
                    }
                }
            }
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[59] == 1) {
                if (r_obstacle_6[3].position_x <= 30 * size_dm) {
                    r_obstacle_6[3].position(267 * size_dm, 203 * size_dm);
                    r_obstacle_6[3].setObstacleAlpha(200);
                } else {
                    if (r_obstacle_6[3].position_x >= 215 * size_dm) {
                        r_obstacle_6[3].setObstacleAlpha(200);
                        r_obstacle_6[3].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[59].position(195 * size_dm, 281 * size_dm);
                            effect[59].setObstacleAlpha(200);
                            effect[59].position_effect();
                        } else {
                            effect[59].setObstacleAlpha(0);
                            effect[59].position_effect();
                        }
                    } else if (r_obstacle_6[3].position_x >= 143 * size_dm && r_obstacle_6[3].position_x <= 195 * size_dm) {

                        if (r_obstacle_6[3].position_x >= 167 * size_dm && r_obstacle_6[3].position_x <= 195 * size_dm) {
                            r_obstacle_6[3].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        } else if (r_obstacle_6[3].position_x >= 143 * size_dm && r_obstacle_6[3].position_x < 167 * size_dm) {
                            r_obstacle_6[3].setPosition(Obstacle_1_Part2_SpeedX, 3);
                        }

                        if (r_obstacle_6[3].position_x >= 163 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[59].position(143 * size_dm, 333 * size_dm);
                                effect[59].setObstacleAlpha(200);
                                effect[59].position_effect();
                            } else {

                                effect[59].setObstacleAlpha(0);
                                effect[59].position_effect();

                            }
                        } else {
                            effect[59].setObstacleAlpha(0);
                            effect[59].position_effect();
                        }
                    } else if (r_obstacle_6[3].position_x < 143 * size_dm) {
                        r_obstacle_6[3].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        effect[59].setObstacleAlpha(0);
                        effect[59].position_effect();
                    } else {
                        r_obstacle_6[3].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        effect[59].setObstacleAlpha(0);
                        effect[59].position_effect();
                    }
                }
            }
            ///////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[60] == 1) {
                if (r_obstacle_7[0].position_x <= 30 * size_dm) {
                    r_obstacle_7[0].position(280 * size_dm, 216 * size_dm);
                    r_obstacle_7[0].setObstacleAlpha(200);
                } else {
                    if (r_obstacle_7[0].position_x >= 267 * size_dm) {
                        r_obstacle_7[0].setObstacleAlpha(200);
                        r_obstacle_7[0].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[60].position(247 * size_dm, 255 * size_dm);
                            effect[60].setObstacleAlpha(200);
                            effect[60].position_effect();
                        } else {
                            effect[60].setObstacleAlpha(0);
                            effect[60].position_effect();
                        }
                    } else if (r_obstacle_7[0].position_x >= 195 * size_dm && r_obstacle_7[0].position_x <= 247 * size_dm) {

                        if (r_obstacle_7[0].position_x >= 219 * size_dm && r_obstacle_7[0].position_x <= 247 * size_dm) {
                            r_obstacle_7[0].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        } else if (r_obstacle_7[0].position_x >= 195 * size_dm && r_obstacle_7[0].position_x < 219 * size_dm) {
                            r_obstacle_7[0].setPosition(Obstacle_1_Part2_SpeedX, 3);
                        }

                        if (r_obstacle_7[0].position_x >= 215 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[60].position(195 * size_dm, 307 * size_dm);
                                effect[60].setObstacleAlpha(200);
                                effect[60].position_effect();
                            } else {

                                effect[60].setObstacleAlpha(0);
                                effect[60].position_effect();

                            }
                        } else {
                            effect[60].setObstacleAlpha(0);
                            effect[60].position_effect();
                        }
                    } else if (r_obstacle_7[0].position_x < 195 * size_dm) {
                        r_obstacle_7[0].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        effect[60].setObstacleAlpha(0);
                        effect[60].position_effect();
                    } else {
                        r_obstacle_7[0].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        effect[60].setObstacleAlpha(0);
                        effect[60].position_effect();
                    }
                }
            }
            /////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[61] == 1) {
                if (r_obstacle_7[1].position_x <= 30 * size_dm) {
                    r_obstacle_7[1].position(280 * size_dm, 216 * size_dm);
                    r_obstacle_7[1].setObstacleAlpha(200);
                } else {
                    if (r_obstacle_7[1].position_x >= 254 * size_dm) {
                        r_obstacle_7[1].setObstacleAlpha(200);
                        r_obstacle_7[1].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[61].position(234 * size_dm, 268 * size_dm);
                            effect[61].setObstacleAlpha(200);
                            effect[61].position_effect();
                        } else {
                            effect[61].setObstacleAlpha(0);
                            effect[61].position_effect();
                        }
                    } else if (r_obstacle_7[1].position_x >= 182 * size_dm && r_obstacle_7[1].position_x <= 234 * size_dm) {

                        if (r_obstacle_7[1].position_x >= 206 * size_dm && r_obstacle_7[1].position_x <= 234 * size_dm) {
                            r_obstacle_7[1].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        } else if (r_obstacle_7[1].position_x >= 182 * size_dm && r_obstacle_7[1].position_x < 206 * size_dm) {
                            r_obstacle_7[1].setPosition(Obstacle_1_Part2_SpeedX, 3);
                        }

                        if (r_obstacle_7[1].position_x >= 202 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[61].position(182 * size_dm, 320 * size_dm);
                                effect[61].setObstacleAlpha(200);
                                effect[61].position_effect();
                            } else {

                                effect[61].setObstacleAlpha(0);
                                effect[61].position_effect();

                            }
                        } else {
                            effect[61].setObstacleAlpha(0);
                            effect[61].position_effect();
                        }
                    } else if (r_obstacle_7[1].position_x < 182 * size_dm) {
                        r_obstacle_7[1].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        effect[61].setObstacleAlpha(0);
                        effect[61].position_effect();
                    } else {
                        r_obstacle_7[1].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        effect[61].setObstacleAlpha(0);
                        effect[61].position_effect();
                    }
                }
            }
            //////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[62] == 1) {
                if (r_obstacle_7[2].position_x <= 30 * size_dm) {
                    r_obstacle_7[2].position(280 * size_dm, 216 * size_dm);
                    r_obstacle_7[2].setObstacleAlpha(200);
                } else {
                    if (r_obstacle_7[2].position_x >= 241 * size_dm) {
                        r_obstacle_7[2].setObstacleAlpha(200);
                        r_obstacle_7[2].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[62].position(221 * size_dm, 281 * size_dm);
                            effect[62].setObstacleAlpha(200);
                            effect[62].position_effect();
                        } else {
                            effect[62].setObstacleAlpha(0);
                            effect[62].position_effect();
                        }
                    } else if (r_obstacle_7[2].position_x >= 169 * size_dm && r_obstacle_7[2].position_x <= 221 * size_dm) {

                        if (r_obstacle_7[2].position_x >= 193 * size_dm && r_obstacle_7[2].position_x <= 221 * size_dm) {
                            r_obstacle_7[2].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        } else if (r_obstacle_7[2].position_x >= 169 * size_dm && r_obstacle_7[2].position_x < 193 * size_dm) {
                            r_obstacle_7[2].setPosition(Obstacle_1_Part2_SpeedX, 3);
                        }

                        if (r_obstacle_7[2].position_x >= 189 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[62].position(169 * size_dm, 333 * size_dm);
                                effect[62].setObstacleAlpha(200);
                                effect[62].position_effect();
                            } else {

                                effect[62].setObstacleAlpha(0);
                                effect[62].position_effect();

                            }
                        } else {
                            effect[62].setObstacleAlpha(0);
                            effect[62].position_effect();
                        }
                    } else if (r_obstacle_7[2].position_x < 169 * size_dm) {
                        r_obstacle_7[2].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        effect[62].setObstacleAlpha(0);
                        effect[62].position_effect();
                    } else {
                        r_obstacle_7[2].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        effect[62].setObstacleAlpha(0);
                        effect[62].position_effect();
                    }
                }
            }
            ///////////////////////////////////////////////////////////////////////////////////////////////////
            if (pattern[63] == 1) {
                if (r_obstacle_7[3].position_x <= 30 * size_dm) {
                    r_obstacle_7[3].position(280 * size_dm, 216 * size_dm);
                    r_obstacle_7[3].setObstacleAlpha(200);
                } else {
                    if (r_obstacle_7[3].position_x >= 228 * size_dm) {
                        r_obstacle_7[3].setObstacleAlpha(200);
                        r_obstacle_7[3].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        if (level_time_number % 2 == 0) {
                            effect[63].position(208 * size_dm, 294 * size_dm);
                            effect[63].setObstacleAlpha(200);
                            effect[63].position_effect();
                        } else {
                            effect[63].setObstacleAlpha(0);
                            effect[63].position_effect();
                        }
                    } else if (r_obstacle_7[3].position_x >= 156 * size_dm && r_obstacle_7[3].position_x <= 208 * size_dm) {

                        if (r_obstacle_7[3].position_x >= 180 * size_dm && r_obstacle_7[3].position_x <= 208 * size_dm) {
                            r_obstacle_7[3].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        } else if (r_obstacle_7[3].position_x >= 156 * size_dm && r_obstacle_7[3].position_x < 180 * size_dm) {
                            r_obstacle_7[3].setPosition(Obstacle_1_Part2_SpeedX, 3);
                        }

                        if (r_obstacle_7[3].position_x >= 176 * size_dm) {
                            if (level_time_number % 2 == 0) {
                                effect[63].position(156 * size_dm, 346 * size_dm);
                                effect[63].setObstacleAlpha(200);
                                effect[63].position_effect();
                            } else {

                                effect[63].setObstacleAlpha(0);
                                effect[63].position_effect();

                            }
                        } else {
                            effect[63].setObstacleAlpha(0);
                            effect[63].position_effect();
                        }
                    } else if (r_obstacle_7[3].position_x < 156 * size_dm) {
                        r_obstacle_7[3].setPosition(Obstacle_1_Part2_SpeedX, Obstacle_1_Part2_SpeedY);
                        effect[63].setObstacleAlpha(0);
                        effect[63].position_effect();
                    } else {
                        r_obstacle_7[3].setPosition(Obstacle_1_Part1_SpeedX, Obstacle_1_Part1_SpeedY);
                        effect[63].setObstacleAlpha(0);
                        effect[63].position_effect();
                    }
                }
            }
        }
        else if(enemy_action_flag1 == true){

            for(int i=0; i<64; i++)
            {
                pattern[i] = 0;
            }

            for(int i=0; i<64; i++)
            {
                effect[i].setObstacleAlpha(0);
                effect[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                obstacle[i].position(120*size_dm, 125*size_dm);
                obstacle[i].setObstacleAlpha(0);
                obstacle[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                obstacle_1[i].position(107*size_dm, 138*size_dm);
                obstacle_1[i].setObstacleAlpha(0);
                obstacle_1[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                obstacle_2[i].position(94*size_dm, 151*size_dm);
                obstacle_2[i].setObstacleAlpha(0);
                obstacle_2[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                obstacle_3[i].position(81*size_dm, 164*size_dm);
                obstacle_3[i].setObstacleAlpha(0);
                obstacle_3[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                obstacle_4[i].position(68*size_dm, 177*size_dm);
                obstacle_4[i].setObstacleAlpha(0);
                obstacle_4[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                obstacle_5[i].position(55*size_dm, 190*size_dm);
                obstacle_5[i].setObstacleAlpha(0);
                obstacle_5[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                obstacle_6[i].position(42*size_dm, 203*size_dm);
                obstacle_6[i].setObstacleAlpha(0);
                obstacle_6[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                obstacle_7[i].position(29*size_dm, 216*size_dm);
                obstacle_7[i].setObstacleAlpha(0);
                obstacle_7[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                r_obstacle[i].position(189*size_dm, 125*size_dm);
                r_obstacle[i].setObstacleAlpha(0);
                r_obstacle[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                r_obstacle_1[i].position(202*size_dm, 138*size_dm);
                r_obstacle_1[i].setObstacleAlpha(0);
                r_obstacle_1[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                r_obstacle_2[i].position(215*size_dm, 151*size_dm);
                r_obstacle_2[i].setObstacleAlpha(0);
                r_obstacle_2[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                r_obstacle_3[i].position(228*size_dm, 164*size_dm);
                r_obstacle_3[i].setObstacleAlpha(0);
                r_obstacle_3[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                r_obstacle_4[i].position(241*size_dm, 177*size_dm);
                r_obstacle_4[i].setObstacleAlpha(0);
                r_obstacle_4[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                r_obstacle_5[i].position(254*size_dm, 190*size_dm);
                r_obstacle_5[i].setObstacleAlpha(0);
                r_obstacle_5[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                r_obstacle_6[i].position(267*size_dm, 203*size_dm);
                r_obstacle_6[i].setObstacleAlpha(0);
                r_obstacle_6[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                r_obstacle_7[i].position(280*size_dm, 216*size_dm);
                r_obstacle_7[i].setObstacleAlpha(0);
                r_obstacle_7[i].position_effect();
            }

        } else if (action_flag1_count == 0)
        {
            for(int i=0; i<64; i++)
            {
                pattern[i] = 0;
            }

            for(int i=0; i<64; i++)
            {
                effect[i].setObstacleAlpha(0);
                effect[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                obstacle[i].position(120*size_dm, 125*size_dm);
                obstacle[i].setObstacleAlpha(0);
                obstacle[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                obstacle_1[i].position(107*size_dm, 138*size_dm);
                obstacle_1[i].setObstacleAlpha(0);
                obstacle_1[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                obstacle_2[i].position(94*size_dm, 151*size_dm);
                obstacle_2[i].setObstacleAlpha(0);
                obstacle_2[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                obstacle_3[i].position(81*size_dm, 164*size_dm);
                obstacle_3[i].setObstacleAlpha(0);
                obstacle_3[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                obstacle_4[i].position(68*size_dm, 177*size_dm);
                obstacle_4[i].setObstacleAlpha(0);
                obstacle_4[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                obstacle_5[i].position(55*size_dm, 190*size_dm);
                obstacle_5[i].setObstacleAlpha(0);
                obstacle_5[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                obstacle_6[i].position(42*size_dm, 203*size_dm);
                obstacle_6[i].setObstacleAlpha(0);
                obstacle_6[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                obstacle_7[i].position(29*size_dm, 216*size_dm);
                obstacle_7[i].setObstacleAlpha(0);
                obstacle_7[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                r_obstacle[i].position(189*size_dm, 125*size_dm);
                r_obstacle[i].setObstacleAlpha(0);
                r_obstacle[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                r_obstacle_1[i].position(202*size_dm, 138*size_dm);
                r_obstacle_1[i].setObstacleAlpha(0);
                r_obstacle_1[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                r_obstacle_2[i].position(215*size_dm, 151*size_dm);
                r_obstacle_2[i].setObstacleAlpha(0);
                r_obstacle_2[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                r_obstacle_3[i].position(228*size_dm, 164*size_dm);
                r_obstacle_3[i].setObstacleAlpha(0);
                r_obstacle_3[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                r_obstacle_4[i].position(241*size_dm, 177*size_dm);
                r_obstacle_4[i].setObstacleAlpha(0);
                r_obstacle_4[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                r_obstacle_5[i].position(254*size_dm, 190*size_dm);
                r_obstacle_5[i].setObstacleAlpha(0);
                r_obstacle_5[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                r_obstacle_6[i].position(267*size_dm, 203*size_dm);
                r_obstacle_6[i].setObstacleAlpha(0);
                r_obstacle_6[i].position_effect();
            }

            for(int i=0; i<4; i++)
            {
                r_obstacle_7[i].position(280*size_dm, 216*size_dm);
                r_obstacle_7[i].setObstacleAlpha(0);
                r_obstacle_7[i].position_effect();
            }
        }
    }

    private int getRandomMath9(int max, int offset) {


        int nResult = (int)(Math.random() * (max-offset+1)) + offset;


        return nResult;

    }

    public void shot_enemy1()
    {
        int position_x = (int) (player.getX() - (enemy_center.getX()));
        int position_y = (int) (player.getY() - (enemy_center.getY()));
        float angle = (float) cal_angle(position_x, position_y);

        if( (angle <= 90 && angle >= 0) || (angle >= 180 && angle < 270)) {
            enemy1_cal[0] = 1;
            enemy1_cal[1] = 0;

        } else
        {
            enemy1_cal[0] = 0;
            enemy1_cal[1] = 1;
        }

    }


    public void shot_enemy2()
    {
        int position_x = (int) (player.getX() - (enemy_center.getX()));
        int position_y = (int) (player.getY() - (enemy_center.getY()));
        float angle = (float) cal_angle(position_x, position_y);

        if( (angle <= 270 && angle > 90) || (angle >= 90 && angle < 270)) {
            enemy1_cal[0] = 1;
            enemy1_cal[1] = 0;

        } else
        {
            enemy1_cal[0] = 0;
            enemy1_cal[1] = 1;
        }

    }

    public void shot_enemy6()
    {
        int position_x = (int) (player.getX() - (enemy_center.getX()-enemy_center.getWidth()/2));
        int position_y = (int) (player.getY() - (enemy_center.getY()-enemy_center.getHeight()/2));
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

    public void enemy_move_angle()
    {
        int position_x = (int) (player.getX() - (enemy_center.getX()-enemy_center.getWidth()/2));
        int position_y = (int) (player.getY() - (enemy_center.getY()-enemy_center.getHeight()/2));
        float angle = (float) cal_angle(position_x, position_y);

        //if(angle >= 225 && angle < 315 )

       if(angle >= 16.25 && angle < 38.75 ) {
            enemy_move_number[1] = 1;

        } else if(angle >= 38.75 && angle < 61.25 ) {
            enemy_move_number[2] = 1;

        } else if(angle >= 61.25 && angle < 83.75) {

            enemy_move_number[3] = 1;
        } else if(angle >= 83.75 && angle < 106.25){

            enemy_move_number[4] = 1;
        }else if(angle >= 106.25 && angle < 128.75){

            enemy_move_number[5] = 1;
        }else if(angle >= 128.75 && angle < 151.25){

            enemy_move_number[6] = 1;
        }else if(angle >= 151.25 && angle < 173.75){

            enemy_move_number[7] = 1;
        }else if(angle >= 173.75 && angle < 196.25){

            enemy_move_number[8] = 1;
        }else if(angle >= 196.25 && angle < 218.75){

            enemy_move_number[9] = 1;
        }else if(angle >= 218.75 && angle < 241.25){

            enemy_move_number[10] = 1;
        }else if(angle >= 241.25 && angle < 263.75){

            enemy_move_number[11] = 1;
        }else if(angle >= 263.75 && angle < 286.25){

            enemy_move_number[12] = 1;
        }else if(angle >= 286.25 && angle < 308.75){

            enemy_move_number[13] = 1;
        }else if(angle >= 308.75 && angle < 331.25){

            enemy_move_number[14] = 1;
        }else if(angle >= 331.25 && angle < 353.75){

            enemy_move_number[15] = 1;
        }
        else{
        enemy_move_number[0] = 1;


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


    public void bullet_moving(float x, float y, int z, int t) {
        int initial_bullet_x = (int) x;
        int initial_bullet_y = (int) y;

        int bullet_speed_x = -z;
        int bullet_speed_y = -t;

        for(int i=0; i<5; i++) {
            if (bullet[i] == 1) {
                if ((bullet_number_count == i + 1) && (bullet_click == true)) {
                    bullet_SpeedX[i] = bullet_speed_x;
                    bullet_SpeedY[i] = bullet_speed_y;

                    bullet_initialX[i] = initial_bullet_x;
                    bullet_initialY[i] = initial_bullet_y;

                    bullet_click = false;
                    bullet_number_count = 0;

                    player_bullet[i].position(bullet_initialX[i], bullet_initialY[i]);
                }

                if (player_bullet[i].position_x >= 260 * size_dm || player_bullet[i].position_x <= 10 * size_dm || player_bullet[i].position_y <= 110 * size_dm || player_bullet[i].position_y >= 350 * size_dm) {

                    player_bullet[i].position(10, 10);
                    player_bullet[i].setObstacleAlpha(0);
                    player_bullet[i].position_effect();
                    bullet[i] = 0;
                    bullet_number_count = 0;
                    bullet_click = false;

                } else {

                    player_bullet[i].setObstacleAlpha(200);
                    player_bullet[i].setPosition(bullet_SpeedX[i], bullet_SpeedY[i]);
                }
            }

        }
    }


    boolean hit_check_enemy() {

        for (int i = 0; i < 5; i++) {
            if ((player_bullet[i].position_x - enemy_center.getX()) * (player_bullet[i].position_x - enemy_center.getX()) < player_bullet[i].resized_width/2 * player_bullet[i].resized_width) {
                if ((player_bullet[i].position_y - enemy_center.getY()) * (player_bullet[i].position_y- enemy_center.getY()) < player_bullet[i].resized_height/2 * player_bullet[i].resized_height) {
                    return true;
                }
            }
        }

        return false;
    }

    boolean hit_check()
    {

        if((enemy_center.getX() -enemy_center.getWidth()/2 - player.getX())*(enemy_center.getX() -enemy_center.getWidth()/2 - player.getX()) < enemy_center.getWidth()/2*enemy_center.getWidth()/3)
        {
            if((enemy_center.getY() -enemy_center.getHeight()/2  - player.getY())*(enemy_center.getY() -enemy_center.getHeight()/2 - player.getY()) < enemy_center.getHeight()/2*enemy_center.getHeight()/3)
            {
                return true;
            }
        }

        if(action_flag1_count2 == 0)
        {

            if (pattern[0] == 1) {
                if ((obstacle[0].position_x+obstacle[0].resized_width/4-player.getX())*(obstacle[0].position_x+obstacle[0].resized_width/4-player.getX()) < obstacle[0].resized_width/3 *  obstacle[0].resized_width/2)
                {
                    if((obstacle[0].position_y+obstacle[0].resized_height/4-player.getY())*(obstacle[0].position_y+obstacle[0].resized_height/4-player.getY()) < obstacle[0].resized_height/2*obstacle[0].resized_height/3)
                    {
                        return true;
                    }
                }
            }

            if (pattern[1] == 1) {
                if ((obstacle[1].position_x+obstacle[1].resized_width/4-player.getX())*(obstacle[1].position_x+obstacle[1].resized_width/4-player.getX()) < obstacle[1].resized_width/3 *  obstacle[1].resized_width/2)
                {
                    if((obstacle[1].position_y+obstacle[1].resized_height/4-player.getY())*(obstacle[1].position_y+obstacle[1].resized_height/4-player.getY()) < obstacle[1].resized_height/2*obstacle[1].resized_height/3)
                    {
                        return true;
                    }
                }
            }

            if (pattern[2] == 1) {
                if ((obstacle[2].position_x+obstacle[2].resized_width/4-player.getX())*(obstacle[2].position_x+obstacle[2].resized_width/4-player.getX()) < obstacle[2].resized_width/3 *  obstacle[2].resized_width/2)
                {
                    if((obstacle[2].position_y+obstacle[2].resized_height/4-player.getY())*(obstacle[2].position_y+obstacle[2].resized_height/4-player.getY()) < obstacle[2].resized_height/3*obstacle[2].resized_height/3)
                    {
                        return true;
                    }
                }
            }

            if (pattern[3] == 1) {
                if ((obstacle[3].position_x+obstacle[3].resized_width/4-player.getX())*(obstacle[3].position_x+obstacle[3].resized_width/4-player.getX()) < obstacle[3].resized_width/3 *  obstacle[3].resized_width/2)
                {
                    if((obstacle[3].position_y+obstacle[3].resized_height/4-player.getY())*(obstacle[3].position_y+obstacle[3].resized_height/4-player.getY()) < obstacle[3].resized_height/2*obstacle[3].resized_height/3)
                    {
                        return true;
                    }
                }
            }

            if (pattern[4] == 1) {
                if ((obstacle_3[3].position_x+obstacle_3[3].resized_width/4-player.getX())*(obstacle_3[3].position_x+obstacle_3[3].resized_width/4-player.getX()) < obstacle_3[3].resized_width/3 *  obstacle_3[3].resized_width/2)
                {
                    if((obstacle_3[3].position_y+obstacle_3[3].resized_height/4-player.getY())*(obstacle_3[3].position_y+obstacle_3[3].resized_height/4-player.getY()) < obstacle_3[3].resized_height/2*obstacle_3[3].resized_height/3)
                    {
                        return true;
                    }
                }
            }

            if (pattern[5] == 1) {
                if ((obstacle_1[0].position_x+obstacle_1[0].resized_width/4-player.getX())*(obstacle_1[0].position_x+obstacle_1[0].resized_width/4-player.getX()) < obstacle_1[0].resized_width/3 * obstacle_1[0].resized_width/2)
                {
                    if((obstacle_1[0].position_y+obstacle_1[0].resized_height/4-player.getY())*(obstacle_1[0].position_y+obstacle_1[0].resized_height/4-player.getY()) < obstacle_1[0].resized_height/2*obstacle_1[0].resized_height/3)
                    {
                        return true;
                    }
                }
            }

            if (pattern[6] == 1) {
                if ((obstacle_1[1].position_x+obstacle_1[1].resized_width/4-player.getX())*(obstacle_1[1].position_x+obstacle_1[1].resized_width/4-player.getX()) < obstacle_1[1].resized_width/3 * obstacle_1[1].resized_width/2)
                {
                    if((obstacle_1[1].position_y+obstacle_1[1].resized_height/4-player.getY())*(obstacle_1[1].position_y+obstacle_1[1].resized_height/4-player.getY()) < obstacle_1[1].resized_height/2*obstacle_1[1].resized_height/3)
                    {
                        return true;
                    }
                }
            }

            if (pattern[7] == 1) {
                if ((obstacle_1[2].position_x + obstacle_1[2].resized_width / 4 - player.getX()) * (obstacle_1[2].position_x + obstacle_1[2].resized_width / 4 - player.getX()) < obstacle_1[2].resized_width / 3 * obstacle_1[2].resized_width / 2) {
                    if ((obstacle_1[2].position_y + obstacle_1[2].resized_height / 4 - player.getY()) * (obstacle_1[2].position_y + obstacle_1[2].resized_height / 4 - player.getY()) < obstacle_1[2].resized_height / 2 * obstacle_1[2].resized_height / 3) {
                        return true;
                    }
                }
            }

            if (pattern[8] == 1) {
                if ((effect[0].position_x + effect[0].resized_width / 4 - player.getX()) * (effect[0].position_x + effect[0].resized_width / 4 - player.getX()) < effect[0].resized_width / 3 * effect[0].resized_width / 2) {
                    if ((effect[0].position_y + effect[0].resized_height / 4 - player.getY()) * (effect[0].position_y + effect[0].resized_height / 4 - player.getY()) < effect[0].resized_height / 3 * effect[0].resized_height / 2) {
                        return true;
                    }
                }
            }

            if (pattern[9] == 1) {
                if ((effect[1].position_x + effect[1].resized_width / 4 - player.getX()) * (effect[1].position_x + effect[1].resized_width / 4 - player.getX()) < effect[1].resized_width / 3 * effect[1].resized_width / 2) {
                    if ((effect[1].position_y + effect[1].resized_height / 4 - player.getY()) * (effect[1].position_y + effect[1].resized_height / 4 - player.getY()) < effect[1].resized_height / 3 * effect[1].resized_height / 2) {
                        return true;
                    }
                }
            }

            if (pattern[10] == 1) {
                if ((effect[2].position_x + effect[2].resized_width / 4 - player.getX()) * (effect[2].position_x + effect[2].resized_width / 4 - player.getX()) < effect[2].resized_width / 3 * effect[2].resized_width / 2) {
                    if ((effect[2].position_y + effect[2].resized_height / 4 - player.getY()) * (effect[2].position_y + effect[2].resized_height / 4 - player.getY()) < effect[2].resized_height / 3 * effect[2].resized_height / 2) {
                        return true;
                    }
                }
            }

            if (pattern[11] == 1) {
                if ((effect[3].position_x + effect[3].resized_width / 4 - player.getX()) * (effect[3].position_x + effect[3].resized_width / 4 - player.getX()) < effect[3].resized_width / 3 * effect[3].resized_width / 2) {
                    if ((effect[3].position_y + effect[3].resized_height / 4 - player.getY()) * (effect[3].position_y + effect[3].resized_height / 4 - player.getY()) < effect[3].resized_height / 3 * effect[3].resized_height / 2) {
                        return true;
                    }
                }
            }

            if (pattern[12] == 1) {
                if ((effect[4].position_x + effect[4].resized_width / 4 - player.getX()) * (effect[4].position_x + effect[4].resized_width / 4 - player.getX()) < effect[4].resized_width / 3 * effect[4].resized_width / 2) {
                    if ((effect[4].position_y + effect[4].resized_height / 4 - player.getY()) * (effect[4].position_y + effect[4].resized_height / 4 - player.getY()) < effect[4].resized_height / 3 * effect[4].resized_height / 2) {
                        return true;
                    }
                }
            }

            if (pattern[13] == 1) {
                if ((effect[5].position_x + effect[5].resized_width / 4 - player.getX()) * (effect[5].position_x + effect[5].resized_width / 4 - player.getX()) < effect[5].resized_width / 3 * effect[5].resized_width / 2) {
                    if ((effect[5].position_y + effect[5].resized_height / 4 - player.getY()) * (effect[5].position_y + effect[5].resized_height / 4 - player.getY()) < effect[5].resized_height / 3 * effect[5].resized_height / 2) {
                        return true;
                    }
                }
            }

            if (pattern[14] == 1) {
                if ((effect[6].position_x + effect[6].resized_width / 4 - player.getX()) * (effect[6].position_x + effect[6].resized_width / 4 - player.getX()) < effect[6].resized_width / 3 * effect[6].resized_width / 2) {
                    if ((effect[6].position_y + effect[6].resized_height / 4 - player.getY()) * (effect[6].position_y + effect[6].resized_height / 4 - player.getY()) < effect[6].resized_height / 3 * effect[6].resized_height / 2) {
                        return true;
                    }
                }
            }

            if (pattern[15] == 1) {
                if ((effect[7].position_x + effect[7].resized_width / 4 - player.getX()) * (effect[7].position_x + effect[7].resized_width / 4 - player.getX()) < effect[7].resized_width / 3 * effect[7].resized_width / 2) {
                    if ((effect[7].position_y + effect[7].resized_height / 4 - player.getY()) * (effect[7].position_y + effect[7].resized_height / 4 - player.getY()) < effect[7].resized_height / 3 * effect[7].resized_height / 2) {
                        return true;
                    }
                }
            }

            if (pattern[16] == 1) {
                if ((obstacle_1[3].position_x + obstacle_1[3].resized_width/4 -player.getX())*(obstacle_1[3].position_x + obstacle_1[3].resized_width/4 -player.getX()) < obstacle_1[3].resized_width/3*obstacle_1[3].resized_width/2) {
                    if ((obstacle_1[3].position_y + obstacle_1[3].resized_height/4 -player.getY())*(obstacle_1[3].position_y + obstacle_1[3].resized_height/4 -player.getY()) < obstacle_1[3].resized_height/3*obstacle_1[3].resized_height/2) {
                        return true;
                    }
                }
            }

            if (pattern[17] == 1) {
                if ((obstacle_2[0].position_x + obstacle_2[0].resized_width/4 -player.getX())*(obstacle_2[0].position_x + obstacle_2[0].resized_width/4 -player.getX()) < obstacle_2[0].resized_width/3*obstacle_2[0].resized_width/2) {
                    if ((obstacle_2[0].position_y + obstacle_2[0].resized_height/4 -player.getY())*(obstacle_2[0].position_y + obstacle_2[0].resized_height/4 -player.getY()) < obstacle_2[0].resized_height/3*obstacle_2[0].resized_height/2) {
                        return true;
                    }
                }
            }

            if (pattern[18] == 1) {
                if ((obstacle_2[1].position_x + obstacle_2[1].resized_width/4 -player.getX())*(obstacle_2[1].position_x + obstacle_2[1].resized_width/4 -player.getX()) < obstacle_2[1].resized_width/3*obstacle_2[1].resized_width/2) {
                    if ((obstacle_2[1].position_y + obstacle_2[1].resized_height/4 -player.getY())*(obstacle_2[1].position_y + obstacle_2[1].resized_height/4 -player.getY()) < obstacle_2[1].resized_height/3*obstacle_2[1].resized_height/2) {
                        return true;
                    }
                }
            }

            if (pattern[19] == 1) {
                if ((obstacle_2[2].position_x + obstacle_2[2].resized_width/4 -player.getX())*(obstacle_2[2].position_x + obstacle_2[2].resized_width/4 -player.getX()) < obstacle_2[2].resized_width/3*obstacle_2[2].resized_width/2) {
                    if ((obstacle_2[2].position_y + obstacle_2[2].resized_height/4 -player.getY())*(obstacle_2[2].position_y + obstacle_2[2].resized_height/4 -player.getY()) < obstacle_2[2].resized_height/3*obstacle_2[2].resized_height/2) {
                        return true;
                    }
                }
            }

            if (pattern[20] == 1) {
                if ((obstacle_2[3].position_x + obstacle_2[3].resized_width/4 -player.getX())*(obstacle_2[3].position_x + obstacle_2[3].resized_width/4 -player.getX()) < obstacle_2[3].resized_width/3*obstacle_2[3].resized_width/2) {
                    if ((obstacle_2[3].position_y + obstacle_2[3].resized_height/4 -player.getY())*(obstacle_2[3].position_y + obstacle_2[3].resized_height/4 -player.getY()) < obstacle_2[3].resized_height/3*obstacle_2[3].resized_height/2) {
                        return true;
                    }
                }
            }

            if (pattern[21] == 1) {
                if ((obstacle_3[0].position_x + obstacle_3[0].resized_width/4 -player.getX())*(obstacle_3[0].position_x + obstacle_3[0].resized_width/4 -player.getX()) < obstacle_3[0].resized_width/3*obstacle_3[0].resized_width/2) {
                    if ((obstacle_3[0].position_y + obstacle_3[0].resized_height/4 -player.getY())*(obstacle_3[0].position_y + obstacle_3[0].resized_height/4 -player.getY()) < obstacle_3[0].resized_height/3*obstacle_3[0].resized_height/2) {
                        return true;
                    }
                }
            }

            if (pattern[22] == 1) {
                if ((obstacle_3[1].position_x + obstacle_3[1].resized_width/4 -player.getX())*(obstacle_3[1].position_x + obstacle_3[1].resized_width/4 -player.getX()) < obstacle_3[1].resized_width/3*obstacle_3[1].resized_width/2) {
                    if ((obstacle_3[1].position_y + obstacle_3[1].resized_height/4 -player.getY())*(obstacle_3[1].position_y + obstacle_3[1].resized_height/4 -player.getY()) < obstacle_3[1].resized_height/3*obstacle_3[1].resized_height/2) {
                        return true;
                    }
                }
            }

            if (pattern[23] == 1) {
                if ((obstacle_3[2].position_x + obstacle_3[2].resized_width/4 -player.getX())*(obstacle_3[2].position_x + obstacle_3[2].resized_width/4 -player.getX()) < obstacle_3[2].resized_width/3*obstacle_3[2].resized_width/2) {
                    if ((obstacle_3[2].position_y + obstacle_3[2].resized_height/4 -player.getY())*(obstacle_3[2].position_y + obstacle_3[2].resized_height/4 -player.getY()) < obstacle_3[2].resized_height/3*obstacle_3[2].resized_height/2) {
                        return true;
                    }
                }
            }

            if (pattern[24] == 1) {
                if ((effect[8].position_x + effect[8].resized_width/4 -player.getX())*(effect[8].position_x + effect[8].resized_width/4 -player.getX()) < effect[8].resized_width/3*effect[8].resized_width/2) {
                    if ((effect[8].position_y + effect[8].resized_height/4 -player.getY())*(effect[8].position_y + effect[8].resized_height/4 -player.getY()) < effect[8].resized_height/3*effect[8].resized_height/2) {
                        return true;
                    }
                }
            }

            if (pattern[25] == 1) {
                if ((effect[9].position_x + effect[9].resized_width/4 -player.getX())*(effect[9].position_x + effect[9].resized_width/4 -player.getX()) < effect[9].resized_width/3*effect[9].resized_width/2) {
                    if ((effect[9].position_y + effect[9].resized_height/4 -player.getY())*(effect[9].position_y + effect[9].resized_height/4 -player.getY()) < effect[9].resized_height/3*effect[9].resized_height/2) {
                        return true;
                    }
                }
            }

            if (pattern[26] == 1) {
                if ((effect[10].position_x + effect[10].resized_width/4 -player.getX())*(effect[10].position_x + effect[10].resized_width/4 -player.getX()) < effect[10].resized_width/3*effect[10].resized_width/2) {
                    if ((effect[10].position_y + effect[10].resized_height/4 -player.getY())*(effect[10].position_y + effect[10].resized_height/4 -player.getY()) < effect[10].resized_height/3*effect[10].resized_height/2) {
                        return true;
                    }
                }
            }

            if (pattern[27] == 1) {
                if ((effect[11].position_x + effect[11].resized_width/4 -player.getX())*(effect[11].position_x + effect[11].resized_width/4 -player.getX()) < effect[11].resized_width/3*effect[11].resized_width/2) {
                    if ((effect[11].position_y + effect[11].resized_height/4 -player.getY())*(effect[11].position_y + effect[11].resized_height/4 -player.getY()) < effect[11].resized_height/3*effect[11].resized_height/2) {
                        return true;
                    }
                }
            }

            if (pattern[28] == 1) {
                if ((effect[12].position_x + effect[12].resized_width/4 -player.getX())*(effect[12].position_x + effect[12].resized_width/4 -player.getX()) < effect[12].resized_width/3*effect[12].resized_width/2) {
                    if ((effect[12].position_y + effect[12].resized_height/4 -player.getY())*(effect[12].position_y + effect[12].resized_height/4 -player.getY()) < effect[12].resized_height/3*effect[12].resized_height/2) {
                        return true;
                    }
                }
            }

            if (pattern[29] == 1) {
                if ((effect[13].position_x + effect[13].resized_width/4 -player.getX())*(effect[13].position_x + effect[13].resized_width/4 -player.getX()) < effect[13].resized_width/3*effect[13].resized_width/2) {
                    if ((effect[13].position_y + effect[13].resized_height/4 -player.getY())*(effect[13].position_y + effect[13].resized_height/4 -player.getY()) < effect[13].resized_height/3*effect[13].resized_height/2) {
                        return true;
                    }
                }
            }

            if (pattern[30] == 1) {
                if ((effect[14].position_x + effect[14].resized_width/4 -player.getX())*(effect[14].position_x + effect[14].resized_width/4 -player.getX()) < effect[14].resized_width/3*effect[14].resized_width/2) {
                    if ((effect[14].position_y + effect[14].resized_height/4 -player.getY())*(effect[14].position_y + effect[14].resized_height/4 -player.getY()) < effect[14].resized_height/3*effect[14].resized_height/2) {
                        return true;
                    }
                }
            }

            if (pattern[31] == 1) {
                if ((effect[15].position_x + effect[15].resized_width/4 -player.getX())*(effect[15].position_x + effect[15].resized_width/4 -player.getX()) < effect[15].resized_width/3*effect[15].resized_width/2) {
                    if ((effect[15].position_y + effect[15].resized_height/4 -player.getY())*(effect[15].position_y + effect[15].resized_height/4 -player.getY()) < effect[15].resized_height/3*effect[15].resized_height/2) {
                        return true;
                    }
                }
            }

        }else {

            for(int i=0; i<15; i++) {
                if (enemy_shot[i] == 1) {
                    if ((enemy_bullet[i].position_x + enemy_bullet[i].resized_width / 4 - player.getX()) * (enemy_bullet[i].position_x + enemy_bullet[i].resized_width / 4 - player.getX()) < enemy_bullet[i].resized_width / 2 * enemy_bullet[i].resized_width / 3) {
                        if ((enemy_bullet[i].position_y + enemy_bullet[i].resized_height / 4 - player.getY()) * (enemy_bullet[i].position_y + enemy_bullet[i].resized_height / 4 - player.getY()) < enemy_bullet[i].resized_height / 2 * enemy_bullet[i].resized_height / 3) {
                            enemy_bullet[i].position((int)enemy_center.getX(), (int)enemy_center.getY());
                            enemy_bullet[i].setObstacleAlpha(0);
                            enemy_bullet[i].position_effect();
                            enemy_shot[0] = 0;
                            return true;
                        }
                    }
                }
            }


            if (Math.abs(obstacle[0].position_x - tile[0].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[0].getX() - tile[0].getWidth() / 4) * (player.getX() - tile[0].getX() - tile[0].getWidth() / 4) < tile[0].getWidth() / 2 * tile[0].getWidth() / 3) {
                    if ((player.getY() - tile[0].getY() - tile[0].getHeight() / 4) * (player.getY() - tile[0].getY() - tile[0].getHeight() / 4) < tile[0].getHeight() / 2 * tile[0].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(obstacle[0].position_x - tile[8].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[8].getX() - tile[8].getWidth() / 4) * (player.getX() - tile[8].getX() - tile[8].getWidth() / 4) < tile[8].getWidth() / 2 * tile[8].getWidth() / 3) {
                    if ((player.getY() - tile[8].getY() - tile[8].getHeight() / 4) * (player.getY() - tile[8].getY() - tile[8].getHeight() / 4) < tile[8].getHeight() / 2 * tile[8].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            //////////////////////////////////////////////////////////////////////////////

            if (Math.abs(obstacle[1].position_x - tile[33].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[33].getX() - tile[33].getWidth() / 4) * (player.getX() - tile[33].getX() - tile[33].getWidth() / 4) < tile[33].getWidth() / 2 * tile[33].getWidth() / 3) {
                    if ((player.getY() - tile[33].getY() - tile[33].getHeight() / 4) * (player.getY() - tile[33].getY() - tile[33].getHeight() / 4) < tile[33].getHeight() / 2 * tile[33].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(obstacle[1].position_x - tile[43].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[43].getX() - tile[43].getWidth() / 4) * (player.getX() - tile[43].getX() - tile[43].getWidth() / 4) < tile[43].getWidth() / 2 * tile[43].getWidth() / 3) {
                    if ((player.getY() - tile[43].getY() - tile[43].getHeight() / 4) * (player.getY() - tile[43].getY() - tile[43].getHeight() / 4) < tile[43].getHeight() / 2 * tile[43].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            //////////////////////////////////////////////////////////////////////////////

            if (Math.abs(obstacle[2].position_x - tile[3].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[3].getX() - tile[3].getWidth() / 4) * (player.getX() - tile[3].getX() - tile[3].getWidth() / 4) < tile[3].getWidth() / 2 * tile[3].getWidth() / 3) {
                    if ((player.getY() - tile[3].getY() - tile[3].getHeight() / 4) * (player.getY() - tile[3].getY() - tile[3].getHeight() / 4) < tile[3].getHeight() / 2 * tile[3].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(obstacle[2].position_x - tile[47].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[47].getX() - tile[47].getWidth() / 4) * (player.getX() - tile[47].getX() - tile[47].getWidth() / 4) < tile[47].getWidth() / 2 * tile[47].getWidth() / 3) {
                    if ((player.getY() - tile[47].getY() - tile[47].getHeight() / 4) * (player.getY() - tile[47].getY() - tile[47].getHeight() / 4) < tile[47].getHeight() / 2 * tile[47].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            //////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(obstacle[3].position_x - tile[37].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[37].getX() - tile[37].getWidth() / 4) * (player.getX() - tile[37].getX() - tile[37].getWidth() / 4) < tile[37].getWidth() / 3 * tile[37].getWidth() / 2) {
                    if ((player.getY() - tile[37].getY() - tile[37].getHeight() / 4) * (player.getY() - tile[37].getY() - tile[37].getHeight() / 4) < tile[37].getHeight() / 2 * tile[37].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(obstacle[3].position_x - tile[51].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[51].getX() - tile[51].getWidth() / 4) * (player.getX() - tile[51].getX() - tile[51].getWidth() / 4) < tile[51].getWidth() / 2 * tile[51].getWidth() / 3) {
                    if ((player.getY() - tile[51].getY() - tile[51].getHeight() / 4) * (player.getY() - tile[51].getY() - tile[51].getHeight() / 4) < tile[51].getHeight() / 2 * tile[51].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            /////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(obstacle_1[0].position_x - tile[32].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[32].getX() - tile[32].getWidth() / 4) * (player.getX() - tile[32].getX() - tile[32].getWidth() / 4) < tile[32].getWidth() / 2 * tile[32].getWidth() / 3) {
                    if ((player.getY() - tile[32].getY() - tile[32].getHeight() / 4) * (player.getY() - tile[32].getY() - tile[32].getHeight() / 4) < tile[32].getHeight() / 2 * tile[32].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(obstacle_1[0].position_x - tile[42].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[42].getX() - tile[42].getWidth() / 4) * (player.getX() - tile[42].getX() - tile[42].getWidth() / 4) < tile[42].getWidth() / 2 * tile[42].getWidth() / 3) {
                    if ((player.getY() - tile[42].getY() - tile[42].getHeight() / 4) * (player.getY() - tile[42].getY() - tile[42].getHeight() / 4) < tile[42].getHeight() / 2 * tile[42].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            //////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(obstacle_1[1].position_x - tile[2].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[2].getX() - tile[2].getWidth() / 4) * (player.getX() - tile[2].getX() - tile[2].getWidth() / 4) < tile[2].getWidth() / 2 * tile[2].getWidth() / 3) {
                    if ((player.getY() - tile[2].getY() - tile[2].getHeight() / 4) * (player.getY() - tile[2].getY() - tile[2].getHeight() / 4) < tile[2].getHeight() / 2 * tile[2].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(obstacle_1[1].position_x - tile[14].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[14].getX() - tile[14].getWidth() / 4) * (player.getX() - tile[14].getX() - tile[14].getWidth() / 4) < tile[14].getWidth() / 2 * tile[14].getWidth() / 3) {
                    if ((player.getY() - tile[14].getY() - tile[14].getHeight() / 4) * (player.getY() - tile[14].getY() - tile[14].getHeight() / 4) < tile[14].getHeight() / 2 * tile[14].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            /////////////////////////////////////////////////////////////////////////////

            if (Math.abs(obstacle_1[2].position_x - tile[36].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[36].getX() - tile[36].getWidth() / 4) * (player.getX() - tile[36].getX() - tile[36].getWidth() / 4) < tile[36].getWidth() / 2 * tile[36].getWidth() / 3) {
                    if ((player.getY() - tile[36].getY() - tile[36].getHeight() / 4) * (player.getY() - tile[36].getY() - tile[36].getHeight() / 4) < tile[36].getHeight() / 2 * tile[36].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(obstacle_1[2].position_x - tile[50].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[50].getX() - tile[50].getWidth() / 4) * (player.getX() - tile[50].getX() - tile[50].getWidth() / 4) < tile[50].getWidth() / 2 * tile[50].getWidth() / 3) {
                    if ((player.getY() - tile[50].getY() - tile[50].getHeight() / 4) * (player.getY() - tile[50].getY() - tile[50].getHeight() / 4) < tile[50].getHeight() / 2 * tile[50].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            /////////////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(obstacle_1[3].position_x - tile[7].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[7].getX() - tile[7].getWidth() / 4) * (player.getX() - tile[7].getX() - tile[7].getWidth() / 4) < tile[7].getWidth() / 2 * tile[7].getWidth() / 3) {
                    if ((player.getY() - tile[7].getY() - tile[7].getHeight() / 4) * (player.getY() - tile[7].getY() - tile[7].getHeight() / 4) < tile[7].getHeight() / 2 * tile[7].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(obstacle_1[3].position_x - tile[22].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[22].getX() - tile[22].getWidth() / 4) * (player.getX() - tile[22].getX() - tile[22].getWidth() / 4) < tile[22].getWidth() / 2 * tile[22].getWidth() / 3) {
                    if ((player.getY() - tile[22].getY() - tile[22].getHeight() / 4) * (player.getY() - tile[22].getY() - tile[22].getHeight() / 4) < tile[22].getHeight() / 2 * tile[22].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            ///////////////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(obstacle_2[0].position_x - tile[1].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[1].getX() - tile[1].getWidth() / 4) * (player.getX() - tile[1].getX() - tile[1].getWidth() / 4) < tile[1].getWidth() / 2 * tile[1].getWidth() / 3) {
                    if ((player.getY() - tile[1].getY() - tile[1].getHeight() / 4) * (player.getY() - tile[1].getY() - tile[1].getHeight() / 4) < tile[1].getHeight() / 2 * tile[1].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(obstacle_2[0].position_x - tile[13].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[13].getX() - tile[13].getWidth() / 4) * (player.getX() - tile[13].getX() - tile[13].getWidth() / 4) < tile[13].getWidth() / 2 * tile[13].getWidth() / 3) {
                    if ((player.getY() - tile[13].getY() - tile[13].getHeight() / 4) * (player.getY() - tile[13].getY() - tile[13].getHeight() / 4) < tile[13].getHeight() / 2 * tile[13].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            /////////////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(obstacle_2[1].position_x - tile[35].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[35].getX() - tile[35].getWidth() / 4) * (player.getX() - tile[35].getX() - tile[35].getWidth() / 4) < tile[35].getWidth() / 2 * tile[35].getWidth() / 3) {
                    if ((player.getY() - tile[35].getY() - tile[35].getHeight() / 4) * (player.getY() - tile[35].getY() - tile[35].getHeight() / 4) < tile[35].getHeight() / 2 * tile[35].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(obstacle_2[1].position_x - tile[49].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[49].getX() - tile[49].getWidth() / 4) * (player.getX() - tile[49].getX() - tile[49].getWidth() / 4) < tile[49].getWidth() / 2 * tile[49].getWidth() / 3) {
                    if ((player.getY() - tile[49].getY() - tile[49].getHeight() / 4) * (player.getY() - tile[49].getY() - tile[49].getHeight() / 4) < tile[49].getHeight() / 2 * tile[49].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            ///////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(obstacle_2[2].position_x - tile[6].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[6].getX() - tile[6].getWidth() / 4) * (player.getX() - tile[6].getX() - tile[6].getWidth() / 4) < tile[6].getWidth() / 2 * tile[6].getWidth() / 3) {
                    if ((player.getY() - tile[6].getY() - tile[6].getHeight() / 4) * (player.getY() - tile[6].getY() - tile[6].getHeight() / 4) < tile[6].getHeight() / 2 * tile[6].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(obstacle_2[2].position_x - tile[21].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[21].getX() - tile[21].getWidth() / 4) * (player.getX() - tile[21].getX() - tile[21].getWidth() / 4) < tile[21].getWidth() / 2 * tile[21].getWidth() / 3) {
                    if ((player.getY() - tile[21].getY() - tile[21].getHeight() / 4) * (player.getY() - tile[21].getY() - tile[21].getHeight() / 4) < tile[21].getHeight() / 2 * tile[21].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            //////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(obstacle_2[3].position_x - tile[41].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[41].getX() - tile[41].getWidth() / 4) * (player.getX() - tile[41].getX() - tile[41].getWidth() / 4) < tile[41].getWidth() / 2 * tile[41].getWidth() / 3) {
                    if ((player.getY() - tile[41].getY() - tile[41].getHeight() / 4) * (player.getY() - tile[41].getY() - tile[41].getHeight() / 4) < tile[41].getHeight() / 2 * tile[41].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(obstacle_2[3].position_x - tile[57].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[57].getX() - tile[57].getWidth() / 4) * (player.getX() - tile[57].getX() - tile[57].getWidth() / 4) < tile[57].getWidth() / 2 * tile[57].getWidth() / 3) {
                    if ((player.getY() - tile[57].getY() - tile[57].getHeight() / 4) * (player.getY() - tile[57].getY() - tile[57].getHeight() / 4) < tile[57].getHeight() / 2 * tile[57].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            /////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(obstacle_3[0].position_x - tile[34].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[34].getX() - tile[34].getWidth() / 4) * (player.getX() - tile[34].getX() - tile[34].getWidth() / 4) < tile[34].getWidth() / 2 * tile[34].getWidth() / 3) {
                    if ((player.getY() - tile[34].getY() - tile[34].getHeight() / 4) * (player.getY() - tile[34].getY() - tile[34].getHeight() / 4) < tile[34].getHeight() / 2 * tile[34].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(obstacle_3[0].position_x - tile[48].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[48].getX() - tile[48].getWidth() / 4) * (player.getX() - tile[48].getX() - tile[48].getWidth() / 4) < tile[48].getWidth() / 2 * tile[48].getWidth() / 3) {
                    if ((player.getY() - tile[48].getY() - tile[48].getHeight() / 4) * (player.getY() - tile[48].getY() - tile[48].getHeight() / 4) < tile[48].getHeight() / 2 * tile[48].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            /////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(obstacle_3[1].position_x - tile[5].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[5].getX() - tile[5].getWidth() / 4) * (player.getX() - tile[5].getX() - tile[5].getWidth() / 4) < tile[5].getWidth() / 2 * tile[5].getWidth() / 3) {
                    if ((player.getY() - tile[5].getY() - tile[5].getHeight() / 4) * (player.getY() - tile[5].getY() - tile[5].getHeight() / 4) < tile[5].getHeight() / 2 * tile[5].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(obstacle_3[1].position_x - tile[20].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[20].getX() - tile[20].getWidth() / 4) * (player.getX() - tile[20].getX() - tile[20].getWidth() / 4) < tile[20].getWidth() / 2 * tile[20].getWidth() / 3) {
                    if ((player.getY() - tile[20].getY() - tile[20].getHeight() / 4) * (player.getY() - tile[20].getY() - tile[20].getHeight() / 4) < tile[20].getHeight() / 2 * tile[20].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            //////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(obstacle_3[2].position_x - tile[40].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[40].getX() - tile[40].getWidth() / 4) * (player.getX() - tile[40].getX() - tile[40].getWidth() / 4) < tile[40].getWidth() / 2 * tile[40].getWidth() / 3) {
                    if ((player.getY() - tile[40].getY() - tile[40].getHeight() / 4) * (player.getY() - tile[40].getY() - tile[40].getHeight() / 4) < tile[40].getHeight() / 2 * tile[40].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(obstacle_3[2].position_x - tile[56].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[56].getX() - tile[56].getWidth() / 4) * (player.getX() - tile[56].getX() - tile[56].getWidth() / 4) < tile[56].getWidth() / 2 * tile[56].getWidth() / 3) {
                    if ((player.getY() - tile[56].getY() - tile[56].getHeight() / 4) * (player.getY() - tile[56].getY() - tile[56].getHeight() / 4) < tile[56].getHeight() / 2 * tile[56].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            //////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(obstacle_3[3].position_x - tile[12].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[12].getX() - tile[12].getWidth() / 4) * (player.getX() - tile[12].getX() - tile[12].getWidth() / 4) < tile[12].getWidth() / 2 * tile[12].getWidth() / 3) {
                    if ((player.getY() - tile[12].getY() - tile[12].getHeight() / 4) * (player.getY() - tile[12].getY() - tile[12].getHeight() / 4) < tile[12].getHeight() / 2 * tile[12].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(obstacle_3[3].position_x - tile[27].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[27].getX() - tile[27].getWidth() / 4) * (player.getX() - tile[27].getX() - tile[27].getWidth() / 4) < tile[27].getWidth() / 2 * tile[27].getWidth() / 3) {
                    if ((player.getY() - tile[27].getY() - tile[27].getHeight() / 4) * (player.getY() - tile[27].getY() - tile[27].getHeight() / 4) < tile[27].getHeight() / 2 * tile[27].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            /////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(obstacle_4[0].position_x - tile[4].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[4].getX() - tile[4].getWidth() / 4) * (player.getX() - tile[4].getX() - tile[4].getWidth() / 4) < tile[4].getWidth() / 2 * tile[4].getWidth() / 3) {
                    if ((player.getY() - tile[4].getY()) * (player.getY() - tile[4].getY()) < 30 * 30) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(obstacle_4[0].position_x - tile[19].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[19].getX() - tile[19].getWidth() / 4) * (player.getX() - tile[19].getX() - tile[19].getWidth() / 4) < tile[19].getWidth() / 2 * tile[19].getWidth() / 3) {
                    if ((player.getY() - tile[19].getY() - tile[19].getHeight() / 4) * (player.getY() - tile[19].getY() - tile[19].getHeight() / 4) < tile[19].getHeight() / 2 * tile[19].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE)
                        return true;
                    }
                }
            }

            /////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(obstacle_4[1].position_x - tile[39].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[39].getX() - tile[39].getWidth() / 4) * (player.getX() - tile[39].getX() - tile[39].getWidth() / 4) < tile[39].getWidth() / 2 * tile[39].getWidth() / 3) {
                    if ((player.getY() - tile[39].getY() - tile[39].getHeight() / 4) * (player.getY() - tile[39].getY() - tile[39].getHeight() / 4) < tile[39].getHeight() / 2 * tile[39].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(obstacle_4[1].position_x - tile[55].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[55].getX() - tile[55].getWidth() / 4) * (player.getX() - tile[55].getX() - tile[55].getWidth() / 4) < tile[55].getWidth() / 2 * tile[55].getWidth() / 3) {
                    if ((player.getY() - tile[55].getY() - tile[55].getHeight() / 4) * (player.getY() - tile[55].getY() - tile[55].getHeight() / 4) < tile[55].getHeight() / 2 * tile[55].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            /////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(obstacle_4[2].position_x - tile[11].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[11].getX() - tile[11].getWidth() / 4) * (player.getX() - tile[11].getX() - tile[11].getWidth() / 4) < tile[11].getWidth() / 2 * tile[11].getWidth() / 3) {
                    if ((player.getY() - tile[11].getY() - tile[11].getHeight() / 4) * (player.getY() - tile[11].getY() - tile[11].getHeight() / 4) < tile[11].getHeight() / 2 * tile[11].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(obstacle_4[2].position_x - tile[26].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[26].getX() - tile[26].getWidth() / 4) * (player.getX() - tile[26].getX() - tile[26].getWidth() / 4) < tile[26].getWidth() / 2 * tile[26].getWidth() / 3) {
                    if ((player.getY() - tile[26].getY() - tile[26].getHeight() / 4) * (player.getY() - tile[26].getY() - tile[26].getHeight() / 4) < tile[26].getHeight() / 2 * tile[26].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            //////////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(obstacle_4[3].position_x - tile[47].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[47].getX() - tile[47].getWidth() / 4) * (player.getX() - tile[47].getX() - tile[47].getWidth() / 4) < tile[47].getWidth() / 2 * tile[47].getWidth() / 3) {
                    if ((player.getY() - tile[47].getY() - tile[47].getHeight() / 4) * (player.getY() - tile[47].getY() - tile[47].getHeight() / 4) < tile[47].getHeight() / 2 * tile[47].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(obstacle_4[3].position_x - tile[61].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[61].getX() - tile[61].getWidth() / 4) * (player.getX() - tile[61].getX() - tile[61].getWidth() / 4) < tile[61].getWidth() / 2 * tile[61].getWidth() / 3) {
                    if ((player.getY() - tile[61].getY() - tile[61].getHeight() / 4) * (player.getY() - tile[61].getY() - tile[61].getHeight() / 4) < tile[61].getHeight() / 2 * tile[61].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            //////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(obstacle_5[0].position_x - tile[38].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[38].getX() - tile[38].getWidth() / 4) * (player.getX() - tile[38].getX() - tile[38].getWidth() / 4) < tile[38].getWidth() / 2 * tile[38].getWidth() / 3) {
                    if ((player.getY() - tile[38].getY() - tile[38].getHeight() / 4) * (player.getY() - tile[38].getY() - tile[38].getHeight() / 4) < tile[38].getHeight() / 2 * tile[38].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(obstacle_5[0].position_x - tile[54].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[54].getX() - tile[54].getWidth() / 4) * (player.getX() - tile[54].getX() - tile[54].getWidth() / 4) < tile[54].getWidth() / 2 * tile[54].getWidth() / 3) {
                    if ((player.getY() - tile[54].getY() - tile[54].getHeight() / 4) * (player.getY() - tile[54].getY() - tile[54].getHeight() / 4) < tile[54].getHeight() / 2 * tile[54].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            //////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(obstacle_5[1].position_x - tile[10].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[10].getX() - tile[10].getWidth() / 4) * (player.getX() - tile[10].getX() - tile[10].getWidth() / 4) < tile[10].getWidth() / 2 * tile[10].getWidth() / 3) {
                    if ((player.getY() - tile[10].getY() - tile[10].getHeight() / 4) * (player.getY() - tile[10].getY() - tile[10].getHeight() / 4) < tile[10].getHeight() / 2 * tile[10].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(obstacle_5[1].position_x - tile[25].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[25].getX() - tile[25].getWidth() / 4) * (player.getX() - tile[25].getX() - tile[25].getWidth() / 4) < tile[25].getWidth() / 2 * tile[25].getWidth() / 3) {
                    if ((player.getY() - tile[25].getY() - tile[25].getHeight() / 4) * (player.getY() - tile[25].getY() - tile[25].getHeight() / 4) < tile[25].getHeight() / 2 * tile[25].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            ////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(obstacle_5[2].position_x - tile[46].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[46].getX() - tile[46].getWidth() / 4) * (player.getX() - tile[46].getX() - tile[46].getWidth() / 4) < tile[46].getWidth() / 2 * tile[46].getWidth() / 3) {
                    if ((player.getY() - tile[46].getY() - tile[46].getHeight() / 4) * (player.getY() - tile[46].getY() - tile[46].getHeight() / 4) < tile[46].getHeight() / 2 * tile[46].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(obstacle_5[2].position_x - tile[60].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[60].getX() - tile[60].getWidth() / 4) * (player.getX() - tile[60].getX() - tile[60].getWidth() / 4) < tile[60].getWidth() / 2 * tile[60].getWidth() / 3) {
                    if ((player.getY() - tile[60].getY() - tile[60].getHeight() / 4) * (player.getY() - tile[60].getY() - tile[60].getHeight() / 4) < tile[60].getHeight() / 2 * tile[60].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            ///////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(obstacle_5[3].position_x - tile[18].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[18].getX() - tile[18].getWidth() / 4) * (player.getX() - tile[18].getX() - tile[18].getWidth() / 4) < tile[18].getWidth() / 2 * tile[18].getWidth() / 3) {
                    if ((player.getY() - tile[18].getY() - tile[18].getHeight() / 4) * (player.getY() - tile[18].getY() - tile[18].getHeight() / 4) < tile[18].getHeight() / 2 * tile[18].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(obstacle_5[3].position_x - tile[30].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[30].getX() - tile[30].getWidth() / 4) * (player.getX() - tile[30].getX() - tile[30].getWidth() / 4) < tile[30].getWidth() / 2 * tile[30].getWidth() / 3) {
                    if ((player.getY() - tile[30].getY() - tile[30].getHeight() / 4) * (player.getY() - tile[30].getY() - tile[30].getHeight() / 4) < tile[30].getHeight() / 2 * tile[30].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            //////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(obstacle_6[0].position_x - tile[9].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[9].getX() - tile[9].getWidth() / 4) * (player.getX() - tile[9].getX() - tile[9].getWidth() / 4) < tile[9].getWidth() / 2 * tile[9].getWidth() / 3) {
                    if ((player.getY() - tile[9].getY() - tile[9].getHeight() / 4) * (player.getY() - tile[9].getY() - tile[9].getHeight() / 4) < tile[9].getHeight() / 2 * tile[9].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(obstacle_6[0].position_x - tile[24].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[24].getX() - tile[24].getWidth() / 4) * (player.getX() - tile[24].getX() - tile[24].getWidth() / 4) < tile[24].getWidth() / 2 * tile[24].getWidth() / 3) {
                    if ((player.getY() - tile[24].getY() - tile[24].getHeight() / 4) * (player.getY() - tile[24].getY() - tile[24].getHeight() / 4) < tile[24].getHeight() / 2 * tile[24].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            //////////////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(obstacle_6[1].position_x - tile[45].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[45].getX() - tile[45].getWidth() / 4) * (player.getX() - tile[45].getX() - tile[45].getWidth() / 4) < tile[45].getWidth() / 2 * tile[45].getWidth() / 3) {
                    if ((player.getY() - tile[45].getY() - tile[45].getHeight() / 4) * (player.getY() - tile[45].getY() - tile[45].getHeight() / 4) < tile[45].getHeight() / 2 * tile[45].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(obstacle_6[1].position_x - tile[59].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[59].getX() - tile[59].getWidth() / 4) * (player.getX() - tile[59].getX() - tile[59].getWidth() / 4) < tile[59].getWidth() / 2 * tile[59].getWidth() / 3) {
                    if ((player.getY() - tile[59].getY() - tile[59].getHeight() / 4) * (player.getY() - tile[59].getY() - tile[59].getHeight() / 4) < tile[59].getHeight() / 2 * tile[59].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            ////////////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(obstacle_6[2].position_x - tile[17].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[17].getX() - tile[17].getWidth() / 4) * (player.getX() - tile[17].getX() - tile[17].getWidth() / 4) < tile[17].getWidth() / 2 * tile[17].getWidth() / 3) {
                    if ((player.getY() - tile[17].getY() - tile[17].getHeight() / 4) * (player.getY() - tile[17].getY() - tile[17].getHeight() / 4) < tile[17].getHeight() / 2 * tile[17].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(obstacle_6[2].position_x - tile[29].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[29].getX() - tile[29].getWidth() / 4) * (player.getX() - tile[29].getX() - tile[29].getWidth() / 4) < tile[29].getWidth() / 2 * tile[29].getWidth() / 3) {
                    if ((player.getY() - tile[29].getY() - tile[29].getHeight() / 4) * (player.getY() - tile[29].getY() - tile[29].getHeight() / 4) < tile[29].getHeight() / 2 * tile[29].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            //////////////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(obstacle_6[3].position_x - tile[53].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[53].getX() - tile[53].getWidth() / 4) * (player.getX() - tile[53].getX() - tile[53].getWidth() / 4) < tile[53].getWidth() / 2 * tile[53].getWidth() / 3) {
                    if ((player.getY() - tile[53].getY() - tile[53].getHeight() / 4) * (player.getY() - tile[53].getY() - tile[53].getHeight() / 4) < tile[53].getHeight() / 2 * tile[53].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(obstacle_6[3].position_x - tile[63].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[63].getX() - tile[63].getWidth() / 4) * (player.getX() - tile[63].getX() - tile[63].getWidth() / 4) < tile[63].getWidth() / 2 * tile[63].getWidth() / 3) {
                    if ((player.getY() - tile[63].getY() - tile[63].getHeight() / 4) * (player.getY() - tile[63].getY() - tile[63].getHeight() / 4) < tile[63].getHeight() / 2 * tile[63].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            /////////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(obstacle_7[0].position_x - tile[44].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[44].getX() - tile[44].getWidth() / 4) * (player.getX() - tile[44].getX() - tile[44].getWidth() / 4) < tile[44].getWidth() / 2 * tile[44].getWidth() / 3) {
                    if ((player.getY() - tile[44].getY() - tile[44].getHeight() / 4) * (player.getY() - tile[44].getY() - tile[44].getHeight() / 4) < tile[44].getHeight() / 2 * tile[44].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(obstacle_7[0].position_x - tile[58].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[58].getX() - tile[58].getWidth() / 4) * (player.getX() - tile[58].getX() - tile[58].getWidth() / 4) < tile[58].getWidth() / 2 * tile[58].getWidth() / 3) {
                    if ((player.getY() - tile[58].getY() - tile[58].getHeight() / 4) * (player.getY() - tile[58].getY() - tile[58].getHeight() / 4) < tile[58].getHeight() / 2 * tile[58].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            ////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(obstacle_7[1].position_x - tile[16].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[16].getX() - tile[16].getWidth() / 4) * (player.getX() - tile[16].getX() - tile[16].getWidth() / 4) < tile[16].getWidth() / 2 * tile[16].getWidth() / 3) {
                    if ((player.getY() - tile[16].getY() - tile[16].getHeight() / 4) * (player.getY() - tile[16].getY() - tile[16].getHeight() / 4) < tile[16].getHeight() / 2 * tile[16].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(obstacle_7[1].position_x - tile[28].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[28].getX() - tile[28].getWidth() / 4) * (player.getX() - tile[28].getX() - tile[28].getWidth() / 4) < tile[28].getWidth() / 2 * tile[28].getWidth() / 3) {
                    if ((player.getY() - tile[28].getY() - tile[28].getHeight() / 4) * (player.getY() - tile[28].getY() - tile[28].getHeight() / 4) < tile[28].getHeight() / 2 * tile[28].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            //////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(obstacle_7[2].position_x - tile[51].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[51].getX() - tile[51].getWidth() / 4) * (player.getX() - tile[51].getX() - tile[51].getWidth() / 4) < tile[51].getWidth() / 2 * tile[51].getWidth() / 3) {
                    if ((player.getY() - tile[51].getY() - tile[51].getHeight() / 4) * (player.getY() - tile[51].getY() - tile[51].getHeight() / 4) < tile[51].getHeight() / 2 * tile[51].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(obstacle_7[2].position_x - tile[62].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[62].getX() - tile[62].getWidth() / 4) * (player.getX() - tile[62].getX() - tile[62].getWidth() / 4) < tile[62].getWidth() / 2 * tile[62].getWidth() / 3) {
                    if ((player.getY() - tile[62].getY() - tile[62].getHeight() / 4) * (player.getY() - tile[62].getY() - tile[62].getHeight() / 4) < tile[62].getHeight() / 2 * tile[62].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            ////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(obstacle_7[3].position_x - tile[23].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[23].getX() - tile[23].getWidth() / 4) * (player.getX() - tile[23].getX() - tile[23].getWidth() / 4) < tile[23].getWidth() / 2 * tile[23].getWidth() / 3) {
                    if ((player.getY() - tile[23].getY() - tile[23].getHeight() / 4) * (player.getY() - tile[23].getY() - tile[23].getHeight() / 4) < tile[23].getHeight() / 2 * tile[23].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(obstacle_7[3].position_x - tile[31].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[31].getX() - tile[31].getWidth() / 4) * (player.getX() - tile[31].getX() - tile[31].getWidth() / 4) < tile[31].getWidth() / 2 * tile[31].getWidth() / 3) {
                    if ((player.getY() - tile[31].getY() - tile[31].getHeight() / 4) * (player.getY() - tile[31].getY() - tile[31].getHeight() / 4) < tile[31].getHeight() / 2 * tile[31].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            ////////////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(r_obstacle[0].position_x - tile[0].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[0].getX() - tile[0].getWidth() / 4) * (player.getX() - tile[0].getX() - tile[0].getWidth() / 4) < tile[0].getWidth() / 2 * tile[0].getWidth() / 3) {
                    if ((player.getY() - tile[0].getY() - tile[0].getHeight() / 4) * (player.getY() - tile[0].getY() - tile[0].getHeight() / 4) < tile[0].getHeight() / 2 * tile[0].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(r_obstacle[0].position_x - tile[4].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[4].getX() - tile[4].getWidth() / 4) * (player.getX() - tile[4].getX() - tile[4].getWidth() / 4) < tile[4].getWidth() / 2 * tile[4].getWidth() / 3) {
                    if ((player.getY() - tile[4].getY() - tile[4].getHeight() / 4) * (player.getY() - tile[4].getY() - tile[4].getHeight() / 4) < tile[4].getHeight() / 3 * tile[4].getHeight() / 2) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            //////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(r_obstacle[1].position_x - tile[32].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[32].getX() - tile[32].getWidth() / 4) * (player.getX() - tile[32].getX() - tile[32].getWidth() / 4) < tile[32].getWidth() / 2 * tile[32].getWidth() / 3) {
                    if ((player.getY() - tile[32].getY() - tile[32].getHeight() / 4) * (player.getY() - tile[32].getY() - tile[32].getHeight() / 4) < tile[32].getHeight() / 2 * tile[32].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(r_obstacle[1].position_x - tile[38].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[38].getX() - tile[38].getWidth() / 4) * (player.getX() - tile[38].getX() - 10) < tile[38].getWidth() / 2 * tile[38].getWidth() / 3) {
                    if ((player.getY() - tile[38].getY() - tile[38].getHeight() / 4) * (player.getY() - tile[38].getY() - tile[38].getHeight() / 4) < tile[38].getHeight() / 2 * tile[38].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            /////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(r_obstacle[2].position_x - tile[1].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[1].getX() - tile[1].getWidth() / 4) * (player.getX() - tile[1].getX() - tile[1].getWidth() / 4) < tile[1].getWidth() / 2 * tile[1].getWidth() / 3) {
                    if ((player.getY() - tile[1].getY() - tile[1].getHeight() / 4) * (player.getY() - tile[1].getY() - tile[1].getHeight() / 4) < tile[1].getHeight() / 2 * tile[1].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(r_obstacle[2].position_x - tile[9].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[9].getX() - tile[9].getWidth() / 4) * (player.getX() - tile[9].getX() - tile[9].getWidth() / 4) < tile[9].getWidth() / 2 * tile[9].getWidth() / 3) {
                    if ((player.getY() - tile[9].getY() - tile[9].getHeight() / 4) * (player.getY() - tile[9].getY() - tile[9].getHeight() / 4) < tile[9].getHeight() / 2 * tile[9].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            ///////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(r_obstacle[3].position_x - tile[34].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[34].getX() - tile[34].getWidth() / 4) * (player.getX() - tile[34].getX() - tile[34].getWidth() / 4) < tile[34].getWidth() / 2 * tile[34].getWidth() / 3) {
                    if ((player.getY() - tile[34].getY() - tile[34].getHeight() / 4) * (player.getY() - tile[34].getY() - tile[34].getHeight() / 4) < tile[34].getHeight() / 2 * tile[34].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(r_obstacle[3].position_x - tile[44].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[44].getX() - tile[44].getWidth() / 4) * (player.getX() - tile[44].getX() - tile[44].getWidth() / 4) < tile[44].getWidth() / 2 * tile[44].getWidth() / 3) {
                    if ((player.getY() - tile[44].getY() - tile[44].getHeight() / 4) * (player.getY() - tile[44].getY() - tile[44].getHeight() / 4) < tile[44].getHeight() / 2 * tile[44].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            //////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(r_obstacle_1[0].position_x - tile[33].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[33].getX() - tile[33].getWidth() / 4) * (player.getX() - tile[33].getX() - tile[33].getWidth() / 4) < tile[33].getWidth() / 2 * tile[33].getWidth() / 3) {
                    if ((player.getY() - tile[33].getY() - tile[33].getHeight() / 4) * (player.getY() - tile[33].getY() - tile[33].getHeight() / 4) < tile[33].getHeight() / 2 * tile[33].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(r_obstacle_1[0].position_x - tile[39].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[39].getX() - tile[39].getWidth() / 4) * (player.getX() - tile[39].getX() - tile[39].getWidth() / 4) < tile[39].getWidth() / 2 * tile[39].getWidth() / 3) {
                    if ((player.getY() - tile[39].getY() - tile[39].getHeight() / 4) * (player.getY() - tile[39].getY() - tile[39].getHeight() / 4) < tile[39].getHeight() / 2 * tile[39].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            ////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(r_obstacle_1[1].position_x - tile[2].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[2].getX() - tile[2].getWidth() / 4) * (player.getX() - tile[2].getX() - tile[2].getWidth() / 4) < tile[2].getWidth() / 2 * tile[2].getWidth() / 3) {
                    if ((player.getY() - tile[2].getY() - tile[2].getHeight() / 4) * (player.getY() - tile[2].getY() - tile[2].getHeight() / 4) < tile[2].getHeight() / 2 * tile[2].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(r_obstacle_1[1].position_x - tile[10].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[10].getX() - tile[10].getWidth() / 4) * (player.getX() - tile[10].getX() - tile[10].getWidth() / 4) < tile[10].getWidth() / 2 * tile[10].getWidth() / 3) {
                    if ((player.getY() - tile[10].getY() - tile[10].getHeight() / 4) * (player.getY() - tile[10].getY() - tile[10].getHeight() / 4) < tile[10].getHeight() / 2 * tile[10].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            ///////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(r_obstacle_1[2].position_x - tile[35].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[35].getX() - tile[35].getWidth() / 4) * (player.getX() - tile[35].getX() - tile[35].getWidth() / 4) < tile[35].getWidth() / 2 * tile[35].getWidth() / 3) {
                    if ((player.getY() - tile[35].getY() - tile[35].getHeight() / 4) * (player.getY() - tile[35].getY() - tile[35].getHeight() / 4) < tile[35].getHeight() / 2 * tile[35].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(r_obstacle_1[2].position_x - tile[45].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[45].getX() - tile[45].getWidth() / 4) * (player.getX() - tile[45].getX() - tile[45].getWidth() / 4) < tile[45].getWidth() / 2 * tile[45].getWidth() / 3) {
                    if ((player.getY() - tile[45].getY() - tile[45].getHeight() / 4) * (player.getY() - tile[45].getY() - tile[45].getHeight() / 4) < tile[45].getHeight() / 2 * tile[45].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            /////////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(r_obstacle_1[3].position_x - tile[5].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[5].getX() - tile[5].getWidth() / 4) * (player.getX() - tile[5].getX() - tile[5].getWidth() / 4) < tile[5].getWidth() / 2 * tile[5].getWidth() / 3) {
                    if ((player.getY() - tile[5].getY() - tile[5].getHeight() / 4) * (player.getY() - tile[5].getY() - tile[5].getHeight() / 4) < tile[5].getHeight() / 2 * tile[5].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(r_obstacle_1[3].position_x - tile[16].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[16].getX() - tile[16].getWidth() / 4) * (player.getX() - tile[16].getX() - tile[16].getWidth() / 4) < tile[16].getWidth() / 2 * tile[16].getWidth() / 3) {
                    if ((player.getY() - tile[16].getY() - tile[16].getHeight() / 4) * (player.getY() - tile[16].getY() - tile[16].getHeight() / 4) < tile[16].getHeight() / 2 * tile[16].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            //////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(r_obstacle_2[0].position_x - tile[3].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[3].getX() - tile[3].getWidth() / 4) * (player.getX() - tile[3].getX() - tile[3].getWidth() / 4) < tile[3].getWidth() / 2 * tile[3].getWidth() / 3) {
                    if ((player.getY() - tile[3].getY() - tile[3].getHeight() / 4) * (player.getY() - tile[3].getY() - tile[3].getHeight() / 4) < tile[3].getHeight() / 2 * tile[3].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(r_obstacle_2[0].position_x - tile[11].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[11].getX() - tile[11].getWidth() / 4) * (player.getX() - tile[11].getX() - tile[11].getWidth() / 4) < tile[11].getWidth() / 2 * tile[11].getWidth() / 3) {
                    if ((player.getY() - tile[11].getY() - tile[11].getHeight() / 4) * (player.getY() - tile[11].getY() - tile[11].getHeight() / 4) < tile[11].getHeight() / 2 * tile[11].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            /////////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(r_obstacle_2[1].position_x - tile[36].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[36].getX() - tile[36].getWidth() / 4) * (player.getX() - tile[36].getX() - tile[36].getWidth() / 4) < tile[36].getWidth() / 2 * tile[36].getWidth() / 3) {
                    if ((player.getY() - tile[36].getY() - tile[36].getHeight() / 4) * (player.getY() - tile[36].getY() - tile[36].getHeight() / 4) < tile[36].getHeight() / 2 * tile[36].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(r_obstacle_2[1].position_x - tile[46].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[46].getX() - tile[46].getWidth() / 4) * (player.getX() - tile[46].getX() - tile[46].getWidth() / 4) < tile[46].getWidth() / 2 * tile[46].getWidth() / 3) {
                    if ((player.getY() - tile[46].getY() - tile[46].getHeight() / 4) * (player.getY() - tile[46].getY() - tile[46].getHeight() / 4) < tile[46].getHeight() / 2 * tile[46].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            //////////////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(r_obstacle_2[2].position_x - tile[6].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[6].getX() - tile[6].getWidth() / 4) * (player.getX() - tile[6].getX() - tile[6].getWidth() / 4) < tile[6].getWidth() / 2 * tile[6].getWidth() / 3) {
                    if ((player.getY() - tile[6].getY() - tile[6].getHeight() / 4) * (player.getY() - tile[6].getY() - tile[6].getHeight() / 4) < tile[6].getHeight() / 2 * tile[6].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(r_obstacle_2[2].position_x - tile[17].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[17].getX() - tile[17].getWidth() / 4) * (player.getX() - tile[17].getX() - tile[17].getWidth() / 4) < tile[17].getWidth() / 2 * tile[17].getWidth() / 3) {
                    if ((player.getY() - tile[17].getY() - tile[17].getHeight() / 4) * (player.getY() - tile[17].getY() - tile[17].getHeight() / 4) < tile[17].getHeight() / 2 * tile[17].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            ////////////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(r_obstacle_2[3].position_x - tile[40].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[40].getX() - tile[40].getWidth() / 4) * (player.getX() - tile[40].getX() - tile[40].getWidth() / 4) < tile[40].getWidth() / 2 * tile[40].getWidth() / 3) {
                    if ((player.getY() - tile[40].getY() - tile[40].getHeight() / 4) * (player.getY() - tile[40].getY() - tile[40].getHeight() / 4) < tile[40].getHeight() / 2 * tile[40].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(r_obstacle_2[3].position_x - tile[17].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[52].getX() - tile[52].getWidth() / 4) * (player.getX() - tile[52].getX() - tile[52].getWidth() / 4) < tile[52].getWidth() / 2 * tile[52].getWidth() / 3) {
                    if ((player.getY() - tile[52].getY() - tile[52].getHeight() / 4) * (player.getY() - tile[52].getY() - tile[52].getHeight() / 4) < tile[52].getHeight() / 2 * tile[52].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            ///////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(r_obstacle_3[0].position_x - tile[37].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[37].getX() - tile[37].getWidth() / 4) * (player.getX() - tile[37].getX() - tile[37].getWidth() / 4) < tile[37].getWidth() / 2 * tile[37].getWidth() / 3) {
                    if ((player.getY() - tile[37].getY() - tile[37].getHeight() / 4) * (player.getY() - tile[37].getY() - tile[37].getHeight() / 4) < tile[37].getHeight() / 2 * tile[37].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(r_obstacle_3[0].position_x - tile[47].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[47].getX() - tile[47].getWidth() / 4) * (player.getX() - tile[47].getX() - tile[47].getWidth() / 4) < tile[47].getWidth() / 2 * tile[47].getWidth() / 3) {
                    if ((player.getY() - tile[47].getY() - tile[47].getHeight() / 4) * (player.getY() - tile[47].getY() - tile[47].getHeight() / 4) < tile[47].getHeight() / 2 * tile[47].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            ////////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(r_obstacle_3[1].position_x - tile[7].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[7].getX() - tile[7].getWidth() / 4) * (player.getX() - tile[7].getX() - tile[7].getWidth() / 4) < tile[7].getWidth() / 2 * tile[7].getWidth() / 3) {
                    if ((player.getY() - tile[7].getY() - tile[7].getHeight() / 4) * (player.getY() - tile[7].getY() - tile[7].getHeight() / 4) < tile[7].getHeight() / 2 * tile[7].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(r_obstacle_3[1].position_x - tile[18].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[18].getX() - tile[18].getWidth() / 4) * (player.getX() - tile[18].getX() - tile[18].getWidth() / 4) < tile[18].getWidth() / 2 * tile[18].getWidth() / 3) {
                    if ((player.getY() - tile[18].getY() - tile[18].getHeight() / 4) * (player.getY() - tile[18].getY() - tile[18].getHeight() / 4) < tile[18].getHeight() / 2 * tile[18].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            //////////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(r_obstacle_3[2].position_x - tile[41].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[41].getX() - tile[41].getWidth() / 4) * (player.getX() - tile[41].getX() - tile[41].getWidth() / 4) < tile[41].getWidth() / 2 * tile[41].getWidth() / 3) {
                    if ((player.getY() - tile[41].getY() - tile[41].getHeight() / 4) * (player.getY() - tile[41].getY() - tile[41].getHeight() / 4) < tile[41].getHeight() / 3 * tile[41].getHeight() / 2) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(r_obstacle_3[2].position_x - tile[53].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[53].getX() - tile[53].getWidth() / 4) * (player.getX() - tile[53].getX() - tile[53].getWidth() / 4) < tile[53].getWidth() / 2 * tile[53].getWidth() / 3) {
                    if ((player.getY() - tile[53].getY() - tile[53].getHeight() / 4) * (player.getY() - tile[53].getY() - tile[53].getHeight() / 4) < tile[53].getHeight() / 2 * tile[53].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            ///////////////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(r_obstacle_3[3].position_x - tile[12].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[12].getX() - tile[12].getWidth() / 4) * (player.getX() - tile[12].getX() - tile[12].getWidth() / 4) < tile[12].getWidth() / 2 * tile[12].getWidth() / 3) {
                    if ((player.getY() - tile[12].getY() - tile[12].getHeight() / 4) * (player.getY() - tile[12].getY() - tile[12].getHeight() / 4) < tile[12].getHeight() / 2 * tile[12].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(r_obstacle_3[3].position_x - tile[23].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[23].getX() - tile[23].getWidth() / 4) * (player.getX() - tile[23].getX() - tile[23].getWidth() / 4) < tile[23].getWidth() / 2 * tile[23].getWidth() / 3) {
                    if ((player.getY() - tile[23].getY() - tile[23].getHeight() / 4) * (player.getY() - tile[23].getY() - tile[23].getHeight() / 4) < tile[23].getHeight() / 2 * tile[23].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            ////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(r_obstacle_4[0].position_x - tile[8].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[8].getX() - tile[8].getWidth() / 4) * (player.getX() - tile[8].getX() - tile[8].getWidth() / 4) < tile[8].getWidth() / 2 * tile[8].getWidth() / 3) {
                    if ((player.getY() - tile[8].getY() - tile[8].getHeight() / 4) * (player.getY() - tile[8].getY() - tile[8].getHeight() / 4) < tile[8].getHeight() / 2 * tile[8].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(r_obstacle_4[0].position_x - tile[19].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[19].getX() - tile[19].getWidth() / 4) * (player.getX() - tile[19].getX() - tile[19].getWidth() / 4) < tile[19].getWidth() / 2 * tile[19].getWidth() / 3) {
                    if ((player.getY() - tile[19].getY() - tile[19].getHeight() / 4) * (player.getY() - tile[19].getY() - tile[19].getHeight() / 4) < tile[19].getHeight() / 2 * tile[19].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            /////////////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(r_obstacle_4[1].position_x - tile[41].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[41].getX() - tile[41].getWidth() / 4) * (player.getX() - tile[41].getX() - tile[41].getWidth() / 4) < tile[41].getWidth() / 2 * tile[41].getWidth() / 3) {
                    if ((player.getY() - tile[41].getY() - tile[41].getHeight() / 4) * (player.getY() - tile[41].getY() - tile[41].getHeight() / 4) < tile[41].getHeight() / 2 * tile[41].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(r_obstacle_4[1].position_x - tile[54].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[54].getX() - tile[54].getWidth() / 4) * (player.getX() - tile[54].getX() - tile[54].getWidth() / 4) < tile[54].getWidth() / 2 * tile[54].getWidth() / 3) {
                    if ((player.getY() - tile[54].getY() - tile[54].getHeight() / 4) * (player.getY() - tile[54].getY() - tile[54].getHeight() / 4) < tile[54].getHeight() / 2 * tile[54].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            /////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(r_obstacle_4[2].position_x - tile[13].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[13].getX() - tile[13].getWidth() / 4) * (player.getX() - tile[13].getX() - tile[13].getWidth() / 4) < tile[13].getWidth() / 2 * tile[13].getWidth() / 3) {
                    if ((player.getY() - tile[13].getY() - tile[13].getHeight() / 4) * (player.getY() - tile[13].getY() - tile[13].getHeight() / 4) < tile[13].getHeight() / 2 * tile[13].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(r_obstacle_4[2].position_x - tile[19].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[19].getX() - tile[19].getWidth() / 4) * (player.getX() - tile[19].getX() - tile[19].getWidth() / 4) < tile[19].getWidth() / 2 * tile[19].getWidth() / 3) {
                    if ((player.getY() - tile[19].getY() - tile[19].getHeight() / 4) * (player.getY() - tile[19].getY() - tile[19].getHeight() / 4) < tile[19].getHeight() / 2 * tile[19].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            //////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(r_obstacle_4[3].position_x - tile[48].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[48].getX() - tile[48].getWidth() / 4) * (player.getX() - tile[48].getX() - tile[48].getWidth() / 4) < tile[48].getWidth() / 2 * tile[48].getWidth() / 3) {
                    if ((player.getY() - tile[48].getY() - tile[48].getHeight() / 4) * (player.getY() - tile[48].getY() - tile[48].getHeight() / 4) < tile[48].getHeight() / 2 * tile[48].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(r_obstacle_4[3].position_x - tile[58].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[58].getX() - tile[58].getWidth() / 4) * (player.getX() - tile[58].getX() - tile[58].getWidth() / 4) < tile[58].getWidth() / 2 * tile[58].getWidth() / 3) {
                    if ((player.getY() - tile[58].getY() - tile[58].getHeight() / 4) * (player.getY() - tile[58].getY() - tile[58].getHeight() / 4) < tile[58].getHeight() / 2 * tile[58].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            ///////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(r_obstacle_5[0].position_x - tile[43].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[43].getX() - tile[43].getWidth() / 4) * (player.getX() - tile[43].getX() - tile[43].getWidth() / 4) < tile[43].getWidth() / 2 * tile[43].getWidth() / 3) {
                    if ((player.getY() - tile[43].getY() - tile[43].getHeight() / 4) * (player.getY() - tile[43].getY() - tile[43].getHeight() / 4) < tile[43].getHeight() / 2 * tile[43].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(r_obstacle_5[0].position_x - tile[55].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[55].getX() - tile[55].getWidth() / 4) * (player.getX() - tile[55].getX() - tile[55].getWidth() / 4) < tile[55].getWidth() / 2 * tile[55].getWidth() / 3) {
                    if ((player.getY() - tile[55].getY() - tile[55].getHeight() / 4) * (player.getY() - tile[55].getY() - tile[55].getHeight() / 4) < tile[55].getHeight() / 2 * tile[55].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            ///////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(r_obstacle_5[1].position_x - tile[14].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[14].getX() - tile[14].getWidth() / 4) * (player.getX() - tile[14].getX() - tile[14].getWidth() / 4) < tile[14].getWidth() / 2 * tile[14].getWidth() / 3) {
                    if ((player.getY() - tile[14].getY() - tile[14].getHeight() / 4) * (player.getY() - tile[14].getY() - tile[14].getHeight() / 4) < tile[14].getHeight() / 2 * tile[14].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(r_obstacle_5[1].position_x - tile[25].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[25].getX() - tile[25].getWidth() / 4) * (player.getX() - tile[25].getX() - tile[25].getWidth() / 4) < tile[25].getWidth() / 2 * tile[25].getWidth() / 3) {
                    if ((player.getY() - tile[25].getY() - tile[25].getHeight() / 4) * (player.getY() - tile[25].getY() - tile[25].getHeight() / 4) < tile[25].getHeight() / 2 * tile[25].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            ////////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(r_obstacle_5[2].position_x - tile[49].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[49].getX() - tile[49].getWidth() / 4) * (player.getX() - tile[49].getX() - tile[49].getWidth() / 4) < tile[49].getWidth() / 3 * tile[49].getWidth() / 3) {
                    if ((player.getY() - tile[49].getY() - tile[49].getHeight() / 4) * (player.getY() - tile[49].getY() - tile[49].getHeight() / 4) < tile[49].getHeight() / 2 * tile[49].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(r_obstacle_5[2].position_x - tile[59].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[59].getX() - tile[59].getWidth() / 4) * (player.getX() - tile[59].getX() - tile[59].getWidth() / 4) < tile[59].getWidth() / 2 * tile[59].getWidth() / 3) {
                    if ((player.getY() - tile[59].getY() - tile[59].getHeight() / 4) * (player.getY() - tile[59].getY() - tile[59].getHeight() / 4) < tile[59].getHeight() / 2 * tile[59].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            ////////////////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(r_obstacle_5[3].position_x - tile[20].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[20].getX() - tile[20].getWidth() / 4) * (player.getX() - tile[20].getX() - tile[20].getWidth() / 4) < tile[20].getWidth() / 2 * tile[20].getWidth() / 3) {
                    if ((player.getY() - tile[20].getY() - tile[20].getHeight() / 4) * (player.getY() - tile[20].getY() - tile[20].getHeight() / 4) < tile[20].getHeight() / 2 * tile[20].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(r_obstacle_5[3].position_x - tile[28].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[28].getX() - tile[28].getWidth() / 4) * (player.getX() - tile[28].getX() - tile[28].getWidth() / 4) < tile[28].getWidth() / 2 * tile[28].getWidth() / 3) {
                    if ((player.getY() - tile[28].getY() - tile[28].getHeight() / 4) * (player.getY() - tile[28].getY() - tile[28].getHeight() / 4) < tile[28].getHeight() / 2 * tile[28].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            ////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(r_obstacle_6[0].position_x - tile[15].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[15].getX() - tile[15].getWidth() / 4) * (player.getX() - tile[15].getX() - tile[15].getWidth() / 4) < tile[15].getWidth() / 3 * tile[15].getWidth() / 2) {
                    if ((player.getY() - tile[15].getY() - tile[15].getHeight() / 4) * (player.getY() - tile[15].getY() - tile[15].getHeight() / 4) < tile[15].getHeight() / 2 * tile[15].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(r_obstacle_6[0].position_x - tile[26].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[26].getX() - tile[26].getWidth() / 4) * (player.getX() - tile[26].getX() - tile[26].getWidth() / 4) < tile[26].getWidth() / 2 * tile[26].getWidth() / 3) {
                    if ((player.getY() - tile[26].getY() - tile[26].getHeight() / 4) * (player.getY() - tile[26].getY() - tile[26].getHeight() / 4) < tile[26].getHeight() / 2 * tile[26].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            ////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(r_obstacle_6[1].position_x - tile[50].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[50].getX() - tile[50].getWidth() / 4) * (player.getX() - tile[50].getX() - tile[50].getWidth() / 4) < tile[50].getWidth() / 2 * tile[50].getWidth() / 3) {
                    if ((player.getY() - tile[50].getY() - tile[50].getHeight() / 4) * (player.getY() - tile[50].getY() - tile[50].getHeight() / 4) < tile[50].getHeight() / 2 * tile[50].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(r_obstacle_6[1].position_x - tile[60].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[60].getX() - tile[60].getWidth() / 4) * (player.getX() - tile[60].getX() - tile[60].getWidth() / 4) < tile[60].getWidth() / 2 * tile[60].getWidth() / 3) {
                    if ((player.getY() - tile[60].getY() - tile[60].getHeight() / 4) * (player.getY() - tile[60].getY() - tile[60].getHeight() / 4) < tile[60].getHeight() / 2 * tile[60].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            ///////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(r_obstacle_6[2].position_x - tile[21].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[21].getX() - tile[21].getWidth() / 4) * (player.getX() - tile[21].getX() - tile[21].getWidth() / 4) < tile[21].getWidth() / 2 * tile[21].getWidth() / 3) {
                    if ((player.getY() - tile[21].getY() - tile[21].getHeight() / 4) * (player.getY() - tile[21].getY() - tile[21].getHeight() / 4) < tile[21].getHeight() / 2 * tile[21].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(r_obstacle_6[2].position_x - tile[29].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[29].getX() - tile[29].getWidth() / 4) * (player.getX() - tile[29].getX() - tile[29].getWidth() / 4) < tile[29].getWidth() / 2 * tile[29].getWidth() / 3) {
                    if ((player.getY() - tile[29].getY() - tile[29].getHeight() / 4) * (player.getY() - tile[29].getY() - tile[29].getHeight() / 4) < tile[29].getHeight() / 2 * tile[29].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            //////////////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(r_obstacle_6[3].position_x - tile[56].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[56].getX() - tile[56].getWidth() / 4) * (player.getX() - tile[56].getX() - tile[56].getWidth() / 4) < tile[56].getWidth() / 2 * tile[56].getWidth() / 3) {
                    if ((player.getY() - tile[56].getY() - tile[56].getHeight() / 4) * (player.getY() - tile[56].getY() - tile[56].getHeight() / 4) < tile[56].getHeight() / 2 * tile[56].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(r_obstacle_6[3].position_x - tile[62].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[62].getX() - tile[62].getWidth() / 4) * (player.getX() - tile[62].getX() - tile[62].getWidth() / 4) < tile[62].getWidth() / 2 * tile[62].getWidth() / 3) {
                    if ((player.getY() - tile[62].getY() - tile[62].getHeight() / 4) * (player.getY() - tile[62].getY() - tile[62].getHeight() / 4) < tile[62].getHeight() / 2 * tile[62].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            ////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(r_obstacle_7[0].position_x - tile[51].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[51].getX() - tile[51].getWidth() / 4) * (player.getX() - tile[51].getX() - tile[51].getWidth() / 4) < tile[51].getWidth() / 2 * tile[51].getWidth() / 3) {
                    if ((player.getY() - tile[51].getY() - tile[51].getHeight() / 4) * (player.getY() - tile[51].getY() - tile[51].getHeight() / 4) < tile[51].getHeight() / 2 * tile[51].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(r_obstacle_7[0].position_x - tile[61].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[61].getX() - tile[61].getWidth() / 4) * (player.getX() - tile[61].getX() - tile[61].getWidth() / 4) < tile[61].getWidth() / 2 * tile[61].getWidth() / 3) {
                    if ((player.getY() - tile[61].getY() - tile[61].getHeight() / 4) * (player.getY() - tile[61].getY() - tile[61].getHeight() / 4) < tile[61].getHeight() / 2 * tile[61].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            ////////////////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(r_obstacle_7[1].position_x - tile[22].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[22].getX() - tile[22].getWidth() / 4) * (player.getX() - tile[22].getX() - tile[22].getWidth() / 4) < tile[22].getWidth() / 2 * tile[22].getWidth() / 3) {
                    if ((player.getY() - tile[22].getY() - tile[22].getHeight() / 4) * (player.getY() - tile[22].getY() - tile[22].getHeight() / 4) < tile[22].getHeight() / 2 * tile[22].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(r_obstacle_7[1].position_x - tile[30].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[30].getX() - tile[30].getWidth() / 4) * (player.getX() - tile[30].getX() - tile[30].getWidth() / 4) < tile[30].getWidth() / 2 * tile[30].getWidth() / 3) {
                    if ((player.getY() - tile[30].getY() - tile[30].getHeight() / 4) * (player.getY() - tile[30].getY() - tile[30].getHeight() / 4) < tile[30].getHeight() / 2 * tile[30].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            //////////////////////////////////////////////////////////////////////////////////////////////////

            if (Math.abs(r_obstacle_7[2].position_x - tile[57].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[57].getX() - tile[57].getWidth() / 4) * (player.getX() - tile[57].getX() - tile[57].getWidth() / 4) < tile[57].getWidth() / 2 * tile[57].getWidth() / 3) {
                    if ((player.getY() - tile[57].getY() - tile[57].getHeight() / 4) * (player.getY() - tile[57].getY() - tile[57].getHeight() / 4) < tile[57].getHeight() / 2 * tile[57].getHeight() / 3) {
                        //heart1.setVisibility(heart1.INVISIBLE);
                        return true;
                    }
                }
            }

            if (Math.abs(r_obstacle_7[2].position_x - tile[63].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[63].getX() - tile[63].getWidth() / 4) * (player.getX() - tile[63].getX() - tile[63].getWidth() / 4) < tile[63].getWidth() / 2 * tile[63].getWidth() / 3) {
                    if ((player.getY() - tile[63].getY() - tile[63].getHeight() / 4) * (player.getY() - tile[63].getY() - tile[63].getHeight() / 4) < tile[63].getHeight() / 2 * tile[63].getHeight() / 3) {
                        return true;
                    }
                }
            }

            if (Math.abs(r_obstacle_7[3].position_x - tile[27].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[27].getX() - tile[27].getWidth() / 4) * (player.getX() - tile[27].getX() - tile[27].getWidth() / 4) < tile[27].getWidth() / 2 * tile[27].getWidth() / 3) {
                    if ((player.getY() - tile[27].getY() - tile[27].getHeight() / 4) * (player.getY() - tile[27].getY() - tile[27].getHeight() / 4) < tile[27].getHeight() / 2 * tile[27].getHeight() / 3) {
                        return true;
                    }
                }
            }

            if (Math.abs(r_obstacle_7[3].position_x - tile[31].getX()) <= 2 * size_dm) {
                if ((player.getX() - tile[31].getX() - tile[31].getWidth() / 4) * (player.getX() - tile[31].getX() - tile[31].getWidth() / 4) < tile[31].getWidth() / 2 * tile[31].getWidth() / 3) {
                    if ((player.getY() - tile[31].getY() - tile[31].getHeight() / 4) * (player.getY() - tile[31].getY() - tile[31].getHeight() / 4) < tile[31].getHeight() / 2 * tile[31].getHeight() / 3) {
                        return true;
                    }
                }
            }
        }

        return false;
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


    public void mapping()
    {
        tile_end_x1 = Math.round(tile[0].getX());
        tile_end_y1 = Math.round(tile[0].getY());

        tile_end_x2 = Math.round(tile[44].getX());
        tile_end_y2 = Math.round(tile[44].getY());

        tile_end_x3 = Math.round(tile[51].getX());
        tile_end_y3 = Math.round(tile[51].getY());

        tile_end_x4 = Math.round(tile[31].getX());
        tile_end_y4 = Math.round(tile[31].getY());

    }

    void game_setFont(TextView name, String path, int res)
    {
        name = (TextView)findViewById(res);
        Typeface font = Typeface.createFromAsset(this.getAssets(), path);

        name.setTypeface(font);
    }

    void timing_set()
    {
        if(total_time_number > 0) {
            total_time_number -= 1;
            time_number.setText("" + total_time_number);
        }
    }


    void enemy_health_check(boolean x)
    {
        if(x == true)
        {
            if(enemy_maximum_energy3 > 5*size_dm) {

                ++action_flag1_count;
                enemy_maximum_energy3 -= player_bullet_damage;

                enemy_energybar3.position(10 * size_dm, 90 * size_dm);
                enemy_energybar3.resized_image(enemy_maximum_energy3, 10 * size_dm);
                enemy_energybar3.setObstacleAlpha(220);

                enemy_energybar3.position_effect();
                stun_player = true;

                if(action_flag1_count == 101)
                {
                    enemy_action_flag1 = true;
                }
            }
            else
            {
                enemy_energybar3.setObstacleAlpha(0);
                enemy_energybar3.position_effect();
                stun_player = true;
                action_flag1_count=0;

            }

            if(enemy_maximum_energy2 > 5*size_dm && action_flag1_count==0)
            {
                ++action_flag1_count2;
                enemy_maximum_energy2 -= player_bullet_damage;

                enemy_energybar2.position(10 * size_dm, 70 * size_dm);
                enemy_energybar2.resized_image(enemy_maximum_energy2, 10 * size_dm);
                enemy_energybar2.setObstacleAlpha(220);

                enemy_energybar2.position_effect();
                stun_player = true;

                if(action_flag1_count2 == 101)
                {
                    enemy_action_flag2 = true;
                }

            }
            else if(enemy_maximum_energy2 <= 5*size_dm){
                enemy_energybar2.setObstacleAlpha(0);
                enemy_energybar2.position_effect();
                stun_player = true;
                action_flag1_count2=0;

            }

            if( enemy_maximum_energy > 5*size_dm && action_flag1_count==0 && action_flag1_count2 == 0) {
                ++action_flag1_count3;
                enemy_maximum_energy -= player_bullet_damage;

                enemy_energybar.position(10 * size_dm, 50 * size_dm);
                enemy_energybar.resized_image(enemy_maximum_energy, 10 * size_dm);
                enemy_energybar.setObstacleAlpha(220);

                enemy_energybar.position_effect();
                stun_player = true;

                if(action_flag1_count3 == 101)
                {
                    enemy_action_flag3 = true;
                }
            }
            else if(enemy_maximum_energy <= 5*size_dm ){
                enemy_energybar.setObstacleAlpha(0);
                enemy_energybar.position_effect();
                stun_player = true;
                action_flag1_count3=0;

            }
        }
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
        Drawable t = tile[0].getDrawable();
        Drawable t1 = tile[1].getDrawable();
        Drawable t2 = tile[2].getDrawable();
        Drawable t3 = tile[3].getDrawable();
        Drawable t4 = tile[4].getDrawable();
        Drawable t5 = tile[5].getDrawable();
        Drawable t6 = tile[6].getDrawable();
        Drawable t7 = tile[7].getDrawable();
        Drawable t8 = tile[8].getDrawable();
        Drawable t9 = tile[9].getDrawable();
        Drawable t10 = tile[10].getDrawable();
        Drawable t11 = tile[11].getDrawable();
        Drawable t12 = tile[12].getDrawable();
        Drawable t13 = tile[13].getDrawable();
        Drawable t14 = tile[14].getDrawable();
        Drawable t15 = tile[15].getDrawable();
        Drawable t16 = tile[16].getDrawable();
        Drawable t17 = tile[17].getDrawable();
        Drawable t18= tile[18].getDrawable();
        Drawable t19 = tile[19].getDrawable();
        Drawable t20 = tile[20].getDrawable();
        Drawable t21 = tile[21].getDrawable();
        Drawable t22 = tile[22].getDrawable();
        Drawable t23 = tile[23].getDrawable();
        Drawable t24 = tile[24].getDrawable();
        Drawable t25 = tile[25].getDrawable();
        Drawable t26 = tile[26].getDrawable();
        Drawable t27 = tile[27].getDrawable();
        Drawable t28 = tile[28].getDrawable();
        Drawable t29 = tile[29].getDrawable();
        Drawable t30 = tile[30].getDrawable();
        Drawable t31 = tile[31].getDrawable();

        Drawable t_1 = tile[32].getDrawable();
        Drawable t_2 = tile[33].getDrawable();
        Drawable t_3 = tile[34].getDrawable();
        Drawable t_4 = tile[35].getDrawable();
        Drawable t_5 = tile[36].getDrawable();
        Drawable t_6 = tile[37].getDrawable();
        Drawable t_7 = tile[38].getDrawable();
        Drawable t_8 = tile[39].getDrawable();
        Drawable t_9 = tile[40].getDrawable();
        Drawable t_10 = tile[41].getDrawable();
        Drawable t_11 = tile[42].getDrawable();
        Drawable t_12 = tile[43].getDrawable();
        Drawable t_13 = tile[44].getDrawable();
        Drawable t_14 = tile[45].getDrawable();
        Drawable t_15 = tile[46].getDrawable();
        Drawable t_16 = tile[47].getDrawable();
        Drawable t_17 = tile[48].getDrawable();
        Drawable t_18 = tile[49].getDrawable();
        Drawable t_19 = tile[50].getDrawable();
        Drawable t_20 = tile[51].getDrawable();
        Drawable t_21 = tile[52].getDrawable();
        Drawable t_22 = tile[53].getDrawable();
        Drawable t_23 = tile[54].getDrawable();
        Drawable t_24 = tile[55].getDrawable();
        Drawable t_25 = tile[56].getDrawable();
        Drawable t_26 = tile[57].getDrawable();
        Drawable t_27 = tile[58].getDrawable();
        Drawable t_28 = tile[59].getDrawable();
        Drawable t_29 = tile[60].getDrawable();
        Drawable t_30 = tile[61].getDrawable();
        Drawable t_31 = tile[62].getDrawable();
        Drawable t_32 = tile[63].getDrawable();

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

        if(t1 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t1).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t1.setCallback(null);

        if(t2 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t2).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t2.setCallback(null);

        if(t3 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t3).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t3.setCallback(null);

        if(t4 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t4).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t4.setCallback(null);

        if(t5 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t5).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t5.setCallback(null);

        if(t6 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t6).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t6.setCallback(null);

        if(t7 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t7).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t7.setCallback(null);

        if(t8 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t8).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t8.setCallback(null);

        if(t9 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t9).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t9.setCallback(null);

        if(t10 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t10).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t10.setCallback(null);

        if(t11 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t11).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t11.setCallback(null);

        if(t12 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t12).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t12.setCallback(null);

        if(t13 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t13).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t13.setCallback(null);

        if(t14 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t14).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t14.setCallback(null);

        if(t15 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t15).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t15.setCallback(null);

        if(t16 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t16).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t16.setCallback(null);

        if(t17 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t17).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t17.setCallback(null);

        if(t18 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t18).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t18.setCallback(null);

        if(t19 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t19).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t19.setCallback(null);

        if(t20 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t20).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t20.setCallback(null);

        if(t21 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t21).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t21.setCallback(null);

        if(t22 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t22).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t22.setCallback(null);

        if(t23 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t23).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t23.setCallback(null);

        if(t24 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t24).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t24.setCallback(null);

        if(t25 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t25).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t25.setCallback(null);

        if(t26 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t26).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t26.setCallback(null);

        if(t27 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t27).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t27.setCallback(null);

        if(t28 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t28).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t28.setCallback(null);

        if(t29 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t29).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t29.setCallback(null);

        if(t30 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t30).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t30.setCallback(null);

        if(t31 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t31).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t31.setCallback(null);

        if(t_1 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t_1).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_1.setCallback(null);

        if(t_2 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t_2).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_2.setCallback(null);

        if(t_3 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t_3).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_3.setCallback(null);

        if(t_4 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t_4).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_4.setCallback(null);

        if(t_5 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t_5).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_5.setCallback(null);

        if(t_6 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t_6).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_6.setCallback(null);

        if(t_7 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t_7).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_7.setCallback(null);

        if(t_8 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t_8).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_8.setCallback(null);

        if(t_9 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t_9).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_9.setCallback(null);

        if(t_10 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t_10).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_10.setCallback(null);

        if(t_11 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t_11).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_11.setCallback(null);

        if(t_12 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t_12).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_12.setCallback(null);

        if(t_13 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t_13).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_13.setCallback(null);

        if(t_13 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t_13).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_13.setCallback(null);

        if(t_14 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t_14).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_14.setCallback(null);

        if(t_15 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t_15).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_15.setCallback(null);

        if(t_16 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t_16).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_16.setCallback(null);

        if(t_17 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t_17).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t17.setCallback(null);

        if(t_18 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t_18).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_18.setCallback(null);

        if(t_19 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t_19).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_19.setCallback(null);

        if(t_20 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t_20).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_20.setCallback(null);

        if(t_21 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t_21).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_21.setCallback(null);

        if(t_22 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t_22).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_22.setCallback(null);

        if(t_23 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t_23).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_23.setCallback(null);

        if(t_24 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t_24).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_24.setCallback(null);

        if(t_25 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t_25).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_25.setCallback(null);

        if(t_26 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t_26).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_26.setCallback(null);

        if(t_27 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t_27).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_27.setCallback(null);
        if(t_28 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t_28).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_28.setCallback(null);
        if(t_29 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t_29).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_29.setCallback(null);
        if(t_30 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t_30).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_30.setCallback(null);

        if(t_31 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t_31).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_31.setCallback(null);

        if(t_32 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t_32).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_32.setCallback(null);

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

        for(int i=0; i<64; i++)
        {
            effect[i].empty();
        }

        for(int i=0; i<16; i++)
        {
            enemy_bullet[i].empty();
        }

       obs2_1.empty(); obs2_2_1.empty(); obs2_2_2.empty(); obs2_3_1.empty(); obs2_3_2.empty(); obs2_3_3.empty(); obs2_4_1.empty(); obs2_4_2.empty(); obs2_4_3.empty(); obs2_4_4.empty();
       obs2_5_1.empty(); obs2_5_2.empty(); obs2_5_3.empty(); obs2_5_4.empty(); obs2_5_5.empty(); obs2_6_1.empty(); obs2_6_2.empty(); obs2_6_3.empty(); obs2_6_4.empty(); obs2_6_5.empty(); obs2_6_6.empty();
        obs2_7_1.empty(); obs2_7_2.empty(); obs2_7_3.empty(); obs2_7_4.empty(); obs2_7_5.empty(); obs2_7_6.empty(); obs2_7_7.empty(); obs2_8_1.empty(); obs2_8_2.empty(); obs2_8_3.empty(); obs2_8_4.empty();
     obs2_8_5.empty(); obs2_8_6.empty(); obs2_8_7.empty(); obs2_8_8.empty(); obs2_9_1.empty(); obs2_9_2.empty(); obs2_9_3.empty(); obs2_9_4.empty(); obs2_9_5.empty(); obs2_9_6.empty(); obs2_9_7.empty();
       obs2_10_1.empty(); obs2_10_2.empty(); obs2_10_3.empty(); obs2_10_4.empty(); obs2_10_5.empty(); obs2_10_6.empty(); obs2_11_1.empty(); obs2_11_2.empty(); obs2_11_3.empty(); obs2_11_4.empty(); obs2_11_5.empty();
       obs2_12_1.empty(); obs2_12_2.empty(); obs2_12_3.empty(); obs2_12_4.empty(); obs2_13_1.empty(); obs2_13_2.empty(); obs2_13_3.empty(); obs2_14_1.empty(); obs2_14_2.empty(); obs2_15_1.empty();

        effect2_1.empty(); effect2_2_1.empty(); effect2_2_2.empty(); effect2_3_1.empty(); effect2_3_2.empty(); effect2_3_3.empty(); effect2_4_1.empty(); effect2_4_2.empty(); effect2_4_3.empty(); effect2_4_4.empty();
        effect2_5_1.empty(); effect2_5_2.empty(); effect2_5_3.empty(); effect2_5_4.empty(); effect2_5_5.empty(); effect2_6_1.empty(); effect2_6_2.empty(); effect2_6_3.empty(); effect2_6_4.empty(); effect2_6_5.empty(); effect2_6_6.empty();
        effect2_7_1.empty(); effect2_7_2.empty(); effect2_7_3.empty(); effect2_7_4.empty(); effect2_7_5.empty(); effect2_7_6.empty(); effect2_7_7.empty(); effect2_8_1.empty(); effect2_8_2.empty(); effect2_8_3.empty(); effect2_8_4.empty();
        effect2_8_5.empty(); effect2_8_6.empty(); effect2_8_7.empty(); effect2_8_8.empty(); effect2_9_1.empty(); effect2_9_2.empty(); effect2_9_3.empty(); effect2_9_4.empty(); effect2_9_5.empty(); effect2_9_6.empty(); effect2_9_7.empty();
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

        for (int i = 0; i < 4; i++) {

            obstacle[i].empty();
            obstaclex2[i].empty();
            obstaclex3[i].empty();
            obstaclex4[i].empty();

            r_obstacle[i].empty();
            r_obstaclex2[i].empty();
            r_obstaclex3[i].empty();
            r_obstaclex4[i].empty();

            obstacle_1[i].empty();
            obstaclex2_1[i].empty();
            obstaclex3_1[i].empty();
            obstaclex4_1[i].empty();
            r_obstacle_1[i].empty();
            r_obstaclex2_1[i].empty();
            r_obstaclex3_1[i].empty();
            r_obstaclex4_1[i].empty();

            obstacle_2[i].empty();
            obstaclex2_2[i].empty();
            obstaclex3_2[i].empty();
            obstaclex4_2[i].empty();

            r_obstacle_2[i].empty();
            r_obstaclex2_2[i].empty();
            r_obstaclex3_2[i].empty();
            r_obstaclex4_2[i].empty();

            obstacle_3[i].empty();
            obstaclex2_3[i].empty();
            obstaclex3_3[i].empty();
            obstaclex4_3[i].empty();

            r_obstacle_3[i].empty();
            r_obstaclex2_3[i].empty();
            r_obstaclex3_3[i].empty();
            r_obstaclex4_3[i].empty();

            obstacle_4[i].empty();
            obstaclex2_4[i].empty();
            obstaclex3_4[i].empty();
            obstaclex4_4[i].empty();

            r_obstacle_4[i].empty();
            r_obstaclex2_4[i].empty();
            r_obstaclex3_4[i].empty();
            r_obstaclex4_4[i].empty();

            obstacle_5[i].empty();
            obstaclex2_5[i].empty();
            obstaclex3_5[i].empty();
            obstaclex4_5[i].empty();

            r_obstacle_5[i].empty();
            r_obstaclex2_5[i].empty();
            r_obstaclex3_5[i].empty();
            r_obstaclex4_5[i].empty();

            obstacle_6[i].empty();
            obstaclex2_6[i].empty();
            obstaclex3_6[i].empty();
            obstaclex4_6[i].empty();

            r_obstacle_6[i].empty();
            r_obstaclex2_6[i].empty();
            r_obstaclex3_6[i].empty();
            r_obstaclex4_6[i].empty();

            obstacle_7[i].empty();
            obstaclex2_7[i].empty();
            obstaclex3_7[i].empty();
            obstaclex4_7[i].empty();
            r_obstacle_7[i].empty();
            r_obstaclex2_7[i].empty();
            r_obstaclex3_7[i].empty();
            r_obstaclex4_7[i].empty();

        }


        for (int i = 0; i < 5; i++) {
            player_bullet[i].empty();
        }

        enemy_energybar.empty();
        enemy_energybar2.empty();
        enemy_energybar3.empty();
        player_energybar.empty();
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
