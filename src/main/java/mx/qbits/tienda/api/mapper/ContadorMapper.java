/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo cualquier criterio, el único dueño de la totalidad de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     mx.qbits.tienda.api.mapper
 * Proyecto:    tienda
 * Tipo:        Interface
 * Nombre:      ContadorMapper
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:05:25
 */
package mx.qbits.tienda.api.mapper;

import java.sql.SQLException;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>Descripción:</p>
 * Interface 'Mapper' MyBatis asociado a la entidad 'Contador'.
 *
 * @author  luz
 * @see     mx.qbits.tienda.api.model.domain.Usuario
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
@Repository
public interface ContadorMapper {
    /**
     * <p>getTableCount.</p>
     *
     * @param databaseName a {@link java.lang.String} object.
     * @param tableName a {@link java.lang.String} object.
     * @return a int.
     * @throws java.sql.SQLException if any.
     */
    @Select("SELECT table_rows FROM information_schema.tables WHERE table_schema = #{databaseName} AND table_name = #{tableName}")
    int getTableCount(String databaseName, String tableName) throws SQLException;

}
