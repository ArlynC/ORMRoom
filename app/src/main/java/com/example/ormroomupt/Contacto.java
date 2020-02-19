package com.example.ormroomupt;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;
@Entity(tableName = "contact")
public class Contacto {
    private String firstName;
    private String lastName;
    @PrimaryKey
    @NonNull
    private String phoneNumber;
    private Date createdDate;
 /*   public Contacto(String firstName, String lastName, @NonNull String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }*/
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @NonNull
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(@NonNull String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
