package ru.pharmacy.pharmacy.entiteis;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pharmacy", schema = "public", catalog = "Pharmacy")
public class PharmacyEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = false, length = -1)
    private String name;
    @Basic
    @Column(name = "deleted", nullable = false)
    private boolean deleted;
    @Basic
    @Column(name = "adress", nullable = false, length = -1)
    private String adress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PharmacyEntity that = (PharmacyEntity) o;
        return id == that.id && deleted == that.deleted && Objects.equals(name, that.name) && Objects.equals(adress, that.adress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, deleted, adress);
    }
}
