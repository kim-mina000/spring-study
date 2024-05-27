package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Order;

import jakarta.transaction.Transactional;

@Transactional
public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	// 주소지가 인천인 	주문을 검색
	@Query("select o from Order o where o.shipAddress LIKE  %:address%")
	List<Order> search1 (@Param("address") String address);
	
//	@Query(value = "select * from tbl_order where ship_address like :address%", nativeQuery = true)
//	List<Order> search1(@Param("address") String address);
	
	// 주문일이 7월 3일인 주문검색
//	@Query(value = "select * from tbl_order where order_date = :inputDate", nativeQuery = true)
//	List<Order> search2(@Param("inputDate") LocalDate inputDate);
	
	@Query("select o from Order o where orderDate = :inputDate")
	List<Order> search2(@Param("inputDate") LocalDate inputDate);
}
