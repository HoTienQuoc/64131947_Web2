package com.thigk.ntu64131947.hotienquoc_cv_sinhvien.model;

public class Student {
    private String id;      // Changed to private
    private String name;    // Changed to private
    private String groupId; // Changed to private

    // Default (no-argument) constructor - REQUIRED for Spring MVC form binding
    public Student() {
    }

    // Constructor with arguments (optional, but good to have)
    public Student(String id, String name, String groupId) {
        this.id = id;
        this.name = name;
        this.groupId = groupId;
    }

    // Standard Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    // Optional: toString() for debugging
    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", groupId='" + groupId + '\'' +
                '}';
    }
}