package ca.labs.androiddev.champlain.groupapplicationjb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        tv = (TextView) findViewById(R.id.about_us);

        String s = "";

        s += "JB skin guru is a company that offers both a product and a service. We offer " + "\n" +
                "skin consolation to users who wish to know more about their skin quality. " + "\n" +
                "We also sell high quality beauty products that are perfect for every girl.  " + "\n \n \n";
        s += "Contact info: \n \n";
        s += "Web page: www.jbskinguru.com \n";
        s += "email: rebeccalabelle006@gmail.com and michabessette@gmail.com";

        tv.setText(s);
    }

    public void btnGoIndex_onClick(View v)
    {
        super.finish();
    }
}
