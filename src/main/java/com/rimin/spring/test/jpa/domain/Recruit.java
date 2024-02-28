package com.rimin.spring.test.jpa.domain;

import java.util.Date;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder(toBuilder=true)
// toBuilder=true : 수정할 수 있게 해주는 역할
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name="recruit")
@Entity
public class Recruit {
	
	
	
	@Id // primary key 
	@GeneratedValue(strategy=GenerationType.IDENTITY) // 
	private int id;
	
	@Column(name="companyId") // 정확한 column 이름 매칭시켜주기
	private int companyId;
	private String position;
	private String responsibilities;
	private String qualification;
	private String type;
	private String region;
	private int salary;
	private Date deadline;
	
	
	@UpdateTimestamp // 자동으로 현재 시간 저장
	@Column(name="createdAt", updatable=false) // false : 업데이트 될 때 마다 수정되는 것 방지
	private Date createdAt;
	
	
	@UpdateTimestamp
	@Column(name="updatedAt")
	private Date updatedAt;
	
	
	
	
	
	
	
}
