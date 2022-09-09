package br.com.carv.dto;

import br.com.carv.entity.CustomerEntity;

public class CustomerDTO {

    private String name;

    private String email;

    private String phone;

    private String address;

    private Long age;

    public CustomerDTO() {

    }

    public CustomerDTO(String name, String email, String phone, String address, Long age) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.age = age;
    }

    public CustomerDTO(CustomerEntity entity) {
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.phone = entity.getPhone();
        this.address = entity.getAddress();
        this.age = entity.getAge();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}

