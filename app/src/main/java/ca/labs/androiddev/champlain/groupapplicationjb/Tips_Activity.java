package ca.labs.androiddev.champlain.groupapplicationjb;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Tips_Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    private DrawerLayout dl;
    private ActionBarDrawerToggle tg;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_);

        tv = (TextView) findViewById(R.id.all_tips);

        String s = "";

        s += "Tip 1: Always shower with cold water" + "\n \n";
        s += "Tip 2: Never leave the shower before putting on moisturizer" + "\n \n";
        s += "Tip 3: Maintain a healthy diet for smooth skin development" + "\n \n";
        s += "Tip 4: Avoid junk food as much as possible" + "\n \n";
        s += "Tip 5: Clean your face every Night" + "\n \n";
        s += "Tip 6: If you have oily skin, change your pillow cover every 3-4 nights" + "\n \n";
        s += "Tip 7: Limit skin exposure to sun" + "\n \n";
        s += "Tip 8: Scrub your skin with a natural scrubber to Exfoliate your skin" + "\n \n";
        s += "Tip 9: Use charcoal based masks to remove black heads" + "\n \n";
        s += "Tip 10: Exercise well and exercise often" + "\n \n";
        s += "Tip 11: Always remove your makeup before going to bed" + "\n \n";
        s += "Tip 12: Use sunscreen of at least 15 SPF when going outside during the summer" + "\n \n";
        s += "Tip 13: Eat fresh fruits and veggies" + "\n \n";
        s += "Tip 14: Stay away from fried food" + "\n \n";
        s += "Tip 15: Sleep at least 8 hours every night" + "\n \n";
        s += "Tip 16: Stay hydrated" + "\n \n";
        s += "Tip 17: Rose water helps with maintain PH levels" + "\n \n";
        s += "Tip 18: Have a regular skin care regime" + "\n \n";
        s += "Tip 19: Reduce your stress levels" + "\n \n";
        s += "Tip 20: Do not over wash your skin, your skin produces healthy oils as well" + "\n \n";

        tv.setMovementMethod(new ScrollingMovementMethod());
        tv.setText(s);

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
