package org.toy_project.integration.account.application.service;

import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import io.r2dbc.spi.Clob;
import lombok.RequiredArgsConstructor;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.data.relational.core.conversion.BasicRelationalConverter;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;
import org.toy_project.account.adapter.out.persistence.Account;
import org.toy_project.account.application.port.in.GetAccountUseCase;
import reactor.core.publisher.Flux;

@SpringBootTest
@ActiveProfiles("dev")
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@RequiredArgsConstructor
class AccountServiceTest {

    private final GetAccountUseCase getAccountUseCase;

    private final BasicRelationalConverter basicRelationalConverter;


    @PostConstruct
    void addClobConverter() {
        ((ConfigurableConversionService) basicRelationalConverter.getConversionService()).addConverter(
                new ClobConverter());
    }


    public static class ClobConverter implements Converter<Clob, String> {

        public String convert(Clob source) {
            final List<CharSequence> asImperative = ((Flux<CharSequence>) source.stream()).collectList().block();
            return Objects.isNull(asImperative) ? "" : String.join("", asImperative);
        }
    }


    @Test
    @DisplayName("계정 조회")
    void getAccountTest() {
        Account account = getAccountUseCase.getAccount(1L).block();
        assertThat(account.getAccountName()).isEqualTo("jennierubyjane");
        assertThat(account.getAccountImages().getImageUrl()).isEqualTo(
                "https://scontent-ssn1-1.cdninstagram.com/v/t51.2885-19/71533411_449636125903525_7464596574253875200_n.jpg?stp=dst-jpg_s320x320&_nc_ht=scontent-ssn1-1.cdninstagram.com&_nc_cat=1&_nc_ohc=46Hei6zgefcAX_ZYID0&edm=AOQ1c0wBAAAA&ccb=7-5&oh=00_AfBDTYWtogBWVxTSXTuu1-SZpHe4C9nrPXByBa98E7ljmQ&oe=645B8991&_nc_sid=8fd12b");
    }
}
