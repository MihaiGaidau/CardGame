package com.gaidau.cardGame.bean;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @JsonManagedReference
    @ManyToMany(mappedBy = "roles")
    List<User> users = new ArrayList<>();
    @Id
    @Enumerated(EnumType.STRING)
    private RoleType name;

}
