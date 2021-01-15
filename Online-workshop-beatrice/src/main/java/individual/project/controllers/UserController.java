package individual.project.controllers;

import individual.project.model.User;
import individual.project.repository.HibernateUsersRepository;
import individual.project.repository.IUsersRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import static java.lang.Integer.parseInt;

public class UserController {
    IUsersRepository usersRepository;

    public UserController(IUsersRepository iUsersRepository){
        this.usersRepository = iUsersRepository;
    }

    public List<User> showAllUsers() {
      List<User> items;
        try {
            items = usersRepository.getUsers();
           return items;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
      return null;
    }
   public boolean addUser(User u) {
        try {
            if(getUserByEmail(u.getEmail()) == null){
                String newPassword = doHashing(u.getPassword());
                u.setPassword(newPassword);
                usersRepository.create(u);
                System.out.println("Created user: " + u);
                return true;
            }else{
                return false;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public boolean updateUser(User u) {
        try {
            usersRepository.update(u);
            System.out.println("Updated user: " + u);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public boolean updatePassword(User u) {
        try {
            String newPassword = doHashing(u.getPassword());
            u.setPassword(newPassword);
            usersRepository.update(u);
            System.out.println("Updated user: " + u);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public User getUserById(int id) {
        try {
           User u = usersRepository.getUserById(id);
            return u;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public User getUserByEmail(String email) {
        List<User> users = showAllUsers();
        for (User u :users) {
            if(u.getEmail().equals(email)){
                return u;
            }
        }
        return null;
    }
    public boolean deleteUser(int id) {
        try {
            usersRepository.delete(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public User getUserFromToken(String token) {
        Claims decoded = decodeJWT(token);

        String id = decoded.getId();

        User u = getUserById(parseInt(id));

        return u;
    }
    public boolean login(String email, String password){
        User u = getUserByEmail(email);
        if(u.equals(null)){
            return false;
        }
        String encryptedPass = doHashing(password);
        if(u.getPassword().equals(encryptedPass)){
            return true;
        }
        return false;
    }

    public boolean validateUser(String id, String role){
        User u = getUserById(parseInt(id));
        if(u.equals(null)){
            return false;
        }

            if(u.getRole().toString().equals(role)){
                return true;
            }else{
                return false;
            }


    }

    public String doHashing(String password){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());

          byte[] result=  md.digest();
            StringBuilder sb = new StringBuilder();

            for (byte b : result) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    private static String SECRET_KEY = "oeRaYY7Wo24sDqKSX";

    //Sample method to construct a JWT
    public String createJWT(String id, String issuer, String subject, long ttlMillis) {

        //The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //We will sign our JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder().setId(id)
                .setIssuedAt(now)
                .setSubject(subject)
                .setIssuer(issuer)
                .signWith(signatureAlgorithm, signingKey);

        //if it has been specified, let's add the expiration
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        //Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();
    }
    public Claims decodeJWT(String jwt) {

        //This line will throw an exception if it is not a signed JWS (as expected)
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
                .parseClaimsJws(jwt).getBody();
        return claims;
    }

}
