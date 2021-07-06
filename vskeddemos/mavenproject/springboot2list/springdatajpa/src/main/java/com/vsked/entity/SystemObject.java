package com.vsked.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "systemObject")
@Entity
public class SystemObject implements Serializable {

    @Id
    private long id;
    private String name;

    public SystemObject() {
    }

    public SystemObject(long id, String name) {
        this.id = id;
        this.name = name;
    }

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

    @Override
    public String toString() {
        return "SystemObject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
