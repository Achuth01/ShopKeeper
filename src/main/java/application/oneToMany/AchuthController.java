package application.oneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/achuth")
public class AchuthController {

    @Autowired
    private AchuthService achuthService;

    @GetMapping("/get")
    public Achuth get(@RequestParam Integer id){
    return achuthService.get(id);
    }

    @GetMapping("/getAll")
    public List<Achuth> getAll(){
        return achuthService.getAll();
    }

    @PostMapping("/add")
    public Achuth add(@RequestBody Achuth achuth){
        return achuthService.add(achuth);
    }

    @PutMapping("/update")
    public Achuth update(@RequestBody Achuth achuth){
        return achuthService.update(achuth);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Integer id){
        achuthService.delete(id);
    }
}
