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
        model.setImage("https://github.com/dajver/CartWithBadgeExample/blob/master/images/honor.jpg?raw=true");
        model.setPrice(599);
        productModels.add(model);

        model = new ProductModel();
        model.setId(5672l);
        model.setTitle("Meizu M5s");
        model.setDescription("32Gb Silver");
        model.setImage("https://github.com/dajver/CartWithBadgeExample/blob/master/images/meizu.jpg?raw=true");
        model.setPrice(899);
        productModels.add(model);

        model = new ProductModel();
        model.setId(5673l);
        model.setTitle("Apple iPhone SE");
        model.setDescription("32Gb Space Gray");
        model.setImage("https://github.com/dajver/CartWithBadgeExample/blob/master/images/iphone.jpg?raw=true");
        model.setPrice(1199);
        productModels.add(model);

        model = new ProductModel();
        model.setId(5674l);
        model.setTitle("Chuwi Hi10 Pro");
        model.setImage("https://github.com/dajver/CartWithBadgeExample/blob/master/images/chuwi.jpg?raw=true");
        model.setPrice(2199);
        productModels.add(model);

        model = new ProductModel();
        model.setId(5675l);
        model.setTitle("Fermi S7-plus");
        model.setDescription("10000mAh gray)");
        model.setImage("https://github.com/dajver/CartWithBadgeExample/blob/master/images/batary.jpg?raw=true");
        model.setPrice(259);
        productModels.add(model);

        return productModels;
    }
}
