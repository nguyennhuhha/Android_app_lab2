package com.example.applab2.Model;

public class EmployeeParttime extends Employee{
    public double tinhLuong() {
        return 150;
    }
    @Override
    public String toString() {
        return super.toString() +" -->PartTime="+tinhLuong();
    }
}
