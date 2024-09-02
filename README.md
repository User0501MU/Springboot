<!--ポスグレxml-->
		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
		</dependency>

#application.property
  # PostgreSQL Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/mydatabase
spring.datasource.username=root
spring.datasource.password=任意のpw
# spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

--1. psql でデータベースに接続する
psql -U your_username -d user_info

--2,テーブルの作成
CREATE TABLE user_credentials (
    id SERIAL PRIMARY KEY,         -- 自動インクリメントの主キー
    login VARCHAR(20) NOT NULL,    -- 最大20文字のログインID
    password VARCHAR(20) NOT NULL  -- 最大20文字のパスワード
);
