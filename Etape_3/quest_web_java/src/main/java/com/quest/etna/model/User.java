package com.quest.etna.model;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "user")
@Data 
@NoArgsConstructor
@AllArgsConstructor
public class User {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Size(min = 2,max = 255)
    @Column(name = "username")
    private String username;

    @NotEmpty
    @Size(min = 3,max = 255)
    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private UserRole role = UserRole.ROLE_USER;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "updated_date")
    private Date updatedDate;


}
