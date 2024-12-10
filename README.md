# D287 – JAVA FRAMEWORKS

## C. Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.

**Changes (mainscreen.html):**  
line 14: Store name changed to "Custom Toy Store".  
line 19: Changed primary header to store name "Custom Toy Store".  
line 21: Changed header for "Parts" to "Legos".  
line 53: Changed header for "Products" to "Action Figures".  

## D. Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.

**line 20: Added a navigation to About page:**   
```html
<a href="/about" class="btn btn-info">About Us</a>
```
**Created about.html page:**  
Defines the About Us page template shown when the user clicks the "Home" button. It includes sections that introduce the company, explain its customizable toy offerings, and provide contact details.  
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>About Custom Toy Factory</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f6f9;
            color: #495057;
            margin: 0;
            padding: 0;
        }  header {
            background-color: #007bff;
            color: white;
            padding: 20px;
            text-align: center;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }  header h1 {
            font-size: 2.5rem;
            margin-bottom: 10px;
        }
        header a.btn {
            display: inline-block;
            background-color: #28a745;
            color: white;
            padding: 10px 20px;
            font-size: 1rem;
            text-decoration: none;
            border-radius: 5px;
            margin-top: 10px;
            transition: background-color 0.3s ease;
        }
        header a.btn:hover {
            background-color: #218838;
        }
        .container {
            max-width: 960px;
            margin: 30px auto;
            padding: 20px;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .container h2 {
            font-size: 1.8rem;
            color: #007bff;
            margin-bottom: 10px;
        }
        .container p {
            font-size: 1.1rem;
            line-height: 1.6;
            margin-bottom: 20px;
        }
        footer {
            background-color: #343a40;
            color: white;
            padding: 15px;
            text-align: center;
            font-size: 1rem;
        }
        .header-image {
            display: block;
            margin: 20px auto;
            width: 100%;
            max-height: 300px;
            object-fit: cover;
            border-radius: 8px;
        }
        @media (max-width: 768px) {
            header h1 {
                font-size: 2rem;
            }
            .container {
                margin: 10px;
                padding: 15px;
            }
            .container h2 {
                font-size: 1.6rem;
            }
            .container p {
                font-size: 1rem;
            }
        }
    </style>
</head>
<body>
<header>
    <h1>About Custom Toy Factory</h1>
    <a href="/mainscreen" class="btn">Home</a>
</header>
<div class="container">
    <h2>Our Story</h2>
    <p>We founded Custom Toy Factory in 2024 to bring imagination to life. With the ability to create your own toys, we make playtime even more fun!</p>
    <h2>Our Products</h2>
    <p>We offer a variety of toys, from action figures to legos, all of which are customizable with different parts. Our goal is to make each toy uniquely yours.</p>
</div>
</body>
</html>
```
**Created  AboutController.java:**  
Added lines (1-11): 
```
package com.example.demo.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/about")
public class AboutController {
    @GetMapping
    public String about() {return "about";}
}
```

## E. Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.  
**Changes (BootStrapData.java):**  
line 3: import com.example.demo.domain.InhousePart;  
lines 17-20: 
```
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
```

lines 45-55: Create toy-related products:
```
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
```
line 57-101: Create toy-related parts:
```    
    Set<Part> sampleParts = new HashSet<>();
    InhousePart legoFireTruckBrick = new InhousePart();
    legoFireTruckBrick.setId(1);
    legoFireTruckBrick.setName("Lego Fire Engine Brick");
    legoFireTruckBrick.setPrice(2.99);
    legoFireTruckBrick.setInv(100);
    legoFireTruckBrick.setMax_inv(100);
    legoFireTruckBrick.setMin_inv(1);
    sampleParts.add(legoFireTruckBrick);

    InhousePart legoWheels = new InhousePart();
    legoWheels.setId(2);
    legoWheels.setName("Lego Wheels");
    legoWheels.setPrice(1.99);
    legoWheels.setInv(50);
    legoWheels.setMax_inv(100);
    legoWheels.setMin_inv(1);
    sampleParts.add(legoWheels);

    InhousePart legoSpaceStationBrick = new InhousePart();
    legoSpaceStationBrick.setId(3);
    legoSpaceStationBrick.setName("Lego Space Station Brick");
    legoSpaceStationBrick.setPrice(3.99);
    legoSpaceStationBrick.setInv(80);
    legoSpaceStationBrick.setMax_inv(100);
    legoSpaceStationBrick.setMin_inv(1);
    sampleParts.add(legoSpaceStationBrick);

    InhousePart superheroCape = new InhousePart();
    superheroCape.setId(4);
    superheroCape.setName("Superhero Cape");
    superheroCape.setPrice(1.49);
    superheroCape.setInv(200);
    superheroCape.setMax_inv(100);
    superheroCape.setMin_inv(1);
    sampleParts.add(superheroCape);

    InhousePart actionFigureLeg = new InhousePart();
    actionFigureLeg.setId(5);
    actionFigureLeg.setName("Action Figure Leg");
    actionFigureLeg.setPrice(0.99);
    actionFigureLeg.setInv(150);
    actionFigureLeg.setMax_inv(100);
    actionFigureLeg.setMin_inv(1);
    sampleParts.add(actionFigureLeg);
```

