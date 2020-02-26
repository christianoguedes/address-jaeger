package br.com.zup.demo.microserviceaddress.controller

import br.com.zup.demo.microserviceaddress.service.AddressService
import br.com.zup.demo.microserviceaddress.util.AddressOutputFormat
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/address")
class AddressController (private val addressService: AddressService) {

    var log: Logger = LoggerFactory.getLogger("AddressController")

    @PostMapping("/{zipCode}")
    fun findAddress(@PathVariable("zipCode") zipCode: String,
                    @RequestParam("format", defaultValue = "json")
                    format: AddressOutputFormat): ResponseEntity<String> {

        log.info("request address zipcode={}", zipCode);

        val result = addressService.findAddressByZipCodeAndFormat(zipCode, format.value)
        return ResponseEntity.ok()
                .contentType(format.contentType)
                .body(result)
    }

}