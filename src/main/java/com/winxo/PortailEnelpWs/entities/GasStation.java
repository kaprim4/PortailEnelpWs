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
@Table(name = "gas_station")
public class GasStation
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = Company.class)
    @JoinColumn(nullable = false)
    private Company company;

    @ManyToOne(targetEntity = Supervisor.class)
    @JoinColumn(nullable = false)
    private Supervisor supervisor;

    @ManyToOne(targetEntity = City.class)
    @JoinColumn(nullable = false)
    private City city;

    private String code_sap;
    private String libelle;
    private String zip_code;
    private String address;
    private String latitude;
    private String longitude;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gasStation", fetch = FetchType.EAGER)
    private List<User> users;

    public GasStation(Company company, Supervisor supervisor, City city, String code_sap, String libelle, String zip_code, String address, String latitude, String longitude, Boolean isActivated, Boolean isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.company = company;
        this.supervisor = supervisor;
        this.city = city;
        this.code_sap = code_sap;
        this.libelle = libelle;
        this.zip_code = zip_code;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.isActivated = isActivated;
        this.isDeleted = isDeleted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
