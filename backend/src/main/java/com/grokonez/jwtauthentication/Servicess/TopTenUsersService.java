package com.grokonez.jwtauthentication.Servicess;


import com.grokonez.jwtauthentication.model.TopTenUses;
import com.grokonez.jwtauthentication.repository.TopTenUserRepository;
import org.apache.catalina.core.AprLifecycleListener;
import org.apache.logging.log4j.util.PropertySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.comparator.Comparators;

import java.text.Format;
import java.util.*;

@Service
public class TopTenUsersService {

    @Autowired
    private TopTenUserRepository TTUR;


    public List<TopTenUses> getTopTen() {

       /* List<TopTenUses> TTL = this.TTUR.findAll();
        List<TopTenUses> res = this.TTUR.findAll();
        int sizeInt= TTL.size();
        int lim1 = TTL.size();
        int lim2 = lim1 * 2;
        int i = 0;
        if (TTL.size() <= 10) {
            while (TTL.size() != 0) {
                TopTenUses T = TTL.get(i);
                for (int k = 0; k < TTL.size(); k++) {
                    if (T.getSomme() < TTL.get(k).getSomme()) {
                        T = TTL.get(k);
                    }

                }
                res.add(T);
                TTL.remove(T);

            }

            return res.subList(lim1, lim2);
        } else {
            int cc=0;
while (TTL.size()!=sizeInt-10 && cc!=10){

    TopTenUses t = TTL.get(0);
            for (int k = 0; k < TTL.size(); k++) {
                if (t.getSomme() < TTL.get(k).getSomme()) {
                    t = TTL.get(k);
                }

            }
            res.add(t);
            TTL.remove(t);
cc++;
        }


            return res.subList(lim1,lim1+10);
        }*/


List<TopTenUses> All = new ArrayList<TopTenUses>();
All=this.TTUR.findAll();

Collections.sort(All, (t1, t2) -> {

    if(t1.getSomme()>t2.getSomme())
        return -1;
    if(t1.getSomme()<t2.getSomme())
        return 1;

    return 0;
});

int size = All.size();
if(size<=10) return All;
else


return All.subList(0,10);
    }


}
