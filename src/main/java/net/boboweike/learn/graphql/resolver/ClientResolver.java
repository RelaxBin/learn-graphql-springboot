package net.boboweike.learn.graphql.resolver;

import graphql.execution.DataFetcherResult;
import graphql.kickstart.execution.error.GenericGraphQLError;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import net.boboweike.learn.graphql.domain.BankAccount;
import net.boboweike.learn.graphql.domain.Client;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class ClientResolver implements GraphQLResolver<BankAccount> {
    public DataFetcherResult<Client> client(BankAccount bankAccount) {
        log.info("Retrieving client data for bank account {}", bankAccount.getId());

        return DataFetcherResult.<Client>newResult()
                .data(Client.builder()
                        .id(UUID.randomUUID())
                        .firstName("William")
                        .lastName("Bobo1")
                        .build())
                .error(new GenericGraphQLError("Can't get part of the client info"))
                .build();
    }
}
