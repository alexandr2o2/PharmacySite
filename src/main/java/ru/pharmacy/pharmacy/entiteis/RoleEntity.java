package ru.pharmacy.pharmacy.entiteis;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "role", schema = "public", catalog = "Pharmacy")
public class RoleEntity {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "name", nullable = false, length = -1)
    private String name;

    @Transient
    @ManyToMany(mappedBy = "role")
    private Set<User> users;

    public RoleEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public RoleEntity() {

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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleEntity that = (RoleEntity) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
