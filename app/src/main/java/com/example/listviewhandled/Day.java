package com.example.listviewhandled;

public class Day {
    String dayName;
    String dayDescription;
    int imageResourceID;

    public Day(String dayName, String dayDescription, int imageResourceID) {
        this.dayName = dayName;
        this.dayDescription = dayDescription;
        this.imageResourceID = imageResourceID;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public String getDayDescription() {
        return dayDescription;
    }

    public void setDayDescription(String dayDescription) {
        this.dayDescription = dayDescription;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }

    public void setImageResourceID(int imageResourceID) {
        this.imageResourceID = imageResourceID;
    }

    @Override
    public String toString() {
        return "Day{" +
                "dayName='" + dayName + '\'' +
                '}';
    }
}
