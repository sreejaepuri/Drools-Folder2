package com.ns.DroolsFolder2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

@Controller
@RequestMapping("/api")
public class cntrler1 {



    @GetMapping("/files")
    public void AccessFolder ()
    {
        Path path= Paths.get("E:\\Drools Demo\\drools Folder\\");

//it is 1 Way
//         try(DirectoryStream<Path> stream = Files.newDirectoryStream(path))
//         {
//             List<String> filecontent =Files.readAllLines(path);
//             for(Path file:stream){
//                 Path files=file.getFileName();
//
//                 System.out.println("******files******"+files);
//                 System.out.println("******filecontent******"+filecontent);
//             }
//         } catch (IOException e) {
//             e.printStackTrace();
//         }

//        it is 2nd way
        try(Stream<Path> paths = Files.walk(path)) {

            paths.forEach(filePath -> {
                if (Files.isRegularFile(filePath)) {
                    try {
//                        System.out.println(filePath); displays the path which it is referrring to
                        String content = new String(Files.readAllBytes((filePath)));
//                        System.out.println(content); writing Content of the files
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
