package com.arproject.arproject.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "uzer")
public class Uzer {

    private int id;
    private String userEmail;
    private String userPass;
    private Boolean userEnabled;
    private UzerAuth userAuth;
    private String firstLastName;
    private List<UzerItem> userItems = new ArrayList<>();

/** * * * * * * * *
    GETTERs/SETTERs
 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    @Column(name = "useremail")
    public String getUserEmail() { return userEmail; }

    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    @Column(name = "userpass")
    public String getUserPass() { return userPass; }

    public void setUserPass(String userPass) { this.userPass = userPass; }

    @Column(name = "userenabled")
    public Boolean getUserEnabled() { return userEnabled; }

    public void setUserEnabled(Boolean userEnabled) { this.userEnabled = userEnabled; }

    @Column(name = "userauth")
    public UzerAuth getUserAuth() { return userAuth; }

    public void setUserAuth(UzerAuth userAuth) { this.userAuth = userAuth; }

    @Column(name = "firstlastname")
    public String getFirstLastName() { return firstLastName; }

    public void setFirstLastName(String firstLastName) { this.firstLastName = firstLastName; }

    @OneToMany(mappedBy = "uzer", fetch = FetchType.LAZY)
    public List<UzerItem> getUserItems() { return userItems; }

    public void setUserItems(List<UzerItem> userItems) { this.userItems = userItems; }

    /** * * * * * * * *
    Equals & hashCode
 */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Uzer uzer = (Uzer) o;

        return id == uzer.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

/** * * * * * * * *
    toString
 */
    @Override
    public String toString() {
        return "Uzer{" +
                "id=" + id +
                ", userEmail='" + userEmail + '\'' +
                ", userPass='" + userPass + '\'' +
                ", userEnabled=" + userEnabled +
                ", userAuth=" + userAuth +
                ", firstLastName='" + firstLastName + '\'' +
                ", userItems=" + userItems +
                '}';
    }
}
