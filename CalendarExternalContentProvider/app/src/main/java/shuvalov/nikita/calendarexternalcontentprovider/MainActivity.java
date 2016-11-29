package shuvalov.nikita.calendarexternalcontentprovider;

import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    CalendarRecyclerAdapter mAdapter;
    ArrayList<Event> mEvents;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEvents = new ArrayList<>();

        setupRecyclerView();

//        CalendarContract
    }

    public void setupRecyclerView(){
        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,true);
        mAdapter = new CalendarRecyclerAdapter(mEvents);
    }
}
