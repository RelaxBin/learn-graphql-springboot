package net.boboweike.learn.graphql.resolver;

import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import net.boboweike.learn.graphql.domain.BankAccount;
import net.boboweike.learn.graphql.domain.Client;
import net.boboweike.learn.graphql.domain.Currency;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class BankAccountResolver implements GraphQLQueryResolver {
    public BankAccount bankAccount(UUID id) {
        log.info("Retrieving bank account, id {}", id);

        var clientA = Client.builder()
                .id(UUID.randomUUID())
                .firstName("William")
                .lastName("Bobo1")
                .build();

        var clientB = Client.builder()
                .id(UUID.randomUUID())
                .firstName("William")
                .lastName("Bobo2")
                .build();

        // 模拟相互引用
        clientA.setClient(clientB);
        clientB.setClient(clientA);

        return BankAccount.builder()
                .id(id)
                .currency(Currency.RMB)
                .client(clientA)
                .build();
    }
}
