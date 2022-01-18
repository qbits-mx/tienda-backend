package mx.qbits.tienda.api.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import mx.qbits.tienda.api.mapper.InformacionAnuncioMapper;
import mx.qbits.tienda.api.mapper.UsuarioDetalleMapper;
import mx.qbits.tienda.api.mapper.UsuarioMapper;
import mx.qbits.tienda.api.model.domain.InformacionAnuncio;
import mx.qbits.tienda.api.model.domain.InformacionMultimedia;
import mx.qbits.tienda.api.model.domain.Usuario;
import mx.qbits.tienda.api.model.domain.UsuarioDetalle;
import mx.qbits.tienda.api.model.enumerations.EnumMessage;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.model.exceptions.CustomException;
import mx.qbits.tienda.api.support.MailSenderService;

@Service
public class InformacionAnuncioServiceImpl implements InformacionAnuncioService {

	private InformacionAnuncioMapper aMapper;
	private UsuarioMapper uMapper;
	private UsuarioDetalleMapper uDMapper;
	private MailSenderService mailSenderService;
	
	/**
	 * Constructor basado en todos los atributos de la clase.
	 * 
	 * @param aMapper 
	 * @param uMapper
	 * @param uDMapper
	 * @param mailSenderService
	 */
	public InformacionAnuncioServiceImpl(InformacionAnuncioMapper aMapper, UsuarioMapper uMapper,
			UsuarioDetalleMapper uDMapper, MailSenderService mailSenderService) {
		this.aMapper = aMapper;
		this.uMapper = uMapper;
		this.uDMapper = uDMapper;
		this.mailSenderService = mailSenderService;
	}
	
	/** {@inheritDoc} */
	@Override
	public InformacionAnuncio getAnuncio(int id) throws BusinessException {
		try {
			return aMapper.getById(id);
		} catch (SQLException e) {
			throw new BusinessException(e);
		}
	}

	/** {@inheritDoc} */
	@Override
	public int actualizaValidado(int id, boolean validado) throws BusinessException {
		try {
			return aMapper.updateValidado(id, validado);
		} catch (SQLException e) {
			throw new BusinessException(e);
		}
	}

	/** {@inheritDoc} */
	@Override
	public int actualizaNotificado(int id, boolean notificado, String mensaje) throws BusinessException {
		try {
			InformacionAnuncio anuncio = getAnuncio(id);
			if (anuncio == null) {
				String formato = String.format("Anuncio con identificador: %d", id);
				throw new CustomException(EnumMessage.NOT_FOUND, formato);
			}
			if (anuncio.isNotificado() || anuncio.isValidado()) {
				String formato = String.format("Anuncio con identificador: %d", id);
				throw new CustomException(EnumMessage.NOT_FOUND, formato);
			}
			Usuario usuario = uMapper.getById(anuncio.getIdUsuario());
			if (usuario == null) {
				String formato = String.format("Usuario con identificador: %d", anuncio.getIdUsuario());
				throw new CustomException(EnumMessage.NOT_FOUND, formato);
			}
			UsuarioDetalle detalleU = uDMapper.getById(anuncio.getIdUsuario());
			if (detalleU == null) {
				String formato = String.format("Informacion del Usuario con identificador: %d", anuncio.getIdUsuario());
				throw new CustomException(EnumMessage.NOT_FOUND, formato);
			}
			String body = String.format("<h1>Hola %s. Tu anuncio sobre %s, no cumple las normas por: %s. Favor de revisarlo</h1>", detalleU.getNickName(), anuncio.getDescripcion(), mensaje);
			String enviado = mailSenderService.sendHtmlMail(usuario.getCorreo(), "Super Tienda: Anuncio Rechazado", body);
			if (!enviado.equals("succeed")) {
				String formato = String.format("No se pudo enviar correo a %s", usuario.getCorreo());
				throw new CustomException(EnumMessage.SEND_MAIL, formato);
			}
			return aMapper.updateNotificado(id, notificado);
		} catch (CustomException e) {
			throw e;
		} catch (SQLException e) {
			throw new BusinessException(e);
		}
	}

	/** {@inheritDoc} */
	@Override
	public List<InformacionMultimedia> dameMultimedias(int id) throws BusinessException {
		try {
            return aMapper.getAllMultimediaByIdAnuncio(id);
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
	}
}
