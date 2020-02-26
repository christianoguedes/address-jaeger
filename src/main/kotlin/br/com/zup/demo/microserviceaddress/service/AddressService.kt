package br.com.zup.demo.microserviceaddress.service

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseBody

@FeignClient(name = "addressService")
interface AddressService {

    @GetMapping("/ws/{zipCode}/{format}", consumes = [APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE, TEXT_PLAIN_VALUE])
    @ResponseBody
    fun findAddressByZipCodeAndFormat(@PathVariable("zipCode") zipCode: String,
                                      @PathVariable("format") format: String): String

}