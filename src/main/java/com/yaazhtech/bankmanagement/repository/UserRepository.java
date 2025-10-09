package com.yaazhtech.bankmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.yaazhtech.bankmanagement.data.PupilUser;

public interface UserRepository extends JpaRepository<PupilUser, Long> {
    Optional<PupilUser> findByEmail(String email);
}
