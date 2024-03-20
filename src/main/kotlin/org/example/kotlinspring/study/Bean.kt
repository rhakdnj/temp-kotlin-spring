package org.example.kotlinspring.study

import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Config {
  @Bean
  fun name(): String {
    return "Kotlin"
  }

  @Bean
  fun age(): Int {
    return 20
  }

  @Bean
  fun person(): Person {
    return Person(name(), age(), address())
  }

  @Bean
  fun person2(address2: Address): Person {
    return Person(name(), age(), address2)
  }

  @Bean
  fun address(): Address {
    return Address("firstLine", "city")
  }

  @Bean
  fun address2(): Address {
    return Address("secondLine", "city")
  }
}


fun main() {
  val context = AnnotationConfigApplicationContext(Config::class.java)

  context.getBean("name").let(::println)
  context.getBean("age").let(::println)
  context.getBean("person").let(::println)
  context.getBean("person2").let(::println)
//  context.getBean(Address::class.java).let(::println)
}


data class Person(val name: String, val age: Int, val address: Address)
data class Address(val firstLine: String, val city: String)
