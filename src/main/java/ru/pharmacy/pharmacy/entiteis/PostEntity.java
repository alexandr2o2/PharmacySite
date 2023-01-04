package ru.pharmacy.pharmacy.entiteis;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "post", schema = "public", catalog = "Pharmacy")
public class PostEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "order_id", nullable = true)
    private Integer orderId;
    @Basic
    @Column(name = "pharmacy_id", nullable = false)
    private int pharmacyId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public int getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(int pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostEntity that = (PostEntity) o;
        return id == that.id && pharmacyId == that.pharmacyId && Objects.equals(orderId, that.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderId, pharmacyId);
    }
}
