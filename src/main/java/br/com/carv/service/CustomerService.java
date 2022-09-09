package br.com.carv.service;

import br.com.carv.dto.CustomerDTO;
import br.com.carv.entity.CustomerEntity;
import br.com.carv.exception.CustomerNotFoundException;
import br.com.carv.repository.CustomerRepository;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CustomerService {

    private CustomerRepository customerRepository;

    @Inject
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerDTO> findAllCustomers() {
        PanacheQuery<CustomerEntity> entities = customerRepository.findAll();
        List<CustomerDTO> dtoList = entities.stream()
                .map(entity -> new CustomerDTO(entity.getName(), entity.getEmail(), entity.getPhone(), entity.getAddress(), entity.getAge()))
                .collect(Collectors.toList());
        return dtoList;
    }

    public CustomerDTO findById(Long id) {
        CustomerEntity entity = customerRepository.findById(id);
        if (entity == null) {
            throw new CustomerNotFoundException("User not found! Id: " + id);
        }
        CustomerDTO dto = new CustomerDTO(entity);
        return dto;
    }

    public void saveCustomer(CustomerDTO dto) {
        CustomerEntity entity = new CustomerEntity(dto);
        customerRepository.persist(entity);
    }

    public void deleteCustomer(Long id) {
        CustomerEntity entity = customerRepository.findById(id);
        if (entity == null) {
            throw new CustomerNotFoundException("User not found! Id: " + id);
        }
        customerRepository.delete(entity);
    }

    public void updateCustomer(Long id, CustomerDTO dto) {
        CustomerEntity entity = customerRepository.findById(id);
        if (entity == null) {
            throw new CustomerNotFoundException("User not found! Id: " + id);
        }
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setAddress(dto.getAddress());
        entity.setPhone(dto.getPhone());
        entity.setId(dto.getAge());
        customerRepository.persist(entity);
    }
}
