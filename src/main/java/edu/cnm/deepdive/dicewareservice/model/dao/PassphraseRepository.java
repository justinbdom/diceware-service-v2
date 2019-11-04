package edu.cnm.deepdive.dicewareservice.model.dao;

import edu.cnm.deepdive.dicewareservice.model.entity.Passphrase;
import edu.cnm.deepdive.dicewareservice.model.entity.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface PassphraseRepository extends CrudRepository<Passphrase, Long> {

  Optional<Passphrase> getPassphraseByUserAndKey(User user, String key);

  Iterable<Passphrase> getAllByUserOrderByKeyAsc(User user);

  Optional<Passphrase> getPassphraseByUserAndId(User user, long id);

}
