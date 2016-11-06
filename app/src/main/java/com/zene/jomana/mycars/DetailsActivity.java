package com.zene.jomana.mycars;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    private ImageView ivImage;
    private TextView tvName;
    private TextView tvPrice;
    private TextView tvPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ivImage=(ImageView)findViewById(R.id.ivImage);
        tvName=(TextView)findViewById(R.id.tvName);
        tvPrice=(TextView)findViewById(R.id.tvPrice);
        tvPhone=(TextView)findViewById(R.id.tvPhone);

    }
    private void dataHandler(){
        String stName=tvName.getText().toString();
        String stPrice=tvPrice.getText().toString();
        String stPhone=tvPhone.getText().toString();
    }


}
