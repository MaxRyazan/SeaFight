package ru.maxruazan.seafight;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SpringMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfigurationClass.class);

      Game game = context.getBean("game", Game.class);
      game.play();

      context.close();
    }
}
