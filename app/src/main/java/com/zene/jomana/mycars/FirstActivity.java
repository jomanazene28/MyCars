package com.zene.jomana.mycars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity {
    private Button btnSell;
    private Button btnBuy;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        btnSell=(Button) findViewById(R.id.btnSell);
        btnBuy=(Button) findViewById(R.id.btnBuy);
        eventHandler();
    }

    private void eventHandler(){
        btnSell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(FirstActivity.this,ShareActivity.class);
                startActivity(i);
            }
        });
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(FirstActivity.this,SearchActivity.class);
                startActivity(i);
            }
        });
    }
}
