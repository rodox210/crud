package com.rodd331.crud.impl.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {
  //Todo fazer buscar paginadas
    Optional<UserEntity> findById(String id);
    Optional<UserEntity> findByUserName(String userName);
    Optional<UserEntity> findByEmail(String email);
}

