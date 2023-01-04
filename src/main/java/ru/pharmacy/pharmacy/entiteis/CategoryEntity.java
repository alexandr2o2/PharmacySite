package ru.pharmacy.pharmacy.entiteis;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "category", schema = "public", catalog = "Pharmacy")
public class CategoryEntity {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "name", nullable = false, length = -1)
    private String name;
    @Basic
    @Column(name = "deleted", nullable = false)
    private boolean deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryEntity that = (CategoryEntity) o;
        return getId() == that.getId() && deleted == that.deleted && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), name, deleted);
    }
}
