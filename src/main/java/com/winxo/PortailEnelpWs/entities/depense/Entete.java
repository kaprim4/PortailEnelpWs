package com.winxo.PortailEnelpWs.entities.depense;

import com.winxo.PortailEnelpWs.entities.GasStation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "z_depense_entete")
public class Entete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = GasStation.class)
    @JoinColumn(nullable = false, columnDefinition="integer")
    private GasStation gasStation;

    @CreationTimestamp
    @Column(columnDefinition = "date")
    private LocalDate mois_comptable;

    private String period;

    @Column(columnDefinition = "datetime default NULL")
    private LocalDateTime date_ouverture;

    @Column(columnDefinition = "datetime default NULL")
    private LocalDateTime date_cloture;

    @Column(precision = 20, scale= 2, columnDefinition = "decimal default 0.00")
    private Long m_caisse_debut;

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

    public Entete(GasStation gasStation, LocalDate mois_comptable, String period, LocalDateTime date_ouverture, LocalDateTime date_cloture, Long m_caisse_debut, Boolean isActivated, Boolean isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.gasStation = gasStation;
        this.mois_comptable = mois_comptable;
        this.period = period;
        this.date_ouverture = date_ouverture;
        this.date_cloture = date_cloture;
        this.m_caisse_debut = m_caisse_debut;
        this.isActivated = isActivated;
        this.isDeleted = isDeleted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
