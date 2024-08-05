package com.Magistances.chatbot.Service.Implemntation;


import com.Magistances.chatbot.Model.Dtos.DatesDto;
import com.Magistances.chatbot.Model.Entity.Dates;
import com.Magistances.chatbot.Service.InterImpl.Idate;
import com.Magistances.chatbot.Service.Repository.RDates;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ImplementationDates implements Idate {

    private  final RDates rDates;

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

    public DatesDto toDto(Dates dates){
        return new DatesDto(
                dates.getIdDate(),
                dates.getServiceDate(),
                dates.getPaymentStatusDate(),
                dates.getDayOfDate(),
                dates.getHourOfDate(),
                dates.getCreationDate());
    }

    public Dates toEntity(DatesDto datesDto){
        new Dates();
        return Dates
                .builder()
                .idDate(datesDto.idDate())
                .serviceDate(datesDto.serviceDate())
                .paymentStatusDate(datesDto.paymentStatusDate())
                .dayOfDate(datesDto.dayOfdate())
                .hourOfDate(datesDto.hourOfDate())
                .creationDate(datesDto.creationDate())
                .build();

    }
}
