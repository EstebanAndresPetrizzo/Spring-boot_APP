package com.example.SpringAPP.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity (name = "usuario")
class usuario implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO, generator = "user_seq")
    @GenericGenerator(name = "user_seq", strategy = "native")
    private Long id;

    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column (unique = true)
    private String email;
    @Column (unique = true)
    private String userName;
    @Column
    private String password;

    @Transient //para omitir este valor en la transaccion a la BBDD
    private String confirmPassword;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)//Lazy mas performante para la base para many to many
    @JoinColumn(name = "role", referencedColumnName = "role_id")
    private Role rol;

    public usuario(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Role getRol() {
        return rol;
    }

    public void setRol(Role rol) {
        this.rol = rol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        usuario usuario = (usuario) o;
        return Objects.equals(id, usuario.id) &&
                Objects.equals(firstName, usuario.firstName) &&
                Objects.equals(lastName, usuario.lastName) &&
                Objects.equals(email, usuario.email) &&
                Objects.equals(userName, usuario.userName) &&
                Objects.equals(password, usuario.password) &&
                Objects.equals(confirmPassword, usuario.confirmPassword) &&
                Objects.equals(rol, usuario.rol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, userName, password, confirmPassword, rol);
    }
}
