package com.foodu.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodu.Model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login,Integer> {

}
