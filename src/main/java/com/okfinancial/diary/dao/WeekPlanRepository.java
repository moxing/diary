/**
 * 
 */
package com.okfinancial.diary.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.okfinancial.diary.domain.User;
import com.okfinancial.diary.domain.WeekPlan;


/**
 * @author uu
 *
 */
public interface WeekPlanRepository extends CrudRepository<WeekPlan, Long> {
	
//	@RestResource(path = "user")
//	@Query("select w from WeekPlan w where w.User.id = :userId and w.startDate> NOW() and w.endDate<NOW()")
//	WeekPlan findCurrWeekPlanByUser(@Param(""));
	
	@Query("from WeekPlan w where w.user = :user and w.startDate < :date and w.endDate > :date")
	WeekPlan findByUserAndDate(@Param("user") User user, @Param("date") Date date);
	
	WeekPlan findByUserOrderByStartDateDesc(@Param("user") User user);
	
}
