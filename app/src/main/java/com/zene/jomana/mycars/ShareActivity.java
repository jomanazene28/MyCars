package com.zene.jomana.mycars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class ShareActivity extends AppCompatActivity {
    private EditText etName;
    private EditText etPhone;
    private EditText etAdress;
    private EditText etType;
    private EditText etYear;
    private EditText etDetails;
    private EditText etPrice;
    private Button btnImage;
    private ImageView ivImage;
    private Button btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        etName=(EditText)findViewById(R.id.etName);
        etPhone=(EditText)findViewById(R.id.etPhone);
        etAdress=(EditText)findViewById(R.id.etAdress);
        etType=(EditText)findViewById(R.id.etType);
        etYear=(EditText)findViewById(R.id.etYear);
        etDetails=(EditText)findViewById(R.id.etDetails);
        etPrice=(EditText)findViewById(R.id.etPrice);
        btnImage=(Button)findViewById(R.id.btnImage);
        ivImage=(ImageView)findViewById(R.id.ivImage);
        btnShare=(Button)findViewById(R.id.btnShare);
        eventHandler();
    }
    public void dataHandler(){
        String stName=etName.getText().toString();
        String stPhone=etPhone.getText().toString();
        String stAddress=etAdress.getText().toString();
        String stType=etType.getText().toString();
        String stYear=etYear.getText().toString();
        String stDetails=etDetails.getText().toString();
        String stPrice=etPrice.getText().toString();
    }

    public void eventHandler(){
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ShareActivity.this,CarsListActivity.class);
                startActivity(i);
            }
        });
    }
}
