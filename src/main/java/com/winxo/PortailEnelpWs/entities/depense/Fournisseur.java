package com.winxo.PortailEnelpWs.entities.depense;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "z_depense_fournisseur")
public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code_fournisseur;
    private String libelle;
    private String localite;

    @Column(columnDefinition = "mediumtext")
    private String adresse;

    private String rc;
    private String cnss;
    private String id_tva;
    private String ice;
    private String id_fiscal;

    @Column(columnDefinition = "boolean default 1")
    private Boolean isActivated;

    @Column(columnDefinition = "boolean default 0")
    private Boolean isDeleted;

    @CreationTimestamp
    @Column(nullable = false, updatable = false, columnDefinition = "datetime default CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @CreationTimestamp
    @Column(nullable = false, updatable = false, columnDefinition = "datetime default CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;

    public Fournisseur(String code_fournisseur, String libelle, String localite, String adresse, String rc, String cnss, String id_tva, String ice, String id_fiscal, Boolean isActivated, Boolean isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.code_fournisseur = code_fournisseur;
        this.libelle = libelle;
        this.localite = localite;
        this.adresse = adresse;
        this.rc = rc;
        this.cnss = cnss;
        this.id_tva = id_tva;
        this.ice = ice;
        this.id_fiscal = id_fiscal;
        this.isActivated = isActivated;
        this.isDeleted = isDeleted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
