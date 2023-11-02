package com.winxo.PortailEnelpWs.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "region")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String libelle;
    private String code;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "region", fetch = FetchType.EAGER)
    private List<City> cities;

    public Region(String libelle, String code, Boolean isActivated, Boolean isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.libelle = libelle;
        this.code = code;
        this.isActivated = isActivated;
        this.isDeleted = isDeleted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
