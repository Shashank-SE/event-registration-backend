package com.eventportal.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}
