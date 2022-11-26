package com.clean.app.application.publics.models;//model=GeneralLedger

import com.clean.app.common.jwt.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UersModel {
      int id;
     String userName;
     String password;
     String email;


    public static UersModel Map(User entity) {
        return UersModel.builder()
                .id(entity.getId())
                .userName(entity.getUserName())
                .password(entity.getPassword())
                .email(entity.getEmail())
                .build();
    }
}