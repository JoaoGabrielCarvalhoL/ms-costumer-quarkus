package br.com.carv.entity;

import br.com.carv.dto.CustomerDTO;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(nullable = false, length = 50)
    private String email;

    private String phone;

    private String address;

    private Long age;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public CustomerEntity() {

    }

    public CustomerEntity(String name, String email, String phone, String address, Long age) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.age = age;
    }

    public CustomerEntity(CustomerDTO dto) {
        this.name = dto.getName();
        this.email = dto.getEmail();
        this.phone = dto.getPhone();
        this.address = dto.getAddress();
        this.age = dto.getAge();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @PrePersist
    private void setCreationDate() {
        setCreatedAt(LocalDateTime.now());
    }

    @PreUpdate
    private void setUpdateDate() {
        setUpdatedAt(LocalDateTime.now());
    }
}
