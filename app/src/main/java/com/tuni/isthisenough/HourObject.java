package com.tuni.isthisenough;

/**
 * @author Tero Taipalus
 * HourObject POJO class. Used to objects.
 */

public class HourObject {

    private String jobTitle;
    private int oHours;
    private int oMinutes;
    private String jodDescription;
    private String oDate;

    /**
     * Constructor of class.
     * @param jobTitle Title of the hours given.
     * @param oHours hours for this job.
     * @param oMinutes minutes for this job.
     * @param jodDescription description for the job.
     * @param date jobs date.
     */

    public HourObject(String jobTitle, int oHours, int oMinutes, String jodDescription, String date) {
        this.jobTitle = jobTitle;
        this.oHours = oHours;
        this.oMinutes = oMinutes;
        this.jodDescription = jodDescription;
        this.oDate = date;
    }

    /**
     * Get method for job title.
     * @return returns the value of job title.
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * Set method for job title.
     * @param jobTitle input value to be set.
     */

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    /**
     * Get method for job hours.
     * @return returns the value of hours.
     */

    public int getoHours() {
        return oHours;
    }

    /**
     * Set method for job hours.
     * @param oHours input value to be set.
     */

    public void setoHours(int oHours) {
        this.oHours = oHours;
    }

    /**
     * Get method for job minutes.
     * @return returns the value of minutes.
     */

    public int getoMinutes() {
        return oMinutes;
    }

    /**
     * Set method for job hours.
     * @param oMinutes input value to be set.
     */

    public void setoMinutes(int oMinutes) {
        this.oMinutes = oMinutes;
    }

    /**
     * Get method for job description.
     * @return returns job description.
     */

    public String getJodDescription() {
        return jodDescription;
    }

    /**
     * Set method for job description.
     * @param jodDescription input value to be set.
     */

    public void setJodDescription(String jodDescription) {
        this.jodDescription = jodDescription;
    }

    /**
     * Get method for date.
     * @return the date
     */

    public String getDate() {
        return oDate;
    }

    /**
     * Set method for date
     * @param date input value to be set.
     */

    public void setDate(String date) {
        this.oDate = oDate;
    }

    /**
     *  POJO classes toString method
     * @return returns all the data in the object in string.
     */

    @Override
    public String toString() {
        return "HourObject{" +
                "jobTitle='" + jobTitle + '\'' +
                ", oHours=" + oHours +
                ", oMinutes=" + oMinutes +
                ", jodDescription='" + jodDescription + '\'' +
                ", date='" + oDate + '\'' +
                '}';
    }
}
