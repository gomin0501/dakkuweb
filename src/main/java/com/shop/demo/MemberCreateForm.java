package com.shop.demo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberCreateForm {
	@Size(min=3, max =25)
	@NotNull(message="사용자 ID는 필수항목입니다.")
	private String userId;
	
	@NotNull(message="비밀번호는 필수항목입니다.")
	private String password;
	
	@NotNull(message="이름은 필수항목입니다.")
	private String name;
	
	@NotNull(message="성별을 입력하세요.")
	private String gender;
	
	@NotNull(message="생년월일을 입력하세요.")
	private String birth;
	
	@NotNull(message="이메일을 입력하세요.")
	private String mail;
	
	@NotNull(message="전화번호를 입력하세요.")
	private String phone;
	
	@NotNull(message="주소를 입력하세요.")
	private String address;
	
	
	
	
}
