package project.dajver.com.cartviewwithbadge.etc;

import java.util.ArrayList;
import java.util.List;

import project.dajver.com.cartviewwithbadge.product.adapter.models.ProductModel;

public class ProductsHelper {
    public static List<ProductModel> getProductsList() {
        List<ProductModel> productModels = new ArrayList<>();

        ProductModel model = new ProductModel();
        model.setId(5678l);
        model.setTitle("Honor 6A 2");
        model.setDescription("16Gb Grey");
        model.setImage("https://www.citrus.ua/upload/new_iblock/100/c9f1994b1520c4f05ac9c1f7bd5690e0.jpg");
        model.setPrice(599);
        productModels.add(model);

        model = new ProductModel();
        model.setId(5672l);
        model.setTitle("Meizu M5s");
        model.setDescription("32Gb Silver");
        model.setImage("https://cdn1.citrus.ua/upload/new_iblock/5e1/a832e835d186c8156f0090a1319e2a68.jpg");
        model.setPrice(899);
        productModels.add(model);

        model = new ProductModel();
        model.setId(5673l);
        model.setTitle("Apple iPhone SE");
        model.setDescription("32Gb Space Gray");
        model.setImage("https://www.citrus.ua/upload/new_iblock/ee3/266368eb03ab58074c8c0d6947f560a7.jpg");
        model.setPrice(1199);
        productModels.add(model);

        model = new ProductModel();
        model.setId(5674l);
        model.setTitle("Chuwi Hi10 Pro");
        model.setImage("https://cdn1.citrus.ua/upload/new_iblock/fe8/c13bbeaa7cc8ac126cf96dd12d07d36c.jpg");
        model.setPrice(2199);
        productModels.add(model);

        model = new ProductModel();
        model.setId(5675l);
        model.setTitle("Fermi S7-plus");
        model.setDescription("10000mAh gray)");
        model.setImage("https://www.citrus.ua/upload/new_iblock/f90/9713854e2db57da9e40343b0ca65a40a.jpg");
        model.setPrice(259);
        productModels.add(model);

        return productModels;
    }
}
