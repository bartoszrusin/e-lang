package pl.brusin.elang.admin.domain.users;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table
public class User implements Serializable {

    private Integer id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String address;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(length = 200, nullable = false)
    @NotNull(message = "Name is required")
//    @Pattern(regexp = "\\w+", message = "Name is required")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(length = 200, nullable = false)
    @NotNull(message = "Surname is required")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name = "phone_number", length = 20, nullable = false)
    @NotNull(message = "Phone number is required")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //TODO move to another entity class: Address
    @Column(length = 1024, nullable = false)
    @NotNull(message = "Address is required")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object obj) {
        return this.id != null && obj instanceof User && this.id.equals(((User) obj).getId());
    }

    @Override
    public int hashCode() {
        return this.id != null ? this.id.hashCode() : 0;
    }
}
