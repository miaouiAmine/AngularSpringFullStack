package com.grokonez.jwtauthentication.Servicess;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.grokonez.jwtauthentication.model.*;
import com.grokonez.jwtauthentication.repository.GiftCodeRepository;
import com.grokonez.jwtauthentication.repository.PortMonnaisRepository;
import com.grokonez.jwtauthentication.repository.UserRepository;
import com.grokonez.jwtauthentication.repository.utilisationRepository;
import jdk.nashorn.internal.parser.JSONParser;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;


@Service
public class GiftCodeService {


    @Autowired
    private GiftCodeRepository GCR;

    @Autowired
    private UserRepository UR;

    @Autowired
    private UtilisationService UTS;

    @Autowired
    private PortMonnaisService PS;

    @Autowired
    private utilisationRepository utiR;
    @Autowired
    private PortMonnaisRepository PR;

//return null si code ne exist pas
    public Optional<GiftCode> get(long id) {
        return GCR.findById(id);
    }

    public List<GiftCode> getAllCodes() {
        return GCR.findAllByOrderByIdCodeAsc();
    }

    public GiftCode saveCode(GiftCode code) {
        return GCR.save(code);
    }

    public boolean codeExist(GiftCode code) {
        Optional<GiftCode> test = GCR.findById(code.getIdCode());
        if (test == null)
            return false;
        else
            return true;
    }




    public boolean codeStillUsable(GiftCode Code) {
        boolean timeTest = false;
        boolean nbUseTest = false;

        Date dateFinCode = Code.getDateFin();
        Date currentDate = new Date();
        if (currentDate.compareTo(dateFinCode) < 0)
            timeTest = true;

        if (Code.getNbrUtilisation() > 0)
            nbUseTest = true;

        if (timeTest && nbUseTest)
            return true;
        else return false;
    }



    public String errorCounterFunction(int e) {
        String s1 = "utilisateur inexistant";
        String s2 = "tu n a pas un port monnais";
        String s3 = "code inexistant";
        String s4 = "code expirer";
        String resp = "";
        String v = " | | | | ";
        switch (e) {
            case 1:
                resp = s1;
                break;
            case 10:
                resp = s2;
                break;
            case 11:
                resp = s1 + v + s2;
                break;
            case 100:
                resp = s3;
                break;
            case 101:
                resp = s1 + v + s3;
                break;
            case 110:
                resp = s2 + v + s3;
                break;
            case 111:
                resp = s1 + v + s2 + v + s3;
                break;
            case 1000:
                resp = s4;
                break;
            case 1001:
                resp = s1 + v + s4;
                break;
            case 1011:
                resp = s1 + v + s2 + s4;
                break;
            case 1100:
                resp = s3 + v + s4;
                break;
            case 1101:
                resp = s1 + v + s3 + v + s4;
                break;
            case 1110:
                resp = s2 + v + s3 + v + s4;
                break;
            case 1111:
                resp = s1 + v + s2 + v + s3 + v + s4;
                break;

            default:
                resp = "erreur inconnue";
                break;
        }
        return JSONParser.quote(resp);
    }


    public String utiliserCode(String CodeText, long idUser) {

        int errorCounter = 0;
        User Uu = UR.getUserById(idUser);
        if (Uu == null) errorCounter = errorCounter + 1;

        PortMonnais Pp = PR.findPortMonnaisByIdUser(idUser);
        if (Pp == null) errorCounter = errorCounter + 10;

        GiftCode Gg = GCR.findGiftCodeByCodeText(CodeText);
        if (Gg == null) errorCounter = errorCounter + 100;

        if (valable(CodeText) == false) errorCounter = errorCounter + 1000;

        if(codeUsed(CodeText,idUser)==true) return JSONParser.quote("vous avez utiliser ce code");

        if(errorCounter!=0 ){ return errorCounterFunction(errorCounter);}


        PortMonnais P = PR.findPortMonnaisByIdUser(idUser);
        User U = UR.getUserById(idUser);
        GiftCode G = GCR.findGiftCodeByCodeText(CodeText);




        if( Pp.getEtat().charAt(0)=='A' || Pp.getEtat().charAt(0)=='a' ) {
         int CodeValueBefore = G.getCodeValue();

         int nbUseBefore = G.getNbrUtilisation();
         int nbUseAfter = nbUseBefore - 1;

         int maxUtilisation = G.getNbrUtilisationMax();
         int reduction = G.getReductionParUtilisation();

       //creation d utilisation
        Utilisation nouveauUtilisation = new Utilisation();

        nouveauUtilisation.setIdUser(U.getId());

        nouveauUtilisation.setCodeText(G.getCodeText());

        nouveauUtilisation.setSoldeAvant(P.getSolde());

        nouveauUtilisation.setDateUtilisation(new Date());


//MAJ solde port monnais
         P.setSolde(P.getSolde()+CodeValueBefore);
         PR.save(P);

         nouveauUtilisation.setSoldeApres(P.getSolde());
nouveauUtilisation.setIdCode(G.getIdCode());
         nouveauUtilisation.setValeurAjouter(CodeValueBefore);
        utiR.save(nouveauUtilisation);//save utilisation
// MAJ Gifgtcode params
         G.setNbrUtilisation(G.getNbrUtilisation()-1);
         G.setCodeValue(G.getCodeValue()-G.getReductionParUtilisation());
         GCR.save(G);


        return JSONParser.quote("code utiliser avec sucess");
    }
else return JSONParser.quote("votre portMonnais est est Bloquer, SVP de contacter l'Admin ");



    }





    public String OnCodeUse(String text,long idUser){
        if(codeUsed(text,idUser))
            return JSONParser.quote("vous avez utiliser ce code");


     else return JSONParser.quote("code Utiliser");




    }


    //tester
    public String RandomCode() {
        int i = 0;

        String alphaMin = "azertyuiopqsdfghjklmwxcvbn";
        String alphaMaj = "AQWXSZEDCVFRTGBNHYUJIKOLPM";
        String nums = "1234567890";
        Date date = new Date();

        String sdate = date.toString();
        String str1 = sdate.substring(0, 3);
        String str2 = sdate.substring(4, 7);
        String str3 = sdate.substring(8, 10);
        String str4 = sdate.substring(11, 13);
        String str5 = sdate.substring(14, 16);
        String str6 = sdate.substring(17, 19);
        String str7 = sdate.substring(20, 23);
        String str8 = sdate.substring(24, 28);
        String str = str1 + str2 + str3 + str4 + str5 + str6 + str7 + str8;
        String strF = alphaMaj + nums + alphaMin + nums + str;

        Random rand = new Random();


        int cont = 0;
        char ox;
        String res = "";
        while (cont != 40) {

            int a = (int) (Math.random() * 10);

            switch (a) {
                case 0:
                    ox = strF.charAt(rand.nextInt(strF.length()));
                case 1:
                    ox = alphaMaj.charAt(rand.nextInt(alphaMaj.length()));
                case 2:
                    ox = alphaMin.charAt(rand.nextInt(alphaMin.length()));
                case 3:
                    ox = nums.charAt(rand.nextInt(nums.length()));
                case 4:
                    ox = str.charAt(rand.nextInt(str.length()));
                case 5:
                    ox = alphaMaj.charAt(rand.nextInt(alphaMaj.length()));
                case 6:
                    ox = alphaMin.charAt(rand.nextInt(alphaMin.length()));
                case 7:
                    ox = nums.charAt(rand.nextInt(nums.length()));
                case 8:
                    ox = str.charAt(rand.nextInt(str.length()));
                case 9:
                    ox = strF.charAt(rand.nextInt(strF.length()));
                case 10:
                    ox = strF.charAt(rand.nextInt(strF.length()));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + "");
            }

            res = res + ox;
            cont++;
        }

        return JSONParser.quote(res);
    }

    //tester
    public boolean codebytext(String text) {
        GiftCode resp = GCR.findGiftCodeByCodeText(text);
        if (resp == null)
            return false;
        else
            return true;
    }

    //tester
    public Boolean valable(String text) {

        boolean resp = codebytext(text);
        //code existant
        if (resp == true) {

            GiftCode G = new GiftCode();
            G = GCR.findGiftCodeByCodeText(text);
            Date d = new Date();
            d = G.getDateFin();
            int a = G.getNbrUtilisation();
            Date datetest = new Date();
            if (datetest.before(d) && a >= 1) return true;
            else return false;
        }//code inexistant
        else return false;

    }

//tester
    public Boolean codeUsed(String text, long idUser) {
        GiftCode G = GCR.findGiftCodeByCodeText(text);
        Optional<User> U=UR.findById(idUser);
        if (G != null && U != null) {

            List<Utilisation> listUtilisation = utiR.findAllByCodeTextAndIdUser(text,idUser);
            if (listUtilisation.size() ==0) {
                return false;
            } else return true;
        }
return false;

    }

    public String creeCode(GiftCode code){
String ok="code cree avec sucess";
String non="erreur lorsque la creation de code <un autre code a le meme text> ";
        String text =code.getCodeText();
        GiftCode G= GCR.findGiftCodeByCodeText(text);

        if(G == null){
            GCR.save(code);
        return JSONParser.quote(ok);}
        else
            return JSONParser.quote(non);
    }



    public String DeleteCodeById(long idCode){
        GiftCode C = GCR.findGiftCodeByIdCode(idCode);

        if(C == null) return JSONParser.quote("il ya pas in code dont l ID = "+ idCode);
        else{
            GCR.deleteById(idCode);
            return JSONParser.quote("code don t l ID = "+idCode+" a ete supprimr avec sucess");
        }
    }



}