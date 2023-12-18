package com.CRUD_Projet_backend.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "roles")
public class Role {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private Long idrole;
    @Column(name = "nom_role", length = 50, nullable = false)
    private String nomrole;

    @Column(name = "desc_role", length = 100, nullable = true)
    private String descrole;
    //Relation avec Utilisateur (@OneToMany): +un role pour +_sieurs utilisateurs, donc une liste d'utilisateurs
    @ManyToMany(mappedBy = "role", cascade = CascadeType.ALL) //
    private List<User> users;
    //
}
