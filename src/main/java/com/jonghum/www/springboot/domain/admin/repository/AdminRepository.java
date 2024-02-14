package com.jonghum.www.springboot.domain.admin.repository;


import com.jonghum.www.springboot.domain.admin.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,String> {

    //   @Query(value = "SELECT p FROM admin p WHERE p.name = :id AND p.category = :password")
    @Query(value="select a from Admin a where a.id=:id and a.password=:password")
    Admin findByIdAndPassword(@Param("id") String id,@Param("password") String password);

    @Query(value="select a from Admin a where a.id=:id and a.password=:password")
    Admin findById(String id, String password);
}
