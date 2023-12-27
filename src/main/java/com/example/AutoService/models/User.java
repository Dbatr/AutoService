package com.example.AutoService.models;

import com.example.AutoService.models.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {
    // Уникальный идентификатор пользователя
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId")
    private Long id;

    // Логин пользователя
    @Column(name = "Login")
    private String login;

    // Пароль пользователя
    @Column(name = "Password")
    private String password;

    // Имя пользователя
    @Column(name = "FirstName")
    private String firstName;

    // Фамилия пользователя
    @Column(name = "LastName")
    private String lastName;

    // Номер телефона пользователя
    @Column(name = "PhoneNumber")
    private String phoneNumber;

    // Флаг, указывающий, активен ли пользователь
    @Column(name = "active")
    private boolean active;

    // Роли пользователя (например, ROLE_USER, ROLE_ADMIN)
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles = new HashSet<>();

    // Методы интерфейса UserDetails

    // Получение ролей пользователя
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    // Получение логина пользователя
    @Override
    public String getUsername() {
        return login;
    }

    // Методы, указывающие на состояние учетной записи пользователя

    // Учетная запись пользователя не истекла
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // Учетная запись пользователя не заблокирована
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // Учетные данные пользователя не истекли
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // Учетная запись пользователя активна
    @Override
    public boolean isEnabled() {
        return active;
    }

}
