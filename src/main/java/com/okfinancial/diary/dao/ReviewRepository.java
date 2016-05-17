/**
 * 
 */
package com.okfinancial.diary.dao;

import org.springframework.data.repository.CrudRepository;

import com.okfinancial.diary.domain.DayPlanReview;

/**
 * @author uu
 *
 */
public interface ReviewRepository extends CrudRepository<DayPlanReview, Long> {
}
