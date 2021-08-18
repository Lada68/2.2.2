package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDao;

@Controller
@RequestMapping("/cars")
public class CarsController {

private  final CarDao carDao;
    @Autowired
    public CarsController(CarDao carDao) {
        this.carDao = carDao;
    }

//    @GetMapping("/car")
//    public String testMethod(){
//
//        return "car";
//    }
//    @GetMapping()
//    public String getListCars(Model model){
//
//
//        return "cars/cars";
//    }
    @GetMapping()
    public String show(Model model, @RequestParam("count") int count ){
        model.addAttribute("cars",carDao.getListCars());
        model.addAttribute("list", carDao.show(count));

  return "cars/cars";  }

}
