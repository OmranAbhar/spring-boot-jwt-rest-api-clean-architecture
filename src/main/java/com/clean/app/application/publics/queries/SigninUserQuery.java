package com.clean.app.application.publics.queries;

import com.clean.app.application.publics.models.SigninModel;
import com.clean.app.application.publics.models.UersModel;
import com.clean.app.common.mediator.core.IRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SigninUserQuery implements IRequest<SigninModel> {
    private String password;
    private String email;
}
