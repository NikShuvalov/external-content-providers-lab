package shuvalov.nikita.calendarexternalcontentprovider;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.CalendarContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    CalendarRecyclerAdapter mAdapter;
    ArrayList<Event> mEvents;
    Cursor mCursor;
    public static final int MY_PERMISSION_REQUEST = 404;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEvents = new ArrayList<>();

        setupRecyclerView();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CALENDAR) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_CALENDAR}, MY_PERMISSION_REQUEST);
        }else if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CALENDAR) == PackageManager.PERMISSION_GRANTED){
            mCursor = getContentResolver().query(CalendarContract.Events.CONTENT_URI, null, null, null, null, null);
        }

        if (mCursor!=null){
            getCalendarContent();
        }

    }

    public void setupRecyclerView(){
        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,true);
        mAdapter = new CalendarRecyclerAdapter(mEvents);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void getCalendarContent(){
        if(mCursor.moveToFirst()){
            while(!mCursor.isAfterLast()){
                //ToDo:Get the relevant information from the Calendar.
                mEvents.add(new Event(mCursor.getString(mCursor.getColumnIndex(CalendarContract.Events.DESCRIPTION)),
                        mCursor.getString(mCursor.getColumnIndex(CalendarContract.Events.DTSTART))));
                mCursor.moveToNext();
            }
        }
        mCursor.close();
        mAdapter.updateList(mEvents);
    }
}
