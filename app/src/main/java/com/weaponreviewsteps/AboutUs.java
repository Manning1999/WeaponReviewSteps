package com.weaponreviewsteps;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AboutUs extends AppCompatActivity {


    TextView Hyperlink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);


        ConfigureHomeButton();


        Hyperlink = findViewById(R.id.Website);
        Spanned text = Html.fromHtml("Website: " + "<a href='https://internationalweaponsreview.com/'>internationalweaponsreview.com</a>");
        Hyperlink.setMovementMethod(LinkMovementMethod.getInstance());
        Hyperlink.setText(text);

    }


    //region ----Buttons-----
    //-----------------------------------------------------------------------------------------------------------------


    private void ConfigureHomeButton(){
        ImageButton button = findViewById(R.id.home);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(AboutUs.this, MainPage.class));
            }
        });

    }









    //-----------------------------------------------------------------------------------------------------------------
    //endregion
}
