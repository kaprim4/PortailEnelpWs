package com.winxo.PortailEnelpWs.entities.depense;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "z_depense_activites")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer code;
    private String libelle;

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

    @ManyToMany(mappedBy = "activities")
    @JsonIgnore
    private List<Operation> operations;

    public Activity(Integer code, String libelle, Boolean isActivated, Boolean isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.code = code;
        this.libelle = libelle;
        this.isActivated = isActivated;
        this.isDeleted = isDeleted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
