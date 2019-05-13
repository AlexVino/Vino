package by.vino.mygarage.dao.jpa;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="ads")
public class Ad {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "carId")
    private Car car;
    @Column(name="dateAdd")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date dateAdd;
    @Column(name="dateDelete")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date dateDelete;

    public int getAdId() {
        return adId;
    }

    public void setAdId(int adId) {
        this.adId = adId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    public Date getDateDelete() {
        return dateDelete;
    }

    public void setDateDelete(Date dateDelete) {
        this.dateDelete = dateDelete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ad)) return false;
        Ad ad = (Ad) o;
        return adId == ad.adId &&
                Objects.equals(user, ad.user) &&
                Objects.equals(car, ad.car) &&
                Objects.equals(dateAdd, ad.dateAdd) &&
                Objects.equals(dateDelete, ad.dateDelete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adId, user, car, dateAdd, dateDelete);
    }
}