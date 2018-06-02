package net.caimito;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Statement {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	@Column
	private Date date ;
	
	@Column
	private String description ;
	
	@Column
	private BigDecimal amount ;

	public Statement() {
	}
	
	public Statement(LocalDate date, String description, BigDecimal amount) {
		this.date = Date.valueOf(date) ;
		this.description = description ;
		this.amount = amount ;
	}

}
