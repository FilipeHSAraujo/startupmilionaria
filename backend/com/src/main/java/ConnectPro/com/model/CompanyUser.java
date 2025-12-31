package ConnectPro.com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "company_user")
public class CompanyUser extends User {

    // Ein e como o cnpj
    @Column(nullable = false, unique = true, length = 9)
    private String ein;

    @Column(nullable = false)
    private String legalName;
}
