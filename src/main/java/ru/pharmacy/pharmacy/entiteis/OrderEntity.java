package ru.pharmacy.pharmacy.entiteis;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "order", schema = "public", catalog = "Pharmacy")
public class OrderEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "time", nullable = false)
    private Time time;
    @Basic
    @Column(name = "status_id", nullable = false)
    private int statusId;
    @Basic
    @Column(name = "deleted", nullable = false)
    private boolean deleted;
    @Basic
    @Column(name = "address", nullable = true, length = -1)
    private String address;
    @Basic
    @Column(name = "user_id", nullable = true)
    private Integer userId;

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

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return id == that.id && statusId == that.statusId && deleted == that.deleted && Objects.equals(time, that.time) && Objects.equals(address, that.address) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time, statusId, deleted, address, userId);
    }
}
