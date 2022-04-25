
package com.ipl.aula7_acessoapi_retrofitconfiguracao.model;

import com.google.gson.annotations.SerializedName;

public class Allocation {

    @SerializedName("course")
    private Course mCourse;
    @SerializedName("dayOfWeek")
    private String mDayOfWeek;
    @SerializedName("endHour")
    private String mEndHour;
    @SerializedName("id")
    private Long mId;
    @SerializedName("startHour")
    private String mStartHour;

    public Course getCourse() {
        return mCourse;
    }

    public void setCourse(Course course) {
        mCourse = course;
    }

    public String getDayOfWeek() {
        return mDayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        mDayOfWeek = dayOfWeek;
    }

    public String getEndHour() {
        return mEndHour;
    }

    public void setEndHour(String endHour) {
        mEndHour = endHour;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getStartHour() {
        return mStartHour;
    }

    public void setStartHour(String startHour) {
        mStartHour = startHour;
    }

    @Override
    public String toString() {
        return "Allocation{" +
                "mCourse=" + mCourse +
                ", mDayOfWeek='" + mDayOfWeek + '\'' +
                ", mEndHour='" + mEndHour + '\'' +
                ", mId=" + mId +
                ", mStartHour='" + mStartHour + '\'' +
                '}';
    }
}
