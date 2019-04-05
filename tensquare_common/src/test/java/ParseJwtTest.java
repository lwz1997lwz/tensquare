import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

/**
 * @program: tensquare_parent
 * @description:
 * @author: Linweizhe
 * @create: 2019-03-01 16:24
 **/
public class ParseJwtTest {
    public static void main(String[] args) {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiLlsI_nmb0iLCJpYXQiOjE1NTE0MjkwNDgsImV4cCI6MTU1MTQyOTEwOH0.wukPju91W3QLHA3-cWmEtTi6thBgiQR6Sw6YhaBuuoA";
        Claims claims = Jwts.parser().setSigningKey("itcast").parseClaimsJws(token).getBody();
        System.out.println(claims.getId());
        System.out.println(claims.getSubject());

    }
}
