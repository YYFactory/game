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
 * Created by user on 2017-07-10.
 */

public class game8 extends AppCompatActivity{

    private int tile_end_x1, tile_end_y1;
    private int tile_end_x2, tile_end_y2;
    private int tile_end_x3, tile_end_y3;
    private int tile_end_x4, tile_end_y4;
    private int prior_player_x, prior_player_y;
    private int SpeedX, SpeedY;
    private int timing_number = 0, total_time_number = 50, health_timing_number = 0, level_time_number=0;
    private int pattern_number=0, health_number = 0, pattern2_number=0;
    private int pattern_speed_number[]= {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                            0, 0, 0};

    private int three_SpeedX = 2, three_SpeedY = 0;
    private int two_SpeedX = 2, two_SpeedY = -1;
    private int three_two_SpeedX = 2, three_two_SpeedY = -2;
    private int one_SpeedX = 1, one_SpeedY = -2;
    private int twelve_SpeedX = 0, twelve_SpeedY = -2;
    private int eleven_SpeedX = -1, eleven_SpeedY = -2;
    private int eleven_ten_SpeedX = -2, eleven_ten_SpeedY = -2;
    private int ten_SpeedX = -2, ten_SpeedY = -1;
    private int nine_SpeedX = -2, nine_SpeedY = 0;
    private int eight_SpeedX = -2, eight_SpeedY = 1;
    private int eight_seven_SpeedX = -2, eight_seven_SpeedY = 2;
    private int seven_SpeedX = -1, seven_SpeedY = 2;
    private int six_SpeedX = 0, six_SpeedY = 2;
    private int five_SpeedX = 1, five_SpeedY = 2;
    private int five_four_SpeedX = 2, five_four_SpeedY = 2;
    private int four_SpeedX = 2, four_SpeedY = 1;
    private int score_total;
    ////////////////////////////////////////////////////////////////////////////////////

    private int frameHeight;
    private int size_dm;

    private int pattern[]={0};
    private int pattern2[]={0, 0};
    private int pattern4[]={0, 0, 0, 0};
    private int pattern8[]={0, 0, 0, 0, 0, 0, 0, 0};
    private int pattern16[]={0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                0, 0, 0, 0, 0, 0};
    private int pattern32[]={0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                0, 0};

    private int pattern_speed[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                        0, 0, 0, 0, 0, 0};

    private int resource_number[] = {R.id.tile1_1, R.id.tile1_2, R.id.tile1_3, R.id.tile1_4, R.id.tile1_5, R.id.tile1_6, R.id.tile1_7, R.id.tile1_8, R.id.tile1_9, R.id.tile1_10,
            R.id.tile1_11, R.id.tile1_12, R.id.tile1_13, R.id.tile1_14, R.id.tile1_15, R.id.tile1_16, R.id.tile1_17, R.id.tile1_18, R.id.tile1_19, R.id.tile1_20,
            R.id.tile1_21, R.id.tile1_22, R.id.tile1_23, R.id.tile1_24, R.id.tile1_25, R.id.tile1_26, R.id.tile1_27, R.id.tile1_28, R.id.tile1_29, R.id.tile1_30,
            R.id.tile1_31, R.id.tile1_32, R.id.tile2_1, R.id.tile2_2, R.id.tile2_3, R.id.tile2_4, R.id.tile2_5, R.id.tile2_6, R.id.tile2_7, R.id.tile2_8, R.id.tile2_9, R.id.tile2_10,
            R.id.tile2_11, R.id.tile2_12, R.id.tile2_13, R.id.tile2_14, R.id.tile2_15, R.id.tile2_16, R.id.tile2_17, R.id.tile2_18, R.id.tile2_19, R.id.tile2_20,
            R.id.tile2_21, R.id.tile2_22, R.id.tile2_23, R.id.tile2_24, R.id.tile2_25, R.id.tile2_26, R.id.tile2_27, R.id.tile2_28, R.id.tile2_29, R.id.tile2_30,
            R.id.tile2_31, R.id.tile2_32};

    private TextView score, score_number, time, time_number, life;
    private boolean Isdamaged_player;
    private boolean stun_player = false;
    private boolean action_flg = false;
    private boolean start_flg = false;

    private Handler handler = new Handler();
    private Timer timer = new Timer();
    private ImageView player;

    private RelativeLayout layout_joystick;
    private RelativeLayout gameview8;
    private ImageView tile, tile45, tile52, tile32;
    private ImageView heart1, heart2, heart3;

    ObstacleClass obstacle[]= new ObstacleClass[1];
    ObstacleClass obstacle2[]= new ObstacleClass[2];
    ObstacleClass obstacle4[]= new ObstacleClass[4];
    ObstacleClass obstacle8[]= new ObstacleClass[8];
    ObstacleClass obstacle16[]= new ObstacleClass[16];
    ObstacleClass obstacle32[]= new ObstacleClass[32];

    JoyStickClass js;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameview8);

        DisplayMetrics dm = getResources().getDisplayMetrics();
        size_dm = Math.round(dm.density);

        score_number = (TextView) findViewById(R.id.score_number);
        time_number = (TextView) findViewById(R.id.time_number);

        WindowManager wm = getWindowManager();
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);

        layout_joystick = (RelativeLayout) findViewById(R.id.layout_joystick);
        gameview8 = (RelativeLayout) findViewById(R.id.gameview8);

        js = new JoyStickClass(getApplicationContext(), layout_joystick, R.drawable.center);
        js.setStickSize(30*size_dm, 30*size_dm);
        js.setLayoutSize(100*size_dm, 100*size_dm);
        js.setLayoutAlpha(50);
        js.setStickAlpha(50);
        js.setOffset(15*size_dm);
        js.setMinimumDistance(1*size_dm);

        js.initial_draw(50*size_dm, 50*size_dm);

        heart1 = (ImageView) findViewById(R.id.heart1);
        heart2 = (ImageView) findViewById(R.id.heart2);
        heart3 = (ImageView) findViewById(R.id.heart3);
        player = (ImageView) findViewById(R.id.player);

        tile = (ImageView) findViewById(R.id.tile1_1);
        tile32 = (ImageView) findViewById(R.id.tile1_32);
        tile45 = (ImageView) findViewById(R.id.tile2_13);
        tile52 = (ImageView) findViewById(R.id.tile2_20);


        obstacle[0] = new ObstacleClass(getApplicationContext(), gameview8, R.drawable.enemy3);
        obstacle[0].position(100*size_dm, 100*size_dm);
        obstacle[0].resized_image(100*size_dm, 100*size_dm);
        obstacle[0].setObstacleAlpha(220);
///////////////////////////////////////////////////////////////////////////////////////////////////////
      for(int i=0; i<2; i++) {
          obstacle2[i] = new ObstacleClass(getApplicationContext(), gameview8, R.drawable.enemy3);
          obstacle2[i].position(100 * size_dm, 100 * size_dm);
          obstacle2[i].resized_image(90 * size_dm, 90 * size_dm);
          obstacle2[i].setObstacleAlpha(220);
      }
////////////////////////////////////////////////////////////////////////////////////////////////////////
        for(int i=0; i<4; i++) {
            obstacle4[i] = new ObstacleClass(getApplicationContext(), gameview8, R.drawable.enemy3);
            obstacle4[i].position(100 * size_dm, 100 * size_dm);
            obstacle4[i].resized_image(80 * size_dm, 80 * size_dm);
            obstacle4[i].setObstacleAlpha(220);
        }
///////////////////////////////////////////////////////////////////////////////////////////////////////////
        for(int i=0; i<8; i++) {
            obstacle8[i] = new ObstacleClass(getApplicationContext(), gameview8, R.drawable.enemy3);
            obstacle8[i].position(100 * size_dm, 100 * size_dm);
            obstacle8[i].resized_image(70 * size_dm, 70 * size_dm);
            obstacle8[i].setObstacleAlpha(220);
        }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        for(int i=0; i<16; i++) {
            obstacle16[i] = new ObstacleClass(getApplicationContext(), gameview8, R.drawable.enemy3);
            obstacle16[i].position(100 * size_dm, 100 * size_dm);
            obstacle16[i].resized_image(50 * size_dm, 50 * size_dm);
            obstacle16[i].setObstacleAlpha(220);
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        for(int i=0; i<32; i++) {
            obstacle32[i] = new ObstacleClass(getApplicationContext(), gameview8, R.drawable.enemy3);
            obstacle32[i].position(100 * size_dm, 100 * size_dm);
            obstacle32[i].resized_image(40 * size_dm, 40 * size_dm);
            obstacle32[i].setObstacleAlpha(220);
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //더 넣을지 안 넣을지는 막 테스트때 하자.
        for(int i=0; i<62; i++)
        {
            pattern_speed_number[i] = getRandomMath8(15, 0);
        }

        score_total = getIntent().getIntExtra("SCORE", 0);
        score_number.setText(score_total + "");

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
                                                Intent intent = new Intent(getApplicationContext(), Main9.class);
                                                intent.putExtra("SCORE", score_total);
                                                startActivity(intent);
                                            }catch(Exception e)
                                            {
                                                Intent intent = new Intent(getApplicationContext(), Main9.class);
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

                                        if (level_time_number <= 200) {
                                            pattern_number = getRandomMath8(0, 0);
                                            pattern[pattern_number] = 1;
                                        } else if ((level_time_number <= 500 && level_time_number > 200 )) {
                                            pattern[0] = 0;
                                            pattern_number = getRandomMath8(1, 0);
                                            pattern2[pattern_number] = 1;
                                        } else if ((level_time_number <= 800 && level_time_number > 500)) {
                                            for(int i=0; i<2; i++)
                                            {
                                                pattern2[i] = 0;
                                            }
                                            pattern_number = getRandomMath8(3, 0);
                                            pattern4[pattern_number] = 1;
                                        } else if ((level_time_number <= 1200 && level_time_number > 800) ) {
                                            for(int i=0; i<4; i++)
                                            {
                                                pattern4[i] = 0;
                                            }
                                            pattern_number = getRandomMath8(7, 0);
                                            pattern8[pattern_number] = 1;
                                        } else if ((level_time_number <= 1800 && level_time_number > 1200)) {
                                            for(int i=0; i<8; i++)
                                            {
                                                pattern8[i] = 0;
                                            }
                                            pattern_number = getRandomMath8(15, 0);
                                            pattern16[pattern_number] = 1;
                                        } else if ((level_time_number <= 5000 && level_time_number > 1800)) {
                                            for(int i=0; i<16; i++)
                                            {
                                                pattern16[i] = 0;
                                            }
                                            pattern_number = getRandomMath8(31, 0);
                                            pattern32[pattern_number] = 1;
                                        } else
                                        {
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

                                        obstacle_moving();
                                        obstacle_moving2();
                                        obstacle_moving3();
                                        //obstacle_2_moving(obstacle_2_SpeedX, obstacle_2_SpeedY, pattern_number);
                                        //obstacle_3_moving(obstacle_3_SpeedX, obstacle_3_SpeedY, pattern_number);
                                        player_moving(SpeedX, SpeedY, action_flg);

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

    void obstacle_moving3()
    {
        if(pattern32[0] == 1)
        {
            if(obstacle32[0].position_x  >= 300*size_dm || obstacle32[0].position_x  <= 10*size_dm || obstacle32[0].position_y <= 90*size_dm ||  obstacle32[0].position_y >=350*size_dm)
            {
                pattern_speed_number[31] = getRandomMath8(15, 0);
                obstacle32[0].setObstacleAlpha(200);
                if(pattern_speed_number[31] == 0)
                {
                    obstacle32[0].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[31] == 1)
                {
                    obstacle32[0].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[31] == 2)
                {
                    obstacle32[0].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[31] == 3)
                {
                    obstacle32[0].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[31] == 4)
                {
                    obstacle32[0].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[31] == 5)
                {
                    obstacle32[0].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[31] == 6)
                {
                    obstacle32[0].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[31] == 7)
                {
                    obstacle32[0].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[31] == 8)
                {
                    obstacle32[0].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[31] == 9)
                {
                    obstacle32[0].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[31] == 10)
                {
                    obstacle32[0].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[31] == 11)
                {
                    obstacle32[0].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[31] == 12)
                {
                    obstacle32[0].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[31] == 13)
                {
                    obstacle32[0].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[31] == 14)
                {
                    obstacle32[0].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[31] == 15)
                {
                    obstacle32[0].setPosition(four_SpeedX , four_SpeedY);
                }
            }
            else
            {
                obstacle32[0].setObstacleAlpha(200);
                if(pattern_speed_number[31] == 0)
                {
                    obstacle32[0].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[31] == 1)
                {
                    obstacle32[0].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[31] == 2)
                {
                    obstacle32[0].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[31] == 3)
                {
                    obstacle32[0].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[31] == 4)
                {
                    obstacle32[0].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[31] == 5)
                {
                    obstacle32[0].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[31] == 6)
                {
                    obstacle32[0].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[31] == 7)
                {
                    obstacle32[0].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[31] == 8)
                {
                    obstacle32[0].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[31] == 9)
                {
                    obstacle32[0].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[31] == 10)
                {
                    obstacle32[0].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[31] == 11)
                {
                    obstacle32[0].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[31] == 12)
                {
                    obstacle32[0].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[31] == 13)
                {
                    obstacle32[0].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[31] == 14)
                {
                    obstacle32[0].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[31] == 15)
                {
                    obstacle32[0].setPosition(four_SpeedX , four_SpeedY);
                }
            }
        }
        else
        {
            obstacle32[0].setObstacleAlpha(0);
            obstacle32[0].position_effect();
        }

        if(pattern32[1] == 1)
        {
            if(obstacle32[1].position_x  >= 300*size_dm || obstacle32[1].position_x  <= 10*size_dm || obstacle32[1].position_y <= 90*size_dm ||  obstacle32[1].position_y >=350*size_dm)
            {
                pattern_speed_number[32] = getRandomMath8(15, 0);
                obstacle32[1].setObstacleAlpha(200);
                if(pattern_speed_number[32] == 0)
                {
                    obstacle32[1].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[32] == 1)
                {
                    obstacle32[1].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[32] == 2)
                {
                    obstacle32[1].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[32] == 3)
                {
                    obstacle32[1].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[32] == 4)
                {
                    obstacle32[1].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[32] == 5)
                {
                    obstacle32[1].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[32] == 6)
                {
                    obstacle32[1].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[32] == 7)
                {
                    obstacle32[1].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[32] == 8)
                {
                    obstacle32[1].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[32] == 9)
                {
                    obstacle32[1].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[32] == 10)
                {
                    obstacle32[1].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[32] == 11)
                {
                    obstacle32[1].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[32] == 12)
                {
                    obstacle32[1].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[32] == 13)
                {
                    obstacle32[1].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[32] == 14)
                {
                    obstacle32[1].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[32] == 15)
                {
                    obstacle32[1].setPosition(four_SpeedX , four_SpeedY);
                }
            }
            else
            {
                obstacle32[1].setObstacleAlpha(200);
                if(pattern_speed_number[32] == 0)
                {
                    obstacle32[1].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[32] == 1)
                {
                    obstacle32[1].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[32] == 2)
                {
                    obstacle32[1].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[32] == 3)
                {
                    obstacle32[1].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[32] == 4)
                {
                    obstacle32[1].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[32] == 5)
                {
                    obstacle32[1].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[32] == 6)
                {
                    obstacle32[1].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[32] == 7)
                {
                    obstacle32[1].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[32] == 8)
                {
                    obstacle32[1].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[32] == 9)
                {
                    obstacle32[1].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[32] == 10)
                {
                    obstacle32[1].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[32] == 11)
                {
                    obstacle32[1].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[32] == 12)
                {
                    obstacle32[1].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[32] == 13)
                {
                    obstacle32[1].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[32] == 14)
                {
                    obstacle32[1].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[32] == 15)
                {
                    obstacle32[1].setPosition(four_SpeedX , four_SpeedY);
                }
            }
        }
        else
        {
            obstacle32[1].setObstacleAlpha(0);
            obstacle32[1].position_effect();
        }

        if(pattern32[2] == 1)
        {
            if(obstacle32[2].position_x  >= 300*size_dm || obstacle32[2].position_x  <= 10*size_dm || obstacle32[2].position_y <= 90*size_dm ||  obstacle32[2].position_y >=350*size_dm)
            {
                pattern_speed_number[33] = getRandomMath8(15, 0);
                obstacle32[2].setObstacleAlpha(200);
                if(pattern_speed_number[33] == 0)
                {
                    obstacle32[2].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[33] == 1)
                {
                    obstacle32[2].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[33] == 2)
                {
                    obstacle32[2].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[33] == 3)
                {
                    obstacle32[2].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[33] == 4)
                {
                    obstacle32[2].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[33] == 5)
                {
                    obstacle32[2].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[33] == 6)
                {
                    obstacle32[2].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[33] == 7)
                {
                    obstacle32[2].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[33] == 8)
                {
                    obstacle32[2].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[33] == 9)
                {
                    obstacle32[2].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[33] == 10)
                {
                    obstacle32[2].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[33] == 11)
                {
                    obstacle32[2].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[33] == 12)
                {
                    obstacle32[2].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[33] == 13)
                {
                    obstacle32[2].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[33] == 14)
                {
                    obstacle32[2].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[33] == 15)
                {
                    obstacle32[2].setPosition(four_SpeedX , four_SpeedY);
                }
            }
            else
            {
                obstacle32[2].setObstacleAlpha(200);
                if(pattern_speed_number[33] == 0)
                {
                    obstacle32[2].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[33] == 1)
                {
                    obstacle32[2].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[33] == 2)
                {
                    obstacle32[2].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[33] == 3)
                {
                    obstacle32[2].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[33] == 4)
                {
                    obstacle32[2].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[33] == 5)
                {
                    obstacle32[2].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[33] == 6)
                {
                    obstacle32[2].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[33] == 7)
                {
                    obstacle32[2].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[33] == 8)
                {
                    obstacle32[2].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[33] == 9)
                {
                    obstacle32[2].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[33] == 10)
                {
                    obstacle32[2].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[33] == 11)
                {
                    obstacle32[2].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[33] == 12)
                {
                    obstacle32[2].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[33] == 13)
                {
                    obstacle32[2].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[33] == 14)
                {
                    obstacle32[2].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[33] == 15)
                {
                    obstacle32[2].setPosition(four_SpeedX , four_SpeedY);
                }
            }
        }
        else
        {
            obstacle32[2].setObstacleAlpha(0);
            obstacle32[2].position_effect();
        }

        if(pattern32[3] == 1)
        {
            if(obstacle32[3].position_x  >= 300*size_dm || obstacle32[3].position_x  <= 10*size_dm || obstacle32[3].position_y <= 90*size_dm ||  obstacle32[3].position_y >=350*size_dm)
            {
                pattern_speed_number[34] = getRandomMath8(15, 0);
                obstacle32[3].setObstacleAlpha(200);
                if(pattern_speed_number[34] == 0)
                {
                    obstacle32[3].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[34] == 1)
                {
                    obstacle32[3].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[34] == 2)
                {
                    obstacle32[3].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[34] == 3)
                {
                    obstacle32[3].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[34] == 4)
                {
                    obstacle32[3].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[34] == 5)
                {
                    obstacle32[3].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[34] == 6)
                {
                    obstacle32[3].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[34] == 7)
                {
                    obstacle32[3].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[34] == 8)
                {
                    obstacle32[3].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[34] == 9)
                {
                    obstacle32[3].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[34] == 10)
                {
                    obstacle32[3].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[34] == 11)
                {
                    obstacle32[3].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[34] == 12)
                {
                    obstacle32[3].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[34] == 13)
                {
                    obstacle32[3].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[34] == 14)
                {
                    obstacle32[3].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[34] == 15)
                {
                    obstacle32[3].setPosition(four_SpeedX , four_SpeedY);
                }
            }
            else
            {
                obstacle32[3].setObstacleAlpha(200);
                if(pattern_speed_number[34] == 0)
                {
                    obstacle32[3].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[34] == 1)
                {
                    obstacle32[3].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[34] == 2)
                {
                    obstacle32[3].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[34] == 3)
                {
                    obstacle32[3].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[34] == 4)
                {
                    obstacle32[3].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[34] == 5)
                {
                    obstacle32[3].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[34] == 6)
                {
                    obstacle32[3].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[34] == 7)
                {
                    obstacle32[3].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[34] == 8)
                {
                    obstacle32[3].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[34] == 9)
                {
                    obstacle32[3].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[34] == 10)
                {
                    obstacle32[3].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[34] == 11)
                {
                    obstacle32[3].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[34] == 12)
                {
                    obstacle32[3].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[34] == 13)
                {
                    obstacle32[3].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[34] == 14)
                {
                    obstacle32[3].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[34] == 15)
                {
                    obstacle32[3].setPosition(four_SpeedX , four_SpeedY);
                }
            }
        }
        else
        {
            obstacle32[3].setObstacleAlpha(0);
            obstacle32[3].position_effect();
        }

        if(pattern32[4] == 1)
        {
            if(obstacle32[4].position_x  >= 300*size_dm || obstacle32[4].position_x  <= 10*size_dm || obstacle32[4].position_y <= 90*size_dm ||  obstacle32[4].position_y >=350*size_dm)
            {
                pattern_speed_number[35] = getRandomMath8(15, 0);
                obstacle32[4].setObstacleAlpha(200);

                if(pattern_speed_number[35] == 0)
                {
                    obstacle32[4].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[35] == 1)
                {
                    obstacle32[4].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[35] == 2)
                {
                    obstacle32[4].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[35] == 3)
                {
                    obstacle32[4].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[35] == 4)
                {
                    obstacle32[4].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[35] == 5)
                {
                    obstacle32[4].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[35] == 6)
                {
                    obstacle32[4].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[35] == 7)
                {
                    obstacle32[4].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[35] == 8)
                {
                    obstacle32[4].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[35] == 9)
                {
                    obstacle32[4].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[35] == 10)
                {
                    obstacle32[4].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[35] == 11)
                {
                    obstacle32[4].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[35] == 12)
                {
                    obstacle32[4].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[35] == 13)
                {
                    obstacle32[4].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[35] == 14)
                {
                    obstacle32[4].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[35] == 15)
                {
                    obstacle32[4].setPosition(four_SpeedX , four_SpeedY);
                }
            }
            else
            {
                obstacle32[4].setObstacleAlpha(200);
                if(pattern_speed_number[35] == 0)
                {
                    obstacle32[4].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[35] == 1)
                {
                    obstacle32[4].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[35] == 2)
                {
                    obstacle32[4].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[35] == 3)
                {
                    obstacle32[4].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[35] == 4)
                {
                    obstacle32[4].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[35] == 5)
                {
                    obstacle32[4].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[35] == 6)
                {
                    obstacle32[4].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[35] == 7)
                {
                    obstacle32[4].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[35] == 8)
                {
                    obstacle32[4].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[35] == 9)
                {
                    obstacle32[4].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[35] == 10)
                {
                    obstacle32[4].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[35] == 11)
                {
                    obstacle32[4].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[35] == 12)
                {
                    obstacle32[4].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[35] == 13)
                {
                    obstacle32[4].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[35] == 14)
                {
                    obstacle32[4].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[35] == 15)
                {
                    obstacle32[4].setPosition(four_SpeedX , four_SpeedY);
                }
            }
        }
        else
        {
            obstacle32[4].setObstacleAlpha(0);
            obstacle32[4].position_effect();
        }

        if(pattern32[5] == 1)
        {
            if(obstacle32[5].position_x  >= 300*size_dm || obstacle32[5].position_x  <= 10*size_dm || obstacle32[5].position_y <= 90*size_dm ||  obstacle32[5].position_y >=350*size_dm)
            {
                pattern_speed_number[36] = getRandomMath8(15, 0);
                obstacle32[5].setObstacleAlpha(200);
                if(pattern_speed_number[36] == 0)
                {
                    obstacle32[5].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[36] == 1)
                {
                    obstacle32[5].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[36] == 2)
                {
                    obstacle32[5].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[36] == 3)
                {
                    obstacle32[5].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[36] == 4)
                {
                    obstacle32[5].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[36] == 5)
                {
                    obstacle32[5].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[36] == 6)
                {
                    obstacle32[5].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[36] == 7)
                {
                    obstacle32[5].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[36] == 8)
                {
                    obstacle32[5].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[36] == 9)
                {
                    obstacle32[5].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[36] == 10)
                {
                    obstacle32[5].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[36] == 11)
                {
                    obstacle32[5].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[36] == 12)
                {
                    obstacle32[5].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[36] == 13)
                {
                    obstacle32[5].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[36] == 14)
                {
                    obstacle32[5].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[36] == 15)
                {
                    obstacle32[5].setPosition(four_SpeedX , four_SpeedY);
                }
            }
            else
            {
                obstacle32[5].setObstacleAlpha(200);
                if(pattern_speed_number[36] == 0)
                {
                    obstacle32[5].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[36] == 1)
                {
                    obstacle32[5].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[36] == 2)
                {
                    obstacle32[5].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[36] == 3)
                {
                    obstacle32[5].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[36] == 4)
                {
                    obstacle32[5].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[36] == 5)
                {
                    obstacle32[5].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[36] == 6)
                {
                    obstacle32[5].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[36] == 7)
                {
                    obstacle32[5].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[36] == 8)
                {
                    obstacle32[5].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[36] == 9)
                {
                    obstacle32[5].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[36] == 10)
                {
                    obstacle32[5].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[36] == 11)
                {
                    obstacle32[5].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[36] == 12)
                {
                    obstacle32[5].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[36] == 13)
                {
                    obstacle32[5].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[36] == 14)
                {
                    obstacle32[5].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[36] == 15)
                {
                    obstacle32[5].setPosition(four_SpeedX , four_SpeedY);
                }
            }
        }
        else
        {
            obstacle32[5].setObstacleAlpha(0);
            obstacle32[5].position_effect();
        }

        if(pattern32[6] == 1)
        {
            if(obstacle32[6].position_x  >= 300*size_dm || obstacle32[6].position_x  <= 10*size_dm || obstacle32[6].position_y <= 90*size_dm ||  obstacle32[6].position_y >=350*size_dm)
            {
                pattern_speed_number[37] = getRandomMath8(15, 0);
                obstacle32[6].setObstacleAlpha(200);
                if(pattern_speed_number[37] == 0)
                {
                    obstacle32[6].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[37] == 1)
                {
                    obstacle32[6].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[37] == 2)
                {
                    obstacle32[6].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[37] == 3)
                {
                    obstacle32[6].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[37] == 4)
                {
                    obstacle32[6].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[37] == 5)
                {
                    obstacle32[6].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[37] == 6)
                {
                    obstacle32[6].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[37] == 7)
                {
                    obstacle32[6].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[37] == 8)
                {
                    obstacle32[6].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[37] == 9)
                {
                    obstacle32[6].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[37] == 10)
                {
                    obstacle32[6].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[37] == 11)
                {
                    obstacle32[6].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[37] == 12)
                {
                    obstacle32[6].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[37] == 13)
                {
                    obstacle32[6].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[37] == 14)
                {
                    obstacle32[6].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[37] == 15)
                {
                    obstacle32[6].setPosition(four_SpeedX , four_SpeedY);
                }
            }
            else
            {
                obstacle32[6].setObstacleAlpha(200);
                if(pattern_speed_number[37] == 0)
                {
                    obstacle32[6].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[37] == 1)
                {
                    obstacle32[6].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[37] == 2)
                {
                    obstacle32[6].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[37] == 3)
                {
                    obstacle32[6].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[37] == 4)
                {
                    obstacle32[6].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[37] == 5)
                {
                    obstacle32[6].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[37] == 6)
                {
                    obstacle32[6].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[37] == 7)
                {
                    obstacle32[6].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[37] == 8)
                {
                    obstacle32[6].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[37] == 9)
                {
                    obstacle32[6].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[37] == 10)
                {
                    obstacle32[6].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[37] == 11)
                {
                    obstacle32[6].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[37] == 12)
                {
                    obstacle32[6].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[37] == 13)
                {
                    obstacle32[6].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[37] == 14)
                {
                    obstacle32[6].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[37] == 15)
                {
                    obstacle32[6].setPosition(four_SpeedX , four_SpeedY);
                }
            }
        }
        else
        {
            obstacle32[6].setObstacleAlpha(0);
            obstacle32[6].position_effect();
        }

        if(pattern32[7] == 1)
        {
            if(obstacle32[7].position_x  >= 300*size_dm || obstacle32[7].position_x  <= 10*size_dm || obstacle32[7].position_y <= 90*size_dm ||  obstacle32[7].position_y >=350*size_dm)
            {
                pattern_speed_number[38] = getRandomMath8(15, 0);
                obstacle32[7].setObstacleAlpha(200);

                if(pattern_speed_number[38] == 0)
                {
                    obstacle32[7].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[38] == 1)
                {
                    obstacle32[7].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[38] == 2)
                {
                    obstacle32[7].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[38] == 3)
                {
                    obstacle32[7].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[38] == 4)
                {
                    obstacle32[7].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[38] == 5)
                {
                    obstacle32[7].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[38] == 6)
                {
                    obstacle32[7].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[38] == 7)
                {
                    obstacle32[7].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[38] == 8)
                {
                    obstacle32[7].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[38] == 9)
                {
                    obstacle32[7].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[38] == 10)
                {
                    obstacle32[7].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[38] == 11)
                {
                    obstacle32[7].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[38] == 12)
                {
                    obstacle32[7].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[38] == 13)
                {
                    obstacle32[7].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[38] == 14)
                {
                    obstacle32[7].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[38] == 15)
                {
                    obstacle32[7].setPosition(four_SpeedX , four_SpeedY);
                }
            }
            else
            {
                obstacle32[7].setObstacleAlpha(200);
                if(pattern_speed_number[38] == 0)
                {
                    obstacle32[7].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[38] == 1)
                {
                    obstacle32[7].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[38] == 2)
                {
                    obstacle32[7].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[38] == 3)
                {
                    obstacle32[7].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[38] == 4)
                {
                    obstacle32[7].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[38] == 5)
                {
                    obstacle32[7].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[38] == 6)
                {
                    obstacle32[7].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[38] == 7)
                {
                    obstacle32[7].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[38] == 8)
                {
                    obstacle32[7].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[38] == 9)
                {
                    obstacle32[7].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[38] == 10)
                {
                    obstacle32[7].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[38] == 11)
                {
                    obstacle32[7].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[38] == 12)
                {
                    obstacle32[7].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[38] == 13)
                {
                    obstacle32[7].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[38] == 14)
                {
                    obstacle32[7].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[38] == 15)
                {
                    obstacle32[7].setPosition(four_SpeedX , four_SpeedY);
                }
            }
        }
        else
        {
            obstacle32[7].setObstacleAlpha(0);
            obstacle32[7].position_effect();
        }

        if(pattern32[8] == 1)
        {
            if(obstacle32[8].position_x  >= 300*size_dm || obstacle32[8].position_x  <= 10*size_dm || obstacle32[8].position_y <= 90*size_dm ||  obstacle32[8].position_y >=350*size_dm)
            {
                pattern_speed_number[39] = getRandomMath8(15, 0);
                obstacle32[8].setObstacleAlpha(200);
                if(pattern_speed_number[39] == 0)
                {
                    obstacle32[8].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[39] == 1)
                {
                    obstacle32[8].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[39] == 2)
                {
                    obstacle32[8].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[39] == 3)
                {
                    obstacle32[8].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[39] == 4)
                {
                    obstacle32[8].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[39] == 5)
                {
                    obstacle32[8].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[39] == 6)
                {
                    obstacle32[8].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[39] == 7)
                {
                    obstacle32[8].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[39] == 8)
                {
                    obstacle32[8].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[39] == 9)
                {
                    obstacle32[8].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[39] == 10)
                {
                    obstacle32[8].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[39] == 11)
                {
                    obstacle32[8].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[39] == 12)
                {
                    obstacle32[8].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[39] == 13)
                {
                    obstacle32[8].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[39] == 14)
                {
                    obstacle32[8].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[39] == 15)
                {
                    obstacle32[8].setPosition(four_SpeedX , four_SpeedY);
                }
            }
            else
            {
                obstacle32[8].setObstacleAlpha(200);
                if(pattern_speed_number[39] == 0)
                {
                    obstacle32[8].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[39] == 1)
                {
                    obstacle32[8].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[39] == 2)
                {
                    obstacle32[8].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[39] == 3)
                {
                    obstacle32[8].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[39] == 4)
                {
                    obstacle32[8].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[39] == 5)
                {
                    obstacle32[8].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[39] == 6)
                {
                    obstacle32[8].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[39] == 7)
                {
                    obstacle32[8].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[39] == 8)
                {
                    obstacle32[8].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[39] == 9)
                {
                    obstacle32[8].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[39] == 10)
                {
                    obstacle32[8].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[39] == 11)
                {
                    obstacle32[8].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[39] == 12)
                {
                    obstacle32[8].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[39] == 13)
                {
                    obstacle32[8].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[39] == 14)
                {
                    obstacle32[8].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[39] == 15)
                {
                    obstacle32[8].setPosition(four_SpeedX , four_SpeedY);
                }
            }
        }
        else {
            obstacle32[8].setObstacleAlpha(0);
            obstacle32[8].position_effect();
        }

        if(pattern32[9] == 1)
        {
            if(obstacle32[9].position_x  >= 300*size_dm || obstacle32[9].position_x  <= 10*size_dm || obstacle32[9].position_y <= 90*size_dm ||  obstacle32[9].position_y >=350*size_dm)
            {
                pattern_speed_number[40] = getRandomMath8(15, 0);
                obstacle32[9].setObstacleAlpha(200);
                if(pattern_speed_number[40] == 0)
                {
                    obstacle32[9].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[40] == 1)
                {
                    obstacle32[9].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[40] == 2)
                {
                    obstacle32[9].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[40] == 3)
                {
                    obstacle32[9].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[40] == 4)
                {
                    obstacle32[9].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[40] == 5)
                {
                    obstacle32[9].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[40] == 6)
                {
                    obstacle32[9].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[40] == 7)
                {
                    obstacle32[9].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[40] == 8)
                {
                    obstacle32[9].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[40] == 9)
                {
                    obstacle32[9].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[40] == 10)
                {
                    obstacle32[9].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[40] == 11)
                {
                    obstacle32[9].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[40] == 12)
                {
                    obstacle32[9].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[40] == 13)
                {
                    obstacle32[9].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[40] == 14)
                {
                    obstacle32[9].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[40] == 15)
                {
                    obstacle32[9].setPosition(four_SpeedX , four_SpeedY);
                }
            }
            else
            {
                obstacle32[9].setObstacleAlpha(200);
                if(pattern_speed_number[40] == 0)
                {
                    obstacle32[9].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[40] == 1)
                {
                    obstacle32[9].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[40] == 2)
                {
                    obstacle32[9].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[40] == 3)
                {
                    obstacle32[9].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[40] == 4)
                {
                    obstacle32[9].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[40] == 5)
                {
                    obstacle32[9].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[40] == 6)
                {
                    obstacle32[9].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[40] == 7)
                {
                    obstacle32[9].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[40] == 8)
                {
                    obstacle32[9].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[40] == 9)
                {
                    obstacle32[9].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[40] == 10)
                {
                    obstacle32[9].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[40] == 11)
                {
                    obstacle32[9].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[40] == 12)
                {
                    obstacle32[9].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[40] == 13)
                {
                    obstacle32[9].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[40] == 14)
                {
                    obstacle32[9].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[40] == 15)
                {
                    obstacle32[9].setPosition(four_SpeedX , four_SpeedY);
                }
            }
        }
        else
        {
            obstacle32[9].setObstacleAlpha(0);
            obstacle32[9].position_effect();
        }

        if(pattern32[10] == 1)
        {
            if(obstacle32[10].position_x  >= 300*size_dm || obstacle32[10].position_x  <= 10*size_dm || obstacle32[10].position_y <= 90*size_dm ||  obstacle32[10].position_y >=350*size_dm)
            {
                pattern_speed_number[41] = getRandomMath8(15, 0);
                obstacle32[10].setObstacleAlpha(200);
                if(pattern_speed_number[41] == 0)
                {
                    obstacle32[10].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[41] == 1)
                {
                    obstacle32[10].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[41] == 2)
                {
                    obstacle32[10].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[41] == 3)
                {
                    obstacle32[10].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[41] == 4)
                {
                    obstacle32[10].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[41] == 5)
                {
                    obstacle32[10].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[41] == 6)
                {
                    obstacle32[10].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[41] == 7)
                {
                    obstacle32[10].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[41] == 8)
                {
                    obstacle32[10].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[41] == 9)
                {
                    obstacle32[10].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[41] == 10)
                {
                    obstacle32[10].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[41] == 11)
                {
                    obstacle32[10].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[41] == 12)
                {
                    obstacle32[10].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[41] == 13)
                {
                    obstacle32[10].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[41] == 14)
                {
                    obstacle32[10].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[41] == 15)
                {
                    obstacle32[10].setPosition(four_SpeedX , four_SpeedY);
                }
            }
            else
            {
                obstacle32[10].setObstacleAlpha(200);
                if(pattern_speed_number[41] == 0)
                {
                    obstacle32[10].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[41] == 1)
                {
                    obstacle32[10].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[41] == 2)
                {
                    obstacle32[10].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[41] == 3)
                {
                    obstacle32[10].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[41] == 4)
                {
                    obstacle32[10].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[41] == 5)
                {
                    obstacle32[10].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[41] == 6)
                {
                    obstacle32[10].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[41] == 7)
                {
                    obstacle32[10].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[41] == 8)
                {
                    obstacle32[10].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[41] == 9)
                {
                    obstacle32[10].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[41] == 10)
                {
                    obstacle32[10].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[41] == 11)
                {
                    obstacle32[10].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[41] == 12)
                {
                    obstacle32[10].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[41] == 13)
                {
                    obstacle32[10].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[41] == 14)
                {
                    obstacle32[10].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[41] == 15)
                {
                    obstacle32[10].setPosition(four_SpeedX , four_SpeedY);
                }
            }
        }
        else
        {
            obstacle32[10].setObstacleAlpha(0);
            obstacle32[10].position_effect();
        }

        if(pattern32[11] == 1)
        {
            if(obstacle32[11].position_x  >= 300*size_dm || obstacle32[11].position_x  <= 10*size_dm || obstacle32[11].position_y <= 90*size_dm ||  obstacle32[11].position_y >=350*size_dm)
            {
                pattern_speed_number[42] = getRandomMath8(15, 0);
                obstacle32[11].setObstacleAlpha(200);
                if(pattern_speed_number[42] == 0)
                {
                    obstacle32[11].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[42] == 1)
                {
                    obstacle32[11].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[42] == 2)
                {
                    obstacle32[11].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[42] == 3)
                {
                    obstacle32[11].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[42] == 4)
                {
                    obstacle32[11].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[42] == 5)
                {
                    obstacle32[11].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[42] == 6)
                {
                    obstacle32[11].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[42] == 7)
                {
                    obstacle32[11].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[42] == 8)
                {
                    obstacle32[11].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[42] == 9)
                {
                    obstacle32[11].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[42] == 10)
                {
                    obstacle32[11].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[42] == 11)
                {
                    obstacle32[11].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[42] == 12)
                {
                    obstacle32[11].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[42] == 13)
                {
                    obstacle32[11].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[42] == 14)
                {
                    obstacle32[11].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[42] == 15)
                {
                    obstacle32[11].setPosition(four_SpeedX , four_SpeedY);
                }

            }
            else
            {
                obstacle32[11].setObstacleAlpha(200);
                if(pattern_speed_number[42] == 0)
                {
                    obstacle32[11].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[42] == 1)
                {
                    obstacle32[11].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[42] == 2)
                {
                    obstacle32[11].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[42] == 3)
                {
                    obstacle32[11].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[42] == 4)
                {
                    obstacle32[11].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[42] == 5)
                {
                    obstacle32[11].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[42] == 6)
                {
                    obstacle32[11].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[42] == 7)
                {
                    obstacle32[11].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[42] == 8)
                {
                    obstacle32[11].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[42] == 9)
                {
                    obstacle32[11].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[42] == 10)
                {
                    obstacle32[11].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[42] == 11)
                {
                    obstacle32[11].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[42] == 12)
                {
                    obstacle32[11].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[42] == 13)
                {
                    obstacle32[11].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[42] == 14)
                {
                    obstacle32[11].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[42] == 15)
                {
                    obstacle32[11].setPosition(four_SpeedX , four_SpeedY);
                }
            }
        }
        else
        {
            obstacle32[11].setObstacleAlpha(0);
            obstacle32[11].position_effect();
        }

        if(pattern32[12] == 1)
        {
            if(obstacle32[12].position_x  >= 300*size_dm || obstacle32[12].position_x  <= 10*size_dm || obstacle32[12].position_y <= 90*size_dm ||  obstacle32[12].position_y >=350*size_dm)
            {
                pattern_speed_number[43] = getRandomMath8(15, 0);
                obstacle32[12].setObstacleAlpha(200);
                if(pattern_speed_number[43] == 0)
                {
                    obstacle32[12].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[43] == 1)
                {
                    obstacle32[12].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[43] == 2)
                {
                    obstacle32[12].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[43] == 3)
                {
                    obstacle32[12].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[43] == 4)
                {
                    obstacle32[12].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[43] == 5)
                {
                    obstacle32[12].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[43] == 6)
                {
                    obstacle32[12].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[43] == 7)
                {
                    obstacle32[12].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[43] == 8)
                {
                    obstacle32[12].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[43] == 9)
                {
                    obstacle32[12].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[43] == 10)
                {
                    obstacle32[12].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[43] == 11)
                {
                    obstacle32[12].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[43] == 12)
                {
                    obstacle32[12].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[43] == 13)
                {
                    obstacle32[12].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[43] == 14)
                {
                    obstacle32[12].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[43] == 15)
                {
                    obstacle32[12].setPosition(four_SpeedX , four_SpeedY);
                }
            }
            else
            {
                obstacle32[12].setObstacleAlpha(200);
                if(pattern_speed_number[43] == 0)
                {
                    obstacle32[12].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[43] == 1)
                {
                    obstacle32[12].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[43] == 2)
                {
                    obstacle32[12].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[43] == 3)
                {
                    obstacle32[12].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[43] == 4)
                {
                    obstacle32[12].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[43] == 5)
                {
                    obstacle32[12].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[43] == 6)
                {
                    obstacle32[12].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[43] == 7)
                {
                    obstacle32[12].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[43] == 8)
                {
                    obstacle32[12].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[43] == 9)
                {
                    obstacle32[12].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[43] == 10)
                {
                    obstacle32[12].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[43] == 11)
                {
                    obstacle32[12].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[43] == 12)
                {
                    obstacle32[12].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[43] == 13)
                {
                    obstacle32[12].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[43] == 14)
                {
                    obstacle32[12].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[43] == 15)
                {
                    obstacle32[12].setPosition(four_SpeedX , four_SpeedY);
                }
            }
        }
        else
        {
            obstacle32[12].setObstacleAlpha(0);
            obstacle32[12].position_effect();
        }

        if(pattern32[13] == 1)
        {
            if(obstacle32[13].position_x  >= 300*size_dm || obstacle32[13].position_x  <= 10*size_dm || obstacle32[13].position_y <= 90*size_dm ||  obstacle32[13].position_y >=350*size_dm)
            {
                pattern_speed_number[44] = getRandomMath8(15, 0);
                obstacle32[13].setObstacleAlpha(200);
                if(pattern_speed_number[44] == 0)
                {
                    obstacle32[13].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[44] == 1)
                {
                    obstacle32[13].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[44] == 2)
                {
                    obstacle32[13].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[44] == 3)
                {
                    obstacle32[13].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[44] == 4)
                {
                    obstacle32[13].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[44] == 5)
                {
                    obstacle32[13].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[44] == 6)
                {
                    obstacle32[13].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[44] == 7)
                {
                    obstacle32[13].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[44] == 8)
                {
                    obstacle32[13].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[44] == 9)
                {
                    obstacle32[13].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[44] == 10)
                {
                    obstacle32[13].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[44] == 11)
                {
                    obstacle32[13].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[44] == 12)
                {
                    obstacle32[13].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[44] == 13)
                {
                    obstacle32[13].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[44] == 14)
                {
                    obstacle32[13].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[44] == 15)
                {
                    obstacle32[13].setPosition(four_SpeedX , four_SpeedY);
                }
            }
            else
            {
                obstacle32[13].setObstacleAlpha(200);
                if(pattern_speed_number[44] == 0)
                {
                    obstacle32[13].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[44] == 1)
                {
                    obstacle32[13].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[44] == 2)
                {
                    obstacle32[13].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[44] == 3)
                {
                    obstacle32[13].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[44] == 4)
                {
                    obstacle32[13].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[44] == 5)
                {
                    obstacle32[13].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[44] == 6)
                {
                    obstacle32[13].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[44] == 7)
                {
                    obstacle32[13].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[44] == 8)
                {
                    obstacle32[13].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[44] == 9)
                {
                    obstacle32[13].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[44] == 10)
                {
                    obstacle32[13].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[44] == 11)
                {
                    obstacle32[13].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[44] == 12)
                {
                    obstacle32[13].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[44] == 13)
                {
                    obstacle32[13].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[44] == 14)
                {
                    obstacle32[13].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[44] == 15)
                {
                    obstacle32[13].setPosition(four_SpeedX , four_SpeedY);
                }
            }
        }
        else
        {
            obstacle32[13].setObstacleAlpha(0);
            obstacle32[13].position_effect();
        }

        if(pattern32[14] == 1)
        {
            if(obstacle32[14].position_x  >= 300*size_dm || obstacle32[14].position_x  <= 10*size_dm || obstacle32[14].position_y <= 90*size_dm ||  obstacle32[14].position_y >=350*size_dm)
            {
                pattern_speed_number[45] = getRandomMath8(15, 0);
                obstacle32[14].setObstacleAlpha(14);

                if(pattern_speed_number[45] == 0)
                {
                    obstacle32[14].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[45] == 1)
                {
                    obstacle32[14].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[45] == 2)
                {
                    obstacle32[14].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[45] == 3)
                {
                    obstacle32[14].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[45] == 4)
                {
                    obstacle32[14].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[45] == 5)
                {
                    obstacle32[14].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[45] == 6)
                {
                    obstacle32[14].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[45] == 7)
                {
                    obstacle32[14].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[45] == 8)
                {
                    obstacle32[14].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[45] == 9)
                {
                    obstacle32[14].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[45] == 10)
                {
                    obstacle32[14].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[45] == 11)
                {
                    obstacle32[14].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[45] == 12)
                {
                    obstacle32[14].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[45] == 13)
                {
                    obstacle32[14].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[45] == 14)
                {
                    obstacle32[14].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[45] == 15)
                {
                    obstacle32[14].setPosition(four_SpeedX , four_SpeedY);
                }
            }
            else
            {
                obstacle32[14].setObstacleAlpha(200);
                if(pattern_speed_number[45] == 0)
                {
                    obstacle32[14].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[45] == 1)
                {
                    obstacle32[14].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[45] == 2)
                {
                    obstacle32[14].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[45] == 3)
                {
                    obstacle32[14].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[45] == 4)
                {
                    obstacle32[14].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[45] == 5)
                {
                    obstacle32[14].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[45] == 6)
                {
                    obstacle32[14].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[45] == 7)
                {
                    obstacle32[14].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[45] == 8)
                {
                    obstacle32[14].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[45] == 9)
                {
                    obstacle32[14].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[45] == 10)
                {
                    obstacle32[14].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[45] == 11)
                {
                    obstacle32[14].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[45] == 12)
                {
                    obstacle32[14].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[45] == 13)
                {
                    obstacle32[14].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[45] == 14)
                {
                    obstacle32[14].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[45] == 15)
                {
                    obstacle32[14].setPosition(four_SpeedX , four_SpeedY);
                }
            }
        }
        else
        {
            obstacle32[14].setObstacleAlpha(0);
            obstacle32[14].position_effect();
        }

        if(pattern32[15] == 1)
        {
            if(obstacle32[15].position_x  >= 300*size_dm || obstacle32[15].position_x  <= 10*size_dm || obstacle32[15].position_y <= 90*size_dm ||  obstacle32[15].position_y >=350*size_dm)
            {
                pattern_speed_number[46] = getRandomMath8(15, 0);
                obstacle32[15].setObstacleAlpha(200);
                if(pattern_speed_number[46] == 0)
                {
                    obstacle32[15].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[46] == 1)
                {
                    obstacle32[15].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[46] == 2)
                {
                    obstacle32[15].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[46] == 3)
                {
                    obstacle32[15].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[46] == 4)
                {
                    obstacle32[15].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[46] == 5)
                {
                    obstacle32[15].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[46] == 6)
                {
                    obstacle32[15].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[46] == 7)
                {
                    obstacle32[15].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[46] == 8)
                {
                    obstacle32[15].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[46] == 9)
                {
                    obstacle32[15].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[46] == 10)
                {
                    obstacle32[15].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[46] == 11)
                {
                    obstacle32[15].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[46] == 12)
                {
                    obstacle32[15].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[46] == 13)
                {
                    obstacle32[15].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[46] == 14)
                {
                    obstacle32[15].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[46] == 15)
                {
                    obstacle32[15].setPosition(four_SpeedX , four_SpeedY);
                }
            }
            else
            {
                obstacle32[15].setObstacleAlpha(200);
                if(pattern_speed_number[46] == 0)
                {
                    obstacle32[15].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[46] == 1)
                {
                    obstacle32[15].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[46] == 2)
                {
                    obstacle32[15].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[46] == 3)
                {
                    obstacle32[15].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[46] == 4)
                {
                    obstacle32[15].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[46] == 5)
                {
                    obstacle32[15].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[46] == 6)
                {
                    obstacle32[15].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[46] == 7)
                {
                    obstacle32[15].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[46] == 8)
                {
                    obstacle32[15].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[46] == 9)
                {
                    obstacle32[15].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[46] == 10)
                {
                    obstacle32[15].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[46] == 11)
                {
                    obstacle32[15].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[46] == 12)
                {
                    obstacle32[15].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[46] == 13)
                {
                    obstacle32[15].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[46] == 14)
                {
                    obstacle32[15].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[46] == 15)
                {
                    obstacle32[15].setPosition(four_SpeedX , four_SpeedY);
                }
            }
        }
        else
        {
            obstacle32[15].setObstacleAlpha(0);
            obstacle32[15].position_effect();
        }

        if(pattern32[16] == 1)
        {
            if(obstacle32[16].position_x  >= 300*size_dm || obstacle32[16].position_x  <= 10*size_dm || obstacle32[16].position_y <= 90*size_dm ||  obstacle32[16].position_y >=350*size_dm)
            {
                pattern_speed_number[47] = getRandomMath8(15, 0);
                obstacle32[16].setObstacleAlpha(200);
                if(pattern_speed_number[47] == 0)
                {
                    obstacle32[16].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[47] == 1)
                {
                    obstacle32[16].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[47] == 2)
                {
                    obstacle32[16].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[47] == 3)
                {
                    obstacle32[16].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[47] == 4)
                {
                    obstacle32[16].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[47] == 5)
                {
                    obstacle32[16].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[47] == 6)
                {
                    obstacle32[16].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[47] == 7)
                {
                    obstacle32[16].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[47] == 8)
                {
                    obstacle32[16].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[47] == 9)
                {
                    obstacle32[16].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[47] == 10)
                {
                    obstacle32[16].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[47] == 11)
                {
                    obstacle32[16].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[47] == 12)
                {
                    obstacle32[16].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[47] == 13)
                {
                    obstacle32[16].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[47] == 14)
                {
                    obstacle32[16].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[47] == 15)
                {
                    obstacle32[16].setPosition(four_SpeedX , four_SpeedY);
                }
            }
            else
            {
                obstacle32[16].setObstacleAlpha(200);
                if(pattern_speed_number[47] == 0)
                {
                    obstacle32[16].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[47] == 1)
                {
                    obstacle32[16].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[47] == 2)
                {
                    obstacle32[16].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[47] == 3)
                {
                    obstacle32[16].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[47] == 4)
                {
                    obstacle32[16].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[47] == 5)
                {
                    obstacle32[16].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[47] == 6)
                {
                    obstacle32[16].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[47] == 7)
                {
                    obstacle32[16].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[47] == 8)
                {
                    obstacle32[16].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[47] == 9)
                {
                    obstacle32[16].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[47] == 10)
                {
                    obstacle32[16].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[47] == 11)
                {
                    obstacle32[16].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[47] == 12)
                {
                    obstacle32[16].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[47] == 13)
                {
                    obstacle32[16].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[47] == 14)
                {
                    obstacle32[16].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[47] == 15)
                {
                    obstacle32[16].setPosition(four_SpeedX , four_SpeedY);
                }
            }
        }
        else
        {
            obstacle32[16].setObstacleAlpha(0);
            obstacle32[16].position_effect();
        }

        if(pattern32[17] == 1)
        {
            if(obstacle32[17].position_x  >= 300*size_dm || obstacle32[17].position_x  <= 10*size_dm || obstacle32[17].position_y <= 90*size_dm ||  obstacle32[17].position_y >=350*size_dm)
            {
                pattern_speed_number[48] = getRandomMath8(15, 0);
                obstacle32[17].setObstacleAlpha(200);
                if(pattern_speed_number[48] == 0)
                {
                    obstacle32[17].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[48] == 1)
                {
                    obstacle32[17].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[48] == 2)
                {
                    obstacle32[17].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[48] == 3)
                {
                    obstacle32[17].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[48] == 4)
                {
                    obstacle32[17].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[48] == 5)
                {
                    obstacle32[17].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[48] == 6)
                {
                    obstacle32[17].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[48] == 7)
                {
                    obstacle32[17].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[48] == 8)
                {
                    obstacle32[17].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[48] == 9)
                {
                    obstacle32[17].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[48] == 10)
                {
                    obstacle32[17].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[48] == 11)
                {
                    obstacle32[17].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[48] == 12)
                {
                    obstacle32[17].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[48] == 13)
                {
                    obstacle32[17].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[48] == 14)
                {
                    obstacle32[17].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[48] == 15)
                {
                    obstacle32[17].setPosition(four_SpeedX , four_SpeedY);
                }
            }
            else
            {
                obstacle32[17].setObstacleAlpha(200);
                if(pattern_speed_number[48] == 0)
                {
                    obstacle32[17].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[48] == 1)
                {
                    obstacle32[17].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[48] == 2)
                {
                    obstacle32[17].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[48] == 3)
                {
                    obstacle32[17].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[48] == 4)
                {
                    obstacle32[17].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[48] == 5)
                {
                    obstacle32[17].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[48] == 6)
                {
                    obstacle32[17].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[48] == 7)
                {
                    obstacle32[17].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[48] == 8)
                {
                    obstacle32[17].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[48] == 9)
                {
                    obstacle32[17].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[48] == 10)
                {
                    obstacle32[17].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[48] == 11)
                {
                    obstacle32[17].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[48] == 12)
                {
                    obstacle32[17].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[48] == 13)
                {
                    obstacle32[17].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[48] == 14)
                {
                    obstacle32[17].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[48] == 15)
                {
                    obstacle32[17].setPosition(four_SpeedX , four_SpeedY);
                }
            }
        }
        else
        {
            obstacle32[17].setObstacleAlpha(0);
            obstacle32[17].position_effect();
        }

        if(pattern32[18] == 1)
        {
            if(obstacle32[18].position_x  >= 300*size_dm || obstacle32[18].position_x  <= 10*size_dm || obstacle32[18].position_y <= 90*size_dm ||  obstacle32[18].position_y >=350*size_dm)
            {
                pattern_speed_number[49] = getRandomMath8(15, 0);
                obstacle32[18].setObstacleAlpha(200);
                if(pattern_speed_number[49] == 0)
                {
                    obstacle32[18].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[49] == 1)
                {
                    obstacle32[18].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[49] == 2)
                {
                    obstacle32[18].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[49] == 3)
                {
                    obstacle32[18].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[49] == 4)
                {
                    obstacle32[18].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[49] == 5)
                {
                    obstacle32[18].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[49] == 6)
                {
                    obstacle32[18].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[49] == 7)
                {
                    obstacle32[18].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[49] == 8)
                {
                    obstacle32[18].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[49] == 9)
                {
                    obstacle32[18].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[49] == 10)
                {
                    obstacle32[18].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[49] == 11)
                {
                    obstacle32[18].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[49] == 12)
                {
                    obstacle32[18].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[49] == 13)
                {
                    obstacle32[18].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[49] == 14)
                {
                    obstacle32[18].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[49] == 15)
                {
                    obstacle32[18].setPosition(four_SpeedX , four_SpeedY);
                }
            }
            else
            {
                obstacle32[18].setObstacleAlpha(200);
                if(pattern_speed_number[49] == 0)
                {
                    obstacle32[18].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[49] == 1)
                {
                    obstacle32[18].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[49] == 2)
                {
                    obstacle32[18].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[49] == 3)
                {
                    obstacle32[18].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[49] == 4)
                {
                    obstacle32[18].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[49] == 5)
                {
                    obstacle32[18].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[49] == 6)
                {
                    obstacle32[18].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[49] == 7)
                {
                    obstacle32[18].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[49] == 8)
                {
                    obstacle32[18].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[49] == 9)
                {
                    obstacle32[18].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[49] == 10)
                {
                    obstacle32[18].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[49] == 11)
                {
                    obstacle32[18].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[49] == 12)
                {
                    obstacle32[18].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[49] == 13)
                {
                    obstacle32[18].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[49] == 14)
                {
                    obstacle32[18].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[49] == 15)
                {
                    obstacle32[18].setPosition(four_SpeedX , four_SpeedY);
                }
            }
        }
        else
        {
            obstacle32[18].setObstacleAlpha(0);
            obstacle32[18].position_effect();
        }

        if(pattern32[19] == 1)
        {
            if(obstacle32[19].position_x  >= 300*size_dm || obstacle32[19].position_x  <= 10*size_dm || obstacle32[19].position_y <= 90*size_dm ||  obstacle32[19].position_y >=350*size_dm)
            {
                pattern_speed_number[50] = getRandomMath8(15, 0);
                obstacle32[19].setObstacleAlpha(200);
                if(pattern_speed_number[50] == 0)
                {
                    obstacle32[19].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[50] == 1)
                {
                    obstacle32[19].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[50] == 2)
                {
                    obstacle32[19].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[50] == 3)
                {
                    obstacle32[19].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[50] == 4)
                {
                    obstacle32[19].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[50] == 5)
                {
                    obstacle32[19].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[50] == 6)
                {
                    obstacle32[19].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[50] == 7)
                {
                    obstacle32[19].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[50] == 8)
                {
                    obstacle32[19].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[50] == 9)
                {
                    obstacle32[19].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[50] == 10)
                {
                    obstacle32[19].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[50] == 11)
                {
                    obstacle32[19].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[50] == 12)
                {
                    obstacle32[19].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[50] == 13)
                {
                    obstacle32[19].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[50] == 14)
                {
                    obstacle32[19].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[50] == 15)
                {
                    obstacle32[19].setPosition(four_SpeedX , four_SpeedY);
                }
            }
            else
            {
                obstacle32[19].setObstacleAlpha(200);
                if(pattern_speed_number[50] == 0)
                {
                    obstacle32[19].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[50] == 1)
                {
                    obstacle32[19].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[50] == 2)
                {
                    obstacle32[19].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[50] == 3)
                {
                    obstacle32[19].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[50] == 4)
                {
                    obstacle32[19].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[50] == 5)
                {
                    obstacle32[19].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[50] == 6)
                {
                    obstacle32[19].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[50] == 7)
                {
                    obstacle32[19].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[50] == 8)
                {
                    obstacle32[19].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[50] == 9)
                {
                    obstacle32[19].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[50] == 10)
                {
                    obstacle32[19].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[50] == 11)
                {
                    obstacle32[19].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[50] == 12)
                {
                    obstacle32[19].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[50] == 13)
                {
                    obstacle32[19].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[50] == 14)
                {
                    obstacle32[19].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[50] == 15)
                {
                    obstacle32[19].setPosition(four_SpeedX , four_SpeedY);
                }
            }
        }
        else
        {
            obstacle32[19].setObstacleAlpha(0);
            obstacle32[19].position_effect();
        }

        if(pattern32[20] == 1)
        {
            if(obstacle32[20].position_x  >= 300*size_dm || obstacle32[20].position_x  <= 10*size_dm || obstacle32[20].position_y <= 90*size_dm ||  obstacle32[20].position_y >=350*size_dm)
            {
                pattern_speed_number[51] = getRandomMath8(15, 0);
                obstacle32[20].setObstacleAlpha(200);
                if(pattern_speed_number[51] == 0)
                {
                    obstacle32[20].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[51] == 1)
                {
                    obstacle32[20].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[51] == 2)
                {
                    obstacle32[20].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[51] == 3)
                {
                    obstacle32[20].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[51] == 4)
                {
                    obstacle32[20].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[51] == 5)
                {
                    obstacle32[20].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[51] == 6)
                {
                    obstacle32[20].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[51] == 7)
                {
                    obstacle32[20].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[51] == 8)
                {
                    obstacle32[20].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[51] == 9)
                {
                    obstacle32[20].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[51] == 10)
                {
                    obstacle32[20].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[51] == 11)
                {
                    obstacle32[20].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[51] == 12)
                {
                    obstacle32[20].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[51] == 13)
                {
                    obstacle32[20].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[51] == 14)
                {
                    obstacle32[20].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[51] == 15)
                {
                    obstacle32[20].setPosition(four_SpeedX , four_SpeedY);
                }
            }
            else
            {
                obstacle32[20].setObstacleAlpha(200);
                if(pattern_speed_number[51] == 0)
                {
                    obstacle32[20].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[51] == 1)
                {
                    obstacle32[20].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[51] == 2)
                {
                    obstacle32[20].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[51] == 3)
                {
                    obstacle32[20].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[51] == 4)
                {
                    obstacle32[20].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[51] == 5)
                {
                    obstacle32[20].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[51] == 6)
                {
                    obstacle32[20].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[51] == 7)
                {
                    obstacle32[20].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[51] == 8)
                {
                    obstacle32[20].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[51] == 9)
                {
                    obstacle32[20].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[51] == 10)
                {
                    obstacle32[20].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[51] == 11)
                {
                    obstacle32[20].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[51] == 12)
                {
                    obstacle32[20].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[51] == 13)
                {
                    obstacle32[20].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[51] == 14)
                {
                    obstacle32[20].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[51] == 15)
                {
                    obstacle32[20].setPosition(four_SpeedX , four_SpeedY);
                }
            }
        }
        else
        {
            obstacle32[20].setObstacleAlpha(0);
            obstacle32[20].position_effect();
        }

        if(pattern32[21] == 1)
        {
            if(obstacle32[21].position_x  >= 300*size_dm || obstacle32[21].position_x  <= 10*size_dm || obstacle32[21].position_y <= 90*size_dm ||  obstacle32[21].position_y >=350*size_dm)
            {
                pattern_speed_number[52] = getRandomMath8(15, 0);
                obstacle32[21].setObstacleAlpha(200);
                if(pattern_speed_number[52] == 0)
                {
                    obstacle32[21].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[52] == 1)
                {
                    obstacle32[21].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[52] == 2)
                {
                    obstacle32[21].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[52] == 3)
                {
                    obstacle32[21].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[52] == 4)
                {
                    obstacle32[21].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[52] == 5)
                {
                    obstacle32[21].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[52] == 6)
                {
                    obstacle32[21].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[52] == 7)
                {
                    obstacle32[21].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[52] == 8)
                {
                    obstacle32[21].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[52] == 9)
                {
                    obstacle32[21].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[52] == 10)
                {
                    obstacle32[21].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[52] == 11)
                {
                    obstacle32[21].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[52] == 12)
                {
                    obstacle32[21].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[52] == 13)
                {
                    obstacle32[21].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[52] == 14)
                {
                    obstacle32[21].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[52] == 15)
                {
                    obstacle32[21].setPosition(four_SpeedX , four_SpeedY);
                }
            }
            else
            {
                obstacle32[21].setObstacleAlpha(200);
                if(pattern_speed_number[52] == 0)
                {
                    obstacle32[21].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[52] == 1)
                {
                    obstacle32[21].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[52] == 2)
                {
                    obstacle32[21].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[52] == 3)
                {
                    obstacle32[21].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[52] == 4)
                {
                    obstacle32[21].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[52] == 5)
                {
                    obstacle32[21].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[52] == 6)
                {
                    obstacle32[21].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[52] == 7)
                {
                    obstacle32[21].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[52] == 8)
                {
                    obstacle32[21].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[52] == 9)
                {
                    obstacle32[21].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[52] == 10)
                {
                    obstacle32[21].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[52] == 11)
                {
                    obstacle32[21].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[52] == 12)
                {
                    obstacle32[21].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[52] == 13)
                {
                    obstacle32[21].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[52] == 14)
                {
                    obstacle32[21].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[52] == 15)
                {
                    obstacle32[21].setPosition(four_SpeedX , four_SpeedY);
                }
            }
        }
        else {
            obstacle32[21].setObstacleAlpha(0);
            obstacle32[21].position_effect();
        }

        if(pattern32[22] == 1)
        {
            if(obstacle32[22].position_x  >= 300*size_dm || obstacle32[22].position_x  <= 10*size_dm || obstacle32[22].position_y <= 90*size_dm ||  obstacle32[22].position_y >=350*size_dm)
            {
                pattern_speed_number[53] = getRandomMath8(15, 0);
                obstacle32[22].setObstacleAlpha(200);
                if(pattern_speed_number[53] == 0)
                {
                    obstacle32[22].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[53] == 1)
                {
                    obstacle32[22].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[53] == 2)
                {
                    obstacle32[22].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[53] == 3)
                {
                    obstacle32[22].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[53] == 4)
                {
                    obstacle32[22].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[53] == 5)
                {
                    obstacle32[22].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[53] == 6)
                {
                    obstacle32[22].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[53] == 7)
                {
                    obstacle32[22].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[53] == 8)
                {
                    obstacle32[22].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[53] == 9)
                {
                    obstacle32[22].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[53] == 10)
                {
                    obstacle32[22].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[53] == 11)
                {
                    obstacle32[22].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[53] == 12)
                {
                    obstacle32[22].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[53] == 13)
                {
                    obstacle32[22].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[53] == 14)
                {
                    obstacle32[22].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[53] == 15)
                {
                    obstacle32[22].setPosition(four_SpeedX , four_SpeedY);
                }
            }
            else
            {
                obstacle32[22].setObstacleAlpha(200);
                if(pattern_speed_number[53] == 0)
                {
                    obstacle32[22].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[53] == 1)
                {
                    obstacle32[22].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[53] == 2)
                {
                    obstacle32[22].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[53] == 3)
                {
                    obstacle32[22].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[53] == 4)
                {
                    obstacle32[22].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[53] == 5)
                {
                    obstacle32[22].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[53] == 6)
                {
                    obstacle32[22].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[53] == 7)
                {
                    obstacle32[22].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[53] == 8)
                {
                    obstacle32[22].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[53] == 9)
                {
                    obstacle32[22].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[53] == 10)
                {
                    obstacle32[22].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[53] == 11)
                {
                    obstacle32[22].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[53] == 12)
                {
                    obstacle32[22].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[53] == 13)
                {
                    obstacle32[22].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[53] == 14)
                {
                    obstacle32[22].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[53] == 15)
                {
                    obstacle32[22].setPosition(four_SpeedX , four_SpeedY);
                }
            }
        }
        else
        {
            obstacle32[22].setObstacleAlpha(0);
            obstacle32[22].position_effect();
        }

        if(pattern32[23] == 1)
        {
            if(obstacle32[23].position_x  >= 300*size_dm || obstacle32[23].position_x  <= 10*size_dm || obstacle32[23].position_y <= 90*size_dm ||  obstacle32[23].position_y >=350*size_dm)
            {
                pattern_speed_number[54] = getRandomMath8(15, 0);
                obstacle32[23].setObstacleAlpha(200);
                if(pattern_speed_number[54] == 0)
                {
                    obstacle32[23].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[54] == 1)
                {
                    obstacle32[23].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[54] == 2)
                {
                    obstacle32[23].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[54] == 3)
                {
                    obstacle32[23].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[54] == 4)
                {
                    obstacle32[23].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[54] == 5)
                {
                    obstacle32[23].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[54] == 6)
                {
                    obstacle32[23].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[54] == 7)
                {
                    obstacle32[23].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[54] == 8)
                {
                    obstacle32[23].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[54] == 9)
                {
                    obstacle32[23].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[54] == 10)
                {
                    obstacle32[23].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[54] == 11)
                {
                    obstacle32[23].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[54] == 12)
                {
                    obstacle32[23].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[54] == 13)
                {
                    obstacle32[23].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[54] == 14)
                {
                    obstacle32[23].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[54] == 15)
                {
                    obstacle32[23].setPosition(four_SpeedX , four_SpeedY);
                }
            }
            else
            {
                obstacle32[23].setObstacleAlpha(200);
                if(pattern_speed_number[54] == 0)
                {
                    obstacle32[23].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[54] == 1)
                {
                    obstacle32[23].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[54] == 2)
                {
                    obstacle32[23].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[54] == 3)
                {
                    obstacle32[23].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[54] == 4)
                {
                    obstacle32[23].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[54] == 5)
                {
                    obstacle32[23].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[54] == 6)
                {
                    obstacle32[23].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[54] == 7)
                {
                    obstacle32[23].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[54] == 8)
                {
                    obstacle32[23].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[54] == 9)
                {
                    obstacle32[23].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[54] == 10)
                {
                    obstacle32[23].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[54] == 11)
                {
                    obstacle32[23].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[54] == 12)
                {
                    obstacle32[23].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[54] == 13)
                {
                    obstacle32[23].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[54] == 14)
                {
                    obstacle32[23].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[54] == 15)
                {
                    obstacle32[23].setPosition(four_SpeedX , four_SpeedY);
                }
            }
        }
        else
        {
            obstacle32[23].setObstacleAlpha(0);
            obstacle32[23].position_effect();
        }

        if(pattern32[24] == 1)
        {
            if(obstacle32[24].position_x  >= 300*size_dm || obstacle32[24].position_x  <= 10*size_dm || obstacle32[24].position_y <= 90*size_dm ||  obstacle32[24].position_y >=350*size_dm)
            {
                pattern_speed_number[55] = getRandomMath8(15, 0);
                obstacle32[24].setObstacleAlpha(200);
                if(pattern_speed_number[55] == 0)
                {
                    obstacle32[24].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[55] == 1)
                {
                    obstacle32[24].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[55] == 2)
                {
                    obstacle32[24].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[55] == 3)
                {
                    obstacle32[24].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[55] == 4)
                {
                    obstacle32[24].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[55] == 5)
                {
                    obstacle32[24].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[55] == 6)
                {
                    obstacle32[24].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[55] == 7)
                {
                    obstacle32[24].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[55] == 8)
                {
                    obstacle32[24].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[55] == 9)
                {
                    obstacle32[24].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[55] == 10)
                {
                    obstacle32[24].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[55] == 11)
                {
                    obstacle32[24].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[55] == 12)
                {
                    obstacle32[24].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[55] == 13)
                {
                    obstacle32[24].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[55] == 14)
                {
                    obstacle32[24].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[55] == 15)
                {
                    obstacle32[24].setPosition(four_SpeedX , four_SpeedY);
                }
            }
            else
            {
                obstacle32[24].setObstacleAlpha(200);
                if(pattern_speed_number[55] == 0)
                {
                    obstacle32[24].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[55] == 1)
                {
                    obstacle32[24].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[55] == 2)
                {
                    obstacle32[24].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[55] == 3)
                {
                    obstacle32[24].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[55] == 4)
                {
                    obstacle32[24].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[55] == 5)
                {
                    obstacle32[24].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[55] == 6)
                {
                    obstacle32[24].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[55] == 7)
                {
                    obstacle32[24].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[55] == 8)
                {
                    obstacle32[24].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[55] == 9)
                {
                    obstacle32[24].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[55] == 10)
                {
                    obstacle32[24].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[55] == 11)
                {
                    obstacle32[24].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[55] == 12)
                {
                    obstacle32[24].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[55] == 13)
                {
                    obstacle32[24].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[55] == 14)
                {
                    obstacle32[24].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[55] == 15)
                {
                    obstacle32[24].setPosition(four_SpeedX , four_SpeedY);
                }
            }
        }
        else
        {
            obstacle32[24].setObstacleAlpha(0);
            obstacle32[24].position_effect();
        }

        if(pattern32[25] == 1)
        {
            if(obstacle32[25].position_x  >= 300*size_dm || obstacle32[25].position_x  <= 10*size_dm || obstacle32[25].position_y <= 90*size_dm ||  obstacle32[25].position_y >=350*size_dm)
            {
                pattern_speed_number[56] = getRandomMath8(15, 0);
                obstacle32[25].setObstacleAlpha(200);
                if(pattern_speed_number[56] == 0)
                {
                    obstacle32[25].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[56] == 1)
                {
                    obstacle32[25].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[56] == 2)
                {
                    obstacle32[25].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[56] == 3)
                {
                    obstacle32[25].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[56] == 4)
                {
                    obstacle32[25].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[56] == 5)
                {
                    obstacle32[25].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[56] == 6)
                {
                    obstacle32[25].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[56] == 7)
                {
                    obstacle32[25].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[56] == 8)
                {
                    obstacle32[25].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[56] == 9)
                {
                    obstacle32[25].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[56] == 10)
                {
                    obstacle32[25].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[56] == 11)
                {
                    obstacle32[25].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[56] == 12)
                {
                    obstacle32[25].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[56] == 13)
                {
                    obstacle32[25].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[56] == 14)
                {
                    obstacle32[25].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[56] == 15)
                {
                    obstacle32[25].setPosition(four_SpeedX , four_SpeedY);
                }
            }
            else
            {
                obstacle32[25].setObstacleAlpha(200);
                if(pattern_speed_number[56] == 0)
                {
                    obstacle32[25].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[56] == 1)
                {
                    obstacle32[25].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[56] == 2)
                {
                    obstacle32[25].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[56] == 3)
                {
                    obstacle32[25].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[56] == 4)
                {
                    obstacle32[25].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[56] == 5)
                {
                    obstacle32[25].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[56] == 6)
                {
                    obstacle32[25].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[56] == 7)
                {
                    obstacle32[25].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[56] == 8)
                {
                    obstacle32[25].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[56] == 9)
                {
                    obstacle32[25].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[56] == 10)
                {
                    obstacle32[25].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[56] == 11)
                {
                    obstacle32[25].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[56] == 12)
                {
                    obstacle32[25].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[56] == 13)
                {
                    obstacle32[25].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[56] == 14)
                {
                    obstacle32[25].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[56] == 15)
                {
                    obstacle32[25].setPosition(four_SpeedX , four_SpeedY);
                }
            }
        }
        else
        {
            obstacle32[25].setObstacleAlpha(0);
            obstacle32[25].position_effect();
        }

        if(pattern32[26] == 1)
        {
            if(obstacle32[26].position_x  >= 300*size_dm || obstacle32[26].position_x  <= 10*size_dm || obstacle32[26].position_y <= 90*size_dm ||  obstacle32[26].position_y >=350*size_dm)
            {
                pattern_speed_number[57] = getRandomMath8(15, 0);
                obstacle32[26].setObstacleAlpha(200);
                if(pattern_speed_number[57] == 0)
                {
                    obstacle32[26].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[57] == 1)
                {
                    obstacle32[26].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[57] == 2)
                {
                    obstacle32[26].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[57] == 3)
                {
                    obstacle32[26].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[57] == 4)
                {
                    obstacle32[26].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[57] == 5)
                {
                    obstacle32[26].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[57] == 6)
                {
                    obstacle32[26].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[57] == 7)
                {
                    obstacle32[26].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[57] == 8)
                {
                    obstacle32[26].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[57] == 9)
                {
                    obstacle32[26].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[57] == 10)
                {
                    obstacle32[26].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[57] == 11)
                {
                    obstacle32[26].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[57] == 12)
                {
                    obstacle32[26].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[57] == 13)
                {
                    obstacle32[26].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[57] == 14)
                {
                    obstacle32[26].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[57] == 15)
                {
                    obstacle32[26].setPosition(four_SpeedX , four_SpeedY);
                }
            }
            else
            {
                obstacle32[26].setObstacleAlpha(200);
                if(pattern_speed_number[57] == 0)
                {
                    obstacle32[26].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[57] == 1)
                {
                    obstacle32[26].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[57] == 2)
                {
                    obstacle32[26].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[57] == 3)
                {
                    obstacle32[26].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[57] == 4)
                {
                    obstacle32[26].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[57] == 5)
                {
                    obstacle32[26].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[57] == 6)
                {
                    obstacle32[26].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[57] == 7)
                {
                    obstacle32[26].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[57] == 8)
                {
                    obstacle32[26].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[57] == 9)
                {
                    obstacle32[26].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[57] == 10)
                {
                    obstacle32[26].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[57] == 11)
                {
                    obstacle32[26].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[57] == 12)
                {
                    obstacle32[26].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[57] == 13)
                {
                    obstacle32[26].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[57] == 14)
                {
                    obstacle32[26].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[57] == 15)
                {
                    obstacle32[26].setPosition(four_SpeedX , four_SpeedY);
                }
            }
        }
        else
        {
            obstacle32[26].setObstacleAlpha(0);
            obstacle32[26].position_effect();
        }

        if(pattern32[27] == 1)
        {
            if(obstacle32[27].position_x  >= 300*size_dm || obstacle32[27].position_x  <= 10*size_dm || obstacle32[27].position_y <= 90*size_dm ||  obstacle32[27].position_y >=350*size_dm)
            {
                pattern_speed_number[58] = getRandomMath8(15, 0);
                obstacle32[27].setObstacleAlpha(200);
                if(pattern_speed_number[58] == 0)
                {
                    obstacle32[27].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[58] == 1)
                {
                    obstacle32[27].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[58] == 2)
                {
                    obstacle32[27].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[58] == 3)
                {
                    obstacle32[27].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[58] == 4)
                {
                    obstacle32[27].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[58] == 5)
                {
                    obstacle32[27].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[58] == 6)
                {
                    obstacle32[27].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[58] == 7)
                {
                    obstacle32[27].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[58] == 8)
                {
                    obstacle32[27].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[58] == 9)
                {
                    obstacle32[27].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[58] == 10)
                {
                    obstacle32[27].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[58] == 11)
                {
                    obstacle32[27].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[58] == 12)
                {
                    obstacle32[27].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[58] == 13)
                {
                    obstacle32[27].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[58] == 14)
                {
                    obstacle32[27].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[58] == 15)
                {
                    obstacle32[27].setPosition(four_SpeedX , four_SpeedY);
                }
            }
            else
            {
                obstacle32[27].setObstacleAlpha(200);
                if(pattern_speed_number[58] == 0)
                {
                    obstacle32[27].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[58] == 1)
                {
                    obstacle32[27].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[58] == 2)
                {
                    obstacle32[27].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[58] == 3)
                {
                    obstacle32[27].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[58] == 4)
                {
                    obstacle32[27].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[58] == 5)
                {
                    obstacle32[27].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[58] == 6)
                {
                    obstacle32[27].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[58] == 7)
                {
                    obstacle32[27].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[58] == 8)
                {
                    obstacle32[27].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[58] == 9)
                {
                    obstacle32[27].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[58] == 10)
                {
                    obstacle32[27].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[58] == 11)
                {
                    obstacle32[27].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[58] == 12)
                {
                    obstacle32[27].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[58] == 13)
                {
                    obstacle32[27].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[58] == 14)
                {
                    obstacle32[27].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[58] == 15)
                {
                    obstacle32[27].setPosition(four_SpeedX , four_SpeedY);
                }
            }
        }
        else
        {
            obstacle32[27].setObstacleAlpha(0);
            obstacle32[27].position_effect();
        }

        if(pattern32[28] == 1)
        {
            if(obstacle32[28].position_x  >= 300*size_dm || obstacle32[28].position_x  <= 10*size_dm || obstacle32[28].position_y <= 90*size_dm ||  obstacle32[28].position_y >=350*size_dm)
            {
                pattern_speed_number[59] = getRandomMath8(15, 0);
                obstacle32[28].setObstacleAlpha(200);
                if(pattern_speed_number[59] == 0)
                {
                    obstacle32[28].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[59] == 1)
                {
                    obstacle32[28].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[59] == 2)
                {
                    obstacle32[28].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[59] == 3)
                {
                    obstacle32[28].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[59] == 4)
                {
                    obstacle32[28].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[59] == 5)
                {
                    obstacle32[28].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[59] == 6)
                {
                    obstacle32[28].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[59] == 7)
                {
                    obstacle32[28].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[59] == 8)
                {
                    obstacle32[28].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[59] == 9)
                {
                    obstacle32[28].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[59] == 10)
                {
                    obstacle32[28].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[59] == 11)
                {
                    obstacle32[28].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[59] == 12)
                {
                    obstacle32[28].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[59] == 13)
                {
                    obstacle32[28].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[59] == 14)
                {
                    obstacle32[28].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[59] == 15)
                {
                    obstacle32[28].setPosition(four_SpeedX , four_SpeedY);
                }
            }
            else
            {
                obstacle32[28].setObstacleAlpha(200);
                if(pattern_speed_number[59] == 0)
                {
                    obstacle32[28].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[59] == 1)
                {
                    obstacle32[28].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[59] == 2)
                {
                    obstacle32[28].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[59] == 3)
                {
                    obstacle32[28].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[59] == 4)
                {
                    obstacle32[28].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[59] == 5)
                {
                    obstacle32[28].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[59] == 6)
                {
                    obstacle32[28].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[59] == 7)
                {
                    obstacle32[28].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[59] == 8)
                {
                    obstacle32[28].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[59] == 9)
                {
                    obstacle32[28].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[59] == 10)
                {
                    obstacle32[28].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[59] == 11)
                {
                    obstacle32[28].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[59] == 12)
                {
                    obstacle32[28].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[59] == 13)
                {
                    obstacle32[28].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[59] == 14)
                {
                    obstacle32[28].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[59] == 15)
                {
                    obstacle32[28].setPosition(four_SpeedX , four_SpeedY);
                }
            }
        }
        else
        {
            obstacle32[28].setObstacleAlpha(0);
            obstacle32[28].position_effect();
        }

        if(pattern32[29] == 1)
        {
            if(obstacle32[29].position_x  >= 300*size_dm || obstacle32[29].position_x  <= 10*size_dm || obstacle32[29].position_y <= 90*size_dm ||  obstacle32[29].position_y >=350*size_dm)
            {
                pattern_speed_number[60] = getRandomMath8(15, 0);
                obstacle32[29].setObstacleAlpha(200);
                if(pattern_speed_number[60] == 0)
                {
                    obstacle32[29].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[60] == 1)
                {
                    obstacle32[29].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[60] == 2)
                {
                    obstacle32[29].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[60] == 3)
                {
                    obstacle32[29].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[60] == 4)
                {
                    obstacle32[29].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[60] == 5)
                {
                    obstacle32[29].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[60] == 6)
                {
                    obstacle32[29].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[60] == 7)
                {
                    obstacle32[29].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[60] == 8)
                {
                    obstacle32[29].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[60] == 9)
                {
                    obstacle32[29].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[60] == 10)
                {
                    obstacle32[29].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[60] == 11)
                {
                    obstacle32[29].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[60] == 12)
                {
                    obstacle32[29].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[60] == 13)
                {
                    obstacle32[29].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[60] == 14)
                {
                    obstacle32[29].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[60] == 15)
                {
                    obstacle32[29].setPosition(four_SpeedX , four_SpeedY);
                }
            }
            else
            {
                obstacle32[29].setObstacleAlpha(200);
                if(pattern_speed_number[60] == 0)
                {
                    obstacle32[29].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[60] == 1)
                {
                    obstacle32[29].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[60] == 2)
                {
                    obstacle32[29].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[60] == 3)
                {
                    obstacle32[29].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[60] == 4)
                {
                    obstacle32[29].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[60] == 5)
                {
                    obstacle32[29].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[60] == 6)
                {
                    obstacle32[29].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[60] == 7)
                {
                    obstacle32[29].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[60] == 8)
                {
                    obstacle32[29].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[60] == 9)
                {
                    obstacle32[29].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[60] == 10)
                {
                    obstacle32[29].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[60] == 11)
                {
                    obstacle32[29].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[60] == 12)
                {
                    obstacle32[29].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[60] == 13)
                {
                    obstacle32[29].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[60] == 14)
                {
                    obstacle32[29].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[60] == 15)
                {
                    obstacle32[29].setPosition(four_SpeedX , four_SpeedY);
                }
            }
        }
        else
        {
            obstacle32[29].setObstacleAlpha(0);
            obstacle32[29].position_effect();
        }

        if(pattern32[30] == 1)
        {
            if(obstacle32[30].position_x  >= 300*size_dm || obstacle32[30].position_x  <= 10*size_dm || obstacle32[30].position_y <= 90*size_dm ||  obstacle32[30].position_y >=350*size_dm)
            {
                pattern_speed_number[61] = getRandomMath8(15, 0);
                obstacle32[30].setObstacleAlpha(200);

                if(pattern_speed_number[61] == 0)
                {
                    obstacle32[30].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[61] == 1)
                {
                    obstacle32[30].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[61] == 2)
                {
                    obstacle32[30].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[61] == 3)
                {
                    obstacle32[30].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[61] == 4)
                {
                    obstacle32[30].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[61] == 5)
                {
                    obstacle32[30].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[61] == 6)
                {
                    obstacle32[30].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[61] == 7)
                {
                    obstacle32[30].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[61] == 8)
                {
                    obstacle32[30].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[61] == 9)
                {
                    obstacle32[30].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[61] == 10)
                {
                    obstacle32[30].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[61] == 11)
                {
                    obstacle32[30].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[61] == 12)
                {
                    obstacle32[30].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[61] == 13)
                {
                    obstacle32[30].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[61] == 14)
                {
                    obstacle32[30].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[61] == 15)
                {
                    obstacle32[30].setPosition(four_SpeedX , four_SpeedY);
                }

            }
            else
            {
                obstacle32[30].setObstacleAlpha(200);
                if(pattern_speed_number[61] == 0)
                {
                    obstacle32[30].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[61] == 1)
                {
                    obstacle32[30].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[61] == 2)
                {
                    obstacle32[30].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[61] == 3)
                {
                    obstacle32[30].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[61] == 4)
                {
                    obstacle32[30].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[61] == 5)
                {
                    obstacle32[30].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[61] == 6)
                {
                    obstacle32[30].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[61] == 7)
                {
                    obstacle32[30].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[61] == 8)
                {
                    obstacle32[30].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[61] == 9)
                {
                    obstacle32[30].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[61] == 10)
                {
                    obstacle32[30].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[61] == 11)
                {
                    obstacle32[30].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[61] == 12)
                {
                    obstacle32[30].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[61] == 13)
                {
                    obstacle32[30].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[61] == 14)
                {
                    obstacle32[30].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[61] == 15)
                {
                    obstacle32[30].setPosition(four_SpeedX , four_SpeedY);
                }
            }
        }
        else
        {
            obstacle32[30].setObstacleAlpha(0);
            obstacle32[30].position_effect();
        }

        if(pattern32[31] == 1)
        {
            if(obstacle32[31].position_x  >= 300*size_dm || obstacle32[31].position_x  <= 10*size_dm || obstacle32[31].position_y <= 90*size_dm ||  obstacle32[31].position_y >=350*size_dm)
            {
                pattern_speed_number[62] = getRandomMath8(15, 0);
                obstacle32[31].setObstacleAlpha(200);
                if(pattern_speed_number[62] == 0)
                {
                    obstacle32[31].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[62] == 1)
                {
                    obstacle32[31].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[62] == 2)
                {
                    obstacle32[31].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[62] == 3)
                {
                    obstacle32[31].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[62] == 4)
                {
                    obstacle32[31].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[62] == 5)
                {
                    obstacle32[31].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[62] == 6)
                {
                    obstacle32[31].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[62] == 7)
                {
                    obstacle32[31].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[62] == 8)
                {
                    obstacle32[31].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[62] == 9)
                {
                    obstacle32[31].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[62] == 10)
                {
                    obstacle32[31].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[62] == 11)
                {
                    obstacle32[31].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[62] == 12)
                {
                    obstacle32[31].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[62] == 13)
                {
                    obstacle32[31].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[62] == 14)
                {
                    obstacle32[31].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[62] == 15)
                {
                    obstacle32[31].setPosition(four_SpeedX , four_SpeedY);
                }

            }
            else
            {
                obstacle32[31].setObstacleAlpha(200);
                if(pattern_speed_number[62] == 0)
                {
                    obstacle32[31].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[62] == 1)
                {
                    obstacle32[31].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[62] == 2)
                {
                    obstacle32[31].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[62] == 3)
                {
                    obstacle32[31].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[62] == 4)
                {
                    obstacle32[31].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[62] == 5)
                {
                    obstacle32[31].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[62] == 6)
                {
                    obstacle32[31].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[62] == 7)
                {
                    obstacle32[31].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[62] == 8)
                {
                    obstacle32[31].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[62] == 9)
                {
                    obstacle32[31].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[62] == 10)
                {
                    obstacle32[31].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[62] == 11)
                {
                    obstacle32[31].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[62] == 12)
                {
                    obstacle32[31].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[62] == 13)
                {
                    obstacle32[31].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[62] == 14)
                {
                    obstacle32[31].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[62] == 15)
                {
                    obstacle32[31].setPosition(four_SpeedX , four_SpeedY);
                }
            }
        }
        else
        {
            obstacle32[31].setObstacleAlpha(0);
            obstacle32[31].position_effect();
        }
    }

    void obstacle_moving2()
    {
        if(pattern8[0] == 1)
        {
            if(obstacle8[0].position_x  >= 300*size_dm || obstacle8[0].position_x  <= 10*size_dm || obstacle8[0].position_y <= 90*size_dm ||  obstacle8[0].position_y >=350*size_dm)
            {
                pattern_speed_number[7] = getRandomMath8(15, 0);
                obstacle8[0].setObstacleAlpha(200);
                if(pattern_speed_number[7] == 0)
                {
                    obstacle8[0].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[7] == 1)
                {
                    obstacle8[0].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[7] == 2)
                {
                    obstacle8[0].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[7] == 3)
                {
                    obstacle8[0].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[7] == 4)
                {
                    obstacle8[0].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[7] == 5)
                {
                    obstacle8[0].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[7] == 6)
                {
                    obstacle8[0].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[7] == 7)
                {
                    obstacle8[0].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[7] == 8)
                {
                    obstacle8[0].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[7] == 9)
                {
                    obstacle8[0].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[7] == 10)
                {
                    obstacle8[0].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[7] == 11)
                {
                    obstacle8[0].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[7] == 12)
                {
                    obstacle8[0].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[7] == 13)
                {
                    obstacle8[0].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[7] == 14)
                {
                    obstacle8[0].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[7] == 15)
                {
                    obstacle8[0].setPosition(four_SpeedX , four_SpeedY);
                }
            }
            else
            {
                obstacle8[0].setObstacleAlpha(200);
                if(pattern_speed_number[7] == 0)
                {
                    obstacle8[0].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[7] == 1)
                {
                    obstacle8[0].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[7] == 2)
                {
                    obstacle8[0].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[7] == 3)
                {
                    obstacle8[0].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[7] == 4)
                {
                    obstacle8[0].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[7] == 5)
                {
                    obstacle8[0].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[7] == 6)
                {
                    obstacle8[0].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[7] == 7)
                {
                    obstacle8[0].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[7] == 8)
                {
                    obstacle8[0].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[7] == 9)
                {
                    obstacle8[0].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[7] == 10)
                {
                    obstacle8[0].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[7] == 11)
                {
                    obstacle8[0].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[7] == 12)
                {
                    obstacle8[0].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[7] == 13)
                {
                    obstacle8[0].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[7] == 14)
                {
                    obstacle8[0].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[7] == 15)
                {
                    obstacle8[0].setPosition(four_SpeedX , four_SpeedY);
                }
            }
        }
        else
        {
            obstacle8[0].setObstacleAlpha(0);
            obstacle8[0].position_effect();
        }

        if(pattern8[1] == 1)
        {
            if(obstacle8[1].position_x  >= 300*size_dm || obstacle8[1].position_x  <= 10*size_dm || obstacle8[1].position_y <= 90*size_dm ||  obstacle8[1].position_y >=350*size_dm)
            {
                pattern_speed_number[8] = getRandomMath8(15, 0);
                obstacle8[1].setObstacleAlpha(200);
                if(pattern_speed_number[8] == 0)
                {
                    obstacle8[1].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[8] == 1)
                {
                    obstacle8[1].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[8] == 2)
                {
                    obstacle8[1].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[8] == 3)
                {
                    obstacle8[1].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[8] == 4)
                {
                    obstacle8[1].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[8] == 5)
                {
                    obstacle8[1].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[8] == 6)
                {
                    obstacle8[1].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[8] == 7)
                {
                    obstacle8[1].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[8] == 8)
                {
                    obstacle8[1].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[8] == 9)
                {
                    obstacle8[1].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[8] == 10)
                {
                    obstacle8[1].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[8] == 11)
                {
                    obstacle8[1].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[8] == 12)
                {
                    obstacle8[1].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[8] == 13)
                {
                    obstacle8[1].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[8] == 14)
                {
                    obstacle8[1].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[8] == 15)
                {
                    obstacle8[1].setPosition(four_SpeedX , four_SpeedY);
                }
            }
            else
            {
                obstacle8[1].setObstacleAlpha(200);
                if(pattern_speed_number[8] == 0)
                {
                    obstacle8[1].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[8] == 1)
                {
                    obstacle8[1].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[8] == 2)
                {
                    obstacle8[1].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[8] == 3)
                {
                    obstacle8[1].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[8] == 4)
                {
                    obstacle8[1].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[8] == 5)
                {
                    obstacle8[1].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[8] == 6)
                {
                    obstacle8[1].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[8] == 7)
                {
                    obstacle8[1].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[8] == 8)
                {
                    obstacle8[1].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[8] == 9)
                {
                    obstacle8[1].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[8] == 10)
                {
                    obstacle8[1].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[8] == 11)
                {
                    obstacle8[1].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[8] == 12)
                {
                    obstacle8[1].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[8] == 13)
                {
                    obstacle8[1].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[8] == 14)
                {
                    obstacle8[1].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[8] == 15)
                {
                    obstacle8[1].setPosition(four_SpeedX , four_SpeedY);
                }
            }
        }
        else
        {
            obstacle8[1].setObstacleAlpha(0);
            obstacle8[1].position_effect();
        }

        if(pattern8[2] == 1)
        {
            if(obstacle8[2].position_x  >= 300*size_dm || obstacle8[2].position_x  <= 10*size_dm || obstacle8[2].position_y <= 90*size_dm ||  obstacle8[2].position_y >=350*size_dm)
            {
                pattern_speed_number[9] = getRandomMath8(15, 0);
                obstacle8[2].setObstacleAlpha(200);
                if(pattern_speed_number[9] == 0)
                {
                    obstacle8[2].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[9] == 1)
                {
                    obstacle8[2].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[9] == 2)
                {
                    obstacle8[2].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[9] == 3)
                {
                    obstacle8[2].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[9] == 4)
                {
                    obstacle8[2].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[9] == 5)
                {
                    obstacle8[2].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[9] == 6)
                {
                    obstacle8[2].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[9] == 7)
                {
                    obstacle8[2].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[9] == 8)
                {
                    obstacle8[2].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[9] == 9)
                {
                    obstacle8[2].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[9] == 10)
                {
                    obstacle8[2].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[9] == 11)
                {
                    obstacle8[2].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[9] == 12)
                {
                    obstacle8[2].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[9] == 13)
                {
                    obstacle8[2].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[9] == 14)
                {
                    obstacle8[2].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[9] == 15)
                {
                    obstacle8[2].setPosition(four_SpeedX , four_SpeedY);
                }

            }
            else
            {
                obstacle8[2].setObstacleAlpha(200);
                if(pattern_speed_number[9] == 0)
                {
                    obstacle8[2].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[9] == 1)
                {
                    obstacle8[2].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[9] == 2)
                {
                    obstacle8[2].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[9] == 3)
                {
                    obstacle8[2].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[9] == 4)
                {
                    obstacle8[2].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[9] == 5)
                {
                    obstacle8[2].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[9] == 6)
                {
                    obstacle8[2].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[9] == 7)
                {
                    obstacle8[2].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[9] == 8)
                {
                    obstacle8[2].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[9] == 9)
                {
                    obstacle8[2].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[9] == 10)
                {
                    obstacle8[2].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[9] == 11)
                {
                    obstacle8[2].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[9] == 12)
                {
                    obstacle8[2].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[9] == 13)
                {
                    obstacle8[2].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[9] == 14)
                {
                    obstacle8[2].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[9] == 15)
                {
                    obstacle8[2].setPosition(four_SpeedX , four_SpeedY);
                }
            }
        }
        else
        {
            obstacle8[2].setObstacleAlpha(0);
            obstacle8[2].position_effect();
        }

        if(pattern8[3] == 1)
        {
            if(obstacle8[3].position_x  >= 300*size_dm || obstacle8[3].position_x  <= 10*size_dm || obstacle8[3].position_y <= 90*size_dm ||  obstacle8[3].position_y >=350*size_dm)
            {
                pattern_speed_number[10] = getRandomMath8(15, 0);
                obstacle8[3].setObstacleAlpha(200);
                if(pattern_speed_number[10] == 0)
                {
                    obstacle8[3].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[10] == 1)
                {
                    obstacle8[3].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[10] == 2)
                {
                    obstacle8[3].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[10] == 3)
                {
                    obstacle8[3].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[10] == 4)
                {
                    obstacle8[3].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[10] == 5)
                {
                    obstacle8[3].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[10] == 6)
                {
                    obstacle8[3].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[10] == 7)
                {
                    obstacle8[3].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[10] == 8)
                {
                    obstacle8[3].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[10] == 9)
                {
                    obstacle8[3].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[10] == 10)
                {
                    obstacle8[3].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[10] == 11)
                {
                    obstacle8[3].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[10] == 12)
                {
                    obstacle8[3].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[10] == 13)
                {
                    obstacle8[3].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[10] == 14)
                {
                    obstacle8[3].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[10] == 15)
                {
                    obstacle8[3].setPosition(four_SpeedX , four_SpeedY);
                }

            }
            else
            {
                obstacle8[3].setObstacleAlpha(200);
                if(pattern_speed_number[10] == 0)
                {
                    obstacle8[3].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[10] == 1)
                {
                    obstacle8[3].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[10] == 2)
                {
                    obstacle8[3].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[10] == 3)
                {
                    obstacle8[3].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[10] == 4)
                {
                    obstacle8[3].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[10] == 5)
                {
                    obstacle8[3].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[10] == 6)
                {
                    obstacle8[3].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[10] == 7)
                {
                    obstacle8[3].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[10] == 8)
                {
                    obstacle8[3].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[10] == 9)
                {
                    obstacle8[3].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[10] == 10)
                {
                    obstacle8[3].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[10] == 11)
                {
                    obstacle8[3].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[10] == 12)
                {
                    obstacle8[3].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[10] == 13)
                {
                    obstacle8[3].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[10] == 14)
                {
                    obstacle8[3].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[10] == 15)
                {
                    obstacle8[3].setPosition(four_SpeedX , four_SpeedY);
                }

            }
        }
        else
        {
            obstacle8[3].setObstacleAlpha(0);
            obstacle8[3].position_effect();
        }

        if(pattern8[4] == 1)
        {
            if(obstacle8[4].position_x  >= 300*size_dm || obstacle8[4].position_x  <= 10*size_dm || obstacle8[4].position_y <= 90*size_dm ||  obstacle8[4].position_y >=350*size_dm)
            {
                pattern_speed_number[11] = getRandomMath8(15, 0);
                obstacle8[4].setObstacleAlpha(200);
                if(pattern_speed_number[11] == 0)
                {
                    obstacle8[4].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[11] == 1)
                {
                    obstacle8[4].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[11] == 2)
                {
                    obstacle8[4].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[11] == 3)
                {
                    obstacle8[4].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[11] == 4)
                {
                    obstacle8[4].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[11] == 5)
                {
                    obstacle8[4].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[11] == 6)
                {
                    obstacle8[4].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[11] == 7)
                {
                    obstacle8[4].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[11] == 8)
                {
                    obstacle8[4].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[11] == 9)
                {
                    obstacle8[4].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[11] == 10)
                {
                    obstacle8[4].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[11] == 11)
                {
                    obstacle8[4].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[11] == 12)
                {
                    obstacle8[4].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[11] == 13)
                {
                    obstacle8[4].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[11] == 14)
                {
                    obstacle8[4].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[11] == 15)
                {
                    obstacle8[4].setPosition(four_SpeedX , four_SpeedY);
                }

            }
            else
            {
                obstacle8[4].setObstacleAlpha(200);
                if(pattern_speed_number[11] == 0)
                {
                    obstacle8[4].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[11] == 1)
                {
                    obstacle8[4].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[11] == 2)
                {
                    obstacle8[4].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[11] == 3)
                {
                    obstacle8[4].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[11] == 4)
                {
                    obstacle8[4].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[11] == 5)
                {
                    obstacle8[4].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[11] == 6)
                {
                    obstacle8[4].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[11] == 7)
                {
                    obstacle8[4].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[11] == 8)
                {
                    obstacle8[4].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[11] == 9)
                {
                    obstacle8[4].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[11] == 10)
                {
                    obstacle8[4].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[11] == 11)
                {
                    obstacle8[4].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[11] == 12)
                {
                    obstacle8[4].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[11] == 13)
                {
                    obstacle8[4].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[11] == 14)
                {
                    obstacle8[4].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[11] == 15)
                {
                    obstacle8[4].setPosition(four_SpeedX , four_SpeedY);
                }
            }
        }
        else
        {
            obstacle8[4].setObstacleAlpha(0);
            obstacle8[4].position_effect();
        }

        if(pattern8[5] == 1)
        {
            if(obstacle8[5].position_x  >= 300*size_dm || obstacle8[5].position_x  <= 10*size_dm || obstacle8[5].position_y <= 90*size_dm ||  obstacle8[5].position_y >=350*size_dm)
            {
                pattern_speed_number[12] = getRandomMath8(15, 0);
                obstacle8[5].setObstacleAlpha(200);
                if(pattern_speed_number[12] == 0)
                {
                    obstacle8[5].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[12] == 1)
                {
                    obstacle8[5].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[12] == 2)
                {
                    obstacle8[5].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[12] == 3)
                {
                    obstacle8[5].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[12] == 4)
                {
                    obstacle8[5].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[12] == 5)
                {
                    obstacle8[5].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[12] == 6)
                {
                    obstacle8[5].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[12] == 7)
                {
                    obstacle8[5].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[12] == 8)
                {
                    obstacle8[5].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[12] == 9)
                {
                    obstacle8[5].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[12] == 10)
                {
                    obstacle8[5].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[12] == 11)
                {
                    obstacle8[5].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[12] == 12)
                {
                    obstacle8[5].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[12] == 13)
                {
                    obstacle8[5].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[12] == 14)
                {
                    obstacle8[5].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[12] == 15)
                {
                    obstacle8[5].setPosition(four_SpeedX , four_SpeedY);
                }
            }
            else
            {
                obstacle8[5].setObstacleAlpha(200);
                if(pattern_speed_number[12] == 0)
                {
                    obstacle8[5].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[12] == 1)
                {
                    obstacle8[5].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[12] == 2)
                {
                    obstacle8[5].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[12] == 3)
                {
                    obstacle8[5].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[12] == 4)
                {
                    obstacle8[5].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[12] == 5)
                {
                    obstacle8[5].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[12] == 6)
                {
                    obstacle8[5].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[12] == 7)
                {
                    obstacle8[5].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[12] == 8)
                {
                    obstacle8[5].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[12] == 9)
                {
                    obstacle8[5].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[12] == 10)
                {
                    obstacle8[5].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[12] == 11)
                {
                    obstacle8[5].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[12] == 12)
                {
                    obstacle8[5].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[12] == 13)
                {
                    obstacle8[5].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[12] == 14)
                {
                    obstacle8[5].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[12] == 15)
                {
                    obstacle8[5].setPosition(four_SpeedX , four_SpeedY);
                }
            }
        }
        else
        {
            obstacle8[5].setObstacleAlpha(0);
            obstacle8[5].position_effect();
        }

        if(pattern8[6] == 1)
        {
            if(obstacle8[6].position_x  >= 300*size_dm || obstacle8[6].position_x  <= 10*size_dm || obstacle8[6].position_y <= 90*size_dm ||  obstacle8[6].position_y >=350*size_dm)
            {
                pattern_speed_number[13] = getRandomMath8(15, 0);
                obstacle8[6].setObstacleAlpha(200);
                if(pattern_speed_number[13] == 0)
                {
                    obstacle8[6].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[13] == 1)
                {
                    obstacle8[6].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[13] == 2)
                {
                    obstacle8[6].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[13] == 3)
                {
                    obstacle8[6].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[13] == 4)
                {
                    obstacle8[6].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[13] == 5)
                {
                    obstacle8[6].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[13] == 6)
                {
                    obstacle8[6].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[13] == 7)
                {
                    obstacle8[6].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[13] == 8)
                {
                    obstacle8[6].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[13] == 9)
                {
                    obstacle8[6].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[13] == 10)
                {
                    obstacle8[6].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[13] == 11)
                {
                    obstacle8[6].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[13] == 12)
                {
                    obstacle8[6].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[13] == 13)
                {
                    obstacle8[6].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[13] == 14)
                {
                    obstacle8[6].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[13] == 15)
                {
                    obstacle8[6].setPosition(four_SpeedX , four_SpeedY);
                }
            }
            else
            {
                obstacle8[6].setObstacleAlpha(200);
                if(pattern_speed_number[13] == 0)
                {
                    obstacle8[6].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[13] == 1)
                {
                    obstacle8[6].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[13] == 2)
                {
                    obstacle8[6].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[13] == 3)
                {
                    obstacle8[6].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[13] == 4)
                {
                    obstacle8[6].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[13] == 5)
                {
                    obstacle8[6].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[13] == 6)
                {
                    obstacle8[6].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[13] == 7)
                {
                    obstacle8[6].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[13] == 8)
                {
                    obstacle8[6].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[13] == 9)
                {
                    obstacle8[6].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[13] == 10)
                {
                    obstacle8[6].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[13] == 11)
                {
                    obstacle8[6].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[13] == 12)
                {
                    obstacle8[6].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[13] == 13)
                {
                    obstacle8[6].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[13] == 14)
                {
                    obstacle8[6].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[13] == 15)
                {
                    obstacle8[6].setPosition(four_SpeedX , four_SpeedY);
                }
            }
        }
        else
        {
            obstacle8[6].setObstacleAlpha(0);
            obstacle8[6].position_effect();
        }

        if(pattern8[7] == 1)
        {
            if(obstacle8[7].position_x  >= 300*size_dm || obstacle8[7].position_x  <= 10*size_dm || obstacle8[7].position_y <= 90*size_dm ||  obstacle8[7].position_y >=350*size_dm)
            {
                pattern_speed_number[14] = getRandomMath8(15, 0);
                obstacle8[7].setObstacleAlpha(200);
                if(pattern_speed_number[14] == 0)
                {
                    obstacle8[7].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[14] == 1)
                {
                    obstacle8[7].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[14] == 2)
                {
                    obstacle8[7].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[14] == 3)
                {
                    obstacle8[7].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[14] == 4)
                {
                    obstacle8[7].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[14] == 5)
                {
                    obstacle8[7].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[14] == 6)
                {
                    obstacle8[7].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[14] == 7)
                {
                    obstacle8[7].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[14] == 8)
                {
                    obstacle8[7].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[14] == 9)
                {
                    obstacle8[7].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[14] == 10)
                {
                    obstacle8[7].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[14] == 11)
                {
                    obstacle8[7].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[14] == 12)
                {
                    obstacle8[7].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[14] == 13)
                {
                    obstacle8[7].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[14] == 14)
                {
                    obstacle8[7].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[14] == 15)
                {
                    obstacle8[7].setPosition(four_SpeedX , four_SpeedY);
                }
            }
            else
            {
                obstacle8[7].setObstacleAlpha(200);
                if(pattern_speed_number[14] == 0)
                {
                    obstacle8[7].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[14] == 1)
                {
                    obstacle8[7].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[14] == 2)
                {
                    obstacle8[7].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[14] == 3)
                {
                    obstacle8[7].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[14] == 4)
                {
                    obstacle8[7].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[14] == 5)
                {
                    obstacle8[7].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[14] == 6)
                {
                    obstacle8[7].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[14] == 7)
                {
                    obstacle8[7].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[14] == 8)
                {
                    obstacle8[7].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[14] == 9)
                {
                    obstacle8[7].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[14] == 10)
                {
                    obstacle8[7].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[14] == 11)
                {
                    obstacle8[7].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[14] == 12)
                {
                    obstacle8[7].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[14] == 13)
                {
                    obstacle8[7].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[14] == 14)
                {
                    obstacle8[7].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[14] == 15)
                {
                    obstacle8[7].setPosition(four_SpeedX , four_SpeedY);
                }
            }
        }
        else
        {
            obstacle8[7].setObstacleAlpha(0);
            obstacle8[7].position_effect();
        }
    }

    void obstacle_moving() {
        if (pattern[0] == 1) {
            if (obstacle[0].position_x >= 300 * size_dm || obstacle[0].position_x <= 10 * size_dm || obstacle[0].position_y <= 90 * size_dm || obstacle[0].position_y >= 350 * size_dm) {
                pattern_speed_number[0] = getRandomMath8(15, 0);

                obstacle[0].setObstacleAlpha(200);
                if (pattern_speed_number[0] == 0) {
                    obstacle[0].setPosition(three_SpeedX, three_SpeedY);
                } else if (pattern_speed_number[0] == 1) {
                    obstacle[0].setPosition(two_SpeedX, two_SpeedY);

                } else if (pattern_speed_number[0] == 2) {
                    obstacle[0].setPosition(three_SpeedX, three_SpeedY);

                } else if (pattern_speed_number[0] == 3) {
                    obstacle[0].setPosition(one_SpeedX, one_SpeedY);
                } else if (pattern_speed_number[0] == 4) {
                    obstacle[0].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if (pattern_speed_number[0] == 5) {
                    obstacle[0].setPosition(eleven_SpeedX, eleven_SpeedY = -2);
                } else if (pattern_speed_number[0] == 6) {
                    obstacle[0].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if (pattern_speed_number[0] == 7) {
                    obstacle[0].setPosition(ten_SpeedX, ten_SpeedY);
                } else if (pattern_speed_number[0] == 8) {
                    obstacle[0].setPosition(nine_SpeedX, nine_SpeedY);
                } else if (pattern_speed_number[0] == 9) {
                    obstacle[0].setPosition(eight_SpeedX, eight_SpeedY);
                } else if (pattern_speed_number[0] == 10) {
                    obstacle[0].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if (pattern_speed_number[0] == 11) {
                    obstacle[0].setPosition(seven_SpeedX, seven_SpeedY);
                } else if (pattern_speed_number[0] == 12) {
                    obstacle[0].setPosition(six_SpeedX, six_SpeedY);
                } else if (pattern_speed_number[0] == 13) {
                    obstacle[0].setPosition(five_SpeedX, five_SpeedY);
                } else if (pattern_speed_number[0] == 14) {
                    obstacle[0].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if (pattern_speed_number[0] == 15) {
                    obstacle[0].setPosition(four_SpeedX, four_SpeedY);
                }

            } else {

                obstacle[0].setObstacleAlpha(200);
                if (pattern_speed_number[0] == 0) {
                    obstacle[0].setPosition(three_SpeedX, three_SpeedY);
                } else if (pattern_speed_number[0] == 1) {
                    obstacle[0].setPosition(two_SpeedX, two_SpeedY);

                } else if (pattern_speed_number[0] == 2) {
                    obstacle[0].setPosition(three_SpeedX, three_SpeedY);

                } else if (pattern_speed_number[0] == 3) {
                    obstacle[0].setPosition(one_SpeedX, one_SpeedY);
                } else if (pattern_speed_number[0] == 4) {
                    obstacle[0].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if (pattern_speed_number[0] == 5) {
                    obstacle[0].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if (pattern_speed_number[0] == 6) {
                    obstacle[0].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if (pattern_speed_number[0] == 7) {
                    obstacle[0].setPosition(ten_SpeedX, ten_SpeedY);
                } else if (pattern_speed_number[0] == 8) {
                    obstacle[0].setPosition(nine_SpeedX, nine_SpeedY);
                } else if (pattern_speed_number[0] == 9) {
                    obstacle[0].setPosition(eight_SpeedX, eight_SpeedY);
                } else if (pattern_speed_number[0] == 10) {
                    obstacle[0].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if (pattern_speed_number[0] == 11) {
                    obstacle[0].setPosition(seven_SpeedX, seven_SpeedY);
                } else if (pattern_speed_number[0] == 12) {
                    obstacle[0].setPosition(six_SpeedX, six_SpeedY);
                } else if (pattern_speed_number[0] == 13) {
                    obstacle[0].setPosition(five_SpeedX, five_SpeedY);
                } else if (pattern_speed_number[0] == 14) {
                    obstacle[0].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if (pattern_speed_number[0] == 15) {
                    obstacle[0].setPosition(four_SpeedX, four_SpeedY);
                }
            }
        }
        else
        {
            obstacle[0].setObstacleAlpha(0);
            obstacle[0].position_effect();
        }

        if (pattern2[0] == 1) {
            if (obstacle2[0].position_x >= 300 * size_dm || obstacle2[0].position_x <= 10 * size_dm || obstacle2[0].position_y <= 90 * size_dm || obstacle2[0].position_y >= 350 * size_dm) {
                pattern_speed_number[1] = getRandomMath8(15, 0);
                obstacle2[0].setObstacleAlpha(200);
                if (pattern_speed_number[1] == 0) {
                    obstacle2[0].setPosition(three_SpeedX, three_SpeedY);
                } else if (pattern_speed_number[1] == 1) {
                    obstacle2[0].setPosition(two_SpeedX, two_SpeedY);

                } else if (pattern_speed_number[1] == 2) {
                    obstacle2[0].setPosition(three_SpeedX, three_SpeedY);

                } else if (pattern_speed_number[1] == 3) {
                    obstacle2[0].setPosition(one_SpeedX, one_SpeedY);
                } else if (pattern_speed_number[1] == 4) {
                    obstacle2[0].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if (pattern_speed_number[1] == 5) {
                    obstacle2[0].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if (pattern_speed_number[1] == 6) {
                    obstacle2[0].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if (pattern_speed_number[1] == 7) {
                    obstacle2[0].setPosition(ten_SpeedX, ten_SpeedY);
                } else if (pattern_speed_number[1] == 8) {
                    obstacle2[0].setPosition(nine_SpeedX, nine_SpeedY);
                } else if (pattern_speed_number[1] == 9) {
                    obstacle2[0].setPosition(eight_SpeedX, eight_SpeedY);
                } else if (pattern_speed_number[1] == 10) {
                    obstacle2[0].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if (pattern_speed_number[1] == 11) {
                    obstacle2[0].setPosition(seven_SpeedX, seven_SpeedY);
                } else if (pattern_speed_number[1] == 12) {
                    obstacle2[0].setPosition(six_SpeedX, six_SpeedY);
                } else if (pattern_speed_number[1] == 13) {
                    obstacle2[0].setPosition(five_SpeedX, five_SpeedY);
                } else if (pattern_speed_number[1] == 14) {
                    obstacle2[0].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if (pattern_speed_number[1] == 15) {
                    obstacle2[0].setPosition(four_SpeedX, four_SpeedY);
                }
            } else {
                obstacle2[0].setObstacleAlpha(200);
                if (pattern_speed_number[1] == 0) {
                    obstacle2[0].setPosition(three_SpeedX, three_SpeedY);
                } else if (pattern_speed_number[1] == 1) {
                    obstacle2[0].setPosition(two_SpeedX, two_SpeedY);

                } else if (pattern_speed_number[1] == 2) {
                    obstacle2[0].setPosition(three_SpeedX, three_SpeedY);

                } else if (pattern_speed_number[1] == 3) {
                    obstacle2[0].setPosition(one_SpeedX, one_SpeedY);
                } else if (pattern_speed_number[1] == 4) {
                    obstacle2[0].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if (pattern_speed_number[1] == 5) {
                    obstacle2[0].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if (pattern_speed_number[1] == 6) {
                    obstacle2[0].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if (pattern_speed_number[1] == 7) {
                    obstacle2[0].setPosition(ten_SpeedX, ten_SpeedY);
                } else if (pattern_speed_number[1] == 8) {
                    obstacle2[0].setPosition(nine_SpeedX, nine_SpeedY);
                } else if (pattern_speed_number[1] == 9) {
                    obstacle2[0].setPosition(eight_SpeedX, eight_SpeedY);
                } else if (pattern_speed_number[1] == 10) {
                    obstacle2[0].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if (pattern_speed_number[1] == 11) {
                    obstacle2[0].setPosition(seven_SpeedX, seven_SpeedY);
                } else if (pattern_speed_number[1] == 12) {
                    obstacle2[0].setPosition(six_SpeedX, six_SpeedY);
                } else if (pattern_speed_number[1] == 13) {
                    obstacle2[0].setPosition(five_SpeedX, five_SpeedY);
                } else if (pattern_speed_number[1] == 14) {
                    obstacle2[0].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if (pattern_speed_number[1] == 15) {
                    obstacle2[0].setPosition(four_SpeedX, four_SpeedY);
                }
            }
        }
        else
        {
            obstacle2[0].setObstacleAlpha(0);
            obstacle2[0].position_effect();
        }

        if (pattern2[1] == 1) {
            if (obstacle2[1].position_x >= 300 * size_dm || obstacle2[1].position_x <= 10 * size_dm || obstacle2[1].position_y <= 90 * size_dm || obstacle2[1].position_y >= 350 * size_dm) {
                pattern_speed_number[2] = getRandomMath8(15, 0);

                obstacle2[1].setObstacleAlpha(200);
                if (pattern_speed_number[2] == 0) {
                    obstacle2[1].setPosition(three_SpeedX, three_SpeedY);
                } else if (pattern_speed_number[2] == 1) {
                    obstacle2[1].setPosition(two_SpeedX, two_SpeedY);

                } else if (pattern_speed_number[2] == 2) {
                    obstacle2[1].setPosition(three_SpeedX, three_SpeedY);

                } else if (pattern_speed_number[2] == 3) {
                    obstacle2[1].setPosition(one_SpeedX, one_SpeedY);
                } else if (pattern_speed_number[2] == 4) {
                    obstacle2[1].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if (pattern_speed_number[2] == 5) {
                    obstacle2[1].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if (pattern_speed_number[2] == 6) {
                    obstacle2[1].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if (pattern_speed_number[2] == 7) {
                    obstacle2[1].setPosition(ten_SpeedX, ten_SpeedY);
                } else if (pattern_speed_number[2] == 8) {
                    obstacle2[1].setPosition(nine_SpeedX, nine_SpeedY);
                } else if (pattern_speed_number[2] == 9) {
                    obstacle2[1].setPosition(eight_SpeedX, eight_SpeedY);
                } else if (pattern_speed_number[2] == 10) {
                    obstacle2[1].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if (pattern_speed_number[2] == 11) {
                    obstacle2[1].setPosition(seven_SpeedX, seven_SpeedY);
                } else if (pattern_speed_number[2] == 12) {
                    obstacle2[1].setPosition(six_SpeedX, six_SpeedY);
                } else if (pattern_speed_number[2] == 13) {
                    obstacle2[1].setPosition(five_SpeedX, five_SpeedY);
                } else if (pattern_speed_number[2] == 14) {
                    obstacle2[1].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if (pattern_speed_number[2] == 15) {
                    obstacle2[1].setPosition(four_SpeedX, four_SpeedY);
                }
            } else {
                obstacle2[1].setObstacleAlpha(200);
                if (pattern_speed_number[2] == 0) {
                    obstacle2[1].setPosition(three_SpeedX, three_SpeedY);
                } else if (pattern_speed_number[2] == 1) {
                    obstacle2[1].setPosition(two_SpeedX, two_SpeedY);

                } else if (pattern_speed_number[2] == 2) {
                    obstacle2[1].setPosition(three_SpeedX, three_SpeedY);

                } else if (pattern_speed_number[2] == 3) {
                    obstacle2[1].setPosition(one_SpeedX, one_SpeedY);
                } else if (pattern_speed_number[2] == 4) {
                    obstacle2[1].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if (pattern_speed_number[2] == 5) {
                    obstacle2[1].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if (pattern_speed_number[2] == 6) {
                    obstacle2[1].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if (pattern_speed_number[2] == 7) {
                    obstacle2[1].setPosition(ten_SpeedX, ten_SpeedY);
                } else if (pattern_speed_number[2] == 8) {
                    obstacle2[1].setPosition(nine_SpeedX, nine_SpeedY);
                } else if (pattern_speed_number[2] == 9) {
                    obstacle2[1].setPosition(eight_SpeedX, eight_SpeedY);
                } else if (pattern_speed_number[2] == 10) {
                    obstacle2[1].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if (pattern_speed_number[2] == 11) {
                    obstacle2[1].setPosition(seven_SpeedX, seven_SpeedY);
                } else if (pattern_speed_number[2] == 12) {
                    obstacle2[1].setPosition(six_SpeedX, six_SpeedY);
                } else if (pattern_speed_number[2] == 13) {
                    obstacle2[1].setPosition(five_SpeedX, five_SpeedY);
                } else if (pattern_speed_number[2] == 14) {
                    obstacle2[1].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if (pattern_speed_number[2] == 15) {
                    obstacle2[1].setPosition(four_SpeedX, four_SpeedY);
                }
            }
        }
        else
        {
            obstacle2[1].setObstacleAlpha(0);
            obstacle2[1].position_effect();
        }

        if (pattern4[0] == 1) {
            if (obstacle4[0].position_x >= 300 * size_dm || obstacle4[0].position_x <= 10 * size_dm || obstacle4[0].position_y <= 90 * size_dm || obstacle4[0].position_y >= 350 * size_dm) {
                pattern_speed_number[3] = getRandomMath8(15, 0);
                obstacle4[0].setObstacleAlpha(200);
                if (pattern_speed_number[3] == 0) {
                    obstacle4[0].setPosition(three_SpeedX, three_SpeedY);
                } else if (pattern_speed_number[3] == 1) {
                    obstacle4[0].setPosition(two_SpeedX, two_SpeedY);

                } else if (pattern_speed_number[3] == 2) {
                    obstacle4[0].setPosition(three_SpeedX, three_SpeedY);

                } else if (pattern_speed_number[3] == 3) {
                    obstacle4[0].setPosition(one_SpeedX, one_SpeedY);
                } else if (pattern_speed_number[3] == 4) {
                    obstacle4[0].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if (pattern_speed_number[3] == 5) {
                    obstacle4[0].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if (pattern_speed_number[3] == 6) {
                    obstacle4[0].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if (pattern_speed_number[3] == 7) {
                    obstacle4[0].setPosition(ten_SpeedX, ten_SpeedY);
                } else if (pattern_speed_number[3] == 8) {
                    obstacle4[0].setPosition(nine_SpeedX, nine_SpeedY);
                } else if (pattern_speed_number[3] == 9) {
                    obstacle4[0].setPosition(eight_SpeedX, eight_SpeedY);
                } else if (pattern_speed_number[3] == 10) {
                    obstacle4[0].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if (pattern_speed_number[3] == 11) {
                    obstacle4[0].setPosition(seven_SpeedX, seven_SpeedY);
                } else if (pattern_speed_number[3] == 12) {
                    obstacle4[0].setPosition(six_SpeedX, six_SpeedY);
                } else if (pattern_speed_number[3] == 13) {
                    obstacle4[0].setPosition(five_SpeedX, five_SpeedY);
                } else if (pattern_speed_number[3] == 14) {
                    obstacle4[0].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if (pattern_speed_number[3] == 15) {
                    obstacle4[0].setPosition(four_SpeedX, four_SpeedY);
                }

            } else {
                obstacle4[0].setObstacleAlpha(200);
                if (pattern_speed_number[3] == 0) {
                    obstacle4[0].setPosition(three_SpeedX, three_SpeedY);
                } else if (pattern_speed_number[3] == 1) {
                    obstacle4[0].setPosition(two_SpeedX, two_SpeedY);

                } else if (pattern_speed_number[3] == 2) {
                    obstacle4[0].setPosition(three_SpeedX, three_SpeedY);

                } else if (pattern_speed_number[3] == 3) {
                    obstacle4[0].setPosition(one_SpeedX, one_SpeedY);
                } else if (pattern_speed_number[3] == 4) {
                    obstacle4[0].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if (pattern_speed_number[3] == 5) {
                    obstacle4[0].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if (pattern_speed_number[3] == 6) {
                    obstacle4[0].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if (pattern_speed_number[3] == 7) {
                    obstacle4[0].setPosition(ten_SpeedX, ten_SpeedY);
                } else if (pattern_speed_number[3] == 8) {
                    obstacle4[0].setPosition(nine_SpeedX, nine_SpeedY);
                } else if (pattern_speed_number[3] == 9) {
                    obstacle4[0].setPosition(eight_SpeedX, eight_SpeedY);
                } else if (pattern_speed_number[3] == 10) {
                    obstacle4[0].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if (pattern_speed_number[3] == 11) {
                    obstacle4[0].setPosition(seven_SpeedX, seven_SpeedY);
                } else if (pattern_speed_number[3] == 12) {
                    obstacle4[0].setPosition(six_SpeedX, six_SpeedY);
                } else if (pattern_speed_number[3] == 13) {
                    obstacle4[0].setPosition(five_SpeedX, five_SpeedY);
                } else if (pattern_speed_number[3] == 14) {
                    obstacle4[0].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if (pattern_speed_number[3] == 15) {
                    obstacle4[0].setPosition(four_SpeedX, four_SpeedY);
                }
            }
        }
        else
        {
            obstacle4[0].setObstacleAlpha(0);
            obstacle4[0].position_effect();
        }

        if (pattern4[1] == 1) {
            if (obstacle4[1].position_x >= 300 * size_dm || obstacle4[1].position_x <= 10 * size_dm || obstacle4[1].position_y <= 90 * size_dm || obstacle4[1].position_y >= 350 * size_dm) {
                pattern_speed_number[4] = getRandomMath8(15, 0);
                obstacle4[1].setObstacleAlpha(200);
                if (pattern_speed_number[4] == 0) {
                    obstacle4[1].setPosition(three_SpeedX, three_SpeedY);
                } else if (pattern_speed_number[4] == 1) {
                    obstacle4[1].setPosition(two_SpeedX, two_SpeedY);

                } else if (pattern_speed_number[4] == 2) {
                    obstacle4[1].setPosition(three_SpeedX, three_SpeedY);

                } else if (pattern_speed_number[4] == 3) {
                    obstacle4[1].setPosition(one_SpeedX, one_SpeedY);
                } else if (pattern_speed_number[4] == 4) {
                    obstacle4[1].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if (pattern_speed_number[4] == 5) {
                    obstacle4[1].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if (pattern_speed_number[4] == 6) {
                    obstacle4[1].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if (pattern_speed_number[4] == 7) {
                    obstacle4[1].setPosition(ten_SpeedX, ten_SpeedY);
                } else if (pattern_speed_number[4] == 8) {
                    obstacle4[1].setPosition(nine_SpeedX, nine_SpeedY);
                } else if (pattern_speed_number[4] == 9) {
                    obstacle4[1].setPosition(eight_SpeedX, eight_SpeedY);
                } else if (pattern_speed_number[4] == 10) {
                    obstacle4[1].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if (pattern_speed_number[4] == 11) {
                    obstacle4[1].setPosition(seven_SpeedX, seven_SpeedY);
                } else if (pattern_speed_number[4] == 12) {
                    obstacle4[1].setPosition(six_SpeedX, six_SpeedY);
                } else if (pattern_speed_number[4] == 13) {
                    obstacle4[1].setPosition(five_SpeedX, five_SpeedY);
                } else if (pattern_speed_number[4] == 14) {
                    obstacle4[1].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if (pattern_speed_number[4] == 15) {
                    obstacle4[1].setPosition(four_SpeedX, four_SpeedY);
                }

            } else {
                obstacle4[1].setObstacleAlpha(200);
                if (pattern_speed_number[4] == 0) {
                    obstacle4[1].setPosition(three_SpeedX, three_SpeedY);
                } else if (pattern_speed_number[4] == 1) {
                    obstacle4[1].setPosition(two_SpeedX, two_SpeedY);

                } else if (pattern_speed_number[4] == 2) {
                    obstacle4[1].setPosition(three_SpeedX, three_SpeedY);

                } else if (pattern_speed_number[4] == 3) {
                    obstacle4[1].setPosition(one_SpeedX, one_SpeedY);
                } else if (pattern_speed_number[4] == 4) {
                    obstacle4[1].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if (pattern_speed_number[4] == 5) {
                    obstacle4[1].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if (pattern_speed_number[4] == 6) {
                    obstacle4[1].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if (pattern_speed_number[4] == 7) {
                    obstacle4[1].setPosition(ten_SpeedX, ten_SpeedY);
                } else if (pattern_speed_number[4] == 8) {
                    obstacle4[1].setPosition(nine_SpeedX, nine_SpeedY);
                } else if (pattern_speed_number[4] == 9) {
                    obstacle4[1].setPosition(eight_SpeedX, eight_SpeedY);
                } else if (pattern_speed_number[4] == 10) {
                    obstacle4[1].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if (pattern_speed_number[4] == 11) {
                    obstacle4[1].setPosition(seven_SpeedX, seven_SpeedY);
                } else if (pattern_speed_number[4] == 12) {
                    obstacle4[1].setPosition(six_SpeedX, six_SpeedY);
                } else if (pattern_speed_number[4] == 13) {
                    obstacle4[1].setPosition(five_SpeedX, five_SpeedY);
                } else if (pattern_speed_number[4] == 14) {
                    obstacle4[1].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if (pattern_speed_number[4] == 15) {
                    obstacle4[1].setPosition(four_SpeedX, four_SpeedY);
                }
            }
        }
        else
        {
            obstacle4[1].setObstacleAlpha(0);
            obstacle4[1].position_effect();
        }

        if (pattern4[2] == 1) {
            if (obstacle4[2].position_x >= 300 * size_dm || obstacle4[2].position_x <= 10 * size_dm || obstacle4[2].position_y <= 90 * size_dm || obstacle4[2].position_y >= 350 * size_dm) {
                pattern_speed_number[5] = getRandomMath8(15, 0);
                obstacle4[2].setObstacleAlpha(200);
                if (pattern_speed_number[5] == 0) {
                    obstacle4[2].setPosition(three_SpeedX, three_SpeedY);
                } else if (pattern_speed_number[5] == 1) {
                    obstacle4[2].setPosition(two_SpeedX, two_SpeedY);

                } else if (pattern_speed_number[5] == 2) {
                    obstacle4[2].setPosition(three_SpeedX, three_SpeedY);

                } else if (pattern_speed_number[5] == 3) {
                    obstacle4[2].setPosition(one_SpeedX, one_SpeedY);
                } else if (pattern_speed_number[5] == 4) {
                    obstacle4[2].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if (pattern_speed_number[5] == 5) {
                    obstacle4[2].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if (pattern_speed_number[5] == 6) {
                    obstacle4[2].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if (pattern_speed_number[5] == 7) {
                    obstacle4[2].setPosition(ten_SpeedX, ten_SpeedY);
                } else if (pattern_speed_number[5] == 8) {
                    obstacle4[2].setPosition(nine_SpeedX, nine_SpeedY);
                } else if (pattern_speed_number[5] == 9) {
                    obstacle4[2].setPosition(eight_SpeedX, eight_SpeedY);
                } else if (pattern_speed_number[5] == 10) {
                    obstacle4[2].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if (pattern_speed_number[5] == 11) {
                    obstacle4[2].setPosition(seven_SpeedX, seven_SpeedY);
                } else if (pattern_speed_number[5] == 12) {
                    obstacle4[2].setPosition(six_SpeedX, six_SpeedY);
                } else if (pattern_speed_number[5] == 13) {
                    obstacle4[2].setPosition(five_SpeedX, five_SpeedY);
                } else if (pattern_speed_number[5] == 14) {
                    obstacle4[2].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if (pattern_speed_number[5] == 15) {
                    obstacle4[2].setPosition(four_SpeedX, four_SpeedY);
                }

            } else {
                obstacle4[2].setObstacleAlpha(200);
                if (pattern_speed_number[5] == 0) {
                    obstacle4[2].setPosition(three_SpeedX, three_SpeedY);
                } else if (pattern_speed_number[5] == 1) {
                    obstacle4[2].setPosition(two_SpeedX, two_SpeedY);

                } else if (pattern_speed_number[5] == 2) {
                    obstacle4[2].setPosition(three_SpeedX, three_SpeedY);

                } else if (pattern_speed_number[5] == 3) {
                    obstacle4[2].setPosition(one_SpeedX, one_SpeedY);
                } else if (pattern_speed_number[5] == 4) {
                    obstacle4[2].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if (pattern_speed_number[5] == 5) {
                    obstacle4[2].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if (pattern_speed_number[5] == 6) {
                    obstacle4[2].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if (pattern_speed_number[5] == 7) {
                    obstacle4[2].setPosition(ten_SpeedX, ten_SpeedY);
                } else if (pattern_speed_number[5] == 8) {
                    obstacle4[2].setPosition(nine_SpeedX, nine_SpeedY);
                } else if (pattern_speed_number[5] == 9) {
                    obstacle4[2].setPosition(eight_SpeedX, eight_SpeedY);
                } else if (pattern_speed_number[5] == 10) {
                    obstacle4[2].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if (pattern_speed_number[5] == 11) {
                    obstacle4[2].setPosition(seven_SpeedX, seven_SpeedY);
                } else if (pattern_speed_number[5] == 12) {
                    obstacle4[2].setPosition(six_SpeedX, six_SpeedY);
                } else if (pattern_speed_number[5] == 13) {
                    obstacle4[2].setPosition(five_SpeedX, five_SpeedY);
                } else if (pattern_speed_number[5] == 14) {
                    obstacle4[2].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if (pattern_speed_number[5] == 15) {
                    obstacle4[2].setPosition(four_SpeedX, four_SpeedY);
                }
            }
        }
        else
        {
            obstacle4[2].setObstacleAlpha(0);
            obstacle4[2].position_effect();
        }


        if (pattern4[3] == 1) {
            if (obstacle4[3].position_x >= 300 * size_dm || obstacle4[3].position_x <= 10 * size_dm || obstacle4[3].position_y <= 90 * size_dm || obstacle4[3].position_y >= 350 * size_dm) {
                pattern_speed_number[6] = getRandomMath8(15, 0);
                obstacle4[3].setObstacleAlpha(200);
                if (pattern_speed_number[6] == 0) {
                    obstacle4[3].setPosition(three_SpeedX, three_SpeedY);
                } else if (pattern_speed_number[6] == 1) {
                    obstacle4[3].setPosition(two_SpeedX, two_SpeedY);

                } else if (pattern_speed_number[6] == 2) {
                    obstacle4[3].setPosition(three_SpeedX, three_SpeedY);

                } else if (pattern_speed_number[6] == 3) {
                    obstacle4[3].setPosition(one_SpeedX, one_SpeedY);
                } else if (pattern_speed_number[6] == 4) {
                    obstacle4[3].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if (pattern_speed_number[6] == 5) {
                    obstacle4[3].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if (pattern_speed_number[6] == 6) {
                    obstacle4[3].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if (pattern_speed_number[6] == 7) {
                    obstacle4[3].setPosition(ten_SpeedX, ten_SpeedY);
                } else if (pattern_speed_number[6] == 8) {
                    obstacle4[3].setPosition(nine_SpeedX, nine_SpeedY);
                } else if (pattern_speed_number[6] == 9) {
                    obstacle4[3].setPosition(eight_SpeedX, eight_SpeedY);
                } else if (pattern_speed_number[6] == 10) {
                    obstacle4[3].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if (pattern_speed_number[6] == 11) {
                    obstacle4[3].setPosition(seven_SpeedX, seven_SpeedY);
                } else if (pattern_speed_number[6] == 12) {
                    obstacle4[3].setPosition(six_SpeedX, six_SpeedY);
                } else if (pattern_speed_number[6] == 13) {
                    obstacle4[3].setPosition(five_SpeedX, five_SpeedY);
                } else if (pattern_speed_number[6] == 14) {
                    obstacle4[3].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if (pattern_speed_number[6] == 15) {
                    obstacle4[3].setPosition(four_SpeedX, four_SpeedY);
                }
            } else {
                obstacle4[3].setObstacleAlpha(200);
                if (pattern_speed_number[6] == 0) {
                    obstacle4[3].setPosition(three_SpeedX, three_SpeedY);
                } else if (pattern_speed_number[6] == 1) {
                    obstacle4[3].setPosition(two_SpeedX, two_SpeedY);

                } else if (pattern_speed_number[6] == 2) {
                    obstacle4[3].setPosition(three_SpeedX, three_SpeedY);

                } else if (pattern_speed_number[6] == 3) {
                    obstacle4[3].setPosition(one_SpeedX, one_SpeedY);
                } else if (pattern_speed_number[6] == 4) {
                    obstacle4[3].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if (pattern_speed_number[6] == 5) {
                    obstacle4[3].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if (pattern_speed_number[6] == 6) {
                    obstacle4[3].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if (pattern_speed_number[6] == 7) {
                    obstacle4[3].setPosition(ten_SpeedX, ten_SpeedY);
                } else if (pattern_speed_number[6] == 8) {
                    obstacle4[3].setPosition(nine_SpeedX, nine_SpeedY);
                } else if (pattern_speed_number[6] == 9) {
                    obstacle4[3].setPosition(eight_SpeedX, eight_SpeedY);
                } else if (pattern_speed_number[6] == 10) {
                    obstacle4[3].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if (pattern_speed_number[6] == 11) {
                    obstacle4[3].setPosition(seven_SpeedX, seven_SpeedY);
                } else if (pattern_speed_number[6] == 12) {
                    obstacle4[3].setPosition(six_SpeedX, six_SpeedY);
                } else if (pattern_speed_number[6] == 13) {
                    obstacle4[3].setPosition(five_SpeedX, five_SpeedY);
                } else if (pattern_speed_number[6] == 14) {
                    obstacle4[3].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if (pattern_speed_number[6] == 15) {
                    obstacle4[3].setPosition(four_SpeedX, four_SpeedY);
                }
            }
        }
        else
        {
            obstacle4[3].setObstacleAlpha(0);
            obstacle4[3].position_effect();
        }


        if (pattern16[0] == 1) {
            if (obstacle16[0].position_x >= 300 * size_dm || obstacle16[0].position_x <= 10 * size_dm || obstacle16[0].position_y <= 90 * size_dm || obstacle16[0].position_y >= 350 * size_dm) {
                pattern_speed_number[15] = getRandomMath8(15, 0);
                obstacle16[0].setObstacleAlpha(200);
                if (pattern_speed_number[15] == 0) {
                    obstacle16[0].setPosition(three_SpeedX, three_SpeedY);
                } else if (pattern_speed_number[15] == 1) {
                    obstacle16[0].setPosition(two_SpeedX, two_SpeedY);

                } else if (pattern_speed_number[15] == 2) {
                    obstacle16[0].setPosition(three_SpeedX, three_SpeedY);

                } else if (pattern_speed_number[15] == 3) {
                    obstacle16[0].setPosition(one_SpeedX, one_SpeedY);
                } else if (pattern_speed_number[15] == 4) {
                    obstacle16[0].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if (pattern_speed_number[15] == 5) {
                    obstacle16[0].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if (pattern_speed_number[15] == 6) {
                    obstacle16[0].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if (pattern_speed_number[15] == 7) {
                    obstacle16[0].setPosition(ten_SpeedX, ten_SpeedY);
                } else if (pattern_speed_number[15] == 8) {
                    obstacle16[0].setPosition(nine_SpeedX, nine_SpeedY);
                } else if (pattern_speed_number[15] == 9) {
                    obstacle16[0].setPosition(eight_SpeedX, eight_SpeedY);
                } else if (pattern_speed_number[15] == 10) {
                    obstacle16[0].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if (pattern_speed_number[15] == 11) {
                    obstacle16[0].setPosition(seven_SpeedX, seven_SpeedY);
                } else if (pattern_speed_number[15] == 12) {
                    obstacle16[0].setPosition(six_SpeedX, six_SpeedY);
                } else if (pattern_speed_number[15] == 13) {
                    obstacle16[0].setPosition(five_SpeedX, five_SpeedY);
                } else if (pattern_speed_number[15] == 14) {
                    obstacle16[0].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if (pattern_speed_number[15] == 15) {
                    obstacle16[0].setPosition(four_SpeedX, four_SpeedY);
                }
            } else {
                obstacle16[0].setObstacleAlpha(200);
                if (pattern_speed_number[15] == 0) {
                    obstacle16[0].setPosition(three_SpeedX, three_SpeedY);
                } else if (pattern_speed_number[15] == 1) {
                    obstacle16[0].setPosition(two_SpeedX, two_SpeedY);

                } else if (pattern_speed_number[15] == 2) {
                    obstacle16[0].setPosition(three_SpeedX, three_SpeedY);

                } else if (pattern_speed_number[15] == 3) {
                    obstacle16[0].setPosition(one_SpeedX, one_SpeedY);
                } else if (pattern_speed_number[15] == 4) {
                    obstacle16[0].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if (pattern_speed_number[15] == 5) {
                    obstacle16[0].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if (pattern_speed_number[15] == 6) {
                    obstacle16[0].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if (pattern_speed_number[15] == 7) {
                    obstacle16[0].setPosition(ten_SpeedX, ten_SpeedY);
                } else if (pattern_speed_number[15] == 8) {
                    obstacle16[0].setPosition(nine_SpeedX, nine_SpeedY);
                } else if (pattern_speed_number[15] == 9) {
                    obstacle16[0].setPosition(eight_SpeedX, eight_SpeedY);
                } else if (pattern_speed_number[15] == 10) {
                    obstacle16[0].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if (pattern_speed_number[15] == 11) {
                    obstacle16[0].setPosition(seven_SpeedX, seven_SpeedY);
                } else if (pattern_speed_number[15] == 12) {
                    obstacle16[0].setPosition(six_SpeedX, six_SpeedY);
                } else if (pattern_speed_number[15] == 13) {
                    obstacle16[0].setPosition(five_SpeedX, five_SpeedY);
                } else if (pattern_speed_number[15] == 14) {
                    obstacle16[0].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if (pattern_speed_number[15] == 15) {
                    obstacle16[0].setPosition(four_SpeedX, four_SpeedY);
                }
            }
        }
        else
        {
            obstacle16[0].setObstacleAlpha(0);
            obstacle16[0].position_effect();
        }

        if (pattern16[1] == 1) {
            if (obstacle16[1].position_x >= 300 * size_dm || obstacle16[1].position_x <= 10 * size_dm || obstacle16[1].position_y <= 90 * size_dm || obstacle16[1].position_y >= 350 * size_dm) {
                pattern_speed_number[16] = getRandomMath8(15, 0);
                obstacle16[1].setObstacleAlpha(200);
                if (pattern_speed_number[16] == 0) {
                    obstacle16[1].setPosition(three_SpeedX, three_SpeedY);
                } else if (pattern_speed_number[16] == 1) {
                    obstacle16[1].setPosition(two_SpeedX, two_SpeedY);

                } else if (pattern_speed_number[16] == 2) {
                    obstacle16[1].setPosition(three_SpeedX, three_SpeedY);

                } else if (pattern_speed_number[16] == 3) {
                    obstacle16[1].setPosition(one_SpeedX, one_SpeedY);
                } else if (pattern_speed_number[16] == 4) {
                    obstacle16[1].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if (pattern_speed_number[16] == 5) {
                    obstacle16[1].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if (pattern_speed_number[16] == 6) {
                    obstacle16[1].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if (pattern_speed_number[16] == 7) {
                    obstacle16[1].setPosition(ten_SpeedX, ten_SpeedY);
                } else if (pattern_speed_number[16] == 8) {
                    obstacle16[1].setPosition(nine_SpeedX, nine_SpeedY);
                } else if (pattern_speed_number[16] == 9) {
                    obstacle16[1].setPosition(eight_SpeedX, eight_SpeedY);
                } else if (pattern_speed_number[16] == 10) {
                    obstacle16[1].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if (pattern_speed_number[16] == 11) {
                    obstacle16[1].setPosition(seven_SpeedX, seven_SpeedY);
                } else if (pattern_speed_number[16] == 12) {
                    obstacle16[1].setPosition(six_SpeedX, six_SpeedY);
                } else if (pattern_speed_number[16] == 13) {
                    obstacle16[1].setPosition(five_SpeedX, five_SpeedY);
                } else if (pattern_speed_number[16] == 14) {
                    obstacle16[1].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if (pattern_speed_number[16] == 15) {
                    obstacle16[1].setPosition(four_SpeedX, four_SpeedY);
                }
            } else {
                obstacle16[1].setObstacleAlpha(200);
                if (pattern_speed_number[16] == 0) {
                    obstacle16[1].setPosition(three_SpeedX, three_SpeedY);
                } else if (pattern_speed_number[16] == 1) {
                    obstacle16[1].setPosition(two_SpeedX, two_SpeedY);

                } else if (pattern_speed_number[16] == 2) {
                    obstacle16[1].setPosition(three_SpeedX, three_SpeedY);

                } else if (pattern_speed_number[16] == 3) {
                    obstacle16[1].setPosition(one_SpeedX, one_SpeedY);
                } else if (pattern_speed_number[16] == 4) {
                    obstacle16[1].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if (pattern_speed_number[16] == 5) {
                    obstacle16[1].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if (pattern_speed_number[16] == 6) {
                    obstacle16[1].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if (pattern_speed_number[16] == 7) {
                    obstacle16[1].setPosition(ten_SpeedX, ten_SpeedY);
                } else if (pattern_speed_number[16] == 8) {
                    obstacle16[1].setPosition(nine_SpeedX, nine_SpeedY);
                } else if (pattern_speed_number[16] == 9) {
                    obstacle16[1].setPosition(eight_SpeedX, eight_SpeedY);
                } else if (pattern_speed_number[16] == 10) {
                    obstacle16[1].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if (pattern_speed_number[16] == 11) {
                    obstacle16[1].setPosition(seven_SpeedX, seven_SpeedY);
                } else if (pattern_speed_number[16] == 12) {
                    obstacle16[1].setPosition(six_SpeedX, six_SpeedY);
                } else if (pattern_speed_number[16] == 13) {
                    obstacle16[1].setPosition(five_SpeedX, five_SpeedY);
                } else if (pattern_speed_number[16] == 14) {
                    obstacle16[1].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if (pattern_speed_number[16] == 15) {
                    obstacle16[1].setPosition(four_SpeedX, four_SpeedY);
                }
            }
        }
        else {
            obstacle16[1].setObstacleAlpha(0);
            obstacle16[1].position_effect();
        }

        if (pattern16[2] == 1) {
            if (obstacle16[2].position_x >= 300 * size_dm || obstacle16[2].position_x <= 10 * size_dm || obstacle16[2].position_y <= 90 * size_dm || obstacle16[2].position_y >= 350 * size_dm) {
                pattern_speed_number[17] = getRandomMath8(15, 0);
                obstacle16[2].setObstacleAlpha(200);
                if (pattern_speed_number[17] == 0) {
                    obstacle16[2].setPosition(three_SpeedX, three_SpeedY);
                } else if (pattern_speed_number[17] == 1) {
                    obstacle16[2].setPosition(two_SpeedX, two_SpeedY);

                } else if (pattern_speed_number[17] == 2) {
                    obstacle16[2].setPosition(three_SpeedX, three_SpeedY);

                } else if (pattern_speed_number[17] == 3) {
                    obstacle16[2].setPosition(one_SpeedX, one_SpeedY);
                } else if (pattern_speed_number[17] == 4) {
                    obstacle16[2].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if (pattern_speed_number[17] == 5) {
                    obstacle16[2].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if (pattern_speed_number[17] == 6) {
                    obstacle16[2].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if (pattern_speed_number[17] == 7) {
                    obstacle16[2].setPosition(ten_SpeedX, ten_SpeedY);
                } else if (pattern_speed_number[17] == 8) {
                    obstacle16[2].setPosition(nine_SpeedX, nine_SpeedY);
                } else if (pattern_speed_number[17] == 9) {
                    obstacle16[2].setPosition(eight_SpeedX, eight_SpeedY);
                } else if (pattern_speed_number[17] == 10) {
                    obstacle16[2].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if (pattern_speed_number[17] == 11) {
                    obstacle16[2].setPosition(seven_SpeedX, seven_SpeedY);
                } else if (pattern_speed_number[17] == 12) {
                    obstacle16[2].setPosition(six_SpeedX, six_SpeedY);
                } else if (pattern_speed_number[17] == 13) {
                    obstacle16[2].setPosition(five_SpeedX, five_SpeedY);
                } else if (pattern_speed_number[17] == 14) {
                    obstacle16[2].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if (pattern_speed_number[17] == 15) {
                    obstacle16[2].setPosition(four_SpeedX, four_SpeedY);
                }
            } else {
                obstacle16[2].setObstacleAlpha(200);
                if (pattern_speed_number[17] == 0) {
                    obstacle16[2].setPosition(three_SpeedX, three_SpeedY);
                } else if (pattern_speed_number[17] == 1) {
                    obstacle16[2].setPosition(two_SpeedX, two_SpeedY);

                } else if (pattern_speed_number[17] == 2) {
                    obstacle16[2].setPosition(three_SpeedX, three_SpeedY);

                } else if (pattern_speed_number[17] == 3) {
                    obstacle16[2].setPosition(one_SpeedX, one_SpeedY);
                } else if (pattern_speed_number[17] == 4) {
                    obstacle16[2].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if (pattern_speed_number[17] == 5) {
                    obstacle16[2].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if (pattern_speed_number[17] == 6) {
                    obstacle16[2].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if (pattern_speed_number[17] == 7) {
                    obstacle16[2].setPosition(ten_SpeedX, ten_SpeedY);
                } else if (pattern_speed_number[17] == 8) {
                    obstacle16[2].setPosition(nine_SpeedX, nine_SpeedY);
                } else if (pattern_speed_number[17] == 9) {
                    obstacle16[2].setPosition(eight_SpeedX, eight_SpeedY);
                } else if (pattern_speed_number[17] == 10) {
                    obstacle16[2].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if (pattern_speed_number[17] == 11) {
                    obstacle16[2].setPosition(seven_SpeedX, seven_SpeedY);
                } else if (pattern_speed_number[17] == 12) {
                    obstacle16[2].setPosition(six_SpeedX, six_SpeedY);
                } else if (pattern_speed_number[17] == 13) {
                    obstacle16[2].setPosition(five_SpeedX, five_SpeedY);
                } else if (pattern_speed_number[17] == 14) {
                    obstacle16[2].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if (pattern_speed_number[17] == 15) {
                    obstacle16[2].setPosition(four_SpeedX, four_SpeedY);
                }
            }
        }
        else
        {
            obstacle16[2].setObstacleAlpha(0);
            obstacle16[2].position_effect();
        }

        if (pattern16[3] == 1) {
            if (obstacle16[3].position_x >= 300 * size_dm || obstacle16[3].position_x <= 10 * size_dm || obstacle16[3].position_y <= 90 * size_dm || obstacle16[3].position_y >= 350 * size_dm) {
                pattern_speed_number[18] = getRandomMath8(15, 0);
                obstacle16[3].setObstacleAlpha(200);
                if (pattern_speed_number[18] == 0) {
                    obstacle16[3].setPosition(three_SpeedX, three_SpeedY);
                } else if (pattern_speed_number[18] == 1) {
                    obstacle16[3].setPosition(two_SpeedX, two_SpeedY);

                } else if (pattern_speed_number[18] == 2) {
                    obstacle16[3].setPosition(three_SpeedX, three_SpeedY);

                } else if (pattern_speed_number[18] == 3) {
                    obstacle16[3].setPosition(one_SpeedX, one_SpeedY);
                } else if (pattern_speed_number[18] == 4) {
                    obstacle16[3].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if (pattern_speed_number[18] == 5) {
                    obstacle16[3].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if (pattern_speed_number[18] == 6) {
                    obstacle16[3].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if (pattern_speed_number[18] == 7) {
                    obstacle16[3].setPosition(ten_SpeedX, ten_SpeedY);
                } else if (pattern_speed_number[18] == 8) {
                    obstacle16[3].setPosition(nine_SpeedX, nine_SpeedY);
                } else if (pattern_speed_number[18] == 9) {
                    obstacle16[3].setPosition(eight_SpeedX, eight_SpeedY);
                } else if (pattern_speed_number[18] == 10) {
                    obstacle16[3].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if (pattern_speed_number[18] == 11) {
                    obstacle16[3].setPosition(seven_SpeedX, seven_SpeedY);
                } else if (pattern_speed_number[18] == 12) {
                    obstacle16[3].setPosition(six_SpeedX, six_SpeedY);
                } else if (pattern_speed_number[18] == 13) {
                    obstacle16[3].setPosition(five_SpeedX, five_SpeedY);
                } else if (pattern_speed_number[18] == 14) {
                    obstacle16[3].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if (pattern_speed_number[18] == 15) {
                    obstacle16[3].setPosition(four_SpeedX, four_SpeedY);
                }
            } else {
                obstacle16[3].setObstacleAlpha(200);
                if (pattern_speed_number[18] == 0) {
                    obstacle16[3].setPosition(three_SpeedX, three_SpeedY);
                } else if (pattern_speed_number[18] == 1) {
                    obstacle16[3].setPosition(two_SpeedX, two_SpeedY);

                } else if (pattern_speed_number[18] == 2) {
                    obstacle16[3].setPosition(three_SpeedX, three_SpeedY);

                } else if (pattern_speed_number[18] == 3) {
                    obstacle16[3].setPosition(one_SpeedX, one_SpeedY);
                } else if (pattern_speed_number[18] == 4) {
                    obstacle16[3].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if (pattern_speed_number[18] == 5) {
                    obstacle16[3].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if (pattern_speed_number[18] == 6) {
                    obstacle16[3].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if (pattern_speed_number[18] == 7) {
                    obstacle16[3].setPosition(ten_SpeedX, ten_SpeedY);
                } else if (pattern_speed_number[18] == 8) {
                    obstacle16[3].setPosition(nine_SpeedX, nine_SpeedY);
                } else if (pattern_speed_number[18] == 9) {
                    obstacle16[3].setPosition(eight_SpeedX, eight_SpeedY);
                } else if (pattern_speed_number[18] == 10) {
                    obstacle16[3].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if (pattern_speed_number[18] == 11) {
                    obstacle16[3].setPosition(seven_SpeedX, seven_SpeedY);
                } else if (pattern_speed_number[18] == 12) {
                    obstacle16[3].setPosition(six_SpeedX, six_SpeedY);
                } else if (pattern_speed_number[18] == 13) {
                    obstacle16[3].setPosition(five_SpeedX, five_SpeedY);
                } else if (pattern_speed_number[18] == 14) {
                    obstacle16[3].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if (pattern_speed_number[18] == 15) {
                    obstacle16[3].setPosition(four_SpeedX, four_SpeedY);
                }
            }
        }
        else
        {
            obstacle16[3].setObstacleAlpha(0);
            obstacle16[3].position_effect();
        }

        if (pattern16[4] == 1) {
            if (obstacle16[4].position_x >= 300 * size_dm || obstacle16[4].position_x <= 10 * size_dm || obstacle16[4].position_y <= 90 * size_dm || obstacle16[4].position_y >= 350 * size_dm) {
                pattern_speed_number[19] = getRandomMath8(15, 0);
                obstacle16[4].setObstacleAlpha(200);
                if (pattern_speed_number[19] == 0) {
                    obstacle16[4].setPosition(three_SpeedX, three_SpeedY);
                } else if (pattern_speed_number[19] == 1) {
                    obstacle16[4].setPosition(two_SpeedX, two_SpeedY);

                } else if (pattern_speed_number[19] == 2) {
                    obstacle16[4].setPosition(three_SpeedX, three_SpeedY);

                } else if (pattern_speed_number[19] == 3) {
                    obstacle16[4].setPosition(one_SpeedX, one_SpeedY);
                } else if (pattern_speed_number[19] == 4) {
                    obstacle16[4].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if (pattern_speed_number[19] == 5) {
                    obstacle16[4].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if (pattern_speed_number[19] == 6) {
                    obstacle16[4].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if (pattern_speed_number[19] == 7) {
                    obstacle16[4].setPosition(ten_SpeedX, ten_SpeedY);
                } else if (pattern_speed_number[19] == 8) {
                    obstacle16[4].setPosition(nine_SpeedX, nine_SpeedY);
                } else if (pattern_speed_number[19] == 9) {
                    obstacle16[4].setPosition(eight_SpeedX, eight_SpeedY);
                } else if (pattern_speed_number[19] == 10) {
                    obstacle16[4].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if (pattern_speed_number[19] == 11) {
                    obstacle16[4].setPosition(seven_SpeedX, seven_SpeedY);
                } else if (pattern_speed_number[19] == 12) {
                    obstacle16[4].setPosition(six_SpeedX, six_SpeedY);
                } else if (pattern_speed_number[19] == 13) {
                    obstacle16[4].setPosition(five_SpeedX, five_SpeedY);
                } else if (pattern_speed_number[19] == 14) {
                    obstacle16[4].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if (pattern_speed_number[19] == 15) {
                    obstacle16[4].setPosition(four_SpeedX, four_SpeedY);
                }
            } else {
                obstacle16[4].setObstacleAlpha(200);
                if (pattern_speed_number[19] == 0) {
                    obstacle16[4].setPosition(three_SpeedX, three_SpeedY);
                } else if (pattern_speed_number[19] == 1) {
                    obstacle16[4].setPosition(two_SpeedX, two_SpeedY);

                } else if (pattern_speed_number[19] == 2) {
                    obstacle16[4].setPosition(three_SpeedX, three_SpeedY);

                } else if (pattern_speed_number[19] == 3) {
                    obstacle16[4].setPosition(one_SpeedX, one_SpeedY);
                } else if (pattern_speed_number[19] == 4) {
                    obstacle16[4].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if (pattern_speed_number[19] == 5) {
                    obstacle16[4].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if (pattern_speed_number[19] == 6) {
                    obstacle16[4].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if (pattern_speed_number[19] == 7) {
                    obstacle16[4].setPosition(ten_SpeedX, ten_SpeedY);
                } else if (pattern_speed_number[19] == 8) {
                    obstacle16[4].setPosition(nine_SpeedX, nine_SpeedY);
                } else if (pattern_speed_number[19] == 9) {
                    obstacle16[4].setPosition(eight_SpeedX, eight_SpeedY);
                } else if (pattern_speed_number[19] == 10) {
                    obstacle16[4].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if (pattern_speed_number[19] == 11) {
                    obstacle16[4].setPosition(seven_SpeedX, seven_SpeedY);
                } else if (pattern_speed_number[19] == 12) {
                    obstacle16[4].setPosition(six_SpeedX, six_SpeedY);
                } else if (pattern_speed_number[19] == 13) {
                    obstacle16[4].setPosition(five_SpeedX, five_SpeedY);
                } else if (pattern_speed_number[19] == 14) {
                    obstacle16[4].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if (pattern_speed_number[19] == 15) {
                    obstacle16[4].setPosition(four_SpeedX, four_SpeedY);
                }
            }
        }
        else
        {
            obstacle16[4].setObstacleAlpha(0);
            obstacle16[4].position_effect();
        }

        if (pattern16[5] == 1) {
            if (obstacle16[5].position_x >= 300 * size_dm || obstacle16[5].position_x <= 10 * size_dm || obstacle16[5].position_y <= 90 * size_dm || obstacle16[5].position_y >= 350 * size_dm) {
                pattern_speed_number[20] = getRandomMath8(15, 0);
                obstacle16[5].setObstacleAlpha(200);
                if (pattern_speed_number[20] == 0) {
                    obstacle16[5].setPosition(three_SpeedX, three_SpeedY);
                } else if (pattern_speed_number[20] == 1) {
                    obstacle16[5].setPosition(two_SpeedX, two_SpeedY);

                } else if (pattern_speed_number[20] == 2) {
                    obstacle16[5].setPosition(three_SpeedX, three_SpeedY);

                } else if (pattern_speed_number[20] == 3) {
                    obstacle16[5].setPosition(one_SpeedX, one_SpeedY);
                } else if (pattern_speed_number[20] == 4) {
                    obstacle16[5].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if (pattern_speed_number[20] == 5) {
                    obstacle16[5].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if (pattern_speed_number[20] == 6) {
                    obstacle16[5].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if (pattern_speed_number[20] == 7) {
                    obstacle16[5].setPosition(ten_SpeedX, ten_SpeedY);
                } else if (pattern_speed_number[20] == 8) {
                    obstacle16[5].setPosition(nine_SpeedX, nine_SpeedY);
                } else if (pattern_speed_number[20] == 9) {
                    obstacle16[5].setPosition(eight_SpeedX, eight_SpeedY);
                } else if (pattern_speed_number[20] == 10) {
                    obstacle16[5].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if (pattern_speed_number[20] == 11) {
                    obstacle16[5].setPosition(seven_SpeedX, seven_SpeedY);
                } else if (pattern_speed_number[20] == 12) {
                    obstacle16[5].setPosition(six_SpeedX, six_SpeedY);
                } else if (pattern_speed_number[20] == 13) {
                    obstacle16[5].setPosition(five_SpeedX, five_SpeedY);
                } else if (pattern_speed_number[20] == 14) {
                    obstacle16[5].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if (pattern_speed_number[20] == 15) {
                    obstacle16[5].setPosition(four_SpeedX, four_SpeedY);
                }
            } else {
                obstacle16[5].setObstacleAlpha(200);
                if (pattern_speed_number[20] == 0) {
                    obstacle16[5].setPosition(three_SpeedX, three_SpeedY);
                } else if (pattern_speed_number[20] == 1) {
                    obstacle16[5].setPosition(two_SpeedX, two_SpeedY);

                } else if (pattern_speed_number[20] == 2) {
                    obstacle16[5].setPosition(three_SpeedX, three_SpeedY);

                } else if (pattern_speed_number[20] == 3) {
                    obstacle16[5].setPosition(one_SpeedX, one_SpeedY);
                } else if (pattern_speed_number[20] == 4) {
                    obstacle16[5].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if (pattern_speed_number[20] == 5) {
                    obstacle16[5].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if (pattern_speed_number[20] == 6) {
                    obstacle16[5].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if (pattern_speed_number[20] == 7) {
                    obstacle16[5].setPosition(ten_SpeedX, ten_SpeedY);
                } else if (pattern_speed_number[20] == 8) {
                    obstacle16[5].setPosition(nine_SpeedX, nine_SpeedY);
                } else if (pattern_speed_number[20] == 9) {
                    obstacle16[5].setPosition(eight_SpeedX, eight_SpeedY);
                } else if (pattern_speed_number[20] == 10) {
                    obstacle16[5].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if (pattern_speed_number[20] == 11) {
                    obstacle16[5].setPosition(seven_SpeedX, seven_SpeedY);
                } else if (pattern_speed_number[20] == 12) {
                    obstacle16[5].setPosition(six_SpeedX, six_SpeedY);
                } else if (pattern_speed_number[20] == 13) {
                    obstacle16[5].setPosition(five_SpeedX, five_SpeedY);
                } else if (pattern_speed_number[20] == 14) {
                    obstacle16[5].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if (pattern_speed_number[20] == 15) {
                    obstacle16[5].setPosition(four_SpeedX, four_SpeedY);
                }
            }
        }
        else
        {
            obstacle16[5].setObstacleAlpha(0);
            obstacle16[5].position_effect();
        }

        if (pattern16[6] == 1) {
            if (obstacle16[6].position_x >= 300 * size_dm || obstacle16[6].position_x <= 10 * size_dm || obstacle16[6].position_y <= 90 * size_dm || obstacle16[6].position_y >= 350 * size_dm) {
                pattern_speed_number[21] = getRandomMath8(15, 0);
                obstacle16[6].setObstacleAlpha(200);
                if (pattern_speed_number[21] == 0) {
                    obstacle16[6].setPosition(three_SpeedX, three_SpeedY);
                } else if (pattern_speed_number[21] == 1) {
                    obstacle16[6].setPosition(two_SpeedX, two_SpeedY);

                } else if (pattern_speed_number[21] == 2) {
                    obstacle16[6].setPosition(three_SpeedX, three_SpeedY);

                } else if (pattern_speed_number[21] == 3) {
                    obstacle16[6].setPosition(one_SpeedX, one_SpeedY);
                } else if (pattern_speed_number[21] == 4) {
                    obstacle16[6].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if (pattern_speed_number[21] == 5) {
                    obstacle16[6].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if (pattern_speed_number[21] == 6) {
                    obstacle16[6].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if (pattern_speed_number[21] == 7) {
                    obstacle16[6].setPosition(ten_SpeedX, ten_SpeedY);
                } else if (pattern_speed_number[21] == 8) {
                    obstacle16[6].setPosition(nine_SpeedX, nine_SpeedY);
                } else if (pattern_speed_number[21] == 9) {
                    obstacle16[6].setPosition(eight_SpeedX, eight_SpeedY);
                } else if (pattern_speed_number[21] == 10) {
                    obstacle16[6].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if (pattern_speed_number[21] == 11) {
                    obstacle16[6].setPosition(seven_SpeedX, seven_SpeedY);
                } else if (pattern_speed_number[21] == 12) {
                    obstacle16[6].setPosition(six_SpeedX, six_SpeedY);
                } else if (pattern_speed_number[21] == 13) {
                    obstacle16[6].setPosition(five_SpeedX, five_SpeedY);
                } else if (pattern_speed_number[21] == 14) {
                    obstacle16[6].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if (pattern_speed_number[21] == 15) {
                    obstacle16[6].setPosition(four_SpeedX, four_SpeedY);
                }
            } else {
                obstacle16[6].setObstacleAlpha(200);
                if (pattern_speed_number[21] == 0) {
                    obstacle16[6].setPosition(three_SpeedX, three_SpeedY);
                } else if (pattern_speed_number[21] == 1) {
                    obstacle16[6].setPosition(two_SpeedX, two_SpeedY);

                } else if (pattern_speed_number[21] == 2) {
                    obstacle16[6].setPosition(three_SpeedX, three_SpeedY);

                } else if (pattern_speed_number[21] == 3) {
                    obstacle16[6].setPosition(one_SpeedX, one_SpeedY);
                } else if (pattern_speed_number[21] == 4) {
                    obstacle16[6].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if (pattern_speed_number[21] == 5) {
                    obstacle16[6].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if (pattern_speed_number[21] == 6) {
                    obstacle16[6].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if (pattern_speed_number[21] == 7) {
                    obstacle16[6].setPosition(ten_SpeedX, ten_SpeedY);
                } else if (pattern_speed_number[21] == 8) {
                    obstacle16[6].setPosition(nine_SpeedX, nine_SpeedY);
                } else if (pattern_speed_number[21] == 9) {
                    obstacle16[6].setPosition(eight_SpeedX, eight_SpeedY);
                } else if (pattern_speed_number[21] == 10) {
                    obstacle16[6].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if (pattern_speed_number[21] == 11) {
                    obstacle16[6].setPosition(seven_SpeedX, seven_SpeedY);
                } else if (pattern_speed_number[21] == 12) {
                    obstacle16[6].setPosition(six_SpeedX, six_SpeedY);
                } else if (pattern_speed_number[21] == 13) {
                    obstacle16[6].setPosition(five_SpeedX, five_SpeedY);
                } else if (pattern_speed_number[21] == 14) {
                    obstacle16[6].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if (pattern_speed_number[21] == 15) {
                    obstacle16[6].setPosition(four_SpeedX, four_SpeedY);
                }
            }
        }
        else
        {
            obstacle16[6].setObstacleAlpha(0);
            obstacle16[6].position_effect();
        }

        if (pattern16[7] == 1) {
            if (obstacle16[7].position_x >= 300 * size_dm || obstacle16[7].position_x <= 10 * size_dm || obstacle16[7].position_y <= 90 * size_dm || obstacle16[7].position_y >= 350 * size_dm) {
                pattern_speed_number[22] = getRandomMath8(15, 0);
                obstacle16[7].setObstacleAlpha(200);
                if (pattern_speed_number[22] == 0) {
                    obstacle16[7].setPosition(three_SpeedX, three_SpeedY);
                } else if (pattern_speed_number[22] == 1) {
                    obstacle16[7].setPosition(two_SpeedX, two_SpeedY);

                } else if (pattern_speed_number[22] == 2) {
                    obstacle16[7].setPosition(three_SpeedX, three_SpeedY);

                } else if (pattern_speed_number[22] == 3) {
                    obstacle16[7].setPosition(one_SpeedX, one_SpeedY);
                } else if (pattern_speed_number[22] == 4) {
                    obstacle16[7].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if (pattern_speed_number[22] == 5) {
                    obstacle16[7].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if (pattern_speed_number[22] == 6) {
                    obstacle16[7].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if (pattern_speed_number[22] == 7) {
                    obstacle16[7].setPosition(ten_SpeedX, ten_SpeedY);
                } else if (pattern_speed_number[22] == 8) {
                    obstacle16[7].setPosition(nine_SpeedX, nine_SpeedY);
                } else if (pattern_speed_number[22] == 9) {
                    obstacle16[7].setPosition(eight_SpeedX, eight_SpeedY);
                } else if (pattern_speed_number[22] == 10) {
                    obstacle16[7].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if (pattern_speed_number[22] == 11) {
                    obstacle16[7].setPosition(seven_SpeedX, seven_SpeedY);
                } else if (pattern_speed_number[22] == 12) {
                    obstacle16[7].setPosition(six_SpeedX, six_SpeedY);
                } else if (pattern_speed_number[22] == 13) {
                    obstacle16[7].setPosition(five_SpeedX, five_SpeedY);
                } else if (pattern_speed_number[22] == 14) {
                    obstacle16[7].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if (pattern_speed_number[22] == 15) {
                    obstacle16[7].setPosition(four_SpeedX, four_SpeedY);
                }
            } else {
                obstacle16[7].setObstacleAlpha(200);
                if (pattern_speed_number[22] == 0) {
                    obstacle16[7].setPosition(three_SpeedX, three_SpeedY);
                } else if (pattern_speed_number[22] == 1) {
                    obstacle16[7].setPosition(two_SpeedX, two_SpeedY);

                } else if (pattern_speed_number[22] == 2) {
                    obstacle16[7].setPosition(three_SpeedX, three_SpeedY);

                } else if (pattern_speed_number[22] == 3) {
                    obstacle16[7].setPosition(one_SpeedX, one_SpeedY);
                } else if (pattern_speed_number[22] == 4) {
                    obstacle16[7].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if (pattern_speed_number[22] == 5) {
                    obstacle16[7].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if (pattern_speed_number[22] == 6) {
                    obstacle16[7].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if (pattern_speed_number[22] == 7) {
                    obstacle16[7].setPosition(ten_SpeedX, ten_SpeedY);
                } else if (pattern_speed_number[22] == 8) {
                    obstacle16[7].setPosition(nine_SpeedX, nine_SpeedY);
                } else if (pattern_speed_number[22] == 9) {
                    obstacle16[7].setPosition(eight_SpeedX, eight_SpeedY);
                } else if (pattern_speed_number[22] == 10) {
                    obstacle16[7].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if (pattern_speed_number[22] == 11) {
                    obstacle16[7].setPosition(seven_SpeedX, seven_SpeedY);
                } else if (pattern_speed_number[22] == 12) {
                    obstacle16[7].setPosition(six_SpeedX, six_SpeedY);
                } else if (pattern_speed_number[22] == 13) {
                    obstacle16[7].setPosition(five_SpeedX, five_SpeedY);
                } else if (pattern_speed_number[22] == 14) {
                    obstacle16[7].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if (pattern_speed_number[22] == 15) {
                    obstacle16[7].setPosition(four_SpeedX, four_SpeedY);
                }
            }
        }
        else
        {
            obstacle16[7].setObstacleAlpha(0);
            obstacle16[7].position_effect();
        }

        if (pattern16[8] == 1) {
            if (obstacle16[8].position_x >= 300 * size_dm || obstacle16[8].position_x <= 10 * size_dm || obstacle16[8].position_y <= 90 * size_dm || obstacle16[8].position_y >= 350 * size_dm) {
                pattern_speed_number[23] = getRandomMath8(15, 0);
                obstacle16[8].setObstacleAlpha(200);
                if (pattern_speed_number[23] == 0) {
                    obstacle16[8].setPosition(three_SpeedX, three_SpeedY);
                } else if (pattern_speed_number[23] == 1) {
                    obstacle16[8].setPosition(two_SpeedX, two_SpeedY);

                } else if (pattern_speed_number[23] == 2) {
                    obstacle16[8].setPosition(three_SpeedX, three_SpeedY);

                } else if (pattern_speed_number[23] == 3) {
                    obstacle16[8].setPosition(one_SpeedX, one_SpeedY);
                } else if (pattern_speed_number[23] == 4) {
                    obstacle16[8].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if (pattern_speed_number[23] == 5) {
                    obstacle16[8].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if (pattern_speed_number[23] == 6) {
                    obstacle16[8].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if (pattern_speed_number[23] == 7) {
                    obstacle16[8].setPosition(ten_SpeedX, ten_SpeedY);
                } else if (pattern_speed_number[23] == 8) {
                    obstacle16[8].setPosition(nine_SpeedX, nine_SpeedY);
                } else if (pattern_speed_number[23] == 9) {
                    obstacle16[8].setPosition(eight_SpeedX, eight_SpeedY);
                } else if (pattern_speed_number[23] == 10) {
                    obstacle16[8].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if (pattern_speed_number[23] == 11) {
                    obstacle16[8].setPosition(seven_SpeedX, seven_SpeedY);
                } else if (pattern_speed_number[23] == 12) {
                    obstacle16[8].setPosition(six_SpeedX, six_SpeedY);
                } else if (pattern_speed_number[23] == 13) {
                    obstacle16[8].setPosition(five_SpeedX, five_SpeedY);
                } else if (pattern_speed_number[23] == 14) {
                    obstacle16[8].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if (pattern_speed_number[23] == 15) {
                    obstacle16[8].setPosition(four_SpeedX, four_SpeedY);
                }
            } else {
                obstacle16[8].setObstacleAlpha(200);
                if (pattern_speed_number[23] == 0) {
                    obstacle16[8].setPosition(three_SpeedX, three_SpeedY);
                } else if (pattern_speed_number[23] == 1) {
                    obstacle16[8].setPosition(two_SpeedX, two_SpeedY);

                } else if (pattern_speed_number[23] == 2) {
                    obstacle16[8].setPosition(three_SpeedX, three_SpeedY);

                } else if (pattern_speed_number[23] == 3) {
                    obstacle16[8].setPosition(one_SpeedX, one_SpeedY);
                } else if (pattern_speed_number[23] == 4) {
                    obstacle16[8].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if (pattern_speed_number[23] == 5) {
                    obstacle16[8].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if (pattern_speed_number[23] == 6) {
                    obstacle16[8].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if (pattern_speed_number[23] == 7) {
                    obstacle16[8].setPosition(ten_SpeedX, ten_SpeedY);
                } else if (pattern_speed_number[23] == 8) {
                    obstacle16[8].setPosition(nine_SpeedX, nine_SpeedY);
                } else if (pattern_speed_number[23] == 9) {
                    obstacle16[8].setPosition(eight_SpeedX, eight_SpeedY);
                } else if (pattern_speed_number[23] == 10) {
                    obstacle16[8].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if (pattern_speed_number[23] == 11) {
                    obstacle16[8].setPosition(seven_SpeedX, seven_SpeedY);
                } else if (pattern_speed_number[23] == 12) {
                    obstacle16[8].setPosition(six_SpeedX, six_SpeedY);
                } else if (pattern_speed_number[23] == 13) {
                    obstacle16[8].setPosition(five_SpeedX, five_SpeedY);
                } else if (pattern_speed_number[23] == 14) {
                    obstacle16[8].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if (pattern_speed_number[23] == 15) {
                    obstacle16[8].setPosition(four_SpeedX, four_SpeedY);
                }
            }
        }
        else
        {
            obstacle16[8].setObstacleAlpha(0);
            obstacle16[8].position_effect();
        }

        if (pattern16[9] == 1) {
            if (obstacle16[9].position_x >= 300 * size_dm || obstacle16[9].position_x <= 10 * size_dm || obstacle16[9].position_y <= 90 * size_dm || obstacle16[9].position_y >= 350 * size_dm) {
                pattern_speed_number[24] = getRandomMath8(15, 0);
                obstacle16[9].setObstacleAlpha(200);
                if (pattern_speed_number[24] == 0) {
                    obstacle16[9].setPosition(three_SpeedX, three_SpeedY);
                } else if (pattern_speed_number[24] == 1) {
                    obstacle16[9].setPosition(two_SpeedX, two_SpeedY);

                } else if (pattern_speed_number[24] == 2) {
                    obstacle16[9].setPosition(three_SpeedX, three_SpeedY);

                } else if (pattern_speed_number[24] == 3) {
                    obstacle16[9].setPosition(one_SpeedX, one_SpeedY);
                } else if (pattern_speed_number[24] == 4) {
                    obstacle16[9].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if (pattern_speed_number[24] == 5) {
                    obstacle16[9].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if (pattern_speed_number[24] == 6) {
                    obstacle16[9].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if (pattern_speed_number[24] == 7) {
                    obstacle16[9].setPosition(ten_SpeedX, ten_SpeedY);
                } else if (pattern_speed_number[24] == 8) {
                    obstacle16[9].setPosition(nine_SpeedX, nine_SpeedY);
                } else if (pattern_speed_number[24] == 9) {
                    obstacle16[9].setPosition(eight_SpeedX, eight_SpeedY);
                } else if (pattern_speed_number[24] == 10) {
                    obstacle16[9].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if (pattern_speed_number[24] == 11) {
                    obstacle16[9].setPosition(seven_SpeedX, seven_SpeedY);
                } else if (pattern_speed_number[24] == 12) {
                    obstacle16[9].setPosition(six_SpeedX, six_SpeedY);
                } else if (pattern_speed_number[24] == 13) {
                    obstacle16[9].setPosition(five_SpeedX, five_SpeedY);
                } else if (pattern_speed_number[24] == 14) {
                    obstacle16[9].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if (pattern_speed_number[24] == 15) {
                    obstacle16[9].setPosition(four_SpeedX, four_SpeedY);
                }
            } else {
                obstacle16[9].setObstacleAlpha(200);
                if (pattern_speed_number[24] == 0) {
                    obstacle16[9].setPosition(three_SpeedX, three_SpeedY);
                } else if (pattern_speed_number[24] == 1) {
                    obstacle16[9].setPosition(two_SpeedX, two_SpeedY);

                } else if (pattern_speed_number[24] == 2) {
                    obstacle16[9].setPosition(three_SpeedX, three_SpeedY);

                } else if (pattern_speed_number[24] == 3) {
                    obstacle16[9].setPosition(one_SpeedX, one_SpeedY);
                } else if (pattern_speed_number[24] == 4) {
                    obstacle16[9].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if (pattern_speed_number[24] == 5) {
                    obstacle16[9].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if (pattern_speed_number[24] == 6) {
                    obstacle16[9].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if (pattern_speed_number[24] == 7) {
                    obstacle16[9].setPosition(ten_SpeedX, ten_SpeedY);
                } else if (pattern_speed_number[24] == 8) {
                    obstacle16[9].setPosition(nine_SpeedX, nine_SpeedY);
                } else if (pattern_speed_number[24] == 9) {
                    obstacle16[9].setPosition(eight_SpeedX, eight_SpeedY);
                } else if (pattern_speed_number[24] == 10) {
                    obstacle16[9].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if (pattern_speed_number[24] == 11) {
                    obstacle16[9].setPosition(seven_SpeedX, seven_SpeedY);
                } else if (pattern_speed_number[24] == 12) {
                    obstacle16[9].setPosition(six_SpeedX, six_SpeedY);
                } else if (pattern_speed_number[24] == 13) {
                    obstacle16[9].setPosition(five_SpeedX, five_SpeedY);
                } else if (pattern_speed_number[24] == 14) {
                    obstacle16[9].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if (pattern_speed_number[24] == 15) {
                    obstacle16[9].setPosition(four_SpeedX, four_SpeedY);
                }
            }
        }
        else
        {
            obstacle16[9].setObstacleAlpha(0);
            obstacle16[9].position_effect();
        }

        if (pattern16[10] == 1) {
            if (obstacle16[10].position_x >= 300 * size_dm || obstacle16[10].position_x <= 10 * size_dm || obstacle16[10].position_y <= 90 * size_dm || obstacle16[10].position_y >= 350 * size_dm) {
                pattern_speed_number[25] = getRandomMath8(15, 0);
                obstacle16[10].setObstacleAlpha(200);
                if (pattern_speed_number[25] == 0) {
                    obstacle16[10].setPosition(three_SpeedX, three_SpeedY);
                } else if (pattern_speed_number[25] == 1) {
                    obstacle16[10].setPosition(two_SpeedX, two_SpeedY);

                } else if (pattern_speed_number[25] == 2) {
                    obstacle16[10].setPosition(three_SpeedX, three_SpeedY);

                } else if (pattern_speed_number[25] == 3) {
                    obstacle16[10].setPosition(one_SpeedX, one_SpeedY);
                } else if (pattern_speed_number[25] == 4) {
                    obstacle16[10].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if (pattern_speed_number[25] == 5) {
                    obstacle16[10].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if (pattern_speed_number[25] == 6) {
                    obstacle16[10].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if (pattern_speed_number[25] == 7) {
                    obstacle16[10].setPosition(ten_SpeedX, ten_SpeedY);
                } else if (pattern_speed_number[25] == 8) {
                    obstacle16[10].setPosition(nine_SpeedX, nine_SpeedY);
                } else if (pattern_speed_number[25] == 9) {
                    obstacle16[10].setPosition(eight_SpeedX, eight_SpeedY);
                } else if (pattern_speed_number[25] == 10) {
                    obstacle16[10].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if (pattern_speed_number[25] == 11) {
                    obstacle16[10].setPosition(seven_SpeedX, seven_SpeedY);
                } else if (pattern_speed_number[25] == 12) {
                    obstacle16[10].setPosition(six_SpeedX, six_SpeedY);
                } else if (pattern_speed_number[25] == 13) {
                    obstacle16[10].setPosition(five_SpeedX, five_SpeedY);
                } else if (pattern_speed_number[25] == 14) {
                    obstacle16[10].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if (pattern_speed_number[25] == 15) {
                    obstacle16[10].setPosition(four_SpeedX, four_SpeedY);
                }
            } else {
                obstacle16[10].setObstacleAlpha(200);
                if (pattern_speed_number[25] == 0) {
                    obstacle16[10].setPosition(three_SpeedX, three_SpeedY);
                } else if (pattern_speed_number[25] == 1) {
                    obstacle16[10].setPosition(two_SpeedX, two_SpeedY);

                } else if (pattern_speed_number[25] == 2) {
                    obstacle16[10].setPosition(three_SpeedX, three_SpeedY);

                } else if (pattern_speed_number[25] == 3) {
                    obstacle16[10].setPosition(one_SpeedX, one_SpeedY);
                } else if (pattern_speed_number[25] == 4) {
                    obstacle16[10].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if (pattern_speed_number[25] == 5) {
                    obstacle16[10].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if (pattern_speed_number[25] == 6) {
                    obstacle16[10].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if (pattern_speed_number[25] == 7) {
                    obstacle16[10].setPosition(ten_SpeedX, ten_SpeedY);
                } else if (pattern_speed_number[25] == 8) {
                    obstacle16[10].setPosition(nine_SpeedX, nine_SpeedY);
                } else if (pattern_speed_number[25] == 9) {
                    obstacle16[10].setPosition(eight_SpeedX, eight_SpeedY);
                } else if (pattern_speed_number[25] == 10) {
                    obstacle16[10].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if (pattern_speed_number[25] == 11) {
                    obstacle16[10].setPosition(seven_SpeedX, seven_SpeedY);
                } else if (pattern_speed_number[25] == 12) {
                    obstacle16[10].setPosition(six_SpeedX, six_SpeedY);
                } else if (pattern_speed_number[25] == 13) {
                    obstacle16[10].setPosition(five_SpeedX, five_SpeedY);
                } else if (pattern_speed_number[25] == 14) {
                    obstacle16[10].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if (pattern_speed_number[25] == 15) {
                    obstacle16[10].setPosition(four_SpeedX, four_SpeedY);
                }
            }
        }
        else
        {
            obstacle16[10].setObstacleAlpha(0);
            obstacle16[10].position_effect();
        }

        if (pattern16[11] == 1) {
            if (obstacle16[11].position_x >= 300 * size_dm || obstacle16[11].position_x <= 10 * size_dm || obstacle16[11].position_y <= 90 * size_dm || obstacle16[11].position_y >= 350 * size_dm) {
                pattern_speed_number[26] = getRandomMath8(15, 0);
                obstacle16[11].setObstacleAlpha(200);
                if (pattern_speed_number[26] == 0) {
                    obstacle16[11].setPosition(three_SpeedX, three_SpeedY);
                } else if (pattern_speed_number[26] == 1) {
                    obstacle16[11].setPosition(two_SpeedX, two_SpeedY);

                } else if (pattern_speed_number[26] == 2) {
                    obstacle16[11].setPosition(three_SpeedX, three_SpeedY);

                } else if (pattern_speed_number[26] == 3) {
                    obstacle16[11].setPosition(one_SpeedX, one_SpeedY);
                } else if (pattern_speed_number[26] == 4) {
                    obstacle16[11].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if (pattern_speed_number[26] == 5) {
                    obstacle16[11].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if (pattern_speed_number[26] == 6) {
                    obstacle16[11].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if (pattern_speed_number[26] == 7) {
                    obstacle16[11].setPosition(ten_SpeedX, ten_SpeedY);
                } else if (pattern_speed_number[26] == 8) {
                    obstacle16[11].setPosition(nine_SpeedX, nine_SpeedY);
                } else if (pattern_speed_number[26] == 9) {
                    obstacle16[11].setPosition(eight_SpeedX, eight_SpeedY);
                } else if (pattern_speed_number[26] == 10) {
                    obstacle16[11].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if (pattern_speed_number[26] == 11) {
                    obstacle16[11].setPosition(seven_SpeedX, seven_SpeedY);
                } else if (pattern_speed_number[26] == 12) {
                    obstacle16[11].setPosition(six_SpeedX, six_SpeedY);
                } else if (pattern_speed_number[26] == 13) {
                    obstacle16[11].setPosition(five_SpeedX, five_SpeedY);
                } else if (pattern_speed_number[26] == 14) {
                    obstacle16[11].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if (pattern_speed_number[26] == 15) {
                    obstacle16[11].setPosition(four_SpeedX, four_SpeedY);
                }
            } else {
                obstacle16[11].setObstacleAlpha(200);
                if (pattern_speed_number[26] == 0) {
                    obstacle16[11].setPosition(three_SpeedX, three_SpeedY);
                } else if (pattern_speed_number[26] == 1) {
                    obstacle16[11].setPosition(two_SpeedX, two_SpeedY);

                } else if (pattern_speed_number[26] == 2) {
                    obstacle16[11].setPosition(three_SpeedX, three_SpeedY);

                } else if (pattern_speed_number[26] == 3) {
                    obstacle16[11].setPosition(one_SpeedX, one_SpeedY);
                } else if (pattern_speed_number[26] == 4) {
                    obstacle16[11].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if (pattern_speed_number[26] == 5) {
                    obstacle16[11].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if (pattern_speed_number[26] == 6) {
                    obstacle16[11].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if (pattern_speed_number[26] == 7) {
                    obstacle16[11].setPosition(ten_SpeedX, ten_SpeedY);
                } else if (pattern_speed_number[26] == 8) {
                    obstacle16[11].setPosition(nine_SpeedX, nine_SpeedY);
                } else if (pattern_speed_number[26] == 9) {
                    obstacle16[11].setPosition(eight_SpeedX, eight_SpeedY);
                } else if (pattern_speed_number[26] == 10) {
                    obstacle16[11].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if (pattern_speed_number[26] == 11) {
                    obstacle16[11].setPosition(seven_SpeedX, seven_SpeedY);
                } else if (pattern_speed_number[26] == 12) {
                    obstacle16[11].setPosition(six_SpeedX, six_SpeedY);
                } else if (pattern_speed_number[26] == 13) {
                    obstacle16[11].setPosition(five_SpeedX, five_SpeedY);
                } else if (pattern_speed_number[26] == 14) {
                    obstacle16[11].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if (pattern_speed_number[26] == 15) {
                    obstacle16[11].setPosition(four_SpeedX, four_SpeedY);
                }
            }
        }
        else
        {
            obstacle16[11].setObstacleAlpha(0);
            obstacle16[11].position_effect();
        }

        if (pattern16[12] == 1) {
            if (obstacle16[12].position_x >= 300 * size_dm || obstacle16[12].position_x <= 10 * size_dm || obstacle16[12].position_y <= 90 * size_dm || obstacle16[12].position_y >= 350 * size_dm) {
                pattern_speed_number[27] = getRandomMath8(15, 0);
                obstacle16[12].setObstacleAlpha(200);
                if (pattern_speed_number[27] == 0) {
                    obstacle16[12].setPosition(three_SpeedX, three_SpeedY);
                } else if (pattern_speed_number[27] == 1) {
                    obstacle16[12].setPosition(two_SpeedX, two_SpeedY);

                } else if (pattern_speed_number[27] == 2) {
                    obstacle16[12].setPosition(three_SpeedX, three_SpeedY);

                } else if (pattern_speed_number[27] == 3) {
                    obstacle16[12].setPosition(one_SpeedX, one_SpeedY);
                } else if (pattern_speed_number[27] == 4) {
                    obstacle16[12].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if (pattern_speed_number[27] == 5) {
                    obstacle16[12].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if (pattern_speed_number[27] == 6) {
                    obstacle16[12].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if (pattern_speed_number[27] == 7) {
                    obstacle16[12].setPosition(ten_SpeedX, ten_SpeedY);
                } else if (pattern_speed_number[27] == 8) {
                    obstacle16[12].setPosition(nine_SpeedX, nine_SpeedY);
                } else if (pattern_speed_number[27] == 9) {
                    obstacle16[12].setPosition(eight_SpeedX, eight_SpeedY);
                } else if (pattern_speed_number[27] == 10) {
                    obstacle16[12].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if (pattern_speed_number[27] == 11) {
                    obstacle16[12].setPosition(seven_SpeedX, seven_SpeedY);
                } else if (pattern_speed_number[27] == 12) {
                    obstacle16[12].setPosition(six_SpeedX, six_SpeedY);
                } else if (pattern_speed_number[27] == 13) {
                    obstacle16[12].setPosition(five_SpeedX, five_SpeedY);
                } else if (pattern_speed_number[27] == 14) {
                    obstacle16[12].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if (pattern_speed_number[27] == 15) {
                    obstacle16[12].setPosition(four_SpeedX, four_SpeedY);
                }
            } else {
                obstacle16[12].setObstacleAlpha(200);
                if (pattern_speed_number[27] == 0) {
                    obstacle16[12].setPosition(three_SpeedX, three_SpeedY);
                } else if (pattern_speed_number[27] == 1) {
                    obstacle16[12].setPosition(two_SpeedX, two_SpeedY);

                } else if (pattern_speed_number[27] == 2) {
                    obstacle16[12].setPosition(three_SpeedX, three_SpeedY);

                } else if (pattern_speed_number[27] == 3) {
                    obstacle16[12].setPosition(one_SpeedX, one_SpeedY);
                } else if (pattern_speed_number[27] == 4) {
                    obstacle16[12].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if (pattern_speed_number[27] == 5) {
                    obstacle16[12].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if (pattern_speed_number[27] == 6) {
                    obstacle16[12].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if (pattern_speed_number[27] == 7) {
                    obstacle16[12].setPosition(ten_SpeedX, ten_SpeedY);
                } else if (pattern_speed_number[27] == 8) {
                    obstacle16[12].setPosition(nine_SpeedX, nine_SpeedY);
                } else if (pattern_speed_number[27] == 9) {
                    obstacle16[12].setPosition(eight_SpeedX, eight_SpeedY);
                } else if (pattern_speed_number[27] == 10) {
                    obstacle16[12].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if (pattern_speed_number[27] == 11) {
                    obstacle16[12].setPosition(seven_SpeedX, seven_SpeedY);
                } else if (pattern_speed_number[27] == 12) {
                    obstacle16[12].setPosition(six_SpeedX, six_SpeedY);
                } else if (pattern_speed_number[27] == 13) {
                    obstacle16[12].setPosition(five_SpeedX, five_SpeedY);
                } else if (pattern_speed_number[27] == 14) {
                    obstacle16[12].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if (pattern_speed_number[27] == 15) {
                    obstacle16[12].setPosition(four_SpeedX, four_SpeedY);
                }
            }
        } else
        {
            obstacle16[12].setObstacleAlpha(0);
            obstacle16[12].position_effect();
        }

        if(pattern16[13] == 1)
        {
            if(obstacle16[13].position_x  >= 300*size_dm || obstacle16[13].position_x  <= 10*size_dm || obstacle16[13].position_y <= 90*size_dm ||  obstacle16[13].position_y >=350*size_dm)
            {
                pattern_speed_number[28] = getRandomMath8(15, 0);
                obstacle16[13].setObstacleAlpha(200);
                if(pattern_speed_number[28] == 0)
                {
                    obstacle16[13].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[28] == 1)
                {
                    obstacle16[13].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[28] == 2)
                {
                    obstacle16[13].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[28] == 3)
                {
                    obstacle16[13].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[28] == 4)
                {
                    obstacle16[13].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[28] == 5)
                {
                    obstacle16[13].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[28] == 6)
                {
                    obstacle16[13].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[28] == 7)
                {
                    obstacle16[13].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[28] == 8)
                {
                    obstacle16[13].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[28] == 9)
                {
                    obstacle16[13].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[28] == 10)
                {
                    obstacle16[13].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[28] == 11)
                {
                    obstacle16[13].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[28] == 12)
                {
                    obstacle16[13].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[28] == 13)
                {
                    obstacle16[13].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[28] == 14)
                {
                    obstacle16[13].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[28] == 15)
                {
                    obstacle16[13].setPosition(four_SpeedX , four_SpeedY);
                }
            }
            else
            {
                obstacle16[13].setObstacleAlpha(200);
                if(pattern_speed_number[28] == 0)
                {
                    obstacle16[13].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[28] == 1)
                {
                    obstacle16[13].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[28] == 2)
                {
                    obstacle16[13].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[28] == 3)
                {
                    obstacle16[13].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[28] == 4)
                {
                    obstacle16[13].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[28] == 5)
                {
                    obstacle16[13].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[28] == 6)
                {
                    obstacle16[13].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[28] == 7)
                {
                    obstacle16[13].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[28] == 8)
                {
                    obstacle16[13].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[28] == 9)
                {
                    obstacle16[13].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[28] == 10)
                {
                    obstacle16[13].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[28] == 11)
                {
                    obstacle16[13].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[28] == 12)
                {
                    obstacle16[13].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[28] == 13)
                {
                    obstacle16[13].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[28] == 14)
                {
                    obstacle16[13].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[28] == 15)
                {
                    obstacle16[13].setPosition(four_SpeedX , four_SpeedY);
                }
            }
        }
        else
        {
            obstacle16[13].setObstacleAlpha(0);
            obstacle16[13].position_effect();
        }

        if(pattern16[14] == 1)
        {
            if(obstacle16[14].position_x  >= 300*size_dm || obstacle16[14].position_x  <= 10*size_dm || obstacle16[14].position_y <= 90*size_dm ||  obstacle16[14].position_y >=350*size_dm)
            {
                pattern_speed_number[29] = getRandomMath8(15, 0);
                obstacle16[14].setObstacleAlpha(200);

                if(pattern_speed_number[29] == 0)
                {
                    obstacle16[14].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[29] == 1)
                {
                    obstacle16[14].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[29] == 2)
                {
                    obstacle16[14].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[29] == 3)
                {
                    obstacle16[14].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[29] == 4)
                {
                    obstacle16[14].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[29] == 5)
                {
                    obstacle16[14].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[29] == 6)
                {
                    obstacle16[14].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[29] == 7)
                {
                    obstacle16[14].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[29] == 8)
                {
                    obstacle16[14].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[29] == 9)
                {
                    obstacle16[14].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[29] == 10)
                {
                    obstacle16[14].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[29] == 11)
                {
                    obstacle16[14].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[29] == 12)
                {
                    obstacle16[14].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[29] == 13)
                {
                    obstacle16[14].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[29] == 14)
                {
                    obstacle16[14].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[29] == 15)
                {
                    obstacle16[14].setPosition(four_SpeedX , four_SpeedY);
                }
            }
            else
            {
                obstacle16[14].setObstacleAlpha(200);
                if(pattern_speed_number[29] == 0)
                {
                    obstacle16[14].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[29] == 1)
                {
                    obstacle16[14].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[29] == 2)
                {
                    obstacle16[14].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[29] == 3)
                {
                    obstacle16[14].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[29] == 4)
                {
                    obstacle16[14].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[29] == 5)
                {
                    obstacle16[14].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[29] == 6)
                {
                    obstacle16[14].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[29] == 7)
                {
                    obstacle16[14].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[29] == 8)
                {
                    obstacle16[14].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[29] == 9)
                {
                    obstacle16[14].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[29] == 10)
                {
                    obstacle16[14].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[29] == 11)
                {
                    obstacle16[14].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[29] == 12)
                {
                    obstacle16[14].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[29] == 13)
                {
                    obstacle16[14].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[29] == 14)
                {
                    obstacle16[14].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[29] == 15)
                {
                    obstacle16[14].setPosition(four_SpeedX , four_SpeedY);
                }
            }
        }
        else
        {
            obstacle16[14].setObstacleAlpha(0);
            obstacle16[14].position_effect();
        }

        if(pattern16[15] == 1)
        {
            if(obstacle16[15].position_x  >= 300*size_dm || obstacle16[15].position_x  <= 10*size_dm || obstacle16[15].position_y <= 90*size_dm ||  obstacle16[15].position_y >=350*size_dm)
            {
                pattern_speed_number[30] = getRandomMath8(15, 0);
                obstacle16[15].setObstacleAlpha(200);
                if(pattern_speed_number[30] == 0)
                {
                    obstacle16[15].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[30] == 1)
                {
                    obstacle16[15].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[30] == 2)
                {
                    obstacle16[15].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[30] == 3)
                {
                    obstacle16[15].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[30] == 4)
                {
                    obstacle16[15].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[30] == 5)
                {
                    obstacle16[15].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[30] == 6)
                {
                    obstacle16[15].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[30] == 7)
                {
                    obstacle16[15].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[30] == 8)
                {
                    obstacle16[15].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[30] == 9)
                {
                    obstacle16[15].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[30] == 10)
                {
                    obstacle16[15].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[30] == 11)
                {
                    obstacle16[15].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[30] == 12)
                {
                    obstacle16[15].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[30] == 13)
                {
                    obstacle16[15].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[30] == 14)
                {
                    obstacle16[15].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[30] == 15)
                {
                    obstacle16[15].setPosition(four_SpeedX , four_SpeedY);
                }
            }
            else
            {
                obstacle16[15].setObstacleAlpha(200);
                if(pattern_speed_number[30] == 0)
                {
                    obstacle16[15].setPosition(three_SpeedX, three_SpeedY);
                }
                else if(pattern_speed_number[30] == 1)
                {
                    obstacle16[15].setPosition(two_SpeedX, two_SpeedY);

                } else if(pattern_speed_number[30] == 2)
                {
                    obstacle16[15].setPosition(three_SpeedX, three_SpeedY);

                } else if(pattern_speed_number[30] == 3)
                {
                    obstacle16[15].setPosition(one_SpeedX, one_SpeedY);
                } else if(pattern_speed_number[30] == 4)
                {
                    obstacle16[15].setPosition(twelve_SpeedX, twelve_SpeedY);
                } else if(pattern_speed_number[30] == 5)
                {
                    obstacle16[15].setPosition(eleven_SpeedX, eleven_SpeedY);
                } else if(pattern_speed_number[30] == 6)
                {
                    obstacle16[15].setPosition(eleven_ten_SpeedX, eleven_ten_SpeedY);
                } else if(pattern_speed_number[30] == 7)
                {
                    obstacle16[15].setPosition(ten_SpeedX, ten_SpeedY);
                } else if(pattern_speed_number[30] == 8)
                {
                    obstacle16[15].setPosition(nine_SpeedX, nine_SpeedY);
                } else if(pattern_speed_number[30] == 9)
                {
                    obstacle16[15].setPosition(eight_SpeedX, eight_SpeedY);
                } else if(pattern_speed_number[30] == 10)
                {
                    obstacle16[15].setPosition(eight_seven_SpeedX, eight_seven_SpeedY);
                } else if(pattern_speed_number[30] == 11)
                {
                    obstacle16[15].setPosition( seven_SpeedX, seven_SpeedY);
                } else if(pattern_speed_number[30] == 12)
                {
                    obstacle16[15].setPosition(six_SpeedX, six_SpeedY);
                } else if(pattern_speed_number[30] == 13)
                {
                    obstacle16[15].setPosition(five_SpeedX, five_SpeedY);
                } else if(pattern_speed_number[30] == 14)
                {
                    obstacle16[15].setPosition(five_four_SpeedX, five_four_SpeedY);
                } else if(pattern_speed_number[30] == 15)
                {
                    obstacle16[15].setPosition(four_SpeedX , four_SpeedY);
                }
            }
        }
        else
        {
            obstacle16[15].setObstacleAlpha(0);
            obstacle16[15].position_effect();
        }
    }

    boolean hit_check()
    {
        if(pattern[0] == 1)
        {
            if((obstacle[0].position_x+obstacle[0].resized_width/2 - player.getX())*(obstacle[0].position_x+obstacle[0].resized_width/2  - player.getX()) < (obstacle[0].resized_width/4)*(obstacle[0].resized_width/4))
            {
                if((obstacle[0].position_y+obstacle[0].resized_height/2- player.getY())*(obstacle[0].position_y+obstacle[0].resized_height/2 - player.getY()) < (obstacle[0].resized_height/4)*(obstacle[0].resized_height/4))
                {
                    return true;
                }
            }
        }

        if(pattern2[0] == 1)
        {
            if((obstacle2[0].position_x+obstacle2[0].resized_width/2  - player.getX())*(obstacle2[0].position_x+obstacle2[0].resized_width/2 - player.getX()) < (obstacle2[0].resized_width/4)*(obstacle2[0].resized_width/4))
            {
                if((obstacle2[0].position_y+obstacle2[0].resized_height/2 - player.getY())*(obstacle2[0].position_y+obstacle2[0].resized_height/2 - player.getY()) < (obstacle2[0].resized_height/4)*(obstacle2[0].resized_height/4))
                {
                    return true;
                }
            }
        }

        if(pattern2[1] == 1)
        {
            if((obstacle2[1].position_x+obstacle2[1].resized_width/2 - player.getX())*(obstacle2[1].position_x+obstacle2[1].resized_width/2 - player.getX()) < (obstacle2[1].resized_width/4)*(obstacle2[1].resized_width/4))
            {
                if((obstacle2[1].position_y+obstacle2[1].resized_height/2- player.getY())*(obstacle2[1].position_y +obstacle2[1].resized_height/2 - player.getY()) < (obstacle2[1].resized_height/4)*(obstacle2[1].resized_height/4))
                {
                    return true;
                }
            }
        }

        for(int i=0; i<4; i++) {
            if (pattern4[i] == 1) {
                if ((obstacle4[i].position_x+obstacle4[i].resized_width/2 - player.getX()) * (obstacle4[i].position_x+obstacle4[i].resized_width/2 - player.getX()) < ( obstacle4[i].resized_width / 4) * ( obstacle4[i].resized_width / 4)) {
                    if ((obstacle4[i].position_y+obstacle4[i].resized_height/2 - player.getY()) * (obstacle4[i].position_y +obstacle4[i].resized_height/2 - player.getY()) < (obstacle4[i].resized_height / 4) * ( obstacle4[i].resized_height / 4)) {
                        return true;
                    }
                }
            }
        }

        for(int i=0; i<8; i++) {
            if (pattern8[i] == 1) {
                if ((obstacle8[i].position_x+obstacle8[i].resized_width/2 - player.getX()) * (obstacle8[i].position_x+obstacle8[i].resized_width/2 - player.getX()) < ( obstacle8[i].resized_width / 4) * ( obstacle8[i].resized_width / 4)) {
                    if ((obstacle8[i].position_y +obstacle8[i].resized_height/2- player.getY()) * (obstacle8[i].position_y +obstacle8[i].resized_height/2- player.getY()) < ( obstacle8[i].resized_height / 4) * ( obstacle8[i].resized_height / 4)) {
                        return true;
                    }
                }
            }
        }

        for(int i=0; i<16; i++)
        {
            if(pattern16[i] == 1)
            {
                if((obstacle16[i].position_x+obstacle16[i].resized_width/2 - player.getX())*(obstacle16[i].position_x+obstacle16[i].resized_width/2- player.getX()) < (obstacle16[i].resized_width/4)*(obstacle16[i].resized_width/4))
                {
                    if((obstacle16[i].position_y+obstacle16[i].resized_height/2- player.getY())*(obstacle16[i].position_y+obstacle16[i].resized_height/2  - player.getY()) < (obstacle16[i].resized_height/4)*(obstacle16[i].resized_height/4))
                    {
                        return true;
                    }
                }
            }
        }

        for(int i=0; i<32; i++)
        {
            if(pattern32[i] == 1)
            {
                if((obstacle32[i].position_x+obstacle32[i].resized_width/2- player.getX())*(obstacle32[i].position_x+obstacle32[i].resized_width/2- player.getX()) < (obstacle32[i].resized_width/4)*(obstacle32[i].resized_width/4))
                {
                    if((obstacle32[i].position_y+obstacle32[i].resized_height/2- player.getY())*(obstacle32[i].position_y +obstacle32[i].resized_height/2- player.getY()) < (obstacle32[i].resized_height/4)*(obstacle32[i].resized_height/4))
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private int getRandomMath8(int max, int offset) {


        int nResult = (int)(Math.random() * (max-offset+1)) + offset;


        return nResult;

    }

    public void mapping()
    {
        tile_end_x1 = Math.round(tile.getX());
        tile_end_y1 = Math.round(tile.getY());

        tile_end_x2 = Math.round(tile45.getX());
        tile_end_y2 = Math.round(tile45.getY());

        tile_end_x3 = Math.round(tile52.getX());
        tile_end_y3 = Math.round(tile52.getY());

        tile_end_x4 = Math.round(tile32.getX());
        tile_end_y4 = Math.round(tile32.getY());

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

    public void player_moving(int x, int y, boolean button_down) {

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
        Drawable t = tile.getDrawable();
        Drawable t45 = tile45.getDrawable();
        Drawable t51 = tile52.getDrawable();
        Drawable t31 = tile32.getDrawable();

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

        if(t45 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t45).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t45.setCallback(null);

        if(t51 instanceof BitmapDrawable)
        {
            Bitmap bitmap = ((BitmapDrawable)t51).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
        t51.setCallback(null);


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


       obstacle[0].empty();
       obstacle2[0].empty(); obstacle2[1].empty();
        for(int i=0; i<4; i++) {
            obstacle4[i].empty();
        }

        for(int i =0; i<8; i++) {
            obstacle8[i].empty();
        }

        for(int i=0; i<16; i++) {
            obstacle16[i].empty();
        }

        for(int i=0; i<32; i++) {
            obstacle32[i].empty();
        }
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
