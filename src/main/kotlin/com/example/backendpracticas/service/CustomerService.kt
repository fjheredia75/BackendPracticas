package com.example.backendpracticas.service

import com.example.backendpracticas.model.Customer
import com.example.backendpracticas.repository.CategoryRepository
import com.example.backendpracticas.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class CustomerService {
    @Autowired
    lateinit var customerRepository: CustomerRepository
    @Autowired
    lateinit var categoryRepository: CategoryRepository


    fun save (customer:Customer):Customer{
        try {
            categoryRepository.findById(customer.categoryId)
                ?: throw Exception("El category no existe")
            return customerRepository.save(customer)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }



    fun list ():List<Customer>{
        return customerRepository.findAll()
    }


    fun update(customer:Customer):Customer{
        try {
            customerRepository.findById(customer.id)
                ?: throw Exception("ID no existe")
            return  customerRepository.save(customer)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }

    }
}