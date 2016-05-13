/**
 * 
 */
package com.okfinancial.diary.dao;

import org.springframework.data.repository.CrudRepository;

import com.okfinancial.diary.domain.DayPlan;


/**
 * @author uu
 *
 */
public interface DayPlanRepository extends CrudRepository<DayPlan, Long> {
		
	
}
