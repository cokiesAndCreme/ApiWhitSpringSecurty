package com.Magistances.chatbot.Service.InterImpl;

import com.Magistances.chatbot.Model.Dtos.DateDtoGetAll;
import com.Magistances.chatbot.Model.Dtos.DatesDto;
import com.Magistances.chatbot.Model.Dtos.DatesDtoFindByIdUser;
import com.Magistances.chatbot.Model.Entity.Dates;

import java.util.List;

public interface Idate {
    //holaaa
    DatesDto createNewDate(DatesDto datesdto);
    DateDtoGetAll findById(Long id);
    void deteleById (Long id);
    List<DateDtoGetAll>findAll();
    List<DatesDto>findByIdUser(Long id);
    List<DatesDtoFindByIdUser> findDatesByUserId(Long id);
}
