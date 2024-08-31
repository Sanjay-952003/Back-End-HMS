package com.Hospital.Management.System.Repo;

import com.Hospital.Management.System.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    User finByUsername(String username);
}