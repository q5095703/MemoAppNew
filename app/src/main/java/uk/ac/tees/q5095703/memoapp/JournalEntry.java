package uk.ac.tees.q5095703.memoapp;

/**
 * Created by Invate on 18/02/2017.
 */

public class JournalEntry {
    private int ID;
    private String note_text;
    private String category;
    private String datetime;
    private String loc_long;
    private String loc_lat;

    public JournalEntry(int ID,String note, String cat,String date,String longe, String lat){
        this.ID = ID;
        this.note_text = note;
        this.category = cat;
        this.datetime = date;
        this.loc_long =longe;
        this.loc_lat = lat;
    }
    public JournalEntry(String note, String cat,String date,String longe, String lat){
        this.note_text = note;
        this.category = cat;
        this.datetime = date;
        this.loc_long =longe;
        this.loc_lat = lat;
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNote_text() {
        return note_text;
    }

    public void setNote_text(String note_text) {
        this.note_text = note_text;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getLoc_long() {
        return loc_long;
    }

    public void setLoc_long(String loc_long) {
        this.loc_long = loc_long;
    }

    public String getLoc_lat() {
        return loc_lat;
    }

    public void setLoc_lat(String loc_lat) {
        this.loc_lat = loc_lat;
    }
}
