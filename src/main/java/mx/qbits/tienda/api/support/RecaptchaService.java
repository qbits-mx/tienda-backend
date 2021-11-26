package mx.qbits.tienda.api.support;

import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.model.request.GoogleCaptcha;

public interface RecaptchaService {
    String checkCaptcha(GoogleCaptcha googleCaptcha) throws BusinessException;
}
