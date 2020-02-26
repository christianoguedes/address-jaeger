package br.com.zup.demo.microserviceaddress

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Configuration
import org.springframework.core.convert.converter.Converter
import org.springframework.core.convert.converter.ConverterFactory
import org.springframework.format.FormatterRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@EnableFeignClients
@SpringBootApplication
class MicroserviceAddressApplication

fun main(args: Array<String>) {
    runApplication<MicroserviceAddressApplication>(*args)
}

@Configuration
internal class ConvertersConfig : WebMvcConfigurer {
    override fun addFormatters(registry: FormatterRegistry) {
        registry.addConverterFactory(StringToEnumConverterFactory())
    }
}

internal class StringToEnumConverterFactory : ConverterFactory<String, Enum<*>?> {
    override fun <E : Enum<*>?> getConverter(clazz: Class<E>): Converter<String, E> {
        return StringToEnumConverter(clazz)
    }
}

internal class StringToEnumConverter<T : Enum<*>?>(private val enumClass: Class<T>) : Converter<String, T> {
    override fun convert(source: String): T? {
        if (source.isEmpty()) {
            return null
        }
        return enumClass.enumConstants.first { it!!.name.toUpperCase() == source.toUpperCase().trim() }
    }
}