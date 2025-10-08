package com.yaazhtech.bankmanagement.repository;

import com.yaazhtech.bankmanagement.data.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserData, Long>
{

}
// JpaRepository provides CRUD methods out-of-the-box
// <UserData, Long> → UserData is the entity type, Long is the type of primary key
// Methods like save(), findAll(), findById(), deleteById() are already available