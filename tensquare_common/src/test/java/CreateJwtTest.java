import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.io.PrintStream;
import java.util.Date;

/**
 * @program: tensquare_parent
 * @description: 用于测试JWT
 * @author: Linweizhe
 * @create: 2019-03-01 16:16
 **/
public class CreateJwtTest {
    private PrintStream out;

    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        long exp = now + 1000 * 60;
        JwtBuilder builder= Jwts.builder().setId("888")
                .setSubject("小白")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"itcast")
           .setExpiration(new Date(exp));
        System.out.println( builder.compact() );
    }

}
