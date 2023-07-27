package br.com.dcx;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloWorldController {

    private static final String mensagem = "Olá %s!";
    private static final AtomicLong counter = new AtomicLong();

    @RequestMapping("/helloworld")
    public HelloWorld helloWorld(@RequestParam(value = "name", defaultValue = "World") String name){
        return new HelloWorld(counter.incrementAndGet(), String.format(mensagem, name));
    }
}
