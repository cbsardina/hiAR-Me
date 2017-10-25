package com.arproject.arproject.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "aruser")
public class ArUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "username")
    private String userName;
    @Column(name = "name")
    private String name;
    @Column(name = "useremail")
    private String userEmail;
    @OneToMany(mappedBy = "aruser", fetch = FetchType.LAZY)
    private List<ArUserObject> arUserObjects = new ArrayList<>();

  // *** GETTERs/SETTERs ***
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getUserEmail() { return userEmail; }

    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public List<ArUserObject> getArUserObjects() { return arUserObjects; }

    // *** Equals & HashCode ***
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
                ", userEmail=" + userEmail +
                ", arUserObjects=" + arUserObjects +
                '}';
    }
}
