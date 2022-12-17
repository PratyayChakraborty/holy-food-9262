package com.foodu.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodu.Model.CurrentUserSession;

@Repository
public interface CurrentUserRepo extends JpaRepository<CurrentUserSession, Integer>{

	
	public  CurrentUserSession  findByUuid(String uuid);
	
	
	
	
}
