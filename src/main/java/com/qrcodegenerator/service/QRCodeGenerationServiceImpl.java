package com.qrcodegenerator.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
@Slf4j
public class QRCodeGenerationServiceImpl implements  IQRCodeGenerationService{


    @Value("${qrcode.message}")
    private  String QRCODE_MESSAGE;

    @Value("${qrcode.output.directory}")
    private  String QRCODE_LOCATION;


    private static final String charset = "UTF-8";

    private static final String strDateFormat = "yyyyMMddhhmmss";

    @Override
    public void generateQRCode(String message) {

        log.info(" ### Generating  QR code  ### ");

        log.info("Output location - {}", QRCODE_LOCATION);

        try{
            String finalMessage = (StringUtils.isBlank(message))? QRCODE_MESSAGE : message;
            log.info("Final input message -{}",finalMessage);


        }
    }

    private void processQRCode(
            String data,
            String path,
            String charset,
            int height,
            int width) throws WriterException, IOException {

        BitMatrix matrix = new MultiFormatWriter().encode(
                new String(data.getBytes(charset),charset), BarcodeFormat.QR_CODE,width,height);

        MatrixToImageWriter.writeToFile(matrix,path.substring(path.lastIndexOf('.') + 1), new File(path));
    }
}
