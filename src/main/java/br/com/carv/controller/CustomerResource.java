package br.com.carv.controller;

import br.com.carv.dto.CustomerDTO;
import br.com.carv.service.CustomerService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
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
        return Response.status(Response.Status.OK).entity(customers).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        CustomerDTO customerDTO = customerService.findById(id);
        return Response.status(Response.Status.OK).entity(customerDTO).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response saveCustomer(CustomerDTO dto) {
        customerService.saveCustomer(dto);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @Path("/{id}")
    public Response updateCustomer(@PathParam("id") Long id, CustomerDTO dto) {
        customerService.updateCustomer(id, dto);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteCustomer(@PathParam("id") Long id){
        customerService.deleteCustomer(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }




}
