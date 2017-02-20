package uk.ac.tees.q5095703.memoapp;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Invate on 18/02/2017.
 */

public class DateBaseHandler  extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "JornalEntry.db";
    // Contacts table name
    private static final String TABLE_NAME = "JournalEntry";
    // Contacts Table Columns names
    private static final String COL_ID = "_id"; // Primary key column must be _id
    private static final String COL_NOTETEXT = "notetext";
    private static final String COL_CATEGORY = "category";
    private static final String COL_TIME = "datetime";
    private static final String COL_LONG = "long";
    private static final String COL_LAT = "lat";

    public DateBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
// Generate Create SQL Statement
        String CREATE_CONTACTS_TABLE = "CREATE TABLE "
                + TABLE_NAME
                + "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COL_NOTETEXT + " TEXT,"
                + COL_CATEGORY + " TEXT,"
                + COL_TIME + " TEXT,"
                + COL_LONG + " TEXT," + COL_LAT + " TEXT" + ")";
        // Execute/run create SQL statement
        db.execSQL(CREATE_CONTACTS_TABLE);
        Log.d("Database", "Database Created.");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public long addLecturer(JournalEntry entry) {
        // Open database connection (for write)
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NOTETEXT, entry.getNote_text());
        values.put(COL_CATEGORY, entry.getCategory());
        values.put(COL_TIME, entry.getDatetime());
        values.put(COL_LONG, entry.getLoc_long());
        values.put(COL_LAT, entry.getLoc_lat());

        // Id column not required (AutoIncrement)

        // Add record to database and get id of new record (must long integer).
        long id = db.insert(TABLE_NAME, null, values);
        db.close(); // Closing database connection
        return id; // R
    }

    public List<String> getAllCat() {
        List<String> labels = new ArrayList<String>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                labels.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        db.close();

        // returning lables
        return labels;
    }


    public List<JournalEntry> getAll() {
        // Create empty list (in memory)
        List<JournalEntry> list = new ArrayList<JournalEntry>();
        // Connect to the database to read data
        SQLiteDatabase db = this.getReadableDatabase();
        // Generate SQL SELECT statement
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        // Execute select statement
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) { // If data (records) available
            // Get position (index) of each of the column names.
            int idIdx = cursor.getColumnIndex(COL_ID);
            int noteIdx = cursor.getColumnIndex(COL_NOTETEXT);
            int catIdx = cursor.getColumnIndex(COL_CATEGORY);
            int timeIdx = cursor.getColumnIndex(COL_TIME);
            int longIdx = cursor.getColumnIndex(COL_LONG);
            int latIdx = cursor.getColumnIndex(COL_LAT);
            do {
                // Create lecturer object for current database record
                JournalEntry entrie = new JournalEntry(
                        cursor.getInt(idIdx),
                        cursor.getString(noteIdx),
                        cursor.getString(catIdx),
                        cursor.getString(timeIdx),
                        cursor.getString(longIdx),
                        cursor.getString(latIdx)
                );
                // Add lecturer objext to list
                list.add(entrie);
            } while (cursor.moveToNext()); // repeat until there are no more records
        }
        return list;
    }

    public void removeAll() {

        // Connect to the tables
        SQLiteDatabase db = this.getWritableDatabase();

        // Execute delete (drop) table SQL command
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // call create method to re-generate the table
        onCreate(db);
    }

    public void findEntry(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
    }


    public void deleteEntry(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(
                TABLE_NAME, // Param 1: Table name
                COL_ID + " = ?", // Param 2: where/filter clause
                new String[] { String.valueOf(id) } // Param 3: Arguments (string) array
        );
        db.close();
    }

}
