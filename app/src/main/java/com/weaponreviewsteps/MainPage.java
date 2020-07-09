package com.weaponreviewsteps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainPage extends AppCompatActivity {


    Button processButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);


        ConfigureStepsButton();
        ConfigureAboutUsButton();
    }



    private void ConfigureStepsButton(){

        processButton = findViewById(R.id.Process1);

        processButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainPage.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }


    private void ConfigureAboutUsButton(){
        Button button = findViewById(R.id.AboutUs);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(MainPage.this, AboutUs.class));
            }
        });

    }
}
