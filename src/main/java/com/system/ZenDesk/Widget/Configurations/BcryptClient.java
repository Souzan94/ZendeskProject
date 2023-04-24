package com.system.ZenDesk.Widget.Configurations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class BcryptClient {

    private static Logger logger = LoggerFactory.getLogger(BcryptClient.class);


    public static void main(String[]args) throws IOException {


        BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
        logger.info("Enter the word to encrypt");
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
        String word=bufferedReader.readLine();
        String bcryptWord=encoder.encode(word);
        logger.info("Encrypt Word : "+ bcryptWord);
        logger.info("match word : "+ encoder.matches(word,bcryptWord));
        List<Integer> list= Arrays.asList(2,6,8,9,8);
        List subList=list.stream().filter(e -> e>7).collect(Collectors.toList());
        int a=list.stream().filter(e -> e>7).findFirst().get();
        IntSummaryStatistics stats = list.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println(stats.getMax());
        System.out.println(stats.getMin());
        System.out.println(stats.getSum());
        System.out.println(stats.getAverage());




    }


}
