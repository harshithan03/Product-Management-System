package pms;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;


public class Client {

    public static Scanner sc= new Scanner(System.in);

    public static ProductDAO dao = new ProductDAO();

    public static Product product = new Product();

    public static void main(String[] args) {

        boolean flag = true;
        while (flag) {

            System.out.println("WELCOME TO PMS");
            System.out.println("1. INSERT Product");
            System.out.println("2. UPDATE Product");
            System.out.println("3. SELECT Product");
            System.out.println("4. DELETE Product");
            System.out.println("5. SELECT ALL");
            System.out.println("0. EXIT");

            int op = sc.nextInt();

            switch (op) {
                case 1:
                    dao.insertProduct(insert());

                    break;
                case 2:

                    dao.updateProduct(update());

                    break;
                case 3:

                    System.out.println(dao.getProduct(selectProduct()).toString());
                    break;
                case 4:

                    dao.deleteProduct(delete());
                case 5:
                    List<Product> AllProducts = dao.selectAll();
                    if(AllProducts == null){
                        try{
                            throw new ProductNotFoundException();
                        }catch (ProductNotFoundException e){
                            System.out.println("There are Zero(0) Number Of Products..");
                        }
                    }
                    for(Product item : AllProducts){
                        System.out.println(item.toString());
                    }
                    break;

                case 0:

                    flag = false;
                    System.out.println("EXIT");

                    break;

                default:
                    System.err.println("Enter option");
                    break;
            }
        }
    }


    public static Product insert(){
        System.out.print("Enter Product Id : ");
        product.setPID(sc.nextInt());
        System.out.print("Enter Product Name : ");
        product.setPname(sc.next());
        System.out.print("Enter Product Price : ");
        product.setPrice(sc.nextDouble());
        System.out.print("Enter Date Of Manufacture : ");
        product.setDOM(Date.valueOf(sc.next()));

        return product;
    }
    public static Product update(){
        System.out.print("Enter Product Id to Update : ");
        product.setPID(sc.nextInt());
        System.out.print("Enter new Product Name : ");
        product.setPname(sc.next());
        System.out.print("Enter new Product Price : ");
        product.setPrice(sc.nextDouble());
        System.out.print("Enter latest Date Of Manufacture : ");
        product.setDOM(Date.valueOf(sc.next()));

        return product;
    }
    public static int delete(){
        System.out.print("Enter Product Id to Delete : ");
        int id = sc.nextInt();
        return id;
    }
    public static int selectProduct(){
        System.out.print("Enter Product Id to Display : ");
        int id = sc.nextInt();
        return id;
    }

}


