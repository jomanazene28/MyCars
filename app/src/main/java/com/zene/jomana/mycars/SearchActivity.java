package com.zene.jomana.mycars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SearchActivity extends AppCompatActivity {
    private EditText etName;
    private EditText etAdress;
    private EditText etType;
    private EditText etYear;
    private Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        etName=(EditText)findViewById(R.id.etName);
        etAdress=(EditText)findViewById(R.id.etAdress);
        etType=(EditText)findViewById(R.id.etType);
        etYear=(EditText)findViewById(R.id.etYear);
        btnSearch=(Button)findViewById(R.id.btnSearch);
        eventHandler();
    }
    public void dataHandler(){
        String stName=etName.getText().toString();
        String stAdress=etAdress.getText().toString();
        String stType=etType.getText().toString();
        String stYear=etYear.getText().toString();
    }

    public void eventHandler(){
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SearchActivity.this,CarsListActivity.class);
                startActivity(i);
            }
        });
    }
}
