package br.com.carv.controller;

import br.com.carv.dto.CustomerDTO;
import br.com.carv.service.CustomerService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/customers")
public class CustomerResource {

    private CustomerService customerService;

    @Inject
    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCustomers() {
        List<CustomerDTO> customers = customerService.findAllCustomers();
        return Response.ok().entity(customers).build();
    }
}
