package com.winxo.PortailEnelpWs.entities.upload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseFile
{

    private String name;
    private String url;
    private String type;
    private long size;

    public ResponseFile(String name, String url, String type, long size) {
        this.name = name;
        this.url = url;
        this.type = type;
        this.size = size;
    }
}