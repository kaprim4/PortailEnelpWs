package com.winxo.PortailEnelpWs.entities.bons;

import com.fasterxml.jackson.annotation.JsonView;
import com.winxo.PortailEnelpWs.entities.GasStation;
import com.winxo.PortailEnelpWs.entities.views.View;
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
    @JsonView(View.Summary.class)
    private Integer id;
    private String voucherNumber;

    @JsonView(View.Summary.class)
    @Column(precision = 20, scale= 2, columnDefinition = "decimal default 0.00")
    private Long voucherAmount;

    @JsonView(View.Summary.class)
    @ManyToOne(targetEntity = VoucherType.class)
    @JoinColumn(nullable = false)
    private VoucherType voucherType;

    @JsonView(View.Summary.class)
    @ManyToOne(targetEntity = VoucherCustomer.class)
    @JoinColumn(nullable = false)
    private VoucherCustomer voucherCustomer;

    @JsonView(View.Summary.class)
    @Column(columnDefinition = "boolean default 1")
    private Boolean newlyAdded;

    @JsonView(View.Summary.class)
    @Column(columnDefinition = "boolean default 1")
    private Boolean isActivated;

    @JsonView(View.Summary.class)
    @Column(columnDefinition = "boolean default 0")
    private Boolean isDeleted;

    @JsonView(View.Summary.class)
    @CreationTimestamp
    @Column(nullable = false, updatable = false, columnDefinition = "datetime default CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @JsonView(View.Summary.class)
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
