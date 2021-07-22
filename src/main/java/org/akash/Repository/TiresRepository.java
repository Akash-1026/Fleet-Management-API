package org.akash.Repository;

import org.akash.Entity.Tires;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiresRepository extends CrudRepository<Tires,String> {
}
