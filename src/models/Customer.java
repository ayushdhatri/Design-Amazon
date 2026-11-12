package models;

import util.UniqueIdGenerator;

import java.util.UUID;

public class Customer {
    private final String id;

    private final String name;

    private Address shippingAddress;

    private final Account account;

    public Customer(String name, Address shippingAddress, Account account){
        this.id = UniqueIdGenerator.getUniqueId();
        this.name = name;
        this.shippingAddress = shippingAddress;
        this.account = account;
    }

    public String getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public Address getShippingAddress(){
        return this.shippingAddress;
    }

    public Account getAccount(){
        return this.account;
    }

    public void updateShippingAddress(Address newAddress){
        this.shippingAddress = newAddress;
    }





}
