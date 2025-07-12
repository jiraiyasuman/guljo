package com.guljo.guljo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guljo.guljo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
