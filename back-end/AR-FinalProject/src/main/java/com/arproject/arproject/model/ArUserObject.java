package com.arproject.arproject.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.FileInputStream;

@Entity
@Table(name = "aruserobject")
public class ArUserObject {

    private int id;
    private String objectName;
    private String objectDescription;
    private String fileName;
    private FileInputStream arUserFile;
    private ArUser arUser;

  // *** POJO ***
    public ArUserObject() {}

  // *** GETTERs/SETTERs ***

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "aruser_id")
    public ArUser getArUser() { return arUser; }

    public void setArUser(ArUser arUser) { this.arUser = arUser; }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    @Column(name = "objectname")
    public String getObjectName() { return objectName; }

    public void setObjectName(String objectName) { this.objectName = objectName; }

    @Column(name = "objectdescription")
    public String getObjectDescription() { return objectDescription; }

    public void setObjectDescription(String objectDescription) { this.objectDescription = objectDescription; }

    @Column(name = "filename")
    public String getFileName() { return fileName; }

    public void setFileName(String fileName) { this.fileName = fileName; }

    @Column(name = "aruserfile")
    public FileInputStream getArUserFile() { return arUserFile; }

    public void setArUserFile(FileInputStream arUserFile) { this.arUserFile = arUserFile; }

    // * * * * * * * * *

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
                ", fileName='" + fileName + '\'' +
                ", objectDescription='" + objectDescription + '\'' +
                ", arUserFile='" + arUserFile + '\'' +
                ", arUser=" + arUser +
                '}';
    }
}
