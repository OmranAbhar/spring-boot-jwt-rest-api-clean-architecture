package com.clean.app.application.publics.commonds;//model=GeneralLedger


import com.clean.app.common.mediator.core.IRequest;
import com.clean.app.application.publics.models.UersModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersCommand implements IRequest<UersModel> {
    Integer id;
    String username;
    String password;
    String email;
}