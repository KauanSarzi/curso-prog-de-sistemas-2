package com.bookstore.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.jpa.models.PublisherModel;
import java.util.UUID;

public interface PublisherRepository extends JpaRepository <PublisherModel, UUID> {
    
}
