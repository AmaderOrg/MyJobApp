package com.amaderorg.myjobapp.Model.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.amaderorg.myjobapp.Model.Database.Tables.ContactInformation;
import com.amaderorg.myjobapp.Model.Database.Tables.ContactsTableSchema.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by souvi_000 on 3/28/2016.
 */
public class DBManager {
    private static SQLiteDatabase mSQLiteDatabase;
    private Context mContext;
    public DBManager (Context context) {
        mContext = context;
        ApplicationContentProvider applicationContentProvider = new ApplicationContentProvider();
        mSQLiteDatabase = applicationContentProvider.getDatabase();
    }

    public void addSenderContact(ContactInformation sender) {
       // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(ContactEntry.FIRST_NAME, sender.getFirstName());
        values.put(ContactEntry.LAST_NAME, sender.getLastName());
        values.put(ContactEntry.COMPANY, sender.getCompanyName());
        values.put(ContactEntry.LOCATION, sender.getLocation());
        values.put(ContactEntry.EMAIL_ID, sender.getEmailId());

        // Insert the new row, returning the primary key value of the new row
        mContext.getContentResolver().insert(ApplicationContentProvider.CONTACTS_TABLE_URI, values);
    }

    public List<ContactInformation> getAllSenderContacts() {
        List<ContactInformation> list = new ArrayList<ContactInformation>();
        String query = "Select * From "+ ContactEntry.TABLE_NAME;

        Cursor cursor = mSQLiteDatabase.rawQuery(query, null);

        if (cursor.moveToFirst()){
            while(!cursor.isAfterLast()){
                ContactInformation sender = new ContactInformation();
                sender.setFirstName(cursor.getString(cursor.getColumnIndex(ContactEntry.FIRST_NAME)));
                sender.setLastName(cursor.getString(cursor.getColumnIndex(ContactEntry.LAST_NAME)));
                sender.setCompanyName(cursor.getString(cursor.getColumnIndex(ContactEntry.COMPANY)));
                sender.setLocation(cursor.getInt(cursor.getColumnIndex(ContactEntry.LOCATION)));
                sender.setEmailId(cursor.getString(cursor.getColumnIndex(ContactEntry.EMAIL_ID)));
                list.add(sender);
                // do what ever you want here
                cursor.moveToNext();
            }
        }
        cursor.close();
        return list;
    }
}
