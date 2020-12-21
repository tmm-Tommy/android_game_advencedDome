package com.example.advanceddome.entity;

public class WorkTableEntity {
    private String name;
    private Class<?> toActivity;

    @Override
    public String toString() {
        return "WorkTableEntity{" +
                "name='" + name + '\'' +
                ", toActivity=" + toActivity +
                '}';
    }

    public WorkTableEntity(String name, Class<?> toActivity) {
        this.name = name;
        this.toActivity = toActivity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class<?> getToActivity() {
        return toActivity;
    }

    public void setToActivity(Class<?> toActivity) {
        this.toActivity = toActivity;
    }
}
