package com.arproject.arproject.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "genericuser")
public class GenericUser {

    private int id;
    private String userName;
    private String name;
    private List<ArUserFile> genericUserFiles = new ArrayList<>();

  // *** POJO ***
    public GenericUser() {}

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

    @OneToMany(mappedBy = "genericuser", fetch = FetchType.EAGER)
    public List<ArUserFile> getGenericUserFiles() { return genericUserFiles; }

    public void setGenericUserFiles(List<ArUserFile> genericUserFiles) { this.genericUserFiles = genericUserFiles; }

  // * * * * * * * * * * * * * * * * * * * * *

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GenericUser that = (GenericUser) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

  // *** toString ***

    @Override
    public String toString() {
        return "GenericUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", genericUserFiles=" + genericUserFiles +
                '}';
    }
}
