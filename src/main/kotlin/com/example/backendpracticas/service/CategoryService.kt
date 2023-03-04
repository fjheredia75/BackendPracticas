package com.example.backendpracticas.service

import com.example.backendpracticas.model.Category
import com.example.backendpracticas.repository.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class CategoryService {
    @Autowired
    lateinit var categoryRepository: CategoryRepository
    fun save (category:Category):Category{
        return categoryRepository.save(category)
    }
    fun list ():List<Category>{
        return categoryRepository.findAll()
    }

    fun listById (id: Long?): Category?{
        return  categoryRepository.findById(id)
    }

    fun update(category:Category):Category{
        try {
            categoryRepository.findById(category.id)
                ?: throw Exception("ID no existe")
            return  categoryRepository.save(category)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }

    }

    fun updateDescripcion(category:Category): Category {
        try{
            val response = categoryRepository.findById(category.id)
                ?: throw Exception("ID no existe")
            response.apply {
                description=category.description
            }
            return categoryRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun delete (id: Long?):Boolean?{
        categoryRepository.findById(id) ?:
        throw  Exception()
        categoryRepository.deleteById(id!!)
        return true
    }
}