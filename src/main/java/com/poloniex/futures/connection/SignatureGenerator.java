package com.poloniex.futures.connection;

import com.poloniex.futures.constant.APIConstants;
import com.poloniex.futures.exception.SDKException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * Generator for signatures to authenticate Rest and websocket calls
 */
public class SignatureGenerator {
    /**
     * Generate signature string.
     *
     * @param secret  the account's API key secret
     * @param payload the payload to encrypt
     * @return signature
     */
    public static String generateSignature(String secret, String payload) {
        Mac hmacSha256;
        try {
            hmacSha256 = Mac.getInstance(APIConstants.SIGNATURE_METHOD_VALUE);
            SecretKeySpec secKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), APIConstants.SIGNATURE_METHOD_VALUE);
            hmacSha256.init(secKey);
        } catch (NoSuchAlgorithmException e) {
            throw new SDKException(SDKException.ENV_ERROR, "No such algorithm: " + e.getMessage());
        } catch (InvalidKeyException e) {
            throw new SDKException(SDKException.KEY_MISSING, "Invalid key: " + e.getMessage());
        }
        byte[] hash = hmacSha256.doFinal(payload.getBytes(StandardCharsets.UTF_8));

        return Base64.getEncoder().encodeToString(hash);
    }
}
