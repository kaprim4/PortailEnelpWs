package com.winxo.PortailEnelpWs.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String libelle;
    private String alias;

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

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role", fetch = FetchType.EAGER)
    private List<User> users;

    public Role(String libelle, String alias, Boolean isActivated, Boolean isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.libelle = libelle;
        this.alias = alias;
        this.isActivated = isActivated;
        this.isDeleted = isDeleted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
