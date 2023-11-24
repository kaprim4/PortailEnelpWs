package com.winxo.PortailEnelpWs.entities.upload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseHeader
{

    private Integer gas_station_id;
    private Long maxSlipNumber;
    private Long nextSlipNumber;

    public ResponseHeader(Integer gas_station_id, Long maxSlipNumber, Long nextSlipNumber) {
        this.gas_station_id = gas_station_id;
        this.maxSlipNumber = maxSlipNumber;
        this.nextSlipNumber = nextSlipNumber;
    }
}
