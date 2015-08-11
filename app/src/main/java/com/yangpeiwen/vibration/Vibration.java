package com.yangpeiwen.vibration;

import android.app.Activity;
import android.os.Vibrator;
import android.os.Bundle;
import android.widget.SeekBar;

public class Vibration extends Activity {
    Vibrator vibrator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibration);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                startVibrate(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        vibrator.cancel();
    }

    void startVibrate(int value){
        long pattern[] = {10-value, 10+value, 10-value, 10+value};
        if(value==0)vibrator.cancel();
        else vibrator.vibrate(pattern, 2);
    }
}
