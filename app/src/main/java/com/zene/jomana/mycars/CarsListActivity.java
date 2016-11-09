package com.zene.jomana.mycars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.zene.jomana.mycars.data.MyAdapter;
import com.zene.jomana.mycars.data.MyCar;

public class CarsListActivity extends AppCompatActivity {
    private ListView lvCarsList;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carslist);
        lvCarsList = (ListView) findViewById(R.id.lvCarsList);
        myAdapter = new MyAdapter(this, R.layout.activity_my_adapter);
        lvCarsList.setAdapter(myAdapter);
        initListView();


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logOut:
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(CarsListActivity.this, LogInActivity.class);
                startActivity(i);
                break;
            case R.id.Settings:
                Toast.makeText(getBaseContext(), "Settings", Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }

    private void initListView() {

        String email = FirebaseAuth.getInstance().getCurrentUser().getEmail().replace('.', '_');
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(email);
        reference.child("MyTasks").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                myAdapter.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    MyCar myCar = ds.getValue(MyCar.class);
                    myCar.setType(ds.getKey());
                    myAdapter.add(myCar);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
