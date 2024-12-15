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
lines 57-101: Create toy-related parts:
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
## F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
#### •  The “Buy Now” button must be next to the buttons that update and delete products.
#### •  The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
#### •  Display a message that indicates the success or failure of a purchase.
**Added (purchaseSuccess.html):**
lines 1-46: This page is shown when a toy is successfully purchased
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Purchase Successful</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f8ff;
            text-align: center;
            margin: 0;
            padding: 0;
        }

        h1 {
            color: #4CAF50;
            font-size: 2em;
            margin-top: 50px;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2);
        }

        a {
            display: inline-block;
            margin-top: 30px;
            padding: 10px 20px;
            background-color: #007BFF;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-size: 1.1em;
        }

        a:hover {
            background-color: #0056b3;
        }

        a:active {
            background-color: #004085;
        }
    </style>
</head>
<body>
<h1>Your purchase was successful! Thank you for ordering from our Custom Toy Factory!</h1>
<a href="/mainscreen">Back to Main Screen</a>
</body>
</html>
```
**Added (purchaseFailure.html):**
This page is shown when the purchase fail
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Purchase Failed</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #ffdddd; /* Light red background to indicate error */
            text-align: center;
            margin: 0;
            padding: 0;
        }

        h1 {
            color: #d32f2f; /* Dark red color for the error message */
            font-size: 2em;
            margin-top: 50px;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2);
        }

        a {
            display: inline-block;
            margin-top: 30px;
            padding: 10px 20px;
            background-color: #f44336; /* Red background for the error button */
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-size: 1.1em;
        }

        a:hover {
            background-color: #c62828; /* Darker red when hovering */
        }

        a:active {
            background-color: #b71c1c; /* Even darker red when clicked */
        }
    </style>
</head>
<body>
    <h1>Sorry, your purchase could not be completed. The toy may be out of stock, or something went wrong.</h1>
    <a href="/mainscreen">Back to Main Screen</a>
</body>
</html>

```
**Changes (mainscreen.html):**
lines 87-90: Added a Buy Now button
```html
<form th:action="@{/buyToy}" method="GET">
    <input type="hidden" th:name="toyID" th:value="${tempProduct.id}" />
    <button type="submit" class="btn btn-primary btn-sm">Buy Now</button>
</form>
```
**Changes (AddProductController.java):**
lines 178-202: Added the Buy Now functionality, handling Toy Inventory Update, and integrating with existing product management
```
@Autowired
    private ProductRepository toyRepository;
    @GetMapping("/buyToy")
    public String buyToy(@RequestParam("toyID") Long theId, Model theModel) {
        Optional<Product> toyToBuy = toyRepository.findById(theId);

        if (toyToBuy.isPresent()) {
            Product toy = toyToBuy.get();

            if (toy.getInv() > 0) {
                // Decrease inventory by 1
                toy.setInv(toy.getInv() - 1);
                toyRepository.save(toy); // Save the updated toy to the database

                theModel.addAttribute("message", "Your purchase was successful!");
                return "redirect:/purchaseSuccess";
            } else {
                theModel.addAttribute("message", "Sorry, this toy is out of stock.");
                return "redirect:/purchaseFailure";
            }
        } else {
            theModel.addAttribute("message", "Sorry, this toy does not exist.");
            return "redirect:/purchaseFailure";
        }
    }
```
## G.  Modify the parts to track maximum and minimum inventory by doing the following: Add additional fields to the part entity for maximum and minimum inventory. Modify the sample inventory to include the maximum and minimum fields. Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values. Rename the file the persistent storage is saved to. Modify the code to enforce that the inventory is between or at the minimum and maximum value.
**Changes (Part.java):**
lines 33-36: New fields for minimum and maximum inventory 
```
    @Column(name = "MAX_INV")
    int maxInv;
    @Column(name = "MIN_INV")
    int minInv;
```
lines 57-58: Added default value for min(0) and max(1000) inventory
```
    this.minInv = 0;
    this.maxInv = 1000;
```
lines 60-67: Added a second constructor to set minInv and maxInv explicitly
```
public Part(long id, String name, double price, int inv, int minInv, int maxInv) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inv = inv;
        this.minInv = minInv;
        this.maxInv = maxInv;
    }
```
lines 101-115: Added getters and setters for the minInv and maxInv, allowing these fields to be accessed and modified
```
public int getMinInv() {
    return minInv;
}

public void setMinInv(int minInv) {
    this.minInv = minInv;
}

public int getMaxInv() {
    return maxInv;
}

public void setMaxInv(int maxInv) {
    this.maxInv = maxInv;
}
```
**Changes(mainscreen.html)**  
lines 76-77: Added Minimum Inventory and Maximum Inventory to table
```html
<th>Minimum Inventory</th>
<th>Maximum inventory</th>
```
lines 85-85: Added Table rows for Minimum Inventory and Maximum Inventory
```html
<td th:text="${tempPart.minInv}">1</td>
<td th:text="${tempPart.maxInv}">1</td>
```
**Changes(BootStrapDate.java)**  
lines 63-64: Set Minimum Inventory and Maximum Inventory for Lego Fire Truck Brick
```
legoFireTruckBrick.setMaxInv(1000);
legoFireTruckBrick.setMinInv(1);
```
lines 72-73: Set Minimum Inventory and Maximum Inventory for Lego Wheels
```
legoWheels.setMaxInv(1000);
legoWheels.setMinInv(1);
```
lines 81-82: Set Minimum Inventory and Maximum Inventory for Lego Space Station Brick
```
legoSpaceStationBrick.setMaxInv(1000);
legoSpaceStationBrick.setMinInv(1);
```
lines 90-91: Set Minimum Inventory and Maximum Inventory for Superhero Cape
```
superheroCape.setMaxInv(1000);
superheroCape.setMinInv(1);
```
lines 99-100: Set Minimum Inventory and Maximum Inventory for Action Figure Leg
```
actionFigureLeg.setMaxInv(1000);
actionFigureLeg.setMinInv(1);
```
**Changes(application.properties)**
line 6: Changed name of database to Custom Toy Store
```
spring.datasource.url=jdbc:h2:file:~/custom-toy-store
```
**Changes(InhousePartForm.html)**
lines 26-29: Added Minimum Inventory and Maximum Inventory fields
```html
<p><input type="text" path="inv" th:field="*{minInv}" placeholder="Inventory" class="form-control mb-4 col-4"/></p>
<p th:if="${#fields.hasErrors('minInv')}" th:errors="*{minInv}">Minimum Inventory Error</p>

<p><input type="text" path="inv" th:field="*{maxInv}" placeholder="Inventory" class="form-control mb-4 col-4"/></p>
<p th:if="${#fields.hasErrors('maxInv')}" th:errors="*{maxInv}">Maximum Inventory Error</p>

```

**Changes(OutsourcedPartForm.html)**
lines 27-30: Added Minimum Inventory and Maximum Inventory fields
```html
<p><input type="text" path="inv" th:field="*{minInv}" placeholder="Inventory" class="form-control mb-4 col-4"/></p>
<p th:if="${#fields.hasErrors('minInv')}" th:errors="*{minInv}">Minimum Inventory Error</p>

<p><input type="text" path="inv" th:field="*{maxInv}" placeholder="Inventory" class="form-control mb-4 col-4"/></p>
<p th:if="${#fields.hasErrors('maxInv')}" th:errors="*{maxInv}">Maximum Inventory Error</p>
```

## H. Add validation for between or at the maximum and minimum fields. The validation must include the following:
#### •  Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
#### •  Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
#### •  Display error messages when adding and updating parts if the inventory is greater than the maximum
**Created (ValidMinMax.java):**  
lines 1-18: Combined annotation for both min and max inventory validation
```
package com.example.demo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Constraint(validatedBy = MinMaxValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidMinMax {
    String message() default "Invalid inventory level.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

```
**Created (MinMaxValidator.java)**
lines 1-29: Implements the logic for validating the minimum and maximum inventory for parts.
```
package com.example.demo.validators;

import com.example.demo.domain.Part;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MinMaxValidator implements ConstraintValidator<ValidMinMax, Part> {

    @Override
    public void initialize(ValidMinMax constraintAnnotation) {}

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();

        boolean valid = true;

        if (part.getInv() < part.getMinInv()) {
            context.buildConstraintViolationWithTemplate("Inventory must be greater than min.").addConstraintViolation();
            valid = false;
        }
        if (part.getInv() > part.getMaxInv()) {
            context.buildConstraintViolationWithTemplate("Inventory must be less than max.").addConstraintViolation();
            valid = false;
        }

        return valid;
    }
}

```
**Changes(Part.java)**  
Apply @ValidMinMax annotation to the Part class:
line 4:
```
import com.example.demo.validators.ValidMinMax;
```
line 18:
```
@ValidMinMax
```
