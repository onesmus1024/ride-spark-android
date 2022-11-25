package com.molynew.ridespark;

public class Ride {

    private  String id;
    private  String route;
    private  String destination;
    private  String meetingPoint;
    private String date;
    private String time;
    private String status;
    private String user;
    private String createdAt;
    private String updateAt;


    public Ride(String  id, String route, String destination, String meetingPoint, String date, String time, String status, String user, String createdAt, String updateAt) {
        this.id = id;
        this.route = route;
        this.destination = destination;
        this.meetingPoint = meetingPoint;
        this.date = date;
        this.time = time;
        this.status = status;
        this.user = user;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getMeetingPoint() {
        return meetingPoint;
    }

    public void setMeetingPoint(String meetingPoint) {
        this.meetingPoint = meetingPoint;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }
}
