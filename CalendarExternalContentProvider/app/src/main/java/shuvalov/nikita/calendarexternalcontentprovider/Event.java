package shuvalov.nikita.calendarexternalcontentprovider;

/**
 * Created by NikitaShuvalov on 11/29/16.
 */

public class Event {
    String mName, mDate;
    long mId;

    public Event(String name, String date, long id) {
        mName = name;
        mDate = date;
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public String getDate() {
        return mDate;
    }
    public long getId(){
        return mId;
    }
}
