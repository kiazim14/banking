package com.example.ebanking.repository;

import com.example.ebanking.entity.BankWithdraw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface BankWithdrawRepository extends JpaRepository<BankWithdraw, Long>{

	@Query(value = "select * from bankwithdraw where status='0'", nativeQuery = true)
	public List<BankWithdraw> getAllWithdrawRequest();

	@Transactional
	@Modifying
	@Query(value = "update bankwithdraw set status = 1 where id = :id", nativeQuery = true)
    public void updateWithdrawRequest(Long id);

	@Transactional
	@Modifying
	@Query(value = "update bankwithdraw set status = -1 where id = :id", nativeQuery = true)
	public  void denyWithdrawRequest(Long id);

}
