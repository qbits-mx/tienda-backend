package mx.qbits.tienda.api.support;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import static mx.qbits.tienda.api.model.enumerations.EnumMessage.GOOGLE_CAPTCHA;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.model.exceptions.CustomException;
import mx.qbits.tienda.api.model.request.GoogleCaptcha;

@Service
public class RecaptchaServiceImpl implements RecaptchaService {
    private RestTemplate restTemplate;
    
    @Value("${google_recaptcha_url}")
    private String googleRecaptchaUrl;
    
    @Value("${google.recaptcha.secret}")
    private String googleRecaptchaSecret;
    
    public RecaptchaServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    /** {@inheritDoc} */
    @Override
    public String checkCaptcha(GoogleCaptcha googleCaptcha) throws BusinessException {
        try {
            return genericRecaptchaChecker(
                    googleRecaptchaUrl,
                    googleRecaptchaSecret,
                    googleCaptcha.getResponse());
        } catch (RestClientException e) {
            throw new CustomException(GOOGLE_CAPTCHA);
        }
    }
    
    private String genericRecaptchaChecker(String url, String secret, String response) {
        StringBuilder redirectUrl = new StringBuilder();
        redirectUrl.append(url);
        redirectUrl.append("?secret=");
        redirectUrl.append(secret);
        redirectUrl.append("&response=");
        redirectUrl.append(response);
        redirectUrl.append("&remoteip=127.0.0.1");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded");
        String body = ""; // No recibe nada en su body... lo manda como parámetros en el smsUrl
        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        return restTemplate.postForObject(redirectUrl.toString(), entity, String.class);
    }
}
