package guru.springframework.msscbrewery.web.mappers;

import guru.springframework.msscbrewery.domain.Customer;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    Customer customerDtoToCustomer(CustomerDto dto);
//from a dto to domain object
    CustomerDto customerToCustomerDto(Customer customer);
//from domain object to dto

}
