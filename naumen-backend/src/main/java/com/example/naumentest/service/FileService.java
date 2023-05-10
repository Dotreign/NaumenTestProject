package com.example.naumentest.service;

import com.example.naumentest.model.Name;
import com.example.naumentest.repository.NameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class FileService {

    NameRepository nameRepo;

    @Autowired
    public FileService(NameRepository nameRepo) {
        this.nameRepo = nameRepo;
    }

    public String dataExtractor(String data) {
        try {
            System.out.println(data);
            Pattern pattern = Pattern.compile("[а-яА-Я]+\\-[0-9]+");
            Matcher matcher = pattern.matcher(data);
            while (matcher.find()) {
                String substring = data.substring(matcher.start(), matcher.end());
                String[] tokens = substring.split("-");
                if (!nameRepo.existsByName(tokens[0])) {
                    Name name = new Name(tokens[0], Integer.valueOf(tokens[1]));
                    nameRepo.save(name);
                }
            }
            return "Файл успешно обработан";
        } catch (Exception e) {
            e.printStackTrace();
            return "Ошибка при обработке файла";
        }
    }

}
