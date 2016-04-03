package com.amaderorg.myjobapp.Model.Database.Tables;

import android.provider.BaseColumns;

/**
 * Schema of the Senders Contact  table
 */
public final class ContactsTableSchema {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public ContactsTableSchema() {}

    /* Inner class that defines the table contents */
    public static abstract class ContactEntry implements BaseColumns {
        public static final String TABLE_NAME = "ContactTable";
        public static final String CONTACT_ID = "ContactId";
        public static final String FIRST_NAME = "ContactFirstName";
        public static final String LAST_NAME = "ContactLastName";
        public static final String COMPANY = "CompanyName";
        public static final String LOCATION = "ContactLocation";
        public static final String EMAIL_ADDRESS = "EmailAddress";
    }
}
