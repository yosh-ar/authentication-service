package com.example.Service_auth.commons.dtos;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @NotNull
    private String email;
    @NotNull
    private String password;


}
