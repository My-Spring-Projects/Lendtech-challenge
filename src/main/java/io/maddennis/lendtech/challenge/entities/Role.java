package io.maddennis.lendtech.challenge.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long role_id;
    @Enumerated(EnumType.STRING) @Column(length = 20)
    private RoleEnum name;

    public Role(RoleEnum name) {
        this.name = name;
    }
}
