package com.yaazhtech.bankmanagement.repository;

import com.yaazhtech.bankmanagement.data.PupilUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<PupilUser, Long> {
}
