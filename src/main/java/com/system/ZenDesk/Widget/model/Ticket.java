package com.system.ZenDesk.Widget.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Component
public class Ticket {

    @Autowired
    private Comment comment;
    private String subject;
    private Boolean high_priority;
    private Boolean is_public;
    @Autowired
    private Requester requester;
    @Autowired
    private List<CustomField> customFields;

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Requester getRequester() {
        return requester;
    }

    public void setRequester(Requester requester) {
        this.requester = requester;
    }

    public List<CustomField> getCustomFields() {
        return customFields;
    }

    public void setCustomFields(List<CustomField> customFields) {
        this.customFields = customFields;
    }

    public Boolean getHigh_priority() {
        return high_priority;
    }

    public void setHigh_priority(Boolean high_priority) {
        this.high_priority = high_priority;
    }

    public Boolean getIs_public() {
        return is_public;
    }

    public void setIs_public(Boolean is_public) {
        this.is_public = is_public;
    }
}
