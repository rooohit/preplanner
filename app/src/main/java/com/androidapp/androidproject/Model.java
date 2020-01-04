package com.androidapp.androidproject;

public class Model {

    private int id;
    private String name;
    private String destination;
    private String date;
    private byte[] image;



    public Model(int id, String name, String destination, String date, byte[] image) {
        this.id = id;
        this.name = name;
        this.destination = destination;
        this.date = date;
        this.image= image;

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public byte[] getImage(){
        return image;
    }

    public void setImage(byte[] image){
        this.image=image;
    }


}
