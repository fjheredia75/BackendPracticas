package com.example.backendpracticas.controller

import com.example.backendpracticas.model.Activity
import com.example.backendpracticas.service.ActivityService
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
@RequestMapping("/activity")
class ActivityController {
    @Autowired
    lateinit var activityService: ActivityService
    @PostMapping
    fun save (@RequestBody @Valid activity:Activity):Activity{
        return activityService.save(activity)
    }
    @GetMapping
    fun list ():List<Activity>{
        return activityService.list()
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable ("id") id: Long): ResponseEntity<Activity>{
        return ResponseEntity(activityService.listById(id), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody @Valid activity: Activity):ResponseEntity<Activity>{
        return ResponseEntity(activityService.update(activity), HttpStatus.OK)
    }

    @PatchMapping
    fun updateDescripcion (@RequestBody @Valid activity:Activity):ResponseEntity<Activity>{
        return ResponseEntity(activityService.updateDescripcion(activity), HttpStatus.OK)
    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return activityService.delete(id)
    }
}