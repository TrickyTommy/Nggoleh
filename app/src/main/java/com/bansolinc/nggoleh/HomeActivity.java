package com.bansolinc.nggoleh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.support.v7.widget.Toolbar;
import android.widget.ViewFlipper;


public class HomeActivity extends AppCompatActivity {

    ImageView btn_store,btn_account,btn_chat;
    ViewFlipper v_flipper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ///

        ///

        btn_store = (ImageView) findViewById(R.id.btn_store);
        btn_chat = (ImageView) findViewById(R.id.btn_chat);
        btn_account = (ImageView) findViewById(R.id.btn_account);

        int images[] = {R.drawable.umkmtoko, R.drawable.umkmtoko2, R.drawable.umkmtokobatik,R.drawable.umkmtokobatikbaju};
        v_flipper = findViewById(R.id.v_flipper);

        for (int i = 0; i < images.length; i++) {
            fliverImages(images[i]);
        }
        for (int image : images)
            fliverImages(image);

        //
        btn_store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ListHome.class);
                startActivity(intent);
            }
        });

        btn_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
//        btn_chat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(HomeActivity.this, Main2Activity.class);
//                startActivity(intent);
//            }
//        });

        ///
    }

    public void fliverImages(int images) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(images);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);

        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);

    }
}
