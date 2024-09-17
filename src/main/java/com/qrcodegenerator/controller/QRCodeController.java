package com.qrcodegenerator.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class QRCodeController {

    public String generateQRCode(@RequestBody String message){
        log.info("Input message is -{}", message);

    }
}
