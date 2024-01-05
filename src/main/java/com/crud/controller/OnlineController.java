package com.crud.controller;

import com.crud.entity.OnlineRegistration;
import com.crud.payload.OnlineRegistrationDto;
import com.crud.service.OnlineService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/onlinereg")
public class OnlineController {

//    private OnlineService onlineService;
//
//    public OnlineController(OnlineService onlineService) {
//        this.onlineService = onlineService;
//    }
//
//    @PostMapping
//    public ResponseEntity<OnlineRegistrationDto> createReg(@RequestBody OnlineRegistrationDto onlineRegistrationDto){
//        OnlineRegistrationDto dto = onlineService.createReg(onlineRegistrationDto);
//        return new ResponseEntity<>(dto, HttpStatus.CREATED);
//    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteReg(@PathVariable long id){
//        onlineService.deleteReg(id);
//        return new ResponseEntity<>("Post is deleted!!",HttpStatus.OK);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<OnlineRegistrationDto>> getAllReg(){
//        List<OnlineRegistrationDto> allReg = onlineService.getAllReg();
//        return new ResponseEntity<>(allReg,HttpStatus.OK);
//    }
//    @PutMapping("/{id}")
//    public ResponseEntity<OnlineRegistrationDto> updateReg(@PathVariable long id,@RequestBody OnlineRegistrationDto onlineRegistrationDto){
//        OnlineRegistrationDto dto = onlineService.updateReg(id, onlineRegistrationDto);
//        return new ResponseEntity<>(dto, HttpStatus.OK);
//    }

    private OnlineService onlineService;

    public OnlineController(OnlineService onlineService) {
        this.onlineService = onlineService;
    }

    @PostMapping
    public ResponseEntity<?> createReg(@Valid @RequestBody OnlineRegistrationDto onlineRegistrationDto,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
            OnlineRegistrationDto dto = onlineService.createReg(onlineRegistrationDto);
            return new ResponseEntity<>(dto, HttpStatus.CREATED);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReg(@PathVariable long id){
        onlineService.deleteReg(id);
        return new ResponseEntity<>("Reg is deleted!!",HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OnlineRegistrationDto>> getAllReg(){
        List<OnlineRegistrationDto> allReg = onlineService.getAllReg();
        return new ResponseEntity<>(allReg, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OnlineRegistrationDto> updateReg(@PathVariable long id, @RequestBody OnlineRegistrationDto onlineRegistrationDto){
        OnlineRegistrationDto dto = onlineService.updateReg(id, onlineRegistrationDto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
