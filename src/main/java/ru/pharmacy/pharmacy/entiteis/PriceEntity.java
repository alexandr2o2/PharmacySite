package ru.pharmacy.pharmacy.entiteis;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "price", schema = "public", catalog = "Pharmacy")
public class PriceEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "time", nullable = false)
    private Time time;
    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    private float price;
    @Basic
    @Column(name = "medicine_id", nullable = false)
    private int medicineId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceEntity that = (PriceEntity) o;
        return id == that.id && Float.compare(that.price, price) == 0 && medicineId == that.medicineId && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time, price, medicineId);
    }
}
