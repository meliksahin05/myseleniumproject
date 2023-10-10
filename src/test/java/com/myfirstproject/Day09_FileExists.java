package com.myfirstproject;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Day09_FileExists {

    @Test
    public void fileExistTest(){
//         	•Class: FileExistTest
//	•Method: isExist
//	•Pick a file on your desktop
//	•And verify if that file exist on your computer or not

        String pathOfFlower = System.getProperty("user.home") + "/Desktop/flower.jpeg";
        System.out.println(pathOfFlower);

       boolean isFlowerExist = Files.exists(Paths.get(pathOfFlower));
       assertTrue(isFlowerExist);
        System.out.println("isFlowerExist = " + isFlowerExist);
    }
}
