package ca.labs.androiddev.champlain.groupapplicationjb;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import ca.labs.androiddev.champlain.groupapplicationjb.Models.DBManager;
import ca.labs.androiddev.champlain.groupapplicationjb.Models.Product;
import ca.labs.androiddev.champlain.groupapplicationjb.Models.User;

public class StoreActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    private DrawerLayout dl;
    private ActionBarDrawerToggle tg;
    ArrayList<Product> products;
    ProductAdapter adapter;
    DBManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        RecyclerView recyclerView = findViewById(R.id.recyclerView_list);

        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));

        manager = new DBManager(this);

        products = manager.getProductList();

        adapter = new ProductAdapter(products);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

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

    @Override
    public void onStart()
    {
        Button addButton = (Button)findViewById(R.id.addItemButton);
        addButton.setVisibility(View.GONE);
        if (User.isIsLoggedIn())
        {
            if (User.getCurrUser().equals("admin"))
            {
                addButton.setVisibility(View.VISIBLE);
            }
        }
        super.onStart();
    }

    public void btnGoIndex_onClick(View v)
    {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void btnAddItem_onClick(View v)
    {
        startActivity(new Intent(this, AddProduct_Activity.class));
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
