package com.firewood.dataauthserver.user;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "USER")
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String password;
    private String token;

    public User(String userId, String password, String token) {
        this.userId = userId;
        this.password = password;
        this.token = token;
    }
}
