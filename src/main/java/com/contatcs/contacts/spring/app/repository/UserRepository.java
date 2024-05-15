package com.contatcs.contacts.spring.app.repository;

import com.contatcs.contacts.spring.app.model.Users;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{

    //No need to implement it, spring data jpa takes care of it.
    Optional<Users> findUsersByUsernameAndPassword(String username, String password);

}
