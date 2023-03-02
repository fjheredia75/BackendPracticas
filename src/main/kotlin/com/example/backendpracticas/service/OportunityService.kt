package com.example.backendpracticas.service

import com.example.backendpracticas.model.Oportunity
import com.example.backendpracticas.repository.OportunityRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class OportunityService {
    @Autowired
    lateinit var oportunityRepository: OportunityRepository
    fun save (oportunity:Oportunity):Oportunity{
        return oportunityRepository.save(oportunity)
    }
    fun list ():List<Oportunity>{
        return oportunityRepository.findAll()
    }

    fun listById (id: Long?): Oportunity?{
        return  oportunityRepository.findById(id)
    }

    fun update(oportunity:Oportunity):Oportunity{
        try {
            oportunityRepository.findById(oportunity.id)
                ?: throw Exception("ID no existe")
            return  oportunityRepository.save(oportunity)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }

    }

    fun updateDescripcion(oportunity:Oportunity): Oportunity {
        try{
            val response = oportunityRepository.findById(oportunity.id)
                ?: throw Exception("ID no existe")
            response.apply {
                description=oportunity.description
            }
            return oportunityRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun delete (id: Long?):Boolean?{
        oportunityRepository.findById(id) ?:
        throw  Exception()
        oportunityRepository.deleteById(id!!)
        return true
    }
}