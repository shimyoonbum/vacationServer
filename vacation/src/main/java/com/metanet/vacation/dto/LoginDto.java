package com.metanet.vacation.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

   @NotNull
   @Size(min = 4, max = 50)
   private String username;

   @NotNull
   @Size(min = 4, max = 100)
   private String password;
}