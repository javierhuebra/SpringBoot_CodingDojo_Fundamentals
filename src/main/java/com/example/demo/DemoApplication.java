package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
// 1. Annotation
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// 1. Anotación
        @RequestMapping("/")
        // 3. Método que se asigna a la Solicitud anterior.
        public String hello() { // 3
                return "Hello World! demoaplication";
        }

	// 1. Anotación
        @RequestMapping("/random")
        // 3. Método que se asigna a la Solicitud anterior.
        public String random() { // 3
                return "Esssstoy corriendo Spring Boot desde vscode, tengo bastantes dudas pero imagino que se iran aclarando a medida que transite el curso, esta muy bueno";
        }

}
