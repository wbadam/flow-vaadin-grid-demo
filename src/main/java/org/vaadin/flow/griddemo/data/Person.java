package org.vaadin.flow.griddemo.data;

/*
    {
       "firstName": "Elijah",
       "lastName": "Watson",
       "address": {
         "street": "4336 Stony Cider Parade",
         "city": "Igloo",
         "state": "District of Columbia",
         "zip": "20013-6820",
         "country": "USA",
         "phone": "(202) 555-6279"
       },
       "email": "elijah.watson@company.com"
     }
*/
public class Person {

    public static class Address {
        private String street;
        private String city;
        private String state;
        private String zip;
        private String country;
        private String phone;

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getZip() {
            return zip;
        }

        public void setZip(String zip) {
            this.zip = zip;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }

    private String firstName;
    private String lastName;
    private Address address;
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
