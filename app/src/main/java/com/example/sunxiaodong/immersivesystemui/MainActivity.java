package com.example.sunxiaodong.immersivesystemui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.sunxiaodong.immersivesystemui.immersive.ImmersiveActivity;
import com.example.sunxiaodong.immersivesystemui.translucent.TranslucentBarActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mGoTranslucentBar;
    private Button mGoImmersive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mGoTranslucentBar = (Button) findViewById(R.id.go_translucent_bar);
        mGoTranslucentBar.setOnClickListener(this);
        mGoImmersive = (Button) findViewById(R.id.go_immersive);
        mGoImmersive.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.go_translucent_bar: {
                goTranslucentBar();
            }
            break;
            case R.id.go_immersive: {
                goImmersive();
            }
            break;
        }
    }

    private void goTranslucentBar() {
        Intent intent = new Intent(this, TranslucentBarActivity.class);
        startActivity(intent);
    }

    private void goImmersive() {
        Intent intent = new Intent(this, ImmersiveActivity.class);
        startActivity(intent);
    }

}
