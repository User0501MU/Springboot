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

postgres-# \l

                                                                       データベース一覧
   名前    |  所有者  | エンコーディング | ロケールプロバイダー |      照合順序       |  Ctype(変換演算子)  | ICUロケール | ICUルール: |     アクセス権限      
   
-----------+----------+------------------+----------------------+---------------------+---------------------+-------------+------------+-----------------------
 
 postgres  | postgres | UTF8             | libc                 | Japanese_Japan.utf8 | Japanese_Japan.utf8 |             |            |

 template0 | postgres | UTF8             | libc                 | Japanese_Japan.utf8 | Japanese_Japan.utf8 |             |            | =c/postgres          +
 
	   |          |                  |                      |                     |                     |             |            | postgres=CTc/postgres

 template1 | postgres | UTF8             | libc                 | Japanese_Japan.utf8 | Japanese_Japan.utf8 |             |            | =c/postgres          +

	   |          |                  |                      |                     |                     |             |            | postgres=CTc/postgres

 user_info | postgres | UTF8             | libc                 | Japanese_Japan.utf8 | Japanese_Japan.utf8 |
  
   |            |

(4 行)

postgres=# \c  user_info

データベース"user_info"にユーザー"postgres"として接続しました。

user_info=# CREATE TABLE user_info (

user_info(#     login_id VARCHAR(20),

user_info(#     password VARCHAR(20)

user_info(# );

CREATE TABLE

user_info=#

user_info=# INSERT INTO user_info (login_id, password)

user_info-# VALUES ('user01', 'pwd01');

INSERT 0 1

user_info=#

user_info=# \dt

	      リレーション一覧

 スキーマ |   名前    |  タイプ  |  所有者

----------+-----------+----------+----------

 public   | user_info | テーブル | postgres

(1 行)


user_info=# \d user_info

	テーブル"public.user_info"

    列    |        タイプ         | 照合順序 | Null 値を許容 | デフォルト

----------+-----------------------+----------+---------------+------------

 login_id | character varying(20) |          |               |

 password | character varying(20) |          |               |


user_info=# SELECT * FROM user_info;

 login_id | password

----------+----------

 user01   | pwd01

(1 行)


user_info=# INSERT INTO user_info (login_id, password)

user_info-# VALUES ('user02', 'pwd02');

INSERT 0 1

user_info=# SELECT * FROM user_info;

 login_id | password

----------+----------

 user01   | pwd01

 user02   | pwd02

(2 行)


user_info=#
