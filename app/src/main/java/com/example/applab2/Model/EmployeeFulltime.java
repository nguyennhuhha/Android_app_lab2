package com.example.applab2.Model;

public class EmployeeFulltime extends Employee{
    public double tinhLuong() {
        return 500;
    }
    @Override
    public String toString() {
        return super.toString() +" -->FullTime="+tinhLuong();
    }
}
