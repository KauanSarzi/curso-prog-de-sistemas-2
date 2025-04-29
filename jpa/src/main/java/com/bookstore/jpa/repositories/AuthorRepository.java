package com.bookstore.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.jpa.models.AuthorModel;
import java.util.UUID;

public interface AuthorRepository extends JpaRepository <AuthorModel, UUID> {
 
}