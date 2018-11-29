package ca.labs.androiddev.champlain.groupapplicationjb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import ca.labs.androiddev.champlain.groupapplicationjb.Models.DBManager;
import ca.labs.androiddev.champlain.groupapplicationjb.Models.User;

public class LoginActivity extends AppCompatActivity
{


    //DBManager db = new DBManager(this);
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void btnGoIndex_onClick(View v)
    {
        super.finish();
    }

    public void btnLogin_onClick(View v)
    {
        EditText UsernameEdit = findViewById(R.id.editUsername);
        EditText PasswordEdit = findViewById(R.id.editPassword);
        TextView errorMessage = findViewById(R.id.errorMessageText);
        DBManager db = new DBManager(this);

        String newUsername = UsernameEdit.getText().toString();
        String newPassword = PasswordEdit.getText().toString();
        User newUser = new User(newUsername, newPassword);

        if (db.checkForUser(newUser))
        {
            User.setCurrUser(newUser.getUsername());
            User.setIsLoggedIn(true);
            super.finish();
        }
        else
        {
            errorMessage.setText("Invalid Username or Password");
        }

    }
}
