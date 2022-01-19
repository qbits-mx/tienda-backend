package mx.qbits.tienda.api.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import mx.qbits.tienda.api.mapper.ConsultaMapper;
import mx.qbits.tienda.api.model.domain.Anuncio;
import mx.qbits.tienda.api.model.domain.InfoCompraVenta;
import mx.qbits.tienda.api.model.exceptions.BusinessException;

@Service
public class ConsultaServiceImpl implements ConsultaService {

	private ConsultaMapper mapper;
	
	public ConsultaServiceImpl(ConsultaMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public InfoCompraVenta consultaAnuncioVendido(int idAnuncio) throws BusinessException {
		try {
            InfoCompraVenta consulta = mapper.consultaAnuncioVendido(idAnuncio);
            return consulta;
        } catch(SQLException e) {
            throw new BusinessException(e);
        }
	}

	@Override
	public InfoCompraVenta consultaAnuncioComprado(int idAnuncio) throws BusinessException {
		try {
            InfoCompraVenta consulta = mapper.consultaAnuncioComprado(idAnuncio);
            return consulta;
        } catch(SQLException e) {
            throw new BusinessException(e);
        }
	}
}
