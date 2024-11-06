package org.example.userservicenew.repositories;

import org.example.userservicenew.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
