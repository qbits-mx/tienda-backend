package mx.qbits.tienda.api.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.qbits.tienda.api.mapper.GenteMapper;
import mx.qbits.tienda.api.model.domain.Gente;
import mx.qbits.tienda.api.model.exceptions.BusinessException;

@Service
public class GenteServiceImpl implements GenteService {

    private GenteMapper mapper;

    public GenteServiceImpl(GenteMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public int salvaDatos(int id, String correo, String clave) throws BusinessException {
        try {
            Gente result = mapper.getById(id);
            if(result==null) {
                mapper.insert(correo, clave);
            } else {
                mapper.update(new Gente(id, correo, clave, 0));
            }
            return 1;
        } catch(SQLException e) {
            throw new BusinessException(e);
        }
    }

    @Override
    public List<Gente> dameDatos() throws BusinessException {
        try {
            ok();
            return mapper.getNonBlockedUsers();
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
    }

    private void ok() {
        RestTemplate restTemplate = new RestTemplate();

        String q = "{'columnas':[['','COBROS','PAGOS','TOTAL']],'filas':[['TRASPASO DE EFECTIVO','','',''],['T.SIAC','22,000,000,000.00','9,954,334,144.75','3.00'],['T.SPEI','34,300,000,000.00','40,416,813,425.00','11.00'],['T.INTERM','131.19','1,963,110.87','-28.00'],['','','','5,926,889,450.57'],['PAPEL BANCARIO','','',''],['INTERÉS/CUPON BONOS','1,147,547,629.46','4,017,047,475.92',null],['VTO. PAPEL BANCARIO (RTO.)','3,650,466,054.67','3,498,920,213.49',null],['VTO. I. BANSAN','3,999,999,999.43','0.00',null],['','','',''],['COMPRA VENTA PB','10,126,410,024.22','11,738,848,035.73',null],['TOTAL DE PAPEL BANCARIO','18,924,423,707.78','19,254,815,725.14','-330,392,017.36'],['','','',''],['PAPEL GUBERNAMENTAL','','',null],['VTO. GUBERNAMENTAL','106,450,480,777.46','88,482,838,882.23',null],['DERECHOS','0.00','0.00',null],['','','',''],['COMPRA VENTA PG','83,160,407,864.62','107,084,728,863.09',null],['TOTAL RSP','40,416,813,425.00','40,416,813,425.00',null],['TOTAL DE GUBERNAMENTAL','230,027,702,067.08','235,984,381,170.32','-330,392,017.36'],['','','',''],['TOTAL BANCARIO Y GUBER.','248,952,125,774.86','255,239,196,895.46','-6,287,071,120.60'],['TOTAL MER. DE CAPITALES','1,581,821,808.00','1,221,639,496.34',null],['GRAN TOTAL','-6,287,071,120.60','5,926,889,450.57',null],['','','SALDO DALI','-12,213,960,571.17']],'identificador':0}";
//        String p = q.replace('\'', '\"');
        String url = "http://localhost:8080/reportes/generales";
//
//
//        HttpEntity<Gente> request = new HttpEntity<>(new Gente());
//        String foo = restTemplate.postForObject(url, request, String.class);

        //String url2 = "https://api.binance.com/api/v1/ticker/24hr?symbol=ETHUSDT";
        //String s = restTemplate.getForObject(url2, String.class);

        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "curl");
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(q.replace('\'', '\"'), headers);

        //String s = restTemplate.postForObject(url, entity, String.class);

        ResponseEntity<String> s = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        System.out.println(s.getBody());
    }

}