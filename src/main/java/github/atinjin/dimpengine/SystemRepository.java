package github.atinjin.dimpengine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ryanjin on 12/05/2017.
 */
@Repository
public interface SystemRepository extends JpaRepository<SystemInformation, String> {
}
