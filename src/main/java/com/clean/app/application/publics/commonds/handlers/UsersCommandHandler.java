package com.clean.app.application.publics.commonds.handlers;


import com.clean.app.application.publics.commonds.UsersCommand;
import com.clean.app.application.publics.models.UersModel;
import com.clean.app.common.encryption.Encryption;
import com.clean.app.common.jwt.entity.User;
import com.clean.app.common.jwt.repository.UserRepository;
import com.clean.app.common.mediator.core.IRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;

public class UsersCommandHandler implements IRequestHandler<UsersCommand, UersModel> {
    private UserRepository userRepository;

    @Autowired
    public UsersCommandHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UersModel handle(UsersCommand request) {
        User record = null;
        if (request.getId() != null) {
            record = userRepository.findById(request.getId()).get();
        } else {
            record = new User();
        }
        try {
            record.setUserName(request.getUsername());
            record.setPassword(Encryption.EncryptPassword(request.getEmail(), request.getPassword()));
            record.setEmail(request.getEmail());
            userRepository.save(record);
            return UersModel.Map(record);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}