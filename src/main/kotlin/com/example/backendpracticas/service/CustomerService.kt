package com.example.backendpracticas.service

import com.example.backendpracticas.model.Customer
import com.example.backendpracticas.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class CustomerService {
    @Autowired
    lateinit var customerRepository: CustomerRepository
    fun save (customer:Customer):Customer{
        return customerRepository.save(customer)
    }
    fun list ():List<Customer>{
        return customerRepository.findAll()
    }
    fun listById (id: Long?): Customer?{
        return  customerRepository.findById(id)
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

    fun updateNombre(customer:Customer): Customer {
        try{
            val response = customerRepository.findById(customer.id)
                ?: throw Exception("ID no existe")
            response.apply {
                nui =customer. nui
            }
            return customerRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun delete (id: Long?):Boolean?{
        customerRepository.findById(id) ?:
        throw  Exception()
        customerRepository.deleteById(id!!)
        return true
    }
}