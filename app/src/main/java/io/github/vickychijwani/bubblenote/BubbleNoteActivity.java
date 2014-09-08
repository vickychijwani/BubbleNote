package io.github.vickychijwani.bubblenote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BubbleNoteActivity extends Activity {

    public static final String TAG = "BubbleNoteActivity";

    Button showChatHead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bubble_note);

        showChatHead = (Button) findViewById(R.id.show_bubble);

        showChatHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), BubbleNoteService.class);
                startService(i);
            }
        });
    }

}
