package com.curevent.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comments")

public class Comment {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "event_id")
    private UUID eventId;

    @Column(name = "owner_id")
    private UUID ownerId;

    @Column(name = "description")
    @NotNull
    private String description;
}
