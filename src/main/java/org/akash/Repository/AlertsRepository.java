package org.akash.Repository;

import org.akash.Entity.Alerts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertsRepository extends CrudRepository<Alerts,String> {
}
