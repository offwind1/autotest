package com.mizholdings.me2.user.serve;

import com.mizholdings.me2.agent.app.*;
import com.mizholdings.me2.agent.web.AdvertAgent;
import com.mizholdings.util.User;

public class Manage extends ServeBase {

    private AdvertAgent advertAgent;

    public Manage(User user) {
        super(user);
    }

    public AdvertAgent advertAgent() {
        return (AdvertAgent) getAgent("advertAgent");
    }
}
