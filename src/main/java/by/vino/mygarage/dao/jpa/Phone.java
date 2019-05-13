package by.vino.mygarage.dao.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="phones")
public class Phone {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int phoneId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "addressId")
    private Address address;
    @Column
    private String phoneName;

    public int getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Phone phone = (Phone) o;

        if (phoneId != phone.phoneId) return false;
        if (address != null ? !address.equals(phone.address) : phone.address != null) return false;
        return phoneName != null ? phoneName.equals(phone.phoneName) : phone.phoneName == null;
    }

    @Override
    public int hashCode() {
        int result = phoneId;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phoneName != null ? phoneName.hashCode() : 0);
        return result;
    }
}