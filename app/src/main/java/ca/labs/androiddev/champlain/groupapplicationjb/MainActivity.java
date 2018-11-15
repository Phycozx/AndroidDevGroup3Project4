package ca.labs.androiddev.champlain.groupapplicationjb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import Models.User;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart()
    {
        if (User.isIsLoggedIn())
        {
            TextView t = (TextView)findViewById(R.id.userTextView);
            t.setText("Welcome, " + User.getCurrUser());
        }
        super.onStart();
    }


    public void btnStore_onClick(View v)
    {
        startActivity(new Intent(this, StoreActivity.class));
    }

    public void btnTips_onClick(View v)
    {
        startActivity(new Intent(this, Tips_Activity.class));
    }

    public void btnLogin_onClick(View v)
    {
        startActivity(new Intent(this, LoginActivity.class));
    }

    public void btnRegister_onClick(View v)
    {
        startActivity(new Intent(this, RegisterActivity.class));
    }
}
