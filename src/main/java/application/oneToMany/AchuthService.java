package application.oneToMany;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
public class AchuthService {

    @Autowired
    private AchuthRepo achuthRepo;

    @Autowired
    private FriendsRepo friendsRepo;

    public Achuth add(Achuth achuth){
        for (Friends friends:achuth.getFriends()){
            friends.setAchuth(achuth);
        }
        return achuthRepo.saveorUpdate(achuth);
    }

    public Achuth update(Achuth achuth){
        return achuthRepo.saveorUpdate(achuth);
    }

    public void delete(Integer id){
        achuthRepo.remove(id);
    }

    public Achuth get(Integer id){
        return achuthRepo.get(id);
    }

    public List<Achuth> getAll(){
        return achuthRepo.getAll();
    }



}
