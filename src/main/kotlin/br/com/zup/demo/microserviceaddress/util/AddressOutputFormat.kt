package br.com.zup.demo.microserviceaddress.util

import org.springframework.http.MediaType

@Suppress("unused")
enum class AddressOutputFormat(val value: String, val contentType: MediaType) {

    JSON("json", MediaType.APPLICATION_JSON),
    XML("xml", MediaType.APPLICATION_XHTML_XML),
    PIPED("piped", MediaType.TEXT_PLAIN),
    QUERTY("querty", MediaType.TEXT_PLAIN);

}