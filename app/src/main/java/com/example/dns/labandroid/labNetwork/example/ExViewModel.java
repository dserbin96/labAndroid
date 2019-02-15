package com.example.dns.labandroid.labNetwork.example;
//модель содержащая инфорацию о модели
public class ExViewModel {
    private int id;
    private String cabinet;
    private String teacher;
    private String time;

    public ExViewModel(int id, String cabinet, String teacher, String time) {
        this.id = id;
        this.cabinet = cabinet;
        this.teacher = teacher;
        this.time = time;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getCabinet() {
        return cabinet;
    }

    public void setCabinet(String cabinet) {
        this.cabinet = cabinet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
