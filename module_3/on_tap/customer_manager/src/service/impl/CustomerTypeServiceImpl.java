package service.impl;
import model.CustomerType;
import repository.customer.impl.CustomerTypeRepository;
import repository.customer.impl.CustomerTypeRepositoryImpl;
import service.CustomerTypeService;

import java.util.List;

public class CustomerTypeServiceImpl implements CustomerTypeService {
CustomerTypeRepository customerTypeRepository=new CustomerTypeRepositoryImpl();
    @Override
    public CustomerType findById(int id) {
        return customerTypeRepository.findById(id);
    }

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
