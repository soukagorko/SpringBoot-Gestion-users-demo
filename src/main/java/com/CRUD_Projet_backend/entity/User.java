package com.CRUD_Projet_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int iduser;
    @Column(name = "prenom", length = 50, nullable = false)
    private String prenom;
    @Column(name = "nom", length = 30, nullable = false)
    private String nom;
    @Column(name = "username", length = 50, nullable = false)
    private String username;
    @Column(name = "password", length = 50, nullable = false)
    private String password;
    @Column(name = "contact", length = 50, nullable = true)
    private String contact;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id_role"))
    private List<Role> role;

    //Relation avec Service (ManyToOne): +sieurs utilisateurs avec un meme service
    @ManyToOne(optional = false)
    @JoinColumn(name = "service_id", nullable = false, referencedColumnName = "id_service")
    private Service service;
}
