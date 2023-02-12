package tobyspring.helloboot;

import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.assertj.core.api.Assertions.assertThat;

class HelloServiceTest {

    @Test
    void simpleHelloService() {
        // given
        SimpleHelloService helloService = new SimpleHelloService();
        // when
        String ret = helloService.sayHello("Test");
        // then
        assertThat(ret).isEqualTo("Hello Test");
    }

    @Test
    void helloDecorator() {
        // given
        HelloDecorator decorator = new HelloDecorator(name -> name);
        // when
        String ret = decorator.sayHello("Test");
        // then
        assertThat(ret).isEqualTo("*Test*");
    }
}