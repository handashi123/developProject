package com.handashi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * SpringBootApplication 은 Configuration, ComponentSacn, EnableAutoConfiguration 3개를 합친것과 같다.
 * 기동 class는 루트패키지에 위치해야 base package 설정없이 사용가능
 * @author han
 *
 */
@SpringBootApplication
public class SpringBootStart {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SpringApplication.run(SpringBootStart.class, args);
    }

}
