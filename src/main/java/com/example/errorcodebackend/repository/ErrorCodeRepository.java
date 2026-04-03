package com.example.errorcodebackend.repository;

import com.example.errorcodebackend.model.ErrorCode;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ErrorCodeRepository extends MongoRepository<ErrorCode, String> {

    Optional<ErrorCode> findByErrorCode(String errorCode);
}