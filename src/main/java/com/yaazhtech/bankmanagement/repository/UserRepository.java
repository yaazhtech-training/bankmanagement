package com.yaazhtech.bankmanagement.repository;

import com.yaazhtech.bankmanagement.data.PupilUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<PupilUser, Long> {

    // Find a user by username (for login)
    PupilUser findByUserName(String userName);

    // Optional: Find a user by email (if you want email login)
    PupilUser findByEmail(String email);

    // Optional: Find a user by username and password directly
    PupilUser findByUserNameAndPassword(String userName, String password);
}
// Declares a repository interface for PupilUser entities.
// Extends JpaRepository to inherit built-in CRUD methods like:
// save(), findById(), findAll(), deleteById(), existsById(), etc.
// The first generic type <PupilUser> specifies the entity type.
// The second generic type <Long> specifies the type of the entity's primary key.