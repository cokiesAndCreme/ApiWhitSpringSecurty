package com.Magistances.chatbot.Service.InterImpl;

import ch.qos.logback.core.net.server.Client;
import com.Magistances.chatbot.Model.Dtos.UserDto;
import com.Magistances.chatbot.Model.Entity.User;

import java.util.List;

public interface Iuser {
    void createNewUser(UserDto userdto);
    UserDto findById(Long id);
    void deteleById(Long id);
    List<UserDto> findAll();
    UserDto upload(UserDto userdto);
    UserDto findbyphonmuber(String phonenumber);
}
