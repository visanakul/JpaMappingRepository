package com.mapping.jpa.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mapping.jpa.entity.Result;

public interface ResultRepository extends JpaRepository<Result, Serializable> {

}
