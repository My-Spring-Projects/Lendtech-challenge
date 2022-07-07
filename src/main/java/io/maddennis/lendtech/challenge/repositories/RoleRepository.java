package io.maddennis.lendtech.challenge.repositories;

import io.maddennis.lendtech.challenge.entities.Role;
import io.maddennis.lendtech.challenge.entities.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    //Optional<Role> findByName(RoleEnum name);
}
