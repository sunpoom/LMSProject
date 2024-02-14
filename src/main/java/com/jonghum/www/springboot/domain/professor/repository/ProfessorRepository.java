package com.jonghum.www.springboot.domain.professor.repository;

import com.jonghum.www.springboot.domain.professor.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfessorRepository extends JpaRepository<Professor, String> {

    @Query("select p from Professor p where p.id=:id and p.password=:password")
    Professor findByIdAndPassword(@Param("id") String id, @Param("password") String password);
}
