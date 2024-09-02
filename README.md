<!--ポスグレxml-->
		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
		</dependency>

# application.property
  #PostgreSQL Database Configuration
  
spring.datasource.url=jdbc:postgresql://localhost:5432/mydatabase

spring.datasource.username=root

spring.datasource.password=任意のpw

#spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

https://www.tohoho-web.com/ex/postgresql.html#drop-database

--0,データベース作成

postgres=# DROP DATABASE test_database;

--1. データベースに接続する

postgres=# \c user_info
データベース"user_info"にユーザー"postgres"として接続しました。

--2,テーブルの作成

CREATE TABLE user_credentials (

    id SERIAL PRIMARY KEY,         -- 自動インクリメントの主キー
    
    login VARCHAR(20) NOT NULL,    -- 最大20文字のログインID
    
    password VARCHAR(20) NOT NULL  -- 最大20文字のパスワード
);

--テーブル中身一覧

\d user_credentials;

-- カラム：データの挿入

INSERT INTO user_credentials (login, password) VALUES ('user1', 'psd1');

user_info=# -- 特定の条件でデータを表示
user_info=# SELECT * FROM user_credentials WHERE login = 'user1';
 id | login | password
----+-------+----------
  1 | user1 | psd1
(1 行)

user_info=# SELECT * FROM user_credentials WHERE login = 'user2';
 id | login | password
----+-------+----------
  2 | user2 | psd2
(1 行)
