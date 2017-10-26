package com.arproject.arproject.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "uzer")
public class Uzer {

    private int id;
    private String userName;
    private String userPass;
    private String fullName;
    private String userEmail;
    private List<UzerItem> uzerItems = new ArrayList<>();

/** * * * * * * * *
    GETTERs/SETTERs
 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    @Column(name = "username")
    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    @Column(name = "userpass")
    public String getUserPass() { return userPass; }

    public void setUserPass(String userPass) { this.userPass = userPass; }

    @Column(name = "fullname")
    public String getFullName() { return fullName; }

    public void setFullName(String fullName) { this.fullName = fullName; }

    @Column(name = "useremail")
    public String getUserEmail() { return userEmail; }

    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    @OneToMany(mappedBy = "uzer", fetch = FetchType.LAZY)
    public List<UzerItem> getUzerItems() { return uzerItems; }

    public void setUzerItems(List<UzerItem> uzerItems) { this.uzerItems = uzerItems; }

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
                ", userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                ", fullName='" + fullName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", uzerItems=" + uzerItems +
                '}';
    }
}
