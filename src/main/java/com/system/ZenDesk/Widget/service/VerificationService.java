package com.system.ZenDesk.Widget.service;


import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class VerificationService {
    private  static final Integer EXPIRE_MINS=2;
    private LoadingCache<String, Integer> codeCache;


    public VerificationService() {
        super();
        codeCache = CacheBuilder.newBuilder().expireAfterWrite(EXPIRE_MINS, TimeUnit.MINUTES)
                .build(

                        new CacheLoader<String,Integer>() {

                            @Override
                            public Integer load(String key) throws Exception {
                                return 0;
                            }
                        }

                );

    }
    public void clearCode(String key) {

        codeCache.invalidate(key);


    }

    public int getCode(String key) {


        try{

            return codeCache.get(key);
        }
        catch (Exception e){
            return 0;

        }
    }

    public int generateCode(String key) {

        Random random=new Random();
        int code= 100000 +random.nextInt(900000);
        codeCache.put(key,code);
        return code;

    }
}
