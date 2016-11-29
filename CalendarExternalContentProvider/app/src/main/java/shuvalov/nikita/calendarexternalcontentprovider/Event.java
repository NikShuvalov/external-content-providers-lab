package shuvalov.nikita.calendarexternalcontentprovider;

/**
 * Created by NikitaShuvalov on 11/29/16.
 */

public class Event {
    String mName, mDate;

    public Event(String name, String date) {
        mName = name;
        mDate = date;
    }

    public String getName() {
        return mName;
    }

    public String getDate() {
        return mDate;
    }
}
