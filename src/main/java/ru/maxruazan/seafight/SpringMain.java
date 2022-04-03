package ru.maxruazan.seafight;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
    public static void main(String[] args) {
      ClassPathXmlApplicationContext context =  new ClassPathXmlApplicationContext("config.xml");

      Game game = context.getBean("game", Game.class);
      game.play();

      context.close();
    }
}
