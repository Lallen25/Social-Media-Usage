package com.lewisswrec.swrec11;

import android.content.ClipData;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HelpScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_screen);

        Button copybtn = this.findViewById(R.id.button);
       final TextView email = this.findViewById(R.id.textView6);



        copybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE)).setText(email.getText().toString());
            }
        });
    }
}
