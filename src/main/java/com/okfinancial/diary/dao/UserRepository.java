/**
 * 
 */
package com.okfinancial.diary.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.okfinancial.diary.domain.User;


/**
 * @author uu
 *
 */
public interface UserRepository extends CrudRepository<User, Long> {
	

	User findOneByEmail(String email);
	
	User findOneByName(String name);
	
	List<User> findByState(Integer state);
	
}
