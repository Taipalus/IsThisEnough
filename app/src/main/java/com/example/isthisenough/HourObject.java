package com.example.isthisenough;

public class HourObject {

    private String jobTitle;
    private int oHours;
    private int oMinutes;
    private String jodDescription;
    private String date;

    public HourObject(String jobTitle, int oHours, int oMinutes, String jodDescription, String date) {
        this.jobTitle = jobTitle;
        this.oHours = oHours;
        this.oMinutes = oMinutes;
        this.jodDescription = jodDescription;
        this.date = date;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getoHours() {
        return oHours;
    }

    public void setoHours(int oHours) {
        this.oHours = oHours;
    }

    public int getoMinutes() {
        return oMinutes;
    }

    public void setoMinutes(int oMinutes) {
        this.oMinutes = oMinutes;
    }

    public String getJodDescription() {
        return jodDescription;
    }

    public void setJodDescription(String jodDescription) {
        this.jodDescription = jodDescription;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "HourObject{" +
                "jobTitle='" + jobTitle + '\'' +
                ", oHours=" + oHours +
                ", oMinutes=" + oMinutes +
                ", jodDescription='" + jodDescription + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
