package pms;

import java.util.List;

public interface IProdService {

    public int insertProduct(Product product);
    public int updateProduct(Product product);
    public int deleteProduct(int Prodelete);
    public Product getProductByNo(int proID);
    public List<Product> selectAll();
    Product getProduct(int proID);
}