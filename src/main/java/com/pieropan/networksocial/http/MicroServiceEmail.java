package com.pieropan.networksocial.http;

import com.pieropan.networksocial.dto.EmailDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "ms-email", url = "${spring.service.mail}")
public interface MicroServiceEmail {

    @RequestMapping(method = RequestMethod.POST, value = "/send")
    void send(EmailDto emailDto);
}