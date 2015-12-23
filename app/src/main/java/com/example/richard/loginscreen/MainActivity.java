package com.example.richard.loginscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static Button login_button;
    private static EditText username;
    private static EditText password;
    private static TextView attempt_count;
    int max_attempts=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButtonClicked();
    }

    public void loginButtonClicked(){
        username = (EditText) findViewById(R.id.etxt_username);
        password = (EditText) findViewById(R.id.etxt_password);
        attempt_count = (TextView) findViewById(R.id.txt_attempt_count);
        login_button = (Button) findViewById(R.id.btn_login);

        login_button.setOnClickListener(buttonClicked);
    }

    public View.OnClickListener buttonClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(username.getText().toString().equals("Admin")&&
                    password.getText().toString().equals("pass1234")){

                Toast.makeText(MainActivity.this,"Correct Username and Password",Toast.LENGTH_LONG)
                        .show();

                Intent loginIntent = new Intent("com.example.richard.loginscreen.SuccessPage");
                startActivity(loginIntent);
            }else{//wrong username and password
                Toast.makeText(MainActivity.this,
                        "Incorrect Username or Password",Toast.LENGTH_LONG).show();

                --max_attempts;
                if(max_attempts==0){
                    //disable the login button
                    login_button.setEnabled(false);
                }
                attempt_count.setText(String.valueOf(max_attempts)+" attempts left");
            }
        }
    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
