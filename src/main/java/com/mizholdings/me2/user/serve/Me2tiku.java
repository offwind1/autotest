package com.mizholdings.me2.user.serve;

import com.mizholdings.me2.agent.me2tiku.Me2tikuAgent;
import com.mizholdings.util.User;

public class Me2tiku extends ServeBase {
    public Me2tiku(User user) {
        super(user);
    }

    public Me2tikuAgent me2tikuAgent() {
        return (Me2tikuAgent) getAgent("me2tikuAgent");
    }

}
