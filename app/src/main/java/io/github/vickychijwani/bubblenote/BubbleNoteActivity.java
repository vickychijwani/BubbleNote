package io.github.vickychijwani.bubblenote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class BubbleNoteActivity extends Activity implements SeekBar.OnSeekBarChangeListener {

    public static final String TAG = "BubbleNoteActivity";

    private Button mShowChatHead;
    private SeekBar mSpringTensionSlider;
    private SeekBar mSpringFrictionSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bubble_note);

        mShowChatHead = (Button) findViewById(R.id.show_bubble);
        mSpringTensionSlider = (SeekBar) findViewById(R.id.spring_tension);
        mSpringFrictionSlider = (SeekBar) findViewById(R.id.spring_friction);

        mShowChatHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), BubbleNoteService.class);
                startService(i);
            }
        });

        mSpringTensionSlider.setProgress(BubbleNoteService.sSpringTension);
        mSpringFrictionSlider.setProgress(BubbleNoteService.sSpringFriction);

        mSpringTensionSlider.setOnSeekBarChangeListener(this);
        mSpringFrictionSlider.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (seekBar == mSpringTensionSlider) {
            BubbleNoteService.sSpringTension = progress;
        } else if (seekBar == mSpringFrictionSlider) {
            BubbleNoteService.sSpringFriction = progress;
        }
        BubbleNoteService.setSpringConfig();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
