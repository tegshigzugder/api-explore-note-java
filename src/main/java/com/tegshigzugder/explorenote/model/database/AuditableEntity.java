package com.tegshigzugder.explorenote.model.database;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public abstract class AuditableEntity {
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}