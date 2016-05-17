/**
 * 
 */
package com.okfinancial.diary.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.okfinancial.diary.domain.DayPlan;
import com.okfinancial.diary.domain.User;


/**
 * @author uu
 *
 */
public interface DayPlanRepository extends CrudRepository<DayPlan, Long> {
		
	@Query("from DayPlan d where d.user.leader = :leader and TO_DAYS(d.planDate) = TO_DAYS(:date)")
	List<DayPlan> findByLeaderAndDate(@Param("leader") User leader, @Param("date") Date date);
	
}
