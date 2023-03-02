package com.example.backendpracticas.controller

import com.example.backendpracticas.model.Oportunity
import com.example.backendpracticas.service.OportunityService
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
@RequestMapping("/oportunity")
class OportunityController {
    @Autowired
    lateinit var oportunityService: OportunityService
    @PostMapping
    fun save (@RequestBody @Valid oportunity:Oportunity):Oportunity{
        return oportunityService.save(oportunity)
    }
    @GetMapping
    fun list ():List<Oportunity>{
        return oportunityService.list()
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable ("id") id: Long): ResponseEntity<Oportunity>{
        return ResponseEntity(oportunityService.listById(id), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody @Valid oportunity: Oportunity):ResponseEntity<Oportunity>{
        return ResponseEntity(oportunityService.update(oportunity), HttpStatus.OK)
    }

    @PatchMapping
    fun updateDescripcion (@RequestBody @Valid oportunity:Oportunity):ResponseEntity<Oportunity>{
        return ResponseEntity(oportunityService.updateDescripcion(oportunity), HttpStatus.OK)
    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return oportunityService.delete(id)
    }
}