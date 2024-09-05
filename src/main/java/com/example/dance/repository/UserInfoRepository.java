//インターフェイスで作成 DBを動かす（？）
package com.example.dance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dance.entity.UserInfo;

@Repository
public interface UserInfoRepository
extends JpaRepository<UserInfo,String>
//interfaceインターフェイス
//extends継承
//JpaRepositoryインターフェイス（基本的な CRUD 操作、ページング、ソート機能を提供）
//<UserInfo,String>は、Entityに定義したクラス名UserInfoとフィールドの型がstring型なのでstringを定義
{

}
