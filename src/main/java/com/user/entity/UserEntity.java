package com.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class UserEntity {

    @Id
    private Long id;
    private String name;
    private String email;
    private String password;
    private String cpf;
    private Boolean isActive;
    private String idResponsible;
    private Boolean accessSystem;

}
