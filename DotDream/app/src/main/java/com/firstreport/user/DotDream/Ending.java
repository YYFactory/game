package com.firstreport.user.DotDream;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Created by user on 2017-06-29.
 */

public class Ending extends AppCompatActivity {

    private TextView test2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending);

        TextView main_first = null;
        setFont_ending(main_first, "fonts/korra.ttf", R.id.button);
        setFont_ending(main_first, "fonts/korra.ttf", R.id.test);
        setFont_ending(main_first, "fonts/korra.ttf", R.id.test2);

        test2 = (TextView) findViewById(R.id.test2);
        int score = getIntent().getIntExtra("SCORE", 0);
        test2.setText(score + "");

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Button button = (Button)findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), game.class);
                startActivity(intent);
            }
        });
    }

    void setFont_ending(TextView name, String path, int res)
    {
        name = (TextView)findViewById(res);
        Typeface font = Typeface.createFromAsset(this.getAssets(), path);

        name.setTypeface(font);
    }

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
