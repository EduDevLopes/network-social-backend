package com.pieropan.networksocial.http;

import com.pieropan.networksocial.dto.EmailDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "ms-email", url = "http://localhost:8081/email")
public interface MicroServiceEmail {

    @RequestMapping(method = RequestMethod.POST, value = "/send")
    ResponseEntity send(EmailDto emailDto);
}