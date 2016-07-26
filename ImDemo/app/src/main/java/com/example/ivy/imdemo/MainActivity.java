package com.example.ivy.imdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnOther = (Button) findViewById(R.id.button);
        btnOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // startActivity(new Intent(MainActivity.this,ChatActivity.class));
                /***5 开启单聊*/
                if (RongIM.getInstance()!=null){
                    RongIM.getInstance().startPrivateChat(MainActivity.this,"1","title");
                }
            }
        });


        //在 activity 中连接融云，RongIM.connect（token,callback）操作。

        initRongyun();

    }

    private void initRongyun() {

//        String Token = "Uv44TBK1zzvazQikuApFfShN3jxO+sRwk7jce09f//4ox/tGDSXEOVHNzufPYKVLtiPtn5TkcTk=";//1
        String Token = "OGM44tQW2w8BRlIn5VohkpfZx7lUd3cu16sagBNaiRb4znarEfl7h4Gz+raZQA8SeWSderDz3zo/WNDXMgqZjQ==";//2

        RongIM.connect(Token,new RongIMClient.ConnectCallback(){

            @Override
            public void onSuccess(String userId) {
                Log.e("MainActivity", "——onSuccess—-" + userId);
            }

            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {

                Log.e("MainActivity", "——onError—-" + errorCode);
            }

            @Override
            public void onTokenIncorrect() {

            }
        });
    }
}
