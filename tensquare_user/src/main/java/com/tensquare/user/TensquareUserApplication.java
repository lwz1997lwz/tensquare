package com.tensquare.user;
import com.tensqaure.common.util.IdWorker;
import com.tensqaure.common.util.JwtUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class TensquareUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(TensquareUserApplication.class, args);
	}

	@Bean
	public IdWorker idWorkker() {
		return new IdWorker(1, 1);
	}

	//将BCrypt 作为bean注入容器之中
	@Bean
	public BCrypt bCrypt() {
		return new BCrypt();
	}

	@Bean
	public JwtUtil jwtUtil(){
		return new JwtUtil();
	}

	@Bean
	public BCryptPasswordEncoder bcryptPasswordEncoder(){
		return  new  BCryptPasswordEncoder();
	}
}
