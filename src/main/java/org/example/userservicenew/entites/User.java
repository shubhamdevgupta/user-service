package org.example.userservicenew.entites;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "micro_user")
public class User {
    @Id
    @Column(name = "ID")
    private  String userId;
    @Column(name = "NAME", length = 15)
    private  String name;
    @Column(name = "EMAIL")
    private  String email;
    @Column(name = "ABOUT")
    private  String about;

    @Transient
    private List<Rating> ratingList=new ArrayList<>();
}
