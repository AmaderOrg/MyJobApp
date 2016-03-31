package com.amaderorg.myjobapp.Model.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.amaderorg.myjobapp.Model.Database.Tables.ContactsTableSchema;

/**
 * Created by souvi_000 on 3/28/2016.
 */
public class ApplicationDBHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FeedReader.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String NUMBER_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_SENDER_CONTACTS =
            "CREATE TABLE " + ContactsTableSchema.ContactEntry.TABLE_NAME + " (" +
                    ContactsTableSchema.ContactEntry.CONTACT_ID + NUMBER_TYPE + " PRIMARY KEY AUTOINCREMENT," +
                    ContactsTableSchema.ContactEntry.FIRST_NAME + TEXT_TYPE + COMMA_SEP +
                    ContactsTableSchema.ContactEntry.LAST_NAME + TEXT_TYPE + COMMA_SEP +
                    ContactsTableSchema.ContactEntry.COMPANY + TEXT_TYPE + COMMA_SEP +
                    ContactsTableSchema.ContactEntry.LOCATION + NUMBER_TYPE + COMMA_SEP +
                    ContactsTableSchema.ContactEntry.EMAIL_ID + TEXT_TYPE + " )";

    private static final String SQL_SENDER_CONTACTS_DELETE =
            "DROP TABLE IF EXISTS " + ContactsTableSchema.ContactEntry.TABLE_NAME;

    public ApplicationDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_SENDER_CONTACTS);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_SENDER_CONTACTS_DELETE);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}

