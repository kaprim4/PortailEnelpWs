package com.winxo.PortailEnelpWs.entities.upload;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
public class ResponseFile
{

    private String name;
    private String url;
    private String type;
    private long size;
    private Boolean isActivated;
    private Boolean isDeleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ResponseFile(String name, String url, String type, long size, Boolean isActivated, Boolean isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.name = name;
        this.url = url;
        this.type = type;
        this.size = size;
        this.isActivated = isActivated;
        this.isDeleted = isDeleted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}