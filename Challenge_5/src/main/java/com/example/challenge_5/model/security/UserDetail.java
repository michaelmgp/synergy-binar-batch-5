package com.example.challenge_5.model.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "oauth_user_detail")
public class UserDetail {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String name;
    private String phoneNumber;
    private String address;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
