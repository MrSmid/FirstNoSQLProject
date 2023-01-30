package com.mrsu.KulaginPavel.FirstNoSQLProject.repository;

import com.mrsu.KulaginPavel.FirstNoSQLProject.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
