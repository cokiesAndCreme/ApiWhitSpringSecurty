package com.Magistances.chatbot.Coontroller;

import ch.qos.logback.core.net.server.Client;
import com.Magistances.chatbot.Coontroller.AviceController.Exepcions.isAlreadyExist;
import com.Magistances.chatbot.Model.Dtos.UserDto;
import com.Magistances.chatbot.Model.Entity.User;
import com.Magistances.chatbot.Service.Implemntation.ImplementationDates;
import com.Magistances.chatbot.Service.Implemntation.ImplementationUsers;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("users/")
@RequiredArgsConstructor
public class Controller {


    private final ImplementationUsers implementationUsers;

    @GetMapping("getdates")
    public ResponseEntity<?> getAllUsers(){
        return ResponseEntity.ok( implementationUsers.findAll());
    }

    @GetMapping("getUser/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        if (!implementationUsers.ifExistById(id)) throw new isAlreadyExist("User does not exists");
        return ResponseEntity.ok().body(implementationUsers.findById(id));
    }

    @PostMapping("createUser")
    public ResponseEntity<?> createNewUser(@RequestBody @Valid UserDto userDto){
         implementationUsers.createNewUser(userDto);
         return ResponseEntity.created( URI.create("/createUser/" + userDto.idUser())).build();
    }

    @DeleteMapping("deleteuser/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable @NotNull Long id){
        if(!implementationUsers.ifExistById(id)) throw new isAlreadyExist("User does not exists");
        implementationUsers.deteleById(id);
        return ResponseEntity.noContent().build();
    }

    //fix update method 5/8/24
    @PutMapping("modifyUser")
    public ResponseEntity<?> modyfyUser(@RequestBody @Valid  UserDto userdto){
         implementationUsers.upload(userdto);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("getbyphonenumber")
    public ResponseEntity<?> findByPhone(@RequestParam(name = "phone") @NotBlank @Min(12) String phone){
         var users = implementationUsers.findbyphonmuber(phone);
         return ResponseEntity.ok(users);

    }


}
