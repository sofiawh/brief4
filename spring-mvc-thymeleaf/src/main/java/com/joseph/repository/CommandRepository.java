package com.joseph.repository;

import com.joseph.entity.Command;
import com.joseph.entity.Customer;
import com.joseph.enums.State;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("commandRepository")
public interface CommandRepository extends JpaRepository<Command, Integer> {
	
//	@Transactional
 //   @Modifying
/*    @Query("INSERT INTO Command (id, dateCmd, customer, state) " +
           "VALUES (:id, :dateCmd, :customerId, :state)")
    void saveCommandWithParameters(int id, Date dateCmd, int customerId, State state);
	*/
//    @Query("INSERT INTO Command (id, customer, state) " +
//		       "VALUES (:id, :customer, :state)")
//		void saveCommandWithParameters(@Param("id") int id, 		                              
//		                               @Param("customer") Customer customer, 
//		                               @Param("state") State state);

//	List<Command> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(
//			String keyword, String keyword2, String keyword3);

	
}
