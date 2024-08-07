package com.Magistances.chatbot.Service.Repository;

import ch.qos.logback.core.net.server.Client;
import com.Magistances.chatbot.Model.Entity.Dates;
import com.Magistances.chatbot.Model.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface RUser extends JpaRepository<User,Long> {

    @Query("SELECT u FROM User u WHERE u.phoneUser LIKE %:phonenumber%")
    List<User> findbyphonmuber (@Param("phonenumber")String phonenumber);


}
