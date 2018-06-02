package net.caimito;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EntityCrudTest {
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private AccountRepository accountRepository;

	@Test
	public void createRead() {
		Account account = new Account("Assets") ;
		
		entityManager.persist(account) ;
		
		assertThat(accountRepository.findByDescription("Assets"), hasItem(account)) ;
	}
}
