/**
 * 
 */
package com.okfinancial.diary.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.okfinancial.diary.domain.User;


/**
 * @author uu
 *
 */
public interface UserRepository extends CrudRepository<User, Long> {
	
	User findOneByEmail(@Param("email") String email);
	
	User findOneByName(@Param("name") String name);
	
	@Query("from User u where u.leader is Null")
	List<User> findByLeaderIsNull();
	
//	@Query("update User set leader=:leader where u.leader=:oriLeader and u.state=0")
//	void changeLeader(@Param("leader") User leader,@Param("oriLeader") User oriLeader);
	
}
