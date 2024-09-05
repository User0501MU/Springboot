//serviceクラス

package com.example.dance.service;

import java.util.Optional;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dance.entity.UserInfo;
import com.example.dance.repository.UserInfoRepository;

////import lombok.RequiredArgsConstructor;


@Service
//@RequiredArgsConstructor
//lombokの提供するアノテーション
//privatefinalで宣言したインスタンスに対してnewしたものを注入するコンストラクタを実装してくれる
public class LoginService{

	private final UserInfoRepository repository;//newされたものがrepositoryに入る
//	@Autowired
	 public LoginService(UserInfoRepository repository) {
        this.repository = repository;
}
	public Optional<UserInfo>searchUserById(String loginId){
		return repository.findById(loginId);



	}

}