package com.arproject.arproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
@Table(name = "uzeritem")
public class UzerItem {

    private int id;
    private String itemName;
    private String itemDescription;
    private String fileName;
    private String filePath;
    private Uzer uzer;

/** * * * * * * * *
     GETTERs/SETTERs
 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    @Column(name = "itemname")
    public String getItemName() { return itemName; }

    public void setItemName(String itemName) { this.itemName = itemName; }

    @Column(name = "itemdescription")
    public String getItemDescription() { return itemDescription; }

    public void setItemDescription(String itemDescription) { this.itemDescription = itemDescription; }

    @Column(name = "filename")
    public String getFileName() { return fileName; }

    public void setFileName(String fileName) { this.fileName = fileName; }

    @Column(name = "filepath")
    public String getFilePath() { return filePath; }

    public void setFilePath(String filePath) { this.filePath = filePath; }

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "uzer_id")
    public Uzer getUzer() { return uzer; }

    public void setUzer(Uzer uzer) { this.uzer = uzer; }

/** * * * * * * * *
     Equals & hashCode
 */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UzerItem uzerItem = (UzerItem) o;

        return id == uzerItem.id;
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
        return "UzerItem{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", uzer=" + (uzer == null ? "": uzer.getId()) +
                '}';
    }
}
