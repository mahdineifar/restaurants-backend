package com.example.restaurants.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "T_USER")
public class User extends DateAudit implements UserDetails {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USR_ID")
    private Long id;

    @Column(name = "USR_USERNAME", length = 30, unique = true, nullable = false)
    @Size(min = 5, max = 30)
    private String username;

    @Column(name = "USR_FIRST_NAME", length = 30)
    @Size(min = 3, max = 30)
    private String firstName;

    @Column(name = "USR_LAST_NAME", length = 30)
    @Size(min = 3, max = 30)
    private String lastName;

    @Column(name = "USR_EMAIL", length = 100, nullable = false, unique = true)
    @Size(max = 100)
    @Email
    private String email;

    @Column(name = "USR_PASSWORD", nullable = false)
    private String password;

    @Column(name = "USR_ENABLED", columnDefinition = "bit default 1")
    private boolean enabled;

    @Column(name = "USR_ACCOUNT_NOT_LOCKED", columnDefinition = "bit default 1")
    private boolean accountNonLocked;

    @Column(name = "USR_ACCOUNT_NON_EXPIRED", columnDefinition = "bit default 1")
    private boolean accountNonExpired;

    @Column(name = "USR_CREDENTIALS_NON_EXPIRED", columnDefinition = "bit default 1")
    private boolean credentialsNonExpired;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "JT_USER_ROLE",
            joinColumns = @JoinColumn(name = "USR_ID", referencedColumnName = "USR_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROL_ID", referencedColumnName = "ROL_ID"),
            uniqueConstraints = @UniqueConstraint(columnNames = {
            "USR_ID", "ROL_ID" }))
    private List<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Role role : this.roles) {
            for(Authority authority: role.getAuthorities()){
                grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
            }
        }
        return grantedAuthorities;
    }
}
