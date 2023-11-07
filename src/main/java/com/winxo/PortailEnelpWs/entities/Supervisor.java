package com.winxo.PortailEnelpWs.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "supervisor")

public class Supervisor
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String lastName;
    private String email;

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supervisor", fetch = FetchType.EAGER)
    private List<GasStation> gasStations;

    public Supervisor(String firstName, String lastName, String email, Boolean isActivated, Boolean isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.isActivated = isActivated;
        this.isDeleted = isDeleted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
