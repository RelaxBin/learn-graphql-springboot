package net.boboweike.learn.graphql.resolver;

import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import net.boboweike.learn.graphql.domain.BankAccount;
import net.boboweike.learn.graphql.domain.Client;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class ClientResolver implements GraphQLResolver<BankAccount> {
    public Client client(BankAccount bankAccount) {
        log.info("Retrieving client data for bank account {}", bankAccount.getId());

        return Client.builder()
                .id(UUID.randomUUID())
                .firstName("William")
                .lastName("Bobo1")
                .build();
    }
}
