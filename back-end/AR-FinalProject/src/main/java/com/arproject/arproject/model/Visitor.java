package com.arproject.arproject.model;

import javax.persistence.*;

@Entity
@Table(name = "visitor")
public class Visitor {

    private int id;
    private String visitorName;
    private String visitorEmail;
    private String visitorComments;

/** * * * * * * * *
     GETTERs/SETTERs
 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    @Column(name = "visitorname")
    public String getVisitorName() { return visitorName; }

    public void setVisitorName(String visitorName) { this.visitorName = visitorName; }

    @Column(name = "visitoremail")
    public String getVisitorEmail() { return visitorEmail; }

    public void setVisitorEmail(String visitorEmail) { this.visitorEmail = visitorEmail; }

    @Column(name = "visitorcomments")
    public String getVisitorComments() { return visitorComments; }

    public void setVisitorComments(String visitorComments) { this.visitorComments = visitorComments; }

/** * * * * * * * *
     Equals & hashCode
 */
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

/** * * * * * * * *
     toString
 */
    @Override
    public String toString() {
        return "Visitor{" +
                "id=" + id +
                ", visitorName='" + visitorName + '\'' +
                ", visitorEmail='" + visitorEmail + '\'' +
                ", visitorComments='" + visitorComments + '\'' +
                '}';
    }
}
