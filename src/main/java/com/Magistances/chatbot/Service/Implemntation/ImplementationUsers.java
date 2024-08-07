package com.Magistances.chatbot.Service.Implemntation;

import com.Magistances.chatbot.Coontroller.AviceController.Exepcions.isAlreadyExist;
import com.Magistances.chatbot.Model.Dtos.UserDto;
import com.Magistances.chatbot.Model.Entity.User;
import com.Magistances.chatbot.Service.InterImpl.Iuser;
import com.Magistances.chatbot.Service.Repository.RUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ImplementationUsers implements Iuser {

    private final RUser rUser;

    @Override
    public void createNewUser(UserDto userDto) {
        rUser.save(toEntity(userDto));
    }

    @Override
    public UserDto findById(Long id) {
        var user = rUser.findById(id).orElse(null);
        return toDto(user);
    }

    @Override
    public void deteleById(Long id) {
        rUser.deleteById(id);

    }

    @Override
    public List<UserDto> findAll() {
        var users = rUser.findAll();
        return users.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public UserDto upload(UserDto userdto) {
        var us = rUser.save(toEntity(userdto));
        return userdto;
    }

    @Override
    public List<UserDto> findbyphonmuber(String phonenumber) {
       var us =  rUser.findbyphonmuber(phonenumber);
        return us.stream().map(this::toDto).toList();
    }

    public boolean ifExistById(Long id){
        return rUser.existsById(id);
    }

    public User toEntity (UserDto userDto){
        new User();
        return User
                .builder()
                .idUser(userDto.idUser())
                .nameUser(userDto.nameUser())
                .phoneUser(userDto.phoneUser())
                .DireccionUser(userDto.DireccionUser())
                .build();
    }

    public UserDto toDto(User user){
        return new UserDto(
                user.getIdUser(),
                user.getNameUser(),
                user.getPhoneUser(),
                user.getDireccionUser());
    }
}
