package com.qrcodegenerator.controller;


import com.qrcodegenerator.service.IQRCodeGenerationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class QRCodeController {

    @Autowired
    IQRCodeGenerationService qrCodeGenerationService;

    @PostMapping("/qrcode")
    public String generateQRCode(@RequestBody String message){
        log.info("Input message is -{}", message);

        qrCodeGenerationService.generateQRCode(message);
        return "QR code generated";
    }
}
