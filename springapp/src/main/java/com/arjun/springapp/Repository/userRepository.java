package com.arjun.springapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.arjun.springapp.Entity.user;

public interface userRepository extends JpaRepository<user,Integer>
{
	// @Modifying
    @Query(value="insert into user (id,name,email,password) values (?,?,?,?)",nativeQuery = true)
    void AddNewuser(int id,String name , String email,String password);
    @Query("select a from user a")
    List<user> GiveAlluser();
    @Query("Select a from user a where a.id=?1")
    Optional<user> GiveSingleuser();
}



