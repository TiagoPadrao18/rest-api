package com.mindera.users.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Setter
@Getter
public class User {

    private Long id;
    private String name;
    private String password;

    @Override
    public String toString() {
        return
                 id +"," + name + ","+
                password ;

    }
}
