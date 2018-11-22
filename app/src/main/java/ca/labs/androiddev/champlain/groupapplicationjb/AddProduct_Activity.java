package ca.labs.androiddev.champlain.groupapplicationjb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Models.DBManager;
import Models.Product;

public class AddProduct_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);


    }

    public void btnGoIndex_onClick(View v)
    {
        super.finish();
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
}
