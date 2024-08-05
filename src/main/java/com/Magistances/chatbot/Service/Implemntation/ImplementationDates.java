package com.Magistances.chatbot.Service.Implemntation;


import com.Magistances.chatbot.Model.Dtos.DatesDto;
import com.Magistances.chatbot.Model.Dtos.UserDto;
import com.Magistances.chatbot.Model.Entity.Dates;
import com.Magistances.chatbot.Model.Entity.User;
import com.Magistances.chatbot.Service.InterImpl.Idate;
import com.Magistances.chatbot.Service.Repository.RDates;
import com.Magistances.chatbot.Service.Repository.RUser;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ImplementationDates implements Idate {

    private  final RDates rDates;
    private final RUser rUser;

    @Override
    public DatesDto createNewDate(DatesDto datesdto) {
        var date = rDates.save(toEntity(datesdto));
        return datesdto;
    }

    @Override
    public DatesDto findById(Long id) {
        val date = rDates.findById(id).orElse(null);
        return toDto(date);
    }

    @Override
    public void deteleById(Long id) {
        rDates.deleteById(id);
    }

    @Override
    public List<DatesDto> findAll() {
        var dates= rDates.findAll();
        return dates.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<DatesDto> findByIdUser(Long id) {
        var dates = rDates.findById(id);
        return dates.stream().map(this::toDto).collect(Collectors.toList());
    }

    public boolean isAlreadyExist(Long id){
        return rDates.existsById(id);
    }

    public User returnUserById(Long id){
        return rUser.findById(id).orElseThrow();
    }

    public UserDto returnUserDto(User user){
        return new UserDto(user.getIdUser(),
                user.getNameUser(),
                user.getPhoneUser(),
                user.getDireccionUser());
    }

    public DatesDto toDto(Dates dates){
        return new DatesDto(
                dates.getIdDate(),
                dates.getServiceDate(),
                dates.getPaymentStatusDate(),
                dates.getDayOfDate(),
                dates.getHourOfDate(),
                dates.getCreationDate(),
                dates.getUser_fk().getIdUser());
    }

    public Dates toEntity(DatesDto datesDto){
        new Dates();
        return Dates
                .builder()
                .idDate(datesDto.idDate())
                .serviceDate(datesDto.serviceDate())
                .paymentStatusDate(datesDto.paymentStatusDate())
                .dayOfDate(datesDto.dayOfDate())
                .hourOfDate(datesDto.hourOfDate())
                .creationDate(datesDto.creationDate())
                .user_fk(returnUserById(datesDto.user_fk()))
                .build();

    }
}
