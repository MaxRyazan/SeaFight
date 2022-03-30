package SeaFight.SpringParts;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//FIXME
@Component
@Aspect
public class Log {
    @After ("execution(* setParameters(..))")
    public void log() {
        File file = new File("SeaFightLog.txt");
        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter(file));

            bf.write("1111");

        } catch (IOException e) {
            System.out.println("Произошла ошибка. Скорее всего файла с именем " + file + " не существует.");
        }
    }
}
