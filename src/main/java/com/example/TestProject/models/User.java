package com.example.TestProject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String surName;

    @Column(name = "patronymic", nullable = false)
    private String patronymic;

    @Column(name = "information")
    private String information;

    @Column(name = "private_phone", nullable = false)
    private int private_telephone;

    @Column(name = "home_phone")
    private int home_telephone;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

}
