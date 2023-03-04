package com.example.backendpracticas.controller

import com.example.backendpracticas.model.Customer
import com.example.backendpracticas.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid


@RestController
@RequestMapping("/customer")
class CustomerController {
    @Autowired
    lateinit var customerService: CustomerService
    @PostMapping
    fun save (@RequestBody @Valid customer:Customer):Customer{
        return customerService.save(customer)
    }
    @GetMapping
    fun list ():List<Customer>{
        return customerService.list()
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<Customer>{
        return ResponseEntity(customerService.listById(id), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody @Valid customer: Customer):ResponseEntity<Customer>{
        return ResponseEntity(customerService.update(customer), HttpStatus.OK)
    }

    @PatchMapping
    fun updateNombre (@RequestBody @Valid customer:Customer):ResponseEntity<Customer>{
        return ResponseEntity(customerService.updateNombre(customer), HttpStatus.OK)
    }


    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return customerService.delete(id)
    }
}