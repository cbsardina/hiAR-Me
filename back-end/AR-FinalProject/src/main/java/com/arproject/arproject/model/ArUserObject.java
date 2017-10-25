package com.arproject.arproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
@Table(name = "aruserobject")
public class ArUserObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "objectname")
    private String objectName;
    @Column(name = "objectdescription")
    private String objectDescription;
    @Column(name = "filename")
    private String fileName;
    @Column(name = "filepath")
    private String filePath;
    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "aruser_id")
    private ArUser arUser;

  // *** GETTERs/SETTERs ***
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getObjectName() { return objectName; }

    public void setObjectName(String objectName) { this.objectName = objectName; }

    public String getObjectDescription() { return objectDescription; }

    public void setObjectDescription(String objectDescription) { this.objectDescription = objectDescription; }

    public String getFileName() { return fileName; }

    public void setFileName(String fileName) { this.fileName = fileName; }


    public String getFilePath() { return filePath; }

    public void setFilePath(String filePath) { this.filePath = filePath; }

    public ArUser getArUser() { return arUser; }

    public void setArUser(ArUser arUser) { this.arUser = arUser; }

  // *** equals & hashCode ***
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArUserObject arUserObject = (ArUserObject) o;

        return id == arUserObject.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

  // *** toString ***
    @Override
    public String toString() {
        return "ArUserObject{" +
                "id=" + id +
                ", objectName='" + objectName + '\'' +
                ", objectDescription='" + objectDescription + '\'' +
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", arUser=" + (arUser == null ? "": arUser.getId()) +
                '}';
    }
}
