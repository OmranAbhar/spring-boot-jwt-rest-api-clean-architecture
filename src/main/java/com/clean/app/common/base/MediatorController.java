package com.clean.app.common.base;

import com.clean.app.common.mediator.core.IMediator;
import com.clean.app.common.mediator.core.IRequest;
import com.clean.app.common.GeneralResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class MediatorController {
    protected IMediator mediator;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public GeneralResponse DispatchRequest(IRequest<?> request){
        GeneralResponse gr = new GeneralResponse();
        try{
            gr.data = mediator.send(request);
            gr.successful = true;
        }
        catch (Exception ex){
            gr.successful =false;
            gr.error = ex.getMessage();
            logger.error("Exception Handling Command : ",ex);
        }
        return gr;
    }
}
