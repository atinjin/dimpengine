package github.atinjin.dimpengine;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by ryanjin on 12/05/2017.
 */
@Entity
@Getter @Setter @AllArgsConstructor
public class SystemInformation {

    @Id
    String id;
    String ipAddress;
}
