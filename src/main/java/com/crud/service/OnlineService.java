package com.crud.service;

import com.crud.payload.OnlineRegistrationDto;

import java.util.List;

public interface OnlineService {
    OnlineRegistrationDto createReg(OnlineRegistrationDto onlineRegistrationDto);

    void deleteReg(long id);

    List<OnlineRegistrationDto> getAllReg();

    OnlineRegistrationDto updateReg(long id, OnlineRegistrationDto onlineRegistrationDto);
//    public OnlineRegistrationDto createReg(OnlineRegistrationDto onlineRegistrationDto);
//
//    void deleteReg(long id);
//
//    List<OnlineRegistrationDto> getAllReg();
//
//    OnlineRegistrationDto updateReg(long id, OnlineRegistrationDto onlineRegistrationDto);
}
