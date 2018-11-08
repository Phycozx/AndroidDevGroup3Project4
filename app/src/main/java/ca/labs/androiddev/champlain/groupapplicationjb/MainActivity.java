package ca.labs.androiddev.champlain.groupapplicationjb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
