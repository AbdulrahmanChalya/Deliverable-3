/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.midtermclone;

/**
 *
 * @author orlan
 */
public class BuildingPermit {
    private enum permits = {"BP2023-001", "BP2023-002", "BP2023-003", "BP2023-004"};
    private enum categories = { "Abdulrahman-CATAGORY",Residential", "Commercial", "Industrial", "Agricultural" };
    
    private String Permit;
    private String Category;

    public BuildingPermit(String Permit, String Category) {
        this.Permit = Permit;
        this.Category = Category;
    }
    
    public String[] getPermits() {
        return permits;
    }
    
    
    public String[] getCategories() {
        return categories;
    }

    public void setPermit(String Permit) {
        this.Permit = Permit;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getPermit() {
        return Permit;
    }

    public String getCategory() {
        return Category;
    }
    
}
