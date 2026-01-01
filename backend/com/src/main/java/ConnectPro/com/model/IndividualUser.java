package ConnectPro.com.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@DiscriminatorValue("INDIVIDUAL")
public class IndividualUser extends User {

    // Ssn e como cpf
    @Column(nullable = false, unique = true, length = 9)
    private String ssn;
}
