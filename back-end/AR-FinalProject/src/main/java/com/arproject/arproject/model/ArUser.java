package com.arproject.arproject.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "aruser")
public class ArUser {

    private int id;
    private String userName;
    private String name;
    private List<ArUserObject> arUserObjects = new ArrayList<>();

  // *** POJO ***
    public ArUser() {}

  // *** GETTERs/SETTERs ***

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    @Column(name = "username")
    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    @Column(name = "name")
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    @OneToMany(mappedBy = "aruser", fetch = FetchType.EAGER)
    public List<ArUserObject> getArUserObjects() {
        return arUserObjects;
    }

  // * * * * * * * * *
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArUser arUser = (ArUser) o;

        return id == arUser.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

  // *** toString ***
    @Override
    public String toString() {
        return "ArUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", arUserObjects=" + arUserObjects +
                '}';
    }
}
