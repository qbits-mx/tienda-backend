package mx.qbits.tienda.api.model;

import mx.qbits.tienda.api.utils.DigestEncoder;
import org.junit.Test;

public class TestDigestEncoder {
    @Test
    public void test() {
        String de = DigestEncoder.digest("gustavo", "extra");
        System.out.println(de);
        assert("45bc501a73daf744877226e1163fee7ff562ca85b027bada517ae367a20efda8".equals(de));
        // echo -n "gustavoaxtra" | shasum -a 256
    }
}
