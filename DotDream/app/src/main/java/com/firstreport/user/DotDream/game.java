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
 * Created by user on 2017-06-26.
 */

public class game extends AppCompatActivity {

    //private static final int SHOW_PRESS = 1;
    //private static final int LONG_PRESS = 2;
    //private static final int TAP = 3;
    private int tile_end_x1, tile_end_y1;
    private int tile_end_x2, tile_end_y2;
    private int tile_end_x3, tile_end_y3;
    private int tile_end_x4, tile_end_y4;
    private int prior_player_x, prior_player_y;
    private int timing_number = 0, total_time_number = 50, health_timing_number = 0, level_time_number = 0;
    private int pattern_number, health_number = 0;
    private int size_dm;

    private int SpeedX, SpeedY;
    private int obstacle_SpeedX, obstacle_SpeedY;
    private int obstacle_2_SpeedX, obstacle_2_SpeedY;
    private int obstacle_3_SpeedX, obstacle_3_SpeedY;
    private int screenWidth;
    private int screenHeight;
    private int frameHeight;
    private int pattern[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    private boolean Isdamaged_player;
    private boolean stun_player = false;

    private Handler handler = new Handler();
    private Timer timer = new Timer();
    private ImageView player;

    private RelativeLayout layout_joystick;
    private RelativeLayout gameview;

    private ImageView tile1_1;
    private ImageView tile1_32;
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

    private boolean action_flg = false;
    private boolean start_flg = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameview);

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
        gameview = (RelativeLayout) findViewById(R.id.gameview);

        js = new JoyStickClass(getApplicationContext(), layout_joystick, R.drawable.center);
        js.setStickSize(30 * size_dm, 30 * size_dm);
        js.setLayoutSize(100 * size_dm, 100 * size_dm);
        js.setLayoutAlpha(50);
        js.setStickAlpha(50);
        js.setOffset(15 * size_dm);
        js.setMinimumDistance(1 * size_dm);

        js.initial_draw(50 * size_dm, 50 * size_dm);

        obs = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obs.position(120 * size_dm, 125 * size_dm);
        obs.resized_image(30 * size_dm, 30 * size_dm);
        obs.setObstacleAlpha(200);

        obs_1 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obs_1.position(107 * size_dm, 138 * size_dm);
        obs_1.resized_image(30 * size_dm, 30 * size_dm);
        obs_1.setObstacleAlpha(200);

        obs_2 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obs_2.position(94 * size_dm, 151 * size_dm);
        obs_2.resized_image(30 * size_dm, 30 * size_dm);
        obs_2.setObstacleAlpha(200);

        obs_3 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obs_3.position(81 * size_dm, 164 * size_dm);
        obs_3.resized_image(30 * size_dm, 30 * size_dm);
        obs_3.setObstacleAlpha(200);

        obs_4 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obs_4.position(68 * size_dm, 177 * size_dm);
        obs_4.resized_image(30 * size_dm, 30 * size_dm);
        obs_4.setObstacleAlpha(200);

        obs_5 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obs_5.position(55 * size_dm, 190 * size_dm);
        obs_5.resized_image(30 * size_dm, 30 * size_dm);
        obs_5.setObstacleAlpha(200);

        obs_6 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obs_6.position(42 * size_dm, 203 * size_dm);
        obs_6.resized_image(30 * size_dm, 30 * size_dm);
        obs_6.setObstacleAlpha(200);

        obs_7 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obs_7.position(29 * size_dm, 216 * size_dm);
        obs_7.resized_image(30 * size_dm, 30 * size_dm);
        obs_7.setObstacleAlpha(200);

        obsx2 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obsx2.position(120 * size_dm, 125 * size_dm);
        obsx2.resized_image(30 * size_dm, 30 * size_dm);
        obsx2.setObstacleAlpha(200);

        obsx2_1 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obsx2_1.position(107 * size_dm, 138 * size_dm);
        obsx2_1.resized_image(30 * size_dm, 30 * size_dm);
        obsx2_1.setObstacleAlpha(200);

        obsx2_2 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obsx2_2.position(94 * size_dm, 151 * size_dm);
        obsx2_2.resized_image(30 * size_dm, 30 * size_dm);
        obsx2_2.setObstacleAlpha(200);

        obsx2_3 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obsx2_3.position(81 * size_dm, 164 * size_dm);
        obsx2_3.resized_image(30 * size_dm, 30 * size_dm);
        obsx2_3.setObstacleAlpha(200);

        obsx2_4 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obsx2_4.position(68 * size_dm, 177 * size_dm);
        obsx2_4.resized_image(30 * size_dm, 30 * size_dm);
        obsx2_4.setObstacleAlpha(200);

        obsx2_5 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obsx2_5.position(55 * size_dm, 190 * size_dm);
        obsx2_5.resized_image(30 * size_dm, 30 * size_dm);
        obsx2_5.setObstacleAlpha(200);

        obsx2_6 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obsx2_6.position(42 * size_dm, 203 * size_dm);
        obsx2_6.resized_image(30 * size_dm, 30 * size_dm);
        obsx2_6.setObstacleAlpha(200);

        obsx2_7 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obsx2_7.position(29 * size_dm, 216 * size_dm);
        obsx2_7.resized_image(30 * size_dm, 30 * size_dm);
        obsx2_7.setObstacleAlpha(200);

        obsx3 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obsx3.position(100 * size_dm, 109 * size_dm);
        obsx3.resized_image(30 * size_dm, 30 * size_dm);
        obsx3.setObstacleAlpha(200);

        obsx3_1 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obsx3_1.position(53 * size_dm, 86 * size_dm);
        obsx3_1.resized_image(30 * size_dm, 30 * size_dm);
        obsx3_1.setObstacleAlpha(200);

        obsx3_2 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obsx3_2.position(45 * size_dm, 104 * size_dm);
        obsx3_2.resized_image(30 * size_dm, 30 * size_dm);
        obsx3_2.setObstacleAlpha(200);

        obsx3_3 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obsx3_3.position(60 * size_dm, 139 * size_dm);
        obsx3_3.resized_image(30 * size_dm, 30 * size_dm);
        obsx3_3.setObstacleAlpha(200);

        obsx3_4 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obsx3_4.position(75 * size_dm, 164 * size_dm);
        obsx3_4.resized_image(30 * size_dm, 30 * size_dm);
        obsx3_4.setObstacleAlpha(200);

        obsx3_5 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obsx3_5.position(90 * size_dm, 222 * size_dm);
        obsx3_5.resized_image(30 * size_dm, 30 * size_dm);
        obsx3_5.setObstacleAlpha(200);

        obsx3_6 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obsx3_6.position(67 * size_dm, 224 * size_dm);
        obsx3_6.resized_image(30 * size_dm, 30 * size_dm);
        obsx3_6.setObstacleAlpha(200);

        obsx3_7 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obsx3_7.position(40 * size_dm, 233 * size_dm);
        obsx3_7.resized_image(30 * size_dm, 30 * size_dm);
        obsx3_7.setObstacleAlpha(200);

        obs1 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obs1.position(189 * size_dm, 125 * size_dm);
        obs1.resized_image(30 * size_dm, 30 * size_dm);
        obs1.setObstacleAlpha(200);

        obs_1_1 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obs_1_1.position(202 * size_dm, 138 * size_dm);
        obs_1_1.resized_image(30 * size_dm, 30 * size_dm);
        obs_1_1.setObstacleAlpha(200);

        obs_2_1 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obs_2_1.position(215 * size_dm, 151 * size_dm);
        obs_2_1.resized_image(30 * size_dm, 30 * size_dm);
        obs_2_1.setObstacleAlpha(200);

        obs_3_1 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obs_3_1.position(228 * size_dm, 164 * size_dm);
        obs_3_1.resized_image(30 * size_dm, 30 * size_dm);
        obs_3_1.setObstacleAlpha(200);

        obs_4_1 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obs_4_1.position(241 * size_dm, 177 * size_dm);
        obs_4_1.resized_image(30 * size_dm, 30 * size_dm);
        obs_4_1.setObstacleAlpha(200);

        obs_5_1 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obs_5_1.position(254 * size_dm, 190 * size_dm);
        obs_5_1.resized_image(30 * size_dm, 30 * size_dm);
        obs_5_1.setObstacleAlpha(200);

        obs_6_1 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obs_6_1.position(267 * size_dm, 203 * size_dm);
        obs_6_1.resized_image(30 * size_dm, 30 * size_dm);
        obs_6_1.setObstacleAlpha(200);

        obs_7_1 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obs_7_1.position(280 * size_dm, 216 * size_dm);
        obs_7_1.resized_image(30 * size_dm, 30 * size_dm);
        obs_7_1.setObstacleAlpha(200);

        obs1x2 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obs1x2.position(189 * size_dm, 125 * size_dm);
        obs1x2.resized_image(30 * size_dm, 30 * size_dm);
        obs1x2.setObstacleAlpha(200);

        obsx2_1_1 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obsx2_1_1.position(202 * size_dm, 138 * size_dm);
        obsx2_1_1.resized_image(30 * size_dm, 30 * size_dm);
        obsx2_1_1.setObstacleAlpha(200);

        obsx2_2_1 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obsx2_2_1.position(215 * size_dm, 151 * size_dm);
        obsx2_2_1.resized_image(30 * size_dm, 30 * size_dm);
        obsx2_2_1.setObstacleAlpha(200);

        obsx2_3_1 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obsx2_3_1.position(228 * size_dm, 164 * size_dm);
        obsx2_3_1.resized_image(30 * size_dm, 30 * size_dm);
        obsx2_3_1.setObstacleAlpha(200);

        obsx2_4_1 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obsx2_4_1.position(241 * size_dm, 177 * size_dm);
        obsx2_4_1.resized_image(30 * size_dm, 30 * size_dm);
        obsx2_4_1.setObstacleAlpha(200);

        obsx2_5_1 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obsx2_5_1.position(254 * size_dm, 190 * size_dm);
        obsx2_5_1.resized_image(30 * size_dm, 30 * size_dm);
        obsx2_5_1.setObstacleAlpha(200);

        obsx2_6_1 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obsx2_6_1.position(267 * size_dm, 203 * size_dm);
        obsx2_6_1.resized_image(30 * size_dm, 30 * size_dm);
        obsx2_6_1.setObstacleAlpha(200);

        obsx2_7_1 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obsx2_7_1.position(280 * size_dm, 216 * size_dm);
        obsx2_7_1.resized_image(30 * size_dm, 30 * size_dm);
        obsx2_7_1.setObstacleAlpha(200);

        obs1x3 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obs1x3.position(189 * size_dm, 125 * size_dm);
        obs1x3.resized_image(30 * size_dm, 30 * size_dm);
        obs1x3.setObstacleAlpha(200);

        obsx3_1_1 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obsx3_1_1.position(202 * size_dm, 138 * size_dm);
        obsx3_1_1.resized_image(30 * size_dm, 30 * size_dm);
        obsx3_1_1.setObstacleAlpha(200);

        obsx3_2_1 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obsx3_2_1.position(215 * size_dm, 151 * size_dm);
        obsx3_2_1.resized_image(30 * size_dm, 30 * size_dm);
        obsx3_2_1.setObstacleAlpha(200);

        obsx3_3_1 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obsx3_3_1.position(228 * size_dm, 164 * size_dm);
        obsx3_3_1.resized_image(30 * size_dm, 30 * size_dm);
        obsx3_3_1.setObstacleAlpha(200);

        obsx3_4_1 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obsx3_4_1.position(241 * size_dm, 177 * size_dm);
        obsx3_4_1.resized_image(30 * size_dm, 30 * size_dm);
        obsx3_4_1.setObstacleAlpha(200);

        obsx3_5_1 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obsx3_5_1.position(254 * size_dm, 190 * size_dm);
        obsx3_5_1.resized_image(30 * size_dm, 30 * size_dm);
        obsx3_5_1.setObstacleAlpha(200);

        obsx3_6_1 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obsx3_6_1.position(267 * size_dm, 203 * size_dm);
        obsx3_6_1.resized_image(30 * size_dm, 30 * size_dm);
        obsx3_6_1.setObstacleAlpha(200);

        obsx3_7_1 = new ObstacleClass(getApplicationContext(), gameview, R.drawable.enemy);
        obsx3_7_1.position(280 * size_dm, 216 * size_dm);
        obsx3_7_1.resized_image(30 * size_dm, 30 * size_dm);
        obsx3_7_1.setObstacleAlpha(200);

        player = (ImageView) findViewById(R.id.player);

        tile1_1 = (ImageView) findViewById(R.id.tile1_1);
        tile1_32 = (ImageView) findViewById(R.id.tile1_32);
        tile2_13 = (ImageView) findViewById(R.id.tile2_13);
        tile2_20 = (ImageView) findViewById(R.id.tile2_20);

        heart1 = (ImageView) findViewById(R.id.heart1);
        heart2 = (ImageView) findViewById(R.id.heart2);
        heart3 = (ImageView) findViewById(R.id.heart3);

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
                                                Intent intent = new Intent(getApplicationContext(), Main2.class);
                                                startActivity(intent);
                                            } catch (Exception e) {
                                                Intent intent = new Intent(getApplicationContext(), Main2.class);
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

                                        obstacle_moving(obstacle_SpeedX, obstacle_SpeedY, pattern_number);
                                        obstacle_2_moving(obstacle_2_SpeedX, obstacle_2_SpeedY, pattern_number);
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

    private int getRandomMath(int max, int offset) {


        int nResult = (int) (Math.random() * (max - offset + 1)) + offset;


        return nResult;

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

    boolean hit_check() {
        if ((obs.position_x - player.getX()) * (obs.position_x - player.getX()) < obs.resized_width / 3 * obs.resized_width / 3) {
            if ((obs.position_y - player.getY()) * (obs.position_y - player.getY()) < obs.resized_height / 3 * obs.resized_height / 3) {
                return true;
            }
        }

        if ((obs_1.position_x - player.getX()) * (obs_1.position_x - player.getX()) < obs_1.resized_width / 3 * obs_1.resized_width / 3) {
            if ((obs_1.position_y - player.getY()) * (obs_1.position_y - player.getY()) < obs_1.resized_height / 3 * obs_1.resized_height / 3) {
                return true;
            }
        }

        if ((obs_2.position_x - player.getX()) * (obs_2.position_x - player.getX()) < obs_2.resized_width / 3 * obs_2.resized_width / 3) {
            if ((obs_2.position_y - player.getY()) * (obs_2.position_y - player.getY()) < obs_2.resized_height / 3 * obs_2.resized_height / 3) {
                return true;
            }
        }

        if ((obs_3.position_x - player.getX()) * (obs_3.position_x - player.getX()) < obs_3.resized_width / 3 * obs_3.resized_width / 3) {
            if ((obs_3.position_y - player.getY()) * (obs_3.position_y - player.getY()) < obs_3.resized_height / 3 * obs_3.resized_height / 3) {
                return true;
            }
        }

        if ((obs_4.position_x - player.getX()) * (obs_4.position_x - player.getX()) < obs_4.resized_width / 3 * obs_4.resized_width / 3) {
            if ((obs_4.position_y - player.getY()) * (obs_4.position_y - player.getY()) < obs_4.resized_height / 3 * obs_4.resized_height / 3) {
                return true;
            }
        }

        if ((obs_5.position_x - player.getX()) * (obs_5.position_x - player.getX()) < obs_5.resized_width / 3 * obs_5.resized_width / 3) {
            if ((obs_5.position_y - player.getY()) * (obs_5.position_y - player.getY()) < obs_5.resized_height / 3 * obs_5.resized_height / 3) {
                return true;
            }
        }

        if ((obs_6.position_x - player.getX()) * (obs_6.position_x - player.getX()) < obs_6.resized_width / 3 * obs_6.resized_width / 3) {
            if ((obs_6.position_y - player.getY()) * (obs_6.position_y - player.getY()) < obs_6.resized_height / 3 * obs_6.resized_height / 3) {
                return true;
            }
        }

        if ((obs_7.position_x - player.getX()) * (obs_7.position_x - player.getX()) < obs_7.resized_width / 3 * obs_7.resized_width / 3) {
            if ((obs_7.position_y - player.getY()) * (obs_7.position_y - player.getY()) < obs_7.resized_height / 3 * obs_7.resized_height / 3) {
                return true;
            }
        }

        if ((obsx2.position_x - player.getX()) * (obsx2.position_x - player.getX()) < obsx2.resized_width / 3 * obsx2.resized_width / 3) {
            if ((obsx2_1.position_y - player.getY()) * (obsx2_1.position_y - player.getY()) < obsx2_1.resized_height / 3 * obsx2_1.resized_height / 3) {
                return true;
            }
        }

        if ((obsx2_1.position_x - player.getX()) * (obsx2_1.position_x - player.getX()) < obsx2_1.resized_width / 3 * obsx2_1.resized_width / 3) {
            if ((obsx2_1.position_y - player.getY()) * (obsx2_1.position_y - player.getY()) < obsx2_1.resized_height / 3 * obsx2_1.resized_height / 3) {
                return true;
            }
        }

        if ((obsx2_2.position_x - player.getX()) * (obsx2_2.position_x - player.getX()) < obsx2_2.resized_width / 3 * obsx2_2.resized_width / 3) {
            if ((obsx2_2.position_y - player.getY()) * (obsx2_2.position_y - player.getY()) < obsx2_2.resized_height / 3 * obsx2_2.resized_height / 3) {
                return true;
            }
        }

        if ((obsx2_3.position_x - player.getX()) * (obsx2_3.position_x - player.getX()) < obsx2_3.resized_width / 3 * obsx2_3.resized_width / 3) {
            if ((obsx2_3.position_y - player.getY()) * (obsx2_3.position_y - player.getY()) < obsx2_3.resized_height / 3 * obsx2_3.resized_height / 3) {
                return true;
            }
        }

        if ((obsx2_4.position_x - player.getX()) * (obsx2_4.position_x - player.getX()) < obsx2_4.resized_width / 3 * obsx2_4.resized_width / 3) {
            if ((obsx2_4.position_y - player.getY()) * (obsx2_4.position_y - player.getY()) < obsx2_4.resized_height / 3 * obsx2_4.resized_height / 3) {
                return true;
            }
        }

        if ((obsx2_5.position_x - player.getX()) * (obsx2_5.position_x - player.getX()) < obsx2_5.resized_width / 3 * obsx2_5.resized_width / 3) {
            if ((obsx2_5.position_y - player.getY()) * (obsx2_5.position_y - player.getY()) < obsx2_5.resized_height / 3 * obsx2_5.resized_height / 3) {
                return true;
            }
        }

        if ((obsx2_6.position_x - player.getX()) * (obsx2_6.position_x - player.getX()) < obsx2_6.resized_width / 3 * obsx2_6.resized_width / 3) {
            if ((obsx2_6.position_y - player.getY()) * (obsx2_6.position_y - player.getY()) < obsx2_6.resized_height / 3 * obsx2_6.resized_height / 3) {
                return true;
            }
        }

        if ((obsx2_7.position_x - player.getX()) * (obsx2_7.position_x - player.getX()) < obsx2_7.resized_width / 3 * obsx2_7.resized_width / 3) {
            if ((obsx2_7.position_y - player.getY()) * (obsx2_7.position_y - player.getY()) < obsx2_7.resized_height / 3 * obsx2_7.resized_height / 3) {
                return true;
            }
        }

        if ((obsx3.position_x - player.getX()) * (obsx3.position_x - player.getX()) < obsx3.resized_width / 3 * obsx3.resized_width / 3) {
            if ((obsx3.position_y - player.getY()) * (obsx3.position_y - player.getY()) < obsx3.resized_height / 3 * obsx3.resized_height / 3) {

                return true;
            }
        }

        if ((obsx3_1.position_x - player.getX()) * (obsx3_1.position_x - player.getX()) < obsx3_1.resized_width / 3 * obsx3_1.resized_width / 3) {
            if ((obsx3_1.position_y - player.getY()) * (obsx3_1.position_y - player.getY()) < obsx3_1.resized_height / 3 * obsx3_1.resized_height / 3) {

                return true;
            }
        }

        if ((obsx3_2.position_x - player.getX()) * (obsx3_2.position_x - player.getX()) < obsx3_2.resized_width / 3 * obsx3_2.resized_width / 3) {
            if ((obsx3_2.position_y - player.getY()) * (obsx3_2.position_y - player.getY()) < obsx3_2.resized_height / 3 * obsx3_2.resized_height / 3) {
                return true;
            }
        }

        if ((obsx3_3.position_x - player.getX()) * (obsx3_3.position_x - player.getX()) < obsx3_3.resized_width / 3 * obsx3_3.resized_width / 3) {
            if ((obsx3_3.position_y - player.getY()) * (obsx3_3.position_y - player.getY()) < obsx3_3.resized_height / 3 * obsx3_3.resized_height / 3) {
                return true;
            }
        }

        if ((obsx3_4.position_x - player.getX()) * (obsx3_4.position_x - player.getX()) < obsx3_4.resized_width / 3 * obsx3_4.resized_width / 3) {
            if ((obsx3_4.position_y - player.getY()) * (obsx3_4.position_y - player.getY()) < obsx3_4.resized_height / 3 * obsx3_4.resized_height / 3) {
                return true;
            }
        }

        if ((obsx3_5.position_x - player.getX()) * (obsx3_5.position_x - player.getX()) < obsx3_5.resized_width / 3 * obsx3_5.resized_width / 3) {
            if ((obsx3_5.position_y - player.getY()) * (obsx3_5.position_y - player.getY()) < obsx3_5.resized_height / 3 * obsx3_5.resized_height / 3) {
                return true;
            }
        }

        if ((obsx3_6.position_x - player.getX()) * (obsx3_6.position_x - player.getX()) < obsx3_6.resized_width / 3 * obsx3_6.resized_width / 3) {
            if ((obsx3_6.position_y - player.getY()) * (obsx3_6.position_y - player.getY()) < obsx3_6.resized_height / 3 * obsx3_6.resized_height / 3) {
                return true;
            }
        }

        if ((obsx3_7.position_x - player.getX()) * (obsx3_7.position_x - player.getX()) < obsx3_7.resized_width / 3 * obsx3_7.resized_width / 3) {
            if ((obsx3_7.position_y - player.getY()) * (obsx3_7.position_y - player.getY()) < obsx3_7.resized_height / 3 * obsx3_7.resized_height / 3) {

                return true;
            }
        }


        if ((obs1.position_x - player.getX()) * (obs1.position_x - player.getX()) < obs1.resized_width / 3 * obs1.resized_width / 3) {
            if ((obs1.position_y - player.getY()) * (obs1.position_y - player.getY()) < obs1.resized_height / 3 * obs1.resized_height / 3) {
                return true;
            }
        }

        if ((obs_1_1.position_x - player.getX()) * (obs_1_1.position_x - player.getX()) < obs_1_1.resized_width / 3 * obs_1_1.resized_width / 3) {
            if ((obs_1_1.position_y - player.getY()) * (obs_1_1.position_y - player.getY()) < obs_1_1.resized_height / 3 * obs_1_1.resized_height / 3) {
                return true;
            }
        }

        if ((obs_2_1.position_x - player.getX()) * (obs_2_1.position_x - player.getX()) < obs_2_1.resized_width / 3 * obs_2_1.resized_width / 3) {
            if ((obs_2_1.position_y - player.getY()) * (obs_2_1.position_y - player.getY()) < obs_2_1.resized_height / 3 * obs_2_1.resized_height / 3) {
                return true;
            }
        }

        if ((obs_3_1.position_x - player.getX()) * (obs_3_1.position_x - player.getX()) < obs_3_1.resized_width / 3 * obs_3_1.resized_width / 3) {
            if ((obs_3_1.position_y - player.getY()) * (obs_3_1.position_y - player.getY()) < obs_3_1.resized_width / 3 * obs_3_1.resized_width / 3) {
                return true;
            }
        }

        if ((obs_4_1.position_x - player.getX()) * (obs_4_1.position_x - player.getX()) < obs_4_1.resized_width / 3 * obs_4_1.resized_width / 3) {
            if ((obs_4_1.position_y - player.getY()) * (obs_4_1.position_y - player.getY()) < obs_4_1.resized_height / 3 * obs_4_1.resized_height / 3) {
                return true;
            }
        }

        if ((obs_5_1.position_x - player.getX()) * (obs_5_1.position_x - player.getX()) < obs_5_1.resized_width / 3 * obs_5_1.resized_width / 3) {
            if ((obs_5_1.position_y - player.getY()) * (obs_5_1.position_y - player.getY()) < obs_5_1.resized_height / 3 * obs_5_1.resized_height / 3) {
                return true;
            }
        }

        if ((obs_6_1.position_x + obs_6_1.resized_width / 4 - player.getX()) * (obs_6_1.position_x + obs_6_1.resized_width / 4 - player.getX()) < obs_6_1.resized_width / 3 * obs_6_1.resized_width / 3) {
            if ((obs_6_1.position_y + obs_6_1.resized_height / 4 - player.getY()) * (obs_6_1.position_y + obs_6_1.resized_height / 4 - player.getY()) < obs_6_1.resized_height / 3 * obs_6_1.resized_height / 3) {
                return true;
            }
        }

        if ((obs_7_1.position_x - player.getX()) * (obs_7_1.position_x - player.getX()) < obs_7_1.resized_width / 3 * obs_7_1.resized_width / 3) {
            if ((obs_7_1.position_y - player.getY()) * (obs_7_1.position_y - player.getY()) < obs_7_1.resized_height / 3 * obs_7_1.resized_height / 3) {
                return true;
            }
        }

        if ((obs1x2.position_x - player.getX()) * (obs1x2.position_x - player.getX()) < obs1x2.resized_width / 3 * obs1x2.resized_width / 3) {
            if ((obs1x2.position_y - player.getY()) * (obs1x2.position_y - player.getY()) < obs1x2.resized_height / 3 * obs1x2.resized_height / 3) {
                return true;
            }
        }

        if ((obsx2_1_1.position_x - player.getX()) * (obsx2_1_1.position_x - player.getX()) < obsx2_1_1.resized_width / 3 * obsx2_1_1.resized_width / 3) {
            if ((obsx2_1_1.position_y - player.getY()) * (obsx2_1_1.position_y - player.getY()) < obsx2_1_1.resized_height / 3 * obsx2_1_1.resized_height / 3) {
                return true;
            }
        }

        if ((obsx2_2_1.position_x - player.getX()) * (obsx2_2_1.position_x - player.getX()) < obsx2_2_1.resized_width / 3 * obsx2_2_1.resized_width / 3) {
            if ((obsx2_2_1.position_y - player.getY()) * (obsx2_2_1.position_y - player.getY()) < obsx2_2_1.resized_height / 3 * obsx2_2_1.resized_height / 3) {
                return true;
            }
        }

        if ((obsx2_3_1.position_x - player.getX()) * (obsx2_3_1.position_x - player.getX()) < obsx2_3_1.resized_width / 3 * obsx2_3_1.resized_width / 3) {
            if ((obsx2_3_1.position_y - player.getY()) * (obsx2_3_1.position_y - player.getY()) < obsx2_3_1.resized_height / 3 * obsx2_3_1.resized_height / 3) {
                return true;
            }
        }

        if ((obsx2_4_1.position_x + obsx2_4_1.resized_width / 4 - player.getX()) * (obsx2_4_1.position_x - player.getX()) < obsx2_4_1.resized_width / 3 * obsx2_4_1.resized_width / 3) {
            if ((obsx2_4_1.position_y + obsx2_4_1.resized_height / 4 - player.getY()) * (obsx2_4_1.position_y - player.getY()) < obsx2_4_1.resized_height / 3 * obsx2_4_1.resized_height / 3) {
                return true;
            }
        }

        if ((obsx2_5_1.position_x + obsx2_5_1.resized_width / 4 - player.getX()) * (obsx2_5_1.position_x + obsx2_5_1.resized_width / 4 - player.getX()) < obsx2_5_1.resized_width / 3 * obsx2_5_1.resized_width / 3) {
            if ((obsx2_5_1.position_y + obsx2_5_1.resized_height / 4 - player.getY()) * (obsx2_5_1.position_y + obsx2_5_1.resized_height / 4 - player.getY()) < obsx2_5_1.resized_height / 3 * obsx2_5_1.resized_height / 3) {
                return true;
            }
        }

        if ((obsx2_6_1.position_x + obsx2_6_1.resized_width / 4 - player.getX()) * (obsx2_6_1.position_x + obsx2_6_1.resized_width / 4 - player.getX()) < obsx2_6_1.resized_width / 3 * obsx2_6_1.resized_width / 3) {
            if ((obsx2_6_1.position_y + obsx2_6_1.resized_height / 4 - player.getY()) * (obsx2_6_1.position_y + obsx2_6_1.resized_height / 4 - player.getY()) < obsx2_6_1.resized_height / 3 * obsx2_6_1.resized_height / 3) {
                return true;
            }
        }

        if ((obsx2_7_1.position_x + obsx2_7_1.resized_width / 4 - player.getX()) * (obsx2_7_1.position_x + obsx2_7_1.resized_width / 4 - player.getX()) < obsx2_7_1.resized_width / 3 * obsx2_7_1.resized_width / 3) {
            if ((obsx2_7_1.position_y + obsx2_7_1.resized_height / 4 - player.getY()) * (obsx2_7_1.position_y + obsx2_7_1.resized_height / 4 - player.getY()) < obsx2_7_1.resized_height / 3 * obsx2_7_1.resized_height / 3) {
                return true;
            }
        }

        if ((obs1x3.position_x - player.getX()) * (obs1x3.position_x + obs1x3.resized_width / 4 - player.getX()) < obs1x3.resized_width / 3 * obs1x3.resized_width / 3) {
            if ((obs1x3.position_y - player.getY()) * (obs1x3.position_y + obs1x3.resized_height / 4 - player.getY()) < obs1x3.resized_height / 3 * obs1x3.resized_height / 3) {

                return true;
            }
        }

        if ((obsx3_1_1.position_x - player.getX()) * (obsx3_1_1.position_x - player.getX()) < obsx3_1_1.resized_width / 3 * obsx3_1_1.resized_width / 3) {
            if ((obsx3_1_1.position_y - player.getY()) * (obsx3_1_1.position_y - player.getY()) < obsx3_1_1.resized_height / 3 * obsx3_1_1.resized_height / 3) {
                return true;
            }
        }

        if ((obsx3_2_1.position_x - player.getX()) * (obsx3_2_1.position_x - player.getX()) < obsx3_2_1.resized_width / 3 * obsx3_2_1.resized_width / 3) {
            if ((obsx3_2_1.position_y - player.getY()) * (obsx3_2_1.position_y - player.getY()) < obsx3_2_1.resized_height / 3 * obsx3_2_1.resized_height / 3) {
                return true;
            }
        }

        if ((obsx3_3_1.position_x - player.getX()) * (obsx3_3_1.position_x - player.getX()) < obsx3_3_1.resized_width / 3 * obsx3_3_1.resized_width / 3) {
            if ((obsx3_3_1.position_y + -player.getY()) * (obsx3_3_1.position_y - player.getY()) < obsx3_3_1.resized_height / 3 * obsx3_3_1.resized_height / 3) {
                return true;
            }
        }

        if ((obsx3_4_1.position_x - player.getX()) * (obsx3_4_1.position_x - player.getX()) < obsx3_4_1.resized_width / 3 * obsx3_4_1.resized_width / 3) {
            if ((obsx3_4_1.position_y - player.getY()) * (obsx3_4_1.position_y - player.getY()) < obsx3_4_1.resized_height / 3 * obsx3_4_1.resized_height / 3) {
                return true;
            }
        }

        if ((obsx3_5_1.position_x - player.getX()) * (obsx3_5_1.position_x - player.getX()) < obsx3_5_1.resized_width / 3 * obsx3_5_1.resized_width / 3) {
            if ((obsx3_5_1.position_y - player.getY()) * (obsx3_5_1.position_y - player.getY()) < obsx3_5_1.resized_height / 3 * obsx3_5_1.resized_height / 3) {
                return true;
            }
        }

        if ((obsx3_6_1.position_x - player.getX()) * (obsx3_6_1.position_x - player.getX()) < obsx3_6_1.resized_width / 3 * obsx3_6_1.resized_width / 3) {
            if ((obsx3_6_1.position_y - player.getY()) * (obsx3_6_1.position_y - player.getY()) < obsx3_6_1.resized_height / 3 * obsx3_6_1.resized_height / 3) {
                return true;
            }
        }

        if ((obsx3_7_1.position_x - player.getX()) * (obsx3_7_1.position_x - player.getX()) < obsx3_7_1.resized_width / 3 * obsx3_7_1.resized_width / 3) {
            if ((obsx3_7_1.position_y - player.getY()) * (obsx3_7_1.position_y - player.getY()) < obsx3_7_1.resized_height / 3 * obsx3_7_1.resized_height / 3) {
                return true;
            }
        }
        return false;
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

    public void obstacle_moving(int x, int y, int z) {
        if (total_time_number >= 0 && health_number < 3) {
            if (pattern[0] == 1) {
                if (obs.position_x >= 280 * size_dm) {
                    obs.position(120 * size_dm, 125 * size_dm);
                    obs.setObstacleAlpha(200);
                } else {
                    obs.setPosition(x, y);
                }
            }

            if (pattern[1] == 1) {
                if (obs_1.position_x >= 267 * size_dm) {
                    obs_1.position(107 * size_dm, 138 * size_dm);
                    obs_1.setObstacleAlpha(200);
                } else {
                    obs_1.setPosition(x, y);
                }
            }

            if (pattern[2] == 1) {
                if (obs_2.position_x >= 254 * size_dm) {
                    obs_2.position(94 * size_dm, 151 * size_dm);
                    obs_2.setObstacleAlpha(200);
                } else {
                    obs_2.setPosition(x, y);
                }
            }

            if (pattern[3] == 1) {
                if (obs_3.position_x >= 241 * size_dm) {
                    obs_3.position(81 * size_dm, 164 * size_dm);
                    obs_3.setObstacleAlpha(200);
                } else {
                    obs_3.setPosition(x, y);
                }
            }

            if (pattern[4] == 1) {
                if (obs_4.position_x >= 228 * size_dm) {
                    obs_4.position(68 * size_dm, 177 * size_dm);
                    obs_4.setObstacleAlpha(200);
                } else {
                    obs_4.setPosition(x, y);
                }
            }

            if (pattern[5] == 1) {
                if (obs_5.position_x >= 215 * size_dm) {
                    obs_5.position(55 * size_dm, 190 * size_dm);
                    obs_5.setObstacleAlpha(200);
                } else {
                    obs_5.setPosition(x, y);
                }
            }

            if (pattern[6] == 1) {
                if (obs_6.position_x >= 202 * size_dm) {
                    obs_6.position(42 * size_dm, 203 * size_dm);
                    obs_6.setObstacleAlpha(200);
                } else {
                    obs_6.setPosition(x, y);
                }
            }

            if (pattern[7] == 1) {
                if (obs_7.position_x >= 189 * size_dm) {
                    obs_7.position(29 * size_dm, 216 * size_dm);
                    obs_7.setObstacleAlpha(200);
                } else {
                    obs_7.setPosition(x, y);
                }
            }

            if (pattern[8] == 1) {
                if (obsx2.position_x >= 280 * size_dm) {
                    obsx2.position(120 * size_dm, 125 * size_dm);
                    obsx2.setObstacleAlpha(200);
                } else {
                    obsx2.setPosition(x, y);
                }
            }

            if (pattern[9] == 1) {
                if (obsx2_1.position_x >= 267 * size_dm) {
                    obsx2_1.position(107 * size_dm, 138 * size_dm);
                    obsx2_1.setObstacleAlpha(200);
                } else {
                    obsx2_1.setPosition(x, y);
                }
            }

            if (pattern[10] == 1) {
                if (obsx2_2.position_x >= 254 * size_dm) {
                    obsx2_2.position(94 * size_dm, 151 * size_dm);
                    obsx2_2.setObstacleAlpha(200);
                } else {
                    obsx2_2.setPosition(x, y);
                }
            }

            if (pattern[11] == 1) {
                if (obsx2_3.position_x >= 241 * size_dm) {
                    obsx2_3.position(81 * size_dm, 164 * size_dm);
                    obsx2_3.setObstacleAlpha(200);
                } else {
                    obsx2_3.setPosition(x, y);
                }
            }

            if (pattern[12] == 1) {
                if (obsx2_4.position_x >= 228 * size_dm) {
                    obsx2_4.position(68 * size_dm, 177 * size_dm);
                    obsx2_4.setObstacleAlpha(200);
                } else {
                    obsx2_4.setPosition(x, y);
                }
            }

            if (pattern[13] == 1) {
                if (obsx2_5.position_x >= 215 * size_dm) {
                    obsx2_5.position(55 * size_dm, 190 * size_dm);
                    obsx2_5.setObstacleAlpha(200);
                } else {
                    obsx2_5.setPosition(x, y);
                }
            }

            if (pattern[14] == 1) {
                if (obsx2_6.position_x >= 202 * size_dm) {
                    obsx2_6.position(42 * size_dm, 203 * size_dm);
                    obsx2_6.setObstacleAlpha(200);
                } else {
                    obsx2_6.setPosition(x, y);
                }
            }

            if (pattern[15] == 1) {
                if (obsx2_7.position_x >= 189 * size_dm) {
                    obsx2_7.position(29 * size_dm, 216 * size_dm);
                    obsx2_7.setObstacleAlpha(200);
                } else {
                    obsx2_7.setPosition(x, y);
                }
            }

            if (pattern[16] == 1) {
                if (obsx3.position_x >= 280 * size_dm) {
                    obsx3.position(120 * size_dm, 125 * size_dm);
                    obsx3.setObstacleAlpha(200);
                } else {
                    obsx3.setPosition(x, y);
                }
            }

            if (pattern[17] == 1) {
                if (obsx3_1.position_x >= 267 * size_dm) {
                    obsx3_1.position(107 * size_dm, 138 * size_dm);
                    obsx3_1.setObstacleAlpha(200);
                } else {
                    obsx3_1.setPosition(x, y);
                }
            }

            if (pattern[18] == 1) {
                if (obsx3_2.position_x >= 254 * size_dm) {
                    obsx3_2.position(94 * size_dm, 151 * size_dm);
                    obsx3_2.setObstacleAlpha(200);
                } else {
                    obsx3_2.setPosition(x, y);
                }
            }

            if (pattern[19] == 1) {
                if (obsx3_3.position_x >= 241 * size_dm) {
                    obsx3_3.position(81 * size_dm, 164 * size_dm);
                    obsx3_3.setObstacleAlpha(200);
                } else {
                    obsx3_3.setPosition(x, y);
                }
            }

            if (pattern[20] == 1) {
                if (obsx3_4.position_x >= 228 * size_dm) {
                    obsx3_4.position(68 * size_dm, 177 * size_dm);
                    obsx3_4.setObstacleAlpha(200);
                } else {
                    obsx3_4.setPosition(x, y);
                }
            }

            if (pattern[21] == 1) {
                if (obsx3_5.position_x >= 215 * size_dm) {
                    obsx3_5.position(55 * size_dm, 190 * size_dm);
                    obsx3_5.setObstacleAlpha(200);
                } else {
                    obsx3_5.setPosition(x, y);
                }
            }

            if (pattern[22] == 1) {
                if (obsx3_6.position_x >= 202 * size_dm) {
                    obsx3_6.position(42 * size_dm, 203 * size_dm);
                    obsx3_6.setObstacleAlpha(200);
                } else {
                    obsx3_6.setPosition(x, y);
                }
            }

            if (pattern[23] == 1) {
                if (obsx3_7.position_x >= 189 * size_dm) {
                    obsx3_7.position(29 * size_dm, 216 * size_dm);
                    obsx3_7.setObstacleAlpha(200);
                } else {
                    obsx3_7.setPosition(x, y);
                }
            }
        }
    }

    public void obstacle_2_moving(int x, int y, int z) {
        if (total_time_number >= 0 && health_number < 3) {
            if (pattern[24] == 1) {
                if (obs1.position_x <= 29 * size_dm) {
                    obs1.position(189 * size_dm, 125 * size_dm);
                    obs1.setObstacleAlpha(200);
                } else {
                    obs1.setPosition(x, y);
                }
            }

            if (pattern[25] == 1) {
                if (obs_1_1.position_x <= 42 * size_dm) {
                    obs_1_1.position(202 * size_dm, 138 * size_dm);
                    obs_1_1.setObstacleAlpha(200);
                } else {
                    obs_1_1.setPosition(x, y);
                }
            }

            if (pattern[26] == 1) {
                if (obs_2_1.position_x <= 55 * size_dm) {
                    obs_2_1.position(215 * size_dm, 151 * size_dm);
                    obs_2_1.setObstacleAlpha(200);
                } else {
                    obs_2_1.setPosition(x, y);
                }
            }

            if (pattern[27] == 1) {
                if (obs_3_1.position_x <= 68 * size_dm) {
                    obs_3_1.position(228 * size_dm, 164 * size_dm);
                    obs_3_1.setObstacleAlpha(200);
                } else {
                    obs_3_1.setPosition(x, y);
                }
            }

            if (pattern[28] == 1) {
                if (obs_4_1.position_x <= 81 * size_dm) {
                    obs_4_1.position(241 * size_dm, 177 * size_dm);
                    obs_4_1.setObstacleAlpha(200);
                } else {
                    obs_4_1.setPosition(x, y);
                }
            }

            if (pattern[29] == 1) {
                if (obs_5_1.position_x <= 94 * size_dm) {
                    obs_5_1.position(254 * size_dm, 190 * size_dm);
                    obs_5_1.setObstacleAlpha(200);
                } else {
                    obs_5_1.setPosition(x, y);
                }
            }

            if (pattern[30] == 1) {
                if (obs_6_1.position_x <= 107 * size_dm) {
                    obs_6_1.position(267 * size_dm, 203 * size_dm);
                    obs_6_1.setObstacleAlpha(200);
                } else {
                    obs_6_1.setPosition(x, y);
                }
            }

            if (pattern[31] == 1) {
                if (obs_7_1.position_x <= 120 * size_dm) {
                    obs_7_1.position(280 * size_dm, 216 * size_dm);
                    obs_7_1.setObstacleAlpha(200);
                } else {
                    obs_7_1.setPosition(x, y);
                }
            }

            if (pattern[32] == 1) {
                if (obs1x2.position_x <= 29 * size_dm) {
                    obs1x2.position(189 * size_dm, 125 * size_dm);
                    obs1x2.setObstacleAlpha(200);
                } else {
                    obs1x2.setPosition(x, y);
                }
            }

            if (pattern[33] == 1) {
                if (obsx2_1_1.position_x <= 42 * size_dm) {
                    obsx2_1_1.position(202 * size_dm, 138 * size_dm);
                    obsx2_1_1.setObstacleAlpha(200);
                } else {
                    obsx2_1_1.setPosition(x, y);
                }
            }

            if (pattern[34] == 1) {
                if (obsx2_2_1.position_x <= 55 * size_dm) {
                    obsx2_2_1.position(215 * size_dm, 151 * size_dm);
                    obsx2_2_1.setObstacleAlpha(200);
                } else {
                    obsx2_2_1.setPosition(x, y);
                }
            }

            if (pattern[35] == 1) {
                if (obsx2_3_1.position_x <= 68 * size_dm) {
                    obsx2_3_1.position(228 * size_dm, 164 * size_dm);
                    obsx2_3_1.setObstacleAlpha(200);
                } else {
                    obsx2_3_1.setPosition(x, y);
                }
            }

            if (pattern[36] == 1) {
                if (obsx2_4_1.position_x <= 81 * size_dm) {
                    obsx2_4_1.position(241 * size_dm, 177 * size_dm);
                    obsx2_4_1.setObstacleAlpha(200);
                } else {
                    obsx2_4_1.setPosition(x, y);
                }
            }

            if (pattern[37] == 1) {
                if (obsx2_5_1.position_x <= 94 * size_dm) {
                    obsx2_5_1.position(254 * size_dm, 190 * size_dm);
                    obsx2_5_1.setObstacleAlpha(200);
                } else {
                    obsx2_5_1.setPosition(x, y);
                }
            }

            if (pattern[38] == 1) {
                if (obsx2_6_1.position_x <= 107 * size_dm) {
                    obsx2_6_1.position(267 * size_dm, 203 * size_dm);
                    obsx2_6_1.setObstacleAlpha(200);
                } else {
                    obsx2_6_1.setPosition(x, y);
                }
            }

            if (pattern[39] == 1) {
                if (obsx2_7_1.position_x <= 120 * size_dm) {
                    obsx2_7_1.position(280 * size_dm, 216 * size_dm);
                    obsx2_7_1.setObstacleAlpha(200);
                } else {
                    obsx2_7_1.setPosition(x, y);
                }
            }

            if (pattern[40] == 1) {
                if (obs1x3.position_x <= 29 * size_dm) {
                    obs1x3.position(189 * size_dm, 125 * size_dm);
                    obs1x3.setObstacleAlpha(200);
                } else {
                    obs1x3.setPosition(x, y);
                }
            }

            if (pattern[41] == 1) {
                if (obsx3_1_1.position_x <= 42 * size_dm) {
                    obsx3_1_1.position(202 * size_dm, 138 * size_dm);
                    obsx3_1_1.setObstacleAlpha(200);
                } else {
                    obsx3_1_1.setPosition(x, y);
                }
            }

            if (pattern[42] == 1) {
                if (obsx3_2_1.position_x <= 55 * size_dm) {
                    obsx3_2_1.position(215 * size_dm, 151 * size_dm);
                    obsx3_2_1.setObstacleAlpha(200);
                } else {
                    obsx3_2_1.setPosition(x, y);
                }
            }

            if (pattern[43] == 1) {
                if (obsx3_3_1.position_x <= 68 * size_dm) {
                    obsx3_3_1.position(228 * size_dm, 164 * size_dm);
                    obsx3_3_1.setObstacleAlpha(200);
                } else {
                    obsx3_3_1.setPosition(x, y);
                }
            }

            if (pattern[44] == 1) {
                if (obsx3_4_1.position_x <= 81 * size_dm) {
                    obsx3_4_1.position(241 * size_dm, 177 * size_dm);
                    obsx3_4_1.setObstacleAlpha(200);
                } else {
                    obsx3_4_1.setPosition(x, y);
                }
            }

            if (pattern[45] == 1) {
                if (obsx3_5_1.position_x <= 94 * size_dm) {
                    obsx3_5_1.position(254 * size_dm, 190 * size_dm);
                    obsx3_5_1.setObstacleAlpha(200);
                } else {
                    obsx3_5_1.setPosition(x, y);
                }
            }

            if (pattern[46] == 1) {
                if (obsx3_6_1.position_x <= 107 * size_dm) {
                    obsx3_6_1.position(267 * size_dm, 203 * size_dm);
                    obsx3_6_1.setObstacleAlpha(200);
                } else {
                    obsx3_6_1.setPosition(x, y);
                }
            }

            if (pattern[47] == 1) {
                if (obsx3_7_1.position_x <= 120 * size_dm) {
                    obsx3_7_1.position(280 * size_dm, 216 * size_dm);
                    obsx3_7_1.setObstacleAlpha(200);
                } else {
                    obsx3_7_1.setPosition(x, y);
                }
            }
        }
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

    @Override
    protected void onDestroy() {
        Drawable t = tile1_1.getDrawable();
        Drawable t31 = tile1_32.getDrawable();
        Drawable t_13 = tile2_13.getDrawable();
        Drawable t_20 = tile2_20.getDrawable();

        Drawable h1 = heart1.getDrawable();
        Drawable h2 = heart2.getDrawable();
        Drawable h3 = heart3.getDrawable();

        if (t instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t.setCallback(null);

        if (t31 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t31).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t31.setCallback(null);

        if (t_13 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t_13).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_13.setCallback(null);

        if (t_20 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) t_20).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t_20.setCallback(null);


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

        obs.empty();
        obs_1.empty();
        obs_2.empty();
        obs_3.empty();
        obs_4.empty();
        obs_5.empty();
        obs_6.empty();
        obs_7.empty();
        obsx2.empty();
        obsx2_1.empty();
        obsx2_2.empty();
        obsx2_3.empty();
        obsx2_4.empty();
        obsx2_5.empty();
        obsx2_6.empty();
        obsx2_7.empty();
        obsx3.empty();
        obsx3_1.empty();
        obsx3_2.empty();
        obsx3_3.empty();
        obsx3_4.empty();
        obsx3_5.empty();
        obsx3_6.empty();
        obsx3_7.empty();

        obs1.empty();
        obs_1_1.empty();
        obs_2_1.empty();
        obs_3_1.empty();
        obs_4_1.empty();
        obs_5_1.empty();
        obs_6_1.empty();
        obs_7_1.empty();
        obs1x2.empty();
        obsx2_1_1.empty();
        obsx2_2_1.empty();
        obsx2_3_1.empty();
        obsx2_4_1.empty();
        obsx2_5_1.empty();
        obsx2_6_1.empty();
        obsx2_7_1.empty();
        obs1x3.empty();
        obsx3_1_1.empty();
        obsx3_2_1.empty();
        obsx3_3_1.empty();
        obsx3_4_1.empty();
        obsx3_5_1.empty();
        obsx3_6_1.empty();
        obsx3_7_1.empty();

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
