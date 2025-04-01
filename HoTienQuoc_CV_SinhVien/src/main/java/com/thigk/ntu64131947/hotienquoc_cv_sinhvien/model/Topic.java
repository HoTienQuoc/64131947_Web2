package com.thigk.ntu64131947.hotienquoc_cv_sinhvien.model;

public class Topic {
    private String id;                 // Changed to private
    private String topicName;          // Changed to private
    private String topicDescription;   // Changed to private
    private String supervisorId;       // Changed to private
    private String topicType;          // Changed to private

    // Default (no-argument) constructor - REQUIRED for Spring MVC form binding
    public Topic() {
    }

    // Constructor with arguments (optional, but good to have)
    public Topic(String id, String topicName, String topicDescription, String supervisorId, String topicType) {
        this.id = id;
        this.topicName = topicName;
        this.topicDescription = topicDescription;
        this.supervisorId = supervisorId;
        this.topicType = topicType;
    }

    // Standard Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicDescription() {
        return topicDescription;
    }

    public void setTopicDescription(String topicDescription) {
        this.topicDescription = topicDescription;
    }

    public String getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(String supervisorId) {
        this.supervisorId = supervisorId;
    }

    public String getTopicType() {
        return topicType;
    }

    public void setTopicType(String topicType) {
        this.topicType = topicType;
    }

    // Optional: toString() for debugging
    @Override
    public String toString() {
        return "Topic{" +
                "id='" + id + '\'' +
                ", topicName='" + topicName + '\'' +
                ", topicDescription='" + topicDescription + '\'' +
                ", supervisorId='" + supervisorId + '\'' +
                ", topicType='" + topicType + '\'' +
                '}';
    }
}