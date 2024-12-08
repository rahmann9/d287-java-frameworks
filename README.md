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
```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>About Custom Toy Factory</title>
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
            }
            header {
                background-color: #007bff;
                color: white;
                padding: 20px;
                text-align: center;
                box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            }
            header h1 {
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
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f6f9;
            color: #495057;
            margin: 0;
            padding: 0;
        }
        header {
            background-color: #007bff;
            color: white;
            padding: 20px;
            text-align: center;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
        header h1 {
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
**Changes (MainScreenControllerr.java):**
Added line (55-56): 
```
@GetMapping("/about")
    public String about(){return "about";}
```

