package com.example.errorcodebackend.controller;

import com.example.errorcodebackend.model.ErrorCode;
import com.example.errorcodebackend.repository.ErrorCodeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/errorcodes") // this is where you get the exact path for the json
public class ErrorCodeController {

    @Autowired
    private ErrorCodeRepository repository;

    // GET all error codes
    @GetMapping
    public List<ErrorCode> getAll() {
        return repository.findAll();
    }

    // GET by error code 
    @GetMapping("/{code}")
    public ErrorCode getByCode(@PathVariable String code) {
        if (code == null) return null;

        String normalizedCode = code.toLowerCase().trim();
        Optional<ErrorCode> result = repository.findByErrorCode(normalizedCode);
        return result.orElse(null);
    }

    // POST (add new error code)
    @PostMapping
    public ResponseEntity<ErrorCode> add(@RequestBody ErrorCode errorCode) {
        
        if (errorCode == null || 
            errorCode.getErrorCode() == null || 
            errorCode.getErrorCode().isBlank()){
            return ResponseEntity.badRequest().build();
        }
        
        String normalizedCode = errorCode.getErrorCode().toLowerCase().trim();
        errorCode.setErrorCode(normalizedCode);

        Optional<ErrorCode> existing = repository.findByErrorCode(normalizedCode);
        
        if (existing.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(existing.get());
        }

        return ResponseEntity.ok(repository.save(errorCode));
    }
}