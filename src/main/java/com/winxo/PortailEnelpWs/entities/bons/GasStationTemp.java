package com.winxo.PortailEnelpWs.entities.bons;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "ztbons_station_temp")
public class GasStationTemp
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bordereau")
    private Integer id_bordereau;

    @Column(name = "zztype_bon_temp")
    private String zztype_bon_temp;

    @Column(name = "zznum_bon_temp")
    private String zznum_bon_temp;

    @Column(name = "zznum_bord_temp")
    private String zznum_bord_temp;

    @Column(name = "zzcode_barre_temp")
    private String zzcode_barre_temp;

    @Column(name = "zznum_vehicule_temp")
    private String zznum_vehicule_temp;

    @Column(name = "zzdate_bon_temp")
    private LocalDate zzdate_bon_temp;

    @Column(name = "zzclient_temp")
    private String zzclient_temp;

    @Column(name = "zzstation_prov_temp")
    private String zzstation_prov_temp;

    @Column(name = "zzid_port_bon_temp")
    private String zzid_port_bon_temp;

    @Column(name = "zzposte_produit_temp")
    private String zzposte_produit_temp;

    @Column(name = "zzarticle_temp_temp")
    private String zzarticle_temp_temp;

    @Column(name = "zzqte_produit_temp", precision = 20, scale= 2, columnDefinition = "decimal default 0.00")
    private Long zzqte_produit_temp;

    @Column(name = "zzmnt_unit_temp", precision = 20, scale= 2, columnDefinition = "decimal default 0.00")
    private Long zzmnt_unit_temp;

    @Column(name = "zzmnt_produit_temp", precision = 20, scale= 2, columnDefinition = "decimal default 0.00")
    private Long zzmnt_produit_temp;

    @Column(name = "zzmnt_vignette_temp", precision = 20, scale= 2, columnDefinition = "decimal default 0.00")
    private Long zzmnt_vignette_temp;

    @Column(name = "zzname_temp")
    private String zzname_temp;

    @Column(name = "zzlocalite_temp")
    private String zzlocalite_temp;

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

    public GasStationTemp(String zztype_bon_temp, String zznum_bon_temp, String zznum_bord_temp, String zzcode_barre_temp, String zznum_vehicule_temp, LocalDate zzdate_bon_temp, String zzclient_temp, String zzstation_prov_temp, String zzid_port_bon_temp, String zzposte_produit_temp, String zzarticle_temp_temp, Long zzqte_produit_temp, Long zzmnt_unit_temp, Long zzmnt_produit_temp, Long zzmnt_vignette_temp, String zzname_temp, String zzlocalite_temp, Boolean isActivated, Boolean isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.zztype_bon_temp = zztype_bon_temp;
        this.zznum_bon_temp = zznum_bon_temp;
        this.zznum_bord_temp = zznum_bord_temp;
        this.zzcode_barre_temp = zzcode_barre_temp;
        this.zznum_vehicule_temp = zznum_vehicule_temp;
        this.zzdate_bon_temp = zzdate_bon_temp;
        this.zzclient_temp = zzclient_temp;
        this.zzstation_prov_temp = zzstation_prov_temp;
        this.zzid_port_bon_temp = zzid_port_bon_temp;
        this.zzposte_produit_temp = zzposte_produit_temp;
        this.zzarticle_temp_temp = zzarticle_temp_temp;
        this.zzqte_produit_temp = zzqte_produit_temp;
        this.zzmnt_unit_temp = zzmnt_unit_temp;
        this.zzmnt_produit_temp = zzmnt_produit_temp;
        this.zzmnt_vignette_temp = zzmnt_vignette_temp;
        this.zzname_temp = zzname_temp;
        this.zzlocalite_temp = zzlocalite_temp;
        this.isActivated = isActivated;
        this.isDeleted = isDeleted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
