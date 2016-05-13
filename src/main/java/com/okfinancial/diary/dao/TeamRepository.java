/**
 * 
 */
package com.okfinancial.diary.dao;

import org.springframework.data.repository.CrudRepository;

import com.okfinancial.diary.domain.Team;


/**
 * @author uu
 *
 */
public interface TeamRepository extends CrudRepository<Team, Long> {
	
}
