package com.winxo.PortailEnelpWs.entities.bons;

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
@Table(name = "ztbons_voucher_controle")
public class VoucherControl
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String voucherNumber;

    @Column(precision = 20, scale= 2, columnDefinition = "decimal default 0.00")
    private Long voucherAmount;

    @ManyToOne(targetEntity = VoucherType.class)
    @JoinColumn(nullable = false)
    private VoucherType voucherType;

    @ManyToOne(targetEntity = VoucherCustomer.class)
    @JoinColumn(nullable = false)
    private VoucherCustomer voucherCustomer;

    @Column(columnDefinition = "boolean default 1")
    private Boolean newlyAdded;

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

    public VoucherControl(String voucherNumber, Long voucherAmount, VoucherType voucherType, VoucherCustomer voucherCustomer, Boolean newlyAdded, Boolean isActivated, Boolean isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.voucherNumber = voucherNumber;
        this.voucherAmount = voucherAmount;
        this.voucherType = voucherType;
        this.voucherCustomer = voucherCustomer;
        this.newlyAdded = newlyAdded;
        this.isActivated = isActivated;
        this.isDeleted = isDeleted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
