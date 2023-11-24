package com.hammadmansoor.i200929;

import java.util.UUID;

public class UniqueUserIdGenerator {

    public int generateID(){
        int random = (int) (Math.random() * 400 + 1 % 4);
     return random;

    }
}
