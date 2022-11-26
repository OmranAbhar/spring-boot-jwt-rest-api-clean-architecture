package com.clean.app.common.jwt.controller;
//import org.jasypt.util.text.AES256TextEncryptor;
import com.clean.app.application.publics.commonds.UsersCommand;
import com.clean.app.application.publics.queries.SigninUserQuery;
import com.clean.app.common.GeneralResponse;
import com.clean.app.common.base.MediatorController;
import com.clean.app.common.mediator.core.IMediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController extends MediatorController {
    @Autowired
    public AuthController(IMediator mediators) {
        this.mediator = mediators;
    }

    @PostMapping("/signin")
    public GeneralResponse generateToken(@RequestBody SigninUserQuery query) throws Exception {
        return this.DispatchRequest(query);
    }

    @PostMapping("/add-user")
    public GeneralResponse insertUser(@RequestBody UsersCommand command)
    {
        return this.DispatchRequest(command);
    }
}
