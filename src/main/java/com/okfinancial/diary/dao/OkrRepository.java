/**
 * 
 */
package com.okfinancial.diary.dao;

import org.springframework.data.repository.CrudRepository;

import com.okfinancial.diary.domain.Okr;


/**
 * @author uu
 *
 */
public interface OkrRepository extends CrudRepository<Okr, Long> {
	
}
