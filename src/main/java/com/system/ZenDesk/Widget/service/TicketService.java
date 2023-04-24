package com.system.ZenDesk.Widget.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.system.ZenDesk.Widget.model.*;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service

public class TicketService {


    @Value("${email}")
    private String email;

    @Value("${password}")
    private String password;
    @Value("${ticket_url}")
    private String url;

    public String generateTicket(User user,Boolean high_priority,Boolean is_public,String mainCategory,String subCategory) throws IOException {

        OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse(url)
                .newBuilder();

        ObjectMapper objectMapper = new ObjectMapper();
        Ticket ticket = new Ticket();
        Comment comment = new Comment();
        comment.setBody("this is a test ticket");
        ticket.setSubject("Hello Zendesk");
        ticket.setComment(comment);
        Requester requester = new Requester();
        requester.setEmail(user.getEmail());
        requester.setName(user.getName()+" "+user.getSurName());
        requester.setLocale_id(Long.toString(user.getId()));
        requester.setPhone(user.getPhoneNumber());
        ticket.setRequester(requester);
        List<CustomField> customFields = new ArrayList<CustomField>();
        customFields.add(new CustomField(1, Arrays.asList(mainCategory, subCategory)));

        ticket.setCustomFields(customFields);
        ticket.setIs_public(high_priority);
        ticket.setIs_public(is_public);
        String json = objectMapper.writeValueAsString(Collections.singletonMap("ticket", ticket));
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), json);

        Request request = new Request.Builder()
                .url(urlBuilder.build())
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", Credentials.basic(email, password))
                .build();
        Response response = client.newCall(request).execute();
        if (response.code() == HttpStatus.CREATED.value()){
             return "SUCCESS....";

        }
             else {

            return "Error....";

        }

    }}
        

