package com.example.backendpracticas.controller

import com.example.backendpracticas.model.Category
import com.example.backendpracticas.service.CategoryService
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
@RequestMapping("/category")
class CategoryController {
    @Autowired
    lateinit var categoryService: CategoryService
    @PostMapping
    fun save (@RequestBody @Valid category:Category):Category{
        return categoryService.save(category)
    }
    @GetMapping
    fun list ():List<Category>{
        return categoryService.list()
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable ("id") id: Long): ResponseEntity<Category>{
        return ResponseEntity(categoryService.listById(id), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody @Valid category: Category):ResponseEntity<Category>{
        return ResponseEntity(categoryService.update(category), HttpStatus.OK)
    }

    @PatchMapping
    fun updateDescripcion (@RequestBody @Valid category:Category):ResponseEntity<Category>{
        return ResponseEntity(categoryService.updateDescripcion(category), HttpStatus.OK)
    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return categoryService.delete(id)
    }
}