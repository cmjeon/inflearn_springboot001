package tobyspring.helloboot;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HelloControllerTest {

    @Test
    void HelloController() {
        // given
        HelloController helloController = new HelloController(new HelloDecorator(name -> name) {
            @Override
            public String sayHello(String name) {
                return name;
            }
        });
        // when
        String ret = helloController.hello("Test");
        // then
        assertThat(ret).isEqualTo("Test");
    }

    @Test
    void failHelloController() {
        // given
        HelloController helloController = new HelloController(name -> name);

        assertThatThrownBy(() -> {
            // when
            helloController.hello(null);
        // then
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            // when
            helloController.hello("");
        // then
        }).isInstanceOf(IllegalArgumentException.class);
    }

}