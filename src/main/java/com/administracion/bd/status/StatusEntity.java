package com.administracion.bd.status;

import jakarta.persistence.*;

@Entity
@Table(name = "status")
public class StatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Asegura que el ID se genere automáticamente
    @Column(name = "status_id")
    private Long statusId;

    @Column(name = "description", nullable = true)
    private String description;

    
    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

