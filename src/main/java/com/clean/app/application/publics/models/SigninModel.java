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
public class SigninModel {
    String userName;
    String token;
}