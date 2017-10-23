package com.arproject.arproject.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "aruserfile")
public class ArUserFile {

    private int id;
    private String fileType;
    private String fileDescription;
    private String arUserFile;
    private ArUser arUser;
    private GenericUser genericUser;

  // *** POJO ***
    public ArUserFile() {}

  // *** GETTERs/SETTERs ***

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "aruser_id")
    public ArUser getArUser() { return arUser; }

    public void setArUser(ArUser arUser) { this.arUser = arUser; }

    //TODO: this needs to be adjusted in DB
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "genericuser_id")
    public GenericUser getGenericUser() { return genericUser; }

    public void setGenericUser(GenericUser genericUser) { this.genericUser = genericUser; }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() { return id; }

    public void setId(int objId) { this.id = id; }

    @Column(name = "filetype")
    public String getFileType() { return fileType; }

    public void setFileType(String fileType) { this.fileType = fileType; }

    @Column(name = "filedescription")
    public String getFileDescription() { return fileDescription; }

    public void setFileDescription(String fileDescription) { this.fileDescription = fileDescription; }

    @Column(name = "aruserfile")
    public String getArUserFile() { return arUserFile; }

    public void setArUserFile(String arUserFile) { this.arUserFile = arUserFile; }

    // * * * * * * * * *

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArUserFile arUserFile = (ArUserFile) o;

        return id == arUserFile.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    // *** toString ***

    @Override
    public String toString() {
        return "ArUserFile{" +
                "id=" + id +
                ", fileType='" + fileType + '\'' +
                ", fileDescription='" + fileDescription + '\'' +
                ", arUserFile='" + arUserFile + '\'' +
                ", arUser=" + arUser +
                ", genericUser=" + genericUser +
                '}';
    }
}
