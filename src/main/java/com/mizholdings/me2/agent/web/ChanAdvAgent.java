package com.mizholdings.me2.agent.web;

import com.mizholdings.me2.interfaces.mizhumanage.ChanadvInterface;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.Requests;
import com.mizholdings.util.User;

public class ChanAdvAgent extends MODBase<ChanAdvAgent> {


    public static ChanadvInterface chanadvInterface = Requests.getService(ChanadvInterface.class);

    public ChanAdvAgent(User executor) {
        super(executor);
        interfaced = chanadvInterface;
    }

}
