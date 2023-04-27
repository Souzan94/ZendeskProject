package com.system.ZenDesk.Widget.model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Component
public class CreateCampaignRequest {

    private String key;
    private String call_type;

    private String name;
    private String date_range_begin;
    private String date_range_end;
    private String time_range_begin;
    private  String time_range_end;
    private List<Integer> active_days;
    private  int max_thread_count;
    private int ring_timeout;
    private  String cli;
    private int welcome_announcement_id;
    private int call_retries;
    private  String webhook_url;
    private String digit_target_0;
    private String digit_target_1;
    private String digit_target_2;
    private String digit_target_3;
    private String digit_target_4;
    private String digit_target_5;
    private String digit_target_6;
    private String digit_target_7;
    private String digit_target_8;
    private String digit_target_9;
    private String digit_target_star;
    private String digit_target_square;
    private String timeout_target;
    private String invalid_target;
    private  int digit_retries;
    private  int digit_timeout;
    private  boolean is_commercial;
    private List<PhoneListItem> phone_list;


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCall_type() {
        return call_type;
    }

    public void setCall_type(String call_type) {
        this.call_type = call_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate_range_begin() {
        return date_range_begin;
    }

    public void setDate_range_begin(String date_range_begin) {
        this.date_range_begin = date_range_begin;
    }

    public String getDate_range_end() {
        return date_range_end;
    }

    public void setDate_range_end(String date_range_end) {
        this.date_range_end = date_range_end;
    }

    public String getTime_range_begin() {
        return time_range_begin;
    }

    public void setTime_range_begin(String time_range_begin) {
        this.time_range_begin = time_range_begin;
    }

    public String getTime_range_end() {
        return time_range_end;
    }

    public void setTime_range_end(String time_range_end) {
        this.time_range_end = time_range_end;
    }

    public List<Integer> getActive_days() {
        return active_days;
    }

    public void setActive_days(List<Integer> active_days) {
        this.active_days = active_days;
    }

    public int getMax_thread_count() {
        return max_thread_count;
    }

    public void setMax_thread_count(int max_thread_count) {
        this.max_thread_count = max_thread_count;
    }

    public int getRing_timeout() {
        return ring_timeout;
    }

    public void setRing_timeout(int ring_timeout) {
        this.ring_timeout = ring_timeout;
    }

    public String getCli() {
        return cli;
    }

    public void setCli(String cli) {
        this.cli = cli;
    }

    public int getWelcome_announcement_id() {
        return welcome_announcement_id;
    }

    public void setWelcome_announcement_id(int welcome_announcement_id) {
        this.welcome_announcement_id = welcome_announcement_id;
    }

    public int getCall_retries() {
        return call_retries;
    }

    public void setCall_retries(int call_retries) {
        this.call_retries = call_retries;
    }

    public String getWebhook_url() {
        return webhook_url;
    }

    public void setWebhook_url(String webhook_url) {
        this.webhook_url = webhook_url;
    }

    public String getDigit_target_0() {
        return digit_target_0;
    }

    public void setDigit_target_0(String digit_target_0) {
        this.digit_target_0 = digit_target_0;
    }

    public String getDigit_target_1() {
        return digit_target_1;
    }

    public void setDigit_target_1(String digit_target_1) {
        this.digit_target_1 = digit_target_1;
    }

    public String getDigit_target_2() {
        return digit_target_2;
    }

    public void setDigit_target_2(String digit_target_2) {
        this.digit_target_2 = digit_target_2;
    }

    public String getDigit_target_3() {
        return digit_target_3;
    }

    public void setDigit_target_3(String digit_target_3) {
        this.digit_target_3 = digit_target_3;
    }

    public String getDigit_target_4() {
        return digit_target_4;
    }

    public void setDigit_target_4(String digit_target_4) {
        this.digit_target_4 = digit_target_4;
    }

    public String getDigit_target_5() {
        return digit_target_5;
    }

    public void setDigit_target_5(String digit_target_5) {
        this.digit_target_5 = digit_target_5;
    }

    public String getDigit_target_6() {
        return digit_target_6;
    }

    public void setDigit_target_6(String digit_target_6) {
        this.digit_target_6 = digit_target_6;
    }

    public String getDigit_target_7() {
        return digit_target_7;
    }

    public void setDigit_target_7(String digit_target_7) {
        this.digit_target_7 = digit_target_7;
    }

    public String getDigit_target_8() {
        return digit_target_8;
    }

    public void setDigit_target_8(String digit_target_8) {
        this.digit_target_8 = digit_target_8;
    }

    public String getDigit_target_9() {
        return digit_target_9;
    }

    public void setDigit_target_9(String digit_target_9) {
        this.digit_target_9 = digit_target_9;
    }

    public String getDigit_target_star() {
        return digit_target_star;
    }

    public void setDigit_target_star(String digit_target_star) {
        this.digit_target_star = digit_target_star;
    }

    public String getDigit_target_square() {
        return digit_target_square;
    }

    public void setDigit_target_square(String digit_target_square) {
        this.digit_target_square = digit_target_square;
    }

    public String getTimeout_target() {
        return timeout_target;
    }

    public void setTimeout_target(String timeout_target) {
        this.timeout_target = timeout_target;
    }

    public String getInvalid_target() {
        return invalid_target;
    }

    public void setInvalid_target(String invalid_target) {
        this.invalid_target = invalid_target;
    }

    public int getDigit_retries() {
        return digit_retries;
    }

    public void setDigit_retries(int digit_retries) {
        this.digit_retries = digit_retries;
    }

    public int getDigit_timeout() {
        return digit_timeout;
    }

    public void setDigit_timeout(int digit_timeout) {
        this.digit_timeout = digit_timeout;
    }

    public boolean isIs_commercial() {
        return is_commercial;
    }

    public void setIs_commercial(boolean is_commercial) {
        this.is_commercial = is_commercial;
    }

    public List<PhoneListItem> getPhone_list() {
        return phone_list;
    }

    public void setPhone_list(List<PhoneListItem> phone_list) {
        this.phone_list = phone_list;
    }
}
