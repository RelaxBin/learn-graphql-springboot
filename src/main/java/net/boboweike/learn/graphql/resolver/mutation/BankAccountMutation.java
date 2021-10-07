package net.boboweike.learn.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import net.boboweike.learn.graphql.domain.BankAccount;
import net.boboweike.learn.graphql.domain.Currency;
import net.boboweike.learn.graphql.domain.input.CreateBankAccountInput;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class BankAccountMutation implements GraphQLMutationResolver {
    public BankAccount createBankAccount(CreateBankAccountInput input, DataFetchingEnvironment env) {
      log.info("Creating bank account for {}", input);

      if (env.getSelectionSet().contains("xyz")) {
          // custom logic
      }

      return BankAccount.builder().id(UUID.randomUUID()).currency(Currency.RMB).build();
    }
}
