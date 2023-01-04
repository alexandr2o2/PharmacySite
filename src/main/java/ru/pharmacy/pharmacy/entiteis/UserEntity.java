package ru.pharmacy.pharmacy.entiteis;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user", schema = "public", catalog = "Pharmacy")
public class UserEntity implements UserDetails {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "name", nullable = false, length = -1)
    private String name;
    @Basic
    @Column(name = "surname", nullable = false, length = -1)
    private String surname;
    @Basic
    @Column(name = "email", nullable = false, length = -1)
    private String email;
    @Basic
    @Column(name = "login", nullable = false, length = -1)
    private String login;
    @Basic
    @Column(name = "password", nullable = false, length = -1)
    private String password;
    @Basic
    @Column(name = "deleted",nullable = false, length = -1)
    private Boolean deleted;
    @ManyToMany
    private Set<Role> role;

    public UserEntity() {
    }

    public UserEntity(Long id, String name, String surname, String email, String password, Boolean deleted, String login, Set<Role> role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.deleted = deleted;
        this.login = login;
        this.role = role;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRole();
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return !getDeleted();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
