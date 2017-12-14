package edu.karazin.shop.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.karazin.shop.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
	
	@Query("FROM Order where id=:userDataId")
	Iterable<Order> findByUserData(@Param("userDataId") Long userDataId);
}
