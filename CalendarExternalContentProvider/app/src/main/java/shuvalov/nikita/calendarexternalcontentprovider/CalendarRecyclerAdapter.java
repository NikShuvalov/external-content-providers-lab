package shuvalov.nikita.calendarexternalcontentprovider;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.CalendarContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by NikitaShuvalov on 11/29/16.
 */

public class CalendarRecyclerAdapter extends RecyclerView.Adapter<CalendarItemHolder> {
    ArrayList<Event> mEvents;


    public CalendarRecyclerAdapter(ArrayList<Event> events) {
        mEvents = events;
    }

    @Override
    public CalendarItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_form, null);
        return new CalendarItemHolder(view);
    }

    @Override
    public void onBindViewHolder(final CalendarItemHolder holder, int position) {
        holder.bindData(mEvents.get(position));
        holder.mContainer.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                ContentResolver contentResolver = view.getContext().getContentResolver();
                Toast.makeText(view.getContext(), "Removed event id: " + mEvents.get(holder.getAdapterPosition()).getId(), Toast.LENGTH_SHORT).show();
                Long id = mEvents.get(holder.getAdapterPosition()).getId();

                if (ActivityCompat.checkSelfPermission(view.getContext(), Manifest.permission.WRITE_CALENDAR) == PackageManager.PERMISSION_GRANTED) {
                    Uri deleteUri = ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI,id);
                    contentResolver.delete(deleteUri, null, null);
                    contentResolver.notifyChange(CalendarContract.Events.CONTENT_URI,null);
                    mEvents.remove(holder.getAdapterPosition());
                    notifyItemRemoved(holder.getAdapterPosition());
                }
                return false;
            }
        });

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
    RelativeLayout mContainer;

    public CalendarItemHolder(View itemView) {
        super(itemView);
        mDate = (TextView)itemView.findViewById(R.id.date);
        mDay = (TextView)itemView.findViewById(R.id.day_name);
        mContainer = (RelativeLayout)itemView.findViewById(R.id.holder_container);
    }
    public void bindData(Event event){
        mDate.setText(event.getDate());
        mDay.setText(event.getName());
    }
}
