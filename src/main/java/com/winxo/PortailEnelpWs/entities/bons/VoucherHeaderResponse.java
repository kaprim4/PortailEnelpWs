package com.winxo.PortailEnelpWs.entities.bons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VoucherHeaderResponse
{

    private Integer id;
    private VoucherHeader voucherHeader;
    private Integer voucherCount;
    private Long voucherSum;
}
