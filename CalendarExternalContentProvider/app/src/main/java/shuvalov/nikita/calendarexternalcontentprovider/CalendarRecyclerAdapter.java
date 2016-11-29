package shuvalov.nikita.calendarexternalcontentprovider;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_form,null);
        return new CalendarItemHolder(view);
    }

    @Override
    public void onBindViewHolder(CalendarItemHolder holder, int position) {
        holder.bindData(mEvents.get(position));

    }

    @Override
    public int getItemCount() {
        return mEvents.size();
    }

    public void updateList(ArrayList<Event> events){
        mEvents = events;
        notifyDataSetChanged();
    }
}
class CalendarItemHolder extends RecyclerView.ViewHolder{
    TextView mDate, mDay;

    public CalendarItemHolder(View itemView) {
        super(itemView);
        mDate = (TextView)itemView.findViewById(R.id.date);
        mDay = (TextView)itemView.findViewById(R.id.day_name);
    }
    public void bindData(Event event){
        mDate.setText(event.getDate());
        mDay.setText(event.getName());
    }
}
