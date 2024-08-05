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

    @Query("SELECT u FROM Dates u WHERE u.user_fk.idUser = :id")
    List<Dates> findDatesByUserId(@Param("id")Long id);
//
//    @Query("SELECT u FROM Dates WHERE users.phone_user")
//    List<Dates>findbyphonenumber(@Param("phonenumber")String phonenumber);
    //maybe add method findByStringLike (phone number as string)
}
