package com.Magistances.chatbot.Service.Repository;

import com.Magistances.chatbot.Model.Dtos.DatesDto;
import com.Magistances.chatbot.Model.Entity.Dates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RDates extends JpaRepository <Dates,Long>{
    //corregir problema con la query
    List<Dates> findByidUser(Long userId);
//
//    @Query("SELECT u FROM Dates WHERE users.phone_user")
//    List<Dates>findbyphonenumber(@Param("phonenumber")String phonenumber);
    //maybe add method findByStringLike (phone number as string)
}
