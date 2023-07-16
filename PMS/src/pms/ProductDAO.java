package pms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProductDAO {

    Connection con = DBUtil.getDBconnection();
    public static final String insertQuery = "insert into Product values (?,?,?,?)";
    public static final String updateQuery = "update Product set Pname = ?" + " Price = ?,DOM = ?, where Pid = ?";
    public static final String selectQuery = "select * from Product where pid = ?";
    public static final String deleteQuery = "delete * from Product where pid = ?";
    public static final String selectAllQuery = "select * from Product";

    // INSERT QUERY

    public int insertProduct(Product product) {

        String insertQuery = "insert into product values(?,?,?,?)";
        int count = 0;
        try {

            PreparedStatement prepareStatement = con.prepareStatement(insertQuery);

            prepareStatement.setInt(1, product.getPid());
            prepareStatement.setString(2, product.getPname());
            prepareStatement.setDouble(3, product.getPrice());
            prepareStatement.setDate(4, product.getDOM());

            count = prepareStatement.executeUpdate();
        }
        catch(SQLException e){

            e.printStackTrace();

        }
        return count;

    }

    // UPDATE QUERY

    public int updateProduct(Product product) {

        String updateQuery = "update product set Pname = ?, price = ?, DOM =? where Pid = ?";
        int count = 0;

        try {
            PreparedStatement prepareStatement = con.prepareStatement(updateQuery);

            prepareStatement.setString(1, product.getPname());
            prepareStatement.setDouble(2, product.getPrice());
            prepareStatement.setDate(3, product.getDOM());
            prepareStatement.setInt(4,product.getPid());

            count = prepareStatement.executeUpdate();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    // SELECT QUERY
    public Product getProduct(int proID) {

        Product product = new Product();

        String selectQuery = "select * from product where Pid = ?";

        Product pro = null;

        try {
            PreparedStatement prepareStatement = con.prepareStatement(selectQuery);
            prepareStatement.setInt(1,proID);

            ResultSet rs = prepareStatement.executeQuery();
            while(rs.next()) {

                product.setPID(rs.getInt("Pid"));
                product.setPname(rs.getString("pname"));
                product.setPrice(rs.getDouble("Price"));
                product.setDOM(rs.getDate("DOM"));
            }

        }
        catch(SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    // DELETE QUERY

    public int deleteProduct(int Prodelete) {

        String deleteQuery = "delete from product where Pid = ?";

        int count = 0;

        try {
            PreparedStatement preparestatement = con.prepareStatement(deleteQuery);

            preparestatement.setInt(1, Prodelete);

            count = preparestatement.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return count;

    }

    // SELECT ALL

    public List<Product> selectAll() {

        String selectAllQuery = "select * from product";

        List<Product> list = new ArrayList<Product>();

        try {
            PreparedStatement preparestatement = con.prepareStatement(selectAllQuery);

            ResultSet rs = preparestatement.executeQuery();

            while (rs.next()) {

                Product product = new Product();
                product.setPID(rs.getInt(1));
                product.setPname(rs.getString(2));
                product.setPrice(rs.getDouble(3));
                product.setDOM(rs.getDate(4));

                list.add(product);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return list;
    }

}