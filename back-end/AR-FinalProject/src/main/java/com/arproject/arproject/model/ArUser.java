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
    private String resume;
    private String github;
    private String portfolio;
    private String image;
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

    @Column(name = "resume")
    public String getResume() { return resume; }

    public void setResume(String resume) { this.resume = resume; }

    @Column(name = "github")
    public String getGithub() { return github; }

    public void setGithub(String github) { this.github = github; }

    @Column(name = "portfolio")
    public String getPortfolio() { return portfolio; }

    public void setPortfolio(String portfolio) { this.portfolio = portfolio; }

    @Column(name = "image")
    public String getImage() { return image; }

    public void setImage(String image) { this.image = image; }

    @OneToMany(mappedBy = "aruser", fetch = FetchType.EAGER)
    public List<ArUserObject> getArUserObjects() {
        return arUserObjects;
    }

    public void setArUserObjects(List<ArUserObject> arUserObjects) {
        this.arUserObjects = arUserObjects;
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
                ", resume='" + resume + '\'' +
                ", github='" + github + '\'' +
                ", portfolio='" + portfolio + '\'' +
                ", image='" + image + '\'' +
                ", arUserObjects=" + arUserObjects +
                '}';
    }
}
