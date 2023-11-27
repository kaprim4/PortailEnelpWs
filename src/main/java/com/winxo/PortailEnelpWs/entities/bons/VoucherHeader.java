package com.winxo.PortailEnelpWs.entities.bons;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.winxo.PortailEnelpWs.entities.City;
import com.winxo.PortailEnelpWs.entities.GasStation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "ztbons_entete")
public class VoucherHeader
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = GasStation.class)
    @JoinColumn(nullable = false)
    private GasStation gasStation;

    private Long slipNumber;

    @Column(nullable = false, columnDefinition = "date")
    private LocalDate voucherDate;

    @Column(columnDefinition = "boolean default 0")
    private Boolean isDayOver;

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
    @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true, mappedBy = "voucherHeader")
    private List<VoucherTemp> voucherTemps;

    public VoucherHeader(GasStation gasStation, Long slipNumber, LocalDate voucherDate, Boolean isDayOver, Boolean isActivated, Boolean isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.gasStation = gasStation;
        this.slipNumber = slipNumber;
        this.voucherDate = voucherDate;
        this.isDayOver = isDayOver;
        this.isActivated = isActivated;
        this.isDeleted = isDeleted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
