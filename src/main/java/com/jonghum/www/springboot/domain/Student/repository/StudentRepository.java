package com.jonghum.www.springboot.domain.Student.repository;

import com.jonghum.www.springboot.domain.Student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,String> {

    @Query("select s from Student s where s.id=:id and s.password=:password")
    Student findByIdAndPassword(@Param("id") String id,@Param("password") String password);
}
