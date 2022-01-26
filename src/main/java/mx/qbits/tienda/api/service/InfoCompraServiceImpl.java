package mx.qbits.tienda.api.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import mx.qbits.tienda.api.mapper.InfoCompraMapper;
import mx.qbits.tienda.api.model.domain.InfoCompra;
import mx.qbits.tienda.api.model.exceptions.BusinessException;

@Service
public class InfoCompraServiceImpl implements InfoCompraService {
	
	private InfoCompraMapper mapper;
	
	public InfoCompraServiceImpl(InfoCompraMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public InfoCompra consultaAnuncioComprado(int idAnuncio) throws BusinessException {
		try {
            InfoCompra consulta = mapper.consultaAnuncioComprado(idAnuncio);
            return consulta;
        } catch(SQLException e) {
            throw new BusinessException(e);
        }
	}

}
