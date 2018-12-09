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
import android.widget.Toast;

import ca.labs.androiddev.champlain.groupapplicationjb.Models.DBManager;
import ca.labs.androiddev.champlain.groupapplicationjb.Models.Product;

public class AddProduct_Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout dl;
    private ActionBarDrawerToggle tg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

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

    public void btnAdd_onClick(View v){
        EditText nameInput = (EditText)findViewById(R.id.editName);
        EditText priceInput = (EditText)findViewById(R.id.editPrice);
        EditText descInput = (EditText)findViewById(R.id.editDescription);

        String name = nameInput.getText().toString();
        double price = Double.parseDouble(priceInput.getText().toString());
        String desc = descInput.getText().toString();

        DBManager db = new DBManager(this);

        if(!db.productExists(new Product(name,price,desc))) {
            db.addProduct(name, price, desc);
            Toast.makeText(getApplication(), name + " added", Toast.LENGTH_LONG).show();

            nameInput.setText("");
            priceInput.setText("");
            descInput.setText("");
        }
        else{
            Toast.makeText(getApplication(), name + " already exists", Toast.LENGTH_LONG).show();
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
