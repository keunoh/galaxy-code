package com.kaltz.galaxy.config;

import com.kaltz.galaxy.repository.*;
import com.kaltz.galaxy.service.ItemService;
import com.kaltz.galaxy.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class AppConfig {

    @Bean
    ItemRepository itemRepository() {
        log.info("call itemRepository()");
        return new ItemRepositoryImpl();
    }

    @Bean
    MemberRepository memberRepository() {
        log.info("call memberRepository()");
        return new MemberRepositoryImpl();
    }

    @Bean
    BoardRepository boardRepository() {
        log.info("call boardRepository()");
        return new BoardRepositoryImpl();
    }

    @Bean
    MemberService memberService(MemberRepository memberRepository) {
        log.info("call memberService(" + memberRepository + ")");
        return new MemberService(memberRepository);
    }

    @Bean
    ItemService itemService(ItemRepository itemRepository) {
        log.info("call itemService(" + itemRepository + ")");
        return new ItemService(itemRepository);
    }
}
