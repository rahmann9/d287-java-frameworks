package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;
    private final InhousePartRepository inhousePartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository, InhousePartRepository inhousePartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
        this.inhousePartRepository = inhousePartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(productRepository.count() == 0) {

            Set<Product> sampleProducts = new HashSet<Product>();
            Product legoFireTruck = new Product(1, "Lego Fire Truck Set", 29.99, 10);
            Product actionFigureSet = new Product(2, "Action Figure Set", 19.99, 15);
            Product legoSpaceStation = new Product(3, "Lego Space Station", 49.99, 5);
            Product superheroActionFigures = new Product(4, "Superhero Action Figures", 24.99, 20);
            Product legoCarSet = new Product(5, "Lego Car Set", 15.99, 30);
            sampleProducts.add(legoFireTruck);
            sampleProducts.add(actionFigureSet);
            sampleProducts.add(legoSpaceStation);
            sampleProducts.add(superheroActionFigures);
            sampleProducts.add(legoCarSet);
            productRepository.saveAll(sampleProducts);
        }
        if(partRepository.count() == 0) {
            Set<Part> sampleParts = new HashSet<>();
            InhousePart legoFireTruckBrick = new InhousePart();
            legoFireTruckBrick.setId(1);
            legoFireTruckBrick.setName("Lego Fire Engine Brick");
            legoFireTruckBrick.setPrice(2.99);
            legoFireTruckBrick.setInv(100);
            legoFireTruckBrick.setMaxInv(195);
            legoFireTruckBrick.setMinInv(1);
            inhousePartRepository.save(legoFireTruckBrick);

            InhousePart legoWheels = new InhousePart();
            legoWheels.setId(2);
            legoWheels.setName("Lego Wheels");
            legoWheels.setPrice(1.99);
            legoWheels.setInv(50);
            legoWheels.setMaxInv(195);
            legoWheels.setMinInv(1);
            inhousePartRepository.save(legoWheels);

            InhousePart legoSpaceStationBrick = new InhousePart();
            legoSpaceStationBrick.setId(3);
            legoSpaceStationBrick.setName("Lego Space Station Brick");
            legoSpaceStationBrick.setPrice(3.99);
            legoSpaceStationBrick.setInv(80);
            legoSpaceStationBrick.setMaxInv(195);
            legoSpaceStationBrick.setMinInv(1);
            inhousePartRepository.save(legoSpaceStationBrick);

            InhousePart superheroCape = new InhousePart();
            superheroCape.setId(4);
            superheroCape.setName("Superhero Cape");
            superheroCape.setPrice(1.49);
            superheroCape.setInv(20);
            superheroCape.setMaxInv(185);
            superheroCape.setMinInv(1);
            inhousePartRepository.save(superheroCape);

            InhousePart actionFigureLeg = new InhousePart();
            actionFigureLeg.setId(5);
            actionFigureLeg.setName("Action Figure Leg");
            actionFigureLeg.setPrice(0.99);
            actionFigureLeg.setInv(150);
            actionFigureLeg.setMaxInv(195);
            actionFigureLeg.setMinInv(1);
            inhousePartRepository.save(actionFigureLeg);
        }
        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
