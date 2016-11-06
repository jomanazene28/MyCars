package com.zene.jomana.mycars.data;

/**
 * Created by user on 10/27/2016.
 */
public class MyCar {
    private String type;
    private int year;
    private String details;
    private int price;
    private String image;


    public MyCar(String type,int year,String details,int price,String image)
    {
        this.type=type;
        this.year=year;
        this.details=details;
        this.price=price;
        this.image=image;
    }
    public MyCar(){

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "MyCar{" +
                "type='" + type + '\'' +
                ", year=" + year +
                ", details='" + details + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';
    }
}
