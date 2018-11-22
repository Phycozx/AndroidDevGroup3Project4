package ca.labs.androiddev.champlain.groupapplicationjb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import Models.User;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.btnAddProduct);
      //  button.setEnabled(false);
        button.setVisibility(View.GONE);
    //    button.setBackgroundResource(R.drawable.ic_launcher_background);
    }

    @Override
    protected void onStart()
    {
        if (User.isIsLoggedIn())
        {
            TextView t = (TextView)findViewById(R.id.userTextView);
            t.setText("Welcome, " + User.getCurrUser());

            if(User.getCurrUser().equals("admin")){
                Button button = (Button)findViewById(R.id.btnAddProduct);
              //  button.setEnabled(true);
                button.setVisibility(View.VISIBLE);
        }


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

    public void btnAddProduct_onClick(View v)
    {
        startActivity(new Intent(this, AddProduct_Activity.class));
    }

    public void btnRegister_onClick(View v)
    {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    public void btnAbout_onClick(View v)
    {
        startActivity(new Intent(this, AboutActivity.class ));
    }
}
