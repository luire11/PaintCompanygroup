package com.tts.PaintCompany.Subscribe;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Subscriber {
	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	
	@Getter
	@Setter
	@NotEmpty(message = "Please enter your email address")
	@Email(message = "Please enter a valid email address")
	private String email;
		
	@Column
	@CreationTimestamp
	@Getter
	@Setter
	private Date signedUp;
	
	public Subscriber() {
	}
	
	
	public Subscriber(String email, Date signedUp) {
		this.email = email;
		this.signedUp = signedUp;
	  }
	
	@Override
	public String toString() {
		return "Subscriber [id= " + id  +  ", email= " + email
	+ ", signedUp= " + signedUp + "]";
	}

}
