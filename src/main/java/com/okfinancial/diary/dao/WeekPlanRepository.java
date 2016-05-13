/**
 * 
 */
package com.okfinancial.diary.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.okfinancial.diary.domain.WeekPlan;


/**
 * @author uu
 *
 */
public interface WeekPlanRepository extends CrudRepository<WeekPlan, Long> {
		
	List<WeekPlan> findByUserId(Long userId);
	
	@Query("select w from WeekPlan w where w.startDate = ?1 and w.endDate<?1")
	WeekPlan findByDate(Date date);
	
}
