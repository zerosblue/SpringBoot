package com.example.selfstudy.dto;


import com.example.selfstudy.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@AllArgsConstructor
@ToString
public class MemberForm {
    private String email;
    private String password;

    public  Member toEntity() {
        return new Member( null, email, password);
    }
}
