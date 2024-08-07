package com.Magistances.chatbot.Coontroller;

import com.Magistances.chatbot.Coontroller.AviceController.Exepcions.isAlreadyExist;
import com.Magistances.chatbot.Model.Dtos.DateDtoGetAll;
import com.Magistances.chatbot.Model.Dtos.DatesDto;
import com.Magistances.chatbot.Model.Entity.Dates;
import com.Magistances.chatbot.Service.Implemntation.ImplementationDates;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("dates/")
@RequiredArgsConstructor
public class ControllerDate {

    private final ImplementationDates implementationDates;

    @GetMapping("getdates")
    public ResponseEntity<List<DateDtoGetAll>> getAllDates(){
       List<DateDtoGetAll> dates = implementationDates.findAll();
       return   ResponseEntity.ok(dates);
    }

    @PutMapping("modifydate")
    public ResponseEntity<?>modifyAppointment(@RequestBody @Valid DatesDto date){
         implementationDates.createNewDate(date);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("finddate/{id}")
    public ResponseEntity<DateDtoGetAll>findDateById(@PathVariable Long id){
        if(!implementationDates.isAlreadyExist(id)) throw  new isAlreadyExist("the date does not exist");
        var date = implementationDates.findById(id);
        return ResponseEntity.ok(date);
    }

    @PostMapping("createdate")
    public ResponseEntity<?>createNewDate(@RequestBody DatesDto dates){
        implementationDates.createNewDate(dates);
        return ResponseEntity.created(URI.create("/createdate/" + dates.idDate())).build();
    }

    @DeleteMapping("deletedate/{id}")
    public ResponseEntity<?>deleteById(@PathVariable Long id){
        if(implementationDates.isAlreadyExist(id)) throw new isAlreadyExist("the date does not exist");
        implementationDates.deteleById(id);
        return ResponseEntity.noContent().build();
    }


    //this work but have a error when you put a invalid id user, and return a empy array
    @GetMapping("findByUserId/{id}")
    public ResponseEntity<?>findByUserId(@PathVariable Long id ){
        var dates = implementationDates.findDatesByUserId(id);
        return ResponseEntity.ok(dates);
    }







}
