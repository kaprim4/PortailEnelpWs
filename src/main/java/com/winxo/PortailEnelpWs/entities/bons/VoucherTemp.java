package com.winxo.PortailEnelpWs.entities.bons;

import com.winxo.PortailEnelpWs.entities.GasStation;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "ztbons_voucher_temp")
public class VoucherTemp
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = VoucherType.class)
    @JoinColumn(nullable = false)
    private VoucherType voucherType;

    private String voucherNumber;
    private String slipNumber;
    private String barcode;
    private String vehiculeNumber;
    private LocalDate voucherDate;

    @ManyToOne(targetEntity = GasStation.class)
    @JoinColumn(nullable = false)
    private GasStation gasStation;

    @ManyToOne(targetEntity = GasStation.class)
    private GasStation gasStationOrigin;

    private String poste_produit;

    @Column(precision = 20, scale= 2, columnDefinition = "decimal default 0.00")
    private Long voucherAmount;

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

    public VoucherTemp(VoucherType voucherType, String voucherNumber, String slipNumber, String barcode, String vehiculeNumber, LocalDate voucherDate, GasStation gasStation, GasStation gasStationOrigin, String poste_produit, Long voucherAmount, Boolean isActivated, Boolean isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.voucherType = voucherType;
        this.voucherNumber = voucherNumber;
        this.slipNumber = slipNumber;
        this.barcode = barcode;
        this.vehiculeNumber = vehiculeNumber;
        this.voucherDate = voucherDate;
        this.gasStation = gasStation;
        this.gasStationOrigin = gasStationOrigin;
        this.poste_produit = poste_produit;
        this.voucherAmount = voucherAmount;
        this.isActivated = isActivated;
        this.isDeleted = isDeleted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
