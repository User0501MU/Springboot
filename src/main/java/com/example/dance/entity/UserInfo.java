//Entity DBの保管場所
package com.example.dance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user_info")//どのテーブルとリンクしているか
@Data
public class UserInfo {

	@Id //プライマリキー
	@Column(name = "login_id")//TBL（tacle)のフィールド名とEntityのフィールド名が異なるので@Columnで紐づける
	private String loginId;


	private String password;
}
