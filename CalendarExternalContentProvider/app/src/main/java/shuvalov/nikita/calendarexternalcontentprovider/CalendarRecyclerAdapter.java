package shuvalov.nikita.calendarexternalcontentprovider;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by NikitaShuvalov on 11/29/16.
 */

public class CalendarRecyclerAdapter extends RecyclerView.Adapter<CalendarItemHolder> {
    ArrayList<Event> mEvents;

    public CalendarRecyclerAdapter(ArrayList<Event> events) {mEvents = events;}

    @Override
    public CalendarItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(CalendarItemHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
class CalendarItemHolder extends RecyclerView.ViewHolder{
    TextView mDate, mDay;

    public CalendarItemHolder(View itemView) {
        super(itemView);
        mDate = (TextView)itemView.findViewById(R.id.date);
        mDay = (TextView)itemView.findViewById(R.id.day_name);
    }
}
