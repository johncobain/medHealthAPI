package br.edu.ifba.inf015.medHealthAPI.models.entities;

import br.edu.ifba.inf015.medHealthAPI.dtos.user.UserFormDto;
import br.edu.ifba.inf015.medHealthAPI.models.enums.Roles;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Roles role = Roles.ROLE_USER;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @PrePersist
    protected void onCreate() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        this.createdAt = now;
        this.updatedAt = now;
        if(this.role == null){
            this.role = Roles.ROLE_USER;
        }else{
            this.role = Roles.valueOf(this.role.name());
        }
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Timestamp(System.currentTimeMillis());
        if (this.role == null) {
            this.role = Roles.ROLE_USER;
        } else {
            this.role = Roles.valueOf(this.role.name());
        }
    }

    public User(){}

    public User(UserFormDto user){
        this.username = user.username();
        this.password = user.password();
        this.role = (user.role() == null ? Roles.ROLE_USER : Roles.valueOf(user.role()));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.role == null ? Roles.ROLE_USER.name() : this.role.name()));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public Roles getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = (role == null ? Roles.ROLE_USER : Roles.valueOf(role));
    }
}
