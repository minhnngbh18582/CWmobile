package com.example.cwmobile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int version = 1;
    public  static String dbName="Trip.db";
    public static final String TABLE_TRIP ="Tripdata";
    public static final String TRIP_ID = "id";
    public static final String TRIP_NAME = "name";
    public static final String TRIP_DESTINATION = "destination";
    public static final String TRIP_DATE = "date";
    public static final String TRIP_RISK = "risk";
    public static final String TRIP_DESCRIPTION = "description";
    public static final String TRIP_PARTICIPANTS = "participants";
    public static final String TRIP_TOTAL = "total";
    private static final String CREATE_TABLE="create table if not exists "+ TABLE_TRIP + "(" + TRIP_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+TRIP_NAME+" TEXT NOT NULL,"
            + TRIP_DESTINATION + " TEXT, " + TRIP_DATE + " TEXT, " + TRIP_RISK + " TEXT, " + TRIP_DESCRIPTION + " TEXT, " + TRIP_PARTICIPANTS + " INTEGER, " + TRIP_TOTAL + " INTEGER);";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+ TABLE_TRIP;

    private Context context;
    private SQLiteDatabase database;

    public DatabaseHelper(Context context) {
        super(context,dbName,null,version );
        context=this.context;
        database = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            db.execSQL(CREATE_TABLE);
        } catch (Exception e) {

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public boolean InsertTrip(Trip objEmp)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TRIP_NAME,objEmp.getTripName());
        cv.put(TRIP_DESTINATION,objEmp.getTripDestination());
        cv.put(TRIP_DATE,objEmp.getTripDate());
        cv.put(TRIP_RISK,objEmp.getTripRisk());
        cv.put(TRIP_DESCRIPTION,objEmp.getTripDescription());
        cv.put(TRIP_PARTICIPANTS,objEmp.getTripParticipants());

        long result = db.insert(TABLE_TRIP,null,cv);
        if(result == -1)
            return false;
        else
            return true;
    }

    public List<Trip> getExams() {
        Cursor cursor = database.query(TABLE_TRIP, new String[] {TRIP_NAME, TRIP_DESTINATION, TRIP_DATE, TRIP_RISK, TRIP_DESCRIPTION, TRIP_PARTICIPANTS},
                null, null, null, null, TRIP_NAME);

        List<Trip> results = new ArrayList<Trip>();

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {            
            String name = cursor.getString(1);
            String destination = cursor.getString(2);
            String date = cursor.getString(3);
            String risk = cursor.getString(4);
            String description = cursor.getString(5);
            int participants = cursor.getInt(6);

            Trip trip = new Trip(name,destination,date,risk,description,participants);
            results.add(trip);

            cursor.moveToNext();
        }

        return results;

    }

}
