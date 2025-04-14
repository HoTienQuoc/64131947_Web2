package com.hotienquoc.cv.sinhvien.hotienquoc_cv_sinhvien.models;

public class Student {
    private Long id;
    private String name;
    private String groupId;

    // Constructor
    public Student(long id, String name, String groupId) {
        this.id = id;
        this.name = name;
        this.groupId = groupId;
    }

    public Student() {} // nhớ có constructor rỗng

    // Getter và Setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}
