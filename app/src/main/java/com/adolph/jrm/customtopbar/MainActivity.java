package com.adolph.jrm.customtopbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TopBar topBar = (TopBar) findViewById(R.id.topbar);
        topBar.setOnTopbarClickListener(new TopBar.topbarClickListener() {
            @Override
            public void leftClick() {
                Toast.makeText(MainActivity.this,"Left",Toast.LENGTH_LONG).show();
            }

            @Override
            public void rightClick() {
                Toast.makeText(MainActivity.this,"Right",Toast.LENGTH_LONG).show();
            }
        });
    }
}
