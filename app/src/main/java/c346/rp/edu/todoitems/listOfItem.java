package c346.rp.edu.todoitems;

import java.util.Calendar;

public class listOfItem {

    private String item;
    private Calendar date;

    public listOfItem(String item, Calendar date) {
        this.item = item;
        this.date = date;
    }

    public String getItem() {
        return item;
    }

    public Calendar getDate() {
        return date;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getDateString(){
        String str = date.get(Calendar.DAY_OF_MONTH) + "/" + date.get(Calendar.MONTH)
                + "/" + date.get(Calendar.YEAR);
        return str;
    }

}
