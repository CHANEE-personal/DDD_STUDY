package org.toy_project.integration.member.application.service;

import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import io.r2dbc.spi.Clob;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.data.relational.core.conversion.BasicRelationalConverter;
import org.toy_project.account.adapter.out.persistence.Account;
import org.toy_project.account.application.port.in.GetAccountUseCase;
import org.toy_project.member.adapter.out.Member;
import org.toy_project.member.application.port.in.JoinMemberUseCase;
import org.toy_project.member.domain.MemberEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest(properties = {"spring.config.location=classpath:application-test.yml"})
@RequiredArgsConstructor
class JoinMemberServiceTest {

    @Autowired
    private JoinMemberUseCase joinMemberUseCase;

    @Autowired
    private BasicRelationalConverter basicRelationalConverter;


    @PostConstruct
    void addClobConverter() {
        ((ConfigurableConversionService) basicRelationalConverter.getConversionService()).addConverter(
                new JoinMemberServiceTest.ClobConverter());
    }


    public static class ClobConverter implements Converter<Clob, String> {

        public String convert(Clob source) {
            final List<CharSequence> asImperative = ((Flux<CharSequence>) source.stream()).collectList().block();
            return Objects.isNull(asImperative) ? "" : String.join("", asImperative);
        }
    }


    @Test
    @DisplayName("회원 가입")
    void joinMemberTest() {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setUserName("test");
        memberEntity.setUserId("test");
        memberEntity.setPassword("test");
        memberEntity.setUserPhone("010-1234-5678");
        memberEntity.setSex("m");
        memberEntity.setBirthday("1999-09-09");
        memberEntity.setAddress("인천");
        memberEntity.setEmail("test@naver.com");

        Member memberMono = joinMemberUseCase.joinMember(memberEntity).block();

        Assertions.assertThat(memberMono.getUserId()).isEqualTo("test");
    }
}
