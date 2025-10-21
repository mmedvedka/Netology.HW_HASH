
import java.util.Objects;

class Address {
    protected String country;
    protected String city;

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public String getCountry()
    {
        return this.country;
    }

    @Override
    public boolean equals(Object obj) {
        Address address = (Address) obj;
        if (obj == null) {
            return false;
        };
        return this.country.equals(address.country) && this.city.equals(address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city);
    }

    @Override
    public String toString() {
        return country + " - " + city;
    }
}
