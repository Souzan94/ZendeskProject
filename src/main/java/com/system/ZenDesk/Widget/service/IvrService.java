package com.system.ZenDesk.Widget.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.system.ZenDesk.Widget.model.CreateCampaignRequest;
import com.system.ZenDesk.Widget.model.CustomField;
import com.system.ZenDesk.Widget.model.PhoneListItem;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class IvrService {

    @Value("${campaignUrl}")
    private String url;

    @Value("${key}")
    private String key;
    @Value("${cli}")
    private String cli;


    @Value("${webhook_url}")
    private String webhook_url;

    @Value("${host}")
    private String host;
    @Value("${phone}")
    private String phone;



    public void CreateCampaign() throws IOException {


    OkHttpClient client = new OkHttpClient();
    HttpUrl.Builder urlBuilder = HttpUrl.parse(url)
            .newBuilder();
    ObjectMapper objectMapper = new ObjectMapper();
    CreateCampaignRequest request= new CreateCampaignRequest();
    request.setKey(key);
    request.setCall_type("ivr");
    request.setName("Test Campaign");
    request.setDate_range_begin("2023-05-12");
    request.setDate_range_end("2023-05-12");
    request.setTime_range_begin("09:00");
    request.setTime_range_end("11:00");
    List<Integer> activeDays = Arrays.asList(1,2,3,4,5,6,7);
    request.setActive_days(activeDays);
    request.setMax_thread_count(1);
    request.setRing_timeout(30);
    request.setCli(cli);
    request.setWelcome_announcement_id(43108);
    request.setCall_retries(2);
    request.setWebhook_url(webhook_url);
    request.setDigit_target_0("announcement/43227");
    request.setDigit_target_1("announcement/43227");
    request.setDigit_target_2("user/1003");
    request.setDigit_target_3("group/700");
    request.setDigit_target_4("ivr/10");
    request.setDigit_target_5("announcement/43113");
    request.setDigit_target_6("external/05321234567");
    request.setDigit_target_7("voicemail/1003");
    request.setDigit_target_8("queue/201");
    request.setDigit_target_9("queue/202");
    request.setDigit_target_star("restart");
    request.setDigit_target_square("user/1000");
    request.setTimeout_target("");
    request.setInvalid_target("");
    request.setDigit_retries(1);
    request.setDigit_timeout(4);
    request.setIs_commercial(false);
    List<PhoneListItem> phoneList = new ArrayList<PhoneListItem>();
    phoneList.add(new PhoneListItem(phone,"",""));
    request.setPhone_list(phoneList);
        String json = objectMapper.writeValueAsString(request);

        RequestBody body = RequestBody.create(MediaType.parse("application/json"), json);
System.out.println(json);

        Request newRequest = new Request.Builder()
                .url(urlBuilder.build())
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Host",host)
                .addHeader("Accept","*/*")
                .build();
        Response response = client.newCall(newRequest).execute();


       System.out.println(response);



    }
}
