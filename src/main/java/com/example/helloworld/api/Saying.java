package com.example.helloworld.api;
/* POJO for the standard: RFC 1149 
 * {
 * "id": 1,
 * "content": "Hi!"
 * }
 * */
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class Saying {
	/*JavaBeans standard for the id and content properties*/
    private long id;
    @Length(max = 3)
    private String content;

    public Saying() {
        // Jackson deserialization
    }

    public Saying(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}