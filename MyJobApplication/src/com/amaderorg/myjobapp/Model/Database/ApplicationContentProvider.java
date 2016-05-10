package com.amaderorg.myjobapp.Model.Database;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

import com.amaderorg.myjobapp.Model.Database.Tables.ContactsTableSchema;

/**
 * This class provides database manipulation functions
 */
public class ApplicationContentProvider extends ContentProvider {
    /**
     * Database common constants
     */
    private static final String PROVIDER_NAME = "com.amaderorg.myjobapp";
    private static final String PROVIDER_DIR_PATH = "vnd.android.cursor.dir/";
    private static final String CONTACTS_TABLE_URL = "content://" + PROVIDER_NAME + "/" +
            ContactsTableSchema.ContactEntry.TABLE_NAME;
    public static final Uri CONTACTS_TABLE_URI = Uri.parse(CONTACTS_TABLE_URL);

    /**
     * SQLite Database
     */
    private static SQLiteDatabase mSQLiteDatabase;

    /**
     * Holds Uri code
     */
    private static final int CONTACTS_URI_CODE = 1;
    private static final UriMatcher URI_MATCHER;

    static {
        URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
        URI_MATCHER.addURI(PROVIDER_NAME, ContactsTableSchema.ContactEntry.TABLE_NAME, CONTACTS_URI_CODE);
    }

    @Override
    public boolean onCreate() {
        ApplicationDBHelper dbHelper = new ApplicationDBHelper(getContext());
        mSQLiteDatabase = dbHelper.getWritableDatabase();
        return mSQLiteDatabase != null;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        switch (URI_MATCHER.match(uri)) {
            case CONTACTS_URI_CODE:
                qb.setTables(ContactsTableSchema.ContactEntry.TABLE_NAME);
                break;
            default:
                throw new IllegalArgumentException("Unknown Uri "+ uri);
        }
        try {
            Cursor cursor = qb.query(mSQLiteDatabase, projection, selection, selectionArgs, null, null, sortOrder);
            cursor.setNotificationUri(getContext().getContentResolver(), uri);
            return cursor;
        } catch (Exception exception) {
            return null;
        }
    }

    @Override
    public String getType(Uri uri) {
        switch (URI_MATCHER.match(uri)) {
            case CONTACTS_URI_CODE:
                return PROVIDER_DIR_PATH + ContactsTableSchema.ContactEntry.TABLE_NAME;
            default:
                throw new IllegalArgumentException("Unknown Uri "+ uri);
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long rowID = 0;
        switch (URI_MATCHER.match(uri)) {
            case CONTACTS_URI_CODE:
                rowID = mSQLiteDatabase.insertWithOnConflict(
                        ContactsTableSchema.ContactEntry.TABLE_NAME, null, values,
                        SQLiteDatabase.CONFLICT_IGNORE);
                break;
            default:
                break;
        }
        if (rowID > 0) {
            Uri uri1 = ContentUris.withAppendedId(uri, rowID);
            getContext().getContentResolver().notifyChange(uri1, null);
            return uri1;
        } else {
            return null;
        }
    }

    //TODO - needs to be added when required
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

    /**
     * Getter method for the satabase
     *
     * @return SQLite database
     */
    public SQLiteDatabase getDatabase () {
        return mSQLiteDatabase;
    }
}
