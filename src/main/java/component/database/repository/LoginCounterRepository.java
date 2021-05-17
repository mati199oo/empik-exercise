package component.database.repository;

import component.database.model.LoginCounter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginCounterRepository extends JpaRepository<LoginCounter, String> {}