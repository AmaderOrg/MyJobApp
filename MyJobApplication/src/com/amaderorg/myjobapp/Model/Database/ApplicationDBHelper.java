package com.amaderorg.myjobapp.Model.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.amaderorg.myjobapp.Model.Database.Tables.ContactsTableSchema;

/**
 * Database setup class for my job app
 */
public class ApplicationDBHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    //Database name
    public static final String DATABASE_NAME = "JobApplicationDB.db";

    // Defined types for SQL queries
    private static final String TEXT_TYPE = " TEXT";
    private static final String NUMBER_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";

    /**
     * SQL query to create a table based on schema defined in ContactsTableSchema
     */
    private static final String SQL_CREATE_SENDER_CONTACTS =
            "CREATE TABLE " + ContactsTableSchema.ContactEntry.TABLE_NAME + " (" +
                    ContactsTableSchema.ContactEntry.CONTACT_ID + NUMBER_TYPE + " PRIMARY KEY AUTOINCREMENT," +
                    ContactsTableSchema.ContactEntry.FIRST_NAME + TEXT_TYPE + COMMA_SEP +
                    ContactsTableSchema.ContactEntry.LAST_NAME + TEXT_TYPE + COMMA_SEP +
                    ContactsTableSchema.ContactEntry.COMPANY + TEXT_TYPE + COMMA_SEP +
                    ContactsTableSchema.ContactEntry.LOCATION + NUMBER_TYPE + COMMA_SEP +
                    ContactsTableSchema.ContactEntry.EMAIL_ADDRESS + TEXT_TYPE + " )";

    /**
     * SQL query to delete the Contacts table
     */
    private static final String SQL_SENDER_CONTACTS_DELETE =
            "DROP TABLE IF EXISTS " + ContactsTableSchema.ContactEntry.TABLE_NAME;

    /**
     * Constructor method
     * @param context: Application context
     */
    public ApplicationDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * On create method for any table
     * @param db: SQLite database
     */
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_SENDER_CONTACTS);
    }

    /**
     * Helper method used while upgrading database
     *
     * @param db         : SQL database
     * @param oldVersion : older version of database
     * @param newVersion : newer version of database
     */
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_SENDER_CONTACTS_DELETE);
        onCreate(db);
    }


    /**
     * Helper method used while downgrading database
     *
     * @param db         : SQL database
     * @param oldVersion : older version of database
     * @param newVersion : newer version of database
     */
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}

