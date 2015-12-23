package com.example.richard.loginscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SuccessPage extends AppCompatActivity {

    private static Button button_sbm;
    private static ImageView img_view;
    private int currentImage;
    int images[] = {R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5};
    private static Button button_names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_page);

        imageSwitched(); seeNames();
    }

    public void imageSwitched(){
        button_sbm = (Button) findViewById(R.id.btn_switch);
        img_view = (ImageView) findViewById(R.id.img_view);

        button_sbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ++currentImage;
                        currentImage = currentImage % images.length;//ensure always within range
                        img_view.setImageResource(images[currentImage]);
                    }
                }
        );
    }

    public void seeNames(){
        button_names = (Button) findViewById(R.id.btn_names);

        button_names.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent namesIntent = new Intent("com.example.richard.loginscreen.NameLists");
                        startActivity(namesIntent);
                    }
                }
        );
    }

}
