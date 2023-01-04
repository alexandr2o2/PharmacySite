package ru.pharmacy.pharmacy.entiteis;

import org.springframework.beans.factory.annotation.Autowired;
import ru.pharmacy.pharmacy.repositorys.CategoryRepository;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "medicine", schema = "public", catalog = "Pharmacy")
public class MedicineEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "name", nullable = false, length = -1)
    private String name;
    @Basic
    @Column(name = "description", nullable = true, length = -1)
    private String description;
    @Basic
    @Column(name = "deleted", nullable = false)
    private boolean deleted;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "med_cat",
            joinColumns = { @JoinColumn(name = "medicine_id") },
            inverseJoinColumns = { @JoinColumn(name = "category_id") })
    private Set<CategoryEntity> categoryEntities = new HashSet<CategoryEntity>();

    public MedicineEntity() {
    }

    public MedicineEntity(long id, String name, String description, Boolean deleted, Set<CategoryEntity> categoryEntities) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.deleted = deleted;
        this.categoryEntities = categoryEntities;
    }


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Set<CategoryEntity> getCategoryEntities() {
        return categoryEntities;
    }

    public void setCategoryEntities(Set<CategoryEntity> categoryEntities) {
        this.categoryEntities = categoryEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicineEntity that = (MedicineEntity) o;
        return id == that.id && deleted == that.deleted && Objects.equals(name, that.name) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, deleted);
    }
}
