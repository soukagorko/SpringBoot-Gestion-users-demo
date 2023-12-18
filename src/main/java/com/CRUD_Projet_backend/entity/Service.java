package com.CRUD_Projet_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "services")
public class Service {
    //
    @Id
    @Column(name = "id_service")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idservice;

    @Column(name = "nom_service", length = 50, nullable=false)
    private String nomservice;

    @Column(name = "sigle_service", length = 20, nullable=true)
    private String sigleservice;

    @Column(name = "desc_service", length = 100, nullable=true)
    private String descservice;

    @Column(name = "contact_service", length = 30, nullable=true)
    private String contactservice;
    //Relation avec Utilisateur (@OneToMany): +un service pour +_sieurs utilisateurs, donc une liste d'utilisateurs
    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL) //
    private List<User> users;
}
