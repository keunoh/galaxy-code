package com.kaltz.galaxy;

import com.kaltz.galaxy.config.AppConfig;
import com.kaltz.galaxy.domain.Member;
import com.kaltz.galaxy.repository.MemberRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class GalaxyApplication {



	public static void main(String[] args) {
		SpringApplication.run(GalaxyApplication.class, args);
	}

	@PostConstruct
	public void save() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

		for (int i = 0; i < 150; i++) {
			Member member = new Member("keunoh " + i);
			memberRepository.save(member);
		}
	}

}
