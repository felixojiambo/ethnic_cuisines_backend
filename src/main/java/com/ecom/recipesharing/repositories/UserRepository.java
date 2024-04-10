package com.ecom.recipesharing.repositories;
import com.ecom.recipesharing.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User,Long> {
    public  User findByEmail(String email);
}

