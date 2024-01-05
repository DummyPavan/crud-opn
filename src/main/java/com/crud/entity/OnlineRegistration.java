package com.crud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="onlineReg")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OnlineRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private long mobile;
    private String email;

}
