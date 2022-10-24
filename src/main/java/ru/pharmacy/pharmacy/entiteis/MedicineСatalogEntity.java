package ru.pharmacy.pharmacy.entiteis;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "medicine_сatalog", schema = "public", catalog = "Pharmacy")
public class MedicineСatalogEntity {
    @Basic
    @Column(name = "manufacturer_id", nullable = true)
    private Integer manufacturerId;
    @Basic
    @Column(name = "deleted", nullable = false)
    private boolean deleted;
    @Basic
    @Column(name = "name", nullable = true, length = -1)
    private String name;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "medicine_id", nullable = false)
    private int medicineId;
    @Basic
    @Column(name = "price_id", nullable = false)
    private int priceId;

    public Integer getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Integer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicineСatalogEntity that = (MedicineСatalogEntity) o;
        return deleted == that.deleted && medicineId == that.medicineId && priceId == that.priceId && Objects.equals(manufacturerId, that.manufacturerId) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturerId, deleted, name, medicineId, priceId);
    }
}
