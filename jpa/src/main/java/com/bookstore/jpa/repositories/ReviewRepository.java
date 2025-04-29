package com.bookstore.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.jpa.models.ReviewModel;
import java.util.UUID;

public interface ReviewRepository extends JpaRepository <ReviewModel, UUID> {
}