package com.Magistances.chatbot.Service.InterImpl;

import com.Magistances.chatbot.Model.Dtos.DatesDto;
import com.Magistances.chatbot.Model.Entity.Dates;

import java.util.List;

public interface Idate {
    //holaaa
    DatesDto createNewDate(DatesDto datesdto);
    DatesDto findById(Long id);
    void deteleById (Long id);
    List<DatesDto>findAll();
    List<DatesDto>findByIdUser(Long id);
}
