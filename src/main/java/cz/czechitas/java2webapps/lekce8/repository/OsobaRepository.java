package cz.czechitas.java2webapps.lekce8.repository;

import cz.czechitas.java2webapps.lekce8.entity.Osoba;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//kód, který komunikuje s databází
// CrudRepository nám pomocí Springu udělá vše za nás
// Long je typ primárního klíče v Osoba entity
@Repository
public interface OsobaRepository extends CrudRepository <Osoba, Long> {
}
