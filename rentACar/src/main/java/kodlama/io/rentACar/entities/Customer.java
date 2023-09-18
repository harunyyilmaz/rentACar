package kodlama.io.rentACar.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.naming.Name;
import javax.persistence.*;

@Table(name = "customers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "password" , unique = true)
    private int password;
    @Column(name = "userName" , unique = true)
    private String userName;
    @Column(name = "firstName")
    private String firstname;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "nationalIdentityNumber")
    private String nationalIdentityNumber;

}
