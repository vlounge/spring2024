package com.vlad.springUrfuApp.persistence;

import jakarta.persistence.*;
import lombok.*;

/**
 * Класс таблицы для хранения ролей в базе данных
 */
@Table(name="role")
@Entity

@NoArgsConstructor
@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String roleName;
}
