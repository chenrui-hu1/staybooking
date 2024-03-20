package com.hcr.staybooking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "authority")
@AllArgsConstructor
@NoArgsConstructor
public class Authority implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String username;
    private String authority;
}
