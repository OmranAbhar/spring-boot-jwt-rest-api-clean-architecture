package com.clean.app.application.publics.queries.handlers;

import com.clean.app.application.publics.models.SigninModel;
import com.clean.app.application.publics.models.UersModel;
import com.clean.app.application.publics.queries.SigninUserQuery;
import com.clean.app.common.jwt.util.JwtUtil;
import com.clean.app.common.mediator.core.IRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class SinginUserQueryHandler implements IRequestHandler<SigninUserQuery, SigninModel> {
    private JwtUtil jwtUtil;
    private AuthenticationManager authenticationManager;

    @Autowired
    public SinginUserQueryHandler(JwtUtil jwtUtil,AuthenticationManager authenticationManager) {
        this.jwtUtil=jwtUtil;
        this.authenticationManager=authenticationManager;
    }

    @Override
    public SigninModel handle(SigninUserQuery request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(),  request.getPassword())
            );
        } catch (Exception ex) {
            throw new RuntimeException("inavalid username/password");
        }
        SigninModel result=new SigninModel();
        result.setToken(jwtUtil.generateToken(request.getEmail()));
        result.setUserName(request.getEmail());
        return result;
    }

}
