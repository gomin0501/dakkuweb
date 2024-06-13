package com.shop.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name="DakkuTems")
public class DakkuTems {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column private long id;
	
	@Column(unique=true)
	private String itemcode;
	
	@NotBlank(message="상품 이름을 입력하세요")
	private String itemname;
	
	@NotBlank(message="상품 가격을 입력하세요")
	private int unitPrice;
	
	@NotBlank(message="상세정보를 입력하세요")
	private String description;
	
	@NotBlank(message="분류를 선택하세요")
	private String category;
	
	@NotBlank(message="판매 작가를 입력하세요")
	private String author;
	
	@NotBlank(message="입고 수량을 입력하세요")
	private int unitsInstock;
	
	@NotBlank(message="상품 사진을 등록하세요")
	private String filename;
}
