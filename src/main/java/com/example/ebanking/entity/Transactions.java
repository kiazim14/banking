package com.example.ebanking.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;

@Entity
@Getter
@Setter
@Table(name = "transactions")
public class Transactions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long id;

	@Column(name = "accountno")
	public BigInteger accountNo;

	@Column(name = "amount")
	public BigInteger amount;
	
	@Column(name = "description")
	public String description;

	@Column(name = "status")
	public int status;

	@Column(name = "type")
	public String type;

	@Column(name = "date")
	public Date date;

	@Column(name = "transactiontype")
	public String transactionType;
}
