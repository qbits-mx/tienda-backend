package mx.qbits.tienda.api.service;

import mx.qbits.tienda.api.model.domain.Anuncio;

public interface AnuncioService{
    int salvaAnuncio(Anuncio anuncio) throws Exception;
}