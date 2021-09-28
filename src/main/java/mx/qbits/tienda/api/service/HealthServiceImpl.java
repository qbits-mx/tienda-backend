/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     mx.qbits.tienda.api.service
 * Proyecto:    tienda
 * Tipo:        Clase
 * Nombre:      HealthServiceImpl
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:46:17
 */
package mx.qbits.tienda.api.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

/**
 * Clase utilitaria que reporta la resultante de la ejecución de un comando de
 * sistema operativo y retorna el número de linease del log que se le solicita.
 *
 * @author garellano
 *
 */
@Service
@PropertySource("classpath:c3p0.properties")
@EnableEncryptableProperties
public class HealthServiceImpl implements HealthService {
    /**
     * slf4j logger.
     * Why private+static+final? See:
     * https://stackoverflow.com/questions/6653520/why-do-we-declare-loggers-static-final
     * Why logger instead LOGGER? The logger reference is not a constant, but a final reference,
     * and should NOT be in uppercase. A constant VALUE should be in uppercase.
     * Also, for this interesting damed shit, See:
     * https://stackoverflow.com/questions/1417190/should-a-static-final-logger-be-declared-in-upper-case
     */
    private static final Logger logger = LoggerFactory.getLogger(HealthServiceImpl.class);

    /** System environment property. */
    private Environment environment;

    @Value("${logging.file.name}")
    private String logfile;

    /**
     * Constructor que ayuda a no tener la propiedad "environment" como Autowired.
     *
     * @param environment Propiedad environment
     */
    public HealthServiceImpl(Environment environment) {
        this.environment = environment;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, String> getInfo(String data) throws IOException {
        Map<String, String> info = new HashMap<>();
        info.put("info.data", "execute");

        info.put("data.received", data);

        Process process = Runtime.getRuntime().exec("/bin/bash -c " + data);
        BufferedReader inStream = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line = "";
        while ((line = inStream.readLine()) != null) {
            sb.append(line);
            sb.append("\n");
        }
        logger.info("Resulting ouput for {}: {} {}", data, sb, "\n[end block]\n");
        info.put("resp: ", sb.toString());

        if (environment != null) {
            info.put("server.port.1", environment.getProperty("server.port", "8080"));
            info.put("server.port.2", environment.getProperty("local.server.port", "8080"));
        }

        info.put("local.address.1", InetAddress.getLocalHost().getHostAddress());
        info.put("local.address.2", InetAddress.getLocalHost().getHostName());

        info.put("remote.address.1", InetAddress.getLoopbackAddress().getHostAddress());
        info.put("remote.address.2", InetAddress.getLoopbackAddress().getHostName());

        long time = System.currentTimeMillis();
        info.put("time.millis", time + "");

        Date date = new Date(time);
        info.put("date.time", date.toString());
        // get url
        // is https?
        info.put("log.location:", logfile);

        String[] actPro = System.getProperty("spring-boot.run.profiles","").split(",");
        for (int i = 0; i < actPro.length; i++) {
            info.put("perfil_" + i, actPro[i]);
        }

        if (actPro.length > 0) {
            info.put("activeProfile", actPro[0]);
        }

        String buildVersion = "1.0-SNAPSHOT"; // PROJECT_VERSION
        String projectName = "Tienda"; // PROJECT_NAME

        info.put("build.version", buildVersion);
        info.put("project.name", projectName);
        info.put("project.id", projectName + "_" + buildVersion);

        return info;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getLog(int last) {
        List<String> lista = new ArrayList<>();
        try {
            List<String> allLines = Files.readAllLines(Paths.get(logfile));
            int len = allLines.size();
            if (last < 1) {
                return allLines;
            }
            for (int i = max(0, len - last); i < len; i++) {
                lista.add(allLines.get(i));
            }
            return lista;
        } catch (IOException e) {
            lista.add(e.getMessage());
            return lista;
        }
    }
    public int max(int a, int b) {
        if(a>b) return a;
        return b;
    }
}
