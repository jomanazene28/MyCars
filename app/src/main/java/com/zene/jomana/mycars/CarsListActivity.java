package com.zene.jomana.mycars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class CarsListActivity extends AppCompatActivity {
    private ListView lvCarsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carslist);
        lvCarsList=(ListView)findViewById(R.id.lvCarsList);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.logOut:
                FirebaseAuth.getInstance().signOut();
                Intent i=new Intent(CarsListActivity.this,LogInActivity.class);
                startActivity(i);
                break;
            case R.id.Settings:
                Toast.makeText(getBaseContext(),"Settings",Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }
}
