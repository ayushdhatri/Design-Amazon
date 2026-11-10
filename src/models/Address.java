package models;

public class Address {
    private String city;

    private String state;

    Address(String city, String state){
        this.state = state;
        this.city = city;
    }

    public String getCity(){
        return this.city;
    }

    public String getState(){
        return this.state;
    }

    public void setState(String updateState){
        this.state = updateState;
    }

    public void setCity(String updateCity){
        this.city = updateCity;
    }

}
