package com.shop.demo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name="DakkuMember")
public class DakkuMember {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable=false) 
	private long id;
	
	@Size(min=3,max=25)
	@NotNull(message="사용자 ID는 필수항목입니다.")
	private String userId;
	
	@NotBlank(message="비밀번호는 필수항목입니다.")
	private String password;
	
	@NotBlank(message="이름은 필수항목입니다.")
	@Column
	private String name;
	
	@NotBlank(message="성별을 입력하세요.")
	@Column
	private String gender;
	
	@NotBlank(message="생년월일을 입력하세요.")
	@Column
	private String birth;
	
	@NotBlank(message="이메일을 입력하세요.")
	@Column
	private String mail;
	
	@NotBlank(message="전화번호를 입력하세요.")
	@Column
	private String phone;
	
	@NotBlank(message="주소를 입력하세요.")
	@Column
	private String address;
	
	private LocalDateTime timestamp;
	
	
	
	
	
}
