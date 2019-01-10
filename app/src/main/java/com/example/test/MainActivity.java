package com.example.test;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    private final int WC = ViewGroup.LayoutParams.WRAP_CONTENT;
    private final int MP = ViewGroup.LayoutParams.MATCH_PARENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        MyDrawerLayout drawerLayout = new MyDrawerLayout(this);
        drawerLayout.setLayoutParams(new MyDrawerLayout.LayoutParams(MP, WC));
        setContentView(drawerLayout);


        LinearLayout firstLayout = new LinearLayout(this);
        firstLayout.setLayoutParams(new DrawerLayout.LayoutParams(MP, MP));
        firstLayout.setOrientation(LinearLayout.VERTICAL);
        drawerLayout.addView(firstLayout);

        TextView textView = new TextView(this);
        textView.setText("こいつは画面に表示される");
        firstLayout.addView(textView, new LinearLayout.LayoutParams(WC, WC));

        //こいつがメニューとして隠れてほしいが現状表示されてしまっている
        LinearLayout secondLayout = new LinearLayout(this);
        secondLayout.setOrientation(LinearLayout.VERTICAL);
        secondLayout.setBackgroundColor(Color.GRAY);
        DrawerLayout.LayoutParams lp = new DrawerLayout.LayoutParams(300, MP);
        //layout_gravity = "left"相当だと思っている
        lp.gravity = Gravity.LEFT;
        secondLayout.setLayoutParams(lp);
        drawerLayout.addView(secondLayout);
        Button secondButton = new Button(this);
        secondButton.setText("メニュー");
        secondButton.setBackgroundColor(Color.GREEN);
        secondLayout.addView(secondButton, new LinearLayout.LayoutParams(MP, WC));


    }
}

