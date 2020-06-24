package xyz.chenww.online_xdclass;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "xyz.chenww.online_xdclass.mapper")
public class OnlineXdclassApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineXdclassApplication.class, args);
	}

}
