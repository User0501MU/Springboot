package com.example.dance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dance.form.LoginForm;

@Controller
//@RequestMapping("/login")//ログイン画面
public class LoginController {

	@GetMapping("/login")//@@RequestMappingなしで@GetMappingに直接(引数)でも表示可
	public String view(Model model,LoginForm form) {//Model は、controllerからhtmlへデータを受け渡す為のクラス、keyとvalueセットで受け渡す
		//ログイン画面なので今回は初期値不要の為、model.addattribute は使わず、Modelに引数としてformをSpringで画面に渡すという風に記述
		return"login";//loginという名のページ（html）を表示して！
	}

	//ログイン画面の入力値を受け取る、ログイン牡丹押した際の処理
	@PostMapping("/login")
	public void login(LoginForm form) {
		System.out.println(form.toString());
	}

}
