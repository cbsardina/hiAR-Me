package com.arproject.arproject.model;

import javax.persistence.*;

@Entity
@Table(name = "visitor")
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "visitorname")
    private String visitorName;
    @Column(name = "visitoremail")
    private String visitorEmail;
    @Column(name = "comments")
    private String comments;

  // *** GETTERs/SETTERs ***
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getVisitorName() { return visitorName; }

    public void setVisitorName(String visitorName) { this.visitorName = visitorName; }

    public String getVisitorEmail() { return visitorEmail; }

    public void setVisitorEmail(String visitorEmail) { this.visitorEmail = visitorEmail; }

    public String getComments() { return comments; }

    public void setComments(String comments) { this.comments = comments; }

  // * * * * * * * * * * * * * * * * * *
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Visitor visitor = (Visitor) o;

        return id == visitor.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

  // *** toString ***

    @Override
    public String toString() {
        return "Visitor{" +
                "id=" + id +
                ", visitorName='" + visitorName + '\'' +
                ", visitorEmail='" + visitorEmail + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
