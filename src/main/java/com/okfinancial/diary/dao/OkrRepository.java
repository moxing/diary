/**
 * 
 */
package com.okfinancial.diary.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.okfinancial.diary.domain.Okr;
import com.okfinancial.diary.domain.User;


/**
 * @author uu
 *
 */
public interface OkrRepository extends CrudRepository<Okr, Long> {
	
	List<Okr> findByUserOrderByQuarterDesc(@Param("user") User user);
	
	@Query("from Okr o where o.user = :user and year(o.quarter) = :year and quarter(o.quarter) = :quarter")
	Okr findByUserAtQuarter(@Param("user") User user,@Param("year") int year,@Param("quarter") int quarter);
}
