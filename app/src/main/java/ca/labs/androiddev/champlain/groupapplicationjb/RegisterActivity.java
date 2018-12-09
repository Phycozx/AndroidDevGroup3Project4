package ca.labs.androiddev.champlain.groupapplicationjb;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ca.labs.androiddev.champlain.groupapplicationjb.Models.DBManager;
import ca.labs.androiddev.champlain.groupapplicationjb.Models.User;

public class RegisterActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    private DrawerLayout dl;
    private ActionBarDrawerToggle tg;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Copy-Paste of Sidebar Code
        dl = (DrawerLayout)findViewById(R.id.drawer_layout);
        tg = new ActionBarDrawerToggle(this, dl,R.string.nav_open, R.string.nav_close);
        dl.addDrawerListener(tg);
        tg.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        dl.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View view, float v) {

            }

            @Override
            public void onDrawerOpened(@NonNull View view) {

            }

            @Override
            public void onDrawerClosed(@NonNull View view) {

            }

            @Override
            public void onDrawerStateChanged(int i) {

            }
        });
        NavigationView nv = findViewById(R.id.nav_view);
        nv.setNavigationItemSelectedListener(this);
        //End of Copy-Paste Sidebar Code
    }

    public void btnGoIndex_onClick(View v)
    {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void btnRegister_onClick(View v)
    {

        EditText usernameInput = (EditText)findViewById(R.id.editUsername);
        EditText passwordInput = (EditText)findViewById(R.id.editPassword);
        EditText passwordConfirmInput = (EditText)findViewById(R.id.editConfirmPassword);
        TextView errorText = (TextView)findViewById(R.id.errorMessageText);


        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();
        String passwordConfirm = passwordConfirmInput.getText().toString();

        boolean validRegister = true;
        String errorMessage = "";
        DBManager db = new DBManager(this);

        if (!password.equals(passwordConfirm))
        {
            validRegister = false;
            errorMessage = "Passwords do not match";
        }
        if (db.checkForUser(new User(username, password)))
        {
            validRegister = false;
            errorMessage = "Username already taken";
        }
        if (validRegister)
        {

            if (!db.checkForUser(new User(username, password)))
            {
                db.addUser(username, password);
                Toast.makeText(getApplication(),"Successful Registration",Toast.LENGTH_LONG);
                super.finish();
            }
            else
            {
                errorText.setText("Username already taken");
            }

        }
        else
        {
            errorText.setText(errorMessage);
        }
    }



    //Copy Paste of Sidebar Code
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (tg.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        String buttonText = menuItem.getTitle().toString();
        if (buttonText.equals("Home"))
        {
            dl.closeDrawers();
            startActivity(new Intent(this, MainActivity.class));
        }
        else if (buttonText.equals("Store"))
        {
            dl.closeDrawers();
            startActivity(new Intent(this, StoreActivity.class));
        }
        else if (buttonText.equals("Tips"))
        {
            dl.closeDrawers();
            startActivity(new Intent(this, Tips_Activity.class));
        }
        else if (buttonText.equals("Login"))
        {
            dl.closeDrawers();
            startActivity(new Intent(this, LoginActivity.class));
        }
        else if (buttonText.equals("About Us"))
        {
            dl.closeDrawers();
            startActivity(new Intent(this, AboutActivity.class));
        }
        return true;
    }
    //End of Copy Pasted Code
}
