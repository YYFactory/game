package com.firstreport.user.DotDream;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by user on 2017-06-25.
 */

public class SplashActivity extends AppCompatActivity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        initialize();
    }

    private void initialize() {

        Handler handler = new Handler()
        {
            @Override
            public void handleMessage(Message msg)
            {
                finish();

                overridePendingTransition(R.layout.fadein, R.layout.fadeout);
            }
        };
        handler.sendEmptyMessageDelayed(0, 2000);

    }
}
