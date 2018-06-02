package net.caimito;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

	Set<Account> findByDescription(String description);

}
