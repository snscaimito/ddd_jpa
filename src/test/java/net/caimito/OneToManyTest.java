package net.caimito;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OneToManyTest {

	@Autowired
	private AccountRepository accountRepository;

	@Test
	public void createAccountAddStatements() {
		Account account = new Account("Assets") ;

		accountRepository.save(account) ;
		
		account.postStatement(LocalDate.now(), "Purchase", new BigDecimal(100)) ;

		Set<Account> accounts = accountRepository.findByDescription("Assets") ;
		assertThat(accounts.toArray(new Account[accounts.size()])[0].getStatements(), is(not(empty()))) ;
	}
}
