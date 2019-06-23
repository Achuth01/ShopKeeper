package application.oneToMany;

import fr.opensagres.xdocreport.core.XDocReportException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/friends")
public class FriendsController {

    @Autowired
    private FriendsService friendsService;

    @GetMapping("/get")
    public Friends get(@RequestParam Integer id){
        return friendsService.get(id);
    }

    @GetMapping("/download")
    public XWPFDocument get() throws IOException, XDocReportException {
        return friendsService.downloadDoc();
    }

    @GetMapping("/getAll")
    public List<Friends> getAll(){
        return friendsService.getAll();
    }

    @PostMapping("/add")
    public Friends add(@RequestBody Friends friends){
        return friendsService.add(friends);
    }

    @PutMapping("/update")
    public Friends update(@RequestBody Friends friends){
        return friendsService.update(friends);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Integer id){
        friendsService.delete(id);
    }
}
