package ca.labs.androiddev.champlain.groupapplicationjb.Models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBManager extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "AndroidFinalProject";
    public DBManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public static final String CREATE_USER_TAB_QUERY = "CREATE TABLE " + User.USER_TAB_NAME + " (" +
            User.USER_COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            User.USER_COL_USERNAME + " TEXT," +
            User.USER_COL_PASSWORD + " TEXT)";

    public static final String CREATE_PRODUCT_TAB_QUERY = "CREATE TABLE " + Product.PRODUCT_TAB_NAME + " (" +
            Product.PRODUCT_COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            Product.PRODUCT_COL_NAME + " TEXT," +
            Product.PRODUCT_COL_PRICE + " NUMBER," +
            Product.PRODUCT_COL_DESCRIPTION + " TEXT)";

    private final static String adminUsername = "admin";
    private final static String adminPassword = "admin";


    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREATE_USER_TAB_QUERY);

        ContentValues vals = new ContentValues();
        vals.put(User.USER_COL_USERNAME,adminUsername);
        vals.put(User.USER_COL_PASSWORD,adminPassword);
        db.insert(User.USER_TAB_NAME,null, vals);

        db.execSQL(CREATE_PRODUCT_TAB_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }

    public void addUser(String username, String password)
    {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues vals = new ContentValues();
        vals.put(User.USER_COL_PASSWORD,password);
        vals.put(User.USER_COL_USERNAME,username);
        db.insert(User.USER_TAB_NAME,null, vals);
        db.close();
    }
    public ArrayList<User> getUserList()
    {
        ArrayList<User> list = new ArrayList<User>();
        SQLiteDatabase db = this.getWritableDatabase();

        String GET_LIST = "SELECT * FROM " + User.USER_TAB_NAME+";";
        Cursor c = db.rawQuery(GET_LIST,null);

        if (c.moveToFirst())
        {
            do {
                User us = new User();
                us.setId(c.getInt(c.getColumnIndex(User.USER_COL_ID)));
                us.setUsername(c.getString(c.getColumnIndex(User.USER_COL_USERNAME)));
                us.setPassword(c.getString(c.getColumnIndex(User.USER_COL_PASSWORD)));

                list.add(us);
            } while (c.moveToNext());
        }
        return list;
    }

    public boolean checkForUser(User u)
    {
        ArrayList<User> list = getUserList();
        boolean valid = false;
        for (int i = 0; i < list.size(); i++)
        {
            if (u.getUsername().equals(list.get(i).getUsername()))
            {
                if (u.getPassword().equals(list.get(i).getPassword()))
                {
                    valid = true;
                }
            }
        }
        return valid;

    }

    //Product
    public void addProduct(String name, double price, String description )
    {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues vals = new ContentValues();
        vals.put(Product.PRODUCT_COL_NAME,name);
        vals.put(Product.PRODUCT_COL_PRICE,price);
        vals.put(Product.PRODUCT_COL_DESCRIPTION,description);
        db.insert(Product.PRODUCT_TAB_NAME,null, vals);
        db.close();
    }

    public ArrayList<Product> getProductList()
    {
        ArrayList<Product> list = new ArrayList<Product>();
        SQLiteDatabase db = this.getWritableDatabase();

        String GET_LIST = "SELECT * FROM " + Product.PRODUCT_TAB_NAME+";";
        Cursor c = db.rawQuery(GET_LIST,null);

        if (c.moveToFirst())
        {
            do {
                Product prod = new Product();
                prod.setId(c.getInt(c.getColumnIndex(Product.PRODUCT_COL_ID)));
                prod.setName(c.getString(c.getColumnIndex(Product.PRODUCT_COL_NAME)));
                prod.setPrice(c.getDouble(c.getColumnIndex(Product.PRODUCT_COL_PRICE)));
                prod.setDescription(c.getString(c.getColumnIndex(Product.PRODUCT_COL_DESCRIPTION)));
                list.add(prod);
            } while (c.moveToNext());
        }
        return list;
    }

    public boolean productExists(Product p)
    {
        ArrayList<Product> list = getProductList();
        for (int i = 0; i < list.size(); i++)
        {
            if (p.getName().equals(list.get(i).getName()))
            {
                return true;
            }
        }
        return false;

    }

}
