package com.example.backendpracticas.service

import com.example.backendpracticas.model.Activity
import com.example.backendpracticas.repository.ActivityRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class ActivityService {
    @Autowired
    lateinit var activityRepository: ActivityRepository
    fun save (activity:Activity):Activity{
        return activityRepository.save(activity)
    }
    fun list ():List<Activity>{
        return activityRepository.findAll()
    }

    fun listById (id: Long?): Activity?{
        return  activityRepository.findById(id)
    }

    fun update(activity:Activity):Activity{
        try {
            activityRepository.findById(activity.id)
                ?: throw Exception("ID no existe")
            return  activityRepository.save(activity)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }

    }

    fun updateDescripcion(activity:Activity): Activity {
        try{
            val response = activityRepository.findById(activity.id)
                ?: throw Exception("ID no existe")
            response.apply {
                description=activity.description
            }
            return activityRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun delete (id: Long?):Boolean?{
        activityRepository.findById(id) ?:
        throw  Exception()
        activityRepository.deleteById(id!!)
        return true
    }

}