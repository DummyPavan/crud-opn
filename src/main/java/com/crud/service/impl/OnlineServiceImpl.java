package com.crud.service.impl;

import com.crud.entity.OnlineRegistration;
import com.crud.exception.ResourceNotFoundException;
import com.crud.payload.OnlineRegistrationDto;
import com.crud.repository.OnlineRepository;
import com.crud.service.OnlineService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OnlineServiceImpl implements OnlineService {

    private OnlineRepository onlineRepository;

    public OnlineServiceImpl(OnlineRepository onlineRepository) {
        this.onlineRepository = onlineRepository;
    }

    @Override
    public OnlineRegistrationDto createReg(OnlineRegistrationDto onlineRegistrationDto) {
        OnlineRegistration onlineRegistration=new OnlineRegistration();
        onlineRegistration.setName(onlineRegistrationDto.getName());
        onlineRegistration.setMobile(onlineRegistrationDto.getMobile());
        onlineRegistration.setEmail(onlineRegistrationDto.getEmail());

        OnlineRegistration saved = onlineRepository.save(onlineRegistration);

        OnlineRegistrationDto dto=new OnlineRegistrationDto();
        dto.setId(saved.getId());
        dto.setName(saved.getName());
        dto.setMobile(saved.getMobile());
        dto.setEmail(saved.getEmail());
        dto.setMessage("Reg is created");
        return dto;
    }

    @Override
    public void deleteReg(long id) {
        OnlineRegistration onlineRegistration = onlineRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Resource not found" + id)
        );
        onlineRepository.deleteById(id);
    }

    @Override
    public List<OnlineRegistrationDto> getAllReg() {
        List<OnlineRegistration> all = onlineRepository.findAll();
        List<OnlineRegistrationDto> dtos = all.stream().map(c -> mapToDto(c)).collect(Collectors.toList());
        return dtos;
    }

    @Override
    public OnlineRegistrationDto updateReg(long id, OnlineRegistrationDto onlineRegistrationDto) {
        OnlineRegistration onlineRegistration = onlineRepository.findById(id).orElseThrow(
                ()-> new NullPointerException("Id not found")
        );
        onlineRegistration.setName(onlineRegistrationDto.getName());
        onlineRegistration.setMobile(onlineRegistrationDto.getMobile());
        onlineRegistration.setEmail(onlineRegistrationDto.getEmail());

        OnlineRegistration saved = onlineRepository.save(onlineRegistration);
        OnlineRegistrationDto dto = mapToDto(saved);
        return dto;
    }

    OnlineRegistrationDto mapToDto(OnlineRegistration onlineRegistration){
        OnlineRegistrationDto dto=new OnlineRegistrationDto();
        dto.setId(onlineRegistration.getId());
        dto.setName(onlineRegistration.getName());
        dto.setMobile(onlineRegistration.getMobile());
        dto.setEmail(onlineRegistration.getEmail());
        return dto;
    }
//    private OnlineRepository onlineRepository;
//
//    public OnlineServiceImpl(OnlineRepository onlineRepository) {
//        this.onlineRepository = onlineRepository;
//    }
//
//    @Override
//    public OnlineRegistrationDto createReg(OnlineRegistrationDto onlineRegistrationDto) {
//
//        OnlineRegistration onlineRegistration=new OnlineRegistration();
//        onlineRegistration.setName(onlineRegistrationDto.getName());
//        onlineRegistration.setMobile(onlineRegistrationDto.getMobile());
//        onlineRegistration.setEmail(onlineRegistrationDto.getEmail());
//
//        OnlineRegistration saved = onlineRepository.save(onlineRegistration);
//
//        OnlineRegistrationDto dto=new OnlineRegistrationDto();
//        dto.setId(saved.getId());
//        dto.setName(saved.getName());
//        dto.setMobile(saved.getMobile());
//        dto.setEmail(saved.getEmail());
//        dto.setMessage("Post is created");
//
//        return dto;
//
//
//    }
//
//    @Override
//    public void deleteReg(long id) {
//        onlineRepository.deleteById(id);
//    }
//
//    @Override
//    public List<OnlineRegistrationDto> getAllReg() {
//        List<OnlineRegistration> regs = onlineRepository.findAll();
//        List<OnlineRegistrationDto> dtos = regs.stream().map(c -> mapToDto(c)).collect(Collectors.toList());
//        return dtos;
//    }
//
//    @Override
//    public OnlineRegistrationDto updateReg(long id, OnlineRegistrationDto onlineRegistrationDto) {
//        OnlineRegistration onlineRegistration=onlineRepository.findById(id).orElseThrow(
//                ()->new NullPointerException("Reg not found")
//        );
//        onlineRegistration.setName(onlineRegistrationDto.getName());
//        onlineRegistration.setMobile(onlineRegistrationDto.getMobile());
//        onlineRegistration.setEmail(onlineRegistrationDto.getEmail());
//
//        OnlineRegistration saved = onlineRepository.save(onlineRegistration);
//
//        OnlineRegistrationDto dto = mapToDto(saved);
//
//        return dto;
//    }
//
//    OnlineRegistrationDto mapToDto(OnlineRegistration onlineRegistration){
//       OnlineRegistrationDto dto=new OnlineRegistrationDto();
//       dto.setId(onlineRegistration.getId());
//       dto.setName(onlineRegistration.getName());
//       dto.setMobile(onlineRegistration.getMobile());
//       dto.setEmail(onlineRegistration.getEmail());
//       return dto;
//   }

}
