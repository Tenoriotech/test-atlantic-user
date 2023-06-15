package com.user.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String cpf;
    private Boolean isActive;
    private String idResponsible;
    private Boolean systemAccess;

}
