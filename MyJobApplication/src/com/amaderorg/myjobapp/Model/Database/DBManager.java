package com.amaderorg.myjobapp.Model.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.amaderorg.myjobapp.Model.Database.Tables.Contact;
import com.amaderorg.myjobapp.Model.Database.Tables.ContactsTableSchema.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Database manager provides methods to perform SQL operations of the database tables
 */
public class DBManager {
    private static SQLiteDatabase mSQLiteDatabase;
    private Context mContext;
    public DBManager (Context context) {
        mContext = context;
        ApplicationContentProvider applicationContentProvider = new ApplicationContentProvider();
        mSQLiteDatabase = applicationContentProvider.getDatabase();
    }

    /**
     * This method helps adding a Contact information in the database
     *
     * @param contactInformation : Contact information
     */
    public void addContact(Contact contactInformation) {
       // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(ContactEntry.FIRST_NAME, contactInformation.getFirstName());
        values.put(ContactEntry.LAST_NAME, contactInformation.getLastName());
        values.put(ContactEntry.COMPANY, contactInformation.getCompanyName());
        values.put(ContactEntry.LOCATION, contactInformation.getLocation());
        values.put(ContactEntry.EMAIL_ADDRESS, contactInformation.getEmailAddress());

        // Insert the new row, returning the primary key value of the new row
        mContext.getContentResolver().insert(ApplicationContentProvider.CONTACTS_TABLE_URI, values);
    }

    /**
     * This methods helps to retrieve all contact information from the database
     *
     * @return list of all contact information from the database
     */
    public List<Contact> getAllContacts() {
        List<Contact> list = new ArrayList<Contact>();
        String query = "Select * From "+ ContactEntry.TABLE_NAME;

        Cursor cursor = mSQLiteDatabase.rawQuery(query, null);

        if (cursor.moveToFirst()){
            while(!cursor.isAfterLast()){
                Contact sender = new Contact();
                sender.setFirstName(cursor.getString(cursor.getColumnIndex(ContactEntry.FIRST_NAME)));
                sender.setLastName(cursor.getString(cursor.getColumnIndex(ContactEntry.LAST_NAME)));
                sender.setCompanyName(cursor.getString(cursor.getColumnIndex(ContactEntry.COMPANY)));
                sender.setLocation(cursor.getInt(cursor.getColumnIndex(ContactEntry.LOCATION)));
                sender.setEmailId(cursor.getString(cursor.getColumnIndex(ContactEntry.EMAIL_ADDRESS)));
                list.add(sender);
                // do what ever you want here
                cursor.moveToNext();
            }
        }
        cursor.close();
        return list;
    }
}
