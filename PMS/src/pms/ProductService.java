package pms;

import java.util.List;

public abstract class ProductService implements IProdService {

    private ProductDAO dao = new ProductDAO();

    @Override
    public int insertProduct(Product product) {
        return dao.insertProduct(product);
    }

    @Override
    public int updateProduct(Product product) {
        return dao.updateProduct(product);
    }

    @Override
    public int deleteProduct(int Prodelete) {
        return dao.deleteProduct(Prodelete);
    }

    @Override
    public Product getProduct(int proID) {
        return dao.getProduct(proID);
    }

    @Override
    public List<Product> selectAll() {
        return dao.selectAll();
    }
}