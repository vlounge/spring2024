package com.vlad.springUrfuApp.domain;

import jakarta.persistence.*;
import lombok.*;

/**
 * Класс таблицы для хранения в базе данных ролей для доступа к сервисам
 */
@Table(name="role")
@Entity

@NoArgsConstructor
@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
public class RoleEntity {
    
    /**
     * ID роли
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    /**
     * Название роли
     */
    @Column(name = "name")
    private String roleName;
}
