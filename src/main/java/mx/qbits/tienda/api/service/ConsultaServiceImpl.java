package mx.qbits.tienda.api.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import mx.qbits.tienda.api.mapper.ConsultaMapper;
import mx.qbits.tienda.api.model.domain.InfoVenta;
import mx.qbits.tienda.api.model.domain.InfoCompra;
import mx.qbits.tienda.api.model.exceptions.BusinessException;

@Service
public class ConsultaServiceImpl implements ConsultaService {

	private ConsultaMapper mapper;
	
	public ConsultaServiceImpl(ConsultaMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public InfoVenta consultaAnuncioVendido(int idAnuncio) throws BusinessException {
		try {
            InfoVenta consulta = mapper.consultaAnuncioVendido(idAnuncio);
            return consulta;
        } catch(SQLException e) {
            throw new BusinessException(e);
        }
	}

}
