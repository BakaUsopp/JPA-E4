package org.example.entities.generators;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.security.*;
import java.util.Base64;
import java.util.UUID;

public class UUIDGenerator implements IdentifierGenerator {

    @Override
    public Object generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) {
        return sign(UUID.randomUUID().toString());
    }

    public String sign(String primary){
        try {
            KeyPairGenerator pair =  KeyPairGenerator.getInstance("RSA");
            pair.initialize(2048);

            KeyPair kp = pair.generateKeyPair();
            PrivateKey pk =kp.getPrivate();
            Signature sg = Signature.getInstance("SHA256withRSA");
            sg.initSign(pk);
            sg.update(primary.getBytes());
            byte[] result = sg.sign();
            return primary +"."+ Base64.getEncoder().encodeToString(result);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
