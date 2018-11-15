package ca.labs.androiddev.champlain.groupapplicationjb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

import Models.DBManager;

public class RegisterActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void btnGoIndex_onClick(View v)
    {
        super.finish();
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
        if (Pattern.matches("[a-zA-Z]+", password) == false)
        {
            validRegister = false;
            errorMessage = "Password must contain at least one number.";
        }
        if (!password.equals(passwordConfirm))
        {
            validRegister = false;
            errorMessage = "Passwords do not match";
        }
        if (validRegister)
        {
            DBManager db = new DBManager(this);
            db.addUser(username, password);
            Toast.makeText(getApplication(),"Successful Registration",Toast.LENGTH_LONG);
            super.finish();
        }
        else
        {
            errorText.setText(errorMessage);
        }
    }
}
