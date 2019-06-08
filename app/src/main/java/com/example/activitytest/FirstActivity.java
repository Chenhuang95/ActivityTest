package com.example.activitytest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);

        Button button1 = (Button)findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  String data = "hello hc";
              Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
            //  intent.putExtra("extra_data",data);
              startActivityForResult(intent,1);
                /*  Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                startActivity(intent);
                */
            }
        });
    }

//intent second返回
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case 1:
                if (requestCode==RESULT_OK){
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("FirstActivity",returnedData);
                }
                break;
                default:
        }
    }

    //menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"you click add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"you click remove",Toast.LENGTH_SHORT).show();
                break;
                default:
        }
        return true;
    }
}
