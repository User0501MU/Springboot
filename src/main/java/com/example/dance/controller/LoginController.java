package com.example.dance.controller;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dance.form.LoginForm;
import com.example.dance.service.LoginService;

////import lombok.RequiredArgsConstructor;
////import repository.UserInfoRepository;

@Controller
//@RequiredArgsConstructor
//@RequestMapping("/login")//ログイン画面
public class LoginController{

	/*
	 * //定数で定義 private static final String LOGIN_ID = "user";
	 *
	 * private static final String PASSWORD ="pwd";
	 */

	/*service追記*/
	private final LoginService service;//lombokの場合、コンストラクタの宣言

//	   @Autowired
	    public LoginController(LoginService service) {
	        this.service = service;
	    }

	@GetMapping("/login")//@@RequestMappingなしで@GetMappingに直接(引数)でも表示可
	public String view(Model model,LoginForm form) {//Model は、controllerからhtmlへデータを受け渡す為のクラス、keyとvalueセットで受け渡す
		//ログイン画面なので今回は初期値不要の為、model.addattribute は使わず、Modelに引数としてformをSpringで画面に渡すという風に記述
		return"login";//loginという名のページ（html）を表示して！
	}

	//ログイン画面の入力値を受け取る、ログイン牡丹押した際の処理
	@PostMapping("/login")
	public String login(Model model,LoginForm form) {
		//System.out.println(form.toString());

		//isCorrectUserAuthはboolean型の変数でID,PWが間違っていればfalse
		//DBからだと少し記述が変わる

		/*service追記*/
		var userInfo =service.searchUserById(form.getLoginId());
		var isCorrectUserAuth =userInfo.isPresent()
				&&form.getPassword().equals(userInfo.get().getPassword());
		/*
		 * var isCorrectUserAuth = form.getLoginId().equals(LOGIN_ID)
		 * &&form.getPassword().equals(PASSWORD);
		 */
		if(isCorrectUserAuth) {//変数を見てif文
			return"redirect:/menu";//戻り値voidをString
		}else {
			model.addAttribute("errorMsa","ログインIDとPWの組み合わせが間違っています。");//modelを使えるようにするためModel model,を記述　addAttributeはcontrollerからビューに渡す
			return"login";
		}
	}
}
