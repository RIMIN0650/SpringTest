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
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name="new_student")
@Entity
public class Student {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	
	// 카멜 케이스로 정의된 컬럼은 정확한 컬럼이름 매칭
	@Column(name="phoneNumber")
	private String phoneNumber;
	private String email;
	
	@Column(name="dreamJob")
	private String dreamJob;
	
	
	// insert 될 때 자동으로 현재 시간이 저장되도록
	@UpdateTimestamp
	// 업데이트 될 때마다 수정되면 안됨
	@Column(name="createdAt", updatable=false)
	private Date createdAt;
	@UpdateTimestamp
	@Column(name="updatedAt")
	private Date updatedAt;
	
	
}
